package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.widgets.m;

final class k
  implements View.OnClickListener
{
  k(g paramg) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    this.a.j();
    this.a.b.a(c.bD.U);
    g.d(this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */