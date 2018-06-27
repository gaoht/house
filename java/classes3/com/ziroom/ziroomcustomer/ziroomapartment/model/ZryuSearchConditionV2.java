package com.ziroom.ziroomcustomer.ziroomapartment.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ZryuSearchConditionV2
  extends ZryuBaseResult
  implements Serializable
{
  public Date checkInDate;
  public List<CityListBean> cityList;
  public PriceBean priceBean;
  public List<PriceRangeListBean> priceRangeList;
  public int selectCityIndex;
  public int unlimitPrice;
  public String unlimitPriceStr;
  
  public List<CityListBean> getCityList()
  {
    return this.cityList;
  }
  
  public List<PriceRangeListBean> getPriceRangeList()
  {
    return this.priceRangeList;
  }
  
  public void setCityList(List<CityListBean> paramList)
  {
    this.cityList = paramList;
  }
  
  public void setPriceRangeList(List<PriceRangeListBean> paramList)
  {
    this.priceRangeList = paramList;
  }
  
  public static class CityListBean
  {
    public double centerLat;
    public double centerLon;
    public String cityCode;
    public String cityName;
    
    public double getCenterLat()
    {
      return this.centerLat;
    }
    
    public double getCenterLon()
    {
      return this.centerLon;
    }
    
    public String getCityCode()
    {
      return this.cityCode;
    }
    
    public String getCityName()
    {
      return this.cityName;
    }
    
    public void setCenterLat(double paramDouble)
    {
      this.centerLat = paramDouble;
    }
    
    public void setCenterLon(double paramDouble)
    {
      this.centerLon = paramDouble;
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
  
  public static class PriceBean
  {
    public int maxPrice;
    public int minPrice;
  }
  
  public static class PriceRangeListBean
  {
    public int id;
    public double maxPrice;
    public double minPrice;
    public String rangeDescribe;
    
    public int getId()
    {
      return this.id;
    }
    
    public double getMaxPrice()
    {
      return this.maxPrice;
    }
    
    public double getMinPrice()
    {
      return this.minPrice;
    }
    
    public String getRangeDescribe()
    {
      return this.rangeDescribe;
    }
    
    public void setId(int paramInt)
    {
      this.id = paramInt;
    }
    
    public void setMaxPrice(double paramDouble)
    {
      this.maxPrice = paramDouble;
    }
    
    public void setMinPrice(double paramDouble)
    {
      this.minPrice = paramDouble;
    }
    
    public void setRangeDescribe(String paramString)
    {
      this.rangeDescribe = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/ZryuSearchConditionV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */