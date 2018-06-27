package com.ziroom.ziroomcustomer.minsu.chat.photoview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

abstract class e
{
  d a;
  
  public static e newInstance(Context paramContext, d paramd)
  {
    int i = Build.VERSION.SDK_INT;
    if (i < 5) {
      paramContext = new a(paramContext);
    }
    for (;;)
    {
      paramContext.a = paramd;
      return paramContext;
      if (i < 8) {
        paramContext = new b(paramContext);
      } else {
        paramContext = new c(paramContext);
      }
    }
  }
  
  public abstract boolean isScaling();
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  private static class a
    extends e
  {
    float b;
    float c;
    final float d;
    final float e;
    private VelocityTracker f;
    private boolean g;
    
    public a(Context paramContext)
    {
      paramContext = ViewConfiguration.get(paramContext);
      this.e = paramContext.getScaledMinimumFlingVelocity();
      this.d = paramContext.getScaledTouchSlop();
    }
    
    float a(MotionEvent paramMotionEvent)
    {
      return paramMotionEvent.getX();
    }
    
    float b(MotionEvent paramMotionEvent)
    {
      return paramMotionEvent.getY();
    }
    
    public boolean isScaling()
    {
      return false;
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      boolean bool = false;
      switch (paramMotionEvent.getAction())
      {
      }
      do
      {
        float f1;
        float f2;
        do
        {
          do
          {
            float f3;
            float f4;
            do
            {
              return true;
              this.f = VelocityTracker.obtain();
              this.f.addMovement(paramMotionEvent);
              this.b = a(paramMotionEvent);
              this.c = b(paramMotionEvent);
              this.g = false;
              return true;
              f1 = a(paramMotionEvent);
              f2 = b(paramMotionEvent);
              f3 = f1 - this.b;
              f4 = f2 - this.c;
              if (!this.g)
              {
                if (Math.sqrt(f3 * f3 + f4 * f4) >= this.d) {
                  bool = true;
                }
                this.g = bool;
              }
            } while (!this.g);
            this.a.onDrag(f3, f4);
            this.b = f1;
            this.c = f2;
          } while (this.f == null);
          this.f.addMovement(paramMotionEvent);
          return true;
        } while (this.f == null);
        this.f.recycle();
        this.f = null;
        return true;
        if ((this.g) && (this.f != null))
        {
          this.b = a(paramMotionEvent);
          this.c = b(paramMotionEvent);
          this.f.addMovement(paramMotionEvent);
          this.f.computeCurrentVelocity(1000);
          f1 = this.f.getXVelocity();
          f2 = this.f.getYVelocity();
          if (Math.max(Math.abs(f1), Math.abs(f2)) >= this.e) {
            this.a.onFling(this.b, this.c, -f1, -f2);
          }
        }
      } while (this.f == null);
      this.f.recycle();
      this.f = null;
      return true;
    }
  }
  
  @TargetApi(5)
  private static class b
    extends e.a
  {
    private int f = -1;
    private int g = 0;
    
    public b(Context paramContext)
    {
      super();
    }
    
    float a(MotionEvent paramMotionEvent)
    {
      try
      {
        float f1 = paramMotionEvent.getX(this.g);
        return f1;
      }
      catch (Exception localException) {}
      return paramMotionEvent.getX();
    }
    
    float b(MotionEvent paramMotionEvent)
    {
      try
      {
        float f1 = paramMotionEvent.getY(this.g);
        return f1;
      }
      catch (Exception localException) {}
      return paramMotionEvent.getY();
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      int j = 0;
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
      do
      {
        for (;;)
        {
          i = j;
          if (this.f != -1) {
            i = this.f;
          }
          this.g = paramMotionEvent.findPointerIndex(i);
          return super.onTouchEvent(paramMotionEvent);
          this.f = paramMotionEvent.getPointerId(0);
          continue;
          this.f = -1;
        }
        i = (paramMotionEvent.getAction() & 0xFF00) >> 8;
      } while (paramMotionEvent.getPointerId(i) != this.f);
      if (i == 0) {}
      for (int i = 1;; i = 0)
      {
        this.f = paramMotionEvent.getPointerId(i);
        this.b = paramMotionEvent.getX(i);
        this.c = paramMotionEvent.getY(i);
        break;
      }
    }
  }
  
  @TargetApi(8)
  private static class c
    extends e.b
  {
    private final ScaleGestureDetector f = new ScaleGestureDetector(paramContext, this.g);
    private final ScaleGestureDetector.OnScaleGestureListener g = new ScaleGestureDetector.OnScaleGestureListener()
    {
      public boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        e.c.this.a.onScale(paramAnonymousScaleGestureDetector.getScaleFactor(), paramAnonymousScaleGestureDetector.getFocusX(), paramAnonymousScaleGestureDetector.getFocusY());
        return true;
      }
      
      public boolean onScaleBegin(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        return true;
      }
      
      public void onScaleEnd(ScaleGestureDetector paramAnonymousScaleGestureDetector) {}
    };
    
    public c(Context paramContext)
    {
      super();
    }
    
    public boolean isScaling()
    {
      return this.f.isInProgress();
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      this.f.onTouchEvent(paramMotionEvent);
      return super.onTouchEvent(paramMotionEvent);
    }
  }
  
  public static abstract interface d
  {
    public abstract void onDrag(float paramFloat1, float paramFloat2);
    
    public abstract void onFling(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
    
    public abstract void onScale(float paramFloat1, float paramFloat2, float paramFloat3);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/photoview/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */