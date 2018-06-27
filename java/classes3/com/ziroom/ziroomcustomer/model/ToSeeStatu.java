package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class ToSeeStatu
  implements Serializable
{
  private String house_code;
  private String house_no;
  private String house_status;
  
  public String getHouse_code()
  {
    return this.house_code;
  }
  
  public String getHouse_no()
  {
    return this.house_no;
  }
  
  public String getHouse_status()
  {
    return this.house_status;
  }
  
  public void setHouse_code(String paramString)
  {
    this.house_code = paramString;
  }
  
  public void setHouse_no(String paramString)
  {
    this.house_no = paramString;
  }
  
  public void setHouse_status(String paramString)
  {
    this.house_status = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/ToSeeStatu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */