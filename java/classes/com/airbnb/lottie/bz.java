package com.airbnb.lottie;

import org.json.JSONObject;

class bz
{
  private final String a;
  private final b b;
  private final b c;
  private final b d;
  private final b e;
  
  private bz(String paramString, b paramb, b paramb1, b paramb2, b paramb3)
  {
    this.a = paramString;
    this.b = paramb;
    this.c = paramb1;
    this.d = paramb2;
    this.e = paramb3;
  }
  
  String a()
  {
    return this.a;
  }
  
  b b()
  {
    return this.b;
  }
  
  b c()
  {
    return this.d;
  }
  
  b d()
  {
    return this.c;
  }
  
  b e()
  {
    return this.e;
  }
  
  public String toString()
  {
    return "Trim Path: {start: " + this.c + ", end: " + this.d + ", offset: " + this.e + "}";
  }
  
  static class a
  {
    static bz a(JSONObject paramJSONObject, aw paramaw)
    {
      return new bz(paramJSONObject.optString("nm"), bz.b.a(paramJSONObject.optInt("m", 1)), b.a.a(paramJSONObject.optJSONObject("s"), paramaw, false), b.a.a(paramJSONObject.optJSONObject("e"), paramaw, false), b.a.a(paramJSONObject.optJSONObject("o"), paramaw, false), null);
    }
  }
  
  static enum b
  {
    private b() {}
    
    static b a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("Unknown trim path type " + paramInt);
      case 1: 
        return a;
      }
      return b;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */