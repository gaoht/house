package com.baidu.trace.model;

public final class LatLng
{
  public double latitude;
  public double longitude;
  
  public LatLng() {}
  
  public LatLng(double paramDouble1, double paramDouble2)
  {
    this.latitude = paramDouble1;
    this.longitude = paramDouble2;
  }
  
  public final double getLatitude()
  {
    return this.latitude;
  }
  
  public final double getLongitude()
  {
    return this.longitude;
  }
  
  public final void setLatitude(double paramDouble)
  {
    this.latitude = paramDouble;
  }
  
  public final void setLongitude(double paramDouble)
  {
    this.longitude = paramDouble;
  }
  
  public final String toString()
  {
    return "LatLng [latitude=" + this.latitude + ", longitude=" + this.longitude + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/model/LatLng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */