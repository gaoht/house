package com.facebook.imagepipeline.animated.factory;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import com.facebook.common.executors.DefaultSerialExecutorService;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImplProvider;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.NotThreadSafe;

@DoNotStrip
@NotThreadSafe
public class AnimatedFactoryImpl
  implements AnimatedFactory
{
  private AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
  private AnimatedDrawableFactory mAnimatedDrawableFactory;
  private AnimatedDrawableUtil mAnimatedDrawableUtil;
  private AnimatedImageFactory mAnimatedImageFactory;
  private ExecutorSupplier mExecutorSupplier;
  private PlatformBitmapFactory mPlatformBitmapFactory;
  
  @DoNotStrip
  public AnimatedFactoryImpl(PlatformBitmapFactory paramPlatformBitmapFactory, ExecutorSupplier paramExecutorSupplier)
  {
    this.mPlatformBitmapFactory = paramPlatformBitmapFactory;
    this.mExecutorSupplier = paramExecutorSupplier;
  }
  
  private AnimatedDrawableFactory buildAnimatedDrawableFactory(final SerialExecutorService paramSerialExecutorService, final ActivityManager paramActivityManager, final AnimatedDrawableUtil paramAnimatedDrawableUtil, AnimatedDrawableBackendProvider paramAnimatedDrawableBackendProvider, ScheduledExecutorService paramScheduledExecutorService, final MonotonicClock paramMonotonicClock, Resources paramResources)
  {
    createAnimatedDrawableFactory(paramAnimatedDrawableBackendProvider, new AnimatedDrawableCachingBackendImplProvider()
    {
      public AnimatedDrawableCachingBackendImpl get(AnimatedDrawableBackend paramAnonymousAnimatedDrawableBackend, AnimatedDrawableOptions paramAnonymousAnimatedDrawableOptions)
      {
        return new AnimatedDrawableCachingBackendImpl(paramSerialExecutorService, paramActivityManager, paramAnimatedDrawableUtil, paramMonotonicClock, paramAnonymousAnimatedDrawableBackend, paramAnonymousAnimatedDrawableOptions);
      }
    }, paramAnimatedDrawableUtil, paramScheduledExecutorService, paramResources);
  }
  
  private AnimatedImageFactory buildAnimatedImageFactory()
  {
    new AnimatedImageFactoryImpl(new AnimatedDrawableBackendProvider()
    {
      public AnimatedDrawableBackend get(AnimatedImageResult paramAnonymousAnimatedImageResult, Rect paramAnonymousRect)
      {
        return new AnimatedDrawableBackendImpl(AnimatedFactoryImpl.this.getAnimatedDrawableUtil(), paramAnonymousAnimatedImageResult, paramAnonymousRect);
      }
    }, this.mPlatformBitmapFactory);
  }
  
  private AnimatedDrawableBackendProvider getAnimatedDrawableBackendProvider()
  {
    if (this.mAnimatedDrawableBackendProvider == null) {
      this.mAnimatedDrawableBackendProvider = new AnimatedDrawableBackendProvider()
      {
        public AnimatedDrawableBackend get(AnimatedImageResult paramAnonymousAnimatedImageResult, Rect paramAnonymousRect)
        {
          return new AnimatedDrawableBackendImpl(AnimatedFactoryImpl.this.getAnimatedDrawableUtil(), paramAnonymousAnimatedImageResult, paramAnonymousRect);
        }
      };
    }
    return this.mAnimatedDrawableBackendProvider;
  }
  
  private AnimatedDrawableUtil getAnimatedDrawableUtil()
  {
    if (this.mAnimatedDrawableUtil == null) {
      this.mAnimatedDrawableUtil = new AnimatedDrawableUtil();
    }
    return this.mAnimatedDrawableUtil;
  }
  
  protected AnimatedDrawableFactory createAnimatedDrawableFactory(AnimatedDrawableBackendProvider paramAnimatedDrawableBackendProvider, AnimatedDrawableCachingBackendImplProvider paramAnimatedDrawableCachingBackendImplProvider, AnimatedDrawableUtil paramAnimatedDrawableUtil, ScheduledExecutorService paramScheduledExecutorService, Resources paramResources)
  {
    return new AnimatedDrawableFactoryImpl(paramAnimatedDrawableBackendProvider, paramAnimatedDrawableCachingBackendImplProvider, paramAnimatedDrawableUtil, paramScheduledExecutorService, paramResources);
  }
  
  public AnimatedDrawableFactory getAnimatedDrawableFactory(Context paramContext)
  {
    if (this.mAnimatedDrawableFactory == null) {
      this.mAnimatedDrawableFactory = buildAnimatedDrawableFactory(new DefaultSerialExecutorService(this.mExecutorSupplier.forDecode()), (ActivityManager)paramContext.getSystemService("activity"), getAnimatedDrawableUtil(), getAnimatedDrawableBackendProvider(), UiThreadImmediateExecutorService.getInstance(), RealtimeSinceBootClock.get(), paramContext.getResources());
    }
    return this.mAnimatedDrawableFactory;
  }
  
  public AnimatedImageFactory getAnimatedImageFactory()
  {
    if (this.mAnimatedImageFactory == null) {
      this.mAnimatedImageFactory = buildAnimatedImageFactory();
    }
    return this.mAnimatedImageFactory;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/animated/factory/AnimatedFactoryImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */