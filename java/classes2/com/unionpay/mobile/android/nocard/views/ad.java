package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.upwidget.c;
import java.util.List;

final class ad
  implements AdapterView.OnItemClickListener
{
  ad(o.b paramb) {}
  
  @Instrumented
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    VdsAgent.onItemClick(this, paramAdapterView, paramView, paramInt, paramLong);
    o.b.a(this.a).dismiss();
    if ((o.b.b(this.a) != null) && (paramInt - o.b.c(this.a).c() < o.b.b(this.a).size()))
    {
      o.b.a(this.a, paramInt);
      o.b.c(this.a).a(o.b.d(this.a));
    }
    if (o.b.e(this.a) != null) {
      o.b.e(this.a).a(paramInt - o.b.c(this.a).c());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */