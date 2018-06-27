package com.baidu.trace;

import org.json.JSONObject;

public final class g
  implements com.baidu.trace.c.g
{
  protected static String a = null;
  protected static long b = 0L;
  protected static String c = null;
  protected static String d = null;
  
  protected static void b()
  {
    a = null;
    c = null;
    d = null;
  }
  
  public final void a() {}
  
  public final void a(JSONObject paramJSONObject)
  {
    try
    {
      if ((!paramJSONObject.has("access_key")) || (!paramJSONObject.has("expire_time")) || (!paramJSONObject.has("secret_key")) || (!paramJSONObject.has("token")))
      {
        b();
        bc.a().a(1);
        return;
      }
      a = paramJSONObject.getString("access_key");
      b = paramJSONObject.getLong("expire_time");
      c = paramJSONObject.getString("secret_key");
      d = paramJSONObject.getString("token");
      h.a();
      bc.a().a(0);
      return;
    }
    catch (Exception paramJSONObject)
    {
      b();
      bc.a().a(1);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */