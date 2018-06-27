package com.unionpay.mobile.android.widgets;

import android.content.Context;
import org.json.JSONObject;

public abstract class z
  extends ba
  implements ba.a
{
  public z(Context paramContext, JSONObject paramJSONObject, String paramString)
  {
    super(paramContext, paramJSONObject, paramString);
  }
  
  public String h()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ((q() != null) && (a() != null))
    {
      localStringBuffer.append("\"");
      localStringBuffer.append(q());
      localStringBuffer.append("\":");
      localStringBuffer.append("\"");
      localStringBuffer.append(a());
      localStringBuffer.append("\"");
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */