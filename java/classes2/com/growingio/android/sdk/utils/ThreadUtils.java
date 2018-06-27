package com.growingio.android.sdk.utils;

import android.os.Handler;
import android.os.Looper;

public class ThreadUtils
{
  private static final Object b;
  private static boolean c;
  private static Handler d;
  
  static
  {
    if (!ThreadUtils.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      b = new Object();
      c = false;
      d = null;
      return;
    }
  }
  
  public static void a(Runnable paramRunnable)
  {
    if (a())
    {
      paramRunnable.run();
      return;
    }
    b().post(paramRunnable);
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    b().postDelayed(paramRunnable, paramLong);
  }
  
  public static boolean a()
  {
    return b().getLooper() == Looper.myLooper();
  }
  
  private static Handler b()
  {
    synchronized (b)
    {
      if (d != null) {
        break label46;
      }
      if (c) {
        throw new RuntimeException("Did not yet override the UI thread");
      }
    }
    d = new Handler(Looper.getMainLooper());
    label46:
    Handler localHandler = d;
    return localHandler;
  }
  
  public static void b(Runnable paramRunnable)
  {
    b().post(paramRunnable);
  }
  
  public static void c(Runnable paramRunnable)
  {
    b().removeCallbacks(paramRunnable);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/utils/ThreadUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */