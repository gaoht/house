package com.baidu.trace.api.track;

import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;
import com.baidu.trace.model.Point;
import java.util.Map;

public class LatestPoint
  extends Point
{
  private String h;
  private String i;
  private Map<String, String> j;
  
  public LatestPoint() {}
  
  public LatestPoint(LatLng paramLatLng, CoordType paramCoordType)
  {
    super(paramLatLng, paramCoordType);
  }
  
  public LatestPoint(LatLng paramLatLng, CoordType paramCoordType, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    super(paramLatLng, paramCoordType);
    this.h = paramString1;
    this.i = paramString2;
    this.j = paramMap;
  }
  
  public Map<String, String> getColumns()
  {
    return this.j;
  }
  
  public String getFloor()
  {
    return this.h;
  }
  
  public String getObjectName()
  {
    return this.i;
  }
  
  public void setColumns(Map<String, String> paramMap)
  {
    this.j = paramMap;
  }
  
  public void setFloor(String paramString)
  {
    this.h = paramString;
  }
  
  public void setObjectName(String paramString)
  {
    this.i = paramString;
  }
  
  public String toString()
  {
    return "LatestPoint [location=" + this.a + ", coordType=" + this.b + ", radius=" + this.c + ", locTime=" + this.d + ", direction=" + this.e + ", speed=" + this.f + ", height=" + this.g + ", floor=" + this.h + ", objectName=" + this.i + ", columns=" + this.j + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/track/LatestPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */