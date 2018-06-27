package com.airbnb.lottie;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class e
  implements k<PointF>
{
  private final List<bh> a = new ArrayList();
  private PointF b;
  
  e()
  {
    this.b = new PointF(0.0F, 0.0F);
  }
  
  e(Object paramObject, aw paramaw)
  {
    if (a(paramObject))
    {
      paramObject = (JSONArray)paramObject;
      int j = ((JSONArray)paramObject).length();
      int i = 0;
      while (i < j)
      {
        bh localbh = bh.a.a(((JSONArray)paramObject).optJSONObject(i), paramaw, a.a());
        this.a.add(localbh);
        i += 1;
      }
      at.a(this.a);
      return;
    }
    this.b = as.a((JSONArray)paramObject, paramaw.getDpScale());
  }
  
  static k<PointF> a(JSONObject paramJSONObject, aw paramaw)
  {
    if (paramJSONObject.has("k")) {
      return new e(paramJSONObject.opt("k"), paramaw);
    }
    return new i(b.a.a(paramJSONObject.optJSONObject("x"), paramaw), b.a.a(paramJSONObject.optJSONObject("y"), paramaw));
  }
  
  private boolean a(Object paramObject)
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
  
  public n<?, PointF> createAnimation()
  {
    if (!hasAnimation()) {
      return new cd(this.b);
    }
    return new bi(this.a);
  }
  
  public boolean hasAnimation()
  {
    return !this.a.isEmpty();
  }
  
  public String toString()
  {
    return "initialPoint=" + this.b;
  }
  
  private static class a
    implements k.a<PointF>
  {
    private static final k.a<PointF> a = new a();
    
    public PointF valueFromObject(Object paramObject, float paramFloat)
    {
      return as.a((JSONArray)paramObject, paramFloat);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */