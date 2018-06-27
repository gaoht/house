package com.unionpay.sdk;

import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class bb
  extends Handler
{
  bb(n paramn, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while (n.a(this.a) == null);
    n.a(this.a).unregisterListener(n.b(this.a));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */