package com.ziroom.ziroomcustomer.signed;

public class q
{
  private String a;
  private String b;
  
  public q() {}
  
  public q(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String getContract_code()
  {
    return this.a;
  }
  
  public String getPassword()
  {
    return this.b;
  }
  
  public void setContract_code(String paramString)
  {
    this.a = paramString;
  }
  
  public void setPassword(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */