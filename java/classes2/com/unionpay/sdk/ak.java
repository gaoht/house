package com.unionpay.sdk;

import android.app.Activity;
import android.os.Message;
import java.util.HashMap;

final class ak
  implements Runnable
{
  ak(Activity paramActivity, String paramString) {}
  
  public final void run()
  {
    try
    {
      k.a("onResume(Context, appId, channelId) being called!");
      ag.a locala = new ag.a();
      locala.a.put("context", this.a);
      locala.a.put("pageName", this.b);
      locala.a.put("apiType", Integer.valueOf(6));
      locala.a.put("occurTime", Long.valueOf(System.currentTimeMillis()));
      locala.a.put("isSessionOnly", "0");
      Message.obtain(bk.a(), 102, locala).sendToTarget();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!UPAgent.LOG_ON) {}
      localThrowable.printStackTrace();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */