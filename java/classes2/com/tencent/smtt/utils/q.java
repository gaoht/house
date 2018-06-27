package com.tencent.smtt.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

public class q
{
  private static Class a;
  private static Method b;
  
  static
  {
    try
    {
      a = Class.forName("android.os.SystemProperties");
      b = a.getDeclaredMethod("get", new Class[] { String.class, String.class });
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    return b(paramString1, paramString2);
  }
  
  private static String b(String paramString1, String paramString2)
  {
    if ((a == null) || (b == null)) {
      return paramString2;
    }
    try
    {
      paramString1 = (String)b.invoke(a, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramString2;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/utils/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */