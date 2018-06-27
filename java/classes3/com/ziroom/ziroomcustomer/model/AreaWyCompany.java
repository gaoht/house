package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class AreaWyCompany
  implements Serializable
{
  private String address;
  private String cname;
  private String tel;
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getCname()
  {
    return this.cname;
  }
  
  public String getTel()
  {
    return this.tel;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setCname(String paramString)
  {
    this.cname = paramString;
  }
  
  public void setTel(String paramString)
  {
    this.tel = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/AreaWyCompany.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */