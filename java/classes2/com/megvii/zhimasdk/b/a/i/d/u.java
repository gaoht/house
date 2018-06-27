package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f;
import com.megvii.zhimasdk.b.a.f.b;
import com.megvii.zhimasdk.b.a.f.l;
import com.megvii.zhimasdk.b.a.o.a;
import java.util.ArrayList;
import java.util.List;

public class u
  extends p
{
  private final String[] a;
  
  public u()
  {
    this(null);
  }
  
  public u(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null) {}
    for (this.a = ((String[])paramArrayOfString.clone());; this.a = new String[] { "EEE, dd-MMM-yy HH:mm:ss z" })
    {
      a("path", new i());
      a("domain", new s());
      a("secure", new j());
      a("comment", new e());
      a("expires", new g(this.a));
      return;
    }
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
    t localt = t.a;
    com.megvii.zhimasdk.b.a.o.d locald;
    if ((parame instanceof com.megvii.zhimasdk.b.a.d)) {
      locald = ((com.megvii.zhimasdk.b.a.d)parame).a();
    }
    for (parame = new com.megvii.zhimasdk.b.a.k.u(((com.megvii.zhimasdk.b.a.d)parame).b(), locald.c());; parame = new com.megvii.zhimasdk.b.a.k.u(0, locald.c()))
    {
      return a(new f[] { localt.a(locald, parame) }, parame1);
      parame = parame.d();
      if (parame == null) {
        throw new l("Header value is null");
      }
      locald = new com.megvii.zhimasdk.b.a.o.d(parame.length());
      locald.a(parame);
    }
  }
  
  public List<com.megvii.zhimasdk.b.a.e> a(List<b> paramList)
  {
    a.a(paramList, "List of cookies");
    com.megvii.zhimasdk.b.a.o.d locald = new com.megvii.zhimasdk.b.a.o.d(paramList.size() * 20);
    locald.a("Cookie");
    locald.a(": ");
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (b)paramList.get(i);
      if (i > 0) {
        locald.a("; ");
      }
      locald.a(((b)localObject).a());
      localObject = ((b)localObject).b();
      if (localObject != null)
      {
        locald.a("=");
        locald.a((String)localObject);
      }
      i += 1;
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
    return "netscape";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */