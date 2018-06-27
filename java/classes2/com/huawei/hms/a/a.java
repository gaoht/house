package com.huawei.hms.a;

import android.os.Looper;

public final class a
{
  public static <T> T a(T paramT, String paramString)
  {
    if (paramT == null) {
      throw new NullPointerException(String.valueOf(paramString));
    }
    return paramT;
  }
  
  public static void a(String paramString)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException(paramString);
    }
  }
  
  public static <T> T b(T paramT, String paramString)
  {
    if (paramT == null) {
      throw new NullPointerException(String.valueOf(paramString));
    }
    return paramT;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/huawei/hms/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */