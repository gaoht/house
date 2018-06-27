package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f.b;
import com.megvii.zhimasdk.b.a.f.c;
import com.megvii.zhimasdk.b.a.f.e;
import com.megvii.zhimasdk.b.a.f.g;
import com.megvii.zhimasdk.b.a.f.l;
import com.megvii.zhimasdk.b.a.f.m;
import com.megvii.zhimasdk.b.a.f.n;

public class ag
  implements c
{
  public void a(b paramb, e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramb, "Cookie");
    if (((paramb instanceof n)) && ((paramb instanceof com.megvii.zhimasdk.b.a.f.a)) && (!((com.megvii.zhimasdk.b.a.f.a)paramb).b("version"))) {
      throw new g("Violates RFC 2965. Version attribute is required.");
    }
  }
  
  public void a(m paramm, String paramString)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramm, "Cookie");
    if (paramString == null) {
      throw new l("Missing value for version attribute");
    }
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0) {
        throw new l("Invalid cookie version.");
      }
    }
    catch (NumberFormatException paramString)
    {
      int i;
      for (;;)
      {
        i = -1;
      }
      paramm.a(i);
    }
  }
  
  public boolean b(b paramb, e parame)
  {
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */