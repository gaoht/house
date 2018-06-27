package com.baidu.trace.api.track;

import com.baidu.trace.model.BaseResponse;
import com.baidu.trace.model.Point;
import java.util.List;

public final class HistoryTrackResponse
  extends BaseResponse
{
  private int a;
  private int b;
  private String c;
  private double d;
  private double e;
  private Point f;
  private Point g;
  public List<TrackPoint> trackPoints;
  
  public HistoryTrackResponse() {}
  
  public HistoryTrackResponse(int paramInt1, int paramInt2, String paramString)
  {
    super(paramInt1, paramInt2, paramString);
  }
  
  public HistoryTrackResponse(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2, double paramDouble1, double paramDouble2, Point paramPoint1, Point paramPoint2, List<TrackPoint> paramList)
  {
    super(paramInt1, paramInt2, paramString1);
    this.a = paramInt3;
    this.b = paramInt4;
    this.c = paramString2;
    this.d = paramDouble1;
    this.e = paramDouble2;
    this.f = paramPoint1;
    this.g = paramPoint2;
    this.trackPoints = paramList;
  }
  
  public final double getDistance()
  {
    return this.d;
  }
  
  public final Point getEndPoint()
  {
    return this.g;
  }
  
  public final String getEntityName()
  {
    return this.c;
  }
  
  public final int getSize()
  {
    return this.b;
  }
  
  public final Point getStartPoint()
  {
    return this.f;
  }
  
  public final double getTollDistance()
  {
    return this.e;
  }
  
  public final int getTotal()
  {
    return this.a;
  }
  
  public final List<TrackPoint> getTrackPoints()
  {
    return this.trackPoints;
  }
  
  public final void setDistance(double paramDouble)
  {
    this.d = paramDouble;
  }
  
  public final void setEndPoint(Point paramPoint)
  {
    this.g = paramPoint;
  }
  
  public final void setEntityName(String paramString)
  {
    this.c = paramString;
  }
  
  public final void setSize(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void setStartPoint(Point paramPoint)
  {
    this.f = paramPoint;
  }
  
  public final void setTollDistance(double paramDouble)
  {
    this.e = paramDouble;
  }
  
  public final void setTotal(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void setTrackPoints(List<TrackPoint> paramList)
  {
    this.trackPoints = paramList;
  }
  
  public final String toString()
  {
    return "HistoryTrackResponse [tag=" + this.tag + ", status=" + this.status + ", message=" + this.message + ", total=" + this.a + ", size=" + this.b + ", entityName=" + this.c + ", distance=" + this.d + ", tollDistance=" + this.e + ", startPoint=" + this.f + ", endPoint=" + this.g + ", trackPoints=" + this.trackPoints + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/track/HistoryTrackResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */