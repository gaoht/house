package com.megvii.zhimasdk.b.a.b.c;

import com.megvii.zhimasdk.b.a.ac;
import com.megvii.zhimasdk.b.a.ae;
import com.megvii.zhimasdk.b.a.b.f.c;
import com.megvii.zhimasdk.b.a.l;
import com.megvii.zhimasdk.b.a.y;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;

public class k
{
  private String a;
  private ac b;
  private URI c;
  private com.megvii.zhimasdk.b.a.k.q d;
  private com.megvii.zhimasdk.b.a.k e;
  private LinkedList<y> f;
  private com.megvii.zhimasdk.b.a.b.a.a g;
  
  k()
  {
    this(null);
  }
  
  k(String paramString)
  {
    this.a = paramString;
  }
  
  public static k a(com.megvii.zhimasdk.b.a.q paramq)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramq, "HTTP request");
    return new k().b(paramq);
  }
  
  private k b(com.megvii.zhimasdk.b.a.q paramq)
  {
    if (paramq == null) {
      return this;
    }
    this.a = paramq.h().a();
    this.b = paramq.h().b();
    if ((paramq instanceof j))
    {
      this.c = ((j)paramq).j();
      if (this.d == null) {
        this.d = new com.megvii.zhimasdk.b.a.k.q();
      }
      this.d.a();
      this.d.a(paramq.e());
      if (!(paramq instanceof l)) {
        break label162;
      }
      this.e = ((l)paramq).c();
      label114:
      if (!(paramq instanceof d)) {
        break label170;
      }
    }
    label162:
    label170:
    for (this.g = ((d)paramq).a_();; this.g = null)
    {
      this.f = null;
      return this;
      this.c = URI.create(paramq.h().c());
      break;
      this.e = null;
      break label114;
    }
  }
  
  public j a()
  {
    Object localObject1;
    Object localObject2;
    if (this.c != null)
    {
      localObject1 = this.c;
      localObject2 = this.e;
      if ((this.f == null) || (this.f.isEmpty())) {
        break label193;
      }
      if ((localObject2 != null) || ((!"POST".equalsIgnoreCase(this.a)) && (!"PUT".equalsIgnoreCase(this.a)))) {
        break label143;
      }
      localObject2 = new com.megvii.zhimasdk.b.a.b.b.a(this.f, com.megvii.zhimasdk.b.a.n.d.a);
    }
    label77:
    label143:
    label193:
    for (;;)
    {
      if (localObject2 == null) {}
      a locala;
      for (localObject2 = new b(this.a);; localObject2 = locala)
      {
        ((i)localObject2).a(this.b);
        ((i)localObject2).a((URI)localObject1);
        if (this.d != null) {
          ((i)localObject2).a(this.d.b());
        }
        ((i)localObject2).a(this.g);
        return (j)localObject2;
        localObject1 = URI.create("/");
        break;
        try
        {
          URI localURI = new c((URI)localObject1).a(this.f).a();
          localObject1 = localURI;
        }
        catch (URISyntaxException localURISyntaxException) {}
        break label77;
        locala = new a(this.a);
        locala.a((com.megvii.zhimasdk.b.a.k)localObject2);
      }
    }
  }
  
  public k a(URI paramURI)
  {
    this.c = paramURI;
    return this;
  }
  
  static class a
    extends e
  {
    private final String c;
    
    a(String paramString)
    {
      this.c = paramString;
    }
    
    public String a()
    {
      return this.c;
    }
  }
  
  static class b
    extends i
  {
    private final String c;
    
    b(String paramString)
    {
      this.c = paramString;
    }
    
    public String a()
    {
      return this.c;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/b/c/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */