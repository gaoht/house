package com.g.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONObject;

public class ap
{
  private static volatile ap a = null;
  
  static
  {
    try
    {
      ad.a().register(a());
      return;
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
  }
  
  public static ap a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ap();
      }
      return a;
    }
    finally {}
  }
  
  private Map a(Map paramMap)
  {
    TreeMap localTreeMap = new TreeMap();
    if (paramMap != null) {}
    for (;;)
    {
      try
      {
        if (paramMap.size() == 0) {
          return localTreeMap;
        }
        paramMap = paramMap.entrySet().iterator();
        int i = 0;
        if (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          localTreeMap.put(localEntry.getKey(), z.a(String.valueOf(localEntry.getValue())));
          i += 1;
          if (i != 50) {
            continue;
          }
        }
      }
      catch (Throwable paramMap)
      {
        av.postSDKError(paramMap);
        continue;
      }
      return localTreeMap;
    }
  }
  
  public final void onTDEBEventAppEvent(db.a parama)
  {
    if (parama != null) {
      try
      {
        if (parama.a != null)
        {
          if (Integer.parseInt(String.valueOf(parama.a.get("apiType"))) != 2) {
            return;
          }
          Object localObject1 = (a)parama.a.get("service");
          if ((i.a((a)localObject1) != null) && (!i.a((a)localObject1).isEmpty()))
          {
            TreeMap localTreeMap = new TreeMap();
            String str = String.valueOf(parama.a.get("eventId"));
            if ((c.c.size() > 0) && (str != null) && (!str.startsWith("__"))) {
              localTreeMap.putAll(c.c);
            }
            Object localObject2 = parama.a.get("map");
            if ((localObject2 != null) && ((localObject2 instanceof Map))) {
              localTreeMap.putAll((Map)localObject2);
            }
            localObject2 = new be();
            ((be)localObject2).b = "appEvent";
            ((be)localObject2).c = str;
            ((be)localObject2).a = ((a)localObject1);
            localObject1 = new TreeMap();
            ((Map)localObject1).put("eventLabel", String.valueOf(parama.a.get("eventLabel")));
            ((Map)localObject1).put("eventParam", new JSONObject(a(localTreeMap)));
            ((be)localObject2).d = ((Map)localObject1);
            ad.a().post(localObject2);
            return;
          }
        }
      }
      catch (NumberFormatException parama)
      {
        av.postSDKError(parama);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */