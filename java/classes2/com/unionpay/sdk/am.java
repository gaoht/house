package com.unionpay.sdk;

import android.os.Message;
import java.util.HashMap;

final class am
  implements Runnable
{
  am(int paramInt, String paramString) {}
  
  public final void run()
  {
    try
    {
      if (ag.b)
      {
        ag.a locala = new ag.a();
        locala.a.put("apiType", Integer.valueOf(this.a));
        locala.a.put("occurTime", String.valueOf(System.currentTimeMillis()));
        HashMap localHashMap = locala.a;
        if (this.b == null) {}
        for (String str = "";; str = r.a(this.b))
        {
          localHashMap.put("pageName", str);
          Message.obtain(bk.a(), 102, locala).sendToTarget();
          ag.c = true;
          return;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      k.a(localThrowable);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */