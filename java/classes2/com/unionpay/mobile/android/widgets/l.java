package com.unionpay.mobile.android.widgets;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.languages.c;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

final class l
  implements View.OnClickListener
{
  l(k paramk) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (k.a(this.a))
    {
      localObject = new JSONObject();
      try
      {
        if (!TextUtils.isEmpty(this.a.a()))
        {
          if (this.a.a().matches("[A-Za-z0-9]{8,32}"))
          {
            this.a.a(true);
            ((JSONObject)localObject).put("value", this.a.h());
            ((JSONObject)localObject).put("action", k.b(this.a));
          }
          for (;;)
          {
            paramView.setTag(localObject);
            localObject = k.c(this.a).iterator();
            while (((Iterator)localObject).hasNext()) {
              ((View.OnClickListener)((Iterator)localObject).next()).onClick(paramView);
            }
            ((JSONObject)localObject).put("errMsg", String.format(c.bD.aD, new Object[] { c.bD.C }));
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          continue;
          ((JSONObject)localObject).put("errMsg", String.format(c.bD.aC, new Object[] { c.bD.C }));
        }
      }
    }
    this.a.b.e();
    this.a.a(false);
    Object localObject = k.d(this.a).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((View.OnClickListener)((Iterator)localObject).next()).onClick(paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */