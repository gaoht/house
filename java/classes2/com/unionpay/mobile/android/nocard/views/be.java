package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class be
  implements View.OnClickListener
{
  be(bd parambd) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    paramView = this.a;
    bd.a(this.a.d, "pay_success_back_merchant");
    bd.a(this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */