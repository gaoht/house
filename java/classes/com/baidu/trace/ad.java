package com.baidu.trace;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.trace.api.fence.DeleteFenceRequest;
import com.baidu.trace.api.fence.OnFenceListener;

final class ad
  implements Runnable
{
  ad(Context paramContext, Handler paramHandler, DeleteFenceRequest paramDeleteFenceRequest, OnFenceListener paramOnFenceListener, IService paramIService) {}
  
  public final void run()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    boolean bool = a.a(this.a, this.b, this.c, localStringBuffer, this.d);
    if ((this.e == null) || ((this.c.getFenceIds() != null) && (TextUtils.isEmpty(localStringBuffer.toString())))) {}
    for (;;)
    {
      return;
      try
      {
        if (this.c.getFenceIds() != null)
        {
          this.e.handleLocalFence(2, 0L, localStringBuffer.substring(0, localStringBuffer.length() - 1));
          return;
        }
        if (bool)
        {
          this.e.handleLocalFence(3, 0L, null);
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */