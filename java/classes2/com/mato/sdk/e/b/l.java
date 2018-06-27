package com.mato.sdk.e.b;

import com.mato.sdk.b.e;
import com.mato.sdk.b.g;
import com.mato.sdk.b.l.a;
import com.mato.sdk.c.c.b;
import com.mato.sdk.g.b;
import com.mato.sdk.g.j;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class l
  implements l.a<com.mato.sdk.c.a>
{
  private static final String a = g.b("NetDiagnosisReportor");
  private final com.mato.sdk.b.l<com.mato.sdk.c.a> b;
  private final Map<String, String> c;
  
  public l(String paramString)
  {
    long l = System.currentTimeMillis();
    Object localObject = com.mato.sdk.proxy.a.a();
    String str1 = j.a(((e)localObject).e(), "80dee591a993ea01e51a766134f7827d");
    localObject = ((e)localObject).j();
    String str2 = e.c();
    HashMap localHashMap = new HashMap();
    localHashMap.put("packageName", localObject);
    localHashMap.put("timestamp", String.valueOf(l));
    localHashMap.put("imei", str1);
    localHashMap.put("platform", str2);
    localHashMap.put("mid", paramString);
    localHashMap.put("version", "1");
    localHashMap.toString();
    this.c = localHashMap;
    this.b = new com.mato.sdk.b.l();
    this.b.a(this);
  }
  
  private static void b() {}
  
  private static Map<String, String> c(String paramString)
  {
    long l = System.currentTimeMillis();
    Object localObject = com.mato.sdk.proxy.a.a();
    String str1 = j.a(((e)localObject).e(), "80dee591a993ea01e51a766134f7827d");
    localObject = ((e)localObject).j();
    String str2 = e.c();
    HashMap localHashMap = new HashMap();
    localHashMap.put("packageName", localObject);
    localHashMap.put("timestamp", String.valueOf(l));
    localHashMap.put("imei", str1);
    localHashMap.put("platform", str2);
    localHashMap.put("mid", paramString);
    localHashMap.put("version", "1");
    localHashMap.toString();
    return localHashMap;
  }
  
  public final void a(String paramString)
  {
    this.b.a(paramString);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3)
  {
    b(paramString1, "wspx-diagnose-one", "netdiagnosis.gzip");
    b(paramString2, "wspx-diagnose-two", "accesslog.gzip");
    b(paramString3, "wspx-diagnose-three", "debug.gzip");
  }
  
  public final void b(String paramString)
  {
    b(paramString, "wspx-diagnose-one", "netdiagnosis.gzip");
  }
  
  public final void b(String paramString1, String paramString2, final String paramString3)
  {
    paramString1 = b.c(new File(paramString1));
    if (paramString1 == null) {
      return;
    }
    final com.mato.sdk.c.a locala = new com.mato.sdk.c.a();
    locala.b(paramString2);
    locala.c("gzip");
    locala.a(paramString3);
    locala.a(this.c);
    locala.a(paramString1);
    locala.a(new c.b()
    {
      public final void a()
      {
        l.a();
        String str = paramString3;
        l.a(l.this).a(paramString3);
      }
      
      public final void b()
      {
        l.a();
        l.a(l.this).a(paramString3, locala, 6, 120000);
      }
    });
    locala.a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */