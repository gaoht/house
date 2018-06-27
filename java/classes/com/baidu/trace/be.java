package com.baidu.trace;

import android.content.Context;
import android.os.Handler;
import com.baidu.trace.api.track.OnTrackListener;
import com.baidu.trace.api.track.QueryCacheTrackRequest;
import com.baidu.trace.api.track.QueryCacheTrackResponse;
import java.util.ArrayList;

final class be
  implements Runnable
{
  be(Context paramContext, QueryCacheTrackRequest paramQueryCacheTrackRequest, QueryCacheTrackResponse paramQueryCacheTrackResponse, Handler paramHandler, OnTrackListener paramOnTrackListener) {}
  
  public final void run()
  {
    ArrayList localArrayList = new ArrayList();
    if (!am.a(this.c, this.d.getEntityName(), localArrayList))
    {
      this.a.setStatus(14001);
      this.a.setMessage("请求失败");
    }
    this.a.setResult(localArrayList);
    this.e.post(new bf(this));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */