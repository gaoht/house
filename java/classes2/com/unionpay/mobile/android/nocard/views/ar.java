package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.model.b;

final class ar
  implements View.OnClickListener
{
  ar(ao paramao) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    this.a.j();
    this.a.a.I.f = "cancel";
    this.a.w();
    this.a.k();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */