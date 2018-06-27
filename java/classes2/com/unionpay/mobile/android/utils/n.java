package com.unionpay.mobile.android.utils;

import android.content.Context;
import android.os.Handler;
import com.unionpay.mobile.android.fully.a;
import com.unionpay.mobile.android.net.c;
import com.unionpay.mobile.android.net.d;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class n
  extends UPPayEngine
  implements a
{
  private Context a;
  
  public n(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
  }
  
  public final String a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      ((JSONObject)localObject).put("reqtm", h());
      localObject = ((JSONObject)localObject).toString();
      paramString = (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      int i;
      for (;;) {}
    }
    j.c("uppay", "post message = " + paramString);
    paramString = f(paramString);
    d().a(paramString);
    paramString = new HashMap(1);
    paramString.put("sid", f());
    d().a(paramString);
    paramString = new c(d(), this.a);
    i = paramString.a();
    paramString = paramString.c();
    if (i == 0)
    {
      paramString = g(paramString);
      j.a("uppay", "[ response msg ] " + paramString);
      return paramString;
    }
    paramString = e().obtainMessage(2);
    paramString.arg1 = i;
    e().sendMessage(paramString);
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/utils/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */