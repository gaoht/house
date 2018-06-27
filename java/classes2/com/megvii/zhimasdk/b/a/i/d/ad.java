package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f.b;
import com.megvii.zhimasdk.b.a.f.c;
import com.megvii.zhimasdk.b.a.f.e;
import com.megvii.zhimasdk.b.a.f.g;
import com.megvii.zhimasdk.b.a.f.l;
import com.megvii.zhimasdk.b.a.f.m;
import com.megvii.zhimasdk.b.a.f.n;
import java.util.StringTokenizer;

public class ad
  implements c
{
  private static boolean a(int paramInt, int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == paramArrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static int[] a(String paramString)
  {
    paramString = new StringTokenizer(paramString, ",");
    int[] arrayOfInt = new int[paramString.countTokens()];
    int i = 0;
    for (;;)
    {
      try
      {
        if (!paramString.hasMoreTokens()) {
          break;
        }
        arrayOfInt[i] = Integer.parseInt(paramString.nextToken().trim());
        if (arrayOfInt[i] < 0) {
          throw new l("Invalid Port attribute.");
        }
      }
      catch (NumberFormatException paramString)
      {
        throw new l("Invalid Port attribute: " + paramString.getMessage());
      }
      i += 1;
    }
    return arrayOfInt;
  }
  
  public void a(b paramb, e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramb, "Cookie");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "Cookie origin");
    int i = parame.c();
    if (((paramb instanceof com.megvii.zhimasdk.b.a.f.a)) && (((com.megvii.zhimasdk.b.a.f.a)paramb).b("port")) && (!a(i, paramb.f()))) {
      throw new g("Port attribute violates RFC 2965: Request port not found in cookie's port list.");
    }
  }
  
  public void a(m paramm, String paramString)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramm, "Cookie");
    if ((paramm instanceof n))
    {
      paramm = (n)paramm;
      if ((paramString != null) && (paramString.trim().length() > 0)) {
        paramm.a(a(paramString));
      }
    }
  }
  
  public boolean b(b paramb, e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramb, "Cookie");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "Cookie origin");
    int i = parame.c();
    if (((paramb instanceof com.megvii.zhimasdk.b.a.f.a)) && (((com.megvii.zhimasdk.b.a.f.a)paramb).b("port")))
    {
      if (paramb.f() == null) {
        return false;
      }
      if (!a(i, paramb.f())) {
        return false;
      }
    }
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */