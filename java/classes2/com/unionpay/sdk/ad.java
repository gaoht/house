package com.unionpay.sdk;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class ad
  extends bh
{
  private static volatile ad a = null;
  private bg b = t.a();
  
  static
  {
    try
    {
      ar.a().register(a());
      return;
    }
    catch (Throwable localThrowable)
    {
      k.a(localThrowable);
    }
  }
  
  public static ad a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ad();
      }
      return a;
    }
    finally {}
  }
  
  private final void a(String paramString1, String paramString2, String paramString3, Map paramMap)
  {
    if ((o.b() == null) || (o.b().isEmpty())) {
      return;
    }
    this.b.a(o.b(), paramString1, paramString2, Long.valueOf(paramString3).longValue(), paramMap);
  }
  
  public final void onTDEBEventAppEvent(ag.a parama)
  {
    if ((parama == null) || (parama.a == null)) {}
    do
    {
      do
      {
        return;
      } while (Integer.parseInt(String.valueOf(parama.a.get("apiType"))) != 4);
      if (ag.b) {
        break;
      }
      localObject1 = parama.a.get("context");
    } while ((localObject1 == null) || (!(localObject1 instanceof Context)));
    ag.a((Context)localObject1);
    Object localObject1 = new TreeMap();
    Object localObject2 = String.valueOf(parama.a.get("eventId"));
    if ((d.a.size() > 0) && (localObject2 != null) && (!((String)localObject2).startsWith("__"))) {
      ((Map)localObject1).putAll(d.a);
    }
    localObject2 = parama.a.get("map");
    if ((localObject2 != null) && ((localObject2 instanceof HashMap))) {
      ((Map)localObject1).putAll((Map)localObject2);
    }
    parama.a.put("controller", a());
    parama.a.put("map", localObject1);
    parama = parama.a;
    if ((parama.containsKey("map")) && ((parama.get("map") instanceof Map)))
    {
      a(String.valueOf(parama.get("eventId")), String.valueOf(parama.get("eventLabel")), String.valueOf(parama.get("occurTime")), (Map)parama.get("map"));
      return;
    }
    a(String.valueOf(parama.get("eventId")), String.valueOf(parama.get("eventLabel")), String.valueOf(parama.get("occurTime")), null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */