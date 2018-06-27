package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f;
import com.megvii.zhimasdk.b.a.f.b;
import com.megvii.zhimasdk.b.a.f.c;
import com.megvii.zhimasdk.b.a.f.l;
import com.megvii.zhimasdk.b.a.f.m;
import com.megvii.zhimasdk.b.a.k.p;
import com.megvii.zhimasdk.b.a.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ae
  extends x
{
  public ae()
  {
    this(null, false);
  }
  
  public ae(String[] paramArrayOfString, boolean paramBoolean)
  {
    super(paramArrayOfString, paramBoolean);
    a("domain", new ac());
    a("port", new ad());
    a("commenturl", new aa());
    a("discard", new ab());
    a("version", new ag());
  }
  
  private List<b> b(f[] paramArrayOff, com.megvii.zhimasdk.b.a.f.e parame)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOff.length);
    int k = paramArrayOff.length;
    int i = 0;
    while (i < k)
    {
      Object localObject2 = paramArrayOff[i];
      Object localObject1 = ((f)localObject2).a();
      Object localObject3 = ((f)localObject2).b();
      if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
        throw new l("Cookie name may not be empty");
      }
      localObject1 = new d((String)localObject1, (String)localObject3);
      ((d)localObject1).e(a(parame));
      ((d)localObject1).d(b(parame));
      ((d)localObject1).a(new int[] { parame.c() });
      localObject2 = ((f)localObject2).c();
      localObject3 = new HashMap(localObject2.length);
      int j = localObject2.length - 1;
      Object localObject4;
      while (j >= 0)
      {
        localObject4 = localObject2[j];
        ((Map)localObject3).put(((y)localObject4).a().toLowerCase(Locale.ENGLISH), localObject4);
        j -= 1;
      }
      localObject2 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (y)((Map.Entry)((Iterator)localObject2).next()).getValue();
        localObject4 = ((y)localObject3).a().toLowerCase(Locale.ENGLISH);
        ((d)localObject1).a((String)localObject4, ((y)localObject3).b());
        localObject4 = a((String)localObject4);
        if (localObject4 != null) {
          ((c)localObject4).a((m)localObject1, ((y)localObject3).b());
        }
      }
      localArrayList.add(localObject1);
      i += 1;
    }
    return localArrayList;
  }
  
  private static com.megvii.zhimasdk.b.a.f.e c(com.megvii.zhimasdk.b.a.f.e parame)
  {
    int k = 0;
    String str = parame.a();
    int i = 0;
    if (i < str.length())
    {
      int m = str.charAt(i);
      j = k;
      if (m != 46) {
        if (m != 58) {
          break label96;
        }
      }
    }
    for (int j = k;; j = 1)
    {
      com.megvii.zhimasdk.b.a.f.e locale = parame;
      if (j != 0) {
        locale = new com.megvii.zhimasdk.b.a.f.e(str + ".local", parame.c(), parame.b(), parame.d());
      }
      return locale;
      label96:
      i += 1;
      break;
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public List<b> a(com.megvii.zhimasdk.b.a.e parame, com.megvii.zhimasdk.b.a.f.e parame1)
  {
    com.megvii.zhimasdk.b.a.o.a.a(parame, "Header");
    com.megvii.zhimasdk.b.a.o.a.a(parame1, "Cookie origin");
    if (!parame.c().equalsIgnoreCase("Set-Cookie2")) {
      throw new l("Unrecognized cookie header '" + parame.toString() + "'");
    }
    return b(parame.e(), c(parame1));
  }
  
  protected List<b> a(f[] paramArrayOff, com.megvii.zhimasdk.b.a.f.e parame)
  {
    return b(paramArrayOff, c(parame));
  }
  
  public void a(b paramb, com.megvii.zhimasdk.b.a.f.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramb, "Cookie");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "Cookie origin");
    super.a(paramb, c(parame));
  }
  
  protected void a(com.megvii.zhimasdk.b.a.o.d paramd, b paramb, int paramInt)
  {
    super.a(paramd, paramb, paramInt);
    if ((paramb instanceof com.megvii.zhimasdk.b.a.f.a))
    {
      String str = ((com.megvii.zhimasdk.b.a.f.a)paramb).a("port");
      if (str != null)
      {
        paramd.a("; $Port");
        paramd.a("=\"");
        if (str.trim().length() > 0)
        {
          paramb = paramb.f();
          if (paramb != null)
          {
            int i = paramb.length;
            paramInt = 0;
            while (paramInt < i)
            {
              if (paramInt > 0) {
                paramd.a(",");
              }
              paramd.a(Integer.toString(paramb[paramInt]));
              paramInt += 1;
            }
          }
        }
        paramd.a("\"");
      }
    }
  }
  
  public com.megvii.zhimasdk.b.a.e b()
  {
    com.megvii.zhimasdk.b.a.o.d locald = new com.megvii.zhimasdk.b.a.o.d(40);
    locald.a("Cookie2");
    locald.a(": ");
    locald.a("$Version=");
    locald.a(Integer.toString(a()));
    return new p(locald);
  }
  
  public boolean b(b paramb, com.megvii.zhimasdk.b.a.f.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramb, "Cookie");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "Cookie origin");
    return super.b(paramb, c(parame));
  }
  
  public String toString()
  {
    return "rfc2965";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */