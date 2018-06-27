package com.unionpay.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.lang.reflect.Method;

final class ab
  implements m
{
  public final void a(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (r.d) {
      k.b(new String[] { "location method already called" });
    }
    while ((!paramMethod.getName().equalsIgnoreCase("getLastKnownLocation")) && (!paramMethod.getName().equalsIgnoreCase("requestLocationUpdates")) && (!paramMethod.getName().equalsIgnoreCase("getScanResults"))) {
      return;
    }
    if (d.c != null) {
      d.c.getSharedPreferences("UP_CHANNEL_ID", 0).edit().putBoolean("location_called", true).commit();
    }
    r.d = true;
    k.b(new String[] { paramMethod.getName() + " calling" });
  }
  
  public final void a(Object paramObject1, Method paramMethod, Object[] paramArrayOfObject, Object paramObject2) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */