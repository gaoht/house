package cn.testin.analysis;

import java.util.Map;

public class ih
{
  private final gt a;
  private gd b;
  
  public ih(gt paramgt)
  {
    this.a = paramgt;
  }
  
  private float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    float f2 = b(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt3 = paramInt1 - (paramInt3 - paramInt1);
    float f1;
    if (paramInt3 < 0)
    {
      f1 = paramInt1 / (paramInt1 - paramInt3);
      paramInt3 = 0;
    }
    for (;;)
    {
      paramInt4 = (int)(paramInt2 - f1 * (paramInt4 - paramInt2));
      if (paramInt4 < 0)
      {
        f1 = paramInt2 / (paramInt2 - paramInt4);
        paramInt4 = i;
      }
      for (;;)
      {
        float f3 = paramInt1;
        return b(paramInt1, paramInt2, (int)(f1 * (paramInt3 - paramInt1) + f3), paramInt4) + f2 - 1.0F;
        if (paramInt3 < this.a.c()) {
          break label194;
        }
        f1 = (this.a.c() - 1 - paramInt1) / (paramInt3 - paramInt1);
        paramInt3 = this.a.c();
        paramInt3 -= 1;
        break;
        if (paramInt4 >= this.a.d())
        {
          f1 = (this.a.d() - 1 - paramInt2) / (paramInt4 - paramInt2);
          paramInt4 = this.a.d() - 1;
        }
        else
        {
          f1 = 1.0F;
        }
      }
      label194:
      f1 = 1.0F;
    }
  }
  
  private float a(gc paramgc1, gc paramgc2)
  {
    float f1 = a((int)paramgc1.a(), (int)paramgc1.b(), (int)paramgc2.a(), (int)paramgc2.b());
    float f2 = a((int)paramgc2.a(), (int)paramgc2.b(), (int)paramgc1.a(), (int)paramgc1.b());
    if (Float.isNaN(f1)) {
      return f2 / 7.0F;
    }
    if (Float.isNaN(f2)) {
      return f1 / 7.0F;
    }
    return (f1 + f2) / 14.0F;
  }
  
  private static int a(gc paramgc1, gc paramgc2, gc paramgc3, float paramFloat)
  {
    int i = (he.a(gc.a(paramgc1, paramgc2) / paramFloat) + he.a(gc.a(paramgc1, paramgc3) / paramFloat)) / 2 + 7;
    switch (i & 0x3)
    {
    case 1: 
    default: 
      return i;
    case 0: 
      return i + 1;
    case 2: 
      return i - 1;
    }
    throw fw.a();
  }
  
  private static gt a(gt paramgt, hc paramhc, int paramInt)
  {
    return ha.a().a(paramgt, paramInt, paramInt, paramhc);
  }
  
  private static hc a(gc paramgc1, gc paramgc2, gc paramgc3, gc paramgc4, int paramInt)
  {
    float f1 = paramInt - 3.5F;
    float f4;
    float f5;
    float f3;
    if (paramgc4 != null)
    {
      f4 = paramgc4.a();
      f5 = paramgc4.b();
      f3 = f1 - 3.0F;
    }
    for (float f2 = f3;; f2 = f1)
    {
      return hc.a(3.5F, 3.5F, f1, 3.5F, f2, f3, 3.5F, f1, paramgc1.a(), paramgc1.b(), paramgc2.a(), paramgc2.b(), f4, f5, paramgc3.a(), paramgc3.b());
      f4 = paramgc2.a() - paramgc1.a() + paramgc3.a();
      f5 = paramgc2.b() - paramgc1.b() + paramgc3.b();
      f3 = f1;
    }
  }
  
  private float b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k;
    int n;
    int m;
    int i;
    if (Math.abs(paramInt4 - paramInt2) > Math.abs(paramInt3 - paramInt1))
    {
      k = 1;
      if (k == 0) {
        break label266;
      }
      n = paramInt4;
      m = paramInt3;
      i = paramInt2;
      paramInt4 = paramInt1;
    }
    for (;;)
    {
      int i5 = Math.abs(n - i);
      int i6 = Math.abs(m - paramInt4);
      int j = -i5 / 2;
      int i1;
      label74:
      int i2;
      label84:
      int i3;
      label109:
      int i4;
      label117:
      int i7;
      if (i < n)
      {
        i1 = 1;
        if (paramInt4 >= m) {
          break label168;
        }
        i2 = 1;
        paramInt3 = 0;
        paramInt2 = i;
        paramInt1 = paramInt4;
        if (paramInt2 == n + i1) {
          break label263;
        }
        if (k == 0) {
          break label174;
        }
        i3 = paramInt1;
        if (k == 0) {
          break label180;
        }
        i4 = paramInt2;
        if (paramInt3 != 1) {
          break label186;
        }
        i7 = 1;
      }
      for (;;)
      {
        if (i7 == this.a.a(i3, i4))
        {
          if (paramInt3 == 2)
          {
            return he.a(paramInt2, paramInt1, i, paramInt4);
            k = 0;
            break;
            i1 = -1;
            break label74;
            label168:
            i2 = -1;
            break label84;
            label174:
            i3 = paramInt2;
            break label109;
            label180:
            i4 = paramInt1;
            break label117;
            label186:
            i7 = 0;
            continue;
          }
          paramInt3 += 1;
          label196:
          j += i6;
          if (j > 0) {
            if (paramInt1 != m) {}
          }
        }
      }
      label263:
      for (;;)
      {
        if (paramInt3 == 2)
        {
          return he.a(n + i1, m, i, paramInt4);
          paramInt1 += i2;
          j -= i5;
        }
        for (;;)
        {
          paramInt2 += i1;
          break;
          return NaN.0F;
        }
        break label196;
      }
      label266:
      m = paramInt4;
      paramInt4 = paramInt2;
      i = paramInt1;
      n = paramInt3;
    }
  }
  
  protected final float a(gc paramgc1, gc paramgc2, gc paramgc3)
  {
    return (a(paramgc1, paramgc2) + a(paramgc1, paramgc3)) / 2.0F;
  }
  
  protected final gy a(in paramin)
  {
    ii localii1 = paramin.b();
    ii localii2 = paramin.c();
    ii localii3 = paramin.a();
    float f1 = a(localii1, localii2, localii3);
    if (f1 < 1.0F) {
      throw fw.a();
    }
    int j = a(localii1, localii2, localii3, f1);
    ic localic = ic.a(j);
    int i = localic.d();
    Object localObject = null;
    paramin = (in)localObject;
    float f2;
    int k;
    int m;
    if (localic.b().length > 0)
    {
      f2 = localii2.a();
      float f3 = localii1.a();
      float f4 = localii3.a();
      float f5 = localii2.b();
      float f6 = localii1.b();
      float f7 = localii3.b();
      float f8 = 1.0F - 3.0F / (i - 7);
      float f9 = localii1.a();
      k = (int)((f2 - f3 + f4 - localii1.a()) * f8 + f9);
      m = (int)(localii1.b() + f8 * (f5 - f6 + f7 - localii1.b()));
      i = 4;
      paramin = (in)localObject;
      if (i <= 16) {
        f2 = i;
      }
    }
    for (;;)
    {
      try
      {
        paramin = a(f1, k, m, f2);
        localObject = a(localii1, localii2, localii3, paramin, j);
        localObject = a(this.a, (hc)localObject, j);
        if (paramin != null) {
          break label289;
        }
        paramin = new gc[3];
        paramin[0] = localii3;
        paramin[1] = localii1;
        paramin[2] = localii2;
        return new gy((gt)localObject, paramin);
      }
      catch (fw paramin)
      {
        i <<= 1;
      }
      break;
      label289:
      paramin = new gc[] { localii3, localii1, localii2, paramin };
    }
  }
  
  public final gy a(Map<fs, ?> paramMap)
  {
    if (paramMap == null) {}
    for (gd localgd = null;; localgd = (gd)paramMap.get(fs.j))
    {
      this.b = localgd;
      return a(new ij(this.a, this.b).a(paramMap));
    }
  }
  
  protected final if a(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2)
  {
    int j = (int)(paramFloat2 * paramFloat1);
    int i = Math.max(0, paramInt1 - j);
    paramInt1 = Math.min(this.a.c() - 1, paramInt1 + j);
    if (paramInt1 - i < paramFloat1 * 3.0F) {
      throw fw.a();
    }
    int k = Math.max(0, paramInt2 - j);
    paramInt2 = Math.min(this.a.d() - 1, j + paramInt2);
    if (paramInt2 - k < paramFloat1 * 3.0F) {
      throw fw.a();
    }
    return new ig(this.a, i, k, paramInt1 - i, paramInt2 - k, paramFloat1, this.b).a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */