package com.unionpay.tsmservice;

import android.os.Handler.Callback;
import android.os.Message;

final class UPTsmAddon$1
  implements Handler.Callback
{
  UPTsmAddon$1(UPTsmAddon paramUPTsmAddon) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        int i = paramMessage.what;
        switch (i)
        {
        default: 
          bool = false;
          return bool;
        }
      }
      finally {}
      paramMessage = this.a;
      UPTsmAddon.a();
      continue;
      paramMessage = this.a;
      UPTsmAddon.b();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/UPTsmAddon$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */