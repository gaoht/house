package com.growingio.android.sdk.collection;

import android.util.Log;
import com.growingio.android.sdk.models.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomEvent
  extends g
{
  String a;
  JSONObject b;
  JSONObject c;
  long d;
  
  public CustomEvent(String paramString, JSONObject paramJSONObject)
  {
    this.a = paramString;
    this.b = paramJSONObject;
  }
  
  public CustomEvent(JSONObject paramJSONObject)
  {
    this.c = paramJSONObject;
    try
    {
      paramJSONObject.put("s", SessionManager.a());
      String str = paramJSONObject.getString("d");
      paramJSONObject.put("d", AppState.l().b() + "::" + str);
      str = paramJSONObject.getString("p");
      paramJSONObject.put("p", AppState.l().y() + "::" + str);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static ArrayList<CustomEvent> a(CustomEvent paramCustomEvent)
  {
    int i = 1;
    ArrayList localArrayList1 = h(paramCustomEvent.b);
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(paramCustomEvent);
    if (localArrayList1 == null) {
      return localArrayList2;
    }
    paramCustomEvent.b = ((JSONObject)localArrayList1.get(0));
    int j = localArrayList1.size();
    if (j == 1) {
      return localArrayList2;
    }
    long l = paramCustomEvent.d;
    paramCustomEvent = paramCustomEvent.a;
    while (i < j)
    {
      CustomEvent localCustomEvent = new CustomEvent(paramCustomEvent, (JSONObject)localArrayList1.get(i));
      localCustomEvent.d = l;
      localArrayList2.add(localCustomEvent);
      i += 1;
    }
    return localArrayList2;
  }
  
  private static ArrayList<JSONObject> a(JSONObject paramJSONObject, Map.Entry<String, JSONArray> paramEntry, String[] paramArrayOfString)
  {
    int i = 0;
    int j = 0;
    Object localObject = (String)paramEntry.getKey();
    JSONArray localJSONArray = (JSONArray)paramEntry.getValue();
    paramEntry = new ArrayList();
    int k = localJSONArray.length();
    if (k == 0)
    {
      paramEntry.add(paramJSONObject);
      return paramEntry;
    }
    JSONObject localJSONObject;
    try
    {
      if ((localJSONArray.get(0) instanceof JSONObject))
      {
        i = j;
        if (i < k)
        {
          localObject = new JSONObject(paramJSONObject, paramArrayOfString);
          localJSONObject = localJSONArray.getJSONObject(i);
          Iterator localIterator = localJSONObject.keys();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            ((JSONObject)localObject).put(str, localJSONObject.get(str));
          }
        }
        return paramEntry;
      }
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    for (;;)
    {
      paramEntry.add(localObject);
      i += 1;
      break;
      while (i < k)
      {
        localJSONObject = new JSONObject(paramJSONObject, paramArrayOfString);
        localJSONObject.put((String)localObject, localJSONArray.get(i));
        paramEntry.add(localJSONObject);
        i += 1;
      }
    }
  }
  
  private static ArrayList<JSONObject> a(JSONObject paramJSONObject, Set<Map.Entry<String, JSONArray>> paramSet)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      a(paramJSONObject, (Map.Entry)paramSet.next());
    }
    paramSet = new ArrayList();
    paramSet.add(paramJSONObject);
    return paramSet;
  }
  
  private static void a(JSONObject paramJSONObject, Map.Entry<String, JSONArray> paramEntry)
  {
    String str = (String)paramEntry.getKey();
    paramEntry = (JSONArray)paramEntry.getValue();
    int j = paramEntry.length();
    StringBuilder localStringBuilder = new StringBuilder();
    if (j == 0) {}
    try
    {
      paramJSONObject.put(str, "");
      if ((paramEntry.get(0) instanceof JSONObject)) {
        Log.w("GIO.VPAEvent", "GrowingIO打点属性中目前仅支持存在最多一个类型为Object的JsonArray");
      }
      localStringBuilder.append(paramEntry.getString(0));
      int i = 1;
      while (i < j)
      {
        localStringBuilder.append("##").append(paramEntry.getString(i));
        i += 1;
      }
      paramJSONObject.put(str, localStringBuilder.toString());
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private static ArrayList<JSONObject> h(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    Object localObject1 = new HashMap();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        Object localObject2 = paramJSONObject.get(str);
        if (!(localObject2 instanceof JSONArray)) {
          break label91;
        }
        ((HashMap)localObject1).put(str, (JSONArray)localObject2);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      continue;
      label91:
      localArrayList.add(localJSONException);
    }
    int i = ((HashMap)localObject1).size();
    if (i == 0) {
      return null;
    }
    localObject1 = ((HashMap)localObject1).entrySet();
    localIterator = ((Set)localObject1).iterator();
    if (i == 1) {
      return a(paramJSONObject, (Map.Entry)localIterator.next(), (String[])localArrayList.toArray(new String[0]));
    }
    return a(paramJSONObject, (Set)localObject1);
  }
  
  public String a()
  {
    return "cstm";
  }
  
  boolean b()
  {
    return this.c != null;
  }
  
  public JSONObject c()
  {
    try
    {
      if (this.c != null) {
        return this.c;
      }
      JSONObject localJSONObject = l();
      localJSONObject.put("n", this.a);
      localJSONObject.put("t", "cstm");
      localJSONObject.put("e", this.b);
      localJSONObject.put("ptm", this.d);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/collection/CustomEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */