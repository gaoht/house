package com.unionpay;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class f
  implements DialogInterface.OnClickListener
{
  f(Context paramContext) {}
  
  @Instrumented
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VdsAgent.onClick(this, paramDialogInterface, paramInt);
    UPPayAssistEx.a(this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */