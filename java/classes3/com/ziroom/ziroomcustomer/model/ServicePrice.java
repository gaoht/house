package com.ziroom.ziroomcustomer.model;

import java.util.List;

public class ServicePrice
{
  private List<ServicePriceItem> data;
  private String priceType;
  
  public List<ServicePriceItem> getData()
  {
    return this.data;
  }
  
  public String getPriceType()
  {
    return this.priceType;
  }
  
  public void setData(List<ServicePriceItem> paramList)
  {
    this.data = paramList;
  }
  
  public void setPriceType(String paramString)
  {
    this.priceType = paramString;
  }
  
  public String toString()
  {
    return "ServicePrice [priceType=" + this.priceType + ", data=" + this.data + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/ServicePrice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */