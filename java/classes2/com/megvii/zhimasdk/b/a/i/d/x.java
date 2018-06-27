package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f.b;
import com.megvii.zhimasdk.b.a.f.f;
import com.megvii.zhimasdk.b.a.f.l;
import com.megvii.zhimasdk.b.a.o.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class x
  extends p
{
  private static final f a = new f();
  private static final String[] b = { "EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy" };
  private final String[] c;
  private final boolean d;
  
  public x()
  {
    this(null, false);
  }
  
  public x(String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramArrayOfString != null) {}
    for (this.c = ((String[])paramArrayOfString.clone());; this.c = b)
    {
      this.d = paramBoolean;
      a("version", new z());
      a("path", new i());
      a("domain", new w());
      a("max-age", new h());
      a("secure", new j());
      a("comment", new e());
      a("expires", new g(this.c));
      return;
    }
  }
  
  private List<com.megvii.zhimasdk.b.a.e> b(List<b> paramList)
  {
    Object localObject = paramList.iterator();
    int i = Integer.MAX_VALUE;
    b localb;
    if (((Iterator)localObject).hasNext())
    {
      localb = (b)((Iterator)localObject).next();
      if (localb.h() >= i) {
        break label165;
      }
      i = localb.h();
    }
    label165:
    for (;;)
    {
      break;
      localObject = new d(paramList.size() * 40);
      ((d)localObject).a("Cookie");
      ((d)localObject).a(": ");
      ((d)localObject).a("$Version=");
      ((d)localObject).a(Integer.toString(i));
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localb = (b)paramList.next();
        ((d)localObject).a("; ");
        a((d)localObject, localb, i);
      }
      paramList = new ArrayList(1);
      paramList.add(new com.megvii.zhimasdk.b.a.k.p((d)localObject));
      return paramList;
    }
  }
  
  private List<com.megvii.zhimasdk.b.a.e> c(List<b> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      int i = localb.h();
      d locald = new d(40);
      locald.a("Cookie: ");
      locald.a("$Version=");
      locald.a(Integer.toString(i));
      locald.a("; ");
      a(locald, localb, i);
      localArrayList.add(new com.megvii.zhimasdk.b.a.k.p(locald));
    }
    return localArrayList;
  }
  
  public int a()
  {
    return 1;
  }
  
  public List<b> a(com.megvii.zhimasdk.b.a.e parame, com.megvii.zhimasdk.b.a.f.e parame1)
  {
    com.megvii.zhimasdk.b.a.o.a.a(parame, "Header");
    com.megvii.zhimasdk.b.a.o.a.a(parame1, "Cookie origin");
    if (!parame.c().equalsIgnoreCase("Set-Cookie")) {
      throw new l("Unrecognized cookie header '" + parame.toString() + "'");
    }
    return a(parame.e(), parame1);
  }
  
  public List<com.megvii.zhimasdk.b.a.e> a(List<b> paramList)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramList, "List of cookies");
    Object localObject = paramList;
    if (paramList.size() > 1)
    {
      localObject = new ArrayList(paramList);
      Collections.sort((List)localObject, a);
    }
    if (this.d) {
      return b((List)localObject);
    }
    return c((List)localObject);
  }
  
  public void a(b paramb, com.megvii.zhimasdk.b.a.f.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramb, "Cookie");
    String str = paramb.a();
    if (str.indexOf(' ') != -1) {
      throw new com.megvii.zhimasdk.b.a.f.g("Cookie name may not contain blanks");
    }
    if (str.startsWith("$")) {
      throw new com.megvii.zhimasdk.b.a.f.g("Cookie name may not start with $");
    }
    super.a(paramb, parame);
  }
  
  protected void a(d paramd, b paramb, int paramInt)
  {
    a(paramd, paramb.a(), paramb.b(), paramInt);
    if ((paramb.e() != null) && ((paramb instanceof com.megvii.zhimasdk.b.a.f.a)) && (((com.megvii.zhimasdk.b.a.f.a)paramb).b("path")))
    {
      paramd.a("; ");
      a(paramd, "$Path", paramb.e(), paramInt);
    }
    if ((paramb.d() != null) && ((paramb instanceof com.megvii.zhimasdk.b.a.f.a)) && (((com.megvii.zhimasdk.b.a.f.a)paramb).b("domain")))
    {
      paramd.a("; ");
      a(paramd, "$Domain", paramb.d(), paramInt);
    }
  }
  
  protected void a(d paramd, String paramString1, String paramString2, int paramInt)
  {
    paramd.a(paramString1);
    paramd.a("=");
    if (paramString2 != null)
    {
      if (paramInt > 0)
      {
        paramd.a('"');
        paramd.a(paramString2);
        paramd.a('"');
      }
    }
    else {
      return;
    }
    paramd.a(paramString2);
  }
  
  public com.megvii.zhimasdk.b.a.e b()
  {
    return null;
  }
  
  public String toString()
  {
    return "rfc2109";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */