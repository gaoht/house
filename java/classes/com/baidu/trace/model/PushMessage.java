package com.baidu.trace.model;

import com.baidu.trace.api.fence.FenceAlarmPushInfo;

public final class PushMessage
{
  private String a;
  private FenceAlarmPushInfo b;
  
  public final FenceAlarmPushInfo getFenceAlarmPushInfo()
  {
    return this.b;
  }
  
  public final String getMessage()
  {
    return this.a;
  }
  
  public final void setFenceAlarmPushInfo(FenceAlarmPushInfo paramFenceAlarmPushInfo)
  {
    this.b = paramFenceAlarmPushInfo;
  }
  
  public final void setMessage(String paramString)
  {
    this.a = paramString;
  }
  
  public final String toString()
  {
    return "PushMessage [fenceAlarmPushInfo=" + this.b + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/model/PushMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */