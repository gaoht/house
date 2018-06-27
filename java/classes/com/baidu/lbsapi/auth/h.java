package com.baidu.lbsapi.auth;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Hashtable;

class h
  extends Handler
{
  h(LBSAuthManager paramLBSAuthManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (a.a) {
      a.a("handleMessage !!");
    }
    Object localObject = paramMessage.getData().getString("listenerKey");
    localObject = (LBSAuthManagerListener)LBSAuthManager.a().get(localObject);
    if (a.a) {
      a.a("handleMessage listener = " + localObject);
    }
    if (localObject != null) {
      ((LBSAuthManagerListener)localObject).onAuthResult(paramMessage.what, paramMessage.obj.toString());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/lbsapi/auth/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */