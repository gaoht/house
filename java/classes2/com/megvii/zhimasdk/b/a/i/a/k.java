package com.megvii.zhimasdk.b.a.i.a;

import com.megvii.zhimasdk.b.a.a.i;
import com.megvii.zhimasdk.b.a.a.m;
import com.megvii.zhimasdk.b.a.a.n;
import com.megvii.zhimasdk.b.a.a.o;
import com.megvii.zhimasdk.b.a.e;
import com.megvii.zhimasdk.b.a.o.d;
import com.megvii.zhimasdk.b.a.q;

public class k
  extends a
{
  private final h a;
  private a b;
  private String c;
  
  public k()
  {
    this(new j());
  }
  
  public k(h paramh)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramh, "NTLM engine");
    this.a = paramh;
    this.b = a.a;
    this.c = null;
  }
  
  public e a(m paramm, q paramq)
  {
    try
    {
      paramq = (com.megvii.zhimasdk.b.a.a.p)paramm;
      if (this.b == a.f) {
        throw new i("NTLM authentication failed");
      }
    }
    catch (ClassCastException paramq)
    {
      throw new n("Credentials cannot be used for NTLM authentication: " + paramm.getClass().getName());
    }
    if (this.b == a.b)
    {
      paramm = this.a.a(paramq.d(), paramq.e());
      this.b = a.c;
      paramq = new d(32);
      if (!e()) {
        break label217;
      }
      paramq.a("Proxy-Authorization");
    }
    for (;;)
    {
      paramq.a(": NTLM ");
      paramq.a(paramm);
      return new com.megvii.zhimasdk.b.a.k.p(paramq);
      if (this.b == a.d)
      {
        paramm = this.a.a(paramq.c(), paramq.b(), paramq.d(), paramq.e(), this.c);
        this.b = a.e;
        break;
      }
      throw new i("Unexpected web_state: " + this.b);
      label217:
      paramq.a("Authorization");
    }
  }
  
  public String a()
  {
    return "ntlm";
  }
  
  protected void a(d paramd, int paramInt1, int paramInt2)
  {
    this.c = paramd.b(paramInt1, paramInt2);
    if (this.c.length() == 0) {
      if (this.b == a.a) {
        this.b = a.b;
      }
    }
    do
    {
      return;
      this.b = a.f;
      return;
      if (this.b.compareTo(a.c) < 0)
      {
        this.b = a.f;
        throw new o("Out of sequence NTLM response message");
      }
    } while (this.b != a.c);
    this.b = a.d;
  }
  
  public String b()
  {
    return null;
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean d()
  {
    return (this.b == a.e) || (this.b == a.f);
  }
  
  static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */