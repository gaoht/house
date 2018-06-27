package com.umeng.analytics.pro;

import java.io.Serializable;

public class ct
  implements Serializable
{
  private final boolean a;
  public final byte b;
  private final String c;
  private final boolean d;
  
  public ct(byte paramByte)
  {
    this(paramByte, false);
  }
  
  public ct(byte paramByte, String paramString)
  {
    this.b = paramByte;
    this.a = true;
    this.c = paramString;
    this.d = false;
  }
  
  public ct(byte paramByte, boolean paramBoolean)
  {
    this.b = paramByte;
    this.a = false;
    this.c = null;
    this.d = paramBoolean;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public boolean c()
  {
    return this.b == 12;
  }
  
  public boolean d()
  {
    return (this.b == 15) || (this.b == 13) || (this.b == 14);
  }
  
  public boolean e()
  {
    return this.d;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */