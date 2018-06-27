package com.superrtc.mediamanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;

public class RTCNetworkReceiver
  extends BroadcastReceiver
{
  private b a;
  
  public static a getNetworkType(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()))
    {
      int i = localNetworkInfo.getType();
      if ((Build.VERSION.SDK_INT >= 13) && (i == 9)) {
        return a.c;
      }
      if (i == 1) {
        return a.b;
      }
      switch (((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType())
      {
      default: 
        return a.c;
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
        return a.c;
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 14: 
      case 15: 
        return a.c;
      }
      return a.c;
    }
    return a.a;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a != null) {
      this.a.onNetworkChanged(getNetworkType(paramContext).ordinal());
    }
  }
  
  public void setNetworkListener(b paramb)
  {
    this.a = paramb;
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void onNetworkChanged(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/mediamanager/RTCNetworkReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */