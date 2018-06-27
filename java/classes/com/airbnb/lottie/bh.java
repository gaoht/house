package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import org.json.JSONArray;
import org.json.JSONObject;

class bh
  extends at<PointF>
{
  private Path f;
  
  private bh(aw paramaw, PointF paramPointF1, PointF paramPointF2, Interpolator paramInterpolator, float paramFloat, Float paramFloat1)
  {
    super(paramaw, paramPointF1, paramPointF2, paramInterpolator, paramFloat, paramFloat1);
  }
  
  Path e()
  {
    return this.f;
  }
  
  static class a
  {
    static bh a(JSONObject paramJSONObject, aw paramaw, k.a<PointF> parama)
    {
      at localat = at.a.a(paramJSONObject, paramaw, paramaw.getDpScale(), parama);
      JSONArray localJSONArray = paramJSONObject.optJSONArray("ti");
      paramJSONObject = paramJSONObject.optJSONArray("to");
      if ((localJSONArray != null) && (paramJSONObject != null))
      {
        parama = as.a(paramJSONObject, paramaw.getDpScale());
        paramJSONObject = as.a(localJSONArray, paramaw.getDpScale());
      }
      for (;;)
      {
        paramaw = new bh(paramaw, (PointF)localat.a, (PointF)localat.b, localat.c, localat.d, localat.e, null);
        if ((localat.b != null) && (localat.a != null) && (((PointF)localat.a).equals(((PointF)localat.b).x, ((PointF)localat.b).y))) {}
        for (int i = 1;; i = 0)
        {
          if ((paramaw.b != null) && (i == 0)) {
            bh.a(paramaw, ch.a((PointF)localat.a, (PointF)localat.b, parama, paramJSONObject));
          }
          return paramaw;
        }
        paramJSONObject = null;
        parama = null;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */