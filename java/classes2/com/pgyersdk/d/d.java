package com.pgyersdk.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pgyersdk.views.g;

class d
  implements DialogInterface.OnClickListener
{
  d(a parama) {}
  
  @Instrumented
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VdsAgent.onClick(this, paramDialogInterface, paramInt);
    a.a(paramDialogInterface, Boolean.valueOf(false));
    a.a(a.a(), paramDialogInterface);
    a.a(this.a, a.a(this.a).l);
    this.a.sendFeedback(a.b(this.a), VdsAgent.trackEditTextSilent(a.a(this.a).b()).toString(), VdsAgent.trackEditTextSilent(a.a(this.a).c()).toString(), a.c(this.a), a.d(this.a), Boolean.valueOf(false));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */