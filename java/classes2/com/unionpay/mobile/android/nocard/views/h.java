package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.widgets.m;

final class h
  implements View.OnClickListener
{
  h(g paramg) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.a.o()) {
      return;
    }
    g.a(this.a).d();
    paramView = g.a(this.a).b();
    if (!paramView.a())
    {
      this.a.a(paramView.b);
      return;
    }
    if ((g.b(this.a) != null) && (!g.b(this.a).e()))
    {
      this.a.a(g.b(this.a).b());
      return;
    }
    this.a.b.a(c.bD.U);
    Object localObject = this.a;
    g.a(this.a.d, this.a.q + "_open_apply");
    if (!g.c(this.a))
    {
      localObject = i.a(this.a.a.C, "action");
      this.a.e.c((String)localObject, paramView.b);
      g.a(this.a, 102);
      return;
    }
    g.d(this.a);
    g.a(this.a, 104);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */