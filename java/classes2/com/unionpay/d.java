package com.unionpay;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class d
  implements DialogInterface.OnClickListener
{
  d(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  @Instrumented
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VdsAgent.onClick(this, paramDialogInterface, paramInt);
    UPPayAssistEx.a(this.a, this.b, this.c, this.d, this.e, this.f);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */