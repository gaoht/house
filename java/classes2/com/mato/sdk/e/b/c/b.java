package com.mato.sdk.e.b.c;

import android.net.Uri;
import com.mato.sdk.b.h;
import com.mato.sdk.e.b.b.a;
import com.mato.sdk.e.b.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class b
{
  protected final com.mato.sdk.e.b.g a;
  private List<String> b = new ArrayList();
  private List<Integer> c = new ArrayList();
  private boolean d = false;
  
  private b(com.mato.sdk.e.b.g paramg)
  {
    this.a = paramg;
  }
  
  public static b a(com.mato.sdk.e.b.g paramg)
  {
    if (paramg.b) {
      return new a(paramg);
    }
    return new b(paramg);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt > 100) && (paramInt < 400);
  }
  
  private static com.mato.sdk.e.b.a.b b(List<com.mato.sdk.e.b.a.b> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.mato.sdk.e.b.a.b localb = (com.mato.sdk.e.b.a.b)paramList.next();
      if (localb.c.equals(paramString)) {
        return localb;
      }
    }
    return null;
  }
  
  private void f()
  {
    if (!this.d)
    {
      d();
      this.d = true;
    }
  }
  
  protected final void a(int paramInt, Object... paramVarArgs)
  {
    paramVarArgs = String.format(Locale.US, e.a(paramInt), paramVarArgs);
    this.c.add(Integer.valueOf(paramInt));
    this.b.add(paramVarArgs);
  }
  
  public final boolean a()
  {
    return b().isEmpty();
  }
  
  public final List<String> b()
  {
    f();
    return this.b;
  }
  
  public final List<Integer> c()
  {
    f();
    return this.c;
  }
  
  protected abstract void d();
  
  protected final int e()
  {
    int i = com.mato.sdk.b.b.a(this.a.d);
    switch (h.a(this.a.f))
    {
    default: 
    case 2: 
    case 3: 
    case 4: 
      for (;;)
      {
        return -1;
        return 10;
        switch (i)
        {
        default: 
          break;
        case 0: 
          return 56;
        case 2: 
          return 70;
        case 1: 
          return 160;
          switch (i)
          {
          }
          break;
        }
      }
      return 310;
      return 460;
      return 490;
    }
    return 350;
  }
  
  static final class a
    extends b
  {
    private static final String b = com.mato.sdk.b.g.b("");
    private b.c c;
    private b.c d;
    private final List<com.mato.sdk.e.b.a.b> e = new ArrayList();
    private final List<com.mato.sdk.e.b.a.b> f = new ArrayList();
    private final String g;
    private int h;
    
    public a(com.mato.sdk.e.b.g paramg)
    {
      super((byte)0);
      if (!this.a.n.isEmpty())
      {
        this.g = ((a)this.a.n.get(0)).a;
        return;
      }
      this.g = "Unknown";
    }
    
    private boolean f()
    {
      ArrayList localArrayList1 = new ArrayList(d.b.length);
      ArrayList localArrayList2 = new ArrayList(d.b.length);
      this.h = e();
      int i = this.h;
      Iterator localIterator = this.a.p.iterator();
      while (localIterator.hasNext())
      {
        com.mato.sdk.e.b.a.e locale = (com.mato.sdk.e.b.a.e)localIterator.next();
        if (d.a(locale.a))
        {
          localArrayList1.add(locale.c);
          localArrayList2.add(locale.b);
        }
        else
        {
          this.e.add(locale.c);
          this.f.add(locale.b);
        }
      }
      if (!localArrayList1.isEmpty()) {
        this.c = b.c.a(localArrayList1, this.h);
      }
      if (!localArrayList2.isEmpty()) {
        this.d = b.c.a(localArrayList2, this.h);
      }
      this.e.size();
      this.f.size();
      return (this.c != null) && (this.d != null);
    }
    
    private void g()
    {
      b.c localc;
      if (this.d.a())
      {
        localc = this.c;
        if (localc.b != localc.a) {
          break label314;
        }
        i = 1;
        if (i != 0) {
          a(5003, new Object[] { this.g });
        }
      }
      if ((this.d.a()) && (this.c.c()) && (this.c.d())) {
        a(5004, new Object[0]);
      }
      if ((this.d.a()) && (this.c.c()) && (this.c.e()) && (this.c.f())) {
        a(5005, new Object[] { this.g });
      }
      if ((!this.d.a()) && (!this.c.a()) && (this.d.c()) && (this.d.d()) && (this.c.c()) && (this.c.d())) {
        a(3004, new Object[0]);
      }
      if ((this.d.a()) && (this.c.c()) && (this.c.e()))
      {
        if (this.c.c != 0) {
          break label319;
        }
        i = 1;
        label262:
        if (i != 0)
        {
          localc = this.c;
          if (localc.d != localc.a) {
            break label324;
          }
        }
      }
      label314:
      label319:
      label324:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          a(5006, new Object[] { this.g, this.g });
        }
        return;
        i = 0;
        break;
        i = 0;
        break label262;
      }
    }
    
    private void h()
    {
      if (this.h == -1) {}
      do
      {
        return;
        if ((this.d.a()) && (this.c.a()) && (this.d.i()) && (this.c.j())) {
          a(5007, new Object[] { this.g });
        }
      } while ((!this.d.a()) || (!this.c.a()) || (!this.d.j()) || (!this.c.j()));
      a(3005, new Object[] { Integer.valueOf(this.d.e) });
    }
    
    private void i()
    {
      if ((this.d.a()) && (this.c.a()))
      {
        Iterator localIterator = this.f.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (com.mato.sdk.e.b.a.b)localIterator.next();
          com.mato.sdk.e.b.a.b localb = b.a(this.e, ((com.mato.sdk.e.b.a.b)localObject).c);
          if (localb == null) {
            localObject = ((com.mato.sdk.e.b.a.b)localObject).c;
          } else if (!a(localb.e)) {
            if (a(((com.mato.sdk.e.b.a.b)localObject).e)) {
              a(6000, new Object[] { this.g, Uri.parse(((com.mato.sdk.e.b.a.b)localObject).c).getHost() });
            } else {
              a(4004, new Object[] { Uri.parse(((com.mato.sdk.e.b.a.b)localObject).c).getHost() });
            }
          }
        }
      }
    }
    
    protected final void d()
    {
      Object localObject = new ArrayList(d.b.length);
      ArrayList localArrayList = new ArrayList(d.b.length);
      this.h = e();
      int i = this.h;
      Iterator localIterator = this.a.p.iterator();
      while (localIterator.hasNext())
      {
        com.mato.sdk.e.b.a.e locale = (com.mato.sdk.e.b.a.e)localIterator.next();
        if (d.a(locale.a))
        {
          ((List)localObject).add(locale.c);
          localArrayList.add(locale.b);
        }
        else
        {
          this.e.add(locale.c);
          this.f.add(locale.b);
        }
      }
      if (!((List)localObject).isEmpty()) {
        this.c = b.c.a((List)localObject, this.h);
      }
      if (!localArrayList.isEmpty()) {
        this.d = b.c.a(localArrayList, this.h);
      }
      this.e.size();
      this.f.size();
      if ((this.c != null) && (this.d != null)) {}
      for (i = 1; i == 0; i = 0) {
        return;
      }
      if (this.d.a())
      {
        localObject = this.c;
        if (((b.c)localObject).b != ((b.c)localObject).a) {
          break label680;
        }
        i = 1;
        if (i != 0) {
          a(5003, new Object[] { this.g });
        }
      }
      if ((this.d.a()) && (this.c.c()) && (this.c.d())) {
        a(5004, new Object[0]);
      }
      if ((this.d.a()) && (this.c.c()) && (this.c.e()) && (this.c.f())) {
        a(5005, new Object[] { this.g });
      }
      if ((!this.d.a()) && (!this.c.a()) && (this.d.c()) && (this.d.d()) && (this.c.c()) && (this.c.d())) {
        a(3004, new Object[0]);
      }
      if ((this.d.a()) && (this.c.c()) && (this.c.e()))
      {
        if (this.c.c != 0) {
          break label685;
        }
        i = 1;
        label494:
        if (i != 0)
        {
          localObject = this.c;
          if (((b.c)localObject).d != ((b.c)localObject).a) {
            break label690;
          }
        }
      }
      label680:
      label685:
      label690:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          a(5006, new Object[] { this.g, this.g });
        }
        if (this.h != -1)
        {
          if ((this.d.a()) && (this.c.a()) && (this.d.i()) && (this.c.j())) {
            a(5007, new Object[] { this.g });
          }
          if ((this.d.a()) && (this.c.a()) && (this.d.j()) && (this.c.j())) {
            a(3005, new Object[] { Integer.valueOf(this.d.e) });
          }
        }
        i();
        return;
        i = 0;
        break;
        i = 0;
        break label494;
      }
    }
  }
  
  static final class b
    extends b
  {
    private static final String b = com.mato.sdk.b.g.b("");
    private int c;
    private b.c d = null;
    private final List<com.mato.sdk.e.b.a.b> e = new ArrayList();
    
    public b(com.mato.sdk.e.b.g paramg)
    {
      super((byte)0);
    }
    
    private boolean f()
    {
      ArrayList localArrayList = new ArrayList(d.b.length);
      this.c = e();
      int i = this.c;
      Iterator localIterator = this.a.p.iterator();
      while (localIterator.hasNext())
      {
        com.mato.sdk.e.b.a.e locale = (com.mato.sdk.e.b.a.e)localIterator.next();
        if (d.a(locale.a)) {
          localArrayList.add(locale.b);
        } else {
          this.e.add(locale.b);
        }
      }
      if (!localArrayList.isEmpty()) {
        this.d = b.c.a(localArrayList, this.c);
      }
      return this.d != null;
    }
    
    private void g()
    {
      if ((this.d.c()) && (this.d.d())) {
        a(3006, new Object[0]);
      }
      if ((this.d.c()) && (this.d.e()) && (this.d.f())) {
        a(3007, new Object[0]);
      }
    }
    
    private void h()
    {
      if (this.c == -1) {}
      while ((!this.d.a()) || (!this.d.j())) {
        return;
      }
      a(3008, new Object[] { Integer.valueOf(this.d.e) });
    }
    
    private void i()
    {
      if (!this.d.a()) {}
      for (;;)
      {
        return;
        Iterator localIterator = this.e.iterator();
        while (localIterator.hasNext())
        {
          com.mato.sdk.e.b.a.b localb = (com.mato.sdk.e.b.a.b)localIterator.next();
          if (!a(localb.e)) {
            a(4005, new Object[] { Uri.parse(localb.c).getHost(), localb.a });
          }
        }
      }
    }
    
    private void j()
    {
      if ((!this.d.a()) || (!this.d.i())) {}
      for (;;)
      {
        return;
        Iterator localIterator = this.e.iterator();
        while (localIterator.hasNext())
        {
          com.mato.sdk.e.b.a.b localb = (com.mato.sdk.e.b.a.b)localIterator.next();
          if ((a(localb.e)) && (localb.m < (float)(this.c * 0.5D))) {
            a(4006, new Object[] { Uri.parse(localb.c).getHost(), localb.a, localb.a });
          }
        }
      }
    }
    
    protected final void d()
    {
      ArrayList localArrayList = new ArrayList(d.b.length);
      this.c = e();
      int i = this.c;
      Iterator localIterator = this.a.p.iterator();
      while (localIterator.hasNext())
      {
        com.mato.sdk.e.b.a.e locale = (com.mato.sdk.e.b.a.e)localIterator.next();
        if (d.a(locale.a)) {
          localArrayList.add(locale.b);
        } else {
          this.e.add(locale.b);
        }
      }
      if (!localArrayList.isEmpty()) {
        this.d = b.c.a(localArrayList, this.c);
      }
      if (this.d != null) {}
      for (i = 1; i == 0; i = 0) {
        return;
      }
      if ((this.d.c()) && (this.d.d())) {
        a(3006, new Object[0]);
      }
      if ((this.d.c()) && (this.d.e()) && (this.d.f())) {
        a(3007, new Object[0]);
      }
      if ((this.c != -1) && (this.d.a()) && (this.d.j())) {
        a(3008, new Object[] { Integer.valueOf(this.d.e) });
      }
      i();
      j();
    }
  }
  
  static final class c
  {
    private static final String f = com.mato.sdk.b.g.b("PortalsIndex");
    final int a;
    final int b;
    final int c;
    final int d;
    final int e;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    
    private c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
    {
      this.a = paramInt1;
      this.g = paramInt2;
      this.b = paramInt3;
      this.h = paramInt4;
      this.i = paramInt5;
      this.c = paramInt6;
      this.d = paramInt7;
      this.j = paramInt8;
      this.k = paramInt9;
      this.e = paramInt10;
    }
    
    public static c a(List<com.mato.sdk.e.b.a.b> paramList, int paramInt)
    {
      int i5 = 0;
      int i7 = 0;
      int i6 = 0;
      int i4 = 0;
      int i2 = 0;
      int n = 0;
      int m = 0;
      int i1 = 0;
      Iterator localIterator = paramList.iterator();
      int i3 = 0;
      if (localIterator.hasNext())
      {
        com.mato.sdk.e.b.a.b localb = (com.mato.sdk.e.b.a.b)localIterator.next();
        int i8 = localb.e;
        if (i8 == -1) {
          i6 += 1;
        }
        for (;;)
        {
          i8 = i4;
          if (localb.g == -1) {
            i8 = i4 + 1;
          }
          int i9 = i2;
          if (localb.h == -1) {
            i9 = i2 + 1;
          }
          int i10 = n;
          if (localb.j == -1) {
            i10 = n + 1;
          }
          int i11 = m;
          int i12 = i1;
          if (-1 != paramInt)
          {
            n = m;
            if (localb.m > (float)(paramInt * 0.5D)) {
              n = m + 1;
            }
            i11 = n;
            i12 = i1;
            if (localb.m > (float)(paramInt * 0.8D))
            {
              i12 = i1 + 1;
              i11 = n;
            }
          }
          i3 = localb.m + i3;
          i4 = i8;
          i2 = i9;
          n = i10;
          m = i11;
          i1 = i12;
          break;
          if ((i8 >= 400) && (i8 < 600)) {
            i7 += 1;
          } else if (b.a(i8)) {
            i5 += 1;
          }
        }
      }
      paramInt = i3 / paramList.size();
      return new c(paramList.size(), i5, i7, i6, i4, i2, n, m, i1, paramInt);
    }
    
    public final boolean a()
    {
      return this.g == this.a;
    }
    
    public final boolean b()
    {
      return this.b == this.a;
    }
    
    public final boolean c()
    {
      return this.h == this.a;
    }
    
    public final boolean d()
    {
      return this.i == this.a;
    }
    
    public final boolean e()
    {
      return this.i == 0;
    }
    
    public final boolean f()
    {
      return this.c == this.a;
    }
    
    public final boolean g()
    {
      return this.c == 0;
    }
    
    public final boolean h()
    {
      return this.d == this.a;
    }
    
    public final boolean i()
    {
      return this.k == this.a;
    }
    
    public final boolean j()
    {
      return this.j == 0;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/b/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */