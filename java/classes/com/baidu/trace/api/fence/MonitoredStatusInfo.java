package com.baidu.trace.api.fence;

public final class MonitoredStatusInfo
{
  private long a;
  private MonitoredStatus b = MonitoredStatus.unknown;
  
  public MonitoredStatusInfo() {}
  
  public MonitoredStatusInfo(long paramLong, MonitoredStatus paramMonitoredStatus)
  {
    this.a = paramLong;
    this.b = paramMonitoredStatus;
  }
  
  public final long getFenceId()
  {
    return this.a;
  }
  
  public final MonitoredStatus getMonitoredStatus()
  {
    return this.b;
  }
  
  public final void setFenceId(long paramLong)
  {
    this.a = paramLong;
  }
  
  public final void setMonitoredStatus(MonitoredStatus paramMonitoredStatus)
  {
    this.b = paramMonitoredStatus;
  }
  
  public final String toString()
  {
    return "MonitoredStatusInfo [fenceId=" + this.a + ", monitoredStatus=" + this.b + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/MonitoredStatusInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */