package com.ziroom.ziroomcustomer.home.view;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

public class e
  extends d.e
{
  private static final Handler a = new Handler(Looper.getMainLooper());
  private long b;
  private boolean c;
  private final int[] d = new int[2];
  private final float[] e = new float[2];
  private int f = 200;
  private Interpolator g;
  private d.e.a h;
  private d.e.b i;
  private float j;
  private final Runnable k = new Runnable()
  {
    public void run()
    {
      e.a(e.this);
    }
  };
  
  private void a()
  {
    if (this.c)
    {
      float f2 = (float)(SystemClock.uptimeMillis() - this.b) / this.f;
      float f1 = f2;
      if (this.g != null) {
        f1 = this.g.getInterpolation(f2);
      }
      this.j = f1;
      if (this.i != null) {
        this.i.onAnimationUpdate();
      }
      if (SystemClock.uptimeMillis() >= this.b + this.f)
      {
        this.c = false;
        if (this.h != null) {
          this.h.onAnimationEnd();
        }
      }
    }
    if (this.c) {
      a.postDelayed(this.k, 10L);
    }
  }
  
  public void cancel()
  {
    this.c = false;
    a.removeCallbacks(this.k);
    if (this.h != null) {
      this.h.onAnimationCancel();
    }
  }
  
  public void end()
  {
    if (this.c)
    {
      this.c = false;
      a.removeCallbacks(this.k);
      this.j = 1.0F;
      if (this.i != null) {
        this.i.onAnimationUpdate();
      }
      if (this.h != null) {
        this.h.onAnimationEnd();
      }
    }
  }
  
  public float getAnimatedFloatValue()
  {
    return a.a(this.e[0], this.e[1], getAnimatedFraction());
  }
  
  public float getAnimatedFraction()
  {
    return this.j;
  }
  
  public int getAnimatedIntValue()
  {
    return a.a(this.d[0], this.d[1], getAnimatedFraction());
  }
  
  public boolean isRunning()
  {
    return this.c;
  }
  
  public void setDuration(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setFloatValues(float paramFloat1, float paramFloat2)
  {
    this.e[0] = paramFloat1;
    this.e[1] = paramFloat2;
  }
  
  public void setIntValues(int paramInt1, int paramInt2)
  {
    this.d[0] = paramInt1;
    this.d[1] = paramInt2;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.g = paramInterpolator;
  }
  
  public void setListener(d.e.a parama)
  {
    this.h = parama;
  }
  
  public void setUpdateListener(d.e.b paramb)
  {
    this.i = paramb;
  }
  
  public void start()
  {
    if (!this.c)
    {
      if (this.g == null) {
        this.g = new AccelerateDecelerateInterpolator();
      }
      this.b = SystemClock.uptimeMillis();
      this.c = true;
      if (this.h != null) {
        this.h.onAnimationStart();
      }
      a.postDelayed(this.k, 10L);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/view/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */