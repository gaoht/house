package com.baidu.trace.api.entity;

import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.Point;
import java.util.Map;

public class LatestLocation
  extends Point
{
  private String h;
  private double i;
  private String j;
  private Map<String, String> k;
  
  public LatestLocation() {}
  
  public LatestLocation(CoordType paramCoordType)
  {
    this.b = paramCoordType;
  }
  
  public LatestLocation(String paramString, double paramDouble)
  {
    this.h = paramString;
    this.i = paramDouble;
  }
  
  public Map<String, String> getColumns()
  {
    return this.k;
  }
  
  public double getDistance()
  {
    return this.i;
  }
  
  public String getFloor()
  {
    return this.h;
  }
  
  public String getObjectName()
  {
    return this.j;
  }
  
  public void setColumns(Map<String, String> paramMap)
  {
    this.k = paramMap;
  }
  
  public void setDistance(double paramDouble)
  {
    this.i = paramDouble;
  }
  
  public void setFloor(String paramString)
  {
    this.h = paramString;
  }
  
  public void setObjectName(String paramString)
  {
    this.j = paramString;
  }
  
  public String toString()
  {
    return "LatestLocation [location=" + this.a + ", coordType=" + this.b + ", radius=" + this.c + ", locTime=" + this.d + ", direction=" + this.e + ", speed=" + this.f + ", height=" + this.g + ", floor=" + this.h + ", distance=" + this.i + ", objectName=" + this.j + ", columns=" + this.k + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/entity/LatestLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */