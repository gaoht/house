package com.baidu.trace.api.fence;

import com.baidu.trace.model.BaseRequest;
import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;
import java.util.List;

public final class MonitoredStatusByLocationRequest
  extends BaseRequest
{
  private String a;
  private List<Long> b;
  private LatLng c;
  private CoordType d;
  private FenceType e;
  
  private MonitoredStatusByLocationRequest(int paramInt, long paramLong, String paramString, List<Long> paramList, LatLng paramLatLng, CoordType paramCoordType, FenceType paramFenceType)
  {
    super(paramInt, paramLong);
    this.a = paramString;
    this.b = paramList;
    this.c = paramLatLng;
    this.d = paramCoordType;
    this.e = paramFenceType;
  }
  
  public static MonitoredStatusByLocationRequest buildLocalRequest(int paramInt, long paramLong, String paramString, List<Long> paramList, LatLng paramLatLng, CoordType paramCoordType)
  {
    return new MonitoredStatusByLocationRequest(paramInt, paramLong, paramString, paramList, paramLatLng, paramCoordType, FenceType.local);
  }
  
  public static MonitoredStatusByLocationRequest buildServerRequest(int paramInt, long paramLong, String paramString, List<Long> paramList, LatLng paramLatLng, CoordType paramCoordType)
  {
    return new MonitoredStatusByLocationRequest(paramInt, paramLong, paramString, paramList, paramLatLng, paramCoordType, FenceType.server);
  }
  
  public final CoordType getCoordType()
  {
    return this.d;
  }
  
  public final List<Long> getFenceIds()
  {
    return this.b;
  }
  
  public final FenceType getFenceType()
  {
    return this.e;
  }
  
  public final LatLng getLatLng()
  {
    return this.c;
  }
  
  public final String getMonitoredPerson()
  {
    return this.a;
  }
  
  public final void setCoordType(CoordType paramCoordType)
  {
    this.d = paramCoordType;
  }
  
  public final void setFenceIds(List<Long> paramList)
  {
    this.b = paramList;
  }
  
  public final void setLatLng(LatLng paramLatLng)
  {
    this.c = paramLatLng;
  }
  
  public final void setMonitoredPerson(String paramString)
  {
    this.a = paramString;
  }
  
  public final String toString()
  {
    if (FenceType.local == this.e) {
      return "MonitoredStatusByLocationRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", fenceIds=" + this.b + ", latLng=" + this.c + ", coordType=" + this.d + ", fenceType=" + this.e + "]";
    }
    return "MonitoredStatusByLocationRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", monitoredPerson=" + this.a + ", fenceIds=" + this.b + ", latLng=" + this.c + ", coordType=" + this.d + ", fenceType=" + this.e + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/MonitoredStatusByLocationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */