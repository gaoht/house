package cn.jiguang.c.c;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class h
  implements Cloneable
{
  private static m[] d = new m[0];
  private static l[] e = new l[0];
  private g a;
  private List[] b = new List[4];
  private int c;
  
  public h()
  {
    this(new g());
  }
  
  private h(d paramd)
  {
    this(new g(paramd));
    int i = 0;
    if (i < 4) {}
    for (;;)
    {
      int j;
      try
      {
        k = this.a.b(i);
        if (k <= 0) {
          break label105;
        }
        this.b[i] = new ArrayList(k);
      }
      catch (t paramd)
      {
        int k;
        m localm;
        throw paramd;
      }
      if (j < k)
      {
        localm = m.a(paramd, i);
        this.b[i].add(localm);
        j += 1;
      }
      else
      {
        i += 1;
        break;
        this.c = paramd.a();
        return;
        label105:
        j = 0;
      }
    }
  }
  
  private h(g paramg)
  {
    this.a = paramg;
  }
  
  public h(byte[] paramArrayOfByte)
  {
    this(new d(paramArrayOfByte));
  }
  
  public static h a(m paramm)
  {
    h localh = new h();
    if (localh.b[0] == null) {
      localh.b[0] = new LinkedList();
    }
    localh.a.a(0);
    localh.b[0].add(paramm);
    return localh;
  }
  
  public final m a()
  {
    List localList = this.b[0];
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    return (m)localList.get(0);
  }
  
  public final l[] a(int paramInt)
  {
    if (this.b[1] == null) {
      return e;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject;
    HashSet localHashSet;
    label46:
    j localj;
    if (this.b[1] == null)
    {
      localObject = d;
      localHashSet = new HashSet();
      paramInt = 0;
      if (paramInt >= localObject.length) {
        break label234;
      }
      localj = localObject[paramInt].b();
      if (!localHashSet.contains(localj)) {
        break label255;
      }
      i = localLinkedList.size() - 1;
      label82:
      if (i < 0) {
        break label255;
      }
      l locall = (l)localLinkedList.get(i);
      if ((locall.b().d() != localObject[paramInt].d()) || (locall.b().e() != localObject[paramInt].e()) || (!locall.b().b().equals(localj))) {
        break label227;
      }
      locall.a(localObject[paramInt]);
    }
    label227:
    label234:
    label255:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        localLinkedList.add(new l(localObject[paramInt]));
        localHashSet.add(localj);
      }
      paramInt += 1;
      break label46;
      localObject = this.b[1];
      localObject = (m[])((List)localObject).toArray(new m[((List)localObject).size()]);
      break;
      i -= 1;
      break label82;
      return (l[])localLinkedList.toArray(new l[localLinkedList.size()]);
    }
  }
  
  public final byte[] b(int paramInt)
  {
    e locale = new e();
    this.a.a(locale);
    b localb = new b();
    this.a.a();
    int i1 = 0;
    int i;
    Object localObject;
    int j;
    label84:
    m localm;
    int m;
    if (i1 < 4) {
      if (this.b[i1] != null)
      {
        int i3 = this.b[i1].size();
        i = locale.a();
        paramInt = 0;
        int k = 0;
        localObject = null;
        j = 0;
        if (j < i3)
        {
          localm = (m)this.b[i1].get(j);
          if (i1 == 3)
          {
            m = paramInt;
            k += 1;
            paramInt = i;
            i = m;
          }
        }
      }
    }
    for (;;)
    {
      m = j + 1;
      j = i;
      i = paramInt;
      paramInt = j;
      j = m;
      break label84;
      m = paramInt;
      int n = i;
      if (localObject != null) {
        if ((localm.d() != ((m)localObject).d()) || (localm.e() != ((m)localObject).e()) || (!localm.b().equals(((m)localObject).b()))) {
          break label257;
        }
      }
      label257:
      for (int i2 = 1;; i2 = 0)
      {
        m = paramInt;
        n = i;
        if (i2 == 0)
        {
          n = locale.a();
          m = j;
        }
        localm.a(locale, localb);
        if (locale.a() <= 65535) {
          break label278;
        }
        locale.a(n);
        i1 += 1;
        break;
      }
      this.c = locale.a();
      return locale.b();
      label278:
      paramInt = n;
      i = m;
      localObject = localm;
    }
  }
  
  public final Object clone()
  {
    h localh = new h();
    int i = 0;
    while (i < this.b.length)
    {
      if (this.b[i] != null) {
        localh.b[i] = new LinkedList(this.b[i]);
      }
      i += 1;
    }
    localh.a = ((g)this.a.clone());
    localh.c = this.c;
    return localh;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */