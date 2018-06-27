package com.unionpay.tsmservice.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class UPSaftyKeyboard$2
  implements View.OnClickListener
{
  UPSaftyKeyboard$2(UPSaftyKeyboard paramUPSaftyKeyboard) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    this.a.hide();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/widget/UPSaftyKeyboard$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */