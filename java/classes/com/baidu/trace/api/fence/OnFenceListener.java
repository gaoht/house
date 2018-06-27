package com.baidu.trace.api.fence;

public abstract interface OnFenceListener
{
  public abstract void onCreateFenceCallback(CreateFenceResponse paramCreateFenceResponse);
  
  public abstract void onDeleteFenceCallback(DeleteFenceResponse paramDeleteFenceResponse);
  
  public abstract void onFenceListCallback(FenceListResponse paramFenceListResponse);
  
  public abstract void onHistoryAlarmCallback(HistoryAlarmResponse paramHistoryAlarmResponse);
  
  public abstract void onMonitoredStatusByLocationCallback(MonitoredStatusByLocationResponse paramMonitoredStatusByLocationResponse);
  
  public abstract void onMonitoredStatusCallback(MonitoredStatusResponse paramMonitoredStatusResponse);
  
  public abstract void onUpdateFenceCallback(UpdateFenceResponse paramUpdateFenceResponse);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/OnFenceListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */