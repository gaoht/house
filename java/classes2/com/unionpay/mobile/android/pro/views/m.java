package com.unionpay.mobile.android.pro.views;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.utils.i;
import org.json.JSONObject;

final class m
  implements View.OnClickListener
{
  m(k paramk) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    paramView = (JSONObject)paramView.getTag();
    String str = i.a(paramView, "errMsg");
    if ((str != null) && (!TextUtils.isEmpty(str)))
    {
      k.d(this.a, str);
      return;
    }
    str = i.a(paramView, "action");
    paramView = i.a(paramView, "value");
    k.a(this.a, str, paramView + ",\"carrier_tp\":\"7\"");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */