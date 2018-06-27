package com.ziroom.ziroomcustomer.ziroomapartment.model;

import java.io.Serializable;

public class ZryuSearchConditionResult
  implements Serializable
{
  private AreaEntity area;
  private String checkInTime;
  private String city;
  private String direction;
  private String floor;
  private boolean isCityAll = false;
  private PriceEntity price;
  private String roomNumber;
  
  public AreaEntity getArea()
  {
    return this.area;
  }
  
  public String getCheckInTime()
  {
    return this.checkInTime;
  }
  
  public String getCity()
  {
    return this.city;
  }
  
  public String getDirection()
  {
    return this.direction;
  }
  
  public String getFloor()
  {
    return this.floor;
  }
  
  public PriceEntity getPrice()
  {
    return this.price;
  }
  
  public String getRoomNumber()
  {
    return this.roomNumber;
  }
  
  public boolean isCityAll()
  {
    return this.isCityAll;
  }
  
  public void setArea(AreaEntity paramAreaEntity)
  {
    this.area = paramAreaEntity;
  }
  
  public void setCheckInTime(String paramString)
  {
    this.checkInTime = paramString;
  }
  
  public void setCity(String paramString)
  {
    this.city = paramString;
  }
  
  public void setCityAll(boolean paramBoolean)
  {
    this.isCityAll = paramBoolean;
  }
  
  public void setDirection(String paramString)
  {
    this.direction = paramString;
  }
  
  public void setFloor(String paramString)
  {
    this.floor = paramString;
  }
  
  public void setPrice(PriceEntity paramPriceEntity)
  {
    this.price = paramPriceEntity;
  }
  
  public void setRoomNumber(String paramString)
  {
    this.roomNumber = paramString;
  }
  
  public static class AreaEntity
    implements Serializable
  {
    private double maxArea;
    private double minArea;
    
    public double getMaxArea()
    {
      return this.maxArea;
    }
    
    public double getMinArea()
    {
      return this.minArea;
    }
    
    public void setMaxArea(double paramDouble)
    {
      this.maxArea = paramDouble;
    }
    
    public void setMinArea(double paramDouble)
    {
      this.minArea = paramDouble;
    }
  }
  
  public static class PriceEntity
    implements Serializable
  {
    private double maxPrice;
    private double minPrice;
    
    public double getMaxPrice()
    {
      return this.maxPrice;
    }
    
    public double getMinPrice()
    {
      return this.minPrice;
    }
    
    public void setMaxPrice(double paramDouble)
    {
      this.maxPrice = paramDouble;
    }
    
    public void setMinPrice(double paramDouble)
    {
      this.minPrice = paramDouble;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/ZryuSearchConditionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */