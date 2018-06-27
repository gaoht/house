package com.g.a;

import android.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ca
  extends br
{
  public static al a;
  public static String c = UUID.randomUUID().toString();
  
  public ca(cc paramcc)
  {
    switch (cb.a[paramcc.ordinal()])
    {
    default: 
      return;
    case 1: 
      a("type", cc.a.a());
      a("available", Boolean.valueOf(r.e(c.e)));
      al localal;
      if (r.g(c.e))
      {
        a("connected", Boolean.valueOf(true));
        a("current", r.v(c.e));
        paramcc = r.w(c.e);
        localal = a(paramcc);
        if (a == null)
        {
          a("scannable", paramcc);
          a = localal;
          a("configured", r.u(c.e));
          a("ip", r.b(c.e));
        }
      }
      for (;;)
      {
        if (r.a()) {
          a("proxy", Proxy.getDefaultHost() + ":" + Proxy.getDefaultPort());
        }
        a("scannableFingerId", c);
        return;
        if (new am().a(a, localal) > 0.8D)
        {
          a("scannable", null);
          break;
        }
        a("scannable", paramcc);
        a = localal;
        c = UUID.randomUUID().toString();
        break;
        a("connected", Boolean.valueOf(false));
      }
    case 2: 
      try
      {
        a("type", cc.b.a());
        a("available", Boolean.valueOf(r.f(c.e)));
        a("connected", Boolean.valueOf(r.h(c.e)));
        if (r.c(c.e)) {
          a("current", r.s(c.e));
        }
        if (r.a()) {
          a("proxy", Proxy.getDefaultHost() + ":" + Proxy.getDefaultPort());
        }
        a("scannable", r.t(c.e));
        return;
      }
      catch (Throwable paramcc)
      {
        return;
      }
    }
    try
    {
      a("type", cc.c.a());
      return;
    }
    catch (Throwable paramcc) {}
  }
  
  private static al a(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      for (;;)
      {
        if (i < paramJSONArray.length()) {}
        try
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          localArrayList.add(new aj(localJSONObject.getString("name"), localJSONObject.getString("id"), (byte)localJSONObject.getInt("level"), (byte)0, (byte)0));
          i += 1;
          continue;
          paramJSONArray = new al();
          paramJSONArray.setBsslist(localArrayList);
          return paramJSONArray;
        }
        catch (JSONException localJSONException)
        {
          for (;;) {}
        }
      }
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */