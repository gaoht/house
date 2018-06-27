package com.megvii.zhimasdk.b.a.b.f;

import com.megvii.zhimasdk.b.a.c;
import com.megvii.zhimasdk.b.a.k.f;
import com.megvii.zhimasdk.b.a.k.l;
import com.megvii.zhimasdk.b.a.k.u;
import com.megvii.zhimasdk.b.a.o.d;
import com.megvii.zhimasdk.b.a.y;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class e
{
  private static final char[] a = { 38, 59 };
  private static final String b = "[" + new String(a) + "]";
  private static final BitSet c = new BitSet(256);
  private static final BitSet d = new BitSet(256);
  private static final BitSet e = new BitSet(256);
  private static final BitSet f = new BitSet(256);
  private static final BitSet g = new BitSet(256);
  private static final BitSet h = new BitSet(256);
  private static final BitSet i = new BitSet(256);
  
  static
  {
    int j = 97;
    while (j <= 122)
    {
      c.set(j);
      j += 1;
    }
    j = 65;
    while (j <= 90)
    {
      c.set(j);
      j += 1;
    }
    j = 48;
    while (j <= 57)
    {
      c.set(j);
      j += 1;
    }
    c.set(95);
    c.set(45);
    c.set(46);
    c.set(42);
    i.or(c);
    c.set(33);
    c.set(126);
    c.set(39);
    c.set(40);
    c.set(41);
    d.set(44);
    d.set(59);
    d.set(58);
    d.set(36);
    d.set(38);
    d.set(43);
    d.set(61);
    e.or(c);
    e.or(d);
    f.or(c);
    f.set(47);
    f.set(59);
    f.set(58);
    f.set(64);
    f.set(38);
    f.set(61);
    f.set(43);
    f.set(36);
    f.set(44);
    h.set(59);
    h.set(47);
    h.set(63);
    h.set(58);
    h.set(64);
    h.set(38);
    h.set(61);
    h.set(43);
    h.set(36);
    h.set(44);
    h.set(91);
    h.set(93);
    g.or(h);
    g.or(c);
  }
  
  public static String a(Iterable<? extends y> paramIterable, char paramChar, Charset paramCharset)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = (y)paramIterable.next();
      String str = f(((y)localObject).a(), paramCharset);
      localObject = f(((y)localObject).b(), paramCharset);
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(paramChar);
      }
      localStringBuilder.append(str);
      if (localObject != null)
      {
        localStringBuilder.append("=");
        localStringBuilder.append((String)localObject);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(Iterable<? extends y> paramIterable, Charset paramCharset)
  {
    return a(paramIterable, '&', paramCharset);
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    if (paramString2 != null) {}
    for (paramString2 = Charset.forName(paramString2);; paramString2 = c.a) {
      return a(paramString1, paramString2, i, true);
    }
  }
  
  private static String a(String paramString, Charset paramCharset, BitSet paramBitSet, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = paramCharset.encode(paramString);
    while (paramString.hasRemaining())
    {
      int j = paramString.get() & 0xFF;
      if (paramBitSet.get(j))
      {
        localStringBuilder.append((char)j);
      }
      else if ((paramBoolean) && (j == 32))
      {
        localStringBuilder.append('+');
      }
      else
      {
        localStringBuilder.append("%");
        char c1 = Character.toUpperCase(Character.forDigit(j >> 4 & 0xF, 16));
        char c2 = Character.toUpperCase(Character.forDigit(j & 0xF, 16));
        localStringBuilder.append(c1);
        localStringBuilder.append(c2);
      }
    }
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString, Charset paramCharset, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramString.length());
    paramString = CharBuffer.wrap(paramString);
    while (paramString.hasRemaining())
    {
      int j = paramString.get();
      if ((j == 37) && (paramString.remaining() >= 2))
      {
        char c1 = paramString.get();
        char c2 = paramString.get();
        j = Character.digit(c1, 16);
        int k = Character.digit(c2, 16);
        if ((j != -1) && (k != -1))
        {
          localByteBuffer.put((byte)((j << 4) + k));
        }
        else
        {
          localByteBuffer.put((byte)37);
          localByteBuffer.put((byte)c1);
          localByteBuffer.put((byte)c2);
        }
      }
      else if ((paramBoolean) && (j == 43))
      {
        localByteBuffer.put((byte)32);
      }
      else
      {
        localByteBuffer.put((byte)j);
      }
    }
    localByteBuffer.flip();
    return paramCharset.decode(localByteBuffer).toString();
  }
  
  public static String a(List<? extends y> paramList, char paramChar, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (y)paramList.next();
      String str = a(((y)localObject).a(), paramString);
      localObject = a(((y)localObject).b(), paramString);
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(paramChar);
      }
      localStringBuilder.append(str);
      if (localObject != null)
      {
        localStringBuilder.append("=");
        localStringBuilder.append((String)localObject);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(List<? extends y> paramList, String paramString)
  {
    return a(paramList, '&', paramString);
  }
  
  public static List<y> a(String paramString, Charset paramCharset)
  {
    return a(paramString, paramCharset, a);
  }
  
  public static List<y> a(String paramString, Charset paramCharset, char... paramVarArgs)
  {
    if (paramString == null)
    {
      paramString = Collections.emptyList();
      return paramString;
    }
    f localf = f.b;
    d locald = new d(paramString.length());
    locald.a(paramString);
    u localu = new u(0, locald.c());
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      paramString = localArrayList;
      if (localu.c()) {
        break;
      }
      paramString = localf.a(locald, localu, paramVarArgs);
      if (paramString.a().length() > 0) {
        localArrayList.add(new l(e(paramString.a(), paramCharset), e(paramString.b(), paramCharset)));
      }
    }
  }
  
  static String b(String paramString, Charset paramCharset)
  {
    return a(paramString, paramCharset, e, false);
  }
  
  static String c(String paramString, Charset paramCharset)
  {
    return a(paramString, paramCharset, g, false);
  }
  
  static String d(String paramString, Charset paramCharset)
  {
    return a(paramString, paramCharset, f, false);
  }
  
  private static String e(String paramString, Charset paramCharset)
  {
    if (paramString == null) {
      return null;
    }
    if (paramCharset != null) {}
    for (;;)
    {
      return a(paramString, paramCharset, true);
      paramCharset = c.a;
    }
  }
  
  private static String f(String paramString, Charset paramCharset)
  {
    if (paramString == null) {
      return null;
    }
    if (paramCharset != null) {}
    for (;;)
    {
      return a(paramString, paramCharset, i, true);
      paramCharset = c.a;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/b/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */