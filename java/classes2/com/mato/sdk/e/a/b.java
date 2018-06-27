package com.mato.sdk.e.a;

import com.mato.sdk.b.e;
import com.mato.sdk.b.g;
import com.mato.sdk.b.h;
import com.mato.sdk.c.b.f;
import com.mato.sdk.c.c.a;
import com.mato.sdk.c.c.b;
import com.mato.sdk.d.m;
import com.mato.sdk.g.j;
import com.mato.sdk.proxy.a;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static final String a = g.b("");
  
  public static void a(String paramString)
  {
    try
    {
      c.a locala = new c.a();
      locala.b("maa-dns");
      locala.c("gzip");
      e locale = a.a();
      long l = new Date().getTime();
      String str1 = m.a(String.valueOf(l) + "2989d4f8dcda393d1c1ca3c021f0cb10" + locale.j());
      String str2 = a.b().h().a();
      HashMap localHashMap = new HashMap();
      localHashMap.put("platform", e.c());
      localHashMap.put("imei", j.a(locale.e(), "80dee591a993ea01e51a766134f7827d"));
      localHashMap.put("imsi", j.a(locale.d(), "80dee591a993ea01e51a766134f7827d"));
      localHashMap.put("packageName", locale.j());
      localHashMap.put("timestamp", String.valueOf(l));
      localHashMap.put("authKey", str1);
      localHashMap.put("networkType", str2);
      localHashMap.toString();
      locala.a(localHashMap);
      locala.a("dnslog.gzip");
      locala.a(com.mato.sdk.g.b.a(paramString.getBytes()));
      locala.a(new c.b()
      {
        public final void a()
        {
          b.a();
        }
        
        public final void b()
        {
          b.a();
        }
      });
      a.b().a(locala.a());
      return;
    }
    catch (Throwable paramString)
    {
      f.b().a(paramString);
    }
  }
  
  private static Map<String, String> b()
  {
    e locale = a.a();
    long l = new Date().getTime();
    String str1 = m.a(String.valueOf(l) + "2989d4f8dcda393d1c1ca3c021f0cb10" + locale.j());
    String str2 = a.b().h().a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("platform", e.c());
    localHashMap.put("imei", j.a(locale.e(), "80dee591a993ea01e51a766134f7827d"));
    localHashMap.put("imsi", j.a(locale.d(), "80dee591a993ea01e51a766134f7827d"));
    localHashMap.put("packageName", locale.j());
    localHashMap.put("timestamp", String.valueOf(l));
    localHashMap.put("authKey", str1);
    localHashMap.put("networkType", str2);
    localHashMap.toString();
    return localHashMap;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */