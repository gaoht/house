package com.unionpay.mobile.android.hce;

import android.content.ServiceConnection;
import com.unionpay.mobile.android.hce.service.a;
import com.unionpay.mobile.android.model.d;
import com.unionpay.mobile.android.utils.i;
import org.json.JSONObject;

public final class c
  implements d
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private a g;
  private ServiceConnection h;
  
  public c(JSONObject paramJSONObject, String paramString, a parama, ServiceConnection paramServiceConnection)
  {
    this.a = i.a(paramJSONObject, "num");
    this.b = i.a(paramJSONObject, "name");
    this.d = i.a(paramJSONObject, "type");
    String str = i.a(paramJSONObject, "type");
    if (e.a.equals(str)) {
      str = e.e;
    }
    for (;;)
    {
      this.c = str;
      this.e = i.a(paramJSONObject, "instNum");
      this.f = paramString;
      this.g = parama;
      this.h = paramServiceConnection;
      return;
      if (e.b.equals(str)) {
        str = e.f;
      } else if (e.c.equals(str)) {
        str = e.g;
      } else if (e.d.equals(str)) {
        str = e.h;
      } else {
        str = "";
      }
    }
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final String b()
  {
    return this.b;
  }
  
  public final String c()
  {
    return this.c;
  }
  
  public final String d()
  {
    return this.d;
  }
  
  public final String e()
  {
    return this.e;
  }
  
  public final String f()
  {
    return this.f;
  }
  
  public final a g()
  {
    return this.g;
  }
  
  public final ServiceConnection h()
  {
    return this.h;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/hce/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */