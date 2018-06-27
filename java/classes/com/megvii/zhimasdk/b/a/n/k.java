package com.megvii.zhimasdk.b.a.n;

import com.megvii.zhimasdk.b.a.ac;
import com.megvii.zhimasdk.b.a.ae;
import com.megvii.zhimasdk.b.a.l;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.q;
import com.megvii.zhimasdk.b.a.r;
import com.megvii.zhimasdk.b.a.v;

public class k
  implements r
{
  private final boolean a;
  
  @Deprecated
  public k()
  {
    this(false);
  }
  
  public k(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void a(q paramq, e parame)
  {
    a.a(paramq, "HTTP request");
    if ((!paramq.a("Expect")) && ((paramq instanceof l)))
    {
      parame = paramq.h().b();
      com.megvii.zhimasdk.b.a.k localk = ((l)paramq).c();
      if ((localk != null) && (localk.b() != 0L) && (!parame.c(v.b)) && (paramq.g().a("http.protocol.expect-continue", this.a))) {
        paramq.a("Expect", "100-continue");
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/n/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */