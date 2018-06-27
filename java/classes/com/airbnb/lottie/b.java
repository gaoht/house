package com.airbnb.lottie;

import android.util.Log;
import java.util.List;
import org.json.JSONObject;

class b
  extends m<Float, Float>
{
  private b()
  {
    super(Float.valueOf(0.0F));
  }
  
  private b(List<at<Float>> paramList, Float paramFloat)
  {
    super(paramList, paramFloat);
  }
  
  public au<Float> createAnimation()
  {
    if (!hasAnimation()) {
      return new cd(this.b);
    }
    return new ae(this.a);
  }
  
  public Float getInitialValue()
  {
    return (Float)this.b;
  }
  
  static final class a
  {
    static b a()
    {
      return new b(null);
    }
    
    static b a(JSONObject paramJSONObject, aw paramaw)
    {
      return a(paramJSONObject, paramaw, true);
    }
    
    static b a(JSONObject paramJSONObject, aw paramaw, boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (float f = paramaw.getDpScale();; f = 1.0F)
      {
        if (paramJSONObject.has("x")) {
          Log.w("LOTTIE", "Animation has expressions which are not supported.");
        }
        paramJSONObject = l.a(paramJSONObject, f, paramaw, b.b.a).a();
        return new b(paramJSONObject.a, (Float)paramJSONObject.b, null);
      }
    }
  }
  
  private static class b
    implements k.a<Float>
  {
    static final b a = new b();
    
    public Float valueFromObject(Object paramObject, float paramFloat)
    {
      return Float.valueOf(as.a(paramObject) * paramFloat);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */