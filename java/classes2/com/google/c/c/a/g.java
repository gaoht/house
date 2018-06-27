package com.google.c.c.a;

import com.google.c.a.b;
import com.google.c.f;
import com.google.c.p;
import com.google.c.q;
import java.lang.reflect.Array;
import java.util.Map;

public final class g
  implements p
{
  private static b a(d paramd, String paramString, int paramInt1, int paramInt2)
    throws q
  {
    paramd.a(paramString, 2);
    paramString = paramd.a().a(2, 8);
    int j;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      if (paramString[0].length >= paramString.length) {
        break label112;
      }
      j = 1;
      label37:
      if ((i ^ j) == 0) {
        break label131;
      }
      paramString = b(paramString);
    }
    label70:
    label112:
    label123:
    label128:
    label131:
    for (int i = 1;; i = 0)
    {
      paramInt1 /= paramString[0].length;
      paramInt2 /= paramString.length;
      if (paramInt1 < paramInt2)
      {
        if (paramInt1 <= 1) {
          break label123;
        }
        paramd = paramd.a().a(paramInt1 * 2, paramInt1 * 4 * 2);
        if (i == 0) {
          break label128;
        }
        paramd = b(paramd);
      }
      for (;;)
      {
        return a(paramd);
        i = 0;
        break;
        j = 0;
        break label37;
        paramInt1 = paramInt2;
        break label70;
        return a(paramString);
      }
    }
  }
  
  private static b a(byte[][] paramArrayOfByte)
  {
    b localb = new b(paramArrayOfByte.length + 60, paramArrayOfByte[0].length + 60);
    localb.clear();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = 0;
      while (j < paramArrayOfByte[0].length)
      {
        if (paramArrayOfByte[i][j] == 1) {
          localb.set(i + 30, j + 30);
        }
        j += 1;
      }
      i += 1;
    }
    return localb;
  }
  
  private static d a(com.google.c.a parama, boolean paramBoolean)
  {
    if (parama != com.google.c.a.k) {
      throw new IllegalArgumentException("Can only encode PDF_417, but got " + parama);
    }
    parama = new d();
    parama.a(paramBoolean);
    return parama;
  }
  
  private static byte[][] b(byte[][] paramArrayOfByte)
  {
    int i = paramArrayOfByte[0].length;
    int j = paramArrayOfByte.length;
    byte[][] arrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { i, j });
    i = 0;
    while (i < paramArrayOfByte.length)
    {
      int k = paramArrayOfByte.length;
      j = 0;
      while (j < paramArrayOfByte[0].length)
      {
        arrayOfByte[j][(k - i - 1)] = paramArrayOfByte[i][j];
        j += 1;
      }
      i += 1;
    }
    return arrayOfByte;
  }
  
  public b encode(String paramString, com.google.c.a parama, int paramInt1, int paramInt2)
    throws q
  {
    return a(a(parama, false), paramString, paramInt1, paramInt2);
  }
  
  public b encode(String paramString, com.google.c.a parama, int paramInt1, int paramInt2, Map<f, ?> paramMap)
    throws q
  {
    return encode(paramString, parama, paramInt1, paramInt2);
  }
  
  public b encode(String paramString, com.google.c.a parama, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, c paramc)
    throws q
  {
    parama = a(parama, paramBoolean);
    parama.a(paramInt4, paramInt3, paramInt6, paramInt5);
    parama.a(paramc);
    return a(parama, paramString, paramInt1, paramInt2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/c/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */