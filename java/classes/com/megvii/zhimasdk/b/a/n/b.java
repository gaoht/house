package com.megvii.zhimasdk.b.a.n;

import com.megvii.zhimasdk.b.a.q;
import com.megvii.zhimasdk.b.a.r;
import com.megvii.zhimasdk.b.a.s;
import com.megvii.zhimasdk.b.a.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
public final class b
  implements g, Cloneable
{
  protected final List<r> a = new ArrayList();
  protected final List<u> b = new ArrayList();
  
  public int a()
  {
    return this.a.size();
  }
  
  public r a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.a.size())) {
      return null;
    }
    return (r)this.a.get(paramInt);
  }
  
  protected void a(b paramb)
  {
    paramb.a.clear();
    paramb.a.addAll(this.a);
    paramb.b.clear();
    paramb.b.addAll(this.b);
  }
  
  public void a(q paramq, e parame)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((r)localIterator.next()).a(paramq, parame);
    }
  }
  
  public void a(r paramr)
  {
    if (paramr == null) {
      return;
    }
    this.a.add(paramr);
  }
  
  public void a(r paramr, int paramInt)
  {
    if (paramr == null) {
      return;
    }
    this.a.add(paramInt, paramr);
  }
  
  public void a(s params, e parame)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((u)localIterator.next()).a(params, parame);
    }
  }
  
  public void a(u paramu)
  {
    if (paramu == null) {
      return;
    }
    this.b.add(paramu);
  }
  
  public int b()
  {
    return this.b.size();
  }
  
  public u b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.b.size())) {
      return null;
    }
    return (u)this.b.get(paramInt);
  }
  
  public final void b(r paramr)
  {
    a(paramr);
  }
  
  public final void b(r paramr, int paramInt)
  {
    a(paramr, paramInt);
  }
  
  public final void b(u paramu)
  {
    a(paramu);
  }
  
  public Object clone()
  {
    b localb = (b)super.clone();
    a(localb);
    return localb;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/n/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */