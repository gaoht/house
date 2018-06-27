package com.unionpay.mobile.android.pro.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.widgets.m;

final class f
  implements View.OnClickListener
{
  f(a parama) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (a.n(this.a)) {}
    do
    {
      return;
      a.e(this.a).d();
      if (a.o(this.a))
      {
        a.p(this.a);
        return;
      }
    } while (a.q(this.a).p == null);
    paramView = a.e(this.a).a();
    if (!paramView.a())
    {
      a.g(this.a, paramView.b);
      return;
    }
    paramView = this.a;
    a.a(a.r(this.a), a.s(this.a) + "_apply");
    a.t(this.a).a(c.bD.U);
    a.u(this.a);
    this.a.a(a.v(this.a).p);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */