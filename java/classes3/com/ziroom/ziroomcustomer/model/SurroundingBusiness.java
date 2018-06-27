package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class SurroundingBusiness
  implements Serializable
{
  private String address;
  private String content;
  private String name;
  private String pic;
  private String telephone;
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPic()
  {
    return this.pic;
  }
  
  public String getTelephone()
  {
    return this.telephone;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPic(String paramString)
  {
    this.pic = paramString;
  }
  
  public void setTelephone(String paramString)
  {
    this.telephone = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/SurroundingBusiness.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */