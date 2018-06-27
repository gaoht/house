package com.unionpay.mobile.android.pro.views;

import android.os.Bundle;
import android.os.Handler;
import com.unionpay.mobile.android.model.c;
import java.util.HashMap;

final class ac
  implements Runnable
{
  ac(x paramx, com.unionpay.mobile.android.pro.pboc.engine.b paramb, c paramc, String paramString, HashMap paramHashMap) {}
  
  public final void run()
  {
    Bundle localBundle = this.a.a(this.b, this.c, x.u(this.e).p, this.d, x.v(this.e).m);
    Handler localHandler1 = x.w(this.e);
    Handler localHandler2 = x.w(this.e);
    if (localBundle != null) {}
    for (;;)
    {
      localHandler1.sendMessage(localHandler2.obtainMessage(0, localBundle));
      return;
      localBundle = null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */