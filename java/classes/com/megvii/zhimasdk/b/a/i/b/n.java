package com.megvii.zhimasdk.b.a.i.b;

import com.megvii.zhimasdk.b.a.ae;
import com.megvii.zhimasdk.b.a.b.c.f;
import com.megvii.zhimasdk.b.a.b.c.g;
import com.megvii.zhimasdk.b.a.b.c.j;
import com.megvii.zhimasdk.b.a.b.o;
import com.megvii.zhimasdk.b.a.n.e;
import com.megvii.zhimasdk.b.a.q;
import com.megvii.zhimasdk.b.a.s;

@Deprecated
class n
  implements o
{
  private final com.megvii.zhimasdk.b.a.b.n a;
  
  public com.megvii.zhimasdk.b.a.b.n a()
  {
    return this.a;
  }
  
  public boolean a(q paramq, s params, e parame)
  {
    return this.a.a(params, parame);
  }
  
  public j b(q paramq, s params, e parame)
  {
    params = this.a.b(params, parame);
    if (paramq.h().a().equalsIgnoreCase("HEAD")) {
      return new g(params);
    }
    return new f(params);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */