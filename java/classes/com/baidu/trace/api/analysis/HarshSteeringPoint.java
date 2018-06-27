package com.baidu.trace.api.analysis;

import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;
import com.baidu.trace.model.Point;

public class HarshSteeringPoint
  extends Point
{
  private double h;
  private TurnType i;
  private double j;
  
  public HarshSteeringPoint() {}
  
  public HarshSteeringPoint(CoordType paramCoordType)
  {
    this.b = paramCoordType;
  }
  
  public HarshSteeringPoint(LatLng paramLatLng, CoordType paramCoordType, long paramLong, double paramDouble1, TurnType paramTurnType, double paramDouble2)
  {
    this.a = paramLatLng;
    this.b = paramCoordType;
    this.d = paramLong;
    this.h = paramDouble1;
    this.i = paramTurnType;
    this.j = paramDouble2;
  }
  
  public double getCentripetalAcceleration()
  {
    return this.h;
  }
  
  public double getTurnSpeed()
  {
    return this.j;
  }
  
  public TurnType getTurnType()
  {
    return this.i;
  }
  
  public void setCentripetalAcceleration(double paramDouble)
  {
    this.h = paramDouble;
  }
  
  public void setTurnSpeed(double paramDouble)
  {
    this.j = paramDouble;
  }
  
  public void setTurnType(TurnType paramTurnType)
  {
    this.i = paramTurnType;
  }
  
  public String toString()
  {
    return "HarshSteeringPoint [location=" + this.a + ", coordType=" + this.b + ", locTime=" + this.d + ", centripetalAcceleration=" + this.h + ", turnType=" + this.i + ", turnSpeed=" + this.j + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/analysis/HarshSteeringPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */