package com.ziroom.ziroomcustomer.minsu.landlord.model;

import java.util.List;

public class MoneyItem
{
  private String desc;
  private String feeUnit;
  private String name;
  private List<FeeItem> subList;
  private String subTitle;
  private String symbol;
  private String tipMsg;
  private String value;
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public String getFeeUnit()
  {
    return this.feeUnit;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public List<FeeItem> getSubList()
  {
    return this.subList;
  }
  
  public String getSubTitle()
  {
    return this.subTitle;
  }
  
  public String getSymbol()
  {
    return this.symbol;
  }
  
  public String getTipMsg()
  {
    return this.tipMsg;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setDesc(String paramString)
  {
    this.desc = paramString;
  }
  
  public void setFeeUnit(String paramString)
  {
    this.feeUnit = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setSubList(List<FeeItem> paramList)
  {
    this.subList = paramList;
  }
  
  public void setSubTitle(String paramString)
  {
    this.subTitle = paramString;
  }
  
  public void setSymbol(String paramString)
  {
    this.symbol = paramString;
  }
  
  public void setTipMsg(String paramString)
  {
    this.tipMsg = paramString;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/model/MoneyItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */