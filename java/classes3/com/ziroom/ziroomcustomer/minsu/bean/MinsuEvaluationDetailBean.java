package com.ziroom.ziroomcustomer.minsu.bean;

public class MinsuEvaluationDetailBean
  extends MinsuBaseJson
{
  private DataBean data;
  
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
    private Object bedSn;
    private String checkInTime;
    private String checkOutTime;
    private String endTimeStr;
    private EvaluateOrderBean evaluateOrder;
    private String houseName;
    private int housingDay;
    private LandlordEvaluateBean landlordEvaluate;
    private String landlordName;
    private String landlordPicUrl;
    private String picUrl;
    private Object price;
    private Object roomName;
    private String startTimeStr;
    private int sumMoney;
    private TenantEvaluateBean tenantEvaluate;
    private String userName;
    
    public Object getBedSn()
    {
      return this.bedSn;
    }
    
    public String getCheckInTime()
    {
      return this.checkInTime;
    }
    
    public String getCheckOutTime()
    {
      return this.checkOutTime;
    }
    
    public String getEndTimeStr()
    {
      return this.endTimeStr;
    }
    
    public EvaluateOrderBean getEvaluateOrder()
    {
      return this.evaluateOrder;
    }
    
    public String getHouseName()
    {
      return this.houseName;
    }
    
    public int getHousingDay()
    {
      return this.housingDay;
    }
    
    public LandlordEvaluateBean getLandlordEvaluate()
    {
      return this.landlordEvaluate;
    }
    
    public String getLandlordName()
    {
      return this.landlordName;
    }
    
    public String getLandlordPicUrl()
    {
      return this.landlordPicUrl;
    }
    
    public String getPicUrl()
    {
      return this.picUrl;
    }
    
    public Object getPrice()
    {
      return this.price;
    }
    
    public Object getRoomName()
    {
      return this.roomName;
    }
    
    public String getStartTimeStr()
    {
      return this.startTimeStr;
    }
    
    public int getSumMoney()
    {
      return this.sumMoney;
    }
    
    public TenantEvaluateBean getTenantEvaluate()
    {
      return this.tenantEvaluate;
    }
    
    public String getUserName()
    {
      return this.userName;
    }
    
    public void setBedSn(Object paramObject)
    {
      this.bedSn = paramObject;
    }
    
    public void setCheckInTime(String paramString)
    {
      this.checkInTime = paramString;
    }
    
    public void setCheckOutTime(String paramString)
    {
      this.checkOutTime = paramString;
    }
    
    public void setEndTimeStr(String paramString)
    {
      this.endTimeStr = paramString;
    }
    
    public void setEvaluateOrder(EvaluateOrderBean paramEvaluateOrderBean)
    {
      this.evaluateOrder = paramEvaluateOrderBean;
    }
    
    public void setHouseName(String paramString)
    {
      this.houseName = paramString;
    }
    
    public void setHousingDay(int paramInt)
    {
      this.housingDay = paramInt;
    }
    
    public void setLandlordEvaluate(LandlordEvaluateBean paramLandlordEvaluateBean)
    {
      this.landlordEvaluate = paramLandlordEvaluateBean;
    }
    
    public void setLandlordName(String paramString)
    {
      this.landlordName = paramString;
    }
    
    public void setLandlordPicUrl(String paramString)
    {
      this.landlordPicUrl = paramString;
    }
    
    public void setPicUrl(String paramString)
    {
      this.picUrl = paramString;
    }
    
    public void setPrice(Object paramObject)
    {
      this.price = paramObject;
    }
    
    public void setRoomName(Object paramObject)
    {
      this.roomName = paramObject;
    }
    
    public void setStartTimeStr(String paramString)
    {
      this.startTimeStr = paramString;
    }
    
    public void setSumMoney(int paramInt)
    {
      this.sumMoney = paramInt;
    }
    
    public void setTenantEvaluate(TenantEvaluateBean paramTenantEvaluateBean)
    {
      this.tenantEvaluate = paramTenantEvaluateBean;
    }
    
    public void setUserName(String paramString)
    {
      this.userName = paramString;
    }
    
    public static class EvaluateOrderBean
    {
      private Object bedFid;
      private long createTime;
      private int evaStatu;
      private int evaUserType;
      private String evaUserUid;
      private String fid;
      private String houseFid;
      private int id;
      private long lastModifyDate;
      private int orderEvaFlag;
      private String orderSn;
      private String ratedUserUid;
      private int rentWay;
      private String roomFid;
      
      public Object getBedFid()
      {
        return this.bedFid;
      }
      
      public long getCreateTime()
      {
        return this.createTime;
      }
      
      public int getEvaStatu()
      {
        return this.evaStatu;
      }
      
      public int getEvaUserType()
      {
        return this.evaUserType;
      }
      
      public String getEvaUserUid()
      {
        return this.evaUserUid;
      }
      
      public String getFid()
      {
        return this.fid;
      }
      
      public String getHouseFid()
      {
        return this.houseFid;
      }
      
      public int getId()
      {
        return this.id;
      }
      
      public long getLastModifyDate()
      {
        return this.lastModifyDate;
      }
      
      public int getOrderEvaFlag()
      {
        return this.orderEvaFlag;
      }
      
      public String getOrderSn()
      {
        return this.orderSn;
      }
      
      public String getRatedUserUid()
      {
        return this.ratedUserUid;
      }
      
      public int getRentWay()
      {
        return this.rentWay;
      }
      
      public String getRoomFid()
      {
        return this.roomFid;
      }
      
      public void setBedFid(Object paramObject)
      {
        this.bedFid = paramObject;
      }
      
      public void setCreateTime(long paramLong)
      {
        this.createTime = paramLong;
      }
      
      public void setEvaStatu(int paramInt)
      {
        this.evaStatu = paramInt;
      }
      
      public void setEvaUserType(int paramInt)
      {
        this.evaUserType = paramInt;
      }
      
      public void setEvaUserUid(String paramString)
      {
        this.evaUserUid = paramString;
      }
      
      public void setFid(String paramString)
      {
        this.fid = paramString;
      }
      
      public void setHouseFid(String paramString)
      {
        this.houseFid = paramString;
      }
      
      public void setId(int paramInt)
      {
        this.id = paramInt;
      }
      
      public void setLastModifyDate(long paramLong)
      {
        this.lastModifyDate = paramLong;
      }
      
      public void setOrderEvaFlag(int paramInt)
      {
        this.orderEvaFlag = paramInt;
      }
      
      public void setOrderSn(String paramString)
      {
        this.orderSn = paramString;
      }
      
      public void setRatedUserUid(String paramString)
      {
        this.ratedUserUid = paramString;
      }
      
      public void setRentWay(int paramInt)
      {
        this.rentWay = paramInt;
      }
      
      public void setRoomFid(String paramString)
      {
        this.roomFid = paramString;
      }
    }
    
    public static class LandlordEvaluateBean
    {
      private String content;
      private long createTime;
      private String evaOrderFid;
      private String fid;
      private int id;
      private int isDel;
      private float landlordSatisfied;
      private long lastModifyDate;
      
      public String getContent()
      {
        return this.content;
      }
      
      public long getCreateTime()
      {
        return this.createTime;
      }
      
      public String getEvaOrderFid()
      {
        return this.evaOrderFid;
      }
      
      public String getFid()
      {
        return this.fid;
      }
      
      public int getId()
      {
        return this.id;
      }
      
      public int getIsDel()
      {
        return this.isDel;
      }
      
      public float getLandlordSatisfied()
      {
        return this.landlordSatisfied;
      }
      
      public long getLastModifyDate()
      {
        return this.lastModifyDate;
      }
      
      public void setContent(String paramString)
      {
        this.content = paramString;
      }
      
      public void setCreateTime(long paramLong)
      {
        this.createTime = paramLong;
      }
      
      public void setEvaOrderFid(String paramString)
      {
        this.evaOrderFid = paramString;
      }
      
      public void setFid(String paramString)
      {
        this.fid = paramString;
      }
      
      public void setId(int paramInt)
      {
        this.id = paramInt;
      }
      
      public void setIsDel(int paramInt)
      {
        this.isDel = paramInt;
      }
      
      public void setLandlordSatisfied(int paramInt)
      {
        this.landlordSatisfied = paramInt;
      }
      
      public void setLastModifyDate(long paramLong)
      {
        this.lastModifyDate = paramLong;
      }
    }
    
    public static class TenantEvaluateBean
    {
      private String content;
      private float costPerformance;
      private long createTime;
      private float descriptionMatch;
      private float evaFive;
      private float evaFour;
      private String evaOrderFid;
      private String fid;
      private float houseClean;
      private int id;
      private int isDel;
      private long lastModifyDate;
      private float safetyDegree;
      private float trafficPosition;
      
      public String getContent()
      {
        return this.content;
      }
      
      public float getCostPerformance()
      {
        return this.costPerformance;
      }
      
      public long getCreateTime()
      {
        return this.createTime;
      }
      
      public float getDescriptionMatch()
      {
        return this.descriptionMatch;
      }
      
      public float getEvaFive()
      {
        return this.evaFive;
      }
      
      public float getEvaFour()
      {
        return this.evaFour;
      }
      
      public String getEvaOrderFid()
      {
        return this.evaOrderFid;
      }
      
      public String getFid()
      {
        return this.fid;
      }
      
      public float getHouseClean()
      {
        return this.houseClean;
      }
      
      public int getId()
      {
        return this.id;
      }
      
      public int getIsDel()
      {
        return this.isDel;
      }
      
      public long getLastModifyDate()
      {
        return this.lastModifyDate;
      }
      
      public float getSafetyDegree()
      {
        return this.safetyDegree;
      }
      
      public float getTrafficPosition()
      {
        return this.trafficPosition;
      }
      
      public void setContent(String paramString)
      {
        this.content = paramString;
      }
      
      public void setCostPerformance(int paramInt)
      {
        this.costPerformance = paramInt;
      }
      
      public void setCreateTime(long paramLong)
      {
        this.createTime = paramLong;
      }
      
      public void setDescriptionMatch(int paramInt)
      {
        this.descriptionMatch = paramInt;
      }
      
      public void setEvaFive(int paramInt)
      {
        this.evaFive = paramInt;
      }
      
      public void setEvaFour(int paramInt)
      {
        this.evaFour = paramInt;
      }
      
      public void setEvaOrderFid(String paramString)
      {
        this.evaOrderFid = paramString;
      }
      
      public void setFid(String paramString)
      {
        this.fid = paramString;
      }
      
      public void setHouseClean(int paramInt)
      {
        this.houseClean = paramInt;
      }
      
      public void setId(int paramInt)
      {
        this.id = paramInt;
      }
      
      public void setIsDel(int paramInt)
      {
        this.isDel = paramInt;
      }
      
      public void setLastModifyDate(long paramLong)
      {
        this.lastModifyDate = paramLong;
      }
      
      public void setSafetyDegree(int paramInt)
      {
        this.safetyDegree = paramInt;
      }
      
      public void setTrafficPosition(int paramInt)
      {
        this.trafficPosition = paramInt;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuEvaluationDetailBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */