package com.unionpay.mobile.android.nocard.views;

import android.os.Handler.Callback;
import android.os.Message;
import android.widget.LinearLayout;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.model.d;
import com.unionpay.mobile.android.views.order.l;
import com.unionpay.mobile.android.views.order.o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ap
  implements Handler.Callback
{
  ap(ao paramao) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    boolean bool = false;
    if (this.a.a.aP == l.e.intValue())
    {
      this.a.r.clear();
      paramMessage = new HashMap();
      this.a.r.remove(paramMessage);
      if ((b.bb != null) && (b.bb.size() > 0))
      {
        int j = b.bb.size();
        int i = 0;
        while (i < j)
        {
          paramMessage = (d)b.bb.get(i);
          Object localObject = this.a;
          localObject = ao.a(paramMessage);
          this.a.r.add(localObject);
          if (i == 0) {
            ao.a(this.a).b(paramMessage.b() + paramMessage.c() + " " + ((Map)localObject).get("text2"));
          }
          i += 1;
        }
        ao.a(this.a).setVisibility(0);
        ao.b(this.a).setVisibility(8);
      }
    }
    else
    {
      return true;
    }
    this.a.n();
    this.a.a.aP = l.a.intValue();
    if (this.a.a.aE) {
      bool = true;
    }
    this.a.a(c.bD.bq, this.a.a.bg, a.t - a.k - a.s * 3, bool, true);
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */