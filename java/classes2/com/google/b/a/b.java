package com.google.b.a;

import java.io.InputStream;
import java.util.Vector;

public final class b
{
  private final byte[] a;
  private int b;
  private int c;
  private int d;
  private final InputStream e;
  private int f;
  private int g;
  private int h = Integer.MAX_VALUE;
  private int i;
  private int j = 64;
  private int k = 67108864;
  
  private b(InputStream paramInputStream)
  {
    this.a = new byte['က'];
    this.b = 0;
    this.d = 0;
    this.e = paramInputStream;
  }
  
  private b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.b = (paramInt1 + paramInt2);
    this.d = paramInt1;
    this.e = null;
  }
  
  public static b a(InputStream paramInputStream)
  {
    return new b(paramInputStream);
  }
  
  public static b a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new b(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (this.d < this.b) {
      throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }
    if (this.g + this.b == this.h)
    {
      if (paramBoolean) {
        throw d.a();
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
        throw d.a();
      }
      return false;
    }
    p();
    m = this.g + this.b + this.c;
    if ((m > this.k) || (m < 0)) {
      throw d.h();
    }
    return true;
  }
  
  private void p()
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
  
  public int a()
  {
    if (n())
    {
      this.f = 0;
      return 0;
    }
    this.f = j();
    if (this.f == 0) {
      throw d.d();
    }
    return this.f;
  }
  
  public void a(int paramInt)
  {
    if (this.f != paramInt) {
      throw d.e();
    }
  }
  
  public void a(e parame)
  {
    int m = j();
    if (this.i >= this.j) {
      throw d.g();
    }
    m = c(m);
    this.i += 1;
    parame.a(this);
    a(0);
    this.i -= 1;
    d(m);
  }
  
  public void b()
  {
    int m;
    do
    {
      m = a();
    } while ((m != 0) && (b(m)));
  }
  
  public boolean b(int paramInt)
  {
    switch (f.a(paramInt))
    {
    default: 
      throw d.f();
    case 0: 
      e();
      return true;
    case 1: 
      m();
      return true;
    case 2: 
      f(j());
      return true;
    case 3: 
      b();
      a(f.a(f.b(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    l();
    return true;
  }
  
  public int c(int paramInt)
  {
    if (paramInt < 0) {
      throw d.b();
    }
    paramInt = this.g + this.d + paramInt;
    int m = this.h;
    if (paramInt > m) {
      throw d.a();
    }
    this.h = paramInt;
    p();
    return m;
  }
  
  public long c()
  {
    return k();
  }
  
  public long d()
  {
    return k();
  }
  
  public void d(int paramInt)
  {
    this.h = paramInt;
    p();
  }
  
  public int e()
  {
    return j();
  }
  
  public byte[] e(int paramInt)
  {
    if (paramInt < 0) {
      throw d.b();
    }
    if (this.g + this.d + paramInt > this.h)
    {
      f(this.h - this.g - this.d);
      throw d.a();
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
          throw d.a();
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
  
  public void f(int paramInt)
  {
    if (paramInt < 0) {
      throw d.b();
    }
    if (this.g + this.d + paramInt > this.h)
    {
      f(this.h - this.g - this.d);
      throw d.a();
    }
    if (paramInt <= this.b - this.d) {
      this.d += paramInt;
    }
    for (;;)
    {
      return;
      int m = this.b;
      int n = this.d;
      this.g += this.b;
      this.d = 0;
      this.b = 0;
      m -= n;
      while (m < paramInt)
      {
        if (this.e == null) {}
        for (n = -1; n <= 0; n = (int)this.e.skip(paramInt - m)) {
          throw d.a();
        }
        m += n;
        this.g = (n + this.g);
      }
    }
  }
  
  public boolean f()
  {
    return j() != 0;
  }
  
  public String g()
  {
    int m = j();
    if ((m <= this.b - this.d) && (m > 0))
    {
      String str = new String(this.a, this.d, m, "UTF-8");
      this.d = (m + this.d);
      return str;
    }
    return new String(e(m), "UTF-8");
  }
  
  public a h()
  {
    int m = j();
    if ((m <= this.b - this.d) && (m > 0))
    {
      a locala = a.a(this.a, this.d, m);
      this.d = (m + this.d);
      return locala;
    }
    return a.a(e(m));
  }
  
  public int i()
  {
    return j();
  }
  
  public int j()
  {
    int m = o();
    if (m >= 0) {}
    int i1;
    do
    {
      return m;
      m &= 0x7F;
      n = o();
      if (n >= 0) {
        return m | n << 7;
      }
      m |= (n & 0x7F) << 7;
      n = o();
      if (n >= 0) {
        return m | n << 14;
      }
      m |= (n & 0x7F) << 14;
      i1 = o();
      if (i1 >= 0) {
        return m | i1 << 21;
      }
      n = o();
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
      if (o() >= 0) {
        break;
      }
      n += 1;
    }
    label133:
    throw d.c();
  }
  
  public long k()
  {
    int m = 0;
    long l = 0L;
    while (m < 64)
    {
      int n = o();
      l |= (n & 0x7F) << m;
      if ((n & 0x80) == 0) {
        return l;
      }
      m += 7;
    }
    throw d.c();
  }
  
  public int l()
  {
    return o() & 0xFF | (o() & 0xFF) << 8 | (o() & 0xFF) << 16 | (o() & 0xFF) << 24;
  }
  
  public long m()
  {
    int m = o();
    int n = o();
    int i1 = o();
    int i2 = o();
    int i3 = o();
    int i4 = o();
    int i5 = o();
    int i6 = o();
    long l = m;
    return (n & 0xFF) << 8 | l & 0xFF | (i1 & 0xFF) << 16 | (i2 & 0xFF) << 24 | (i3 & 0xFF) << 32 | (i4 & 0xFF) << 40 | (i5 & 0xFF) << 48 | (i6 & 0xFF) << 56;
  }
  
  public boolean n()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.d == this.b)
    {
      bool1 = bool2;
      if (!a(false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public byte o()
  {
    if (this.d == this.b) {
      a(true);
    }
    byte[] arrayOfByte = this.a;
    int m = this.d;
    this.d = (m + 1);
    return arrayOfByte[m];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */