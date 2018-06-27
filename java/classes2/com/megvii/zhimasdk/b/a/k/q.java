package com.megvii.zhimasdk.b.a.k;

import com.megvii.zhimasdk.b.a.e;
import com.megvii.zhimasdk.b.a.h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q
  implements Serializable, Cloneable
{
  private final List<e> a = new ArrayList(16);
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(e parame)
  {
    if (parame == null) {
      return;
    }
    this.a.add(parame);
  }
  
  public void a(e[] paramArrayOfe)
  {
    a();
    if (paramArrayOfe == null) {
      return;
    }
    Collections.addAll(this.a, paramArrayOfe);
  }
  
  public e[] a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.size())
    {
      e locale = (e)this.a.get(i);
      if (locale.c().equalsIgnoreCase(paramString)) {
        localArrayList.add(locale);
      }
      i += 1;
    }
    return (e[])localArrayList.toArray(new e[localArrayList.size()]);
  }
  
  public e b(String paramString)
  {
    int i = 0;
    while (i < this.a.size())
    {
      e locale = (e)this.a.get(i);
      if (locale.c().equalsIgnoreCase(paramString)) {
        return locale;
      }
      i += 1;
    }
    return null;
  }
  
  public void b(e parame)
  {
    if (parame == null) {
      return;
    }
    this.a.remove(parame);
  }
  
  public e[] b()
  {
    return (e[])this.a.toArray(new e[this.a.size()]);
  }
  
  public h c()
  {
    return new k(this.a, null);
  }
  
  public void c(e parame)
  {
    if (parame == null) {
      return;
    }
    int i = 0;
    while (i < this.a.size())
    {
      if (((e)this.a.get(i)).c().equalsIgnoreCase(parame.c()))
      {
        this.a.set(i, parame);
        return;
      }
      i += 1;
    }
    this.a.add(parame);
  }
  
  public boolean c(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.a.size())
      {
        if (((e)this.a.get(i)).c().equalsIgnoreCase(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public h d(String paramString)
  {
    return new k(this.a, paramString);
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/k/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */