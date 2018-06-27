package com.baidu.trace.api.track;

import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.Point;
import java.util.Map;

public class TrackPoint
  extends Point
{
  private String h;
  private String i;
  private Map<String, String> j;
  
  public TrackPoint() {}
  
  public TrackPoint(CoordType paramCoordType)
  {
    this.b = paramCoordType;
  }
  
  public TrackPoint(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    this.h = paramString1;
    this.i = paramString2;
    this.j = paramMap;
  }
  
  public Map<String, String> getColumns()
  {
    return this.j;
  }
  
  public String getCreateTime()
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
  
  public void setCreateTime(String paramString)
  {
    this.h = paramString;
  }
  
  public void setObjectName(String paramString)
  {
    this.i = paramString;
  }
  
  public String toString()
  {
    return "TrackPoint [location=" + this.a + ", coordType=" + this.b + ", radius=" + this.c + ", locTime=" + this.d + ", direction=" + this.e + ", speed=" + this.f + ", height=" + this.g + ", createTime=" + this.h + ", objectName=" + this.i + ", columns=" + this.j + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/track/TrackPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */