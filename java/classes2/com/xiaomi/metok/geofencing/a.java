package com.xiaomi.metok.geofencing;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.util.Log;

public class a
{
  private Context a;
  private c b;
  private boolean c = false;
  private final ServiceConnection d = new b(this);
  
  public a(Context paramContext)
  {
    this.a = paramContext;
    this.c = false;
    a(paramContext);
  }
  
  public void a(Context paramContext)
  {
    if (this.c) {}
    while (paramContext == null) {
      return;
    }
    if (this.b == null)
    {
      Intent localIntent = new Intent("com.xiaomi.metok.GeoFencingService");
      localIntent.setPackage("com.xiaomi.metok");
      try
      {
        if (!paramContext.bindService(localIntent, this.d, 1))
        {
          Log.d("GeoFencingServiceWrapper", "Can't bind GeoFencingService");
          this.c = false;
          return;
        }
      }
      catch (SecurityException paramContext)
      {
        Log.e("GeoFencingServiceWrapper", "SecurityException:" + paramContext);
        return;
      }
      Log.d("GeoFencingServiceWrapper", "GeoFencingService started");
      this.c = true;
      return;
    }
    Log.d("GeoFencingServiceWrapper", "GeoFencingService already started");
  }
  
  public void a(Context paramContext, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    a(paramContext);
    if (this.b != null) {}
    try
    {
      this.b.a(paramDouble1, paramDouble2, paramFloat, paramLong, paramString1, paramString2, paramString3);
      Log.d("GeoFencingServiceWrapper", "calling registerFenceListener success");
      return;
    }
    catch (RemoteException paramContext)
    {
      throw new RuntimeException("GeoFencingService has died", paramContext);
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext);
    if (this.b != null) {}
    try
    {
      this.b.a(paramString1, paramString2);
      Log.d("GeoFencingServiceWrapper", "calling unregisterFenceListener success");
      return;
    }
    catch (RemoteException paramContext)
    {
      throw new RuntimeException("GeoFencingService has died", paramContext);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/metok/geofencing/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */