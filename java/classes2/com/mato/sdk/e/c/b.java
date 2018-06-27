package com.mato.sdk.e.c;

import com.mato.sdk.b.e;
import com.mato.sdk.f.h.a;
import com.mato.sdk.f.h.b;
import com.mato.sdk.g.j;
import com.mato.sdk.proxy.Proxy;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private String a;
  private String b;
  private String c;
  private h.a d;
  private h.b<JSONObject> e;
  
  private String b()
    throws JSONException
  {
    Object localObject = com.mato.sdk.proxy.a.a();
    String str1 = j.a(((e)localObject).e(), "80dee591a993ea01e51a766134f7827d");
    String str2 = j.a(((e)localObject).d(), "80dee591a993ea01e51a766134f7827d");
    String str3 = Proxy.getVersion();
    localObject = ((e)localObject).j();
    String str4 = e.c();
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("packageName", localObject);
    localJSONObject.put("sdkVersion", str3);
    localJSONObject.put("platform", str4);
    localJSONObject.put("imei", str1);
    localJSONObject.put("networkType", this.a);
    localJSONObject.put("imsi", str2);
    localJSONObject.put("md5", this.b);
    a.d();
    localJSONObject.toString();
    return localJSONObject.toString();
  }
  
  public final a.1 a(h.a parama)
  {
    this.d = parama;
    return this;
  }
  
  public final a.1 a(h.b<JSONObject> paramb)
  {
    this.e = paramb;
    return this;
  }
  
  public final a.1 a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public final a a()
  {
    return new a(this, (byte)0);
  }
  
  public final a.1 b(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public final a.1 c(String paramString)
  {
    this.b = paramString;
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */