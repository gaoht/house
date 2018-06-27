package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class HouseBillInfoEntity
  implements Serializable
{
  private String activeNames;
  private String activeTotalMoneyView;
  private List<ActualPayData> actualPayList;
  private List<String> billNumList;
  private String contractStrategy;
  private List<HousePayCost> costList;
  private HouseInfoMessage houseInfo;
  private String isChangePay;
  private String isChangePayEasyPay;
  private int isConfirmDisplay;
  private int isEasyPay;
  private String loanCode;
  private String loanType;
  private String minPayMoney;
  private String minPayMoneyEasyPay;
  private String minPayMoneyEasyPayView;
  private String minPayMoneyView;
  private String normInt;
  private String origInt;
  private String payLimitTime;
  private String payRemindDesc;
  private String payStatus;
  private String popupMsg;
  private String productCode;
  private String shouldPayDate;
  private float surplusShouldPay;
  private float surplusShouldPayEasyPay;
  private String surplusShouldPayEasyPayView;
  private String surplusShouldPayView;
  private String systemId;
  private String totalActualPayFeeView;
  private String totalShouldPayView;
  
  public String getActiveNames()
  {
    return this.activeNames;
  }
  
  public String getActiveTotalMoneyView()
  {
    return this.activeTotalMoneyView;
  }
  
  public List<ActualPayData> getActualPayList()
  {
    return this.actualPayList;
  }
  
  public List<String> getBillNumList()
  {
    return this.billNumList;
  }
  
  public String getContractStrategy()
  {
    return this.contractStrategy;
  }
  
  public List<HousePayCost> getCostList()
  {
    return this.costList;
  }
  
  public HouseInfoMessage getHouseInfo()
  {
    return this.houseInfo;
  }
  
  public String getIsChangePay()
  {
    return this.isChangePay;
  }
  
  public String getIsChangePayEasyPay()
  {
    return this.isChangePayEasyPay;
  }
  
  public int getIsConfirmDisplay()
  {
    return this.isConfirmDisplay;
  }
  
  public int getIsEasyPay()
  {
    return this.isEasyPay;
  }
  
  public String getLoanCode()
  {
    return this.loanCode;
  }
  
  public String getLoanType()
  {
    return this.loanType;
  }
  
  public String getMinPayMoney()
  {
    return this.minPayMoney;
  }
  
  public String getMinPayMoneyEasyPay()
  {
    return this.minPayMoneyEasyPay;
  }
  
  public String getMinPayMoneyEasyPayView()
  {
    return this.minPayMoneyEasyPayView;
  }
  
  public String getMinPayMoneyView()
  {
    return this.minPayMoneyView;
  }
  
  public String getNormInt()
  {
    return this.normInt;
  }
  
  public String getOrigInt()
  {
    return this.origInt;
  }
  
  public String getPayLimitTime()
  {
    return this.payLimitTime;
  }
  
  public String getPayRemindDesc()
  {
    return this.payRemindDesc;
  }
  
  public String getPayStatus()
  {
    return this.payStatus;
  }
  
  public String getPopupMsg()
  {
    return this.popupMsg;
  }
  
  public String getProductCode()
  {
    return this.productCode;
  }
  
  public String getShouldPayDate()
  {
    return this.shouldPayDate;
  }
  
  public float getSurplusShouldPay()
  {
    return this.surplusShouldPay;
  }
  
  public float getSurplusShouldPayEasyPay()
  {
    return this.surplusShouldPayEasyPay;
  }
  
  public String getSurplusShouldPayEasyPayView()
  {
    return this.surplusShouldPayEasyPayView;
  }
  
  public String getSurplusShouldPayView()
  {
    return this.surplusShouldPayView;
  }
  
  public String getSystemId()
  {
    return this.systemId;
  }
  
  public String getTotalActualPayFeeView()
  {
    return this.totalActualPayFeeView;
  }
  
  public String getTotalShouldPayView()
  {
    return this.totalShouldPayView;
  }
  
  public void setActiveNames(String paramString)
  {
    this.activeNames = paramString;
  }
  
  public void setActiveTotalMoneyView(String paramString)
  {
    this.activeTotalMoneyView = paramString;
  }
  
  public void setActualPayList(List<ActualPayData> paramList)
  {
    this.actualPayList = paramList;
  }
  
  public void setBillNumList(List<String> paramList)
  {
    this.billNumList = paramList;
  }
  
  public void setContractStrategy(String paramString)
  {
    this.contractStrategy = paramString;
  }
  
  public void setCostList(List<HousePayCost> paramList)
  {
    this.costList = paramList;
  }
  
  public void setHouseInfo(HouseInfoMessage paramHouseInfoMessage)
  {
    this.houseInfo = paramHouseInfoMessage;
  }
  
  public void setIsChangePay(String paramString)
  {
    this.isChangePay = paramString;
  }
  
  public void setIsChangePayEasyPay(String paramString)
  {
    this.isChangePayEasyPay = paramString;
  }
  
  public void setIsConfirmDisplay(int paramInt)
  {
    this.isConfirmDisplay = paramInt;
  }
  
  public void setIsEasyPay(int paramInt)
  {
    this.isEasyPay = paramInt;
  }
  
  public void setLoanCode(String paramString)
  {
    this.loanCode = paramString;
  }
  
  public void setLoanType(String paramString)
  {
    this.loanType = paramString;
  }
  
  public void setMinPayMoney(String paramString)
  {
    this.minPayMoney = paramString;
  }
  
  public void setMinPayMoneyEasyPay(String paramString)
  {
    this.minPayMoneyEasyPay = paramString;
  }
  
  public void setMinPayMoneyEasyPayView(String paramString)
  {
    this.minPayMoneyEasyPayView = paramString;
  }
  
  public void setMinPayMoneyView(String paramString)
  {
    this.minPayMoneyView = paramString;
  }
  
  public void setNormInt(String paramString)
  {
    this.normInt = paramString;
  }
  
  public void setOrigInt(String paramString)
  {
    this.origInt = paramString;
  }
  
  public void setPayLimitTime(String paramString)
  {
    this.payLimitTime = paramString;
  }
  
  public void setPayRemindDesc(String paramString)
  {
    this.payRemindDesc = paramString;
  }
  
  public void setPayStatus(String paramString)
  {
    this.payStatus = paramString;
  }
  
  public void setPopupMsg(String paramString)
  {
    this.popupMsg = paramString;
  }
  
  public void setProductCode(String paramString)
  {
    this.productCode = paramString;
  }
  
  public void setShouldPayDate(String paramString)
  {
    this.shouldPayDate = paramString;
  }
  
  public void setSurplusShouldPay(float paramFloat)
  {
    this.surplusShouldPay = paramFloat;
  }
  
  public void setSurplusShouldPayEasyPay(float paramFloat)
  {
    this.surplusShouldPayEasyPay = paramFloat;
  }
  
  public void setSurplusShouldPayEasyPayView(String paramString)
  {
    this.surplusShouldPayEasyPayView = paramString;
  }
  
  public void setSurplusShouldPayView(String paramString)
  {
    this.surplusShouldPayView = paramString;
  }
  
  public void setSystemId(String paramString)
  {
    this.systemId = paramString;
  }
  
  public void setTotalActualPayFeeView(String paramString)
  {
    this.totalActualPayFeeView = paramString;
  }
  
  public void setTotalShouldPayView(String paramString)
  {
    this.totalShouldPayView = paramString;
  }
  
  public class ActualPayData
    implements Serializable
  {
    private String actualPayFee;
    private String payTime;
    
    public ActualPayData() {}
    
    public String getActualPayFee()
    {
      return this.actualPayFee;
    }
    
    public String getPayTime()
    {
      return this.payTime;
    }
    
    public void setActualPayFee(String paramString)
    {
      this.actualPayFee = paramString;
    }
    
    public void setPayTime(String paramString)
    {
      this.payTime = paramString;
    }
  }
  
  public class HouseInfoMessage
    implements Serializable
  {
    private String houseAddress;
    private String houseArea;
    private String housePrice;
    private String houseTypeStr;
    private String picUrl;
    private String priceUnit;
    private String roomName;
    
    public HouseInfoMessage() {}
    
    public String getHouseAddress()
    {
      return this.houseAddress;
    }
    
    public String getHouseArea()
    {
      return this.houseArea;
    }
    
    public String getHousePrice()
    {
      return this.housePrice;
    }
    
    public String getHouseTypeStr()
    {
      return this.houseTypeStr;
    }
    
    public String getPicUrl()
    {
      return this.picUrl;
    }
    
    public String getPriceUnit()
    {
      return this.priceUnit;
    }
    
    public String getRoomName()
    {
      return this.roomName;
    }
    
    public void setHouseAddress(String paramString)
    {
      this.houseAddress = paramString;
    }
    
    public void setHouseArea(String paramString)
    {
      this.houseArea = paramString;
    }
    
    public void setHousePrice(String paramString)
    {
      this.housePrice = paramString;
    }
    
    public void setHouseTypeStr(String paramString)
    {
      this.houseTypeStr = paramString;
    }
    
    public void setPicUrl(String paramString)
    {
      this.picUrl = paramString;
    }
    
    public void setPriceUnit(String paramString)
    {
      this.priceUnit = paramString;
    }
    
    public void setRoomName(String paramString)
    {
      this.roomName = paramString;
    }
  }
  
  public class HousePayCost
    implements Serializable
  {
    private String costName;
    private String costShouldPayView;
    
    public HousePayCost() {}
    
    public String getCostName()
    {
      return this.costName;
    }
    
    public String getCostShouldPayView()
    {
      return this.costShouldPayView;
    }
    
    public void setCostName(String paramString)
    {
      this.costName = paramString;
    }
    
    public void setCostShouldPayView(String paramString)
    {
      this.costShouldPayView = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/HouseBillInfoEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */