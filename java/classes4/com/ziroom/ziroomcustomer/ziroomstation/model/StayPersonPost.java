package com.ziroom.ziroomcustomer.ziroomstation.model;

public class StayPersonPost
{
  private String credentialNumber;
  private int credentialType;
  private String houseTypeBid;
  private byte sex;
  private String stayPersonName;
  
  public StayPersonPost(String paramString1, String paramString2, int paramInt, String paramString3, byte paramByte)
  {
    this.stayPersonName = paramString1;
    this.houseTypeBid = paramString2;
    this.credentialType = paramInt;
    this.credentialNumber = paramString3;
    this.sex = paramByte;
  }
  
  public String getCredentialNumber()
  {
    return this.credentialNumber;
  }
  
  public int getCredentialType()
  {
    return this.credentialType;
  }
  
  public String getHouseTypeBid()
  {
    return this.houseTypeBid;
  }
  
  public byte getSex()
  {
    return this.sex;
  }
  
  public String getStayPersonName()
  {
    return this.stayPersonName;
  }
  
  public void setCredentialNumber(String paramString)
  {
    this.credentialNumber = paramString;
  }
  
  public void setCredentialType(int paramInt)
  {
    this.credentialType = paramInt;
  }
  
  public void setHouseTypeBid(String paramString)
  {
    this.houseTypeBid = paramString;
  }
  
  public void setSex(byte paramByte)
  {
    this.sex = paramByte;
  }
  
  public void setStayPersonName(String paramString)
  {
    this.stayPersonName = paramString;
  }
  
  public String toString()
  {
    return "StayPersonPost{stayPersonName='" + this.stayPersonName + '\'' + ", houseTypeBid='" + this.houseTypeBid + '\'' + ", credentialType=" + this.credentialType + ", credentialNumber='" + this.credentialNumber + '\'' + ", sex=" + this.sex + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/StayPersonPost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */