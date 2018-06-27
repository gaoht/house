package com.ziroom.ziroomcustomer.ziroomstation.model;

import com.ziroom.ziroomcustomer.ziroomstation.b.a;
import java.util.List;

public class OrderMoneyDetails
  extends a
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
    private int amount;
    private List<ListOrderPriceVoBean> listOrderPriceVo;
    private String promptStr;
    private SubmitParamDtoBean submitParamDto;
    
    public int getAmount()
    {
      return this.amount;
    }
    
    public List<ListOrderPriceVoBean> getListOrderPriceVo()
    {
      return this.listOrderPriceVo;
    }
    
    public String getPromptStr()
    {
      return this.promptStr;
    }
    
    public SubmitParamDtoBean getSubmitParamDto()
    {
      return this.submitParamDto;
    }
    
    public void setAmount(int paramInt)
    {
      this.amount = paramInt;
    }
    
    public void setListOrderPriceVo(List<ListOrderPriceVoBean> paramList)
    {
      this.listOrderPriceVo = paramList;
    }
    
    public void setPromptStr(String paramString)
    {
      this.promptStr = paramString;
    }
    
    public void setSubmitParamDto(SubmitParamDtoBean paramSubmitParamDtoBean)
    {
      this.submitParamDto = paramSubmitParamDtoBean;
    }
    
    public static class ListOrderPriceVoBean
    {
      private List<ListHouseTypePriceBean> listHouseTypePrice;
      private String orderDay;
      
      public List<ListHouseTypePriceBean> getListHouseTypePrice()
      {
        return this.listHouseTypePrice;
      }
      
      public String getOrderDay()
      {
        return this.orderDay;
      }
      
      public void setListHouseTypePrice(List<ListHouseTypePriceBean> paramList)
      {
        this.listHouseTypePrice = paramList;
      }
      
      public void setOrderDay(String paramString)
      {
        this.orderDay = paramString;
      }
      
      public static class ListHouseTypePriceBean
      {
        private Object houseNameForWeb;
        private String houseTypeBid;
        private String houseTypeName;
        private String houseTypeParentBid;
        private String houseTypeParentName;
        private String houseTypeParentShowName;
        private Object houseTypeShowName;
        private int isPreferential;
        private Object preferentialTip;
        private int price;
        private List<PriceDtosBean> priceDtos;
        private int quantity;
        
        public Object getHouseNameForWeb()
        {
          return this.houseNameForWeb;
        }
        
        public String getHouseTypeBid()
        {
          return this.houseTypeBid;
        }
        
        public String getHouseTypeName()
        {
          return this.houseTypeName;
        }
        
        public String getHouseTypeParentBid()
        {
          return this.houseTypeParentBid;
        }
        
        public String getHouseTypeParentName()
        {
          return this.houseTypeParentName;
        }
        
        public String getHouseTypeParentShowName()
        {
          return this.houseTypeParentShowName;
        }
        
        public Object getHouseTypeShowName()
        {
          return this.houseTypeShowName;
        }
        
        public int getIsPreferential()
        {
          return this.isPreferential;
        }
        
        public Object getPreferentialTip()
        {
          return this.preferentialTip;
        }
        
        public int getPrice()
        {
          return this.price;
        }
        
        public List<PriceDtosBean> getPriceDtos()
        {
          return this.priceDtos;
        }
        
        public int getQuantity()
        {
          return this.quantity;
        }
        
        public void setHouseNameForWeb(Object paramObject)
        {
          this.houseNameForWeb = paramObject;
        }
        
        public void setHouseTypeBid(String paramString)
        {
          this.houseTypeBid = paramString;
        }
        
        public void setHouseTypeName(String paramString)
        {
          this.houseTypeName = paramString;
        }
        
        public void setHouseTypeParentBid(String paramString)
        {
          this.houseTypeParentBid = paramString;
        }
        
        public void setHouseTypeParentName(String paramString)
        {
          this.houseTypeParentName = paramString;
        }
        
        public void setHouseTypeParentShowName(String paramString)
        {
          this.houseTypeParentShowName = paramString;
        }
        
        public void setHouseTypeShowName(Object paramObject)
        {
          this.houseTypeShowName = paramObject;
        }
        
        public void setIsPreferential(int paramInt)
        {
          this.isPreferential = paramInt;
        }
        
        public void setPreferentialTip(Object paramObject)
        {
          this.preferentialTip = paramObject;
        }
        
        public void setPrice(int paramInt)
        {
          this.price = paramInt;
        }
        
        public void setPriceDtos(List<PriceDtosBean> paramList)
        {
          this.priceDtos = paramList;
        }
        
        public void setQuantity(int paramInt)
        {
          this.quantity = paramInt;
        }
        
        public static class PriceDtosBean
        {
          private String perDate;
          private int price;
          
          public String getPerDate()
          {
            return this.perDate;
          }
          
          public int getPrice()
          {
            return this.price;
          }
          
          public void setPerDate(String paramString)
          {
            this.perDate = paramString;
          }
          
          public void setPrice(int paramInt)
          {
            this.price = paramInt;
          }
        }
      }
    }
    
    public static class SubmitParamDtoBean
    {
      private String appVersionStr;
      private List<BedCountBean> bedCount;
      private String cityCode;
      private String endDate;
      private String imei;
      private String l;
      private String phoneModel;
      private String projectBid;
      private String source;
      private String startDate;
      private String sysVersionStr;
      private long timestamp;
      private String uuid;
      
      public String getAppVersionStr()
      {
        return this.appVersionStr;
      }
      
      public List<BedCountBean> getBedCount()
      {
        return this.bedCount;
      }
      
      public String getCityCode()
      {
        return this.cityCode;
      }
      
      public String getEndDate()
      {
        return this.endDate;
      }
      
      public String getImei()
      {
        return this.imei;
      }
      
      public String getL()
      {
        return this.l;
      }
      
      public String getPhoneModel()
      {
        return this.phoneModel;
      }
      
      public String getProjectBid()
      {
        return this.projectBid;
      }
      
      public String getSource()
      {
        return this.source;
      }
      
      public String getStartDate()
      {
        return this.startDate;
      }
      
      public String getSysVersionStr()
      {
        return this.sysVersionStr;
      }
      
      public long getTimestamp()
      {
        return this.timestamp;
      }
      
      public String getUuid()
      {
        return this.uuid;
      }
      
      public void setAppVersionStr(String paramString)
      {
        this.appVersionStr = paramString;
      }
      
      public void setBedCount(List<BedCountBean> paramList)
      {
        this.bedCount = paramList;
      }
      
      public void setCityCode(String paramString)
      {
        this.cityCode = paramString;
      }
      
      public void setEndDate(String paramString)
      {
        this.endDate = paramString;
      }
      
      public void setImei(String paramString)
      {
        this.imei = paramString;
      }
      
      public void setL(String paramString)
      {
        this.l = paramString;
      }
      
      public void setPhoneModel(String paramString)
      {
        this.phoneModel = paramString;
      }
      
      public void setProjectBid(String paramString)
      {
        this.projectBid = paramString;
      }
      
      public void setSource(String paramString)
      {
        this.source = paramString;
      }
      
      public void setStartDate(String paramString)
      {
        this.startDate = paramString;
      }
      
      public void setSysVersionStr(String paramString)
      {
        this.sysVersionStr = paramString;
      }
      
      public void setTimestamp(long paramLong)
      {
        this.timestamp = paramLong;
      }
      
      public void setUuid(String paramString)
      {
        this.uuid = paramString;
      }
      
      public static class BedCountBean
      {
        private String houseTypeBid;
        private int quantity;
        
        public String getHouseTypeBid()
        {
          return this.houseTypeBid;
        }
        
        public int getQuantity()
        {
          return this.quantity;
        }
        
        public void setHouseTypeBid(String paramString)
        {
          this.houseTypeBid = paramString;
        }
        
        public void setQuantity(int paramInt)
        {
          this.quantity = paramInt;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/OrderMoneyDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */