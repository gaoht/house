package com.umeng.analytics.pro;

import java.io.ByteArrayOutputStream;

public class ci
  extends ByteArrayOutputStream
{
  public ci() {}
  
  public ci(int paramInt)
  {
    super(paramInt);
  }
  
  public byte[] a()
  {
    return this.buf;
  }
  
  public int b()
  {
    return this.count;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */