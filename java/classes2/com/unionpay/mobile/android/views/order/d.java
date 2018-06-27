package com.unionpay.mobile.android.views.order;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class d
  implements View.OnClickListener
{
  d(b paramb) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (b.b(this.a) != null) {
      b.b(this.a).dismiss();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/views/order/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */