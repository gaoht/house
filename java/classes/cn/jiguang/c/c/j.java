package cn.jiguang.c.c;

import java.io.Serializable;
import java.text.DecimalFormat;

public final class j
  implements Serializable, Comparable
{
  public static final j a;
  public static final j b;
  private static final byte[] f;
  private static final byte[] g;
  private static final DecimalFormat h;
  private static final byte[] i;
  private static final j j;
  private static final String[] z;
  private byte[] c;
  private long d;
  private int e;
  
  static
  {
    String[] arrayOfString = new String[12];
    int m = 0;
    Object localObject2 = "mA_:fmK\t7kfJE";
    int k = -1;
    Object localObject1 = arrayOfString;
    int i6;
    Object localObject3;
    for (;;)
    {
      char[] arrayOfChar = ((String)localObject2).toCharArray();
      int n = arrayOfChar.length;
      int i3 = 0;
      int i1 = 0;
      int i5 = k;
      localObject2 = arrayOfChar;
      i6 = m;
      localObject3 = localObject1;
      int i2 = n;
      Object localObject4;
      int i4;
      if (n <= 1)
      {
        localObject4 = localObject1;
        localObject1 = arrayOfChar;
        i4 = k;
      }
      label143:
      do
      {
        i2 = i1;
        for (;;)
        {
          localObject2 = localObject1;
          i3 = localObject2[i1];
          switch (i2 % 5)
          {
          default: 
            k = 10;
            localObject2[i1] = ((char)(k ^ i3));
            i2 += 1;
            if (n != 0) {
              break label143;
            }
            i1 = n;
          }
        }
        i3 = i2;
        i2 = n;
        localObject3 = localObject4;
        i6 = m;
        localObject2 = localObject1;
        i5 = i4;
        i4 = i5;
        localObject1 = localObject2;
        m = i6;
        localObject4 = localObject3;
        n = i2;
        i1 = i3;
      } while (i2 > i3);
      localObject1 = new String((char[])localObject2).intern();
      switch (i5)
      {
      default: 
        localObject3[i6] = localObject1;
        m = 1;
        localObject2 = "#\025\t";
        k = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i6] = localObject1;
        m = 2;
        localObject2 = "hNK>f$@\\/*kI\t)kjHL";
        k = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i6] = localObject1;
        m = 3;
        localObject2 = "fNM{owLH+o";
        k = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i6] = localObject1;
        m = 4;
        localObject2 = "aBY/s$AH6o";
        k = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i6] = localObject1;
        m = 5;
        localObject2 = "hNK>f$[F4*h@G<";
        k = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i6] = localObject1;
        m = 6;
        localObject2 = "mA_:fmK\t>gt[P{feML7";
        k = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i6] = localObject1;
        m = 7;
        localObject2 = "e[]>gt[L?*p@\t)oi@_>*p@F{geAP{feML7y";
        k = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i6] = localObject1;
        m = 8;
        localObject2 = "JND>*p@F{fkAN";
        k = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i6] = localObject1;
        m = 9;
        localObject2 = "fNM{feML7*pVY>";
        k = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i6] = localObject1;
        m = 10;
        localObject2 = "fNM{ikBY)ow\\@4d";
        k = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i6] = localObject1;
        m = 11;
        localObject2 = "p@F{geAP{feML7y";
        k = 10;
        localObject1 = arrayOfString;
      }
    }
    localObject3[i6] = localObject1;
    z = arrayOfString;
    f = new byte[] { 0 };
    g = new byte[] { 1, 42 };
    h = new DecimalFormat();
    i = new byte['Ā'];
    h.setMinimumIntegerDigits(3);
    k = 0;
    label586:
    if (k < i.length)
    {
      if ((k < 65) || (k > 90)) {
        i[k] = ((byte)k);
      }
      for (;;)
      {
        k += 1;
        break label586;
        k = 4;
        break;
        k = 47;
        break;
        k = 41;
        break;
        k = 91;
        break;
        i[k] = ((byte)(k - 65 + 97));
      }
    }
    localObject1 = new j();
    a = (j)localObject1;
    ((j)localObject1).b(f, 0, 1);
    localObject1 = new j();
    b = (j)localObject1;
    ((j)localObject1).c = new byte[0];
    localObject1 = new j();
    j = (j)localObject1;
    ((j)localObject1).b(g, 0, 1);
  }
  
  private j() {}
  
  public j(d paramd)
  {
    byte[] arrayOfByte = new byte[64];
    int m = 0;
    int k = 0;
    while (k == 0)
    {
      int n = paramd.f();
      switch (n & 0xC0)
      {
      default: 
        throw new t(z[9]);
      case 0: 
        if (c() >= 128) {
          throw new t(z[11]);
        }
        if (n == 0)
        {
          a(f, 0, 1);
          k = 1;
        }
        else
        {
          arrayOfByte[0] = ((byte)n);
          paramd.a(arrayOfByte, 1, n);
          a(arrayOfByte, 0, 1);
        }
        break;
      case 192: 
        int i1 = ((n & 0xFF3F) << 8) + paramd.f();
        if (i1 >= paramd.a() - 2) {
          throw new t(z[10]);
        }
        n = m;
        if (m == 0)
        {
          paramd.d();
          n = 1;
        }
        paramd.b(i1);
        m = n;
      }
    }
    if (m != 0) {
      paramd.e();
    }
  }
  
  private j(j paramj, int paramInt)
  {
    int m = paramj.c();
    if (paramInt > m) {
      throw new IllegalArgumentException(z[7]);
    }
    this.c = paramj.c;
    b(m - paramInt);
    int k = 0;
    while ((k < 7) && (k < m - paramInt))
    {
      a(k, paramj.a(k + paramInt));
      k += 1;
    }
  }
  
  private j(String paramString, j paramj)
  {
    if (paramString.equals("")) {
      throw a(paramString, z[4]);
    }
    if (paramString.equals("@"))
    {
      if (paramj == null)
      {
        b(b, this);
        return;
      }
      b(paramj, this);
      return;
    }
    if (paramString.equals("."))
    {
      b(a, this);
      return;
    }
    int i2 = -1;
    int i4 = 1;
    byte[] arrayOfByte = new byte[64];
    int i5 = 0;
    int n = 0;
    int m = 0;
    int i3 = 0;
    int k;
    int i1;
    if (i3 < paramString.length())
    {
      k = (byte)paramString.charAt(i3);
      if (i5 != 0) {
        if ((k >= 48) && (k <= 57) && (n < 3))
        {
          int i6 = n + 1;
          int i7 = m * 10 + (k - 48);
          if (i7 > 255) {
            throw a(paramString, z[3]);
          }
          m = i7;
          n = i6;
          i1 = i4;
          if (i6 < 3) {
            break label254;
          }
          k = (byte)i7;
          n = i6;
          m = i7;
        }
      }
    }
    for (;;)
    {
      if (i4 > 63)
      {
        throw a(paramString, z[5]);
        if ((n > 0) && (n < 3)) {
          throw a(paramString, z[3]);
        }
      }
      else
      {
        arrayOfByte[i4] = k;
        i5 = 0;
        i2 = i4;
        i1 = i4 + 1;
        for (;;)
        {
          label254:
          i3 += 1;
          i4 = i1;
          break;
          if (k == 92)
          {
            i5 = 1;
            n = 0;
            m = 0;
            i1 = i4;
          }
          else
          {
            if (k != 46) {
              break label339;
            }
            if (i2 == -1) {
              throw a(paramString, z[6]);
            }
            arrayOfByte[0] = ((byte)(i4 - 1));
            a(paramString, arrayOfByte, 0, 1);
            i2 = -1;
            i1 = 1;
          }
        }
        label339:
        if (i2 == -1) {}
        for (i1 = i3;; i1 = i2)
        {
          if (i4 > 63) {
            throw a(paramString, z[5]);
          }
          arrayOfByte[i4] = k;
          i4 += 1;
          i2 = i1;
          i1 = i4;
          break label254;
          if ((n > 0) && (n < 3)) {
            throw a(paramString, z[3]);
          }
          if (i5 != 0) {
            throw a(paramString, z[3]);
          }
          if (i2 == -1) {
            a(paramString, f, 0, 1);
          }
          for (m = 1; (paramj != null) && (m == 0); m = 0)
          {
            a(paramString, paramj.c, paramj.a(0), paramj.c());
            return;
            arrayOfByte[0] = ((byte)(i4 - 1));
            a(paramString, arrayOfByte, 0, 1);
          }
          break;
        }
      }
    }
  }
  
  private final int a(int paramInt)
  {
    int n;
    if ((paramInt == 0) && (c() == 0))
    {
      n = 0;
      return n;
    }
    if ((paramInt < 0) || (paramInt >= c())) {
      throw new IllegalArgumentException(z[2]);
    }
    if (paramInt < 7) {
      return (int)(this.d >>> (7 - paramInt) * 8) & 0xFF;
    }
    int k = a(6);
    int m = 6;
    for (;;)
    {
      n = k;
      if (m >= paramInt) {
        break;
      }
      n = this.c[k];
      m += 1;
      k = n + 1 + k;
    }
  }
  
  public static j a(j paramj1, j paramj2)
  {
    if (paramj1.a()) {
      return paramj1;
    }
    j localj = new j();
    b(paramj1, localj);
    localj.a(paramj2.c, paramj2.a(0), paramj2.c());
    return localj;
  }
  
  public static j a(String paramString)
  {
    return a(paramString, null);
  }
  
  public static j a(String paramString, j paramj)
  {
    if ((paramString.equals("@")) && (paramj != null)) {
      return paramj;
    }
    if (paramString.equals(".")) {
      return a;
    }
    return new j(paramString, paramj);
  }
  
  private static s a(String paramString1, String paramString2)
  {
    return new s("'" + paramString1 + z[1] + paramString2);
  }
  
  private static String a(byte[] paramArrayOfByte, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int k = paramInt + 1;
    int m = paramArrayOfByte[paramInt];
    paramInt = k;
    if (paramInt < k + m)
    {
      int n = paramArrayOfByte[paramInt] & 0xFF;
      if ((n <= 32) || (n >= 127))
      {
        localStringBuffer.append('\\');
        localStringBuffer.append(h.format(n));
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if ((n == 34) || (n == 40) || (n == 41) || (n == 46) || (n == 59) || (n == 92) || (n == 64) || (n == 36))
        {
          localStringBuffer.append('\\');
          localStringBuffer.append((char)n);
        }
        else
        {
          localStringBuffer.append((char)n);
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 7) {
      return;
    }
    paramInt1 = (7 - paramInt1) * 8;
    this.d &= (255L << paramInt1 ^ 0xFFFFFFFFFFFFFFFF);
    long l = this.d;
    this.d = (paramInt2 << paramInt1 | l);
  }
  
  private final void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      a(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (k paramArrayOfByte)
    {
      throw a(paramString, z[8]);
    }
  }
  
  private final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i2 = 0;
    int k;
    int m;
    if (this.c == null)
    {
      k = 0;
      i1 = paramInt1;
      n = 0;
      m = 0;
    }
    for (;;)
    {
      if (n >= paramInt2) {
        break label99;
      }
      i3 = paramArrayOfByte[i1];
      if (i3 > 63)
      {
        throw new IllegalStateException(z[0]);
        k = this.c.length - a(0);
        break;
      }
      i3 += 1;
      i1 += i3;
      m += i3;
      n += 1;
    }
    label99:
    int i3 = k + m;
    if (i3 > 255) {
      throw new k();
    }
    int n = c();
    int i1 = n + paramInt2;
    if (i1 > 128) {
      throw new IllegalStateException(z[11]);
    }
    byte[] arrayOfByte = new byte[i3];
    if (k != 0) {
      System.arraycopy(this.c, a(0), arrayOfByte, 0, k);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, k, m);
    this.c = arrayOfByte;
    paramInt1 = i2;
    while (paramInt1 < paramInt2)
    {
      a(n + paramInt1, k);
      k += arrayOfByte[k] + 1;
      paramInt1 += 1;
    }
    b(i1);
  }
  
  private final void b(int paramInt)
  {
    this.d &= 0xFFFFFFFFFFFFFF00;
    this.d |= paramInt;
  }
  
  private static final void b(j paramj1, j paramj2)
  {
    int k = 0;
    if (paramj1.a(0) == 0)
    {
      paramj2.c = paramj1.c;
      paramj2.d = paramj1.d;
      return;
    }
    int m = paramj1.a(0);
    int i1 = paramj1.c.length - m;
    int n = paramj1.c();
    paramj2.c = new byte[i1];
    System.arraycopy(paramj1.c, m, paramj2.c, 0, i1);
    while ((k < n) && (k < 7))
    {
      paramj2.a(k, paramj1.a(k) - m);
      k += 1;
    }
    paramj2.b(n);
  }
  
  private final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      a(paramArrayOfByte, 0, 1);
      return;
    }
    catch (k paramArrayOfByte) {}
  }
  
  private final int c()
  {
    return (int)(this.d & 0xFF);
  }
  
  public final void a(e parame)
  {
    int i2 = c();
    Object localObject;
    if (i2 == 0)
    {
      localObject = new byte[0];
      parame.a((byte[])localObject);
      return;
    }
    byte[] arrayOfByte = new byte[this.c.length - a(0)];
    int k = a(0);
    int m = 0;
    int n = 0;
    for (;;)
    {
      localObject = arrayOfByte;
      if (n >= i2) {
        break;
      }
      int i3 = this.c[k];
      if (i3 > 63) {
        throw new IllegalStateException(z[0]);
      }
      arrayOfByte[m] = this.c[k];
      k += 1;
      m += 1;
      int i1 = 0;
      while (i1 < i3)
      {
        arrayOfByte[m] = i[(this.c[k] & 0xFF)];
        i1 += 1;
        m += 1;
        k += 1;
      }
      n += 1;
    }
  }
  
  public final void a(e parame, b paramb)
  {
    int n = c();
    int k = 0;
    while (k < n - 1)
    {
      if (k == 0) {}
      for (j localj = this;; localj = new j(this, k))
      {
        m = -1;
        if (paramb != null) {
          m = paramb.a(localj);
        }
        if (m < 0) {
          break;
        }
        parame.c(m | 0xC000);
        return;
      }
      if (paramb != null) {
        paramb.a(parame.a(), localj);
      }
      int m = a(k);
      parame.a(this.c, m, this.c[m] + 1);
      k += 1;
    }
    parame.b(0);
  }
  
  public final void a(e parame, b paramb, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(parame);
      return;
    }
    a(parame, null);
  }
  
  public final boolean a()
  {
    int k = c();
    if (k == 0) {}
    while (this.c[a(k - 1)] != 0) {
      return false;
    }
    return true;
  }
  
  public final int b()
  {
    return c();
  }
  
  public final int compareTo(Object paramObject)
  {
    paramObject = (j)paramObject;
    if (this == paramObject) {
      return 0;
    }
    int i1 = c();
    int i2 = ((j)paramObject).c();
    int k;
    int m;
    if (i1 > i2)
    {
      k = i2;
      m = 1;
    }
    for (;;)
    {
      if (m > k) {
        break label182;
      }
      int i3 = a(i1 - m);
      int i4 = ((j)paramObject).a(i2 - m);
      int i5 = this.c[i3];
      int i6 = paramObject.c[i4];
      int n = 0;
      for (;;)
      {
        if ((n >= i5) || (n >= i6)) {
          break label162;
        }
        int i7 = i[(this.c[(n + i3 + 1)] & 0xFF)] - i[(paramObject.c[(n + i4 + 1)] & 0xFF)];
        if (i7 != 0)
        {
          return i7;
          k = i1;
          break;
        }
        n += 1;
      }
      label162:
      if (i5 != i6) {
        return i5 - i6;
      }
      m += 1;
    }
    label182:
    return i1 - i2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof j))) {
        return false;
      }
      paramObject = (j)paramObject;
      if (((j)paramObject).e == 0) {
        ((j)paramObject).hashCode();
      }
      if (this.e == 0) {
        hashCode();
      }
      if (((j)paramObject).e != this.e) {
        return false;
      }
      if (((j)paramObject).c() != c()) {
        return false;
      }
      byte[] arrayOfByte = ((j)paramObject).c;
      int k = ((j)paramObject).a(0);
      int i2 = c();
      int m = a(0);
      int n = 0;
      while (n < i2)
      {
        if (this.c[m] != arrayOfByte[k]) {
          return false;
        }
        int i3 = this.c[m];
        if (i3 > 63) {
          throw new IllegalStateException(z[0]);
        }
        k += 1;
        m += 1;
        int i1 = 0;
        while (i1 < i3)
        {
          if (i[(this.c[m] & 0xFF)] != i[(arrayOfByte[k] & 0xFF)]) {
            return false;
          }
          i1 += 1;
          k += 1;
          m += 1;
        }
        n += 1;
      }
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (this.e != 0) {
      return this.e;
    }
    int k = a(0);
    while (k < this.c.length)
    {
      m += (m << 3) + i[(this.c[k] & 0xFF)];
      k += 1;
    }
    this.e = m;
    return this.e;
  }
  
  public final String toString()
  {
    int n = c();
    if (n == 0) {
      return "@";
    }
    if ((n == 1) && (this.c[a(0)] == 0)) {
      return ".";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int m = a(0);
    int k = 0;
    for (;;)
    {
      int i1;
      if (k < n)
      {
        i1 = this.c[m];
        if (i1 > 63) {
          throw new IllegalStateException(z[0]);
        }
        if (i1 == 0) {
          localStringBuffer.append('.');
        }
      }
      else
      {
        return localStringBuffer.toString();
      }
      if (k > 0) {
        localStringBuffer.append('.');
      }
      localStringBuffer.append(a(this.c, m));
      m += i1 + 1;
      k += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */