package com.airbnb.lottie;

import android.graphics.Color;
import android.util.Log;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class c
  extends m<ag, ag>
{
  private c(List<at<ag>> paramList, ag paramag)
  {
    super(paramList, paramag);
  }
  
  public au<ag> createAnimation()
  {
    if (!hasAnimation()) {
      return new cd(this.b);
    }
    return new ah(this.a);
  }
  
  static final class a
  {
    static c a(JSONObject paramJSONObject, aw paramaw)
    {
      paramJSONObject = l.a(paramJSONObject, 1.0F, paramaw, new c.b(paramJSONObject.optInt("p"), null)).a();
      paramaw = (ag)paramJSONObject.b;
      return new c(paramJSONObject.a, paramaw, null);
    }
  }
  
  private static class b
    implements k.a<ag>
  {
    private final int a;
    
    private b(int paramInt)
    {
      this.a = paramInt;
    }
    
    private int a(double paramDouble, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
    {
      int i = 1;
      while (i < paramArrayOfDouble1.length)
      {
        double d1 = paramArrayOfDouble1[(i - 1)];
        double d2 = paramArrayOfDouble1[i];
        if (paramArrayOfDouble1[i] >= paramDouble)
        {
          paramDouble = (paramDouble - d1) / (d2 - d1);
          return (int)(bd.a(paramArrayOfDouble2[(i - 1)], paramArrayOfDouble2[i], paramDouble) * 255.0D);
        }
        i += 1;
      }
      return (int)(paramArrayOfDouble2[(paramArrayOfDouble2.length - 1)] * 255.0D);
    }
    
    private void a(ag paramag, JSONArray paramJSONArray)
    {
      int m = 0;
      int i = this.a * 4;
      if (paramJSONArray.length() <= i) {}
      for (;;)
      {
        return;
        int j = (paramJSONArray.length() - i) / 2;
        double[] arrayOfDouble1 = new double[j];
        double[] arrayOfDouble2 = new double[j];
        int k = 0;
        j = m;
        if (i < paramJSONArray.length())
        {
          if (i % 2 == 0) {
            arrayOfDouble1[k] = paramJSONArray.optDouble(i);
          }
          for (;;)
          {
            i += 1;
            break;
            arrayOfDouble2[k] = paramJSONArray.optDouble(i);
            k += 1;
          }
        }
        while (j < paramag.c())
        {
          i = paramag.b()[j];
          i = Color.argb(a(paramag.a()[j], arrayOfDouble1, arrayOfDouble2), Color.red(i), Color.green(i), Color.blue(i));
          paramag.b()[j] = i;
          j += 1;
        }
      }
    }
    
    public ag valueFromObject(Object paramObject, float paramFloat)
    {
      int i = 0;
      paramObject = (JSONArray)paramObject;
      float[] arrayOfFloat = new float[this.a];
      int[] arrayOfInt = new int[this.a];
      ag localag = new ag(arrayOfFloat, arrayOfInt);
      if (((JSONArray)paramObject).length() != this.a * 4) {
        Log.w("LOTTIE", "Unexpected gradient length: " + ((JSONArray)paramObject).length() + ". Expected " + this.a * 4 + ". This may affect the appearance of the gradient. " + "Make sure to save your After Effects file before exporting an animation with " + "gradients.");
      }
      int k = 0;
      int j = 0;
      if (i < this.a * 4)
      {
        int m = i / 4;
        double d = ((JSONArray)paramObject).optDouble(i);
        switch (i % 4)
        {
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfFloat[m] = ((float)d);
          continue;
          j = (int)(d * 255.0D);
          continue;
          k = (int)(d * 255.0D);
          continue;
          arrayOfInt[m] = Color.argb(255, j, k, (int)(d * 255.0D));
        }
      }
      a(localag, (JSONArray)paramObject);
      return localag;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */