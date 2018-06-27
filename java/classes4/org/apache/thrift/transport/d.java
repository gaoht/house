package org.apache.thrift.transport;

public abstract class d
{
  public abstract int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public void a(int paramInt) {}
  
  public byte[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 0;
  }
  
  public abstract void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public int c()
  {
    return -1;
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      int j = a(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
      if (j <= 0) {
        throw new e("Cannot read. Remote side has closed. Tried to read " + paramInt2 + " bytes, but only got " + i + " bytes.");
      }
      i += j;
    }
    return i;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/apache/thrift/transport/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */