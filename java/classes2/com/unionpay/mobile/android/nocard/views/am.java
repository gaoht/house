package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class am
  implements View.OnClickListener
{
  am(ak paramak) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    ak.a(this.a).d();
    ((InputMethodManager)this.a.d.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
    paramView = this.a;
    ak.a(this.a.d, this.a.q + "_open_user_protocol");
    this.a.a(ak.b(this.a).d(), ak.b(this.a).c());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */