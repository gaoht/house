package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class q
  implements View.OnClickListener
{
  q(p paramp) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (p.a(this.a) != null) {
      p.a(this.a).dismiss();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */