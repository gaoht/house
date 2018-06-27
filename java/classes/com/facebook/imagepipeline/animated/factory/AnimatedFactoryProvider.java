package com.facebook.imagepipeline.animated.factory;

import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import java.lang.reflect.Constructor;

public class AnimatedFactoryProvider
{
  private static AnimatedFactory sImpl = null;
  private static boolean sImplLoaded;
  
  public static AnimatedFactory getAnimatedFactory(PlatformBitmapFactory paramPlatformBitmapFactory, ExecutorSupplier paramExecutorSupplier)
  {
    if (!sImplLoaded) {}
    try
    {
      sImpl = (AnimatedFactory)Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImplSupport").getConstructor(new Class[] { PlatformBitmapFactory.class, ExecutorSupplier.class }).newInstance(new Object[] { paramPlatformBitmapFactory, paramExecutorSupplier });
      if (sImpl != null)
      {
        sImplLoaded = true;
        return sImpl;
      }
      try
      {
        sImpl = (AnimatedFactory)Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImpl").getConstructor(new Class[] { PlatformBitmapFactory.class, ExecutorSupplier.class }).newInstance(new Object[] { paramPlatformBitmapFactory, paramExecutorSupplier });
        sImplLoaded = true;
        return sImpl;
      }
      catch (Throwable paramPlatformBitmapFactory)
      {
        for (;;) {}
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/animated/factory/AnimatedFactoryProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */