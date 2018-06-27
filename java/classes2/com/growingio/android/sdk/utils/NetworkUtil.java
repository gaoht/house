package com.growingio.android.sdk.utils;

import android.text.TextUtils;

public class NetworkUtil
{
  public static String a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
    }
    while ((!paramString.equalsIgnoreCase("TD-SCDMA")) && (!paramString.equalsIgnoreCase("WCDMA")) && (!paramString.equalsIgnoreCase("CDMA2000")))
    {
      return "UNKNOWN";
      return "2G";
      return "3G";
      return "4G";
    }
    return "3G";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/utils/NetworkUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */