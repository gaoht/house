package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f.l;
import com.megvii.zhimasdk.b.a.f.m;

public class o
  extends a
{
  public void a(m paramm, String paramString)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramm, "Cookie");
    if (paramString == null) {
      throw new l("Missing value for version attribute");
    }
    int i = 0;
    try
    {
      int j = Integer.parseInt(paramString);
      i = j;
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
    paramm.a(i);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */