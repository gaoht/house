package com.mato.sdk.e.d;

import android.os.Build;
import com.mato.sdk.c.b.f;
import com.mato.sdk.f.d;
import com.mato.sdk.f.h.a;
import com.mato.sdk.f.h.b;
import com.mato.sdk.f.k;
import com.mato.sdk.g.j;
import com.mato.sdk.proxy.Proxy;
import com.mato.sdk.proxy.a;
import org.json.JSONException;
import org.json.JSONObject;

final class c
  extends com.mato.sdk.f.e<JSONObject>
{
  private static final String b = com.mato.sdk.b.g.b("");
  private final h.b<JSONObject> c;
  private final String d;
  
  c(a parama)
  {
    super(1, a.a(parama), a.b(parama));
    Object localObject = null;
    try
    {
      String str = a.c(parama);
      localObject = str;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
    this.d = ((String)localObject);
    this.c = a.d(parama);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (this.c != null) {
      this.c.a(paramJSONObject);
    }
  }
  
  protected final com.mato.sdk.f.h<JSONObject> a(d paramd)
  {
    try
    {
      com.mato.sdk.f.h localh = com.mato.sdk.f.h.a(new JSONObject(j.b(paramd.b, "80dee591a993ea01e51a766134f7827d")));
      return localh;
    }
    catch (Throwable localThrowable)
    {
      f.b().a(localThrowable, paramd.b);
      return com.mato.sdk.f.h.a(localThrowable);
    }
  }
  
  public final com.mato.sdk.f.g c()
  {
    if (this.d == null) {
      return null;
    }
    return new k(this.d);
  }
  
  public static final class a
  {
    private String a;
    private String b;
    private h.a c;
    private h.b<JSONObject> d;
    
    private String b()
      throws JSONException
    {
      Object localObject = a.a();
      String str1 = j.a(((com.mato.sdk.b.e)localObject).e(), "80dee591a993ea01e51a766134f7827d");
      String str2 = ((com.mato.sdk.b.e)localObject).j();
      String str3 = Proxy.getVersion();
      String str4 = com.mato.sdk.b.e.c();
      String str5 = Build.MANUFACTURER + " " + Build.MODEL;
      String str6 = a.b().h().a();
      localObject = j.a(((com.mato.sdk.b.e)localObject).d(), "80dee591a993ea01e51a766134f7827d");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("imei", str1);
      localJSONObject.put("packageName", str2);
      localJSONObject.put("sdkVersion", str3);
      localJSONObject.put("platform", str4);
      localJSONObject.put("model", str5);
      localJSONObject.put("networkType", str6);
      localJSONObject.put("imsi", localObject);
      localJSONObject.put("testIds", this.b);
      c.d();
      localJSONObject.toString();
      return localJSONObject.toString();
    }
    
    public final a a(h.a parama)
    {
      this.c = parama;
      return this;
    }
    
    public final a a(h.b<JSONObject> paramb)
    {
      this.d = paramb;
      return this;
    }
    
    public final a a(String paramString)
    {
      this.a = paramString;
      return this;
    }
    
    public final c a()
    {
      return new c(this);
    }
    
    public final a b(String paramString)
    {
      this.b = paramString;
      return this;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */