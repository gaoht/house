package com.alipay.sdk.auth;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class h
  implements DialogInterface.OnClickListener
{
  h(f paramf) {}
  
  @Instrumented
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VdsAgent.onClick(this, paramDialogInterface, paramInt);
    this.a.a.cancel();
    AuthActivity.a(this.a.b.a, false);
    paramDialogInterface = AuthActivity.c(this.a.b.a) + "?resultCode=150";
    i.a(this.a.b.a, paramDialogInterface);
    this.a.b.a.finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/sdk/auth/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */