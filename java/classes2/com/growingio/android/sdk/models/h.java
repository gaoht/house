package com.growingio.android.sdk.models;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class h
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public boolean i = false;
  
  public static h a(JSONObject paramJSONObject)
  {
    h localh = new h();
    try
    {
      localh.d = paramJSONObject.getString("domain");
      localh.a = paramJSONObject.optString("xpath");
      localh.b = paramJSONObject.optString("path");
      localh.c = paramJSONObject.optString("content");
      localh.e = paramJSONObject.optString("index");
      localh.f = paramJSONObject.optString("query");
      localh.g = paramJSONObject.optString("href");
      localh.h = paramJSONObject.optString("nodeType");
      return localh;
    }
    catch (JSONException paramJSONObject) {}
    return localh;
  }
  
  private static boolean a(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if (TextUtils.isEmpty(paramString)) {
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramString.length() > 1);
    char c1 = paramString.charAt(0);
    int j;
    if ((c1 >= '0') && (c1 <= '9'))
    {
      j = 1;
      label48:
      if (((c1 < 'A') || (c1 > 'Z')) && ((c1 < 'a') || (c1 > 'z'))) {
        break label120;
      }
    }
    label120:
    for (int k = 1;; k = 0)
    {
      if ((j == 0) && (k == 0))
      {
        bool1 = bool2;
        if (!"_!@#$%^&*()-=+|\\[]{},.<>/?".contains(c1 + "")) {
          break;
        }
      }
      return false;
      j = 0;
      break label48;
    }
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("domain", this.d);
      localJSONObject.put("path", this.b);
      if (!TextUtils.isEmpty(this.a)) {
        localJSONObject.put("xpath", this.a);
      }
      if (a(this.c)) {
        localJSONObject.put("content", this.c);
      }
      if (!TextUtils.isEmpty(this.e)) {
        localJSONObject.put("index", this.e);
      }
      if (!TextUtils.isEmpty(this.f)) {
        localJSONObject.put("query", this.f);
      }
      if (!TextUtils.isEmpty("href")) {
        localJSONObject.put("href", this.g);
      }
      if (!TextUtils.isEmpty(this.h)) {
        localJSONObject.put("nodeType", this.h);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public h b()
  {
    h localh = new h();
    localh.a = this.a;
    localh.b = this.b;
    localh.c = this.c;
    localh.d = this.d;
    localh.e = this.e;
    localh.f = this.f;
    localh.g = this.g;
    localh.h = this.h;
    return localh;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/models/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */