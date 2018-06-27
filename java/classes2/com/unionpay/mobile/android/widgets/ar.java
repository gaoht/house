package com.unionpay.mobile.android.widgets;

import android.os.Handler;
import android.os.Message;

final class ar
  extends Thread
{
  ar(ap paramap, int paramInt) {}
  
  public final void run()
  {
    if (ap.b(this.b) != null)
    {
      long l1 = System.currentTimeMillis() + this.a * 1000;
      for (;;)
      {
        long l2 = System.currentTimeMillis();
        if (l2 > l1) {
          break label110;
        }
        int i = (int)((l1 - l2 + this.a) / 1000L);
        if (i <= 0) {
          break label110;
        }
        Message localMessage = Message.obtain();
        localMessage.what = 0;
        localMessage.arg1 = i;
        ap.b(this.b).sendMessage(localMessage);
        try
        {
          sleep(1000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          ap.b(this.b).sendEmptyMessage(1);
        }
      }
    }
    return;
    label110:
    ap.b(this.b).sendEmptyMessage(1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */