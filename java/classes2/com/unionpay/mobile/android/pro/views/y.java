package com.unionpay.mobile.android.pro.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.widgets.m;
import java.util.List;

final class y
  implements View.OnClickListener
{
  y(x paramx) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (x.a(this.a)) {
      return;
    }
    x.b(this.a).d();
    paramView = x.b(this.a).a();
    if (!paramView.a())
    {
      x.a(this.a, paramView.b);
      return;
    }
    if ((x.c(this.a) != null) && (!x.c(this.a).e()))
    {
      x.b(this.a, x.c(this.a).b());
      return;
    }
    if ((x.d(this.a) != null) && (!x.d(this.a).e()))
    {
      x.c(this.a, x.d(this.a).b());
      return;
    }
    x.e(this.a).a(com.unionpay.mobile.android.languages.c.bD.U);
    paramView = this.a;
    x.a(x.f(this.a), x.g(this.a) + "_apply");
    if (x.h(this.a).bq)
    {
      x.a(this.a, x.i(this.a).br, x.b(this.a).a().b, x.j(this.a));
      return;
    }
    x.a(this.a, (com.unionpay.mobile.android.model.c)x.l(this.a).q.get(x.k(this.a).N), x.b(this.a).a().b, x.j(this.a));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */