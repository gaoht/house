package com.ziroom.ziroomcustomer.model;

import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuContractItem;
import java.io.Serializable;
import java.util.List;

public class LeaseListEntity
  implements Serializable
{
  private int PayOutTimeType;
  private String address;
  private String comeFrom;
  private String contractCode;
  private String contractState;
  private String contractStrategy;
  private String evaluateType;
  private String houseCode;
  private String houseId;
  private String housePic;
  private int houseType;
  private String isBlank;
  private int isCertified;
  private String isEvaluate;
  private String isRenew;
  private int isRentback;
  private int isSublet;
  private int isView;
  private int isZWhite;
  private int isZiroom;
  private int jointRentFlag;
  private String maxPayTime;
  private String moneyUnit;
  private String payFeeSource;
  private String paymentType;
  private float price;
  private String propertyState;
  private String roomCode;
  private String signDate;
  private String stopDate;
  private int sysContractId;
  private List<String> tips;
  private int userInfoFlag;
  private ZryuContractItem zryuContractInfo;
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getComeFrom()
  {
    return this.comeFrom;
  }
  
  public String getContractCode()
  {
    return this.contractCode;
  }
  
  public String getContractState()
  {
    return this.contractState;
  }
  
  public String getContractStrategy()
  {
    return this.contractStrategy;
  }
  
  public String getEvaluateType()
  {
    return this.evaluateType;
  }
  
  public String getHouseCode()
  {
    return this.houseCode;
  }
  
  public String getHouseId()
  {
    return this.houseId;
  }
  
  public String getHousePic()
  {
    return this.housePic;
  }
  
  public int getHouseType()
  {
    return this.houseType;
  }
  
  public String getIsBlank()
  {
    return this.isBlank;
  }
  
  public int getIsCertified()
  {
    return this.isCertified;
  }
  
  public String getIsEvaluate()
  {
    return this.isEvaluate;
  }
  
  public String getIsRenew()
  {
    return this.isRenew;
  }
  
  public int getIsRentback()
  {
    return this.isRentback;
  }
  
  public int getIsSublet()
  {
    return this.isSublet;
  }
  
  public int getIsView()
  {
    return this.isView;
  }
  
  public int getIsZWhite()
  {
    return this.isZWhite;
  }
  
  public int getIsZiroom()
  {
    return this.isZiroom;
  }
  
  public int getJointRentFlag()
  {
    return this.jointRentFlag;
  }
  
  public String getMaxPayTime()
  {
    return this.maxPayTime;
  }
  
  public String getMoneyUnit()
  {
    return this.moneyUnit;
  }
  
  public String getPayFeeSource()
  {
    return this.payFeeSource;
  }
  
  public int getPayOutTimeType()
  {
    return this.PayOutTimeType;
  }
  
  public String getPaymentType()
  {
    return this.paymentType;
  }
  
  public float getPrice()
  {
    return this.price;
  }
  
  public String getPropertyState()
  {
    return this.propertyState;
  }
  
  public String getRoomCode()
  {
    return this.roomCode;
  }
  
  public String getSignDate()
  {
    return this.signDate;
  }
  
  public String getStopDate()
  {
    return this.stopDate;
  }
  
  public int getSysContractId()
  {
    return this.sysContractId;
  }
  
  public List<String> getTips()
  {
    return this.tips;
  }
  
  public int getUserInfoFlag()
  {
    return this.userInfoFlag;
  }
  
  public ZryuContractItem getZryuContractInfo()
  {
    return this.zryuContractInfo;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setComeFrom(String paramString)
  {
    this.comeFrom = paramString;
  }
  
  public void setContractCode(String paramString)
  {
    this.contractCode = paramString;
  }
  
  public void setContractState(String paramString)
  {
    this.contractState = paramString;
  }
  
  public void setContractStrategy(String paramString)
  {
    this.contractStrategy = paramString;
  }
  
  public void setEvaluateType(String paramString)
  {
    this.evaluateType = paramString;
  }
  
  public void setHouseCode(String paramString)
  {
    this.houseCode = paramString;
  }
  
  public void setHouseId(String paramString)
  {
    this.houseId = paramString;
  }
  
  public void setHousePic(String paramString)
  {
    this.housePic = paramString;
  }
  
  public void setHouseType(int paramInt)
  {
    this.houseType = paramInt;
  }
  
  public void setIsBlank(String paramString)
  {
    this.isBlank = paramString;
  }
  
  public void setIsCertified(int paramInt)
  {
    this.isCertified = paramInt;
  }
  
  public void setIsEvaluate(String paramString)
  {
    this.isEvaluate = paramString;
  }
  
  public void setIsRenew(String paramString)
  {
    this.isRenew = paramString;
  }
  
  public void setIsRentback(int paramInt)
  {
    this.isRentback = paramInt;
  }
  
  public void setIsSublet(int paramInt)
  {
    this.isSublet = paramInt;
  }
  
  public void setIsView(int paramInt)
  {
    this.isView = paramInt;
  }
  
  public void setIsZWhite(int paramInt)
  {
    this.isZWhite = paramInt;
  }
  
  public void setIsZiroom(int paramInt)
  {
    this.isZiroom = paramInt;
  }
  
  public void setJointRentFlag(int paramInt)
  {
    this.jointRentFlag = paramInt;
  }
  
  public void setMaxPayTime(String paramString)
  {
    this.maxPayTime = paramString;
  }
  
  public void setMoneyUnit(String paramString)
  {
    this.moneyUnit = paramString;
  }
  
  public void setPayFeeSource(String paramString)
  {
    this.payFeeSource = paramString;
  }
  
  public void setPayOutTimeType(int paramInt)
  {
    this.PayOutTimeType = paramInt;
  }
  
  public void setPaymentType(String paramString)
  {
    this.paymentType = paramString;
  }
  
  public void setPrice(float paramFloat)
  {
    this.price = paramFloat;
  }
  
  public void setPropertyState(String paramString)
  {
    this.propertyState = paramString;
  }
  
  public void setRoomCode(String paramString)
  {
    this.roomCode = paramString;
  }
  
  public void setSignDate(String paramString)
  {
    this.signDate = paramString;
  }
  
  public void setStopDate(String paramString)
  {
    this.stopDate = paramString;
  }
  
  public void setSysContractId(int paramInt)
  {
    this.sysContractId = paramInt;
  }
  
  public void setTips(List<String> paramList)
  {
    this.tips = paramList;
  }
  
  public void setUserInfoFlag(int paramInt)
  {
    this.userInfoFlag = paramInt;
  }
  
  public void setZryuContractInfo(ZryuContractItem paramZryuContractItem)
  {
    this.zryuContractInfo = paramZryuContractItem;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/LeaseListEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */