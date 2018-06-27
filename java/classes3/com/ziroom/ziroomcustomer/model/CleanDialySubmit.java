package com.ziroom.ziroomcustomer.model;

public class CleanDialySubmit
{
  private String address;
  private String addressXY;
  private String appointDate;
  private int appointTime;
  private int dataSource;
  private String hireContract;
  private String houseSource;
  private String linkPhone;
  private String linkman;
  private double price;
  private String promoCodeId;
  private String remark;
  private String rentContract;
  private String serviceInfoId;
  private String servicePmId;
  private String signature;
  private String timestamp;
  private String uid;
  
  public CleanDialySubmit(String paramString1, String paramString2, String paramString3, double paramDouble, String paramString4, int paramInt1, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15)
  {
    this.signature = paramString1;
    this.serviceInfoId = paramString2;
    this.servicePmId = paramString3;
    this.price = paramDouble;
    this.appointDate = paramString4;
    this.appointTime = paramInt1;
    this.address = paramString5;
    this.addressXY = paramString6;
    this.remark = paramString7;
    this.uid = paramString8;
    this.dataSource = paramInt2;
    this.houseSource = paramString9;
    this.rentContract = paramString10;
    this.hireContract = paramString11;
    this.linkman = paramString12;
    this.linkPhone = paramString13;
    this.timestamp = paramString14;
    this.promoCodeId = paramString15;
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getAddressXY()
  {
    return this.addressXY;
  }
  
  public String getAppointDate()
  {
    return this.appointDate;
  }
  
  public int getAppointTime()
  {
    return this.appointTime;
  }
  
  public int getDataSource()
  {
    return this.dataSource;
  }
  
  public String getHireContract()
  {
    return this.hireContract;
  }
  
  public String getHouseSource()
  {
    return this.houseSource;
  }
  
  public String getLinkPhone()
  {
    return this.linkPhone;
  }
  
  public String getLinkman()
  {
    return this.linkman;
  }
  
  public double getPrice()
  {
    return this.price;
  }
  
  public String getPromoCodeId()
  {
    return this.promoCodeId;
  }
  
  public String getRemark()
  {
    return this.remark;
  }
  
  public String getRentContract()
  {
    return this.rentContract;
  }
  
  public String getServiceInfoId()
  {
    return this.serviceInfoId;
  }
  
  public String getServicePmId()
  {
    return this.servicePmId;
  }
  
  public String getSignature()
  {
    return this.signature;
  }
  
  public String getTimestamp()
  {
    return this.timestamp;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setAddressXY(String paramString)
  {
    this.addressXY = paramString;
  }
  
  public void setAppointDate(String paramString)
  {
    this.appointDate = paramString;
  }
  
  public void setAppointTime(int paramInt)
  {
    this.appointTime = paramInt;
  }
  
  public void setDataSource(int paramInt)
  {
    this.dataSource = paramInt;
  }
  
  public void setHireContract(String paramString)
  {
    this.hireContract = paramString;
  }
  
  public void setHouseSource(String paramString)
  {
    this.houseSource = paramString;
  }
  
  public void setLinkPhone(String paramString)
  {
    this.linkPhone = paramString;
  }
  
  public void setLinkman(String paramString)
  {
    this.linkman = paramString;
  }
  
  public void setPrice(double paramDouble)
  {
    this.price = paramDouble;
  }
  
  public void setPromoCodeId(String paramString)
  {
    this.promoCodeId = paramString;
  }
  
  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }
  
  public void setRentContract(String paramString)
  {
    this.rentContract = paramString;
  }
  
  public void setServiceInfoId(String paramString)
  {
    this.serviceInfoId = paramString;
  }
  
  public void setServicePmId(String paramString)
  {
    this.servicePmId = paramString;
  }
  
  public void setSignature(String paramString)
  {
    this.signature = paramString;
  }
  
  public void setTimestamp(String paramString)
  {
    this.timestamp = paramString;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/CleanDialySubmit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */