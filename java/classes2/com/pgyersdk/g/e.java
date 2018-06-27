package com.pgyersdk.g;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

class e
  implements DialogInterface.OnClickListener
{
  e(c paramc) {}
  
  @Instrumented
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VdsAgent.onClick(this, paramDialogInterface, paramInt);
    try
    {
      a.a(c.a(this.a), this.a.f);
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/g/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */