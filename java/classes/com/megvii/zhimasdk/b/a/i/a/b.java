package com.megvii.zhimasdk.b.a.i.a;

import com.megvii.zhimasdk.b.a.c;
import com.megvii.zhimasdk.b.a.k.p;
import com.megvii.zhimasdk.b.a.o.d;
import com.megvii.zhimasdk.b.a.q;
import java.nio.charset.Charset;
import java.security.Principal;

public class b
  extends m
{
  private boolean a = false;
  
  public b()
  {
    this(c.b);
  }
  
  public b(Charset paramCharset)
  {
    super(paramCharset);
  }
  
  @Deprecated
  public com.megvii.zhimasdk.b.a.e a(com.megvii.zhimasdk.b.a.a.m paramm, q paramq)
  {
    return a(paramm, paramq, new com.megvii.zhimasdk.b.a.n.a());
  }
  
  public com.megvii.zhimasdk.b.a.e a(com.megvii.zhimasdk.b.a.a.m paramm, q paramq, com.megvii.zhimasdk.b.a.n.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramm, "Credentials");
    com.megvii.zhimasdk.b.a.o.a.a(paramq, "HTTP request");
    parame = new StringBuilder();
    parame.append(paramm.a().getName());
    parame.append(":");
    if (paramm.b() == null)
    {
      paramm = "null";
      parame.append(paramm);
      paramm = com.megvii.zhimasdk.b.a.h.a.b(com.megvii.zhimasdk.b.a.o.e.a(parame.toString(), a(paramq)), 2);
      paramq = new d(32);
      if (!e()) {
        break label136;
      }
      paramq.a("Proxy-Authorization");
    }
    for (;;)
    {
      paramq.a(": Basic ");
      paramq.a(paramm, 0, paramm.length);
      return new p(paramq);
      paramm = paramm.b();
      break;
      label136:
      paramq.a("Authorization");
    }
  }
  
  public String a()
  {
    return "basic";
  }
  
  public void a(com.megvii.zhimasdk.b.a.e parame)
  {
    super.a(parame);
    this.a = true;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean d()
  {
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */