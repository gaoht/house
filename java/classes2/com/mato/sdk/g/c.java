package com.mato.sdk.g;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public final class c
{
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
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/g/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */