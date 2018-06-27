package com.ziroom.ziroomcustomer.ziroomstation.model;

import java.io.Serializable;

public class StationOrderCreateUserEntity
  implements Serializable
{
  private String credentials;
  private String credentialsStyle;
  private String houseType;
  private String houseTypeBid;
  private String name;
  private String sex;
  
  public StationOrderCreateUserEntity(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.name = paramString1;
    this.sex = paramString2;
    this.credentialsStyle = paramString3;
    this.credentials = paramString4;
    this.houseType = paramString5;
    this.houseTypeBid = paramString6;
  }
  
  public String getCredentials()
  {
    return this.credentials;
  }
  
  public String getCredentialsStyle()
  {
    return this.credentialsStyle;
  }
  
  public String getHouseType()
  {
    return this.houseType;
  }
  
  public String getHouseTypeBid()
  {
    return this.houseTypeBid;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getSex()
  {
    return this.sex;
  }
  
  public void setCredentials(String paramString)
  {
    this.credentials = paramString;
  }
  
  public void setCredentialsStyle(String paramString)
  {
    this.credentialsStyle = paramString;
  }
  
  public void setHouseType(String paramString)
  {
    this.houseType = paramString;
  }
  
  public void setHouseTypeBid(String paramString)
  {
    this.houseTypeBid = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setSex(String paramString)
  {
    this.sex = paramString;
  }
  
  public String toString()
  {
    return "StationOrderCreateUserEntity{name='" + this.name + '\'' + ", sex='" + this.sex + '\'' + ", credentialsStyle='" + this.credentialsStyle + '\'' + ", credentials='" + this.credentials + '\'' + ", houseType='" + this.houseType + '\'' + ", houseTypeBid='" + this.houseTypeBid + '\'' + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/StationOrderCreateUserEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */