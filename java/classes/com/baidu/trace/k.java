package com.baidu.trace;

import com.baidu.trace.api.bos.BosGetObjectResponse;
import com.baidu.trace.api.bos.BosObjectResponse;
import com.baidu.trace.api.bos.BosPutObjectResponse;
import com.baidu.trace.api.bos.OnBosListener;

final class k
  implements Runnable
{
  k(int paramInt, OnBosListener paramOnBosListener, BosObjectResponse paramBosObjectResponse) {}
  
  public final void run()
  {
    switch (this.a)
    {
    default: 
      return;
    case 1: 
      this.b.onPutObjectCallback((BosPutObjectResponse)this.c);
      return;
    }
    this.b.onGetObjectCallback((BosGetObjectResponse)this.c);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */