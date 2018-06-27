package com.unionpay.sdk;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class q
{
  private static long a(String paramString)
  {
    long l = 1125899906842597L;
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      l = l * 131L + paramString.charAt(i);
      i += 1;
    }
    return l;
  }
  
  public static List a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    if (!r.b) {
      return localArrayList;
    }
    if ((r.a(23)) && (paramContext.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0)) {
      return localArrayList;
    }
    try
    {
      if (((r.b(paramContext, "android.permission.ACCESS_FINE_LOCATION")) || (r.b(paramContext, "android.permission.ACCESS_COARSE_LOCATION"))) && ((r.d) || (r.e))) {
        ((LocationManager)paramContext.getSystemService("location")).getProviders(true);
      }
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return localArrayList;
  }
  
  public static String b(Context paramContext)
  {
    paramContext = a(paramContext);
    StringBuffer localStringBuffer1 = new StringBuffer();
    Iterator localIterator = paramContext.iterator();
    if (localIterator.hasNext())
    {
      Location localLocation = (Location)localIterator.next();
      StringBuffer localStringBuffer2 = localStringBuffer1.append(localLocation.getLatitude()).append(',').append(localLocation.getLongitude()).append(',');
      if (localLocation.hasAltitude())
      {
        paramContext = Double.valueOf(localLocation.getAltitude());
        label81:
        localStringBuffer2 = localStringBuffer2.append(paramContext).append(',').append(localLocation.getTime()).append(',');
        if (!localLocation.hasAccuracy()) {
          break label210;
        }
        paramContext = Float.valueOf(localLocation.getAccuracy());
        label121:
        localStringBuffer2 = localStringBuffer2.append(paramContext).append(',');
        if (!localLocation.hasBearing()) {
          break label216;
        }
        paramContext = Float.valueOf(localLocation.getBearing());
        label149:
        localStringBuffer2 = localStringBuffer2.append(paramContext).append(',');
        if (!localLocation.hasSpeed()) {
          break label222;
        }
      }
      label210:
      label216:
      label222:
      for (paramContext = Float.valueOf(localLocation.getSpeed());; paramContext = "")
      {
        localStringBuffer2.append(paramContext).append(',').append(localLocation.getProvider()).append(':');
        break;
        paramContext = "";
        break label81;
        paramContext = "";
        break label121;
        paramContext = "";
        break label149;
      }
    }
    return localStringBuffer1.toString();
  }
  
  public static JSONArray c(Context paramContext)
  {
    Object localObject = a(paramContext);
    paramContext = new JSONArray();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Location localLocation = (Location)((Iterator)localObject).next();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("lat", localLocation.getLatitude());
        localJSONObject.put("lng", localLocation.getLongitude());
        localJSONObject.put("ts", localLocation.getTime());
        if (r.a(17)) {
          localJSONObject.put("elapsed", localLocation.getElapsedRealtimeNanos());
        }
        if (localLocation.hasAltitude()) {
          localJSONObject.put("altitude", localLocation.getAltitude());
        }
        if (localLocation.hasAccuracy()) {
          localJSONObject.put("accurate", localLocation.getAccuracy());
        }
        if (localLocation.hasBearing()) {
          localJSONObject.put("bearing", localLocation.getBearing());
        }
        if (localLocation.hasSpeed()) {
          localJSONObject.put("speed", localLocation.getSpeed());
        }
        localJSONObject.put("provider", localLocation.getProvider());
        paramContext.put(localJSONObject);
      }
      catch (Throwable localThrowable) {}
    }
    return paramContext;
  }
  
  /* Error */
  public static JSONArray d(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 171	org/json/JSONArray
    //   5: dup
    //   6: invokespecial 172	org/json/JSONArray:<init>	()V
    //   9: astore 4
    //   11: aload_0
    //   12: invokestatic 212	com/unionpay/sdk/q:e	(Landroid/content/Context;)[Landroid/accounts/Account;
    //   15: astore 5
    //   17: aload 5
    //   19: ifnull +70 -> 89
    //   22: aload 5
    //   24: arraylength
    //   25: istore_3
    //   26: iconst_0
    //   27: istore_1
    //   28: iload_1
    //   29: iload_3
    //   30: if_icmpge +59 -> 89
    //   33: aload 5
    //   35: iload_1
    //   36: aaload
    //   37: astore 6
    //   39: new 174	org/json/JSONObject
    //   42: dup
    //   43: invokespecial 175	org/json/JSONObject:<init>	()V
    //   46: astore 7
    //   48: aload 7
    //   50: ldc -42
    //   52: aload 6
    //   54: getfield 219	android/accounts/Account:type	Ljava/lang/String;
    //   57: invokevirtual 206	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   60: pop
    //   61: aload 7
    //   63: ldc -35
    //   65: aload 6
    //   67: getfield 223	android/accounts/Account:name	Ljava/lang/String;
    //   70: invokevirtual 206	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   73: pop
    //   74: aload 4
    //   76: aload 7
    //   78: invokevirtual 209	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   81: pop
    //   82: iload_1
    //   83: iconst_1
    //   84: iadd
    //   85: istore_1
    //   86: goto -58 -> 28
    //   89: aload_0
    //   90: invokestatic 228	com/unionpay/sdk/j:y	(Landroid/content/Context;)Lorg/json/JSONArray;
    //   93: astore 5
    //   95: iload_2
    //   96: istore_1
    //   97: iload_1
    //   98: aload 5
    //   100: invokevirtual 229	org/json/JSONArray:length	()I
    //   103: if_icmpge +163 -> 266
    //   106: aload 5
    //   108: iload_1
    //   109: invokevirtual 233	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   112: astore 6
    //   114: aload 6
    //   116: ldc -21
    //   118: invokevirtual 239	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   121: astore 7
    //   123: aload 7
    //   125: ifnull +133 -> 258
    //   128: new 174	org/json/JSONObject
    //   131: dup
    //   132: invokespecial 175	org/json/JSONObject:<init>	()V
    //   135: astore 8
    //   137: aload 8
    //   139: ldc -42
    //   141: ldc -15
    //   143: invokevirtual 206	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   146: pop
    //   147: aload 8
    //   149: ldc -35
    //   151: aload 7
    //   153: invokevirtual 206	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   156: pop
    //   157: aload 8
    //   159: ldc -13
    //   161: aload 6
    //   163: ldc -11
    //   165: invokevirtual 248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   168: invokevirtual 206	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   171: pop
    //   172: aload 8
    //   174: ldc -6
    //   176: aload 6
    //   178: ldc -4
    //   180: invokevirtual 248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   183: invokevirtual 206	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   186: pop
    //   187: aload 8
    //   189: ldc -2
    //   191: aload 6
    //   193: ldc_w 256
    //   196: invokevirtual 248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   199: invokevirtual 206	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   202: pop
    //   203: aload 8
    //   205: ldc_w 258
    //   208: aload_0
    //   209: invokestatic 261	com/unionpay/sdk/j:o	(Landroid/content/Context;)Ljava/lang/String;
    //   212: invokevirtual 206	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   215: pop
    //   216: aload 8
    //   218: ldc_w 263
    //   221: aload 6
    //   223: ldc_w 265
    //   226: invokevirtual 248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   229: invokevirtual 206	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   232: pop
    //   233: aload 8
    //   235: ldc_w 267
    //   238: aload 6
    //   240: ldc_w 269
    //   243: invokevirtual 248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   246: invokevirtual 206	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   249: pop
    //   250: aload 4
    //   252: aload 8
    //   254: invokevirtual 209	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   257: pop
    //   258: iload_1
    //   259: iconst_1
    //   260: iadd
    //   261: istore_1
    //   262: goto -165 -> 97
    //   265: astore_0
    //   266: aload 4
    //   268: invokevirtual 229	org/json/JSONArray:length	()I
    //   271: ifle +6 -> 277
    //   274: aload 4
    //   276: areturn
    //   277: aconst_null
    //   278: areturn
    //   279: astore 6
    //   281: goto -199 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	paramContext	Context
    //   27	235	1	i	int
    //   1	95	2	j	int
    //   25	6	3	k	int
    //   9	266	4	localJSONArray	JSONArray
    //   15	92	5	localObject1	Object
    //   37	202	6	localJSONObject1	JSONObject
    //   279	1	6	localThrowable	Throwable
    //   46	106	7	localObject2	Object
    //   135	118	8	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   89	95	265	java/lang/Throwable
    //   97	123	265	java/lang/Throwable
    //   128	258	265	java/lang/Throwable
    //   39	82	279	java/lang/Throwable
  }
  
  public static Account[] e(Context paramContext)
  {
    if (r.b(paramContext, "android.permission.GET_ACCOUNTS")) {
      try
      {
        paramContext = AccountManager.get(paramContext).getAccounts();
        return paramContext;
      }
      catch (Throwable paramContext) {}
    }
    return null;
  }
  
  public static Long[][] f(Context paramContext)
  {
    arrayOfLong = new Long[3][];
    try
    {
      Object localObject2 = (ActivityManager)paramContext.getSystemService("activity");
      Object localObject1 = paramContext.getPackageManager();
      HashSet localHashSet = new HashSet();
      localHashSet.add(paramContext.getPackageName());
      try
      {
        Object localObject3 = new HashSet();
        if (r.b(paramContext, "android.permission.GET_TASKS"))
        {
          paramContext = ((ActivityManager)localObject2).getRecentTasks(10, 1);
          if (paramContext != null)
          {
            paramContext = paramContext.iterator();
            while (paramContext.hasNext())
            {
              Object localObject4 = ((ActivityManager.RecentTaskInfo)paramContext.next()).baseIntent.getComponent();
              if (localObject4 != null)
              {
                localObject4 = ((ComponentName)localObject4).getPackageName();
                if (localHashSet.add(localObject4)) {
                  ((Set)localObject3).add(Long.valueOf(a((String)localObject4)));
                }
              }
            }
          }
        }
        try
        {
          for (;;)
          {
            localObject2 = ((ActivityManager)localObject2).getRunningAppProcesses();
            paramContext = new HashSet();
            if (localObject2 == null) {
              break;
            }
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = ((ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next()).processName;
              try
              {
                if (((PackageManager)localObject1).getLaunchIntentForPackage((String)localObject3) != null) {
                  paramContext.add(Long.valueOf(a((String)localObject3)));
                }
              }
              catch (Throwable localThrowable) {}
            }
            arrayOfLong[0] = new Long[localThrowable.size()];
            arrayOfLong[0] = ((Long[])localThrowable.toArray(arrayOfLong[0]));
          }
          arrayOfLong[1] = new Long[paramContext.size()];
          arrayOfLong[1] = ((Long[])paramContext.toArray(arrayOfLong[1]));
        }
        catch (Throwable paramContext)
        {
          for (;;) {}
        }
      }
      catch (Throwable paramContext) {}
      return arrayOfLong;
    }
    catch (Throwable paramContext)
    {
      try
      {
        localObject1 = ((PackageManager)localObject1).getInstalledApplications(0);
        paramContext = new HashSet();
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ApplicationInfo)((Iterator)localObject1).next();
            if (((((ApplicationInfo)localObject2).flags & 0x1) <= 0) && (!localHashSet.contains(((ApplicationInfo)localObject2).packageName))) {
              paramContext.add(Long.valueOf(a(((ApplicationInfo)localObject2).packageName)));
            }
          }
        }
        arrayOfLong[2] = new Long[paramContext.size()];
        arrayOfLong[2] = ((Long[])paramContext.toArray(arrayOfLong[2]));
        return arrayOfLong;
      }
      catch (Throwable paramContext) {}
      paramContext = paramContext;
      return arrayOfLong;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */