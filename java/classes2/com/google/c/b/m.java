package com.google.c.b;

import com.google.c.a.a;
import com.google.c.c;
import com.google.c.d;
import com.google.c.e;
import com.google.c.g;
import com.google.c.j;
import com.google.c.k;
import com.google.c.l;
import com.google.c.n;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public abstract class m
{
  protected static int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int n = paramArrayOfInt1.length;
    int j = 0;
    int k = 0;
    int i = 0;
    while (j < n)
    {
      i += paramArrayOfInt1[j];
      k += paramArrayOfInt2[j];
      j += 1;
    }
    if (i < k) {}
    label143:
    for (;;)
    {
      return Integer.MAX_VALUE;
      int i1 = (i << 8) / k;
      j = 0;
      k = 0;
      if (j >= n) {
        break;
      }
      int m = paramArrayOfInt1[j] << 8;
      int i2 = paramArrayOfInt2[j] * i1;
      if (m > i2) {
        m -= i2;
      }
      for (;;)
      {
        if (m > paramInt * i1 >> 8) {
          break label143;
        }
        k += m;
        j += 1;
        break;
        m = i2 - m;
      }
    }
    return k / i;
  }
  
  private l a(c paramc, Map<e, ?> paramMap)
    throws j
  {
    int i1 = paramc.getWidth();
    int m = paramc.getHeight();
    Object localObject1 = new a(i1);
    int i;
    int j;
    label49:
    int i2;
    label67:
    int n;
    if ((paramMap != null) && (paramMap.containsKey(e.d)))
    {
      i = 1;
      if (i == 0) {
        break label136;
      }
      j = 8;
      i2 = Math.max(1, m >> j);
      if (i == 0) {
        break label142;
      }
      i = m;
      j = 0;
      if (j < i)
      {
        n = j + 1 >> 1;
        if ((j & 0x1) != 0) {
          break label148;
        }
        k = 1;
        label94:
        if (k == 0) {
          break label154;
        }
      }
    }
    label136:
    label142:
    label148:
    label154:
    for (int k = n;; k = -n)
    {
      n = (m >> 1) + k * i2;
      if ((n >= 0) && (n < m)) {
        break label162;
      }
      throw j.getNotFoundInstance();
      i = 0;
      break;
      j = 5;
      break label49;
      i = 15;
      break label67;
      k = 0;
      break label94;
    }
    label162:
    label396:
    for (;;)
    {
      try
      {
        Object localObject2 = paramc.getBlackRow(n, (a)localObject1);
        localObject1 = localObject2;
        k = 0;
        localObject3 = localObject1;
        localObject2 = paramMap;
        if (k < 2)
        {
          if (k != 1) {
            break label396;
          }
          ((a)localObject1).reverse();
          if ((paramMap == null) || (!paramMap.containsKey(e.h))) {
            break label396;
          }
          localObject2 = new EnumMap(e.class);
          ((Map)localObject2).putAll(paramMap);
          ((Map)localObject2).remove(e.h);
          paramMap = (Map<e, ?>)localObject2;
          try
          {
            localObject2 = decodeRow(n, (a)localObject1, paramMap);
            if (k == 1)
            {
              ((l)localObject2).putMetadata(com.google.c.m.b, Integer.valueOf(180));
              localObject3 = ((l)localObject2).getResultPoints();
              if (localObject3 != null)
              {
                localObject3[0] = new n(i1 - localObject3[0].getX() - 1.0F, localObject3[0].getY());
                localObject3[1] = new n(i1 - localObject3[1].getX() - 1.0F, localObject3[1].getY());
              }
            }
            return (l)localObject2;
          }
          catch (k localk)
          {
            k += 1;
          }
        }
      }
      catch (j localj)
      {
        Map<e, ?> localMap = paramMap;
        Object localObject3 = localObject1;
        j += 1;
        localObject1 = localObject3;
        paramMap = localMap;
      }
    }
  }
  
  protected static void a(a parama, int paramInt, int[] paramArrayOfInt)
    throws j
  {
    int m = paramArrayOfInt.length;
    Arrays.fill(paramArrayOfInt, 0, m, 0);
    int n = parama.getSize();
    if (paramInt >= n) {
      throw j.getNotFoundInstance();
    }
    if (!parama.get(paramInt)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      k = 0;
      j = paramInt;
      paramInt = k;
      for (;;)
      {
        if (j >= n) {
          break label151;
        }
        if (!(parama.get(j) ^ i)) {
          break;
        }
        paramArrayOfInt[paramInt] += 1;
        j += 1;
      }
    }
    int k = paramInt + 1;
    if (k == m) {}
    for (;;)
    {
      if ((k != m) && ((k != m - 1) || (j != n)))
      {
        throw j.getNotFoundInstance();
        paramArrayOfInt[k] = 1;
        if (i == 0) {}
        for (paramInt = 1;; paramInt = 0)
        {
          i = paramInt;
          paramInt = k;
          break;
        }
      }
      return;
      label151:
      k = paramInt;
    }
  }
  
  public l decode(c paramc)
    throws j, g
  {
    return decode(paramc, null);
  }
  
  public l decode(c paramc, Map<e, ?> paramMap)
    throws j, g
  {
    try
    {
      l locall = a(paramc, paramMap);
      return locall;
    }
    catch (j localj)
    {
      if (paramMap == null) {
        break label178;
      }
    }
    Object localObject;
    if (paramMap.containsKey(e.d))
    {
      i = 1;
      if ((i == 0) || (!paramc.isRotateSupported())) {
        break label185;
      }
      paramc = paramc.rotateCounterClockwise();
      paramMap = a(paramc, paramMap);
      localObject = paramMap.getResultMetadata();
      if ((localObject == null) || (!((Map)localObject).containsKey(com.google.c.m.b))) {
        break label188;
      }
    }
    label178:
    label185:
    label188:
    for (int i = (((Integer)((Map)localObject).get(com.google.c.m.b)).intValue() + 270) % 360;; i = 270)
    {
      paramMap.putMetadata(com.google.c.m.b, Integer.valueOf(i));
      localObject = paramMap.getResultPoints();
      if (localObject != null)
      {
        int j = paramc.getHeight();
        i = 0;
        for (;;)
        {
          if (i < localObject.length)
          {
            localObject[i] = new n(j - localObject[i].getY() - 1.0F, localObject[i].getX());
            i += 1;
            continue;
            i = 0;
            break;
          }
        }
      }
      return paramMap;
      throw ((Throwable)localObject);
    }
  }
  
  public abstract l decodeRow(int paramInt, a parama, Map<e, ?> paramMap)
    throws j, d, g;
  
  public void reset() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/b/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */