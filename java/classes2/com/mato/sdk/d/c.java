package com.mato.sdk.d;

import android.util.Base64;
import com.mato.sdk.c.b.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class c
{
  public static String a(String paramString)
  {
    try
    {
      paramString = new String(Base64.decode(paramString, 0));
      return paramString;
    }
    catch (Throwable paramString)
    {
      f.b().a(paramString);
    }
    return null;
  }
  
  public static String a(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    paramString = paramJSONObject.optString(paramString, null);
    paramJSONObject = paramString;
    if (paramString != null)
    {
      paramJSONObject = paramString;
      if (paramString.length() != 0)
      {
        paramString = a(paramString);
        paramJSONObject = paramString;
        if (paramString == null) {
          paramJSONObject = paramString;
        }
      }
    }
    return paramJSONObject;
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
  
  public static boolean b(JSONArray paramJSONArray)
  {
    return (paramJSONArray != null) && (paramJSONArray.length() > 0);
  }
  
  public abstract boolean a(JSONObject paramJSONObject);
  
  public JSONObject w()
    throws JSONException
  {
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */