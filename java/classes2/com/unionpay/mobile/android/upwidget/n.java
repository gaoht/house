package com.unionpay.mobile.android.upwidget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.widgets.ad;

final class n
  implements View.OnClickListener
{
  n(j paramj) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    j.h(this.a).setEnabled(false);
    j.i(this.a).setVisibility(8);
    j.j(this.a).setVisibility(0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/upwidget/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */