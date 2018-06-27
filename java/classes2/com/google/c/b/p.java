package com.google.c.b;

import com.google.c.j;
import com.google.c.l;
import com.google.c.m;
import com.google.c.n;
import java.util.EnumMap;
import java.util.Map;

final class p
{
  private static final int[] a = { 1, 1, 2 };
  private static final int[] b = { 24, 20, 18, 17, 12, 6, 3, 10, 9, 5 };
  private final int[] c = new int[4];
  private final StringBuilder d = new StringBuilder();
  
  private static int a(int paramInt)
    throws j
  {
    int i = 0;
    while (i < 10)
    {
      if (paramInt == b[i]) {
        return i;
      }
      i += 1;
    }
    throw j.getNotFoundInstance();
  }
  
  private static int a(CharSequence paramCharSequence)
  {
    int k = paramCharSequence.length();
    int j = 0;
    int i = k - 2;
    while (i >= 0)
    {
      j += paramCharSequence.charAt(i) - '0';
      i -= 2;
    }
    j *= 3;
    i = k - 1;
    while (i >= 0)
    {
      j += paramCharSequence.charAt(i) - '0';
      i -= 2;
    }
    return j * 3 % 10;
  }
  
  private static Map<m, Object> a(String paramString)
  {
    m localm;
    switch (paramString.length())
    {
    case 3: 
    case 4: 
    default: 
      return null;
    case 2: 
      localm = m.e;
    }
    for (paramString = b(paramString); paramString != null; paramString = c(paramString))
    {
      EnumMap localEnumMap = new EnumMap(m.class);
      localEnumMap.put(localm, paramString);
      return localEnumMap;
      localm = m.f;
    }
  }
  
  private static Integer b(String paramString)
  {
    return Integer.valueOf(paramString);
  }
  
  private static String c(String paramString)
  {
    String str;
    int j;
    int i;
    switch (paramString.charAt(0))
    {
    default: 
      str = "";
      j = Integer.parseInt(paramString.substring(1));
      i = j / 100;
      j %= 100;
      if (j >= 10) {
        break;
      }
    }
    for (paramString = "0" + j;; paramString = String.valueOf(j))
    {
      return str + String.valueOf(i) + '.' + paramString;
      str = "£";
      break;
      str = "$";
      break;
      if ("90000".equals(paramString)) {
        return null;
      }
      if ("99991".equals(paramString)) {
        return "0.00";
      }
      if ("99990".equals(paramString)) {
        return "Used";
      }
      str = "";
      break;
    }
  }
  
  int a(com.google.c.a.a parama, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
    throws j
  {
    int[] arrayOfInt = this.c;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int n = parama.getSize();
    int i = paramArrayOfInt[1];
    int k = 0;
    int m;
    for (int j = 0; (k < 5) && (i < n); j = m)
    {
      int i1 = q.a(parama, arrayOfInt, i, q.e);
      paramStringBuilder.append((char)(i1 % 10 + 48));
      int i2 = arrayOfInt.length;
      m = 0;
      while (m < i2)
      {
        int i3 = arrayOfInt[m];
        m += 1;
        i = i3 + i;
      }
      m = j;
      if (i1 >= 10) {
        m = j | 1 << 4 - k;
      }
      j = i;
      if (k != 4) {
        j = parama.getNextUnset(parama.getNextSet(i));
      }
      k += 1;
      i = j;
    }
    if (paramStringBuilder.length() != 5) {
      throw j.getNotFoundInstance();
    }
    j = a(j);
    if (a(paramStringBuilder.toString()) != j) {
      throw j.getNotFoundInstance();
    }
    return i;
  }
  
  l a(int paramInt1, com.google.c.a.a parama, int paramInt2)
    throws j
  {
    Object localObject2 = q.a(parama, paramInt2, false, a);
    Object localObject1 = this.d;
    ((StringBuilder)localObject1).setLength(0);
    paramInt2 = a(parama, (int[])localObject2, (StringBuilder)localObject1);
    localObject1 = ((StringBuilder)localObject1).toString();
    parama = a((String)localObject1);
    int i = localObject2[0];
    localObject2 = new n((localObject2[1] + i) / 2.0F, paramInt1);
    n localn = new n(paramInt2, paramInt1);
    com.google.c.a locala = com.google.c.a.q;
    localObject1 = new l((String)localObject1, null, new n[] { localObject2, localn }, locala);
    if (parama != null) {
      ((l)localObject1).putAllMetadata(parama);
    }
    return (l)localObject1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */