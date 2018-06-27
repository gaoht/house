package com.ziroom.ziroomcustomer.findhouse.model;

import java.util.List;

public class CommuteData
{
  private Double farthest_lat;
  private Double farthest_lng;
  private List<Region> regions;
  private Float scale;
  private Integer zoom;
  
  public Double getFarthest_lat()
  {
    return this.farthest_lat;
  }
  
  public Double getFarthest_lng()
  {
    return this.farthest_lng;
  }
  
  public List<Region> getRegions()
  {
    return this.regions;
  }
  
  public Float getScale()
  {
    return this.scale;
  }
  
  public Integer getZoom()
  {
    return this.zoom;
  }
  
  public void setFarthest_lat(Double paramDouble)
  {
    this.farthest_lat = paramDouble;
  }
  
  public void setFarthest_lng(Double paramDouble)
  {
    this.farthest_lng = paramDouble;
  }
  
  public void setRegions(List<Region> paramList)
  {
    this.regions = paramList;
  }
  
  public void setScale(Float paramFloat)
  {
    this.scale = paramFloat;
  }
  
  public void setZoom(Integer paramInteger)
  {
    this.zoom = paramInteger;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/CommuteData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */