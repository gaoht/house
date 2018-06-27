package com.megvii.zhimasdk.b.a.i.b;

import com.megvii.zhimasdk.b.a.ab;
import com.megvii.zhimasdk.b.a.ac;
import com.megvii.zhimasdk.b.a.ae;
import com.megvii.zhimasdk.b.a.b.c.j;
import com.megvii.zhimasdk.b.a.k.m;
import com.megvii.zhimasdk.b.a.l.f;
import java.net.URI;
import java.net.URISyntaxException;

@Deprecated
public class v
  extends com.megvii.zhimasdk.b.a.k.a
  implements j
{
  private final com.megvii.zhimasdk.b.a.q c;
  private URI d;
  private String e;
  private ac f;
  private int g;
  
  public v(com.megvii.zhimasdk.b.a.q paramq)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramq, "HTTP request");
    this.c = paramq;
    a(paramq.g());
    a(paramq.e());
    if ((paramq instanceof j))
    {
      this.d = ((j)paramq).j();
      this.e = ((j)paramq).a();
      this.f = null;
    }
    for (;;)
    {
      this.g = 0;
      return;
      ae localae = paramq.h();
      try
      {
        this.d = new URI(localae.c());
        this.e = localae.a();
        this.f = paramq.d();
      }
      catch (URISyntaxException paramq)
      {
        throw new ab("Invalid request URI: " + localae.c(), paramq);
      }
    }
  }
  
  public String a()
  {
    return this.e;
  }
  
  public void a(URI paramURI)
  {
    this.d = paramURI;
  }
  
  public ac d()
  {
    if (this.f == null) {
      this.f = f.b(g());
    }
    return this.f;
  }
  
  public ae h()
  {
    String str3 = a();
    ac localac = d();
    String str1 = null;
    if (this.d != null) {
      str1 = this.d.toASCIIString();
    }
    String str2;
    if (str1 != null)
    {
      str2 = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      str2 = "/";
    }
    return new m(str3, str2, localac);
  }
  
  public boolean i()
  {
    return false;
  }
  
  public URI j()
  {
    return this.d;
  }
  
  public boolean k()
  {
    return true;
  }
  
  public void l()
  {
    this.a.a();
    a(this.c.e());
  }
  
  public com.megvii.zhimasdk.b.a.q m()
  {
    return this.c;
  }
  
  public int n()
  {
    return this.g;
  }
  
  public void o()
  {
    this.g += 1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/b/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */