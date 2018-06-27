package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class AlternateListingEntity
  implements Serializable
{
  private String address;
  private String picUrl;
  private String price;
  private String toSee_state;
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getPicUrl()
  {
    return this.picUrl;
  }
  
  public String getPrice()
  {
    return this.price;
  }
  
  public String getToSee_state()
  {
    return this.toSee_state;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setPicUrl(String paramString)
  {
    this.picUrl = paramString;
  }
  
  public void setPrice(String paramString)
  {
    this.price = paramString;
  }
  
  public void setToSee_state(String paramString)
  {
    this.toSee_state = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/AlternateListingEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */