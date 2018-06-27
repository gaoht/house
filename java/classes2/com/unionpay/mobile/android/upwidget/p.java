package com.unionpay.mobile.android.upwidget;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.Iterator;

final class p
  implements View.OnClickListener
{
  p(j paramj) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    int i = ((Integer)paramView.getTag()).intValue();
    if (i == j.a(this.a)) {
      return;
    }
    j.c(this.a, i);
    if ((j.l(this.a)) && (!TextUtils.isEmpty(j.m(this.a)[i].d)))
    {
      paramView.setTag(j.m(this.a)[i].d);
      Iterator localIterator = j.n(this.a).iterator();
      while (localIterator.hasNext()) {
        ((View.OnClickListener)localIterator.next()).onClick(paramView);
      }
      j.a(this.a, (LinearLayout)j.m(this.a)[i].c, "正在查询。。。");
      j.o(this.a);
    }
    paramView.setTag(Integer.valueOf(i));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/upwidget/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */