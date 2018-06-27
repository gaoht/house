package com.unionpay.mobile.android.widgets;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class s
  implements View.OnClickListener
{
  s(p paramp) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    paramView = p.b(this.a);
    if (!(paramView instanceof Dialog))
    {
      paramView.show();
      return;
    }
    VdsAgent.showDialog((Dialog)paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */