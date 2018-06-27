package com.unionpay.mobile.android.views.order;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class a
  implements View.OnClickListener
{
  a(AbstractMethod paramAbstractMethod) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.a.f != null) {
      if (this.a.c() != null) {
        break label62;
      }
    }
    label62:
    for (boolean bool = true;; bool = false)
    {
      this.a.f.a(this.a.b(), bool, this.a.d(), this.a.c());
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/views/order/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */