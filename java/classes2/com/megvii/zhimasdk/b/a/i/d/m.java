package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f.b;
import com.megvii.zhimasdk.b.a.f.l;
import com.megvii.zhimasdk.b.a.k.u;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class m
  extends p
{
  private static final String[] a = { "EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z" };
  private final String[] b;
  
  public m()
  {
    this(null, n.a.a);
  }
  
  public m(String[] paramArrayOfString)
  {
    this(paramArrayOfString, n.a.a);
  }
  
  public m(String[] paramArrayOfString, n.a parama)
  {
    if (paramArrayOfString != null) {}
    for (this.b = ((String[])paramArrayOfString.clone());; this.b = a) {
      switch (2.a[parama.ordinal()])
      {
      default: 
        throw new RuntimeException("Unknown security level");
      }
    }
    a("path", new i());
    for (;;)
    {
      a("domain", new f());
      a("max-age", new h());
      a("secure", new j());
      a("comment", new e());
      a("expires", new g(this.b));
      a("version", new o());
      return;
      a("path", new i()
      {
        public void a(b paramAnonymousb, com.megvii.zhimasdk.b.a.f.e paramAnonymouse) {}
      });
    }
  }
  
  private static boolean b(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("\"")) && (paramString.endsWith("\""));
  }
  
  public int a()
  {
    return 0;
  }
  
  public List<b> a(com.megvii.zhimasdk.b.a.e parame, com.megvii.zhimasdk.b.a.f.e parame1)
  {
    a.a(parame, "Header");
    a.a(parame1, "Cookie origin");
    if (!parame.c().equalsIgnoreCase("Set-Cookie")) {
      throw new l("Unrecognized cookie header '" + parame.toString() + "'");
    }
    Object localObject1 = parame.e();
    int m = localObject1.length;
    int j = 0;
    int i = 0;
    int k = 0;
    Object localObject2;
    while (j < m)
    {
      localObject2 = localObject1[j];
      if (((com.megvii.zhimasdk.b.a.f)localObject2).a("version") != null) {
        k = 1;
      }
      if (((com.megvii.zhimasdk.b.a.f)localObject2).a("expires") != null) {
        i = 1;
      }
      j += 1;
    }
    if ((i != 0) || (k == 0))
    {
      localObject2 = t.a;
      if ((parame instanceof com.megvii.zhimasdk.b.a.d)) {
        localObject1 = ((com.megvii.zhimasdk.b.a.d)parame).a();
      }
      for (parame = new u(((com.megvii.zhimasdk.b.a.d)parame).b(), ((com.megvii.zhimasdk.b.a.o.d)localObject1).c());; parame = new u(0, ((com.megvii.zhimasdk.b.a.o.d)localObject1).c()))
      {
        localObject1 = ((t)localObject2).a((com.megvii.zhimasdk.b.a.o.d)localObject1, parame);
        parame = ((com.megvii.zhimasdk.b.a.f)localObject1).a();
        localObject2 = ((com.megvii.zhimasdk.b.a.f)localObject1).b();
        if ((parame != null) && (!com.megvii.zhimasdk.b.a.o.h.b(parame))) {
          break;
        }
        throw new l("Cookie name may not be empty");
        parame = parame.d();
        if (parame == null) {
          throw new l("Header value is null");
        }
        localObject1 = new com.megvii.zhimasdk.b.a.o.d(parame.length());
        ((com.megvii.zhimasdk.b.a.o.d)localObject1).a(parame);
      }
      parame = new c(parame, (String)localObject2);
      parame.e(a(parame1));
      parame.d(b(parame1));
      parame1 = ((com.megvii.zhimasdk.b.a.f)localObject1).c();
      j = parame1.length - 1;
      while (j >= 0)
      {
        localObject1 = parame1[j];
        localObject2 = ((y)localObject1).a().toLowerCase(Locale.ENGLISH);
        parame.a((String)localObject2, ((y)localObject1).b());
        localObject2 = a((String)localObject2);
        if (localObject2 != null) {
          ((com.megvii.zhimasdk.b.a.f.c)localObject2).a(parame, ((y)localObject1).b());
        }
        j -= 1;
      }
      if (i != 0) {
        parame.a(0);
      }
      return Collections.singletonList(parame);
    }
    return a((com.megvii.zhimasdk.b.a.f[])localObject1, parame1);
  }
  
  public List<com.megvii.zhimasdk.b.a.e> a(List<b> paramList)
  {
    a.a(paramList, "List of cookies");
    com.megvii.zhimasdk.b.a.o.d locald = new com.megvii.zhimasdk.b.a.o.d(paramList.size() * 20);
    locald.a("Cookie");
    locald.a(": ");
    int i = 0;
    if (i < paramList.size())
    {
      b localb = (b)paramList.get(i);
      if (i > 0) {
        locald.a("; ");
      }
      String str1 = localb.a();
      String str2 = localb.b();
      if ((localb.h() > 0) && (!b(str2))) {
        com.megvii.zhimasdk.b.a.k.e.b.a(locald, new com.megvii.zhimasdk.b.a.k.c(str1, str2), false);
      }
      for (;;)
      {
        i += 1;
        break;
        locald.a(str1);
        locald.a("=");
        if (str2 != null) {
          locald.a(str2);
        }
      }
    }
    paramList = new ArrayList(1);
    paramList.add(new com.megvii.zhimasdk.b.a.k.p(locald));
    return paramList;
  }
  
  public com.megvii.zhimasdk.b.a.e b()
  {
    return null;
  }
  
  public String toString()
  {
    return "compatibility";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */