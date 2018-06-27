package com.growingio.android.sdk.circle.a;

import com.growingio.android.sdk.models.c;
import com.growingio.android.sdk.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  private static String d = "GIO.HeatMapResponse";
  private boolean a;
  private String b;
  private c[] c;
  
  public d(JSONObject paramJSONObject)
  {
    try
    {
      this.a = paramJSONObject.getBoolean("success");
      if (paramJSONObject.has("reason")) {
        this.b = paramJSONObject.getString("reason");
      }
      if (paramJSONObject.has("data")) {
        this.c = c.a(paramJSONObject.getJSONArray("data"));
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      LogUtil.e(d, "HeatMapResponse解析异常" + paramJSONObject);
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public c[] c()
  {
    return this.c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/circle/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */