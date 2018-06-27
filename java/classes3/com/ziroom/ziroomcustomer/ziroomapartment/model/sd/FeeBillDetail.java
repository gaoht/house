package com.ziroom.ziroomcustomer.ziroomapartment.model.sd;

import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignKvItem;
import java.util.List;

public class FeeBillDetail
{
  private String billNum;
  private Integer billStatus;
  private String billStatusTxt;
  private String billTitle;
  private String billType;
  private Integer feeItemType;
  private List<ZryuSignKvItem> itemList;
  private String operation;
  private Integer operationCode;
  private Integer oughtAmount;
  private String systemId;
  
  public String getBillNum()
  {
    return this.billNum;
  }
  
  public Integer getBillStatus()
  {
    return this.billStatus;
  }
  
  public String getBillStatusTxt()
  {
    return this.billStatusTxt;
  }
  
  public String getBillTitle()
  {
    return this.billTitle;
  }
  
  public String getBillType()
  {
    return this.billType;
  }
  
  public Integer getFeeItemType()
  {
    return this.feeItemType;
  }
  
  public List<ZryuSignKvItem> getItemList()
  {
    return this.itemList;
  }
  
  public String getOperation()
  {
    return this.operation;
  }
  
  public Integer getOperationCode()
  {
    return this.operationCode;
  }
  
  public Integer getOughtAmount()
  {
    return this.oughtAmount;
  }
  
  public String getSystemId()
  {
    return this.systemId;
  }
  
  public void setBillNum(String paramString)
  {
    this.billNum = paramString;
  }
  
  public void setBillStatus(Integer paramInteger)
  {
    this.billStatus = paramInteger;
  }
  
  public void setBillStatusTxt(String paramString)
  {
    this.billStatusTxt = paramString;
  }
  
  public void setBillTitle(String paramString)
  {
    this.billTitle = paramString;
  }
  
  public void setBillType(String paramString)
  {
    this.billType = paramString;
  }
  
  public void setFeeItemType(Integer paramInteger)
  {
    this.feeItemType = paramInteger;
  }
  
  public void setItemList(List<ZryuSignKvItem> paramList)
  {
    this.itemList = paramList;
  }
  
  public void setOperation(String paramString)
  {
    this.operation = paramString;
  }
  
  public void setOperationCode(Integer paramInteger)
  {
    this.operationCode = paramInteger;
  }
  
  public void setOughtAmount(Integer paramInteger)
  {
    this.oughtAmount = paramInteger;
  }
  
  public void setSystemId(String paramString)
  {
    this.systemId = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sd/FeeBillDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */