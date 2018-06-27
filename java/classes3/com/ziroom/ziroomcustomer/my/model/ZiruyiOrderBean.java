package com.ziroom.ziroomcustomer.my.model;

import java.util.List;

public class ZiruyiOrderBean
{
  private List<ZiRuYiOrderListBean> orderList;
  private int total;
  
  public List<ZiRuYiOrderListBean> getOrderList()
  {
    return this.orderList;
  }
  
  public int getTotal()
  {
    return this.total;
  }
  
  public void setOrderList(List<ZiRuYiOrderListBean> paramList)
  {
    this.orderList = paramList;
  }
  
  public void setTotal(int paramInt)
  {
    this.total = paramInt;
  }
  
  public class ZiRuYiOrderListBean
    extends SortIndexBean
  {
    private String address;
    private int amount;
    private String createTime;
    private String endDate;
    private List<ZiruyiHouseTypeInfoBean> houseTypeInfo;
    private String isEvaluate;
    private String name;
    private int nights;
    private String orderBid;
    private String orderNumber;
    private int orderProjectType;
    private int orderStatus;
    private String paymentNumber;
    private String projectBid;
    private String projectName;
    private String sellPhone;
    private String startDate;
    
    public ZiRuYiOrderListBean() {}
    
    public SortIndexBean convertToTravelOrder()
    {
      this.arriveTime = this.startDate;
      this.leaveTime = this.endDate;
      this.fid = this.orderBid;
      this.houseAddress = this.address;
      this.houseName = this.projectName;
      this.orderType = this.orderProjectType;
      this.rentWay = null;
      this.landlordUid = null;
      this.landlordMobile = this.sellPhone;
      return this;
    }
    
    public String getAddress()
    {
      return this.address;
    }
    
    public int getAmount()
    {
      return this.amount;
    }
    
    public String getCreateTime()
    {
      return this.createTime;
    }
    
    public String getEndDate()
    {
      return this.endDate;
    }
    
    public List<ZiruyiHouseTypeInfoBean> getHouseTypeInfo()
    {
      return this.houseTypeInfo;
    }
    
    public String getIsEvaluate()
    {
      return this.isEvaluate;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public int getNights()
    {
      return this.nights;
    }
    
    public String getOrderBid()
    {
      return this.orderBid;
    }
    
    public String getOrderNumber()
    {
      return this.orderNumber;
    }
    
    public int getOrderProjectType()
    {
      return this.orderProjectType;
    }
    
    public int getOrderStatus()
    {
      return this.orderStatus;
    }
    
    public String getPaymentNumber()
    {
      return this.paymentNumber;
    }
    
    public String getProjectBid()
    {
      return this.projectBid;
    }
    
    public String getProjectName()
    {
      return this.projectName;
    }
    
    public String getSellPhone()
    {
      return this.sellPhone;
    }
    
    public String getStartDate()
    {
      return this.startDate;
    }
    
    public void setAddress(String paramString)
    {
      this.address = paramString;
    }
    
    public void setAmount(int paramInt)
    {
      this.amount = paramInt;
    }
    
    public void setCreateTime(String paramString)
    {
      this.createTime = paramString;
    }
    
    public void setEndDate(String paramString)
    {
      this.endDate = paramString;
    }
    
    public void setHouseTypeInfo(List<ZiruyiHouseTypeInfoBean> paramList)
    {
      this.houseTypeInfo = paramList;
    }
    
    public void setIsEvaluate(String paramString)
    {
      this.isEvaluate = paramString;
    }
    
    public void setName(String paramString)
    {
      this.name = paramString;
    }
    
    public void setNights(int paramInt)
    {
      this.nights = paramInt;
    }
    
    public void setOrderBid(String paramString)
    {
      this.orderBid = paramString;
    }
    
    public void setOrderNumber(String paramString)
    {
      this.orderNumber = paramString;
    }
    
    public void setOrderProjectType(int paramInt)
    {
      this.orderProjectType = paramInt;
    }
    
    public void setOrderStatus(int paramInt)
    {
      this.orderStatus = paramInt;
    }
    
    public void setPaymentNumber(String paramString)
    {
      this.paymentNumber = paramString;
    }
    
    public void setProjectBid(String paramString)
    {
      this.projectBid = paramString;
    }
    
    public void setProjectName(String paramString)
    {
      this.projectName = paramString;
    }
    
    public void setSellPhone(String paramString)
    {
      this.sellPhone = paramString;
    }
    
    public void setStartDate(String paramString)
    {
      this.startDate = paramString;
    }
    
    public class ZiruyiHouseTypeInfoBean
    {
      private int bedCount;
      private String houseName;
      private String houseTypeBid;
      private String imgUrl;
      
      public ZiruyiHouseTypeInfoBean() {}
      
      public int getBedCount()
      {
        return this.bedCount;
      }
      
      public String getHouseName()
      {
        return this.houseName;
      }
      
      public String getHouseTypeBid()
      {
        return this.houseTypeBid;
      }
      
      public String getImgUrl()
      {
        return this.imgUrl;
      }
      
      public void setBedCount(int paramInt)
      {
        this.bedCount = paramInt;
      }
      
      public void setHouseName(String paramString)
      {
        this.houseName = paramString;
      }
      
      public void setHouseTypeBid(String paramString)
      {
        this.houseTypeBid = paramString;
      }
      
      public void setImgUrl(String paramString)
      {
        this.imgUrl = paramString;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/ZiruyiOrderBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */