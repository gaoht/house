package com.g.a;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class br
{
  protected JSONObject b = new JSONObject();
  
  protected void a(String paramString, Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return;
      try
      {
        if (!a(paramObject))
        {
          this.b.put(paramString, paramObject);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  protected boolean a(Object paramObject)
  {
    if ((paramObject instanceof JSONObject))
    {
      if (((JSONObject)paramObject).length() > 0) {}
    }
    else {
      while (((paramObject instanceof JSONArray)) && (((JSONArray)paramObject).length() <= 0)) {
        return true;
      }
    }
    return false;
  }
  
  public Object a_()
  {
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */