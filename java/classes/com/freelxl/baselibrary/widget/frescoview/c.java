package com.freelxl.baselibrary.widget.frescoview;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.facebook.common.logging.FLog;

public class c
  implements f.a, g
{
  private static final Class<?> a = c.class;
  private static final RectF b = new RectF(0.0F, 0.0F, 1.0F, 1.0F);
  private f c;
  private g.a d = null;
  private boolean e = false;
  private boolean f = false;
  private boolean g = true;
  private boolean h = true;
  private float i = 1.0F;
  private float j = 2.0F;
  private final RectF k = new RectF();
  private final RectF l = new RectF();
  private final RectF m = new RectF();
  private final Matrix n = new Matrix();
  private final Matrix o = new Matrix();
  private final Matrix p = new Matrix();
  private final float[] q = new float[9];
  private final RectF r = new RectF();
  private boolean s;
  
  public c(f paramf)
  {
    this.c = paramf;
    this.c.setListener(this);
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.min(Math.max(paramFloat2, paramFloat1), paramFloat3);
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    float f1 = paramFloat2 - paramFloat1;
    if (f1 < Math.min(paramFloat5 - paramFloat3, paramFloat4 - paramFloat5) * 2.0F) {
      return paramFloat5 - (paramFloat2 + paramFloat1) / 2.0F;
    }
    if (f1 < paramFloat4 - paramFloat3)
    {
      if (paramFloat5 < (paramFloat3 + paramFloat4) / 2.0F) {
        return paramFloat3 - paramFloat1;
      }
      return paramFloat4 - paramFloat2;
    }
    if (paramFloat1 > paramFloat3) {
      return paramFloat3 - paramFloat1;
    }
    if (paramFloat2 < paramFloat4) {
      return paramFloat4 - paramFloat2;
    }
    return 0.0F;
  }
  
  private float a(Matrix paramMatrix)
  {
    paramMatrix.getValues(this.q);
    return this.q[0];
  }
  
  private void a()
  {
    this.o.mapRect(this.m, this.l);
    if ((this.d != null) && (isEnabled())) {
      this.d.onTransformChanged(this.o);
    }
  }
  
  private void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt)
  {
    int i1 = 0;
    while (i1 < paramInt)
    {
      paramArrayOfFloat1[(i1 * 2 + 0)] = ((paramArrayOfFloat2[(i1 * 2 + 0)] - this.l.left) / this.l.width());
      paramArrayOfFloat1[(i1 * 2 + 1)] = ((paramArrayOfFloat2[(i1 * 2 + 1)] - this.l.top) / this.l.height());
      i1 += 1;
    }
  }
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  private boolean a(Matrix paramMatrix, float paramFloat)
  {
    paramMatrix.getValues(this.q);
    paramMatrix = this.q;
    paramMatrix[0] -= 1.0F;
    paramMatrix = this.q;
    paramMatrix[4] -= 1.0F;
    paramMatrix = this.q;
    paramMatrix[8] -= 1.0F;
    int i1 = 0;
    while (i1 < 9)
    {
      if (Math.abs(this.q[i1]) > paramFloat) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  private boolean a(Matrix paramMatrix, float paramFloat1, float paramFloat2, int paramInt)
  {
    if (!a(paramInt, 4)) {}
    float f2;
    do
    {
      return false;
      f1 = a(paramMatrix);
      f2 = a(f1, this.i, this.j);
    } while (f2 == f1);
    float f1 = f2 / f1;
    paramMatrix.postScale(f1, f1, paramFloat1, paramFloat2);
    return true;
  }
  
  private void b(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt)
  {
    int i1 = 0;
    while (i1 < paramInt)
    {
      paramArrayOfFloat1[(i1 * 2 + 0)] = (paramArrayOfFloat2[(i1 * 2 + 0)] * this.l.width() + this.l.left);
      paramArrayOfFloat1[(i1 * 2 + 1)] = (paramArrayOfFloat2[(i1 * 2 + 1)] * this.l.height() + this.l.top);
      i1 += 1;
    }
  }
  
  private boolean b(Matrix paramMatrix, int paramInt)
  {
    if (!a(paramInt, 3)) {
      return false;
    }
    RectF localRectF = this.r;
    localRectF.set(this.l);
    paramMatrix.mapRect(localRectF);
    float f1;
    if (a(paramInt, 1))
    {
      f1 = a(localRectF.left, localRectF.right, this.k.left, this.k.right, this.l.centerX());
      if (!a(paramInt, 2)) {
        break label149;
      }
    }
    label149:
    for (float f2 = a(localRectF.top, localRectF.bottom, this.k.top, this.k.bottom, this.l.centerY());; f2 = 0.0F)
    {
      if ((f1 == 0.0F) && (f2 == 0.0F)) {
        break label155;
      }
      paramMatrix.postTranslate(f1, f2);
      return true;
      f1 = 0.0F;
      break;
    }
    label155:
    return false;
  }
  
  public static c newInstance()
  {
    return new c(f.newInstance());
  }
  
  protected boolean a(Matrix paramMatrix, float paramFloat, PointF paramPointF1, PointF paramPointF2, int paramInt)
  {
    float[] arrayOfFloat = this.q;
    arrayOfFloat[0] = paramPointF1.x;
    arrayOfFloat[1] = paramPointF1.y;
    b(arrayOfFloat, arrayOfFloat, 1);
    float f1 = paramPointF2.x;
    float f2 = arrayOfFloat[0];
    float f3 = paramPointF2.y;
    float f4 = arrayOfFloat[1];
    paramMatrix.setScale(paramFloat, paramFloat, arrayOfFloat[0], arrayOfFloat[1]);
    boolean bool = a(paramMatrix, arrayOfFloat[0], arrayOfFloat[1], paramInt);
    paramMatrix.postTranslate(f1 - f2, f3 - f4);
    return bool | false | b(paramMatrix, paramInt);
  }
  
  protected boolean a(Matrix paramMatrix, int paramInt)
  {
    f localf = this.c;
    paramMatrix.set(this.n);
    if (this.f) {
      paramMatrix.postRotate(localf.getRotation() * 57.29578F, localf.getPivotX(), localf.getPivotY());
    }
    if (this.g)
    {
      float f1 = localf.getScale();
      paramMatrix.postScale(f1, f1, localf.getPivotX(), localf.getPivotY());
    }
    boolean bool = a(paramMatrix, localf.getPivotX(), localf.getPivotY(), paramInt);
    if (this.h) {
      paramMatrix.postTranslate(localf.getTranslationX(), localf.getTranslationY());
    }
    return b(paramMatrix, paramInt) | false | bool;
  }
  
  protected f f()
  {
    return this.c;
  }
  
  public RectF getImageBounds()
  {
    return this.l;
  }
  
  public void getImageRelativeToViewAbsoluteTransform(Matrix paramMatrix)
  {
    paramMatrix.setRectToRect(b, this.m, Matrix.ScaleToFit.FILL);
  }
  
  public float getMaxScaleFactor()
  {
    return this.j;
  }
  
  public float getMinScaleFactor()
  {
    return this.i;
  }
  
  public float getScaleFactor()
  {
    return a(this.o);
  }
  
  public Matrix getTransform()
  {
    return this.o;
  }
  
  public RectF getViewBounds()
  {
    return this.k;
  }
  
  public boolean isEnabled()
  {
    return this.e;
  }
  
  public boolean isIdentity()
  {
    return a(this.o, 0.001F);
  }
  
  public boolean isRotationEnabled()
  {
    return this.f;
  }
  
  public boolean isScaleEnabled()
  {
    return this.g;
  }
  
  public boolean isTranslationEnabled()
  {
    return this.h;
  }
  
  public PointF mapImageToView(PointF paramPointF)
  {
    float[] arrayOfFloat = this.q;
    arrayOfFloat[0] = paramPointF.x;
    arrayOfFloat[1] = paramPointF.y;
    b(arrayOfFloat, arrayOfFloat, 1);
    this.o.mapPoints(arrayOfFloat, 0, arrayOfFloat, 0, 1);
    return new PointF(arrayOfFloat[0], arrayOfFloat[1]);
  }
  
  public PointF mapViewToImage(PointF paramPointF)
  {
    float[] arrayOfFloat = this.q;
    arrayOfFloat[0] = paramPointF.x;
    arrayOfFloat[1] = paramPointF.y;
    this.o.invert(this.p);
    this.p.mapPoints(arrayOfFloat, 0, arrayOfFloat, 0, 1);
    a(arrayOfFloat, arrayOfFloat, 1);
    return new PointF(arrayOfFloat[0], arrayOfFloat[1]);
  }
  
  public void onGestureBegin(f paramf)
  {
    FLog.v(a, "onGestureBegin");
    this.n.set(this.o);
    this.s = false;
  }
  
  public void onGestureEnd(f paramf)
  {
    FLog.v(a, "onGestureEnd");
  }
  
  public void onGestureUpdate(f paramf)
  {
    FLog.v(a, "onGestureUpdate");
    boolean bool = a(this.o, 7);
    a();
    if (bool) {
      this.c.restartGesture();
    }
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      this.s = bool;
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    FLog.v(a, "onTouchEvent: action: ", Integer.valueOf(paramMotionEvent.getAction()));
    if (this.e) {
      return this.c.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public void reset()
  {
    FLog.v(a, "reset");
    this.c.reset();
    this.n.reset();
    this.o.reset();
    a();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (!paramBoolean) {
      reset();
    }
  }
  
  public void setImageBounds(RectF paramRectF)
  {
    if (!paramRectF.equals(this.l))
    {
      this.l.set(paramRectF);
      a();
    }
  }
  
  public void setListener(g.a parama)
  {
    this.d = parama;
  }
  
  public void setMaxScaleFactor(float paramFloat)
  {
    this.j = paramFloat;
  }
  
  public void setMinScaleFactor(float paramFloat)
  {
    this.i = paramFloat;
  }
  
  public void setRotationEnabled(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setScaleEnabled(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setTransform(Matrix paramMatrix)
  {
    FLog.v(a, "setTransform");
    this.o.set(paramMatrix);
    a();
  }
  
  public void setTranslationEnabled(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setViewBounds(RectF paramRectF)
  {
    this.k.set(paramRectF);
  }
  
  public boolean wasTransformCorrected()
  {
    return !this.s;
  }
  
  public void zoomToPoint(float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    FLog.v(a, "zoomToPoint");
    a(this.o, paramFloat, paramPointF1, paramPointF2, 7);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/widget/frescoview/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */