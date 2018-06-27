package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class SignedPayWayInfoEntity
  implements Serializable
{
  private String check;
  private String payment;
  
  public String getCheck()
  {
    return this.check;
  }
  
  public String getPayment()
  {
    return this.payment;
  }
  
  public void setCheck(String paramString)
  {
    this.check = paramString;
  }
  
  public void setPayment(String paramString)
  {
    this.payment = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/SignedPayWayInfoEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */