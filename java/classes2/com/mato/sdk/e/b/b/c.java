package com.mato.sdk.e.b.b;

import com.mato.sdk.e.b.j;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements j
{
  public String a;
  public int b = 100;
  public int c = -1;
  public int d = -1;
  public int e = -1;
  private String f;
  
  public c(String paramString)
  {
    this.a = paramString;
  }
  
  private boolean c()
  {
    return this.b != 100;
  }
  
  public final JSONObject a()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("host", this.a);
    localJSONObject.put("packetLoss", this.b);
    localJSONObject.put("maxRTT", this.e);
    localJSONObject.put("minRTT", this.c);
    localJSONObject.put("avgRTT", this.d);
    return localJSONObject;
  }
  
  public final void a(JSONObject paramJSONObject)
    throws JSONException
  {
    this.a = paramJSONObject.getString("host");
    this.b = paramJSONObject.getInt("packetLoss");
    this.e = paramJSONObject.getInt("maxRTT");
    this.c = paramJSONObject.getInt("minRTT");
    this.d = paramJSONObject.getInt("avgRTT");
  }
  
  public final float b()
  {
    return (this.e - this.c) * 100.0F / this.e;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/b/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */