package com.baidu.trace;

import com.baidu.trace.api.bos.BosGetObjectResponse;
import com.baidu.trace.api.bos.OnBosListener;

final class j
  implements Runnable
{
  j(OnBosListener paramOnBosListener, BosGetObjectResponse paramBosGetObjectResponse) {}
  
  public final void run()
  {
    this.a.onGetObjectCallback(this.b);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */