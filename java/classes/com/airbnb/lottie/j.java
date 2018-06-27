package com.airbnb.lottie;

import android.graphics.PointF;
import android.util.Log;
import java.util.Collections;
import org.json.JSONObject;

class j
{
  private final e a;
  private final k<PointF> b;
  private final g c;
  private final b d;
  private final d e;
  
  private j(e parame, k<PointF> paramk, g paramg, b paramb, d paramd)
  {
    this.a = parame;
    this.b = paramk;
    this.c = paramg;
    this.d = paramb;
    this.e = paramd;
  }
  
  e a()
  {
    return this.a;
  }
  
  k<PointF> b()
  {
    return this.b;
  }
  
  g c()
  {
    return this.c;
  }
  
  public cf createAnimation()
  {
    return new cf(this);
  }
  
  b d()
  {
    return this.d;
  }
  
  d e()
  {
    return this.e;
  }
  
  static class a
  {
    static j a()
    {
      return new j(new e(), new e(), g.a.a(), b.a.a(), d.a.a(), null);
    }
    
    static j a(JSONObject paramJSONObject, aw paramaw)
    {
      Object localObject1 = paramJSONObject.optJSONObject("a");
      Object localObject2;
      label43:
      Object localObject3;
      label64:
      Object localObject4;
      if (localObject1 != null)
      {
        localObject1 = new e(((JSONObject)localObject1).opt("k"), paramaw);
        localObject2 = paramJSONObject.optJSONObject("p");
        if (localObject2 == null) {
          break label155;
        }
        localObject2 = e.a((JSONObject)localObject2, paramaw);
        localObject3 = paramJSONObject.optJSONObject("s");
        if (localObject3 == null) {
          break label165;
        }
        localObject3 = g.a.a((JSONObject)localObject3, paramaw);
        JSONObject localJSONObject = paramJSONObject.optJSONObject("r");
        localObject4 = localJSONObject;
        if (localJSONObject == null) {
          localObject4 = paramJSONObject.optJSONObject("rz");
        }
        if (localObject4 == null) {
          break label187;
        }
        localObject4 = b.a.a((JSONObject)localObject4, paramaw, false);
        label103:
        paramJSONObject = paramJSONObject.optJSONObject("o");
        if (paramJSONObject == null) {
          break label198;
        }
      }
      label155:
      label165:
      label187:
      label198:
      for (paramJSONObject = d.a.a(paramJSONObject, paramaw);; paramJSONObject = new d(Collections.emptyList(), Integer.valueOf(100)))
      {
        return new j((e)localObject1, (k)localObject2, (g)localObject3, (b)localObject4, paramJSONObject, null);
        Log.w("LOTTIE", "Layer has no transform property. You may be using an unsupported layer type such as a camera.");
        localObject1 = new e();
        break;
        a("position");
        localObject2 = null;
        break label43;
        localObject3 = new g(Collections.emptyList(), new bq());
        break label64;
        a("rotation");
        localObject4 = null;
        break label103;
      }
    }
    
    private static void a(String paramString)
    {
      throw new IllegalArgumentException("Missing transform for " + paramString);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */