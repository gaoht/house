package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class Fees
  implements Serializable
{
  private String balance;
  private String displayNums;
  private String isAdvancePay;
  private String isPayAll;
  private String price;
  private String price_unit;
  private String remarks;
  private String type;
  private String unPayMoney;
  
  public String getBalance()
  {
    return this.balance;
  }
  
  public String getDisplayNums()
  {
    return this.displayNums;
  }
  
  public String getIsAdvancePay()
  {
    return this.isAdvancePay;
  }
  
  public String getIsPayAll()
  {
    return this.isPayAll;
  }
  
  public String getPrice()
  {
    return this.price;
  }
  
  public String getPrice_unit()
  {
    return this.price_unit;
  }
  
  public String getRemarks()
  {
    return this.remarks;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public String getUnPayMoney()
  {
    return this.unPayMoney;
  }
  
  public void setBalance(String paramString)
  {
    this.balance = paramString;
  }
  
  public void setDisplayNums(String paramString)
  {
    this.displayNums = paramString;
  }
  
  public void setIsAdvancePay(String paramString)
  {
    this.isAdvancePay = paramString;
  }
  
  public void setIsPayAll(String paramString)
  {
    this.isPayAll = paramString;
  }
  
  public void setPrice(String paramString)
  {
    this.price = paramString;
  }
  
  public void setPrice_unit(String paramString)
  {
    this.price_unit = paramString;
  }
  
  public void setRemarks(String paramString)
  {
    this.remarks = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void setUnPayMoney(String paramString)
  {
    this.unPayMoney = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/Fees.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */