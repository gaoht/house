package com.airbnb.lottie;

import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class by
{
  private final String a;
  private final b b;
  private final List<b> c;
  private final a d;
  private final d e;
  private final b f;
  private final b g;
  private final c h;
  
  private by(String paramString, b paramb1, List<b> paramList, a parama, d paramd, b paramb2, b paramb, c paramc)
  {
    this.a = paramString;
    this.b = paramb1;
    this.c = paramList;
    this.d = parama;
    this.e = paramd;
    this.f = paramb2;
    this.g = paramb;
    this.h = paramc;
  }
  
  String a()
  {
    return this.a;
  }
  
  a b()
  {
    return this.d;
  }
  
  d c()
  {
    return this.e;
  }
  
  b d()
  {
    return this.f;
  }
  
  List<b> e()
  {
    return this.c;
  }
  
  b f()
  {
    return this.b;
  }
  
  b g()
  {
    return this.g;
  }
  
  c h()
  {
    return this.h;
  }
  
  static class a
  {
    static by a(JSONObject paramJSONObject, aw paramaw)
    {
      String str1 = paramJSONObject.optString("nm");
      ArrayList localArrayList = new ArrayList();
      a locala = a.a.a(paramJSONObject.optJSONObject("c"), paramaw);
      b localb = b.a.a(paramJSONObject.optJSONObject("w"), paramaw);
      d locald = d.a.a(paramJSONObject.optJSONObject("o"), paramaw);
      by.b localb1 = by.b.values()[(paramJSONObject.optInt("lc") - 1)];
      by.c localc = by.c.values()[(paramJSONObject.optInt("lj") - 1)];
      Object localObject = null;
      if (paramJSONObject.has("d"))
      {
        JSONArray localJSONArray = paramJSONObject.optJSONArray("d");
        paramJSONObject = null;
        int i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.optJSONObject(i);
          String str2 = localJSONObject.optString("n");
          if (str2.equals("o")) {
            localObject = b.a.a(localJSONObject.optJSONObject("v"), paramaw);
          }
          for (;;)
          {
            i += 1;
            paramJSONObject = (JSONObject)localObject;
            break;
            if (!str2.equals("d"))
            {
              localObject = paramJSONObject;
              if (!str2.equals("g")) {}
            }
            else
            {
              localArrayList.add(b.a.a(localJSONObject.optJSONObject("v"), paramaw));
              localObject = paramJSONObject;
            }
          }
        }
        if (localArrayList.size() == 1) {
          localArrayList.add(localArrayList.get(0));
        }
        localObject = paramJSONObject;
      }
      return new by(str1, (b)localObject, localArrayList, locala, locald, localb, localb1, localc, null);
    }
  }
  
  static enum b
  {
    private b() {}
    
    Paint.Cap a()
    {
      switch (by.1.a[ordinal()])
      {
      default: 
        return Paint.Cap.SQUARE;
      case 1: 
        return Paint.Cap.BUTT;
      }
      return Paint.Cap.ROUND;
    }
  }
  
  static enum c
  {
    private c() {}
    
    Paint.Join a()
    {
      switch (by.1.b[ordinal()])
      {
      default: 
        return null;
      case 1: 
        return Paint.Join.BEVEL;
      case 2: 
        return Paint.Join.MITER;
      }
      return Paint.Join.ROUND;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */