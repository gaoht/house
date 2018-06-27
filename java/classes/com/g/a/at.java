package com.g.a;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import java.util.Map;

public final class at
{
  static Handler a;
  static HandlerThread b;
  private static volatile at c = null;
  private static WifiManager d;
  
  static
  {
    a = null;
    b = null;
    try
    {
      ad.a().register(a());
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private at()
  {
    try
    {
      b = new HandlerThread("locHandlerThread");
      b.start();
      a = new au(this, b.getLooper());
      a(4, 0L);
      return;
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
  }
  
  public static at a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new at();
      }
      return c;
    }
    finally {}
  }
  
  private void b()
  {
    try
    {
      if (!a("check_wifi_permission"))
      {
        a(1, 180000L);
        return;
      }
      Object localObject = c.e;
      Context localContext = c.e;
      d = (WifiManager)((Context)localObject).getSystemService("wifi");
      if (d.isWifiEnabled())
      {
        localObject = new ba(d);
        c.e.registerReceiver((BroadcastReceiver)localObject, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        return;
      }
    }
    catch (Throwable localThrowable) {}
  }
  
  private void c()
  {
    if (!a("check_gps_permission"))
    {
      a(2, 600000L);
      return;
    }
    try
    {
      be localbe = new be();
      localbe.b = "env";
      localbe.c = "locationUpdate";
      localbe.a = a.b;
      ad.a().post(localbe);
      a(2, 600000L);
      return;
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
  }
  
  @TargetApi(23)
  private void d()
  {
    try
    {
      if (!a("check_bs_permission"))
      {
        a(3, 180000L);
        return;
      }
      Object localObject = c.e;
      if (localObject != null) {
        try
        {
          localObject = c.e;
          Context localContext = c.e;
          localObject = (TelephonyManager)((Context)localObject).getSystemService("phone");
          if (((TelephonyManager)localObject).getSimState() == 5)
          {
            ((TelephonyManager)localObject).getCellLocation();
            ((TelephonyManager)localObject).listen(new az(), 16);
            CellLocation.requestLocationUpdate();
            return;
          }
        }
        catch (Throwable localThrowable1) {}
      }
      return;
    }
    catch (Throwable localThrowable2)
    {
      av.postSDKError(localThrowable2);
    }
  }
  
  protected void a(int paramInt, long paramLong)
  {
    try
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      a.sendMessageDelayed(localMessage, paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
  }
  
  protected boolean a(String paramString)
  {
    if (z.a(23)) {}
    for (;;)
    {
      int i;
      int j;
      boolean bool1;
      boolean bool2;
      try
      {
        i = c.e.checkSelfPermission("android.permission.READ_PHONE_STATE");
        if (i != 0) {
          break label246;
        }
        i = 1;
      }
      catch (Throwable localThrowable1)
      {
        label68:
        i = 0;
      }
      try
      {
        if (c.e.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0)
        {
          int k = c.e.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION");
          j = i;
          if (k != 0) {
            break label233;
          }
        }
        bool1 = true;
      }
      catch (Throwable localThrowable4)
      {
        for (;;)
        {
          continue;
          bool2 = false;
          break label68;
          label233:
          bool1 = false;
          i = j;
          break;
          label241:
          i = 0;
        }
      }
      if (z.b(c.e, "android.permission.ACCESS_WIFI_STATE"))
      {
        bool2 = true;
        if (paramString.equals("check_bs_permission"))
        {
          if ((bool1) && (i != 0))
          {
            return true;
            av.postSDKError(localThrowable1);
            bool1 = false;
            continue;
            try
            {
              bool1 = z.b(c.e, "android.permission.READ_PHONE_STATE");
              if (!bool1) {
                break label241;
              }
              i = 1;
            }
            catch (Throwable localThrowable2)
            {
              try
              {
                if (!z.b(c.e, "android.permission.ACCESS_COARSE_LOCATION"))
                {
                  bool1 = z.b(c.e, "android.permission.ACCESS_FINE_LOCATION");
                  j = i;
                  if (!bool1) {
                    break label233;
                  }
                }
                bool1 = true;
              }
              catch (Throwable localThrowable3)
              {
                for (;;) {}
              }
              localThrowable2 = localThrowable2;
              i = 0;
            }
            av.postSDKError(localThrowable2);
            bool1 = false;
          }
          else
          {
            return false;
          }
        }
        else
        {
          if (paramString.equals("check_gps_permission")) {
            return bool1;
          }
          if (paramString.equals("check_wifi_permission"))
          {
            if (z.a(23))
            {
              if ((!bool2) || (!bool1)) {
                return false;
              }
            }
            else {
              return bool2;
            }
          }
          else {
            return false;
          }
        }
      }
      else
      {
        label246:
        i = 0;
      }
    }
  }
  
  public final void onTDEBEventLocationEvent(bc parambc)
  {
    try
    {
      if (Integer.parseInt(String.valueOf(parambc.a.get("eventType"))) != 5) {
        return;
      }
      parambc = new be();
      parambc.b = "env";
      parambc.c = "lwcUpdate";
      parambc.a = a.b;
      ad.a().post(parambc);
      return;
    }
    catch (Throwable parambc)
    {
      av.postSDKError(parambc);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */