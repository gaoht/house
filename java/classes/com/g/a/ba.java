package com.g.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class ba
  extends BroadcastReceiver
{
  am a = new am();
  ArrayList b;
  JSONArray c;
  al d;
  al e;
  double f = 0.0D;
  long g = 0L;
  long h = 0L;
  private long i = 180000L;
  private WifiManager j;
  
  public ba(WifiManager paramWifiManager)
  {
    this.j = paramWifiManager;
  }
  
  private al a(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      ArrayList localArrayList = new ArrayList();
      int k = 0;
      for (;;)
      {
        if (k < paramJSONArray.length()) {
          try
          {
            JSONObject localJSONObject = paramJSONArray.getJSONObject(k);
            localArrayList.add(new aj(localJSONObject.getString("SSID"), localJSONObject.getString("BSSID"), (byte)localJSONObject.getInt("level"), (byte)0, (byte)0));
            k += 1;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              av.postSDKError(localThrowable);
            }
          }
        }
      }
      paramJSONArray = new al();
      paramJSONArray.setBsslist(localArrayList);
      return paramJSONArray;
    }
    return null;
  }
  
  private void a()
  {
    try
    {
      be localbe = new be();
      localbe.b = "env";
      localbe.c = "wifiUpdate";
      localbe.a = a.b;
      ad.a().post(localbe);
      return;
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
  }
  
  private al b()
  {
    try
    {
      this.d = a(this.c);
      return this.d;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        av.postSDKError(localThrowable);
      }
    }
  }
  
  private al c()
  {
    for (;;)
    {
      try
      {
        this.b = ((ArrayList)this.j.getScanResults());
        localObject = this.b;
        if (localObject == null) {
          continue;
        }
      }
      catch (Throwable localThrowable2)
      {
        Object localObject;
        int k;
        av.postSDKError(localThrowable2);
        continue;
        k += 1;
        continue;
      }
      try
      {
        localObject = new JSONArray();
        k = 0;
        if (k < this.b.size())
        {
          if (((ScanResult)this.b.get(k)).level < -75) {
            continue;
          }
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("SSID", ((ScanResult)this.b.get(k)).SSID);
          localJSONObject.put("BSSID", ((ScanResult)this.b.get(k)).BSSID);
          localJSONObject.put("level", ((ScanResult)this.b.get(k)).level);
          ((JSONArray)localObject).put(localJSONObject);
        }
      }
      catch (Throwable localThrowable1)
      {
        av.postSDKError(localThrowable1);
      }
    }
    for (;;)
    {
      return this.e;
      this.c = localThrowable1;
      this.e = a(localThrowable1);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    at.a.post(new bb(this));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */