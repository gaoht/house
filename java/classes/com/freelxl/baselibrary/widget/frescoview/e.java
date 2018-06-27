package com.freelxl.baselibrary.widget.frescoview;

import android.view.MotionEvent;

public class e
{
  static float a = 0.0F;
  static float b = 0.0F;
  static float c = 0.0F;
  private boolean d;
  private int e;
  private int f;
  private final int[] g = new int[2];
  private final float[] h = new float[2];
  private final float[] i = new float[2];
  private final float[] j = new float[2];
  private final float[] k = new float[2];
  private a l = null;
  
  public e()
  {
    reset();
  }
  
  private static int a(MotionEvent paramMotionEvent)
  {
    int n = paramMotionEvent.getPointerCount();
    int i1 = paramMotionEvent.getActionMasked();
    int m;
    if (i1 != 1)
    {
      m = n;
      if (i1 != 6) {}
    }
    else
    {
      m = n - 1;
    }
    return m;
  }
  
  private int a(MotionEvent paramMotionEvent, int paramInt)
  {
    int m = paramMotionEvent.getPointerCount();
    int n = paramMotionEvent.getActionMasked();
    int i1 = paramMotionEvent.getActionIndex();
    if (((n == 1) || (n == 6)) && (paramInt >= i1)) {
      paramInt += 1;
    }
    for (;;)
    {
      if (paramInt < m) {
        return paramInt;
      }
      return -1;
    }
  }
  
  private void b()
  {
    if (!this.d)
    {
      if (this.l != null) {
        this.l.onGestureBegin(this);
      }
      this.d = true;
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    int m = 0;
    this.e = 0;
    if (m < 2)
    {
      int n = a(paramMotionEvent, m);
      if (n == -1) {
        this.g[m] = -1;
      }
      for (;;)
      {
        m += 1;
        break;
        this.g[m] = paramMotionEvent.getPointerId(n);
        float[] arrayOfFloat1 = this.j;
        float[] arrayOfFloat2 = this.h;
        float f1 = paramMotionEvent.getX(n);
        arrayOfFloat2[m] = f1;
        arrayOfFloat1[m] = f1;
        arrayOfFloat1 = this.k;
        arrayOfFloat2 = this.i;
        f1 = paramMotionEvent.getY(n);
        arrayOfFloat2[m] = f1;
        arrayOfFloat1[m] = f1;
        this.e += 1;
      }
    }
  }
  
  private void c()
  {
    if (this.d)
    {
      this.d = false;
      if (this.l != null) {
        this.l.onGestureEnd(this);
      }
    }
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    int m = 0;
    while (m < 2)
    {
      int n = paramMotionEvent.findPointerIndex(this.g[m]);
      if (n != -1)
      {
        this.j[m] = paramMotionEvent.getX(n);
        this.k[m] = paramMotionEvent.getY(n);
      }
      m += 1;
    }
  }
  
  public static e newInstance()
  {
    return new e();
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public float[] getCurrentX()
  {
    return this.j;
  }
  
  public float[] getCurrentY()
  {
    return this.k;
  }
  
  public int getNewPointerCount()
  {
    return this.f;
  }
  
  public int getPointerCount()
  {
    return this.e;
  }
  
  public float[] getStartX()
  {
    return this.h;
  }
  
  public float[] getStartY()
  {
    return this.i;
  }
  
  public boolean isGestureInProgress()
  {
    return this.d;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      bool = true;
      do
      {
        return bool;
        if ((this.e == 1) && ((a != paramMotionEvent.getX()) || (b != paramMotionEvent.getY())))
        {
          float f1 = paramMotionEvent.getX() - a;
          float f2 = paramMotionEvent.getY() - b;
          double d1 = c;
          c = (float)(Math.sqrt(f1 * f1 + f2 * f2) + d1);
        }
        a = paramMotionEvent.getX();
        b = paramMotionEvent.getY();
        c(paramMotionEvent);
        if ((!this.d) && (this.e > 0) && (a())) {
          b();
        }
        if ((!this.d) || (this.l == null)) {
          break;
        }
        this.l.onGestureUpdate(this);
        break;
        c = 0.0F;
        this.f = a(paramMotionEvent);
        c();
        b(paramMotionEvent);
        if ((this.e == 1) && (c == 0.0F))
        {
          a = paramMotionEvent.getX();
          b = paramMotionEvent.getY();
        }
      } while ((this.e <= 1) && (c < 8.0F));
      if ((this.e > 0) && (a()))
      {
        b();
        continue;
        this.f = 0;
        c();
        reset();
      }
    }
  }
  
  public void reset()
  {
    int m = 0;
    this.d = false;
    this.e = 0;
    while (m < 2)
    {
      this.g[m] = -1;
      m += 1;
    }
  }
  
  public void restartGesture()
  {
    if (!this.d) {
      return;
    }
    c();
    int m = 0;
    while (m < 2)
    {
      this.h[m] = this.j[m];
      this.i[m] = this.k[m];
      m += 1;
    }
    b();
  }
  
  public void setListener(a parama)
  {
    this.l = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onGestureBegin(e parame);
    
    public abstract void onGestureEnd(e parame);
    
    public abstract void onGestureUpdate(e parame);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/widget/frescoview/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */