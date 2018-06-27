package com.unionpay;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.utils.h;

final class m
  implements View.OnClickListener
{
  m(UPPayWapActivity paramUPPayWapActivity) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    paramView = new AlertDialog.Builder(this.a);
    UPPayWapActivity.a(this.a, paramView.create());
    paramView.setMessage(h.a().a);
    paramView.setTitle(h.a().d);
    paramView.setPositiveButton(h.a().b, new n(this));
    paramView.setNegativeButton(h.a().c, new o(this));
    paramView = paramView.create();
    if (!(paramView instanceof AlertDialog))
    {
      paramView.show();
      return;
    }
    VdsAgent.showDialog((AlertDialog)paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */