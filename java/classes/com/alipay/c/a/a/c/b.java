package com.alipay.c.a.a.c;

import android.content.Context;
import com.alipay.android.a.a.a.d;
import com.alipay.android.a.a.a.h;
import com.alipay.android.a.a.a.r;
import org.json.JSONObject;

public final class b
  implements a
{
  private static b d = null;
  private static com.alipay.f.a.a.b.a.a.b e;
  private d a = null;
  private com.alipay.f.a.a.a.a b = null;
  private com.alipay.f.a.a.b.a.a c = null;
  
  private b(Context paramContext, String paramString)
  {
    h localh = new h();
    localh.a = paramString;
    this.a = new r(paramContext);
    this.b = ((com.alipay.f.a.a.a.a)this.a.a(com.alipay.f.a.a.a.a.class, localh));
    this.c = ((com.alipay.f.a.a.b.a.a)this.a.a(com.alipay.f.a.a.b.a.a.class, localh));
  }
  
  public static b a(Context paramContext, String paramString)
  {
    try
    {
      if (d == null) {
        d = new b(paramContext, paramString);
      }
      paramContext = d;
      return paramContext;
    }
    finally {}
  }
  
  public final com.alipay.f.a.a.b.a.a.b a(com.alipay.f.a.a.b.a.a.a parama)
  {
    if (this.c != null)
    {
      e = null;
      new Thread(new c(this, parama)).start();
      int i = 300000;
      while ((e == null) && (i >= 0))
      {
        Thread.sleep(50L);
        i -= 50;
      }
    }
    return e;
  }
  
  public final boolean a(String paramString)
  {
    if (com.alipay.c.a.a.a.a.a(paramString)) {
      return false;
    }
    Object localObject;
    if (this.b != null) {
      localObject = null;
    }
    for (;;)
    {
      try
      {
        com.alipay.f.a.a.a.a locala = this.b;
        com.alipay.c.a.a.a.a.e(paramString);
        paramString = locala.a();
        if (!com.alipay.c.a.a.a.a.a(paramString))
        {
          bool = ((Boolean)new JSONObject(paramString).get("success")).booleanValue();
          return bool;
        }
      }
      catch (Throwable paramString)
      {
        paramString = (String)localObject;
        continue;
      }
      boolean bool = false;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/c/a/a/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */