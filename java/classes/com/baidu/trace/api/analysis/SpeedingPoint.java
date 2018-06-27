package com.baidu.trace.api.analysis;

import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;
import com.baidu.trace.model.Point;

public class SpeedingPoint
  extends Point
{
  private double h;
  private double i;
  
  public SpeedingPoint() {}
  
  public SpeedingPoint(CoordType paramCoordType)
  {
    this.b = paramCoordType;
  }
  
  public SpeedingPoint(LatLng paramLatLng, CoordType paramCoordType, long paramLong, double paramDouble1, double paramDouble2)
  {
    this.a = paramLatLng;
    this.b = paramCoordType;
    this.d = paramLong;
    this.h = paramDouble1;
    this.i = paramDouble2;
  }
  
  public double getActualSpeed()
  {
    return this.h;
  }
  
  public double getLimitSpeed()
  {
    return this.i;
  }
  
  public void setActualSpeed(double paramDouble)
  {
    this.h = paramDouble;
  }
  
  public void setLimitSpeed(double paramDouble)
  {
    this.i = paramDouble;
  }
  
  public String toString()
  {
    return "SpeedingPoint [location=" + this.a + ", coordType=" + this.b + ", locTime=" + this.d + ", actualSpeed=" + this.h + ", limitSpeed=" + this.i + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/analysis/SpeedingPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */