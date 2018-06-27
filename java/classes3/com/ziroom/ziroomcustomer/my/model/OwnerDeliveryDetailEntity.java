package com.ziroom.ziroomcustomer.my.model;

import java.io.Serializable;
import java.util.List;

public class OwnerDeliveryDetailEntity
  implements Serializable
{
  private List<Object> delivery;
  private String deliveryDate;
  public String hireCommissionerPhone;
  
  public List<Object> getDelivery()
  {
    return this.delivery;
  }
  
  public String getDeliveryDate()
  {
    return this.deliveryDate;
  }
  
  public void setDelivery(List<Object> paramList)
  {
    this.delivery = paramList;
  }
  
  public void setDeliveryDate(String paramString)
  {
    this.deliveryDate = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/OwnerDeliveryDetailEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */