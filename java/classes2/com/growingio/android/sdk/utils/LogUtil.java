package com.growingio.android.sdk.utils;

import android.util.Log;
import com.growingio.android.sdk.collection.GConfig;

public class LogUtil
{
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (GConfig.DEBUG) {
      Log.d(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    if (GConfig.DEBUG)
    {
      String str = "";
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramVarArgs[i];
        str = str + localObject;
        i += 1;
      }
      Log.d(paramString, str);
    }
  }
  
  public static void d(Throwable paramThrowable)
  {
    if (GConfig.DEBUG) {
      paramThrowable.printStackTrace();
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (GConfig.DEBUG) {
      Log.e(paramString1, paramString2);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (GConfig.DEBUG) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (GConfig.DEBUG) {
      Log.v(paramString1, paramString2);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/utils/LogUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */