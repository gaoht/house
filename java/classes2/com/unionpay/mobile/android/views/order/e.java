package com.unionpay.mobile.android.views.order;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class e
  implements AdapterView.OnItemClickListener
{
  e(b paramb) {}
  
  @Instrumented
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    VdsAgent.onItemClick(this, paramAdapterView, paramView, paramInt, paramLong);
    b.a(this.a, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/views/order/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */