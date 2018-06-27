package cn.testin.analysis;

public final class hh
{
  private final hf a;
  
  public hh(hf paramhf)
  {
    this.a = paramhf;
  }
  
  private int[] a(hg paramhg)
  {
    int j = 0;
    int i = 1;
    int m = paramhg.a();
    if (m == 1) {
      return new int[] { paramhg.a(1) };
    }
    int[] arrayOfInt = new int[m];
    while ((i < this.a.c()) && (j < m))
    {
      int k = j;
      if (paramhg.b(i) == 0)
      {
        arrayOfInt[j] = this.a.c(i);
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    if (j != m) {
      throw new hi("Error locator degree does not match number of roots");
    }
    return arrayOfInt;
  }
  
  private int[] a(hg paramhg, int[] paramArrayOfInt)
  {
    int n = paramArrayOfInt.length;
    int[] arrayOfInt = new int[n];
    int j = 0;
    int i1;
    int i;
    int k;
    label38:
    int m;
    if (j < n)
    {
      i1 = this.a.c(paramArrayOfInt[j]);
      i = 1;
      k = 0;
      if (k < n)
      {
        if (j == k) {
          break label177;
        }
        m = this.a.c(paramArrayOfInt[k], i1);
        if ((m & 0x1) == 0)
        {
          m |= 0x1;
          label80:
          i = this.a.c(i, m);
        }
      }
    }
    label177:
    for (;;)
    {
      k += 1;
      break label38;
      m &= 0xFFFFFFFE;
      break label80;
      arrayOfInt[j] = this.a.c(paramhg.b(i1), this.a.c(i));
      if (this.a.d() != 0) {
        arrayOfInt[j] = this.a.c(arrayOfInt[j], i1);
      }
      j += 1;
      break;
      return arrayOfInt;
    }
  }
  
  private hg[] a(hg paramhg1, hg paramhg2, int paramInt)
  {
    if (paramhg1.a() < paramhg2.a()) {}
    for (;;)
    {
      Object localObject = this.a.a();
      hg localhg1 = this.a.b();
      while (paramhg1.a() >= paramInt / 2)
      {
        if (paramhg1.b()) {
          throw new hi("r_{i-1} was zero");
        }
        hg localhg2 = this.a.a();
        int i = paramhg1.a(paramhg1.a());
        i = this.a.c(i);
        while ((paramhg2.a() >= paramhg1.a()) && (!paramhg2.b()))
        {
          int j = paramhg2.a() - paramhg1.a();
          int k = this.a.c(paramhg2.a(paramhg2.a()), i);
          localhg2 = localhg2.a(this.a.a(j, k));
          paramhg2 = paramhg2.a(paramhg1.a(j, k));
        }
        localObject = localhg2.b(localhg1).a((hg)localObject);
        if (paramhg2.a() >= paramhg1.a()) {
          throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
        }
        localhg2 = paramhg1;
        paramhg1 = paramhg2;
        paramhg2 = (hg)localObject;
        localObject = localhg1;
        localhg1 = paramhg2;
        paramhg2 = localhg2;
      }
      paramInt = localhg1.a(0);
      if (paramInt == 0) {
        throw new hi("sigmaTilde(0) was zero");
      }
      paramInt = this.a.c(paramInt);
      return new hg[] { localhg1.c(paramInt), paramhg1.c(paramInt) };
      localhg1 = paramhg1;
      paramhg1 = paramhg2;
      paramhg2 = localhg1;
    }
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    int k = 0;
    Object localObject1 = new hg(this.a, paramArrayOfInt);
    Object localObject2 = new int[paramInt];
    int i = 0;
    int j = 1;
    while (i < paramInt)
    {
      int m = ((hg)localObject1).b(this.a.a(this.a.d() + i));
      localObject2[(localObject2.length - 1 - i)] = m;
      if (m != 0) {
        j = 0;
      }
      i += 1;
    }
    if (j != 0) {}
    for (;;)
    {
      return;
      localObject1 = new hg(this.a, (int[])localObject2);
      localObject2 = a(this.a.a(paramInt, 1), (hg)localObject1, paramInt);
      localObject1 = localObject2[0];
      localObject2 = localObject2[1];
      localObject1 = a((hg)localObject1);
      localObject2 = a((hg)localObject2, (int[])localObject1);
      paramInt = k;
      while (paramInt < localObject1.length)
      {
        i = paramArrayOfInt.length - 1 - this.a.b(localObject1[paramInt]);
        if (i < 0) {
          throw new hi("Bad error location");
        }
        paramArrayOfInt[i] = hf.b(paramArrayOfInt[i], localObject2[paramInt]);
        paramInt += 1;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/hh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */