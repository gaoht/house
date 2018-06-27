package com.pgyersdk.g;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

class d
  implements DialogInterface.OnClickListener
{
  d(c paramc) {}
  
  @Instrumented
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VdsAgent.onClick(this, paramDialogInterface, paramInt);
    this.a.b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/g/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */