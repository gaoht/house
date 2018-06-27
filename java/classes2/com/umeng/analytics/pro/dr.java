package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class dr
  extends dt
{
  protected InputStream a = null;
  protected OutputStream b = null;
  
  protected dr() {}
  
  public dr(InputStream paramInputStream)
  {
    this.a = paramInputStream;
  }
  
  public dr(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    this.a = paramInputStream;
    this.b = paramOutputStream;
  }
  
  public dr(OutputStream paramOutputStream)
  {
    this.b = paramOutputStream;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws du
  {
    if (this.a == null) {
      throw new du(1, "Cannot read from null inputStream");
    }
    try
    {
      paramInt1 = this.a.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 < 0) {
        throw new du(4);
      }
    }
    catch (IOException paramArrayOfByte)
    {
      throw new du(0, paramArrayOfByte);
    }
    return paramInt1;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
    throws du
  {}
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws du
  {
    if (this.b == null) {
      throw new du(1, "Cannot write to null outputStream");
    }
    try
    {
      this.b.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new du(0, paramArrayOfByte);
    }
  }
  
  public void c()
  {
    if (this.a != null) {}
    try
    {
      this.a.close();
      this.a = null;
      if (this.b == null) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        this.b.close();
        this.b = null;
        return;
        localIOException1 = localIOException1;
        localIOException1.printStackTrace();
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.printStackTrace();
        }
      }
    }
  }
  
  public void d()
    throws du
  {
    if (this.b == null) {
      throw new du(1, "Cannot flush null outputStream");
    }
    try
    {
      this.b.flush();
      return;
    }
    catch (IOException localIOException)
    {
      throw new du(0, localIOException);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/dr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */