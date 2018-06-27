package cn.testin.analysis;

final class hg
{
  private final hf a;
  private final int[] b;
  
  hg(hf paramhf, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 0) {
      throw new IllegalArgumentException();
    }
    this.a = paramhf;
    int j = paramArrayOfInt.length;
    if ((j > 1) && (paramArrayOfInt[0] == 0))
    {
      int i = 1;
      while ((i < j) && (paramArrayOfInt[i] == 0)) {
        i += 1;
      }
      if (i == j)
      {
        this.b = new int[] { 0 };
        return;
      }
      this.b = new int[j - i];
      System.arraycopy(paramArrayOfInt, i, this.b, 0, this.b.length);
      return;
    }
    this.b = paramArrayOfInt;
  }
  
  int a()
  {
    return this.b.length - 1;
  }
  
  int a(int paramInt)
  {
    return this.b[(this.b.length - 1 - paramInt)];
  }
  
  hg a(int paramInt1, int paramInt2)
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
    return new hg(this.a, arrayOfInt);
  }
  
  hg a(hg paramhg)
  {
    if (!this.a.equals(paramhg.a)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (b()) {
      return paramhg;
    }
    if (paramhg.b()) {
      return this;
    }
    Object localObject = this.b;
    int[] arrayOfInt = paramhg.b;
    if (localObject.length > arrayOfInt.length) {
      paramhg = arrayOfInt;
    }
    for (;;)
    {
      arrayOfInt = new int[localObject.length];
      int j = localObject.length - paramhg.length;
      System.arraycopy(localObject, 0, arrayOfInt, 0, j);
      int i = j;
      while (i < localObject.length)
      {
        arrayOfInt[i] = hf.b(paramhg[(i - j)], localObject[i]);
        i += 1;
      }
      return new hg(this.a, arrayOfInt);
      paramhg = (hg)localObject;
      localObject = arrayOfInt;
    }
  }
  
  int b(int paramInt)
  {
    int j = 0;
    int i;
    if (paramInt == 0)
    {
      i = a(0);
      return i;
    }
    if (paramInt == 1)
    {
      int[] arrayOfInt = this.b;
      k = arrayOfInt.length;
      paramInt = 0;
      for (;;)
      {
        i = paramInt;
        if (j >= k) {
          break;
        }
        paramInt = hf.b(paramInt, arrayOfInt[j]);
        j += 1;
      }
    }
    j = this.b[0];
    int m = this.b.length;
    int k = 1;
    for (;;)
    {
      i = j;
      if (k >= m) {
        break;
      }
      j = hf.b(this.a.c(paramInt, j), this.b[k]);
      k += 1;
    }
  }
  
  hg b(hg paramhg)
  {
    if (!this.a.equals(paramhg.a)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if ((b()) || (paramhg.b())) {
      return this.a.a();
    }
    int[] arrayOfInt1 = this.b;
    int k = arrayOfInt1.length;
    paramhg = paramhg.b;
    int m = paramhg.length;
    int[] arrayOfInt2 = new int[k + m - 1];
    int i = 0;
    while (i < k)
    {
      int n = arrayOfInt1[i];
      int j = 0;
      while (j < m)
      {
        arrayOfInt2[(i + j)] = hf.b(arrayOfInt2[(i + j)], this.a.c(n, paramhg[j]));
        j += 1;
      }
      i += 1;
    }
    return new hg(this.a, arrayOfInt2);
  }
  
  boolean b()
  {
    boolean bool = false;
    if (this.b[0] == 0) {
      bool = true;
    }
    return bool;
  }
  
  hg c(int paramInt)
  {
    if (paramInt == 0) {
      localObject = this.a.a();
    }
    do
    {
      return (hg)localObject;
      localObject = this;
    } while (paramInt == 1);
    int j = this.b.length;
    Object localObject = new int[j];
    int i = 0;
    while (i < j)
    {
      localObject[i] = this.a.c(this.b[i], paramInt);
      i += 1;
    }
    return new hg(this.a, (int[])localObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(a() * 8);
    int i = a();
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


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/hg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */