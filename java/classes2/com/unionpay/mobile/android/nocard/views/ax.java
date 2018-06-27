package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.nocard.utils.c;
import com.unionpay.mobile.android.views.order.l;

final class ax
  implements View.OnClickListener
{
  ax(at paramat) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (c.a(this.a.d, this.a.a) == l.c.intValue())
    {
      this.a.n();
      this.a.n();
      return;
    }
    this.a.n();
    if (this.a.a.J)
    {
      this.a.n();
      this.a.a.J = false;
    }
    this.a.a.aP = l.c.intValue();
    this.a.d(2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */