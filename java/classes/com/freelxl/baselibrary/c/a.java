package com.freelxl.baselibrary.c;

import android.text.TextUtils;
import android.util.Log;
import com.freelxl.baselibrary.f.e;

public class a
{
  public static String a = "";
  public static boolean b = true;
  public static boolean c = true;
  public static boolean d = true;
  public static boolean e = true;
  public static boolean f = true;
  public static boolean g = true;
  public static a h;
  
  private static String a(StackTraceElement paramStackTraceElement)
  {
    String str = paramStackTraceElement.getClassName();
    paramStackTraceElement = String.format("%s.%s(L:%d)", new Object[] { str.substring(str.lastIndexOf(".") + 1), paramStackTraceElement.getMethodName(), Integer.valueOf(paramStackTraceElement.getLineNumber()) });
    if (TextUtils.isEmpty(a)) {
      return paramStackTraceElement;
    }
    return a + ":" + paramStackTraceElement;
  }
  
  public static void d(String paramString)
  {
    if (!b) {
      return;
    }
    String str = a(e.getCallerStackTraceElement());
    if (h != null)
    {
      h.d(str, paramString);
      return;
    }
    Log.d(str, paramString);
  }
  
  public static void d(String paramString, Throwable paramThrowable)
  {
    if (!b) {
      return;
    }
    String str = a(e.getCallerStackTraceElement());
    if (h != null)
    {
      h.d(str, paramString, paramThrowable);
      return;
    }
    Log.d(str, paramString, paramThrowable);
  }
  
  public static void e(String paramString)
  {
    if (!c) {
      return;
    }
    String str = a(e.getCallerStackTraceElement());
    if (h != null)
    {
      h.e(str, paramString);
      return;
    }
    Log.e(str, paramString);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    if (!c) {
      return;
    }
    String str = a(e.getCallerStackTraceElement());
    if (h != null)
    {
      h.e(str, paramString, paramThrowable);
      return;
    }
    Log.e(str, paramString, paramThrowable);
  }
  
  public static void i(String paramString)
  {
    if (!d) {
      return;
    }
    String str = a(e.getCallerStackTraceElement());
    if (h != null)
    {
      h.i(str, paramString);
      return;
    }
    Log.i(str, paramString);
  }
  
  public static void i(String paramString, Throwable paramThrowable)
  {
    if (!d) {
      return;
    }
    String str = a(e.getCallerStackTraceElement());
    if (h != null)
    {
      h.i(str, paramString, paramThrowable);
      return;
    }
    Log.i(str, paramString, paramThrowable);
  }
  
  public static void v(String paramString)
  {
    if (!e) {
      return;
    }
    String str = a(e.getCallerStackTraceElement());
    if (h != null)
    {
      h.v(str, paramString);
      return;
    }
    Log.v(str, paramString);
  }
  
  public static void v(String paramString, Throwable paramThrowable)
  {
    if (!e) {
      return;
    }
    String str = a(e.getCallerStackTraceElement());
    if (h != null)
    {
      h.v(str, paramString, paramThrowable);
      return;
    }
    Log.v(str, paramString, paramThrowable);
  }
  
  public static void w(String paramString)
  {
    if (!f) {
      return;
    }
    String str = a(e.getCallerStackTraceElement());
    if (h != null)
    {
      h.w(str, paramString);
      return;
    }
    Log.w(str, paramString);
  }
  
  public static void w(String paramString, Throwable paramThrowable)
  {
    if (!f) {
      return;
    }
    String str = a(e.getCallerStackTraceElement());
    if (h != null)
    {
      h.w(str, paramString, paramThrowable);
      return;
    }
    Log.w(str, paramString, paramThrowable);
  }
  
  public static void w(Throwable paramThrowable)
  {
    if (!f) {
      return;
    }
    String str = a(e.getCallerStackTraceElement());
    if (h != null)
    {
      h.w(str, paramThrowable);
      return;
    }
    Log.w(str, paramThrowable);
  }
  
  public static void wtf(String paramString)
  {
    if (!g) {
      return;
    }
    String str = a(e.getCallerStackTraceElement());
    if (h != null)
    {
      h.wtf(str, paramString);
      return;
    }
    Log.wtf(str, paramString);
  }
  
  public static void wtf(String paramString, Throwable paramThrowable)
  {
    if (!g) {
      return;
    }
    String str = a(e.getCallerStackTraceElement());
    if (h != null)
    {
      h.wtf(str, paramString, paramThrowable);
      return;
    }
    Log.wtf(str, paramString, paramThrowable);
  }
  
  public static void wtf(Throwable paramThrowable)
  {
    if (!g) {
      return;
    }
    String str = a(e.getCallerStackTraceElement());
    if (h != null)
    {
      h.wtf(str, paramThrowable);
      return;
    }
    Log.wtf(str, paramThrowable);
  }
  
  public static abstract interface a
  {
    public abstract void d(String paramString1, String paramString2);
    
    public abstract void d(String paramString1, String paramString2, Throwable paramThrowable);
    
    public abstract void e(String paramString1, String paramString2);
    
    public abstract void e(String paramString1, String paramString2, Throwable paramThrowable);
    
    public abstract void i(String paramString1, String paramString2);
    
    public abstract void i(String paramString1, String paramString2, Throwable paramThrowable);
    
    public abstract void v(String paramString1, String paramString2);
    
    public abstract void v(String paramString1, String paramString2, Throwable paramThrowable);
    
    public abstract void w(String paramString1, String paramString2);
    
    public abstract void w(String paramString1, String paramString2, Throwable paramThrowable);
    
    public abstract void w(String paramString, Throwable paramThrowable);
    
    public abstract void wtf(String paramString1, String paramString2);
    
    public abstract void wtf(String paramString1, String paramString2, Throwable paramThrowable);
    
    public abstract void wtf(String paramString, Throwable paramThrowable);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */