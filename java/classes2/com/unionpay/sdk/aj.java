package com.unionpay.sdk;

import android.app.Activity;
import android.os.Message;
import java.util.HashMap;

final class aj
  implements Runnable
{
  aj(String paramString, boolean paramBoolean, Activity paramActivity) {}
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        k.a("onResume being called! pageName: " + this.a + "From: " + String.valueOf(this.b));
        ag.a locala = new ag.a();
        locala.a.put("context", this.c);
        HashMap localHashMap = locala.a;
        if (this.b)
        {
          i = 6;
          localHashMap.put("apiType", Integer.valueOf(i));
          locala.a.put("occurTime", Long.valueOf(System.currentTimeMillis()));
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
      i = 2;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */