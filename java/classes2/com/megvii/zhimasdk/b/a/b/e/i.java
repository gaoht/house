package com.megvii.zhimasdk.b.a.b.e;

import com.megvii.zhimasdk.b.a.f.l;
import com.megvii.zhimasdk.b.a.s;
import com.megvii.zhimasdk.b.a.u;
import java.util.Iterator;
import java.util.List;

public class i
  implements u
{
  public com.megvii.zhimasdk.b.a.h.b a = new com.megvii.zhimasdk.b.a.h.b(getClass());
  
  private static String a(com.megvii.zhimasdk.b.a.f.b paramb)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramb.a());
    localStringBuilder.append("=\"");
    String str2 = paramb.b();
    if (str2 != null)
    {
      String str1 = str2;
      if (str2.length() > 100) {
        str1 = str2.substring(0, 100) + "...";
      }
      localStringBuilder.append(str1);
    }
    localStringBuilder.append("\"");
    localStringBuilder.append(", version:");
    localStringBuilder.append(Integer.toString(paramb.h()));
    localStringBuilder.append(", domain:");
    localStringBuilder.append(paramb.d());
    localStringBuilder.append(", path:");
    localStringBuilder.append(paramb.e());
    localStringBuilder.append(", expiry:");
    localStringBuilder.append(paramb.c());
    return localStringBuilder.toString();
  }
  
  private void a(com.megvii.zhimasdk.b.a.h paramh, com.megvii.zhimasdk.b.a.f.h paramh1, com.megvii.zhimasdk.b.a.f.e parame, com.megvii.zhimasdk.b.a.b.h paramh2)
  {
    while (paramh.hasNext())
    {
      com.megvii.zhimasdk.b.a.e locale = paramh.a();
      try
      {
        Iterator localIterator = paramh1.a(locale, parame).iterator();
        while (localIterator.hasNext())
        {
          com.megvii.zhimasdk.b.a.f.b localb = (com.megvii.zhimasdk.b.a.f.b)localIterator.next();
          try
          {
            paramh1.a(localb, parame);
            paramh2.a(localb);
            if (!this.a.a()) {
              continue;
            }
            this.a.a("Cookie accepted [" + a(localb) + "]");
          }
          catch (l locall2) {}
          if (this.a.c()) {
            this.a.c("Cookie rejected [" + a(localb) + "] " + locall2.getMessage());
          }
        }
        if (!this.a.c()) {
          continue;
        }
      }
      catch (l locall1) {}
      this.a.c("Invalid cookie header: \"" + locale + "\". " + locall1.getMessage());
    }
  }
  
  public void a(s params, com.megvii.zhimasdk.b.a.n.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(params, "HTTP request");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP context");
    Object localObject = a.a(parame);
    parame = ((a)localObject).c();
    if (parame == null) {
      this.a.a("Cookie spec not specified in HTTP context");
    }
    com.megvii.zhimasdk.b.a.b.h localh;
    do
    {
      return;
      localh = ((a)localObject).b();
      if (localh == null)
      {
        this.a.a("Cookie store not specified in HTTP context");
        return;
      }
      localObject = ((a)localObject).d();
      if (localObject == null)
      {
        this.a.a("Cookie origin not specified in HTTP context");
        return;
      }
      a(params.e("Set-Cookie"), parame, (com.megvii.zhimasdk.b.a.f.e)localObject, localh);
    } while (parame.a() <= 0);
    a(params.e("Set-Cookie2"), parame, (com.megvii.zhimasdk.b.a.f.e)localObject, localh);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/b/e/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */