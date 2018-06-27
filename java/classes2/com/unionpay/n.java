package com.unionpay;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class n
  implements DialogInterface.OnClickListener
{
  n(m paramm) {}
  
  @Instrumented
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VdsAgent.onClick(this, paramDialogInterface, paramInt);
    this.a.a.finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */