package com.mato.sdk.c;

import android.text.TextUtils;
import com.mato.sdk.c.b.f;
import com.mato.sdk.f.a;
import com.mato.sdk.f.c;
import com.mato.sdk.f.d;
import com.mato.sdk.f.e;
import com.mato.sdk.f.g;
import com.mato.sdk.f.h;
import com.mato.sdk.f.h.a;
import com.mato.sdk.f.h.b;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

public abstract class b
  extends e<d>
{
  private static String b = "http://mlog.chinanetcenter.com/file";
  private static String[] f = { "58.220.6.46", "58.220.6.47", "58.220.6.48", "58.220.6.49", "58.220.6.50", "58.220.6.51" };
  private final String c;
  private final String d;
  private final h.b<d> e;
  private a g;
  
  public b(String paramString1, String paramString2, h.b<d> paramb, h.a parama)
  {
    super(1, b, parama);
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramb;
  }
  
  public static void a(String paramString)
  {
    b = paramString;
    if (TextUtils.isEmpty(paramString)) {
      b = "http://mlog.chinanetcenter.com/file";
    }
  }
  
  private void b(d paramd)
  {
    if (this.e != null) {
      this.e.a(paramd);
    }
  }
  
  protected final h<d> a(d paramd)
  {
    long l = this.a;
    int i = paramd.a;
    String str = paramd.b;
    return h.a(paramd);
  }
  
  public final boolean a(e<?> parame)
  {
    if (parame == null) {
      return false;
    }
    if ((parame instanceof b))
    {
      b localb = (b)parame;
      if (this.c == localb.c) {
        return super.a(parame);
      }
    }
    return false;
  }
  
  public final a b()
  {
    if (this.g == null) {
      this.g = new a("dsp", f);
    }
    return this.g;
  }
  
  public final g c()
  {
    c localc = new c();
    try
    {
      localc.a("type", this.c);
      localc.a("codec", this.d);
      Map localMap = d();
      if (localMap != null) {
        localc.a(localMap);
      }
      localc.a("filename", e(), "application/octet-stream", f());
      return localc;
    }
    catch (Exception localException)
    {
      f.b().a(localException);
    }
    return null;
  }
  
  protected Map<String, String> d()
  {
    return Collections.emptyMap();
  }
  
  protected abstract String e();
  
  protected abstract InputStream f();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */