package com.b.b;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class o
  extends n
{
  private final InputStream b;
  
  static
  {
    if (!o.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public o(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      throw new NullPointerException();
    }
    this.b = paramInputStream;
  }
  
  private long a(long paramLong)
    throws IOException
  {
    long l1 = 0L;
    long l2;
    long l3;
    do
    {
      l2 = l1;
      if (l1 == paramLong) {
        break;
      }
      l3 = this.b.skip(paramLong - l1);
      if ((!a) && (l3 < 0L)) {
        throw new AssertionError();
      }
      l2 = l1 + l3;
      l1 = l2;
    } while (l3 != 0L);
    return l2;
  }
  
  protected byte a()
    throws IOException
  {
    int i = this.b.read();
    if (i == -1) {
      throw new EOFException("End of data reached.");
    }
    return (byte)i;
  }
  
  public byte[] getBytes(int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i != paramInt)
    {
      int j = this.b.read(arrayOfByte, i, paramInt - i);
      if (j == -1) {
        throw new EOFException("End of data reached.");
      }
      j = i + j;
      i = j;
      if (!a)
      {
        i = j;
        if (j > paramInt) {
          throw new AssertionError();
        }
      }
    }
    return arrayOfByte;
  }
  
  public void skip(long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("n must be zero or greater.");
    }
    long l = a(paramLong);
    if (l != paramLong) {
      throw new EOFException(String.format("Unable to skip. Requested %d bytes but skipped %d.", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) }));
    }
  }
  
  public boolean trySkip(long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("n must be zero or greater.");
    }
    return a(paramLong) == paramLong;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */