package com.google.a;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

public class c
{
  private final byte[] a;
  private int b;
  private int c;
  private int d;
  private final InputStream e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  private c() {}
  
  private c(InputStream paramInputStream)
  {
    this.h = Integer.MAX_VALUE;
    this.j = 64;
    this.k = 67108864;
    this.a = new byte['က'];
    this.b = 0;
    this.d = 0;
    this.g = 0;
    this.e = paramInputStream;
  }
  
  private c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.h = Integer.MAX_VALUE;
    this.j = 64;
    this.k = 67108864;
    this.a = paramArrayOfByte;
    this.b = (paramInt1 + paramInt2);
    this.d = paramInt1;
    this.g = (-paramInt1);
    this.e = null;
  }
  
  public static c a(InputStream paramInputStream)
  {
    return new c(paramInputStream);
  }
  
  public static c a(byte[] paramArrayOfByte)
  {
    return new c(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static c a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new c(paramArrayOfByte, 0, paramInt2);
  }
  
  private boolean a(boolean paramBoolean)
    throws IOException
  {
    if (this.d < this.b) {
      throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }
    if (this.g + this.b == this.h)
    {
      if (paramBoolean) {
        throw new IOException("Truncated message.");
      }
      return false;
    }
    this.g += this.b;
    this.d = 0;
    if (this.e == null) {}
    for (int m = -1;; m = this.e.read(this.a))
    {
      this.b = m;
      if ((this.b != 0) && (this.b >= -1)) {
        break;
      }
      throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.b + "\nThe InputStream implementation is buggy.");
    }
    if (this.b == -1)
    {
      this.b = 0;
      if (paramBoolean) {
        throw new IOException("Truncated message.");
      }
      return false;
    }
    w();
    m = this.g + this.b + this.c;
    if ((m > this.k) || (m < 0)) {
      throw new IOException("Size limit exceeded.");
    }
    return true;
  }
  
  private void d(int paramInt)
    throws IOException
  {
    if (this.f != paramInt) {
      throw new IOException("Invalid end tag.");
    }
  }
  
  public static int e(int paramInt)
  {
    return paramInt >>> 3;
  }
  
  private byte[] f(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw new IOException("Negative size.");
    }
    if (this.g + this.d + paramInt > this.h)
    {
      g(this.h - this.g - this.d);
      throw new IOException("Truncated message.");
    }
    if (paramInt <= this.b - this.d)
    {
      localObject = new byte[paramInt];
      System.arraycopy(this.a, this.d, localObject, 0, paramInt);
      this.d += paramInt;
      return (byte[])localObject;
    }
    if (paramInt < 4096)
    {
      localObject = new byte[paramInt];
      m = this.b - this.d;
      System.arraycopy(this.a, this.d, localObject, 0, m);
      this.d = this.b;
      a(true);
      while (paramInt - m > this.b)
      {
        System.arraycopy(this.a, 0, localObject, m, this.b);
        m += this.b;
        this.d = this.b;
        a(true);
      }
      System.arraycopy(this.a, 0, localObject, m, paramInt - m);
      this.d = (paramInt - m);
      return (byte[])localObject;
    }
    int i2 = this.d;
    int i3 = this.b;
    this.g += this.b;
    this.d = 0;
    this.b = 0;
    Object localObject = new Vector();
    int m = paramInt - (i3 - i2);
    while (m > 0)
    {
      arrayOfByte1 = new byte[Math.min(m, 4096)];
      int n = 0;
      while (n < arrayOfByte1.length)
      {
        if (this.e == null) {}
        for (int i1 = -1; i1 == -1; i1 = this.e.read(arrayOfByte1, n, arrayOfByte1.length - n)) {
          throw new IOException("Truncated message.");
        }
        this.g += i1;
        n += i1;
      }
      n = arrayOfByte1.length;
      ((Vector)localObject).addElement(arrayOfByte1);
      m -= n;
    }
    byte[] arrayOfByte1 = new byte[paramInt];
    m = i3 - i2;
    System.arraycopy(this.a, i2, arrayOfByte1, 0, m);
    paramInt = 0;
    while (paramInt < ((Vector)localObject).size())
    {
      byte[] arrayOfByte2 = (byte[])((Vector)localObject).elementAt(paramInt);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, m, arrayOfByte2.length);
      m += arrayOfByte2.length;
      paramInt += 1;
    }
    return arrayOfByte1;
  }
  
  private void g(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw new IOException("Negative size.");
    }
    if (this.g + this.d + paramInt > this.h)
    {
      g(this.h - this.g - this.d);
      throw new IOException("Truncated message.");
    }
    if (paramInt <= this.b - this.d) {
      this.d += paramInt;
    }
    for (;;)
    {
      return;
      int m = this.b - this.d;
      this.g += m;
      this.d = 0;
      this.b = 0;
      while (m < paramInt)
      {
        if (this.e == null) {}
        for (int n = -1; n <= 0; n = (int)this.e.skip(paramInt - m)) {
          throw new IOException("Truncated message.");
        }
        m += n;
        this.g = (n + this.g);
      }
    }
  }
  
  private long v()
    throws IOException
  {
    int m = 0;
    long l = 0L;
    while (m < 64)
    {
      int n = x();
      l |= (n & 0x7F) << m;
      if ((n & 0x80) == 0) {
        return l;
      }
      m += 7;
    }
    throw new IOException("malformed varint.");
  }
  
  private void w()
  {
    this.b += this.c;
    int m = this.g + this.b;
    if (m > this.h)
    {
      this.c = (m - this.h);
      this.b -= this.c;
      return;
    }
    this.c = 0;
  }
  
  private byte x()
    throws IOException
  {
    if (this.d == this.b) {
      a(true);
    }
    byte[] arrayOfByte = this.a;
    int m = this.d;
    this.d = (m + 1);
    return arrayOfByte[m];
  }
  
  public final int a()
    throws IOException
  {
    if ((this.d == this.b) && (!a(false))) {}
    for (int m = 1; m != 0; m = 0)
    {
      this.f = 0;
      return 0;
    }
    this.f = r();
    if (this.f >>> 3 == 0) {
      throw new IOException("Invalid tag.");
    }
    return this.f;
  }
  
  public final void a(g paramg)
    throws IOException
  {
    int m = r();
    if (this.i >= this.j) {
      throw new IOException("Recursion limit exceeded.");
    }
    m = b(m);
    this.i += 1;
    paramg.a(this);
    d(0);
    this.i -= 1;
    c(m);
  }
  
  public final boolean a(int paramInt)
    throws IOException
  {
    switch (paramInt & 0x7)
    {
    default: 
      throw new IOException("Invalid wire type: " + (paramInt & 0x7));
    case 0: 
      r();
      return true;
    case 1: 
      t();
      return true;
    case 2: 
      g(r());
      return true;
    case 3: 
      int m;
      do
      {
        m = a();
      } while ((m != 0) && (a(m)));
      d(paramInt >>> 3 << 3 | 0x4);
      return true;
    case 4: 
      return false;
    }
    s();
    return true;
  }
  
  public final double b()
    throws IOException
  {
    return Double.longBitsToDouble(t());
  }
  
  public final int b(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw new IOException("Negative size.");
    }
    paramInt = this.g + this.d + paramInt;
    int m = this.h;
    if (paramInt > m) {
      throw new IOException("Truncated message.");
    }
    this.h = paramInt;
    w();
    return m;
  }
  
  public final float c()
    throws IOException
  {
    return Float.intBitsToFloat(s());
  }
  
  public final void c(int paramInt)
  {
    this.h = paramInt;
    w();
  }
  
  public final long d()
    throws IOException
  {
    return v();
  }
  
  public final long e()
    throws IOException
  {
    return v();
  }
  
  public final int f()
    throws IOException
  {
    return r();
  }
  
  public final long g()
    throws IOException
  {
    return t();
  }
  
  public final int h()
    throws IOException
  {
    return s();
  }
  
  public final boolean i()
    throws IOException
  {
    return r() != 0;
  }
  
  public final String j()
    throws IOException
  {
    int m = r();
    if ((m <= this.b - this.d) && (m > 0))
    {
      String str = new String(this.a, this.d, m, "UTF-8");
      this.d = (m + this.d);
      return str;
    }
    return new String(f(m), "UTF-8");
  }
  
  public final b k()
    throws IOException
  {
    int m = r();
    if ((m <= this.b - this.d) && (m > 0))
    {
      b localb = b.a(this.a, this.d, m);
      this.d = (m + this.d);
      return localb;
    }
    return b.a(f(m));
  }
  
  public final int l()
    throws IOException
  {
    return r();
  }
  
  public final int m()
    throws IOException
  {
    return r();
  }
  
  public final int n()
    throws IOException
  {
    return s();
  }
  
  public final long o()
    throws IOException
  {
    return t();
  }
  
  public final int p()
    throws IOException
  {
    int m = r();
    return -(m & 0x1) ^ m >>> 1;
  }
  
  public final long q()
    throws IOException
  {
    long l = v();
    return -(l & 1L) ^ l >>> 1;
  }
  
  public final int r()
    throws IOException
  {
    int m = x();
    if (m >= 0) {}
    int i1;
    do
    {
      return m;
      m &= 0x7F;
      n = x();
      if (n >= 0) {
        return m | n << 7;
      }
      m |= (n & 0x7F) << 7;
      n = x();
      if (n >= 0) {
        return m | n << 14;
      }
      m |= (n & 0x7F) << 14;
      i1 = x();
      if (i1 >= 0) {
        return m | i1 << 21;
      }
      n = x();
      i1 = m | (i1 & 0x7F) << 21 | n << 28;
      m = i1;
    } while (n >= 0);
    int n = 0;
    for (;;)
    {
      if (n >= 5) {
        break label133;
      }
      m = i1;
      if (x() >= 0) {
        break;
      }
      n += 1;
    }
    label133:
    throw new IOException("malformed varint.");
  }
  
  public final int s()
    throws IOException
  {
    return x() & 0xFF | (x() & 0xFF) << 8 | (x() & 0xFF) << 16 | (x() & 0xFF) << 24;
  }
  
  public final long t()
    throws IOException
  {
    int m = x();
    int n = x();
    int i1 = x();
    int i2 = x();
    int i3 = x();
    int i4 = x();
    int i5 = x();
    int i6 = x();
    long l = m;
    return (n & 0xFF) << 8 | l & 0xFF | (i1 & 0xFF) << 16 | (i2 & 0xFF) << 24 | (i3 & 0xFF) << 32 | (i4 & 0xFF) << 40 | (i5 & 0xFF) << 48 | (i6 & 0xFF) << 56;
  }
  
  public final int u()
  {
    if (this.h == Integer.MAX_VALUE) {
      return -1;
    }
    int m = this.g;
    int n = this.d;
    return this.h - (m + n);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */