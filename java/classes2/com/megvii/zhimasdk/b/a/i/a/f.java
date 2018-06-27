package com.megvii.zhimasdk.b.a.i.a;

import com.megvii.zhimasdk.b.a.a.h;
import com.megvii.zhimasdk.b.a.a.o;
import com.megvii.zhimasdk.b.a.n;
import com.megvii.zhimasdk.b.a.s;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

public class f
{
  public com.megvii.zhimasdk.b.a.h.b a;
  
  public f()
  {
    this(null);
  }
  
  public f(com.megvii.zhimasdk.b.a.h.b paramb)
  {
    if (paramb != null) {}
    for (;;)
    {
      this.a = paramb;
      return;
      paramb = new com.megvii.zhimasdk.b.a.h.b(getClass());
    }
  }
  
  public boolean a(n paramn, s params, com.megvii.zhimasdk.b.a.b.c paramc, h paramh, com.megvii.zhimasdk.b.a.n.e parame)
  {
    if (paramc.a(paramn, params, parame))
    {
      this.a.a("Authentication required");
      if (paramh.b() == com.megvii.zhimasdk.b.a.a.b.e) {
        paramc.b(paramn, paramh.c(), parame);
      }
      return true;
    }
    switch (1.a[paramh.b().ordinal()])
    {
    default: 
      paramh.a(com.megvii.zhimasdk.b.a.a.b.a);
    }
    for (;;)
    {
      return false;
      this.a.a("Authentication succeeded");
      paramh.a(com.megvii.zhimasdk.b.a.a.b.e);
      paramc.a(paramn, paramh.c(), parame);
    }
  }
  
  public boolean b(n paramn, s params, com.megvii.zhimasdk.b.a.b.c paramc, h paramh, com.megvii.zhimasdk.b.a.n.e parame)
  {
    for (;;)
    {
      Map localMap;
      com.megvii.zhimasdk.b.a.a.c localc;
      try
      {
        if (this.a.a()) {
          this.a.a(paramn.e() + " requested authentication");
        }
        localMap = paramc.b(paramn, params, parame);
        if (localMap.isEmpty())
        {
          this.a.a("Response contains no authentication challenges");
          return false;
        }
        localc = paramh.c();
        switch (1.a[paramh.b().ordinal()])
        {
        case 3: 
          paramn = paramc.a(localMap, paramn, params, parame);
          if ((paramn == null) || (paramn.isEmpty())) {
            break label415;
          }
          if (this.a.a()) {
            this.a.a("Selected authentication options: " + paramn);
          }
          paramh.a(com.megvii.zhimasdk.b.a.a.b.b);
          paramh.a(paramn);
          return true;
        }
      }
      catch (o paramn)
      {
        if (!this.a.c()) {
          continue;
        }
        this.a.c("Malformed challenge: " + paramn.getMessage());
        paramh.a();
        return false;
      }
      paramh.a();
      continue;
      if (localc == null)
      {
        this.a.a("Auth scheme is null");
        paramc.b(paramn, null, parame);
        paramh.a();
        paramh.a(com.megvii.zhimasdk.b.a.a.b.d);
        return false;
      }
      if (localc != null)
      {
        com.megvii.zhimasdk.b.a.e locale = (com.megvii.zhimasdk.b.a.e)localMap.get(localc.a().toLowerCase(Locale.ENGLISH));
        if (locale != null)
        {
          this.a.a("Authorization challenge processed");
          localc.a(locale);
          if (localc.d())
          {
            this.a.a("Authentication failed");
            paramc.b(paramn, paramh.c(), parame);
            paramh.a();
            paramh.a(com.megvii.zhimasdk.b.a.a.b.d);
            return false;
          }
          paramh.a(com.megvii.zhimasdk.b.a.a.b.c);
          return true;
        }
        paramh.a();
        continue;
        label415:
        return false;
      }
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */