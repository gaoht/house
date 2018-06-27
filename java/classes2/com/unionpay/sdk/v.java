package com.unionpay.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class v
  extends Handler
{
  v(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    try
    {
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof p)))
      {
        u.a((p)paramMessage.obj);
        int i = u.b().i;
        if (u.b().f == null)
        {
          u.a();
          u.c();
          return;
        }
        ag.c = false;
        u.a(u.a(), u.b().a, u.b().b, u.b().c, u.b().e, u.b().f, u.b().g, i, u.b().h);
        return;
      }
    }
    catch (Throwable paramMessage)
    {
      k.a(paramMessage);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */