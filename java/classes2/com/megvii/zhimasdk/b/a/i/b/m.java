package com.megvii.zhimasdk.b.a.i.b;

import com.megvii.zhimasdk.b.a.ab;
import com.megvii.zhimasdk.b.a.ae;
import com.megvii.zhimasdk.b.a.af;
import com.megvii.zhimasdk.b.a.b.c.f;
import com.megvii.zhimasdk.b.a.b.c.g;
import com.megvii.zhimasdk.b.a.b.c.j;
import com.megvii.zhimasdk.b.a.b.c.k;
import com.megvii.zhimasdk.b.a.b.f.c;
import com.megvii.zhimasdk.b.a.b.f.d;
import com.megvii.zhimasdk.b.a.b.o;
import com.megvii.zhimasdk.b.a.n;
import com.megvii.zhimasdk.b.a.o.h;
import com.megvii.zhimasdk.b.a.q;
import com.megvii.zhimasdk.b.a.s;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

public class m
  implements o
{
  public static final m b = new m();
  private static final String[] c = { "GET", "HEAD" };
  public com.megvii.zhimasdk.b.a.h.b a = new com.megvii.zhimasdk.b.a.h.b(getClass());
  
  protected URI a(String paramString)
  {
    try
    {
      Object localObject = new c(new URI(paramString).normalize());
      String str = ((c)localObject).c();
      if (str != null) {
        ((c)localObject).c(str.toLowerCase(Locale.ENGLISH));
      }
      if (h.a(((c)localObject).d())) {
        ((c)localObject).d("/");
      }
      localObject = ((c)localObject).a();
      return (URI)localObject;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      throw new ab("Invalid redirect URI: " + paramString, localURISyntaxException);
    }
  }
  
  public boolean a(q paramq, s params, com.megvii.zhimasdk.b.a.n.e parame)
  {
    boolean bool2 = true;
    com.megvii.zhimasdk.b.a.o.a.a(paramq, "HTTP request");
    com.megvii.zhimasdk.b.a.o.a.a(params, "HTTP response");
    int i = params.a().b();
    paramq = paramq.h().a();
    params = params.c("location");
    boolean bool1 = bool2;
    switch (i)
    {
    case 304: 
    case 305: 
    case 306: 
    default: 
      bool1 = false;
    case 303: 
    case 302: 
      do
      {
        return bool1;
        if (!b(paramq)) {
          break;
        }
        bool1 = bool2;
      } while (params != null);
      return false;
    }
    return b(paramq);
  }
  
  public j b(q paramq, s params, com.megvii.zhimasdk.b.a.n.e parame)
  {
    parame = c(paramq, params, parame);
    String str = paramq.h().a();
    if (str.equalsIgnoreCase("HEAD")) {
      return new g(parame);
    }
    if (str.equalsIgnoreCase("GET")) {
      return new f(parame);
    }
    if (params.a().b() == 307) {
      return k.a(paramq).a(parame).a();
    }
    return new f(parame);
  }
  
  protected boolean b(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = c;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public URI c(q paramq, s params, com.megvii.zhimasdk.b.a.n.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramq, "HTTP request");
    com.megvii.zhimasdk.b.a.o.a.a(params, "HTTP response");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP context");
    Object localObject1 = com.megvii.zhimasdk.b.a.b.e.a.a(parame);
    Object localObject2 = params.c("location");
    if (localObject2 == null) {
      throw new ab("Received redirect response " + params.a() + " but no location header");
    }
    params = ((com.megvii.zhimasdk.b.a.e)localObject2).d();
    if (this.a.a()) {
      this.a.a("Redirect requested to location '" + params + "'");
    }
    localObject2 = ((com.megvii.zhimasdk.b.a.b.e.a)localObject1).k();
    params = a(params);
    try
    {
      if (params.isAbsolute()) {
        break label337;
      }
      if (!((com.megvii.zhimasdk.b.a.b.a.a)localObject2).b()) {
        throw new ab("Relative redirect location '" + params + "' not allowed");
      }
    }
    catch (URISyntaxException paramq)
    {
      throw new ab(paramq.getMessage(), paramq);
    }
    n localn = ((com.megvii.zhimasdk.b.a.b.e.a)localObject1).o();
    com.megvii.zhimasdk.b.a.o.b.a(localn, "Target host");
    label337:
    for (paramq = d.a(d.a(new URI(paramq.h().c()), localn, false), params);; paramq = params)
    {
      localObject1 = (u)((com.megvii.zhimasdk.b.a.b.e.a)localObject1).a("http.protocol.redirect-locations");
      params = (s)localObject1;
      if (localObject1 == null)
      {
        params = new u();
        parame.a("http.protocol.redirect-locations", params);
      }
      if ((!((com.megvii.zhimasdk.b.a.b.a.a)localObject2).c()) && (params.a(paramq))) {
        throw new com.megvii.zhimasdk.b.a.b.e("Circular redirect to '" + paramq + "'");
      }
      params.b(paramq);
      return paramq;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/b/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */