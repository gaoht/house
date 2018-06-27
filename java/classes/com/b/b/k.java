package com.b.b;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class k
  extends j
{
  private final InputStream b;
  private final int c;
  private final ArrayList<byte[]> d = new ArrayList();
  private boolean e;
  private long f;
  
  static
  {
    if (!k.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public k(InputStream paramInputStream)
  {
    this(paramInputStream, 2048, -1L);
  }
  
  public k(InputStream paramInputStream, int paramInt)
  {
    this(paramInputStream, paramInt, -1L);
  }
  
  public k(InputStream paramInputStream, int paramInt, long paramLong)
  {
    if (paramInputStream == null) {
      throw new NullPointerException();
    }
    if (paramInt <= 0) {
      throw new IllegalArgumentException("chunkLength must be greater than zero");
    }
    this.c = paramInt;
    this.b = paramInputStream;
    this.f = paramLong;
  }
  
  protected byte a(int paramInt)
    throws IOException
  {
    if ((!a) && (paramInt < 0)) {
      throw new AssertionError();
    }
    int i = paramInt / this.c;
    int j = this.c;
    return ((byte[])this.d.get(i))[(paramInt % j)];
  }
  
  protected void a(int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt1 < 0) {
      throw new a(String.format("Attempt to read from buffer using a negative index (%d)", new Object[] { Integer.valueOf(paramInt1) }));
    }
    if (paramInt2 < 0) {
      throw new a("Number of requested bytes must be zero or greater");
    }
    if (paramInt1 + paramInt2 - 1L > 2147483647L) {
      throw new a(String.format("Number of requested bytes summed with starting index exceed maximum range of signed 32 bit integers (requested index: %d, requested count: %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (!b(paramInt1, paramInt2))
    {
      if ((!a) && (!this.e)) {
        throw new AssertionError();
      }
      throw new a(paramInt1, paramInt2, this.f);
    }
  }
  
  protected boolean b(int paramInt1, int paramInt2)
    throws IOException
  {
    boolean bool = true;
    if ((paramInt1 < 0) || (paramInt2 < 0)) {}
    long l;
    do
    {
      return false;
      l = paramInt1 + paramInt2 - 1L;
    } while (l > 2147483647L);
    paramInt2 = (int)l;
    if (this.e)
    {
      if (paramInt2 < this.f) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    int i = paramInt2 / this.c;
    while (i >= this.d.size())
    {
      if ((!a) && (this.e)) {
        throw new AssertionError();
      }
      byte[] arrayOfByte = new byte[this.c];
      paramInt1 = 0;
      for (;;)
      {
        if ((this.e) || (paramInt1 == this.c)) {
          break label243;
        }
        int j = this.b.read(arrayOfByte, paramInt1, this.c - paramInt1);
        if (j == -1)
        {
          this.e = true;
          j = this.d.size() * this.c + paramInt1;
          if (this.f == -1L)
          {
            this.f = j;
            if (paramInt2 < this.f) {
              continue;
            }
            this.d.add(arrayOfByte);
            return false;
          }
          if ((this.f == j) || (a)) {
            break;
          }
          throw new AssertionError();
        }
        paramInt1 += j;
      }
      label243:
      this.d.add(arrayOfByte);
    }
    return true;
  }
  
  public byte[] getBytes(int paramInt1, int paramInt2)
    throws IOException
  {
    a(paramInt1, paramInt2);
    byte[] arrayOfByte = new byte[paramInt2];
    int j = 0;
    int i = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = j;
    while (i != 0)
    {
      int k = paramInt2 / this.c;
      int m = paramInt2 % this.c;
      j = Math.min(i, this.c - m);
      System.arraycopy((byte[])this.d.get(k), m, arrayOfByte, paramInt1, j);
      i -= j;
      paramInt2 += j;
      paramInt1 += j;
    }
    return arrayOfByte;
  }
  
  public long getLength()
    throws IOException
  {
    if (this.f != -1L) {
      return this.f;
    }
    b(Integer.MAX_VALUE, 1);
    if ((!a) && (!this.e)) {
      throw new AssertionError();
    }
    return this.f;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */