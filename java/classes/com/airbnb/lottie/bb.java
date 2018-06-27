package com.airbnb.lottie;

import org.json.JSONObject;

public class bb
{
  private final String a;
  private final b b;
  
  private bb(String paramString, b paramb)
  {
    this.a = paramString;
    this.b = paramb;
  }
  
  b a()
  {
    return this.b;
  }
  
  public String getName()
  {
    return this.a;
  }
  
  public String toString()
  {
    return "MergePaths{mode=" + this.b + '}';
  }
  
  static class a
  {
    static bb a(JSONObject paramJSONObject)
    {
      return new bb(paramJSONObject.optString("nm"), bb.b.a(paramJSONObject.optInt("mm", 1)), null);
    }
  }
  
  static enum b
  {
    private b() {}
    
    private static b b(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return a;
      case 1: 
        return a;
      case 2: 
        return b;
      case 3: 
        return c;
      case 4: 
        return d;
      }
      return e;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */