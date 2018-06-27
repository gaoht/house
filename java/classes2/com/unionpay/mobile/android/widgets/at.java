package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter.LengthFilter;
import com.unionpay.mobile.android.utils.i;
import org.json.JSONObject;

public final class at
  extends aa
{
  private int n = 0;
  
  public at(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString)
  {
    super(paramContext, paramInt, paramJSONObject, paramString);
    paramContext = i.a(paramJSONObject, "maxLength");
    if ((paramContext != null) && (paramContext.length() > 0)) {}
    for (this.n = Integer.getInteger(paramContext).intValue();; this.n = 23)
    {
      this.b.a(new InputFilter.LengthFilter(this.n));
      return;
    }
  }
  
  public final boolean b()
  {
    if (this.h) {}
    while (this.n >= a().length()) {
      return true;
    }
    return false;
  }
  
  protected final String d()
  {
    return "_input_text";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */