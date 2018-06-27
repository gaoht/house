package com.airbnb.lottie;

import android.graphics.Color;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

class av
{
  private static final String a = av.class.getSimpleName();
  private final List<Object> b;
  private final aw c;
  private final String d;
  private final long e;
  private final b f;
  private final long g;
  private final String h;
  private final List<az> i;
  private final j j;
  private final int k;
  private final int l;
  private final int m;
  private final float n;
  private final float o;
  private final int p;
  private final int q;
  private final List<at<Float>> r;
  private final c s;
  
  private av(List<Object> paramList, aw paramaw, String paramString1, long paramLong1, b paramb, long paramLong2, String paramString2, List<az> paramList1, j paramj, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4, int paramInt5, List<at<Float>> paramList2, c paramc)
  {
    this.b = paramList;
    this.c = paramaw;
    this.d = paramString1;
    this.e = paramLong1;
    this.f = paramb;
    this.g = paramLong2;
    this.h = paramString2;
    this.i = paramList1;
    this.j = paramj;
    this.k = paramInt1;
    this.l = paramInt2;
    this.m = paramInt3;
    this.n = paramFloat1;
    this.o = paramFloat2;
    this.p = paramInt4;
    this.q = paramInt5;
    this.r = paramList2;
    this.s = paramc;
  }
  
  float a()
  {
    return this.o;
  }
  
  String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append(d()).append("\n");
    Object localObject1 = this.c.a(k());
    if (localObject1 != null)
    {
      localStringBuilder.append("\t\tParents: ").append(((av)localObject1).d());
      for (localObject1 = this.c.a(((av)localObject1).k()); localObject1 != null; localObject1 = this.c.a(((av)localObject1).k())) {
        localStringBuilder.append("->").append(((av)localObject1).d());
      }
      localStringBuilder.append(paramString).append("\n");
    }
    if (!h().isEmpty()) {
      localStringBuilder.append(paramString).append("\tMasks: ").append(h().size()).append("\n");
    }
    if ((p() != 0) && (o() != 0)) {
      localStringBuilder.append(paramString).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", new Object[] { Integer.valueOf(p()), Integer.valueOf(o()), Integer.valueOf(n()) }));
    }
    if (!this.b.isEmpty())
    {
      localStringBuilder.append(paramString).append("\tShapes:\n");
      localObject1 = this.b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        localStringBuilder.append(paramString).append("\t\t").append(localObject2).append("\n");
      }
    }
    return localStringBuilder.toString();
  }
  
  List<at<Float>> b()
  {
    return this.r;
  }
  
  long c()
  {
    return this.e;
  }
  
  String d()
  {
    return this.d;
  }
  
  String e()
  {
    return this.h;
  }
  
  int f()
  {
    return this.p;
  }
  
  int g()
  {
    return this.q;
  }
  
  List<az> h()
  {
    return this.i;
  }
  
  b i()
  {
    return this.f;
  }
  
  c j()
  {
    return this.s;
  }
  
  long k()
  {
    return this.g;
  }
  
  List<Object> l()
  {
    return this.b;
  }
  
  j m()
  {
    return this.j;
  }
  
  int n()
  {
    return this.m;
  }
  
  int o()
  {
    return this.l;
  }
  
  int p()
  {
    return this.k;
  }
  
  public String toString()
  {
    return a("");
  }
  
  static class a
  {
    static av a(aw paramaw)
    {
      Rect localRect = paramaw.getBounds();
      return new av(Collections.emptyList(), paramaw, null, -1L, av.b.a, -1L, null, Collections.emptyList(), j.a.a(), 0, 0, 0, 0.0F, 0.0F, localRect.width(), localRect.height(), Collections.emptyList(), av.c.a, null);
    }
    
    static av a(JSONObject paramJSONObject, aw paramaw)
    {
      String str1 = paramJSONObject.optString("nm");
      String str2 = paramJSONObject.optString("refId");
      long l1 = paramJSONObject.optLong("ind");
      int i = 0;
      int j = 0;
      int k = 0;
      int i1 = 0;
      int n = 0;
      int m = paramJSONObject.optInt("ty", -1);
      if (m < av.b.g.ordinal()) {}
      long l2;
      j localj;
      av.c localc;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      ArrayList localArrayList3;
      for (av.b localb = av.b.values()[m];; localb = av.b.g)
      {
        l2 = paramJSONObject.optLong("parent", -1L);
        if (localb == av.b.b)
        {
          i = (int)(paramJSONObject.optInt("sw") * paramaw.getDpScale());
          j = (int)(paramJSONObject.optInt("sh") * paramaw.getDpScale());
          k = Color.parseColor(paramJSONObject.optString("sc"));
        }
        localj = j.a.a(paramJSONObject.optJSONObject("ks"), paramaw);
        localc = av.c.values()[paramJSONObject.optInt("tt")];
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localArrayList3 = new ArrayList();
        localJSONArray = paramJSONObject.optJSONArray("masksProperties");
        if (localJSONArray == null) {
          break;
        }
        m = 0;
        while (m < localJSONArray.length())
        {
          localArrayList2.add(az.a.a(localJSONArray.optJSONObject(m), paramaw));
          m += 1;
        }
      }
      JSONArray localJSONArray = paramJSONObject.optJSONArray("shapes");
      if (localJSONArray != null)
      {
        m = 0;
        while (m < localJSONArray.length())
        {
          Object localObject = bu.a(localJSONArray.optJSONObject(m), paramaw);
          if (localObject != null) {
            localArrayList1.add(localObject);
          }
          m += 1;
        }
      }
      float f2 = (float)paramJSONObject.optDouble("sr", 1.0D);
      float f3 = (float)paramJSONObject.optDouble("st") / paramaw.d();
      m = i1;
      if (localb == av.b.a)
      {
        m = (int)(paramJSONObject.optInt("w") * paramaw.getDpScale());
        n = (int)(paramJSONObject.optInt("h") * paramaw.getDpScale());
      }
      float f4 = (float)paramJSONObject.optLong("ip");
      float f1 = (float)paramJSONObject.optLong("op");
      if (f4 > 0.0F) {
        localArrayList3.add(new at(paramaw, Float.valueOf(0.0F), Float.valueOf(0.0F), null, 0.0F, Float.valueOf(f4)));
      }
      if (f1 > 0.0F) {}
      for (;;)
      {
        localArrayList3.add(new at(paramaw, Float.valueOf(1.0F), Float.valueOf(1.0F), null, f4, Float.valueOf(f1)));
        if (f1 <= paramaw.d()) {
          localArrayList3.add(new at(paramaw, Float.valueOf(0.0F), Float.valueOf(0.0F), null, f1, Float.valueOf((float)paramaw.a())));
        }
        return new av(localArrayList1, paramaw, str1, l1, localb, l2, str2, localArrayList2, localj, i, j, k, f2, f3, m, n, localArrayList3, localc, null);
        f1 = (float)(paramaw.a() + 1L);
      }
    }
  }
  
  static enum b
  {
    private b() {}
  }
  
  static enum c
  {
    private c() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */