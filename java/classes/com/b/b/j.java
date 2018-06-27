package com.b.b;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public abstract class j
{
  private boolean a = true;
  
  protected abstract byte a(int paramInt)
    throws IOException;
  
  protected abstract void a(int paramInt1, int paramInt2)
    throws IOException;
  
  protected abstract boolean b(int paramInt1, int paramInt2)
    throws IOException;
  
  public boolean getBit(int paramInt)
    throws IOException
  {
    int i = paramInt / 8;
    a(i, 1);
    return (a(i) >> paramInt % 8 & 0x1) == 1;
  }
  
  public abstract byte[] getBytes(int paramInt1, int paramInt2)
    throws IOException;
  
  public double getDouble64(int paramInt)
    throws IOException
  {
    return Double.longBitsToDouble(getInt64(paramInt));
  }
  
  public float getFloat32(int paramInt)
    throws IOException
  {
    return Float.intBitsToFloat(getInt32(paramInt));
  }
  
  public short getInt16(int paramInt)
    throws IOException
  {
    a(paramInt, 2);
    if (this.a) {
      return (short)((short)a(paramInt) << 8 & 0xFF00 | (short)a(paramInt + 1) & 0xFF);
    }
    return (short)((short)a(paramInt + 1) << 8 & 0xFF00 | (short)a(paramInt) & 0xFF);
  }
  
  public int getInt24(int paramInt)
    throws IOException
  {
    a(paramInt, 3);
    if (this.a) {
      return a(paramInt) << 16 & 0xFF0000 | a(paramInt + 1) << 8 & 0xFF00 | a(paramInt + 2) & 0xFF;
    }
    return a(paramInt + 2) << 16 & 0xFF0000 | a(paramInt + 1) << 8 & 0xFF00 | a(paramInt) & 0xFF;
  }
  
  public int getInt32(int paramInt)
    throws IOException
  {
    a(paramInt, 4);
    if (this.a) {
      return a(paramInt) << 24 & 0xFF000000 | a(paramInt + 1) << 16 & 0xFF0000 | a(paramInt + 2) << 8 & 0xFF00 | a(paramInt + 3) & 0xFF;
    }
    return a(paramInt + 3) << 24 & 0xFF000000 | a(paramInt + 2) << 16 & 0xFF0000 | a(paramInt + 1) << 8 & 0xFF00 | a(paramInt) & 0xFF;
  }
  
  public long getInt64(int paramInt)
    throws IOException
  {
    a(paramInt, 8);
    if (this.a) {
      return a(paramInt) << 56 & 0xFF00000000000000 | a(paramInt + 1) << 48 & 0xFF000000000000 | a(paramInt + 2) << 40 & 0xFF0000000000 | a(paramInt + 3) << 32 & 0xFF00000000 | a(paramInt + 4) << 24 & 0xFF000000 | a(paramInt + 5) << 16 & 0xFF0000 | a(paramInt + 6) << 8 & 0xFF00 | a(paramInt + 7) & 0xFF;
    }
    return a(paramInt + 7) << 56 & 0xFF00000000000000 | a(paramInt + 6) << 48 & 0xFF000000000000 | a(paramInt + 5) << 40 & 0xFF0000000000 | a(paramInt + 4) << 32 & 0xFF00000000 | a(paramInt + 3) << 24 & 0xFF000000 | a(paramInt + 2) << 16 & 0xFF0000 | a(paramInt + 1) << 8 & 0xFF00 | a(paramInt) & 0xFF;
  }
  
  public byte getInt8(int paramInt)
    throws IOException
  {
    a(paramInt, 1);
    return a(paramInt);
  }
  
  public abstract long getLength()
    throws IOException;
  
  public String getNullTerminatedString(int paramInt1, int paramInt2)
    throws IOException
  {
    byte[] arrayOfByte = getBytes(paramInt1, paramInt2);
    paramInt1 = 0;
    while ((paramInt1 < arrayOfByte.length) && (arrayOfByte[paramInt1] != 0)) {
      paramInt1 += 1;
    }
    return new String(arrayOfByte, 0, paramInt1);
  }
  
  public float getS15Fixed16(int paramInt)
    throws IOException
  {
    a(paramInt, 4);
    if (this.a)
    {
      f = (a(paramInt) & 0xFF) << 8 | a(paramInt + 1) & 0xFF;
      i = a(paramInt + 2);
      paramInt = a(paramInt + 3);
      d = f;
      return (float)(((i & 0xFF) << 8 | paramInt & 0xFF) / 65536.0D + d);
    }
    float f = (a(paramInt + 3) & 0xFF) << 8 | a(paramInt + 2) & 0xFF;
    int i = a(paramInt + 1);
    paramInt = a(paramInt);
    double d = f;
    return (float)(((i & 0xFF) << 8 | paramInt & 0xFF) / 65536.0D + d);
  }
  
  public String getString(int paramInt1, int paramInt2)
    throws IOException
  {
    return new String(getBytes(paramInt1, paramInt2));
  }
  
  public String getString(int paramInt1, int paramInt2, String paramString)
    throws IOException
  {
    byte[] arrayOfByte = getBytes(paramInt1, paramInt2);
    try
    {
      paramString = new String(arrayOfByte, paramString);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return new String(arrayOfByte);
  }
  
  public int getUInt16(int paramInt)
    throws IOException
  {
    a(paramInt, 2);
    if (this.a) {
      return a(paramInt) << 8 & 0xFF00 | a(paramInt + 1) & 0xFF;
    }
    return a(paramInt + 1) << 8 & 0xFF00 | a(paramInt) & 0xFF;
  }
  
  public long getUInt32(int paramInt)
    throws IOException
  {
    a(paramInt, 4);
    if (this.a) {
      return a(paramInt) << 24 & 0xFF000000 | a(paramInt + 1) << 16 & 0xFF0000 | a(paramInt + 2) << 8 & 0xFF00 | a(paramInt + 3) & 0xFF;
    }
    return a(paramInt + 3) << 24 & 0xFF000000 | a(paramInt + 2) << 16 & 0xFF0000 | a(paramInt + 1) << 8 & 0xFF00 | a(paramInt) & 0xFF;
  }
  
  public short getUInt8(int paramInt)
    throws IOException
  {
    a(paramInt, 1);
    return (short)(a(paramInt) & 0xFF);
  }
  
  public boolean isMotorolaByteOrder()
  {
    return this.a;
  }
  
  public void setMotorolaByteOrder(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */