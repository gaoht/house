package com.ziroom.ziroomcustomer.model;

public class MyAppoint
  implements Comparable<MyAppoint>
{
  private String appointAddr;
  private String appointStatus;
  private String appointStatusZra;
  private String appointTime;
  private String area;
  private String bedroom;
  private String bizCircleName;
  private String createTime;
  private String floor;
  private String houseCode;
  private String houseId;
  private String houseNumber;
  private String housePhoto;
  private String houseStatus;
  private String houseType;
  private String isEvaluate = "1";
  private String keeperHeadCorn;
  private String keeperId;
  private String keeperName;
  private String keeperPhone;
  private String number;
  private String orderId;
  private String orderKey;
  private String orderNum;
  private int orderType;
  private String rent;
  private String rentUnit;
  private String source;
  private String tokenId;
  private String viewEvaluate;
  private String villageId;
  private String villageName;
  
  public int compareTo(MyAppoint paramMyAppoint)
  {
    int i = Integer.parseInt(getCreateTime());
    int j = Integer.parseInt(paramMyAppoint.getCreateTime());
    if (i < j) {
      return 1;
    }
    if (i > j) {
      return -1;
    }
    return 0;
  }
  
  public String getAppointAddr()
  {
    return this.appointAddr;
  }
  
  public String getAppointStatus()
  {
    return this.appointStatus;
  }
  
  public String getAppointStatusZra()
  {
    return this.appointStatusZra;
  }
  
  public String getAppointTime()
  {
    return this.appointTime;
  }
  
  public String getArea()
  {
    return this.area;
  }
  
  public String getBedroom()
  {
    return this.bedroom;
  }
  
  public String getBizCircleName()
  {
    return this.bizCircleName;
  }
  
  public String getCreateTime()
  {
    return this.createTime;
  }
  
  public String getFloor()
  {
    return this.floor;
  }
  
  public String getHouseCode()
  {
    return this.houseCode;
  }
  
  public String getHouseId()
  {
    return this.houseId;
  }
  
  public String getHouseNumber()
  {
    return this.houseNumber;
  }
  
  public String getHousePhoto()
  {
    return this.housePhoto;
  }
  
  public String getHouseStatus()
  {
    return this.houseStatus;
  }
  
  public String getHouseType()
  {
    return this.houseType;
  }
  
  public String getIsEvaluate()
  {
    return this.isEvaluate;
  }
  
  public String getKeeperHeadCorn()
  {
    return this.keeperHeadCorn;
  }
  
  public String getKeeperId()
  {
    return this.keeperId;
  }
  
  public String getKeeperName()
  {
    return this.keeperName;
  }
  
  public String getKeeperPhone()
  {
    return this.keeperPhone;
  }
  
  public String getNumber()
  {
    return this.number;
  }
  
  public String getOrderId()
  {
    return this.orderId;
  }
  
  public String getOrderKey()
  {
    return this.orderKey;
  }
  
  public String getOrderNum()
  {
    return this.orderNum;
  }
  
  public int getOrderType()
  {
    return this.orderType;
  }
  
  public String getRent()
  {
    return this.rent;
  }
  
  public String getRentUnit()
  {
    return this.rentUnit;
  }
  
  public String getSource()
  {
    return this.source;
  }
  
  public String getTokenId()
  {
    return this.tokenId;
  }
  
  public String getViewEvaluate()
  {
    return this.viewEvaluate;
  }
  
  public String getVillageId()
  {
    return this.villageId;
  }
  
  public String getVillageName()
  {
    return this.villageName;
  }
  
  public void setAppointAddr(String paramString)
  {
    this.appointAddr = paramString;
  }
  
  public void setAppointStatus(String paramString)
  {
    this.appointStatus = paramString;
  }
  
  public void setAppointStatusZra(String paramString)
  {
    this.appointStatusZra = paramString;
  }
  
  public void setAppointTime(String paramString)
  {
    this.appointTime = paramString;
  }
  
  public void setArea(String paramString)
  {
    this.area = paramString;
  }
  
  public void setBedroom(String paramString)
  {
    this.bedroom = paramString;
  }
  
  public void setBizCircleName(String paramString)
  {
    this.bizCircleName = paramString;
  }
  
  public void setCreateTime(String paramString)
  {
    this.createTime = paramString;
  }
  
  public void setFloor(String paramString)
  {
    this.floor = paramString;
  }
  
  public void setHouseCode(String paramString)
  {
    this.houseCode = paramString;
  }
  
  public void setHouseId(String paramString)
  {
    this.houseId = paramString;
  }
  
  public void setHouseNumber(String paramString)
  {
    this.houseNumber = paramString;
  }
  
  public void setHousePhoto(String paramString)
  {
    this.housePhoto = paramString;
  }
  
  public void setHouseStatus(String paramString)
  {
    this.houseStatus = paramString;
  }
  
  public void setHouseType(String paramString)
  {
    this.houseType = paramString;
  }
  
  public void setIsEvaluate(String paramString)
  {
    this.isEvaluate = paramString;
  }
  
  public void setKeeperHeadCorn(String paramString)
  {
    this.keeperHeadCorn = paramString;
  }
  
  public void setKeeperId(String paramString)
  {
    this.keeperId = paramString;
  }
  
  public void setKeeperName(String paramString)
  {
    this.keeperName = paramString;
  }
  
  public void setKeeperPhone(String paramString)
  {
    this.keeperPhone = paramString;
  }
  
  public void setNumber(String paramString)
  {
    this.number = paramString;
  }
  
  public void setOrderId(String paramString)
  {
    this.orderId = paramString;
  }
  
  public void setOrderKey(String paramString)
  {
    this.orderKey = paramString;
  }
  
  public void setOrderNum(String paramString)
  {
    this.orderNum = paramString;
  }
  
  public void setOrderType(int paramInt)
  {
    this.orderType = paramInt;
  }
  
  public void setRent(String paramString)
  {
    this.rent = paramString;
  }
  
  public void setRentUnit(String paramString)
  {
    this.rentUnit = paramString;
  }
  
  public void setSource(String paramString)
  {
    this.source = paramString;
  }
  
  public void setTokenId(String paramString)
  {
    this.tokenId = paramString;
  }
  
  public void setViewEvaluate(String paramString)
  {
    this.viewEvaluate = paramString;
  }
  
  public void setVillageId(String paramString)
  {
    this.villageId = paramString;
  }
  
  public void setVillageName(String paramString)
  {
    this.villageName = paramString;
  }
  
  public String toString()
  {
    return "MyAppoint{orderId='" + this.orderId + '\'' + ", orderType=" + this.orderType + ", keeperName='" + this.keeperName + '\'' + ", keeperId='" + this.keeperId + '\'' + ", keeperPhone='" + this.keeperPhone + '\'' + ", keeperHeadCorn='" + this.keeperHeadCorn + '\'' + ", houseId='" + this.houseId + '\'' + ", houseCode='" + this.houseCode + '\'' + ", houseType='" + this.houseType + '\'' + ", appointTime='" + this.appointTime + '\'' + ", appointAddr='" + this.appointAddr + '\'' + ", appointStatus='" + this.appointStatus + '\'' + ", housePhoto='" + this.housePhoto + '\'' + ", bizCircleName='" + this.bizCircleName + '\'' + ", villageName='" + this.villageName + '\'' + ", number='" + this.number + '\'' + ", bedroom='" + this.bedroom + '\'' + ", floor='" + this.floor + '\'' + ", area='" + this.area + '\'' + ", rent='" + this.rent + '\'' + ", rentUnit='" + this.rentUnit + '\'' + ", houseStatus='" + this.houseStatus + '\'' + ", isEvaluate='" + this.isEvaluate + '\'' + ", villageId='" + this.villageId + '\'' + ", houseNumber='" + this.houseNumber + '\'' + ", createTime='" + this.createTime + '\'' + ", appointStatusZra='" + this.appointStatusZra + '\'' + ", source='" + this.source + '\'' + ", tokenId='" + this.tokenId + '\'' + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/MyAppoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */