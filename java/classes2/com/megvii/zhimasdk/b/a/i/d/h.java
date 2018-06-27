package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f.l;
import com.megvii.zhimasdk.b.a.f.m;
import java.util.Date;

public class h
  extends a
{
  public void a(m paramm, String paramString)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramm, "Cookie");
    if (paramString == null) {
      throw new l("Missing value for max-age attribute");
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0) {
        throw new l("Negative max-age attribute: " + paramString);
      }
    }
    catch (NumberFormatException paramm)
    {
      throw new l("Invalid max-age attribute: " + paramString);
    }
    paramm.b(new Date(System.currentTimeMillis() + i * 1000L));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */