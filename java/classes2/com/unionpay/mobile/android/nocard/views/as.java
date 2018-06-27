package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.model.b;

final class as
  implements View.OnClickListener
{
  as(ao paramao) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    this.a.j();
    if (b.bl) {
      this.a.d(this.a.a.bo, this.a.a.bp);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */