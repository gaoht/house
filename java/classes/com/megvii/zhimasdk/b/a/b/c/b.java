package com.megvii.zhimasdk.b.a.b.c;

import com.megvii.zhimasdk.b.a.e.i;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class b
  extends com.megvii.zhimasdk.b.a.k.a
  implements a, com.megvii.zhimasdk.b.a.q, Cloneable
{
  private final AtomicBoolean c = new AtomicBoolean(false);
  private final AtomicReference<com.megvii.zhimasdk.b.a.c.a> d = new AtomicReference(null);
  
  public void a(com.megvii.zhimasdk.b.a.c.a parama)
  {
    if (!this.c.get()) {
      this.d.set(parama);
    }
  }
  
  @Deprecated
  public void a(com.megvii.zhimasdk.b.a.e.e parame)
  {
    a(new b.1(this, parame));
  }
  
  @Deprecated
  public void a(i parami)
  {
    a(new b.2(this, parami));
  }
  
  public Object clone()
  {
    b localb = (b)super.clone();
    localb.a = ((com.megvii.zhimasdk.b.a.k.q)com.megvii.zhimasdk.b.a.b.f.a.a(this.a));
    localb.b = ((com.megvii.zhimasdk.b.a.l.e)com.megvii.zhimasdk.b.a.b.f.a.a(this.b));
    return localb;
  }
  
  public boolean i()
  {
    return this.c.get();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/b/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */