package com.baidu.trace;

import com.baidu.trace.a.d;
import com.baidu.trace.c.g;
import org.json.JSONObject;

public class t
  implements g
{
  public final void a() {}
  
  public final void a(JSONObject paramJSONObject)
  {
    az.a = 0;
    d locald = new d();
    try
    {
      locald.a = ((byte)paramJSONObject.getInt("operat_result"));
      return;
    }
    catch (Exception paramJSONObject)
    {
      locald.a = 0;
      return;
    }
    finally
    {
      bc.a().a(locald);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */