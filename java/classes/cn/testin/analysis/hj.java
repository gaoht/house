package cn.testin.analysis;

import java.util.Map;

public class hj
  implements fy
{
  private static final gc[] a = new gc[0];
  private final hx b = new hx();
  
  private static float a(int[] paramArrayOfInt, gt paramgt)
  {
    int m = paramgt.d();
    int n = paramgt.c();
    int j = paramArrayOfInt[0];
    int i = paramArrayOfInt[1];
    int i1 = 1;
    int k = 0;
    if ((j < n) && (i < m))
    {
      if (i1 == paramgt.a(j, i)) {
        break label112;
      }
      k += 1;
      if (k != 5) {}
    }
    else
    {
      if ((j != n) && (i != m)) {
        break label102;
      }
      throw fw.a();
    }
    if (i1 == 0) {
      i1 = 1;
    }
    label102:
    label112:
    for (;;)
    {
      j += 1;
      i += 1;
      break;
      i1 = 0;
      continue;
      return (j - paramArrayOfInt[0]) / 7.0F;
    }
  }
  
  private static gt a(gt paramgt)
  {
    Object localObject = paramgt.a();
    int[] arrayOfInt = paramgt.b();
    if ((localObject == null) || (arrayOfInt == null)) {
      throw fw.a();
    }
    float f = a((int[])localObject, paramgt);
    int i3 = localObject[1];
    int m = arrayOfInt[1];
    int k = localObject[0];
    int j = arrayOfInt[0];
    if ((k >= j) || (i3 >= m)) {
      throw fw.a();
    }
    int i = j;
    if (m - i3 != j - k)
    {
      j = m - i3 + k;
      i = j;
      if (j >= paramgt.c()) {
        throw fw.a();
      }
    }
    int n = Math.round((i - k + 1) / f);
    int i1 = Math.round((m - i3 + 1) / f);
    if ((n <= 0) || (i1 <= 0)) {
      throw fw.a();
    }
    if (i1 != n) {
      throw fw.a();
    }
    int i2 = (int)(f / 2.0F);
    j = i3 + i2;
    k += i2;
    i = (int)((n - 1) * f) + k - i;
    if (i > 0) {
      if (i > i2) {
        throw fw.a();
      }
    }
    for (i = k - i;; i = k)
    {
      k = (int)((i1 - 1) * f) + j - m;
      if (k > 0)
      {
        if (k > i2) {
          throw fw.a();
        }
        j -= k;
      }
      for (;;)
      {
        localObject = new gt(n, i1);
        k = 0;
        while (k < i1)
        {
          i2 = (int)(k * f);
          m = 0;
          while (m < n)
          {
            if (paramgt.a((int)(m * f) + i, j + i2)) {
              ((gt)localObject).b(m, k);
            }
            m += 1;
          }
          k += 1;
        }
        return (gt)localObject;
      }
    }
  }
  
  public final ga a(fq paramfq, Map<fs, ?> paramMap)
  {
    if ((paramMap != null) && (paramMap.containsKey(fs.b)))
    {
      paramfq = a(paramfq.a());
      paramfq = this.b.a(paramfq, paramMap);
    }
    Object localObject;
    for (paramMap = a;; paramMap = ((gy)localObject).b())
    {
      if ((paramfq.e() instanceof ib)) {
        ((ib)paramfq.e()).a(paramMap);
      }
      paramMap = new ga(paramfq.b(), paramfq.a(), paramMap, fo.a);
      localObject = paramfq.c();
      if (localObject != null) {
        paramMap.a(gb.c, localObject);
      }
      localObject = paramfq.d();
      if (localObject != null) {
        paramMap.a(gb.d, localObject);
      }
      if (paramfq.f())
      {
        paramMap.a(gb.j, Integer.valueOf(paramfq.h()));
        paramMap.a(gb.k, Integer.valueOf(paramfq.g()));
      }
      return paramMap;
      localObject = new ih(paramfq.a()).a(paramMap);
      paramfq = this.b.a(((gy)localObject).a(), paramMap);
    }
  }
  
  public void a() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/hj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */