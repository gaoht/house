package cn.testin.analysis;

public class gz
  extends fp
{
  private static final byte[] a = new byte[0];
  private byte[] b = a;
  private final int[] c = new int[32];
  
  public gz(fu paramfu)
  {
    super(paramfu);
  }
  
  private static int a(int[] paramArrayOfInt)
  {
    int i2 = 0;
    int i3 = paramArrayOfInt.length;
    int i = 0;
    int m = 0;
    int j = 0;
    int i1;
    for (int n = 0; i < i3; n = i1)
    {
      k = m;
      if (paramArrayOfInt[i] > m)
      {
        k = paramArrayOfInt[i];
        j = i;
      }
      i1 = n;
      if (paramArrayOfInt[i] > n) {
        i1 = paramArrayOfInt[i];
      }
      i += 1;
      m = k;
    }
    m = 0;
    i = 0;
    int k = i2;
    if (k < i3)
    {
      i1 = k - j;
      i1 *= paramArrayOfInt[k] * i1;
      if (i1 <= m) {
        break label252;
      }
      m = k;
      i = i1;
    }
    for (;;)
    {
      k += 1;
      i1 = m;
      m = i;
      i = i1;
      break;
      if (j > i)
      {
        i1 = i;
        m = j;
      }
      for (;;)
      {
        if (m - i1 <= i3 / 16) {
          throw fw.a();
        }
        j = m - 1;
        k = -1;
        i = m - 1;
        if (i > i1)
        {
          i2 = i - i1;
          i2 = i2 * i2 * (m - i) * (n - paramArrayOfInt[i]);
          if (i2 <= k) {
            break label232;
          }
          k = i;
          j = i2;
        }
        for (;;)
        {
          i -= 1;
          i2 = k;
          k = j;
          j = i2;
          break;
          return j << 3;
          label232:
          i2 = j;
          j = k;
          k = i2;
        }
        m = i;
        i1 = j;
      }
      label252:
      i1 = i;
      i = m;
      m = i1;
    }
  }
  
  private void a(int paramInt)
  {
    if (this.b.length < paramInt) {
      this.b = new byte[paramInt];
    }
    paramInt = 0;
    while (paramInt < 32)
    {
      this.c[paramInt] = 0;
      paramInt += 1;
    }
  }
  
  public gt b()
  {
    Object localObject = a();
    int k = ((fu)localObject).b();
    int m = ((fu)localObject).c();
    gt localgt = new gt(k, m);
    a(k);
    int[] arrayOfInt = this.c;
    int i = 1;
    int j;
    while (i < 5)
    {
      byte[] arrayOfByte = ((fu)localObject).a(m * i / 5, this.b);
      n = k * 4 / 5;
      j = k / 5;
      while (j < n)
      {
        int i1 = (arrayOfByte[j] & 0xFF) >> 3;
        arrayOfInt[i1] += 1;
        j += 1;
      }
      i += 1;
    }
    int n = a(arrayOfInt);
    localObject = ((fu)localObject).a();
    i = 0;
    while (i < m)
    {
      j = 0;
      while (j < k)
      {
        if ((localObject[(i * k + j)] & 0xFF) < n) {
          localgt.b(j, i);
        }
        j += 1;
      }
      i += 1;
    }
    return localgt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/gz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */