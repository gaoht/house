package com.baidu.trace.api.fence;

public enum MonitoredStatus
{
  static
  {
    in = new MonitoredStatus("in", 1);
    out = new MonitoredStatus("out", 2);
  }
  
  private MonitoredStatus() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/MonitoredStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */