package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;

final class d
  implements com.unionpay.mobile.android.pboctransaction.b
{
  d(b paramb) {}
  
  public final void a()
  {
    b.a(this.a, 2);
  }
  
  public final void b()
  {
    Message localMessage = b.a(this.a).obtainMessage(2, null);
    b.a(this.a).sendMessage(localMessage);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/pboc/engine/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */