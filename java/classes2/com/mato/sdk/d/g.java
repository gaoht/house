package com.mato.sdk.d;

import com.mato.sdk.c.b.f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
  extends a
{
  private static final String A = "manual";
  private static final String B = "auto";
  private static final String C = "antiHijackConfigs";
  private static final String D = "hijackCheckPolicy";
  private static final String E = "debug";
  private static final String F = "accesslogToUser";
  private static final String G = "rejectUrlRegex";
  private static final String H = "multiplatforms";
  private static final String I = "passUrlRegex";
  private static final String J = "bypassDnsHijack";
  private static final String K = "speedTestX";
  private static final String a = com.mato.sdk.b.g.b("");
  private static String b = "maabiz1.chinanetcenter.com";
  private static int c = 39900;
  private static int d = 6666;
  private static String e = "mauth.chinanetcenter.com";
  private static String f = "http://mauth.chinanetcenter.com";
  private static boolean r = false;
  private static final String w = "enableSDK";
  private static final String x = "netChangeAuth";
  private static final String y = "precacheConfig";
  private static final String z = "netDiagnosisConfig";
  private h g;
  private h h;
  private final AtomicBoolean i = new AtomicBoolean(true);
  private final AtomicBoolean j = new AtomicBoolean(false);
  private l k = null;
  private List<b> l = null;
  private List<j> m = null;
  private e n = null;
  private boolean o = false;
  private String p;
  private boolean q = false;
  private k s = null;
  private String t = "";
  private boolean u = true;
  private m v = null;
  
  public g()
  {
    a(new i(1));
    a(new i(2));
    a(new i(3));
    a(new i(4));
  }
  
  private l L()
  {
    return this.k;
  }
  
  private static void a(List<j> paramList, JSONArray paramJSONArray)
  {
    int i2 = paramJSONArray.length();
    int i1 = 0;
    while (i1 < i2)
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i1);
      if (localJSONObject != null)
      {
        j localj = new j();
        localj.a(localJSONObject);
        paramList.add(localj);
      }
      i1 += 1;
    }
  }
  
  public static g b(String paramString)
  {
    try
    {
      g localg = new g();
      localg.a(new JSONObject(paramString));
      return localg;
    }
    catch (Throwable paramString)
    {
      f.b().a(paramString);
    }
    return null;
  }
  
  private void b(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("multiplatforms");
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {
      return;
    }
    this.m = new ArrayList();
    a(this.m, paramJSONObject);
  }
  
  private void b(boolean paramBoolean)
  {
    this.i.getAndSet(paramBoolean);
  }
  
  private void c(JSONArray paramJSONArray)
  {
    this.l = new ArrayList();
    int i2 = paramJSONArray.length();
    int i1 = 0;
    while (i1 < i2)
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i1);
      if (localJSONObject != null)
      {
        b localb = new b();
        localb.a(localJSONObject);
        this.l.add(localb);
      }
      i1 += 1;
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("manual");
    if (localJSONObject != null) {
      this.g = h.a(localJSONObject);
    }
    paramJSONObject = paramJSONObject.optJSONObject("auto");
    if (paramJSONObject != null) {
      this.h = h.a(paramJSONObject);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    this.j.getAndSet(paramBoolean);
  }
  
  public final boolean A()
  {
    return this.i.get();
  }
  
  public final boolean B()
  {
    return this.j.get();
  }
  
  public final List<b> C()
  {
    return this.l;
  }
  
  public final List<j> D()
  {
    return this.m;
  }
  
  public final e E()
  {
    return this.n;
  }
  
  public final h F()
  {
    return this.h;
  }
  
  public final h G()
  {
    return this.g;
  }
  
  public final k H()
  {
    return this.s;
  }
  
  public final m I()
  {
    return this.v;
  }
  
  public final String J()
  {
    return this.t;
  }
  
  public final boolean K()
  {
    return this.u;
  }
  
  public final boolean a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    boolean bool = paramJSONObject.optBoolean("enableSDK", this.i.get());
    this.i.getAndSet(bool);
    bool = paramJSONObject.optBoolean("netChangeAuth", this.j.get());
    this.j.getAndSet(bool);
    this.k = l.a(paramJSONObject);
    Object localObject = paramJSONObject.optJSONObject("precacheConfig");
    if (localObject != null) {
      this.s = k.a((JSONObject)localObject);
    }
    localObject = paramJSONObject.optJSONObject("speedTestX");
    if (localObject != null) {
      this.v = m.a((JSONObject)localObject);
    }
    localObject = paramJSONObject.optJSONObject("netDiagnosisConfig");
    JSONObject localJSONObject;
    if (localObject != null)
    {
      localJSONObject = ((JSONObject)localObject).optJSONObject("manual");
      if (localJSONObject != null) {
        this.g = h.a(localJSONObject);
      }
      localObject = ((JSONObject)localObject).optJSONObject("auto");
      if (localObject != null) {
        this.h = h.a((JSONObject)localObject);
      }
    }
    localObject = paramJSONObject.optJSONArray("antiHijackConfigs");
    if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {}
    for (int i1 = 1; i1 != 0; i1 = 0)
    {
      this.l = new ArrayList();
      int i2 = ((JSONArray)localObject).length();
      i1 = 0;
      while (i1 < i2)
      {
        localJSONObject = ((JSONArray)localObject).optJSONObject(i1);
        if (localJSONObject != null)
        {
          b localb = new b();
          localb.a(localJSONObject);
          this.l.add(localb);
        }
        i1 += 1;
      }
    }
    localObject = paramJSONObject.optJSONObject("optimizationPolicy");
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optJSONArray("multiplatforms");
      if ((localObject != null) && (((JSONArray)localObject).length() != 0)) {
        break label407;
      }
    }
    for (;;)
    {
      localObject = paramJSONObject.optJSONObject("hijackCheckPolicy");
      if (localObject != null) {
        this.n = e.a((JSONObject)localObject);
      }
      this.o = paramJSONObject.optBoolean("debug", false);
      this.q = paramJSONObject.optBoolean("accesslogToUser", false);
      localObject = a(paramJSONObject, "rejectUrlRegex", true);
      if (localObject != null) {
        this.p = ((String)localObject);
      }
      localObject = a(paramJSONObject, "passUrlRegex", true);
      if (localObject != null) {
        this.t = ((String)localObject);
      }
      this.u = paramJSONObject.optBoolean("bypassDnsHijack", this.u);
      return true;
      label407:
      this.m = new ArrayList();
      a(this.m, (JSONArray)localObject);
    }
  }
  
  public final boolean x()
  {
    return this.q;
  }
  
  public final boolean y()
  {
    return this.o;
  }
  
  public final String z()
  {
    return this.p;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */