package com.hyphenate.util;

import com.hyphenate.chat.adapter.EMAChatConfig;

public class EMLog
{
  public static boolean debugMode = false;
  
  public static void d(String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    while (!debugMode) {
      return;
    }
    EMAChatConfig.logD(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    while (!debugMode) {
      return;
    }
    EMAChatConfig.logE(paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    while (!debugMode) {
      return;
    }
    EMAChatConfig.logI(paramString1, paramString2);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    while (!debugMode) {
      return;
    }
    EMAChatConfig.logV(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    while (!debugMode) {
      return;
    }
    EMAChatConfig.logW(paramString1, paramString2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/util/EMLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */