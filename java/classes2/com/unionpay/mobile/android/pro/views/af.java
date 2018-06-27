package com.unionpay.mobile.android.pro.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.widgets.m;

final class af
  implements View.OnClickListener
{
  af(x paramx) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    x.C(this.a);
    x.D(this.a).a(c.bD.U);
    x.f(this.a, x.E(this.a));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */