package com.unionpay.sdk;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class ay
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.bluetooth.device.action.FOUND".equals(paramIntent.getAction()))
    {
      paramContext = b.a(paramContext, (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"));
      paramIntent = paramIntent.getStringExtra("android.bluetooth.device.extra.NAME");
    }
    try
    {
      paramContext.put("name", paramIntent);
      b.b().put(paramContext);
      return;
    }
    catch (JSONException paramIntent)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */