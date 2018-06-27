package org.apache.thrift.transport;

public final class c
  extends d
{
  private byte[] a;
  private int b;
  private int c;
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = c();
    int i = paramInt2;
    if (paramInt2 > j) {
      i = j;
    }
    if (i > 0)
    {
      System.arraycopy(this.a, this.b, paramArrayOfByte, paramInt1, i);
      a(i);
    }
    return i;
  }
  
  public void a(int paramInt)
  {
    this.b += paramInt;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    c(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public byte[] a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException("No writing allowed!");
  }
  
  public int c()
  {
    return this.c - this.b;
  }
  
  public void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = (paramInt1 + paramInt2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/apache/thrift/transport/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */