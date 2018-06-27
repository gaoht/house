package com.baidu.trace;

import com.baidu.lbsapi.auth.tracesdk.LBSAuthManagerListener;

final class e
  implements LBSAuthManagerListener
{
  public final void onAuthResult(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      a.b(paramString);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */