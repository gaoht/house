package com.baidu.trace.api.analysis;

import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.Point;

public class StartPoint
  extends Point
{
  private String h;
  
  public StartPoint() {}
  
  public StartPoint(CoordType paramCoordType)
  {
    this.b = paramCoordType;
  }
  
  public StartPoint(String paramString)
  {
    this.h = paramString;
  }
  
  public String getAddress()
  {
    return this.h;
  }
  
  public void setAddress(String paramString)
  {
    this.h = paramString;
  }
  
  public String toString()
  {
    return "StartPoint [location=" + this.a + ", coordType=" + this.b + ", locTime=" + this.d + ", address=" + this.h + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/analysis/StartPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */