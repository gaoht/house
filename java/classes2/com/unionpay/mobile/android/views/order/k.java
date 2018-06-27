package com.unionpay.mobile.android.views.order;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class k
  implements View.OnClickListener
{
  k(i parami) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.a.e != null)
    {
      paramView = this.a;
      i.a(this.a.b, "login_by_register");
      paramView = this.a.e;
      Object localObject = this.a;
      localObject = i.a(i.b(this.a), "label");
      i locali = this.a;
      paramView.a((String)localObject, i.a(i.b(this.a), "href"));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/views/order/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */