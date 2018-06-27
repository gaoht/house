package com.baidu.trace.api.fence;

import com.baidu.trace.model.BaseResponse;
import java.util.List;

public final class MonitoredStatusByLocationResponse
  extends BaseResponse
{
  private int a;
  private FenceType b;
  private List<MonitoredStatusInfo> c;
  
  public MonitoredStatusByLocationResponse(int paramInt1, int paramInt2, String paramString, int paramInt3, FenceType paramFenceType, List<MonitoredStatusInfo> paramList)
  {
    this(paramInt1, paramInt2, paramString, paramFenceType);
    this.a = paramInt3;
    this.c = paramList;
  }
  
  public MonitoredStatusByLocationResponse(int paramInt1, int paramInt2, String paramString, FenceType paramFenceType)
  {
    super(paramInt1, paramInt2, paramString);
    this.b = paramFenceType;
  }
  
  public final FenceType getFenceType()
  {
    return this.b;
  }
  
  public final List<MonitoredStatusInfo> getMonitoredStatusInfos()
  {
    return this.c;
  }
  
  public final int getSize()
  {
    return this.a;
  }
  
  public final void setFenceType(FenceType paramFenceType)
  {
    this.b = paramFenceType;
  }
  
  public final void setMonitoredStatusInfos(List<MonitoredStatusInfo> paramList)
  {
    this.c = paramList;
  }
  
  public final void setSize(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final String toString()
  {
    return "MonitoredStatusByLocationResponse [tag=" + this.tag + ", status=" + this.status + ", message=" + this.message + ", size=" + this.a + ", fenceType=" + this.b + ", monitoredStatusInfos=" + this.c + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/MonitoredStatusByLocationResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */