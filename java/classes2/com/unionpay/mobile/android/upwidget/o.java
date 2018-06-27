package com.unionpay.mobile.android.upwidget;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.Iterator;

final class o
  implements View.OnClickListener
{
  o(j paramj) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (j.b(this.a) != j.c(this.a))
    {
      localObject = j.d(this.a).get(j.b(this.a));
      if ((localObject instanceof c)) {
        ((c)localObject).a(-1);
      }
    }
    j.a(this.a, j.a(this.a));
    j.b(this.a, j.c(this.a));
    Object localObject = j.k(this.a).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((View.OnClickListener)((Iterator)localObject).next()).onClick(paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/upwidget/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */