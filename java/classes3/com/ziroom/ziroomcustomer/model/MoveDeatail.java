package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class MoveDeatail
  implements Serializable
{
  private String code;
  private String date;
  private String id;
  private String isPay;
  private String phone;
  private String price;
  private String state;
  
  public String getCode()
  {
    return this.code;
  }
  
  public String getDate()
  {
    return this.date;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getIsPay()
  {
    return this.isPay;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public String getPrice()
  {
    return this.price;
  }
  
  public String getState()
  {
    return this.state;
  }
  
  public void setCode(String paramString)
  {
    this.code = paramString;
  }
  
  public void setDate(String paramString)
  {
    this.date = paramString;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setIsPay(String paramString)
  {
    this.isPay = paramString;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public void setPrice(String paramString)
  {
    this.price = paramString;
  }
  
  public void setState(String paramString)
  {
    this.state = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/MoveDeatail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */