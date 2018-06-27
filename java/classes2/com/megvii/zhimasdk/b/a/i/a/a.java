package com.megvii.zhimasdk.b.a.i.a;

import com.megvii.zhimasdk.b.a.a.k;
import com.megvii.zhimasdk.b.a.a.l;
import com.megvii.zhimasdk.b.a.a.m;
import com.megvii.zhimasdk.b.a.a.o;
import com.megvii.zhimasdk.b.a.q;
import java.util.Locale;

public abstract class a
  implements l
{
  private k a;
  
  public com.megvii.zhimasdk.b.a.e a(m paramm, q paramq, com.megvii.zhimasdk.b.a.n.e parame)
  {
    return a(paramm, paramq);
  }
  
  public void a(com.megvii.zhimasdk.b.a.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(parame, "Header");
    Object localObject = parame.c();
    int i;
    if (((String)localObject).equalsIgnoreCase("WWW-Authenticate"))
    {
      this.a = k.a;
      if (!(parame instanceof com.megvii.zhimasdk.b.a.d)) {
        break label137;
      }
      localObject = ((com.megvii.zhimasdk.b.a.d)parame).a();
      i = ((com.megvii.zhimasdk.b.a.d)parame).b();
      parame = (com.megvii.zhimasdk.b.a.e)localObject;
    }
    for (;;)
    {
      if ((i >= parame.c()) || (!com.megvii.zhimasdk.b.a.n.d.a(parame.a(i)))) {
        break label184;
      }
      i += 1;
      continue;
      if (((String)localObject).equalsIgnoreCase("Proxy-Authenticate"))
      {
        this.a = k.b;
        break;
      }
      throw new o("Unexpected header name: " + (String)localObject);
      label137:
      localObject = parame.d();
      if (localObject == null) {
        throw new o("Header value is null");
      }
      parame = new com.megvii.zhimasdk.b.a.o.d(((String)localObject).length());
      parame.a((String)localObject);
      i = 0;
    }
    label184:
    int j = i;
    while ((j < parame.c()) && (!com.megvii.zhimasdk.b.a.n.d.a(parame.a(j)))) {
      j += 1;
    }
    localObject = parame.a(i, j);
    if (!((String)localObject).equalsIgnoreCase(a())) {
      throw new o("Invalid scheme identifier: " + (String)localObject);
    }
    a(parame, j, parame.c());
  }
  
  protected abstract void a(com.megvii.zhimasdk.b.a.o.d paramd, int paramInt1, int paramInt2);
  
  public boolean e()
  {
    return (this.a != null) && (this.a == k.b);
  }
  
  public String toString()
  {
    String str = a();
    if (str != null) {
      return str.toUpperCase(Locale.ENGLISH);
    }
    return super.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */