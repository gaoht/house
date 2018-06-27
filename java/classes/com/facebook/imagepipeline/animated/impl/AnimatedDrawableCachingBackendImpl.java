package com.facebook.imagepipeline.animated.impl;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.support.v4.util.SparseArrayCompat;
import b.h;
import b.j;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.time.MonotonicClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.base.DelegatingAnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

public class AnimatedDrawableCachingBackendImpl
  extends DelegatingAnimatedDrawableBackend
  implements AnimatedDrawableCachingBackend
{
  private static final int PREFETCH_FRAMES = 3;
  private static final Class<?> TAG = AnimatedDrawableCachingBackendImpl.class;
  private static final AtomicInteger sTotalBitmaps = new AtomicInteger();
  private final ActivityManager mActivityManager;
  private final AnimatedDrawableBackend mAnimatedDrawableBackend;
  private final AnimatedDrawableOptions mAnimatedDrawableOptions;
  private final AnimatedDrawableUtil mAnimatedDrawableUtil;
  private final AnimatedImageCompositor mAnimatedImageCompositor;
  private final double mApproxKiloBytesToHoldAllFrames;
  @GuardedBy("this")
  private final WhatToKeepCachedArray mBitmapsToKeepCached;
  @GuardedBy("this")
  private final SparseArrayCompat<CloseableReference<Bitmap>> mCachedBitmaps;
  @GuardedBy("ui-thread")
  private int mCurrentFrameIndex;
  @GuardedBy("this")
  private final SparseArrayCompat<j<Object>> mDecodesInFlight;
  private final SerialExecutorService mExecutorService;
  @GuardedBy("this")
  private final List<Bitmap> mFreeBitmaps;
  private final double mMaximumKiloBytes;
  private final MonotonicClock mMonotonicClock;
  private final ResourceReleaser<Bitmap> mResourceReleaserForBitmaps;
  
  public AnimatedDrawableCachingBackendImpl(SerialExecutorService paramSerialExecutorService, ActivityManager paramActivityManager, AnimatedDrawableUtil paramAnimatedDrawableUtil, MonotonicClock paramMonotonicClock, AnimatedDrawableBackend paramAnimatedDrawableBackend, AnimatedDrawableOptions paramAnimatedDrawableOptions)
  {
    super(paramAnimatedDrawableBackend);
    this.mExecutorService = paramSerialExecutorService;
    this.mActivityManager = paramActivityManager;
    this.mAnimatedDrawableUtil = paramAnimatedDrawableUtil;
    this.mMonotonicClock = paramMonotonicClock;
    this.mAnimatedDrawableBackend = paramAnimatedDrawableBackend;
    this.mAnimatedDrawableOptions = paramAnimatedDrawableOptions;
    if (paramAnimatedDrawableOptions.maximumBytes >= 0) {}
    for (double d = paramAnimatedDrawableOptions.maximumBytes / 1024;; d = getDefaultMaxBytes(paramActivityManager) / 1024)
    {
      this.mMaximumKiloBytes = d;
      this.mAnimatedImageCompositor = new AnimatedImageCompositor(paramAnimatedDrawableBackend, new AnimatedImageCompositor.Callback()
      {
        public CloseableReference<Bitmap> getCachedBitmap(int paramAnonymousInt)
        {
          return AnimatedDrawableCachingBackendImpl.this.getCachedOrPredecodedFrame(paramAnonymousInt);
        }
        
        public void onIntermediateResult(int paramAnonymousInt, Bitmap paramAnonymousBitmap)
        {
          AnimatedDrawableCachingBackendImpl.this.maybeCacheBitmapDuringRender(paramAnonymousInt, paramAnonymousBitmap);
        }
      });
      this.mResourceReleaserForBitmaps = new ResourceReleaser()
      {
        public void release(Bitmap paramAnonymousBitmap)
        {
          AnimatedDrawableCachingBackendImpl.this.releaseBitmapInternal(paramAnonymousBitmap);
        }
      };
      this.mFreeBitmaps = new ArrayList();
      this.mDecodesInFlight = new SparseArrayCompat(10);
      this.mCachedBitmaps = new SparseArrayCompat(10);
      this.mBitmapsToKeepCached = new WhatToKeepCachedArray(this.mAnimatedDrawableBackend.getFrameCount());
      this.mApproxKiloBytesToHoldAllFrames = (this.mAnimatedDrawableBackend.getRenderedWidth() * this.mAnimatedDrawableBackend.getRenderedHeight() / 1024 * this.mAnimatedDrawableBackend.getFrameCount() * 4);
      return;
    }
  }
  
  private void cancelFuturesOutsideOfRange(int paramInt1, int paramInt2)
  {
    int i = 0;
    try
    {
      if (i < this.mDecodesInFlight.size())
      {
        if (AnimatedDrawableUtil.isOutsideRange(paramInt1, paramInt2, this.mDecodesInFlight.keyAt(i)))
        {
          j localj = (j)this.mDecodesInFlight.valueAt(i);
          this.mDecodesInFlight.removeAt(i);
        }
        for (;;)
        {
          break;
          i += 1;
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void copyAndCacheBitmapDuringRendering(int paramInt, Bitmap paramBitmap)
  {
    CloseableReference localCloseableReference = obtainBitmapInternal();
    try
    {
      Canvas localCanvas = new Canvas((Bitmap)localCloseableReference.get());
      localCanvas.drawColor(0, PorterDuff.Mode.SRC);
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      maybeCacheRenderedBitmap(paramInt, localCloseableReference);
      return;
    }
    finally
    {
      localCloseableReference.close();
    }
  }
  
  private Bitmap createNewBitmap()
  {
    FLog.v(TAG, "Creating new bitmap");
    sTotalBitmaps.incrementAndGet();
    FLog.v(TAG, "Total bitmaps: %d", Integer.valueOf(sTotalBitmaps.get()));
    return Bitmap.createBitmap(this.mAnimatedDrawableBackend.getRenderedWidth(), this.mAnimatedDrawableBackend.getRenderedHeight(), Bitmap.Config.ARGB_8888);
  }
  
  private void doPrefetch(int paramInt1, int paramInt2)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramInt2) {}
      try
      {
        final int j = (paramInt1 + i) % this.mAnimatedDrawableBackend.getFrameCount();
        boolean bool = hasCachedOrPredecodedFrame(j);
        final j localj = (j)this.mDecodesInFlight.get(j);
        if ((!bool) && (localj == null))
        {
          localj = j.call(new Callable()
          {
            public Object call()
            {
              AnimatedDrawableCachingBackendImpl.this.runPrefetch(j);
              return null;
            }
          }, this.mExecutorService);
          this.mDecodesInFlight.put(j, localj);
          localj.continueWith(new h()
          {
            public Object then(j<Object> paramAnonymousj)
              throws Exception
            {
              AnimatedDrawableCachingBackendImpl.this.onFutureFinished(localj, j);
              return null;
            }
          });
        }
        i += 1;
      }
      finally {}
    }
  }
  
  private void dropBitmapsThatShouldNotBeCached()
  {
    int i = 0;
    try
    {
      if (i < this.mCachedBitmaps.size())
      {
        int j = this.mCachedBitmaps.keyAt(i);
        if (!this.mBitmapsToKeepCached.get(j))
        {
          CloseableReference localCloseableReference = (CloseableReference)this.mCachedBitmaps.valueAt(i);
          this.mCachedBitmaps.removeAt(i);
          localCloseableReference.close();
        }
        for (;;)
        {
          break;
          i += 1;
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private CloseableReference<Bitmap> getBitmapForFrameInternal(int paramInt, boolean paramBoolean)
  {
    long l = this.mMonotonicClock.now();
    try
    {
      try
      {
        this.mBitmapsToKeepCached.set(paramInt, true);
        CloseableReference localCloseableReference = getCachedOrPredecodedFrame(paramInt);
        if (localCloseableReference != null)
        {
          l = this.mMonotonicClock.now() - l;
          if (l > 10L) {
            FLog.v(TAG, "obtainBitmap for frame %d took %d ms (%s)", Integer.valueOf(paramInt), Long.valueOf(l), "ok");
          }
          return localCloseableReference;
        }
        if (!paramBoolean) {
          break label260;
        }
        localObject2 = finally;
      }
      finally
      {
        for (;;)
        {
          try
          {
            localCloseableReference = obtainBitmapInternal();
          }
          finally
          {
            Object localObject4;
            int i = 1;
            continue;
          }
          try
          {
            this.mAnimatedImageCompositor.renderFrame(paramInt, (Bitmap)localCloseableReference.get());
            maybeCacheRenderedBitmap(paramInt, localCloseableReference);
            localObject4 = localCloseableReference.clone();
            localCloseableReference.close();
            l = this.mMonotonicClock.now() - l;
            if (l > 10L) {
              FLog.v(TAG, "obtainBitmap for frame %d took %d ms (%s)", Integer.valueOf(paramInt), Long.valueOf(l), "renderedOnCallingThread");
            }
            return (CloseableReference<Bitmap>)localObject4;
          }
          finally
          {
            ((CloseableReference)localObject2).close();
          }
        }
        localObject1 = finally;
      }
      l = this.mMonotonicClock.now() - l;
    }
    finally
    {
      i = 0;
    }
    if (l > 10L) {
      if (i == 0) {
        break label306;
      }
    }
    label260:
    label306:
    String str;
    for (localObject4 = "renderedOnCallingThread";; str = "ok")
    {
      FLog.v(TAG, "obtainBitmap for frame %d took %d ms (%s)", Integer.valueOf(paramInt), Long.valueOf(l), localObject4);
      throw ((Throwable)localObject2);
      l = this.mMonotonicClock.now() - l;
      if (l > 10L) {
        FLog.v(TAG, "obtainBitmap for frame %d took %d ms (%s)", Integer.valueOf(paramInt), Long.valueOf(l), "deferred");
      }
      return null;
    }
  }
  
  private CloseableReference<Bitmap> getCachedOrPredecodedFrame(int paramInt)
  {
    try
    {
      CloseableReference localCloseableReference2 = CloseableReference.cloneOrNull((CloseableReference)this.mCachedBitmaps.get(paramInt));
      CloseableReference localCloseableReference1 = localCloseableReference2;
      if (localCloseableReference2 == null) {
        localCloseableReference1 = this.mAnimatedDrawableBackend.getPreDecodedFrame(paramInt);
      }
      return localCloseableReference1;
    }
    finally {}
  }
  
  private static int getDefaultMaxBytes(ActivityManager paramActivityManager)
  {
    if (paramActivityManager.getMemoryClass() > 32) {
      return 5242880;
    }
    return 3145728;
  }
  
  /* Error */
  private boolean hasCachedOrPredecodedFrame(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 119	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mCachedBitmaps	Landroid/support/v4/util/SparseArrayCompat;
    //   6: iload_1
    //   7: invokevirtual 271	android/support/v4/util/SparseArrayCompat:get	(I)Ljava/lang/Object;
    //   10: ifnonnull +18 -> 28
    //   13: aload_0
    //   14: getfield 83	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mAnimatedDrawableBackend	Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableBackend;
    //   17: iload_1
    //   18: invokeinterface 346 2 0
    //   23: istore_2
    //   24: iload_2
    //   25: ifeq +9 -> 34
    //   28: iconst_1
    //   29: istore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: iload_2
    //   33: ireturn
    //   34: iconst_0
    //   35: istore_2
    //   36: goto -6 -> 30
    //   39: astore_3
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_3
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	AnimatedDrawableCachingBackendImpl
    //   0	44	1	paramInt	int
    //   23	13	2	bool	boolean
    //   39	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	39	finally
  }
  
  private void maybeCacheBitmapDuringRender(int paramInt, Bitmap paramBitmap)
  {
    int j = 0;
    int i = j;
    try
    {
      if (this.mBitmapsToKeepCached.get(paramInt))
      {
        i = j;
        if (this.mCachedBitmaps.get(paramInt) == null) {
          i = 1;
        }
      }
      if (i != 0) {
        copyAndCacheBitmapDuringRendering(paramInt, paramBitmap);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  private void maybeCacheRenderedBitmap(int paramInt, CloseableReference<Bitmap> paramCloseableReference)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 130	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mBitmapsToKeepCached	Lcom/facebook/imagepipeline/animated/impl/WhatToKeepCachedArray;
    //   6: iload_1
    //   7: invokevirtual 290	com/facebook/imagepipeline/animated/impl/WhatToKeepCachedArray:get	(I)Z
    //   10: istore 4
    //   12: iload 4
    //   14: ifne +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 119	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mCachedBitmaps	Landroid/support/v4/util/SparseArrayCompat;
    //   24: iload_1
    //   25: invokevirtual 351	android/support/v4/util/SparseArrayCompat:indexOfKey	(I)I
    //   28: istore_3
    //   29: iload_3
    //   30: iflt +25 -> 55
    //   33: aload_0
    //   34: getfield 119	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mCachedBitmaps	Landroid/support/v4/util/SparseArrayCompat;
    //   37: iload_3
    //   38: invokevirtual 184	android/support/v4/util/SparseArrayCompat:valueAt	(I)Ljava/lang/Object;
    //   41: checkcast 198	com/facebook/common/references/CloseableReference
    //   44: invokevirtual 228	com/facebook/common/references/CloseableReference:close	()V
    //   47: aload_0
    //   48: getfield 119	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mCachedBitmaps	Landroid/support/v4/util/SparseArrayCompat;
    //   51: iload_3
    //   52: invokevirtual 189	android/support/v4/util/SparseArrayCompat:removeAt	(I)V
    //   55: aload_0
    //   56: getfield 119	com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl:mCachedBitmaps	Landroid/support/v4/util/SparseArrayCompat;
    //   59: iload_1
    //   60: aload_2
    //   61: invokevirtual 322	com/facebook/common/references/CloseableReference:clone	()Lcom/facebook/common/references/CloseableReference;
    //   64: invokevirtual 281	android/support/v4/util/SparseArrayCompat:put	(ILjava/lang/Object;)V
    //   67: goto -50 -> 17
    //   70: astore_2
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	AnimatedDrawableCachingBackendImpl
    //   0	75	1	paramInt	int
    //   0	75	2	paramCloseableReference	CloseableReference<Bitmap>
    //   28	24	3	i	int
    //   10	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	12	70	finally
    //   20	29	70	finally
    //   33	55	70	finally
    //   55	67	70	finally
  }
  
  private CloseableReference<Bitmap> obtainBitmapInternal()
  {
    try
    {
      long l1 = System.nanoTime();
      long l2 = TimeUnit.NANOSECONDS.convert(20L, TimeUnit.MILLISECONDS) + l1;
      for (;;)
      {
        boolean bool = this.mFreeBitmaps.isEmpty();
        if ((bool) && (l1 < l2)) {
          try
          {
            TimeUnit.NANOSECONDS.timedWait(this, l2 - l1);
            l1 = System.nanoTime();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
            throw new RuntimeException(localInterruptedException);
          }
        }
      }
      if (!this.mFreeBitmaps.isEmpty()) {}
    }
    finally {}
    for (Bitmap localBitmap = createNewBitmap();; localBitmap = (Bitmap)this.mFreeBitmaps.remove(this.mFreeBitmaps.size() - 1)) {
      return CloseableReference.of(localBitmap, this.mResourceReleaserForBitmaps);
    }
  }
  
  private void onFutureFinished(j<?> paramj, int paramInt)
  {
    try
    {
      int i = this.mDecodesInFlight.indexOfKey(paramInt);
      if ((i >= 0) && ((j)this.mDecodesInFlight.valueAt(i) == paramj))
      {
        this.mDecodesInFlight.removeAt(i);
        if (paramj.getError() != null) {
          FLog.v(TAG, paramj.getError(), "Failed to render frame %d", new Object[] { Integer.valueOf(paramInt) });
        }
      }
      return;
    }
    finally {}
  }
  
  private void runPrefetch(int paramInt)
  {
    try
    {
      if (!this.mBitmapsToKeepCached.get(paramInt)) {
        return;
      }
      if (hasCachedOrPredecodedFrame(paramInt)) {
        return;
      }
    }
    finally {}
    CloseableReference localCloseableReference1 = this.mAnimatedDrawableBackend.getPreDecodedFrame(paramInt);
    if (localCloseableReference1 != null) {}
    try
    {
      maybeCacheRenderedBitmap(paramInt, localCloseableReference1);
      CloseableReference.closeSafely(localCloseableReference1);
      return;
      localCloseableReference2 = obtainBitmapInternal();
    }
    finally
    {
      try
      {
        for (;;)
        {
          CloseableReference localCloseableReference2;
          this.mAnimatedImageCompositor.renderFrame(paramInt, (Bitmap)localCloseableReference2.get());
          maybeCacheRenderedBitmap(paramInt, localCloseableReference2);
          FLog.v(TAG, "Prefetch rendered frame %d", Integer.valueOf(paramInt));
          localCloseableReference2.close();
        }
      }
      finally
      {
        ((CloseableReference)localObject2).close();
      }
      localObject2 = finally;
      CloseableReference.closeSafely(localCloseableReference1);
    }
  }
  
  private void schedulePrefetches()
  {
    int m = 1;
    for (;;)
    {
      try
      {
        if (this.mAnimatedDrawableBackend.getFrameInfo(this.mCurrentFrameIndex).disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS)
        {
          i = 1;
          int k = this.mCurrentFrameIndex;
          if (i != 0)
          {
            j = 1;
            k = Math.max(0, k - j);
            if (!this.mAnimatedDrawableOptions.allowPrefetching) {
              continue;
            }
            j = 3;
            break label211;
            j = Math.max(j, i);
            i = (k + j) % this.mAnimatedDrawableBackend.getFrameCount();
            cancelFuturesOutsideOfRange(k, i);
            if (!shouldKeepAllFramesInMemory())
            {
              this.mBitmapsToKeepCached.setAll(true);
              this.mBitmapsToKeepCached.removeOutsideRange(k, i);
              i = k;
              if (i >= 0)
              {
                if (this.mCachedBitmaps.get(i) == null) {
                  continue;
                }
                this.mBitmapsToKeepCached.set(i, true);
              }
              dropBitmapsThatShouldNotBeCached();
            }
            if (!this.mAnimatedDrawableOptions.allowPrefetching) {
              continue;
            }
            doPrefetch(k, j);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        int j = 0;
        continue;
        j = 0;
        break label211;
        i = 0;
        continue;
        i -= 1;
        continue;
        cancelFuturesOutsideOfRange(this.mCurrentFrameIndex, this.mCurrentFrameIndex);
        continue;
        if (i == 0) {
          continue;
        }
      }
      finally {}
      label211:
      int i = m;
    }
  }
  
  private boolean shouldKeepAllFramesInMemory()
  {
    if (this.mAnimatedDrawableOptions.forceKeepAllFramesInMemory) {}
    while (this.mApproxKiloBytesToHoldAllFrames < this.mMaximumKiloBytes) {
      return true;
    }
    return false;
  }
  
  public void appendDebugOptionString(StringBuilder paramStringBuilder)
  {
    if (this.mAnimatedDrawableOptions.forceKeepAllFramesInMemory)
    {
      paramStringBuilder.append("Pinned To Memory");
      if ((shouldKeepAllFramesInMemory()) && (this.mAnimatedDrawableOptions.allowPrefetching)) {
        paramStringBuilder.append(" MT");
      }
      return;
    }
    if (this.mApproxKiloBytesToHoldAllFrames < this.mMaximumKiloBytes) {
      paramStringBuilder.append("within ");
    }
    for (;;)
    {
      this.mAnimatedDrawableUtil.appendMemoryString(paramStringBuilder, (int)this.mMaximumKiloBytes);
      break;
      paramStringBuilder.append("exceeds ");
    }
  }
  
  public void dropCaches()
  {
    try
    {
      this.mBitmapsToKeepCached.setAll(false);
      dropBitmapsThatShouldNotBeCached();
      Iterator localIterator = this.mFreeBitmaps.iterator();
      while (localIterator.hasNext())
      {
        ((Bitmap)localIterator.next()).recycle();
        sTotalBitmaps.decrementAndGet();
      }
      this.mFreeBitmaps.clear();
    }
    finally {}
    this.mAnimatedDrawableBackend.dropCaches();
    FLog.v(TAG, "Total bitmaps: %d", Integer.valueOf(sTotalBitmaps.get()));
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      super.finalize();
      if (this.mCachedBitmaps.size() > 0) {
        FLog.d(TAG, "Finalizing with rendered bitmaps");
      }
      sTotalBitmaps.addAndGet(-this.mFreeBitmaps.size());
      this.mFreeBitmaps.clear();
      return;
    }
    finally {}
  }
  
  public AnimatedDrawableCachingBackend forNewBounds(Rect paramRect)
  {
    paramRect = this.mAnimatedDrawableBackend.forNewBounds(paramRect);
    if (paramRect == this.mAnimatedDrawableBackend) {
      return this;
    }
    return new AnimatedDrawableCachingBackendImpl(this.mExecutorService, this.mActivityManager, this.mAnimatedDrawableUtil, this.mMonotonicClock, paramRect, this.mAnimatedDrawableOptions);
  }
  
  public CloseableReference<Bitmap> getBitmapForFrame(int paramInt)
  {
    this.mCurrentFrameIndex = paramInt;
    CloseableReference localCloseableReference = getBitmapForFrameInternal(paramInt, false);
    schedulePrefetches();
    return localCloseableReference;
  }
  
  @VisibleForTesting
  CloseableReference<Bitmap> getBitmapForFrameBlocking(int paramInt)
  {
    this.mCurrentFrameIndex = paramInt;
    CloseableReference localCloseableReference = getBitmapForFrameInternal(paramInt, true);
    schedulePrefetches();
    return localCloseableReference;
  }
  
  @VisibleForTesting
  Map<Integer, j<?>> getDecodesInFlight()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      int i = 0;
      while (i < this.mDecodesInFlight.size())
      {
        localHashMap.put(Integer.valueOf(this.mDecodesInFlight.keyAt(i)), this.mDecodesInFlight.valueAt(i));
        i += 1;
      }
      return localHashMap;
    }
    finally {}
  }
  
  @VisibleForTesting
  Set<Integer> getFramesCached()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.mCachedBitmaps.size());
      int i = 0;
      while (i < this.mCachedBitmaps.size())
      {
        localHashSet.add(Integer.valueOf(this.mCachedBitmaps.keyAt(i)));
        i += 1;
      }
      return localHashSet;
    }
    finally {}
  }
  
  public int getMemoryUsage()
  {
    int m = 0;
    try
    {
      Object localObject1 = this.mFreeBitmaps.iterator();
      int i = 0;
      int j;
      int k;
      for (;;)
      {
        j = m;
        k = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        Bitmap localBitmap = (Bitmap)((Iterator)localObject1).next();
        i += this.mAnimatedDrawableUtil.getSizeOfBitmap(localBitmap);
      }
      while (j < this.mCachedBitmaps.size())
      {
        localObject1 = (CloseableReference)this.mCachedBitmaps.valueAt(j);
        k += this.mAnimatedDrawableUtil.getSizeOfBitmap((Bitmap)((CloseableReference)localObject1).get());
        j += 1;
      }
      return this.mAnimatedDrawableBackend.getMemoryUsage() + k;
    }
    finally {}
  }
  
  public CloseableReference<Bitmap> getPreviewBitmap()
  {
    return getAnimatedImageResult().getPreviewBitmap();
  }
  
  void releaseBitmapInternal(Bitmap paramBitmap)
  {
    try
    {
      this.mFreeBitmaps.add(paramBitmap);
      return;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
  
  public void renderFrame(int paramInt, Canvas paramCanvas)
  {
    throw new IllegalStateException();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */