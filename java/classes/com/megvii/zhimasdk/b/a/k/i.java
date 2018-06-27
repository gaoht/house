package com.megvii.zhimasdk.b.a.k;

import com.megvii.zhimasdk.b.a.ac;
import com.megvii.zhimasdk.b.a.ae;
import com.megvii.zhimasdk.b.a.af;
import com.megvii.zhimasdk.b.a.e;
import com.megvii.zhimasdk.b.a.o.a;

public class i
  implements s
{
  @Deprecated
  public static final i a = new i();
  public static final i b = new i();
  
  protected int a(ac paramac)
  {
    return paramac.a().length() + 4;
  }
  
  protected com.megvii.zhimasdk.b.a.o.d a(com.megvii.zhimasdk.b.a.o.d paramd)
  {
    if (paramd != null)
    {
      paramd.a();
      return paramd;
    }
    return new com.megvii.zhimasdk.b.a.o.d(64);
  }
  
  public com.megvii.zhimasdk.b.a.o.d a(com.megvii.zhimasdk.b.a.o.d paramd, ac paramac)
  {
    a.a(paramac, "Protocol version");
    int i = a(paramac);
    if (paramd == null) {
      paramd = new com.megvii.zhimasdk.b.a.o.d(i);
    }
    for (;;)
    {
      paramd.a(paramac.a());
      paramd.a('/');
      paramd.a(Integer.toString(paramac.b()));
      paramd.a('.');
      paramd.a(Integer.toString(paramac.c()));
      return paramd;
      paramd.b(i);
    }
  }
  
  public com.megvii.zhimasdk.b.a.o.d a(com.megvii.zhimasdk.b.a.o.d paramd, ae paramae)
  {
    a.a(paramae, "Request line");
    paramd = a(paramd);
    b(paramd, paramae);
    return paramd;
  }
  
  public com.megvii.zhimasdk.b.a.o.d a(com.megvii.zhimasdk.b.a.o.d paramd, af paramaf)
  {
    a.a(paramaf, "Status line");
    paramd = a(paramd);
    b(paramd, paramaf);
    return paramd;
  }
  
  public com.megvii.zhimasdk.b.a.o.d a(com.megvii.zhimasdk.b.a.o.d paramd, e parame)
  {
    a.a(parame, "Header");
    if ((parame instanceof com.megvii.zhimasdk.b.a.d)) {
      return ((com.megvii.zhimasdk.b.a.d)parame).a();
    }
    paramd = a(paramd);
    b(paramd, parame);
    return paramd;
  }
  
  protected void b(com.megvii.zhimasdk.b.a.o.d paramd, ae paramae)
  {
    String str1 = paramae.a();
    String str2 = paramae.c();
    paramd.b(str1.length() + 1 + str2.length() + 1 + a(paramae.b()));
    paramd.a(str1);
    paramd.a(' ');
    paramd.a(str2);
    paramd.a(' ');
    a(paramd, paramae.b());
  }
  
  protected void b(com.megvii.zhimasdk.b.a.o.d paramd, af paramaf)
  {
    int j = a(paramaf.a()) + 1 + 3 + 1;
    String str = paramaf.c();
    int i = j;
    if (str != null) {
      i = j + str.length();
    }
    paramd.b(i);
    a(paramd, paramaf.a());
    paramd.a(' ');
    paramd.a(Integer.toString(paramaf.b()));
    paramd.a(' ');
    if (str != null) {
      paramd.a(str);
    }
  }
  
  protected void b(com.megvii.zhimasdk.b.a.o.d paramd, e parame)
  {
    String str = parame.c();
    parame = parame.d();
    int j = str.length() + 2;
    int i = j;
    if (parame != null) {
      i = j + parame.length();
    }
    paramd.b(i);
    paramd.a(str);
    paramd.a(": ");
    if (parame != null) {
      paramd.a(parame);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/k/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */