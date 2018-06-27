package com.google.a;

import java.io.IOException;
import java.io.OutputStream;

public class d
{
  private final byte[] a;
  private final int b;
  private int c;
  private final OutputStream d;
  
  public d() {}
  
  private d(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    this.d = paramOutputStream;
    this.a = paramArrayOfByte;
    this.c = 0;
    this.b = paramArrayOfByte.length;
  }
  
  private d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.d = null;
    this.a = paramArrayOfByte;
    this.c = paramInt1;
    this.b = (paramInt1 + paramInt2);
  }
  
  public static int a()
  {
    return 8;
  }
  
  public static d a(OutputStream paramOutputStream)
  {
    return new d(paramOutputStream, new byte['']);
  }
  
  public static d a(byte[] paramArrayOfByte)
  {
    return new d(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int b()
  {
    return 4;
  }
  
  public static int b(int paramInt, String paramString)
  {
    return k(paramInt) + b(paramString);
  }
  
  public static int b(int paramInt, boolean paramBoolean)
  {
    return k(paramInt) + 1;
  }
  
  public static int b(b paramb)
  {
    return m(paramb.a()) + paramb.a();
  }
  
  public static int b(g paramg)
  {
    int i = paramg.c();
    return i + m(i);
  }
  
  public static int b(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = m(paramString.length);
      int j = paramString.length;
      return j + i;
    }
    catch (Exception paramString)
    {
      throw new RuntimeException("UTF-8 not supported.");
    }
  }
  
  private void b(byte[] paramArrayOfByte)
    throws IOException
  {
    int j = paramArrayOfByte.length;
    if (this.b - this.c >= j)
    {
      System.arraycopy(paramArrayOfByte, 0, this.a, this.c, j);
      this.c = (j + this.c);
      return;
    }
    int k = this.b - this.c;
    System.arraycopy(paramArrayOfByte, 0, this.a, this.c, k);
    int i = k + 0;
    j -= k;
    this.c = this.b;
    i();
    if (j <= this.b)
    {
      System.arraycopy(paramArrayOfByte, i, this.a, 0, j);
      this.c = j;
      return;
    }
    this.d.write(paramArrayOfByte, i, j);
  }
  
  public static int c()
  {
    return 8;
  }
  
  public static int c(int paramInt1, int paramInt2)
  {
    return k(paramInt1) + g(paramInt2);
  }
  
  public static int d()
  {
    return 4;
  }
  
  public static int d(int paramInt1, int paramInt2)
  {
    return k(paramInt1) + m(paramInt2);
  }
  
  public static int e()
  {
    return 1;
  }
  
  public static int f()
  {
    return 4;
  }
  
  public static int f(long paramLong)
  {
    return i(paramLong);
  }
  
  public static int g()
  {
    return 8;
  }
  
  public static int g(int paramInt)
  {
    if (paramInt >= 0) {
      return m(paramInt);
    }
    return 10;
  }
  
  public static int g(long paramLong)
  {
    return i(paramLong);
  }
  
  public static int h(int paramInt)
  {
    return m(paramInt);
  }
  
  public static int h(long paramLong)
  {
    return i(j(paramLong));
  }
  
  public static int i(int paramInt)
  {
    return m(paramInt);
  }
  
  public static int i(long paramLong)
  {
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFFFFFFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFFFFFFFFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xFFFFFFFFF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0xFFFFFFF800000000 & paramLong) == 0L) {
      return 5;
    }
    if ((0xFFFFFC0000000000 & paramLong) == 0L) {
      return 6;
    }
    if ((0xFFFE000000000000 & paramLong) == 0L) {
      return 7;
    }
    if ((0xFF00000000000000 & paramLong) == 0L) {
      return 8;
    }
    if ((0x8000000000000000 & paramLong) == 0L) {
      return 9;
    }
    return 10;
  }
  
  private void i()
    throws IOException
  {
    if (this.d == null) {
      throw new a();
    }
    this.d.write(this.a, 0, this.c);
    this.c = 0;
  }
  
  public static int j(int paramInt)
  {
    return m(n(paramInt));
  }
  
  public static long j(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public static int k(int paramInt)
  {
    return m(0x0 | paramInt << 3);
  }
  
  private void k(long paramLong)
    throws IOException
  {
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        o((int)paramLong);
        return;
      }
      o((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  private void l(long paramLong)
    throws IOException
  {
    o((int)paramLong & 0xFF);
    o((int)(paramLong >> 8) & 0xFF);
    o((int)(paramLong >> 16) & 0xFF);
    o((int)(paramLong >> 24) & 0xFF);
    o((int)(paramLong >> 32) & 0xFF);
    o((int)(paramLong >> 40) & 0xFF);
    o((int)(paramLong >> 48) & 0xFF);
    o((int)(paramLong >> 56) & 0xFF);
  }
  
  public static int m(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((0xF0000000 & paramInt) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int n(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  private void o(int paramInt)
    throws IOException
  {
    int i = (byte)paramInt;
    if (this.c == this.b) {
      i();
    }
    byte[] arrayOfByte = this.a;
    paramInt = this.c;
    this.c = (paramInt + 1);
    arrayOfByte[paramInt] = i;
  }
  
  private void p(int paramInt)
    throws IOException
  {
    o(paramInt & 0xFF);
    o(paramInt >> 8 & 0xFF);
    o(paramInt >> 16 & 0xFF);
    o(paramInt >>> 24);
  }
  
  public final void a(double paramDouble)
    throws IOException
  {
    l(Double.doubleToLongBits(paramDouble));
  }
  
  public final void a(float paramFloat)
    throws IOException
  {
    p(Float.floatToIntBits(paramFloat));
  }
  
  public final void a(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      l(paramInt);
      return;
    }
    k(paramInt);
  }
  
  public final void a(int paramInt1, int paramInt2)
    throws IOException
  {
    e(paramInt1, 0);
    a(paramInt2);
  }
  
  public final void a(int paramInt, String paramString)
    throws IOException
  {
    e(paramInt, 2);
    a(paramString);
  }
  
  public final void a(int paramInt, boolean paramBoolean)
    throws IOException
  {
    e(paramInt, 0);
    a(paramBoolean);
  }
  
  public final void a(long paramLong)
    throws IOException
  {
    k(paramLong);
  }
  
  public final void a(b paramb)
    throws IOException
  {
    paramb = paramb.b();
    l(paramb.length);
    b(paramb);
  }
  
  public final void a(g paramg)
    throws IOException
  {
    l(paramg.c());
    paramg.a(this);
  }
  
  public final void a(String paramString)
    throws IOException
  {
    paramString = paramString.getBytes("UTF-8");
    l(paramString.length);
    b(paramString);
  }
  
  public final void a(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      o(i);
      return;
    }
  }
  
  public final void b(int paramInt)
    throws IOException
  {
    p(paramInt);
  }
  
  public final void b(int paramInt1, int paramInt2)
    throws IOException
  {
    e(paramInt1, 0);
    l(paramInt2);
  }
  
  public final void b(long paramLong)
    throws IOException
  {
    k(paramLong);
  }
  
  public final void c(int paramInt)
    throws IOException
  {
    l(paramInt);
  }
  
  public final void c(long paramLong)
    throws IOException
  {
    l(paramLong);
  }
  
  public final void d(int paramInt)
    throws IOException
  {
    l(paramInt);
  }
  
  public final void d(long paramLong)
    throws IOException
  {
    l(paramLong);
  }
  
  public final void e(int paramInt)
    throws IOException
  {
    p(paramInt);
  }
  
  public final void e(int paramInt1, int paramInt2)
    throws IOException
  {
    l(paramInt1 << 3 | paramInt2);
  }
  
  public final void e(long paramLong)
    throws IOException
  {
    k(j(paramLong));
  }
  
  public final void f(int paramInt)
    throws IOException
  {
    l(n(paramInt));
  }
  
  public final void h()
    throws IOException
  {
    if (this.d != null) {
      i();
    }
  }
  
  public final void l(int paramInt)
    throws IOException
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        o(paramInt);
        return;
      }
      o(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public static final class a
    extends IOException
  {
    a()
    {
      super();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */