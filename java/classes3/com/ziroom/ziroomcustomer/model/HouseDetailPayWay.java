package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class HouseDetailPayWay
  implements Serializable
{
  private PayWay deposit;
  private PayWay rentFee;
  private PayWay serviceFee;
  
  public PayWay getDeposit()
  {
    return this.deposit;
  }
  
  public PayWay getRentFee()
  {
    return this.rentFee;
  }
  
  public PayWay getServiceFee()
  {
    return this.serviceFee;
  }
  
  public void setDeposit(PayWay paramPayWay)
  {
    this.deposit = paramPayWay;
  }
  
  public void setRentFee(PayWay paramPayWay)
  {
    this.rentFee = paramPayWay;
  }
  
  public void setServiceFee(PayWay paramPayWay)
  {
    this.serviceFee = paramPayWay;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/HouseDetailPayWay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */