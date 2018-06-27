package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.utils.j;

final class f
  implements com.unionpay.mobile.android.pboctransaction.b
{
  f(b paramb) {}
  
  public final void a()
  {
    j.c("uppay-spay", "tsmservice  init success");
    com.unionpay.mobile.android.model.b.bm = false;
    if (b.b(this.a) != null)
    {
      if (!b.b(this.a).e())
      {
        com.unionpay.mobile.android.model.b.aB = false;
        b.a(this.a, 8);
      }
      return;
    }
    b.a(this.a, 8);
  }
  
  public final void b()
  {
    j.c("UPCardEngine", "mSE init failed");
    j.c("uppay-spay", "tsmservice  init fail");
    if (b.a(this.a) != null)
    {
      Message localMessage = b.a(this.a).obtainMessage(8, null);
      b.a(this.a).sendMessage(localMessage);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/pboc/engine/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */