package com.unionpay.mobile.android.pboctransaction.samsung;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.unionpay.mobile.android.model.a;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.tsmservice.AppID;
import com.unionpay.tsmservice.data.AppDetail;
import com.unionpay.tsmservice.data.SeAppListItem;
import com.unionpay.tsmservice.data.VirtualCardInfo;
import java.util.ArrayList;

final class g
  implements Handler.Callback
{
  g(f paramf) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    int i;
    int j;
    switch (paramMessage.what)
    {
    default: 
    case 1000: 
    case 1014: 
      do
      {
        return false;
        f.a(this.a).removeMessages(4);
        j.c("uppay", "init success");
        f.a(this.a, true);
        return false;
        f.a(this.a).removeMessages(4);
        j.c("uppay", "list success");
      } while (f.b(this.a) == null);
      localObject = new ArrayList();
      SeAppListItem[] arrayOfSeAppListItem = (SeAppListItem[])paramMessage.obj;
      if ((arrayOfSeAppListItem != null) && (arrayOfSeAppListItem.length > 0))
      {
        paramMessage = new ArrayList();
        i = 0;
        while (i < arrayOfSeAppListItem.length)
        {
          localObject = this.a;
          localObject = arrayOfSeAppListItem[i].getAppDetail().getAppID().getAppAid();
          if ((localObject == null) || (((String)localObject).length() <= 16) || ("06".equalsIgnoreCase(((String)localObject).substring(14, 16)))) {
            break label643;
          }
          j = 0;
          if (j == 0) {
            paramMessage.add(new a(1, arrayOfSeAppListItem[i].getAppDetail().getAppID().getAppAid(), "", arrayOfSeAppListItem[i].getVirtualCardInfo().getCardNo(), 1));
          }
          i += 1;
        }
      }
      break;
    }
    for (;;)
    {
      paramMessage = f.a(this.a).obtainMessage(8, paramMessage);
      f.b(this.a).sendMessage(paramMessage);
      return false;
      j.c("uppay", "channel success");
      paramMessage = (Bundle)paramMessage.obj;
      f.a(this.a, paramMessage.getString("channel"));
      f.b(this.a, paramMessage.getString("apdu"));
      f.c(this.a);
      return false;
      j.c("uppay", "apdu success version 3.3.1");
      f.a(this.a).removeMessages(3);
      f.c(this.a, (String)paramMessage.obj);
      return false;
      j.c("uppay", "close channel success");
      f.d(this.a);
      return false;
      f.a(this.a).removeMessages(4);
      j.c("uppay", "msg error");
      i = paramMessage.arg1;
      paramMessage = (String)paramMessage.obj;
      f.a(this.a, i, paramMessage);
      return false;
      j.c("uppay", "timeout");
      i = paramMessage.arg1;
      f.a(this.a, i, "");
      return false;
      f.a(this.a).removeMessages(4);
      j.c("uppay-spay", "get spay list call back");
      paramMessage = (VirtualCardInfo)paramMessage.obj;
      paramMessage = new a(32, paramMessage.getAppID().getAppAid(), "", paramMessage.getCardNo(), 1);
      paramMessage = f.b(this.a).obtainMessage(2000, paramMessage);
      f.b(this.a).sendMessage(paramMessage);
      return false;
      j.c("uppay-spay", "send apdu time out");
      f.e(this.a);
      return false;
      f.a(this.a).removeMessages(4);
      j.c("uppay-spay", "check spay support");
      f.f(this.a).a(true);
      return false;
      label643:
      j = 1;
      break;
      paramMessage = (Message)localObject;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/samsung/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */