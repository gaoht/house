package com.unionpay.mobile.android.pro.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.model.b;

final class s
  implements View.OnClickListener
{
  s(k paramk) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    k.z(this.a);
    k.A(this.a).I.f = "cancel";
    this.a.k();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */