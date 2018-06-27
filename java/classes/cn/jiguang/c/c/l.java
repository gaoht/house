package cn.jiguang.c.c;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class l
  implements Serializable
{
  private static final String[] z;
  private List a = new ArrayList(1);
  private short b = 0;
  private short c = 0;
  
  static
  {
    String[] arrayOfString = new String[6];
    int j = 0;
    Object localObject2 = "L-+!CZh,!TMh&!E\036%):RVh:<B[<";
    int i = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int k = arrayOfChar.length;
    int i1 = 0;
    int m = 0;
    int i3 = i;
    localObject2 = arrayOfChar;
    int i4 = j;
    Object localObject3 = localObject1;
    int n = k;
    Object localObject4;
    int i2;
    if (k <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i2 = i;
      label68:
      n = m;
      label71:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 49;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label71;
      }
      i1 = n;
      n = k;
      localObject3 = localObject4;
      i4 = j;
      localObject2 = localObject1;
      i3 = i2;
      i2 = i3;
      localObject1 = localObject2;
      j = i4;
      localObject4 = localObject3;
      k = n;
      m = i1;
      if (n > i1) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i3)
      {
      default: 
        localObject3[i4] = localObject1;
        j = 1;
        localObject2 = "L:;+E\036!;nTS8<7";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "\0365";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "Eh";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "\036;!)B\004h";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "E-%>EG5";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 62;
        continue;
        i = 72;
        continue;
        i = 72;
        continue;
        i = 78;
      }
    }
  }
  
  public l() {}
  
  public l(m paramm)
  {
    this();
    b(paramm);
  }
  
  private static String a(Iterator paramIterator)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    while (paramIterator.hasNext())
    {
      m localm = (m)paramIterator.next();
      localStringBuffer.append("[");
      localStringBuffer.append(localm.a());
      localStringBuffer.append("]");
      if (paramIterator.hasNext()) {
        localStringBuffer.append(" ");
      }
    }
    return localStringBuffer.toString();
  }
  
  private Iterator a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    for (;;)
    {
      int k;
      try
      {
        k = this.a.size();
        int j;
        Object localObject1;
        if (paramBoolean1)
        {
          j = k - this.b;
          if (j == 0)
          {
            localObject1 = Collections.EMPTY_LIST.iterator();
            return (Iterator)localObject1;
          }
        }
        else
        {
          j = this.b;
          continue;
          localObject1 = new ArrayList(j);
          if (paramBoolean1)
          {
            ((List)localObject1).addAll(this.a.subList(i, j));
            if (i != 0) {
              ((List)localObject1).addAll(this.a.subList(0, i));
            }
            label115:
            localObject1 = ((List)localObject1).iterator();
            continue;
            if (this.c >= j) {
              this.c = 0;
            }
            i = this.c;
            this.c = ((short)(i + 1));
            continue;
            i = k - this.b;
          }
        }
      }
      finally {}
      do
      {
        break;
        ((List)localObject2).addAll(this.a.subList(i, k));
        break label115;
      } while (!paramBoolean1);
      if (paramBoolean2) {}
    }
  }
  
  private void b(m paramm)
  {
    if (this.b == 0)
    {
      this.a.add(paramm);
      return;
    }
    this.a.add(this.a.size() - this.b, paramm);
  }
  
  private long c()
  {
    try
    {
      long l = b().f();
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final Iterator a()
  {
    try
    {
      Iterator localIterator = a(true, true);
      return localIterator;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a(m paramm)
  {
    m localm1;
    for (;;)
    {
      m localm2;
      try
      {
        if (this.a.size() == 0)
        {
          b(paramm);
          return;
        }
        localm2 = b();
        if (!paramm.a(localm2)) {
          throw new IllegalArgumentException(z[0]);
        }
      }
      finally {}
      localm1 = paramm;
      if (paramm.f() != localm2.f())
      {
        if (paramm.f() <= localm2.f()) {
          break;
        }
        localm1 = paramm.g();
        localm1.a(localm2.f());
      }
      if (!this.a.contains(localm1)) {
        b(localm1);
      }
    }
    for (;;)
    {
      localm1 = paramm;
      if (i >= this.a.size()) {
        break;
      }
      localm1 = ((m)this.a.get(i)).g();
      localm1.a(paramm.f());
      this.a.set(i, localm1);
      i += 1;
      continue;
      int i = 0;
    }
  }
  
  public final m b()
  {
    try
    {
      if (this.a.size() == 0) {
        throw new IllegalStateException(z[1]);
      }
    }
    finally {}
    m localm = (m)this.a.get(0);
    return localm;
  }
  
  public final String toString()
  {
    if (this.a.size() == 0) {
      return z[5];
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(z[3]);
    localStringBuffer.append(b().b() + " ");
    localStringBuffer.append(c() + " ");
    localStringBuffer.append(a(a(true, false)));
    if (this.b > 0)
    {
      localStringBuffer.append(z[4]);
      localStringBuffer.append(a(a(false, false)));
    }
    localStringBuffer.append(z[2]);
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */