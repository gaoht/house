package com.airbnb.lottie;

import java.util.ArrayList;
import java.util.List;

class cg
  implements n.a, x
{
  private String a;
  private final List<n.a> b = new ArrayList();
  private final bz.b c;
  private final n<?, Float> d;
  private final n<?, Float> e;
  private final n<?, Float> f;
  
  cg(o paramo, bz parambz)
  {
    this.a = parambz.a();
    this.c = parambz.b();
    this.d = parambz.d().createAnimation();
    this.e = parambz.c().createAnimation();
    this.f = parambz.e().createAnimation();
    paramo.a(this.d);
    paramo.a(this.e);
    paramo.a(this.f);
    this.d.a(this);
    this.e.a(this);
    this.f.a(this);
  }
  
  bz.b a()
  {
    return this.c;
  }
  
  void a(n.a parama)
  {
    this.b.add(parama);
  }
  
  public n<?, Float> getEnd()
  {
    return this.e;
  }
  
  public String getName()
  {
    return this.a;
  }
  
  public n<?, Float> getOffset()
  {
    return this.f;
  }
  
  public n<?, Float> getStart()
  {
    return this.d;
  }
  
  public void onValueChanged()
  {
    int i = 0;
    while (i < this.b.size())
    {
      ((n.a)this.b.get(i)).onValueChanged();
      i += 1;
    }
  }
  
  public void setContents(List<x> paramList1, List<x> paramList2) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */