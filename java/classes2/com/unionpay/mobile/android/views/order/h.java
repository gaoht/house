package com.unionpay.mobile.android.views.order;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.utils.j;

final class h
  implements View.OnClickListener
{
  h(CViewMethods paramCViewMethods, int paramInt) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    j.c("uppay", " touched " + this.a);
    if (CViewMethods.a(this.b) != null) {
      CViewMethods.a(this.b).c(this.a);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/views/order/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */