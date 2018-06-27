package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f.b;
import com.megvii.zhimasdk.b.a.f.e;
import com.megvii.zhimasdk.b.a.f.g;
import com.megvii.zhimasdk.b.a.f.l;
import com.megvii.zhimasdk.b.a.f.m;

public class z
  extends a
{
  public void a(b paramb, e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramb, "Cookie");
    if (paramb.h() < 0) {
      throw new g("Cookie version may not be negative");
    }
  }
  
  public void a(m paramm, String paramString)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramm, "Cookie");
    if (paramString == null) {
      throw new l("Missing value for version attribute");
    }
    if (paramString.trim().length() == 0) {
      throw new l("Blank value for version attribute");
    }
    try
    {
      paramm.a(Integer.parseInt(paramString));
      return;
    }
    catch (NumberFormatException paramm)
    {
      throw new l("Invalid version: " + paramm.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */