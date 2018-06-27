package com.g.a;

public class aj
{
  private String a;
  private String b;
  private byte c;
  private byte d;
  private byte e;
  
  public aj()
  {
    this.a = "";
    this.b = "00:00:00:00:00:00";
    this.c = -127;
    this.d = 1;
    this.e = 1;
  }
  
  public aj(String paramString1, String paramString2, byte paramByte1, byte paramByte2, byte paramByte3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramByte1;
    this.d = paramByte2;
    this.e = paramByte3;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public byte c()
  {
    return this.c;
  }
  
  public byte d()
  {
    return this.d;
  }
  
  public byte e()
  {
    return this.e;
  }
  
  public aj f()
  {
    return new aj(this.a, this.b, this.c, this.d, this.e);
  }
  
  public void setBand(byte paramByte)
  {
    this.d = paramByte;
  }
  
  public void setBssid(String paramString)
  {
    this.b = paramString;
  }
  
  public void setChannel(byte paramByte)
  {
    this.e = paramByte;
  }
  
  public void setRssi(byte paramByte)
  {
    this.c = paramByte;
  }
  
  public void setSsid(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */