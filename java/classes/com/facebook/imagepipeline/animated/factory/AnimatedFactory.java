package com.facebook.imagepipeline.animated.factory;

import android.content.Context;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public abstract interface AnimatedFactory
{
  public abstract AnimatedDrawableFactory getAnimatedDrawableFactory(Context paramContext);
  
  public abstract AnimatedImageFactory getAnimatedImageFactory();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/animated/factory/AnimatedFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */