package com.airbnb.lottie;

import android.graphics.PointF;
import org.json.JSONObject;

class s
{
  private final String a;
  private final k<PointF> b;
  private final f c;
  
  private s(String paramString, k<PointF> paramk, f paramf)
  {
    this.a = paramString;
    this.b = paramk;
    this.c = paramf;
  }
  
  String a()
  {
    return this.a;
  }
  
  public k<PointF> getPosition()
  {
    return this.b;
  }
  
  public f getSize()
  {
    return this.c;
  }
  
  static class a
  {
    static s a(JSONObject paramJSONObject, aw paramaw)
    {
      return new s(paramJSONObject.optString("nm"), e.a(paramJSONObject.optJSONObject("p"), paramaw), f.a.a(paramJSONObject.optJSONObject("s"), paramaw), null);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */