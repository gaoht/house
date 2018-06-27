package com.baidu.trace.api.fence;

public final class FenceAlarmInfo
  extends FenceAlarmPushInfo
{
  public FenceAlarmInfo() {}
  
  public FenceAlarmInfo(long paramLong, String paramString1, String paramString2, MonitoredAction paramMonitoredAction, AlarmPoint paramAlarmPoint1, AlarmPoint paramAlarmPoint2)
  {
    super(paramLong, paramString1, paramString2, paramMonitoredAction, paramAlarmPoint1, paramAlarmPoint2);
  }
  
  public final String toString()
  {
    return "FenceAlarmInfo [fenceId=" + this.a + ", fenceName=" + this.b + ", monitoredPerson=" + this.c + ", monitoredAction=" + this.d + ", currentPoint=" + this.e + ", prePoint=" + this.f + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/FenceAlarmInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */