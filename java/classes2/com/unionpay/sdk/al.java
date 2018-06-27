package com.unionpay.sdk;

import android.app.Activity;
import android.os.Message;
import java.util.HashMap;

final class al
  implements Runnable
{
  al(String paramString, Activity paramActivity, boolean paramBoolean) {}
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        k.a("onPause being called! pageName: " + this.a);
        ag.a locala = new ag.a();
        locala.a.put("context", this.b);
        HashMap localHashMap = locala.a;
        if (this.c)
        {
          i = 7;
          localHashMap.put("apiType", Integer.valueOf(i));
          locala.a.put("occurTime", String.valueOf(System.currentTimeMillis()));
          locala.a.put("pageName", this.a);
          Message.obtain(bk.a(), 102, locala).sendToTarget();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        int i;
        if (!UPAgent.LOG_ON) {
          continue;
        }
        localThrowable.printStackTrace();
      }
      i = 3;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */