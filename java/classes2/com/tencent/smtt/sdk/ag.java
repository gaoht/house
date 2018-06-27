package com.tencent.smtt.sdk;

import android.os.HandlerThread;

class ag
  extends HandlerThread
{
  private static ag a;
  
  public ag(String paramString)
  {
    super(paramString);
  }
  
  public static ag a()
  {
    try
    {
      if (a == null)
      {
        a = new ag("TbsHandlerThread");
        a.start();
      }
      ag localag = a;
      return localag;
    }
    finally {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */