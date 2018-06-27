package com.growingio.android.sdk.models;

import android.text.TextUtils;
import com.growingio.android.sdk.collection.AppState;
import com.growingio.android.sdk.collection.SessionManager;
import org.json.JSONArray;
import org.json.JSONObject;

public class l
  extends g
{
  String a;
  i b;
  String c;
  JSONObject d;
  int g = 0;
  String h = "hybrid";
  
  public l(String paramString1, i parami, String paramString2)
  {
    this.a = paramString1;
    this.b = parami;
    this.c = paramString2;
  }
  
  private void a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    String str = paramJSONObject.getString(paramString1);
    if (str != null) {
      paramJSONObject.put(paramString1, paramString2 + "::" + str);
    }
  }
  
  public String a()
  {
    return this.h;
  }
  
  public String a_()
  {
    if (this.h.equals("clck")) {
      return "click";
    }
    return this.h;
  }
  
  public JSONObject c()
  {
    int i = 0;
    if (this.d != null) {
      return this.d;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject(this.a);
        this.h = localJSONObject1.getString("t");
        localJSONObject1.put("s", SessionManager.a());
        a(localJSONObject1, "d", j().b());
        a(localJSONObject1, "p", this.c);
        if ((this.h.equals("imp")) || (this.h.equals("clck")))
        {
          JSONArray localJSONArray = localJSONObject1.getJSONArray("e");
          int j = localJSONArray.length();
          this.g = j;
          a(localJSONObject1, true);
          if (i >= j) {
            break label304;
          }
          JSONObject localJSONObject2 = localJSONArray.getJSONObject(i);
          if (localJSONObject2.opt("idx") != null)
          {
            a(localJSONObject2, "x", this.b.i);
            if (!localJSONObject2.has("ex")) {
              break label352;
            }
            localJSONObject2.remove("ex");
            localJSONObject2.remove("ey");
            localJSONObject2.remove("ew");
            localJSONObject2.remove("eh");
            break label352;
          }
          a(localJSONObject2, "x", this.b.j);
          if (this.b.e <= -1) {
            continue;
          }
          localJSONObject1.put("idx", this.b.e);
          continue;
        }
        if (!this.h.equals("page")) {
          break label304;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      this.g = 1;
      g(localException);
      a(localException, false);
      if (!TextUtils.isEmpty(localException.optString("rp"))) {
        a(localException, "rp", this.c);
      }
      label304:
      if (!this.h.equals("imp"))
      {
        a(localException);
        b(localException);
      }
      if (localException.opt("tm") == null) {
        localException.put("tm", System.currentTimeMillis());
      }
      this.d = localException;
      return localException;
      label352:
      i += 1;
    }
  }
  
  public int i()
  {
    return this.g;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/models/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */