package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuInitSearchBase
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
  
  public String toString()
  {
    return "MinsuInitSearchBase{data=" + this.data + '}';
  }
  
  public static class DataBean
  {
    private List<HotRegionListBean> hotRegionList;
    private List<HouseTypeListBean> houseTypeList;
    private LongTermLeaseDiscountBean longTermLeaseDiscount;
    
    public List<HotRegionListBean> getHotRegionList()
    {
      return this.hotRegionList;
    }
    
    public List<HouseTypeListBean> getHouseTypeList()
    {
      return this.houseTypeList;
    }
    
    public LongTermLeaseDiscountBean getLongTermLeaseDiscount()
    {
      return this.longTermLeaseDiscount;
    }
    
    public void setHotRegionList(List<HotRegionListBean> paramList)
    {
      this.hotRegionList = paramList;
    }
    
    public void setHouseTypeList(List<HouseTypeListBean> paramList)
    {
      this.houseTypeList = paramList;
    }
    
    public void setLongTermLeaseDiscount(LongTermLeaseDiscountBean paramLongTermLeaseDiscountBean)
    {
      this.longTermLeaseDiscount = paramLongTermLeaseDiscountBean;
    }
    
    public String toString()
    {
      return "DataBean{houseTypeList=" + this.houseTypeList + ", hotRegionList=" + this.hotRegionList + '}';
    }
    
    public static class HotRegionListBean
    {
      private String cityCode;
      private Integer hot;
      private Integer id;
      private String latitude;
      private String lineFid;
      private String longitude;
      private String regionName;
      private Integer regionType;
      
      public String getCityCode()
      {
        return this.cityCode;
      }
      
      public Integer getHot()
      {
        return this.hot;
      }
      
      public Integer getId()
      {
        return this.id;
      }
      
      public String getLatitude()
      {
        return this.latitude;
      }
      
      public String getLineFid()
      {
        return this.lineFid;
      }
      
      public String getLongitude()
      {
        return this.longitude;
      }
      
      public String getRegionName()
      {
        return this.regionName;
      }
      
      public Integer getRegionType()
      {
        return this.regionType;
      }
      
      public void setCityCode(String paramString)
      {
        this.cityCode = paramString;
      }
      
      public void setHot(Integer paramInteger)
      {
        this.hot = paramInteger;
      }
      
      public void setId(Integer paramInteger)
      {
        this.id = paramInteger;
      }
      
      public void setLatitude(String paramString)
      {
        this.latitude = paramString;
      }
      
      public void setLineFid(String paramString)
      {
        this.lineFid = paramString;
      }
      
      public void setLongitude(String paramString)
      {
        this.longitude = paramString;
      }
      
      public void setRegionName(String paramString)
      {
        this.regionName = paramString;
      }
      
      public void setRegionType(Integer paramInteger)
      {
        this.regionType = paramInteger;
      }
      
      public String toString()
      {
        return "HotRegionListBean{id=" + this.id + ", cityCode='" + this.cityCode + '\'' + ", regionName='" + this.regionName + '\'' + ", regionType=" + this.regionType + ", longitude='" + this.longitude + '\'' + ", latitude='" + this.latitude + '\'' + ", hot=" + this.hot + ", lineFid='" + this.lineFid + '\'' + '}';
      }
    }
    
    public static class HouseTypeListBean
    {
      private String key;
      private String text;
      
      public String getKey()
      {
        return this.key;
      }
      
      public String getText()
      {
        return this.text;
      }
      
      public void setKey(String paramString)
      {
        this.key = paramString;
      }
      
      public void setText(String paramString)
      {
        this.text = paramString;
      }
      
      public String toString()
      {
        return "HouseTypeListBean{text='" + this.text + '\'' + ", key='" + this.key + '\'' + '}';
      }
    }
    
    public static class LongTermLeaseDiscountBean
    {
      private String title;
      private List<ValuesBean> values;
      
      public String getTitle()
      {
        return this.title;
      }
      
      public List<ValuesBean> getValues()
      {
        return this.values;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public void setValues(List<ValuesBean> paramList)
      {
        this.values = paramList;
      }
      
      public static class ValuesBean
      {
        private int index;
        private String name;
        private String tips;
        private String value;
        
        public int getIndex()
        {
          return this.index;
        }
        
        public String getName()
        {
          return this.name;
        }
        
        public String getTips()
        {
          return this.tips;
        }
        
        public String getValue()
        {
          return this.value;
        }
        
        public void setIndex(int paramInt)
        {
          this.index = paramInt;
        }
        
        public void setName(String paramString)
        {
          this.name = paramString;
        }
        
        public void setTips(String paramString)
        {
          this.tips = paramString;
        }
        
        public void setValue(String paramString)
        {
          this.value = paramString;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuInitSearchBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */