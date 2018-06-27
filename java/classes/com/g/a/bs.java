package com.g.a;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bs
  extends br
{
  public static String a = "";
  
  public bs()
  {
    a("version", "4");
    a("minorVersion", "0");
    a("build", "3");
    a("partner", "SaaS");
    a("platform", "Android");
    a("type", "TalkingData");
    a("framework", a);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = null;
    if (this.b.isNull("features")) {
      localObject1 = new JSONArray();
    }
    for (;;)
    {
      Object localObject2;
      if (localObject1 != null) {
        localObject2 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject2).put("name", paramString1);
        ((JSONObject)localObject2).put("version", paramString2);
        ((JSONObject)localObject2).put("minorVersion", paramString3);
        ((JSONArray)localObject1).put(localObject2);
        a("features", localObject1);
        return;
        try
        {
          localObject2 = this.b.getJSONArray("features");
          localObject1 = localObject2;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          av.postSDKError(paramString1);
        }
      }
    }
  }
  
  public String b()
  {
    return a;
  }
  
  public void setFrameWork(String paramString)
  {
    a = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */