package com.megvii.zhimasdk.b;

import com.megvii.zhimasdk.b.a.a.c;
import com.megvii.zhimasdk.b.a.a.l;
import com.megvii.zhimasdk.b.a.a.m;
import com.megvii.zhimasdk.b.a.k.p;
import com.megvii.zhimasdk.b.a.q;
import java.security.Principal;

public class g
  implements com.megvii.zhimasdk.b.a.a.d
{
  public c a(com.megvii.zhimasdk.b.a.l.e parame)
  {
    return new a();
  }
  
  public static class a
    implements l
  {
    private boolean a = false;
    
    public com.megvii.zhimasdk.b.a.e a(m paramm, q paramq)
    {
      return a(paramm, paramq, null);
    }
    
    public com.megvii.zhimasdk.b.a.e a(m paramm, q paramq, com.megvii.zhimasdk.b.a.n.e parame)
    {
      paramq = new com.megvii.zhimasdk.b.a.o.d(32);
      paramq.a("Authorization");
      paramq.a(": Bearer ");
      paramq.a(paramm.a().getName());
      return new p(paramq);
    }
    
    public String a()
    {
      return "Bearer";
    }
    
    public void a(com.megvii.zhimasdk.b.a.e parame)
    {
      this.a = true;
    }
    
    public String b()
    {
      return null;
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
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */