package android.support.constraint.a;

public class b
{
  g a = null;
  float b = 0.0F;
  boolean c = false;
  final a d;
  boolean e = false;
  
  public b(c paramc)
  {
    this.d = new a(this, paramc);
  }
  
  b a(g paramg, int paramInt)
  {
    this.a = paramg;
    paramg.d = paramInt;
    this.b = paramInt;
    this.e = true;
    return this;
  }
  
  b a(g paramg1, g paramg2, int paramInt1, float paramFloat, g paramg3, g paramg4, int paramInt2)
  {
    if (paramg2 == paramg3)
    {
      this.d.put(paramg1, 1.0F);
      this.d.put(paramg4, 1.0F);
      this.d.put(paramg2, -2.0F);
    }
    do
    {
      do
      {
        return this;
        if (paramFloat != 0.5F) {
          break;
        }
        this.d.put(paramg1, 1.0F);
        this.d.put(paramg2, -1.0F);
        this.d.put(paramg3, -1.0F);
        this.d.put(paramg4, 1.0F);
      } while ((paramInt1 <= 0) && (paramInt2 <= 0));
      this.b = (-paramInt1 + paramInt2);
      return this;
      if (paramFloat <= 0.0F)
      {
        this.d.put(paramg1, -1.0F);
        this.d.put(paramg2, 1.0F);
        this.b = paramInt1;
        return this;
      }
      if (paramFloat >= 1.0F)
      {
        this.d.put(paramg3, -1.0F);
        this.d.put(paramg4, 1.0F);
        this.b = paramInt2;
        return this;
      }
      this.d.put(paramg1, (1.0F - paramFloat) * 1.0F);
      this.d.put(paramg2, (1.0F - paramFloat) * -1.0F);
      this.d.put(paramg3, -1.0F * paramFloat);
      this.d.put(paramg4, 1.0F * paramFloat);
    } while ((paramInt1 <= 0) && (paramInt2 <= 0));
    this.b = (-paramInt1 * (1.0F - paramFloat) + paramInt2 * paramFloat);
    return this;
  }
  
  b a(g paramg1, g paramg2, g paramg3, float paramFloat)
  {
    this.d.put(paramg1, -1.0F);
    this.d.put(paramg2, 1.0F - paramFloat);
    this.d.put(paramg3, paramFloat);
    return this;
  }
  
  void a()
  {
    this.d.a(this);
  }
  
  boolean a(b paramb)
  {
    this.d.a(this, paramb);
    return true;
  }
  
  boolean a(g paramg)
  {
    return this.d.a(paramg);
  }
  
  public b addError(g paramg1, g paramg2)
  {
    this.d.put(paramg1, 1.0F);
    this.d.put(paramg2, -1.0F);
    return this;
  }
  
  b b(g paramg, int paramInt)
  {
    this.d.put(paramg, paramInt);
    return this;
  }
  
  void b(g paramg)
  {
    if (this.a != null)
    {
      this.d.put(this.a, -1.0F);
      this.a = null;
    }
    float f = this.d.remove(paramg) * -1.0F;
    this.a = paramg;
    if (f == 1.0F) {
      return;
    }
    this.b /= f;
    this.d.a(f);
  }
  
  boolean b()
  {
    return (this.a != null) && ((this.a.f == g.a.a) || (this.b >= 0.0F));
  }
  
  String c()
  {
    String str;
    if (this.a == null)
    {
      str = "" + "0";
      str = str + " = ";
      if (this.b == 0.0F) {
        break label369;
      }
      str = str + this.b;
    }
    label205:
    label366:
    label369:
    for (int i = 1;; i = 0)
    {
      int k = this.d.a;
      int j = 0;
      Object localObject;
      float f;
      for (;;)
      {
        if (j < k)
        {
          localObject = this.d.a(j);
          if (localObject == null)
          {
            j += 1;
            continue;
            str = "" + this.a;
            break;
          }
          f = this.d.b(j);
          localObject = ((g)localObject).toString();
          if (i == 0)
          {
            if (f >= 0.0F) {
              break label366;
            }
            str = str + "- ";
            f *= -1.0F;
          }
        }
      }
      for (;;)
      {
        if (f == 1.0F) {}
        for (str = str + (String)localObject;; str = str + f + " " + (String)localObject)
        {
          i = 1;
          break;
          if (f > 0.0F)
          {
            str = str + " + ";
            break label205;
          }
          str = str + " - ";
          f *= -1.0F;
          break label205;
        }
        localObject = str;
        if (i == 0) {
          localObject = str + "0.0";
        }
        return (String)localObject;
      }
    }
  }
  
  public b createRowDimensionRatio(g paramg1, g paramg2, g paramg3, g paramg4, float paramFloat)
  {
    this.d.put(paramg1, -1.0F);
    this.d.put(paramg2, 1.0F);
    this.d.put(paramg3, paramFloat);
    this.d.put(paramg4, -paramFloat);
    return this;
  }
  
  public b createRowEqualDimension(float paramFloat1, float paramFloat2, float paramFloat3, g paramg1, int paramInt1, g paramg2, int paramInt2, g paramg3, int paramInt3, g paramg4, int paramInt4)
  {
    if ((paramFloat2 == 0.0F) || (paramFloat1 == paramFloat3))
    {
      this.b = (-paramInt1 - paramInt2 + paramInt3 + paramInt4);
      this.d.put(paramg1, 1.0F);
      this.d.put(paramg2, -1.0F);
      this.d.put(paramg4, 1.0F);
      this.d.put(paramg3, -1.0F);
      return this;
    }
    paramFloat1 = paramFloat1 / paramFloat2 / (paramFloat3 / paramFloat2);
    this.b = (-paramInt1 - paramInt2 + paramInt3 * paramFloat1 + paramInt4 * paramFloat1);
    this.d.put(paramg1, 1.0F);
    this.d.put(paramg2, -1.0F);
    this.d.put(paramg4, paramFloat1);
    this.d.put(paramg3, -paramFloat1);
    return this;
  }
  
  public b createRowEquals(g paramg, int paramInt)
  {
    if (paramInt < 0)
    {
      this.b = (paramInt * -1);
      this.d.put(paramg, 1.0F);
      return this;
    }
    this.b = paramInt;
    this.d.put(paramg, -1.0F);
    return this;
  }
  
  public b createRowEquals(g paramg1, g paramg2, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = j;
      j = paramInt;
      if (paramInt < 0)
      {
        j = paramInt * -1;
        i = 1;
      }
      this.b = j;
    }
    if (i == 0)
    {
      this.d.put(paramg1, -1.0F);
      this.d.put(paramg2, 1.0F);
      return this;
    }
    this.d.put(paramg1, 1.0F);
    this.d.put(paramg2, -1.0F);
    return this;
  }
  
  public b createRowGreaterThan(g paramg1, g paramg2, g paramg3, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = j;
      j = paramInt;
      if (paramInt < 0)
      {
        j = paramInt * -1;
        i = 1;
      }
      this.b = j;
    }
    if (i == 0)
    {
      this.d.put(paramg1, -1.0F);
      this.d.put(paramg2, 1.0F);
      this.d.put(paramg3, 1.0F);
      return this;
    }
    this.d.put(paramg1, 1.0F);
    this.d.put(paramg2, -1.0F);
    this.d.put(paramg3, -1.0F);
    return this;
  }
  
  public b createRowLowerThan(g paramg1, g paramg2, g paramg3, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = j;
      j = paramInt;
      if (paramInt < 0)
      {
        j = paramInt * -1;
        i = 1;
      }
      this.b = j;
    }
    if (i == 0)
    {
      this.d.put(paramg1, -1.0F);
      this.d.put(paramg2, 1.0F);
      this.d.put(paramg3, -1.0F);
      return this;
    }
    this.d.put(paramg1, 1.0F);
    this.d.put(paramg2, -1.0F);
    this.d.put(paramg3, 1.0F);
    return this;
  }
  
  int d()
  {
    int i = 0;
    if (this.a != null) {
      i = 4;
    }
    return i + 4 + 4 + this.d.c();
  }
  
  void e()
  {
    if (this.b < 0.0F)
    {
      this.b *= -1.0F;
      this.d.a();
    }
  }
  
  void f()
  {
    g localg = this.d.b();
    if (localg != null) {
      b(localg);
    }
    if (this.d.a == 0) {
      this.e = true;
    }
  }
  
  public void reset()
  {
    this.a = null;
    this.d.clear();
    this.b = 0.0F;
    this.e = false;
  }
  
  public String toString()
  {
    return c();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/constraint/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */