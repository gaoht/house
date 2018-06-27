package com.airbnb.lottie;

import android.content.res.Resources;
import org.json.JSONObject;

final class ar
  extends w<JSONObject>
{
  private final Resources a;
  private final bf b;
  
  ar(Resources paramResources, bf parambf)
  {
    this.a = paramResources;
    this.b = parambf;
  }
  
  protected aw a(JSONObject... paramVarArgs)
  {
    return aw.a.a(this.a, paramVarArgs[0]);
  }
  
  protected void a(aw paramaw)
  {
    this.b.onCompositionLoaded(paramaw);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */