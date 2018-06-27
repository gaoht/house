package com.mato.sdk.e.b.c;

import com.mato.sdk.b.b;
import com.mato.sdk.b.h;
import com.mato.sdk.e.b.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class d
{
  private static final String a = com.mato.sdk.b.g.b("");
  private final com.mato.sdk.e.b.g b;
  private final List<Integer> c = new ArrayList(8);
  private final List<String> d = new ArrayList(8);
  private final List<c> e = new ArrayList(4);
  private final List<c> f = new ArrayList();
  private final a g;
  private boolean h = false;
  private a i;
  private boolean j = false;
  private int k = -1;
  
  public d(com.mato.sdk.e.b.g paramg, a parama)
  {
    this.b = paramg;
    this.g = parama;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    int m = 150;
    if (2 == paramInt1) {
      paramInt2 = 500;
    }
    do
    {
      do
      {
        return paramInt2;
        if ((paramInt2 == 0) && (3 == paramInt1)) {
          return 300;
        }
        if (((paramInt2 == 1) || (paramInt2 == 2)) && (3 == paramInt1)) {
          return 200;
        }
        paramInt2 = m;
      } while (4 == paramInt1);
      paramInt2 = m;
    } while (1 == paramInt1);
    return -1;
  }
  
  private void a(int paramInt, Object... paramVarArgs)
  {
    paramVarArgs = String.format(Locale.US, e.a(paramInt), paramVarArgs);
    this.c.add(Integer.valueOf(paramInt));
    this.d.add(paramVarArgs);
  }
  
  private void a(com.mato.sdk.e.b.b.a parama)
  {
    parama = parama.b;
    if (parama == null) {}
    do
    {
      return;
      if ((parama.b == 0) && (this.i.a == 0) && (!this.i.d) && (parama.d > (float)(1.5D * this.k)))
      {
        a(5002, new Object[] { parama.a });
        return;
      }
      if ((parama.b == 0) && (a(parama)))
      {
        a(5001, new Object[] { parama.a });
        return;
      }
    } while ((this.i.a != 0) || (parama.b <= 0));
    a(5000, new Object[] { parama.a });
  }
  
  static boolean a(c paramc)
  {
    if ((paramc.e > 0) && (paramc.e < 150)) {}
    while ((paramc.e - paramc.c) * 100.0F / paramc.e <= 50.0F) {
      return false;
    }
    return true;
  }
  
  private static boolean b(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((2 == paramInt1) && ((3 == paramInt3) || (4 == paramInt3))) {}
    while (((paramInt2 == 0) && (3 == paramInt1) && ((3 == paramInt3) || (4 == paramInt3))) || (((paramInt2 == 1) || (paramInt2 == 2)) && (((3 == paramInt1) && ((3 == paramInt3) || (4 == paramInt3))) || ((4 == paramInt1) && ((3 == paramInt3) || (4 == paramInt3))) || ((1 == paramInt1) && ((3 == paramInt3) || (4 == paramInt3)))))) {
      return true;
    }
    return false;
  }
  
  private void d()
  {
    if (this.h) {
      return;
    }
    Object localObject = this.b.o.iterator();
    c localc;
    while (((Iterator)localObject).hasNext())
    {
      localc = (c)((Iterator)localObject).next();
      if (com.mato.sdk.e.b.d.a(com.mato.sdk.e.b.d.a, localc.a)) {
        this.e.add(localc);
      } else {
        this.f.add(localc);
      }
    }
    int i5 = h.a(this.b.f);
    int i6 = b.a(this.b.d);
    int m;
    int i7;
    int i3;
    int i2;
    int i4;
    label159:
    int n;
    int i1;
    if (2 == i5)
    {
      m = 500;
      this.k = m;
      localObject = this.e;
      i7 = this.k;
      localObject = ((List)localObject).iterator();
      i3 = 0;
      i2 = 0;
      i4 = 0;
      m = 0;
      if (!((Iterator)localObject).hasNext()) {
        break label340;
      }
      localc = (c)((Iterator)localObject).next();
      n = i4;
      if (localc.b > 0) {
        n = i4 + 1;
      }
      i1 = i3;
      if (a(localc)) {
        i1 = i3 + 1;
      }
      i3 = i2;
      if (localc.b == 100) {
        i3 = i2 + 1;
      }
      if ((i7 == -1) || (localc.d <= i7)) {
        break label1082;
      }
      m += 1;
    }
    label340:
    label485:
    label513:
    label514:
    label732:
    label768:
    label806:
    label808:
    label860:
    label1082:
    for (;;)
    {
      i4 = n;
      i2 = i3;
      i3 = i1;
      break label159;
      if ((i6 == 0) && (3 == i5))
      {
        m = 300;
        break;
      }
      if (((i6 == 1) || (i6 == 2)) && (3 == i5))
      {
        m = 200;
        break;
      }
      if (4 == i5)
      {
        m = 150;
        break;
      }
      if (1 == i5)
      {
        m = 150;
        break;
      }
      m = -1;
      break;
      boolean bool = false;
      if (i7 != -1)
      {
        if ((2 == i5) && ((3 == m) || (4 == m))) {
          bool = true;
        }
      }
      else
      {
        this.i = new a(i4, i2, i3, bool);
        if ((this.i.a == 2) || (this.i.a == 3)) {
          a(3000, new Object[0]);
        }
        e();
        if ((this.i.b == 4) && (e())) {
          a(3001, new Object[0]);
        }
        if (this.i.a == 0)
        {
          if (!this.i.d) {
            break label732;
          }
          a(3003, new Object[0]);
          this.j = this.i.d;
        }
        if (this.j) {
          break label860;
        }
        localObject = this.f.iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label860;
        }
        localc = (c)((Iterator)localObject).next();
        if (this.i.a == 0)
        {
          if ((localc.b <= 0) || (localc.b >= 100)) {
            break label768;
          }
          a(4000, new Object[] { localc.a });
        }
        for (;;)
        {
          if ((localc.b != 0) || (!a(localc))) {
            break label806;
          }
          a(4002, new Object[] { localc.a });
          break label514;
          if ((i6 == 0) && (3 == i5) && ((3 == m) || (4 == m)))
          {
            bool = true;
            break;
          }
          if (((i6 == 1) || (i6 == 2)) && (3 == i5) && ((3 == m) || (4 == m)))
          {
            bool = true;
            break;
          }
          if ((4 == i5) && ((3 == m) || (4 == m)))
          {
            bool = true;
            break;
          }
          if ((1 == i5) && ((3 == m) || (4 == m)))
          {
            bool = true;
            break;
          }
          bool = false;
          break;
          if ((3 != this.i.c) && (4 != this.i.c)) {
            break label485;
          }
          a(3002, new Object[0]);
          break label485;
          if (localc.b != 100) {
            break label808;
          }
          a(4001, new Object[] { localc.a, localc.a });
        }
        continue;
        if ((localc.d <= (float)(this.k * 1.5D)) || (this.i.d)) {
          break label513;
        }
        a(4003, new Object[] { localc.a });
      }
      if (this.b.b)
      {
        localObject = this.b.n;
        if (!((List)localObject).isEmpty())
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localc = ((com.mato.sdk.e.b.b.a)((Iterator)localObject).next()).b;
            if (localc != null) {
              if ((localc.b == 0) && (this.i.a == 0) && (!this.i.d) && (localc.d > (float)(1.5D * this.k))) {
                a(5002, new Object[] { localc.a });
              } else if ((localc.b == 0) && (a(localc))) {
                a(5001, new Object[] { localc.a });
              } else if ((this.i.a == 0) && (localc.b > 0)) {
                a(5000, new Object[] { localc.a });
              }
            }
          }
        }
      }
      this.h = true;
      return;
    }
  }
  
  private boolean e()
  {
    Iterator localIterator = this.g.c().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if ((3000 <= localInteger.intValue()) && (localInteger.intValue() < 4000)) {
        return true;
      }
    }
    return false;
  }
  
  private void f()
  {
    if (this.j) {}
    label116:
    label151:
    label153:
    label201:
    for (;;)
    {
      return;
      Iterator localIterator = this.f.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label201;
        }
        c localc = (c)localIterator.next();
        if (this.i.a == 0)
        {
          if ((localc.b <= 0) || (localc.b >= 100)) {
            break label116;
          }
          a(4000, new Object[] { localc.a });
        }
        for (;;)
        {
          if ((localc.b != 0) || (!a(localc))) {
            break label151;
          }
          a(4002, new Object[] { localc.a });
          break;
          if (localc.b != 100) {
            break label153;
          }
          a(4001, new Object[] { localc.a, localc.a });
        }
        continue;
        if ((localc.d <= (float)(this.k * 1.5D)) || (this.i.d)) {
          break;
        }
        a(4003, new Object[] { localc.a });
      }
    }
  }
  
  private void g()
  {
    if (!this.b.b) {}
    for (;;)
    {
      return;
      Object localObject = this.b.n;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          c localc = ((com.mato.sdk.e.b.b.a)((Iterator)localObject).next()).b;
          if (localc != null) {
            if ((localc.b == 0) && (this.i.a == 0) && (!this.i.d) && (localc.d > (float)(1.5D * this.k))) {
              a(5002, new Object[] { localc.a });
            } else if ((localc.b == 0) && (a(localc))) {
              a(5001, new Object[] { localc.a });
            } else if ((this.i.a == 0) && (localc.b > 0)) {
              a(5000, new Object[] { localc.a });
            }
          }
        }
      }
    }
  }
  
  private void h()
  {
    if ((this.i.a == 2) || (this.i.a == 3)) {
      a(3000, new Object[0]);
    }
    e();
    if ((this.i.b == 4) && (e())) {
      a(3001, new Object[0]);
    }
    if (this.i.a == 0)
    {
      if (!this.i.d) {
        break label110;
      }
      a(3003, new Object[0]);
    }
    for (;;)
    {
      this.j = this.i.d;
      return;
      label110:
      if ((3 == this.i.c) || (4 == this.i.c)) {
        a(3002, new Object[0]);
      }
    }
  }
  
  private void i()
  {
    Object localObject = this.b.o.iterator();
    c localc;
    while (((Iterator)localObject).hasNext())
    {
      localc = (c)((Iterator)localObject).next();
      if (com.mato.sdk.e.b.d.a(com.mato.sdk.e.b.d.a, localc.a)) {
        this.e.add(localc);
      } else {
        this.f.add(localc);
      }
    }
    int i4 = h.a(this.b.f);
    int i5 = b.a(this.b.d);
    int m;
    int i6;
    int i1;
    int i3;
    int i2;
    label150:
    int n;
    if (2 == i4)
    {
      m = 500;
      this.k = m;
      localObject = this.e;
      i6 = this.k;
      localObject = ((List)localObject).iterator();
      i1 = 0;
      i3 = 0;
      i2 = 0;
      m = 0;
      if (!((Iterator)localObject).hasNext()) {
        break label328;
      }
      localc = (c)((Iterator)localObject).next();
      n = i1;
      if (localc.b > 0) {
        n = i1 + 1;
      }
      i1 = i3;
      if (a(localc)) {
        i1 = i3 + 1;
      }
      i3 = i2;
      if (localc.b == 100) {
        i3 = i2 + 1;
      }
      if ((i6 == -1) || (localc.d <= i6)) {
        break label486;
      }
      m += 1;
    }
    label328:
    label375:
    label486:
    for (;;)
    {
      i2 = i3;
      i3 = i1;
      i1 = n;
      break label150;
      if ((i5 == 0) && (3 == i4))
      {
        m = 300;
        break;
      }
      if (((i5 == 1) || (i5 == 2)) && (3 == i4))
      {
        m = 200;
        break;
      }
      if (4 == i4)
      {
        m = 150;
        break;
      }
      if (1 == i4)
      {
        m = 150;
        break;
      }
      m = -1;
      break;
      boolean bool = false;
      if (i6 != -1)
      {
        if ((2 != i4) || ((3 != m) && (4 != m))) {
          break label375;
        }
        bool = true;
      }
      for (;;)
      {
        this.i = new a(i1, i2, i3, bool);
        return;
        if ((i5 == 0) && (3 == i4) && ((3 == m) || (4 == m))) {
          bool = true;
        } else if (((i5 == 1) || (i5 == 2)) && (3 == i4) && ((3 == m) || (4 == m))) {
          bool = true;
        } else if ((4 == i4) && ((3 == m) || (4 == m))) {
          bool = true;
        } else if ((1 == i4) && ((3 == m) || (4 == m))) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
  }
  
  public final boolean a()
  {
    return b().isEmpty();
  }
  
  public final List<String> b()
  {
    d();
    return this.d;
  }
  
  public final List<Integer> c()
  {
    d();
    return this.c;
  }
  
  static final class a
  {
    final int a;
    final int b;
    final int c;
    final boolean d;
    
    public a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      this.a = paramInt1;
      this.c = paramInt3;
      this.b = paramInt2;
      this.d = paramBoolean;
    }
    
    public static a a(List<c> paramList, int paramInt1, int paramInt2, int paramInt3)
    {
      boolean bool = false;
      paramList = paramList.iterator();
      int i = 0;
      int m = 0;
      int n = 0;
      int k = 0;
      int j;
      if (paramList.hasNext())
      {
        c localc = (c)paramList.next();
        j = k;
        if (localc.b > 0) {
          j = k + 1;
        }
        k = n;
        if (d.a(localc)) {
          k = n + 1;
        }
        n = m;
        if (localc.b == 100) {
          n = m + 1;
        }
        if ((paramInt1 == -1) || (localc.d <= paramInt1)) {
          break label163;
        }
        i += 1;
      }
      label163:
      for (;;)
      {
        m = n;
        n = k;
        k = j;
        break;
        if (paramInt1 != -1) {
          bool = d.a(paramInt2, paramInt3, i);
        }
        return new a(k, m, n, bool);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/b/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */