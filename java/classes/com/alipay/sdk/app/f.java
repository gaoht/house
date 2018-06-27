package com.alipay.sdk.app;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class f
  implements DialogInterface.OnClickListener
{
  f(d paramd) {}
  
  @Instrumented
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VdsAgent.onClick(this, paramDialogInterface, paramInt);
    this.a.a.cancel();
    c.a(this.a.b, false);
    i.a = i.a();
    c.a(this.a.b).finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/sdk/app/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */