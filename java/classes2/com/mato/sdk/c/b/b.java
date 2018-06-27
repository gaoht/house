package com.mato.sdk.c.b;

import android.text.TextUtils;
import com.mato.android.matoid.service.mtunnel.HttpHandler;
import com.mato.sdk.b.g;
import com.mato.sdk.c.c.b;
import com.mato.sdk.g.j;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static final String a = g.b("");
  private static String b = "wspx-crash";
  
  private static String a(e parame, boolean paramBoolean)
  {
    String str2 = parame.a();
    String str1 = str2;
    if (paramBoolean) {
      str1 = str2 + "\nmaaextra:";
    }
    str2 = parame.b();
    parame = str1;
    if (!TextUtils.isEmpty(str2)) {
      parame = str1 + str2;
    }
    return parame;
  }
  
  private static Map<String, String> a(a parama)
  {
    com.mato.sdk.b.e locale = com.mato.sdk.proxy.a.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("fromSDK", String.valueOf(parama.d()));
    localHashMap.put("summary", parama.f().c());
    localHashMap.put("packageName", locale.j());
    localHashMap.put("timestamp", String.valueOf(parama.b()));
    localHashMap.put("platform", com.mato.sdk.b.e.c());
    localHashMap.put("model", locale.b() + "_" + locale.a());
    localHashMap.put("appVersion", locale.i());
    localHashMap.put("sdkVersion", parama.h());
    localHashMap.put("isNative", String.valueOf(parama.e()));
    if (!parama.a()) {}
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("isUncaught", String.valueOf(bool));
      localHashMap.put("abi", HttpHandler.b());
      localHashMap.put("imei", j.a(locale.e(), "80dee591a993ea01e51a766134f7827d"));
      return localHashMap;
    }
  }
  
  public static void a(a parama, c.b paramb)
  {
    boolean bool1 = true;
    Object localObject3 = parama.f();
    boolean bool2 = parama.a();
    Object localObject2 = ((e)localObject3).a();
    Object localObject1 = localObject2;
    if (bool2) {
      localObject1 = (String)localObject2 + "\nmaaextra:";
    }
    localObject3 = ((e)localObject3).b();
    localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject2 = (String)localObject1 + (String)localObject3;
    }
    localObject1 = new com.mato.sdk.c.a();
    ((com.mato.sdk.c.a)localObject1).b("wspx-crash");
    ((com.mato.sdk.c.a)localObject1).c("gzip");
    ((com.mato.sdk.c.a)localObject1).a("crashlog.gzip");
    localObject3 = com.mato.sdk.proxy.a.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("fromSDK", String.valueOf(parama.d()));
    localHashMap.put("summary", parama.f().c());
    localHashMap.put("packageName", ((com.mato.sdk.b.e)localObject3).j());
    localHashMap.put("timestamp", String.valueOf(parama.b()));
    localHashMap.put("platform", com.mato.sdk.b.e.c());
    localHashMap.put("model", ((com.mato.sdk.b.e)localObject3).b() + "_" + ((com.mato.sdk.b.e)localObject3).a());
    localHashMap.put("appVersion", ((com.mato.sdk.b.e)localObject3).i());
    localHashMap.put("sdkVersion", parama.h());
    localHashMap.put("isNative", String.valueOf(parama.e()));
    if (!parama.a()) {}
    for (;;)
    {
      localHashMap.put("isUncaught", String.valueOf(bool1));
      localHashMap.put("abi", HttpHandler.b());
      localHashMap.put("imei", j.a(((com.mato.sdk.b.e)localObject3).e(), "80dee591a993ea01e51a766134f7827d"));
      ((com.mato.sdk.c.a)localObject1).a(localHashMap);
      ((com.mato.sdk.c.a)localObject1).a(com.mato.sdk.g.b.a(((String)localObject2).getBytes()));
      ((com.mato.sdk.c.a)localObject1).a(paramb);
      ((com.mato.sdk.c.a)localObject1).a();
      return;
      bool1 = false;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/c/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */