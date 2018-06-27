package com.unionpay.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;

final class f
  extends Handler
{
  f(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    ag.a locala;
    bh localbh;
    if ((paramMessage.obj != null) && ((paramMessage.obj instanceof ag.a)))
    {
      locala = (ag.a)paramMessage.obj;
      localbh = (bh)locala.a.get("controller");
      t.a().b();
      switch (paramMessage.what)
      {
      }
    }
    for (;;)
    {
      t.a().c();
      return;
      if (localbh != null)
      {
        paramMessage = locala.a;
        continue;
        try
        {
          ar.a().post(locala);
        }
        catch (Throwable paramMessage)
        {
          k.a(paramMessage);
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */