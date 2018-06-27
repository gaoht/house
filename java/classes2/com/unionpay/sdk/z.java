package com.unionpay.sdk;

import java.io.OutputStream;

final class z
{
  protected byte[] a = new byte[9];
  protected OutputStream b;
  
  z(OutputStream paramOutputStream)
  {
    this.b = paramOutputStream;
  }
  
  static int b(long paramLong)
  {
    if (paramLong < -32L) {
      if (paramLong < -32768L) {
        if (paramLong >= -2147483648L) {}
      }
    }
    do
    {
      return 9;
      return 5;
      if (paramLong < -128L) {
        return 3;
      }
      return 2;
      if (paramLong < 128L) {
        return 1;
      }
      if (paramLong < 65536L)
      {
        if (paramLong < 256L) {
          return 2;
        }
        return 3;
      }
    } while (paramLong >= 4294967296L);
    return 5;
  }
  
  static int b(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = c(paramString.length);
      int j = paramString.length;
      return j + i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  static int c(int paramInt)
  {
    if (paramInt < 16) {
      return 1;
    }
    if (paramInt < 65536) {
      return 3;
    }
    return 5;
  }
  
  private z c(String paramString)
  {
    paramString = paramString.getBytes("UTF-8");
    e(paramString.length);
    return a(paramString);
  }
  
  final z a()
  {
    this.b.write(-64);
    return this;
  }
  
  final z a(double paramDouble)
  {
    this.a[0] = -53;
    long l = Double.doubleToRawLongBits(paramDouble);
    this.a[1] = ((byte)(int)(l >> 56));
    this.a[2] = ((byte)(int)(l >> 48));
    this.a[3] = ((byte)(int)(l >> 40));
    this.a[4] = ((byte)(int)(l >> 32));
    this.a[5] = ((byte)(int)(l >> 24));
    this.a[6] = ((byte)(int)(l >> 16));
    this.a[7] = ((byte)(int)(l >> 8));
    this.a[8] = ((byte)(int)(l >> 0));
    this.b.write(this.a, 0, 9);
    return this;
  }
  
  final z a(float paramFloat)
  {
    this.a[0] = -54;
    int i = Float.floatToRawIntBits(paramFloat);
    this.a[1] = ((byte)(i >> 24));
    this.a[2] = ((byte)(i >> 16));
    this.a[3] = ((byte)(i >> 8));
    this.a[4] = ((byte)(i >> 0));
    this.b.write(this.a, 0, 5);
    return this;
  }
  
  final z a(int paramInt)
  {
    if (paramInt < -32)
    {
      if (paramInt < 32768)
      {
        this.a[0] = -46;
        this.a[1] = ((byte)(paramInt >> 24));
        this.a[2] = ((byte)(paramInt >> 16));
        this.a[3] = ((byte)(paramInt >> 8));
        this.a[4] = ((byte)(paramInt >> 0));
        this.b.write(this.a, 0, 5);
        return this;
      }
      if (paramInt < -128)
      {
        this.a[0] = -47;
        this.a[1] = ((byte)(paramInt >> 8));
        this.a[2] = ((byte)(paramInt >> 0));
        this.b.write(this.a, 0, 3);
        return this;
      }
      this.a[0] = -48;
      this.a[1] = ((byte)paramInt);
      this.b.write(this.a, 0, 2);
      return this;
    }
    if (paramInt < 128)
    {
      this.b.write((byte)paramInt);
      return this;
    }
    if (paramInt < 256)
    {
      this.a[0] = -52;
      this.a[1] = ((byte)paramInt);
      this.b.write(this.a, 0, 2);
      return this;
    }
    if (paramInt < 65536)
    {
      this.a[0] = -51;
      this.a[1] = ((byte)(paramInt >> 8));
      this.a[2] = ((byte)(paramInt >> 0));
      this.b.write(this.a, 0, 3);
      return this;
    }
    this.a[0] = -50;
    this.a[1] = ((byte)(paramInt >> 24));
    this.a[2] = ((byte)(paramInt >> 16));
    this.a[3] = ((byte)(paramInt >> 8));
    this.a[4] = ((byte)(paramInt >> 0));
    this.b.write(this.a, 0, 5);
    return this;
  }
  
  final z a(long paramLong)
  {
    if (paramLong < -32L)
    {
      if (paramLong < -32768L)
      {
        if (paramLong < -2147483648L)
        {
          this.a[0] = -45;
          this.a[1] = ((byte)(int)(paramLong >> 56));
          this.a[2] = ((byte)(int)(paramLong >> 48));
          this.a[3] = ((byte)(int)(paramLong >> 40));
          this.a[4] = ((byte)(int)(paramLong >> 32));
          this.a[5] = ((byte)(int)(paramLong >> 24));
          this.a[6] = ((byte)(int)(paramLong >> 16));
          this.a[7] = ((byte)(int)(paramLong >> 8));
          this.a[8] = ((byte)(int)(paramLong >> 0));
          this.b.write(this.a, 0, 9);
          return this;
        }
        this.a[0] = -46;
        this.a[1] = ((byte)(int)(paramLong >> 24));
        this.a[2] = ((byte)(int)(paramLong >> 16));
        this.a[3] = ((byte)(int)(paramLong >> 8));
        this.a[4] = ((byte)(int)(paramLong >> 0));
        this.b.write(this.a, 0, 5);
        return this;
      }
      if (paramLong < -128L)
      {
        this.a[0] = -47;
        this.a[1] = ((byte)(int)(paramLong >> 8));
        this.a[2] = ((byte)(int)(paramLong >> 0));
        this.b.write(this.a, 0, 3);
        return this;
      }
      this.a[0] = -48;
      this.a[1] = ((byte)(int)paramLong);
      this.b.write(this.a, 0, 2);
      return this;
    }
    if (paramLong < 128L)
    {
      this.b.write((byte)(int)paramLong);
      return this;
    }
    if (paramLong < 65536L)
    {
      if (paramLong < 256L)
      {
        this.a[0] = -52;
        this.a[1] = ((byte)(int)paramLong);
        this.b.write(this.a, 0, 2);
        return this;
      }
      this.a[0] = -51;
      this.a[1] = ((byte)(int)((0xFF00 & paramLong) >> 8));
      this.a[2] = ((byte)(int)((0xFF & paramLong) >> 0));
      this.b.write(this.a, 0, 3);
      return this;
    }
    if (paramLong < 4294967296L)
    {
      this.a[0] = -50;
      this.a[1] = ((byte)(int)((0xFFFFFFFFFF000000 & paramLong) >> 24));
      this.a[2] = ((byte)(int)((0xFF0000 & paramLong) >> 16));
      this.a[3] = ((byte)(int)((0xFF00 & paramLong) >> 8));
      this.a[4] = ((byte)(int)((0xFF & paramLong) >> 0));
      this.b.write(this.a, 0, 5);
      return this;
    }
    this.a[0] = -49;
    this.a[1] = ((byte)(int)(paramLong >> 56));
    this.a[2] = ((byte)(int)(paramLong >> 48));
    this.a[3] = ((byte)(int)(paramLong >> 40));
    this.a[4] = ((byte)(int)(paramLong >> 32));
    this.a[5] = ((byte)(int)(paramLong >> 24));
    this.a[6] = ((byte)(int)(paramLong >> 16));
    this.a[7] = ((byte)(int)(paramLong >> 8));
    this.a[8] = ((byte)(int)(paramLong >> 0));
    this.b.write(this.a, 0, 9);
    return this;
  }
  
  final z a(x paramx)
  {
    if (paramx == null) {
      return a();
    }
    paramx.messagePack(this);
    return this;
  }
  
  final z a(String paramString)
  {
    if (paramString == null) {
      return c("");
    }
    return c(paramString);
  }
  
  final z a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.write(-61);
      return this;
    }
    this.b.write(-62);
    return this;
  }
  
  final z a(byte[] paramArrayOfByte)
  {
    this.b.write(paramArrayOfByte);
    return this;
  }
  
  final z b(int paramInt)
  {
    if (paramInt < 16)
    {
      this.b.write((byte)(paramInt | 0x90));
      return this;
    }
    if (paramInt < 65536)
    {
      this.a[0] = -36;
      this.a[1] = ((byte)(paramInt >> 8));
      this.a[2] = ((byte)(paramInt >> 0));
      this.b.write(this.a, 0, 3);
      return this;
    }
    this.a[0] = -35;
    this.a[1] = ((byte)(paramInt >> 24));
    this.a[2] = ((byte)(paramInt >> 16));
    this.a[3] = ((byte)(paramInt >> 8));
    this.a[4] = ((byte)(paramInt >> 0));
    this.b.write(this.a, 0, 5);
    return this;
  }
  
  final z d(int paramInt)
  {
    if (paramInt < 16)
    {
      this.b.write((byte)(paramInt | 0x80));
      return this;
    }
    if (paramInt < 65536)
    {
      this.a[0] = -34;
      this.a[1] = ((byte)(paramInt >> 8));
      this.a[2] = ((byte)(paramInt >> 0));
      this.b.write(this.a, 0, 3);
      return this;
    }
    this.a[0] = -33;
    this.a[1] = ((byte)(paramInt >> 24));
    this.a[2] = ((byte)(paramInt >> 16));
    this.a[3] = ((byte)(paramInt >> 8));
    this.a[4] = ((byte)(paramInt >> 0));
    this.b.write(this.a, 0, 5);
    return this;
  }
  
  final z e(int paramInt)
  {
    if (paramInt < 32)
    {
      this.b.write((byte)(paramInt | 0xA0));
      return this;
    }
    if (paramInt < 65536)
    {
      this.a[0] = -38;
      this.a[1] = ((byte)(paramInt >> 8));
      this.a[2] = ((byte)(paramInt >> 0));
      this.b.write(this.a, 0, 3);
      return this;
    }
    this.a[0] = -37;
    this.a[1] = ((byte)(paramInt >> 24));
    this.a[2] = ((byte)(paramInt >> 16));
    this.a[3] = ((byte)(paramInt >> 8));
    this.a[4] = ((byte)(paramInt >> 0));
    this.b.write(this.a, 0, 5);
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */