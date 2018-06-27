package com.unionpay.mobile.android.widgets;

import android.content.Context;
import org.json.JSONObject;

public final class au
  extends aa
{
  public au(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString)
  {
    super(paramContext, paramInt, paramJSONObject, paramString);
  }
  
  public final boolean b()
  {
    if (this.h) {
      return true;
    }
    if (a() != null) {}
    for (String str = a(); (this.i != null) && (this.i.length() > 0); str = "") {
      return str.matches(this.i);
    }
    return (str.length() > 0) && (str.length() <= 64);
  }
  
  protected final String d()
  {
    return "login_user";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */