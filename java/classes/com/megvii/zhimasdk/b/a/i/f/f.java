package com.megvii.zhimasdk.b.a.i.f;

import com.megvii.zhimasdk.b.a.j.g;
import java.io.IOException;
import java.io.OutputStream;

public class f
  extends OutputStream
{
  private final g a;
  private final byte[] b;
  private int c = 0;
  private boolean d = false;
  private boolean e = false;
  
  public f(int paramInt, g paramg)
  {
    this.b = new byte[paramInt];
    this.a = paramg;
  }
  
  @Deprecated
  public f(g paramg)
  {
    this(2048, paramg);
  }
  
  protected void a()
  {
    if (this.c > 0)
    {
      this.a.a(Integer.toHexString(this.c));
      this.a.a(this.b, 0, this.c);
      this.a.a("");
      this.c = 0;
    }
  }
  
  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a.a(Integer.toHexString(this.c + paramInt2));
    this.a.a(this.b, 0, this.c);
    this.a.a(paramArrayOfByte, paramInt1, paramInt2);
    this.a.a("");
    this.c = 0;
  }
  
  protected void b()
  {
    this.a.a("0");
    this.a.a("");
  }
  
  public void c()
  {
    if (!this.d)
    {
      a();
      b();
      this.d = true;
    }
  }
  
  public void close()
  {
    if (!this.e)
    {
      this.e = true;
      c();
      this.a.a();
    }
  }
  
  public void flush()
  {
    a();
    this.a.a();
  }
  
  public void write(int paramInt)
  {
    if (this.e) {
      throw new IOException("Attempted write to closed stream.");
    }
    this.b[this.c] = ((byte)paramInt);
    this.c += 1;
    if (this.c == this.b.length) {
      a();
    }
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.e) {
      throw new IOException("Attempted write to closed stream.");
    }
    if (paramInt2 >= this.b.length - this.c)
    {
      a(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.b, this.c, paramInt2);
    this.c += paramInt2;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/f/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */