package com.unionpay.mobile.android.upwidget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.Iterator;

final class h
  implements AdapterView.OnItemClickListener
{
  h(g paramg) {}
  
  @Instrumented
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    VdsAgent.onItemClick(this, paramAdapterView, paramView, paramInt, paramLong);
    Iterator localIterator = g.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((AdapterView.OnItemClickListener)localIterator.next()).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/upwidget/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */