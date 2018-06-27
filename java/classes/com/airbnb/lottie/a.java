package com.airbnb.lottie;

import java.util.List;
import org.json.JSONObject;

class a
  extends m<Integer, Integer>
{
  private a(List<at<Integer>> paramList, Integer paramInteger)
  {
    super(paramList, paramInteger);
  }
  
  public au<Integer> createAnimation()
  {
    if (!hasAnimation()) {
      return new cd(this.b);
    }
    return new u(this.a);
  }
  
  public String toString()
  {
    return "AnimatableColorValue{initialValue=" + this.b + '}';
  }
  
  static final class a
  {
    static a a(JSONObject paramJSONObject, aw paramaw)
    {
      paramJSONObject = l.a(paramJSONObject, 1.0F, paramaw, t.a).a();
      return new a(paramJSONObject.a, (Integer)paramJSONObject.b, null);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */