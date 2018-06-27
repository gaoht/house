package com.b.b;

import java.io.IOException;
import java.io.RandomAccessFile;

public class i
  extends j
{
  private final RandomAccessFile b;
  private final long c;
  private int d;
  
  static
  {
    if (!i.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public i(RandomAccessFile paramRandomAccessFile)
    throws IOException
  {
    if (paramRandomAccessFile == null) {
      throw new NullPointerException();
    }
    this.b = paramRandomAccessFile;
    this.c = this.b.length();
  }
  
  private void b(int paramInt)
    throws IOException
  {
    if (paramInt == this.d) {
      return;
    }
    this.b.seek(paramInt);
    this.d = paramInt;
  }
  
  protected byte a(int paramInt)
    throws IOException
  {
    if (paramInt != this.d) {
      b(paramInt);
    }
    paramInt = this.b.read();
    if (paramInt < 0) {
      throw new a("Unexpected end of file encountered.");
    }
    if ((!a) && (paramInt > 255)) {
      throw new AssertionError();
    }
    this.d += 1;
    return (byte)paramInt;
  }
  
  protected void a(int paramInt1, int paramInt2)
    throws IOException
  {
    if (!b(paramInt1, paramInt2)) {
      throw new a(paramInt1, paramInt2, this.c);
    }
  }
  
  protected boolean b(int paramInt1, int paramInt2)
    throws IOException
  {
    return (paramInt2 >= 0) && (paramInt1 >= 0) && (paramInt1 + paramInt2 - 1L < this.c);
  }
  
  public byte[] getBytes(int paramInt1, int paramInt2)
    throws IOException
  {
    a(paramInt1, paramInt2);
    if (paramInt1 != this.d) {
      b(paramInt1);
    }
    byte[] arrayOfByte = new byte[paramInt2];
    paramInt1 = this.b.read(arrayOfByte);
    this.d += paramInt1;
    if (paramInt1 != paramInt2) {
      throw new a("Unexpected end of file encountered.");
    }
    return arrayOfByte;
  }
  
  public long getLength()
  {
    return this.c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */