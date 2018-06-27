package com.xiaomi.channel.commonutils.android;

import java.lang.reflect.Method;

public class i
{
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramString2;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/android/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */