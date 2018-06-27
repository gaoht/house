package cn.testin.analysis;

import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aq
{
  public static j a(String paramString, Class<? extends j> paramClass)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramClass = (j)paramClass.newInstance();
        Object localObject = new JSONObject(paramString);
        if ((paramClass instanceof k))
        {
          paramClass = (k)paramClass;
          paramClass.a = ((JSONObject)localObject).optInt("errNo");
          paramClass.b = ((JSONObject)localObject).optString("message");
          paramString = paramClass;
          if (!((JSONObject)localObject).has("data")) {
            continue;
          }
          paramString = paramClass;
          if (TextUtils.isEmpty(((JSONObject)localObject).optString("data"))) {
            continue;
          }
          localObject = ((JSONObject)localObject).getJSONObject("data");
          paramClass.c = new l();
          paramClass.c.a = ((JSONObject)localObject).optInt("granularityInterval", 60);
          paramClass.c.b = ((JSONObject)localObject).optInt("maxGranularityNum", 10);
          paramClass.c.c = ((JSONObject)localObject).optInt("downIntervals", -1);
          paramClass.c.d = ((JSONObject)localObject).optInt("downTimes", -1);
          paramClass.c.e = ((JSONObject)localObject).optInt("upIntervals", -1);
          paramClass.c.f = ((JSONObject)localObject).optInt("upTimes", -1);
          paramClass.c.g = ((JSONObject)localObject).optString("clientId", null);
          paramClass.c.i = ((JSONObject)localObject).optString("variants");
          paramClass.c.j = ((JSONObject)localObject).optString("md5");
          paramString = paramClass;
          if (!((JSONObject)localObject).has("exps")) {
            continue;
          }
          paramClass.c.h = new ArrayList();
          localObject = ((JSONObject)localObject).getJSONArray("exps");
          int i = 0;
          for (;;)
          {
            paramString = paramClass;
            if (i >= ((JSONArray)localObject).length()) {
              break;
            }
            paramString = ((JSONArray)localObject).getJSONObject(i);
            m localm = new m();
            localm.a = paramString.optString("layerId", null);
            localm.b = paramString.optString("layerName", null);
            localm.c = paramString.optString("componentsKey", null);
            localm.d = paramString.optString("expVersionName", null);
            localm.e = paramString.optInt("isUpload");
            localm.f = paramString.optLong("expiredTime");
            localm.g = paramString.optString("expId", null);
            localm.j = paramString.optString("expName", null);
            if (paramString.has("events"))
            {
              JSONArray localJSONArray = paramString.getJSONArray("events");
              localm.i = new String[localJSONArray.length()];
              int j = 0;
              while (j < localJSONArray.length())
              {
                localm.i[j] = ((String)localJSONArray.get(j));
                j += 1;
              }
            }
            if (paramString.has("componentsValues")) {
              localm.h = a(paramString.getJSONObject("componentsValues"));
            }
            paramClass.c.h.add(localm);
            i += 1;
          }
        }
        if (((JSONObject)localObject).has("errNo")) {
          paramClass.a = ((JSONObject)localObject).getInt("errNo");
        }
        paramString = paramClass;
        if (!((JSONObject)localObject).has("message")) {
          continue;
        }
        paramClass.b = ((JSONObject)localObject).getString("message");
        return paramClass;
      }
      catch (IllegalAccessException paramString)
      {
        ar.a(paramString);
        return null;
      }
      catch (InstantiationException paramString)
      {
        for (;;)
        {
          ar.a(paramString);
        }
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          ar.a(paramString);
        }
      }
    }
  }
  
  public static String a(HashMap<String, i> paramHashMap)
  {
    if ((paramHashMap == null) || (paramHashMap.isEmpty())) {
      return null;
    }
    JSONObject localJSONObject1 = new JSONObject();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      try
      {
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (i)((Map.Entry)localObject).getValue();
        if ((localObject != null) && (((i)localObject).b != null))
        {
          JSONObject localJSONObject2 = new JSONObject();
          Pair localPair = ((i)localObject).b;
          localJSONObject2.put("value", ((i)localObject).a);
          localJSONObject2.put("versionId", localPair.first);
          localJSONObject2.put("expId", localPair.second);
          localJSONObject1.put(str, localJSONObject2);
        }
      }
      catch (JSONException localJSONException)
      {
        ar.a(localJSONException);
      }
    }
    if (localJSONObject1.length() > 0) {
      return localJSONObject1.toString();
    }
    return null;
  }
  
  public static String a(List<Pair<String, String>> paramList)
  {
    if (paramList == null) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Pair localPair = (Pair)paramList.next();
      if (localPair != null) {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("versionId", localPair.first);
          localJSONObject.put("expId", localPair.second);
          localJSONArray.put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          ar.a(localJSONException);
        }
      }
    }
    return localJSONArray.toString();
  }
  
  public static String a(Map<String, Object> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {}
    do
    {
      return null;
      paramMap = b(paramMap);
    } while (paramMap == null);
    return paramMap.toString();
  }
  
  public static String a(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject.has(paramString)) && (!paramJSONObject.isNull(paramString))) {
      return paramJSONObject.getString(paramString);
    }
    return null;
  }
  
  public static HashMap<String, i> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = paramString.optJSONObject(str);
        if (localJSONObject != null) {
          localHashMap.put(str, new i(localJSONObject.opt("value"), av.a(localJSONObject.optString("expId"), localJSONObject.optString("versionId"))));
        }
      }
      return localHashMap;
    }
    catch (JSONException paramString)
    {
      ar.a(paramString);
      return null;
    }
  }
  
  public static Map<String, Object> a(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONObject != null)
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramJSONObject.opt(str));
      }
    }
    return localHashMap;
  }
  
  public static Map<String, Object> b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = a(new JSONObject(paramString));
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static JSONObject b(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      try
      {
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return localJSONObject;
  }
  
  public static String c(Map<Pair<String, String>, Long> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      try
      {
        Pair localPair = (Pair)localEntry.getKey();
        JSONObject localJSONObject = new JSONObject();
        long l = ((Long)localEntry.getValue()).longValue();
        localJSONObject.put("versionId", localPair.first);
        localJSONObject.put("expId", localPair.second);
        localJSONObject.put("timestamp", l);
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        ar.a(localJSONException);
      }
    }
    if (localJSONArray.length() > 0) {
      return localJSONArray.toString();
    }
    return null;
  }
  
  public static HashMap<Pair<String, String>, Long> c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONArray(paramString);
      HashMap localHashMap = new HashMap();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.optJSONObject(i);
        if (localJSONObject != null) {
          localHashMap.put(av.a(localJSONObject.optString("expId"), localJSONObject.optString("versionId")), Long.valueOf(localJSONObject.optLong("timestamp")));
        }
        i += 1;
      }
      return localHashMap;
    }
    catch (JSONException paramString)
    {
      ar.a(paramString);
    }
    return null;
  }
  
  public static List<Pair<String, String>> d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        Object localObject = paramString.optJSONObject(i);
        if (localObject != null)
        {
          String str = ((JSONObject)localObject).optString("versionId");
          localObject = ((JSONObject)localObject).optString("expId");
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
            localArrayList.add(av.a((String)localObject, str));
          }
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      ar.a(paramString);
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */