package com.g.a;

import android.util.Log;

public class h
{
  public static boolean a = true;
  
  private static String a()
  {
    try
    {
      String str = new Exception().getStackTrace()[4].getClassName();
      str.substring(str.lastIndexOf(".") + 1, str.length());
      return "TDLog";
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        av.postSDKError(localThrowable);
      }
    }
    finally {}
  }
  
  private static void a(String paramString, int paramInt)
  {
    int j = 0;
    if (paramString == null) {}
    for (;;)
    {
      return;
      try
      {
        int m = paramString.length();
        int i = 2000;
        int k = 0;
        while (j < 100)
        {
          if (m <= i) {
            break label59;
          }
          b(paramString.substring(k, i), paramInt);
          j += 1;
          k = i;
          i += 2000;
        }
        label59:
        b(paramString.substring(k, m), paramInt);
        return;
      }
      catch (Throwable paramString)
      {
        av.postSDKError(paramString);
      }
    }
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    if (a)
    {
      a(paramString, 4);
      paramThrowable.printStackTrace();
    }
  }
  
  private static void b(String paramString, int paramInt)
  {
    String str = a();
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      Log.v(str, paramString);
      return;
    case 4: 
      Log.i(str, paramString);
      return;
    case 3: 
      Log.d(str, paramString);
      return;
    case 5: 
      Log.w(str, paramString);
      return;
    }
    Log.e(str, paramString);
  }
  
  public static void dForDeveloper(String paramString)
  {
    if (a) {
      a(paramString, 3);
    }
  }
  
  public static void dForInternal(String... paramVarArgs) {}
  
  public static void eForDeveloper(String paramString)
  {
    if (a) {
      a(paramString, 6);
    }
  }
  
  public static void eForInternal(Throwable paramThrowable) {}
  
  public static void eForInternal(String... paramVarArgs) {}
  
  public static void iForDeveloper(String paramString)
  {
    if (a) {
      a(paramString, 4);
    }
  }
  
  public static void iForInternal(String... paramVarArgs) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */