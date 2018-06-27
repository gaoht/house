package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import java.io.Serializable;

public class ZryuSignPerson
  implements Serializable
{
  private String certNo;
  private String certTypeName;
  private String name;
  private String phone;
  private String sex;
  
  public String getCertNo()
  {
    return this.certNo;
  }
  
  public String getCertTypeName()
  {
    return this.certTypeName;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public String getSex()
  {
    return this.sex;
  }
  
  public void setCertNo(String paramString)
  {
    this.certNo = paramString;
  }
  
  public void setCertTypeName(String paramString)
  {
    this.certTypeName = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public void setSex(String paramString)
  {
    this.sex = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuSignPerson.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */