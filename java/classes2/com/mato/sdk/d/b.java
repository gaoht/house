package com.mato.sdk.d;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  extends c
{
  private static final String d = "domain";
  private static final String e = "cname";
  private static final String f = "bypassIps";
  public String a = "";
  public boolean b = false;
  public List<String> c = new ArrayList();
  
  public final boolean a(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("bypassIps");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      this.c = a(localJSONArray);
      this.a = paramJSONObject.optString("domain", this.a);
      this.b = paramJSONObject.optBoolean("cname", this.b);
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */