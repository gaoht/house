package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

class bl
  implements bg, n.a
{
  private final Path a = new Path();
  private final String b;
  private final ax c;
  private final bm.b d;
  private final n<?, Float> e;
  private final n<?, PointF> f;
  private final n<?, Float> g;
  private final n<?, Float> h;
  private final n<?, Float> i;
  private final n<?, Float> j;
  private final n<?, Float> k;
  private cg l;
  private boolean m;
  
  bl(ax paramax, o paramo, bm parambm)
  {
    this.c = paramax;
    this.b = parambm.a();
    this.d = parambm.b();
    this.e = parambm.c().createAnimation();
    this.f = parambm.d().createAnimation();
    this.g = parambm.e().createAnimation();
    this.i = parambm.g().createAnimation();
    this.k = parambm.i().createAnimation();
    if (this.d == bm.b.a) {
      this.h = parambm.f().createAnimation();
    }
    for (this.j = parambm.h().createAnimation();; this.j = null)
    {
      paramo.a(this.e);
      paramo.a(this.f);
      paramo.a(this.g);
      paramo.a(this.i);
      paramo.a(this.k);
      if (this.d == bm.b.a)
      {
        paramo.a(this.h);
        paramo.a(this.j);
      }
      this.e.a(this);
      this.f.a(this);
      this.g.a(this);
      this.i.a(this);
      this.k.a(this);
      if (this.d == bm.b.a)
      {
        this.i.a(this);
        this.k.a(this);
      }
      return;
      this.h = null;
    }
  }
  
  private void a()
  {
    this.m = false;
    this.c.invalidateSelf();
  }
  
  private void b()
  {
    float f8 = ((Float)this.e.getValue()).floatValue();
    double d1;
    float f17;
    float f14;
    float f18;
    if (this.g == null)
    {
      d1 = 0.0D;
      d1 = Math.toRadians(d1 - 90.0D);
      f17 = (float)(6.283185307179586D / f8);
      f14 = f17 / 2.0F;
      f18 = f8 - (int)f8;
      if (f18 == 0.0F) {
        break label840;
      }
      d1 += (1.0F - f18) * f14;
    }
    label223:
    label248:
    label265:
    label382:
    label467:
    label551:
    label560:
    label569:
    label578:
    label709:
    label716:
    label723:
    label730:
    label765:
    label771:
    label808:
    label827:
    label840:
    for (;;)
    {
      float f3 = ((Float)this.i.getValue()).floatValue();
      float f4 = ((Float)this.h.getValue()).floatValue();
      if (this.j != null) {}
      for (float f1 = ((Float)this.j.getValue()).floatValue() / 100.0F;; f1 = 0.0F)
      {
        float f2 = 0.0F;
        if (this.k != null) {
          f2 = ((Float)this.k.getValue()).floatValue() / 100.0F;
        }
        float f5;
        float f6;
        float f7;
        double d2;
        int i1;
        int n;
        float f10;
        float f9;
        if (f18 != 0.0F)
        {
          f5 = (f3 - f4) * f18 + f4;
          f6 = (float)(f5 * Math.cos(d1));
          f7 = (float)(f5 * Math.sin(d1));
          this.a.moveTo(f6, f7);
          d1 += f17 * f18 / 2.0F;
          d2 = Math.ceil(f8) * 2.0D;
          i1 = 0;
          n = 0;
          f10 = f6;
          f9 = f7;
          if (i1 >= d2) {
            break label771;
          }
          if (n == 0) {
            break label467;
          }
          f6 = f3;
          if ((f5 == 0.0F) || (i1 != d2 - 2.0D)) {
            break label827;
          }
        }
        for (float f11 = f17 * f18 / 2.0F;; f11 = f14)
        {
          f7 = f6;
          if (f5 != 0.0F)
          {
            f7 = f6;
            if (i1 == d2 - 1.0D) {
              f7 = f5;
            }
          }
          float f15 = (float)(f7 * Math.cos(d1));
          float f16 = (float)(f7 * Math.sin(d1));
          if ((f1 == 0.0F) && (f2 == 0.0F))
          {
            this.a.lineTo(f15, f16);
            double d3 = f11;
            if (n != 0) {
              break label765;
            }
            n = 1;
            i1 += 1;
            f9 = f16;
            f10 = f15;
            d1 += d3;
            break label248;
            d1 = ((Float)this.g.getValue()).floatValue();
            break;
            f6 = (float)(f3 * Math.cos(d1));
            f7 = (float)(f3 * Math.sin(d1));
            this.a.moveTo(f6, f7);
            d1 += f14;
            f5 = 0.0F;
            break label223;
            f6 = f4;
            break label265;
          }
          f6 = (float)(Math.atan2(f9, f10) - 1.5707963267948966D);
          f8 = (float)Math.cos(f6);
          float f21 = (float)Math.sin(f6);
          f6 = (float)(Math.atan2(f16, f15) - 1.5707963267948966D);
          float f19 = (float)Math.cos(f6);
          float f20 = (float)Math.sin(f6);
          float f12;
          float f13;
          if (n != 0)
          {
            f6 = f1;
            if (n == 0) {
              break label709;
            }
            f7 = f2;
            if (n == 0) {
              break label716;
            }
            f12 = f4;
            if (n == 0) {
              break label723;
            }
            f13 = f3;
            f8 *= f12 * f6 * 0.47829F;
            f12 = f12 * f6 * 0.47829F * f21;
            f6 = f13 * f7 * 0.47829F * f19;
            f7 = f13 * f7 * 0.47829F * f20;
            if (f18 == 0.0F) {
              break label808;
            }
            if (i1 != 0) {
              break label730;
            }
            f12 *= f18;
            f13 = f8 * f18;
            f8 = f7;
            f7 = f6;
            f6 = f13;
          }
          for (;;)
          {
            this.a.cubicTo(f10 - f6, f9 - f12, f7 + f15, f8 + f16, f15, f16);
            break;
            f6 = f2;
            break label551;
            f7 = f1;
            break label560;
            f12 = f3;
            break label569;
            f13 = f4;
            break label578;
            if (i1 == d2 - 1.0D)
            {
              f13 = f7 * f18;
              f7 = f6 * f18;
              f6 = f8;
              f8 = f13;
              continue;
              n = 0;
              break label382;
              PointF localPointF = (PointF)this.f.getValue();
              this.a.offset(localPointF.x, localPointF.y);
              this.a.close();
              return;
            }
            f13 = f7;
            f7 = f6;
            f6 = f8;
            f8 = f13;
          }
        }
      }
    }
  }
  
  private void c()
  {
    int n = (int)Math.floor(((Float)this.e.getValue()).floatValue());
    double d1;
    float f5;
    float f1;
    float f2;
    double d3;
    label134:
    float f4;
    float f3;
    if (this.g == null)
    {
      d1 = 0.0D;
      d1 = Math.toRadians(d1 - 90.0D);
      f5 = (float)(6.283185307179586D / n);
      float f6 = ((Float)this.k.getValue()).floatValue() / 100.0F;
      float f7 = ((Float)this.i.getValue()).floatValue();
      f1 = (float)(f7 * Math.cos(d1));
      f2 = (float)(f7 * Math.sin(d1));
      this.a.moveTo(f1, f2);
      d3 = f5;
      double d2 = Math.ceil(n);
      n = 0;
      d1 += d3;
      if (n >= d2) {
        break label365;
      }
      f4 = (float)(f7 * Math.cos(d1));
      f3 = (float)(f7 * Math.sin(d1));
      if (f6 == 0.0F) {
        break label351;
      }
      float f9 = (float)(Math.atan2(f2, f1) - 1.5707963267948966D);
      float f8 = (float)Math.cos(f9);
      f9 = (float)Math.sin(f9);
      float f11 = (float)(Math.atan2(f3, f4) - 1.5707963267948966D);
      float f10 = (float)Math.cos(f11);
      f11 = (float)Math.sin(f11);
      this.a.cubicTo(f1 - f8 * (f7 * f6 * 0.25F), f2 - f7 * f6 * 0.25F * f9, f4 + f10 * (f7 * f6 * 0.25F), f11 * (f7 * f6 * 0.25F) + f3, f4, f3);
    }
    for (;;)
    {
      d3 = f5;
      n += 1;
      f1 = f4;
      d1 += d3;
      f2 = f3;
      break label134;
      d1 = ((Float)this.g.getValue()).floatValue();
      break;
      label351:
      this.a.lineTo(f4, f3);
    }
    label365:
    PointF localPointF = (PointF)this.f.getValue();
    this.a.offset(localPointF.x, localPointF.y);
    this.a.close();
  }
  
  public String getName()
  {
    return this.b;
  }
  
  public Path getPath()
  {
    if (this.m) {
      return this.a;
    }
    this.a.reset();
    switch (1.a[this.d.ordinal()])
    {
    }
    for (;;)
    {
      this.a.close();
      ch.a(this.a, this.l);
      this.m = true;
      return this.a;
      b();
      continue;
      c();
    }
  }
  
  public void onValueChanged()
  {
    a();
  }
  
  public void setContents(List<x> paramList1, List<x> paramList2)
  {
    int n = 0;
    while (n < paramList1.size())
    {
      paramList2 = (x)paramList1.get(n);
      if (((paramList2 instanceof cg)) && (((cg)paramList2).a() == bz.b.a))
      {
        this.l = ((cg)paramList2);
        this.l.a(this);
      }
      n += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */