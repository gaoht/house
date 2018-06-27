package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

abstract class p
  implements aa, n.a
{
  final Paint a = new Paint(1);
  private final PathMeasure b = new PathMeasure();
  private final Path c = new Path();
  private final Path d = new Path();
  private final RectF e = new RectF();
  private final ax f;
  private final List<a> g = new ArrayList();
  private final float[] h;
  private final n<?, Float> i;
  private final n<?, Integer> j;
  private final List<n<?, Float>> k;
  private final n<?, Float> l;
  
  p(ax paramax, o paramo, Paint.Cap paramCap, Paint.Join paramJoin, d paramd, b paramb1, List<b> paramList, b paramb2)
  {
    this.f = paramax;
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeCap(paramCap);
    this.a.setStrokeJoin(paramJoin);
    this.j = paramd.createAnimation();
    this.i = paramb1.createAnimation();
    if (paramb2 == null) {}
    for (this.l = null;; this.l = paramb2.createAnimation())
    {
      this.k = new ArrayList(paramList.size());
      this.h = new float[paramList.size()];
      m = 0;
      while (m < paramList.size())
      {
        this.k.add(((b)paramList.get(m)).createAnimation());
        m += 1;
      }
    }
    paramo.a(this.j);
    paramo.a(this.i);
    int m = 0;
    while (m < this.k.size())
    {
      paramo.a((n)this.k.get(m));
      m += 1;
    }
    if (this.l != null) {
      paramo.a(this.l);
    }
    this.j.a(this);
    this.i.a(this);
    m = n;
    while (m < paramList.size())
    {
      ((n)this.k.get(m)).a(this);
      m += 1;
    }
    if (this.l != null) {
      this.l.a(this);
    }
  }
  
  private void a(Canvas paramCanvas, a parama, Matrix paramMatrix)
  {
    if (a.b(parama) == null) {
      return;
    }
    this.c.reset();
    int m = a.a(parama).size() - 1;
    while (m >= 0)
    {
      this.c.addPath(((bg)a.a(parama).get(m)).getPath(), paramMatrix);
      m -= 1;
    }
    this.b.setPath(this.c, false);
    for (float f1 = this.b.getLength(); this.b.nextContour(); f1 = this.b.getLength() + f1) {}
    float f2 = ((Float)a.b(parama).getOffset().getValue()).floatValue() * f1 / 360.0F;
    float f5 = ((Float)a.b(parama).getStart().getValue()).floatValue() * f1 / 100.0F + f2;
    float f6 = ((Float)a.b(parama).getEnd().getValue()).floatValue() * f1 / 100.0F + f2;
    m = a.a(parama).size() - 1;
    f2 = 0.0F;
    label209:
    float f7;
    float f3;
    if (m >= 0)
    {
      this.d.set(((bg)a.a(parama).get(m)).getPath());
      this.d.transform(paramMatrix);
      this.b.setPath(this.d, false);
      f7 = this.b.getLength();
      if ((f6 <= f1) || (f6 - f1 >= f2 + f7) || (f2 >= f6 - f1)) {
        break label380;
      }
      if (f5 <= f1) {
        break label374;
      }
      f3 = (f5 - f1) / f7;
      label320:
      f4 = Math.min((f6 - f1) / f7, 1.0F);
      ch.a(this.d, f3, f4, 0.0F);
      paramCanvas.drawPath(this.d, this.a);
    }
    for (;;)
    {
      m -= 1;
      f2 += f7;
      break label209;
      break;
      label374:
      f3 = 0.0F;
      break label320;
      label380:
      if ((f2 + f7 >= f5) && (f2 <= f6))
      {
        if ((f2 + f7 > f6) || (f5 >= f2)) {
          break label433;
        }
        paramCanvas.drawPath(this.d, this.a);
      }
    }
    label433:
    if (f5 < f2)
    {
      f3 = 0.0F;
      label444:
      if (f6 <= f2 + f7) {
        break label498;
      }
    }
    label498:
    for (float f4 = 1.0F;; f4 = (f6 - f2) / f7)
    {
      ch.a(this.d, f3, f4, 0.0F);
      paramCanvas.drawPath(this.d, this.a);
      break;
      f3 = (f5 - f2) / f7;
      break label444;
    }
  }
  
  private void a(Matrix paramMatrix)
  {
    if (this.k.isEmpty()) {
      return;
    }
    float f1 = ch.a(paramMatrix);
    int m = 0;
    if (m < this.k.size())
    {
      this.h[m] = ((Float)((n)this.k.get(m)).getValue()).floatValue();
      if (m % 2 == 0) {
        if (this.h[m] < 1.0F) {
          this.h[m] = 1.0F;
        }
      }
      for (;;)
      {
        paramMatrix = this.h;
        paramMatrix[m] *= f1;
        m += 1;
        break;
        if (this.h[m] < 0.1F) {
          this.h[m] = 0.1F;
        }
      }
    }
    if (this.l == null) {}
    for (f1 = 0.0F;; f1 = ((Float)this.l.getValue()).floatValue())
    {
      this.a.setPathEffect(new DashPathEffect(this.h, f1));
      return;
    }
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    float f1 = paramInt / 255.0F;
    paramInt = (int)(((Integer)this.j.getValue()).intValue() * f1 / 100.0F * 255.0F);
    this.a.setAlpha(paramInt);
    this.a.setStrokeWidth(((Float)this.i.getValue()).floatValue() * ch.a(paramMatrix));
    if (this.a.getStrokeWidth() <= 0.0F) {
      return;
    }
    a(paramMatrix);
    paramInt = 0;
    label85:
    a locala;
    if (paramInt < this.g.size())
    {
      locala = (a)this.g.get(paramInt);
      if (a.b(locala) == null) {
        break label136;
      }
      a(paramCanvas, locala, paramMatrix);
    }
    for (;;)
    {
      paramInt += 1;
      break label85;
      break;
      label136:
      this.c.reset();
      int m = a.a(locala).size() - 1;
      while (m >= 0)
      {
        this.c.addPath(((bg)a.a(locala).get(m)).getPath(), paramMatrix);
        m -= 1;
      }
      paramCanvas.drawPath(this.c, this.a);
    }
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix)
  {
    this.c.reset();
    int m = 0;
    while (m < this.g.size())
    {
      a locala = (a)this.g.get(m);
      int n = 0;
      while (n < a.a(locala).size())
      {
        this.c.addPath(((bg)a.a(locala).get(n)).getPath(), paramMatrix);
        n += 1;
      }
      m += 1;
    }
    this.c.computeBounds(this.e, false);
    float f1 = ((Float)this.i.getValue()).floatValue();
    paramMatrix = this.e;
    float f2 = this.e.left;
    float f3 = f1 / 2.0F;
    float f4 = this.e.top;
    float f5 = f1 / 2.0F;
    float f6 = this.e.right;
    float f7 = f1 / 2.0F;
    float f8 = this.e.bottom;
    paramMatrix.set(f2 - f3, f4 - f5, f6 + f7, f1 / 2.0F + f8);
    paramRectF.set(this.e);
    paramRectF.set(paramRectF.left - 1.0F, paramRectF.top - 1.0F, paramRectF.right + 1.0F, paramRectF.bottom + 1.0F);
  }
  
  public void onValueChanged()
  {
    this.f.invalidateSelf();
  }
  
  public void setContents(List<x> paramList1, List<x> paramList2)
  {
    int m = paramList1.size() - 1;
    cg localcg = null;
    x localx;
    if (m >= 0)
    {
      localx = (x)paramList1.get(m);
      if ((!(localx instanceof cg)) || (((cg)localx).a() != bz.b.b)) {
        break label232;
      }
      localcg = (cg)localx;
    }
    label232:
    for (;;)
    {
      m -= 1;
      break;
      if (localcg != null) {
        localcg.a(this);
      }
      m = paramList2.size() - 1;
      paramList1 = null;
      if (m >= 0)
      {
        localx = (x)paramList2.get(m);
        if (((localx instanceof cg)) && (((cg)localx).a() == bz.b.b))
        {
          if (paramList1 != null) {
            this.g.add(paramList1);
          }
          paramList1 = new a((cg)localx, null);
          ((cg)localx).a(this);
        }
      }
      for (;;)
      {
        m -= 1;
        break;
        if ((localx instanceof bg))
        {
          if (paramList1 == null) {
            paramList1 = new a(localcg, null);
          }
          for (;;)
          {
            a.a(paramList1).add((bg)localx);
            break;
            if (paramList1 != null) {
              this.g.add(paramList1);
            }
            return;
          }
        }
      }
    }
  }
  
  private static final class a
  {
    private final List<bg> a = new ArrayList();
    private final cg b;
    
    private a(cg paramcg)
    {
      this.b = paramcg;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */