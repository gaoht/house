package com.megvii.zhimasdk.b.a.b.e;

import com.megvii.zhimasdk.b.a.ae;
import com.megvii.zhimasdk.b.a.m;
import com.megvii.zhimasdk.b.a.q;
import com.megvii.zhimasdk.b.a.r;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class b
  implements r
{
  public com.megvii.zhimasdk.b.a.h.b a = new com.megvii.zhimasdk.b.a.h.b(getClass());
  
  public void a(q paramq, com.megvii.zhimasdk.b.a.n.e parame)
  {
    int j = 0;
    com.megvii.zhimasdk.b.a.o.a.a(paramq, "HTTP request");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP context");
    if (paramq.h().a().equalsIgnoreCase("CONNECT")) {
      return;
    }
    Object localObject4 = a.a(parame);
    Object localObject3 = ((a)localObject4).b();
    if (localObject3 == null)
    {
      this.a.a("Cookie store not specified in HTTP context");
      return;
    }
    Object localObject5 = ((a)localObject4).e();
    if (localObject5 == null)
    {
      this.a.a("CookieSpec registry not specified in HTTP context");
      return;
    }
    com.megvii.zhimasdk.b.a.n localn = ((a)localObject4).o();
    if (localn == null)
    {
      this.a.a("Target host not set in the context");
      return;
    }
    Object localObject6 = ((a)localObject4).a();
    if (localObject6 == null)
    {
      this.a.a("Connection route not set in the context");
      return;
    }
    Object localObject2 = ((a)localObject4).k().a();
    if (localObject2 == null) {
      localObject2 = "best-match";
    }
    for (;;)
    {
      if (this.a.a()) {
        this.a.a("CookieSpec selected: " + (String)localObject2);
      }
      Object localObject1;
      label217:
      String str2;
      int i;
      if ((paramq instanceof com.megvii.zhimasdk.b.a.b.c.j))
      {
        localObject1 = ((com.megvii.zhimasdk.b.a.b.c.j)paramq).j();
        if (localObject1 == null) {
          break label361;
        }
        localObject1 = ((URI)localObject1).getPath();
        str2 = localn.a();
        k = localn.b();
        i = k;
        if (k < 0) {
          i = ((com.megvii.zhimasdk.b.a.e.b.e)localObject6).a().b();
        }
        if (i < 0) {
          break label367;
        }
        label254:
        if (com.megvii.zhimasdk.b.a.o.h.a((CharSequence)localObject1)) {
          break label372;
        }
      }
      String str1;
      for (;;)
      {
        localObject1 = new com.megvii.zhimasdk.b.a.f.e(str2, i, (String)localObject1, ((com.megvii.zhimasdk.b.a.e.b.e)localObject6).g());
        localObject5 = (com.megvii.zhimasdk.b.a.f.j)((com.megvii.zhimasdk.b.a.d.a)localObject5).b((String)localObject2);
        if (localObject5 != null) {
          break label379;
        }
        throw new m("Unsupported cookie policy: " + (String)localObject2);
        try
        {
          localObject1 = new URI(paramq.h().c());
        }
        catch (URISyntaxException localURISyntaxException)
        {
          str1 = null;
        }
        break;
        label361:
        str1 = null;
        break label217;
        label367:
        i = 0;
        break label254;
        label372:
        str1 = "/";
      }
      label379:
      localObject2 = ((com.megvii.zhimasdk.b.a.f.j)localObject5).a((com.megvii.zhimasdk.b.a.n.e)localObject4);
      localObject5 = new ArrayList(((com.megvii.zhimasdk.b.a.b.h)localObject3).a());
      localObject3 = new ArrayList();
      localObject4 = new Date();
      localObject5 = ((List)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (com.megvii.zhimasdk.b.a.f.b)((Iterator)localObject5).next();
        if (!((com.megvii.zhimasdk.b.a.f.b)localObject6).a((Date)localObject4))
        {
          if (((com.megvii.zhimasdk.b.a.f.h)localObject2).b((com.megvii.zhimasdk.b.a.f.b)localObject6, str1))
          {
            if (this.a.a()) {
              this.a.a("Cookie " + localObject6 + " match " + str1);
            }
            ((List)localObject3).add(localObject6);
          }
        }
        else if (this.a.a()) {
          this.a.a("Cookie " + localObject6 + " expired");
        }
      }
      if (!((List)localObject3).isEmpty())
      {
        localObject4 = ((com.megvii.zhimasdk.b.a.f.h)localObject2).a((List)localObject3).iterator();
        while (((Iterator)localObject4).hasNext()) {
          paramq.a((com.megvii.zhimasdk.b.a.e)((Iterator)localObject4).next());
        }
      }
      int k = ((com.megvii.zhimasdk.b.a.f.h)localObject2).a();
      if (k > 0)
      {
        localObject3 = ((List)localObject3).iterator();
        for (i = j; ((Iterator)localObject3).hasNext(); i = 1)
        {
          label667:
          localObject4 = (com.megvii.zhimasdk.b.a.f.b)((Iterator)localObject3).next();
          if ((k == ((com.megvii.zhimasdk.b.a.f.b)localObject4).h()) && ((localObject4 instanceof com.megvii.zhimasdk.b.a.f.n))) {
            break label667;
          }
        }
        if (i != 0)
        {
          localObject3 = ((com.megvii.zhimasdk.b.a.f.h)localObject2).b();
          if (localObject3 != null) {
            paramq.a((com.megvii.zhimasdk.b.a.e)localObject3);
          }
        }
      }
      parame.a("http.cookie-spec", localObject2);
      parame.a("http.cookie-origin", str1);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/b/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */