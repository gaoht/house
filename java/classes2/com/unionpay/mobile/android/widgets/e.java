package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter.LengthFilter;
import org.json.JSONObject;

public final class e
  extends aa
{
  public e(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString)
  {
    super(paramContext, paramInt, paramJSONObject, paramString);
    this.b.a(new InputFilter.LengthFilter(3));
    this.b.a(18);
  }
  
  public final boolean b()
  {
    return 3 == a().length();
  }
  
  protected final String d()
  {
    return "_input_cvn2";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */