package com.ziroom.ziroomcustomer.my.model;

import java.util.List;

public class OwnerEntrustScheduleBean
{
  public String address;
  public String link_all;
  public String link_all_type;
  public String link_detail;
  public String link_detail_type;
  public List<ProgressBean> progress;
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getLink_all()
  {
    return this.link_all;
  }
  
  public String getLink_detail()
  {
    return this.link_detail;
  }
  
  public List<ProgressBean> getProgress()
  {
    return this.progress;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setLink_all(String paramString)
  {
    this.link_all = paramString;
  }
  
  public void setLink_detail(String paramString)
  {
    this.link_detail = paramString;
  }
  
  public void setProgress(List<ProgressBean> paramList)
  {
    this.progress = paramList;
  }
  
  public static class ProgressBean
  {
    public int active;
    public String date;
    public String desc;
    public HousekepperBean housekepper;
    public String name;
    
    public int getActive()
    {
      return this.active;
    }
    
    public String getDate()
    {
      return this.date;
    }
    
    public String getDesc()
    {
      return this.desc;
    }
    
    public HousekepperBean getHousekepper()
    {
      return this.housekepper;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public void setActive(int paramInt)
    {
      this.active = paramInt;
    }
    
    public void setDate(String paramString)
    {
      this.date = paramString;
    }
    
    public void setDesc(String paramString)
    {
      this.desc = paramString;
    }
    
    public void setHousekepper(HousekepperBean paramHousekepperBean)
    {
      this.housekepper = paramHousekepperBean;
    }
    
    public void setName(String paramString)
    {
      this.name = paramString;
    }
    
    public static class HousekepperBean
    {
      public String name;
      public String phone;
      
      public String getName()
      {
        return this.name;
      }
      
      public String getPhone()
      {
        return this.phone;
      }
      
      public void setName(String paramString)
      {
        this.name = paramString;
      }
      
      public void setPhone(String paramString)
      {
        this.phone = paramString;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/OwnerEntrustScheduleBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */