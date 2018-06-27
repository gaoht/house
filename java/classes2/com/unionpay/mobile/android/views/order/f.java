package com.unionpay.mobile.android.views.order;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class f
  implements View.OnClickListener
{
  f(b paramb) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.a.e != null)
    {
      paramView = this.a;
      b.a(this.a.b, "bankpay_support_bank");
      paramView = this.a.e;
      Object localObject = this.a;
      localObject = b.a(b.c(this.a), "title");
      b localb = this.a;
      paramView.a((String)localObject, b.a(b.c(this.a), "href"));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/views/order/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */