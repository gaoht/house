package com.ziroom.ziroomcustomer.ziroomapartment.model;

import java.util.List;

public class ZryHouseTypeRoom
{
  private int pageNum;
  private int pageSize;
  private int pageStart;
  private PriceDtoBean priceDto;
  private String priceTag;
  private String proAddr;
  private String proHeadPic;
  private String proName;
  private List<RoomDetailDtoListBean> roomDetailDtoList;
  private int total;
  
  public int getPageNum()
  {
    return this.pageNum;
  }
  
  public int getPageSize()
  {
    return this.pageSize;
  }
  
  public int getPageStart()
  {
    return this.pageStart;
  }
  
  public PriceDtoBean getPriceDto()
  {
    return this.priceDto;
  }
  
  public String getPriceTag()
  {
    return this.priceTag;
  }
  
  public String getProAddr()
  {
    return this.proAddr;
  }
  
  public String getProHeadPic()
  {
    return this.proHeadPic;
  }
  
  public String getProName()
  {
    return this.proName;
  }
  
  public List<RoomDetailDtoListBean> getRoomDetailDtoList()
  {
    return this.roomDetailDtoList;
  }
  
  public int getTotal()
  {
    return this.total;
  }
  
  public void setPageNum(int paramInt)
  {
    this.pageNum = paramInt;
  }
  
  public void setPageSize(int paramInt)
  {
    this.pageSize = paramInt;
  }
  
  public void setPageStart(int paramInt)
  {
    this.pageStart = paramInt;
  }
  
  public void setPriceDto(PriceDtoBean paramPriceDtoBean)
  {
    this.priceDto = paramPriceDtoBean;
  }
  
  public void setPriceTag(String paramString)
  {
    this.priceTag = paramString;
  }
  
  public void setProAddr(String paramString)
  {
    this.proAddr = paramString;
  }
  
  public void setProHeadPic(String paramString)
  {
    this.proHeadPic = paramString;
  }
  
  public void setProName(String paramString)
  {
    this.proName = paramString;
  }
  
  public void setRoomDetailDtoList(List<RoomDetailDtoListBean> paramList)
  {
    this.roomDetailDtoList = paramList;
  }
  
  public void setTotal(int paramInt)
  {
    this.total = paramInt;
  }
  
  public String toString()
  {
    return "ZryHouseTypeRoom{pageNum=" + this.pageNum + ", pageSize=" + this.pageSize + ", total=" + this.total + ", priceDto=" + this.priceDto + ", proName='" + this.proName + '\'' + ", proAddr='" + this.proAddr + '\'' + ", proHeadPic='" + this.proHeadPic + '\'' + ", priceTag='" + this.priceTag + '\'' + ", pageStart=" + this.pageStart + ", roomDetailDtoList=" + this.roomDetailDtoList + '}';
  }
  
  public static class PriceDtoBean
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
    
    public String toString()
    {
      return "PriceDtoBean{minPrice=" + this.minPrice + ", maxPrice=" + this.maxPrice + '}';
    }
  }
  
  public static class RoomDetailDtoListBean
  {
    private String avaSignDate;
    private String currentState;
    private String direction;
    private int floorNumber;
    private String id;
    private int longPrice;
    private int roomArea;
    private String roomNumber;
    private String stateName;
    
    public String getAvaSignDate()
    {
      return this.avaSignDate;
    }
    
    public String getCurrentState()
    {
      return this.currentState;
    }
    
    public String getDirection()
    {
      return this.direction;
    }
    
    public int getFloorNumber()
    {
      return this.floorNumber;
    }
    
    public String getId()
    {
      return this.id;
    }
    
    public int getLongPrice()
    {
      return this.longPrice;
    }
    
    public int getRoomArea()
    {
      return this.roomArea;
    }
    
    public String getRoomNumber()
    {
      return this.roomNumber;
    }
    
    public String getStateName()
    {
      return this.stateName;
    }
    
    public void setAvaSignDate(String paramString)
    {
      this.avaSignDate = paramString;
    }
    
    public void setCurrentState(String paramString)
    {
      this.currentState = paramString;
    }
    
    public void setDirection(String paramString)
    {
      this.direction = paramString;
    }
    
    public void setFloorNumber(int paramInt)
    {
      this.floorNumber = paramInt;
    }
    
    public void setId(String paramString)
    {
      this.id = paramString;
    }
    
    public void setLongPrice(int paramInt)
    {
      this.longPrice = paramInt;
    }
    
    public void setRoomArea(int paramInt)
    {
      this.roomArea = paramInt;
    }
    
    public void setRoomNumber(String paramString)
    {
      this.roomNumber = paramString;
    }
    
    public void setStateName(String paramString)
    {
      this.stateName = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/ZryHouseTypeRoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */