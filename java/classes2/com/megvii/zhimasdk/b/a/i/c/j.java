package com.megvii.zhimasdk.b.a.i.c;

import com.megvii.zhimasdk.b.a.e.r;
import com.megvii.zhimasdk.b.a.e.s;
import com.megvii.zhimasdk.b.a.n;
import com.megvii.zhimasdk.b.a.o.a;

public class j
  implements r
{
  public static final j a = new j();
  
  public int a(n paramn)
  {
    a.a(paramn, "HTTP host");
    int i = paramn.b();
    if (i > 0) {
      return i;
    }
    paramn = paramn.c();
    if (paramn.equalsIgnoreCase("http")) {
      return 80;
    }
    if (paramn.equalsIgnoreCase("https")) {
      return 443;
    }
    throw new s(paramn + " protocol is not supported");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */