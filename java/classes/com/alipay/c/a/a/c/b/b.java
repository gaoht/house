package com.alipay.c.a.a.c.b;

import android.content.Context;
import com.alipay.c.a.a.c.a.c;
import com.alipay.c.a.a.c.a.d;
import java.util.HashMap;
import java.util.Map;

public final class b
  implements a
{
  private static a a = null;
  private static com.alipay.c.a.a.c.a b = null;
  
  public static a a(Context paramContext, String paramString)
  {
    Object localObject = null;
    if (paramContext == null) {
      return null;
    }
    if (a == null) {
      if (paramContext != null) {
        break label38;
      }
    }
    label38:
    for (paramContext = (Context)localObject;; paramContext = com.alipay.c.a.a.c.b.a(paramContext, paramString))
    {
      b = paramContext;
      a = new b();
      return a;
    }
  }
  
  public final c a(d paramd)
  {
    com.alipay.f.a.a.b.a.a.a locala = new com.alipay.f.a.a.b.a.a.a();
    locala.c = com.alipay.c.a.a.a.a.c(paramd.a);
    locala.b = "8";
    locala.a = "1";
    locala.d = new HashMap();
    locala.d.put("apdid", com.alipay.c.a.a.a.a.c(paramd.b));
    locala.d.put("apdidToken", com.alipay.c.a.a.a.a.c(paramd.c));
    locala.d.put("umidToken", com.alipay.c.a.a.a.a.c(paramd.d));
    locala.d.put("dynamicKey", paramd.e);
    if (paramd.f == null) {}
    for (paramd = new HashMap();; paramd = paramd.f)
    {
      locala.e = paramd;
      return com.alipay.c.a.a.c.a.b.a(b.a(locala));
    }
  }
  
  public final boolean a(String paramString)
  {
    return b.a(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/c/a/a/c/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */