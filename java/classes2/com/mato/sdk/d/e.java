package com.mato.sdk.d;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class e
{
  private List<String> a;
  private int b = 30;
  
  public static e a(JSONObject paramJSONObject)
  {
    e locale = new e();
    locale.b = paramJSONObject.optInt("checkInterval", locale.b);
    paramJSONObject = paramJSONObject.optJSONArray("domains");
    if (paramJSONObject != null) {
      locale.a = c.a(paramJSONObject);
    }
    return locale;
  }
  
  private void a(String paramString)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    this.a.add(paramString);
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final String[] b()
  {
    List localList = this.a;
    if ((localList == null) || (localList.isEmpty())) {
      return null;
    }
    return (String[])localList.toArray(new String[localList.size()]);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */