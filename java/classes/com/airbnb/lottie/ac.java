package com.airbnb.lottie;

import android.content.res.Resources;
import java.io.InputStream;

final class ac
  extends w<InputStream>
{
  private final Resources a;
  private final bf b;
  
  ac(Resources paramResources, bf parambf)
  {
    this.a = paramResources;
    this.b = parambf;
  }
  
  protected aw a(InputStream... paramVarArgs)
  {
    return aw.a.a(this.a, paramVarArgs[0]);
  }
  
  protected void a(aw paramaw)
  {
    this.b.onCompositionLoaded(paramaw);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */