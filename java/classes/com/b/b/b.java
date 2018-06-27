package com.b.b;

import java.io.IOException;

public class b
  extends j
{
  private final byte[] a;
  
  public b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException();
    }
    this.a = paramArrayOfByte;
  }
  
  protected byte a(int paramInt)
    throws IOException
  {
    return this.a[paramInt];
  }
  
  protected void a(int paramInt1, int paramInt2)
    throws IOException
  {
    if (!b(paramInt1, paramInt2)) {
      throw new a(paramInt1, paramInt2, this.a.length);
    }
  }
  
  protected boolean b(int paramInt1, int paramInt2)
    throws IOException
  {
    return (paramInt2 >= 0) && (paramInt1 >= 0) && (paramInt1 + paramInt2 - 1L < this.a.length);
  }
  
  public byte[] getBytes(int paramInt1, int paramInt2)
    throws IOException
  {
    a(paramInt1, paramInt2);
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(this.a, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public long getLength()
  {
    return this.a.length;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */