package com.unionpay.mobile.android.pro.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.nocard.utils.c;
import com.unionpay.mobile.android.views.order.l;

final class o
  implements View.OnClickListener
{
  o(k paramk) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (c.a(k.n(this.a), k.o(this.a)) == l.c.intValue())
    {
      this.a.n();
      this.a.n();
      return;
    }
    this.a.n();
    if (k.p(this.a).J)
    {
      this.a.n();
      k.q(this.a).J = false;
    }
    k.r(this.a).aP = l.c.intValue();
    k.s(this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */