package com.unionpay.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  public static Object a(JSONArray paramJSONArray, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramJSONArray != null)
    {
      localObject1 = localObject2;
      if (paramInt < paramJSONArray.length())
      {
        localObject1 = localObject2;
        if (paramInt < 0) {}
      }
    }
    try
    {
      localObject1 = paramJSONArray.get(paramInt);
      return localObject1;
    }
    catch (JSONException paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
    return null;
  }
  
  public static String a(JSONObject paramJSONObject, String paramString)
  {
    String str = "";
    if (d(paramJSONObject, paramString)) {}
    try
    {
      str = paramJSONObject.getString(paramString);
      return str;
    }
    catch (JSONException paramJSONObject)
    {
      g.b("uppay", f.class.toString() + " get " + paramString + " failed!!");
    }
    return "";
  }
  
  public static boolean b(JSONObject paramJSONObject, String paramString)
  {
    boolean bool = false;
    if (d(paramJSONObject, paramString)) {}
    try
    {
      bool = paramJSONObject.getBoolean(paramString);
      return bool;
    }
    catch (JSONException paramJSONObject)
    {
      g.b("uppay", f.class.toString() + " get " + paramString + " failed!!");
    }
    return false;
  }
  
  public static JSONArray c(JSONObject paramJSONObject, String paramString)
  {
    JSONArray localJSONArray = null;
    if (d(paramJSONObject, paramString)) {}
    try
    {
      localJSONArray = paramJSONObject.getJSONArray(paramString);
      return localJSONArray;
    }
    catch (JSONException paramJSONObject)
    {
      g.b("uppay", f.class.toString() + " get " + paramString + " failed!!");
    }
    return null;
  }
  
  private static boolean d(JSONObject paramJSONObject, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramJSONObject != null)
    {
      bool1 = bool2;
      if (paramJSONObject.has(paramString)) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/utils/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */