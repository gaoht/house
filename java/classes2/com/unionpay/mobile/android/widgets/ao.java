package com.unionpay.mobile.android.widgets;

import android.content.Context;
import org.json.JSONObject;

public final class ao
  extends aa
{
  public ao(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString)
  {
    super(paramContext, paramInt, paramJSONObject, paramString);
    this.b.a(129);
  }
  
  public final boolean b()
  {
    String str = a();
    return (str != null) && (str.length() > 0);
  }
  
  protected final String d()
  {
    return "login_pwd";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */