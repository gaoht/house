package com.megvii.zhimasdk.b.a.i.b;

import com.megvii.zhimasdk.b.a.a.c;
import com.megvii.zhimasdk.b.a.e.r;
import com.megvii.zhimasdk.b.a.e.s;
import com.megvii.zhimasdk.b.a.i.c.j;
import com.megvii.zhimasdk.b.a.n;
import java.util.HashMap;

public class d
  implements com.megvii.zhimasdk.b.a.b.a
{
  private final HashMap<n, c> a = new HashMap();
  private final r b;
  
  public d()
  {
    this(null);
  }
  
  public d(r paramr)
  {
    if (paramr != null) {}
    for (;;)
    {
      this.b = paramr;
      return;
      paramr = j.a;
    }
  }
  
  public c a(n paramn)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramn, "HTTP host");
    return (c)this.a.get(c(paramn));
  }
  
  public void a(n paramn, c paramc)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramn, "HTTP host");
    this.a.put(c(paramn), paramc);
  }
  
  public void b(n paramn)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramn, "HTTP host");
    this.a.remove(c(paramn));
  }
  
  protected n c(n paramn)
  {
    n localn = paramn;
    if (paramn.b() <= 0) {}
    try
    {
      int i = this.b.a(paramn);
      localn = new n(paramn.a(), i, paramn.c());
      return localn;
    }
    catch (s locals) {}
    return paramn;
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */