package com.baidu.trace.api.analysis;

import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.Point;

public class EndPoint
  extends Point
{
  private String h;
  
  public EndPoint() {}
  
  public EndPoint(CoordType paramCoordType)
  {
    this.b = paramCoordType;
  }
  
  public EndPoint(String paramString)
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
    return "EndPoint [location=" + this.a + ", coordType=" + this.b + ", locTime=" + this.d + ", address=" + this.h + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/analysis/EndPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */