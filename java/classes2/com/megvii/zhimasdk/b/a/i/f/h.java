package com.megvii.zhimasdk.b.a.i.f;

import com.megvii.zhimasdk.b.a.j.g;
import com.megvii.zhimasdk.b.a.o.a;
import java.io.IOException;
import java.io.OutputStream;

public class h
  extends OutputStream
{
  private final g a;
  private final long b;
  private long c = 0L;
  private boolean d = false;
  
  public h(g paramg, long paramLong)
  {
    this.a = ((g)a.a(paramg, "Session output buffer"));
    this.b = a.a(paramLong, "Content length");
  }
  
  public void close()
  {
    if (!this.d)
    {
      this.d = true;
      this.a.a();
    }
  }
  
  public void flush()
  {
    this.a.a();
  }
  
  public void write(int paramInt)
  {
    if (this.d) {
      throw new IOException("Attempted write to closed stream.");
    }
    if (this.c < this.b)
    {
      this.a.a(paramInt);
      this.c += 1L;
    }
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.d) {
      throw new IOException("Attempted write to closed stream.");
    }
    if (this.c < this.b)
    {
      long l = this.b - this.c;
      int i = paramInt2;
      if (paramInt2 > l) {
        i = (int)l;
      }
      this.a.a(paramArrayOfByte, paramInt1, i);
      this.c += i;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/f/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */