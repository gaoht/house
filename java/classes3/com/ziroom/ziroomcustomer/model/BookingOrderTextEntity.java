package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class BookingOrderTextEntity
  implements Serializable
{
  private String content1;
  private String content2;
  private String date;
  
  public String getContent1()
  {
    return this.content1;
  }
  
  public String getContent2()
  {
    return this.content2;
  }
  
  public String getDate()
  {
    return this.date;
  }
  
  public void setContent1(String paramString)
  {
    this.content1 = paramString;
  }
  
  public void setContent2(String paramString)
  {
    this.content2 = paramString;
  }
  
  public void setDate(String paramString)
  {
    this.date = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/BookingOrderTextEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */