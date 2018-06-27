package com.mato.sdk.e.b;

import android.content.Context;
import com.mato.sdk.d.h;
import com.mato.sdk.proxy.Proxy.NetDiagnosisListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

public final class d
{
  public static String[] a = { "www.baidu.com", "www.sina.com.cn", "www.qq.com", "www.163.com" };
  public static String[] b = { "http://www.baidu.com", "http://www.sina.com.cn", "http://www.qq.com", "http://www.163.com" };
  private static int c = 0;
  private static int d = 1;
  private static final String e = com.mato.sdk.b.g.b("DiagnosisHelper");
  private static final Map<String, a> f = new ConcurrentHashMap();
  
  public static k a(Context paramContext, i parami)
  {
    paramContext = new k(paramContext, parami);
    paramContext.a();
    return paramContext;
  }
  
  private static String a(h paramh)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramh = paramh.b.iterator();
    int i = 1;
    if (paramh.hasNext())
    {
      String str = (String)paramh.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append("(");
        localStringBuilder.append(str.replaceAll("\\.", "\\\\\\."));
        localStringBuilder.append(")");
        break;
        localStringBuilder.append("|");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, Proxy.NetDiagnosisListener paramNetDiagnosisListener)
  {
    new k(paramContext, new i()
    {
      public final void a(g paramAnonymousg) {}
      
      public final void b(g paramAnonymousg) {}
      
      public final void c(g paramAnonymousg)
      {
        String str;
        if (this.a != null) {
          str = "{}";
        }
        try
        {
          paramAnonymousg = paramAnonymousg.a();
          this.a.onCompleted(paramAnonymousg);
          return;
        }
        catch (JSONException paramAnonymousg)
        {
          for (;;)
          {
            paramAnonymousg = str;
          }
        }
      }
      
      public final void d(g paramAnonymousg) {}
    }).a();
  }
  
  public static void a(Context paramContext, Proxy.NetDiagnosisListener paramNetDiagnosisListener, h paramh)
  {
    new a(paramContext, paramNetDiagnosisListener, paramh).a();
  }
  
  public static void a(String paramString, a parama)
  {
    f.put(paramString, parama);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (f.containsKey(paramString2)) {
      ((a)f.get(paramString2)).a(paramString1);
    }
  }
  
  public static boolean a(String paramString)
  {
    return a(b, paramString);
  }
  
  public static boolean a(String[] paramArrayOfString, String paramString)
  {
    boolean bool2 = false;
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfString[i].equalsIgnoreCase(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static void b(String paramString)
  {
    f.remove(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */