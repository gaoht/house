package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import java.io.Serializable;
import java.util.List;

public class ZryuBillInfo
  implements Serializable
{
  private ZryuBillInfoEntity activityInfo;
  private String billNumList;
  private String billType;
  private String contractCode;
  private String contractId;
  private ZryuBillInfoEntity havePayInfo;
  private ZryuBillInfoItem leftPayInfo;
  private long payEndTime;
  private ZryuBillInfoEntity payInfo;
  private ZryuSignProject projectInfo;
  private ZryuBillPayDate shouldPayDate;
  private String signType;
  private String systemId;
  private ThisTimeNeedPay thisTimeNeedPay;
  
  public ZryuBillInfoEntity getActivityInfo()
  {
    return this.activityInfo;
  }
  
  public String getBillNumList()
  {
    return this.billNumList;
  }
  
  public String getBillType()
  {
    return this.billType;
  }
  
  public String getContractCode()
  {
    return this.contractCode;
  }
  
  public String getContractId()
  {
    return this.contractId;
  }
  
  public ZryuBillInfoEntity getHavePayInfo()
  {
    return this.havePayInfo;
  }
  
  public ZryuBillInfoItem getLeftPayInfo()
  {
    return this.leftPayInfo;
  }
  
  public long getPayEndTime()
  {
    return this.payEndTime;
  }
  
  public ZryuBillInfoEntity getPayInfo()
  {
    return this.payInfo;
  }
  
  public ZryuSignProject getProjectInfo()
  {
    return this.projectInfo;
  }
  
  public ZryuBillPayDate getShouldPayDate()
  {
    return this.shouldPayDate;
  }
  
  public String getSignType()
  {
    return this.signType;
  }
  
  public String getSystemId()
  {
    return this.systemId;
  }
  
  public ThisTimeNeedPay getThisTimeNeedPay()
  {
    return this.thisTimeNeedPay;
  }
  
  public void setActivityInfo(ZryuBillInfoEntity paramZryuBillInfoEntity)
  {
    this.activityInfo = paramZryuBillInfoEntity;
  }
  
  public void setBillNumList(String paramString)
  {
    this.billNumList = paramString;
  }
  
  public void setBillType(String paramString)
  {
    this.billType = paramString;
  }
  
  public void setContractCode(String paramString)
  {
    this.contractCode = paramString;
  }
  
  public void setContractId(String paramString)
  {
    this.contractId = paramString;
  }
  
  public void setHavePayInfo(ZryuBillInfoEntity paramZryuBillInfoEntity)
  {
    this.havePayInfo = paramZryuBillInfoEntity;
  }
  
  public void setLeftPayInfo(ZryuBillInfoItem paramZryuBillInfoItem)
  {
    this.leftPayInfo = paramZryuBillInfoItem;
  }
  
  public void setPayEndTime(long paramLong)
  {
    this.payEndTime = paramLong;
  }
  
  public void setPayInfo(ZryuBillInfoEntity paramZryuBillInfoEntity)
  {
    this.payInfo = paramZryuBillInfoEntity;
  }
  
  public void setProjectInfo(ZryuSignProject paramZryuSignProject)
  {
    this.projectInfo = paramZryuSignProject;
  }
  
  public void setShouldPayDate(ZryuBillPayDate paramZryuBillPayDate)
  {
    this.shouldPayDate = paramZryuBillPayDate;
  }
  
  public void setSignType(String paramString)
  {
    this.signType = paramString;
  }
  
  public void setSystemId(String paramString)
  {
    this.systemId = paramString;
  }
  
  public void setThisTimeNeedPay(ThisTimeNeedPay paramThisTimeNeedPay)
  {
    this.thisTimeNeedPay = paramThisTimeNeedPay;
  }
  
  public class ThisTimeNeedPay
    implements Serializable
  {
    private String isChangePay;
    private String isChangePayDesc;
    private String minPayMoney;
    private String minPayMoneyDesc;
    private String name;
    private String needPay;
    private String value;
    
    public ThisTimeNeedPay() {}
    
    public String getIsChangePay()
    {
      return this.isChangePay;
    }
    
    public String getIsChangePayDesc()
    {
      return this.isChangePayDesc;
    }
    
    public String getMinPayMoney()
    {
      return this.minPayMoney;
    }
    
    public String getMinPayMoneyDesc()
    {
      return this.minPayMoneyDesc;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public String getNeedPay()
    {
      return this.needPay;
    }
    
    public String getValue()
    {
      return this.value;
    }
    
    public void setIsChangePay(String paramString)
    {
      this.isChangePay = paramString;
    }
    
    public void setIsChangePayDesc(String paramString)
    {
      this.isChangePayDesc = paramString;
    }
    
    public void setMinPayMoney(String paramString)
    {
      this.minPayMoney = paramString;
    }
    
    public void setMinPayMoneyDesc(String paramString)
    {
      this.minPayMoneyDesc = paramString;
    }
    
    public void setName(String paramString)
    {
      this.name = paramString;
    }
    
    public void setNeedPay(String paramString)
    {
      this.needPay = paramString;
    }
    
    public void setValue(String paramString)
    {
      this.value = paramString;
    }
  }
  
  public class ZryuBillInfoEntity
    implements Serializable
  {
    private List<ZryuBillInfoItem> list;
    private String name;
    private String value;
    
    public ZryuBillInfoEntity() {}
    
    public List<ZryuBillInfoItem> getList()
    {
      return this.list;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public String getValue()
    {
      return this.value;
    }
    
    public void setList(List<ZryuBillInfoItem> paramList)
    {
      this.list = paramList;
    }
    
    public void setName(String paramString)
    {
      this.name = paramString;
    }
    
    public void setValue(String paramString)
    {
      this.value = paramString;
    }
  }
  
  public class ZryuBillPayDate
    implements Serializable
  {
    private String desc;
    private String name;
    private String penaltyWarn;
    private String time;
    private String value;
    
    public ZryuBillPayDate() {}
    
    public String getDesc()
    {
      return this.desc;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public String getPenaltyWarn()
    {
      return this.penaltyWarn;
    }
    
    public String getTime()
    {
      return this.time;
    }
    
    public String getValue()
    {
      return this.value;
    }
    
    public void setDesc(String paramString)
    {
      this.desc = paramString;
    }
    
    public void setName(String paramString)
    {
      this.name = paramString;
    }
    
    public void setPenaltyWarn(String paramString)
    {
      this.penaltyWarn = paramString;
    }
    
    public void setTime(String paramString)
    {
      this.time = paramString;
    }
    
    public void setValue(String paramString)
    {
      this.value = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuBillInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */