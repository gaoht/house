package com.pgyersdk.g;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

class i
  implements DialogInterface.OnClickListener
{
  i(h paramh) {}
  
  @Instrumented
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VdsAgent.onClick(this, paramDialogInterface, paramInt);
    this.a.b.a(this.a, Boolean.valueOf(false));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/g/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */