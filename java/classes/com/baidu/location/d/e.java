package com.baidu.location.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import java.util.Map;

public abstract class e
{
  private static String a = "10.0.0.172";
  private static int b = 80;
  public static int g = a.g;
  protected static int o = 0;
  public String h = null;
  public int i = 3;
  public String j = null;
  public Map<String, Object> k = null;
  public String l = null;
  public byte[] m = null;
  public String n = null;
  
  private static int a(Context paramContext, NetworkInfo paramNetworkInfo)
  {
    if ((paramNetworkInfo != null) && (paramNetworkInfo.getExtraInfo() != null))
    {
      paramContext = paramNetworkInfo.getExtraInfo().toLowerCase();
      if (paramContext != null)
      {
        if ((paramContext.startsWith("cmwap")) || (paramContext.startsWith("uniwap")) || (paramContext.startsWith("3gwap")))
        {
          paramContext = Proxy.getDefaultHost();
          if ((paramContext != null) && (!paramContext.equals("")) && (!paramContext.equals("null"))) {}
          for (;;)
          {
            a = paramContext;
            return a.d;
            paramContext = "10.0.0.172";
          }
        }
        if (paramContext.startsWith("ctwap"))
        {
          paramContext = Proxy.getDefaultHost();
          if ((paramContext != null) && (!paramContext.equals("")) && (!paramContext.equals("null"))) {}
          for (;;)
          {
            a = paramContext;
            return a.d;
            paramContext = "10.0.0.200";
          }
        }
        if ((paramContext.startsWith("cmnet")) || (paramContext.startsWith("uninet")) || (paramContext.startsWith("ctnet")) || (paramContext.startsWith("3gnet"))) {
          return a.e;
        }
      }
    }
    paramContext = Proxy.getDefaultHost();
    if ((paramContext != null) && (paramContext.length() > 0))
    {
      if ("10.0.0.172".equals(paramContext.trim()))
      {
        a = "10.0.0.172";
        return a.d;
      }
      if ("10.0.0.200".equals(paramContext.trim()))
      {
        a = "10.0.0.200";
        return a.d;
      }
    }
    return a.e;
  }
  
  private void b()
  {
    g = c();
  }
  
  private int c()
  {
    Object localObject1 = com.baidu.location.f.getServiceContext();
    try
    {
      Object localObject2 = (ConnectivityManager)((Context)localObject1).getSystemService("connectivity");
      if (localObject2 == null) {
        return a.g;
      }
      localObject2 = ((ConnectivityManager)localObject2).getActiveNetworkInfo();
      if ((localObject2 == null) || (!((NetworkInfo)localObject2).isAvailable())) {
        return a.g;
      }
      if (((NetworkInfo)localObject2).getType() == 1)
      {
        localObject1 = Proxy.getDefaultHost();
        if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
          return a.h;
        }
        return a.f;
      }
      int i1 = a((Context)localObject1, (NetworkInfo)localObject2);
      return i1;
    }
    catch (Exception localException) {}
    return a.g;
  }
  
  public abstract void a();
  
  public abstract void a(boolean paramBoolean);
  
  public void b(boolean paramBoolean)
  {
    new g(this, paramBoolean).start();
  }
  
  public void d()
  {
    new f(this).start();
  }
  
  public void e()
  {
    b(false);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */