package com.ziroom.ziroomcustomer.my.model;

import java.util.List;

public class OwnerConfirmDeliveryBean
{
  public String deliveryDate;
  public String hireCommissionerPhone;
  public List<DeliveryInfoBean> keyCredit;
  public List<DeliveryInfoBean> lifeFee;
  public List<ThingInfoBean> thingInfo;
  
  public String getDeliveryDate()
  {
    return this.deliveryDate;
  }
  
  public List<DeliveryInfoBean> getKeyCredit()
  {
    return this.keyCredit;
  }
  
  public List<DeliveryInfoBean> getLifeFee()
  {
    return this.lifeFee;
  }
  
  public List<ThingInfoBean> getThingInfo()
  {
    return this.thingInfo;
  }
  
  public void setDeliveryDate(String paramString)
  {
    this.deliveryDate = paramString;
  }
  
  public void setKeyCredit(List<DeliveryInfoBean> paramList)
  {
    this.keyCredit = paramList;
  }
  
  public void setLifeFee(List<DeliveryInfoBean> paramList)
  {
    this.lifeFee = paramList;
  }
  
  public void setThingInfo(List<ThingInfoBean> paramList)
  {
    this.thingInfo = paramList;
  }
  
  public static class DataBean
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
  
  public static class DeliveryInfoBean
  {
    public List<OwnerConfirmDeliveryBean.DataBean> data;
    public String deliveryName;
    public String[] imgUrls;
    public String subName;
    
    public List<OwnerConfirmDeliveryBean.DataBean> getData()
    {
      return this.data;
    }
    
    public String getDeliveryName()
    {
      return this.deliveryName;
    }
    
    public void setData(List<OwnerConfirmDeliveryBean.DataBean> paramList)
    {
      this.data = paramList;
    }
    
    public void setDeliveryName(String paramString)
    {
      this.deliveryName = paramString;
    }
  }
  
  public static class ThingInfoBean
  {
    public String roomName;
    public List<OwnerConfirmDeliveryBean.ThingsBean> things;
    
    public String getRoomName()
    {
      return this.roomName;
    }
    
    public List<OwnerConfirmDeliveryBean.ThingsBean> getThings()
    {
      return this.things;
    }
    
    public void setRoomName(String paramString)
    {
      this.roomName = paramString;
    }
    
    public void setThings(List<OwnerConfirmDeliveryBean.ThingsBean> paramList)
    {
      this.things = paramList;
    }
  }
  
  public static class ThingsBean
  {
    public List<OwnerConfirmDeliveryBean.DataBean> data;
    public String deliveryName;
    public String[] imgUrls;
    
    public List<OwnerConfirmDeliveryBean.DataBean> getData()
    {
      return this.data;
    }
    
    public String getDeliveryName()
    {
      return this.deliveryName;
    }
    
    public String[] getImgUrls()
    {
      return this.imgUrls;
    }
    
    public void setData(List<OwnerConfirmDeliveryBean.DataBean> paramList)
    {
      this.data = paramList;
    }
    
    public void setDeliveryName(String paramString)
    {
      this.deliveryName = paramString;
    }
    
    public void setImgUrls(String[] paramArrayOfString)
    {
      this.imgUrls = paramArrayOfString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/OwnerConfirmDeliveryBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */