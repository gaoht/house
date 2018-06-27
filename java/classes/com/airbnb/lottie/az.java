package com.airbnb.lottie;

import org.json.JSONObject;

class az
{
  private final b a;
  private final h b;
  
  private az(b paramb, h paramh)
  {
    this.a = paramb;
    this.b = paramh;
  }
  
  b a()
  {
    return this.a;
  }
  
  h b()
  {
    return this.b;
  }
  
  static class a
  {
    static az a(JSONObject paramJSONObject, aw paramaw)
    {
      Object localObject = paramJSONObject.optString("mode");
      int i = -1;
      switch (((String)localObject).hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          localObject = az.b.d;
        }
        break;
      }
      for (;;)
      {
        return new az((az.b)localObject, h.a.a(paramJSONObject.optJSONObject("pt"), paramaw), null);
        if (!((String)localObject).equals("a")) {
          break;
        }
        i = 0;
        break;
        if (!((String)localObject).equals("s")) {
          break;
        }
        i = 1;
        break;
        if (!((String)localObject).equals("i")) {
          break;
        }
        i = 2;
        break;
        localObject = az.b.a;
        continue;
        localObject = az.b.b;
        continue;
        localObject = az.b.c;
      }
    }
  }
  
  static enum b
  {
    private b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */