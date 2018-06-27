package com.google.c.d.b;

final class a
{
  private final byte[] a;
  private final byte[] b;
  
  a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.a = paramArrayOfByte1;
    this.b = paramArrayOfByte2;
  }
  
  public byte[] getDataBytes()
  {
    return this.a;
  }
  
  public byte[] getErrorCorrectionBytes()
  {
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/d/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */