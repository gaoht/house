package com.ziroom.ziroomcustomer.minsu.bean;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public class MinsuSearchHouseInfoBean
  implements Serializable
{
  private String areaCode;
  private String cityCode;
  private String cityName;
  private String endTime;
  private String hotReginBusiness;
  private String hotReginScenic;
  private String houseType;
  private String indexOrder;
  private String indexOrderType;
  private String jiaxinDiscount;
  public String lineFid;
  private String loc;
  private String longTermDiscount;
  private Integer orderType;
  private Integer personCount;
  private Integer priceEnd;
  private Integer priceStart;
  private String q;
  private Integer rentWay;
  private String rentWayName;
  private Integer roomCount;
  private Set<String> services;
  private String sortType;
  private Map<String, Object> sorts;
  private String startTime;
  private String subway;
  public String subwayCode;
  
  private boolean checkIntegerF(Integer paramInteger)
  {
    return (paramInteger != null) && (paramInteger.intValue() != -1);
  }
  
  public String getAreaCode()
  {
    return this.areaCode;
  }
  
  public int getCheckConfCount()
  {
    int j = 0;
    if (checkIntegerF(getRentWay())) {
      j = 1;
    }
    int i = j;
    if (checkIntegerF(getOrderType())) {
      i = j + 1;
    }
    j = i;
    if (checkIntegerF(getRoomCount())) {
      j = i + 1;
    }
    if (!checkIntegerF(getPriceStart()))
    {
      i = j;
      if (!checkIntegerF(getPriceEnd())) {}
    }
    else
    {
      i = j + 1;
    }
    j = i;
    if (!TextUtils.isEmpty(getHouseType())) {
      j = i + 1;
    }
    if (TextUtils.isEmpty(getLongTermDiscount()))
    {
      i = j;
      if (TextUtils.isEmpty(getJiaxinDiscount())) {}
    }
    else
    {
      i = j + 1;
    }
    return i;
  }
  
  public String getCityCode()
  {
    return this.cityCode;
  }
  
  public String getCityName()
  {
    return this.cityName;
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
  
  public String getHouseType()
  {
    return this.houseType;
  }
  
  public String getIndexOrder()
  {
    return this.indexOrder;
  }
  
  public String getIndexOrderType()
  {
    return this.indexOrderType;
  }
  
  public String getJiaxinDiscount()
  {
    return this.jiaxinDiscount;
  }
  
  public String getLineFid()
  {
    return this.lineFid;
  }
  
  public String getLoc()
  {
    return this.loc;
  }
  
  public String getLongTermDiscount()
  {
    return this.longTermDiscount;
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
  
  public String getSortType()
  {
    return this.sortType;
  }
  
  public Map<String, Object> getSorts()
  {
    return this.sorts;
  }
  
  public String getStartTime()
  {
    return this.startTime;
  }
  
  public String getSubway()
  {
    return this.subway;
  }
  
  public String getSubwayCode()
  {
    return this.subwayCode;
  }
  
  public void setAreaCode(String paramString)
  {
    this.areaCode = paramString;
  }
  
  public void setCityCode(String paramString)
  {
    this.cityCode = paramString;
  }
  
  public void setCityName(String paramString)
  {
    this.cityName = paramString;
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
  
  public void setHouseType(String paramString)
  {
    this.houseType = paramString;
  }
  
  public void setIndexOrder(String paramString)
  {
    this.indexOrder = paramString;
  }
  
  public void setIndexOrderType(String paramString)
  {
    this.indexOrderType = paramString;
  }
  
  public void setJiaxinDiscount(String paramString)
  {
    this.jiaxinDiscount = paramString;
  }
  
  public void setLineFid(String paramString)
  {
    this.lineFid = paramString;
  }
  
  public void setLoc(String paramString)
  {
    this.loc = paramString;
  }
  
  public void setLongTermDiscount(String paramString)
  {
    this.longTermDiscount = paramString;
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
  
  public void setSortType(String paramString)
  {
    this.sortType = paramString;
  }
  
  public void setSorts(Map<String, Object> paramMap)
  {
    this.sorts = paramMap;
  }
  
  public void setStartTime(String paramString)
  {
    this.startTime = paramString;
  }
  
  public void setSubway(String paramString)
  {
    this.subway = paramString;
  }
  
  public void setSubwayCode(String paramString)
  {
    this.subwayCode = paramString;
  }
  
  public String toString()
  {
    return "MinsuSearchHouseInfoBean{cityCode='" + this.cityCode + '\'' + ", cityName='" + this.cityName + '\'' + ", hotReginScenic='" + this.hotReginScenic + '\'' + ", hotReginBusiness='" + this.hotReginBusiness + '\'' + ", q='" + this.q + '\'' + ", rentWay=" + this.rentWay + ", rentWayName='" + this.rentWayName + '\'' + ", orderType=" + this.orderType + ", priceStart=" + this.priceStart + ", priceEnd=" + this.priceEnd + ", personCount=" + this.personCount + ", roomCount=" + this.roomCount + ", services=" + this.services + ", startTime='" + this.startTime + '\'' + ", endTime='" + this.endTime + '\'' + ", indexOrder='" + this.indexOrder + '\'' + ", indexOrderType='" + this.indexOrderType + '\'' + ", sorts=" + this.sorts + ", sortType='" + this.sortType + '\'' + ", subway='" + this.subway + '\'' + ", areaCode='" + this.areaCode + '\'' + ", houseType=" + this.houseType + ", longTermDiscount=" + this.longTermDiscount + ", subwayCode='" + this.subwayCode + '\'' + ", loc='" + this.loc + '\'' + ", lineFid='" + this.lineFid + '\'' + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuSearchHouseInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */