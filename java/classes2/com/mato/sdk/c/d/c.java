package com.mato.sdk.c.d;

import com.mato.sdk.b.e;
import com.mato.sdk.b.g;
import com.mato.sdk.c.c.a;
import com.mato.sdk.c.c.b;
import com.mato.sdk.g.j;
import com.mato.sdk.proxy.a;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static final String a = g.b("");
  private static String b = "maa-event";
  
  private static InputStream a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  private static Map<String, String> a(e parame)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
    localHashMap.put("packageName", parame.j());
    localHashMap.put("imei", j.a(parame.e(), "80dee591a993ea01e51a766134f7827d"));
    localHashMap.put("model", parame.a());
    localHashMap.put("platform", e.c());
    localHashMap.toString();
    return localHashMap;
  }
  
  public static void a(byte[] paramArrayOfByte, c.b paramb)
  {
    e locale = a.a();
    paramArrayOfByte = a(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      return;
    }
    c.a locala = new c.a();
    locala.b("maa-event");
    locala.c("gzip");
    locala.a("eventlog.gzip");
    HashMap localHashMap = new HashMap();
    localHashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
    localHashMap.put("packageName", locale.j());
    localHashMap.put("imei", j.a(locale.e(), "80dee591a993ea01e51a766134f7827d"));
    localHashMap.put("model", locale.a());
    localHashMap.put("platform", e.c());
    localHashMap.toString();
    locala.a(localHashMap);
    locala.a(paramArrayOfByte);
    locala.a(paramb);
    a.b().a(locala.a());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/c/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */