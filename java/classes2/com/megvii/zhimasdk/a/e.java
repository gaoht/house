package com.megvii.zhimasdk.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  protected List<a> a = new ArrayList();
  private String b = "";
  private String c = "";
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("__source__", this.c);
      localJSONObject.put("__topic__", this.b);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(new JSONObject(((a)localIterator.next()).a()));
      }
      localJSONException.put("__logs__", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return null;
    }
    String str = localJSONException.toString();
    return str;
  }
  
  public void a(a parama)
  {
    this.a.add(parama);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */