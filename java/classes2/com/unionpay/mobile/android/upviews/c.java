package com.unionpay.mobile.android.upviews;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;

final class c
  extends TimerTask
{
  c(b.d paramd) {}
  
  public final void run()
  {
    if (!b.b(this.a.a)) {
      b.a(this.a.a).sendEmptyMessage(3);
    }
    b.c(this.a.a).cancel();
    b.c(this.a.a).purge();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/upviews/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */