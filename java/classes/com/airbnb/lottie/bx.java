package com.airbnb.lottie;

import org.json.JSONObject;

class bx
{
  private final String a;
  private final int b;
  private final h c;
  
  private bx(String paramString, int paramInt, h paramh)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramh;
  }
  
  h a()
  {
    return this.c;
  }
  
  public String getName()
  {
    return this.a;
  }
  
  public String toString()
  {
    return "ShapePath{name=" + this.a + ", index=" + this.b + ", hasAnimation=" + this.c.hasAnimation() + '}';
  }
  
  static class a
  {
    static bx a(JSONObject paramJSONObject, aw paramaw)
    {
      paramaw = h.a.a(paramJSONObject.optJSONObject("ks"), paramaw);
      return new bx(paramJSONObject.optString("nm"), paramJSONObject.optInt("ind"), paramaw, null);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */