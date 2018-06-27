package com.unionpay.mobile.android.nocard.views;

import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.views.order.l;

final class aq
  implements Handler.Callback
{
  aq(ao paramao) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    if ((this.a.a.aP == l.a.intValue()) && (!this.a.a.J))
    {
      if (TextUtils.isEmpty(this.a.a.u)) {
        break label66;
      }
      this.a.a(13, this.a.p);
    }
    for (;;)
    {
      return true;
      label66:
      if (this.a.a.aC) {
        ao.c(this.a);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */