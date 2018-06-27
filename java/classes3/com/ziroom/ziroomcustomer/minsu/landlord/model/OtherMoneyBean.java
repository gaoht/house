package com.ziroom.ziroomcustomer.minsu.landlord.model;

public class OtherMoneyBean
{
  private String desc;
  private DetailBean detail;
  private String feeUnit;
  private int isShow;
  private String name;
  private String value;
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public DetailBean getDetail()
  {
    return this.detail;
  }
  
  public String getFeeUnit()
  {
    return this.feeUnit;
  }
  
  public int getIsShow()
  {
    return this.isShow;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setDesc(String paramString)
  {
    this.desc = paramString;
  }
  
  public void setDetail(DetailBean paramDetailBean)
  {
    this.detail = paramDetailBean;
  }
  
  public void setFeeUnit(String paramString)
  {
    this.feeUnit = paramString;
  }
  
  public void setIsShow(int paramInt)
  {
    this.isShow = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
  
  public static class DetailBean
  {
    private MoneyItem money;
    private MoneyItem reason;
    
    public MoneyItem getMoney()
    {
      return this.money;
    }
    
    public MoneyItem getReason()
    {
      return this.reason;
    }
    
    public void setMoney(MoneyItem paramMoneyItem)
    {
      this.money = paramMoneyItem;
    }
    
    public void setReason(MoneyItem paramMoneyItem)
    {
      this.reason = paramMoneyItem;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/model/OtherMoneyBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */