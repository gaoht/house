package com.freelxl.baselibrary.widget.frescoview;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.facebook.common.logging.FLog;

public abstract class a
  extends c
{
  private boolean a;
  private final float[] b = new float[9];
  private final float[] c = new float[9];
  private final float[] d = new float[9];
  private final Matrix e = new Matrix();
  private final Matrix f = new Matrix();
  
  public a(f paramf)
  {
    super(paramf);
  }
  
  private void a(Matrix paramMatrix)
  {
    FLog.v(e(), "setTransformImmediate");
    stopAnimation();
    this.f.set(paramMatrix);
    super.setTransform(paramMatrix);
    f().restartGesture();
  }
  
  protected void a(Matrix paramMatrix, float paramFloat)
  {
    int i = 0;
    while (i < 9)
    {
      this.d[i] = ((1.0F - paramFloat) * this.b[i] + this.c[i] * paramFloat);
      i += 1;
    }
    paramMatrix.setValues(this.d);
  }
  
  protected void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  protected boolean a()
  {
    return this.a;
  }
  
  protected float[] b()
  {
    return this.b;
  }
  
  protected float[] c()
  {
    return this.c;
  }
  
  protected Matrix d()
  {
    return this.f;
  }
  
  protected abstract Class<?> e();
  
  public boolean isIdentity()
  {
    return (!a()) && (super.isIdentity());
  }
  
  public void onGestureBegin(f paramf)
  {
    FLog.v(e(), "onGestureBegin");
    stopAnimation();
    super.onGestureBegin(paramf);
  }
  
  public void onGestureUpdate(f paramf)
  {
    Class localClass = e();
    if (a()) {}
    for (String str = "(ignored)";; str = "")
    {
      FLog.v(localClass, "onGestureUpdate %s", str);
      if (!a()) {
        break;
      }
      return;
    }
    super.onGestureUpdate(paramf);
  }
  
  public void reset()
  {
    FLog.v(e(), "reset");
    stopAnimation();
    this.f.reset();
    this.e.reset();
    super.reset();
  }
  
  public void setTransform(Matrix paramMatrix, long paramLong, Runnable paramRunnable)
  {
    FLog.v(e(), "setTransform: duration %d ms", Long.valueOf(paramLong));
    if (paramLong <= 0L)
    {
      a(paramMatrix);
      return;
    }
    setTransformAnimated(paramMatrix, paramLong, paramRunnable);
  }
  
  public abstract void setTransformAnimated(Matrix paramMatrix, long paramLong, Runnable paramRunnable);
  
  protected abstract void stopAnimation();
  
  public void zoomToPoint(float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    zoomToPoint(paramFloat, paramPointF1, paramPointF2, 7, 0L, null);
  }
  
  public void zoomToPoint(float paramFloat, PointF paramPointF1, PointF paramPointF2, int paramInt, long paramLong, Runnable paramRunnable)
  {
    FLog.v(e(), "zoomToPoint: duration %d ms", Long.valueOf(paramLong));
    a(this.e, paramFloat, paramPointF1, paramPointF2, paramInt);
    setTransform(this.e, paramLong, paramRunnable);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/widget/frescoview/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */