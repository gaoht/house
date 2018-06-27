package com.megvii.zhimasdk.b.a.i.b;

import com.megvii.zhimasdk.b.a.a.g;
import com.megvii.zhimasdk.b.a.a.m;
import com.megvii.zhimasdk.b.a.a.o;
import com.megvii.zhimasdk.b.a.af;
import com.megvii.zhimasdk.b.a.b.i;
import com.megvii.zhimasdk.b.a.h.b;
import com.megvii.zhimasdk.b.a.n;
import com.megvii.zhimasdk.b.a.s;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

abstract class c
  implements com.megvii.zhimasdk.b.a.b.c
{
  private static final List<String> b = Collections.unmodifiableList(Arrays.asList(new String[] { "negotiate", "Kerberos", "NTLM", "Digest", "Basic" }));
  public b a = new b(getClass());
  private final int c;
  private final String d;
  
  c(int paramInt, String paramString)
  {
    this.c = paramInt;
    this.d = paramString;
  }
  
  abstract Collection<String> a(com.megvii.zhimasdk.b.a.b.a.a parama);
  
  public Queue<com.megvii.zhimasdk.b.a.a.a> a(Map<String, com.megvii.zhimasdk.b.a.e> paramMap, n paramn, s params, com.megvii.zhimasdk.b.a.n.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramMap, "Map of auth challenges");
    com.megvii.zhimasdk.b.a.o.a.a(paramn, "Host");
    com.megvii.zhimasdk.b.a.o.a.a(params, "HTTP response");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP context");
    params = com.megvii.zhimasdk.b.a.b.e.a.a(parame);
    LinkedList localLinkedList = new LinkedList();
    com.megvii.zhimasdk.b.a.d.a locala = params.f();
    if (locala == null)
    {
      this.a.a("Auth scheme registry not set in the context");
      return localLinkedList;
    }
    i locali = params.g();
    if (locali == null)
    {
      this.a.a("Credentials provider not set in the context");
      return localLinkedList;
    }
    Object localObject1 = a(params.k());
    params = (s)localObject1;
    if (localObject1 == null) {
      params = b;
    }
    if (this.a.a()) {
      this.a.a("Authentication schemes in the order of preference: " + params);
    }
    params = params.iterator();
    while (params.hasNext())
    {
      Object localObject2 = (String)params.next();
      localObject1 = (com.megvii.zhimasdk.b.a.e)paramMap.get(((String)localObject2).toLowerCase(Locale.ENGLISH));
      if (localObject1 != null)
      {
        com.megvii.zhimasdk.b.a.a.e locale = (com.megvii.zhimasdk.b.a.a.e)locala.b((String)localObject2);
        if (locale == null)
        {
          if (this.a.c()) {
            this.a.c("Authentication scheme " + (String)localObject2 + " not supported");
          }
        }
        else
        {
          localObject2 = locale.a(parame);
          ((com.megvii.zhimasdk.b.a.a.c)localObject2).a((com.megvii.zhimasdk.b.a.e)localObject1);
          localObject1 = locali.a(new g(paramn.a(), paramn.b(), ((com.megvii.zhimasdk.b.a.a.c)localObject2).b(), ((com.megvii.zhimasdk.b.a.a.c)localObject2).a()));
          if (localObject1 != null) {
            localLinkedList.add(new com.megvii.zhimasdk.b.a.a.a((com.megvii.zhimasdk.b.a.a.c)localObject2, (m)localObject1));
          }
        }
      }
      else if (this.a.a())
      {
        this.a.a("Challenge for " + (String)localObject2 + " authentication scheme not available");
      }
    }
    return localLinkedList;
  }
  
  public void a(n paramn, com.megvii.zhimasdk.b.a.a.c paramc, com.megvii.zhimasdk.b.a.n.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramn, "Host");
    com.megvii.zhimasdk.b.a.o.a.a(paramc, "Auth scheme");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP context");
    com.megvii.zhimasdk.b.a.b.e.a locala1 = com.megvii.zhimasdk.b.a.b.e.a.a(parame);
    if (a(paramc))
    {
      com.megvii.zhimasdk.b.a.b.a locala = locala1.h();
      parame = locala;
      if (locala == null)
      {
        parame = new d();
        locala1.a(parame);
      }
      if (this.a.a()) {
        this.a.a("Caching '" + paramc.a() + "' auth scheme for " + paramn);
      }
      parame.a(paramn, paramc);
    }
  }
  
  protected boolean a(com.megvii.zhimasdk.b.a.a.c paramc)
  {
    if ((paramc == null) || (!paramc.d())) {}
    do
    {
      return false;
      paramc = paramc.a();
    } while ((!paramc.equalsIgnoreCase("Basic")) && (!paramc.equalsIgnoreCase("Digest")));
    return true;
  }
  
  public boolean a(n paramn, s params, com.megvii.zhimasdk.b.a.n.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(params, "HTTP response");
    return params.a().b() == this.c;
  }
  
  public Map<String, com.megvii.zhimasdk.b.a.e> b(n paramn, s params, com.megvii.zhimasdk.b.a.n.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(params, "HTTP response");
    params = params.b(this.d);
    parame = new HashMap(params.length);
    int m = params.length;
    int j = 0;
    while (j < m)
    {
      Object localObject = params[j];
      int i;
      if ((localObject instanceof com.megvii.zhimasdk.b.a.d))
      {
        paramn = ((com.megvii.zhimasdk.b.a.d)localObject).a();
        i = ((com.megvii.zhimasdk.b.a.d)localObject).b();
      }
      while ((i < paramn.c()) && (com.megvii.zhimasdk.b.a.n.d.a(paramn.a(i))))
      {
        i += 1;
        continue;
        String str = ((com.megvii.zhimasdk.b.a.e)localObject).d();
        if (str == null) {
          throw new o("Header value is null");
        }
        paramn = new com.megvii.zhimasdk.b.a.o.d(str.length());
        paramn.a(str);
        i = 0;
      }
      int k = i;
      while ((k < paramn.c()) && (!com.megvii.zhimasdk.b.a.n.d.a(paramn.a(k)))) {
        k += 1;
      }
      parame.put(paramn.a(i, k).toLowerCase(Locale.ENGLISH), localObject);
      j += 1;
    }
    return parame;
  }
  
  public void b(n paramn, com.megvii.zhimasdk.b.a.a.c paramc, com.megvii.zhimasdk.b.a.n.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramn, "Host");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP context");
    paramc = com.megvii.zhimasdk.b.a.b.e.a.a(parame).h();
    if (paramc != null)
    {
      if (this.a.a()) {
        this.a.a("Clearing cached auth scheme for " + paramn);
      }
      paramc.b(paramn);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */