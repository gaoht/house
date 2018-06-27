package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.utils.o;

final class al
  implements View.OnClickListener
{
  al(aj paramaj) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    int i = ((Integer)paramView.getTag()).intValue();
    this.a.a(this.a.c, this.a.v() + this.a.d(), o.h, new Object[] { aj.a(this.a, i, "type"), Integer.valueOf(0), aj.a(this.a, i, 0, "label") });
    aj.a(this.a, i, 0);
    if (aj.a(this.a) != null) {
      aj.a(this.a).dismiss();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */