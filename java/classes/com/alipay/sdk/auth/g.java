package com.alipay.sdk.auth;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

final class g
  implements DialogInterface.OnClickListener
{
  g(f paramf) {}
  
  @Instrumented
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VdsAgent.onClick(this, paramDialogInterface, paramInt);
    AuthActivity.a(this.a.b.a, true);
    this.a.a.proceed();
    paramDialogInterface.dismiss();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/sdk/auth/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */