package com.airbnb.lottie;

import android.graphics.Path.FillType;
import org.json.JSONException;
import org.json.JSONObject;

class ai
{
  private final am a;
  private final Path.FillType b;
  private final c c;
  private final d d;
  private final f e;
  private final f f;
  private final String g;
  private final b h;
  private final b i;
  
  private ai(String paramString, am paramam, Path.FillType paramFillType, c paramc, d paramd, f paramf1, f paramf2, b paramb1, b paramb2)
  {
    this.a = paramam;
    this.b = paramFillType;
    this.c = paramc;
    this.d = paramd;
    this.e = paramf1;
    this.f = paramf2;
    this.g = paramString;
    this.h = paramb1;
    this.i = paramb2;
  }
  
  String a()
  {
    return this.g;
  }
  
  am b()
  {
    return this.a;
  }
  
  Path.FillType c()
  {
    return this.b;
  }
  
  c d()
  {
    return this.c;
  }
  
  d e()
  {
    return this.d;
  }
  
  f f()
  {
    return this.e;
  }
  
  f g()
  {
    return this.f;
  }
  
  static class a
  {
    static ai a(JSONObject paramJSONObject, aw paramaw)
    {
      String str = paramJSONObject.optString("nm");
      Object localObject2 = paramJSONObject.optJSONObject("g");
      Object localObject1 = localObject2;
      int i;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((JSONObject)localObject2).has("k"))
        {
          i = ((JSONObject)localObject2).optInt("p");
          localObject1 = ((JSONObject)localObject2).optJSONObject("k");
        }
      }
      try
      {
        ((JSONObject)localObject1).put("p", i);
        if (localObject1 != null)
        {
          localObject1 = c.a.a((JSONObject)localObject1, paramaw);
          localObject2 = paramJSONObject.optJSONObject("o");
          if (localObject2 != null)
          {
            localObject2 = d.a.a((JSONObject)localObject2, paramaw);
            Path.FillType localFillType;
            if (paramJSONObject.optInt("r", 1) == 1)
            {
              localFillType = Path.FillType.WINDING;
              if (paramJSONObject.optInt("t", 1) != 1) {
                break label193;
              }
            }
            label193:
            for (am localam = am.a;; localam = am.b)
            {
              localObject4 = paramJSONObject.optJSONObject("s");
              if (localObject4 == null) {
                break label211;
              }
              localObject4 = f.a.a((JSONObject)localObject4, paramaw);
              paramJSONObject = paramJSONObject.optJSONObject("e");
              if (paramJSONObject == null) {
                break label206;
              }
              paramJSONObject = f.a.a(paramJSONObject, paramaw);
              return new ai(str, localam, localFillType, (c)localObject1, (d)localObject2, (f)localObject4, paramJSONObject, null, null, null);
              localFillType = Path.FillType.EVEN_ODD;
              break;
            }
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          continue;
          label206:
          paramJSONObject = null;
          continue;
          label211:
          Object localObject4 = null;
          continue;
          Object localObject3 = null;
          continue;
          localObject1 = null;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */