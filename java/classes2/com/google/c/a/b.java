package com.google.c.a;

public final class b
{
  private final int a;
  private final int b;
  private final int c;
  private final int[] d;
  
  public b(int paramInt)
  {
    this(paramInt, paramInt);
  }
  
  public b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 1) || (paramInt2 < 1)) {
      throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = (paramInt1 + 31 >> 5);
    this.d = new int[this.c * paramInt2];
  }
  
  public void clear()
  {
    int j = this.d.length;
    int i = 0;
    while (i < j)
    {
      this.d[i] = 0;
      i += 1;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b)) {}
    do
    {
      return false;
      paramObject = (b)paramObject;
    } while ((this.a != ((b)paramObject).a) || (this.b != ((b)paramObject).b) || (this.c != ((b)paramObject).c) || (this.d.length != ((b)paramObject).d.length));
    int i = 0;
    for (;;)
    {
      if (i >= this.d.length) {
        break label93;
      }
      if (this.d[i] != paramObject.d[i]) {
        break;
      }
      i += 1;
    }
    label93:
    return true;
  }
  
  public void flip(int paramInt1, int paramInt2)
  {
    paramInt2 = this.c * paramInt2 + (paramInt1 >> 5);
    int[] arrayOfInt = this.d;
    arrayOfInt[paramInt2] ^= 1 << (paramInt1 & 0x1F);
  }
  
  public boolean get(int paramInt1, int paramInt2)
  {
    int i = this.c;
    return (this.d[(i * paramInt2 + (paramInt1 >> 5))] >>> (paramInt1 & 0x1F) & 0x1) != 0;
  }
  
  public int[] getBottomRightOnBit()
  {
    int i = this.d.length - 1;
    while ((i >= 0) && (this.d[i] == 0)) {
      i -= 1;
    }
    if (i < 0) {
      return null;
    }
    int k = i / this.c;
    int m = this.c;
    int n = this.d[i];
    int j = 31;
    while (n >>> j == 0) {
      j -= 1;
    }
    return new int[] { (i % m << 5) + j, k };
  }
  
  public int[] getEnclosingRectangle()
  {
    int m = this.a;
    int k = this.b;
    int j = -1;
    int i1 = -1;
    int i = 0;
    int i2;
    label29:
    int n;
    if (i < this.b)
    {
      i2 = 0;
      if (i2 < this.c)
      {
        int i3 = this.d[(this.c * i + i2)];
        if (i3 == 0) {
          break label296;
        }
        n = k;
        if (i < k) {
          n = i;
        }
        k = i1;
        if (i > i1) {
          k = i;
        }
        if (i2 * 32 >= m) {
          break label289;
        }
        i1 = 0;
        while (i3 << 31 - i1 == 0) {
          i1 += 1;
        }
        if (i2 * 32 + i1 >= m) {
          break label289;
        }
        i1 = i2 * 32 + i1;
        label137:
        if (i2 * 32 + 31 <= j) {
          break label274;
        }
        m = 31;
        while (i3 >>> m == 0) {
          m -= 1;
        }
        if (i2 * 32 + m <= j) {
          break label274;
        }
        i3 = i2 * 32 + m;
        j = k;
        m = n;
        k = i3;
      }
    }
    for (;;)
    {
      i2 += 1;
      n = i1;
      i1 = j;
      j = k;
      k = m;
      m = n;
      break label29;
      i += 1;
      break;
      i = j - m;
      j = i1 - k;
      if ((i < 0) || (j < 0)) {
        return null;
      }
      return new int[] { m, k, i, j };
      label274:
      m = n;
      n = j;
      j = k;
      k = n;
      continue;
      label289:
      i1 = m;
      break label137;
      label296:
      n = m;
      m = k;
      k = j;
      j = i1;
      i1 = n;
    }
  }
  
  public int getHeight()
  {
    return this.b;
  }
  
  public a getRow(int paramInt, a parama)
  {
    a locala;
    if (parama != null)
    {
      locala = parama;
      if (parama.getSize() >= this.a) {}
    }
    else
    {
      locala = new a(this.a);
    }
    int j = this.c;
    int i = 0;
    while (i < this.c)
    {
      locala.setBulk(i << 5, this.d[(paramInt * j + i)]);
      i += 1;
    }
    return locala;
  }
  
  public int[] getTopLeftOnBit()
  {
    int i = 0;
    while ((i < this.d.length) && (this.d[i] == 0)) {
      i += 1;
    }
    if (i == this.d.length) {
      return null;
    }
    int k = i / this.c;
    int m = this.c;
    int n = this.d[i];
    int j = 0;
    while (n << 31 - j == 0) {
      j += 1;
    }
    return new int[] { (i % m << 5) + j, k };
  }
  
  public int getWidth()
  {
    return this.a;
  }
  
  public int hashCode()
  {
    int i = this.a;
    int j = this.a;
    int k = this.b;
    j = this.c + ((i * 31 + j) * 31 + k) * 31;
    int[] arrayOfInt = this.d;
    k = arrayOfInt.length;
    i = 0;
    while (i < k)
    {
      j = j * 31 + arrayOfInt[i];
      i += 1;
    }
    return j;
  }
  
  public void set(int paramInt1, int paramInt2)
  {
    paramInt2 = this.c * paramInt2 + (paramInt1 >> 5);
    int[] arrayOfInt = this.d;
    arrayOfInt[paramInt2] |= 1 << (paramInt1 & 0x1F);
  }
  
  public void setRegion(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 < 0) || (paramInt1 < 0)) {
      throw new IllegalArgumentException("Left and top must be nonnegative");
    }
    if ((paramInt4 < 1) || (paramInt3 < 1)) {
      throw new IllegalArgumentException("Height and width must be at least 1");
    }
    int i = paramInt1 + paramInt3;
    paramInt4 = paramInt2 + paramInt4;
    if ((paramInt4 > this.b) || (i > this.a)) {
      throw new IllegalArgumentException("The region must fit inside the matrix");
    }
    for (;;)
    {
      paramInt2 += 1;
      if (paramInt2 >= paramInt4) {
        break;
      }
      int j = this.c;
      paramInt3 = paramInt1;
      while (paramInt3 < i)
      {
        int[] arrayOfInt = this.d;
        int k = (paramInt3 >> 5) + paramInt2 * j;
        arrayOfInt[k] |= 1 << (paramInt3 & 0x1F);
        paramInt3 += 1;
      }
    }
  }
  
  public void setRow(int paramInt, a parama)
  {
    System.arraycopy(parama.getBitArray(), 0, this.d, this.c * paramInt, this.c);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.b * (this.a + 1));
    int i = 0;
    while (i < this.b)
    {
      int j = 0;
      if (j < this.a)
      {
        if (get(j, i)) {}
        for (String str = "X ";; str = "  ")
        {
          localStringBuilder.append(str);
          j += 1;
          break;
        }
      }
      localStringBuilder.append('\n');
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */