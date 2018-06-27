package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f;
import com.megvii.zhimasdk.b.a.f.e;
import com.megvii.zhimasdk.b.a.f.l;
import com.megvii.zhimasdk.b.a.f.m;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class p
  extends b
{
  protected static String a(e parame)
  {
    parame = parame.b();
    int j = parame.lastIndexOf('/');
    if (j >= 0)
    {
      int i = j;
      if (j == 0) {
        i = 1;
      }
      return parame.substring(0, i);
    }
    return parame;
  }
  
  protected static String b(e parame)
  {
    return parame.a();
  }
  
  protected List<com.megvii.zhimasdk.b.a.f.b> a(f[] paramArrayOff, e parame)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOff.length);
    int k = paramArrayOff.length;
    int i = 0;
    while (i < k)
    {
      Object localObject2 = paramArrayOff[i];
      Object localObject1 = ((f)localObject2).a();
      String str = ((f)localObject2).b();
      if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
        throw new l("Cookie name may not be empty");
      }
      localObject1 = new c((String)localObject1, str);
      ((c)localObject1).e(a(parame));
      ((c)localObject1).d(b(parame));
      localObject2 = ((f)localObject2).c();
      int j = localObject2.length - 1;
      while (j >= 0)
      {
        str = localObject2[j];
        Object localObject3 = str.a().toLowerCase(Locale.ENGLISH);
        ((c)localObject1).a((String)localObject3, str.b());
        localObject3 = a((String)localObject3);
        if (localObject3 != null) {
          ((com.megvii.zhimasdk.b.a.f.c)localObject3).a((m)localObject1, str.b());
        }
        j -= 1;
      }
      localArrayList.add(localObject1);
      i += 1;
    }
    return localArrayList;
  }
  
  public void a(com.megvii.zhimasdk.b.a.f.b paramb, e parame)
  {
    a.a(paramb, "Cookie");
    a.a(parame, "Cookie origin");
    Iterator localIterator = c().iterator();
    while (localIterator.hasNext()) {
      ((com.megvii.zhimasdk.b.a.f.c)localIterator.next()).a(paramb, parame);
    }
  }
  
  public boolean b(com.megvii.zhimasdk.b.a.f.b paramb, e parame)
  {
    a.a(paramb, "Cookie");
    a.a(parame, "Cookie origin");
    Iterator localIterator = c().iterator();
    while (localIterator.hasNext()) {
      if (!((com.megvii.zhimasdk.b.a.f.c)localIterator.next()).b(paramb, parame)) {
        return false;
      }
    }
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */