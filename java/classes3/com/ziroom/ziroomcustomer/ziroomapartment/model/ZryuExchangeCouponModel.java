package com.ziroom.ziroomcustomer.ziroomapartment.model;

import com.freelxl.baselibrary.b.b;

public class ZryuExchangeCouponModel
  extends b
{
  public DataBean data;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public static class DataBean
  {
    public String code;
    public String desc;
    public String endTime;
    public String money;
    public String name;
    public String rule;
    public Object serviceLineId;
    public String startTime;
    
    public String getCode()
    {
      return this.code;
    }
    
    public String getDesc()
    {
      return this.desc;
    }
    
    public String getEndTime()
    {
      return this.endTime;
    }
    
    public String getMoney()
    {
      return this.money;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public String getRule()
    {
      return this.rule;
    }
    
    public Object getServiceLineId()
    {
      return this.serviceLineId;
    }
    
    public String getStartTime()
    {
      return this.startTime;
    }
    
    public void setCode(String paramString)
    {
      this.code = paramString;
    }
    
    public void setDesc(String paramString)
    {
      this.desc = paramString;
    }
    
    public void setEndTime(String paramString)
    {
      this.endTime = paramString;
    }
    
    public void setMoney(String paramString)
    {
      this.money = paramString;
    }
    
    public void setName(String paramString)
    {
      this.name = paramString;
    }
    
    public void setRule(String paramString)
    {
      this.rule = paramString;
    }
    
    public void setServiceLineId(Object paramObject)
    {
      this.serviceLineId = paramObject;
    }
    
    public void setStartTime(String paramString)
    {
      this.startTime = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/ZryuExchangeCouponModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */