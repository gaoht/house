package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.utils.j;

final class ax
  implements View.OnClickListener
{
  ax(UPWidget paramUPWidget) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    int i = paramView.getId();
    int j = UPWidget.n();
    if (i == 10)
    {
      j.c("kb", " [ FIN ]");
      UPWidget.b(this.a);
      return;
    }
    if (i == 20)
    {
      j.c("kb", " [ DEL ]");
      if (j > 0)
      {
        UPWidget.a(this.a, UPWidget.c(this.a));
        UPWidget.o();
        paramView = this.a.b.b().toString().substring(0, j - 1);
        this.a.b.c(paramView);
        this.a.b.b(paramView.length());
      }
      UPWidget.n();
      return;
    }
    if (UPWidget.n() == 6)
    {
      j.c("kb", " [ FIN ]");
      return;
    }
    UPWidget.a(this.a, UPWidget.c(this.a), Integer.toString(i));
    if (j == 0) {}
    for (paramView = "*";; paramView = this.a.b.b() + "*")
    {
      this.a.b.c(paramView);
      this.a.b.b(paramView.length());
      UPWidget.p();
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */