package com.baidu.trace.api.analysis;

import java.util.List;

public class SpeedingInfo
{
  private double a;
  private List<SpeedingPoint> b;
  
  public SpeedingInfo() {}
  
  public SpeedingInfo(double paramDouble, List<SpeedingPoint> paramList)
  {
    this.a = paramDouble;
    this.b = paramList;
  }
  
  public double getDistance()
  {
    return this.a;
  }
  
  public List<SpeedingPoint> getPoints()
  {
    return this.b;
  }
  
  public void setDistance(double paramDouble)
  {
    this.a = paramDouble;
  }
  
  public void setPoints(List<SpeedingPoint> paramList)
  {
    this.b = paramList;
  }
  
  public String toString()
  {
    return "SpeedingInfo [distance=" + this.a + ", points=" + this.b + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/analysis/SpeedingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */