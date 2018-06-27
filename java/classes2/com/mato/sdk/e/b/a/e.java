package com.mato.sdk.e.b.a;

import com.mato.sdk.e.b.j;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  implements j
{
  public String a;
  public b b;
  public b c;
  
  public e(String paramString)
  {
    this.a = paramString;
  }
  
  public final JSONObject a()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    if (this.b != null) {
      localJSONObject.put("bypass", this.b.a());
    }
    if (this.c != null) {
      localJSONObject.put("accelerate", this.c.a());
    }
    return localJSONObject;
  }
  
  public final void a(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("bypass");
    if (localJSONObject != null)
    {
      this.b = new b("");
      this.b.a(localJSONObject);
      this.a = this.b.c;
    }
    paramJSONObject = paramJSONObject.optJSONObject("accelerate");
    if (paramJSONObject != null)
    {
      this.c = new b("");
      this.c.a(paramJSONObject);
      if (this.a == null) {
        this.a = this.c.c;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/b/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */