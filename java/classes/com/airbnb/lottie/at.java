package com.airbnb.lottie;

import android.graphics.PointF;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class at<T>
{
  private static final Interpolator f = new LinearInterpolator();
  final T a;
  final T b;
  final Interpolator c;
  final float d;
  Float e;
  private final aw g;
  
  public at(aw paramaw, T paramT1, T paramT2, Interpolator paramInterpolator, float paramFloat, Float paramFloat1)
  {
    this.g = paramaw;
    this.a = paramT1;
    this.b = paramT2;
    this.c = paramInterpolator;
    this.d = paramFloat;
    this.e = paramFloat1;
  }
  
  static void a(List<? extends at<?>> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j - 1)
    {
      ((at)paramList.get(i)).e = Float.valueOf(((at)paramList.get(i + 1)).d);
      i += 1;
    }
    at localat = (at)paramList.get(j - 1);
    if (localat.a == null) {
      paramList.remove(localat);
    }
  }
  
  float a()
  {
    return this.d / this.g.d();
  }
  
  boolean a(float paramFloat)
  {
    return (paramFloat >= a()) && (paramFloat <= b());
  }
  
  float b()
  {
    if (this.e == null) {
      return 1.0F;
    }
    return this.e.floatValue() / this.g.d();
  }
  
  boolean c()
  {
    return this.c == null;
  }
  
  public String toString()
  {
    return "Keyframe{startValue=" + this.a + ", endValue=" + this.b + ", startFrame=" + this.d + ", endFrame=" + this.e + ", interpolator=" + this.c + '}';
  }
  
  static class a
  {
    static <T> at<T> a(JSONObject paramJSONObject, aw paramaw, float paramFloat, k.a<T> parama)
    {
      int i = 1;
      float f = 0.0F;
      if (paramJSONObject.has("t"))
      {
        f = (float)paramJSONObject.optDouble("t", 0.0D);
        localObject1 = paramJSONObject.opt("s");
        if (localObject1 == null) {
          break label308;
        }
      }
      label137:
      label161:
      label308:
      for (Object localObject1 = parama.valueFromObject(localObject1, paramFloat);; localObject1 = null)
      {
        Object localObject2 = paramJSONObject.opt("e");
        if (localObject2 != null) {}
        for (parama = parama.valueFromObject(localObject2, paramFloat);; parama = null)
        {
          Object localObject3 = paramJSONObject.optJSONObject("o");
          localObject2 = paramJSONObject.optJSONObject("i");
          if ((localObject3 != null) && (localObject2 != null))
          {
            localObject3 = as.a((JSONObject)localObject3, paramFloat);
            localObject2 = as.a((JSONObject)localObject2, paramFloat);
          }
          for (;;)
          {
            if (paramJSONObject.optInt("h", 0) == 1)
            {
              if (i == 0) {
                break label161;
              }
              paramJSONObject = at.d();
              parama = (k.a<T>)localObject1;
            }
            for (paramFloat = f;; paramFloat = f)
            {
              return new at(paramaw, localObject1, parama, paramJSONObject, paramFloat, null);
              i = 0;
              break;
              if (localObject3 != null)
              {
                ((PointF)localObject3).x = bd.b(((PointF)localObject3).x, -paramFloat, paramFloat);
                ((PointF)localObject3).y = bd.b(((PointF)localObject3).y, -100.0F, 100.0F);
                ((PointF)localObject2).x = bd.b(((PointF)localObject2).x, -paramFloat, paramFloat);
                ((PointF)localObject2).y = bd.b(((PointF)localObject2).y, -100.0F, 100.0F);
                paramJSONObject = PathInterpolatorCompat.create(((PointF)localObject3).x / paramFloat, ((PointF)localObject3).y / paramFloat, ((PointF)localObject2).x / paramFloat, ((PointF)localObject2).y / paramFloat);
                break label137;
              }
              paramJSONObject = at.d();
              break label137;
              parama = parama.valueFromObject(paramJSONObject, paramFloat);
              paramJSONObject = null;
              localObject1 = parama;
            }
            localObject2 = null;
            localObject3 = null;
          }
        }
      }
    }
    
    static <T> List<at<T>> a(JSONArray paramJSONArray, aw paramaw, float paramFloat, k.a<T> parama)
    {
      int j = paramJSONArray.length();
      if (j == 0) {
        return Collections.emptyList();
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(a(paramJSONArray.optJSONObject(i), paramaw, paramFloat, parama));
        i += 1;
      }
      at.a(localArrayList);
      return localArrayList;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */