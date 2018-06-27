package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class q
  implements View.OnClickListener
{
  q(k paramk) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    k.b(this.a).d();
    ((InputMethodManager)k.u(this.a).getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
    paramView = this.a;
    k.a(k.v(this.a), k.w(this.a) + "_open_user_protocol");
    k.c(this.a, k.c(this.a).d(), k.c(this.a).c());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */