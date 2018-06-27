package com.baidu.mapapi.utils;

import android.content.Context;

final class e
  implements Runnable
{
  e(Context paramContext, int paramInt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    do
    {
      if (System.currentTimeMillis() - l > 3000L)
      {
        a.a(this.a);
        a.a(this.b, this.a);
      }
    } while (!a.d().isInterrupted());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/utils/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */