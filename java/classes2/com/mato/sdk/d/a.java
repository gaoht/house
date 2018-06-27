package com.mato.sdk.d;

import android.text.TextUtils;
import android.util.SparseArray;
import com.mato.sdk.b.g;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

public abstract class a
  extends c
{
  private static final String A = "logPolicy";
  private static final String B = "expiredTime";
  private static String C = "optimizationPolicy";
  private static final String D = "serviceType";
  private static final String E = "showToast";
  private static final String F = "filteredUrlRegex";
  private static final String G = "allowedUrlRegex";
  private static final String H = "httpReadTimeout";
  private static final String I = "deleteExif";
  private static final String J = "packageSuffix";
  private static final String K = "_2g";
  private static final String L = "_3g";
  private static final String M = "_4g";
  private static final String N = "wifi";
  private static final String O = "compressBody";
  private static final String P = "authKey";
  private static final String Q = "picUrlRegex";
  private static final String R = "resizeUrlRegex";
  private static final String S = "resizeRate";
  private static final String T = "maaBillingType";
  private static final String U = "authInterval";
  private static final String V = "antiAttackUrlRegex";
  private static final String W = "allowedUrlRegexType";
  private static final String X = "filteredUrlRegexType";
  private static final String a = g.b("");
  private static final int b = 0;
  private static final int c = 1;
  private static int d = 2;
  private static int e = 3;
  private static final String y = "ws_cdn_signal=302_redirect";
  private final AtomicLong f = new AtomicLong(0L);
  private final AtomicInteger g = new AtomicInteger(0);
  private final AtomicBoolean h = new AtomicBoolean(false);
  private f i = null;
  private int j = 60;
  private String k = "";
  private int l = 2;
  private String m = "";
  private int n = 2;
  private int o = -1;
  private boolean p = true;
  private String q = "";
  private boolean r = false;
  private SparseArray<i> s = new SparseArray();
  private String t = null;
  private String u = "";
  private String v = "";
  private String w = "";
  private int x = 0;
  private String z = "ws_cdn_signal=302_redirect";
  
  private void a(long paramLong)
  {
    this.f.set(paramLong);
  }
  
  private void b(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("_2g");
    if (localJSONObject != null) {
      a(2).a(localJSONObject);
    }
    localJSONObject = paramJSONObject.optJSONObject("_3g");
    if (localJSONObject != null) {
      a(3).a(localJSONObject);
    }
    localJSONObject = paramJSONObject.optJSONObject("_4g");
    if (localJSONObject != null) {
      a(4).a(localJSONObject);
    }
    paramJSONObject = paramJSONObject.optJSONObject("wifi");
    if (paramJSONObject != null) {
      a(1).a(paramJSONObject);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    this.h.set(paramBoolean);
  }
  
  private boolean b(String paramString)
  {
    try
    {
      boolean bool = a(new JSONObject(paramString));
      return bool;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  private void c(int paramInt)
  {
    this.o = paramInt;
  }
  
  private void c(String paramString)
  {
    this.k = paramString;
  }
  
  private void c(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  private void d(int paramInt)
  {
    this.x = paramInt;
  }
  
  private void d(String paramString)
  {
    this.m = paramString;
  }
  
  private void d(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  private void e(int paramInt)
  {
    if (paramInt > 0) {
      this.j = paramInt;
    }
  }
  
  private void e(String paramString)
  {
    this.q = paramString;
  }
  
  private void f(String paramString)
  {
    this.t = paramString;
  }
  
  private void g(String paramString)
  {
    this.u = paramString;
  }
  
  private void h(String paramString)
  {
    this.v = paramString;
  }
  
  private void i(String paramString)
  {
    this.w = paramString;
  }
  
  private void j(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "ws_cdn_signal=302_redirect";
    }
    this.z = str;
  }
  
  private boolean x()
  {
    return this.g.get() == 1;
  }
  
  private boolean y()
  {
    return this.g.get() == 0;
  }
  
  public final f a()
  {
    if (this.i == null) {
      this.i = new f();
    }
    return this.i;
  }
  
  public final i a(int paramInt)
  {
    i locali2 = (i)this.s.get(paramInt);
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = (i)this.s.get(3);
    }
    return locali1;
  }
  
  protected final void a(i parami)
  {
    this.s.put(parami.l(), parami);
  }
  
  public final void a(boolean paramBoolean)
  {
    SparseArray localSparseArray = this.s;
    int i2 = localSparseArray.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((i)localSparseArray.valueAt(i1)).a(true);
      i1 += 1;
    }
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    bool1 = true;
    try
    {
      long l1 = paramJSONObject.optLong("expiredTime", this.f.get());
      this.f.set(l1);
      int i1 = paramJSONObject.optInt("serviceType", this.g.get());
      this.g.set(i1);
      boolean bool2 = paramJSONObject.optBoolean("showToast", this.h.get());
      this.h.set(bool2);
      this.o = paramJSONObject.optInt("httpReadTimeout", this.o);
      this.p = paramJSONObject.optBoolean("deleteExif", this.p);
      this.q = paramJSONObject.optString("packageSuffix", this.q);
      this.r = paramJSONObject.optBoolean("compressBody", this.r);
      Object localObject = paramJSONObject.optJSONObject("logPolicy");
      if (localObject != null) {}
      for (this.i = f.a((JSONObject)localObject);; this.i = new f())
      {
        localObject = paramJSONObject.optJSONObject("optimizationPolicy");
        if (localObject != null)
        {
          JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject("_2g");
          if (localJSONObject != null) {
            a(2).a(localJSONObject);
          }
          localJSONObject = ((JSONObject)localObject).optJSONObject("_3g");
          if (localJSONObject != null) {
            a(3).a(localJSONObject);
          }
          localJSONObject = ((JSONObject)localObject).optJSONObject("_4g");
          if (localJSONObject != null) {
            a(4).a(localJSONObject);
          }
          localObject = ((JSONObject)localObject).optJSONObject("wifi");
          if (localObject != null) {
            a(1).a((JSONObject)localObject);
          }
        }
        localObject = a(paramJSONObject, "allowedUrlRegex", true);
        if (localObject != null) {
          this.m = ((String)localObject);
        }
        localObject = a(paramJSONObject, "filteredUrlRegex", true);
        if (localObject != null) {
          this.k = ((String)localObject);
        }
        this.n = paramJSONObject.optInt("allowedUrlRegexType", 2);
        this.l = paramJSONObject.optInt("filteredUrlRegexType", 2);
        this.t = paramJSONObject.optString("authKey", this.t);
        this.w = paramJSONObject.optString("resizeRate", this.w);
        this.x = paramJSONObject.optInt("maaBillingType", this.x);
        localObject = a(paramJSONObject, "picUrlRegex", true);
        if (localObject != null) {
          this.u = ((String)localObject);
        }
        localObject = a(paramJSONObject, "resizeUrlRegex", true);
        if (localObject != null) {
          this.v = ((String)localObject);
        }
        i1 = paramJSONObject.optInt("authInterval", this.j);
        if (i1 > 0) {
          this.j = i1;
        }
        localObject = a(paramJSONObject, "antiAttackUrlRegex", true);
        if (localObject == null) {
          break;
        }
        paramJSONObject = (JSONObject)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramJSONObject = "ws_cdn_signal=302_redirect";
        }
        this.z = paramJSONObject;
        return true;
      }
      return bool1;
    }
    catch (Throwable paramJSONObject)
    {
      com.mato.sdk.c.b.f.b().a(paramJSONObject);
      bool1 = false;
    }
  }
  
  public final String b()
  {
    return a().b();
  }
  
  public final void b(int paramInt)
  {
    this.g.set(paramInt);
  }
  
  public final int c()
  {
    return this.g.get();
  }
  
  public final boolean d()
  {
    return this.g.get() == 2;
  }
  
  public final boolean e()
  {
    return this.g.get() == 3;
  }
  
  public final boolean f()
  {
    return this.h.get();
  }
  
  public final String g()
  {
    return this.k;
  }
  
  public final String h()
  {
    return this.m;
  }
  
  public final int i()
  {
    return this.o;
  }
  
  public final boolean j()
  {
    return this.p;
  }
  
  public final long k()
  {
    return this.f.get();
  }
  
  public final String l()
  {
    return this.q;
  }
  
  public final boolean m()
  {
    return this.r;
  }
  
  public final String n()
  {
    return this.t;
  }
  
  public final String o()
  {
    return this.u;
  }
  
  public final String p()
  {
    return this.v;
  }
  
  public final String q()
  {
    return this.w;
  }
  
  public final int r()
  {
    return this.x;
  }
  
  public final int s()
  {
    return this.j;
  }
  
  public final String t()
  {
    return this.z;
  }
  
  public final int u()
  {
    return this.n;
  }
  
  public final int v()
  {
    return this.l;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */