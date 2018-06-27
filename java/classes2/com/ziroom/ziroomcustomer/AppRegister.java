package com.ziroom.ziroomcustomer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class AppRegister
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    WXAPIFactory.createWXAPI(paramContext, null).registerApp("wx484d02e10be8f5c9");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/AppRegister.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */