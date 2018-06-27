package com.a.a.a;

import java.io.IOException;
import java.io.OutputStream;

public final class c
  extends OutputStream
{
  private final OutputStream a;
  private int b = 0;
  
  c(OutputStream paramOutputStream)
  {
    this.a = paramOutputStream;
  }
  
  public int getBytesWritten()
  {
    return this.b;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.a.write(paramInt);
    this.b += 1;
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    this.a.write(paramArrayOfByte);
    this.b += paramArrayOfByte.length;
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
    this.b += paramInt2;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */