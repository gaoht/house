package com.mato.sdk.e.c;

import com.mato.sdk.c.b.f;
import com.mato.sdk.f.d;
import com.mato.sdk.f.e;
import com.mato.sdk.f.h;
import com.mato.sdk.f.h.a;
import com.mato.sdk.f.h.b;
import com.mato.sdk.f.k;
import com.mato.sdk.g.j;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends e<JSONObject>
{
  private static final String b = com.mato.sdk.b.g.b("");
  private final h.b<JSONObject> c;
  private final String d;
  
  private a(1 param1)
  {
    super(1, 1.a(param1), 1.b(param1));
    Object localObject = "";
    try
    {
      String str = 1.c(param1);
      localObject = str;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
    this.d = ((String)localObject);
    this.c = 1.d(param1);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (this.c != null) {
      this.c.a(paramJSONObject);
    }
  }
  
  protected final h<JSONObject> a(d paramd)
  {
    try
    {
      h localh = h.a(new JSONObject(j.b(paramd.b, "80dee591a993ea01e51a766134f7827d")));
      return localh;
    }
    catch (Throwable localThrowable)
    {
      f.b().a(localThrowable, paramd.b);
      return h.a(localThrowable);
    }
  }
  
  public final com.mato.sdk.f.g c()
  {
    if (this.d == null) {
      return null;
    }
    return new k(this.d);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */