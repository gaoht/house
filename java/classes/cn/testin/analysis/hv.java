package cn.testin.analysis;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

final class hv
{
  private static final char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();
  
  private static char a(int paramInt)
  {
    if (paramInt >= a.length) {
      throw ft.a();
    }
    return a[paramInt];
  }
  
  private static int a(gu paramgu)
  {
    int i = paramgu.a(8);
    if ((i & 0x80) == 0) {
      return i & 0x7F;
    }
    if ((i & 0xC0) == 128) {
      return (i & 0x3F) << 8 | paramgu.a(8);
    }
    if ((i & 0xE0) == 192) {
      return (i & 0x1F) << 16 | paramgu.a(16);
    }
    throw ft.a();
  }
  
  static gw a(byte[] paramArrayOfByte, ic paramic, hy paramhy, Map<fs, ?> paramMap)
  {
    gu localgu = new gu(paramArrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder(50);
    ArrayList localArrayList = new ArrayList(1);
    Object localObject1 = null;
    int i = -1;
    int j = -1;
    boolean bool = false;
    ia localia;
    label104:
    int k;
    for (;;)
    {
      try
      {
        if (localgu.a() < 4)
        {
          localia = ia.a;
          switch (hw.a[localia.ordinal()])
          {
          case 6: 
            k = localgu.a(localia.a(paramic));
            switch (hw.a[localia.ordinal()])
            {
            case 1: 
              label156:
              throw ft.a();
            }
            break;
          }
        }
      }
      catch (IllegalArgumentException paramArrayOfByte)
      {
        throw ft.a();
      }
      localia = ia.a(localgu.a(4));
    }
    for (;;)
    {
      Object localObject2 = ia.a;
      if (localia == localObject2)
      {
        paramMap = localStringBuilder.toString();
        if (localArrayList.isEmpty())
        {
          paramic = null;
          label209:
          if (paramhy != null) {
            break label471;
          }
        }
        label471:
        for (paramhy = null;; paramhy = paramhy.toString())
        {
          return new gw(paramArrayOfByte, paramMap, paramic, paramhy, i, j);
          bool = true;
          k = i;
          i = j;
          j = k;
          break;
          if (localgu.a() < 16) {
            throw ft.a();
          }
          i = localgu.a(8);
          j = localgu.a(8);
          break;
          localObject1 = gv.a(a(localgu));
          localObject2 = localObject1;
          if (localObject1 != null) {
            break label479;
          }
          throw ft.a();
          k = localgu.a(4);
          int m = localgu.a(localia.a(paramic));
          localObject2 = localObject1;
          if (k != 1) {
            break label479;
          }
          a(localgu, localStringBuilder, m);
          k = i;
          i = j;
          j = k;
          break;
          c(localgu, localStringBuilder, k);
          k = i;
          i = j;
          j = k;
          break;
          a(localgu, localStringBuilder, k, bool);
          k = i;
          i = j;
          j = k;
          break;
          a(localgu, localStringBuilder, k, (gv)localObject1, localArrayList, paramMap);
          k = i;
          i = j;
          j = k;
          break;
          b(localgu, localStringBuilder, k);
          k = i;
          i = j;
          j = k;
          break;
          paramic = localArrayList;
          break label209;
        }
        label479:
        k = i;
        localObject1 = localObject2;
        i = j;
        j = k;
      }
      else
      {
        k = i;
        i = j;
        j = k;
        break;
        break label104;
        break label156;
        k = i;
        i = j;
        j = k;
      }
    }
  }
  
  private static void a(gu paramgu, StringBuilder paramStringBuilder, int paramInt)
  {
    if (paramInt * 13 > paramgu.a()) {
      throw ft.a();
    }
    byte[] arrayOfByte = new byte[paramInt * 2];
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (i > 0)
    {
      j = paramgu.a(13);
      j = j % 96 | j / 96 << 8;
      if (j < 959) {
        j += 41377;
      }
      for (;;)
      {
        arrayOfByte[paramInt] = ((byte)(j >> 8 & 0xFF));
        arrayOfByte[(paramInt + 1)] = ((byte)(j & 0xFF));
        i -= 1;
        paramInt += 2;
        break;
        j += 42657;
      }
    }
    try
    {
      paramStringBuilder.append(new String(arrayOfByte, "GB2312"));
      return;
    }
    catch (UnsupportedEncodingException paramgu)
    {
      throw ft.a();
    }
  }
  
  private static void a(gu paramgu, StringBuilder paramStringBuilder, int paramInt, gv paramgv, Collection<byte[]> paramCollection, Map<fs, ?> paramMap)
  {
    if (paramInt * 8 > paramgu.a()) {
      throw ft.a();
    }
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfByte[i] = ((byte)paramgu.a(8));
      i += 1;
    }
    if (paramgv == null) {}
    for (paramgu = hd.a(arrayOfByte, paramMap);; paramgu = paramgv.name()) {
      try
      {
        paramStringBuilder.append(new String(arrayOfByte, paramgu));
        paramCollection.add(arrayOfByte);
        return;
      }
      catch (UnsupportedEncodingException paramgu)
      {
        throw ft.a();
      }
    }
  }
  
  private static void a(gu paramgu, StringBuilder paramStringBuilder, int paramInt, boolean paramBoolean)
  {
    int i = paramStringBuilder.length();
    while (paramInt > 1)
    {
      if (paramgu.a() < 11) {
        throw ft.a();
      }
      int j = paramgu.a(11);
      paramStringBuilder.append(a(j / 45));
      paramStringBuilder.append(a(j % 45));
      paramInt -= 2;
    }
    if (paramInt == 1)
    {
      if (paramgu.a() < 6) {
        throw ft.a();
      }
      paramStringBuilder.append(a(paramgu.a(6)));
    }
    if (paramBoolean)
    {
      paramInt = i;
      if (paramInt < paramStringBuilder.length())
      {
        if (paramStringBuilder.charAt(paramInt) == '%')
        {
          if ((paramInt >= paramStringBuilder.length() - 1) || (paramStringBuilder.charAt(paramInt + 1) != '%')) {
            break label159;
          }
          paramStringBuilder.deleteCharAt(paramInt + 1);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          label159:
          paramStringBuilder.setCharAt(paramInt, '\035');
        }
      }
    }
  }
  
  private static void b(gu paramgu, StringBuilder paramStringBuilder, int paramInt)
  {
    if (paramInt * 13 > paramgu.a()) {
      throw ft.a();
    }
    byte[] arrayOfByte = new byte[paramInt * 2];
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (i > 0)
    {
      j = paramgu.a(13);
      j = j % 192 | j / 192 << 8;
      if (j < 7936) {
        j += 33088;
      }
      for (;;)
      {
        arrayOfByte[paramInt] = ((byte)(j >> 8));
        arrayOfByte[(paramInt + 1)] = ((byte)j);
        i -= 1;
        paramInt += 2;
        break;
        j += 49472;
      }
    }
    try
    {
      paramStringBuilder.append(new String(arrayOfByte, "SJIS"));
      return;
    }
    catch (UnsupportedEncodingException paramgu)
    {
      throw ft.a();
    }
  }
  
  private static void c(gu paramgu, StringBuilder paramStringBuilder, int paramInt)
  {
    while (paramInt >= 3)
    {
      if (paramgu.a() < 10) {
        throw ft.a();
      }
      int i = paramgu.a(10);
      if (i >= 1000) {
        throw ft.a();
      }
      paramStringBuilder.append(a(i / 100));
      paramStringBuilder.append(a(i / 10 % 10));
      paramStringBuilder.append(a(i % 10));
      paramInt -= 3;
    }
    if (paramInt == 2)
    {
      if (paramgu.a() < 7) {
        throw ft.a();
      }
      paramInt = paramgu.a(7);
      if (paramInt >= 100) {
        throw ft.a();
      }
      paramStringBuilder.append(a(paramInt / 10));
      paramStringBuilder.append(a(paramInt % 10));
    }
    while (paramInt != 1) {
      return;
    }
    if (paramgu.a() < 4) {
      throw ft.a();
    }
    paramInt = paramgu.a(4);
    if (paramInt >= 10) {
      throw ft.a();
    }
    paramStringBuilder.append(a(paramInt));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/hv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */