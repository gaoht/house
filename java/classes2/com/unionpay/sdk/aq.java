package com.unionpay.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class aq
  extends Handler
{
  aq(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj != null) && ((paramMessage.obj instanceof p))) {
      paramMessage = (p)paramMessage.obj;
    }
    try
    {
      ar.a().post(paramMessage);
      return;
    }
    catch (Throwable paramMessage)
    {
      k.a(paramMessage);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */