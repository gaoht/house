package com.growingio.android.sdk.models;

import android.text.TextUtils;
import com.growingio.android.sdk.collection.GConfig;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  public boolean a;
  public String b;
  public String c;
  public String d;
  public String e;
  public h f;
  public h g;
  String h;
  public String i;
  e j;
  
  public f() {}
  
  public f(JSONObject paramJSONObject)
  {
    try
    {
      this.b = paramJSONObject.getString("id");
      this.c = paramJSONObject.getString("name");
      this.d = paramJSONObject.getString("eventType");
      this.e = paramJSONObject.getString("platform");
      this.i = paramJSONObject.optString("source");
      this.f = h.a(paramJSONObject.getJSONObject("attrs"));
      this.g = h.a(paramJSONObject.getJSONObject("filter"));
      this.j = e.a(paramJSONObject.getJSONObject("screenshot"));
      this.a = TextUtils.equals(paramJSONObject.optString("status"), "archived");
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  public f a()
  {
    f localf = new f();
    localf.b = this.b;
    localf.e = this.e;
    localf.d = this.d;
    localf.c = this.c;
    localf.h = this.h;
    localf.f = this.f.b();
    localf.g = this.g.b();
    return localf;
  }
  
  public JSONObject b()
  {
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("id", this.b);
      localJSONObject2.put("name", this.c);
      localJSONObject2.put("eventType", this.d);
      localJSONObject2.put("platform", this.e);
      localJSONObject2.put("attrs", this.f.a());
      localJSONObject2.put("filter", this.g.a());
      localJSONObject2.put("comment", this.h);
      localJSONObject2.put("appVersion", GConfig.sAppVersion);
      localJSONObject2.put("sdkVersion", "1.1.2_dcb91e54");
      if (!TextUtils.isEmpty(this.i)) {
        localJSONObject2.put("source", this.i);
      }
      JSONObject localJSONObject1 = new JSONObject();
      if (this.j != null) {
        localJSONObject1 = this.j.a();
      }
      localJSONObject2.put("screenshot", localJSONObject1);
      return localJSONObject2;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject2;
  }
  
  public String toString()
  {
    return b().toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/models/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */