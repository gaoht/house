package com.airbnb.lottie;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class ak
{
  private final String a;
  private final am b;
  private final c c;
  private final d d;
  private final f e;
  private final f f;
  private final b g;
  private final by.b h;
  private final by.c i;
  private final List<b> j;
  private final b k;
  
  private ak(String paramString, am paramam, c paramc, d paramd, f paramf1, f paramf2, b paramb1, by.b paramb, by.c paramc1, List<b> paramList, b paramb2)
  {
    this.a = paramString;
    this.b = paramam;
    this.c = paramc;
    this.d = paramd;
    this.e = paramf1;
    this.f = paramf2;
    this.g = paramb1;
    this.h = paramb;
    this.i = paramc1;
    this.j = paramList;
    this.k = paramb2;
  }
  
  String a()
  {
    return this.a;
  }
  
  am b()
  {
    return this.b;
  }
  
  c c()
  {
    return this.c;
  }
  
  d d()
  {
    return this.d;
  }
  
  f e()
  {
    return this.e;
  }
  
  f f()
  {
    return this.f;
  }
  
  b g()
  {
    return this.g;
  }
  
  by.b h()
  {
    return this.h;
  }
  
  by.c i()
  {
    return this.i;
  }
  
  List<b> j()
  {
    return this.j;
  }
  
  b k()
  {
    return this.k;
  }
  
  static class a
  {
    static ak a(JSONObject paramJSONObject, aw paramaw)
    {
      String str1 = paramJSONObject.optString("nm");
      Object localObject1 = paramJSONObject.optJSONObject("g");
      Object localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((JSONObject)localObject1).has("k")) {
          localObject2 = ((JSONObject)localObject1).optJSONObject("k");
        }
      }
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = c.a.a((JSONObject)localObject2, paramaw);
      }
      Object localObject3 = paramJSONObject.optJSONObject("o");
      localObject2 = null;
      if (localObject3 != null) {
        localObject2 = d.a.a((JSONObject)localObject3, paramaw);
      }
      Object localObject4;
      f localf;
      b localb;
      by.b localb1;
      by.c localc;
      ArrayList localArrayList;
      int i;
      label217:
      JSONObject localJSONObject;
      String str2;
      if (paramJSONObject.optInt("t", 1) == 1)
      {
        localObject3 = am.a;
        localObject4 = paramJSONObject.optJSONObject("s");
        localf = null;
        if (localObject4 != null) {
          localf = f.a.a((JSONObject)localObject4, paramaw);
        }
        localObject5 = paramJSONObject.optJSONObject("e");
        localObject4 = null;
        if (localObject5 != null) {
          localObject4 = f.a.a((JSONObject)localObject5, paramaw);
        }
        localb = b.a.a(paramJSONObject.optJSONObject("w"), paramaw);
        localb1 = by.b.values()[(paramJSONObject.optInt("lc") - 1)];
        localc = by.c.values()[(paramJSONObject.optInt("lj") - 1)];
        localObject5 = null;
        localArrayList = new ArrayList();
        if (!paramJSONObject.has("d")) {
          break label362;
        }
        JSONArray localJSONArray = paramJSONObject.optJSONArray("d");
        paramJSONObject = null;
        i = 0;
        if (i >= localJSONArray.length()) {
          break label332;
        }
        localJSONObject = localJSONArray.optJSONObject(i);
        str2 = localJSONObject.optString("n");
        if (!str2.equals("o")) {
          break label284;
        }
        localObject5 = b.a.a(localJSONObject.optJSONObject("v"), paramaw);
      }
      for (;;)
      {
        i += 1;
        paramJSONObject = (JSONObject)localObject5;
        break label217;
        localObject3 = am.b;
        break;
        label284:
        if (!str2.equals("d"))
        {
          localObject5 = paramJSONObject;
          if (!str2.equals("g")) {}
        }
        else
        {
          localArrayList.add(b.a.a(localJSONObject.optJSONObject("v"), paramaw));
          localObject5 = paramJSONObject;
        }
      }
      label332:
      if (localArrayList.size() == 1) {
        localArrayList.add(localArrayList.get(0));
      }
      Object localObject5 = paramJSONObject;
      label362:
      return new ak(str1, (am)localObject3, (c)localObject1, (d)localObject2, localf, (f)localObject4, localb, localb1, localc, localArrayList, (b)localObject5, null);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */