package com.airbnb.lottie;

import android.util.Log;
import java.util.List;
import org.json.JSONObject;

class d
  extends m<Integer, Integer>
{
  private d()
  {
    super(Integer.valueOf(100));
  }
  
  d(List<at<Integer>> paramList, Integer paramInteger)
  {
    super(paramList, paramInteger);
  }
  
  public au<Integer> createAnimation()
  {
    if (!hasAnimation()) {
      return new cd(this.b);
    }
    return new aq(this.a);
  }
  
  public Integer getInitialValue()
  {
    return (Integer)this.b;
  }
  
  static final class a
  {
    static d a()
    {
      return new d(null);
    }
    
    static d a(JSONObject paramJSONObject, aw paramaw)
    {
      if (paramJSONObject.has("x")) {
        Log.w("LOTTIE", "Animation has expressions which are not supported.");
      }
      paramJSONObject = l.a(paramJSONObject, 1.0F, paramaw, d.b.a()).a();
      paramaw = (Integer)paramJSONObject.b;
      return new d(paramJSONObject.a, paramaw);
    }
  }
  
  private static class b
    implements k.a<Integer>
  {
    private static final b a = new b();
    
    public Integer valueFromObject(Object paramObject, float paramFloat)
    {
      return Integer.valueOf(Math.round(as.a(paramObject) * paramFloat));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */