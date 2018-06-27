package com.airbnb.lottie;

import org.json.JSONObject;

public class ay
{
  private final int a;
  private final int b;
  private final String c;
  private final String d;
  
  private ay(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString1;
    this.d = paramString2;
  }
  
  public String getFileName()
  {
    return this.d;
  }
  
  public int getHeight()
  {
    return this.b;
  }
  
  public String getId()
  {
    return this.c;
  }
  
  public int getWidth()
  {
    return this.a;
  }
  
  static class a
  {
    static ay a(JSONObject paramJSONObject)
    {
      return new ay(paramJSONObject.optInt("w"), paramJSONObject.optInt("h"), paramJSONObject.optString("id"), paramJSONObject.optString("p"), null);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */