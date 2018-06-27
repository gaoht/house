package com.mato.sdk.e.d;

import android.text.TextUtils;
import com.mato.sdk.c.b.f;
import com.mato.sdk.d.m;
import com.mato.sdk.f.h.a;
import com.mato.sdk.f.h.b;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private static final String a = com.mato.sdk.b.g.b("");
  private m b;
  private final a c;
  private String d;
  private final List<g> e = new ArrayList();
  private b f;
  
  public d(a parama)
  {
    this.c = parama;
  }
  
  private void a(JSONObject paramJSONObject)
  {
    int i;
    try
    {
      if (paramJSONObject.getBoolean("success")) {
        break label88;
      }
      paramJSONObject.optString("errorMsg", "");
    }
    catch (Throwable paramJSONObject)
    {
      for (;;)
      {
        label88:
        f.b().a(paramJSONObject);
        this.c.a();
      }
    }
    finally
    {
      this.c.a();
    }
    if (TextUtils.isEmpty(this.d)) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        this.f = new b(this.d, this.b.b(), this.e);
        com.mato.sdk.g.a.a.b().a(new TimerTask()
        {
          public final void run()
          {
            d.b(d.this);
          }
        }, 15000L);
      }
      return;
      this.d = paramJSONObject.optString("reportUrl", "");
      Object localObject = this.d;
      if (!paramJSONObject.has("tasks")) {
        break;
      }
      paramJSONObject = paramJSONObject.getJSONArray("tasks");
      i = 0;
      while (i < paramJSONObject.length())
      {
        localObject = g.a(paramJSONObject.getJSONObject(i), i + 100);
        if (((g)localObject).k()) {
          this.e.add(localObject);
        }
        i += 1;
      }
      if (this.e.isEmpty()) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  private void b(JSONObject paramJSONObject)
    throws JSONException
  {
    int i = 0;
    if (!paramJSONObject.getBoolean("success")) {
      paramJSONObject.optString("errorMsg", "");
    }
    for (;;)
    {
      return;
      this.d = paramJSONObject.optString("reportUrl", "");
      Object localObject = this.d;
      if (paramJSONObject.has("tasks"))
      {
        paramJSONObject = paramJSONObject.getJSONArray("tasks");
        while (i < paramJSONObject.length())
        {
          localObject = g.a(paramJSONObject.getJSONObject(i), i + 100);
          if (((g)localObject).k()) {
            this.e.add(localObject);
          }
          i += 1;
        }
      }
    }
  }
  
  private void c()
  {
    c localc = new c(new c.a().a(this.b.a()).b(this.b.b()).a(new h.a()
    {
      public final void a(Throwable paramAnonymousThrowable)
      {
        d.a(d.this).a();
        d.b();
      }
    }).a(new h.b()
    {
      private void a(JSONObject paramAnonymousJSONObject)
      {
        d.a(d.this, paramAnonymousJSONObject);
      }
    }));
    com.mato.sdk.proxy.a.b().a(localc);
  }
  
  private void c(JSONObject paramJSONObject)
    throws JSONException
  {
    int i = 0;
    this.d = paramJSONObject.optString("reportUrl", "");
    Object localObject = this.d;
    if (!paramJSONObject.has("tasks")) {}
    for (;;)
    {
      return;
      paramJSONObject = paramJSONObject.getJSONArray("tasks");
      while (i < paramJSONObject.length())
      {
        localObject = g.a(paramJSONObject.getJSONObject(i), i + 100);
        if (((g)localObject).k()) {
          this.e.add(localObject);
        }
        i += 1;
      }
    }
  }
  
  private void d()
  {
    this.f.a();
  }
  
  private boolean e()
  {
    if (TextUtils.isEmpty(this.d)) {}
    while (this.e.isEmpty()) {
      return false;
    }
    return true;
  }
  
  public final List<g> a()
  {
    return this.e;
  }
  
  public final void a(int paramInt, String paramString)
  {
    this.f.a(paramInt, paramString);
  }
  
  public final void a(m paramm)
  {
    this.b = paramm;
    this.d = "";
    this.e.clear();
    paramm = new c(new c.a().a(this.b.a()).b(this.b.b()).a(new h.a()
    {
      public final void a(Throwable paramAnonymousThrowable)
      {
        d.a(d.this).a();
        d.b();
      }
    }).a(new h.b()
    {
      private void a(JSONObject paramAnonymousJSONObject)
      {
        d.a(d.this, paramAnonymousJSONObject);
      }
    }));
    com.mato.sdk.proxy.a.b().a(paramm);
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */