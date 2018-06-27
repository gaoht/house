package com.megvii.zhimasdk.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.provider.Settings.System;

public class a
{
  public static boolean a(Context paramContext)
  {
    int i = b(paramContext);
    return (i != 3) && (i != 0);
  }
  
  public static int b(Context paramContext)
  {
    int j = 0;
    int k = c(paramContext);
    int i;
    if (k == 1) {
      i = d(paramContext);
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (k == 0);
      i = j;
    } while (k != -1);
    return 3;
  }
  
  public static int c(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    paramContext = Settings.System.getString(paramContext.getContentResolver(), "airplane_mode_on");
    if ((paramContext != null) && (paramContext.equalsIgnoreCase("1"))) {
      return -1;
    }
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected())) {
      return 1;
    }
    return 0;
  }
  
  public static int d(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext != null)
    {
      int i = paramContext.getType();
      paramContext = paramContext.getState();
      if ((i == 1) && (paramContext == NetworkInfo.State.CONNECTED)) {
        return 1;
      }
      if ((i == 0) && (paramContext == NetworkInfo.State.CONNECTED)) {
        return 2;
      }
    }
    return 0;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */