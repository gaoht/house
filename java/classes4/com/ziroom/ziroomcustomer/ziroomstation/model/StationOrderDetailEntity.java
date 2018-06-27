package com.ziroom.ziroomcustomer.ziroomstation.model;

import com.ziroom.ziroomcustomer.ziroomstation.b.a;
import java.io.Serializable;
import java.util.List;

public class StationOrderDetailEntity
  extends a
  implements Serializable
{
  private DataEntity data;
  
  public DataEntity getData()
  {
    return this.data;
  }
  
  public void setData(DataEntity paramDataEntity)
  {
    this.data = paramDataEntity;
  }
  
  public static class DataEntity
    implements Serializable
  {
    private String amount;
    private int bedCount;
    private String dName;
    private String endDate;
    private List<HouseTypeInfoEntity> houseTypeInfo;
    private String imgUrl;
    private String isEvaluate;
    public double lat;
    private String limitTime;
    public double lng;
    private String mail;
    private String orderBid;
    private String orderNumber;
    private int orderStatus;
    private String orderStatusDesc;
    private String paymentNumber;
    private String phone;
    private String projectAddress;
    private String projectBid;
    private String projectName;
    private String refund;
    private String refundStatu;
    public List<RefundStepBean> refundStep;
    public int remainTime;
    private int selfChecked;
    private String sellPhone;
    private String startDate;
    private boolean supportSelfCheck;
    private String traffic;
    
    public String getAmount()
    {
      return this.amount;
    }
    
    public int getBedCount()
    {
      return this.bedCount;
    }
    
    public String getDName()
    {
      return this.dName;
    }
    
    public String getEndDate()
    {
      return this.endDate;
    }
    
    public List<HouseTypeInfoEntity> getHouseTypeInfo()
    {
      return this.houseTypeInfo;
    }
    
    public String getImgUrl()
    {
      return this.imgUrl;
    }
    
    public String getIsEvaluate()
    {
      return this.isEvaluate;
    }
    
    public String getLimitTime()
    {
      return this.limitTime;
    }
    
    public String getMail()
    {
      return this.mail;
    }
    
    public String getOrderBid()
    {
      return this.orderBid;
    }
    
    public String getOrderNumber()
    {
      return this.orderNumber;
    }
    
    public int getOrderStatus()
    {
      return this.orderStatus;
    }
    
    public String getOrderStatusDesc()
    {
      return this.orderStatusDesc;
    }
    
    public String getPaymentNumber()
    {
      return this.paymentNumber;
    }
    
    public String getPhone()
    {
      return this.phone;
    }
    
    public String getProjectAddress()
    {
      return this.projectAddress;
    }
    
    public String getProjectBid()
    {
      return this.projectBid;
    }
    
    public String getProjectName()
    {
      return this.projectName;
    }
    
    public String getRefund()
    {
      return this.refund;
    }
    
    public String getRefundStatu()
    {
      return this.refundStatu;
    }
    
    public List<RefundStepBean> getRefundStep()
    {
      return this.refundStep;
    }
    
    public int getSelfChecked()
    {
      return this.selfChecked;
    }
    
    public String getSellPhone()
    {
      return this.sellPhone;
    }
    
    public String getStartDate()
    {
      return this.startDate;
    }
    
    public String getTraffic()
    {
      return this.traffic;
    }
    
    public boolean isSupportSelfCheck()
    {
      return this.supportSelfCheck;
    }
    
    public void setAmount(String paramString)
    {
      this.amount = paramString;
    }
    
    public void setBedCount(int paramInt)
    {
      this.bedCount = paramInt;
    }
    
    public void setDName(String paramString)
    {
      this.dName = paramString;
    }
    
    public void setEndDate(String paramString)
    {
      this.endDate = paramString;
    }
    
    public void setHouseTypeInfo(List<HouseTypeInfoEntity> paramList)
    {
      this.houseTypeInfo = paramList;
    }
    
    public void setImgUrl(String paramString)
    {
      this.imgUrl = paramString;
    }
    
    public void setIsEvaluate(String paramString)
    {
      this.isEvaluate = paramString;
    }
    
    public void setLimitTime(String paramString)
    {
      this.limitTime = paramString;
    }
    
    public void setMail(String paramString)
    {
      this.mail = paramString;
    }
    
    public void setOrderBid(String paramString)
    {
      this.orderBid = paramString;
    }
    
    public void setOrderNumber(String paramString)
    {
      this.orderNumber = paramString;
    }
    
    public void setOrderStatus(int paramInt)
    {
      this.orderStatus = paramInt;
    }
    
    public void setOrderStatusDesc(String paramString)
    {
      this.orderStatusDesc = paramString;
    }
    
    public void setPaymentNumber(String paramString)
    {
      this.paymentNumber = paramString;
    }
    
    public void setPhone(String paramString)
    {
      this.phone = paramString;
    }
    
    public void setProjectAddress(String paramString)
    {
      this.projectAddress = paramString;
    }
    
    public void setProjectBid(String paramString)
    {
      this.projectBid = paramString;
    }
    
    public void setProjectName(String paramString)
    {
      this.projectName = paramString;
    }
    
    public void setRefund(String paramString)
    {
      this.refund = paramString;
    }
    
    public void setRefundStatu(String paramString)
    {
      this.refundStatu = paramString;
    }
    
    public void setRefundStep(List<RefundStepBean> paramList)
    {
      this.refundStep = paramList;
    }
    
    public void setSelfChecked(int paramInt)
    {
      this.selfChecked = paramInt;
    }
    
    public void setSellPhone(String paramString)
    {
      this.sellPhone = paramString;
    }
    
    public void setStartDate(String paramString)
    {
      this.startDate = paramString;
    }
    
    public void setSupportSelfCheck(boolean paramBoolean)
    {
      this.supportSelfCheck = paramBoolean;
    }
    
    public void setTraffic(String paramString)
    {
      this.traffic = paramString;
    }
    
    public static class HouseTypeInfoEntity
      implements Serializable
    {
      private int bedCount;
      private String houseShowName;
      private String houseTypeBid;
      private List<StayPersonInfoEntity> stayPersonInfo;
      
      public int getBedCount()
      {
        return this.bedCount;
      }
      
      public String getHouseShowName()
      {
        return this.houseShowName;
      }
      
      public String getHouseTypeBid()
      {
        return this.houseTypeBid;
      }
      
      public List<StayPersonInfoEntity> getStayPersonInfo()
      {
        return this.stayPersonInfo;
      }
      
      public void setBedCount(int paramInt)
      {
        this.bedCount = paramInt;
      }
      
      public void setHouseShowName(String paramString)
      {
        this.houseShowName = paramString;
      }
      
      public void setHouseTypeBid(String paramString)
      {
        this.houseTypeBid = paramString;
      }
      
      public void setStayPersonInfo(List<StayPersonInfoEntity> paramList)
      {
        this.stayPersonInfo = paramList;
      }
      
      public static class StayPersonInfoEntity
        implements Serializable
      {
        private String areaName;
        private String bedBid;
        private String bedNum;
        private String bid;
        private String credentialNumber;
        private int credentialType;
        private String[] labels;
        private String sex;
        private String zName;
        
        public String getAreaName()
        {
          return this.areaName;
        }
        
        public String getBedBid()
        {
          return this.bedBid;
        }
        
        public String getBedNum()
        {
          return this.bedNum;
        }
        
        public String getBid()
        {
          return this.bid;
        }
        
        public String getCredentialNumber()
        {
          return this.credentialNumber;
        }
        
        public int getCredentialType()
        {
          return this.credentialType;
        }
        
        public String[] getLabels()
        {
          return this.labels;
        }
        
        public String getSex()
        {
          return this.sex;
        }
        
        public String getZName()
        {
          return this.zName;
        }
        
        public void setAreaName(String paramString)
        {
          this.areaName = paramString;
        }
        
        public void setBedBid(String paramString)
        {
          this.bedBid = paramString;
        }
        
        public void setBedNum(String paramString)
        {
          this.bedNum = paramString;
        }
        
        public void setBid(String paramString)
        {
          this.bid = paramString;
        }
        
        public void setCredentialNumber(String paramString)
        {
          this.credentialNumber = paramString;
        }
        
        public void setCredentialType(int paramInt)
        {
          this.credentialType = paramInt;
        }
        
        public void setLabels(String[] paramArrayOfString)
        {
          this.labels = paramArrayOfString;
        }
        
        public void setSex(String paramString)
        {
          this.sex = paramString;
        }
        
        public void setZName(String paramString)
        {
          this.zName = paramString;
        }
      }
    }
    
    public static class RefundStepBean
      implements Serializable
    {
      private String pointDes;
      private String pointName;
      private int pointOrder;
      private int pointStatus;
      private String pointTime;
      
      public String getPointDes()
      {
        return this.pointDes;
      }
      
      public String getPointName()
      {
        return this.pointName;
      }
      
      public int getPointOrder()
      {
        return this.pointOrder;
      }
      
      public int getPointStatus()
      {
        return this.pointStatus;
      }
      
      public String getPointTime()
      {
        return this.pointTime;
      }
      
      public void setPointDes(String paramString)
      {
        this.pointDes = paramString;
      }
      
      public void setPointName(String paramString)
      {
        this.pointName = paramString;
      }
      
      public void setPointOrder(int paramInt)
      {
        this.pointOrder = paramInt;
      }
      
      public void setPointStatus(int paramInt)
      {
        this.pointStatus = paramInt;
      }
      
      public void setPointTime(String paramString)
      {
        this.pointTime = paramString;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/StationOrderDetailEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */