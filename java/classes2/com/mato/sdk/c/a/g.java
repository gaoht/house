package com.mato.sdk.c.a;

import android.os.Build;
import com.mato.sdk.b.e;
import com.mato.sdk.c.c.b;
import com.mato.sdk.d.m;
import com.mato.sdk.g.i;
import com.mato.sdk.g.j;
import com.mato.sdk.proxy.Proxy;
import com.mato.sdk.proxy.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public final class g
  implements b
{
  private static final String a = com.mato.sdk.b.g.b("");
  private static String b = "wspx-client";
  private final StringBuilder c = new StringBuilder();
  private final d d;
  private final com.mato.sdk.d.f e;
  private int f;
  private int g;
  private int h;
  
  public g(com.mato.sdk.d.f paramf, d paramd)
  {
    this.e = paramf;
    this.d = paramd;
    this.g = a();
    this.f = 0;
    this.h = 0;
  }
  
  private int a()
  {
    int i = this.e.a();
    int j = this.e.c();
    if (this.e.d()) {}
    do
    {
      return i;
      j -= this.f;
    } while (j > i);
    return j;
  }
  
  private static Map<String, String> a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    e locale = com.mato.sdk.proxy.a.a();
    String str1 = i.a();
    String str2 = m.a(str1 + "2989d4f8dcda393d1c1ca3c021f0cb10" + locale.j());
    String str3 = j.a(locale.e(), "80dee591a993ea01e51a766134f7827d");
    String str4 = j.a(locale.d(), "80dee591a993ea01e51a766134f7827d");
    HashMap localHashMap = new HashMap();
    localHashMap.put("version", "2");
    localHashMap.put("imei", str3);
    localHashMap.put("imsi", str4);
    localHashMap.put("packageName", locale.j());
    localHashMap.put("networkType", paramString);
    localHashMap.put("viaProxy", String.valueOf(paramBoolean1));
    localHashMap.put("serviceType", String.valueOf(paramInt));
    localHashMap.put("timestamp", str1);
    localHashMap.put("authKey", str2);
    localHashMap.put("platform", e.c());
    localHashMap.put("appVersion", locale.i());
    localHashMap.put("resolution", locale.f());
    localHashMap.put("sdkVersion", Proxy.getVersion());
    localHashMap.put("reportFirstTime", String.valueOf(paramBoolean2));
    localHashMap.put("model", Build.MANUFACTURER + " " + Build.MODEL);
    localHashMap.put("edgeChanged", "false");
    localHashMap.put("dnsList", com.mato.sdk.d.h.a(i.b()).toString());
    localHashMap.toString();
    return localHashMap;
  }
  
  private void b()
  {
    a.a().b(this);
  }
  
  private void b(String paramString)
  {
    boolean bool2 = this.d.j();
    int i = this.d.i().c();
    String str1 = this.d.h().a();
    if (this.f == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      com.mato.sdk.c.a locala = new com.mato.sdk.c.a();
      locala.b("wspx-client");
      locala.c("gzip");
      locala.a("accesslog.gzip");
      e locale = com.mato.sdk.proxy.a.a();
      String str2 = i.a();
      String str3 = m.a(str2 + "2989d4f8dcda393d1c1ca3c021f0cb10" + locale.j());
      String str4 = j.a(locale.e(), "80dee591a993ea01e51a766134f7827d");
      String str5 = j.a(locale.d(), "80dee591a993ea01e51a766134f7827d");
      HashMap localHashMap = new HashMap();
      localHashMap.put("version", "2");
      localHashMap.put("imei", str4);
      localHashMap.put("imsi", str5);
      localHashMap.put("packageName", locale.j());
      localHashMap.put("networkType", str1);
      localHashMap.put("viaProxy", String.valueOf(bool2));
      localHashMap.put("serviceType", String.valueOf(i));
      localHashMap.put("timestamp", str2);
      localHashMap.put("authKey", str3);
      localHashMap.put("platform", e.c());
      localHashMap.put("appVersion", locale.i());
      localHashMap.put("resolution", locale.f());
      localHashMap.put("sdkVersion", Proxy.getVersion());
      localHashMap.put("reportFirstTime", String.valueOf(bool1));
      localHashMap.put("model", Build.MANUFACTURER + " " + Build.MODEL);
      localHashMap.put("edgeChanged", "false");
      localHashMap.put("dnsList", com.mato.sdk.d.h.a(i.b()).toString());
      localHashMap.toString();
      locala.a(localHashMap);
      locala.a(com.mato.sdk.g.b.a(paramString.getBytes()));
      locala.a(new c.b()
      {
        public final void a()
        {
          com.mato.sdk.proxy.f.a(g.a(g.this), "accesslog report success");
        }
        
        public final void b()
        {
          com.mato.sdk.proxy.f.a(g.a(g.this), "accesslog report failure");
        }
      });
      locala.a();
      return;
    }
  }
  
  public final void a(String paramString)
  {
    if (this.g <= 0) {}
    do
    {
      return;
      this.c.append(paramString).append("\n");
      i = this.h + 1;
      this.h = i;
    } while (i != this.g);
    paramString = this.c.toString();
    boolean bool2 = this.d.j();
    int i = this.d.i().c();
    String str1 = this.d.h().a();
    if (this.f == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      com.mato.sdk.c.a locala = new com.mato.sdk.c.a();
      locala.b("wspx-client");
      locala.c("gzip");
      locala.a("accesslog.gzip");
      e locale = com.mato.sdk.proxy.a.a();
      String str2 = i.a();
      String str3 = m.a(str2 + "2989d4f8dcda393d1c1ca3c021f0cb10" + locale.j());
      String str4 = j.a(locale.e(), "80dee591a993ea01e51a766134f7827d");
      String str5 = j.a(locale.d(), "80dee591a993ea01e51a766134f7827d");
      HashMap localHashMap = new HashMap();
      localHashMap.put("version", "2");
      localHashMap.put("imei", str4);
      localHashMap.put("imsi", str5);
      localHashMap.put("packageName", locale.j());
      localHashMap.put("networkType", str1);
      localHashMap.put("viaProxy", String.valueOf(bool2));
      localHashMap.put("serviceType", String.valueOf(i));
      localHashMap.put("timestamp", str2);
      localHashMap.put("authKey", str3);
      localHashMap.put("platform", e.c());
      localHashMap.put("appVersion", locale.i());
      localHashMap.put("resolution", locale.f());
      localHashMap.put("sdkVersion", Proxy.getVersion());
      localHashMap.put("reportFirstTime", String.valueOf(bool1));
      localHashMap.put("model", Build.MANUFACTURER + " " + Build.MODEL);
      localHashMap.put("edgeChanged", "false");
      localHashMap.put("dnsList", com.mato.sdk.d.h.a(i.b()).toString());
      localHashMap.toString();
      locala.a(localHashMap);
      locala.a(com.mato.sdk.g.b.a(paramString.getBytes()));
      locala.a(new c.b()
      {
        public final void a()
        {
          com.mato.sdk.proxy.f.a(g.a(g.this), "accesslog report success");
        }
        
        public final void b()
        {
          com.mato.sdk.proxy.f.a(g.a(g.this), "accesslog report failure");
        }
      });
      locala.a();
      this.f += this.g;
      this.h = 0;
      this.c.delete(0, this.c.length());
      this.g = a();
      if (this.g != 0) {
        break;
      }
      a.a().b(this);
      return;
    }
  }
  
  public final boolean a(com.mato.sdk.d.f paramf)
  {
    return this.e.a(paramf);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/c/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */