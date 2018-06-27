package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

import java.util.List;

public class LandlordReleaseTypeLocationInfo
{
  private DataBean data;
  private String message;
  private String status;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public static class DataBean
  {
    private BaiduLocationBean baiduLocation;
    private CommunityNameBean communityName;
    private GoogleLocationBean googleLocation;
    private String hallContent;
    private HouseNumberBean houseNumber;
    private HouseRentWayBean houseRentWay;
    private HouseStreetBean houseStreet;
    private HouseTypeBean houseType;
    private RegionMsgBean regionMsg;
    
    public BaiduLocationBean getBaiduLocation()
    {
      return this.baiduLocation;
    }
    
    public CommunityNameBean getCommunityName()
    {
      return this.communityName;
    }
    
    public GoogleLocationBean getGoogleLocation()
    {
      return this.googleLocation;
    }
    
    public String getHallContent()
    {
      return this.hallContent;
    }
    
    public HouseNumberBean getHouseNumber()
    {
      return this.houseNumber;
    }
    
    public HouseRentWayBean getHouseRentWay()
    {
      return this.houseRentWay;
    }
    
    public HouseStreetBean getHouseStreet()
    {
      return this.houseStreet;
    }
    
    public HouseTypeBean getHouseType()
    {
      return this.houseType;
    }
    
    public RegionMsgBean getRegionMsg()
    {
      return this.regionMsg;
    }
    
    public void setBaiduLocation(BaiduLocationBean paramBaiduLocationBean)
    {
      this.baiduLocation = paramBaiduLocationBean;
    }
    
    public void setCommunityName(CommunityNameBean paramCommunityNameBean)
    {
      this.communityName = paramCommunityNameBean;
    }
    
    public void setGoogleLocation(GoogleLocationBean paramGoogleLocationBean)
    {
      this.googleLocation = paramGoogleLocationBean;
    }
    
    public void setHallContent(String paramString)
    {
      this.hallContent = paramString;
    }
    
    public void setHouseNumber(HouseNumberBean paramHouseNumberBean)
    {
      this.houseNumber = paramHouseNumberBean;
    }
    
    public void setHouseRentWay(HouseRentWayBean paramHouseRentWayBean)
    {
      this.houseRentWay = paramHouseRentWayBean;
    }
    
    public void setHouseStreet(HouseStreetBean paramHouseStreetBean)
    {
      this.houseStreet = paramHouseStreetBean;
    }
    
    public void setHouseType(HouseTypeBean paramHouseTypeBean)
    {
      this.houseType = paramHouseTypeBean;
    }
    
    public void setRegionMsg(RegionMsgBean paramRegionMsgBean)
    {
      this.regionMsg = paramRegionMsgBean;
    }
    
    public static class BaiduLocationBean
    {
      private boolean isEdit;
      private String value;
      
      public String getValue()
      {
        return this.value;
      }
      
      public boolean isIsEdit()
      {
        return this.isEdit;
      }
      
      public void setIsEdit(boolean paramBoolean)
      {
        this.isEdit = paramBoolean;
      }
      
      public void setValue(String paramString)
      {
        this.value = paramString;
      }
    }
    
    public static class CommunityNameBean
    {
      private boolean isEdit;
      private String value;
      
      public String getValue()
      {
        return this.value;
      }
      
      public boolean isIsEdit()
      {
        return this.isEdit;
      }
      
      public void setIsEdit(boolean paramBoolean)
      {
        this.isEdit = paramBoolean;
      }
      
      public void setValue(String paramString)
      {
        this.value = paramString;
      }
    }
    
    public static class GoogleLocationBean
    {
      private boolean isEdit;
      private String value;
      
      public String getValue()
      {
        return this.value;
      }
      
      public boolean isIsEdit()
      {
        return this.isEdit;
      }
      
      public void setIsEdit(boolean paramBoolean)
      {
        this.isEdit = paramBoolean;
      }
      
      public void setValue(String paramString)
      {
        this.value = paramString;
      }
    }
    
    public static class HouseNumberBean
    {
      private boolean isEdit;
      private String value;
      
      public String getValue()
      {
        return this.value;
      }
      
      public boolean isIsEdit()
      {
        return this.isEdit;
      }
      
      public void setIsEdit(boolean paramBoolean)
      {
        this.isEdit = paramBoolean;
      }
      
      public void setValue(String paramString)
      {
        this.value = paramString;
      }
    }
    
    public static class HouseRentWayBean
    {
      private boolean isEdit;
      private List<ListBean> list;
      
      public List<ListBean> getList()
      {
        return this.list;
      }
      
      public boolean isIsEdit()
      {
        return this.isEdit;
      }
      
      public void setIsEdit(boolean paramBoolean)
      {
        this.isEdit = paramBoolean;
      }
      
      public void setList(List<ListBean> paramList)
      {
        this.list = paramList;
      }
      
      public static class ListBean
      {
        private String explain;
        private boolean isSelect;
        private String text;
        private int value;
        
        public String getExplain()
        {
          return this.explain;
        }
        
        public String getText()
        {
          return this.text;
        }
        
        public int getValue()
        {
          return this.value;
        }
        
        public boolean isIsSelect()
        {
          return this.isSelect;
        }
        
        public void setExplain(String paramString)
        {
          this.explain = paramString;
        }
        
        public void setIsSelect(boolean paramBoolean)
        {
          this.isSelect = paramBoolean;
        }
        
        public void setText(String paramString)
        {
          this.text = paramString;
        }
        
        public void setValue(int paramInt)
        {
          this.value = paramInt;
        }
      }
    }
    
    public static class HouseStreetBean
    {
      private boolean isEdit;
      private String value;
      
      public String getValue()
      {
        return this.value;
      }
      
      public boolean isIsEdit()
      {
        return this.isEdit;
      }
      
      public void setIsEdit(boolean paramBoolean)
      {
        this.isEdit = paramBoolean;
      }
      
      public void setValue(String paramString)
      {
        this.value = paramString;
      }
    }
    
    public static class HouseTypeBean
    {
      private boolean isEdit;
      private List<ListBeanX> list;
      
      public List<ListBeanX> getList()
      {
        return this.list;
      }
      
      public boolean isIsEdit()
      {
        return this.isEdit;
      }
      
      public void setIsEdit(boolean paramBoolean)
      {
        this.isEdit = paramBoolean;
      }
      
      public void setList(List<ListBeanX> paramList)
      {
        this.list = paramList;
      }
      
      public static class ListBeanX
      {
        private Object explain;
        private boolean isSelect;
        private String text;
        private int value;
        
        public Object getExplain()
        {
          return this.explain;
        }
        
        public String getText()
        {
          return this.text;
        }
        
        public int getValue()
        {
          return this.value;
        }
        
        public boolean isIsSelect()
        {
          return this.isSelect;
        }
        
        public void setExplain(Object paramObject)
        {
          this.explain = paramObject;
        }
        
        public void setIsSelect(boolean paramBoolean)
        {
          this.isSelect = paramBoolean;
        }
        
        public void setText(String paramString)
        {
          this.text = paramString;
        }
        
        public void setValue(int paramInt)
        {
          this.value = paramInt;
        }
      }
    }
    
    public static class RegionMsgBean
    {
      private boolean isEdit;
      private String text;
      private String value;
      
      public String getText()
      {
        return this.text;
      }
      
      public String getValue()
      {
        return this.value;
      }
      
      public boolean isIsEdit()
      {
        return this.isEdit;
      }
      
      public void setIsEdit(boolean paramBoolean)
      {
        this.isEdit = paramBoolean;
      }
      
      public void setText(String paramString)
      {
        this.text = paramString;
      }
      
      public void setValue(String paramString)
      {
        this.value = paramString;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/LandlordReleaseTypeLocationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */