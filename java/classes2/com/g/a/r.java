package com.g.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class r
{
  static TelephonyManager a;
  static boolean b = false;
  static long c = -300000L;
  private static final String[] d = { "UNKNOWN", "GPRS", "EDGE", "UMTS", "CDMA", "EVDO_0", "EVDO_A", "1xRTT", "HSDPA", "HSUPA", "HSPA", "IDEN", "EVDO_B", "LTE", "EHRPD", "HSPAP" };
  private static final String[] e = { "NONE", "GSM", "CDMA", "SIP" };
  
  private static JSONArray A(Context paramContext)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Object localObject2 = (TelephonyManager)paramContext.getSystemService("phone");
      paramContext = Class.forName("com.android.internal.telephony.Phone");
      try
      {
        localObject1 = paramContext.getField("GEMINI_SIM_1");
        ((Field)localObject1).setAccessible(true);
        localObject1 = (Integer)((Field)localObject1).get(null);
        paramContext = paramContext.getField("GEMINI_SIM_2");
        paramContext.setAccessible(true);
        paramContext = (Integer)paramContext.get(null);
        Object localObject3 = TelephonyManager.class.getMethod("getDefault", new Class[] { Integer.TYPE });
        localObject1 = (TelephonyManager)((Method)localObject3).invoke(localObject2, new Object[] { localObject1 });
        paramContext = (TelephonyManager)((Method)localObject3).invoke(localObject2, new Object[] { paramContext });
        localObject3 = ((TelephonyManager)localObject1).getDeviceId().trim();
        localObject2 = paramContext.getDeviceId().trim();
        if (b((String)localObject3).booleanValue())
        {
          localObject1 = a((TelephonyManager)localObject1, (String)localObject3);
          if (localObject1 != null) {
            localJSONArray.put(localObject1);
          }
        }
        if (b((String)localObject2).booleanValue())
        {
          paramContext = a(paramContext, (String)localObject2);
          if (paramContext != null) {
            localJSONArray.put(paramContext);
          }
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          Object localObject1 = Integer.valueOf(0);
          paramContext = Integer.valueOf(1);
        }
      }
      return localJSONArray;
    }
    catch (Throwable paramContext)
    {
      return null;
    }
  }
  
  private static JSONArray B(Context paramContext)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Object localObject = Class.forName("com.android.internal.telephony.PhoneFactory");
      String str2 = (String)((Class)localObject).getMethod("getServiceName", new Class[] { String.class, Integer.TYPE }).invoke(localObject, new Object[] { "phone", Integer.valueOf(1) });
      localObject = (TelephonyManager)paramContext.getSystemService("phone");
      String str1 = ((TelephonyManager)localObject).getDeviceId().trim();
      paramContext = (TelephonyManager)paramContext.getSystemService(str2);
      str2 = paramContext.getDeviceId().trim();
      if (b(str1).booleanValue())
      {
        localObject = a((TelephonyManager)localObject, str1);
        if (localObject != null) {
          localJSONArray.put(localObject);
        }
      }
      if (b(str2).booleanValue())
      {
        paramContext = a(paramContext, str2);
        if (paramContext != null) {
          localJSONArray.put(paramContext);
        }
      }
      return localJSONArray;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  private static JSONArray C(Context paramContext)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Class localClass = Class.forName("android.telephony.MSimTelephonyManager");
      paramContext = paramContext.getSystemService("phone_msim");
      Integer localInteger1 = Integer.valueOf(0);
      Integer localInteger2 = Integer.valueOf(1);
      Object localObject = localClass.getMethod("getDeviceId", new Class[] { Integer.TYPE });
      String str = ((String)((Method)localObject).invoke(paramContext, new Object[] { localInteger1 })).trim();
      localObject = ((String)((Method)localObject).invoke(paramContext, new Object[] { localInteger2 })).trim();
      if (b(str).booleanValue()) {
        localJSONArray.put(a(localClass, paramContext, localInteger1, str, ""));
      }
      if (b((String)localObject).booleanValue()) {
        localJSONArray.put(a(localClass, paramContext, localInteger2, (String)localObject, ""));
      }
      return localJSONArray;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  private static Boolean a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (paramString.length() > 0)
        {
          i = paramString.charAt(0);
          Boolean localBoolean2 = Boolean.valueOf(true);
          int j = 0;
          Boolean localBoolean1 = localBoolean2;
          if (j < paramString.length())
          {
            if (i != paramString.charAt(j)) {
              localBoolean1 = Boolean.valueOf(false);
            }
          }
          else {
            return localBoolean1;
          }
          j += 1;
          continue;
        }
        int i = 48;
      }
      catch (Throwable paramString)
      {
        return Boolean.valueOf(false);
      }
    }
  }
  
  private static String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < d.length)) {
      return d[paramInt];
    }
    return String.valueOf(paramInt);
  }
  
  public static JSONArray a(ArrayList paramArrayList, int paramInt)
  {
    try
    {
      Collections.sort(paramArrayList, new u());
      paramArrayList = new JSONArray(paramArrayList.subList(0, paramInt));
      return paramArrayList;
    }
    catch (Throwable paramArrayList) {}
    return null;
  }
  
  private static JSONArray a(BitSet paramBitSet)
  {
    if (paramBitSet == null) {}
    for (;;)
    {
      return null;
      if (paramBitSet.cardinality() >= 1)
      {
        JSONArray localJSONArray = new JSONArray();
        for (int i = paramBitSet.nextSetBit(0); i >= 0; i = paramBitSet.nextSetBit(i + 1)) {
          localJSONArray.put(i);
        }
      }
    }
  }
  
  public static JSONObject a(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("lat", paramInt1);
      localJSONObject.put("lng", paramInt2);
      localJSONObject.put("unit", "qd");
      return localJSONObject;
    }
    catch (Throwable localThrowable) {}
    return localJSONObject;
  }
  
  private static JSONObject a(TelephonyManager paramTelephonyManager, SubscriptionManager paramSubscriptionManager, int paramInt)
  {
    localJSONObject = new JSONObject();
    try
    {
      if (z.a(22))
      {
        SubscriptionInfo localSubscriptionInfo = paramSubscriptionManager.getActiveSubscriptionInfoForSimSlotIndex(paramInt);
        if (localSubscriptionInfo != null)
        {
          if (localSubscriptionInfo.getIccId() == null)
          {
            paramSubscriptionManager = "";
            localJSONObject.put("simSerialNumber", paramSubscriptionManager);
            localJSONObject.put("simOperator", localSubscriptionInfo.getMcc() + "0" + localSubscriptionInfo.getMnc());
            if (localSubscriptionInfo.getCarrierName() != null) {
              break label206;
            }
            paramSubscriptionManager = "";
            label99:
            localJSONObject.put("simOperatorName", paramSubscriptionManager);
            if (localSubscriptionInfo.getCountryIso() != null) {
              break label215;
            }
          }
          label206:
          label215:
          for (paramSubscriptionManager = "";; paramSubscriptionManager = localSubscriptionInfo.getCountryIso())
          {
            localJSONObject.put("simCountryIso", paramSubscriptionManager);
            paramInt = localSubscriptionInfo.getSubscriptionId();
            paramSubscriptionManager = paramTelephonyManager.getClass().getMethod("getSubscriberId", new Class[] { Integer.TYPE });
            paramSubscriptionManager.setAccessible(true);
            paramSubscriptionManager = paramSubscriptionManager.invoke(paramTelephonyManager, new Object[] { Integer.valueOf(paramInt) });
            paramTelephonyManager = paramSubscriptionManager;
            if (paramSubscriptionManager == null) {
              paramTelephonyManager = "";
            }
            localJSONObject.put("subscriberId", paramTelephonyManager);
            return localJSONObject;
            paramSubscriptionManager = localSubscriptionInfo.getIccId();
            break;
            paramSubscriptionManager = localSubscriptionInfo.getCarrierName();
            break label99;
          }
        }
      }
      return localJSONObject;
    }
    catch (Throwable paramTelephonyManager) {}
  }
  
  private static JSONObject a(TelephonyManager paramTelephonyManager, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("imei", paramString.trim());
      if (paramTelephonyManager.getSubscriberId() == null)
      {
        paramString = "";
        localJSONObject.put("subscriberId", paramString);
        if (paramTelephonyManager.getSimSerialNumber() != null) {
          break label179;
        }
        paramString = "";
        label49:
        localJSONObject.put("simSerialNumber", paramString);
        localJSONObject.put("dataState", paramTelephonyManager.getDataState());
        localJSONObject.put("networkType", a(paramTelephonyManager.getNetworkType()));
        localJSONObject.put("networkOperator", paramTelephonyManager.getNetworkOperator());
        localJSONObject.put("phoneType", b(paramTelephonyManager.getPhoneType()));
        if (paramTelephonyManager.getSimOperator() != null) {
          break label187;
        }
        paramString = "";
        label122:
        localJSONObject.put("simOperator", paramString);
        if (paramTelephonyManager.getSimOperatorName() != null) {
          break label195;
        }
        paramString = "";
        label141:
        localJSONObject.put("simOperatorName", paramString);
        if (paramTelephonyManager.getSimCountryIso() != null) {
          break label203;
        }
      }
      label179:
      label187:
      label195:
      label203:
      for (paramTelephonyManager = "";; paramTelephonyManager = paramTelephonyManager.getSimCountryIso())
      {
        localJSONObject.put("simCountryIso", paramTelephonyManager);
        return localJSONObject;
        paramString = paramTelephonyManager.getSubscriberId();
        break;
        paramString = paramTelephonyManager.getSimSerialNumber();
        break label49;
        paramString = paramTelephonyManager.getSimOperator();
        break label122;
        paramString = paramTelephonyManager.getSimOperatorName();
        break label141;
      }
      return null;
    }
    catch (Throwable paramTelephonyManager) {}
  }
  
  /* Error */
  private static JSONObject a(Class paramClass, Object paramObject, Integer paramInteger, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 222	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 223	org/json/JSONObject:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: ldc_w 304
    //   14: aload_3
    //   15: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   18: pop
    //   19: aload_0
    //   20: new 260	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 299
    //   30: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload 4
    //   35: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: iconst_1
    //   42: anewarray 90	java/lang/Class
    //   45: dup
    //   46: iconst_0
    //   47: getstatic 120	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   50: aastore
    //   51: invokevirtual 124	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   54: astore_3
    //   55: aload_3
    //   56: aload_1
    //   57: iconst_1
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload_2
    //   64: aastore
    //   65: invokevirtual 130	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   68: ifnonnull +462 -> 530
    //   71: ldc -86
    //   73: astore_3
    //   74: aload 5
    //   76: ldc_w 302
    //   79: aload_3
    //   80: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   83: pop
    //   84: aload_0
    //   85: new 260	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 343
    //   95: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload 4
    //   100: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: iconst_1
    //   107: anewarray 90	java/lang/Class
    //   110: dup
    //   111: iconst_0
    //   112: getstatic 120	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   115: aastore
    //   116: invokevirtual 124	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   119: astore_3
    //   120: aload_3
    //   121: aload_1
    //   122: iconst_1
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: aload_2
    //   129: aastore
    //   130: invokevirtual 130	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   133: ifnonnull +420 -> 553
    //   136: ldc -86
    //   138: astore_3
    //   139: aload 5
    //   141: ldc_w 256
    //   144: aload_3
    //   145: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   148: pop
    //   149: aload 5
    //   151: ldc_w 311
    //   154: aload_0
    //   155: new 260	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   162: ldc_w 344
    //   165: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 4
    //   170: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: iconst_1
    //   177: anewarray 90	java/lang/Class
    //   180: dup
    //   181: iconst_0
    //   182: getstatic 120	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   185: aastore
    //   186: invokevirtual 124	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   189: aload_1
    //   190: iconst_1
    //   191: anewarray 4	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: aload_2
    //   197: aastore
    //   198: invokevirtual 130	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   201: checkcast 112	java/lang/Integer
    //   204: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload 5
    //   210: ldc_w 316
    //   213: aload_0
    //   214: new 260	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   221: ldc_w 345
    //   224: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload 4
    //   229: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: iconst_1
    //   236: anewarray 90	java/lang/Class
    //   239: dup
    //   240: iconst_0
    //   241: getstatic 120	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   244: aastore
    //   245: invokevirtual 124	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   248: aload_1
    //   249: iconst_1
    //   250: anewarray 4	java/lang/Object
    //   253: dup
    //   254: iconst_0
    //   255: aload_2
    //   256: aastore
    //   257: invokevirtual 130	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   260: checkcast 112	java/lang/Integer
    //   263: invokevirtual 348	java/lang/Integer:intValue	()I
    //   266: invokestatic 321	com/g/a/r:a	(I)Ljava/lang/String;
    //   269: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   272: pop
    //   273: aload 5
    //   275: ldc_w 323
    //   278: aload_0
    //   279: new 260	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 349
    //   289: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload 4
    //   294: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: iconst_1
    //   301: anewarray 90	java/lang/Class
    //   304: dup
    //   305: iconst_0
    //   306: getstatic 120	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   309: aastore
    //   310: invokevirtual 124	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   313: aload_1
    //   314: iconst_1
    //   315: anewarray 4	java/lang/Object
    //   318: dup
    //   319: iconst_0
    //   320: aload_2
    //   321: aastore
    //   322: invokevirtual 130	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   325: checkcast 17	java/lang/String
    //   328: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   331: pop
    //   332: aload 5
    //   334: ldc_w 328
    //   337: aload_0
    //   338: new 260	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   345: ldc_w 350
    //   348: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload 4
    //   353: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: iconst_1
    //   360: anewarray 90	java/lang/Class
    //   363: dup
    //   364: iconst_0
    //   365: getstatic 120	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   368: aastore
    //   369: invokevirtual 124	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   372: aload_1
    //   373: iconst_1
    //   374: anewarray 4	java/lang/Object
    //   377: dup
    //   378: iconst_0
    //   379: aload_2
    //   380: aastore
    //   381: invokevirtual 130	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   384: checkcast 112	java/lang/Integer
    //   387: invokevirtual 348	java/lang/Integer:intValue	()I
    //   390: invokestatic 333	com/g/a/r:b	(I)Ljava/lang/String;
    //   393: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   396: pop
    //   397: aload_0
    //   398: new 260	java/lang/StringBuilder
    //   401: dup
    //   402: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   405: ldc_w 351
    //   408: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload 4
    //   413: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: iconst_1
    //   420: anewarray 90	java/lang/Class
    //   423: dup
    //   424: iconst_0
    //   425: getstatic 120	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   428: aastore
    //   429: invokevirtual 124	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   432: astore_3
    //   433: aload_3
    //   434: aload_1
    //   435: iconst_1
    //   436: anewarray 4	java/lang/Object
    //   439: dup
    //   440: iconst_0
    //   441: aload_2
    //   442: aastore
    //   443: invokevirtual 130	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   446: ifnonnull +130 -> 576
    //   449: ldc -86
    //   451: astore_3
    //   452: aload 5
    //   454: ldc_w 258
    //   457: aload_3
    //   458: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   461: pop
    //   462: aload_0
    //   463: new 260	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   470: ldc_w 352
    //   473: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload 4
    //   478: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: iconst_1
    //   485: anewarray 90	java/lang/Class
    //   488: dup
    //   489: iconst_0
    //   490: getstatic 120	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   493: aastore
    //   494: invokevirtual 124	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   497: astore_0
    //   498: aload_0
    //   499: aload_1
    //   500: iconst_1
    //   501: anewarray 4	java/lang/Object
    //   504: dup
    //   505: iconst_0
    //   506: aload_2
    //   507: aastore
    //   508: invokevirtual 130	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   511: ifnonnull +88 -> 599
    //   514: ldc -86
    //   516: astore_0
    //   517: aload 5
    //   519: ldc_w 285
    //   522: aload_0
    //   523: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   526: pop
    //   527: aload 5
    //   529: areturn
    //   530: aload_3
    //   531: aload_1
    //   532: iconst_1
    //   533: anewarray 4	java/lang/Object
    //   536: dup
    //   537: iconst_0
    //   538: aload_2
    //   539: aastore
    //   540: invokevirtual 130	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   543: checkcast 17	java/lang/String
    //   546: invokevirtual 137	java/lang/String:trim	()Ljava/lang/String;
    //   549: astore_3
    //   550: goto -476 -> 74
    //   553: aload_3
    //   554: aload_1
    //   555: iconst_1
    //   556: anewarray 4	java/lang/Object
    //   559: dup
    //   560: iconst_0
    //   561: aload_2
    //   562: aastore
    //   563: invokevirtual 130	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   566: checkcast 17	java/lang/String
    //   569: invokevirtual 137	java/lang/String:trim	()Ljava/lang/String;
    //   572: astore_3
    //   573: goto -434 -> 139
    //   576: aload_3
    //   577: aload_1
    //   578: iconst_1
    //   579: anewarray 4	java/lang/Object
    //   582: dup
    //   583: iconst_0
    //   584: aload_2
    //   585: aastore
    //   586: invokevirtual 130	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   589: checkcast 17	java/lang/String
    //   592: invokevirtual 137	java/lang/String:trim	()Ljava/lang/String;
    //   595: astore_3
    //   596: goto -144 -> 452
    //   599: aload_0
    //   600: aload_1
    //   601: iconst_1
    //   602: anewarray 4	java/lang/Object
    //   605: dup
    //   606: iconst_0
    //   607: aload_2
    //   608: aastore
    //   609: invokevirtual 130	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   612: checkcast 17	java/lang/String
    //   615: invokevirtual 137	java/lang/String:trim	()Ljava/lang/String;
    //   618: astore_0
    //   619: goto -102 -> 517
    //   622: astore_0
    //   623: aload 5
    //   625: areturn
    //   626: astore_3
    //   627: goto -165 -> 462
    //   630: astore_3
    //   631: goto -234 -> 397
    //   634: astore_3
    //   635: goto -303 -> 332
    //   638: astore_3
    //   639: goto -366 -> 273
    //   642: astore_3
    //   643: goto -435 -> 208
    //   646: astore_3
    //   647: goto -498 -> 149
    //   650: astore_3
    //   651: goto -567 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	654	0	paramClass	Class
    //   0	654	1	paramObject	Object
    //   0	654	2	paramInteger	Integer
    //   0	654	3	paramString1	String
    //   0	654	4	paramString2	String
    //   7	617	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   462	514	622	java/lang/Throwable
    //   517	527	622	java/lang/Throwable
    //   599	619	622	java/lang/Throwable
    //   397	449	626	java/lang/Throwable
    //   452	462	626	java/lang/Throwable
    //   576	596	626	java/lang/Throwable
    //   332	397	630	java/lang/Throwable
    //   273	332	634	java/lang/Throwable
    //   208	273	638	java/lang/Throwable
    //   149	208	642	java/lang/Throwable
    //   84	136	646	java/lang/Throwable
    //   139	149	646	java/lang/Throwable
    //   553	573	646	java/lang/Throwable
    //   19	71	650	java/lang/Throwable
    //   74	84	650	java/lang/Throwable
    //   530	550	650	java/lang/Throwable
  }
  
  static void a(Context paramContext)
  {
    try
    {
      a = (TelephonyManager)paramContext.getSystemService("phone");
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static boolean a()
  {
    boolean bool1 = true;
    try
    {
      if (z.a(11))
      {
        if (TextUtils.isEmpty(System.getProperty("http.proxyHost"))) {
          break label42;
        }
        return true;
      }
      boolean bool2 = TextUtils.isEmpty(Proxy.getDefaultHost());
      if (bool2) {
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      bool1 = false;
    }
    return bool1;
    label42:
    return false;
  }
  
  private static Boolean b(String paramString)
  {
    try
    {
      Integer localInteger = Integer.valueOf(paramString.length());
      if ((localInteger.intValue() > 10) && (localInteger.intValue() < 20) && (!a(paramString.trim()).booleanValue())) {
        return Boolean.valueOf(true);
      }
    }
    catch (Throwable paramString) {}
    return Boolean.valueOf(false);
  }
  
  private static String b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < e.length)) {
      return e[paramInt];
    }
    return String.valueOf(paramInt);
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      InetAddress localInetAddress;
      do
      {
        paramContext = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          if (!paramContext.hasMoreElements()) {
            break;
          }
          localEnumeration = ((NetworkInterface)paramContext.nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while ((localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address)));
      paramContext = localInetAddress.getHostAddress().toString();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      av.postSDKError(paramContext);
    }
    return null;
  }
  
  /* Error */
  public static boolean c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 415
    //   4: invokestatic 418	com/g/a/z:b	(Landroid/content/Context;Ljava/lang/String;)Z
    //   7: ifeq +51 -> 58
    //   10: aload_0
    //   11: ldc_w 420
    //   14: invokevirtual 84	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast 422	android/net/ConnectivityManager
    //   20: astore_0
    //   21: aload_0
    //   22: invokevirtual 426	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +8 -> 35
    //   30: aload_1
    //   31: invokevirtual 431	android/net/NetworkInfo:isConnected	()Z
    //   34: ireturn
    //   35: aload_0
    //   36: iconst_0
    //   37: invokevirtual 435	android/net/ConnectivityManager:getNetworkInfo	(I)Landroid/net/NetworkInfo;
    //   40: astore_0
    //   41: aload_0
    //   42: ifnull +82 -> 124
    //   45: aload_0
    //   46: invokevirtual 439	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   49: getstatic 444	android/net/NetworkInfo$State:UNKNOWN	Landroid/net/NetworkInfo$State;
    //   52: invokevirtual 448	android/net/NetworkInfo$State:equals	(Ljava/lang/Object;)Z
    //   55: ifeq +69 -> 124
    //   58: invokestatic 454	android/os/SystemClock:elapsedRealtime	()J
    //   61: getstatic 65	com/g/a/r:c	J
    //   64: lsub
    //   65: ldc2_w 455
    //   68: lcmp
    //   69: ifle +51 -> 120
    //   72: invokestatic 454	android/os/SystemClock:elapsedRealtime	()J
    //   75: putstatic 65	com/g/a/r:c	J
    //   78: aconst_null
    //   79: astore_0
    //   80: aload_0
    //   81: astore_1
    //   82: invokestatic 458	com/g/a/r:a	()Z
    //   85: ifeq +41 -> 126
    //   88: aload_0
    //   89: astore_1
    //   90: new 460	java/net/Socket
    //   93: dup
    //   94: invokestatic 374	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   97: invokestatic 463	android/net/Proxy:getDefaultPort	()I
    //   100: invokespecial 466	java/net/Socket:<init>	(Ljava/lang/String;I)V
    //   103: astore_0
    //   104: aload_0
    //   105: astore_1
    //   106: aload_0
    //   107: astore_2
    //   108: iconst_1
    //   109: putstatic 61	com/g/a/r:b	Z
    //   112: aload_0
    //   113: ifnull +7 -> 120
    //   116: aload_0
    //   117: invokevirtual 469	java/net/Socket:close	()V
    //   120: getstatic 61	com/g/a/r:b	Z
    //   123: ireturn
    //   124: iconst_0
    //   125: ireturn
    //   126: aload_0
    //   127: astore_1
    //   128: new 460	java/net/Socket
    //   131: dup
    //   132: ldc_w 471
    //   135: bipush 80
    //   137: invokespecial 466	java/net/Socket:<init>	(Ljava/lang/String;I)V
    //   140: astore_0
    //   141: goto -37 -> 104
    //   144: astore_0
    //   145: aload_1
    //   146: astore_2
    //   147: iconst_0
    //   148: putstatic 61	com/g/a/r:b	Z
    //   151: aload_1
    //   152: ifnull -32 -> 120
    //   155: aload_1
    //   156: invokevirtual 469	java/net/Socket:close	()V
    //   159: goto -39 -> 120
    //   162: astore_0
    //   163: goto -43 -> 120
    //   166: astore_0
    //   167: aconst_null
    //   168: astore_2
    //   169: aload_2
    //   170: ifnull +7 -> 177
    //   173: aload_2
    //   174: invokevirtual 469	java/net/Socket:close	()V
    //   177: aload_0
    //   178: athrow
    //   179: astore_0
    //   180: aload_0
    //   181: invokestatic 412	com/g/a/av:postSDKError	(Ljava/lang/Throwable;)V
    //   184: goto -64 -> 120
    //   187: astore_0
    //   188: goto -68 -> 120
    //   191: astore_1
    //   192: goto -15 -> 177
    //   195: astore_0
    //   196: goto -27 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	paramContext	Context
    //   25	131	1	localObject1	Object
    //   191	1	1	localThrowable	Throwable
    //   107	67	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   82	88	144	java/lang/Throwable
    //   90	104	144	java/lang/Throwable
    //   108	112	144	java/lang/Throwable
    //   128	141	144	java/lang/Throwable
    //   155	159	162	java/lang/Throwable
    //   82	88	166	finally
    //   90	104	166	finally
    //   128	141	166	finally
    //   0	26	179	java/lang/Throwable
    //   30	35	179	java/lang/Throwable
    //   35	41	179	java/lang/Throwable
    //   45	58	179	java/lang/Throwable
    //   58	78	179	java/lang/Throwable
    //   177	179	179	java/lang/Throwable
    //   116	120	187	java/lang/Throwable
    //   173	177	191	java/lang/Throwable
    //   108	112	195	finally
    //   147	151	195	finally
  }
  
  public static boolean d(Context paramContext)
  {
    try
    {
      if (z.b(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (paramContext != null)
        {
          boolean bool = paramContext.isAvailable();
          if (bool) {
            return true;
          }
        }
        return false;
      }
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static boolean e(Context paramContext)
  {
    try
    {
      if (g(paramContext)) {
        return true;
      }
      boolean bool = ((WifiManager)paramContext.getSystemService("wifi")).isWifiEnabled();
      return bool;
    }
    catch (Throwable paramContext)
    {
      av.postSDKError(paramContext);
    }
    return false;
  }
  
  public static boolean f(Context paramContext)
  {
    boolean bool = false;
    try
    {
      if (a == null) {
        a(paramContext);
      }
      int i = a.getSimState();
      if (i == 5) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static boolean g(Context paramContext)
  {
    try
    {
      if (z.b(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((paramContext != null) && (1 == paramContext.getType()))
        {
          boolean bool = paramContext.isConnected();
          if (bool) {
            return true;
          }
        }
        return false;
      }
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static boolean h(Context paramContext)
  {
    boolean bool = false;
    try
    {
      if (a == null) {
        a(paramContext);
      }
      int i = a.getDataState();
      if (i == 2) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static String i(Context paramContext)
  {
    if (!c(paramContext)) {
      return "OFFLINE";
    }
    if (g(paramContext)) {
      return "WIFI";
    }
    return a(j(paramContext));
  }
  
  public static int j(Context paramContext)
  {
    try
    {
      if (a == null) {
        a(paramContext);
      }
      int i = a.getNetworkType();
      return i;
    }
    catch (Throwable paramContext) {}
    return 0;
  }
  
  public static String k(Context paramContext)
  {
    try
    {
      if (a == null) {
        a(paramContext);
      }
      paramContext = a.getNetworkOperator();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static String l(Context paramContext)
  {
    try
    {
      if (a == null) {
        a(paramContext);
      }
      paramContext = a.getSimOperator();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static String m(Context paramContext)
  {
    try
    {
      if (a == null) {
        a(paramContext);
      }
      paramContext = a.getNetworkCountryIso();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static String n(Context paramContext)
  {
    try
    {
      if (a == null) {
        a(paramContext);
      }
      paramContext = a.getSimCountryIso();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static String o(Context paramContext)
  {
    try
    {
      if ((z.a(23)) && (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0)) {
        return null;
      }
      if ((z.b(paramContext, "android.permission.READ_PHONE_STATE")) && (Build.VERSION.SDK_INT >= 18))
      {
        if (a == null) {
          a(paramContext);
        }
        paramContext = a.getGroupIdLevel1();
        return paramContext;
      }
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static String p(Context paramContext)
  {
    try
    {
      if (a == null) {
        a(paramContext);
      }
      paramContext = a.getNetworkOperatorName();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static String q(Context paramContext)
  {
    try
    {
      if (a == null) {
        a(paramContext);
      }
      paramContext = a.getSimOperatorName();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static JSONArray r(Context paramContext)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", "wifi");
      localJSONObject.put("available", e(paramContext));
      localJSONObject.put("connected", g(paramContext));
      localJSONObject.put("current", v(paramContext));
      localJSONObject.put("scannable", w(paramContext));
      localJSONObject.put("configured", u(paramContext));
      localJSONArray.put(localJSONObject);
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("type", "cellular");
        localJSONObject.put("available", f(paramContext));
        localJSONObject.put("connected", h(paramContext));
        localJSONObject.put("current", s(paramContext));
        localJSONObject.put("scannable", t(paramContext));
        localJSONArray.put(localJSONObject);
        if (localJSONArray.length() > 0) {
          return localJSONArray;
        }
        return null;
      }
      catch (Throwable paramContext)
      {
        for (;;) {}
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public static JSONArray s(Context paramContext)
  {
    int j = 0;
    label251:
    label329:
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        if (!z.a) {
          return null;
        }
        int k = 1;
        localJSONObject = new JSONObject();
        localJSONObject.put("type", j(paramContext));
        localJSONObject.put("mcc", k(paramContext));
        localJSONObject.put("operator", p(paramContext));
        localJSONObject.put("country", m(paramContext));
        int i = k;
        if (z.a(23))
        {
          i = k;
          if (paramContext.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0)
          {
            i = k;
            if (paramContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
              i = 0;
            }
          }
        }
        if ((z.b(paramContext, "android.permission.ACCESS_COARSE_LOCATION")) || (z.b(paramContext, "android.permission.ACCESS_FINE_LOCATION"))) {
          break label329;
        }
        i = j;
        if (i != 0)
        {
          if (a == null) {
            a(paramContext);
          }
          if ((z.c) || (z.d))
          {
            paramContext = a.getCellLocation();
            if (!(paramContext instanceof GsmCellLocation)) {
              break label251;
            }
            paramContext = (GsmCellLocation)paramContext;
            if (paramContext != null)
            {
              localJSONObject.put("systemId", paramContext.getLac());
              localJSONObject.put("networkId", paramContext.getCid());
              if (z.a(9)) {
                localJSONObject.put("basestationId", paramContext.getPsc());
              }
            }
          }
        }
        paramContext = new JSONArray();
        paramContext.put(localJSONObject);
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        av.postSDKError(paramContext);
        return null;
      }
      if ((paramContext instanceof CdmaCellLocation))
      {
        paramContext = (CdmaCellLocation)paramContext;
        if (paramContext != null)
        {
          localJSONObject.put("systemId", paramContext.getSystemId());
          localJSONObject.put("networkId", paramContext.getNetworkId());
          localJSONObject.put("basestationId", paramContext.getBaseStationId());
          localJSONObject.put("location", a(paramContext.getBaseStationLatitude(), paramContext.getBaseStationLongitude()));
        }
      }
    }
  }
  
  /* Error */
  public static JSONArray t(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 575	com/g/a/z:a	Z
    //   3: ifne +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: bipush 23
    //   10: invokestatic 243	com/g/a/z:a	(I)Z
    //   13: ifeq +13 -> 26
    //   16: aload_0
    //   17: ldc_w 589
    //   20: invokevirtual 519	android/content/Context:checkSelfPermission	(Ljava/lang/String;)I
    //   23: ifne -17 -> 6
    //   26: aload_0
    //   27: ldc_w 589
    //   30: invokestatic 418	com/g/a/z:b	(Landroid/content/Context;Ljava/lang/String;)Z
    //   33: ifne +13 -> 46
    //   36: aload_0
    //   37: ldc_w 591
    //   40: invokestatic 418	com/g/a/z:b	(Landroid/content/Context;Ljava/lang/String;)Z
    //   43: ifeq -37 -> 6
    //   46: getstatic 355	com/g/a/r:a	Landroid/telephony/TelephonyManager;
    //   49: ifnonnull +7 -> 56
    //   52: aload_0
    //   53: invokestatic 487	com/g/a/r:a	(Landroid/content/Context;)V
    //   56: new 75	org/json/JSONArray
    //   59: dup
    //   60: invokespecial 76	org/json/JSONArray:<init>	()V
    //   63: astore 7
    //   65: bipush 17
    //   67: invokestatic 243	com/g/a/z:a	(I)Z
    //   70: ifeq +548 -> 618
    //   73: getstatic 355	com/g/a/r:a	Landroid/telephony/TelephonyManager;
    //   76: invokevirtual 641	android/telephony/TelephonyManager:getAllCellInfo	()Ljava/util/List;
    //   79: astore_0
    //   80: aload_0
    //   81: ifnull +689 -> 770
    //   84: aload_0
    //   85: invokeinterface 647 1 0
    //   90: astore 8
    //   92: aload 8
    //   94: invokeinterface 652 1 0
    //   99: ifeq +671 -> 770
    //   102: aload 8
    //   104: invokeinterface 655 1 0
    //   109: checkcast 657	android/telephony/CellInfo
    //   112: astore_0
    //   113: new 222	org/json/JSONObject
    //   116: dup
    //   117: invokespecial 223	org/json/JSONObject:<init>	()V
    //   120: astore 9
    //   122: aload 9
    //   124: ldc_w 659
    //   127: aload_0
    //   128: invokevirtual 662	android/telephony/CellInfo:isRegistered	()Z
    //   131: invokevirtual 543	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   134: pop
    //   135: aload 9
    //   137: ldc_w 664
    //   140: aload_0
    //   141: invokevirtual 667	android/telephony/CellInfo:getTimeStamp	()J
    //   144: invokevirtual 670	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   147: pop
    //   148: aload_0
    //   149: instanceof 672
    //   152: ifeq +184 -> 336
    //   155: aload_0
    //   156: checkcast 672	android/telephony/CellInfoGsm
    //   159: astore_0
    //   160: aload_0
    //   161: invokevirtual 676	android/telephony/CellInfoGsm:getCellIdentity	()Landroid/telephony/CellIdentityGsm;
    //   164: astore 6
    //   166: aload 6
    //   168: invokevirtual 679	android/telephony/CellIdentityGsm:getLac	()I
    //   171: istore 5
    //   173: aload 6
    //   175: invokevirtual 680	android/telephony/CellIdentityGsm:getCid	()I
    //   178: istore 4
    //   180: aload 6
    //   182: invokevirtual 681	android/telephony/CellIdentityGsm:getMcc	()I
    //   185: istore_2
    //   186: aload 6
    //   188: invokevirtual 682	android/telephony/CellIdentityGsm:getMnc	()I
    //   191: istore_1
    //   192: aload_0
    //   193: invokevirtual 686	android/telephony/CellInfoGsm:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthGsm;
    //   196: astore 6
    //   198: iconst_m1
    //   199: istore_3
    //   200: ldc 55
    //   202: astore_0
    //   203: iload 5
    //   205: iconst_m1
    //   206: if_icmpeq +14 -> 220
    //   209: aload 9
    //   211: ldc_w 603
    //   214: iload 5
    //   216: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   219: pop
    //   220: iload 4
    //   222: iconst_m1
    //   223: if_icmpeq +14 -> 237
    //   226: aload 9
    //   228: ldc_w 608
    //   231: iload 4
    //   233: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   236: pop
    //   237: iload_3
    //   238: iconst_m1
    //   239: if_icmpeq +13 -> 252
    //   242: aload 9
    //   244: ldc_w 613
    //   247: iload_3
    //   248: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   251: pop
    //   252: iload_2
    //   253: iconst_m1
    //   254: if_icmpeq +13 -> 267
    //   257: aload 9
    //   259: ldc_w 577
    //   262: iload_2
    //   263: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   266: pop
    //   267: iload_1
    //   268: iconst_m1
    //   269: if_icmpeq +13 -> 282
    //   272: aload 9
    //   274: ldc_w 688
    //   277: iload_1
    //   278: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   281: pop
    //   282: aload 6
    //   284: ifnull +31 -> 315
    //   287: aload 9
    //   289: ldc_w 690
    //   292: aload 6
    //   294: invokevirtual 695	android/telephony/CellSignalStrength:getAsuLevel	()I
    //   297: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   300: pop
    //   301: aload 9
    //   303: ldc_w 697
    //   306: aload 6
    //   308: invokevirtual 700	android/telephony/CellSignalStrength:getDbm	()I
    //   311: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   314: pop
    //   315: aload 9
    //   317: ldc_w 536
    //   320: aload_0
    //   321: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   324: pop
    //   325: aload 7
    //   327: aload 9
    //   329: invokevirtual 153	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   332: pop
    //   333: goto -241 -> 92
    //   336: aload_0
    //   337: instanceof 702
    //   340: ifeq +153 -> 493
    //   343: aload_0
    //   344: checkcast 702	android/telephony/CellInfoCdma
    //   347: astore 6
    //   349: aload 6
    //   351: invokevirtual 705	android/telephony/CellInfoCdma:getCellIdentity	()Landroid/telephony/CellIdentityCdma;
    //   354: astore_0
    //   355: aload_0
    //   356: invokevirtual 708	android/telephony/CellIdentityCdma:getSystemId	()I
    //   359: istore 5
    //   361: aload_0
    //   362: invokevirtual 709	android/telephony/CellIdentityCdma:getNetworkId	()I
    //   365: istore 4
    //   367: aload_0
    //   368: invokevirtual 712	android/telephony/CellIdentityCdma:getBasestationId	()I
    //   371: istore_3
    //   372: aload 6
    //   374: invokevirtual 715	android/telephony/CellInfoCdma:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthCdma;
    //   377: astore 6
    //   379: aload 9
    //   381: ldc_w 717
    //   384: aload 6
    //   386: invokevirtual 722	android/telephony/CellSignalStrengthCdma:getCdmaDbm	()I
    //   389: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   392: pop
    //   393: aload 9
    //   395: ldc_w 717
    //   398: aload 6
    //   400: invokevirtual 722	android/telephony/CellSignalStrengthCdma:getCdmaDbm	()I
    //   403: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   406: pop
    //   407: aload 9
    //   409: ldc_w 724
    //   412: aload 6
    //   414: invokevirtual 727	android/telephony/CellSignalStrengthCdma:getCdmaEcio	()I
    //   417: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   420: pop
    //   421: aload 9
    //   423: ldc_w 729
    //   426: aload 6
    //   428: invokevirtual 732	android/telephony/CellSignalStrengthCdma:getEvdoDbm	()I
    //   431: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   434: pop
    //   435: aload 9
    //   437: ldc_w 734
    //   440: aload 6
    //   442: invokevirtual 737	android/telephony/CellSignalStrengthCdma:getEvdoEcio	()I
    //   445: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   448: pop
    //   449: aload 9
    //   451: ldc_w 739
    //   454: aload 6
    //   456: invokevirtual 742	android/telephony/CellSignalStrengthCdma:getEvdoSnr	()I
    //   459: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   462: pop
    //   463: aload 9
    //   465: ldc_w 629
    //   468: aload_0
    //   469: invokevirtual 745	android/telephony/CellIdentityCdma:getLatitude	()I
    //   472: aload_0
    //   473: invokevirtual 748	android/telephony/CellIdentityCdma:getLongitude	()I
    //   476: invokestatic 637	com/g/a/r:a	(II)Lorg/json/JSONObject;
    //   479: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   482: pop
    //   483: iconst_m1
    //   484: istore_2
    //   485: iconst_m1
    //   486: istore_1
    //   487: ldc 27
    //   489: astore_0
    //   490: goto -287 -> 203
    //   493: aload_0
    //   494: instanceof 750
    //   497: ifeq +59 -> 556
    //   500: aload_0
    //   501: checkcast 750	android/telephony/CellInfoWcdma
    //   504: astore_0
    //   505: aload_0
    //   506: invokevirtual 753	android/telephony/CellInfoWcdma:getCellIdentity	()Landroid/telephony/CellIdentityWcdma;
    //   509: astore 6
    //   511: aload 6
    //   513: invokevirtual 756	android/telephony/CellIdentityWcdma:getLac	()I
    //   516: istore 5
    //   518: aload 6
    //   520: invokevirtual 757	android/telephony/CellIdentityWcdma:getCid	()I
    //   523: istore 4
    //   525: aload 6
    //   527: invokevirtual 758	android/telephony/CellIdentityWcdma:getPsc	()I
    //   530: istore_3
    //   531: aload 6
    //   533: invokevirtual 759	android/telephony/CellIdentityWcdma:getMcc	()I
    //   536: istore_2
    //   537: aload 6
    //   539: invokevirtual 760	android/telephony/CellIdentityWcdma:getMnc	()I
    //   542: istore_1
    //   543: aload_0
    //   544: invokevirtual 763	android/telephony/CellInfoWcdma:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthWcdma;
    //   547: astore 6
    //   549: ldc_w 765
    //   552: astore_0
    //   553: goto -350 -> 203
    //   556: aload_0
    //   557: instanceof 767
    //   560: ifeq +237 -> 797
    //   563: aload_0
    //   564: checkcast 767	android/telephony/CellInfoLte
    //   567: astore_0
    //   568: aload_0
    //   569: invokevirtual 770	android/telephony/CellInfoLte:getCellIdentity	()Landroid/telephony/CellIdentityLte;
    //   572: astore 6
    //   574: aload 6
    //   576: invokevirtual 775	android/telephony/CellIdentityLte:getTac	()I
    //   579: istore 5
    //   581: aload 6
    //   583: invokevirtual 778	android/telephony/CellIdentityLte:getPci	()I
    //   586: istore 4
    //   588: aload 6
    //   590: invokevirtual 781	android/telephony/CellIdentityLte:getCi	()I
    //   593: istore_3
    //   594: aload 6
    //   596: invokevirtual 782	android/telephony/CellIdentityLte:getMcc	()I
    //   599: istore_2
    //   600: aload 6
    //   602: invokevirtual 783	android/telephony/CellIdentityLte:getMnc	()I
    //   605: istore_1
    //   606: aload_0
    //   607: invokevirtual 786	android/telephony/CellInfoLte:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthLte;
    //   610: astore 6
    //   612: ldc 45
    //   614: astore_0
    //   615: goto -412 -> 203
    //   618: iconst_5
    //   619: invokestatic 243	com/g/a/z:a	(I)Z
    //   622: ifeq +148 -> 770
    //   625: getstatic 593	com/g/a/z:c	Z
    //   628: ifne +9 -> 637
    //   631: getstatic 595	com/g/a/z:d	Z
    //   634: ifeq +136 -> 770
    //   637: getstatic 355	com/g/a/r:a	Landroid/telephony/TelephonyManager;
    //   640: invokevirtual 789	android/telephony/TelephonyManager:getNeighboringCellInfo	()Ljava/util/List;
    //   643: astore_0
    //   644: aload_0
    //   645: ifnull +125 -> 770
    //   648: aload_0
    //   649: invokeinterface 647 1 0
    //   654: astore_0
    //   655: aload_0
    //   656: invokeinterface 652 1 0
    //   661: ifeq +109 -> 770
    //   664: aload_0
    //   665: invokeinterface 655 1 0
    //   670: checkcast 791	android/telephony/NeighboringCellInfo
    //   673: astore 6
    //   675: new 222	org/json/JSONObject
    //   678: dup
    //   679: invokespecial 223	org/json/JSONObject:<init>	()V
    //   682: astore 8
    //   684: aload 8
    //   686: ldc_w 603
    //   689: aload 6
    //   691: invokevirtual 792	android/telephony/NeighboringCellInfo:getLac	()I
    //   694: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   697: pop
    //   698: aload 8
    //   700: ldc_w 794
    //   703: aload 6
    //   705: invokevirtual 795	android/telephony/NeighboringCellInfo:getCid	()I
    //   708: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   711: pop
    //   712: aload 8
    //   714: ldc_w 613
    //   717: aload 6
    //   719: invokevirtual 796	android/telephony/NeighboringCellInfo:getPsc	()I
    //   722: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   725: pop
    //   726: aload 8
    //   728: ldc_w 690
    //   731: aload 6
    //   733: invokevirtual 799	android/telephony/NeighboringCellInfo:getRssi	()I
    //   736: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   739: pop
    //   740: aload 8
    //   742: ldc_w 536
    //   745: aload 6
    //   747: invokevirtual 800	android/telephony/NeighboringCellInfo:getNetworkType	()I
    //   750: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   753: pop
    //   754: aload 7
    //   756: aload 8
    //   758: invokevirtual 153	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   761: pop
    //   762: goto -107 -> 655
    //   765: astore 6
    //   767: goto -112 -> 655
    //   770: aload 7
    //   772: invokevirtual 573	org/json/JSONArray:length	()I
    //   775: istore_1
    //   776: iload_1
    //   777: ifle +8 -> 785
    //   780: aload 7
    //   782: astore_0
    //   783: aload_0
    //   784: areturn
    //   785: aconst_null
    //   786: astore_0
    //   787: goto -4 -> 783
    //   790: astore_0
    //   791: aload_0
    //   792: invokestatic 412	com/g/a/av:postSDKError	(Ljava/lang/Throwable;)V
    //   795: aconst_null
    //   796: areturn
    //   797: aconst_null
    //   798: astore_0
    //   799: aconst_null
    //   800: astore 6
    //   802: iconst_m1
    //   803: istore_1
    //   804: iconst_m1
    //   805: istore_2
    //   806: iconst_m1
    //   807: istore_3
    //   808: iconst_m1
    //   809: istore 4
    //   811: iconst_m1
    //   812: istore 5
    //   814: goto -611 -> 203
    //   817: astore_0
    //   818: goto -726 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	821	0	paramContext	Context
    //   191	613	1	i	int
    //   185	621	2	j	int
    //   199	609	3	k	int
    //   178	632	4	m	int
    //   171	642	5	n	int
    //   164	582	6	localObject1	Object
    //   765	1	6	localThrowable	Throwable
    //   800	1	6	localObject2	Object
    //   63	718	7	localJSONArray	JSONArray
    //   90	667	8	localObject3	Object
    //   120	344	9	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   675	762	765	java/lang/Throwable
    //   46	56	790	java/lang/Throwable
    //   56	80	790	java/lang/Throwable
    //   84	92	790	java/lang/Throwable
    //   92	113	790	java/lang/Throwable
    //   618	637	790	java/lang/Throwable
    //   637	644	790	java/lang/Throwable
    //   648	655	790	java/lang/Throwable
    //   655	675	790	java/lang/Throwable
    //   770	776	790	java/lang/Throwable
    //   113	198	817	java/lang/Throwable
    //   209	220	817	java/lang/Throwable
    //   226	237	817	java/lang/Throwable
    //   242	252	817	java/lang/Throwable
    //   257	267	817	java/lang/Throwable
    //   272	282	817	java/lang/Throwable
    //   287	315	817	java/lang/Throwable
    //   315	333	817	java/lang/Throwable
    //   336	483	817	java/lang/Throwable
    //   493	549	817	java/lang/Throwable
    //   556	612	817	java/lang/Throwable
  }
  
  public static JSONArray u(Context paramContext)
  {
    try
    {
      if (!z.a) {
        return null;
      }
      if (z.b(paramContext, "android.permission.ACCESS_WIFI_STATE"))
      {
        Object localObject = ((WifiManager)paramContext.getSystemService("wifi")).getConfiguredNetworks();
        if (localObject != null)
        {
          paramContext = new JSONArray();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            WifiConfiguration localWifiConfiguration = (WifiConfiguration)((Iterator)localObject).next();
            try
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("networkId", localWifiConfiguration.networkId);
              localJSONObject.put("priority", localWifiConfiguration.priority);
              localJSONObject.put("name", localWifiConfiguration.SSID);
              localJSONObject.put("id", localWifiConfiguration.BSSID);
              localJSONObject.put("allowedKeyManagement", a(localWifiConfiguration.allowedKeyManagement));
              localJSONObject.put("allowedAuthAlgorithms", a(localWifiConfiguration.allowedAuthAlgorithms));
              localJSONObject.put("allowedGroupCiphers", a(localWifiConfiguration.allowedGroupCiphers));
              localJSONObject.put("allowedPairwiseCiphers", a(localWifiConfiguration.allowedPairwiseCiphers));
              paramContext.put(localJSONObject);
            }
            catch (Throwable localThrowable) {}
          }
          int i = paramContext.length();
          if (i > 0) {}
          for (;;)
          {
            return paramContext;
            paramContext = null;
          }
        }
      }
      return null;
    }
    catch (Throwable paramContext) {}
  }
  
  /* Error */
  public static JSONArray v(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 575	com/g/a/z:a	Z
    //   3: ifne +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: aload_0
    //   9: ldc_w 802
    //   12: invokestatic 418	com/g/a/z:b	(Landroid/content/Context;Ljava/lang/String;)Z
    //   15: ifeq +272 -> 287
    //   18: aload_0
    //   19: ldc_w 479
    //   22: invokevirtual 84	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   25: checkcast 481	android/net/wifi/WifiManager
    //   28: astore_2
    //   29: aload_2
    //   30: invokevirtual 484	android/net/wifi/WifiManager:isWifiEnabled	()Z
    //   33: ifeq +254 -> 287
    //   36: aload_2
    //   37: invokevirtual 847	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   40: astore_3
    //   41: aload_3
    //   42: ifnull +245 -> 287
    //   45: aload_3
    //   46: invokevirtual 852	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   49: ifnull +238 -> 287
    //   52: aload_3
    //   53: invokevirtual 852	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   56: astore 4
    //   58: new 75	org/json/JSONArray
    //   61: dup
    //   62: invokespecial 76	org/json/JSONArray:<init>	()V
    //   65: astore_0
    //   66: new 222	org/json/JSONObject
    //   69: dup
    //   70: invokespecial 223	org/json/JSONObject:<init>	()V
    //   73: astore_1
    //   74: aload_1
    //   75: ldc_w 815
    //   78: aload_3
    //   79: invokevirtual 855	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   82: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   85: pop
    //   86: aload_1
    //   87: ldc_w 821
    //   90: aload 4
    //   92: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   95: pop
    //   96: aload_1
    //   97: ldc_w 857
    //   100: aload_3
    //   101: invokevirtual 858	android/net/wifi/WifiInfo:getRssi	()I
    //   104: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   107: pop
    //   108: aload_1
    //   109: ldc_w 860
    //   112: aload_3
    //   113: invokevirtual 863	android/net/wifi/WifiInfo:getHiddenSSID	()Z
    //   116: invokevirtual 543	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   119: pop
    //   120: aload_1
    //   121: ldc_w 865
    //   124: aload_3
    //   125: invokevirtual 868	android/net/wifi/WifiInfo:getIpAddress	()I
    //   128: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   131: pop
    //   132: aload_1
    //   133: ldc_w 870
    //   136: aload_3
    //   137: invokevirtual 873	android/net/wifi/WifiInfo:getLinkSpeed	()I
    //   140: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   143: pop
    //   144: aload_1
    //   145: ldc_w 608
    //   148: aload_3
    //   149: invokevirtual 874	android/net/wifi/WifiInfo:getNetworkId	()I
    //   152: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   155: pop
    //   156: aload_1
    //   157: ldc_w 876
    //   160: aload_3
    //   161: invokevirtual 879	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
    //   164: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   167: pop
    //   168: aload_2
    //   169: invokevirtual 883	android/net/wifi/WifiManager:getDhcpInfo	()Landroid/net/DhcpInfo;
    //   172: astore_2
    //   173: aload_2
    //   174: ifnull +104 -> 278
    //   177: new 222	org/json/JSONObject
    //   180: dup
    //   181: invokespecial 223	org/json/JSONObject:<init>	()V
    //   184: astore_3
    //   185: aload_3
    //   186: ldc_w 885
    //   189: aload_2
    //   190: getfield 889	android/net/DhcpInfo:dns1	I
    //   193: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   196: pop
    //   197: aload_3
    //   198: ldc_w 891
    //   201: aload_2
    //   202: getfield 893	android/net/DhcpInfo:dns2	I
    //   205: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   208: pop
    //   209: aload_3
    //   210: ldc_w 895
    //   213: aload_2
    //   214: getfield 898	android/net/DhcpInfo:gateway	I
    //   217: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   220: pop
    //   221: aload_3
    //   222: ldc_w 865
    //   225: aload_2
    //   226: getfield 901	android/net/DhcpInfo:ipAddress	I
    //   229: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   232: pop
    //   233: aload_3
    //   234: ldc_w 903
    //   237: aload_2
    //   238: getfield 906	android/net/DhcpInfo:netmask	I
    //   241: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   244: pop
    //   245: aload_3
    //   246: ldc_w 908
    //   249: aload_2
    //   250: getfield 911	android/net/DhcpInfo:serverAddress	I
    //   253: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   256: pop
    //   257: aload_3
    //   258: ldc_w 913
    //   261: aload_2
    //   262: getfield 915	android/net/DhcpInfo:leaseDuration	I
    //   265: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload_1
    //   270: ldc_w 917
    //   273: aload_3
    //   274: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   277: pop
    //   278: aload_0
    //   279: aload_1
    //   280: invokevirtual 153	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   283: pop
    //   284: aload_0
    //   285: areturn
    //   286: astore_0
    //   287: aconst_null
    //   288: areturn
    //   289: astore_2
    //   290: goto -12 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramContext	Context
    //   73	207	1	localJSONObject	JSONObject
    //   28	234	2	localObject1	Object
    //   289	1	2	localThrowable	Throwable
    //   40	234	3	localObject2	Object
    //   56	35	4	str	String
    // Exception table:
    //   from	to	target	type
    //   0	6	286	java/lang/Throwable
    //   8	41	286	java/lang/Throwable
    //   45	74	286	java/lang/Throwable
    //   278	284	286	java/lang/Throwable
    //   74	173	289	java/lang/Throwable
    //   177	278	289	java/lang/Throwable
  }
  
  /* Error */
  public static JSONArray w(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 575	com/g/a/z:a	Z
    //   3: ifeq +15 -> 18
    //   6: getstatic 593	com/g/a/z:c	Z
    //   9: ifne +11 -> 20
    //   12: getstatic 595	com/g/a/z:d	Z
    //   15: ifne +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: aload_0
    //   21: ldc_w 802
    //   24: invokestatic 418	com/g/a/z:b	(Landroid/content/Context;Ljava/lang/String;)Z
    //   27: ifeq +292 -> 319
    //   30: aload_0
    //   31: ldc_w 479
    //   34: invokevirtual 84	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   37: checkcast 481	android/net/wifi/WifiManager
    //   40: astore_2
    //   41: aload_2
    //   42: invokevirtual 484	android/net/wifi/WifiManager:isWifiEnabled	()Z
    //   45: ifne +18 -> 63
    //   48: getstatic 525	android/os/Build$VERSION:SDK_INT	I
    //   51: bipush 18
    //   53: if_icmplt +266 -> 319
    //   56: aload_2
    //   57: invokevirtual 920	android/net/wifi/WifiManager:isScanAlwaysAvailable	()Z
    //   60: ifeq +259 -> 319
    //   63: aload_0
    //   64: ldc_w 922
    //   67: invokestatic 418	com/g/a/z:b	(Landroid/content/Context;Ljava/lang/String;)Z
    //   70: istore_1
    //   71: iload_1
    //   72: ifeq +55 -> 127
    //   75: new 4	java/lang/Object
    //   78: dup
    //   79: invokespecial 69	java/lang/Object:<init>	()V
    //   82: astore_3
    //   83: new 924	android/content/IntentFilter
    //   86: dup
    //   87: ldc_w 926
    //   90: invokespecial 929	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   93: astore 4
    //   95: aload_0
    //   96: new 931	com/g/a/s
    //   99: dup
    //   100: aload_3
    //   101: aload_0
    //   102: invokespecial 934	com/g/a/s:<init>	(Ljava/lang/Object;Landroid/content/Context;)V
    //   105: aload 4
    //   107: invokevirtual 938	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   110: pop
    //   111: aload_2
    //   112: invokevirtual 941	android/net/wifi/WifiManager:startScan	()Z
    //   115: pop
    //   116: aload_3
    //   117: monitorenter
    //   118: aload_3
    //   119: ldc2_w 942
    //   122: invokevirtual 947	java/lang/Object:wait	(J)V
    //   125: aload_3
    //   126: monitorexit
    //   127: aload_2
    //   128: invokevirtual 950	android/net/wifi/WifiManager:getScanResults	()Ljava/util/List;
    //   131: astore_2
    //   132: aload_2
    //   133: ifnull +186 -> 319
    //   136: new 199	java/util/ArrayList
    //   139: dup
    //   140: invokespecial 951	java/util/ArrayList:<init>	()V
    //   143: astore_0
    //   144: aload_2
    //   145: invokeinterface 647 1 0
    //   150: astore_2
    //   151: aload_2
    //   152: invokeinterface 652 1 0
    //   157: ifeq +152 -> 309
    //   160: aload_2
    //   161: invokeinterface 655 1 0
    //   166: checkcast 953	android/net/wifi/ScanResult
    //   169: astore_3
    //   170: aload_3
    //   171: getfield 955	android/net/wifi/ScanResult:level	I
    //   174: bipush -85
    //   176: if_icmplt -25 -> 151
    //   179: new 222	org/json/JSONObject
    //   182: dup
    //   183: invokespecial 223	org/json/JSONObject:<init>	()V
    //   186: astore 4
    //   188: aload 4
    //   190: ldc_w 821
    //   193: aload_3
    //   194: getfield 956	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
    //   197: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   200: pop
    //   201: aload 4
    //   203: ldc_w 815
    //   206: aload_3
    //   207: getfield 957	android/net/wifi/ScanResult:SSID	Ljava/lang/String;
    //   210: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   213: pop
    //   214: aload 4
    //   216: ldc_w 857
    //   219: aload_3
    //   220: getfield 955	android/net/wifi/ScanResult:level	I
    //   223: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   226: pop
    //   227: aload 4
    //   229: ldc_w 959
    //   232: aload_3
    //   233: getfield 962	android/net/wifi/ScanResult:frequency	I
    //   236: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   239: pop
    //   240: bipush 17
    //   242: invokestatic 243	com/g/a/z:a	(I)Z
    //   245: ifeq +41 -> 286
    //   248: aload 4
    //   250: ldc_w 664
    //   253: aload_3
    //   254: getfield 965	android/net/wifi/ScanResult:timestamp	J
    //   257: invokevirtual 670	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   260: pop
    //   261: aload 4
    //   263: ldc_w 967
    //   266: invokestatic 970	java/lang/System:currentTimeMillis	()J
    //   269: invokestatic 454	android/os/SystemClock:elapsedRealtime	()J
    //   272: lsub
    //   273: aload_3
    //   274: getfield 965	android/net/wifi/ScanResult:timestamp	J
    //   277: ldc2_w 971
    //   280: ldiv
    //   281: ladd
    //   282: invokevirtual 670	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   285: pop
    //   286: aload_0
    //   287: aload 4
    //   289: invokevirtual 975	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   292: pop
    //   293: goto -142 -> 151
    //   296: astore_3
    //   297: goto -146 -> 151
    //   300: astore_0
    //   301: aload_3
    //   302: monitorexit
    //   303: aload_0
    //   304: athrow
    //   305: astore_0
    //   306: goto -179 -> 127
    //   309: aload_0
    //   310: bipush 20
    //   312: invokestatic 977	com/g/a/r:a	(Ljava/util/ArrayList;I)Lorg/json/JSONArray;
    //   315: astore_0
    //   316: aload_0
    //   317: areturn
    //   318: astore_0
    //   319: aconst_null
    //   320: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	paramContext	Context
    //   70	2	1	bool	boolean
    //   40	121	2	localObject1	Object
    //   82	192	3	localObject2	Object
    //   296	6	3	localThrowable	Throwable
    //   93	195	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   188	286	296	java/lang/Throwable
    //   286	293	296	java/lang/Throwable
    //   118	127	300	finally
    //   301	303	300	finally
    //   75	118	305	java/lang/Throwable
    //   303	305	305	java/lang/Throwable
    //   20	63	318	java/lang/Throwable
    //   63	71	318	java/lang/Throwable
    //   127	132	318	java/lang/Throwable
    //   136	151	318	java/lang/Throwable
    //   151	188	318	java/lang/Throwable
    //   309	316	318	java/lang/Throwable
  }
  
  /* Error */
  public static JSONArray x(Context paramContext)
  {
    // Byte code:
    //   0: new 75	org/json/JSONArray
    //   3: dup
    //   4: invokespecial 76	org/json/JSONArray:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: ldc 78
    //   12: invokevirtual 84	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   15: checkcast 86	android/telephony/TelephonyManager
    //   18: astore_2
    //   19: new 199	java/util/ArrayList
    //   22: dup
    //   23: invokespecial 951	java/util/ArrayList:<init>	()V
    //   26: astore 5
    //   28: bipush 22
    //   30: invokestatic 243	com/g/a/z:a	(I)Z
    //   33: ifeq +100 -> 133
    //   36: aload_0
    //   37: ldc_w 980
    //   40: invokevirtual 84	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   43: checkcast 245	android/telephony/SubscriptionManager
    //   46: astore_0
    //   47: aload_2
    //   48: aload_0
    //   49: iconst_0
    //   50: invokestatic 982	com/g/a/r:a	(Landroid/telephony/TelephonyManager;Landroid/telephony/SubscriptionManager;I)Lorg/json/JSONObject;
    //   53: astore_3
    //   54: aload_3
    //   55: ldc_w 304
    //   58: aload_2
    //   59: invokevirtual 134	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   62: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   65: pop
    //   66: aload 4
    //   68: aload_3
    //   69: invokevirtual 153	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   72: pop
    //   73: aload_2
    //   74: aload_0
    //   75: iconst_1
    //   76: invokestatic 982	com/g/a/r:a	(Landroid/telephony/TelephonyManager;Landroid/telephony/SubscriptionManager;I)Lorg/json/JSONObject;
    //   79: astore_3
    //   80: bipush 23
    //   82: invokestatic 243	com/g/a/z:a	(I)Z
    //   85: ifeq +43 -> 128
    //   88: aload_2
    //   89: invokevirtual 985	android/telephony/TelephonyManager:getPhoneCount	()I
    //   92: iconst_2
    //   93: if_icmpne +35 -> 128
    //   96: aload_2
    //   97: iconst_1
    //   98: invokevirtual 987	android/telephony/TelephonyManager:getDeviceId	(I)Ljava/lang/String;
    //   101: astore_0
    //   102: aload_3
    //   103: ldc_w 304
    //   106: aload_0
    //   107: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   110: pop
    //   111: aload_3
    //   112: invokevirtual 988	org/json/JSONObject:length	()I
    //   115: ifle +10 -> 125
    //   118: aload 4
    //   120: aload_3
    //   121: invokevirtual 153	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   124: pop
    //   125: aload 4
    //   127: areturn
    //   128: aconst_null
    //   129: astore_0
    //   130: goto -28 -> 102
    //   133: aload_2
    //   134: invokevirtual 134	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   137: astore_3
    //   138: aload_3
    //   139: invokevirtual 137	java/lang/String:trim	()Ljava/lang/String;
    //   142: invokestatic 140	com/g/a/r:b	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   145: invokevirtual 146	java/lang/Boolean:booleanValue	()Z
    //   148: ifeq +32 -> 180
    //   151: aload 5
    //   153: aload_3
    //   154: invokevirtual 137	java/lang/String:trim	()Ljava/lang/String;
    //   157: invokeinterface 989 2 0
    //   162: pop
    //   163: aload_2
    //   164: aload_3
    //   165: invokestatic 149	com/g/a/r:a	(Landroid/telephony/TelephonyManager;Ljava/lang/String;)Lorg/json/JSONObject;
    //   168: astore_2
    //   169: aload_2
    //   170: ifnull +10 -> 180
    //   173: aload 4
    //   175: aload_2
    //   176: invokevirtual 153	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   179: pop
    //   180: aload_0
    //   181: ldc_w 991
    //   184: invokevirtual 84	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   187: checkcast 86	android/telephony/TelephonyManager
    //   190: astore_2
    //   191: aload_2
    //   192: invokevirtual 134	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   195: astore_3
    //   196: aload_3
    //   197: ifnull +50 -> 247
    //   200: aload_3
    //   201: invokestatic 140	com/g/a/r:b	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   204: invokevirtual 146	java/lang/Boolean:booleanValue	()Z
    //   207: ifeq +40 -> 247
    //   210: aload 5
    //   212: aload_3
    //   213: invokeinterface 994 2 0
    //   218: ifne +29 -> 247
    //   221: aload 5
    //   223: aload_3
    //   224: invokeinterface 989 2 0
    //   229: pop
    //   230: aload_2
    //   231: aload_3
    //   232: invokestatic 149	com/g/a/r:a	(Landroid/telephony/TelephonyManager;Ljava/lang/String;)Lorg/json/JSONObject;
    //   235: astore_2
    //   236: aload_2
    //   237: ifnull +10 -> 247
    //   240: aload 4
    //   242: aload_2
    //   243: invokevirtual 153	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   246: pop
    //   247: aload_0
    //   248: ldc_w 996
    //   251: invokevirtual 84	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   254: checkcast 86	android/telephony/TelephonyManager
    //   257: astore_2
    //   258: aload_2
    //   259: invokevirtual 134	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   262: astore_3
    //   263: aload_3
    //   264: ifnull +50 -> 314
    //   267: aload_3
    //   268: invokestatic 140	com/g/a/r:b	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   271: invokevirtual 146	java/lang/Boolean:booleanValue	()Z
    //   274: ifeq +40 -> 314
    //   277: aload 5
    //   279: aload_3
    //   280: invokeinterface 994 2 0
    //   285: ifne +29 -> 314
    //   288: aload 5
    //   290: aload_3
    //   291: invokeinterface 989 2 0
    //   296: pop
    //   297: aload_2
    //   298: aload_3
    //   299: invokestatic 149	com/g/a/r:a	(Landroid/telephony/TelephonyManager;Ljava/lang/String;)Lorg/json/JSONObject;
    //   302: astore_2
    //   303: aload_2
    //   304: ifnull +10 -> 314
    //   307: aload 4
    //   309: aload_2
    //   310: invokevirtual 153	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   313: pop
    //   314: aload_0
    //   315: invokestatic 998	com/g/a/r:C	(Landroid/content/Context;)Lorg/json/JSONArray;
    //   318: astore_2
    //   319: aload_0
    //   320: invokestatic 1000	com/g/a/r:B	(Landroid/content/Context;)Lorg/json/JSONArray;
    //   323: astore_3
    //   324: aload_3
    //   325: ifnull +119 -> 444
    //   328: aload_3
    //   329: astore_2
    //   330: aload_0
    //   331: invokestatic 1002	com/g/a/r:A	(Landroid/content/Context;)Lorg/json/JSONArray;
    //   334: astore_3
    //   335: aload_3
    //   336: ifnull +105 -> 441
    //   339: aload_3
    //   340: astore_2
    //   341: aload_0
    //   342: invokestatic 1005	com/g/a/r:z	(Landroid/content/Context;)Lorg/json/JSONArray;
    //   345: astore_0
    //   346: aload_0
    //   347: ifnull +5 -> 352
    //   350: aload_0
    //   351: astore_2
    //   352: aload_2
    //   353: ifnull -228 -> 125
    //   356: aload_2
    //   357: invokevirtual 573	org/json/JSONArray:length	()I
    //   360: ifle -235 -> 125
    //   363: iconst_0
    //   364: istore_1
    //   365: iload_1
    //   366: aload_2
    //   367: invokevirtual 573	org/json/JSONArray:length	()I
    //   370: if_icmpge -245 -> 125
    //   373: aload_2
    //   374: iload_1
    //   375: invokevirtual 1009	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   378: astore_0
    //   379: aload_0
    //   380: ldc_w 304
    //   383: invokevirtual 1012	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   386: astore_3
    //   387: aload 5
    //   389: aload_3
    //   390: invokeinterface 994 2 0
    //   395: ifne +19 -> 414
    //   398: aload 5
    //   400: aload_3
    //   401: invokeinterface 989 2 0
    //   406: pop
    //   407: aload 4
    //   409: aload_0
    //   410: invokevirtual 153	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   413: pop
    //   414: iload_1
    //   415: iconst_1
    //   416: iadd
    //   417: istore_1
    //   418: goto -53 -> 365
    //   421: astore_0
    //   422: aload 4
    //   424: areturn
    //   425: astore_2
    //   426: goto -112 -> 314
    //   429: astore_2
    //   430: goto -183 -> 247
    //   433: astore_0
    //   434: aload 4
    //   436: areturn
    //   437: astore_3
    //   438: goto -365 -> 73
    //   441: goto -100 -> 341
    //   444: goto -114 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	paramContext	Context
    //   364	54	1	i	int
    //   18	356	2	localObject1	Object
    //   425	1	2	localThrowable1	Throwable
    //   429	1	2	localThrowable2	Throwable
    //   53	348	3	localObject2	Object
    //   437	1	3	localThrowable3	Throwable
    //   7	428	4	localJSONArray	JSONArray
    //   26	373	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   9	47	421	java/lang/Throwable
    //   133	169	421	java/lang/Throwable
    //   173	180	421	java/lang/Throwable
    //   314	324	421	java/lang/Throwable
    //   330	335	421	java/lang/Throwable
    //   341	346	421	java/lang/Throwable
    //   356	363	421	java/lang/Throwable
    //   365	414	421	java/lang/Throwable
    //   247	263	425	java/lang/Throwable
    //   267	303	425	java/lang/Throwable
    //   307	314	425	java/lang/Throwable
    //   180	196	429	java/lang/Throwable
    //   200	236	429	java/lang/Throwable
    //   240	247	429	java/lang/Throwable
    //   73	102	433	java/lang/Throwable
    //   102	125	433	java/lang/Throwable
    //   47	73	437	java/lang/Throwable
  }
  
  public static JSONObject y(Context paramContext)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      return localJSONObject;
    }
    catch (Throwable paramContext)
    {
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        localJSONObject.put("dataState", paramContext.getDataState());
        localJSONObject.put("networkType", a(paramContext.getNetworkType()));
        localJSONObject.put("networkOperator", paramContext.getNetworkOperator());
        localJSONObject.put("phoneType", b(paramContext.getPhoneType()));
        return localJSONObject;
      }
      catch (Throwable paramContext) {}
      paramContext = paramContext;
      return null;
    }
  }
  
  private static JSONArray z(Context paramContext)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      paramContext = Class.forName("com.android.internal.telephony.Phone");
      try
      {
        localObject1 = paramContext.getField("GEMINI_SIM_1");
        ((Field)localObject1).setAccessible(true);
        localObject1 = (Integer)((Field)localObject1).get(null);
        paramContext = paramContext.getField("GEMINI_SIM_2");
        paramContext.setAccessible(true);
        paramContext = (Integer)paramContext.get(null);
        localObject2 = TelephonyManager.class.getDeclaredMethod("getDeviceIdGemini", new Class[] { Integer.TYPE });
        if (localTelephonyManager != null) {
          if (localObject2 != null) {}
        }
      }
      catch (Throwable paramContext)
      {
        Object localObject1;
        for (;;)
        {
          paramContext = Integer.valueOf(1);
          localObject1 = Integer.valueOf(0);
        }
        String str = ((String)((Method)localObject2).invoke(localTelephonyManager, new Object[] { localObject1 })).trim();
        Object localObject2 = ((String)((Method)localObject2).invoke(localTelephonyManager, new Object[] { paramContext })).trim();
        if (b(str).booleanValue()) {
          localJSONArray.put(a(TelephonyManager.class, localTelephonyManager, (Integer)localObject1, str, "Gemini"));
        }
        if (b((String)localObject2).booleanValue()) {
          localJSONArray.put(a(TelephonyManager.class, localTelephonyManager, paramContext, (String)localObject2, "Gemini"));
        }
        return localJSONArray;
      }
      return null;
    }
    catch (Throwable paramContext)
    {
      return null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/g/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */