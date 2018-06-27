package com.g.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class bp
  extends br
{
  private static HashMap a = new HashMap();
  private static volatile bp c = null;
  
  private bp()
  {
    a("displayName", g.a().h(c.e));
    a("globalId", g.a().a(c.e));
    a("versionName", i.k());
    a("versionCode", Integer.valueOf(i.j()));
    a("installTime", Long.valueOf(g.a().d(c.e)));
    a("updateTime", Long.valueOf(g.a().e(c.e)));
  }
  
  public static bp b()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new bp();
      }
      return c;
    }
    finally {}
  }
  
  public ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(a.a(((Map.Entry)localIterator.next()).getKey().toString()));
    }
    if (a.a(a.b.b()) != null) {
      localArrayList.add(a.b);
    }
    return localArrayList;
  }
  
  public void a(Object paramObject, a parama)
  {
    a.put(parama.b(), paramObject);
  }
  
  public void setAppChannel(String paramString)
  {
    a("channel", paramString);
  }
  
  public void setAppId(String paramString)
  {
    a.put("default", paramString);
  }
  
  public void setSubmitAppId(a parama)
  {
    if (parama != null) {}
    try
    {
      if (a.get(parama.b()) != null) {}
      for (parama = a.get(parama.b());; parama = a.get(a().get(0)))
      {
        a("appKey", parama);
        return;
      }
      a("appKey", a.get("default"));
      return;
    }
    catch (Throwable parama) {}
  }
  
  public void setUniqueId(String paramString)
  {
    a("uniqueId", paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */