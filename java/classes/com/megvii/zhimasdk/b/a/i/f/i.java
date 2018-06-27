package com.megvii.zhimasdk.b.a.i.f;

import com.megvii.zhimasdk.b.a.j.f;
import com.megvii.zhimasdk.b.a.k.u;
import com.megvii.zhimasdk.b.a.l.e;
import com.megvii.zhimasdk.b.a.o.d;
import com.megvii.zhimasdk.b.a.s;
import com.megvii.zhimasdk.b.a.z;

public class i
  extends a<s>
{
  private final com.megvii.zhimasdk.b.a.t a;
  private final d c;
  
  @Deprecated
  public i(f paramf, com.megvii.zhimasdk.b.a.k.t paramt, com.megvii.zhimasdk.b.a.t paramt1, e parame)
  {
    super(paramf, paramt, parame);
    this.a = ((com.megvii.zhimasdk.b.a.t)com.megvii.zhimasdk.b.a.o.a.a(paramt1, "Response factory"));
    this.c = new d(128);
  }
  
  protected s a(f paramf)
  {
    this.c.a();
    if (paramf.a(this.c) == -1) {
      throw new z("The target server failed to respond");
    }
    paramf = new u(0, this.c.c());
    paramf = this.b.c(this.c, paramf);
    return this.a.a(paramf, null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/f/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */