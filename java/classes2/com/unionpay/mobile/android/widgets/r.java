package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.utils.o;

final class r
  implements AdapterView.OnItemClickListener
{
  r(p paramp) {}
  
  @Instrumented
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    VdsAgent.onItemClick(this, paramAdapterView, paramView, paramInt, paramLong);
    this.a.a(this.a.c, this.a.v() + this.a.d(), o.f, new Object[] { Integer.valueOf(paramInt) });
    p.a(this.a, paramInt);
    if (p.a(this.a) != null) {
      p.a(this.a).dismiss();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */