package com.baidu.trace;

import com.baidu.trace.api.bos.BosPutObjectResponse;
import com.baidu.trace.api.bos.OnBosListener;

final class i
  implements Runnable
{
  i(OnBosListener paramOnBosListener, BosPutObjectResponse paramBosPutObjectResponse) {}
  
  public final void run()
  {
    this.a.onPutObjectCallback(this.b);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */