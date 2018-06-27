package com.baidu.trace.api.analysis;

import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;
import com.baidu.trace.model.Point;

public class HarshBreakingPoint
  extends Point
{
  private double h;
  private double i;
  private double j;
  
  public HarshBreakingPoint() {}
  
  public HarshBreakingPoint(CoordType paramCoordType)
  {
    this.b = paramCoordType;
  }
  
  public HarshBreakingPoint(LatLng paramLatLng, CoordType paramCoordType, long paramLong, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    this.a = paramLatLng;
    this.b = paramCoordType;
    this.d = paramLong;
    this.h = paramDouble1;
    this.i = paramDouble2;
    this.j = paramDouble3;
  }
  
  public double getAcceleration()
  {
    return this.h;
  }
  
  public double getEndSpeed()
  {
    return this.j;
  }
  
  public double getInitialSpeed()
  {
    return this.i;
  }
  
  public void setAcceleration(double paramDouble)
  {
    this.h = paramDouble;
  }
  
  public void setEndSpeed(double paramDouble)
  {
    this.j = paramDouble;
  }
  
  public void setInitialSpeed(double paramDouble)
  {
    this.i = paramDouble;
  }
  
  public String toString()
  {
    return "HarshBreakingPoint [location=" + this.a + ", coordType=" + this.b + ", locTime=" + this.d + ", acceleration=" + this.h + ", initialSpeed=" + this.i + ", endSpeed=" + this.j + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/analysis/HarshBreakingPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */