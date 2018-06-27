package com.google.c.d.b;

import com.google.c.d.a.c.b;
import com.google.c.q;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class c
{
  private static final int[] a = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1 };
  
  static int a(int paramInt)
  {
    if (paramInt < a.length) {
      return a[paramInt];
    }
    return -1;
  }
  
  private static int a(int paramInt, com.google.c.d.a.c paramc, com.google.c.d.a.b paramb)
  {
    return (4 + paramb.getCharacterCountBits(paramc) + paramInt + 7) / 8;
  }
  
  private static int a(com.google.c.a.a parama, com.google.c.d.a.a parama1, int paramInt, b paramb)
    throws q
  {
    int j = Integer.MAX_VALUE;
    int k = -1;
    int i = 0;
    if (i < 8)
    {
      e.a(parama, parama1, paramInt, i, paramb);
      int m = a(paramb);
      if (m >= j) {
        break label59;
      }
      k = i;
      j = m;
    }
    label59:
    for (;;)
    {
      i += 1;
      break;
      return k;
    }
  }
  
  private static int a(b paramb)
  {
    return 0 + d.a(paramb) + d.b(paramb) + d.c(paramb) + d.d(paramb);
  }
  
  private static com.google.c.d.a.b a(String paramString1, String paramString2)
  {
    int i = 0;
    if ("Shift_JIS".equals(paramString2))
    {
      if (a(paramString1)) {
        return com.google.c.d.a.b.g;
      }
      return com.google.c.d.a.b.e;
    }
    int k = 0;
    int j = 0;
    if (i < paramString1.length())
    {
      int m = paramString1.charAt(i);
      if ((m >= 48) && (m <= 57)) {
        j = 1;
      }
      for (;;)
      {
        i += 1;
        break;
        if (a(m) == -1) {
          break label84;
        }
        k = 1;
      }
      label84:
      return com.google.c.d.a.b.e;
    }
    if (k != 0) {
      return com.google.c.d.a.b.c;
    }
    if (j != 0) {
      return com.google.c.d.a.b.b;
    }
    return com.google.c.d.a.b.e;
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    throws q
  {
    if (paramInt4 >= paramInt3) {
      throw new q("Block ID too large");
    }
    int i = paramInt1 % paramInt3;
    int j = paramInt3 - i;
    int k = paramInt1 / paramInt3;
    paramInt2 /= paramInt3;
    int m = paramInt2 + 1;
    int n = k - paramInt2;
    k = k + 1 - m;
    if (n != k) {
      throw new q("EC bytes mismatch");
    }
    if (paramInt3 != j + i) {
      throw new q("RS blocks mismatch");
    }
    if (paramInt1 != i * (m + k) + (paramInt2 + n) * j) {
      throw new q("Total bytes mismatch");
    }
    if (paramInt4 < j)
    {
      paramArrayOfInt1[0] = paramInt2;
      paramArrayOfInt2[0] = n;
      return;
    }
    paramArrayOfInt1[0] = m;
    paramArrayOfInt2[0] = k;
  }
  
  static void a(int paramInt1, int paramInt2, com.google.c.d.a.b paramb, com.google.c.a.a parama)
    throws q
  {
    paramInt2 = paramb.getCharacterCountBits(com.google.c.d.a.c.getVersionForNumber(paramInt2));
    if (paramInt1 > (1 << paramInt2) - 1) {
      throw new q(paramInt1 + "is bigger than" + ((1 << paramInt2) - 1));
    }
    parama.appendBits(paramInt1, paramInt2);
  }
  
  static void a(int paramInt, com.google.c.a.a parama)
    throws q
  {
    int k = paramInt << 3;
    if (parama.getSize() > k) {
      throw new q("data bits cannot fit in the QR Code" + parama.getSize() + " > " + k);
    }
    int i = 0;
    while ((i < 4) && (parama.getSize() < k))
    {
      parama.appendBit(false);
      i += 1;
    }
    i = parama.getSize() & 0x7;
    if (i > 0) {
      while (i < 8)
      {
        parama.appendBit(false);
        i += 1;
      }
    }
    int m = parama.getSizeInBytes();
    i = 0;
    if (i < paramInt - m)
    {
      if ((i & 0x1) == 0) {}
      for (int j = 236;; j = 17)
      {
        parama.appendBits(j, 8);
        i += 1;
        break;
      }
    }
    if (parama.getSize() != k) {
      throw new q("Bits size does not equal capacity");
    }
  }
  
  private static void a(int paramInt, com.google.c.d.a.a parama, com.google.c.d.a.b paramb, f paramf)
    throws q
  {
    paramf.setECLevel(parama);
    paramf.setMode(paramb);
    int i = 1;
    while (i <= 40)
    {
      com.google.c.d.a.c localc = com.google.c.d.a.c.getVersionForNumber(i);
      int j = localc.getTotalCodewords();
      c.b localb = localc.getECBlocksForLevel(parama);
      int k = localb.getTotalECCodewords();
      int m = localb.getNumBlocks();
      int n = j - k;
      if (n >= a(paramInt, localc, paramb))
      {
        paramf.setVersion(i);
        paramf.setNumTotalBytes(j);
        paramf.setNumDataBytes(n);
        paramf.setNumRSBlocks(m);
        paramf.setNumECBytes(k);
        paramf.setMatrixWidth(localc.getDimensionForVersion());
        return;
      }
      i += 1;
    }
    throw new q("Cannot find proper rs block info (input data too big?)");
  }
  
  static void a(com.google.c.a.a parama1, int paramInt1, int paramInt2, int paramInt3, com.google.c.a.a parama2)
    throws q
  {
    if (parama1.getSizeInBytes() != paramInt2) {
      throw new q("Number of bits and data bytes does not match");
    }
    ArrayList localArrayList = new ArrayList(paramInt3);
    int k = 0;
    int i = 0;
    int m = 0;
    Object localObject1;
    int n;
    for (int j = 0; k < paramInt3; j = n + j)
    {
      localObject1 = new int[1];
      Object localObject2 = new int[1];
      a(paramInt1, paramInt2, paramInt3, k, (int[])localObject1, (int[])localObject2);
      n = localObject1[0];
      byte[] arrayOfByte = new byte[n];
      parama1.toBytes(j * 8, arrayOfByte, 0, n);
      localObject2 = a(arrayOfByte, localObject2[0]);
      localArrayList.add(new a(arrayOfByte, (byte[])localObject2));
      m = Math.max(m, n);
      i = Math.max(i, localObject2.length);
      n = localObject1[0];
      k += 1;
    }
    if (paramInt2 != j) {
      throw new q("Data bytes does not match offset");
    }
    paramInt2 = 0;
    while (paramInt2 < m)
    {
      parama1 = localArrayList.iterator();
      while (parama1.hasNext())
      {
        localObject1 = ((a)parama1.next()).getDataBytes();
        if (paramInt2 < localObject1.length) {
          parama2.appendBits(localObject1[paramInt2], 8);
        }
      }
      paramInt2 += 1;
    }
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      parama1 = localArrayList.iterator();
      while (parama1.hasNext())
      {
        localObject1 = ((a)parama1.next()).getErrorCorrectionBytes();
        if (paramInt2 < localObject1.length) {
          parama2.appendBits(localObject1[paramInt2], 8);
        }
      }
      paramInt2 += 1;
    }
    if (paramInt1 != parama2.getSizeInBytes()) {
      throw new q("Interleaving error: " + paramInt1 + " and " + parama2.getSizeInBytes() + " differ.");
    }
  }
  
  private static void a(com.google.c.a.c paramc, com.google.c.a.a parama)
  {
    parama.appendBits(com.google.c.d.a.b.f.getBits(), 4);
    parama.appendBits(paramc.getValue(), 8);
  }
  
  static void a(com.google.c.d.a.b paramb, com.google.c.a.a parama)
  {
    parama.appendBits(paramb.getBits(), 4);
  }
  
  static void a(CharSequence paramCharSequence, com.google.c.a.a parama)
  {
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j)
    {
      int k = paramCharSequence.charAt(i) - '0';
      if (i + 2 < j)
      {
        parama.appendBits(k * 100 + (paramCharSequence.charAt(i + 1) - '0') * 10 + (paramCharSequence.charAt(i + 2) - '0'), 10);
        i += 3;
      }
      else if (i + 1 < j)
      {
        parama.appendBits(k * 10 + (paramCharSequence.charAt(i + 1) - '0'), 7);
        i += 2;
      }
      else
      {
        parama.appendBits(k, 4);
        i += 1;
      }
    }
  }
  
  static void a(String paramString, com.google.c.a.a parama)
    throws q
  {
    for (;;)
    {
      int j;
      int i;
      try
      {
        paramString = paramString.getBytes("Shift_JIS");
        int k = paramString.length;
        j = 0;
        if (j >= k) {
          break label139;
        }
        i = (paramString[j] & 0xFF) << 8 | paramString[(j + 1)] & 0xFF;
        if ((i >= 33088) && (i <= 40956))
        {
          i -= 33088;
          if (i != -1) {
            break label112;
          }
          throw new q("Invalid byte sequence");
        }
      }
      catch (UnsupportedEncodingException paramString)
      {
        throw new q(paramString.toString());
      }
      if ((i >= 57408) && (i <= 60351))
      {
        i -= 49472;
        continue;
        label112:
        parama.appendBits((i & 0xFF) + (i >> 8) * 192, 13);
        j += 2;
      }
      else
      {
        label139:
        i = -1;
      }
    }
  }
  
  static void a(String paramString1, com.google.c.a.a parama, String paramString2)
    throws q
  {
    try
    {
      paramString1 = paramString1.getBytes(paramString2);
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        parama.appendBits(paramString1[i], 8);
        i += 1;
      }
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new q(paramString1.toString());
    }
  }
  
  static void a(String paramString1, com.google.c.d.a.b paramb, com.google.c.a.a parama, String paramString2)
    throws q
  {
    switch (1.a[paramb.ordinal()])
    {
    default: 
      throw new q("Invalid mode: " + paramb);
    case 1: 
      a(paramString1, parama);
      return;
    case 2: 
      b(paramString1, parama);
      return;
    case 3: 
      a(paramString1, parama, paramString2);
      return;
    }
    a(paramString1, parama);
  }
  
  private static boolean a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("Shift_JIS");
      int j = paramString.length;
      if (j % 2 != 0) {
        return false;
      }
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label68;
        }
        int k = paramString[i] & 0xFF;
        if (((k < 129) || (k > 159)) && ((k < 224) || (k > 235))) {
          break;
        }
        i += 2;
      }
      label68:
      return true;
    }
    catch (UnsupportedEncodingException paramString) {}
    return false;
  }
  
  static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    int k = paramArrayOfByte.length;
    int[] arrayOfInt = new int[k + paramInt];
    int i = 0;
    while (i < k)
    {
      paramArrayOfByte[i] &= 0xFF;
      i += 1;
    }
    new com.google.c.a.a.c(com.google.c.a.a.a.e).encode(arrayOfInt, paramInt);
    paramArrayOfByte = new byte[paramInt];
    i = j;
    while (i < paramInt)
    {
      paramArrayOfByte[i] = ((byte)arrayOfInt[(k + i)]);
      i += 1;
    }
    return paramArrayOfByte;
  }
  
  static void b(CharSequence paramCharSequence, com.google.c.a.a parama)
    throws q
  {
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j)
    {
      int k = a(paramCharSequence.charAt(i));
      if (k == -1) {
        throw new q();
      }
      if (i + 1 < j)
      {
        int m = a(paramCharSequence.charAt(i + 1));
        if (m == -1) {
          throw new q();
        }
        parama.appendBits(k * 45 + m, 11);
        i += 2;
      }
      else
      {
        parama.appendBits(k, 6);
        i += 1;
      }
    }
  }
  
  public static com.google.c.d.a.b chooseMode(String paramString)
  {
    return a(paramString, null);
  }
  
  public static void encode(String paramString, com.google.c.d.a.a parama, f paramf)
    throws q
  {
    encode(paramString, parama, null, paramf);
  }
  
  public static void encode(String paramString, com.google.c.d.a.a parama, Map<com.google.c.f, ?> paramMap, f paramf)
    throws q
  {
    com.google.c.d.a.b localb;
    com.google.c.a.a locala;
    if (paramMap == null)
    {
      paramMap = null;
      Object localObject = paramMap;
      if (paramMap == null) {
        localObject = "ISO-8859-1";
      }
      localb = a(paramString, (String)localObject);
      locala = new com.google.c.a.a();
      a(paramString, localb, locala, (String)localObject);
      a(locala.getSize(), parama, localb, paramf);
      paramMap = new com.google.c.a.a();
      if ((localb == com.google.c.d.a.b.e) && (!"ISO-8859-1".equals(localObject)))
      {
        localObject = com.google.c.a.c.getCharacterSetECIByName((String)localObject);
        if (localObject != null) {
          a((com.google.c.a.c)localObject, paramMap);
        }
      }
      a(localb, paramMap);
      if (localb != com.google.c.d.a.b.e) {
        break label277;
      }
    }
    label277:
    for (int i = locala.getSizeInBytes();; i = paramString.length())
    {
      a(i, paramf.getVersion(), localb, paramMap);
      paramMap.appendBitArray(locala);
      a(paramf.getNumDataBytes(), paramMap);
      paramString = new com.google.c.a.a();
      a(paramMap, paramf.getNumTotalBytes(), paramf.getNumDataBytes(), paramf.getNumRSBlocks(), paramString);
      paramMap = new b(paramf.getMatrixWidth(), paramf.getMatrixWidth());
      paramf.setMaskPattern(a(paramString, parama, paramf.getVersion(), paramMap));
      e.a(paramString, parama, paramf.getVersion(), paramf.getMaskPattern(), paramMap);
      paramf.setMatrix(paramMap);
      if (paramf.isValid()) {
        return;
      }
      throw new q("Invalid QR code: " + paramf.toString());
      paramMap = (String)paramMap.get(com.google.c.f.b);
      break;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/d/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */