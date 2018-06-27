package com.baidu.trace.api.fence;

public class FenceAlarmPushInfo
{
  protected long a;
  protected String b;
  protected String c;
  protected MonitoredAction d;
  protected AlarmPoint e;
  protected AlarmPoint f;
  
  public FenceAlarmPushInfo() {}
  
  public FenceAlarmPushInfo(long paramLong, String paramString1, String paramString2, MonitoredAction paramMonitoredAction, AlarmPoint paramAlarmPoint1, AlarmPoint paramAlarmPoint2)
  {
    this.a = paramLong;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramMonitoredAction;
    this.e = paramAlarmPoint1;
    this.f = paramAlarmPoint2;
  }
  
  public AlarmPoint getCurrentPoint()
  {
    return this.e;
  }
  
  public long getFenceId()
  {
    return this.a;
  }
  
  public String getFenceName()
  {
    return this.b;
  }
  
  public MonitoredAction getMonitoredAction()
  {
    return this.d;
  }
  
  public String getMonitoredPerson()
  {
    return this.c;
  }
  
  public AlarmPoint getPrePoint()
  {
    return this.f;
  }
  
  public void setCurrentPoint(AlarmPoint paramAlarmPoint)
  {
    this.e = paramAlarmPoint;
  }
  
  public void setFenceId(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void setFenceName(String paramString)
  {
    this.b = paramString;
  }
  
  public void setMonitoredAction(MonitoredAction paramMonitoredAction)
  {
    this.d = paramMonitoredAction;
  }
  
  public void setMonitoredPerson(String paramString)
  {
    this.c = paramString;
  }
  
  public void setPrePoint(AlarmPoint paramAlarmPoint)
  {
    this.f = paramAlarmPoint;
  }
  
  public String toString()
  {
    return "FenceAlarmPushInfo [fenceId=" + this.a + ", fenceName=" + this.b + ", monitoredPerson=" + this.c + ", monitoredAction=" + this.d + ", currentPoint=" + this.e + ", prePoint=" + this.f + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/FenceAlarmPushInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */