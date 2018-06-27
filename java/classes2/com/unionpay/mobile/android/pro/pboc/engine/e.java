package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;

final class e
  implements com.unionpay.mobile.android.pboctransaction.b
{
  e(b paramb) {}
  
  public final void a()
  {
    b.a(this.a, 4);
  }
  
  public final void b()
  {
    Message localMessage = b.a(this.a).obtainMessage(4, null);
    b.a(this.a).sendMessage(localMessage);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/pboc/engine/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */