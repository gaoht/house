package com.baidu.trace.c;

import android.util.Log;
import java.text.SimpleDateFormat;

public final class h
{
  private static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss-SSS");
  private static a.1 b = null;
  private static a.1 c = null;
  
  static
  {
    new SimpleDateFormat("yyyy-MM-dd");
  }
  
  public static void a() {}
  
  public static void a(String paramString1, String paramString2)
  {
    a locala = a.b;
    switch (1.a[locala.ordinal()])
    {
    }
    for (;;)
    {
      "Error".equals(paramString1);
      return;
      Log.d(paramString1, paramString2);
      continue;
      Log.i(paramString1, paramString2);
      continue;
      Log.w(paramString1, paramString2);
      continue;
      Log.e(paramString1, paramString2);
    }
  }
  
  public static void b() {}
  
  public static enum a
  {
    private a(int paramInt) {}
    
    public static a[] a()
    {
      return (a[])e.clone();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */