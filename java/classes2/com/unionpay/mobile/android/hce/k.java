package com.unionpay.mobile.android.hce;

import com.unionpay.mobile.android.utils.i;
import org.json.JSONObject;

public final class k
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private JSONObject g;
  
  public k(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.g = paramJSONObject;
      this.a = i.a(paramJSONObject, "package");
      this.b = i.a(paramJSONObject, "issuer");
      this.c = i.a(paramJSONObject, "syn_key");
      this.d = i.a(paramJSONObject, "pub_key");
      this.e = i.a(paramJSONObject, "status");
      this.f = i.a(paramJSONObject, "priority");
    }
  }
  
  public final boolean a()
  {
    return this.e.equals("D");
  }
  
  public final String b()
  {
    return this.a;
  }
  
  public final String c()
  {
    return this.b;
  }
  
  public final String d()
  {
    return this.c;
  }
  
  public final String e()
  {
    return this.d;
  }
  
  public final JSONObject f()
  {
    return this.g;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/hce/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */