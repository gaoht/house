package com.airbnb.lottie;

import java.util.List;
import org.json.JSONObject;

class g
  extends m<bq, bq>
{
  private g()
  {
    super(new bq());
  }
  
  g(List<at<bq>> paramList, bq parambq)
  {
    super(paramList, parambq);
  }
  
  public au<bq> createAnimation()
  {
    if (!hasAnimation()) {
      return new cd(this.b);
    }
    return new bp(this.a);
  }
  
  static final class a
  {
    static g a()
    {
      return new g(null);
    }
    
    static g a(JSONObject paramJSONObject, aw paramaw)
    {
      paramJSONObject = l.a(paramJSONObject, 1.0F, paramaw, bq.a.a).a();
      return new g(paramJSONObject.a, (bq)paramJSONObject.b);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */