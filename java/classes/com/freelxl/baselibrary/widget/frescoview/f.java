package com.freelxl.baselibrary.widget.frescoview;

import android.view.MotionEvent;

public class f
  implements e.a
{
  private final e a;
  private a b = null;
  
  public f(e parame)
  {
    this.a = parame;
    this.a.setListener(this);
  }
  
  private float a(float[] paramArrayOfFloat, int paramInt)
  {
    float f2 = 0.0F;
    int i = 0;
    float f1 = 0.0F;
    while (i < paramInt)
    {
      f1 += paramArrayOfFloat[i];
      i += 1;
    }
    if (paramInt > 0) {
      f2 = f1 / paramInt;
    }
    return f2;
  }
  
  public static f newInstance()
  {
    return new f(e.newInstance());
  }
  
  public int getNewPointerCount()
  {
    return this.a.getNewPointerCount();
  }
  
  public float getPivotX()
  {
    return a(this.a.getStartX(), this.a.getPointerCount());
  }
  
  public float getPivotY()
  {
    return a(this.a.getStartY(), this.a.getPointerCount());
  }
  
  public int getPointerCount()
  {
    return this.a.getPointerCount();
  }
  
  public float getRotation()
  {
    if (this.a.getPointerCount() < 2) {
      return 0.0F;
    }
    float f5 = this.a.getStartX()[1];
    float f6 = this.a.getStartX()[0];
    float f7 = this.a.getStartY()[1];
    float f8 = this.a.getStartY()[0];
    float f1 = this.a.getCurrentX()[1];
    float f2 = this.a.getCurrentX()[0];
    float f3 = this.a.getCurrentY()[1];
    float f4 = this.a.getCurrentY()[0];
    f5 = (float)Math.atan2(f7 - f8, f5 - f6);
    return (float)Math.atan2(f3 - f4, f1 - f2) - f5;
  }
  
  public float getScale()
  {
    if (this.a.getPointerCount() < 2) {
      return 1.0F;
    }
    float f5 = this.a.getStartX()[1];
    float f6 = this.a.getStartX()[0];
    float f7 = this.a.getStartY()[1];
    float f8 = this.a.getStartY()[0];
    float f1 = this.a.getCurrentX()[1];
    float f2 = this.a.getCurrentX()[0];
    float f3 = this.a.getCurrentY()[1];
    float f4 = this.a.getCurrentY()[0];
    f5 = (float)Math.hypot(f5 - f6, f7 - f8);
    return (float)Math.hypot(f1 - f2, f3 - f4) / f5;
  }
  
  public float getTranslationX()
  {
    return a(this.a.getCurrentX(), this.a.getPointerCount()) - a(this.a.getStartX(), this.a.getPointerCount());
  }
  
  public float getTranslationY()
  {
    return a(this.a.getCurrentY(), this.a.getPointerCount()) - a(this.a.getStartY(), this.a.getPointerCount());
  }
  
  public boolean isGestureInProgress()
  {
    return this.a.isGestureInProgress();
  }
  
  public void onGestureBegin(e parame)
  {
    if (this.b != null) {
      this.b.onGestureBegin(this);
    }
  }
  
  public void onGestureEnd(e parame)
  {
    if (this.b != null) {
      this.b.onGestureEnd(this);
    }
  }
  
  public void onGestureUpdate(e parame)
  {
    if (this.b != null) {
      this.b.onGestureUpdate(this);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.a.onTouchEvent(paramMotionEvent);
  }
  
  public void reset()
  {
    this.a.reset();
  }
  
  public void restartGesture()
  {
    this.a.restartGesture();
  }
  
  public void setListener(a parama)
  {
    this.b = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onGestureBegin(f paramf);
    
    public abstract void onGestureEnd(f paramf);
    
    public abstract void onGestureUpdate(f paramf);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/widget/frescoview/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */