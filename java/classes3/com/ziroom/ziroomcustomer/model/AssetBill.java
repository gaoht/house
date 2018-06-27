package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class AssetBill
  implements Serializable
{
  private String fact_payment;
  private String fact_payment_date;
  private String ought_payment_price;
  private String pay_date;
  
  public String getFact_payment()
  {
    return this.fact_payment;
  }
  
  public String getFact_payment_date()
  {
    return this.fact_payment_date;
  }
  
  public String getOught_payment_price()
  {
    return this.ought_payment_price;
  }
  
  public String getPay_date()
  {
    return this.pay_date;
  }
  
  public void setFact_payment(String paramString)
  {
    this.fact_payment = paramString;
  }
  
  public void setFact_payment_date(String paramString)
  {
    this.fact_payment_date = paramString;
  }
  
  public void setOught_payment_price(String paramString)
  {
    this.ought_payment_price = paramString;
  }
  
  public void setPay_date(String paramString)
  {
    this.pay_date = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/AssetBill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */