package com.baidu.mapapi.model.inner;

public class GeoPoint
{
  private double a;
  private double b;
  
  public GeoPoint(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (paramObject.getClass() != getClass()) {
      return false;
    }
    if ((this.a == ((GeoPoint)paramObject).a) && (this.b == ((GeoPoint)paramObject).b)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public double getLatitudeE6()
  {
    return this.a;
  }
  
  public double getLongitudeE6()
  {
    return this.b;
  }
  
  public void setLatitudeE6(double paramDouble)
  {
    this.a = paramDouble;
  }
  
  public void setLongitudeE6(double paramDouble)
  {
    this.b = paramDouble;
  }
  
  public String toString()
  {
    return "GeoPoint: Latitude: " + this.a + ", Longitude: " + this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/model/inner/GeoPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */