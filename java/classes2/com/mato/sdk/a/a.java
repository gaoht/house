package com.mato.sdk.a;

import com.mato.sdk.b.g;
import com.mato.sdk.c.b.f;
import com.mato.sdk.f.h.a;
import com.mato.sdk.f.h.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static final String a = g.b("");
  private static String l = "http://mauth.chinanetcenter.com/frontoffice/checkAuthority";
  private a b;
  private String c;
  private String d;
  private int e;
  private int f;
  private String g;
  private String h;
  private int i;
  private int j;
  private c.a k;
  
  private void a(JSONObject paramJSONObject)
    throws JSONException
  {
    for (int m = 0;; m = 1)
    {
      try
      {
        if (!paramJSONObject.getBoolean("success"))
        {
          this.e = 2;
          this.d = paramJSONObject.optString("errorMsg", "");
          if (this.b != null)
          {
            if (m == 0) {
              break;
            }
            this.b.a(this);
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        String str = "";
        if (paramJSONObject == null) {
          break label97;
        }
        str = paramJSONObject.toString();
        f.b().a(localThrowable, str);
        return;
      }
      finally
      {
        if (this.b == null) {
          break label142;
        }
        this.b.b(this);
      }
      this.e = 0;
      this.c = paramJSONObject.optString("configuration", "");
    }
    this.b.b(this);
  }
  
  private void e()
  {
    try
    {
      this.e = 1;
      this.d = "NETWORK_ERROR";
      if (this.b != null) {
        this.b.b(this);
      }
      return;
    }
    catch (Exception localException)
    {
      f.b().a(localException);
    }
  }
  
  public final String a()
  {
    return this.c;
  }
  
  public final void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final void a(a parama)
  {
    this.b = parama;
  }
  
  public final void a(String paramString)
  {
    this.h = paramString;
  }
  
  public final String b()
  {
    return this.d;
  }
  
  public final void b(int paramInt)
  {
    this.j = paramInt;
  }
  
  public final void b(String paramString)
  {
    this.g = paramString;
  }
  
  public final int c()
  {
    return this.e;
  }
  
  public final void c(int paramInt)
  {
    this.i = paramInt;
  }
  
  public final void c(String paramString)
  {
    try
    {
      a(new JSONObject(paramString));
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public final void d()
  {
    this.k = new c.a().a("http://mauth.chinanetcenter.com/frontoffice/checkAuthority").a(this.f).b(this.h).c(this.g).b(this.i).a(this.j).a(new h.a()
    {
      public final void a(Throwable paramAnonymousThrowable)
      {
        a.a(a.this, paramAnonymousThrowable);
      }
    }).a(new h.b()
    {
      private void a(JSONObject paramAnonymousJSONObject)
      {
        try
        {
          a.a(a.this, paramAnonymousJSONObject);
          return;
        }
        catch (JSONException paramAnonymousJSONObject) {}
      }
    });
    com.mato.sdk.proxy.a.b().a(this.k.a());
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void b(a parama);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */