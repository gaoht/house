package org.apache.thrift.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class a
  extends d
{
  protected InputStream a = null;
  protected OutputStream b = null;
  
  protected a() {}
  
  public a(OutputStream paramOutputStream)
  {
    this.b = paramOutputStream;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.a == null) {
      throw new e(1, "Cannot read from null inputStream");
    }
    try
    {
      paramInt1 = this.a.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 < 0) {
        throw new e(4);
      }
    }
    catch (IOException paramArrayOfByte)
    {
      throw new e(0, paramArrayOfByte);
    }
    return paramInt1;
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.b == null) {
      throw new e(1, "Cannot write to null outputStream");
    }
    try
    {
      this.b.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new e(0, paramArrayOfByte);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/apache/thrift/transport/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */