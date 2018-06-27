package com.baidu.trace;

import com.baidu.trace.a.a;
import com.baidu.trace.c.g;
import org.json.JSONObject;

public class b
  implements g
{
  protected static byte a;
  
  public final void a() {}
  
  public final void a(JSONObject paramJSONObject)
  {
    a locala = new a();
    try
    {
      locala.a = ((byte)paramJSONObject.getInt("operat_result"));
      return;
    }
    catch (Exception paramJSONObject)
    {
      locala.a = 0;
      return;
    }
    finally
    {
      bc.a().a(locala);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */