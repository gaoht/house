package com.google.c.d.b;

import com.google.c.q;

final class e
{
  private static final int[][] a = { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };
  private static final int[][] b = { { 0, 0, 0, 0, 0, 0, 0, 0 } };
  private static final int[][] c;
  private static final int[][] d;
  private static final int[][] e;
  private static final int[][] f = { { 8, 0 }, { 8, 1 }, { 8, 2 }, { 8, 3 }, { 8, 4 }, { 8, 5 }, { 8, 7 }, { 8, 8 }, { 7, 8 }, { 5, 8 }, { 4, 8 }, { 3, 8 }, { 2, 8 }, { 1, 8 }, { 0, 8 } };
  
  static
  {
    int[] arrayOfInt1 = { 0 };
    int[] arrayOfInt2 = { 0 };
    int[] arrayOfInt3 = { 0 };
    int[] arrayOfInt4 = { 0 };
    int[] arrayOfInt5 = { 0 };
    c = new int[][] { arrayOfInt1, { 0 }, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, { 0 } };
    d = new int[][] { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1 } };
    arrayOfInt1 = new int[] { 6, 18, -1, -1, -1, -1, -1 };
    arrayOfInt2 = new int[] { 6, 30, -1, -1, -1, -1, -1 };
    arrayOfInt3 = new int[] { 6, 22, 38, -1, -1, -1, -1 };
    arrayOfInt4 = new int[] { 6, 24, 42, -1, -1, -1, -1 };
    arrayOfInt5 = new int[] { 6, 28, 50, -1, -1, -1, -1 };
    int[] arrayOfInt6 = { 6, 26, 50, 74, -1, -1, -1 };
    int[] arrayOfInt7 = { 6, 30, 56, 82, -1, -1, -1 };
    int[] arrayOfInt8 = { 6, 26, 50, 74, 98, -1, -1 };
    int[] arrayOfInt9 = { 6, 30, 58, 86, 114, -1, -1 };
    int[] arrayOfInt10 = { 6, 34, 62, 90, 118, -1, -1 };
    int[] arrayOfInt11 = { 6, 30, 54, 78, 102, 126, -1 };
    int[] arrayOfInt12 = { 6, 34, 60, 86, 112, 138, -1 };
    int[] arrayOfInt13 = { 6, 30, 54, 78, 102, 126, 150 };
    int[] arrayOfInt14 = { 6, 24, 50, 76, 102, 128, 154 };
    int[] arrayOfInt15 = { 6, 28, 54, 80, 106, 132, 158 };
    int[] arrayOfInt16 = { 6, 30, 58, 86, 114, 142, 170 };
    e = new int[][] { { -1, -1, -1, -1, -1, -1, -1 }, arrayOfInt1, { 6, 22, -1, -1, -1, -1, -1 }, { 6, 26, -1, -1, -1, -1, -1 }, arrayOfInt2, { 6, 34, -1, -1, -1, -1, -1 }, arrayOfInt3, arrayOfInt4, { 6, 26, 46, -1, -1, -1, -1 }, arrayOfInt5, { 6, 30, 54, -1, -1, -1, -1 }, { 6, 32, 58, -1, -1, -1, -1 }, { 6, 34, 62, -1, -1, -1, -1 }, { 6, 26, 46, 66, -1, -1, -1 }, { 6, 26, 48, 70, -1, -1, -1 }, arrayOfInt6, { 6, 30, 54, 78, -1, -1, -1 }, arrayOfInt7, { 6, 30, 58, 86, -1, -1, -1 }, { 6, 34, 62, 90, -1, -1, -1 }, { 6, 28, 50, 72, 94, -1, -1 }, arrayOfInt8, { 6, 30, 54, 78, 102, -1, -1 }, { 6, 28, 54, 80, 106, -1, -1 }, { 6, 32, 58, 84, 110, -1, -1 }, arrayOfInt9, arrayOfInt10, { 6, 26, 50, 74, 98, 122, -1 }, arrayOfInt11, { 6, 26, 52, 78, 104, 130, -1 }, { 6, 30, 56, 82, 108, 134, -1 }, arrayOfInt12, { 6, 30, 58, 86, 114, 142, -1 }, { 6, 34, 62, 90, 118, 146, -1 }, arrayOfInt13, arrayOfInt14, arrayOfInt15, { 6, 32, 58, 84, 110, 136, 162 }, { 6, 26, 54, 82, 110, 138, 166 }, arrayOfInt16 };
  }
  
  static int a(int paramInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (i != 0)
    {
      i >>>= 1;
      paramInt += 1;
    }
    return paramInt;
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    int i = a(paramInt2);
    paramInt1 <<= i - 1;
    while (a(paramInt1) >= i) {
      paramInt1 ^= paramInt2 << a(paramInt1) - i;
    }
    return paramInt1;
  }
  
  private static void a(int paramInt1, int paramInt2, b paramb)
    throws q
  {
    if ((b[0].length != 8) || (b.length != 1)) {
      throw new q("Bad horizontal separation pattern");
    }
    int i = 0;
    while (i < 8)
    {
      if (!b(paramb.get(paramInt1 + i, paramInt2))) {
        throw new q();
      }
      paramb.set(paramInt1 + i, paramInt2, b[0][i]);
      i += 1;
    }
  }
  
  static void a(int paramInt, com.google.c.a.a parama)
    throws q
  {
    parama.appendBits(paramInt, 6);
    parama.appendBits(a(paramInt, 7973), 12);
    if (parama.getSize() != 18) {
      throw new q("should not happen but we got: " + parama.getSize());
    }
  }
  
  static void a(int paramInt, b paramb)
    throws q
  {
    d(paramb);
    c(paramb);
    c(paramInt, paramb);
    b(paramb);
  }
  
  static void a(com.google.c.a.a parama, int paramInt, b paramb)
    throws q
  {
    int k = paramb.getWidth() - 1;
    int j = paramb.getHeight() - 1;
    int m = -1;
    int i = 0;
    if (k > 0)
    {
      if (k != 6) {
        break label247;
      }
      k -= 1;
    }
    label111:
    label162:
    label247:
    for (;;)
    {
      if ((j >= 0) && (j < paramb.getHeight()))
      {
        int n = 0;
        while (n < 2)
        {
          int i1 = k - n;
          if (!b(paramb.get(i1, j)))
          {
            n += 1;
          }
          else
          {
            boolean bool1;
            if (i < parama.getSize())
            {
              bool1 = parama.get(i);
              i += 1;
              bool2 = bool1;
              if (paramInt != -1)
              {
                bool2 = bool1;
                if (d.a(paramInt, i1, j)) {
                  if (bool1) {
                    break label162;
                  }
                }
              }
            }
            for (boolean bool2 = true;; bool2 = false)
            {
              paramb.set(i1, j, bool2);
              break;
              bool1 = false;
              break label111;
            }
          }
        }
        j += m;
      }
      else
      {
        m = -m;
        k -= 2;
        j += m;
        break;
        if (i != parama.getSize()) {
          throw new q("Not all bits consumed: " + i + '/' + parama.getSize());
        }
        return;
      }
    }
  }
  
  static void a(com.google.c.a.a parama, com.google.c.d.a.a parama1, int paramInt1, int paramInt2, b paramb)
    throws q
  {
    a(paramb);
    a(paramInt1, paramb);
    a(parama1, paramInt2, paramb);
    b(paramInt1, paramb);
    a(parama, paramInt2, paramb);
  }
  
  static void a(com.google.c.d.a.a parama, int paramInt, com.google.c.a.a parama1)
    throws q
  {
    if (!f.isValidMaskPattern(paramInt)) {
      throw new q("Invalid mask pattern");
    }
    paramInt = parama.getBits() << 3 | paramInt;
    parama1.appendBits(paramInt, 5);
    parama1.appendBits(a(paramInt, 1335), 10);
    parama = new com.google.c.a.a();
    parama.appendBits(21522, 15);
    parama1.xor(parama);
    if (parama1.getSize() != 15) {
      throw new q("should not happen but we got: " + parama1.getSize());
    }
  }
  
  static void a(com.google.c.d.a.a parama, int paramInt, b paramb)
    throws q
  {
    com.google.c.a.a locala = new com.google.c.a.a();
    a(parama, paramInt, locala);
    paramInt = 0;
    if (paramInt < locala.getSize())
    {
      boolean bool = locala.get(locala.getSize() - 1 - paramInt);
      paramb.set(f[paramInt][0], f[paramInt][1], bool);
      if (paramInt < 8) {
        paramb.set(paramb.getWidth() - paramInt - 1, 8, bool);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        paramb.set(8, paramb.getHeight() - 7 + (paramInt - 8), bool);
      }
    }
  }
  
  static void a(b paramb)
  {
    paramb.clear((byte)-1);
  }
  
  private static void b(int paramInt1, int paramInt2, b paramb)
    throws q
  {
    if ((c[0].length != 1) || (c.length != 7)) {
      throw new q("Bad vertical separation pattern");
    }
    int i = 0;
    while (i < 7)
    {
      if (!b(paramb.get(paramInt1, paramInt2 + i))) {
        throw new q();
      }
      paramb.set(paramInt1, paramInt2 + i, c[i][0]);
      i += 1;
    }
  }
  
  static void b(int paramInt, b paramb)
    throws q
  {
    if (paramInt < 7) {}
    for (;;)
    {
      return;
      com.google.c.a.a locala = new com.google.c.a.a();
      a(paramInt, locala);
      paramInt = 17;
      int i = 0;
      while (i < 6)
      {
        int j = 0;
        while (j < 3)
        {
          boolean bool = locala.get(paramInt);
          paramInt -= 1;
          paramb.set(i, paramb.getHeight() - 11 + j, bool);
          paramb.set(paramb.getHeight() - 11 + j, i, bool);
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  private static void b(b paramb)
    throws q
  {
    int i = 8;
    while (i < paramb.getWidth() - 8)
    {
      int j = (i + 1) % 2;
      if (!c(paramb.get(i, 6))) {
        throw new q();
      }
      if (b(paramb.get(i, 6))) {
        paramb.set(i, 6, j);
      }
      if (!c(paramb.get(6, i))) {
        throw new q();
      }
      if (b(paramb.get(6, i))) {
        paramb.set(6, i, j);
      }
      i += 1;
    }
  }
  
  private static boolean b(int paramInt)
  {
    return paramInt == -1;
  }
  
  private static void c(int paramInt1, int paramInt2, b paramb)
    throws q
  {
    if ((d[0].length != 5) || (d.length != 5)) {
      throw new q("Bad position adjustment");
    }
    int i = 0;
    while (i < 5)
    {
      int j = 0;
      while (j < 5)
      {
        if (!b(paramb.get(paramInt1 + j, paramInt2 + i))) {
          throw new q();
        }
        paramb.set(paramInt1 + j, paramInt2 + i, d[i][j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void c(int paramInt, b paramb)
    throws q
  {
    if (paramInt < 2) {}
    for (;;)
    {
      return;
      paramInt -= 1;
      int[] arrayOfInt = e[paramInt];
      int j = e[paramInt].length;
      paramInt = 0;
      while (paramInt < j)
      {
        int i = 0;
        if (i < j)
        {
          int k = arrayOfInt[paramInt];
          int m = arrayOfInt[i];
          if ((m == -1) || (k == -1)) {}
          for (;;)
          {
            i += 1;
            break;
            if (b(paramb.get(m, k))) {
              c(m - 2, k - 2, paramb);
            }
          }
        }
        paramInt += 1;
      }
    }
  }
  
  private static void c(b paramb)
    throws q
  {
    if (paramb.get(8, paramb.getHeight() - 8) == 0) {
      throw new q();
    }
    paramb.set(8, paramb.getHeight() - 8, 1);
  }
  
  private static boolean c(int paramInt)
  {
    return (paramInt == -1) || (paramInt == 0) || (paramInt == 1);
  }
  
  private static void d(int paramInt1, int paramInt2, b paramb)
    throws q
  {
    if ((a[0].length != 7) || (a.length != 7)) {
      throw new q("Bad position detection pattern");
    }
    int i = 0;
    while (i < 7)
    {
      int j = 0;
      while (j < 7)
      {
        if (!b(paramb.get(paramInt1 + j, paramInt2 + i))) {
          throw new q();
        }
        paramb.set(paramInt1 + j, paramInt2 + i, a[i][j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void d(b paramb)
    throws q
  {
    int i = a[0].length;
    d(0, 0, paramb);
    d(paramb.getWidth() - i, 0, paramb);
    d(0, paramb.getWidth() - i, paramb);
    i = b[0].length;
    a(0, i - 1, paramb);
    a(paramb.getWidth() - i, i - 1, paramb);
    a(0, paramb.getWidth() - i, paramb);
    i = c.length;
    b(i, 0, paramb);
    b(paramb.getHeight() - i - 1, 0, paramb);
    b(i, paramb.getHeight() - i, paramb);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/d/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */