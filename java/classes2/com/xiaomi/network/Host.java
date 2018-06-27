package com.xiaomi.network;

import java.net.InetSocketAddress;

public final class Host
{
  private String a;
  private int b;
  
  public Host(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public static Host a(String paramString, int paramInt)
  {
    int j = paramString.lastIndexOf(":");
    String str = paramString;
    i = paramInt;
    if (j != -1) {
      str = paramString.substring(0, j);
    }
    try
    {
      i = Integer.parseInt(paramString.substring(j + 1));
      if (i > 0) {
        break label59;
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        i = paramInt;
        continue;
        paramInt = i;
      }
    }
    i = paramInt;
    return new Host(str, i);
  }
  
  public static InetSocketAddress b(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt);
    return new InetSocketAddress(paramString.b(), paramString.a());
  }
  
  public int a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.a;
  }
  
  public String toString()
  {
    if (this.b > 0) {
      return this.a + ":" + this.b;
    }
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/network/Host.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */