package com.unionpay.mobile.android.pro.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class d
  implements View.OnClickListener
{
  d(a parama) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    paramView = (String)paramView.getTag();
    a.f(this.a, paramView);
    a.i(this.a);
    a.b(this.a, paramView, "");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */