package cn.testin.analysis;

final class hk
{
  private final gt a;
  private ic b;
  private hz c;
  private boolean d;
  
  hk(gt paramgt)
  {
    int i = paramgt.d();
    if ((i < 21) || ((i & 0x3) != 1)) {
      throw ft.a();
    }
    this.a = paramgt;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.d) {}
    for (boolean bool = this.a.a(paramInt2, paramInt1); bool; bool = this.a.a(paramInt1, paramInt2)) {
      return paramInt3 << 1 | 0x1;
    }
    return paramInt3 << 1;
  }
  
  hz a()
  {
    int k = 0;
    if (this.c != null) {
      return this.c;
    }
    int i = 0;
    int j = 0;
    while (i < 6)
    {
      j = a(i, 8, j);
      i += 1;
    }
    j = a(8, 7, a(8, 8, a(7, 8, j)));
    i = 5;
    while (i >= 0)
    {
      j = a(8, i, j);
      i -= 1;
    }
    int n = this.a.d();
    int m = n - 1;
    i = k;
    k = m;
    while (k >= n - 7)
    {
      i = a(8, k, i);
      k -= 1;
    }
    m = n - 8;
    k = i;
    i = m;
    while (i < n)
    {
      k = a(i, 8, k);
      i += 1;
    }
    this.c = hz.b(j, k);
    if (this.c != null) {
      return this.c;
    }
    throw ft.a();
  }
  
  void a(boolean paramBoolean)
  {
    this.b = null;
    this.c = null;
    this.d = paramBoolean;
  }
  
  ic b()
  {
    if (this.b != null) {
      return this.b;
    }
    int m = this.a.d();
    int i = (m - 17) / 4;
    if (i <= 6) {
      return ic.b(i);
    }
    int n = m - 11;
    i = 5;
    int j = 0;
    int k;
    while (i >= 0)
    {
      k = m - 9;
      while (k >= n)
      {
        j = a(k, i, j);
        k -= 1;
      }
      i -= 1;
    }
    ic localic = ic.c(j);
    if ((localic != null) && (localic.d() == m))
    {
      this.b = localic;
      return localic;
    }
    j = 0;
    i = 5;
    while (i >= 0)
    {
      k = m - 9;
      while (k >= n)
      {
        j = a(i, k, j);
        k -= 1;
      }
      i -= 1;
    }
    localic = ic.c(j);
    if ((localic != null) && (localic.d() == m))
    {
      this.b = localic;
      return localic;
    }
    throw ft.a();
  }
  
  byte[] c()
  {
    Object localObject = a();
    ic localic = b();
    localObject = hm.values()[localObject.b()];
    int i7 = this.a.d();
    ((hm)localObject).a(this.a, i7);
    localObject = localic.e();
    byte[] arrayOfByte = new byte[localic.c()];
    int i = i7 - 1;
    int j = 0;
    int k = 0;
    int i4 = 0;
    int n = 1;
    while (i > 0)
    {
      int i1 = i;
      if (i == 6) {
        i1 = i - 1;
      }
      i = 0;
      while (i < i7)
      {
        if (n != 0) {}
        int m;
        int i6;
        for (int i2 = i7 - 1 - i;; i2 = i)
        {
          int i3 = 0;
          m = k;
          i6 = j;
          while (i3 < 2)
          {
            k = i6;
            j = m;
            int i5 = i4;
            if (!((gt)localObject).a(i1 - i3, i2))
            {
              i6 += 1;
              j = m << 1;
              m = j;
              if (this.a.a(i1 - i3, i2)) {
                m = j | 0x1;
              }
              k = i6;
              j = m;
              i5 = i4;
              if (i6 == 8)
              {
                arrayOfByte[i4] = ((byte)m);
                j = 0;
                i5 = i4 + 1;
                k = 0;
              }
            }
            i3 += 1;
            i6 = k;
            m = j;
            i4 = i5;
          }
        }
        i += 1;
        j = i6;
        k = m;
      }
      i = i1 - 2;
      n ^= 0x1;
    }
    if (i4 != localic.c()) {
      throw ft.a();
    }
    return arrayOfByte;
  }
  
  void d()
  {
    if (this.c == null) {
      return;
    }
    hm localhm = hm.values()[this.c.b()];
    int i = this.a.d();
    localhm.a(this.a, i);
  }
  
  void e()
  {
    int i = 0;
    while (i < this.a.c())
    {
      int j = i + 1;
      while (j < this.a.d())
      {
        if (this.a.a(i, j) != this.a.a(j, i))
        {
          this.a.c(j, i);
          this.a.c(i, j);
        }
        j += 1;
      }
      i += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/hk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */