package com.mato.sdk.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h
{
  public final List<String> a;
  public final List<String> b;
  
  public h() {}
  
  public h(List<String> paramList1, List<String> paramList2)
  {
    this.a = paramList1;
    this.b = paramList2;
  }
  
  public static h a(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optJSONArray("pingHosts");
    if (localObject != null) {}
    for (localObject = c.a((JSONArray)localObject);; localObject = null)
    {
      paramJSONObject = paramJSONObject.optJSONArray("detectUrls");
      if (paramJSONObject != null) {}
      for (paramJSONObject = c.a(paramJSONObject);; paramJSONObject = null)
      {
        if ((localObject == null) && (paramJSONObject == null)) {
          return null;
        }
        return new h((List)localObject, paramJSONObject);
      }
    }
  }
  
  public static List<String> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length()) {}
      try
      {
        localArrayList.add(paramJSONArray.getString(i));
        i += 1;
        continue;
        return localArrayList;
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
    }
  }
  
  public static JSONArray a(List<String> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      try
      {
        localJSONArray.put(str);
      }
      catch (Exception localException) {}
    }
    return localJSONArray;
  }
  
  private static void a(List<String> paramList, JSONArray paramJSONArray)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length()) {}
      try
      {
        paramList.add(paramJSONArray.getString(i));
        i += 1;
        continue;
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
    }
  }
  
  private static List<Integer> b(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length()) {}
      try
      {
        localArrayList.add(Integer.valueOf(paramJSONArray.getInt(i)));
        i += 1;
        continue;
        return localArrayList;
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
    }
  }
  
  public final boolean a()
  {
    return (this.a != null) || (this.b != null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */