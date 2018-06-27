package com.ziroom.ziroomcustomer.minsu.mapsojourn.bean;

import com.baidu.mapapi.model.LatLng;

public class ZryMapBuildBean
  extends MinsuMapBean
{
  private double latitude;
  private double longitude;
  private Integer maxPrice;
  private Integer minPrice;
  private String projectBid;
  private String projectName;
  private int status;
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (!(paramObject instanceof ZryMapBuildBean));
          bool1 = bool2;
        } while (!super.equals(paramObject));
        paramObject = (ZryMapBuildBean)paramObject;
        bool1 = bool2;
      } while (Double.compare(((ZryMapBuildBean)paramObject).getLongitude(), getLongitude()) != 0);
      bool1 = bool2;
    } while (Double.compare(((ZryMapBuildBean)paramObject).getLatitude(), getLatitude()) != 0);
    return getProjectBid().equals(((ZryMapBuildBean)paramObject).getProjectBid());
  }
  
  public int getBizType()
  {
    return 3;
  }
  
  public LatLng getLatLng()
  {
    return new LatLng(this.latitude, this.longitude);
  }
  
  public double getLatitude()
  {
    return this.latitude;
  }
  
  public double getLongitude()
  {
    return this.longitude;
  }
  
  public String getMapMarkerCode()
  {
    return null;
  }
  
  public String getMapMarkerDesc()
  {
    if (this.status == 2) {
      return "即将开始";
    }
    StringBuilder localStringBuilder1 = new StringBuilder("");
    if ((this.minPrice != null) && (this.minPrice.intValue() != 0)) {
      localStringBuilder1.append("" + this.minPrice).append("-");
    }
    if ((this.maxPrice != null) && (this.maxPrice.intValue() != 0)) {
      localStringBuilder1.append("" + this.maxPrice);
    }
    if (localStringBuilder1.length() > 0)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("¥").append(localStringBuilder1.toString()).append("/晚");
      return localStringBuilder2.toString();
    }
    return localStringBuilder1.toString();
  }
  
  public String getMapMarkerIcon()
  {
    return null;
  }
  
  public String getMapMarkerName()
  {
    return this.projectName;
  }
  
  public Integer getMaxPrice()
  {
    return this.maxPrice;
  }
  
  public Integer getMinPrice()
  {
    return this.minPrice;
  }
  
  public String getProjectBid()
  {
    return this.projectBid;
  }
  
  public String getProjectName()
  {
    return this.projectName;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public LatLng getTouchLatLng()
  {
    return getLatLng();
  }
  
  public int getType()
  {
    return 3;
  }
  
  public int hashCode()
  {
    int i = getProjectBid().hashCode();
    long l = Double.doubleToLongBits(getLongitude());
    int j = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(getLatitude());
    return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
  }
  
  public void setLatitude(double paramDouble)
  {
    this.latitude = paramDouble;
  }
  
  public void setLongitude(double paramDouble)
  {
    this.longitude = paramDouble;
  }
  
  public void setMaxPrice(Integer paramInteger)
  {
    this.maxPrice = paramInteger;
  }
  
  public void setMinPrice(Integer paramInteger)
  {
    this.minPrice = paramInteger;
  }
  
  public void setProjectBid(String paramString)
  {
    this.projectBid = paramString;
  }
  
  public void setProjectName(String paramString)
  {
    this.projectName = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/mapsojourn/bean/ZryMapBuildBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */