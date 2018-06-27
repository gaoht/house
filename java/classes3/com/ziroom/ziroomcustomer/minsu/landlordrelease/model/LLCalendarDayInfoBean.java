package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

import java.io.Serializable;

public class LLCalendarDayInfoBean
  implements Serializable
{
  private String date;
  private String holiday;
  private String isWorkDay;
  private LLCalendarOrderBean landCalenderOrder;
  private int price;
  private int status;
  
  public String getDate()
  {
    return this.date;
  }
  
  public String getHoliday()
  {
    return this.holiday;
  }
  
  public String getIsWorkDay()
  {
    return this.isWorkDay;
  }
  
  public LLCalendarOrderBean getLandCalenderOrder()
  {
    return this.landCalenderOrder;
  }
  
  public int getPrice()
  {
    return this.price;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public void setDate(String paramString)
  {
    this.date = paramString;
  }
  
  public void setHoliday(String paramString)
  {
    this.holiday = paramString;
  }
  
  public void setIsWorkDay(String paramString)
  {
    this.isWorkDay = paramString;
  }
  
  public void setLandCalenderOrder(LLCalendarOrderBean paramLLCalendarOrderBean)
  {
    this.landCalenderOrder = paramLLCalendarOrderBean;
  }
  
  public void setPrice(int paramInt)
  {
    this.price = paramInt;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public String toString()
  {
    return "LLCalendarDayInfoBean{date='" + this.date + '\'' + ", price=" + this.price + ", status=" + this.status + ", landCalenderOrder=" + this.landCalenderOrder + ", holiday=" + this.holiday + ", isWorkDay='" + this.isWorkDay + '\'' + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/LLCalendarDayInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */