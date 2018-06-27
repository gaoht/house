package com.d.c.a;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class a
  extends Animation
{
  public static final boolean a;
  private static final WeakHashMap<View, a> b;
  private final WeakReference<View> c;
  private final Camera d = new Camera();
  private boolean e;
  private float f = 1.0F;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l = 1.0F;
  private float m = 1.0F;
  private float n;
  private float o;
  private final RectF p = new RectF();
  private final RectF q = new RectF();
  private final Matrix r = new Matrix();
  
  static
  {
    if (Integer.valueOf(Build.VERSION.SDK).intValue() < 11) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      b = new WeakHashMap();
      return;
    }
  }
  
  private a(View paramView)
  {
    setDuration(0L);
    setFillAfter(true);
    paramView.setAnimation(this);
    this.c = new WeakReference(paramView);
  }
  
  private void a()
  {
    View localView = (View)this.c.get();
    if (localView != null) {
      a(this.p, localView);
    }
  }
  
  private void a(Matrix paramMatrix, View paramView)
  {
    float f3 = paramView.getWidth();
    float f4 = paramView.getHeight();
    boolean bool = this.e;
    float f1;
    if (bool)
    {
      f1 = this.g;
      if (!bool) {
        break label226;
      }
    }
    label226:
    for (float f2 = this.h;; f2 = f4 / 2.0F)
    {
      float f5 = this.i;
      float f6 = this.j;
      float f7 = this.k;
      if ((f5 != 0.0F) || (f6 != 0.0F) || (f7 != 0.0F))
      {
        paramView = this.d;
        paramView.save();
        paramView.rotateX(f5);
        paramView.rotateY(f6);
        paramView.rotateZ(-f7);
        paramView.getMatrix(paramMatrix);
        paramView.restore();
        paramMatrix.preTranslate(-f1, -f2);
        paramMatrix.postTranslate(f1, f2);
      }
      f5 = this.l;
      f6 = this.m;
      if ((f5 != 1.0F) || (f6 != 1.0F))
      {
        paramMatrix.postScale(f5, f6);
        paramMatrix.postTranslate(-(f1 / f3) * (f5 * f3 - f3), -(f2 / f4) * (f6 * f4 - f4));
      }
      paramMatrix.postTranslate(this.n, this.o);
      return;
      f1 = f3 / 2.0F;
      break;
    }
  }
  
  private void a(RectF paramRectF, View paramView)
  {
    paramRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    Matrix localMatrix = this.r;
    localMatrix.reset();
    a(localMatrix, paramView);
    this.r.mapRect(paramRectF);
    paramRectF.offset(paramView.getLeft(), paramView.getTop());
    float f1;
    if (paramRectF.right < paramRectF.left)
    {
      f1 = paramRectF.right;
      paramRectF.right = paramRectF.left;
      paramRectF.left = f1;
    }
    if (paramRectF.bottom < paramRectF.top)
    {
      f1 = paramRectF.top;
      paramRectF.top = paramRectF.bottom;
      paramRectF.bottom = f1;
    }
  }
  
  private void b()
  {
    View localView = (View)this.c.get();
    if ((localView == null) || (localView.getParent() == null)) {
      return;
    }
    RectF localRectF = this.q;
    a(localRectF, localView);
    localRectF.union(this.p);
    ((View)localView.getParent()).invalidate((int)Math.floor(localRectF.left), (int)Math.floor(localRectF.top), (int)Math.ceil(localRectF.right), (int)Math.ceil(localRectF.bottom));
  }
  
  public static a wrap(View paramView)
  {
    a locala2 = (a)b.get(paramView);
    a locala1;
    if (locala2 != null)
    {
      locala1 = locala2;
      if (locala2 == paramView.getAnimation()) {}
    }
    else
    {
      locala1 = new a(paramView);
      b.put(paramView, locala1);
    }
    return locala1;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    View localView = (View)this.c.get();
    if (localView != null)
    {
      paramTransformation.setAlpha(this.f);
      a(paramTransformation.getMatrix(), localView);
    }
  }
  
  public float getAlpha()
  {
    return this.f;
  }
  
  public float getPivotX()
  {
    return this.g;
  }
  
  public float getPivotY()
  {
    return this.h;
  }
  
  public float getRotation()
  {
    return this.k;
  }
  
  public float getRotationX()
  {
    return this.i;
  }
  
  public float getRotationY()
  {
    return this.j;
  }
  
  public float getScaleX()
  {
    return this.l;
  }
  
  public float getScaleY()
  {
    return this.m;
  }
  
  public int getScrollX()
  {
    View localView = (View)this.c.get();
    if (localView == null) {
      return 0;
    }
    return localView.getScrollX();
  }
  
  public int getScrollY()
  {
    View localView = (View)this.c.get();
    if (localView == null) {
      return 0;
    }
    return localView.getScrollY();
  }
  
  public float getTranslationX()
  {
    return this.n;
  }
  
  public float getTranslationY()
  {
    return this.o;
  }
  
  public float getX()
  {
    View localView = (View)this.c.get();
    if (localView == null) {
      return 0.0F;
    }
    return localView.getLeft() + this.n;
  }
  
  public float getY()
  {
    View localView = (View)this.c.get();
    if (localView == null) {
      return 0.0F;
    }
    return localView.getTop() + this.o;
  }
  
  public void setAlpha(float paramFloat)
  {
    if (this.f != paramFloat)
    {
      this.f = paramFloat;
      View localView = (View)this.c.get();
      if (localView != null) {
        localView.invalidate();
      }
    }
  }
  
  public void setPivotX(float paramFloat)
  {
    if ((!this.e) || (this.g != paramFloat))
    {
      a();
      this.e = true;
      this.g = paramFloat;
      b();
    }
  }
  
  public void setPivotY(float paramFloat)
  {
    if ((!this.e) || (this.h != paramFloat))
    {
      a();
      this.e = true;
      this.h = paramFloat;
      b();
    }
  }
  
  public void setRotation(float paramFloat)
  {
    if (this.k != paramFloat)
    {
      a();
      this.k = paramFloat;
      b();
    }
  }
  
  public void setRotationX(float paramFloat)
  {
    if (this.i != paramFloat)
    {
      a();
      this.i = paramFloat;
      b();
    }
  }
  
  public void setRotationY(float paramFloat)
  {
    if (this.j != paramFloat)
    {
      a();
      this.j = paramFloat;
      b();
    }
  }
  
  public void setScaleX(float paramFloat)
  {
    if (this.l != paramFloat)
    {
      a();
      this.l = paramFloat;
      b();
    }
  }
  
  public void setScaleY(float paramFloat)
  {
    if (this.m != paramFloat)
    {
      a();
      this.m = paramFloat;
      b();
    }
  }
  
  public void setScrollX(int paramInt)
  {
    View localView = (View)this.c.get();
    if (localView != null) {
      localView.scrollTo(paramInt, localView.getScrollY());
    }
  }
  
  public void setScrollY(int paramInt)
  {
    View localView = (View)this.c.get();
    if (localView != null) {
      localView.scrollTo(localView.getScrollX(), paramInt);
    }
  }
  
  public void setTranslationX(float paramFloat)
  {
    if (this.n != paramFloat)
    {
      a();
      this.n = paramFloat;
      b();
    }
  }
  
  public void setTranslationY(float paramFloat)
  {
    if (this.o != paramFloat)
    {
      a();
      this.o = paramFloat;
      b();
    }
  }
  
  public void setX(float paramFloat)
  {
    View localView = (View)this.c.get();
    if (localView != null) {
      setTranslationX(paramFloat - localView.getLeft());
    }
  }
  
  public void setY(float paramFloat)
  {
    View localView = (View)this.c.get();
    if (localView != null) {
      setTranslationY(paramFloat - localView.getTop());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/d/c/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */