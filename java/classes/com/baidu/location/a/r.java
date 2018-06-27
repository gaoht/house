package com.baidu.location.a;

import android.os.HandlerThread;

public class r
{
  private static HandlerThread a = null;
  
  public static HandlerThread a()
  {
    try
    {
      if (a == null)
      {
        a = new HandlerThread("ServiceStartArguments", 10);
        a.start();
      }
      HandlerThread localHandlerThread = a;
      return localHandlerThread;
    }
    finally {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */