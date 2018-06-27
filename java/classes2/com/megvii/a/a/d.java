package com.megvii.a.a;

import android.util.Log;

public final class d
{
  private static boolean a = false;
  private static String b = "MegviiSDK";
  
  public static void a()
  {
    a = true;
  }
  
  public static void a(String paramString)
  {
    b(b, paramString);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    String str;
    if (a)
    {
      str = paramString1;
      if (paramString1 == null) {
        str = b;
      }
      if (paramString2 == null) {
        break label27;
      }
    }
    for (;;)
    {
      Log.e(str, paramString2);
      return;
      label27:
      paramString2 = "";
    }
  }
  
  public static void b()
  {
    a = false;
  }
  
  public static void b(String paramString)
  {
    a(b, paramString);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    String str;
    if (a)
    {
      str = paramString1;
      if (paramString1 == null) {
        str = b;
      }
      if (paramString2 == null) {
        break label27;
      }
    }
    for (;;)
    {
      Log.d(str, paramString2);
      return;
      label27:
      paramString2 = "";
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */