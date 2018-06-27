package com.megvii.zhimasdk.b.a.b.c;

import com.megvii.zhimasdk.b.a.ac;
import com.megvii.zhimasdk.b.a.ae;
import com.megvii.zhimasdk.b.a.b.a.a;
import com.megvii.zhimasdk.b.a.k.m;
import com.megvii.zhimasdk.b.a.l.f;
import java.net.URI;

public abstract class i
  extends b
  implements d, j
{
  private ac c;
  private URI d;
  private a e;
  
  public abstract String a();
  
  public void a(ac paramac)
  {
    this.c = paramac;
  }
  
  public void a(a parama)
  {
    this.e = parama;
  }
  
  public void a(URI paramURI)
  {
    this.d = paramURI;
  }
  
  public a a_()
  {
    return this.e;
  }
  
  public ac d()
  {
    if (this.c != null) {
      return this.c;
    }
    return f.b(g());
  }
  
  public ae h()
  {
    String str2 = a();
    ac localac = d();
    Object localObject = j();
    String str1 = null;
    if (localObject != null) {
      str1 = ((URI)localObject).toASCIIString();
    }
    if (str1 != null)
    {
      localObject = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      localObject = "/";
    }
    return new m(str2, (String)localObject, localac);
  }
  
  public URI j()
  {
    return this.d;
  }
  
  public String toString()
  {
    return a() + " " + j() + " " + d();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/b/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */