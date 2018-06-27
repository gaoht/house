package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import java.util.List;

public class ZryuSignBillItem
{
  private String contractCode;
  private List<ZryuSignBillItemTime> list;
  private String period;
  private String projectAddress;
  private String receivableAmount;
  private String receivedAmount;
  private String receivedNum;
  private String tips;
  
  public String getContractCode()
  {
    return this.contractCode;
  }
  
  public List<ZryuSignBillItemTime> getList()
  {
    return this.list;
  }
  
  public String getPeriod()
  {
    return this.period;
  }
  
  public String getProjectAddress()
  {
    return this.projectAddress;
  }
  
  public String getReceivableAmount()
  {
    return this.receivableAmount;
  }
  
  public String getReceivedAmount()
  {
    return this.receivedAmount;
  }
  
  public String getReceivedNum()
  {
    return this.receivedNum;
  }
  
  public String getTips()
  {
    return this.tips;
  }
  
  public void setContractCode(String paramString)
  {
    this.contractCode = paramString;
  }
  
  public void setList(List<ZryuSignBillItemTime> paramList)
  {
    this.list = paramList;
  }
  
  public void setPeriod(String paramString)
  {
    this.period = paramString;
  }
  
  public void setProjectAddress(String paramString)
  {
    this.projectAddress = paramString;
  }
  
  public void setReceivableAmount(String paramString)
  {
    this.receivableAmount = paramString;
  }
  
  public void setReceivedAmount(String paramString)
  {
    this.receivedAmount = paramString;
  }
  
  public void setReceivedNum(String paramString)
  {
    this.receivedNum = paramString;
  }
  
  public void setTips(String paramString)
  {
    this.tips = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuSignBillItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */