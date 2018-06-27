package com.umeng.analytics.pro;

public final class ds
  extends dt
{
  private byte[] a;
  private int b;
  private int c;
  
  public ds() {}
  
  public ds(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte);
  }
  
  public ds(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    c(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws du
  {
    int j = h();
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
    throw new UnsupportedOperationException("No writing allowed!");
  }
  
  public void c() {}
  
  public void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = (paramInt1 + paramInt2);
  }
  
  public void e()
  {
    this.a = null;
  }
  
  public byte[] f()
  {
    return this.a;
  }
  
  public int g()
  {
    return this.b;
  }
  
  public int h()
  {
    return this.c - this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/ds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */