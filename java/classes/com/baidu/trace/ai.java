package com.baidu.trace;

import com.baidu.trace.api.fence.CreateFenceResponse;
import com.baidu.trace.api.fence.DeleteFenceResponse;
import com.baidu.trace.api.fence.FenceListResponse;
import com.baidu.trace.api.fence.HistoryAlarmResponse;
import com.baidu.trace.api.fence.MonitoredStatusByLocationResponse;
import com.baidu.trace.api.fence.MonitoredStatusResponse;
import com.baidu.trace.api.fence.OnFenceListener;
import com.baidu.trace.api.fence.UpdateFenceResponse;
import com.baidu.trace.model.BaseResponse;

final class ai
  implements Runnable
{
  ai(int paramInt, OnFenceListener paramOnFenceListener, BaseResponse paramBaseResponse) {}
  
  public final void run()
  {
    switch (this.a)
    {
    default: 
      return;
    case 1: 
      this.b.onCreateFenceCallback((CreateFenceResponse)this.c);
      return;
    case 2: 
      this.b.onUpdateFenceCallback((UpdateFenceResponse)this.c);
      return;
    case 3: 
      this.b.onDeleteFenceCallback((DeleteFenceResponse)this.c);
      return;
    case 4: 
      this.b.onFenceListCallback((FenceListResponse)this.c);
      return;
    case 5: 
      this.b.onMonitoredStatusCallback((MonitoredStatusResponse)this.c);
      return;
    case 6: 
      this.b.onMonitoredStatusByLocationCallback((MonitoredStatusByLocationResponse)this.c);
      return;
    }
    this.b.onHistoryAlarmCallback((HistoryAlarmResponse)this.c);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */