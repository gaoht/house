package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.upwidget.a;

final class q
  implements View.OnClickListener
{
  q(o paramo) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    paramView = this.a;
    o.a(this.a.d, this.a.q + "_open_user_protocol");
    this.a.a(o.c(this.a).d(), o.c(this.a).c());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */