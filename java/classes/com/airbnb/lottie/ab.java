package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

class ab
  implements bg, n.a
{
  private final Path a = new Path();
  private final String b;
  private final ax c;
  private final n<?, PointF> d;
  private final n<?, PointF> e;
  private cg f;
  private boolean g;
  
  ab(ax paramax, o paramo, s params)
  {
    this.b = params.a();
    this.c = paramax;
    this.d = params.getSize().createAnimation();
    this.e = params.getPosition().createAnimation();
    paramo.a(this.d);
    paramo.a(this.e);
    this.d.a(this);
    this.e.a(this);
  }
  
  private void a()
  {
    this.g = false;
    this.c.invalidateSelf();
  }
  
  public String getName()
  {
    return this.b;
  }
  
  public Path getPath()
  {
    if (this.g) {
      return this.a;
    }
    this.a.reset();
    PointF localPointF = (PointF)this.d.getValue();
    float f1 = localPointF.x / 2.0F;
    float f2 = localPointF.y / 2.0F;
    float f3 = f1 * 0.55228F;
    float f4 = f2 * 0.55228F;
    this.a.reset();
    this.a.moveTo(0.0F, -f2);
    this.a.cubicTo(0.0F + f3, -f2, f1, 0.0F - f4, f1, 0.0F);
    this.a.cubicTo(f1, 0.0F + f4, 0.0F + f3, f2, 0.0F, f2);
    this.a.cubicTo(0.0F - f3, f2, -f1, 0.0F + f4, -f1, 0.0F);
    this.a.cubicTo(-f1, 0.0F - f4, 0.0F - f3, -f2, 0.0F, -f2);
    localPointF = (PointF)this.e.getValue();
    this.a.offset(localPointF.x, localPointF.y);
    this.a.close();
    ch.a(this.a, this.f);
    this.g = true;
    return this.a;
  }
  
  public void onValueChanged()
  {
    a();
  }
  
  public void setContents(List<x> paramList1, List<x> paramList2)
  {
    int i = 0;
    while (i < paramList1.size())
    {
      paramList2 = (x)paramList1.get(i);
      if (((paramList2 instanceof cg)) && (((cg)paramList2).a() == bz.b.a))
      {
        this.f = ((cg)paramList2);
        this.f.a(this);
      }
      i += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */