package com.baidu.trace;

import android.content.Context;
import android.os.Handler;
import com.baidu.trace.api.track.ClearCacheTrackResponse;
import com.baidu.trace.api.track.OnTrackListener;
import java.util.List;

final class bg
  implements Runnable
{
  bg(Context paramContext, List paramList1, List paramList2, ClearCacheTrackResponse paramClearCacheTrackResponse, Handler paramHandler, OnTrackListener paramOnTrackListener) {}
  
  public final void run()
  {
    if (!am.a(this.c, this.d, this.e))
    {
      this.a.setStatus(14001);
      this.a.setMessage("请求失败");
    }
    this.f.post(new bh(this));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */