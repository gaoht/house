package com.megvii.zhimasdk.b.a.g;

import java.io.InputStream;
import java.io.OutputStream;

public class b
  extends a
{
  private InputStream d;
  private long e = -1L;
  
  public InputStream a()
  {
    if (this.d != null) {}
    for (boolean bool = true;; bool = false)
    {
      com.megvii.zhimasdk.b.a.o.b.a(bool, "Content has not been provided");
      return this.d;
    }
  }
  
  public void a(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void a(InputStream paramInputStream)
  {
    this.d = paramInputStream;
  }
  
  public void a(OutputStream paramOutputStream)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramOutputStream, "Output stream");
    InputStream localInputStream = a();
    try
    {
      byte[] arrayOfByte = new byte['က'];
      for (;;)
      {
        int i = localInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
    }
    finally
    {
      localInputStream.close();
    }
  }
  
  public long b()
  {
    return this.e;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public boolean f()
  {
    return this.d != null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/g/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */