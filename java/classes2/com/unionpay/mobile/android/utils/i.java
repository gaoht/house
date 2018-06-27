package com.unionpay.mobile.android.utils;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
{
  public static String a(JSONArray paramJSONArray, int paramInt)
  {
    String str2 = "";
    String str1 = str2;
    if (paramJSONArray != null)
    {
      str1 = str2;
      if (paramInt >= 0)
      {
        str1 = str2;
        if (paramInt >= paramJSONArray.length()) {}
      }
    }
    try
    {
      str1 = paramJSONArray.getString(paramInt);
      return str1;
    }
    catch (JSONException paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
    return "";
  }
  
  public static String a(JSONObject paramJSONObject, String paramString)
  {
    String str = "";
    if (f(paramJSONObject, paramString)) {}
    try
    {
      str = paramJSONObject.getString(paramString);
      return str;
    }
    catch (JSONException paramJSONObject)
    {
      j.c("uppay", i.class.toString() + " get " + paramString + " failed!!");
    }
    return "";
  }
  
  public static int b(JSONObject paramJSONObject, String paramString)
  {
    int i = 0;
    if (f(paramJSONObject, paramString)) {}
    try
    {
      i = paramJSONObject.getInt(paramString);
      return i;
    }
    catch (JSONException paramJSONObject)
    {
      j.c("uppay", i.class.toString() + " get " + paramString + " failed!!");
    }
    return 0;
  }
  
  public static Object b(JSONArray paramJSONArray, int paramInt)
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
  
  public static JSONObject c(JSONObject paramJSONObject, String paramString)
  {
    JSONObject localJSONObject = null;
    if (f(paramJSONObject, paramString)) {}
    try
    {
      localJSONObject = paramJSONObject.getJSONObject(paramString);
      return localJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      j.c("uppay", i.class.toString() + " get " + paramString + " failed!!");
    }
    return null;
  }
  
  public static JSONArray d(JSONObject paramJSONObject, String paramString)
  {
    JSONArray localJSONArray = null;
    if (f(paramJSONObject, paramString)) {}
    try
    {
      localJSONArray = paramJSONObject.getJSONArray(paramString);
      return localJSONArray;
    }
    catch (JSONException paramJSONObject)
    {
      j.c("uppay", i.class.toString() + " get " + paramString + " failed!!");
    }
    return null;
  }
  
  public static List<JSONArray> e(JSONObject paramJSONObject, String paramString)
  {
    ArrayList localArrayList = new ArrayList(1);
    paramJSONObject = d(paramJSONObject, paramString);
    int i = 0;
    while ((paramJSONObject != null) && (i < paramJSONObject.length()))
    {
      localArrayList.add((JSONArray)b(paramJSONObject, i));
      i += 1;
    }
    return localArrayList;
  }
  
  private static boolean f(JSONObject paramJSONObject, String paramString)
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/utils/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */