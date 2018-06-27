package com.xiaomi.xmpush.thrift;

public enum h
{
  private final int f;
  
  private h(int paramInt)
  {
    this.f = paramInt;
  }
  
  public static h a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return a;
    case 1: 
      return b;
    case 2: 
      return c;
    case 3: 
      return d;
    }
    return e;
  }
  
  public int a()
  {
    return this.f;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */