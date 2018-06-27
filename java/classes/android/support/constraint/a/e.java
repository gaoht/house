package android.support.constraint.a;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class e
{
  private static int d = 1000;
  int a = 0;
  int b = 1;
  final c c;
  private HashMap<String, g> e = null;
  private d f = new d();
  private int g = 32;
  private int h = this.g;
  private b[] i = null;
  private boolean[] j = new boolean[this.g];
  private int k = 0;
  private int l = this.g;
  private g[] m = new g[d];
  private int n = 0;
  private b[] o = new b[this.g];
  
  public e()
  {
    b();
    this.c = new c();
  }
  
  private g a(g.a parama)
  {
    Object localObject = (g)this.c.b.acquire();
    if (localObject == null) {}
    for (parama = new g(parama);; parama = (g.a)localObject)
    {
      if (this.n >= d)
      {
        d *= 2;
        this.m = ((g[])Arrays.copyOf(this.m, d));
      }
      localObject = this.m;
      int i1 = this.n;
      this.n = (i1 + 1);
      localObject[i1] = parama;
      return parama;
      ((g)localObject).reset();
      ((g)localObject).setType(parama);
    }
  }
  
  private void a()
  {
    this.g *= 2;
    this.i = ((b[])Arrays.copyOf(this.i, this.g));
    this.c.c = ((g[])Arrays.copyOf(this.c.c, this.g));
    this.j = new boolean[this.g];
    this.h = this.g;
    this.l = this.g;
    this.f.a.clear();
  }
  
  private void a(b paramb)
  {
    paramb.addError(createErrorVariable(), createErrorVariable());
  }
  
  private void a(b paramb, int paramInt)
  {
    paramb.b(createErrorVariable(), paramInt);
  }
  
  private int b(d paramd)
  {
    int i1 = 0;
    while (i1 < this.b)
    {
      this.j[i1] = false;
      i1 += 1;
    }
    i1 = 0;
    int i4 = 0;
    int i2 = 0;
    g localg;
    int i3;
    if (i2 == 0)
    {
      localg = paramd.a();
      i3 = i1;
      if (localg == null) {
        break label372;
      }
      if (this.j[localg.a] != 0) {
        localg = null;
      }
    }
    for (;;)
    {
      if (localg != null)
      {
        int i5 = -1;
        float f1 = Float.MAX_VALUE;
        i3 = 0;
        label88:
        b localb;
        if (i3 < this.k)
        {
          localb = this.i[i3];
          float f2;
          int i6;
          if (localb.a.f == g.a.a)
          {
            f2 = f1;
            i6 = i5;
          }
          for (;;)
          {
            i3 += 1;
            i5 = i6;
            f1 = f2;
            break label88;
            this.j[localg.a] = true;
            i1 += 1;
            i3 = i1;
            if (i1 < this.b) {
              break label372;
            }
            i2 = 1;
            break;
            i6 = i5;
            f2 = f1;
            if (localb.a(localg))
            {
              float f3 = localb.d.get(localg);
              i6 = i5;
              f2 = f1;
              if (f3 < 0.0F)
              {
                f3 = -localb.b / f3;
                i6 = i5;
                f2 = f1;
                if (f3 < f1)
                {
                  i6 = i3;
                  f2 = f3;
                }
              }
            }
          }
        }
        if (i5 > -1)
        {
          localb = this.i[i5];
          localb.a.b = -1;
          localb.b(localg);
          localb.a.b = i5;
          i3 = 0;
          while (i3 < this.k)
          {
            this.i[i3].a(localb);
            i3 += 1;
          }
          paramd.a(this);
        }
      }
      for (;;)
      {
        try
        {
          c(paramd);
          i4 += 1;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          continue;
        }
        i2 = 1;
        continue;
        i2 = 1;
      }
      return i4;
      label372:
      i1 = i3;
    }
  }
  
  private void b()
  {
    int i1 = 0;
    while (i1 < this.i.length)
    {
      b localb = this.i[i1];
      if (localb != null) {
        this.c.a.release(localb);
      }
      this.i[i1] = null;
      i1 += 1;
    }
  }
  
  private void b(b paramb)
  {
    if (this.k > 0)
    {
      paramb.d.a(paramb, this.i);
      if (paramb.d.a == 0) {
        paramb.e = true;
      }
    }
  }
  
  private int c(d paramd)
    throws Exception
  {
    int i1 = 0;
    if (i1 < this.k)
    {
      if (this.i[i1].a.f == g.a.a) {}
      while (this.i[i1].b >= 0.0F)
      {
        i1 += 1;
        break;
      }
    }
    for (i1 = 1;; i1 = 0)
    {
      int i5;
      int i4;
      float f1;
      int i3;
      int i2;
      int i6;
      label93:
      b localb;
      float f2;
      int i9;
      int i8;
      int i7;
      if (i1 != 0)
      {
        i5 = 0;
        i4 = 0;
        i1 = i4;
        if (i5 != 0) {
          break label417;
        }
        f1 = Float.MAX_VALUE;
        i3 = 0;
        i2 = -1;
        i1 = -1;
        i6 = 0;
        if (i6 < this.k)
        {
          localb = this.i[i6];
          if (localb.a.f == g.a.a)
          {
            f2 = f1;
            i9 = i3;
            i8 = i2;
            i7 = i1;
          }
        }
      }
      for (;;)
      {
        i6 += 1;
        i1 = i7;
        i2 = i8;
        i3 = i9;
        f1 = f2;
        break label93;
        i7 = i1;
        i8 = i2;
        i9 = i3;
        f2 = f1;
        if (localb.b < 0.0F)
        {
          i7 = 1;
          label189:
          if (i7 < this.b)
          {
            g localg = this.c.c[i7];
            float f3 = localb.d.get(localg);
            if (f3 <= 0.0F) {}
            for (;;)
            {
              i7 += 1;
              break label189;
              i8 = 0;
              label241:
              if (i8 < 6)
              {
                f2 = localg.e[i8] / f3;
                if (((f2 < f1) && (i8 == i3)) || (i8 > i3))
                {
                  i1 = i7;
                  i2 = i6;
                  i3 = i8;
                  f1 = f2;
                }
                for (;;)
                {
                  i8 += 1;
                  break label241;
                  if (i2 != -1)
                  {
                    localb = this.i[i2];
                    localb.a.b = -1;
                    localb.b(this.c.c[i1]);
                    localb.a.b = i2;
                    i1 = 0;
                    while (i1 < this.k)
                    {
                      this.i[i1].a(localb);
                      i1 += 1;
                    }
                    paramd.a(this);
                  }
                  for (i1 = i5;; i1 = 1)
                  {
                    i4 += 1;
                    i5 = i1;
                    break;
                  }
                  i1 = 0;
                  label417:
                  i2 = 0;
                  if (i2 < this.k)
                  {
                    if (this.i[i2].a.f == g.a.a) {}
                    while (this.i[i2].b >= 0.0F)
                    {
                      i2 += 1;
                      break;
                    }
                  }
                  return i1;
                }
              }
            }
          }
          i7 = i1;
          i8 = i2;
          i9 = i3;
          f2 = f1;
        }
      }
    }
  }
  
  private void c()
  {
    int i1 = 0;
    while (i1 < this.k)
    {
      b localb = this.i[i1];
      localb.a.d = localb.b;
      i1 += 1;
    }
  }
  
  public static b createRowCentering(e parame, g paramg1, g paramg2, int paramInt1, float paramFloat, g paramg3, g paramg4, int paramInt2, boolean paramBoolean)
  {
    b localb = parame.createRow();
    localb.a(paramg1, paramg2, paramInt1, paramFloat, paramg3, paramg4, paramInt2);
    if (paramBoolean)
    {
      paramg1 = parame.createErrorVariable();
      parame = parame.createErrorVariable();
      paramg1.c = 4;
      parame.c = 4;
      localb.addError(paramg1, parame);
    }
    return localb;
  }
  
  public static b createRowDimensionPercent(e parame, g paramg1, g paramg2, g paramg3, float paramFloat, boolean paramBoolean)
  {
    b localb = parame.createRow();
    if (paramBoolean) {
      parame.a(localb);
    }
    return localb.a(paramg1, paramg2, paramg3, paramFloat);
  }
  
  public static b createRowEquals(e parame, g paramg1, g paramg2, int paramInt, boolean paramBoolean)
  {
    b localb = parame.createRow();
    localb.createRowEquals(paramg1, paramg2, paramInt);
    if (paramBoolean) {
      parame.a(localb, 1);
    }
    return localb;
  }
  
  public static b createRowGreaterThan(e parame, g paramg1, g paramg2, int paramInt, boolean paramBoolean)
  {
    g localg = parame.createSlackVariable();
    b localb = parame.createRow();
    localb.createRowGreaterThan(paramg1, paramg2, localg, paramInt);
    if (paramBoolean) {
      parame.a(localb, (int)(localb.d.get(localg) * -1.0F));
    }
    return localb;
  }
  
  public static b createRowLowerThan(e parame, g paramg1, g paramg2, int paramInt, boolean paramBoolean)
  {
    g localg = parame.createSlackVariable();
    b localb = parame.createRow();
    localb.createRowLowerThan(paramg1, paramg2, localg, paramInt);
    if (paramBoolean) {
      parame.a(localb, (int)(localb.d.get(localg) * -1.0F));
    }
    return localb;
  }
  
  private void d()
  {
    String str = "Display Rows (" + this.k + "x" + this.b + ") :\n\t | C | ";
    int i1 = 1;
    while (i1 <= this.b)
    {
      g localg = this.c.c[i1];
      str = str + localg;
      str = str + " | ";
      i1 += 1;
    }
    str = str + "\n";
    System.out.println(str);
  }
  
  b a(int paramInt)
  {
    return this.i[paramInt];
  }
  
  void a(d paramd)
    throws Exception
  {
    paramd.a(this);
    c(paramd);
    b(paramd);
    c();
  }
  
  public void addCentering(g paramg1, g paramg2, int paramInt1, float paramFloat, g paramg3, g paramg4, int paramInt2, int paramInt3)
  {
    b localb = createRow();
    localb.a(paramg1, paramg2, paramInt1, paramFloat, paramg3, paramg4, paramInt2);
    paramg1 = createErrorVariable();
    paramg2 = createErrorVariable();
    paramg1.c = paramInt3;
    paramg2.c = paramInt3;
    localb.addError(paramg1, paramg2);
    addConstraint(localb);
  }
  
  public void addConstraint(b paramb)
  {
    int i3 = 0;
    if (paramb == null) {}
    int i4;
    do
    {
      do
      {
        return;
        if ((this.k + 1 >= this.l) || (this.b + 1 >= this.h)) {
          a();
        }
        if (paramb.e) {
          break;
        }
        b(paramb);
        paramb.e();
        paramb.f();
      } while (!paramb.b());
      if (this.i[this.k] != null) {
        this.c.a.release(this.i[this.k]);
      }
      if (!paramb.e) {
        paramb.a();
      }
      this.i[this.k] = paramb;
      paramb.a.b = this.k;
      this.k += 1;
      i4 = paramb.a.h;
    } while (i4 <= 0);
    while (this.o.length < i4) {
      this.o = new b[this.o.length * 2];
    }
    b[] arrayOfb = this.o;
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= i4) {
        break;
      }
      arrayOfb[i1] = paramb.a.g[i1];
      i1 += 1;
    }
    label219:
    b localb;
    if (i2 < i4)
    {
      localb = arrayOfb[i2];
      if (localb != paramb) {
        break label244;
      }
    }
    for (;;)
    {
      i2 += 1;
      break label219;
      break;
      label244:
      localb.d.a(localb, paramb);
      localb.a();
    }
  }
  
  public b addEquality(g paramg1, g paramg2, int paramInt1, int paramInt2)
  {
    b localb = createRow();
    localb.createRowEquals(paramg1, paramg2, paramInt1);
    paramg1 = createErrorVariable();
    paramg2 = createErrorVariable();
    paramg1.c = paramInt2;
    paramg2.c = paramInt2;
    localb.addError(paramg1, paramg2);
    addConstraint(localb);
    return localb;
  }
  
  public void addEquality(g paramg, int paramInt)
  {
    int i1 = paramg.b;
    if (paramg.b != -1)
    {
      localb = this.i[i1];
      if (localb.e)
      {
        localb.b = paramInt;
        return;
      }
      localb = createRow();
      localb.createRowEquals(paramg, paramInt);
      addConstraint(localb);
      return;
    }
    b localb = createRow();
    localb.a(paramg, paramInt);
    addConstraint(localb);
  }
  
  public void addGreaterThan(g paramg1, g paramg2, int paramInt1, int paramInt2)
  {
    b localb = createRow();
    g localg = createSlackVariable();
    localg.c = paramInt2;
    localb.createRowGreaterThan(paramg1, paramg2, localg, paramInt1);
    addConstraint(localb);
  }
  
  public void addLowerThan(g paramg1, g paramg2, int paramInt1, int paramInt2)
  {
    b localb = createRow();
    g localg = createSlackVariable();
    localg.c = paramInt2;
    localb.createRowLowerThan(paramg1, paramg2, localg, paramInt1);
    addConstraint(localb);
  }
  
  public g createErrorVariable()
  {
    if (this.b + 1 >= this.h) {
      a();
    }
    g localg = a(g.a.d);
    this.a += 1;
    this.b += 1;
    localg.a = this.a;
    this.c.c[this.a] = localg;
    return localg;
  }
  
  public g createObjectVariable(Object paramObject)
  {
    Object localObject2 = null;
    if (paramObject == null) {}
    Object localObject1;
    do
    {
      do
      {
        return (g)localObject2;
        if (this.b + 1 >= this.h) {
          a();
        }
      } while (!(paramObject instanceof android.support.constraint.a.a.a));
      localObject2 = ((android.support.constraint.a.a.a)paramObject).getSolverVariable();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        ((android.support.constraint.a.a.a)paramObject).resetSolverVariable(this.c);
        localObject1 = ((android.support.constraint.a.a.a)paramObject).getSolverVariable();
      }
      if ((((g)localObject1).a == -1) || (((g)localObject1).a > this.a)) {
        break;
      }
      localObject2 = localObject1;
    } while (this.c.c[localObject1.a] != null);
    if (((g)localObject1).a != -1) {
      ((g)localObject1).reset();
    }
    this.a += 1;
    this.b += 1;
    ((g)localObject1).a = this.a;
    ((g)localObject1).f = g.a.a;
    this.c.c[this.a] = localObject1;
    return (g)localObject1;
  }
  
  public b createRow()
  {
    b localb = (b)this.c.a.acquire();
    if (localb == null) {
      return new b(this.c);
    }
    localb.reset();
    return localb;
  }
  
  public g createSlackVariable()
  {
    if (this.b + 1 >= this.h) {
      a();
    }
    g localg = a(g.a.c);
    this.a += 1;
    this.b += 1;
    localg.a = this.a;
    this.c.c[this.a] = localg;
    return localg;
  }
  
  public void displayVariablesReadableRows()
  {
    d();
    Object localObject1 = "";
    int i1 = 0;
    while (i1 < this.k)
    {
      localObject2 = localObject1;
      if (this.i[i1].a.f == g.a.a)
      {
        localObject1 = (String)localObject1 + this.i[i1].c();
        localObject2 = (String)localObject1 + "\n";
      }
      i1 += 1;
      localObject1 = localObject2;
    }
    Object localObject2 = localObject1;
    if (this.f.a.size() != 0) {
      localObject2 = (String)localObject1 + this.f + "\n";
    }
    System.out.println((String)localObject2);
  }
  
  public c getCache()
  {
    return this.c;
  }
  
  public int getMemoryUsed()
  {
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.k; i2 = i3)
    {
      i3 = i2;
      if (this.i[i1] != null) {
        i3 = i2 + this.i[i1].d();
      }
      i1 += 1;
    }
    return i2;
  }
  
  public int getNumEquations()
  {
    return this.k;
  }
  
  public int getNumVariables()
  {
    return this.a;
  }
  
  public int getObjectVariableValue(Object paramObject)
  {
    paramObject = ((android.support.constraint.a.a.a)paramObject).getSolverVariable();
    if (paramObject != null) {
      return (int)(((g)paramObject).d + 0.5F);
    }
    return 0;
  }
  
  public void minimize()
    throws Exception
  {
    a(this.f);
  }
  
  public void reset()
  {
    int i1 = 0;
    while (i1 < this.c.c.length)
    {
      g localg = this.c.c[i1];
      if (localg != null) {
        localg.reset();
      }
      i1 += 1;
    }
    this.c.b.releaseAll(this.m, this.n);
    this.n = 0;
    Arrays.fill(this.c.c, null);
    if (this.e != null) {
      this.e.clear();
    }
    this.a = 0;
    this.f.a.clear();
    this.b = 1;
    i1 = 0;
    while (i1 < this.k)
    {
      this.i[i1].c = false;
      i1 += 1;
    }
    b();
    this.k = 0;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/constraint/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */