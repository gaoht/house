package com.unionpay.sdk;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.IntentFilter;
import android.os.ParcelUuid;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static JSONArray a = new JSONArray();
  private static Context b = null;
  private static Object c = null;
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      return "EXCEPTION_CODE";
    case 10: 
      return "UNPAIRED";
    case 12: 
      return "PAIRED";
    case 11: 
      return "PAIRING";
    case 1: 
      return "CLASSIC";
    case 3: 
      return "DUAL_MODE";
    case 2: 
      return "LOW_ENERGY";
    }
    return "UNKNOWN";
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      if (r.b(paramContext, "android.permission.BLUETOOTH"))
      {
        paramContext = BluetoothAdapter.getDefaultAdapter();
        if (paramContext == null) {
          return false;
        }
        boolean bool = paramContext.isEnabled();
        return bool;
      }
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  private static String b(int paramInt)
  {
    switch (paramInt)
    {
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 22: 
    default: 
      return "EXCEPTION_CODE";
    case 21: 
      return "SCAN_MODE_CONNECTABLE";
    case 23: 
      return "SCAN_MODE_CONNECTABLE_DISCOVERABLE";
    case 20: 
      return "UNKNOWN";
    case 10: 
      return "STATE_OFF";
    case 12: 
      return "STATE_ON";
    case 13: 
      return "STATE_TURNING_OFF";
    }
    return "STATE_TURNING_ON";
  }
  
  private static JSONObject b(Context paramContext, BluetoothDevice paramBluetoothDevice)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (r.b(paramContext, "android.permission.BLUETOOTH"))
      {
        paramContext = localJSONObject;
        if (paramBluetoothDevice != null)
        {
          localJSONObject.put("address", paramBluetoothDevice.getAddress());
          localJSONObject.put("name", paramBluetoothDevice.getName());
          if (r.a(18)) {
            localJSONObject.put("type", a(paramBluetoothDevice.getType()));
          }
          localJSONObject.put("bondState", a(paramBluetoothDevice.getBondState()));
          paramContext = localJSONObject;
          if (r.a(15))
          {
            paramBluetoothDevice = paramBluetoothDevice.getUuids();
            paramContext = localJSONObject;
            if (paramBluetoothDevice != null)
            {
              paramContext = new JSONArray();
              int j = paramBluetoothDevice.length;
              int i = 0;
              while (i < j)
              {
                paramContext.put(paramBluetoothDevice[i].toString());
                i += 1;
              }
              localJSONObject.put("uuids", paramContext.toString());
              return localJSONObject;
            }
          }
        }
      }
      else
      {
        localJSONObject.put("error", "NO_PERMISSION");
        return localJSONObject;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext = null;
    }
    return paramContext;
  }
  
  public static boolean b(Context paramContext)
  {
    for (;;)
    {
      try
      {
        b = paramContext;
        if (r.b(paramContext, "android.permission.BLUETOOTH_ADMIN"))
        {
          BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
          a = new JSONArray();
          if ((!r.a(18)) || (localBluetoothAdapter == null)) {
            break label88;
          }
          bool1 = localBluetoothAdapter.startLeScan(new ax());
          boolean bool2 = bool1;
          if (!bool1)
          {
            paramContext.registerReceiver(new ay(), new IntentFilter("android.bluetooth.device.action.FOUND"));
            bool2 = localBluetoothAdapter.startDiscovery();
          }
          return bool2;
        }
      }
      catch (Throwable paramContext) {}
      return false;
      label88:
      boolean bool1 = false;
    }
  }
  
  public static JSONArray c(Context paramContext)
  {
    return a;
  }
  
  public static JSONObject d(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject = localJSONObject;
    try
    {
      if (r.b(paramContext, "android.permission.BLUETOOTH"))
      {
        localObject = localJSONObject;
        BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (localBluetoothAdapter != null)
        {
          localObject = localJSONObject;
          String str = localBluetoothAdapter.getAddress();
          localObject = localJSONObject;
          if (BluetoothAdapter.checkBluetoothAddress(str))
          {
            localObject = localJSONObject;
            localJSONObject = b(paramContext, localBluetoothAdapter.getRemoteDevice(str));
            paramContext = localJSONObject;
            if (localJSONObject == null)
            {
              localObject = localJSONObject;
              paramContext = new JSONObject();
            }
            localObject = paramContext;
            paramContext.put("name", localBluetoothAdapter.getName());
            localObject = paramContext;
            paramContext.put("state", b(localBluetoothAdapter.getState()));
            localObject = paramContext;
            paramContext.put("scanMode", b(localBluetoothAdapter.getScanMode()));
            return paramContext;
          }
          localObject = localJSONObject;
          localJSONObject.put("error", "DEVICE_INVALID");
          return localJSONObject;
        }
      }
    }
    catch (Throwable paramContext)
    {
      try
      {
        ((JSONObject)localObject).put("error", "EXCEPTION");
        return (JSONObject)localObject;
      }
      catch (JSONException paramContext)
      {
        return (JSONObject)localObject;
      }
      localObject = localJSONObject;
      localJSONObject.put("error", "NOT_SUPPORT_BLUETOOTH");
      return localJSONObject;
    }
    localObject = localJSONObject;
    localJSONObject.put("error", "NO_PERMISSION");
    return localJSONObject;
  }
  
  public static JSONArray e(Context paramContext)
  {
    Object localObject1;
    try
    {
      if (r.b(paramContext, "android.permission.BLUETOOTH"))
      {
        localObject1 = BluetoothAdapter.getDefaultAdapter();
        if (localObject1 != null)
        {
          Object localObject2 = ((BluetoothAdapter)localObject1).getBondedDevices();
          if ((localObject2 != null) && (((Set)localObject2).size() > 0))
          {
            localObject1 = new JSONArray();
            localObject2 = ((Set)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              JSONObject localJSONObject = b(paramContext, (BluetoothDevice)((Iterator)localObject2).next());
              if (localJSONObject != null) {
                ((JSONArray)localObject1).put(localJSONObject);
              }
            }
          }
        }
      }
      return null;
    }
    catch (Throwable paramContext) {}
    return (JSONArray)localObject1;
  }
  
  public static void stopScan(Context paramContext)
  {
    try
    {
      if (r.b(paramContext, "android.permission.BLUETOOTH_ADMIN"))
      {
        paramContext = BluetoothAdapter.getDefaultAdapter();
        if ((paramContext != null) && (paramContext.isDiscovering()) && (r.a(18)) && (c != null) && ((c instanceof BluetoothAdapter.LeScanCallback))) {
          paramContext.stopLeScan((BluetoothAdapter.LeScanCallback)c);
        }
        paramContext.cancelDiscovery();
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */