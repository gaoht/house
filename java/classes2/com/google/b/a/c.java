package com.google.b.a;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class c
{
  private final byte[] a;
  private final int b;
  private int c;
  private final OutputStream d;
  
  private c(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    this.d = paramOutputStream;
    this.a = paramArrayOfByte;
    this.c = 0;
    this.b = paramArrayOfByte.length;
  }
  
  private c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.d = null;
    this.a = paramArrayOfByte;
    this.c = paramInt1;
    this.b = (paramInt1 + paramInt2);
  }
  
  public static c a(OutputStream paramOutputStream)
  {
    return a(paramOutputStream, 4096);
  }
  
  public static c a(OutputStream paramOutputStream, int paramInt)
  {
    return new c(paramOutputStream, new byte[paramInt]);
  }
  
  public static c a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new c(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int b(int paramInt, a parama)
  {
    return f(paramInt) + b(parama);
  }
  
  public static int b(int paramInt, e parame)
  {
    return f(paramInt) + b(parame);
  }
  
  public static int b(int paramInt, String paramString)
  {
    return f(paramInt) + b(paramString);
  }
  
  public static int b(int paramInt, boolean paramBoolean)
  {
    return f(paramInt) + b(paramBoolean);
  }
  
  public static int b(a parama)
  {
    return h(parama.a()) + parama.a();
  }
  
  public static int b(e parame)
  {
    int i = parame.b();
    return i + h(i);
  }
  
  public static int b(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = h(paramString.length);
      int j = paramString.length;
      return j + i;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported.");
    }
  }
  
  public static int b(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int c(int paramInt)
  {
    if (paramInt >= 0) {
      return h(paramInt);
    }
    return 10;
  }
  
  public static int c(int paramInt1, int paramInt2)
  {
    return f(paramInt1) + c(paramInt2);
  }
  
  public static int c(int paramInt, long paramLong)
  {
    return f(paramInt) + c(paramLong);
  }
  
  public static int c(long paramLong)
  {
    return f(paramLong);
  }
  
  public static int d(int paramInt)
  {
    return h(paramInt);
  }
  
  public static int d(int paramInt1, int paramInt2)
  {
    return f(paramInt1) + d(paramInt2);
  }
  
  public static int d(int paramInt, long paramLong)
  {
    return f(paramInt) + d(paramLong);
  }
  
  public static int d(long paramLong)
  {
    return f(paramLong);
  }
  
  private void d()
  {
    if (this.d == null) {
      throw new a();
    }
    this.d.write(this.a, 0, this.c);
    this.c = 0;
  }
  
  public static int f(int paramInt)
  {
    return h(f.a(paramInt, 0));
  }
  
  public static int f(long paramLong)
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
  
  public static int h(int paramInt)
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
  
  public void a()
  {
    if (this.d != null) {
      d();
    }
  }
  
  public void a(byte paramByte)
  {
    if (this.c == this.b) {
      d();
    }
    byte[] arrayOfByte = this.a;
    int i = this.c;
    this.c = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      g(paramInt);
      return;
    }
    e(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    e(paramInt1, 0);
    a(paramInt2);
  }
  
  public void a(int paramInt, long paramLong)
  {
    e(paramInt, 0);
    a(paramLong);
  }
  
  public void a(int paramInt, a parama)
  {
    e(paramInt, 2);
    a(parama);
  }
  
  public void a(int paramInt, e parame)
  {
    e(paramInt, 2);
    a(parame);
  }
  
  public void a(int paramInt, String paramString)
  {
    e(paramInt, 2);
    a(paramString);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    e(paramInt, 0);
    a(paramBoolean);
  }
  
  public void a(long paramLong)
  {
    e(paramLong);
  }
  
  public void a(a parama)
  {
    parama = parama.b();
    g(parama.length);
    a(parama);
  }
  
  public void a(e parame)
  {
    g(parame.a());
    parame.a(this);
  }
  
  public void a(String paramString)
  {
    paramString = paramString.getBytes("UTF-8");
    g(paramString.length);
    a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      e(i);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int b()
  {
    if (this.d == null) {
      return this.b - this.c;
    }
    throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
  }
  
  public void b(int paramInt)
  {
    g(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    e(paramInt1, 0);
    b(paramInt2);
  }
  
  public void b(int paramInt, long paramLong)
  {
    e(paramInt, 0);
    b(paramLong);
  }
  
  public void b(long paramLong)
  {
    e(paramLong);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.b - this.c >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.c, paramInt2);
      this.c += paramInt2;
      return;
    }
    int i = this.b - this.c;
    System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.c, i);
    paramInt1 += i;
    paramInt2 -= i;
    this.c = this.b;
    d();
    if (paramInt2 <= this.b)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.a, 0, paramInt2);
      this.c = paramInt2;
      return;
    }
    this.d.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void c()
  {
    if (b() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  public void e(int paramInt)
  {
    a((byte)paramInt);
  }
  
  public void e(int paramInt1, int paramInt2)
  {
    g(f.a(paramInt1, paramInt2));
  }
  
  public void e(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        e((int)paramLong);
        return;
      }
      e((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public void g(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        e(paramInt);
        return;
      }
      e(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public static class a
    extends IOException
  {
    a()
    {
      super();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */