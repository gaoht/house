package com.ziroom.ziroomcustomer.model;

public class LockRoom
{
  private String contractCode;
  private String houseCode;
  private String houseCode1;
  private String houseId;
  private String houseType;
  private String villageName;
  
  public String getContractCode()
  {
    return this.contractCode;
  }
  
  public String getHouseCode()
  {
    return this.houseCode;
  }
  
  public String getHouseCode1()
  {
    return this.houseCode1;
  }
  
  public String getHouseId()
  {
    return this.houseId;
  }
  
  public String getHouseType()
  {
    return this.houseType;
  }
  
  public String getVillageName()
  {
    return this.villageName;
  }
  
  public void setContractCode(String paramString)
  {
    this.contractCode = paramString;
  }
  
  public void setHouseCode(String paramString)
  {
    this.houseCode = paramString;
  }
  
  public void setHouseCode1(String paramString)
  {
    this.houseCode1 = paramString;
  }
  
  public void setHouseId(String paramString)
  {
    this.houseId = paramString;
  }
  
  public void setHouseType(String paramString)
  {
    this.houseType = paramString;
  }
  
  public void setVillageName(String paramString)
  {
    this.villageName = paramString;
  }
  
  public String toString()
  {
    return "LockRoom [houseCode=" + this.houseCode + ", houseId=" + this.houseId + ", houseCode1=" + this.houseCode1 + ", villageName=" + this.villageName + ", contractCode=" + this.contractCode + ", houseType=" + this.houseType + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/LockRoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */