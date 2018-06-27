package com.superrtc.sdk;

import android.util.Log;

public class a
{
  private static String a(String paramString1, String paramString2)
  {
    return "<" + Thread.currentThread().getId() + "> |" + paramString1 + "| " + paramString2;
  }
  
  public static void e(String paramString1, String paramString2)
  {
    Log.e("alog", a(paramString1, paramString2));
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    paramThrowable.printStackTrace();
    Log.e("alog", a(paramString1, new StringBuilder().append(paramString2).append(" ,").toString()) + paramThrowable.getMessage());
  }
  
  public static void i(String paramString1, String paramString2)
  {
    Log.i("alog", a(paramString1, paramString2));
  }
  
  public static void w(String paramString1, String paramString2)
  {
    Log.w("alog", a(paramString1, paramString2));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/sdk/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */