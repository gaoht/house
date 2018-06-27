package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class d
  implements View.OnClickListener
{
  d(b paramb, boolean paramBoolean) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    this.b.j();
    if (this.a) {
      this.b.k();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */