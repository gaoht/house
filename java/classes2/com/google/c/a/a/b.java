package com.google.c.a.a;

final class b
{
  private final a a;
  private final int[] b;
  
  b(a parama, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 0) {
      throw new IllegalArgumentException();
    }
    this.a = parama;
    int j = paramArrayOfInt.length;
    if ((j > 1) && (paramArrayOfInt[0] == 0))
    {
      while ((i < j) && (paramArrayOfInt[i] == 0)) {
        i += 1;
      }
      if (i == j)
      {
        this.b = parama.a().b;
        return;
      }
      this.b = new int[j - i];
      System.arraycopy(paramArrayOfInt, i, this.b, 0, this.b.length);
      return;
    }
    this.b = paramArrayOfInt;
  }
  
  int a(int paramInt)
  {
    return this.b[(this.b.length - 1 - paramInt)];
  }
  
  b a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == 0) {
      return this.a.a();
    }
    int i = this.b.length;
    int[] arrayOfInt = new int[i + paramInt1];
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      arrayOfInt[paramInt1] = this.a.c(this.b[paramInt1], paramInt2);
      paramInt1 += 1;
    }
    return new b(this.a, arrayOfInt);
  }
  
  b a(b paramb)
  {
    if (!this.a.equals(paramb.a)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (c()) {
      return paramb;
    }
    if (paramb.c()) {
      return this;
    }
    Object localObject = this.b;
    int[] arrayOfInt = paramb.b;
    if (localObject.length > arrayOfInt.length) {
      paramb = arrayOfInt;
    }
    for (;;)
    {
      arrayOfInt = new int[localObject.length];
      int j = localObject.length - paramb.length;
      System.arraycopy(localObject, 0, arrayOfInt, 0, j);
      int i = j;
      while (i < localObject.length)
      {
        arrayOfInt[i] = a.b(paramb[(i - j)], localObject[i]);
        i += 1;
      }
      return new b(this.a, arrayOfInt);
      paramb = (b)localObject;
      localObject = arrayOfInt;
    }
  }
  
  int[] a()
  {
    return this.b;
  }
  
  int b()
  {
    return this.b.length - 1;
  }
  
  b b(b paramb)
  {
    if (!this.a.equals(paramb.a)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if ((c()) || (paramb.c())) {
      return this.a.a();
    }
    int[] arrayOfInt1 = this.b;
    int k = arrayOfInt1.length;
    paramb = paramb.b;
    int m = paramb.length;
    int[] arrayOfInt2 = new int[k + m - 1];
    int i = 0;
    while (i < k)
    {
      int n = arrayOfInt1[i];
      int j = 0;
      while (j < m)
      {
        arrayOfInt2[(i + j)] = a.b(arrayOfInt2[(i + j)], this.a.c(n, paramb[j]));
        j += 1;
      }
      i += 1;
    }
    return new b(this.a, arrayOfInt2);
  }
  
  boolean c()
  {
    boolean bool = false;
    if (this.b[0] == 0) {
      bool = true;
    }
    return bool;
  }
  
  b[] c(b paramb)
  {
    if (!this.a.equals(paramb.a)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (paramb.c()) {
      throw new IllegalArgumentException("Divide by 0");
    }
    b localb2 = this.a.a();
    int i = paramb.a(paramb.b());
    i = this.a.c(i);
    b localb3;
    for (b localb1 = this; (localb1.b() >= paramb.b()) && (!localb1.c()); localb1 = localb1.a(localb3))
    {
      int j = localb1.b() - paramb.b();
      int k = this.a.c(localb1.a(localb1.b()), i);
      localb3 = paramb.a(j, k);
      localb2 = localb2.a(this.a.a(j, k));
    }
    return new b[] { localb2, localb1 };
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(b() * 8);
    int i = b();
    if (i >= 0)
    {
      int k = a(i);
      int j;
      if (k != 0)
      {
        if (k >= 0) {
          break label104;
        }
        localStringBuilder.append(" - ");
        j = -k;
        label50:
        if ((i == 0) || (j != 1))
        {
          j = this.a.b(j);
          if (j != 0) {
            break label127;
          }
          localStringBuilder.append('1');
        }
        label80:
        if (i != 0)
        {
          if (i != 1) {
            break label161;
          }
          localStringBuilder.append('x');
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        label104:
        j = k;
        if (localStringBuilder.length() <= 0) {
          break label50;
        }
        localStringBuilder.append(" + ");
        j = k;
        break label50;
        label127:
        if (j == 1)
        {
          localStringBuilder.append('a');
          break label80;
        }
        localStringBuilder.append("a^");
        localStringBuilder.append(j);
        break label80;
        label161:
        localStringBuilder.append("x^");
        localStringBuilder.append(i);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */