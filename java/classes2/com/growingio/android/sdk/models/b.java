package com.growingio.android.sdk.models;

import android.text.TextUtils;
import com.growingio.android.sdk.utils.LogUtil;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  public String a;
  public long b;
  public int c = -1;
  public String d;
  public String e;
  private volatile int f;
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("x", this.a);
      localJSONObject.put("tm", System.currentTimeMillis());
      if (this.c >= 0) {
        localJSONObject.put("idx", this.c);
      }
      if (!TextUtils.isEmpty(this.e)) {
        localJSONObject.put("obj", this.e);
      }
      if (!TextUtils.isEmpty(this.d)) {
        localJSONObject.put("v", this.d);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      LogUtil.d("GIO.ActionStruct", "generate impress view error", localJSONException);
    }
    return null;
  }
  
  public int hashCode()
  {
    int k = 0;
    int j = this.f;
    int i = j;
    int m;
    if (j == 0)
    {
      if (this.a == null) {
        break label93;
      }
      i = this.a.hashCode();
      m = this.c;
      if (this.d == null) {
        break label98;
      }
    }
    label93:
    label98:
    for (j = this.d.hashCode();; j = 0)
    {
      if (this.e != null) {
        k = this.e.hashCode();
      }
      i = (j + ((i + 527) * 31 + m) * 31) * 31 + k;
      this.f = i;
      return i;
      i = 0;
      break;
    }
  }
  
  public String toString()
  {
    return String.format(Locale.getDefault(), "tm: %d, xpath: %s, idx: %d, content: %s", new Object[] { Long.valueOf(this.b), this.a, Integer.valueOf(this.c), this.d });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/models/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */