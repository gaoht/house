package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class ai
  implements View.OnClickListener
{
  ai(ah paramah) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (ah.a(this.a) != null)
    {
      this.a.a(this.a.c, this.a.v() + "_change_phoneNO");
      paramView = ah.a(this.a);
      ah localah = this.a;
      paramView.e(ah.b(this.a));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */