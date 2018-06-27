package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class ac
  implements View.OnClickListener
{
  ac(o.b paramb) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (o.b.a(this.a) != null) {
      o.b.a(this.a).dismiss();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */