package com.airbnb.lottie;

import android.graphics.Color;
import org.json.JSONArray;

class t
  implements k.a<Integer>
{
  static final t a = new t();
  
  public Integer valueFromObject(Object paramObject, float paramFloat)
  {
    paramObject = (JSONArray)paramObject;
    if (((JSONArray)paramObject).length() == 4)
    {
      int i = 0;
      int j = 1;
      while (i < ((JSONArray)paramObject).length())
      {
        if (((JSONArray)paramObject).optDouble(i) > 1.0D) {
          j = 0;
        }
        i += 1;
      }
      if (j != 0) {}
      for (paramFloat = 255.0F;; paramFloat = 1.0F) {
        return Integer.valueOf(Color.argb((int)(((JSONArray)paramObject).optDouble(3) * paramFloat), (int)(((JSONArray)paramObject).optDouble(0) * paramFloat), (int)(((JSONArray)paramObject).optDouble(1) * paramFloat), (int)(((JSONArray)paramObject).optDouble(2) * paramFloat)));
      }
    }
    return Integer.valueOf(-16777216);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */