package com.ziroom.ziroomcustomer.signed;

import java.io.Serializable;

public class m
  implements Serializable
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  
  public m() {}
  
  public m(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.e = paramString3;
  }
  
  public String getInterest()
  {
    return this.a;
  }
  
  public String getLoanMoney()
  {
    return this.b;
  }
  
  public String getMonthRent()
  {
    return this.c;
  }
  
  public String getMonthSvFee()
  {
    return this.d;
  }
  
  public String getShouldPay()
  {
    return this.e;
  }
  
  public void setInterest(String paramString)
  {
    this.a = paramString;
  }
  
  public void setLoanMoney(String paramString)
  {
    this.b = paramString;
  }
  
  public void setMonthRent(String paramString)
  {
    this.c = paramString;
  }
  
  public void setMonthSvFee(String paramString)
  {
    this.d = paramString;
  }
  
  public void setShouldPay(String paramString)
  {
    this.e = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */