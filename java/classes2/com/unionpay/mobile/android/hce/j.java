package com.unionpay.mobile.android.hce;

import android.os.Bundle;
import android.os.Handler;

final class j
  implements Runnable
{
  j(f paramf) {}
  
  public final void run()
  {
    Bundle localBundle = f.a(this.a, f.h(this.a), f.i(this.a), f.j(this.a));
    f.k(this.a);
    Handler localHandler1 = f.d(this.a);
    Handler localHandler2 = f.d(this.a);
    if (localBundle != null) {}
    for (;;)
    {
      localHandler1.sendMessage(localHandler2.obtainMessage(2001, localBundle));
      return;
      localBundle = null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/hce/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */