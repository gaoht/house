package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.utils.o;

final class bg
  implements View.OnClickListener
{
  bg(bd.a parama, int paramInt, String paramString1, String paramString2) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    paramView = this.d.a;
    bd.a(this.d.a.d, "pay_success_click_activity", o.i, new Object[] { Integer.valueOf(this.a), this.b });
    this.d.a.a("", this.c);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */