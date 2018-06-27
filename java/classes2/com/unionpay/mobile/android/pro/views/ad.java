package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class ad
  implements View.OnClickListener
{
  ad(x paramx) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    x.b(this.a).d();
    ((InputMethodManager)x.x(this.a).getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
    paramView = this.a;
    x.a(x.y(this.a), x.z(this.a) + "_open_user_protocol");
    x.c(this.a, x.c(this.a).d(), x.c(this.a).c());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */