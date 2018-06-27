package org.apache.thrift.transport;

public class b
  extends d
{
  private org.apache.thrift.d a;
  private int b;
  
  public b(int paramInt)
  {
    this.a = new org.apache.thrift.d(paramInt);
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = this.a.a();
    int i = paramInt2;
    if (paramInt2 > this.a.b() - this.b) {
      i = this.a.b() - this.b;
    }
    if (i > 0)
    {
      System.arraycopy(arrayOfByte, this.b, paramArrayOfByte, paramInt1, i);
      this.b += i;
    }
    return i;
  }
  
  public int a_()
  {
    return this.a.size();
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/apache/thrift/transport/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */