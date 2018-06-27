package com.airbnb.lottie;

import android.graphics.PointF;
import org.json.JSONArray;
import org.json.JSONObject;

class bj
  implements k.a<PointF>
{
  static final bj a = new bj();
  
  public PointF valueFromObject(Object paramObject, float paramFloat)
  {
    if ((paramObject instanceof JSONArray)) {
      return as.a((JSONArray)paramObject, paramFloat);
    }
    if ((paramObject instanceof JSONObject)) {
      return as.a((JSONObject)paramObject, paramFloat);
    }
    throw new IllegalArgumentException("Unable to parse point from " + paramObject);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */