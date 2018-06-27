package com.baidu.trace.api.fence;

import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;

public class AlarmPoint
{
  protected LatLng a;
  protected CoordType b;
  protected long c;
  protected double d;
  private long e;
  
  public AlarmPoint() {}
  
  public AlarmPoint(LatLng paramLatLng, CoordType paramCoordType, long paramLong, double paramDouble)
  {
    this.a = paramLatLng;
    this.b = paramCoordType;
    this.c = paramLong;
    this.d = paramDouble;
  }
  
  public AlarmPoint(LatLng paramLatLng, CoordType paramCoordType, long paramLong1, long paramLong2, double paramDouble)
  {
    this.a = paramLatLng;
    this.b = paramCoordType;
    this.c = paramLong1;
    this.e = paramLong2;
    this.d = paramDouble;
  }
  
  public CoordType getCoordType()
  {
    return this.b;
  }
  
  public long getCreateTime()
  {
    return this.e;
  }
  
  public long getLocTime()
  {
    return this.c;
  }
  
  public LatLng getLocation()
  {
    return this.a;
  }
  
  public double getRadius()
  {
    return this.d;
  }
  
  public void setCoordType(CoordType paramCoordType)
  {
    this.b = paramCoordType;
  }
  
  public void setCreateTime(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void setLocTime(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void setLocation(LatLng paramLatLng)
  {
    this.a = paramLatLng;
  }
  
  public void setRadius(double paramDouble)
  {
    this.d = paramDouble;
  }
  
  public String toString()
  {
    return "AlarmPoint [location=" + this.a + ", coordType=" + this.b + ", locTime=" + this.c + ", createTime=" + this.e + ", radius = " + this.d + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/AlarmPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */