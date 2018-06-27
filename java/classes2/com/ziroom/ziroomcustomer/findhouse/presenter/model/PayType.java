package com.ziroom.ziroomcustomer.findhouse.presenter.model;

import java.util.List;

public class PayType
{
  private List<DetailsBean> details;
  private List<String> reminder;
  
  public List<DetailsBean> getDetails()
  {
    return this.details;
  }
  
  public List<String> getReminder()
  {
    return this.reminder;
  }
  
  public void setDetails(List<DetailsBean> paramList)
  {
    this.details = paramList;
  }
  
  public void setReminder(List<String> paramList)
  {
    this.reminder = paramList;
  }
  
  public static class DetailsBean
  {
    private String deposit;
    private String deposit_unit;
    private String link;
    private String link_title;
    private String link_type;
    private String more_link;
    private String more_link_type;
    private String rent_fee;
    private String rent_fee_unit;
    private String service_fee;
    private String service_fee_unit;
    private String title;
    
    public String getDeposit()
    {
      return this.deposit;
    }
    
    public String getDeposit_unit()
    {
      return this.deposit_unit;
    }
    
    public String getLink()
    {
      return this.link;
    }
    
    public String getLink_title()
    {
      return this.link_title;
    }
    
    public String getLink_type()
    {
      return this.link_type;
    }
    
    public String getMore_link()
    {
      return this.more_link;
    }
    
    public String getMore_link_type()
    {
      return this.more_link_type;
    }
    
    public String getRent_fee()
    {
      return this.rent_fee;
    }
    
    public String getRent_fee_unit()
    {
      return this.rent_fee_unit;
    }
    
    public String getService_fee()
    {
      return this.service_fee;
    }
    
    public String getService_fee_unit()
    {
      return this.service_fee_unit;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setDeposit(String paramString)
    {
      this.deposit = paramString;
    }
    
    public void setDeposit_unit(String paramString)
    {
      this.deposit_unit = paramString;
    }
    
    public void setLink(String paramString)
    {
      this.link = paramString;
    }
    
    public void setLink_title(String paramString)
    {
      this.link_title = paramString;
    }
    
    public void setLink_type(String paramString)
    {
      this.link_type = paramString;
    }
    
    public void setMore_link(String paramString)
    {
      this.more_link = paramString;
    }
    
    public void setMore_link_type(String paramString)
    {
      this.more_link_type = paramString;
    }
    
    public void setRent_fee(String paramString)
    {
      this.rent_fee = paramString;
    }
    
    public void setRent_fee_unit(String paramString)
    {
      this.rent_fee_unit = paramString;
    }
    
    public void setService_fee(String paramString)
    {
      this.service_fee = paramString;
    }
    
    public void setService_fee_unit(String paramString)
    {
      this.service_fee_unit = paramString;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/presenter/model/PayType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */