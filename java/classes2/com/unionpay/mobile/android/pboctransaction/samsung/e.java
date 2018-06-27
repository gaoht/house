package com.unionpay.mobile.android.pboctransaction.samsung;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.tsmservice.ITsmCallback.Stub;
import com.unionpay.tsmservice.result.CheckSSamsungPayResult;
import com.unionpay.tsmservice.result.GetCardInfoBySpayResult;
import com.unionpay.tsmservice.result.GetSeAppListResult;
import com.unionpay.tsmservice.result.InitResult;
import com.unionpay.tsmservice.result.OpenChannelResult;
import com.unionpay.tsmservice.result.SendApduResult;

public final class e
  extends ITsmCallback.Stub
{
  private int a;
  private Handler b;
  
  public e(int paramInt, Handler paramHandler)
  {
    this.a = paramInt;
    this.b = paramHandler;
  }
  
  public final void onError(String paramString1, String paramString2)
    throws RemoteException
  {
    Log.e("uppay", "errorCode:" + paramString1 + ", errorDesc:" + paramString2);
    this.b.sendMessage(Message.obtain(this.b, 1, this.a, 0, paramString1));
  }
  
  public final void onResult(Bundle paramBundle)
    throws RemoteException
  {
    switch (this.a)
    {
    default: 
      return;
    case 1000: 
      paramBundle.setClassLoader(InitResult.class.getClassLoader());
      this.b.sendMessage(Message.obtain(this.b, 1000, paramBundle));
      return;
    case 1014: 
      paramBundle.setClassLoader(GetSeAppListResult.class.getClassLoader());
      paramBundle = ((GetSeAppListResult)paramBundle.get("result")).getSeAppList();
      this.b.sendMessage(Message.obtain(this.b, 1014, paramBundle));
      return;
    case 1011: 
      paramBundle.setClassLoader(OpenChannelResult.class.getClassLoader());
      Object localObject = (OpenChannelResult)paramBundle.get("result");
      paramBundle = ((OpenChannelResult)localObject).getChannel();
      localObject = ((OpenChannelResult)localObject).getOutHexApdu();
      Bundle localBundle = new Bundle();
      localBundle.putString("channel", paramBundle);
      localBundle.putString("apdu", (String)localObject);
      this.b.sendMessage(Message.obtain(this.b, 1011, localBundle));
      return;
    case 1012: 
      paramBundle.setClassLoader(SendApduResult.class.getClassLoader());
      paramBundle = ((SendApduResult)paramBundle.get("result")).getOutHexApdu();
      this.b.sendMessage(Message.obtain(this.b, 1012, paramBundle));
      return;
    case 1013: 
      this.b.sendMessage(Message.obtain(this.b, 1013, ""));
      return;
    case 1015: 
      paramBundle.setClassLoader(GetCardInfoBySpayResult.class.getClassLoader());
      paramBundle = ((GetCardInfoBySpayResult)paramBundle.get("result")).getVirtualCardInfo();
      this.b.sendMessage(Message.obtain(this.b, 1015, paramBundle));
      return;
    }
    j.c("uppay-spay", "check spay support callback");
    paramBundle.setClassLoader(CheckSSamsungPayResult.class.getClassLoader());
    paramBundle.get("result");
    this.b.sendMessage(Message.obtain(this.b, 1016, ""));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/samsung/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */