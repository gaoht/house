package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.support.v4.util.LongSparseArray;

public class al
  extends p
{
  private final String b;
  private final LongSparseArray<LinearGradient> c = new LongSparseArray();
  private final LongSparseArray<RadialGradient> d = new LongSparseArray();
  private final RectF e = new RectF();
  private final am f;
  private final int g;
  private final au<ag> h;
  private final au<PointF> i;
  private final au<PointF> j;
  
  al(ax paramax, o paramo, ak paramak)
  {
    super(paramax, paramo, paramak.h().a(), paramak.i().a(), paramak.d(), paramak.g(), paramak.j(), paramak.k());
    this.b = paramak.a();
    this.f = paramak.b();
    this.g = ((int)(paramax.getComposition().getDuration() / 32L));
    this.h = paramak.c().createAnimation();
    this.h.a(this);
    paramo.a(this.h);
    this.i = paramak.e().createAnimation();
    this.i.a(this);
    paramo.a(this.i);
    this.j = paramak.f().createAnimation();
    this.j.a(this);
    paramo.a(this.j);
  }
  
  private LinearGradient a()
  {
    int k = c();
    Object localObject1 = (LinearGradient)this.c.get(k);
    if (localObject1 != null) {
      return (LinearGradient)localObject1;
    }
    localObject1 = (PointF)this.i.getValue();
    PointF localPointF = (PointF)this.j.getValue();
    Object localObject2 = (ag)this.h.getValue();
    int[] arrayOfInt = ((ag)localObject2).b();
    localObject2 = ((ag)localObject2).a();
    int m = (int)(this.e.left + this.e.width() / 2.0F + ((PointF)localObject1).x);
    float f1 = this.e.top;
    float f2 = this.e.height() / 2.0F;
    int n = (int)(((PointF)localObject1).y + (f1 + f2));
    int i1 = (int)(this.e.left + this.e.width() / 2.0F + localPointF.x);
    int i2 = (int)(this.e.top + this.e.height() / 2.0F + localPointF.y);
    localObject1 = new LinearGradient(m, n, i1, i2, arrayOfInt, (float[])localObject2, Shader.TileMode.CLAMP);
    this.c.put(k, localObject1);
    return (LinearGradient)localObject1;
  }
  
  private RadialGradient b()
  {
    int k = c();
    Object localObject1 = (RadialGradient)this.d.get(k);
    if (localObject1 != null) {
      return (RadialGradient)localObject1;
    }
    localObject1 = (PointF)this.i.getValue();
    PointF localPointF = (PointF)this.j.getValue();
    Object localObject2 = (ag)this.h.getValue();
    int[] arrayOfInt = ((ag)localObject2).b();
    localObject2 = ((ag)localObject2).a();
    int m = (int)(this.e.left + this.e.width() / 2.0F + ((PointF)localObject1).x);
    float f1 = this.e.top;
    float f2 = this.e.height() / 2.0F;
    int n = (int)(((PointF)localObject1).y + (f1 + f2));
    int i1 = (int)(this.e.left + this.e.width() / 2.0F + localPointF.x);
    f1 = this.e.top;
    f2 = this.e.height() / 2.0F;
    int i2 = (int)(localPointF.y + (f1 + f2));
    f1 = (float)Math.hypot(i1 - m, i2 - n);
    localObject1 = new RadialGradient(m, n, f1, arrayOfInt, (float[])localObject2, Shader.TileMode.CLAMP);
    this.d.put(k, localObject1);
    return (RadialGradient)localObject1;
  }
  
  private int c()
  {
    int m = Math.round(this.i.b() * this.g);
    int i1 = Math.round(this.j.b() * this.g);
    int n = Math.round(this.h.b() * this.g);
    int k = 17;
    if (m != 0) {
      k = m * 527;
    }
    m = k;
    if (i1 != 0) {
      m = k * 31 * i1;
    }
    k = m;
    if (n != 0) {
      k = m * 31 * n;
    }
    return k;
  }
  
  public void addColorFilter(String paramString1, String paramString2, ColorFilter paramColorFilter) {}
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    getBounds(this.e, paramMatrix);
    if (this.f == am.a) {
      this.a.setShader(a());
    }
    for (;;)
    {
      super.draw(paramCanvas, paramMatrix, paramInt);
      return;
      this.a.setShader(b());
    }
  }
  
  public String getName()
  {
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */