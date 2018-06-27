package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.Path.FillType;
import java.util.List;

class br
  implements bg, n.a
{
  private final Path a = new Path();
  private final String b;
  private final ax c;
  private final n<?, Path> d;
  private boolean e;
  private cg f;
  
  br(ax paramax, o paramo, bx parambx)
  {
    this.b = parambx.getName();
    this.c = paramax;
    this.d = parambx.a().createAnimation();
    paramo.a(this.d);
    this.d.a(this);
  }
  
  private void a()
  {
    this.e = false;
    this.c.invalidateSelf();
  }
  
  public String getName()
  {
    return this.b;
  }
  
  public Path getPath()
  {
    if (this.e) {
      return this.a;
    }
    this.a.reset();
    this.a.set((Path)this.d.getValue());
    this.a.setFillType(Path.FillType.EVEN_ODD);
    ch.a(this.a, this.f);
    this.e = true;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */