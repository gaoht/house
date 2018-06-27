package com.unionpay.mobile.android.upwidget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.Iterator;

final class k
  implements AdapterView.OnItemClickListener
{
  k(j paramj) {}
  
  @Instrumented
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    VdsAgent.onItemClick(this, paramAdapterView, paramView, paramInt, paramLong);
    paramView.setTag(Integer.valueOf(j.a(this.a)));
    if (j.b(this.a) != j.c(this.a))
    {
      localObject = j.d(this.a).get(j.b(this.a));
      if ((localObject instanceof c)) {
        ((c)localObject).a(-1);
      }
    }
    Object localObject = j.d(this.a).get(j.a(this.a));
    if ((localObject instanceof c)) {
      ((c)localObject).a(paramInt);
    }
    j.a(this.a, j.a(this.a));
    j.b(this.a, paramInt);
    localObject = j.e(this.a).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AdapterView.OnItemClickListener)((Iterator)localObject).next()).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/upwidget/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */