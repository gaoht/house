package com.unionpay.mobile.android.pboctransaction.samsung;

import android.util.Log;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.tsmservice.UPTsmAddon.UPTsmConnectionListener;

final class h
  implements UPTsmAddon.UPTsmConnectionListener
{
  h(f paramf) {}
  
  public final void onTsmConnected()
  {
    j.c("uppay", "TsmService connected.");
    f.g(this.a);
  }
  
  public final void onTsmDisconnected()
  {
    Log.e("uppay", "TsmService disconnected.");
    f.a(this.a, false);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/samsung/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */