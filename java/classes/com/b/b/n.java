package com.b.b;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public abstract class n
{
  private boolean a = true;
  
  protected abstract byte a()
    throws IOException;
  
  public abstract byte[] getBytes(int paramInt)
    throws IOException;
  
  public double getDouble64()
    throws IOException
  {
    return Double.longBitsToDouble(getInt64());
  }
  
  public float getFloat32()
    throws IOException
  {
    return Float.intBitsToFloat(getInt32());
  }
  
  public short getInt16()
    throws IOException
  {
    if (this.a) {
      return (short)((short)a() << 8 & 0xFF00 | (short)a() & 0xFF);
    }
    return (short)((short)a() & 0xFF | (short)a() << 8 & 0xFF00);
  }
  
  public int getInt32()
    throws IOException
  {
    if (this.a) {
      return a() << 24 & 0xFF000000 | a() << 16 & 0xFF0000 | a() << 8 & 0xFF00 | a() & 0xFF;
    }
    return a() & 0xFF | a() << 8 & 0xFF00 | a() << 16 & 0xFF0000 | a() << 24 & 0xFF000000;
  }
  
  public long getInt64()
    throws IOException
  {
    if (this.a) {
      return a() << 56 & 0xFF00000000000000 | a() << 48 & 0xFF000000000000 | a() << 40 & 0xFF0000000000 | a() << 32 & 0xFF00000000 | a() << 24 & 0xFF000000 | a() << 16 & 0xFF0000 | a() << 8 & 0xFF00 | a() & 0xFF;
    }
    return a() & 0xFF | a() << 8 & 0xFF00 | a() << 16 & 0xFF0000 | a() << 24 & 0xFF000000 | a() << 32 & 0xFF00000000 | a() << 40 & 0xFF0000000000 | a() << 48 & 0xFF000000000000 | a() << 56 & 0xFF00000000000000;
  }
  
  public byte getInt8()
    throws IOException
  {
    return a();
  }
  
  public String getNullTerminatedString(int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramInt = 0;
    while (paramInt < arrayOfByte.length)
    {
      int i = a();
      arrayOfByte[paramInt] = i;
      if (i == 0) {
        break;
      }
      paramInt += 1;
    }
    return new String(arrayOfByte, 0, paramInt);
  }
  
  public float getS15Fixed16()
    throws IOException
  {
    if (this.a)
    {
      float f = (a() & 0xFF) << 8 | a() & 0xFF;
      i = a();
      j = a();
      d = f;
      return (float)(((i & 0xFF) << 8 | j & 0xFF) / 65536.0D + d);
    }
    int i = a();
    int j = a();
    double d = a() & 0xFF | (a() & 0xFF) << 8;
    return (float)((i & 0xFF | (j & 0xFF) << 8) / 65536.0D + d);
  }
  
  public String getString(int paramInt)
    throws IOException
  {
    return new String(getBytes(paramInt));
  }
  
  public String getString(int paramInt, String paramString)
    throws IOException
  {
    byte[] arrayOfByte = getBytes(paramInt);
    try
    {
      paramString = new String(arrayOfByte, paramString);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return new String(arrayOfByte);
  }
  
  public int getUInt16()
    throws IOException
  {
    if (this.a) {
      return a() << 8 & 0xFF00 | a() & 0xFF;
    }
    return a() & 0xFF | a() << 8 & 0xFF00;
  }
  
  public long getUInt32()
    throws IOException
  {
    if (this.a) {
      return a() << 24 & 0xFF000000 | a() << 16 & 0xFF0000 | a() << 8 & 0xFF00 | a() & 0xFF;
    }
    return a() & 0xFF | a() << 8 & 0xFF00 | a() << 16 & 0xFF0000 | a() << 24 & 0xFF000000;
  }
  
  public short getUInt8()
    throws IOException
  {
    return (short)(a() & 0xFF);
  }
  
  public boolean isMotorolaByteOrder()
  {
    return this.a;
  }
  
  public void setMotorolaByteOrder(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public abstract void skip(long paramLong)
    throws IOException;
  
  public abstract boolean trySkip(long paramLong)
    throws IOException;
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */