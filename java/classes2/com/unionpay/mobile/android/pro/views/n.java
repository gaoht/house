package com.unionpay.mobile.android.pro.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class n
  implements View.OnClickListener
{
  n(k paramk) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    paramView = (String)paramView.getTag();
    k.e(this.a, paramView);
    k.m(this.a);
    k.b(this.a, paramView, "");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */