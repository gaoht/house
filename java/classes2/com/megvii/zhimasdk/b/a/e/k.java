package com.megvii.zhimasdk.b.a.e;

import com.megvii.zhimasdk.b.a.o.a;
import java.io.IOException;
import java.io.InputStream;

public class k
  extends InputStream
  implements i
{
  protected InputStream a;
  private boolean b;
  private final l c;
  
  public k(InputStream paramInputStream, l paraml)
  {
    a.a(paramInputStream, "Wrapped stream");
    this.a = paramInputStream;
    this.b = false;
    this.c = paraml;
  }
  
  protected void a(int paramInt)
  {
    boolean bool;
    if ((this.a != null) && (paramInt < 0)) {
      bool = true;
    }
    try
    {
      if (this.c != null) {
        bool = this.c.a(this.a);
      }
      if (bool) {
        this.a.close();
      }
      return;
    }
    finally
    {
      this.a = null;
    }
  }
  
  protected boolean a()
  {
    if (this.b) {
      throw new IOException("Attempted read on closed stream.");
    }
    return this.a != null;
  }
  
  public int available()
  {
    int i = 0;
    if (a()) {}
    try
    {
      i = this.a.available();
      return i;
    }
    catch (IOException localIOException)
    {
      c();
      throw localIOException;
    }
  }
  
  protected void b()
  {
    boolean bool;
    if (this.a != null) {
      bool = true;
    }
    try
    {
      if (this.c != null) {
        bool = this.c.b(this.a);
      }
      if (bool) {
        this.a.close();
      }
      return;
    }
    finally
    {
      this.a = null;
    }
  }
  
  protected void c()
  {
    boolean bool;
    if (this.a != null) {
      bool = true;
    }
    try
    {
      if (this.c != null) {
        bool = this.c.c(this.a);
      }
      if (bool) {
        this.a.close();
      }
      return;
    }
    finally
    {
      this.a = null;
    }
  }
  
  public void close()
  {
    this.b = true;
    b();
  }
  
  public void i()
  {
    close();
  }
  
  public void j()
  {
    this.b = true;
    c();
  }
  
  public int read()
  {
    int i = -1;
    if (a()) {}
    try
    {
      i = this.a.read();
      a(i);
      return i;
    }
    catch (IOException localIOException)
    {
      c();
      throw localIOException;
    }
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = -1;
    if (a()) {}
    try
    {
      i = this.a.read(paramArrayOfByte, paramInt1, paramInt2);
      a(i);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      c();
      throw paramArrayOfByte;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/e/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */