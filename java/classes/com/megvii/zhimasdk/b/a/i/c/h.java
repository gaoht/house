package com.megvii.zhimasdk.b.a.i.c;

import com.megvii.zhimasdk.b.a.ab;
import com.megvii.zhimasdk.b.a.h.b;
import com.megvii.zhimasdk.b.a.j.f;
import com.megvii.zhimasdk.b.a.k.u;
import com.megvii.zhimasdk.b.a.l.e;
import com.megvii.zhimasdk.b.a.o.d;
import com.megvii.zhimasdk.b.a.s;
import com.megvii.zhimasdk.b.a.z;

public class h
  extends com.megvii.zhimasdk.b.a.i.f.a<s>
{
  public b a = new b(getClass());
  private final com.megvii.zhimasdk.b.a.t c;
  private final d d;
  
  @Deprecated
  public h(f paramf, com.megvii.zhimasdk.b.a.k.t paramt, com.megvii.zhimasdk.b.a.t paramt1, e parame)
  {
    super(paramf, paramt, parame);
    com.megvii.zhimasdk.b.a.o.a.a(paramt1, "Response factory");
    this.c = paramt1;
    this.d = new d(128);
  }
  
  protected s a(f paramf)
  {
    int i = 0;
    for (;;)
    {
      this.d.a();
      int j = paramf.a(this.d);
      if ((j == -1) && (i == 0)) {
        throw new z("The target server failed to respond");
      }
      u localu = new u(0, this.d.c());
      if (this.b.b(this.d, localu))
      {
        paramf = this.b.c(this.d, localu);
        return this.c.a(paramf, null);
      }
      if ((j == -1) || (a(this.d, i))) {
        throw new ab("The server failed to respond with a valid HTTP response");
      }
      if (this.a.a()) {
        this.a.a("Garbage in response: " + this.d.toString());
      }
      i += 1;
    }
  }
  
  protected boolean a(d paramd, int paramInt)
  {
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */