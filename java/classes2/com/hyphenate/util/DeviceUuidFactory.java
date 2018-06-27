package com.hyphenate.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import java.util.Map;
import java.util.UUID;

public class DeviceUuidFactory
{
  protected static final String PREFS_DEVICE_ID = "device_id";
  protected static final String PREFS_FILE = "device_id.xml";
  protected static UUID uuid;
  
  /* Error */
  public DeviceUuidFactory(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 20	java/lang/Object:<init>	()V
    //   4: getstatic 22	com/hyphenate/util/DeviceUuidFactory:uuid	Ljava/util/UUID;
    //   7: ifnonnull +163 -> 170
    //   10: ldc 2
    //   12: monitorenter
    //   13: getstatic 22	com/hyphenate/util/DeviceUuidFactory:uuid	Ljava/util/UUID;
    //   16: ifnonnull +32 -> 48
    //   19: aload_1
    //   20: ldc 11
    //   22: iconst_0
    //   23: invokevirtual 28	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   26: astore_2
    //   27: aload_2
    //   28: ldc 8
    //   30: aconst_null
    //   31: invokeinterface 34 3 0
    //   36: astore_3
    //   37: aload_3
    //   38: ifnull +14 -> 52
    //   41: aload_3
    //   42: invokestatic 40	java/util/UUID:fromString	(Ljava/lang/String;)Ljava/util/UUID;
    //   45: putstatic 22	com/hyphenate/util/DeviceUuidFactory:uuid	Ljava/util/UUID;
    //   48: ldc 2
    //   50: monitorexit
    //   51: return
    //   52: aload_1
    //   53: invokevirtual 44	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   56: ldc 46
    //   58: invokestatic 51	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   61: astore_3
    //   62: ldc 53
    //   64: aload_3
    //   65: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   68: ifne +49 -> 117
    //   71: aload_3
    //   72: ldc 61
    //   74: invokevirtual 65	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   77: invokestatic 69	java/util/UUID:nameUUIDFromBytes	([B)Ljava/util/UUID;
    //   80: putstatic 22	com/hyphenate/util/DeviceUuidFactory:uuid	Ljava/util/UUID;
    //   83: aload_2
    //   84: invokeinterface 73 1 0
    //   89: ldc 8
    //   91: getstatic 22	com/hyphenate/util/DeviceUuidFactory:uuid	Ljava/util/UUID;
    //   94: invokevirtual 77	java/util/UUID:toString	()Ljava/lang/String;
    //   97: invokeinterface 83 3 0
    //   102: invokeinterface 87 1 0
    //   107: pop
    //   108: goto -60 -> 48
    //   111: astore_1
    //   112: ldc 2
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    //   117: aload_1
    //   118: ldc 89
    //   120: invokevirtual 93	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   123: checkcast 95	android/telephony/TelephonyManager
    //   126: invokevirtual 98	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   129: astore_3
    //   130: aload_3
    //   131: ifnull +30 -> 161
    //   134: aload_3
    //   135: ldc 61
    //   137: invokevirtual 65	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   140: invokestatic 69	java/util/UUID:nameUUIDFromBytes	([B)Ljava/util/UUID;
    //   143: astore_1
    //   144: aload_1
    //   145: putstatic 22	com/hyphenate/util/DeviceUuidFactory:uuid	Ljava/util/UUID;
    //   148: goto -65 -> 83
    //   151: astore_1
    //   152: new 100	java/lang/RuntimeException
    //   155: dup
    //   156: aload_1
    //   157: invokespecial 103	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   160: athrow
    //   161: aload_0
    //   162: aload_1
    //   163: invokespecial 107	com/hyphenate/util/DeviceUuidFactory:generateDeviceUuid	(Landroid/content/Context;)Ljava/util/UUID;
    //   166: astore_1
    //   167: goto -23 -> 144
    //   170: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	DeviceUuidFactory
    //   0	171	1	paramContext	Context
    //   26	58	2	localSharedPreferences	android.content.SharedPreferences
    //   36	99	3	str	String
    // Exception table:
    //   from	to	target	type
    //   13	37	111	finally
    //   41	48	111	finally
    //   48	51	111	finally
    //   52	62	111	finally
    //   62	83	111	finally
    //   83	108	111	finally
    //   112	115	111	finally
    //   117	130	111	finally
    //   134	144	111	finally
    //   144	148	111	finally
    //   152	161	111	finally
    //   161	167	111	finally
    //   62	83	151	java/io/UnsupportedEncodingException
    //   117	130	151	java/io/UnsupportedEncodingException
    //   134	144	151	java/io/UnsupportedEncodingException
    //   144	148	151	java/io/UnsupportedEncodingException
    //   161	167	151	java/io/UnsupportedEncodingException
  }
  
  private UUID generateDeviceUuid(Context paramContext)
  {
    String str1 = Build.BOARD + Build.BRAND + Build.CPU_ABI + Build.DEVICE + Build.DISPLAY + Build.FINGERPRINT + Build.HOST + Build.ID + Build.MANUFACTURER + Build.MODEL + Build.PRODUCT + Build.TAGS + Build.TYPE + Build.USER;
    String str2 = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    String str3 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
    if ((isEmpty(str2)) && (isEmpty(str3)) && (isEmpty(paramContext))) {
      return UUID.randomUUID();
    }
    return UUID.nameUUIDFromBytes((str1 + str2 + str3 + paramContext).getBytes());
  }
  
  private static boolean isEmpty(Object paramObject)
  {
    if (paramObject == null) {
      return true;
    }
    if (((paramObject instanceof String)) && (((String)paramObject).trim().length() == 0)) {
      return true;
    }
    if ((paramObject instanceof Map)) {
      return ((Map)paramObject).isEmpty();
    }
    return false;
  }
  
  public UUID getDeviceUuid()
  {
    return uuid;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/util/DeviceUuidFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */