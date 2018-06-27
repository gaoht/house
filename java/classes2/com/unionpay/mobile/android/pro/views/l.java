package com.unionpay.mobile.android.pro.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.widgets.m;

final class l
  implements View.OnClickListener
{
  l(k paramk) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (k.a(this.a)) {}
    do
    {
      return;
      k.b(this.a).d();
      if ((k.c(this.a) != null) && (!k.c(this.a).e()))
      {
        k.a(this.a, k.c(this.a).b());
        return;
      }
      if ((k.d(this.a) != null) && (!k.d(this.a).e()))
      {
        k.b(this.a, k.d(this.a).b());
        return;
      }
      if (k.e(this.a))
      {
        k.f(this.a);
        return;
      }
    } while (k.g(this.a).p == null);
    paramView = k.b(this.a).a();
    if (!paramView.a())
    {
      k.c(this.a, paramView.b);
      return;
    }
    paramView = this.a;
    k.a(k.h(this.a), k.i(this.a) + "_apply");
    k.j(this.a).a(c.bD.U);
    k.k(this.a);
    k.a(this.a, k.b(this.a).a().b, k.l(this.a));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */