package com.unionpay.mobile.android.pro.views;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.utils.i;
import org.json.JSONObject;

final class z
  implements View.OnClickListener
{
  z(x paramx) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    paramView = (JSONObject)paramView.getTag();
    String str1 = i.a(paramView, "errMsg");
    if ((str1 != null) && (!TextUtils.isEmpty(str1)))
    {
      x.d(this.a, str1);
      return;
    }
    str1 = i.a(paramView, "action");
    String str2 = i.a(paramView, "value");
    if (x.m(this.a).bq) {}
    for (paramView = "10";; paramView = "2")
    {
      x.a(this.a, str1, str2 + ",\"carrier_tp\":" + paramView);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */