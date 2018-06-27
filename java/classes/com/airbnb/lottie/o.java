package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

abstract class o
  implements aa, n.a
{
  final Matrix a = new Matrix();
  final ax b;
  final av c;
  final cf d;
  private final Path e = new Path();
  private final Matrix f = new Matrix();
  private final Paint g = new Paint(1);
  private final Paint h = new Paint(1);
  private final Paint i = new Paint(1);
  private final Paint j = new Paint();
  private final RectF k = new RectF();
  private final RectF l = new RectF();
  private final RectF m = new RectF();
  private final RectF n = new RectF();
  private ba o;
  private o p;
  private o q;
  private List<o> r;
  private final List<n<?, ?>> s = new ArrayList();
  private boolean t = true;
  
  o(ax paramax, av paramav)
  {
    this.b = paramax;
    this.c = paramav;
    this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    if (paramav.j() == av.c.c) {
      this.i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }
    for (;;)
    {
      this.d = paramav.m().createAnimation();
      this.d.a(this);
      this.d.a(this);
      if ((paramav.h() == null) || (paramav.h().isEmpty())) {
        break;
      }
      this.o = new ba(paramav.h());
      paramax = this.o.b().iterator();
      while (paramax.hasNext())
      {
        paramav = (n)paramax.next();
        a(paramav);
        paramav.a(this);
      }
      this.i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }
    d();
  }
  
  static o a(av paramav, ax paramax, aw paramaw)
  {
    switch (2.a[paramav.i().ordinal()])
    {
    default: 
      Log.w("LOTTIE", "Unknown layer type " + paramav.i());
      return null;
    case 1: 
      return new bw(paramax, paramav);
    case 2: 
      return new v(paramax, paramav, paramaw.a(paramav.e()), paramaw);
    case 3: 
      return new cb(paramax, paramav);
    case 4: 
      return new ap(paramax, paramav, paramaw.getDpScale());
    }
    return new be(paramax, paramav);
  }
  
  private void a(Canvas paramCanvas)
  {
    paramCanvas.drawRect(this.k.left - 1.0F, this.k.top - 1.0F, this.k.right + 1.0F, 1.0F + this.k.bottom, this.j);
  }
  
  private void a(Canvas paramCanvas, Matrix paramMatrix)
  {
    paramCanvas.saveLayer(this.k, this.h, 19);
    a(paramCanvas);
    int i2 = this.o.a().size();
    int i1 = 0;
    if (i1 < i2)
    {
      az localaz = (az)this.o.a().get(i1);
      Path localPath = (Path)((n)this.o.b().get(i1)).getValue();
      this.e.set(localPath);
      this.e.transform(paramMatrix);
      switch (2.b[localaz.a().ordinal()])
      {
      default: 
        this.e.setFillType(Path.FillType.WINDING);
      }
      for (;;)
      {
        paramCanvas.drawPath(this.e, this.g);
        i1 += 1;
        break;
        this.e.setFillType(Path.FillType.INVERSE_WINDING);
      }
    }
    paramCanvas.restore();
  }
  
  private void a(RectF paramRectF, Matrix paramMatrix)
  {
    this.l.set(0.0F, 0.0F, 0.0F, 0.0F);
    if (!c()) {
      return;
    }
    int i2 = this.o.a().size();
    int i1 = 0;
    if (i1 < i2)
    {
      az localaz = (az)this.o.a().get(i1);
      Path localPath = (Path)((n)this.o.b().get(i1)).getValue();
      this.e.set(localPath);
      this.e.transform(paramMatrix);
      switch (2.b[localaz.a().ordinal()])
      {
      }
      this.e.computeBounds(this.n, false);
      if (i1 == 0) {
        this.l.set(this.n);
      }
      for (;;)
      {
        i1 += 1;
        break;
        this.l.set(Math.min(this.l.left, this.n.left), Math.min(this.l.top, this.n.top), Math.max(this.l.right, this.n.right), Math.max(this.l.bottom, this.n.bottom));
      }
    }
    paramRectF.set(Math.max(paramRectF.left, this.l.left), Math.max(paramRectF.top, this.l.top), Math.min(paramRectF.right, this.l.right), Math.min(paramRectF.bottom, this.l.bottom));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean != this.t)
    {
      this.t = paramBoolean;
      e();
    }
  }
  
  private void b(RectF paramRectF, Matrix paramMatrix)
  {
    if (!b()) {}
    while (this.c.j() == av.c.c) {
      return;
    }
    this.p.getBounds(this.m, paramMatrix);
    paramRectF.set(Math.max(paramRectF.left, this.m.left), Math.max(paramRectF.top, this.m.top), Math.min(paramRectF.right, this.m.right), Math.min(paramRectF.bottom, this.m.bottom));
  }
  
  private void d()
  {
    if (!this.c.b().isEmpty())
    {
      final ae localae = new ae(this.c.b());
      localae.a();
      localae.a(new n.a()
      {
        public void onValueChanged()
        {
          o localo = o.this;
          if (((Float)localae.getValue()).floatValue() == 1.0F) {}
          for (boolean bool = true;; bool = false)
          {
            o.a(localo, bool);
            return;
          }
        }
      });
      if (((Float)localae.getValue()).floatValue() == 1.0F) {}
      for (boolean bool = true;; bool = false)
      {
        a(bool);
        a(localae);
        return;
      }
    }
    a(true);
  }
  
  private void e()
  {
    this.b.invalidateSelf();
  }
  
  private void f()
  {
    if (this.r != null) {}
    for (;;)
    {
      return;
      if (this.q == null)
      {
        this.r = Collections.emptyList();
        return;
      }
      this.r = new ArrayList();
      for (o localo = this.q; localo != null; localo = localo.q) {
        this.r.add(localo);
      }
    }
  }
  
  av a()
  {
    return this.c;
  }
  
  void a(n<?, ?> paramn)
  {
    if (!(paramn instanceof cd)) {
      this.s.add(paramn);
    }
  }
  
  void a(o paramo)
  {
    this.p = paramo;
  }
  
  public void addColorFilter(String paramString1, String paramString2, ColorFilter paramColorFilter) {}
  
  void b(o paramo)
  {
    this.q = paramo;
  }
  
  boolean b()
  {
    return this.p != null;
  }
  
  boolean c()
  {
    return (this.o != null) && (!this.o.b().isEmpty());
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    if (!this.t) {
      return;
    }
    f();
    this.f.reset();
    this.f.set(paramMatrix);
    int i1 = this.r.size() - 1;
    while (i1 >= 0)
    {
      this.f.preConcat(((o)this.r.get(i1)).d.b());
      i1 -= 1;
    }
    float f1 = paramInt / 255.0F;
    paramInt = (int)(((Integer)this.d.a().getValue()).intValue() * f1 / 100.0F * 255.0F);
    if ((!b()) && (!c()))
    {
      this.f.preConcat(this.d.b());
      drawLayer(paramCanvas, this.f, paramInt);
      return;
    }
    this.k.set(0.0F, 0.0F, 0.0F, 0.0F);
    getBounds(this.k, this.f);
    b(this.k, this.f);
    this.f.preConcat(this.d.b());
    a(this.k, this.f);
    this.k.set(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight());
    paramCanvas.saveLayer(this.k, this.g, 31);
    a(paramCanvas);
    drawLayer(paramCanvas, this.f, paramInt);
    if (c()) {
      a(paramCanvas, this.f);
    }
    if (b())
    {
      paramCanvas.saveLayer(this.k, this.i, 19);
      a(paramCanvas);
      this.p.draw(paramCanvas, paramMatrix, paramInt);
      paramCanvas.restore();
    }
    paramCanvas.restore();
  }
  
  abstract void drawLayer(Canvas paramCanvas, Matrix paramMatrix, int paramInt);
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix)
  {
    this.a.set(paramMatrix);
    this.a.preConcat(this.d.b());
  }
  
  public String getName()
  {
    return this.c.d();
  }
  
  public void onValueChanged()
  {
    e();
  }
  
  public void setContents(List<x> paramList1, List<x> paramList2) {}
  
  void setProgress(float paramFloat)
  {
    if (this.p != null) {
      this.p.setProgress(paramFloat);
    }
    int i1 = 0;
    while (i1 < this.s.size())
    {
      ((n)this.s.get(i1)).setProgress(paramFloat);
      i1 += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */