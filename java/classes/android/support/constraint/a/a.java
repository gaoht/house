package android.support.constraint.a;

import java.io.PrintStream;
import java.util.Arrays;

public class a
{
  int a = 0;
  private final b b;
  private final c c;
  private int d = 8;
  private g e = null;
  private int[] f = new int[this.d];
  private int[] g = new int[this.d];
  private float[] h = new float[this.d];
  private int i = -1;
  private int j = -1;
  private boolean k = false;
  
  a(b paramb, c paramc)
  {
    this.b = paramb;
    this.c = paramc;
  }
  
  final g a(int paramInt)
  {
    int n = this.i;
    int m = 0;
    while ((n != -1) && (m < this.a))
    {
      if (m == paramInt) {
        return this.c.c[this.f[n]];
      }
      n = this.g[n];
      m += 1;
    }
    return null;
  }
  
  void a()
  {
    int n = this.i;
    int m = 0;
    while ((n != -1) && (m < this.a))
    {
      float[] arrayOfFloat = this.h;
      arrayOfFloat[n] *= -1.0F;
      n = this.g[n];
      m += 1;
    }
  }
  
  void a(float paramFloat)
  {
    int n = this.i;
    int m = 0;
    while ((n != -1) && (m < this.a))
    {
      float[] arrayOfFloat = this.h;
      arrayOfFloat[n] /= paramFloat;
      n = this.g[n];
      m += 1;
    }
  }
  
  void a(b paramb)
  {
    int n = this.i;
    int m = 0;
    while ((n != -1) && (m < this.a))
    {
      this.c.c[this.f[n]].a(paramb);
      n = this.g[n];
      m += 1;
    }
  }
  
  void a(b paramb1, b paramb2)
  {
    int n = this.i;
    int m = 0;
    while ((n != -1) && (m < this.a)) {
      if (this.f[n] == paramb2.a.a)
      {
        float f1 = this.h[n];
        remove(paramb2.a);
        a locala = paramb2.d;
        n = locala.i;
        m = 0;
        while ((n != -1) && (m < locala.a))
        {
          add(this.c.c[locala.f[n]], locala.h[n] * f1);
          n = locala.g[n];
          m += 1;
        }
        paramb1.b += paramb2.b * f1;
        paramb2.a.b(paramb1);
        n = this.i;
        m = 0;
      }
      else
      {
        n = this.g[n];
        m += 1;
      }
    }
  }
  
  void a(b paramb, b[] paramArrayOfb)
  {
    int n = this.i;
    int m = 0;
    while ((n != -1) && (m < this.a))
    {
      Object localObject = this.c.c[this.f[n]];
      if (((g)localObject).b != -1)
      {
        float f1 = this.h[n];
        remove((g)localObject);
        localObject = paramArrayOfb[localObject.b];
        if (!((b)localObject).e)
        {
          a locala = ((b)localObject).d;
          n = locala.i;
          m = 0;
          while ((n != -1) && (m < locala.a))
          {
            add(this.c.c[locala.f[n]], locala.h[n] * f1);
            n = locala.g[n];
            m += 1;
          }
        }
        paramb.b += ((b)localObject).b * f1;
        ((b)localObject).a.b(paramb);
        n = this.i;
        m = 0;
      }
      else
      {
        n = this.g[n];
        m += 1;
      }
    }
  }
  
  final boolean a(g paramg)
  {
    if (this.i == -1) {}
    for (;;)
    {
      return false;
      int n = this.i;
      int m = 0;
      while ((n != -1) && (m < this.a))
      {
        if (this.f[n] == paramg.a) {
          return true;
        }
        n = this.g[n];
        m += 1;
      }
    }
  }
  
  public final void add(g paramg, float paramFloat)
  {
    if (paramFloat == 0.0F) {}
    do
    {
      return;
      if (this.i != -1) {
        break;
      }
      this.i = 0;
      this.h[this.i] = paramFloat;
      this.f[this.i] = paramg.a;
      this.g[this.i] = -1;
      this.a += 1;
    } while (this.k);
    this.j += 1;
    return;
    int m = this.i;
    int n = 0;
    int i2 = -1;
    int i1;
    for (;;)
    {
      if ((m == -1) || (n >= this.a)) {
        break label253;
      }
      i1 = this.f[m];
      if (i1 == paramg.a)
      {
        paramg = this.h;
        paramg[m] += paramFloat;
        if (this.h[m] != 0.0F) {
          break;
        }
        if (m == this.i) {
          this.i = this.g[m];
        }
        for (;;)
        {
          this.c.c[i1].b(this.b);
          if (this.k) {
            this.j = m;
          }
          this.a -= 1;
          return;
          this.g[i2] = this.g[m];
        }
      }
      if (this.f[m] < paramg.a) {
        i2 = m;
      }
      m = this.g[m];
      n += 1;
    }
    label253:
    m = this.j + 1;
    if (this.k)
    {
      if (this.f[this.j] == -1) {
        m = this.j;
      }
    }
    else
    {
      label285:
      n = m;
      if (m >= this.f.length)
      {
        n = m;
        if (this.a < this.f.length)
        {
          i1 = 0;
          label315:
          n = m;
          if (i1 < this.f.length)
          {
            if (this.f[i1] != -1) {
              break label538;
            }
            n = i1;
          }
        }
      }
      m = n;
      if (n >= this.f.length)
      {
        m = this.f.length;
        this.d *= 2;
        this.k = false;
        this.j = (m - 1);
        this.h = Arrays.copyOf(this.h, this.d);
        this.f = Arrays.copyOf(this.f, this.d);
        this.g = Arrays.copyOf(this.g, this.d);
      }
      this.f[m] = paramg.a;
      this.h[m] = paramFloat;
      if (i2 == -1) {
        break label547;
      }
      this.g[m] = this.g[i2];
      this.g[i2] = m;
    }
    for (;;)
    {
      this.a += 1;
      if (!this.k) {
        this.j += 1;
      }
      if (this.j < this.f.length) {
        break;
      }
      this.k = true;
      this.j = (this.f.length - 1);
      return;
      m = this.f.length;
      break label285;
      label538:
      i1 += 1;
      break label315;
      label547:
      this.g[m] = this.i;
      this.i = m;
    }
  }
  
  final float b(int paramInt)
  {
    int n = this.i;
    int m = 0;
    while ((n != -1) && (m < this.a))
    {
      if (m == paramInt) {
        return this.h[n];
      }
      n = this.g[n];
      m += 1;
    }
    return 0.0F;
  }
  
  g b()
  {
    Object localObject2 = null;
    int n = this.i;
    int m = 0;
    Object localObject1 = null;
    float f1;
    if ((n != -1) && (m < this.a))
    {
      f1 = this.h[n];
      if (f1 < 0.0F)
      {
        if (f1 <= -0.001F) {
          break label185;
        }
        this.h[n] = 0.0F;
        f1 = 0.0F;
      }
    }
    label182:
    label185:
    for (;;)
    {
      g localg;
      if (f1 != 0.0F)
      {
        localg = this.c.c[this.f[n]];
        if (localg.f == g.a.a)
        {
          if (f1 < 0.0F)
          {
            return localg;
            if (f1 >= 0.001F) {
              break label185;
            }
            this.h[n] = 0.0F;
            f1 = 0.0F;
            continue;
          }
          if (localObject1 != null) {
            break label182;
          }
          localObject1 = localg;
        }
      }
      for (;;)
      {
        n = this.g[n];
        m += 1;
        break;
        if ((f1 < 0.0F) && ((localObject2 == null) || (localg.c < ((g)localObject2).c)))
        {
          localObject2 = localg;
          continue;
          if (localObject1 != null) {
            return (g)localObject1;
          }
          return (g)localObject2;
        }
      }
    }
  }
  
  int c()
  {
    return 0 + this.f.length * 4 * 3 + 36;
  }
  
  public final void clear()
  {
    this.i = -1;
    this.j = -1;
    this.k = false;
    this.a = 0;
  }
  
  public void display()
  {
    int n = this.a;
    System.out.print("{ ");
    int m = 0;
    if (m < n)
    {
      g localg = a(m);
      if (localg == null) {}
      for (;;)
      {
        m += 1;
        break;
        System.out.print(localg + " = " + b(m) + " ");
      }
    }
    System.out.println(" }");
  }
  
  public final float get(g paramg)
  {
    int n = this.i;
    int m = 0;
    while ((n != -1) && (m < this.a))
    {
      if (this.f[n] == paramg.a) {
        return this.h[n];
      }
      n = this.g[n];
      m += 1;
    }
    return 0.0F;
  }
  
  public final void put(g paramg, float paramFloat)
  {
    if (paramFloat == 0.0F) {
      remove(paramg);
    }
    do
    {
      return;
      if (this.i != -1) {
        break;
      }
      this.i = 0;
      this.h[this.i] = paramFloat;
      this.f[this.i] = paramg.a;
      this.g[this.i] = -1;
      this.a += 1;
    } while (this.k);
    this.j += 1;
    return;
    int m = this.i;
    int n = 0;
    int i2 = -1;
    while ((m != -1) && (n < this.a))
    {
      if (this.f[m] == paramg.a)
      {
        this.h[m] = paramFloat;
        return;
      }
      if (this.f[m] < paramg.a) {
        i2 = m;
      }
      m = this.g[m];
      n += 1;
    }
    m = this.j + 1;
    label197:
    int i1;
    if (this.k)
    {
      if (this.f[this.j] == -1) {
        m = this.j;
      }
    }
    else
    {
      n = m;
      if (m >= this.f.length)
      {
        n = m;
        if (this.a < this.f.length)
        {
          i1 = 0;
          label227:
          n = m;
          if (i1 < this.f.length)
          {
            if (this.f[i1] != -1) {
              break label439;
            }
            n = i1;
          }
        }
      }
      m = n;
      if (n >= this.f.length)
      {
        m = this.f.length;
        this.d *= 2;
        this.k = false;
        this.j = (m - 1);
        this.h = Arrays.copyOf(this.h, this.d);
        this.f = Arrays.copyOf(this.f, this.d);
        this.g = Arrays.copyOf(this.g, this.d);
      }
      this.f[m] = paramg.a;
      this.h[m] = paramFloat;
      if (i2 == -1) {
        break label448;
      }
      this.g[m] = this.g[i2];
      this.g[i2] = m;
    }
    for (;;)
    {
      this.a += 1;
      if (!this.k) {
        this.j += 1;
      }
      if (this.a < this.f.length) {
        break;
      }
      this.k = true;
      return;
      m = this.f.length;
      break label197;
      label439:
      i1 += 1;
      break label227;
      label448:
      this.g[m] = this.i;
      this.i = m;
    }
  }
  
  public final float remove(g paramg)
  {
    if (this.e == paramg) {
      this.e = null;
    }
    if (this.i == -1) {}
    for (;;)
    {
      return 0.0F;
      int m = this.i;
      int n = 0;
      int i1 = -1;
      while ((m != -1) && (n < this.a))
      {
        int i2 = this.f[m];
        if (i2 == paramg.a)
        {
          if (m == this.i) {
            this.i = this.g[m];
          }
          for (;;)
          {
            this.c.c[i2].b(this.b);
            this.a -= 1;
            this.f[m] = -1;
            if (this.k) {
              this.j = m;
            }
            return this.h[m];
            this.g[i1] = this.g[m];
          }
        }
        i2 = this.g[m];
        n += 1;
        i1 = m;
        m = i2;
      }
    }
  }
  
  public String toString()
  {
    String str = "";
    int n = this.i;
    int m = 0;
    while ((n != -1) && (m < this.a))
    {
      str = str + " -> ";
      str = str + this.h[n] + " : ";
      str = str + this.c.c[this.f[n]];
      n = this.g[n];
      m += 1;
    }
    return str;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/constraint/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */