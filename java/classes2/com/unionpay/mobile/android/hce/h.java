package com.unionpay.mobile.android.hce;

import android.os.Handler;
import android.os.Message;

final class h
  extends Thread
{
  h(f paramf, String paramString1, String paramString2) {}
  
  public final void run()
  {
    f.a(this.c, this.a, this.b);
    Message localMessage = f.d(this.c).obtainMessage(2006, this.a);
    f.d(this.c).sendMessageDelayed(localMessage, f.e(this.c));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/hce/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */