package com.megvii.zhimasdk.b.a.i.f;

import com.megvii.zhimasdk.b.a.j.f;
import java.io.IOException;
import java.io.InputStream;

public class g
  extends InputStream
{
  private final long a;
  private long b = 0L;
  private boolean c = false;
  private f d = null;
  
  public g(f paramf, long paramLong)
  {
    this.d = ((f)com.megvii.zhimasdk.b.a.o.a.a(paramf, "Session input buffer"));
    this.a = com.megvii.zhimasdk.b.a.o.a.a(paramLong, "Content length");
  }
  
  public int available()
  {
    if ((this.d instanceof com.megvii.zhimasdk.b.a.j.a)) {
      return Math.min(((com.megvii.zhimasdk.b.a.j.a)this.d).e(), (int)(this.a - this.b));
    }
    return 0;
  }
  
  public void close()
  {
    if (!this.c) {}
    try
    {
      if (this.b < this.a)
      {
        byte[] arrayOfByte = new byte['ࠀ'];
        int i;
        do
        {
          i = read(arrayOfByte);
        } while (i >= 0);
      }
      return;
    }
    finally
    {
      this.c = true;
    }
  }
  
  public int read()
  {
    if (this.c) {
      throw new IOException("Attempted read from closed stream.");
    }
    if (this.b >= this.a) {
      return -1;
    }
    int i = this.d.a();
    if (i == -1)
    {
      if (this.b < this.a) {
        throw new com.megvii.zhimasdk.b.a.a("Premature end of Content-Length delimited message body (expected: " + this.a + "; received: " + this.b);
      }
    }
    else {
      this.b += 1L;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.c) {
      throw new IOException("Attempted read from closed stream.");
    }
    if (this.b >= this.a) {
      return -1;
    }
    int i = paramInt2;
    if (this.b + paramInt2 > this.a) {
      i = (int)(this.a - this.b);
    }
    paramInt1 = this.d.a(paramArrayOfByte, paramInt1, i);
    if ((paramInt1 == -1) && (this.b < this.a)) {
      throw new com.megvii.zhimasdk.b.a.a("Premature end of Content-Length delimited message body (expected: " + this.a + "; received: " + this.b);
    }
    if (paramInt1 > 0) {
      this.b += paramInt1;
    }
    return paramInt1;
  }
  
  public long skip(long paramLong)
  {
    if (paramLong <= 0L) {
      return 0L;
    }
    byte[] arrayOfByte = new byte['ࠀ'];
    paramLong = Math.min(paramLong, this.a - this.b);
    long l = 0L;
    for (;;)
    {
      int i;
      if (paramLong > 0L)
      {
        i = read(arrayOfByte, 0, (int)Math.min(2048L, paramLong));
        if (i != -1) {}
      }
      else
      {
        return l;
      }
      l += i;
      paramLong -= i;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/f/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */