package com.ziroom.ziroomcustomer.ziroomapartment.model;

import java.io.Serializable;
import java.util.List;

public class ZryuSearchCondition
  extends ZryuBaseResult
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
  {
    private AreaBean area;
    private List<CheckInTimeBean> checkInTime;
    private List<CityListBean> cityList;
    private List<DirectionListBean> directionList;
    private List<FloorNumberListBean> floorNumberList;
    private PriceBean price;
    private RoomNumberBean roomNumber;
    private List<SortListBean> sortList;
    
    public AreaBean getArea()
    {
      return this.area;
    }
    
    public List<CheckInTimeBean> getCheckInTime()
    {
      return this.checkInTime;
    }
    
    public List<CityListBean> getCityList()
    {
      return this.cityList;
    }
    
    public List<DirectionListBean> getDirectionList()
    {
      return this.directionList;
    }
    
    public List<FloorNumberListBean> getFloorNumberList()
    {
      return this.floorNumberList;
    }
    
    public PriceBean getPrice()
    {
      return this.price;
    }
    
    public RoomNumberBean getRoomNumber()
    {
      return this.roomNumber;
    }
    
    public List<SortListBean> getSortList()
    {
      return this.sortList;
    }
    
    public void setArea(AreaBean paramAreaBean)
    {
      this.area = paramAreaBean;
    }
    
    public void setCheckInTime(List<CheckInTimeBean> paramList)
    {
      this.checkInTime = paramList;
    }
    
    public void setCityList(List<CityListBean> paramList)
    {
      this.cityList = paramList;
    }
    
    public void setDirectionList(List<DirectionListBean> paramList)
    {
      this.directionList = paramList;
    }
    
    public void setFloorNumberList(List<FloorNumberListBean> paramList)
    {
      this.floorNumberList = paramList;
    }
    
    public void setPrice(PriceBean paramPriceBean)
    {
      this.price = paramPriceBean;
    }
    
    public void setRoomNumber(RoomNumberBean paramRoomNumberBean)
    {
      this.roomNumber = paramRoomNumberBean;
    }
    
    public void setSortList(List<SortListBean> paramList)
    {
      this.sortList = paramList;
    }
    
    public static class AreaBean
    {
      private int maxArea;
      private int minArea;
      
      public int getMaxArea()
      {
        return this.maxArea;
      }
      
      public int getMinArea()
      {
        return this.minArea;
      }
      
      public void setMaxArea(int paramInt)
      {
        this.maxArea = paramInt;
      }
      
      public void setMinArea(int paramInt)
      {
        this.minArea = paramInt;
      }
    }
    
    public static class CheckInTimeBean
    {
      private String name;
      private int state;
      
      public String getName()
      {
        return this.name;
      }
      
      public int getState()
      {
        return this.state;
      }
      
      public void setName(String paramString)
      {
        this.name = paramString;
      }
      
      public void setState(int paramInt)
      {
        this.state = paramInt;
      }
    }
    
    public static class CityListBean
    {
      private String cityCode;
      private String cityName;
      
      public String getCityCode()
      {
        return this.cityCode;
      }
      
      public String getCityName()
      {
        return this.cityName;
      }
      
      public void setCityCode(String paramString)
      {
        this.cityCode = paramString;
      }
      
      public void setCityName(String paramString)
      {
        this.cityName = paramString;
      }
    }
    
    public static class DirectionListBean
    {
      private String name;
      private int state;
      
      public String getName()
      {
        return this.name;
      }
      
      public int getState()
      {
        return this.state;
      }
      
      public void setName(String paramString)
      {
        this.name = paramString;
      }
      
      public void setState(int paramInt)
      {
        this.state = paramInt;
      }
    }
    
    public static class FloorNumberListBean
    {
      private String name;
      private int state;
      
      public String getName()
      {
        return this.name;
      }
      
      public int getState()
      {
        return this.state;
      }
      
      public void setName(String paramString)
      {
        this.name = paramString;
      }
      
      public void setState(int paramInt)
      {
        this.state = paramInt;
      }
    }
    
    public static class PriceBean
    {
      private int maxPrice;
      private int minPrice;
      
      public int getMaxPrice()
      {
        return this.maxPrice;
      }
      
      public int getMinPrice()
      {
        return this.minPrice;
      }
      
      public void setMaxPrice(int paramInt)
      {
        this.maxPrice = paramInt;
      }
      
      public void setMinPrice(int paramInt)
      {
        this.minPrice = paramInt;
      }
    }
    
    public static class RoomNumberBean
    {
      private boolean state;
      
      public boolean isState()
      {
        return this.state;
      }
      
      public void setState(boolean paramBoolean)
      {
        this.state = paramBoolean;
      }
    }
    
    public static class SortListBean
      implements Comparable<SortListBean>
    {
      private String code;
      private int order;
      
      public int compareTo(SortListBean paramSortListBean)
      {
        if (this.order > paramSortListBean.order) {
          return 1;
        }
        if (this.order < paramSortListBean.order) {
          return -1;
        }
        return 0;
      }
      
      public String getCode()
      {
        return this.code;
      }
      
      public int getOrder()
      {
        return this.order;
      }
      
      public void setCode(String paramString)
      {
        this.code = paramString;
      }
      
      public void setOrder(int paramInt)
      {
        this.order = paramInt;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/ZryuSearchCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */