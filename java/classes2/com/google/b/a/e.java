package com.google.b.a;

import java.io.IOException;

public abstract class e
{
  public abstract int a();
  
  public abstract e a(b paramb);
  
  public e a(byte[] paramArrayOfByte)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public abstract void a(c paramc);
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = c.a(paramArrayOfByte, paramInt1, paramInt2);
      a(paramArrayOfByte);
      paramArrayOfByte.c();
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
    }
  }
  
  protected boolean a(b paramb, int paramInt)
  {
    return paramb.b(paramInt);
  }
  
  public abstract int b();
  
  public e b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = b.a(paramArrayOfByte, paramInt1, paramInt2);
      a(paramArrayOfByte);
      paramArrayOfByte.a(0);
      return this;
    }
    catch (d paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
    }
  }
  
  public byte[] c()
  {
    byte[] arrayOfByte = new byte[b()];
    a(arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/b/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */