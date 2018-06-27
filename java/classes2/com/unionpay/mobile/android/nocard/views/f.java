package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import org.json.JSONObject;

final class f
  implements View.OnClickListener
{
  f(b paramb, JSONObject paramJSONObject) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    this.b.j();
    this.b.b(this.b.a.aL, this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */