package com.ziroom.ziroomcustomer.findhouse.model;

import java.util.List;

public class ZZPayway
{
  private List<PricesBean> prices;
  private SettingsBean settings;
  
  public List<PricesBean> getPrices()
  {
    return this.prices;
  }
  
  public SettingsBean getSettings()
  {
    return this.settings;
  }
  
  public void setPrices(List<PricesBean> paramList)
  {
    this.prices = paramList;
  }
  
  public void setSettings(SettingsBean paramSettingsBean)
  {
    this.settings = paramSettingsBean;
  }
  
  public static class PricesBean
  {
    private String plan_type;
    private String pledge;
    private String rent;
    private String service;
    
    public String getPlan_type()
    {
      return this.plan_type;
    }
    
    public String getPledge()
    {
      return this.pledge;
    }
    
    public String getRent()
    {
      return this.rent;
    }
    
    public String getService()
    {
      return this.service;
    }
    
    public void setPlan_type(String paramString)
    {
      this.plan_type = paramString;
    }
    
    public void setPledge(String paramString)
    {
      this.pledge = paramString;
    }
    
    public void setRent(String paramString)
    {
      this.rent = paramString;
    }
    
    public void setService(String paramString)
    {
      this.service = paramString;
    }
    
    public String toString()
    {
      return "PricesBean{plan_type='" + this.plan_type + '\'' + ", rent=" + this.rent + ", pledge=" + this.pledge + ", service=" + this.service + '}';
    }
  }
  
  public static class SettingsBean
  {
    private List<FeeTypesBean> fee_types;
    private List<PlanTypesBean> plan_types;
    
    public List<FeeTypesBean> getFee_types()
    {
      return this.fee_types;
    }
    
    public List<PlanTypesBean> getPlan_types()
    {
      return this.plan_types;
    }
    
    public void setFee_types(List<FeeTypesBean> paramList)
    {
      this.fee_types = paramList;
    }
    
    public void setPlan_types(List<PlanTypesBean> paramList)
    {
      this.plan_types = paramList;
    }
    
    public static class FeeTypesBean
    {
      private String code;
      private String title;
      private String unit;
      
      public String getCode()
      {
        return this.code;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public String getUnit()
      {
        return this.unit;
      }
      
      public void setCode(String paramString)
      {
        this.code = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public void setUnit(String paramString)
      {
        this.unit = paramString;
      }
      
      public String toString()
      {
        return "FeeTypesBean{code='" + this.code + '\'' + ", title='" + this.title + '\'' + ", unit='" + this.unit + '\'' + '}';
      }
    }
    
    public static class PlanTypesBean
    {
      private String code;
      private String title;
      
      public String getCode()
      {
        return this.code;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public void setCode(String paramString)
      {
        this.code = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public String toString()
      {
        return "PlanTypesBean{code='" + this.code + '\'' + ", title='" + this.title + '\'' + '}';
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/ZZPayway.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */