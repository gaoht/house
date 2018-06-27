package com.google.c.d;

import com.google.c.d.b.c;
import com.google.c.p;
import com.google.c.q;
import java.util.Map;

public final class a
  implements p
{
  private static com.google.c.a.b a(com.google.c.d.b.f paramf, int paramInt1, int paramInt2)
  {
    paramf = paramf.getMatrix();
    if (paramf == null) {
      throw new IllegalStateException();
    }
    int m = paramf.getWidth();
    int n = paramf.getHeight();
    int j = m + 8;
    int k = n + 8;
    paramInt1 = Math.max(paramInt1, j);
    int i = Math.max(paramInt2, k);
    int i1 = Math.min(paramInt1 / j, i / k);
    k = (paramInt1 - m * i1) / 2;
    paramInt2 = (i - n * i1) / 2;
    com.google.c.a.b localb = new com.google.c.a.b(paramInt1, i);
    paramInt1 = 0;
    while (paramInt1 < n)
    {
      i = k;
      j = 0;
      while (j < m)
      {
        if (paramf.get(j, paramInt1) == 1) {
          localb.setRegion(i, paramInt2, i1, i1);
        }
        j += 1;
        i += i1;
      }
      paramInt2 += i1;
      paramInt1 += 1;
    }
    return localb;
  }
  
  public com.google.c.a.b encode(String paramString, com.google.c.a parama, int paramInt1, int paramInt2)
    throws q
  {
    return encode(paramString, parama, paramInt1, paramInt2, null);
  }
  
  public com.google.c.a.b encode(String paramString, com.google.c.a parama, int paramInt1, int paramInt2, Map<com.google.c.f, ?> paramMap)
    throws q
  {
    if (paramString.length() == 0) {
      throw new IllegalArgumentException("Found empty contents");
    }
    if (parama != com.google.c.a.l) {
      throw new IllegalArgumentException("Can only encode QR_CODE, but got " + parama);
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IllegalArgumentException("Requested dimensions are too small: " + paramInt1 + 'x' + paramInt2);
    }
    parama = com.google.c.d.a.a.a;
    Object localObject;
    if (paramMap != null)
    {
      localObject = (com.google.c.d.a.a)paramMap.get(com.google.c.f.a);
      if (localObject != null) {
        parama = (com.google.c.a)localObject;
      }
    }
    for (;;)
    {
      localObject = new com.google.c.d.b.f();
      c.encode(paramString, parama, paramMap, (com.google.c.d.b.f)localObject);
      return a((com.google.c.d.b.f)localObject, paramInt1, paramInt2);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */