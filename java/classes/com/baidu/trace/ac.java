package com.baidu.trace;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.trace.api.fence.Fence;
import com.baidu.trace.api.fence.OnFenceListener;
import com.baidu.trace.api.fence.UpdateFenceRequest;

final class ac
  implements Runnable
{
  ac(Context paramContext, Handler paramHandler, UpdateFenceRequest paramUpdateFenceRequest, OnFenceListener paramOnFenceListener, IService paramIService) {}
  
  public final void run()
  {
    String str = a.a(this.a, this.b, this.c, this.d);
    if ((TextUtils.isEmpty(str)) || (this.e == null)) {
      return;
    }
    try
    {
      this.e.handleLocalFence(1, this.c.getFence().getFenceId(), str);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */