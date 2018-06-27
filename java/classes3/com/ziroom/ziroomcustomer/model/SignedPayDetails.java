package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class SignedPayDetails
  implements Serializable
{
  private String address;
  private Integer alreadyCount;
  private float alreadyPrice;
  private int balance;
  private float commission;
  private String contractCode;
  private String contractStrategy;
  private float countPrice;
  private float deposit;
  private List<GiftList> giftList;
  private String houseCode;
  private String houseId;
  private String houseType;
  private int isBlank;
  private int isCard;
  private String isZWhite;
  private String lockTime;
  private List<String> payTypeList;
  private int periods;
  private long remainderPayTime;
  private int reserveFirstPay;
  private float shouldPrice;
  private String sysContractId;
  
  public SignedPayDetails() {}
  
  public SignedPayDetails(String paramString1, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString2, String paramString3, Integer paramInteger, List<GiftList> paramList)
  {
    this.contractCode = paramString1;
    this.periods = paramInt1;
    this.shouldPrice = paramFloat1;
    this.alreadyPrice = paramFloat2;
    this.isCard = paramInt2;
    this.isBlank = paramInt3;
    this.address = paramString2;
    this.sysContractId = paramString3;
    this.alreadyCount = paramInteger;
    this.countPrice = (paramFloat1 - paramFloat2);
    this.giftList = paramList;
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public Integer getAlreadyCount()
  {
    return this.alreadyCount;
  }
  
  public float getAlreadyPrice()
  {
    return this.alreadyPrice;
  }
  
  public int getBalance()
  {
    return this.balance;
  }
  
  public float getCommission()
  {
    return this.commission;
  }
  
  public String getContractCode()
  {
    return this.contractCode;
  }
  
  public String getContractStrategy()
  {
    return this.contractStrategy;
  }
  
  public float getCountPrice()
  {
    return this.countPrice;
  }
  
  public float getDeposit()
  {
    return this.deposit;
  }
  
  public List<GiftList> getGiftList()
  {
    return this.giftList;
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
  
  public int getIsBlank()
  {
    return this.isBlank;
  }
  
  public int getIsCard()
  {
    return this.isCard;
  }
  
  public String getIsZWhite()
  {
    return this.isZWhite;
  }
  
  public String getLockTime()
  {
    return this.lockTime;
  }
  
  public List<String> getPayTypeList()
  {
    return this.payTypeList;
  }
  
  public int getPeriods()
  {
    return this.periods;
  }
  
  public long getRemainderPayTime()
  {
    return this.remainderPayTime;
  }
  
  public int getReserveFirstPay()
  {
    return this.reserveFirstPay;
  }
  
  public float getShouldPrice()
  {
    return this.shouldPrice;
  }
  
  public String getSysContractId()
  {
    return this.sysContractId;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setAlreadyCount(Integer paramInteger)
  {
    this.alreadyCount = paramInteger;
  }
  
  public void setAlreadyPrice(float paramFloat)
  {
    this.alreadyPrice = paramFloat;
  }
  
  public void setBalance(int paramInt)
  {
    this.balance = paramInt;
  }
  
  public void setCommission(float paramFloat)
  {
    this.commission = paramFloat;
  }
  
  public void setContractCode(String paramString)
  {
    this.contractCode = paramString;
  }
  
  public void setContractStrategy(String paramString)
  {
    this.contractStrategy = paramString;
  }
  
  public void setCountPrice(float paramFloat)
  {
    this.countPrice = paramFloat;
  }
  
  public void setDeposit(float paramFloat)
  {
    this.deposit = paramFloat;
  }
  
  public void setGiftList(List<GiftList> paramList)
  {
    this.giftList = paramList;
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
  
  public void setIsBlank(int paramInt)
  {
    this.isBlank = paramInt;
  }
  
  public void setIsCard(int paramInt)
  {
    this.isCard = paramInt;
  }
  
  public void setIsZWhite(String paramString)
  {
    this.isZWhite = paramString;
  }
  
  public void setLockTime(String paramString)
  {
    this.lockTime = paramString;
  }
  
  public void setPayTypeList(List<String> paramList)
  {
    this.payTypeList = paramList;
  }
  
  public void setPeriods(int paramInt)
  {
    this.periods = paramInt;
  }
  
  public void setRemainderPayTime(long paramLong)
  {
    this.remainderPayTime = paramLong;
  }
  
  public void setReserveFirstPay(int paramInt)
  {
    this.reserveFirstPay = paramInt;
  }
  
  public void setShouldPrice(float paramFloat)
  {
    this.shouldPrice = paramFloat;
  }
  
  public void setSysContractId(String paramString)
  {
    this.sysContractId = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/SignedPayDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */