package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.b;

final class y
  implements View.OnClickListener
{
  y(o paramo) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    paramView = this.a;
    o.a(this.a.d, "loginpay_support_bank");
    this.a.a(c.bD.k, this.a.a.s);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */