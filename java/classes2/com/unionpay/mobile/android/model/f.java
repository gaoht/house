package com.unionpay.mobile.android.model;

import java.util.HashMap;
import org.json.JSONObject;

public final class f
  implements e
{
  private HashMap<String, Object> a = new HashMap();
  
  public final JSONObject a(String paramString)
  {
    paramString = this.a.get(paramString);
    if ((paramString != null) && ((paramString instanceof JSONObject))) {
      return (JSONObject)paramString;
    }
    return null;
  }
  
  public final void a(String paramString, Object paramObject)
  {
    this.a.put(paramString, paramObject);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/model/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */