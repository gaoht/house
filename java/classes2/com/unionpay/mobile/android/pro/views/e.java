package com.unionpay.mobile.android.pro.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.nocard.utils.c;
import com.unionpay.mobile.android.views.order.l;

final class e
  implements View.OnClickListener
{
  e(a parama) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    int i = c.a(a.j(this.a), a.k(this.a));
    this.a.n();
    this.a.n();
    if (i != l.c.intValue())
    {
      a.l(this.a).aP = l.c.intValue();
      a.m(this.a);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */