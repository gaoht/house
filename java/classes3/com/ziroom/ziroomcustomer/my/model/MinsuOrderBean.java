package com.ziroom.ziroomcustomer.my.model;

import java.util.List;

public class MinsuOrderBean
{
  private List<MinsuOrderListBean> orderList;
  private int total;
  
  public List<MinsuOrderListBean> getOrderList()
  {
    return this.orderList;
  }
  
  public int getTotal()
  {
    return this.total;
  }
  
  public void setOrderList(List<MinsuOrderListBean> paramList)
  {
    this.orderList = paramList;
  }
  
  public void setTotal(int paramInt)
  {
    this.total = paramInt;
  }
  
  public static class MinsuOrderListBean
    extends SortIndexBean
  {
    private String cityCode;
    private String endTimeStr;
    private int evaStatus;
    private String houseAddr;
    private int housingDay;
    private int isLock;
    private int needPay;
    private int orderEvaStatus;
    private int orderProjectType;
    private int orderStatus;
    private String orderStatusName;
    private int orderStatusShowCode;
    private String picUrl;
    private String pjButton;
    private int pjStatus;
    private String roomName;
    private int startTimeStamp;
    private String startTimeStr;
    private String userName;
    
    public SortIndexBean convertToTravelOrder()
    {
      this.arriveTime = this.startTimeStr;
      this.leaveTime = this.endTimeStr;
      this.phone = this.landlordMobile;
      this.houseAddress = this.houseAddr;
      this.orderType = this.orderProjectType;
      return this;
    }
    
    public String getCityCode()
    {
      return this.cityCode;
    }
    
    public String getEndTimeStr()
    {
      return this.endTimeStr;
    }
    
    public int getEvaStatus()
    {
      return this.evaStatus;
    }
    
    public String getHouseAddr()
    {
      return this.houseAddr;
    }
    
    public int getHousingDay()
    {
      return this.housingDay;
    }
    
    public int getIsLock()
    {
      return this.isLock;
    }
    
    public int getNeedPay()
    {
      return this.needPay;
    }
    
    public int getOrderEvaStatus()
    {
      return this.orderEvaStatus;
    }
    
    public int getOrderProjectType()
    {
      return this.orderProjectType;
    }
    
    public int getOrderStatus()
    {
      return this.orderStatus;
    }
    
    public String getOrderStatusName()
    {
      return this.orderStatusName;
    }
    
    public int getOrderStatusShowCode()
    {
      return this.orderStatusShowCode;
    }
    
    public String getPicUrl()
    {
      return this.picUrl;
    }
    
    public String getPjButton()
    {
      return this.pjButton;
    }
    
    public int getPjStatus()
    {
      return this.pjStatus;
    }
    
    public String getRoomName()
    {
      return this.roomName;
    }
    
    public int getStartTimeStamp()
    {
      return this.startTimeStamp;
    }
    
    public String getStartTimeStr()
    {
      return this.startTimeStr;
    }
    
    public String getUserName()
    {
      return this.userName;
    }
    
    public void setCityCode(String paramString)
    {
      this.cityCode = paramString;
    }
    
    public void setEndTimeStr(String paramString)
    {
      this.endTimeStr = paramString;
    }
    
    public void setEvaStatus(int paramInt)
    {
      this.evaStatus = paramInt;
    }
    
    public void setHouseAddr(String paramString)
    {
      this.houseAddr = paramString;
    }
    
    public void setHousingDay(int paramInt)
    {
      this.housingDay = paramInt;
    }
    
    public void setIsLock(int paramInt)
    {
      this.isLock = paramInt;
    }
    
    public void setNeedPay(int paramInt)
    {
      this.needPay = paramInt;
    }
    
    public void setOrderEvaStatus(int paramInt)
    {
      this.orderEvaStatus = paramInt;
    }
    
    public void setOrderProjectType(int paramInt)
    {
      this.orderProjectType = paramInt;
    }
    
    public void setOrderStatus(int paramInt)
    {
      this.orderStatus = paramInt;
    }
    
    public void setOrderStatusName(String paramString)
    {
      this.orderStatusName = paramString;
    }
    
    public void setOrderStatusShowCode(int paramInt)
    {
      this.orderStatusShowCode = paramInt;
    }
    
    public void setPicUrl(String paramString)
    {
      this.picUrl = paramString;
    }
    
    public void setPjButton(String paramString)
    {
      this.pjButton = paramString;
    }
    
    public void setPjStatus(int paramInt)
    {
      this.pjStatus = paramInt;
    }
    
    public void setRoomName(String paramString)
    {
      this.roomName = paramString;
    }
    
    public void setStartTimeStamp(int paramInt)
    {
      this.startTimeStamp = paramInt;
    }
    
    public void setStartTimeStr(String paramString)
    {
      this.startTimeStr = paramString;
    }
    
    public void setUserName(String paramString)
    {
      this.userName = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/MinsuOrderBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */