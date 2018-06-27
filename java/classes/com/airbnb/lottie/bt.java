package com.airbnb.lottie;

import android.graphics.Path.FillType;
import org.json.JSONObject;

class bt
{
  private final boolean a;
  private final Path.FillType b;
  private final String c;
  private final a d;
  private final d e;
  
  private bt(String paramString, boolean paramBoolean, Path.FillType paramFillType, a parama, d paramd)
  {
    this.c = paramString;
    this.a = paramBoolean;
    this.b = paramFillType;
    this.d = parama;
    this.e = paramd;
  }
  
  String a()
  {
    return this.c;
  }
  
  a b()
  {
    return this.d;
  }
  
  d c()
  {
    return this.e;
  }
  
  Path.FillType d()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("ShapeFill{color=");
    if (this.d == null)
    {
      localObject = "null";
      localStringBuilder = localStringBuilder.append((String)localObject).append(", fillEnabled=").append(this.a).append(", opacity=");
      if (this.e != null) {
        break label90;
      }
    }
    label90:
    for (Object localObject = "null";; localObject = this.e.getInitialValue())
    {
      return localObject + '}';
      localObject = Integer.toHexString(((Integer)this.d.getInitialValue()).intValue());
      break;
    }
  }
  
  static class a
  {
    static bt a(JSONObject paramJSONObject, aw paramaw)
    {
      String str = paramJSONObject.optString("nm");
      Object localObject = paramJSONObject.optJSONObject("c");
      if (localObject != null) {}
      for (localObject = a.a.a((JSONObject)localObject, paramaw);; localObject = null)
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject("o");
        if (localJSONObject != null) {}
        for (paramaw = d.a.a(localJSONObject, paramaw);; paramaw = null)
        {
          boolean bool = paramJSONObject.optBoolean("fillEnabled");
          if (paramJSONObject.optInt("r", 1) == 1) {}
          for (paramJSONObject = Path.FillType.WINDING;; paramJSONObject = Path.FillType.EVEN_ODD) {
            return new bt(str, bool, paramJSONObject, (a)localObject, paramaw, null);
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */