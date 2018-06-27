package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.List;

class bn
  implements bg, n.a
{
  private final Path a = new Path();
  private final RectF b = new RectF();
  private final String c;
  private final ax d;
  private final n<?, PointF> e;
  private final n<?, PointF> f;
  private final n<?, Float> g;
  private cg h;
  private boolean i;
  
  bn(ax paramax, o paramo, bo parambo)
  {
    this.c = parambo.a();
    this.d = paramax;
    this.e = parambo.d().createAnimation();
    this.f = parambo.c().createAnimation();
    this.g = parambo.b().createAnimation();
    paramo.a(this.e);
    paramo.a(this.f);
    paramo.a(this.g);
    this.e.a(this);
    this.f.a(this);
    this.g.a(this);
  }
  
  private void a()
  {
    this.i = false;
    this.d.invalidateSelf();
  }
  
  public String getName()
  {
    return this.c;
  }
  
  public Path getPath()
  {
    if (this.i) {
      return this.a;
    }
    this.a.reset();
    PointF localPointF = (PointF)this.f.getValue();
    float f3 = localPointF.x / 2.0F;
    float f4 = localPointF.y / 2.0F;
    float f1;
    if (this.g == null)
    {
      f1 = 0.0F;
      float f2 = Math.min(f3, f4);
      if (f1 <= f2) {
        break label516;
      }
      f1 = f2;
    }
    label516:
    for (;;)
    {
      localPointF = (PointF)this.e.getValue();
      this.a.moveTo(localPointF.x + f3, localPointF.y - f4 + f1);
      this.a.lineTo(localPointF.x + f3, localPointF.y + f4 - f1);
      if (f1 > 0.0F)
      {
        this.b.set(localPointF.x + f3 - 2.0F * f1, localPointF.y + f4 - 2.0F * f1, localPointF.x + f3, localPointF.y + f4);
        this.a.arcTo(this.b, 0.0F, 90.0F, false);
      }
      this.a.lineTo(localPointF.x - f3 + f1, localPointF.y + f4);
      if (f1 > 0.0F)
      {
        this.b.set(localPointF.x - f3, localPointF.y + f4 - 2.0F * f1, localPointF.x - f3 + 2.0F * f1, localPointF.y + f4);
        this.a.arcTo(this.b, 90.0F, 90.0F, false);
      }
      this.a.lineTo(localPointF.x - f3, localPointF.y - f4 + f1);
      if (f1 > 0.0F)
      {
        this.b.set(localPointF.x - f3, localPointF.y - f4, localPointF.x - f3 + 2.0F * f1, localPointF.y - f4 + 2.0F * f1);
        this.a.arcTo(this.b, 180.0F, 90.0F, false);
      }
      this.a.lineTo(localPointF.x + f3 - f1, localPointF.y - f4);
      if (f1 > 0.0F)
      {
        this.b.set(localPointF.x + f3 - 2.0F * f1, localPointF.y - f4, f3 + localPointF.x, localPointF.y - f4 + f1 * 2.0F);
        this.a.arcTo(this.b, 270.0F, 90.0F, false);
      }
      this.a.close();
      ch.a(this.a, this.h);
      this.i = true;
      return this.a;
      f1 = ((Float)this.g.getValue()).floatValue();
      break;
    }
  }
  
  public void onValueChanged()
  {
    a();
  }
  
  public void setContents(List<x> paramList1, List<x> paramList2)
  {
    int j = 0;
    while (j < paramList1.size())
    {
      paramList2 = (x)paramList1.get(j);
      if (((paramList2 instanceof cg)) && (((cg)paramList2).a() == bz.b.a))
      {
        this.h = ((cg)paramList2);
        this.h.a(this);
      }
      j += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */