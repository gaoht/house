package in.srain.cube.views.ptr.b;

import android.util.Log;

public class a
{
  private static int a = 0;
  
  public static void d(String paramString1, String paramString2)
  {
    if (a > 1) {
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a > 1) {
      return;
    }
    Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a > 1) {
      return;
    }
    String str = paramString2;
    if (paramVarArgs.length > 0) {
      str = String.format(paramString2, paramVarArgs);
    }
    Log.d(paramString1, str);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (a > 4) {
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a > 4) {
      return;
    }
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a > 4) {
      return;
    }
    String str = paramString2;
    if (paramVarArgs.length > 0) {
      str = String.format(paramString2, paramVarArgs);
    }
    Log.e(paramString1, str);
  }
  
  public static void f(String paramString1, String paramString2)
  {
    if (a > 5) {
      return;
    }
    Log.wtf(paramString1, paramString2);
  }
  
  public static void f(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a > 5) {
      return;
    }
    Log.wtf(paramString1, paramString2, paramThrowable);
  }
  
  public static void f(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a > 5) {
      return;
    }
    String str = paramString2;
    if (paramVarArgs.length > 0) {
      str = String.format(paramString2, paramVarArgs);
    }
    Log.wtf(paramString1, str);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (a > 2) {
      return;
    }
    Log.i(paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a > 2) {
      return;
    }
    Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a > 2) {
      return;
    }
    String str = paramString2;
    if (paramVarArgs.length > 0) {
      str = String.format(paramString2, paramVarArgs);
    }
    Log.i(paramString1, str);
  }
  
  public static void setLogLevel(int paramInt)
  {
    a = paramInt;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (a > 0) {
      return;
    }
    Log.v(paramString1, paramString2);
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a > 0) {
      return;
    }
    Log.v(paramString1, paramString2, paramThrowable);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a > 0) {
      return;
    }
    String str = paramString2;
    if (paramVarArgs.length > 0) {
      str = String.format(paramString2, paramVarArgs);
    }
    Log.v(paramString1, str);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (a > 3) {
      return;
    }
    Log.w(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a > 3) {
      return;
    }
    Log.w(paramString1, paramString2, paramThrowable);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a > 3) {
      return;
    }
    String str = paramString2;
    if (paramVarArgs.length > 0) {
      str = String.format(paramString2, paramVarArgs);
    }
    Log.w(paramString1, str);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/in/srain/cube/views/ptr/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */