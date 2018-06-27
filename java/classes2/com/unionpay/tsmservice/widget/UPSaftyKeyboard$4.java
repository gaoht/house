package com.unionpay.tsmservice.widget;

import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class UPSaftyKeyboard$4
  implements View.OnClickListener
{
  UPSaftyKeyboard$4(UPSaftyKeyboard paramUPSaftyKeyboard) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (UPSaftyKeyboard.c(this.a)) {
      UPSaftyKeyboard.d(this.a).vibrate(new long[] { 0L, 100L }, -1);
    }
    int i = paramView.getId();
    if (i == 10) {
      this.a.hide();
    }
    label153:
    for (;;)
    {
      return;
      if (i == 20) {
        if (UPSaftyKeyboard.e(this.a) > 0)
        {
          paramView = this.a;
          UPSaftyKeyboard.a();
          UPSaftyKeyboard.f(this.a);
        }
      }
      for (;;)
      {
        if (UPSaftyKeyboard.h(this.a) == null) {
          break label153;
        }
        UPSaftyKeyboard.h(this.a).onEditorChanged(UPSaftyKeyboard.e(this.a));
        return;
        if (UPSaftyKeyboard.e(this.a) == 6) {
          break;
        }
        paramView = this.a;
        UPSaftyKeyboard.a(Integer.toString(i));
        UPSaftyKeyboard.g(this.a);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/widget/UPSaftyKeyboard$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */