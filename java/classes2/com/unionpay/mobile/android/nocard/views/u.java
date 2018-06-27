package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class u
  implements View.OnClickListener
{
  u(o paramo) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    paramView = (String)paramView.getTag();
    o.a(this.a, paramView);
    o.a(this.a);
    o.b(this.a, paramView, "");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */