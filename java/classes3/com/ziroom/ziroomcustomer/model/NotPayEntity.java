package com.ziroom.ziroomcustomer.model;

import com.ziroom.ziroomcustomer.living.d;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class NotPayEntity
  implements Serializable
{
  private String address;
  private String allShouldPayAmount;
  private List<String> billNumList;
  private String contractCode;
  private List<d> expensesCategoryList;
  private String housePic;
  private float money;
  private int orderType;
  private int overDueDay;
  private Date payDate;
  private String payDateStr;
  private List<String> payWayList;
  private int period;
  private String rentContractCode;
  private String sysContractId;
  private int sysPenaltyId;
  private String titleNotes;
  private String type;
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getAllShouldPayAmount()
  {
    return this.allShouldPayAmount;
  }
  
  public List<String> getBillNumList()
  {
    return this.billNumList;
  }
  
  public String getContractCode()
  {
    return this.contractCode;
  }
  
  public List<d> getExpensesCategoryList()
  {
    return this.expensesCategoryList;
  }
  
  public String getHousePic()
  {
    return this.housePic;
  }
  
  public float getMoney()
  {
    return this.money;
  }
  
  public int getOrderType()
  {
    return this.orderType;
  }
  
  public int getOverDueDay()
  {
    return this.overDueDay;
  }
  
  public Date getPayDate()
  {
    return this.payDate;
  }
  
  public String getPayDateStr()
  {
    return this.payDateStr;
  }
  
  public List<String> getPayWayList()
  {
    return this.payWayList;
  }
  
  public int getPeriod()
  {
    return this.period;
  }
  
  public String getRentContractCode()
  {
    return this.rentContractCode;
  }
  
  public String getSysContractId()
  {
    return this.sysContractId;
  }
  
  public int getSysPenaltyId()
  {
    return this.sysPenaltyId;
  }
  
  public String getTitleNotes()
  {
    return this.titleNotes;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setAllShouldPayAmount(String paramString)
  {
    this.allShouldPayAmount = paramString;
  }
  
  public void setBillNumList(List<String> paramList)
  {
    this.billNumList = paramList;
  }
  
  public void setContractCode(String paramString)
  {
    this.contractCode = paramString;
  }
  
  public void setExpensesCategoryList(List<d> paramList)
  {
    this.expensesCategoryList = paramList;
  }
  
  public void setHousePic(String paramString)
  {
    this.housePic = paramString;
  }
  
  public void setMoney(float paramFloat)
  {
    this.money = paramFloat;
  }
  
  public void setOrderType(int paramInt)
  {
    this.orderType = paramInt;
  }
  
  public void setOverDueDay(int paramInt)
  {
    this.overDueDay = paramInt;
  }
  
  public void setPayDate(Date paramDate)
  {
    this.payDate = paramDate;
  }
  
  public void setPayDateStr(String paramString)
  {
    this.payDateStr = paramString;
  }
  
  public void setPayWayList(List<String> paramList)
  {
    this.payWayList = paramList;
  }
  
  public void setPeriod(int paramInt)
  {
    this.period = paramInt;
  }
  
  public void setRentContractCode(String paramString)
  {
    this.rentContractCode = paramString;
  }
  
  public void setSysContractId(String paramString)
  {
    this.sysContractId = paramString;
  }
  
  public void setSysPenaltyId(int paramInt)
  {
    this.sysPenaltyId = paramInt;
  }
  
  public void setTitleNotes(String paramString)
  {
    this.titleNotes = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/NotPayEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */