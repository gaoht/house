package com.unionpay.mobile.android.pro.views;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.plugin.BaseActivity;

final class p
  implements View.OnClickListener
{
  p(k paramk) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    ((BaseActivity)k.t(this.a)).startActivityForResult(new Intent("android.settings.NFC_SETTINGS"), 0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */