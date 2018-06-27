package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class ForwardingControllerListener<INFO>
  implements ControllerListener<INFO>
{
  private static final String TAG = "FdingControllerListener";
  private final List<ControllerListener<? super INFO>> mListeners = new ArrayList(2);
  
  public static <INFO> ForwardingControllerListener<INFO> create()
  {
    return new ForwardingControllerListener();
  }
  
  public static <INFO> ForwardingControllerListener<INFO> of(ControllerListener<? super INFO> paramControllerListener)
  {
    ForwardingControllerListener localForwardingControllerListener = create();
    localForwardingControllerListener.addListener(paramControllerListener);
    return localForwardingControllerListener;
  }
  
  public static <INFO> ForwardingControllerListener<INFO> of(ControllerListener<? super INFO> paramControllerListener1, ControllerListener<? super INFO> paramControllerListener2)
  {
    ForwardingControllerListener localForwardingControllerListener = create();
    localForwardingControllerListener.addListener(paramControllerListener1);
    localForwardingControllerListener.addListener(paramControllerListener2);
    return localForwardingControllerListener;
  }
  
  private void onException(String paramString, Throwable paramThrowable)
  {
    try
    {
      Log.e("FdingControllerListener", paramString, paramThrowable);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void addListener(ControllerListener<? super INFO> paramControllerListener)
  {
    try
    {
      this.mListeners.add(paramControllerListener);
      return;
    }
    finally
    {
      paramControllerListener = finally;
      throw paramControllerListener;
    }
  }
  
  public void clearListeners()
  {
    try
    {
      this.mListeners.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onFailure(String paramString, Throwable paramThrowable)
  {
    try
    {
      int j = this.mListeners.size();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            ((ControllerListener)this.mListeners.get(i)).onFailure(paramString, paramThrowable);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              onException("InternalListener exception in onFailure", localException);
            }
          }
        }
      }
    }
    finally {}
  }
  
  public void onFinalImageSet(String paramString, @Nullable INFO paramINFO, @Nullable Animatable paramAnimatable)
  {
    try
    {
      int j = this.mListeners.size();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            ((ControllerListener)this.mListeners.get(i)).onFinalImageSet(paramString, paramINFO, paramAnimatable);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              onException("InternalListener exception in onFinalImageSet", localException);
            }
          }
        }
      }
    }
    finally {}
  }
  
  public void onIntermediateImageFailed(String paramString, Throwable paramThrowable)
  {
    int j = this.mListeners.size();
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          ((ControllerListener)this.mListeners.get(i)).onIntermediateImageFailed(paramString, paramThrowable);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            onException("InternalListener exception in onIntermediateImageFailed", localException);
          }
        }
      }
    }
  }
  
  public void onIntermediateImageSet(String paramString, @Nullable INFO paramINFO)
  {
    int j = this.mListeners.size();
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          ((ControllerListener)this.mListeners.get(i)).onIntermediateImageSet(paramString, paramINFO);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            onException("InternalListener exception in onIntermediateImageSet", localException);
          }
        }
      }
    }
  }
  
  public void onRelease(String paramString)
  {
    try
    {
      int j = this.mListeners.size();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            ((ControllerListener)this.mListeners.get(i)).onRelease(paramString);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              onException("InternalListener exception in onRelease", localException);
            }
          }
        }
      }
    }
    finally {}
  }
  
  public void onSubmit(String paramString, Object paramObject)
  {
    try
    {
      int j = this.mListeners.size();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            ((ControllerListener)this.mListeners.get(i)).onSubmit(paramString, paramObject);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              onException("InternalListener exception in onSubmit", localException);
            }
          }
        }
      }
    }
    finally {}
  }
  
  public void removeListener(ControllerListener<? super INFO> paramControllerListener)
  {
    try
    {
      this.mListeners.remove(paramControllerListener);
      return;
    }
    finally
    {
      paramControllerListener = finally;
      throw paramControllerListener;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/drawee/controller/ForwardingControllerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */