package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.MonotonicClock;
import com.facebook.drawable.base.DrawableWithCaches;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class AbstractAnimatedDrawable
  extends Drawable
  implements Animatable, DrawableWithCaches
{
  private static final int NO_FRAME = -1;
  private static final int POLL_FOR_RENDERED_FRAME_MS = 5;
  private static final Class<?> TAG = AnimatedDrawable.class;
  private static final long WATCH_DOG_TIMER_MIN_TIMEOUT_MS = 1000L;
  private static final long WATCH_DOG_TIMER_POLL_INTERVAL_MS = 2000L;
  private AnimatedDrawableCachingBackend mAnimatedDrawableBackend;
  private final AnimatedDrawableDiagnostics mAnimatedDrawableDiagnostics;
  private boolean mApplyTransformation;
  private final Rect mDstRect = new Rect();
  private final int mDurationMs;
  private final int mFrameCount;
  private boolean mHaveWatchdogScheduled;
  private final Runnable mInvalidateTask = new Runnable()
  {
    public void run()
    {
      FLog.v(AbstractAnimatedDrawable.TAG, "(%s) Invalidate Task", AbstractAnimatedDrawable.this.mLogId);
      AbstractAnimatedDrawable.access$402(AbstractAnimatedDrawable.this, false);
      AbstractAnimatedDrawable.this.doInvalidateSelf();
    }
  };
  private boolean mInvalidateTaskScheduled;
  private boolean mIsPaused = false;
  private boolean mIsRunning;
  private CloseableReference<Bitmap> mLastDrawnFrame;
  private int mLastDrawnFrameMonotonicNumber = -1;
  private int mLastDrawnFrameNumber = -1;
  private long mLastInvalidateTimeMs = -1L;
  private volatile String mLogId;
  private final int mLoopCount;
  private final MonotonicClock mMonotonicClock;
  private final Runnable mNextFrameTask = new Runnable()
  {
    public void run()
    {
      FLog.v(AbstractAnimatedDrawable.TAG, "(%s) Next Frame Task", AbstractAnimatedDrawable.this.mLogId);
      AbstractAnimatedDrawable.this.onNextFrame();
    }
  };
  private long mNextFrameTaskMs = -1L;
  private final Paint mPaint = new Paint(6);
  private int mPendingRenderedFrameMonotonicNumber;
  private int mPendingRenderedFrameNumber;
  private final ScheduledExecutorService mScheduledExecutorServiceForUiThread;
  private int mScheduledFrameMonotonicNumber;
  private int mScheduledFrameNumber;
  private final Runnable mStartTask = new Runnable()
  {
    public void run()
    {
      AbstractAnimatedDrawable.this.onStart();
    }
  };
  private long mStartTimeMs;
  private float mSx = 1.0F;
  private float mSy = 1.0F;
  private final Paint mTransparentPaint;
  private boolean mWaitingForDraw;
  private final Runnable mWatchdogTask = new Runnable()
  {
    public void run()
    {
      FLog.v(AbstractAnimatedDrawable.TAG, "(%s) Watchdog Task", AbstractAnimatedDrawable.this.mLogId);
      AbstractAnimatedDrawable.this.doWatchdogCheck();
    }
  };
  
  public AbstractAnimatedDrawable(ScheduledExecutorService paramScheduledExecutorService, AnimatedDrawableCachingBackend paramAnimatedDrawableCachingBackend, AnimatedDrawableDiagnostics paramAnimatedDrawableDiagnostics, MonotonicClock paramMonotonicClock)
  {
    this.mScheduledExecutorServiceForUiThread = paramScheduledExecutorService;
    this.mAnimatedDrawableBackend = paramAnimatedDrawableCachingBackend;
    this.mAnimatedDrawableDiagnostics = paramAnimatedDrawableDiagnostics;
    this.mMonotonicClock = paramMonotonicClock;
    this.mDurationMs = this.mAnimatedDrawableBackend.getDurationMs();
    this.mFrameCount = this.mAnimatedDrawableBackend.getFrameCount();
    this.mAnimatedDrawableDiagnostics.setBackend(this.mAnimatedDrawableBackend);
    this.mLoopCount = this.mAnimatedDrawableBackend.getLoopCount();
    this.mTransparentPaint = new Paint();
    this.mTransparentPaint.setColor(0);
    this.mTransparentPaint.setStyle(Paint.Style.FILL);
    resetToPreviewFrame();
  }
  
  private void computeAndScheduleNextFrame(boolean paramBoolean)
  {
    if (this.mDurationMs == 0) {}
    long l;
    int j;
    int k;
    int i;
    label126:
    do
    {
      do
      {
        return;
        l = this.mMonotonicClock.now();
        j = (int)((l - this.mStartTimeMs) / this.mDurationMs);
      } while ((this.mLoopCount != 0) && (j >= this.mLoopCount));
      k = (int)((l - this.mStartTimeMs) % this.mDurationMs);
      int m = this.mAnimatedDrawableBackend.getFrameForTimestampMs(k);
      if (this.mScheduledFrameNumber != m) {}
      for (i = 1;; i = 0)
      {
        this.mScheduledFrameNumber = m;
        this.mScheduledFrameMonotonicNumber = (j * this.mFrameCount + m);
        if (!paramBoolean) {
          break;
        }
        if (i == 0) {
          break label126;
        }
        doInvalidateSelf();
        return;
      }
      i = this.mAnimatedDrawableBackend.getTimestampMsForFrame(this.mScheduledFrameNumber) + this.mAnimatedDrawableBackend.getDurationMsForFrame(this.mScheduledFrameNumber) - k;
      j = this.mScheduledFrameNumber;
      k = this.mFrameCount;
      l += i;
    } while ((this.mNextFrameTaskMs != -1L) && (this.mNextFrameTaskMs <= l));
    FLog.v(TAG, "(%s) Next frame (%d) in %d ms", this.mLogId, Integer.valueOf((j + 1) % k), Integer.valueOf(i));
    unscheduleSelf(this.mNextFrameTask);
    scheduleSelf(this.mNextFrameTask, l);
    this.mNextFrameTaskMs = l;
  }
  
  private void doInvalidateSelf()
  {
    this.mWaitingForDraw = true;
    this.mLastInvalidateTimeMs = this.mMonotonicClock.now();
    invalidateSelf();
  }
  
  private void doWatchdogCheck()
  {
    int k = 0;
    this.mHaveWatchdogScheduled = false;
    if (!this.mIsRunning) {
      return;
    }
    long l = this.mMonotonicClock.now();
    if ((this.mWaitingForDraw) && (l - this.mLastInvalidateTimeMs > 1000L)) {}
    for (int i = 1;; i = 0)
    {
      int j = k;
      if (this.mNextFrameTaskMs != -1L)
      {
        j = k;
        if (l - this.mNextFrameTaskMs > 1000L) {
          j = 1;
        }
      }
      if ((i == 0) && (j == 0)) {
        break;
      }
      dropCaches();
      doInvalidateSelf();
      return;
    }
    this.mScheduledExecutorServiceForUiThread.schedule(this.mWatchdogTask, 2000L, TimeUnit.MILLISECONDS);
    this.mHaveWatchdogScheduled = true;
  }
  
  private void onNextFrame()
  {
    this.mNextFrameTaskMs = -1L;
    if (!this.mIsRunning) {}
    while (this.mDurationMs == 0) {
      return;
    }
    this.mAnimatedDrawableDiagnostics.onNextFrameMethodBegin();
    try
    {
      computeAndScheduleNextFrame(true);
      return;
    }
    finally
    {
      this.mAnimatedDrawableDiagnostics.onNextFrameMethodEnd();
    }
  }
  
  /* Error */
  private void onStart()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 261	com/facebook/imagepipeline/animated/base/AbstractAnimatedDrawable:mIsRunning	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 135	com/facebook/imagepipeline/animated/base/AbstractAnimatedDrawable:mAnimatedDrawableDiagnostics	Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableDiagnostics;
    //   12: invokeinterface 287 1 0
    //   17: aload_0
    //   18: aload_0
    //   19: getfield 137	com/facebook/imagepipeline/animated/base/AbstractAnimatedDrawable:mMonotonicClock	Lcom/facebook/common/time/MonotonicClock;
    //   22: invokeinterface 214 1 0
    //   27: putfield 216	com/facebook/imagepipeline/animated/base/AbstractAnimatedDrawable:mStartTimeMs	J
    //   30: aload_0
    //   31: getfield 115	com/facebook/imagepipeline/animated/base/AbstractAnimatedDrawable:mIsPaused	Z
    //   34: ifeq +71 -> 105
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 216	com/facebook/imagepipeline/animated/base/AbstractAnimatedDrawable:mStartTimeMs	J
    //   42: aload_0
    //   43: getfield 133	com/facebook/imagepipeline/animated/base/AbstractAnimatedDrawable:mAnimatedDrawableBackend	Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableCachingBackend;
    //   46: aload_0
    //   47: getfield 222	com/facebook/imagepipeline/animated/base/AbstractAnimatedDrawable:mScheduledFrameNumber	I
    //   50: invokeinterface 227 2 0
    //   55: i2l
    //   56: lsub
    //   57: putfield 216	com/facebook/imagepipeline/animated/base/AbstractAnimatedDrawable:mStartTimeMs	J
    //   60: aload_0
    //   61: getfield 216	com/facebook/imagepipeline/animated/base/AbstractAnimatedDrawable:mStartTimeMs	J
    //   64: aload_0
    //   65: getfield 133	com/facebook/imagepipeline/animated/base/AbstractAnimatedDrawable:mAnimatedDrawableBackend	Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableCachingBackend;
    //   68: iconst_0
    //   69: invokeinterface 230 2 0
    //   74: i2l
    //   75: ladd
    //   76: lstore_1
    //   77: aload_0
    //   78: aload_0
    //   79: getfield 123	com/facebook/imagepipeline/animated/base/AbstractAnimatedDrawable:mNextFrameTask	Ljava/lang/Runnable;
    //   82: lload_1
    //   83: invokevirtual 252	com/facebook/imagepipeline/animated/base/AbstractAnimatedDrawable:scheduleSelf	(Ljava/lang/Runnable;J)V
    //   86: aload_0
    //   87: lload_1
    //   88: putfield 113	com/facebook/imagepipeline/animated/base/AbstractAnimatedDrawable:mNextFrameTaskMs	J
    //   91: aload_0
    //   92: invokespecial 202	com/facebook/imagepipeline/animated/base/AbstractAnimatedDrawable:doInvalidateSelf	()V
    //   95: aload_0
    //   96: getfield 135	com/facebook/imagepipeline/animated/base/AbstractAnimatedDrawable:mAnimatedDrawableDiagnostics	Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableDiagnostics;
    //   99: invokeinterface 290 1 0
    //   104: return
    //   105: aload_0
    //   106: iconst_0
    //   107: putfield 222	com/facebook/imagepipeline/animated/base/AbstractAnimatedDrawable:mScheduledFrameNumber	I
    //   110: aload_0
    //   111: iconst_0
    //   112: putfield 224	com/facebook/imagepipeline/animated/base/AbstractAnimatedDrawable:mScheduledFrameMonotonicNumber	I
    //   115: goto -55 -> 60
    //   118: astore_3
    //   119: aload_0
    //   120: getfield 135	com/facebook/imagepipeline/animated/base/AbstractAnimatedDrawable:mAnimatedDrawableDiagnostics	Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableDiagnostics;
    //   123: invokeinterface 290 1 0
    //   128: aload_3
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	AbstractAnimatedDrawable
    //   76	12	1	l	long
    //   118	11	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	60	118	finally
    //   60	95	118	finally
    //   105	115	118	finally
  }
  
  private boolean renderFrame(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    CloseableReference localCloseableReference = this.mAnimatedDrawableBackend.getBitmapForFrame(paramInt1);
    if (localCloseableReference != null)
    {
      paramCanvas.drawBitmap((Bitmap)localCloseableReference.get(), 0.0F, 0.0F, this.mPaint);
      if (this.mLastDrawnFrame != null) {
        this.mLastDrawnFrame.close();
      }
      if ((this.mIsRunning) && (paramInt2 > this.mLastDrawnFrameMonotonicNumber))
      {
        int i = paramInt2 - this.mLastDrawnFrameMonotonicNumber - 1;
        this.mAnimatedDrawableDiagnostics.incrementDrawnFrames(1);
        this.mAnimatedDrawableDiagnostics.incrementDroppedFrames(i);
        if (i > 0) {
          FLog.v(TAG, "(%s) Dropped %d frames", this.mLogId, Integer.valueOf(i));
        }
      }
      this.mLastDrawnFrame = localCloseableReference;
      this.mLastDrawnFrameNumber = paramInt1;
      this.mLastDrawnFrameMonotonicNumber = paramInt2;
      FLog.v(TAG, "(%s) Drew frame %d", this.mLogId, Integer.valueOf(paramInt1));
      return true;
    }
    return false;
  }
  
  private void resetToPreviewFrame()
  {
    this.mScheduledFrameNumber = this.mAnimatedDrawableBackend.getFrameForPreview();
    this.mScheduledFrameMonotonicNumber = this.mScheduledFrameNumber;
    this.mPendingRenderedFrameNumber = -1;
    this.mPendingRenderedFrameMonotonicNumber = -1;
  }
  
  private void scheduleInvalidatePoll()
  {
    if (this.mInvalidateTaskScheduled) {
      return;
    }
    this.mInvalidateTaskScheduled = true;
    scheduleSelf(this.mInvalidateTask, 5L);
  }
  
  public boolean didLastDrawRender()
  {
    return this.mLastDrawnFrame != null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    boolean bool2 = false;
    this.mAnimatedDrawableDiagnostics.onDrawMethodBegin();
    for (;;)
    {
      try
      {
        this.mWaitingForDraw = false;
        if ((this.mIsRunning) && (!this.mHaveWatchdogScheduled))
        {
          this.mScheduledExecutorServiceForUiThread.schedule(this.mWatchdogTask, 2000L, TimeUnit.MILLISECONDS);
          this.mHaveWatchdogScheduled = true;
        }
        Object localObject;
        if (this.mApplyTransformation)
        {
          this.mDstRect.set(getBounds());
          if (!this.mDstRect.isEmpty())
          {
            localObject = this.mAnimatedDrawableBackend.forNewBounds(this.mDstRect);
            if (localObject != this.mAnimatedDrawableBackend)
            {
              this.mAnimatedDrawableBackend.dropCaches();
              this.mAnimatedDrawableBackend = ((AnimatedDrawableCachingBackend)localObject);
              this.mAnimatedDrawableDiagnostics.setBackend((AnimatedDrawableCachingBackend)localObject);
            }
            this.mSx = (this.mDstRect.width() / this.mAnimatedDrawableBackend.getRenderedWidth());
            this.mSy = (this.mDstRect.height() / this.mAnimatedDrawableBackend.getRenderedHeight());
            this.mApplyTransformation = false;
          }
        }
        boolean bool3 = this.mDstRect.isEmpty();
        if (bool3) {
          return;
        }
        paramCanvas.save();
        paramCanvas.scale(this.mSx, this.mSy);
        if (this.mPendingRenderedFrameNumber != -1)
        {
          bool3 = renderFrame(paramCanvas, this.mPendingRenderedFrameNumber, this.mPendingRenderedFrameMonotonicNumber);
          bool2 = false | bool3;
          if (bool3)
          {
            FLog.v(TAG, "(%s) Rendered pending frame %d", this.mLogId, Integer.valueOf(this.mPendingRenderedFrameNumber));
            this.mPendingRenderedFrameNumber = -1;
            this.mPendingRenderedFrameMonotonicNumber = -1;
          }
        }
        else
        {
          bool1 = bool2;
          if (this.mPendingRenderedFrameNumber == -1)
          {
            if (this.mIsRunning) {
              computeAndScheduleNextFrame(false);
            }
            bool3 = renderFrame(paramCanvas, this.mScheduledFrameNumber, this.mScheduledFrameMonotonicNumber);
            bool2 |= bool3;
            if (!bool3) {
              break label600;
            }
            FLog.v(TAG, "(%s) Rendered current frame %d", this.mLogId, Integer.valueOf(this.mScheduledFrameNumber));
            bool1 = bool2;
            if (this.mIsRunning)
            {
              computeAndScheduleNextFrame(true);
              bool1 = bool2;
            }
          }
          bool2 = bool1;
          if (!bool1)
          {
            bool2 = bool1;
            if (this.mLastDrawnFrame != null)
            {
              paramCanvas.drawBitmap((Bitmap)this.mLastDrawnFrame.get(), 0.0F, 0.0F, this.mPaint);
              FLog.v(TAG, "(%s) Rendered last known frame %d", this.mLogId, Integer.valueOf(this.mLastDrawnFrameNumber));
              bool2 = true;
            }
          }
          bool1 = bool2;
          if (!bool2)
          {
            localObject = this.mAnimatedDrawableBackend.getPreviewBitmap();
            bool1 = bool2;
            if (localObject != null)
            {
              paramCanvas.drawBitmap((Bitmap)((CloseableReference)localObject).get(), 0.0F, 0.0F, this.mPaint);
              ((CloseableReference)localObject).close();
              FLog.v(TAG, "(%s) Rendered preview frame", this.mLogId);
              bool1 = true;
            }
          }
          if (!bool1)
          {
            paramCanvas.drawRect(0.0F, 0.0F, this.mDstRect.width(), this.mDstRect.height(), this.mTransparentPaint);
            FLog.v(TAG, "(%s) Failed to draw a frame", this.mLogId);
          }
          paramCanvas.restore();
          this.mAnimatedDrawableDiagnostics.drawDebugOverlay(paramCanvas, this.mDstRect);
          return;
        }
        FLog.v(TAG, "(%s) Trying again later for pending %d", this.mLogId, Integer.valueOf(this.mPendingRenderedFrameNumber));
        scheduleInvalidatePoll();
        continue;
        FLog.v(TAG, "(%s) Trying again later for current %d", this.mLogId, Integer.valueOf(this.mScheduledFrameNumber));
      }
      finally
      {
        this.mAnimatedDrawableDiagnostics.onDrawMethodEnd();
      }
      label600:
      this.mPendingRenderedFrameNumber = this.mScheduledFrameNumber;
      this.mPendingRenderedFrameMonotonicNumber = this.mScheduledFrameMonotonicNumber;
      scheduleInvalidatePoll();
      boolean bool1 = bool2;
    }
  }
  
  public void dropCaches()
  {
    FLog.v(TAG, "(%s) Dropping caches", this.mLogId);
    if (this.mLastDrawnFrame != null)
    {
      this.mLastDrawnFrame.close();
      this.mLastDrawnFrame = null;
      this.mLastDrawnFrameNumber = -1;
      this.mLastDrawnFrameMonotonicNumber = -1;
    }
    this.mAnimatedDrawableBackend.dropCaches();
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    if (this.mLastDrawnFrame != null)
    {
      this.mLastDrawnFrame.close();
      this.mLastDrawnFrame = null;
    }
  }
  
  protected AnimatedDrawableCachingBackend getAnimatedDrawableBackend()
  {
    return this.mAnimatedDrawableBackend;
  }
  
  public int getDuration()
  {
    return this.mDurationMs;
  }
  
  public int getFrameCount()
  {
    return this.mFrameCount;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mAnimatedDrawableBackend.getHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.mAnimatedDrawableBackend.getWidth();
  }
  
  public int getLoopCount()
  {
    return this.mLoopCount;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  @VisibleForTesting
  int getScheduledFrameNumber()
  {
    return this.mScheduledFrameNumber;
  }
  
  public boolean isRunning()
  {
    return this.mIsRunning;
  }
  
  @VisibleForTesting
  boolean isWaitingForDraw()
  {
    return this.mWaitingForDraw;
  }
  
  @VisibleForTesting
  boolean isWaitingForNextFrame()
  {
    return this.mNextFrameTaskMs != -1L;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mApplyTransformation = true;
    if (this.mLastDrawnFrame != null)
    {
      this.mLastDrawnFrame.close();
      this.mLastDrawnFrame = null;
    }
    this.mLastDrawnFrameNumber = -1;
    this.mLastDrawnFrameMonotonicNumber = -1;
    this.mAnimatedDrawableBackend.dropCaches();
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    if (this.mIsRunning) {}
    do
    {
      return false;
      paramInt = this.mAnimatedDrawableBackend.getFrameForTimestampMs(paramInt);
    } while (paramInt == this.mScheduledFrameNumber);
    try
    {
      this.mScheduledFrameNumber = paramInt;
      this.mScheduledFrameMonotonicNumber = paramInt;
      doInvalidateSelf();
      return true;
    }
    catch (IllegalStateException localIllegalStateException) {}
    return false;
  }
  
  public void pause()
  {
    this.mIsPaused = true;
    this.mIsRunning = false;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
    doInvalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
    doInvalidateSelf();
  }
  
  public void setLogId(String paramString)
  {
    this.mLogId = paramString;
  }
  
  public void start()
  {
    if ((this.mDurationMs == 0) || (this.mFrameCount <= 1)) {
      return;
    }
    this.mIsRunning = true;
    scheduleSelf(this.mStartTask, this.mMonotonicClock.now());
  }
  
  public void stop()
  {
    this.mIsPaused = false;
    this.mIsRunning = false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/animated/base/AbstractAnimatedDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */