package com.umeng.analytics.pro;

public abstract class dt
{
  public abstract int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws du;
  
  public void a(int paramInt) {}
  
  public abstract boolean a();
  
  public abstract void b()
    throws du;
  
  public void b(byte[] paramArrayOfByte)
    throws du
  {
    b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public abstract void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws du;
  
  public abstract void c();
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws du
  {
    int i = 0;
    while (i < paramInt2)
    {
      int j = a(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
      if (j <= 0) {
        throw new du("Cannot read. Remote side has closed. Tried to read " + paramInt2 + " bytes, but only got " + i + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
      }
      i += j;
    }
    return i;
  }
  
  public void d()
    throws du
  {}
  
  public byte[] f()
  {
    return null;
  }
  
  public int g()
  {
    return 0;
  }
  
  public int h()
  {
    return -1;
  }
  
  public boolean i()
  {
    return a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */