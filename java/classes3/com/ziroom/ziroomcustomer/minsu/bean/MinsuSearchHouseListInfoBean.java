package com.ziroom.ziroomcustomer.minsu.bean;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public class MinsuSearchHouseListInfoBean
  implements Serializable
{
  private String cityCode;
  private String endTime;
  private String hotReginBusiness;
  private String hotReginScenic;
  private String indexOrder;
  private String indexOrderType;
  private String loc;
  private Integer orderType;
  private Integer personCount;
  private Integer priceEnd;
  private Integer priceStart;
  private String q;
  private Integer rentWay;
  private String rentWayName;
  private Integer roomCount;
  private Set<String> services;
  private Map<String, Object> sorts;
  private String startTime;
  
  public String getCityCode()
  {
    return this.cityCode;
  }
  
  public String getEndTime()
  {
    return this.endTime;
  }
  
  public String getHotReginBusiness()
  {
    return this.hotReginBusiness;
  }
  
  public String getHotReginScenic()
  {
    return this.hotReginScenic;
  }
  
  public String getIndexOrder()
  {
    return this.indexOrder;
  }
  
  public String getIndexOrderType()
  {
    return this.indexOrderType;
  }
  
  public String getLoc()
  {
    return this.loc;
  }
  
  public Integer getOrderType()
  {
    return this.orderType;
  }
  
  public Integer getPersonCount()
  {
    return this.personCount;
  }
  
  public Integer getPriceEnd()
  {
    return this.priceEnd;
  }
  
  public Integer getPriceStart()
  {
    return this.priceStart;
  }
  
  public String getQ()
  {
    return this.q;
  }
  
  public Integer getRentWay()
  {
    return this.rentWay;
  }
  
  public String getRentWayName()
  {
    return this.rentWayName;
  }
  
  public Integer getRoomCount()
  {
    return this.roomCount;
  }
  
  public Set<String> getServices()
  {
    return this.services;
  }
  
  public Map<String, Object> getSorts()
  {
    return this.sorts;
  }
  
  public String getStartTime()
  {
    return this.startTime;
  }
  
  public void setCityCode(String paramString)
  {
    this.cityCode = paramString;
  }
  
  public void setEndTime(String paramString)
  {
    this.endTime = paramString;
  }
  
  public void setHotReginBusiness(String paramString)
  {
    this.hotReginBusiness = paramString;
  }
  
  public void setHotReginScenic(String paramString)
  {
    this.hotReginScenic = paramString;
  }
  
  public void setIndexOrder(String paramString)
  {
    this.indexOrder = paramString;
  }
  
  public void setIndexOrderType(String paramString)
  {
    this.indexOrderType = paramString;
  }
  
  public void setLoc(String paramString)
  {
    this.loc = paramString;
  }
  
  public void setOrderType(Integer paramInteger)
  {
    this.orderType = paramInteger;
  }
  
  public void setPersonCount(Integer paramInteger)
  {
    this.personCount = paramInteger;
  }
  
  public void setPriceEnd(Integer paramInteger)
  {
    this.priceEnd = paramInteger;
  }
  
  public void setPriceStart(Integer paramInteger)
  {
    this.priceStart = paramInteger;
  }
  
  public void setQ(String paramString)
  {
    this.q = paramString;
  }
  
  public void setRentWay(Integer paramInteger)
  {
    this.rentWay = paramInteger;
  }
  
  public void setRentWayName(String paramString)
  {
    this.rentWayName = paramString;
  }
  
  public void setRoomCount(Integer paramInteger)
  {
    this.roomCount = paramInteger;
  }
  
  public void setServices(Set<String> paramSet)
  {
    this.services = paramSet;
  }
  
  public void setSorts(Map<String, Object> paramMap)
  {
    this.sorts = paramMap;
  }
  
  public void setStartTime(String paramString)
  {
    this.startTime = paramString;
  }
  
  public String toString()
  {
    return "MinsuSearchHouseListInfoBean{cityCode='" + this.cityCode + '\'' + ", hotReginScenic='" + this.hotReginScenic + '\'' + ", hotReginBusiness='" + this.hotReginBusiness + '\'' + ", q='" + this.q + '\'' + ", rentWay=" + this.rentWay + ", rentWayName='" + this.rentWayName + '\'' + ", orderType=" + this.orderType + ", priceStart=" + this.priceStart + ", priceEnd=" + this.priceEnd + ", personCount=" + this.personCount + ", roomCount=" + this.roomCount + ", services=" + this.services + ", startTime='" + this.startTime + '\'' + ", endTime='" + this.endTime + '\'' + ", indexOrder='" + this.indexOrder + '\'' + ", indexOrderType='" + this.indexOrderType + '\'' + ", sorts=" + this.sorts + ", loc='" + this.loc + '\'' + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuSearchHouseListInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */