package com.airbnb.lottie;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class bs
{
  private final List<z> a = new ArrayList();
  private PointF b;
  private boolean c;
  
  bs() {}
  
  private bs(PointF paramPointF, boolean paramBoolean, List<z> paramList)
  {
    this.b = paramPointF;
    this.c = paramBoolean;
    this.a.addAll(paramList);
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    if (this.b == null) {
      this.b = new PointF();
    }
    this.b.set(paramFloat1, paramFloat2);
  }
  
  PointF a()
  {
    return this.b;
  }
  
  void a(bs parambs1, bs parambs2, float paramFloat)
  {
    if (this.b == null) {
      this.b = new PointF();
    }
    if ((parambs1.b()) || (parambs2.b())) {}
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      if ((this.a.isEmpty()) || (this.a.size() == parambs1.c().size()) || (this.a.size() == parambs2.c().size())) {
        break;
      }
      throw new IllegalStateException("Curves must have the same number of control points. This: " + c().size() + "\tShape 1: " + parambs1.c().size() + "\tShape 2: " + parambs2.c().size());
    }
    if (this.a.isEmpty())
    {
      i = parambs1.c().size() - 1;
      while (i >= 0)
      {
        this.a.add(new z());
        i -= 1;
      }
    }
    PointF localPointF1 = parambs1.a();
    PointF localPointF2 = parambs2.a();
    a(bd.a(localPointF1.x, localPointF2.x, paramFloat), bd.a(localPointF1.y, localPointF2.y, paramFloat));
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      Object localObject2 = (z)parambs1.c().get(i);
      Object localObject1 = (z)parambs2.c().get(i);
      localPointF1 = ((z)localObject2).a();
      localPointF2 = ((z)localObject2).b();
      localObject2 = ((z)localObject2).c();
      PointF localPointF3 = ((z)localObject1).a();
      PointF localPointF4 = ((z)localObject1).b();
      localObject1 = ((z)localObject1).c();
      ((z)this.a.get(i)).a(bd.a(localPointF1.x, localPointF3.x, paramFloat), bd.a(localPointF1.y, localPointF3.y, paramFloat));
      ((z)this.a.get(i)).b(bd.a(localPointF2.x, localPointF4.x, paramFloat), bd.a(localPointF2.y, localPointF4.y, paramFloat));
      ((z)this.a.get(i)).c(bd.a(((PointF)localObject2).x, ((PointF)localObject1).x, paramFloat), bd.a(((PointF)localObject2).y, ((PointF)localObject1).y, paramFloat));
      i -= 1;
    }
  }
  
  boolean b()
  {
    return this.c;
  }
  
  List<z> c()
  {
    return this.a;
  }
  
  public String toString()
  {
    return "ShapeData{numCurves=" + this.a.size() + "closed=" + this.c + '}';
  }
  
  static class a
    implements k.a<bs>
  {
    static final a a = new a();
    
    private static PointF a(int paramInt, JSONArray paramJSONArray)
    {
      if (paramInt >= paramJSONArray.length()) {
        throw new IllegalArgumentException("Invalid index " + paramInt + ". There are only " + paramJSONArray.length() + " points.");
      }
      Object localObject = paramJSONArray.optJSONArray(paramInt);
      paramJSONArray = ((JSONArray)localObject).opt(0);
      localObject = ((JSONArray)localObject).opt(1);
      float f1;
      if ((paramJSONArray instanceof Double))
      {
        f1 = new Float(((Double)paramJSONArray).doubleValue()).floatValue();
        if (!(localObject instanceof Double)) {
          break label148;
        }
      }
      label148:
      for (float f2 = new Float(((Double)localObject).doubleValue()).floatValue();; f2 = ((Integer)localObject).intValue())
      {
        return new PointF(f1, f2);
        f1 = ((Integer)paramJSONArray).intValue();
        break;
      }
    }
    
    public bs valueFromObject(Object paramObject, float paramFloat)
    {
      Object localObject2 = null;
      if ((paramObject instanceof JSONArray))
      {
        paramObject = ((JSONArray)paramObject).opt(0);
        if ((!(paramObject instanceof JSONObject)) || (!((JSONObject)paramObject).has("v"))) {
          break label604;
        }
      }
      label604:
      for (paramObject = (JSONObject)paramObject;; paramObject = null)
      {
        Object localObject1 = paramObject;
        while (localObject1 == null)
        {
          return null;
          localObject1 = localObject2;
          if ((paramObject instanceof JSONObject))
          {
            localObject1 = localObject2;
            if (((JSONObject)paramObject).has("v")) {
              localObject1 = (JSONObject)paramObject;
            }
          }
        }
        Object localObject4 = ((JSONObject)localObject1).optJSONArray("v");
        localObject2 = ((JSONObject)localObject1).optJSONArray("i");
        Object localObject3 = ((JSONObject)localObject1).optJSONArray("o");
        boolean bool = ((JSONObject)localObject1).optBoolean("c", false);
        if ((localObject4 == null) || (localObject2 == null) || (localObject3 == null) || (((JSONArray)localObject4).length() != ((JSONArray)localObject2).length()) || (((JSONArray)localObject4).length() != ((JSONArray)localObject3).length())) {
          throw new IllegalStateException("Unable to process points array or tangents. " + localObject1);
        }
        if (((JSONArray)localObject4).length() == 0) {
          return new bs(new PointF(), false, Collections.emptyList(), null);
        }
        int j = ((JSONArray)localObject4).length();
        paramObject = a(0, (JSONArray)localObject4);
        ((PointF)paramObject).x *= paramFloat;
        ((PointF)paramObject).y *= paramFloat;
        localObject1 = new ArrayList(j);
        int i = 1;
        PointF localPointF1;
        while (i < j)
        {
          localPointF1 = a(i, (JSONArray)localObject4);
          PointF localPointF3 = a(i - 1, (JSONArray)localObject4);
          PointF localPointF4 = a(i - 1, (JSONArray)localObject3);
          PointF localPointF2 = a(i, (JSONArray)localObject2);
          localPointF3 = bd.a(localPointF3, localPointF4);
          localPointF2 = bd.a(localPointF1, localPointF2);
          localPointF3.x *= paramFloat;
          localPointF3.y *= paramFloat;
          localPointF2.x *= paramFloat;
          localPointF2.y *= paramFloat;
          localPointF1.x *= paramFloat;
          localPointF1.y *= paramFloat;
          ((List)localObject1).add(new z(localPointF3, localPointF2, localPointF1));
          i += 1;
        }
        if (bool)
        {
          localPointF1 = a(0, (JSONArray)localObject4);
          localObject4 = a(j - 1, (JSONArray)localObject4);
          localObject3 = a(j - 1, (JSONArray)localObject3);
          localObject2 = a(0, (JSONArray)localObject2);
          localObject3 = bd.a((PointF)localObject4, (PointF)localObject3);
          localObject2 = bd.a(localPointF1, (PointF)localObject2);
          if (paramFloat != 1.0F)
          {
            ((PointF)localObject3).x *= paramFloat;
            ((PointF)localObject3).y *= paramFloat;
            ((PointF)localObject2).x *= paramFloat;
            ((PointF)localObject2).y *= paramFloat;
            localPointF1.x *= paramFloat;
            localPointF1.y *= paramFloat;
          }
          ((List)localObject1).add(new z((PointF)localObject3, (PointF)localObject2, localPointF1));
        }
        return new bs((PointF)paramObject, bool, (List)localObject1, null);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */