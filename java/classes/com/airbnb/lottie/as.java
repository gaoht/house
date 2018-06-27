package com.airbnb.lottie;

import android.graphics.PointF;
import org.json.JSONArray;
import org.json.JSONObject;

class as
{
  static float a(Object paramObject)
  {
    if ((paramObject instanceof Float)) {
      return ((Float)paramObject).floatValue();
    }
    if ((paramObject instanceof Integer)) {
      return ((Integer)paramObject).intValue();
    }
    if ((paramObject instanceof Double)) {
      return (float)((Double)paramObject).doubleValue();
    }
    if ((paramObject instanceof JSONArray)) {
      return (float)((JSONArray)paramObject).optDouble(0);
    }
    return 0.0F;
  }
  
  static PointF a(JSONArray paramJSONArray, float paramFloat)
  {
    if (paramJSONArray.length() < 2) {
      throw new IllegalArgumentException("Unable to parse point for " + paramJSONArray);
    }
    return new PointF((float)paramJSONArray.optDouble(0, 1.0D) * paramFloat, (float)paramJSONArray.optDouble(1, 1.0D) * paramFloat);
  }
  
  static PointF a(JSONObject paramJSONObject, float paramFloat)
  {
    return new PointF(a(paramJSONObject.opt("x")) * paramFloat, a(paramJSONObject.opt("y")) * paramFloat);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */