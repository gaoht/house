package com.baidu.trace.model;

public class Point
{
  protected LatLng a;
  protected CoordType b = CoordType.bd09ll;
  protected double c;
  protected long d;
  protected int e;
  protected double f;
  protected double g;
  
  public Point() {}
  
  public Point(LatLng paramLatLng, CoordType paramCoordType)
  {
    this.a = paramLatLng;
    this.b = paramCoordType;
  }
  
  public CoordType getCoordType()
  {
    return this.b;
  }
  
  public int getDirection()
  {
    return this.e;
  }
  
  public double getHeight()
  {
    return this.g;
  }
  
  public long getLocTime()
  {
    return this.d;
  }
  
  public LatLng getLocation()
  {
    return this.a;
  }
  
  public double getRadius()
  {
    return this.c;
  }
  
  public double getSpeed()
  {
    return this.f;
  }
  
  public void setCoordType(CoordType paramCoordType)
  {
    this.b = paramCoordType;
  }
  
  public void setDirection(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setHeight(double paramDouble)
  {
    this.g = paramDouble;
  }
  
  public void setLocTime(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void setLocation(LatLng paramLatLng)
  {
    this.a = paramLatLng;
  }
  
  public void setRadius(double paramDouble)
  {
    this.c = paramDouble;
  }
  
  public void setSpeed(double paramDouble)
  {
    this.f = paramDouble;
  }
  
  public String toString()
  {
    return "Point [location=" + this.a + ", coordType=" + this.b + ", radius=" + this.c + ", locTime=" + this.d + ", direction=" + this.e + ", speed=" + this.f + ", height=" + this.g + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/model/Point.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */