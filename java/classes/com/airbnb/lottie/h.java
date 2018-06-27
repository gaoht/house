package com.airbnb.lottie;

import android.graphics.Path;
import java.util.List;
import org.json.JSONObject;

class h
  extends m<bs, Path>
{
  private final Path c = new Path();
  
  private h(List<at<bs>> paramList, bs parambs)
  {
    super(paramList, parambs);
  }
  
  Path a(bs parambs)
  {
    this.c.reset();
    bd.a(parambs, this.c);
    return this.c;
  }
  
  public n<?, Path> createAnimation()
  {
    if (!hasAnimation()) {
      return new cd(a((bs)this.b));
    }
    return new bv(this.a);
  }
  
  static final class a
  {
    static h a(JSONObject paramJSONObject, aw paramaw)
    {
      paramJSONObject = l.a(paramJSONObject, paramaw.getDpScale(), paramaw, bs.a.a).a();
      return new h(paramJSONObject.a, (bs)paramJSONObject.b, null);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */