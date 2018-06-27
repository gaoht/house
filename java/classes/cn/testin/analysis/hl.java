package cn.testin.analysis;

final class hl
{
  private final int a;
  private final byte[] b;
  
  private hl(int paramInt, byte[] paramArrayOfByte)
  {
    this.a = paramInt;
    this.b = paramArrayOfByte;
  }
  
  static hl[] a(byte[] paramArrayOfByte, ic paramic, hy paramhy)
  {
    if (paramArrayOfByte.length != paramic.c()) {
      throw new IllegalArgumentException();
    }
    paramic = paramic.a(paramhy);
    paramhy = paramic.b();
    int k = paramhy.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += paramhy[i].a();
      i += 1;
    }
    hl[] arrayOfhl = new hl[j];
    int m = paramhy.length;
    k = 0;
    int n;
    for (j = 0; k < m; j = i)
    {
      Object localObject = paramhy[k];
      i = j;
      j = 0;
      while (j < ((id)localObject).a())
      {
        n = ((id)localObject).b();
        arrayOfhl[i] = new hl(n, new byte[paramic.a() + n]);
        j += 1;
        i += 1;
      }
      k += 1;
    }
    k = arrayOfhl[0].b.length;
    i = arrayOfhl.length - 1;
    int i1;
    if ((i < 0) || (arrayOfhl[i].b.length == k))
    {
      i1 = i + 1;
      n = k - paramic.a();
      k = 0;
      i = 0;
    }
    for (;;)
    {
      if (k >= n) {
        break label273;
      }
      m = 0;
      for (;;)
      {
        if (m < j)
        {
          arrayOfhl[m].b[k] = paramArrayOfByte[i];
          m += 1;
          i += 1;
          continue;
          i -= 1;
          break;
        }
      }
      k += 1;
    }
    label273:
    m = i1;
    k = i;
    while (m < j)
    {
      arrayOfhl[m].b[n] = paramArrayOfByte[k];
      m += 1;
      k += 1;
    }
    int i2 = arrayOfhl[0].b.length;
    i = n;
    while (i < i2)
    {
      m = 0;
      if (m < j)
      {
        if (m < i1) {}
        for (n = i;; n = i + 1)
        {
          arrayOfhl[m].b[n] = paramArrayOfByte[k];
          m += 1;
          k += 1;
          break;
        }
      }
      i += 1;
    }
    return arrayOfhl;
  }
  
  int a()
  {
    return this.a;
  }
  
  byte[] b()
  {
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/hl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */