package com.mato.sdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.mato.sdk.g.i;
import java.text.MessageFormat;

public final class b
{
  private static final String a = g.b("");
  private static int b = 0;
  private static int c = 1;
  private static int d = 2;
  private static int e = 3;
  
  public static int a(String paramString)
  {
    if ((paramString.startsWith("46000")) || (paramString.startsWith("46002")) || (paramString.startsWith("46007"))) {
      return 0;
    }
    if ((paramString.startsWith("46001")) || (paramString.startsWith("46006"))) {
      return 1;
    }
    if ((paramString.startsWith("46003")) || (paramString.startsWith("46005")) || (paramString.startsWith("46011"))) {
      return 2;
    }
    return 3;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Unknown";
    case 0: 
      return "CM";
    case 1: 
      return "CU";
    }
    return "CT";
  }
  
  private static String a(Context paramContext)
  {
    int i = 0;
    Object localObject = i.b(paramContext);
    try
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject == null) || (!((NetworkInfo)localObject).isConnected())) {
        return "none";
      }
    }
    catch (SecurityException paramContext)
    {
      Log.w(a, "Cannot determine network state. Enable android.permission.ACCESS_NETWORK_STATE in your manifest.");
      return "unknown";
    }
    switch (((NetworkInfo)localObject).getType())
    {
    case 8: 
    default: 
      MessageFormat.format("Unknown network type: {0} [{1}]", new Object[] { ((NetworkInfo)localObject).getTypeName(), Integer.valueOf(((NetworkInfo)localObject).getType()) });
      return "unknown";
    case 0: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      paramContext = i.a(paramContext).getNetworkOperatorName();
      if ((Build.PRODUCT.equals("google_sdk")) || (Build.PRODUCT.equals("sdk")) || (Build.PRODUCT.equals("sdk_x86")) || (Build.FINGERPRINT.startsWith("generic"))) {
        i = 1;
      }
      if ((paramContext.equals("Android")) && (i != 0)) {
        return "wifi";
      }
      return paramContext;
    }
    return "wifi";
  }
  
  private static String b(Context paramContext)
  {
    paramContext = i.a(paramContext).getNetworkOperatorName();
    if ((Build.PRODUCT.equals("google_sdk")) || (Build.PRODUCT.equals("sdk")) || (Build.PRODUCT.equals("sdk_x86")) || (Build.FINGERPRINT.startsWith("generic"))) {}
    for (int i = 1; (paramContext.equals("Android")) && (i != 0); i = 0) {
      return "wifi";
    }
    return paramContext;
  }
  
  public static String b(String paramString)
  {
    return a(a(paramString));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */