package com.airbnb.lottie;

import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class l<T>
{
  private final JSONObject a;
  private final float b;
  private final aw c;
  private final k.a<T> d;
  
  private l(JSONObject paramJSONObject, float paramFloat, aw paramaw, k.a<T> parama)
  {
    this.a = paramJSONObject;
    this.b = paramFloat;
    this.c = paramaw;
    this.d = parama;
  }
  
  static <T> l<T> a(JSONObject paramJSONObject, float paramFloat, aw paramaw, k.a<T> parama)
  {
    return new l(paramJSONObject, paramFloat, paramaw, parama);
  }
  
  private T a(List<at<T>> paramList)
  {
    if (this.a != null)
    {
      if (!paramList.isEmpty()) {
        return (T)((at)paramList.get(0)).a;
      }
      return (T)this.d.valueFromObject(this.a.opt("k"), this.b);
    }
    return null;
  }
  
  private static boolean a(Object paramObject)
  {
    if (!(paramObject instanceof JSONArray)) {
      return false;
    }
    paramObject = ((JSONArray)paramObject).opt(0);
    if (((paramObject instanceof JSONObject)) && (((JSONObject)paramObject).has("t"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private List<at<T>> b()
  {
    if (this.a != null)
    {
      Object localObject = this.a.opt("k");
      if (a(localObject)) {
        return at.a.a((JSONArray)localObject, this.c, this.b, this.d);
      }
      return Collections.emptyList();
    }
    return Collections.emptyList();
  }
  
  a<T> a()
  {
    List localList = b();
    return new a(localList, a(localList));
  }
  
  static class a<T>
  {
    final List<at<T>> a;
    final T b;
    
    a(List<at<T>> paramList, T paramT)
    {
      this.a = paramList;
      this.b = paramT;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */