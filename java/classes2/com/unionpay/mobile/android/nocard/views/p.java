package com.unionpay.mobile.android.nocard.views;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.utils.i;
import org.json.JSONObject;

final class p
  implements View.OnClickListener
{
  p(o paramo) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    paramView = (JSONObject)paramView.getTag();
    String str = i.a(paramView, "errMsg");
    if ((str != null) && (!TextUtils.isEmpty(str)))
    {
      this.a.a(str);
      return;
    }
    str = i.a(paramView, "action");
    paramView = i.a(paramView, "value");
    o.a(this.a, str, paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */