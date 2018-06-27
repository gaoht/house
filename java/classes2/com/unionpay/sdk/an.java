package com.unionpay.sdk;

import android.content.Context;
import android.os.Message;
import java.util.HashMap;

final class an
  implements Runnable
{
  an(Throwable paramThrowable, Context paramContext) {}
  
  public final void run()
  {
    try
    {
      if (this.a == null) {
        return;
      }
      if ((this.b != null) && (!ag.b)) {
        ag.a(this.b);
      }
      ag.a locala = new ag.a();
      locala.a.put("apiType", Integer.valueOf(5));
      locala.a.put("occurTime", String.valueOf(System.currentTimeMillis()));
      locala.a.put("throwable", this.a);
      Message.obtain(bk.a(), 102, locala).sendToTarget();
      return;
    }
    catch (Throwable localThrowable)
    {
      k.a(localThrowable);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */