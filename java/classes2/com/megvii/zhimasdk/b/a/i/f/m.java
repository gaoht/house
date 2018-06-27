package com.megvii.zhimasdk.b.a.i.f;

import com.megvii.zhimasdk.b.a.j.g;
import com.megvii.zhimasdk.b.a.o.a;
import java.io.IOException;
import java.io.OutputStream;

public class m
  extends OutputStream
{
  private final g a;
  private boolean b = false;
  
  public m(g paramg)
  {
    this.a = ((g)a.a(paramg, "Session output buffer"));
  }
  
  public void close()
  {
    if (!this.b)
    {
      this.b = true;
      this.a.a();
    }
  }
  
  public void flush()
  {
    this.a.a();
  }
  
  public void write(int paramInt)
  {
    if (this.b) {
      throw new IOException("Attempted write to closed stream.");
    }
    this.a.a(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.b) {
      throw new IOException("Attempted write to closed stream.");
    }
    this.a.a(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/f/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */