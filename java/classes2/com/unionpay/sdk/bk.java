package com.unionpay.sdk;

import android.os.Handler;
import android.os.HandlerThread;

final class bk
{
  private static Handler a = new f(b.getLooper());
  private static final HandlerThread b;
  
  static
  {
    HandlerThread localHandlerThread = new HandlerThread("ProcessingThread");
    b = localHandlerThread;
    localHandlerThread.start();
  }
  
  static final Handler a()
  {
    return a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */