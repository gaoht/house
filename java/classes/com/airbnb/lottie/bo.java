package com.airbnb.lottie;

import android.graphics.PointF;
import org.json.JSONObject;

class bo
{
  private final String a;
  private final k<PointF> b;
  private final f c;
  private final b d;
  
  private bo(String paramString, k<PointF> paramk, f paramf, b paramb)
  {
    this.a = paramString;
    this.b = paramk;
    this.c = paramf;
    this.d = paramb;
  }
  
  String a()
  {
    return this.a;
  }
  
  b b()
  {
    return this.d;
  }
  
  f c()
  {
    return this.c;
  }
  
  k<PointF> d()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "RectangleShape{cornerRadius=" + this.d.getInitialValue() + ", position=" + this.b + ", size=" + this.c + '}';
  }
  
  static class a
  {
    static bo a(JSONObject paramJSONObject, aw paramaw)
    {
      return new bo(paramJSONObject.optString("nm"), e.a(paramJSONObject.optJSONObject("p"), paramaw), f.a.a(paramJSONObject.optJSONObject("s"), paramaw), b.a.a(paramJSONObject.optJSONObject("r"), paramaw), null);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */