package com.ziroom.ziroomcustomer.model;

import com.alibaba.fastjson.e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LeaseInfo
  implements Serializable
{
  private List<GiftList> GiftList;
  private String address;
  private LeaseCaseRecordEntity caseRecord;
  private String comeFrom;
  private e contactKeeperInfo;
  private String contractCode;
  private String contractState;
  private List<String> contractStayManStrList;
  private String contractStrategy;
  private String contractType;
  private String contractUrl;
  private String effectDate;
  private String firstLeftFee;
  private String haveJointRent;
  private String houseCode;
  private String houseId;
  private String houseType;
  private int id;
  private int isBindContract;
  private int isBindUid;
  private String isBlank;
  private String isChangeSign;
  private String isRenew;
  private int isRentback;
  private String isShort;
  private int isView;
  private int isZWhite;
  private String oldContractCode;
  private String payFeeSource;
  private List<LeasePayPlan> payPlan;
  private ArrayList<String> payTypeList;
  private String paymentType;
  private float price;
  private String priceUnit;
  private String propertyState;
  private String roomCode;
  private String roomName;
  private List<String> signSubjectStrList;
  private String stayManDesc;
  private String stopDate;
  private String subjectDesc;
  private String sysContractId = "";
  private List<String> tips;
  private String uid;
  private String waitingPayRemind;
  
  public String getAddress()
  {
    return this.address;
  }
  
  public LeaseCaseRecordEntity getCaseRecord()
  {
    return this.caseRecord;
  }
  
  public String getComeFrom()
  {
    return this.comeFrom;
  }
  
  public e getContactKeeperInfo()
  {
    return this.contactKeeperInfo;
  }
  
  public String getContractCode()
  {
    return this.contractCode;
  }
  
  public String getContractState()
  {
    return this.contractState;
  }
  
  public List<String> getContractStayManStrList()
  {
    return this.contractStayManStrList;
  }
  
  public String getContractStrategy()
  {
    return this.contractStrategy;
  }
  
  public String getContractType()
  {
    return this.contractType;
  }
  
  public String getContractUrl()
  {
    return this.contractUrl;
  }
  
  public String getEffectDate()
  {
    return this.effectDate;
  }
  
  public String getFirstLeftFee()
  {
    return this.firstLeftFee;
  }
  
  public List<GiftList> getGiftList()
  {
    return this.GiftList;
  }
  
  public String getHaveJointRent()
  {
    return this.haveJointRent;
  }
  
  public String getHouseCode()
  {
    return this.houseCode;
  }
  
  public String getHouseId()
  {
    return this.houseId;
  }
  
  public String getHouseType()
  {
    return this.houseType;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public int getIsBindContract()
  {
    return this.isBindContract;
  }
  
  public int getIsBindUid()
  {
    return this.isBindUid;
  }
  
  public String getIsBlank()
  {
    return this.isBlank;
  }
  
  public String getIsChangeSign()
  {
    return this.isChangeSign;
  }
  
  public String getIsRenew()
  {
    return this.isRenew;
  }
  
  public int getIsRentback()
  {
    return this.isRentback;
  }
  
  public String getIsShort()
  {
    return this.isShort;
  }
  
  public int getIsView()
  {
    return this.isView;
  }
  
  public int getIsZWhite()
  {
    return this.isZWhite;
  }
  
  public String getOldContractCode()
  {
    return this.oldContractCode;
  }
  
  public String getPayFeeSource()
  {
    return this.payFeeSource;
  }
  
  public List<LeasePayPlan> getPayPlan()
  {
    return this.payPlan;
  }
  
  public ArrayList<String> getPayTypeList()
  {
    return this.payTypeList;
  }
  
  public String getPaymentType()
  {
    return this.paymentType;
  }
  
  public float getPrice()
  {
    return this.price;
  }
  
  public String getPriceUnit()
  {
    return this.priceUnit;
  }
  
  public String getPropertyState()
  {
    return this.propertyState;
  }
  
  public String getRoomCode()
  {
    return this.roomCode;
  }
  
  public String getRoomName()
  {
    return this.roomName;
  }
  
  public List<String> getSignSubjectStrList()
  {
    return this.signSubjectStrList;
  }
  
  public String getStayManDesc()
  {
    return this.stayManDesc;
  }
  
  public String getStopDate()
  {
    return this.stopDate;
  }
  
  public String getSubjectDesc()
  {
    return this.subjectDesc;
  }
  
  public String getSysContractId()
  {
    return this.sysContractId;
  }
  
  public List<String> getTips()
  {
    return this.tips;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public String getWaitingPayRemind()
  {
    return this.waitingPayRemind;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setCaseRecord(LeaseCaseRecordEntity paramLeaseCaseRecordEntity)
  {
    this.caseRecord = paramLeaseCaseRecordEntity;
  }
  
  public void setComeFrom(String paramString)
  {
    this.comeFrom = paramString;
  }
  
  public void setContactKeeperInfo(e parame)
  {
    this.contactKeeperInfo = parame;
  }
  
  public void setContractCode(String paramString)
  {
    this.contractCode = paramString;
  }
  
  public void setContractState(String paramString)
  {
    this.contractState = paramString;
  }
  
  public void setContractStayManStrList(List<String> paramList)
  {
    this.contractStayManStrList = paramList;
  }
  
  public void setContractStrategy(String paramString)
  {
    this.contractStrategy = paramString;
  }
  
  public void setContractType(String paramString)
  {
    this.contractType = paramString;
  }
  
  public void setContractUrl(String paramString)
  {
    this.contractUrl = paramString;
  }
  
  public void setEffectDate(String paramString)
  {
    this.effectDate = paramString;
  }
  
  public void setFirstLeftFee(String paramString)
  {
    this.firstLeftFee = paramString;
  }
  
  public void setGiftList(List<GiftList> paramList)
  {
    this.GiftList = paramList;
  }
  
  public void setHaveJointRent(String paramString)
  {
    this.haveJointRent = paramString;
  }
  
  public void setHouseCode(String paramString)
  {
    this.houseCode = paramString;
  }
  
  public void setHouseId(String paramString)
  {
    this.houseId = paramString;
  }
  
  public void setHouseType(String paramString)
  {
    this.houseType = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setIsBindContract(int paramInt)
  {
    this.isBindContract = paramInt;
  }
  
  public void setIsBindUid(int paramInt)
  {
    this.isBindUid = paramInt;
  }
  
  public void setIsBlank(String paramString)
  {
    this.isBlank = paramString;
  }
  
  public void setIsChangeSign(String paramString)
  {
    this.isChangeSign = paramString;
  }
  
  public void setIsRenew(String paramString)
  {
    this.isRenew = paramString;
  }
  
  public void setIsRentback(int paramInt)
  {
    this.isRentback = paramInt;
  }
  
  public void setIsShort(String paramString)
  {
    this.isShort = paramString;
  }
  
  public void setIsView(int paramInt)
  {
    this.isView = paramInt;
  }
  
  public void setIsZWhite(int paramInt)
  {
    this.isZWhite = paramInt;
  }
  
  public void setOldContractCode(String paramString)
  {
    this.oldContractCode = paramString;
  }
  
  public void setPayFeeSource(String paramString)
  {
    this.payFeeSource = paramString;
  }
  
  public void setPayPlan(List<LeasePayPlan> paramList)
  {
    this.payPlan = paramList;
  }
  
  public void setPayTypeList(ArrayList<String> paramArrayList)
  {
    this.payTypeList = paramArrayList;
  }
  
  public void setPaymentType(String paramString)
  {
    this.paymentType = paramString;
  }
  
  public void setPrice(float paramFloat)
  {
    this.price = paramFloat;
  }
  
  public void setPriceUnit(String paramString)
  {
    this.priceUnit = paramString;
  }
  
  public void setPropertyState(String paramString)
  {
    this.propertyState = paramString;
  }
  
  public void setRoomCode(String paramString)
  {
    this.roomCode = paramString;
  }
  
  public void setRoomName(String paramString)
  {
    this.roomName = paramString;
  }
  
  public void setSignSubjectStrList(List<String> paramList)
  {
    this.signSubjectStrList = paramList;
  }
  
  public void setStayManDesc(String paramString)
  {
    this.stayManDesc = paramString;
  }
  
  public void setStopDate(String paramString)
  {
    this.stopDate = paramString;
  }
  
  public void setSubjectDesc(String paramString)
  {
    this.subjectDesc = paramString;
  }
  
  public void setSysContractId(String paramString)
  {
    this.sysContractId = paramString;
  }
  
  public void setTips(List<String> paramList)
  {
    this.tips = paramList;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
  
  public void setWaitingPayRemind(String paramString)
  {
    this.waitingPayRemind = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/LeaseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */