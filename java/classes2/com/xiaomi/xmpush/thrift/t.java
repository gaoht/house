package com.xiaomi.xmpush.thrift;

public enum t
{
  private final int d;
  
  private t(int paramInt)
  {
    this.d = paramInt;
  }
  
  public static t a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return a;
    case 1: 
      return b;
    }
    return c;
  }
  
  public int a()
  {
    return this.d;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */