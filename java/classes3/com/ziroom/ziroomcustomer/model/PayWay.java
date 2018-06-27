package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class PayWay
  implements Serializable
{
  private String halfYear;
  private String house_company;
  private String month;
  private String quarter;
  private String year;
  
  public String getHalfYear()
  {
    return this.halfYear;
  }
  
  public String getHouse_company()
  {
    return this.house_company;
  }
  
  public String getMonth()
  {
    return this.month;
  }
  
  public String getQuarter()
  {
    return this.quarter;
  }
  
  public String getYear()
  {
    return this.year;
  }
  
  public void setHalfYear(String paramString)
  {
    this.halfYear = paramString;
  }
  
  public void setHouse_company(String paramString)
  {
    this.house_company = paramString;
  }
  
  public void setMonth(String paramString)
  {
    this.month = paramString;
  }
  
  public void setQuarter(String paramString)
  {
    this.quarter = paramString;
  }
  
  public void setYear(String paramString)
  {
    this.year = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/PayWay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */