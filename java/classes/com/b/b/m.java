package com.b.b;

import java.io.EOFException;
import java.io.IOException;

public class m
  extends n
{
  private final byte[] a;
  private int b;
  
  public m(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0);
  }
  
  public m(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException();
    }
    this.a = paramArrayOfByte;
    this.b = paramInt;
  }
  
  protected byte a()
    throws IOException
  {
    if (this.b >= this.a.length) {
      throw new EOFException("End of data reached.");
    }
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    return arrayOfByte[i];
  }
  
  public byte[] getBytes(int paramInt)
    throws IOException
  {
    if (this.b + paramInt > this.a.length) {
      throw new EOFException("End of data reached.");
    }
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(this.a, this.b, arrayOfByte, 0, paramInt);
    this.b += paramInt;
    return arrayOfByte;
  }
  
  public void skip(long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("n must be zero or greater.");
    }
    if (this.b + paramLong > this.a.length) {
      throw new EOFException("End of data reached.");
    }
    this.b = ((int)(this.b + paramLong));
  }
  
  public boolean trySkip(long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("n must be zero or greater.");
    }
    this.b = ((int)(this.b + paramLong));
    if (this.b > this.a.length)
    {
      this.b = this.a.length;
      return false;
    }
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/b/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */