package com.g.a;

import android.accounts.Account;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import org.json.JSONArray;
import org.json.JSONObject;

public class y
{
  public static int a = 0;
  
  public static JSONArray a(Context paramContext)
  {
    JSONArray localJSONArray = new JSONArray();
    if (!z.a) {
      return localJSONArray;
    }
    if ((z.a(23)) && (paramContext.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0)) {
      return localJSONArray;
    }
    for (;;)
    {
      try
      {
        paramContext = c.e;
        localObject = c.e;
        paramContext = (LocationManager)paramContext.getSystemService("location");
        boolean bool1 = paramContext.isProviderEnabled("gps");
        boolean bool2 = paramContext.isProviderEnabled("network");
        if ((bool1) || (bool2))
        {
          paramContext = paramContext.getLastKnownLocation("passive");
          if (paramContext == null) {}
        }
      }
      catch (Throwable paramContext)
      {
        Object localObject;
        av.postSDKError(paramContext);
        continue;
      }
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("lat", paramContext.getLatitude());
        ((JSONObject)localObject).put("lng", paramContext.getLongitude());
        ((JSONObject)localObject).put("ts", paramContext.getTime());
        if (z.a(17)) {
          ((JSONObject)localObject).put("elapsed", paramContext.getElapsedRealtimeNanos());
        }
        if (paramContext.hasAltitude()) {
          ((JSONObject)localObject).put("altitude", paramContext.getAltitude());
        }
        if (paramContext.hasAccuracy()) {
          ((JSONObject)localObject).put("hAccuracy", paramContext.getAccuracy());
        }
        if (paramContext.hasBearing()) {
          ((JSONObject)localObject).put("bearing", paramContext.getBearing());
        }
        if (paramContext.hasSpeed()) {
          ((JSONObject)localObject).put("speed", paramContext.getSpeed());
        }
        ((JSONObject)localObject).put("provider", paramContext.getProvider());
        localJSONArray.put(localObject);
      }
      catch (Throwable paramContext) {}
    }
    return localJSONArray;
  }
  
  /* Error */
  public static JSONArray b(Context paramContext)
  {
    // Byte code:
    //   0: new 19	org/json/JSONArray
    //   3: dup
    //   4: invokespecial 20	org/json/JSONArray:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokestatic 155	com/g/a/y:c	(Landroid/content/Context;)[Landroid/accounts/Account;
    //   12: astore 4
    //   14: aload 4
    //   16: ifnull +69 -> 85
    //   19: aload 4
    //   21: arraylength
    //   22: istore_2
    //   23: iconst_0
    //   24: istore_1
    //   25: iload_1
    //   26: iload_2
    //   27: if_icmpge +58 -> 85
    //   30: aload 4
    //   32: iload_1
    //   33: aaload
    //   34: astore 5
    //   36: new 66	org/json/JSONObject
    //   39: dup
    //   40: invokespecial 67	org/json/JSONObject:<init>	()V
    //   43: astore 6
    //   45: aload 6
    //   47: ldc -99
    //   49: aload 5
    //   51: getfield 162	android/accounts/Account:type	Ljava/lang/String;
    //   54: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   57: pop
    //   58: aload 6
    //   60: ldc -92
    //   62: aload 5
    //   64: getfield 166	android/accounts/Account:name	Ljava/lang/String;
    //   67: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   70: pop
    //   71: aload_3
    //   72: aload 6
    //   74: invokevirtual 144	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   77: pop
    //   78: iload_1
    //   79: iconst_1
    //   80: iadd
    //   81: istore_1
    //   82: goto -57 -> 25
    //   85: aload_0
    //   86: invokestatic 171	com/g/a/r:x	(Landroid/content/Context;)Lorg/json/JSONArray;
    //   89: astore_0
    //   90: aload_0
    //   91: invokevirtual 175	org/json/JSONArray:length	()I
    //   94: putstatic 10	com/g/a/y:a	I
    //   97: aload_0
    //   98: invokevirtual 175	org/json/JSONArray:length	()I
    //   101: ifle +38 -> 139
    //   104: new 66	org/json/JSONObject
    //   107: dup
    //   108: invokespecial 67	org/json/JSONObject:<init>	()V
    //   111: astore 4
    //   113: aload 4
    //   115: ldc -99
    //   117: ldc -79
    //   119: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   122: pop
    //   123: aload 4
    //   125: ldc -77
    //   127: aload_0
    //   128: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   131: pop
    //   132: aload_3
    //   133: aload 4
    //   135: invokevirtual 144	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   138: pop
    //   139: aload_3
    //   140: invokevirtual 175	org/json/JSONArray:length	()I
    //   143: istore_1
    //   144: iload_1
    //   145: ifle +10 -> 155
    //   148: aload_3
    //   149: areturn
    //   150: astore_0
    //   151: aload_0
    //   152: invokestatic 150	com/g/a/av:postSDKError	(Ljava/lang/Throwable;)V
    //   155: aconst_null
    //   156: areturn
    //   157: astore 5
    //   159: goto -81 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramContext	Context
    //   24	121	1	i	int
    //   22	6	2	j	int
    //   7	142	3	localJSONArray	JSONArray
    //   12	122	4	localObject1	Object
    //   34	29	5	localObject2	Object
    //   157	1	5	localThrowable	Throwable
    //   43	30	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	14	150	java/lang/Throwable
    //   19	23	150	java/lang/Throwable
    //   85	139	150	java/lang/Throwable
    //   139	144	150	java/lang/Throwable
    //   36	78	157	java/lang/Throwable
  }
  
  public static Account[] c(Context paramContext)
  {
    if (z.b(paramContext, "android.permission.GET_ACCOUNTS")) {}
    return null;
  }
  
  public static Long[][] d(Context paramContext)
  {
    return new Long[3][];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/g/a/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */