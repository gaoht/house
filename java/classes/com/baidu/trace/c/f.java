package com.baidu.trace.c;

import android.os.Build;
import android.os.Build.VERSION;

public final class f
{
  public static final String a = Build.BRAND + "-" + Build.MODEL;
  public static final String b = Build.CPU_ABI;
  public static final String c = "android" + Build.VERSION.RELEASE;
  
  public static enum a
  {
    static
    {
      a locala = a;
      locala = b;
    }
    
    private a() {}
  }
  
  public static enum b
  {
    private b() {}
    
    public static b[] a()
    {
      return (b[])e.clone();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */