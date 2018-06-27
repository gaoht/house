package com.ziroom.ziroomcustomer.my.model;

import java.util.List;

public class FInvoiceListModel
{
  public String addr;
  public String applyNo;
  public int busType;
  public String busTypeName;
  public boolean cancelApply;
  public String contractCode;
  public String deadLineTime;
  public List<InfoListBean> infoList;
  public int payAmount;
  public boolean payButton;
  public int payTimeOut;
  public String receivableNum;
  public String statusCode;
  public String statusName;
  public String systemId;
  
  public String getAddr()
  {
    return this.addr;
  }
  
  public String getApplyNo()
  {
    return this.applyNo;
  }
  
  public int getBusType()
  {
    return this.busType;
  }
  
  public String getBusTypeName()
  {
    return this.busTypeName;
  }
  
  public String getContractCode()
  {
    return this.contractCode;
  }
  
  public String getDeadLineTime()
  {
    return this.deadLineTime;
  }
  
  public List<InfoListBean> getInfoList()
  {
    return this.infoList;
  }
  
  public int getPayAmount()
  {
    return this.payAmount;
  }
  
  public int getPayTimeOut()
  {
    return this.payTimeOut;
  }
  
  public String getReceivableNum()
  {
    return this.receivableNum;
  }
  
  public String getStatusCode()
  {
    return this.statusCode;
  }
  
  public String getStatusName()
  {
    return this.statusName;
  }
  
  public String getSystemId()
  {
    return this.systemId;
  }
  
  public boolean isCancelApply()
  {
    return this.cancelApply;
  }
  
  public boolean isPayButton()
  {
    return this.payButton;
  }
  
  public void setAddr(String paramString)
  {
    this.addr = paramString;
  }
  
  public void setApplyNo(String paramString)
  {
    this.applyNo = paramString;
  }
  
  public void setBusType(int paramInt)
  {
    this.busType = paramInt;
  }
  
  public void setBusTypeName(String paramString)
  {
    this.busTypeName = paramString;
  }
  
  public void setCancelApply(boolean paramBoolean)
  {
    this.cancelApply = paramBoolean;
  }
  
  public void setContractCode(String paramString)
  {
    this.contractCode = paramString;
  }
  
  public void setDeadLineTime(String paramString)
  {
    this.deadLineTime = paramString;
  }
  
  public void setInfoList(List<InfoListBean> paramList)
  {
    this.infoList = paramList;
  }
  
  public void setPayAmount(int paramInt)
  {
    this.payAmount = paramInt;
  }
  
  public void setPayButton(boolean paramBoolean)
  {
    this.payButton = paramBoolean;
  }
  
  public void setPayTimeOut(int paramInt)
  {
    this.payTimeOut = paramInt;
  }
  
  public void setReceivableNum(String paramString)
  {
    this.receivableNum = paramString;
  }
  
  public void setStatusCode(String paramString)
  {
    this.statusCode = paramString;
  }
  
  public void setStatusName(String paramString)
  {
    this.statusName = paramString;
  }
  
  public void setSystemId(String paramString)
  {
    this.systemId = paramString;
  }
  
  public static class InfoListBean
  {
    public String title;
    public String value;
    
    public String getTitle()
    {
      return this.title;
    }
    
    public String getValue()
    {
      return this.value;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public void setValue(String paramString)
    {
      this.value = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/FInvoiceListModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */