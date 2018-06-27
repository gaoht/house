package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.utils.j;

final class c
  implements com.unionpay.mobile.android.pboctransaction.b
{
  c(b paramb) {}
  
  public final void a()
  {
    b.a(this.a, 1);
  }
  
  public final void b()
  {
    j.c("UPCardEngine", "mSDInitCallback.initFailed!!!!");
    Message localMessage = b.a(this.a).obtainMessage(1, null);
    b.a(this.a).sendMessage(localMessage);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/pboc/engine/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */