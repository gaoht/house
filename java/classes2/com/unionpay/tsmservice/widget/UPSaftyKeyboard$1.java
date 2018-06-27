package com.unionpay.tsmservice.widget;

import android.os.RemoteException;
import com.unionpay.tsmservice.UPTsmAddon;
import com.unionpay.tsmservice.UPTsmAddon.UPTsmConnectionListener;

final class UPSaftyKeyboard$1
  implements UPTsmAddon.UPTsmConnectionListener
{
  UPSaftyKeyboard$1(UPSaftyKeyboard paramUPSaftyKeyboard) {}
  
  public final void onTsmConnected()
  {
    try
    {
      String[] arrayOfString = new String[1];
      UPSaftyKeyboard.a(this.a).getPubKey(1001, arrayOfString);
      UPSaftyKeyboard.a(this.a, arrayOfString[0]);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  public final void onTsmDisconnected() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/widget/UPSaftyKeyboard$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */