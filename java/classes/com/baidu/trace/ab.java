package com.baidu.trace;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.trace.api.fence.CreateFenceRequest;
import com.baidu.trace.api.fence.Fence;
import com.baidu.trace.api.fence.OnFenceListener;

final class ab
  implements Runnable
{
  ab(Context paramContext, Handler paramHandler, CreateFenceRequest paramCreateFenceRequest, OnFenceListener paramOnFenceListener, IService paramIService) {}
  
  public final void run()
  {
    String str = a.a(this.a, this.b, this.c.getTag(), this.c.getFence(), this.d);
    if ((TextUtils.isEmpty(str)) || (this.e == null)) {
      return;
    }
    try
    {
      this.e.handleLocalFence(0, this.c.getFence().getFenceId(), str);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */