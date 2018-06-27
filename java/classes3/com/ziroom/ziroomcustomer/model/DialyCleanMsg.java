package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class DialyCleanMsg
  implements Serializable
{
  private String address;
  private String appointDate;
  private DialyCleaner cleanner;
  private int isPay;
  private String linkPhone;
  private String linkman;
  private String orderId;
  private String orderNum;
  private String orderType;
  private int price;
  private int state;
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getAppointDate()
  {
    return this.appointDate;
  }
  
  public DialyCleaner getCleanner()
  {
    return this.cleanner;
  }
  
  public int getIsPay()
  {
    return this.isPay;
  }
  
  public String getLinkPhone()
  {
    return this.linkPhone;
  }
  
  public String getLinkman()
  {
    return this.linkman;
  }
  
  public String getOrderId()
  {
    return this.orderId;
  }
  
  public String getOrderNum()
  {
    return this.orderNum;
  }
  
  public String getOrderType()
  {
    return this.orderType;
  }
  
  public int getPrice()
  {
    return this.price;
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setAppointDate(String paramString)
  {
    this.appointDate = paramString;
  }
  
  public void setCleanner(DialyCleaner paramDialyCleaner)
  {
    this.cleanner = paramDialyCleaner;
  }
  
  public void setIsPay(int paramInt)
  {
    this.isPay = paramInt;
  }
  
  public void setLinkPhone(String paramString)
  {
    this.linkPhone = paramString;
  }
  
  public void setLinkman(String paramString)
  {
    this.linkman = paramString;
  }
  
  public void setOrderId(String paramString)
  {
    this.orderId = paramString;
  }
  
  public void setOrderNum(String paramString)
  {
    this.orderNum = paramString;
  }
  
  public void setOrderType(String paramString)
  {
    this.orderType = paramString;
  }
  
  public void setPrice(int paramInt)
  {
    this.price = paramInt;
  }
  
  public void setState(int paramInt)
  {
    this.state = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/DialyCleanMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */