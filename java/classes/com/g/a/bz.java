package com.g.a;

import android.os.SystemClock;

public class bz
  extends br
{
  private int a = 0;
  
  public bz()
  {
    a("bootTime", Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
    a("activeTime", Long.valueOf(SystemClock.elapsedRealtime()));
    a("freeDiskSpace", Integer.valueOf(a()));
  }
  
  private int a()
  {
    try
    {
      int i = n.n()[1];
      return i;
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */