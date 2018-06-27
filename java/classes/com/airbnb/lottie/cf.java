package com.airbnb.lottie;

import android.graphics.Matrix;
import android.graphics.PointF;

class cf
{
  private final Matrix a = new Matrix();
  private final n<?, PointF> b;
  private final n<?, PointF> c;
  private final n<?, bq> d;
  private final n<?, Float> e;
  private final n<?, Integer> f;
  
  cf(j paramj)
  {
    this.b = paramj.a().createAnimation();
    this.c = paramj.b().createAnimation();
    this.d = paramj.c().createAnimation();
    this.e = paramj.d().createAnimation();
    this.f = paramj.e().createAnimation();
  }
  
  n<?, Integer> a()
  {
    return this.f;
  }
  
  void a(n.a parama)
  {
    this.b.a(parama);
    this.c.a(parama);
    this.d.a(parama);
    this.e.a(parama);
    this.f.a(parama);
  }
  
  void a(o paramo)
  {
    paramo.a(this.b);
    paramo.a(this.c);
    paramo.a(this.d);
    paramo.a(this.e);
    paramo.a(this.f);
  }
  
  Matrix b()
  {
    this.a.reset();
    Object localObject = (PointF)this.c.getValue();
    if ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F)) {
      this.a.preTranslate(((PointF)localObject).x, ((PointF)localObject).y);
    }
    float f1 = ((Float)this.e.getValue()).floatValue();
    if (f1 != 0.0F) {
      this.a.preRotate(f1);
    }
    localObject = (bq)this.d.getValue();
    if ((((bq)localObject).a() != 1.0F) || (((bq)localObject).b() != 1.0F)) {
      this.a.preScale(((bq)localObject).a(), ((bq)localObject).b());
    }
    localObject = (PointF)this.b.getValue();
    if ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F)) {
      this.a.preTranslate(-((PointF)localObject).x, -((PointF)localObject).y);
    }
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */