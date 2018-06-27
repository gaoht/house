package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter.LengthFilter;
import org.json.JSONObject;

public final class f
  extends aa
{
  public f(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString)
  {
    super(paramContext, paramInt, paramJSONObject, paramString);
    this.b.a(new InputFilter.LengthFilter(32));
  }
  
  public final boolean b()
  {
    return (a().length() != 0) && (a().length() <= 32);
  }
  
  protected final String d()
  {
    return "_input_certId";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */