package com.ziroom.ziroomcustomer.ziroomstation.utils;

import android.text.TextUtils;
import com.alibaba.fastjson.a;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class h
{
  public static String getJsonString(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = getJsonString(new JSONObject(paramString1), paramString2);
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static String getJsonString(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString(paramString);
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
  
  public static String getOrderNum(JSONObject paramJSONObject, String paramString)
  {
    Object localObject2 = Integer.valueOf(0);
    localObject1 = localObject2;
    try
    {
      paramString = paramJSONObject.getString(paramString);
      localObject1 = localObject2;
      boolean bool = TextUtils.isEmpty(paramString);
      localObject1 = localObject2;
      if (!bool)
      {
        paramJSONObject = (JSONObject)localObject2;
        localObject1 = localObject2;
        try
        {
          paramString = Integer.valueOf(paramString);
          localObject2 = paramString;
          paramJSONObject = paramString;
          localObject1 = paramString;
          if (paramString.intValue() > 99) {
            localObject2 = Integer.valueOf(99);
          }
          paramString = (String)localObject2;
        }
        catch (NumberFormatException paramString)
        {
          for (;;)
          {
            try
            {
              return String.valueOf(paramString);
            }
            catch (JSONException paramString)
            {
              localObject1 = paramJSONObject;
              paramJSONObject = paramString;
              continue;
            }
            paramString = paramString;
            paramString.printStackTrace();
            paramString = Integer.valueOf(0);
          }
        }
        paramJSONObject = paramString;
        paramJSONObject.printStackTrace();
      }
    }
    catch (JSONException paramJSONObject) {}
    return String.valueOf(localObject1);
  }
  
  public static <T> List<T> parseArray(String paramString, Class<T> paramClass)
  {
    try
    {
      paramString = a.parseArray(paramString, paramClass);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static <T> Object parseObject(String paramString, Class<T> paramClass)
  {
    try
    {
      paramString = a.parseObject(paramString, paramClass);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/utils/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */