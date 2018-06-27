package com.g.a;

import org.json.JSONArray;
import org.json.JSONObject;

public class bw
  extends br
{
  public bw()
  {
    a("tid", l.a(c.e));
    try
    {
      localObject = r.x(c.e);
      JSONArray localJSONArray = new JSONArray();
      if (localObject != null)
      {
        localJSONArray.put(((JSONArray)localObject).getJSONObject(0).get("imei"));
        if (((JSONArray)localObject).length() == 2) {
          localJSONArray.put(((JSONArray)localObject).getJSONObject(1).get("imei"));
        }
      }
      a("imeis", localJSONArray);
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = new JSONArray();
    ((JSONArray)localObject).put(l.f(c.e));
    a("wifiMacs", localObject);
    a("androidId", l.b(c.e));
    a("adId", l.g(c.e));
    if (l.a() == null) {}
    for (localObject = "";; localObject = l.a())
    {
      a("serialNo", localObject);
      return;
    }
  }
  
  public void b()
  {
    a("adId", l.g(c.e));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */