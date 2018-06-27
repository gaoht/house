package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class i
  implements AdapterView.OnItemClickListener
{
  i(g paramg) {}
  
  @Instrumented
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    VdsAgent.onItemClick(this, paramAdapterView, paramView, paramInt, paramLong);
    this.a.a(this.a.c, this.a.v() + this.a.d());
    g.a(this.a, paramInt);
    if (g.a(this.a) != null) {
      g.a(this.a).dismiss();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */