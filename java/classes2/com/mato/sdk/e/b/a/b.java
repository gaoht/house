package com.mato.sdk.e.b.a;

import com.mato.sdk.e.b.j;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements j
{
  private static String p = "-";
  public String a = "-";
  public long b = -1L;
  public String c = "";
  public String d = "";
  public int e = -1;
  public String f = "text/xml;charset=gbk";
  public int g = -1;
  public int h = -1;
  public int i = -1;
  public int j = -1;
  public int k = -1;
  public int l = -1;
  public int m = -1;
  public String n;
  public String o;
  private String q = "GET";
  
  public b(String paramString)
  {
    this.c = paramString;
  }
  
  private boolean d()
  {
    return (this.d.contains("P")) || (this.d.contains("p"));
  }
  
  public final JSONObject a()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("destHost", this.a);
    localJSONObject.put("time", this.b);
    localJSONObject.put("url", this.c);
    localJSONObject.put("status", this.e);
    localJSONObject.put("relViaProxy", this.d);
    localJSONObject.put("method", this.q);
    localJSONObject.put("contentType", this.f);
    localJSONObject.put("dns", this.g);
    localJSONObject.put("conn", this.h);
    localJSONObject.put("send", this.i);
    localJSONObject.put("wait", this.j);
    localJSONObject.put("recv", this.k);
    localJSONObject.put("content-length", this.l);
    return localJSONObject;
  }
  
  public final void a(JSONObject paramJSONObject)
    throws JSONException
  {
    this.a = paramJSONObject.getString("destHost");
    this.b = paramJSONObject.getLong("time");
    this.c = paramJSONObject.getString("url");
    this.e = paramJSONObject.getInt("status");
    this.d = paramJSONObject.getString("relViaProxy");
    this.q = paramJSONObject.getString("method");
    this.f = paramJSONObject.getString("contentType");
    this.g = paramJSONObject.getInt("dns");
    this.h = paramJSONObject.getInt("conn");
    this.i = paramJSONObject.getInt("send");
    this.j = paramJSONObject.getInt("wait");
    this.k = paramJSONObject.getInt("recv");
    this.l = paramJSONObject.getInt("content-length");
    c();
  }
  
  public final int b()
  {
    if ((this.g == -1) || (this.h == -1) || (this.i == -1) || (this.j == -1) || (this.k == -1)) {
      return -1;
    }
    return this.g + this.h + this.i + this.j + this.k;
  }
  
  public final void c()
  {
    if ((200 == this.e) && (this.k > 0) && (this.l >= 0)) {
      this.m = (this.l * 1000 / (this.k << 10));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */