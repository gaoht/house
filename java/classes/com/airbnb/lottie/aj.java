package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.support.v4.util.LongSparseArray;
import java.util.ArrayList;
import java.util.List;

class aj
  implements aa, n.a
{
  private final String a;
  private final LongSparseArray<LinearGradient> b = new LongSparseArray();
  private final LongSparseArray<RadialGradient> c = new LongSparseArray();
  private final Matrix d = new Matrix();
  private final Path e = new Path();
  private final Paint f = new Paint(1);
  private final RectF g = new RectF();
  private final List<bg> h = new ArrayList();
  private final am i;
  private final au<ag> j;
  private final au<Integer> k;
  private final au<PointF> l;
  private final au<PointF> m;
  private final ax n;
  private final int o;
  
  aj(ax paramax, o paramo, ai paramai)
  {
    this.a = paramai.a();
    this.n = paramax;
    this.i = paramai.b();
    this.e.setFillType(paramai.c());
    this.o = ((int)(paramax.getComposition().getDuration() / 32L));
    this.j = paramai.d().createAnimation();
    this.j.a(this);
    paramo.a(this.j);
    this.k = paramai.e().createAnimation();
    this.k.a(this);
    paramo.a(this.k);
    this.l = paramai.f().createAnimation();
    this.l.a(this);
    paramo.a(this.l);
    this.m = paramai.g().createAnimation();
    this.m.a(this);
    paramo.a(this.m);
  }
  
  private LinearGradient a()
  {
    int i1 = c();
    Object localObject1 = (LinearGradient)this.b.get(i1);
    if (localObject1 != null) {
      return (LinearGradient)localObject1;
    }
    localObject1 = (PointF)this.l.getValue();
    PointF localPointF = (PointF)this.m.getValue();
    Object localObject2 = (ag)this.j.getValue();
    int[] arrayOfInt = ((ag)localObject2).b();
    localObject2 = ((ag)localObject2).a();
    localObject1 = new LinearGradient(((PointF)localObject1).x, ((PointF)localObject1).y, localPointF.x, localPointF.y, arrayOfInt, (float[])localObject2, Shader.TileMode.CLAMP);
    this.b.put(i1, localObject1);
    return (LinearGradient)localObject1;
  }
  
  private RadialGradient b()
  {
    int i1 = c();
    Object localObject1 = (RadialGradient)this.c.get(i1);
    if (localObject1 != null) {
      return (RadialGradient)localObject1;
    }
    localObject1 = (PointF)this.l.getValue();
    PointF localPointF = (PointF)this.m.getValue();
    Object localObject2 = (ag)this.j.getValue();
    int[] arrayOfInt = ((ag)localObject2).b();
    localObject2 = ((ag)localObject2).a();
    float f1 = ((PointF)localObject1).x;
    float f2 = ((PointF)localObject1).y;
    float f3 = localPointF.x;
    float f4 = localPointF.y;
    localObject1 = new RadialGradient(f1, f2, (float)Math.hypot(f3 - f1, f4 - f2), arrayOfInt, (float[])localObject2, Shader.TileMode.CLAMP);
    this.c.put(i1, localObject1);
    return (RadialGradient)localObject1;
  }
  
  private int c()
  {
    int i2 = Math.round(this.l.b() * this.o);
    int i4 = Math.round(this.m.b() * this.o);
    int i3 = Math.round(this.j.b() * this.o);
    int i1 = 17;
    if (i2 != 0) {
      i1 = i2 * 527;
    }
    i2 = i1;
    if (i4 != 0) {
      i2 = i1 * 31 * i4;
    }
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 * 31 * i3;
    }
    return i1;
  }
  
  public void addColorFilter(String paramString1, String paramString2, ColorFilter paramColorFilter) {}
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.e.reset();
    int i1 = 0;
    while (i1 < this.h.size())
    {
      this.e.addPath(((bg)this.h.get(i1)).getPath(), paramMatrix);
      i1 += 1;
    }
    this.e.computeBounds(this.g, false);
    if (this.i == am.a) {}
    for (Object localObject = a();; localObject = b())
    {
      this.d.set(paramMatrix);
      ((Shader)localObject).setLocalMatrix(this.d);
      this.f.setShader((Shader)localObject);
      float f1 = paramInt / 255.0F;
      paramInt = (int)(((Integer)this.k.getValue()).intValue() * f1 / 100.0F * 255.0F);
      this.f.setAlpha(paramInt);
      paramCanvas.drawPath(this.e, this.f);
      return;
    }
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix)
  {
    this.e.reset();
    int i1 = 0;
    while (i1 < this.h.size())
    {
      this.e.addPath(((bg)this.h.get(i1)).getPath(), paramMatrix);
      i1 += 1;
    }
    this.e.computeBounds(paramRectF, false);
    paramRectF.set(paramRectF.left - 1.0F, paramRectF.top - 1.0F, paramRectF.right + 1.0F, paramRectF.bottom + 1.0F);
  }
  
  public String getName()
  {
    return this.a;
  }
  
  public void onValueChanged()
  {
    this.n.invalidateSelf();
  }
  
  public void setContents(List<x> paramList1, List<x> paramList2)
  {
    int i1 = 0;
    while (i1 < paramList2.size())
    {
      paramList1 = (x)paramList2.get(i1);
      if ((paramList1 instanceof bg)) {
        this.h.add((bg)paramList1);
      }
      i1 += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */