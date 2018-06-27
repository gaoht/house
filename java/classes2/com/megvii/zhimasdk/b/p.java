package com.megvii.zhimasdk.b;

import java.lang.ref.WeakReference;

public class p
{
  private final WeakReference<b> a;
  
  public p(b paramb)
  {
    this.a = new WeakReference(paramb);
  }
  
  public boolean a()
  {
    b localb = (b)this.a.get();
    return (localb == null) || (localb.b());
  }
  
  public boolean b()
  {
    b localb = (b)this.a.get();
    return (localb == null) || (localb.a());
  }
  
  public boolean c()
  {
    if ((b()) || (a())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.a.clear();
      }
      return bool;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */