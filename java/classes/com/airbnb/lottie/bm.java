package com.airbnb.lottie;

import android.graphics.PointF;
import org.json.JSONObject;

class bm
{
  private final String a;
  private final b b;
  private final b c;
  private final k<PointF> d;
  private final b e;
  private final b f;
  private final b g;
  private final b h;
  private final b i;
  
  private bm(String paramString, b paramb, b paramb1, k<PointF> paramk, b paramb2, b paramb3, b paramb4, b paramb5, b paramb6)
  {
    this.a = paramString;
    this.b = paramb;
    this.c = paramb1;
    this.d = paramk;
    this.e = paramb2;
    this.f = paramb3;
    this.g = paramb4;
    this.h = paramb5;
    this.i = paramb6;
  }
  
  String a()
  {
    return this.a;
  }
  
  b b()
  {
    return this.b;
  }
  
  b c()
  {
    return this.c;
  }
  
  k<PointF> d()
  {
    return this.d;
  }
  
  b e()
  {
    return this.e;
  }
  
  b f()
  {
    return this.f;
  }
  
  b g()
  {
    return this.g;
  }
  
  b h()
  {
    return this.h;
  }
  
  b i()
  {
    return this.i;
  }
  
  static class a
  {
    static bm a(JSONObject paramJSONObject, aw paramaw)
    {
      String str = paramJSONObject.optString("nm");
      bm.b localb = bm.b.a(paramJSONObject.optInt("sy"));
      b localb2 = b.a.a(paramJSONObject.optJSONObject("pt"), paramaw, false);
      k localk = e.a(paramJSONObject.optJSONObject("p"), paramaw);
      b localb3 = b.a.a(paramJSONObject.optJSONObject("r"), paramaw, false);
      b localb4 = b.a.a(paramJSONObject.optJSONObject("or"), paramaw);
      b localb5 = b.a.a(paramJSONObject.optJSONObject("os"), paramaw, false);
      b localb1;
      if (localb == bm.b.a)
      {
        localb1 = b.a.a(paramJSONObject.optJSONObject("ir"), paramaw);
        paramaw = b.a.a(paramJSONObject.optJSONObject("is"), paramaw, false);
      }
      for (paramJSONObject = localb1;; paramJSONObject = null)
      {
        return new bm(str, localb, localb2, localk, localb3, paramJSONObject, localb4, paramaw, localb5, null);
        paramaw = null;
      }
    }
  }
  
  static enum b
  {
    private final int c;
    
    private b(int paramInt)
    {
      this.c = paramInt;
    }
    
    static b a(int paramInt)
    {
      b[] arrayOfb = values();
      int j = arrayOfb.length;
      int i = 0;
      while (i < j)
      {
        b localb = arrayOfb[i];
        if (localb.c == paramInt) {
          return localb;
        }
        i += 1;
      }
      return null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */