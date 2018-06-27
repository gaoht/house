package com.mato.sdk.a;

import android.text.TextUtils;
import com.mato.sdk.c.b.f;
import com.mato.sdk.d.m;
import com.mato.sdk.f.d;
import com.mato.sdk.f.h;
import com.mato.sdk.f.h.a;
import com.mato.sdk.f.h.b;
import com.mato.sdk.f.k;
import com.mato.sdk.g.i;
import com.mato.sdk.g.j;
import com.mato.sdk.proxy.Proxy;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends com.mato.sdk.f.e<JSONObject>
{
  private static final String b = com.mato.sdk.b.g.b("");
  private static String[] f = { "203.130.43.48", "203.130.43.47", "103.243.252.227", "103.243.252.226" };
  private final String c;
  private final h.b<JSONObject> d;
  private com.mato.sdk.f.a e;
  
  private c(String paramString1, String paramString2, h.b<JSONObject> paramb, h.a parama)
  {
    super(1, paramString2, parama);
    this.c = paramString1;
    this.d = paramb;
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (this.d != null) {
      this.d.a(paramJSONObject);
    }
  }
  
  protected final h<JSONObject> a(d paramd)
  {
    try
    {
      h localh = h.a(new JSONObject(j.b(paramd.b, "80dee591a993ea01e51a766134f7827d")));
      return localh;
    }
    catch (Throwable localThrowable)
    {
      f.b().a(localThrowable, paramd.b);
      return h.a(localThrowable);
    }
  }
  
  public final Map<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Content-Type", "text/plain; charset=UTF-8");
    return localHashMap;
  }
  
  public final com.mato.sdk.f.a b()
  {
    if (this.e == null) {
      this.e = new com.mato.sdk.f.a("auth", f);
    }
    return this.e;
  }
  
  public final com.mato.sdk.f.g c()
  {
    if (this.c == null) {
      return null;
    }
    return new k(this.c);
  }
  
  public static final class a
  {
    private final int a;
    private String b;
    private String c;
    private long d;
    private long e;
    private int f;
    private String g;
    private h.a h;
    private h.b<JSONObject> i;
    
    private String b()
      throws JSONException
    {
      Object localObject2 = com.mato.sdk.proxy.a.a();
      Object localObject1 = j.a(((com.mato.sdk.b.e)localObject2).e(), "80dee591a993ea01e51a766134f7827d");
      String str1 = j.a(((com.mato.sdk.b.e)localObject2).d(), "80dee591a993ea01e51a766134f7827d");
      String str2 = Proxy.getVersion();
      String str3 = ((com.mato.sdk.b.e)localObject2).j();
      String str4 = i.a();
      String str5 = m.a(str4 + "2989d4f8dcda393d1c1ca3c021f0cb10" + str3);
      String str6 = ((com.mato.sdk.b.e)localObject2).l();
      String str7 = com.mato.sdk.b.e.c();
      String str8 = ((com.mato.sdk.b.e)localObject2).i();
      String str9 = ((com.mato.sdk.b.e)localObject2).a();
      localObject2 = new JSONObject();
      getClass();
      ((JSONObject)localObject2).put("version", 2);
      ((JSONObject)localObject2).put("packageName", str3);
      ((JSONObject)localObject2).put("fingerPrint", str6);
      ((JSONObject)localObject2).put("timestamp", str4);
      ((JSONObject)localObject2).put("authKey", str5);
      ((JSONObject)localObject2).put("sdkVersion", str2);
      ((JSONObject)localObject2).put("platform", str7);
      ((JSONObject)localObject2).put("imei", localObject1);
      ((JSONObject)localObject2).put("appVersion", str8);
      ((JSONObject)localObject2).put("networkType", this.b);
      ((JSONObject)localObject2).put("imsi", str1);
      ((JSONObject)localObject2).put("model", str9);
      ((JSONObject)localObject2).put("lastRequestNum", this.d);
      ((JSONObject)localObject2).put("lastUseTime", this.e);
      ((JSONObject)localObject2).put("type", this.f);
      localObject1 = d(this.c);
      if (localObject1 != null) {
        ((JSONObject)localObject2).put("authFailTime", localObject1);
      }
      return ((JSONObject)localObject2).toString();
    }
    
    private static JSONArray d(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramString = null;
        return paramString;
      }
      String[] arrayOfString = paramString.split(",");
      JSONArray localJSONArray = new JSONArray();
      int k = arrayOfString.length;
      int j = 0;
      for (;;)
      {
        paramString = localJSONArray;
        if (j >= k) {
          break;
        }
        paramString = arrayOfString[j];
        if (paramString.length() > 0) {}
        try
        {
          localJSONArray.put(Long.parseLong(paramString));
          j += 1;
        }
        catch (Exception paramString)
        {
          for (;;) {}
        }
      }
    }
    
    public final a a(int paramInt)
    {
      this.f = paramInt;
      return this;
    }
    
    public final a a(long paramLong)
    {
      this.d = paramLong;
      return this;
    }
    
    public final a a(h.a parama)
    {
      this.h = parama;
      return this;
    }
    
    public final a a(h.b<JSONObject> paramb)
    {
      this.i = paramb;
      return this;
    }
    
    public final a a(String paramString)
    {
      this.g = paramString;
      return this;
    }
    
    public final c a()
    {
      Object localObject1 = "";
      try
      {
        Object localObject3 = com.mato.sdk.proxy.a.a();
        Object localObject2 = j.a(((com.mato.sdk.b.e)localObject3).e(), "80dee591a993ea01e51a766134f7827d");
        String str1 = j.a(((com.mato.sdk.b.e)localObject3).d(), "80dee591a993ea01e51a766134f7827d");
        String str2 = Proxy.getVersion();
        String str3 = ((com.mato.sdk.b.e)localObject3).j();
        String str4 = i.a();
        String str5 = m.a(str4 + "2989d4f8dcda393d1c1ca3c021f0cb10" + str3);
        String str6 = ((com.mato.sdk.b.e)localObject3).l();
        String str7 = com.mato.sdk.b.e.c();
        String str8 = ((com.mato.sdk.b.e)localObject3).i();
        String str9 = ((com.mato.sdk.b.e)localObject3).a();
        localObject3 = new JSONObject();
        getClass();
        ((JSONObject)localObject3).put("version", 2);
        ((JSONObject)localObject3).put("packageName", str3);
        ((JSONObject)localObject3).put("fingerPrint", str6);
        ((JSONObject)localObject3).put("timestamp", str4);
        ((JSONObject)localObject3).put("authKey", str5);
        ((JSONObject)localObject3).put("sdkVersion", str2);
        ((JSONObject)localObject3).put("platform", str7);
        ((JSONObject)localObject3).put("imei", localObject2);
        ((JSONObject)localObject3).put("appVersion", str8);
        ((JSONObject)localObject3).put("networkType", this.b);
        ((JSONObject)localObject3).put("imsi", str1);
        ((JSONObject)localObject3).put("model", str9);
        ((JSONObject)localObject3).put("lastRequestNum", this.d);
        ((JSONObject)localObject3).put("lastUseTime", this.e);
        ((JSONObject)localObject3).put("type", this.f);
        localObject2 = d(this.c);
        if (localObject2 != null) {
          ((JSONObject)localObject3).put("authFailTime", localObject2);
        }
        localObject2 = ((JSONObject)localObject3).toString();
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
      c.d();
      return new c((String)localObject1, this.g, this.i, this.h, (byte)0);
    }
    
    public final a b(long paramLong)
    {
      this.e = paramLong;
      return this;
    }
    
    public final a b(String paramString)
    {
      this.c = paramString;
      return this;
    }
    
    public final a c(String paramString)
    {
      this.b = paramString;
      return this;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */