package com.mato.sdk.e.d;

import android.os.Build;
import com.mato.sdk.c.b.f;
import com.mato.sdk.f.c;
import com.mato.sdk.f.d;
import com.mato.sdk.f.h.a;
import com.mato.sdk.f.h.b;
import com.mato.sdk.g.j;
import com.mato.sdk.proxy.Proxy;
import com.mato.sdk.proxy.a;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

final class e
  extends com.mato.sdk.f.e<d>
{
  private static final String b = com.mato.sdk.b.g.b("");
  private final h.b<d> c;
  private final Map<String, String> d;
  private final InputStream e;
  private final String f;
  
  e(a parama)
  {
    super(1, a.a(parama), a.b(parama));
    this.c = a.c(parama);
    this.e = a.d(parama);
    this.d = a.e(parama);
    this.f = a.f(parama);
  }
  
  private void b(d paramd)
  {
    if (this.c != null) {
      this.c.a(paramd);
    }
  }
  
  protected final com.mato.sdk.f.h<d> a(d paramd)
  {
    long l = this.a;
    int i = paramd.a;
    String str = paramd.b;
    return com.mato.sdk.f.h.a(paramd);
  }
  
  public final com.mato.sdk.f.g c()
  {
    c localc = new c();
    try
    {
      localc.a(this.d);
      localc.a("file", this.f, "application/octet-stream", this.e);
      return localc;
    }
    catch (Throwable localThrowable)
    {
      f.b().a(localThrowable);
    }
    return null;
  }
  
  public static final class a
  {
    private String a;
    private String b;
    private h.a c;
    private h.b<d> d;
    private String e;
    private InputStream f;
    
    private Map<String, String> b()
    {
      Object localObject = a.a();
      long l = System.currentTimeMillis();
      String str1 = j.a(((com.mato.sdk.b.e)localObject).e(), "80dee591a993ea01e51a766134f7827d");
      String str2 = ((com.mato.sdk.b.e)localObject).j();
      String str3 = Proxy.getVersion();
      String str4 = com.mato.sdk.b.e.c();
      String str5 = Build.MANUFACTURER + " " + Build.MODEL;
      String str6 = a.b().h().a();
      localObject = j.a(((com.mato.sdk.b.e)localObject).d(), "80dee591a993ea01e51a766134f7827d");
      HashMap localHashMap = new HashMap();
      localHashMap.put("timestamp", String.valueOf(l));
      localHashMap.put("imei", str1);
      localHashMap.put("packageName", str2);
      localHashMap.put("sdkVersion", str3);
      localHashMap.put("platform", str4);
      localHashMap.put("model", str5);
      localHashMap.put("networkType", str6);
      localHashMap.put("imsi", localObject);
      localHashMap.put("codec", "gzip");
      localHashMap.put("type", "mqs-client");
      localHashMap.put("testIds", this.b);
      return localHashMap;
    }
    
    public final a a(h.a parama)
    {
      this.c = parama;
      return this;
    }
    
    public final a a(h.b<d> paramb)
    {
      this.d = paramb;
      return this;
    }
    
    public final a a(InputStream paramInputStream)
    {
      this.f = paramInputStream;
      return this;
    }
    
    public final a a(String paramString)
    {
      this.a = paramString;
      return this;
    }
    
    public final e a()
    {
      return new e(this);
    }
    
    public final a b(String paramString)
    {
      this.e = paramString;
      return this;
    }
    
    public final a c(String paramString)
    {
      this.b = paramString;
      return this;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */