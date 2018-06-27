package com.unionpay.sdk;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import org.json.JSONArray;

final class ax
  implements BluetoothAdapter.LeScanCallback
{
  public final void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    if (b.a() != null)
    {
      paramBluetoothDevice = b.a(b.a(), paramBluetoothDevice);
      b.b().put(paramBluetoothDevice);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */