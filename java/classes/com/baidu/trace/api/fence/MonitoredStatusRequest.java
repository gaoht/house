package com.baidu.trace.api.fence;

import com.baidu.trace.model.BaseRequest;
import java.util.List;

public final class MonitoredStatusRequest
  extends BaseRequest
{
  private String a;
  private List<Long> b;
  private FenceType c;
  
  private MonitoredStatusRequest(int paramInt, long paramLong, String paramString, List<Long> paramList, FenceType paramFenceType)
  {
    super(paramInt, paramLong);
    this.a = paramString;
    this.b = paramList;
    this.c = paramFenceType;
  }
  
  public static MonitoredStatusRequest buildLocalRequest(int paramInt, long paramLong, String paramString, List<Long> paramList)
  {
    return new MonitoredStatusRequest(paramInt, paramLong, paramString, paramList, FenceType.local);
  }
  
  public static MonitoredStatusRequest buildServerRequest(int paramInt, long paramLong, String paramString, List<Long> paramList)
  {
    return new MonitoredStatusRequest(paramInt, paramLong, paramString, paramList, FenceType.server);
  }
  
  public final List<Long> getFenceIds()
  {
    return this.b;
  }
  
  public final FenceType getFenceType()
  {
    return this.c;
  }
  
  public final String getMonitoredPerson()
  {
    return this.a;
  }
  
  public final void setFenceIds(List<Long> paramList)
  {
    this.b = paramList;
  }
  
  public final void setMonitoredPerson(String paramString)
  {
    this.a = paramString;
  }
  
  public final String toString()
  {
    return "MonitoredStatusRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", monitoredPerson=" + this.a + ", fenceIds=" + this.b + ", fenceType=" + this.c + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/MonitoredStatusRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */