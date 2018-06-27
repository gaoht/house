package com.baidu.trace.api.analysis;

import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;
import com.baidu.trace.model.Point;

public class StayPoint
  extends Point
{
  private long h;
  private long i;
  private int j;
  
  public StayPoint() {}
  
  public StayPoint(long paramLong1, long paramLong2, int paramInt, LatLng paramLatLng, CoordType paramCoordType)
  {
    this.h = paramLong1;
    this.i = paramLong2;
    this.j = paramInt;
    this.a = paramLatLng;
    this.b = paramCoordType;
  }
  
  public int getDuration()
  {
    return this.j;
  }
  
  public long getEndTime()
  {
    return this.i;
  }
  
  public LatLng getLocation()
  {
    return this.a;
  }
  
  public long getStartTime()
  {
    return this.h;
  }
  
  public void setDuration(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setEndTime(long paramLong)
  {
    this.i = paramLong;
  }
  
  public void setLocation(LatLng paramLatLng)
  {
    this.a = paramLatLng;
  }
  
  public void setStartTime(long paramLong)
  {
    this.h = paramLong;
  }
  
  public String toString()
  {
    return "StayPoint [startTime=" + this.h + ", endTime=" + this.i + ", duration=" + this.j + ", location=" + this.a + ", coordType=" + this.b + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/analysis/StayPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */