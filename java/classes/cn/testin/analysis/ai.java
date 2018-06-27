package cn.testin.analysis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class ai
  extends HashMap<String, Object>
{
  public ai()
  {
    b();
  }
  
  private void b()
  {
    put("clientId", al.d(a.d));
    put("appKey", a.e);
    put("appVersion", al.e(a.d));
    put("sdkVersion", a.f);
  }
  
  public JSONObject a()
  {
    Iterator localIterator = keySet().iterator();
    JSONObject localJSONObject = new JSONObject();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        localJSONObject.put(str, get(str));
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return localJSONObject;
  }
  
  public String toString()
  {
    return a().toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */