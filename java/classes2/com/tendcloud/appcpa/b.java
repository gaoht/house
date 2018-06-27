package com.tendcloud.appcpa;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends JSONArray
{
  JSONArray a = null;
  
  public static b createShoppingCart()
  {
    return new b();
  }
  
  public b addItem(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", paramString1);
      localJSONObject.put("name", paramString3);
      localJSONObject.put("category", paramString2);
      localJSONObject.put("unitPrice", paramInt1);
      localJSONObject.put("count", paramInt2);
      put(localJSONObject);
      return this;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
    finally {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tendcloud/appcpa/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */