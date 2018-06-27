package com.megvii.zhimasdk.b.a.i.b;

import com.megvii.zhimasdk.b.a.a.g;
import com.megvii.zhimasdk.b.a.n;
import com.megvii.zhimasdk.b.a.s;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

@Deprecated
class b
  implements com.megvii.zhimasdk.b.a.b.c
{
  public com.megvii.zhimasdk.b.a.h.b a;
  private final com.megvii.zhimasdk.b.a.b.b b;
  
  private boolean a(com.megvii.zhimasdk.b.a.a.c paramc)
  {
    if ((paramc == null) || (!paramc.d())) {}
    do
    {
      return false;
      paramc = paramc.a();
    } while ((!paramc.equalsIgnoreCase("Basic")) && (!paramc.equalsIgnoreCase("Digest")));
    return true;
  }
  
  public com.megvii.zhimasdk.b.a.b.b a()
  {
    return this.b;
  }
  
  public Queue<com.megvii.zhimasdk.b.a.a.a> a(Map<String, com.megvii.zhimasdk.b.a.e> paramMap, n paramn, s params, com.megvii.zhimasdk.b.a.n.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramMap, "Map of auth challenges");
    com.megvii.zhimasdk.b.a.o.a.a(paramn, "Host");
    com.megvii.zhimasdk.b.a.o.a.a(params, "HTTP response");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP context");
    LinkedList localLinkedList = new LinkedList();
    com.megvii.zhimasdk.b.a.b.i locali = (com.megvii.zhimasdk.b.a.b.i)parame.a("http.auth.credentials-provider");
    if (locali == null)
    {
      this.a.a("Credentials provider not set in the context");
      return localLinkedList;
    }
    try
    {
      params = this.b.a(paramMap, params, parame);
      params.a((com.megvii.zhimasdk.b.a.e)paramMap.get(params.a().toLowerCase(Locale.ENGLISH)));
      paramMap = locali.a(new g(paramn.a(), paramn.b(), params.b(), params.a()));
      if (paramMap != null) {
        localLinkedList.add(new com.megvii.zhimasdk.b.a.a.a(params, paramMap));
      }
      return localLinkedList;
    }
    catch (com.megvii.zhimasdk.b.a.a.i paramMap)
    {
      if (this.a.c()) {
        this.a.c(paramMap.getMessage(), paramMap);
      }
    }
    return localLinkedList;
  }
  
  public void a(n paramn, com.megvii.zhimasdk.b.a.a.c paramc, com.megvii.zhimasdk.b.a.n.e parame)
  {
    com.megvii.zhimasdk.b.a.b.a locala = (com.megvii.zhimasdk.b.a.b.a)parame.a("http.auth.auth-cache");
    if (a(paramc))
    {
      Object localObject = locala;
      if (locala == null)
      {
        localObject = new d();
        parame.a("http.auth.auth-cache", localObject);
      }
      if (this.a.a()) {
        this.a.a("Caching '" + paramc.a() + "' auth scheme for " + paramn);
      }
      ((com.megvii.zhimasdk.b.a.b.a)localObject).a(paramn, paramc);
    }
  }
  
  public boolean a(n paramn, s params, com.megvii.zhimasdk.b.a.n.e parame)
  {
    return this.b.a(params, parame);
  }
  
  public Map<String, com.megvii.zhimasdk.b.a.e> b(n paramn, s params, com.megvii.zhimasdk.b.a.n.e parame)
  {
    return this.b.b(params, parame);
  }
  
  public void b(n paramn, com.megvii.zhimasdk.b.a.a.c paramc, com.megvii.zhimasdk.b.a.n.e parame)
  {
    parame = (com.megvii.zhimasdk.b.a.b.a)parame.a("http.auth.auth-cache");
    if (parame == null) {
      return;
    }
    if (this.a.a()) {
      this.a.a("Removing from cache '" + paramc.a() + "' auth scheme for " + paramn);
    }
    parame.b(paramn);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */