package com.baidu.trace;

import com.baidu.trace.a.b;
import com.baidu.trace.a.e;
import com.baidu.trace.c.g;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public final class c
  implements g
{
  private static ArrayList<e> a = null;
  
  protected static void b()
  {
    if (a != null)
    {
      a.clear();
      a = null;
    }
  }
  
  public final void a()
  {
    if (a == null) {
      a = new ArrayList();
    }
    TraceJniInterface.a().clearAttributeData();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      TraceJniInterface.a().addAttributeData(locale.a, locale.b);
    }
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    new b();
    bc.a();
    bc.b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */