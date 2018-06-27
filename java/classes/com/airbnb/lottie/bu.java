package com.airbnb.lottie;

import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class bu
{
  private final String a;
  private final List<Object> b;
  
  bu(String paramString, List<Object> paramList)
  {
    this.a = paramString;
    this.b = paramList;
  }
  
  static Object a(JSONObject paramJSONObject, aw paramaw)
  {
    String str = paramJSONObject.optString("ty");
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        Log.w("LOTTIE", "Unknown shape type " + str);
        return null;
        if (str.equals("gr"))
        {
          i = 0;
          continue;
          if (str.equals("st"))
          {
            i = 1;
            continue;
            if (str.equals("gs"))
            {
              i = 2;
              continue;
              if (str.equals("fl"))
              {
                i = 3;
                continue;
                if (str.equals("gf"))
                {
                  i = 4;
                  continue;
                  if (str.equals("tr"))
                  {
                    i = 5;
                    continue;
                    if (str.equals("sh"))
                    {
                      i = 6;
                      continue;
                      if (str.equals("el"))
                      {
                        i = 7;
                        continue;
                        if (str.equals("rc"))
                        {
                          i = 8;
                          continue;
                          if (str.equals("tm"))
                          {
                            i = 9;
                            continue;
                            if (str.equals("sr"))
                            {
                              i = 10;
                              continue;
                              if (str.equals("mm")) {
                                i = 11;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return a.a(paramJSONObject, paramaw);
    return by.a.a(paramJSONObject, paramaw);
    return ak.a.a(paramJSONObject, paramaw);
    return bt.a.a(paramJSONObject, paramaw);
    return ai.a.a(paramJSONObject, paramaw);
    return j.a.a(paramJSONObject, paramaw);
    return bx.a.a(paramJSONObject, paramaw);
    return s.a.a(paramJSONObject, paramaw);
    return bo.a.a(paramJSONObject, paramaw);
    return bz.a.a(paramJSONObject, paramaw);
    return bm.a.a(paramJSONObject, paramaw);
    return bb.a.a(paramJSONObject);
  }
  
  List<Object> a()
  {
    return this.b;
  }
  
  public String getName()
  {
    return this.a;
  }
  
  public String toString()
  {
    return "ShapeGroup{name='" + this.a + "' Shapes: " + Arrays.toString(this.b.toArray()) + '}';
  }
  
  static class a
  {
    private static bu b(JSONObject paramJSONObject, aw paramaw)
    {
      JSONArray localJSONArray = paramJSONObject.optJSONArray("it");
      paramJSONObject = paramJSONObject.optString("nm");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < localJSONArray.length())
      {
        Object localObject = bu.a(localJSONArray.optJSONObject(i), paramaw);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
      return new bu(paramJSONObject, localArrayList);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */