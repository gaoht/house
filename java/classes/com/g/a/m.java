package com.g.a;

import android.content.Context;
import java.lang.reflect.Method;

final class m
  extends Thread
{
  m(Context paramContext) {}
  
  public void run()
  {
    try
    {
      l.a(true);
      Object localObject = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[] { Context.class }).invoke(null, new Object[] { this.a });
      l.a((String)Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(localObject, new Object[0]));
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */