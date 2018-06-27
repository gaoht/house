package com.airbnb.lottie;

import android.graphics.PointF;
import java.util.List;
import org.json.JSONObject;

class f
  extends m<PointF, PointF>
{
  private f(List<at<PointF>> paramList, PointF paramPointF)
  {
    super(paramList, paramPointF);
  }
  
  public au<PointF> createAnimation()
  {
    if (!hasAnimation()) {
      return new cd(this.b);
    }
    return new bk(this.a);
  }
  
  static final class a
  {
    static f a(JSONObject paramJSONObject, aw paramaw)
    {
      paramJSONObject = l.a(paramJSONObject, paramaw.getDpScale(), paramaw, bj.a).a();
      return new f(paramJSONObject.a, (PointF)paramJSONObject.b, null);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */