package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class aq
  implements View.OnClickListener
{
  aq(ap paramap) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (ap.a(this.a) != null)
    {
      this.a.a(this.a.c, this.a.v() + "_click_get_msg");
      ap.a(this.a).a(this.a);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */