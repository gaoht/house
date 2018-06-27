package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class cz
  extends df
{
  private static final dk d = new dk("");
  private static final da e = new da("", (byte)0, (short)0);
  private static final byte[] f = new byte[16];
  private static final byte h = -126;
  private static final byte i = 1;
  private static final byte j = 31;
  private static final byte k = -32;
  private static final int l = 5;
  byte[] a = new byte[5];
  byte[] b = new byte[10];
  byte[] c = new byte[1];
  private ce m = new ce(15);
  private short n = 0;
  private da o = null;
  private Boolean p = null;
  private final long q;
  private byte[] r = new byte[1];
  
  static
  {
    f[0] = 0;
    f[2] = 1;
    f[3] = 3;
    f[6] = 4;
    f[8] = 5;
    f[10] = 6;
    f[4] = 7;
    f[11] = 8;
    f[15] = 9;
    f[14] = 10;
    f[13] = 11;
    f[12] = 12;
  }
  
  public cz(dt paramdt)
  {
    this(paramdt, -1L);
  }
  
  public cz(dt paramdt, long paramLong)
  {
    super(paramdt);
    this.q = paramLong;
  }
  
  private int E()
    throws cm
  {
    int i3 = 0;
    int i1 = 0;
    int i2;
    if (this.g.h() >= 5)
    {
      byte[] arrayOfByte = this.g.f();
      int i4 = this.g.g();
      i2 = 0;
      i3 = 0;
      for (;;)
      {
        int i5 = arrayOfByte[(i4 + i1)];
        i3 |= (i5 & 0x7F) << i2;
        if ((i5 & 0x80) != 128)
        {
          this.g.a(i1 + 1);
          return i3;
        }
        i2 += 7;
        i1 += 1;
      }
      i1 += 7;
    }
    for (;;)
    {
      i3 = u();
      i2 |= (i3 & 0x7F) << i1;
      if ((i3 & 0x80) == 128) {
        break;
      }
      return i2;
      i2 = 0;
      i1 = i3;
    }
  }
  
  private long F()
    throws cm
  {
    int i1 = 0;
    int i3 = 0;
    long l1 = 0L;
    long l2 = l1;
    int i2;
    if (this.g.h() >= 10)
    {
      byte[] arrayOfByte = this.g.f();
      int i4 = this.g.g();
      i2 = 0;
      i1 = i3;
      for (;;)
      {
        i3 = arrayOfByte[(i4 + i1)];
        l1 |= (i3 & 0x7F) << i2;
        if ((i3 & 0x80) != 128)
        {
          this.g.a(i1 + 1);
          return l1;
        }
        i2 += 7;
        i1 += 1;
      }
    }
    do
    {
      i1 += 7;
      i2 = u();
      l2 |= (i2 & 0x7F) << i1;
    } while ((i2 & 0x80) == 128);
    return l2;
  }
  
  private long a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[7] & 0xFF) << 56 | (paramArrayOfByte[6] & 0xFF) << 48 | (paramArrayOfByte[5] & 0xFF) << 40 | (paramArrayOfByte[4] & 0xFF) << 32 | (paramArrayOfByte[3] & 0xFF) << 24 | (paramArrayOfByte[2] & 0xFF) << 16 | (paramArrayOfByte[1] & 0xFF) << 8 | paramArrayOfByte[0] & 0xFF;
  }
  
  private void a(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[(paramInt + 0)] = ((byte)(int)(paramLong & 0xFF));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 8 & 0xFF));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 16 & 0xFF));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)(paramLong >> 24 & 0xFF));
    paramArrayOfByte[(paramInt + 4)] = ((byte)(int)(paramLong >> 32 & 0xFF));
    paramArrayOfByte[(paramInt + 5)] = ((byte)(int)(paramLong >> 40 & 0xFF));
    paramArrayOfByte[(paramInt + 6)] = ((byte)(int)(paramLong >> 48 & 0xFF));
    paramArrayOfByte[(paramInt + 7)] = ((byte)(int)(paramLong >> 56 & 0xFF));
  }
  
  private void a(da paramda, byte paramByte)
    throws cm
  {
    int i1 = paramByte;
    if (paramByte == -1) {
      i1 = e(paramda.b);
    }
    if ((paramda.c > this.n) && (paramda.c - this.n <= 15)) {
      d(paramda.c - this.n << 4 | i1);
    }
    for (;;)
    {
      this.n = paramda.c;
      return;
      b(i1);
      a(paramda.c);
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws cm
  {
    b(paramInt2);
    this.g.b(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private void b(byte paramByte)
    throws cm
  {
    this.r[0] = paramByte;
    this.g.b(this.r);
  }
  
  private void b(int paramInt)
    throws cm
  {
    int i2 = 0;
    int i1 = paramInt;
    paramInt = i2;
    for (;;)
    {
      if ((i1 & 0xFFFFFF80) == 0)
      {
        this.a[paramInt] = ((byte)i1);
        this.g.b(this.a, 0, paramInt + 1);
        return;
      }
      this.a[paramInt] = ((byte)(i1 & 0x7F | 0x80));
      i1 >>>= 7;
      paramInt += 1;
    }
  }
  
  private void b(long paramLong)
    throws cm
  {
    int i1 = 0;
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        this.b[i1] = ((byte)(int)paramLong);
        this.g.b(this.b, 0, i1 + 1);
        return;
      }
      this.b[i1] = ((byte)(int)(0x7F & paramLong | 0x80));
      paramLong >>>= 7;
      i1 += 1;
    }
  }
  
  private int c(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  private long c(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  private boolean c(byte paramByte)
  {
    paramByte &= 0xF;
    return (paramByte == 1) || (paramByte == 2);
  }
  
  private byte d(byte paramByte)
    throws dg
  {
    switch ((byte)(paramByte & 0xF))
    {
    default: 
      throw new dg("don't know what type: " + (byte)(paramByte & 0xF));
    case 0: 
      return 0;
    case 1: 
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 6;
    case 5: 
      return 8;
    case 6: 
      return 10;
    case 7: 
      return 4;
    case 8: 
      return 11;
    case 9: 
      return 15;
    case 10: 
      return 14;
    case 11: 
      return 13;
    }
    return 12;
  }
  
  private long d(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  private void d(int paramInt)
    throws cm
  {
    b((byte)paramInt);
  }
  
  private byte e(byte paramByte)
  {
    return f[paramByte];
  }
  
  private byte[] e(int paramInt)
    throws cm
  {
    if (paramInt == 0) {
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[paramInt];
    this.g.d(arrayOfByte, 0, paramInt);
    return arrayOfByte;
  }
  
  private void f(int paramInt)
    throws dg
  {
    if (paramInt < 0) {
      throw new dg("Negative length: " + paramInt);
    }
    if ((this.q != -1L) && (paramInt > this.q)) {
      throw new dg("Length exceeded max allowed: " + paramInt);
    }
  }
  
  private int g(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  public ByteBuffer A()
    throws cm
  {
    int i1 = E();
    f(i1);
    if (i1 == 0) {
      return ByteBuffer.wrap(new byte[0]);
    }
    byte[] arrayOfByte = new byte[i1];
    this.g.d(arrayOfByte, 0, i1);
    return ByteBuffer.wrap(arrayOfByte);
  }
  
  public void B()
  {
    this.m.c();
    this.n = 0;
  }
  
  public void a()
    throws cm
  {}
  
  public void a(byte paramByte)
    throws cm
  {
    b(paramByte);
  }
  
  protected void a(byte paramByte, int paramInt)
    throws cm
  {
    if (paramInt <= 14)
    {
      d(paramInt << 4 | e(paramByte));
      return;
    }
    d(e(paramByte) | 0xF0);
    b(paramInt);
  }
  
  public void a(double paramDouble)
    throws cm
  {
    byte[] arrayOfByte = new byte[8];
    byte[] tmp6_5 = arrayOfByte;
    tmp6_5[0] = 0;
    byte[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 0;
    byte[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 0;
    byte[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 0;
    byte[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 0;
    byte[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 0;
    byte[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 0;
    byte[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 0;
    tmp42_36;
    a(Double.doubleToLongBits(paramDouble), tmp6_5, 0);
    this.g.b(tmp6_5);
  }
  
  public void a(int paramInt)
    throws cm
  {
    b(c(paramInt));
  }
  
  public void a(long paramLong)
    throws cm
  {
    b(c(paramLong));
  }
  
  public void a(da paramda)
    throws cm
  {
    if (paramda.b == 2)
    {
      this.o = paramda;
      return;
    }
    a(paramda, (byte)-1);
  }
  
  public void a(db paramdb)
    throws cm
  {
    a(paramdb.a, paramdb.b);
  }
  
  public void a(dc paramdc)
    throws cm
  {
    if (paramdc.c == 0)
    {
      d(0);
      return;
    }
    b(paramdc.c);
    d(e(paramdc.a) << 4 | e(paramdc.b));
  }
  
  public void a(dd paramdd)
    throws cm
  {
    b((byte)-126);
    d(paramdd.b << 5 & 0xFFFFFFE0 | 0x1);
    b(paramdd.c);
    a(paramdd.a);
  }
  
  public void a(dj paramdj)
    throws cm
  {
    a(paramdj.a, paramdj.b);
  }
  
  public void a(dk paramdk)
    throws cm
  {
    this.m.a(this.n);
    this.n = 0;
  }
  
  public void a(String paramString)
    throws cm
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      a(paramString, 0, paramString.length);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new cm("UTF-8 not supported!");
    }
  }
  
  public void a(ByteBuffer paramByteBuffer)
    throws cm
  {
    int i1 = paramByteBuffer.limit();
    int i2 = paramByteBuffer.position();
    a(paramByteBuffer.array(), paramByteBuffer.position() + paramByteBuffer.arrayOffset(), i1 - i2);
  }
  
  public void a(short paramShort)
    throws cm
  {
    b(c(paramShort));
  }
  
  public void a(boolean paramBoolean)
    throws cm
  {
    byte b2 = 1;
    byte b1 = 1;
    if (this.o != null)
    {
      da localda = this.o;
      if (paramBoolean) {}
      for (;;)
      {
        a(localda, b1);
        this.o = null;
        return;
        b1 = 2;
      }
    }
    if (paramBoolean) {}
    for (b1 = b2;; b1 = 2)
    {
      b(b1);
      return;
    }
  }
  
  public void b()
    throws cm
  {
    this.n = this.m.a();
  }
  
  public void c()
    throws cm
  {}
  
  public void d()
    throws cm
  {
    b((byte)0);
  }
  
  public void e()
    throws cm
  {}
  
  public void f()
    throws cm
  {}
  
  public void g()
    throws cm
  {}
  
  public dd h()
    throws cm
  {
    int i1 = u();
    if (i1 != -126) {
      throw new dg("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(i1));
    }
    i1 = u();
    int i2 = (byte)(i1 & 0x1F);
    if (i2 != 1) {
      throw new dg("Expected version 1 but got " + i2);
    }
    byte b1 = (byte)(i1 >> 5 & 0x3);
    i1 = E();
    return new dd(z(), b1, i1);
  }
  
  public void i()
    throws cm
  {}
  
  public dk j()
    throws cm
  {
    this.m.a(this.n);
    this.n = 0;
    return d;
  }
  
  public void k()
    throws cm
  {
    this.n = this.m.a();
  }
  
  public da l()
    throws cm
  {
    int i1 = u();
    if (i1 == 0) {
      return e;
    }
    int i2 = (short)((i1 & 0xF0) >> 4);
    short s;
    da localda;
    if (i2 == 0)
    {
      s = v();
      localda = new da("", d((byte)(i1 & 0xF)), s);
      if (c(i1)) {
        if ((byte)(i1 & 0xF) != 1) {
          break label103;
        }
      }
    }
    label103:
    for (Boolean localBoolean = Boolean.TRUE;; localBoolean = Boolean.FALSE)
    {
      this.p = localBoolean;
      this.n = localda.c;
      return localda;
      s = (short)(i2 + this.n);
      break;
    }
  }
  
  public void m()
    throws cm
  {}
  
  public dc n()
    throws cm
  {
    int i2 = E();
    if (i2 == 0) {}
    for (int i1 = 0;; i1 = u()) {
      return new dc(d((byte)(i1 >> 4)), d((byte)(i1 & 0xF)), i2);
    }
  }
  
  public void o()
    throws cm
  {}
  
  public db p()
    throws cm
  {
    byte b1 = u();
    int i2 = b1 >> 4 & 0xF;
    int i1 = i2;
    if (i2 == 15) {
      i1 = E();
    }
    return new db(d(b1), i1);
  }
  
  public void q()
    throws cm
  {}
  
  public dj r()
    throws cm
  {
    return new dj(p());
  }
  
  public void s()
    throws cm
  {}
  
  public boolean t()
    throws cm
  {
    boolean bool = true;
    if (this.p != null)
    {
      bool = this.p.booleanValue();
      this.p = null;
    }
    while (u() == 1) {
      return bool;
    }
    return false;
  }
  
  public byte u()
    throws cm
  {
    if (this.g.h() > 0)
    {
      byte b1 = this.g.f()[this.g.g()];
      this.g.a(1);
      return b1;
    }
    this.g.d(this.c, 0, 1);
    return this.c[0];
  }
  
  public short v()
    throws cm
  {
    return (short)g(E());
  }
  
  public int w()
    throws cm
  {
    return g(E());
  }
  
  public long x()
    throws cm
  {
    return d(F());
  }
  
  public double y()
    throws cm
  {
    byte[] arrayOfByte = new byte[8];
    this.g.d(arrayOfByte, 0, 8);
    return Double.longBitsToDouble(a(arrayOfByte));
  }
  
  public String z()
    throws cm
  {
    int i1 = E();
    f(i1);
    if (i1 == 0) {
      return "";
    }
    try
    {
      if (this.g.h() >= i1)
      {
        String str1 = new String(this.g.f(), this.g.g(), i1, "UTF-8");
        this.g.a(i1);
        return str1;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new cm("UTF-8 not supported!");
    }
    String str2 = new String(e(i1), "UTF-8");
    return str2;
  }
  
  public static class a
    implements dh
  {
    private final long a;
    
    public a()
    {
      this.a = -1L;
    }
    
    public a(int paramInt)
    {
      this.a = paramInt;
    }
    
    public df a(dt paramdt)
    {
      return new cz(paramdt, this.a);
    }
  }
  
  private static class b
  {
    public static final byte a = 1;
    public static final byte b = 2;
    public static final byte c = 3;
    public static final byte d = 4;
    public static final byte e = 5;
    public static final byte f = 6;
    public static final byte g = 7;
    public static final byte h = 8;
    public static final byte i = 9;
    public static final byte j = 10;
    public static final byte k = 11;
    public static final byte l = 12;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */