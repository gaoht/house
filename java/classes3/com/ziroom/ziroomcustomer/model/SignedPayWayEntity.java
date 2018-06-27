package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class SignedPayWayEntity
  implements Serializable
{
  private int is_blank;
  private int payment;
  private List<SignedPayWayInfoEntity> payments;
  
  public int getIs_blank()
  {
    return this.is_blank;
  }
  
  public int getPayment()
  {
    return this.payment;
  }
  
  public List<SignedPayWayInfoEntity> getPayments()
  {
    return this.payments;
  }
  
  public void setIs_blank(int paramInt)
  {
    this.is_blank = paramInt;
  }
  
  public void setPayment(int paramInt)
  {
    this.payment = paramInt;
  }
  
  public void setPayments(List<SignedPayWayInfoEntity> paramList)
  {
    this.payments = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/SignedPayWayEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */