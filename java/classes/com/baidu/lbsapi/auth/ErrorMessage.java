package com.baidu.lbsapi.auth;

import org.json.JSONException;
import org.json.JSONObject;

class ErrorMessage
{
  static String a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("status", -1);
      localJSONObject.put("message", paramString);
      return localJSONObject.toString();
    }
    catch (JSONException paramString)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/lbsapi/auth/ErrorMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */