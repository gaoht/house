package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.utils.o;

final class am
  implements AdapterView.OnItemClickListener
{
  am(aj paramaj) {}
  
  @Instrumented
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    VdsAgent.onItemClick(this, paramAdapterView, paramView, paramInt, paramLong);
    int i = ((Integer)paramView.getTag()).intValue();
    this.a.a(this.a.c, this.a.v() + this.a.d(), o.h, new Object[] { aj.a(this.a, i, "type"), Integer.valueOf(paramInt), aj.a(this.a, i, paramInt, "label") });
    aj.a(this.a, i, paramInt);
    if (aj.a(this.a) != null) {
      aj.a(this.a).dismiss();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */