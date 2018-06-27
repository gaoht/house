package com.megvii.zhimasdk.b.a.i.b;

import com.megvii.zhimasdk.b.a.f;
import com.megvii.zhimasdk.b.a.k.d;
import com.megvii.zhimasdk.b.a.n.e;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.s;

public class j
  implements com.megvii.zhimasdk.b.a.e.g
{
  public static final j a = new j();
  
  public long a(s params, e parame)
  {
    a.a(params, "HTTP response");
    params = new d(params.e("Keep-Alive"));
    for (;;)
    {
      Object localObject;
      if (params.hasNext())
      {
        localObject = params.a();
        parame = ((f)localObject).a();
        localObject = ((f)localObject).b();
        if ((localObject == null) || (!parame.equalsIgnoreCase("timeout"))) {}
      }
      else
      {
        try
        {
          long l = Long.parseLong((String)localObject);
          return l * 1000L;
        }
        catch (NumberFormatException parame) {}
        return -1L;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */