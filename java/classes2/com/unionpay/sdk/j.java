package com.unionpay.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class j
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
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      Object localObject1 = Class.forName("com.android.internal.telephony.Phone");
      try
      {
        paramContext = ((Class)localObject1).getField("GEMINI_SIM_1");
        paramContext.setAccessible(true);
        paramContext = (Integer)paramContext.get(null);
        localObject1 = ((Class)localObject1).getField("GEMINI_SIM_2");
        ((Field)localObject1).setAccessible(true);
        localObject1 = (Integer)((Field)localObject1).get(null);
        localObject2 = TelephonyManager.class.getDeclaredMethod("getDeviceIdGemini", new Class[] { Integer.TYPE });
        if (localTelephonyManager != null) {
          if (localObject2 != null) {}
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          localObject1 = Integer.valueOf(1);
          paramContext = Integer.valueOf(0);
        }
        String str = ((String)((Method)localObject2).invoke(localTelephonyManager, new Object[] { paramContext })).trim();
        Object localObject2 = ((String)((Method)localObject2).invoke(localTelephonyManager, new Object[] { localObject1 })).trim();
        if (b(str).booleanValue()) {
          localJSONArray.put(a(TelephonyManager.class, localTelephonyManager, paramContext, str, "Gemini"));
        }
        if (b((String)localObject2).booleanValue()) {
          localJSONArray.put(a(TelephonyManager.class, localTelephonyManager, (Integer)localObject1, (String)localObject2, "Gemini"));
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
  
  private static JSONArray B(Context paramContext)
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
  
  private static JSONArray C(Context paramContext)
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
  
  private static JSONArray D(Context paramContext)
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
  
  private static JSONArray a(BitSet paramBitSet)
  {
    int i = paramBitSet.cardinality();
    if ((paramBitSet == null) || (i <= 0)) {}
    for (;;)
    {
      return null;
      JSONArray localJSONArray = new JSONArray();
      for (i = paramBitSet.nextSetBit(0); i >= 0; i = paramBitSet.nextSetBit(i + 1)) {
        localJSONArray.put(i);
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
          break label173;
        }
        paramString = "";
        label47:
        localJSONObject.put("simSerialNumber", paramString);
        localJSONObject.put("dataState", paramTelephonyManager.getDataState());
        localJSONObject.put("networkType", a(paramTelephonyManager.getNetworkType()));
        localJSONObject.put("networkOperator", paramTelephonyManager.getNetworkOperator());
        localJSONObject.put("phoneType", b(paramTelephonyManager.getPhoneType()));
        if (paramTelephonyManager.getSimOperator() != null) {
          break label181;
        }
        paramString = "";
        label116:
        localJSONObject.put("simOperator", paramString);
        if (paramTelephonyManager.getSimOperatorName() != null) {
          break label189;
        }
        paramString = "";
        label135:
        localJSONObject.put("simOperatorName", paramString);
        if (paramTelephonyManager.getSimCountryIso() != null) {
          break label197;
        }
      }
      label173:
      label181:
      label189:
      label197:
      for (paramTelephonyManager = "";; paramTelephonyManager = paramTelephonyManager.getSimCountryIso())
      {
        localJSONObject.put("simCountryIso", paramTelephonyManager);
        return localJSONObject;
        paramString = paramTelephonyManager.getSubscriberId();
        break;
        paramString = paramTelephonyManager.getSimSerialNumber();
        break label47;
        paramString = paramTelephonyManager.getSimOperator();
        break label116;
        paramString = paramTelephonyManager.getSimOperatorName();
        break label135;
      }
      return null;
    }
    catch (Throwable paramTelephonyManager) {}
  }
  
  /* Error */
  private static JSONObject a(Class paramClass, Object paramObject, Integer paramInteger, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 211	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 212	org/json/JSONObject:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: ldc -28
    //   13: aload_3
    //   14: invokevirtual 226	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   17: pop
    //   18: aload_0
    //   19: new 279	java/lang/StringBuilder
    //   22: dup
    //   23: ldc_w 280
    //   26: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: aload 4
    //   31: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: iconst_1
    //   38: anewarray 90	java/lang/Class
    //   41: dup
    //   42: iconst_0
    //   43: getstatic 120	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   46: aastore
    //   47: invokevirtual 162	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   50: astore_3
    //   51: aload_3
    //   52: aload_1
    //   53: iconst_1
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload_2
    //   60: aastore
    //   61: invokevirtual 134	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   64: ifnonnull +436 -> 500
    //   67: ldc -75
    //   69: astore_3
    //   70: aload 5
    //   72: ldc -23
    //   74: aload_3
    //   75: invokevirtual 226	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   78: pop
    //   79: aload_0
    //   80: new 279	java/lang/StringBuilder
    //   83: dup
    //   84: ldc_w 291
    //   87: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: aload 4
    //   92: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: iconst_1
    //   99: anewarray 90	java/lang/Class
    //   102: dup
    //   103: iconst_0
    //   104: getstatic 120	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   107: aastore
    //   108: invokevirtual 162	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   111: astore_3
    //   112: aload_3
    //   113: aload_1
    //   114: iconst_1
    //   115: anewarray 4	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: aload_2
    //   121: aastore
    //   122: invokevirtual 134	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   125: ifnonnull +398 -> 523
    //   128: ldc -75
    //   130: astore_3
    //   131: aload 5
    //   133: ldc -18
    //   135: aload_3
    //   136: invokevirtual 226	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   139: pop
    //   140: aload 5
    //   142: ldc -16
    //   144: aload_0
    //   145: new 279	java/lang/StringBuilder
    //   148: dup
    //   149: ldc_w 292
    //   152: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: aload 4
    //   157: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: iconst_1
    //   164: anewarray 90	java/lang/Class
    //   167: dup
    //   168: iconst_0
    //   169: getstatic 120	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   172: aastore
    //   173: invokevirtual 162	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   176: aload_1
    //   177: iconst_1
    //   178: anewarray 4	java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: aload_2
    //   184: aastore
    //   185: invokevirtual 134	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   188: checkcast 112	java/lang/Integer
    //   191: invokevirtual 226	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   194: pop
    //   195: aload 5
    //   197: ldc -11
    //   199: aload_0
    //   200: new 279	java/lang/StringBuilder
    //   203: dup
    //   204: ldc_w 293
    //   207: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   210: aload 4
    //   212: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: iconst_1
    //   219: anewarray 90	java/lang/Class
    //   222: dup
    //   223: iconst_0
    //   224: getstatic 120	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   227: aastore
    //   228: invokevirtual 162	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   231: aload_1
    //   232: iconst_1
    //   233: anewarray 4	java/lang/Object
    //   236: dup
    //   237: iconst_0
    //   238: aload_2
    //   239: aastore
    //   240: invokevirtual 134	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   243: checkcast 112	java/lang/Integer
    //   246: invokevirtual 296	java/lang/Integer:intValue	()I
    //   249: invokestatic 250	com/unionpay/sdk/j:a	(I)Ljava/lang/String;
    //   252: invokevirtual 226	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   255: pop
    //   256: aload 5
    //   258: ldc -4
    //   260: aload_0
    //   261: new 279	java/lang/StringBuilder
    //   264: dup
    //   265: ldc_w 297
    //   268: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   271: aload 4
    //   273: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: iconst_1
    //   280: anewarray 90	java/lang/Class
    //   283: dup
    //   284: iconst_0
    //   285: getstatic 120	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   288: aastore
    //   289: invokevirtual 162	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   292: aload_1
    //   293: iconst_1
    //   294: anewarray 4	java/lang/Object
    //   297: dup
    //   298: iconst_0
    //   299: aload_2
    //   300: aastore
    //   301: invokevirtual 134	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   304: checkcast 17	java/lang/String
    //   307: invokevirtual 226	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   310: pop
    //   311: aload 5
    //   313: ldc_w 257
    //   316: aload_0
    //   317: new 279	java/lang/StringBuilder
    //   320: dup
    //   321: ldc_w 298
    //   324: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   327: aload 4
    //   329: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: iconst_1
    //   336: anewarray 90	java/lang/Class
    //   339: dup
    //   340: iconst_0
    //   341: getstatic 120	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   344: aastore
    //   345: invokevirtual 162	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   348: aload_1
    //   349: iconst_1
    //   350: anewarray 4	java/lang/Object
    //   353: dup
    //   354: iconst_0
    //   355: aload_2
    //   356: aastore
    //   357: invokevirtual 134	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   360: checkcast 112	java/lang/Integer
    //   363: invokevirtual 296	java/lang/Integer:intValue	()I
    //   366: invokestatic 262	com/unionpay/sdk/j:b	(I)Ljava/lang/String;
    //   369: invokevirtual 226	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   372: pop
    //   373: aload_0
    //   374: new 279	java/lang/StringBuilder
    //   377: dup
    //   378: ldc_w 299
    //   381: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   384: aload 4
    //   386: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: iconst_1
    //   393: anewarray 90	java/lang/Class
    //   396: dup
    //   397: iconst_0
    //   398: getstatic 120	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   401: aastore
    //   402: invokevirtual 162	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   405: astore_3
    //   406: aload_3
    //   407: aload_1
    //   408: iconst_1
    //   409: anewarray 4	java/lang/Object
    //   412: dup
    //   413: iconst_0
    //   414: aload_2
    //   415: aastore
    //   416: invokevirtual 134	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   419: ifnonnull +127 -> 546
    //   422: ldc -75
    //   424: astore_3
    //   425: aload 5
    //   427: ldc_w 267
    //   430: aload_3
    //   431: invokevirtual 226	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   434: pop
    //   435: aload_0
    //   436: new 279	java/lang/StringBuilder
    //   439: dup
    //   440: ldc_w 300
    //   443: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   446: aload 4
    //   448: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: iconst_1
    //   455: anewarray 90	java/lang/Class
    //   458: dup
    //   459: iconst_0
    //   460: getstatic 120	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   463: aastore
    //   464: invokevirtual 162	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   467: astore_0
    //   468: aload_0
    //   469: aload_1
    //   470: iconst_1
    //   471: anewarray 4	java/lang/Object
    //   474: dup
    //   475: iconst_0
    //   476: aload_2
    //   477: aastore
    //   478: invokevirtual 134	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   481: ifnonnull +88 -> 569
    //   484: ldc -75
    //   486: astore_0
    //   487: aload 5
    //   489: ldc_w 272
    //   492: aload_0
    //   493: invokevirtual 226	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   496: pop
    //   497: aload 5
    //   499: areturn
    //   500: aload_3
    //   501: aload_1
    //   502: iconst_1
    //   503: anewarray 4	java/lang/Object
    //   506: dup
    //   507: iconst_0
    //   508: aload_2
    //   509: aastore
    //   510: invokevirtual 134	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   513: checkcast 17	java/lang/String
    //   516: invokevirtual 138	java/lang/String:trim	()Ljava/lang/String;
    //   519: astore_3
    //   520: goto -450 -> 70
    //   523: aload_3
    //   524: aload_1
    //   525: iconst_1
    //   526: anewarray 4	java/lang/Object
    //   529: dup
    //   530: iconst_0
    //   531: aload_2
    //   532: aastore
    //   533: invokevirtual 134	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   536: checkcast 17	java/lang/String
    //   539: invokevirtual 138	java/lang/String:trim	()Ljava/lang/String;
    //   542: astore_3
    //   543: goto -412 -> 131
    //   546: aload_3
    //   547: aload_1
    //   548: iconst_1
    //   549: anewarray 4	java/lang/Object
    //   552: dup
    //   553: iconst_0
    //   554: aload_2
    //   555: aastore
    //   556: invokevirtual 134	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   559: checkcast 17	java/lang/String
    //   562: invokevirtual 138	java/lang/String:trim	()Ljava/lang/String;
    //   565: astore_3
    //   566: goto -141 -> 425
    //   569: aload_0
    //   570: aload_1
    //   571: iconst_1
    //   572: anewarray 4	java/lang/Object
    //   575: dup
    //   576: iconst_0
    //   577: aload_2
    //   578: aastore
    //   579: invokevirtual 134	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   582: checkcast 17	java/lang/String
    //   585: invokevirtual 138	java/lang/String:trim	()Ljava/lang/String;
    //   588: astore_0
    //   589: goto -102 -> 487
    //   592: astore_0
    //   593: aload 5
    //   595: areturn
    //   596: astore_3
    //   597: goto -162 -> 435
    //   600: astore_3
    //   601: goto -228 -> 373
    //   604: astore_3
    //   605: goto -294 -> 311
    //   608: astore_3
    //   609: goto -353 -> 256
    //   612: astore_3
    //   613: goto -418 -> 195
    //   616: astore_3
    //   617: goto -477 -> 140
    //   620: astore_3
    //   621: goto -542 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	624	0	paramClass	Class
    //   0	624	1	paramObject	Object
    //   0	624	2	paramInteger	Integer
    //   0	624	3	paramString1	String
    //   0	624	4	paramString2	String
    //   7	587	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   435	484	592	java/lang/Throwable
    //   487	497	592	java/lang/Throwable
    //   569	589	592	java/lang/Throwable
    //   373	422	596	java/lang/Throwable
    //   425	435	596	java/lang/Throwable
    //   546	566	596	java/lang/Throwable
    //   311	373	600	java/lang/Throwable
    //   256	311	604	java/lang/Throwable
    //   195	256	608	java/lang/Throwable
    //   140	195	612	java/lang/Throwable
    //   79	128	616	java/lang/Throwable
    //   131	140	616	java/lang/Throwable
    //   523	543	616	java/lang/Throwable
    //   18	67	620	java/lang/Throwable
    //   70	79	620	java/lang/Throwable
    //   500	520	620	java/lang/Throwable
  }
  
  private static void a(Context paramContext)
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
      if (r.a(11))
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
    catch (Throwable paramContext) {}
    return null;
  }
  
  private static Map b()
  {
    HashMap localHashMap = new HashMap();
    BufferedReader localBufferedReader = new BufferedReader(new FileReader(new File("/proc/net/arp")));
    for (;;)
    {
      String str = localBufferedReader.readLine();
      if (str == null) {
        break;
      }
      Object localObject = str.split("[ ]+");
      if (!localObject[0].matches("IP"))
      {
        str = localObject[0];
        localObject = localObject[3];
        if ((!localHashMap.containsKey(str)) && (!((String)localObject).equals("00:00:00:00:00:00"))) {
          localHashMap.put(str, localObject);
        }
      }
    }
    localBufferedReader.close();
    return localHashMap;
  }
  
  /* Error */
  public static boolean c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 413
    //   4: invokestatic 416	com/unionpay/sdk/r:b	(Landroid/content/Context;Ljava/lang/String;)Z
    //   7: ifeq +54 -> 61
    //   10: aload_0
    //   11: ldc_w 418
    //   14: invokevirtual 84	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast 420	android/net/ConnectivityManager
    //   20: astore_0
    //   21: aload_0
    //   22: invokevirtual 424	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +8 -> 35
    //   30: aload_1
    //   31: invokevirtual 429	android/net/NetworkInfo:isConnected	()Z
    //   34: ireturn
    //   35: aload_0
    //   36: iconst_0
    //   37: invokevirtual 433	android/net/ConnectivityManager:getNetworkInfo	(I)Landroid/net/NetworkInfo;
    //   40: astore_0
    //   41: aload_0
    //   42: ifnull +150 -> 192
    //   45: aload_0
    //   46: invokevirtual 437	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   49: getstatic 442	android/net/NetworkInfo$State:UNKNOWN	Landroid/net/NetworkInfo$State;
    //   52: invokevirtual 443	android/net/NetworkInfo$State:equals	(Ljava/lang/Object;)Z
    //   55: ifne +6 -> 61
    //   58: goto +134 -> 192
    //   61: invokestatic 449	android/os/SystemClock:elapsedRealtime	()J
    //   64: getstatic 65	com/unionpay/sdk/j:c	J
    //   67: lsub
    //   68: ldc2_w 450
    //   71: lcmp
    //   72: ifle +47 -> 119
    //   75: invokestatic 449	android/os/SystemClock:elapsedRealtime	()J
    //   78: putstatic 65	com/unionpay/sdk/j:c	J
    //   81: aconst_null
    //   82: astore_0
    //   83: aload_0
    //   84: astore_1
    //   85: invokestatic 453	com/unionpay/sdk/j:a	()Z
    //   88: ifeq +35 -> 123
    //   91: aload_0
    //   92: astore_1
    //   93: new 455	java/net/Socket
    //   96: dup
    //   97: invokestatic 327	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   100: invokestatic 458	android/net/Proxy:getDefaultPort	()I
    //   103: invokespecial 461	java/net/Socket:<init>	(Ljava/lang/String;I)V
    //   106: astore_0
    //   107: aload_0
    //   108: astore_1
    //   109: aload_0
    //   110: astore_2
    //   111: iconst_1
    //   112: putstatic 61	com/unionpay/sdk/j:b	Z
    //   115: aload_0
    //   116: invokevirtual 462	java/net/Socket:close	()V
    //   119: getstatic 61	com/unionpay/sdk/j:b	Z
    //   122: ireturn
    //   123: aload_0
    //   124: astore_1
    //   125: new 455	java/net/Socket
    //   128: dup
    //   129: ldc_w 464
    //   132: bipush 80
    //   134: invokespecial 461	java/net/Socket:<init>	(Ljava/lang/String;I)V
    //   137: astore_0
    //   138: goto -31 -> 107
    //   141: astore_0
    //   142: aload_1
    //   143: astore_2
    //   144: iconst_0
    //   145: putstatic 61	com/unionpay/sdk/j:b	Z
    //   148: aload_1
    //   149: ifnull -30 -> 119
    //   152: aload_1
    //   153: invokevirtual 462	java/net/Socket:close	()V
    //   156: goto -37 -> 119
    //   159: astore_0
    //   160: goto -41 -> 119
    //   163: astore_0
    //   164: aconst_null
    //   165: astore_2
    //   166: aload_2
    //   167: ifnull +7 -> 174
    //   170: aload_2
    //   171: invokevirtual 462	java/net/Socket:close	()V
    //   174: aload_0
    //   175: athrow
    //   176: astore_0
    //   177: goto -58 -> 119
    //   180: astore_0
    //   181: goto -62 -> 119
    //   184: astore_1
    //   185: goto -11 -> 174
    //   188: astore_0
    //   189: goto -23 -> 166
    //   192: iconst_0
    //   193: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramContext	Context
    //   25	128	1	localObject1	Object
    //   184	1	1	localThrowable	Throwable
    //   110	61	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   85	91	141	java/lang/Throwable
    //   93	107	141	java/lang/Throwable
    //   111	115	141	java/lang/Throwable
    //   125	138	141	java/lang/Throwable
    //   152	156	159	java/lang/Throwable
    //   85	91	163	finally
    //   93	107	163	finally
    //   125	138	163	finally
    //   0	26	176	java/lang/Throwable
    //   30	35	176	java/lang/Throwable
    //   35	41	176	java/lang/Throwable
    //   45	58	176	java/lang/Throwable
    //   61	81	176	java/lang/Throwable
    //   174	176	176	java/lang/Throwable
    //   115	119	180	java/lang/Throwable
    //   170	174	184	java/lang/Throwable
    //   111	115	188	finally
    //   144	148	188	finally
  }
  
  public static boolean d(Context paramContext)
  {
    try
    {
      if (r.b(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
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
      boolean bool = ((WifiManager)paramContext.getSystemService("wifi")).isWifiEnabled();
      return bool;
    }
    catch (Throwable paramContext) {}
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
      if (r.b(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
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
    return j(paramContext);
  }
  
  public static String j(Context paramContext)
  {
    String str = d[0];
    try
    {
      if (a == null) {
        a(paramContext);
      }
      paramContext = a(a.getNetworkType());
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return str;
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
      if ((r.a(23)) && (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0)) {
        return null;
      }
      if ((r.b(paramContext, "android.permission.READ_PHONE_STATE")) && (Build.VERSION.SDK_INT >= 18))
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
      localJSONObject.put("current", w(paramContext));
      localJSONObject.put("scannable", x(paramContext));
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
    try
    {
      if (!r.b) {
        return null;
      }
      if ((r.a(23)) && (paramContext.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0)) {
        return null;
      }
      if ((r.b(paramContext, "android.permission.ACCESS_COARSE_LOCATION")) || (r.b(paramContext, "android.permission.ACCESS_FINE_LOCATION")))
      {
        if (a == null) {
          a(paramContext);
        }
        JSONObject localJSONObject = new JSONObject();
        Object localObject;
        if ((r.d) || (r.e))
        {
          localObject = a.getCellLocation();
          if (!(localObject instanceof GsmCellLocation)) {
            break label209;
          }
          localObject = (GsmCellLocation)localObject;
          if (localObject != null)
          {
            localJSONObject.put("systemId", ((GsmCellLocation)localObject).getLac());
            localJSONObject.put("networkId", ((GsmCellLocation)localObject).getCid());
            if (r.a(9)) {
              localJSONObject.put("basestationId", ((GsmCellLocation)localObject).getPsc());
            }
          }
        }
        for (;;)
        {
          localJSONObject.put("type", j(paramContext));
          localJSONObject.put("mcc", k(paramContext));
          localJSONObject.put("operator", p(paramContext));
          localJSONObject.put("country", m(paramContext));
          paramContext = new JSONArray();
          paramContext.put(localJSONObject);
          return paramContext;
          label209:
          if ((localObject instanceof CdmaCellLocation))
          {
            localObject = (CdmaCellLocation)localObject;
            if (localObject != null)
            {
              localJSONObject.put("systemId", ((CdmaCellLocation)localObject).getSystemId());
              localJSONObject.put("networkId", ((CdmaCellLocation)localObject).getNetworkId());
              localJSONObject.put("basestationId", ((CdmaCellLocation)localObject).getBaseStationId());
              localJSONObject.put("location", a(((CdmaCellLocation)localObject).getBaseStationLatitude(), ((CdmaCellLocation)localObject).getBaseStationLongitude()));
            }
          }
        }
      }
      return null;
    }
    catch (Throwable paramContext) {}
  }
  
  /* Error */
  public static JSONArray t(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 566	com/unionpay/sdk/r:b	Z
    //   3: ifne +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: bipush 23
    //   10: invokestatic 308	com/unionpay/sdk/r:a	(I)Z
    //   13: ifeq +15 -> 28
    //   16: aload_0
    //   17: ldc_w 568
    //   20: invokevirtual 511	android/content/Context:checkSelfPermission	(Ljava/lang/String;)I
    //   23: ifeq +5 -> 28
    //   26: aconst_null
    //   27: areturn
    //   28: aload_0
    //   29: ldc_w 568
    //   32: invokestatic 416	com/unionpay/sdk/r:b	(Landroid/content/Context;Ljava/lang/String;)Z
    //   35: ifne +13 -> 48
    //   38: aload_0
    //   39: ldc_w 570
    //   42: invokestatic 416	com/unionpay/sdk/r:b	(Landroid/content/Context;Ljava/lang/String;)Z
    //   45: ifeq +746 -> 791
    //   48: getstatic 303	com/unionpay/sdk/j:a	Landroid/telephony/TelephonyManager;
    //   51: ifnonnull +7 -> 58
    //   54: aload_0
    //   55: invokestatic 477	com/unionpay/sdk/j:a	(Landroid/content/Context;)V
    //   58: new 75	org/json/JSONArray
    //   61: dup
    //   62: invokespecial 76	org/json/JSONArray:<init>	()V
    //   65: astore 7
    //   67: bipush 17
    //   69: invokestatic 308	com/unionpay/sdk/r:a	(I)Z
    //   72: ifeq +548 -> 620
    //   75: getstatic 303	com/unionpay/sdk/j:a	Landroid/telephony/TelephonyManager;
    //   78: invokevirtual 632	android/telephony/TelephonyManager:getAllCellInfo	()Ljava/util/List;
    //   81: astore_0
    //   82: aload_0
    //   83: ifnull +692 -> 775
    //   86: aload_0
    //   87: invokeinterface 638 1 0
    //   92: astore 8
    //   94: aload 8
    //   96: invokeinterface 643 1 0
    //   101: ifeq +674 -> 775
    //   104: aload 8
    //   106: invokeinterface 646 1 0
    //   111: checkcast 648	android/telephony/CellInfo
    //   114: astore_0
    //   115: new 211	org/json/JSONObject
    //   118: dup
    //   119: invokespecial 212	org/json/JSONObject:<init>	()V
    //   122: astore 9
    //   124: aload 9
    //   126: ldc_w 650
    //   129: aload_0
    //   130: invokevirtual 653	android/telephony/CellInfo:isRegistered	()Z
    //   133: invokevirtual 535	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   136: pop
    //   137: aload 9
    //   139: ldc_w 655
    //   142: aload_0
    //   143: invokevirtual 658	android/telephony/CellInfo:getTimeStamp	()J
    //   146: invokevirtual 661	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   149: pop
    //   150: aload_0
    //   151: instanceof 663
    //   154: ifeq +184 -> 338
    //   157: aload_0
    //   158: checkcast 663	android/telephony/CellInfoGsm
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 667	android/telephony/CellInfoGsm:getCellIdentity	()Landroid/telephony/CellIdentityGsm;
    //   166: astore 6
    //   168: aload 6
    //   170: invokevirtual 670	android/telephony/CellIdentityGsm:getLac	()I
    //   173: istore 5
    //   175: aload 6
    //   177: invokevirtual 671	android/telephony/CellIdentityGsm:getCid	()I
    //   180: istore 4
    //   182: aload 6
    //   184: invokevirtual 674	android/telephony/CellIdentityGsm:getMcc	()I
    //   187: istore_2
    //   188: aload 6
    //   190: invokevirtual 677	android/telephony/CellIdentityGsm:getMnc	()I
    //   193: istore_1
    //   194: aload_0
    //   195: invokevirtual 681	android/telephony/CellInfoGsm:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthGsm;
    //   198: astore 6
    //   200: iconst_m1
    //   201: istore_3
    //   202: ldc 55
    //   204: astore_0
    //   205: iload 5
    //   207: iconst_m1
    //   208: if_icmpeq +14 -> 222
    //   211: aload 9
    //   213: ldc_w 582
    //   216: iload 5
    //   218: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   221: pop
    //   222: iload 4
    //   224: iconst_m1
    //   225: if_icmpeq +14 -> 239
    //   228: aload 9
    //   230: ldc_w 587
    //   233: iload 4
    //   235: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   238: pop
    //   239: iload_3
    //   240: iconst_m1
    //   241: if_icmpeq +13 -> 254
    //   244: aload 9
    //   246: ldc_w 592
    //   249: iload_3
    //   250: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   253: pop
    //   254: iload_2
    //   255: iconst_m1
    //   256: if_icmpeq +13 -> 269
    //   259: aload 9
    //   261: ldc_w 597
    //   264: iload_2
    //   265: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   268: pop
    //   269: iload_1
    //   270: iconst_m1
    //   271: if_icmpeq +13 -> 284
    //   274: aload 9
    //   276: ldc_w 683
    //   279: iload_1
    //   280: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   283: pop
    //   284: aload 6
    //   286: ifnull +31 -> 317
    //   289: aload 9
    //   291: ldc_w 685
    //   294: aload 6
    //   296: invokevirtual 690	android/telephony/CellSignalStrength:getAsuLevel	()I
    //   299: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   302: pop
    //   303: aload 9
    //   305: ldc_w 692
    //   308: aload 6
    //   310: invokevirtual 695	android/telephony/CellSignalStrength:getDbm	()I
    //   313: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   316: pop
    //   317: aload 9
    //   319: ldc_w 528
    //   322: aload_0
    //   323: invokevirtual 226	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   326: pop
    //   327: aload 7
    //   329: aload 9
    //   331: invokevirtual 156	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   334: pop
    //   335: goto -241 -> 94
    //   338: aload_0
    //   339: instanceof 697
    //   342: ifeq +153 -> 495
    //   345: aload_0
    //   346: checkcast 697	android/telephony/CellInfoCdma
    //   349: astore 6
    //   351: aload 6
    //   353: invokevirtual 700	android/telephony/CellInfoCdma:getCellIdentity	()Landroid/telephony/CellIdentityCdma;
    //   356: astore_0
    //   357: aload_0
    //   358: invokevirtual 703	android/telephony/CellIdentityCdma:getSystemId	()I
    //   361: istore 5
    //   363: aload_0
    //   364: invokevirtual 704	android/telephony/CellIdentityCdma:getNetworkId	()I
    //   367: istore 4
    //   369: aload_0
    //   370: invokevirtual 707	android/telephony/CellIdentityCdma:getBasestationId	()I
    //   373: istore_3
    //   374: aload 6
    //   376: invokevirtual 710	android/telephony/CellInfoCdma:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthCdma;
    //   379: astore 6
    //   381: aload 9
    //   383: ldc_w 712
    //   386: aload 6
    //   388: invokevirtual 717	android/telephony/CellSignalStrengthCdma:getCdmaDbm	()I
    //   391: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   394: pop
    //   395: aload 9
    //   397: ldc_w 712
    //   400: aload 6
    //   402: invokevirtual 717	android/telephony/CellSignalStrengthCdma:getCdmaDbm	()I
    //   405: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   408: pop
    //   409: aload 9
    //   411: ldc_w 719
    //   414: aload 6
    //   416: invokevirtual 722	android/telephony/CellSignalStrengthCdma:getCdmaEcio	()I
    //   419: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   422: pop
    //   423: aload 9
    //   425: ldc_w 724
    //   428: aload 6
    //   430: invokevirtual 727	android/telephony/CellSignalStrengthCdma:getEvdoDbm	()I
    //   433: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   436: pop
    //   437: aload 9
    //   439: ldc_w 729
    //   442: aload 6
    //   444: invokevirtual 732	android/telephony/CellSignalStrengthCdma:getEvdoEcio	()I
    //   447: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   450: pop
    //   451: aload 9
    //   453: ldc_w 734
    //   456: aload 6
    //   458: invokevirtual 737	android/telephony/CellSignalStrengthCdma:getEvdoSnr	()I
    //   461: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   464: pop
    //   465: aload 9
    //   467: ldc_w 620
    //   470: aload_0
    //   471: invokevirtual 740	android/telephony/CellIdentityCdma:getLatitude	()I
    //   474: aload_0
    //   475: invokevirtual 743	android/telephony/CellIdentityCdma:getLongitude	()I
    //   478: invokestatic 628	com/unionpay/sdk/j:a	(II)Lorg/json/JSONObject;
    //   481: invokevirtual 226	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   484: pop
    //   485: iconst_m1
    //   486: istore_2
    //   487: iconst_m1
    //   488: istore_1
    //   489: ldc 27
    //   491: astore_0
    //   492: goto -287 -> 205
    //   495: aload_0
    //   496: instanceof 745
    //   499: ifeq +59 -> 558
    //   502: aload_0
    //   503: checkcast 745	android/telephony/CellInfoWcdma
    //   506: astore_0
    //   507: aload_0
    //   508: invokevirtual 748	android/telephony/CellInfoWcdma:getCellIdentity	()Landroid/telephony/CellIdentityWcdma;
    //   511: astore 6
    //   513: aload 6
    //   515: invokevirtual 751	android/telephony/CellIdentityWcdma:getLac	()I
    //   518: istore 5
    //   520: aload 6
    //   522: invokevirtual 752	android/telephony/CellIdentityWcdma:getCid	()I
    //   525: istore 4
    //   527: aload 6
    //   529: invokevirtual 753	android/telephony/CellIdentityWcdma:getPsc	()I
    //   532: istore_3
    //   533: aload 6
    //   535: invokevirtual 754	android/telephony/CellIdentityWcdma:getMcc	()I
    //   538: istore_2
    //   539: aload 6
    //   541: invokevirtual 755	android/telephony/CellIdentityWcdma:getMnc	()I
    //   544: istore_1
    //   545: aload_0
    //   546: invokevirtual 758	android/telephony/CellInfoWcdma:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthWcdma;
    //   549: astore 6
    //   551: ldc_w 760
    //   554: astore_0
    //   555: goto -350 -> 205
    //   558: aload_0
    //   559: instanceof 762
    //   562: ifeq +231 -> 793
    //   565: aload_0
    //   566: checkcast 762	android/telephony/CellInfoLte
    //   569: astore_0
    //   570: aload_0
    //   571: invokevirtual 765	android/telephony/CellInfoLte:getCellIdentity	()Landroid/telephony/CellIdentityLte;
    //   574: astore 6
    //   576: aload 6
    //   578: invokevirtual 770	android/telephony/CellIdentityLte:getTac	()I
    //   581: istore 5
    //   583: aload 6
    //   585: invokevirtual 773	android/telephony/CellIdentityLte:getPci	()I
    //   588: istore 4
    //   590: aload 6
    //   592: invokevirtual 776	android/telephony/CellIdentityLte:getCi	()I
    //   595: istore_3
    //   596: aload 6
    //   598: invokevirtual 777	android/telephony/CellIdentityLte:getMcc	()I
    //   601: istore_2
    //   602: aload 6
    //   604: invokevirtual 778	android/telephony/CellIdentityLte:getMnc	()I
    //   607: istore_1
    //   608: aload_0
    //   609: invokevirtual 781	android/telephony/CellInfoLte:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthLte;
    //   612: astore 6
    //   614: ldc 45
    //   616: astore_0
    //   617: goto -412 -> 205
    //   620: iconst_5
    //   621: invokestatic 308	com/unionpay/sdk/r:a	(I)Z
    //   624: ifeq +151 -> 775
    //   627: getstatic 572	com/unionpay/sdk/r:d	Z
    //   630: ifne +9 -> 639
    //   633: getstatic 574	com/unionpay/sdk/r:e	Z
    //   636: ifeq +139 -> 775
    //   639: getstatic 303	com/unionpay/sdk/j:a	Landroid/telephony/TelephonyManager;
    //   642: invokevirtual 784	android/telephony/TelephonyManager:getNeighboringCellInfo	()Ljava/util/List;
    //   645: astore_0
    //   646: aload_0
    //   647: ifnull +128 -> 775
    //   650: aload_0
    //   651: invokeinterface 638 1 0
    //   656: astore_0
    //   657: aload_0
    //   658: invokeinterface 643 1 0
    //   663: ifeq +112 -> 775
    //   666: aload_0
    //   667: invokeinterface 646 1 0
    //   672: checkcast 786	android/telephony/NeighboringCellInfo
    //   675: astore 6
    //   677: new 211	org/json/JSONObject
    //   680: dup
    //   681: invokespecial 212	org/json/JSONObject:<init>	()V
    //   684: astore 8
    //   686: aload 8
    //   688: ldc_w 582
    //   691: aload 6
    //   693: invokevirtual 787	android/telephony/NeighboringCellInfo:getLac	()I
    //   696: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   699: pop
    //   700: aload 8
    //   702: ldc_w 789
    //   705: aload 6
    //   707: invokevirtual 790	android/telephony/NeighboringCellInfo:getCid	()I
    //   710: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   713: pop
    //   714: aload 8
    //   716: ldc_w 592
    //   719: aload 6
    //   721: invokevirtual 791	android/telephony/NeighboringCellInfo:getPsc	()I
    //   724: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   727: pop
    //   728: aload 8
    //   730: ldc_w 685
    //   733: aload 6
    //   735: invokevirtual 794	android/telephony/NeighboringCellInfo:getRssi	()I
    //   738: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   741: pop
    //   742: aload 8
    //   744: ldc_w 528
    //   747: aload 6
    //   749: invokevirtual 795	android/telephony/NeighboringCellInfo:getNetworkType	()I
    //   752: invokestatic 250	com/unionpay/sdk/j:a	(I)Ljava/lang/String;
    //   755: invokevirtual 226	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   758: pop
    //   759: aload 7
    //   761: aload 8
    //   763: invokevirtual 156	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   766: pop
    //   767: goto -110 -> 657
    //   770: astore 6
    //   772: goto -115 -> 657
    //   775: aload 7
    //   777: invokevirtual 565	org/json/JSONArray:length	()I
    //   780: istore_1
    //   781: iload_1
    //   782: ifle +6 -> 788
    //   785: aload 7
    //   787: areturn
    //   788: aconst_null
    //   789: areturn
    //   790: astore_0
    //   791: aconst_null
    //   792: areturn
    //   793: aconst_null
    //   794: astore_0
    //   795: aconst_null
    //   796: astore 6
    //   798: iconst_m1
    //   799: istore_1
    //   800: iconst_m1
    //   801: istore_2
    //   802: iconst_m1
    //   803: istore_3
    //   804: iconst_m1
    //   805: istore 4
    //   807: iconst_m1
    //   808: istore 5
    //   810: goto -605 -> 205
    //   813: astore_0
    //   814: goto -720 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	817	0	paramContext	Context
    //   193	607	1	i	int
    //   187	615	2	j	int
    //   201	603	3	k	int
    //   180	626	4	m	int
    //   173	636	5	n	int
    //   166	582	6	localObject1	Object
    //   770	1	6	localThrowable	Throwable
    //   796	1	6	localObject2	Object
    //   65	721	7	localJSONArray	JSONArray
    //   92	670	8	localObject3	Object
    //   122	344	9	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   677	767	770	java/lang/Throwable
    //   48	58	790	java/lang/Throwable
    //   58	82	790	java/lang/Throwable
    //   86	94	790	java/lang/Throwable
    //   94	115	790	java/lang/Throwable
    //   620	639	790	java/lang/Throwable
    //   639	646	790	java/lang/Throwable
    //   650	657	790	java/lang/Throwable
    //   657	677	790	java/lang/Throwable
    //   775	781	790	java/lang/Throwable
    //   115	200	813	java/lang/Throwable
    //   211	222	813	java/lang/Throwable
    //   228	239	813	java/lang/Throwable
    //   244	254	813	java/lang/Throwable
    //   259	269	813	java/lang/Throwable
    //   274	284	813	java/lang/Throwable
    //   289	317	813	java/lang/Throwable
    //   317	335	813	java/lang/Throwable
    //   338	485	813	java/lang/Throwable
    //   495	551	813	java/lang/Throwable
    //   558	614	813	java/lang/Throwable
  }
  
  public static JSONArray u(Context paramContext)
  {
    try
    {
      if (!r.b) {
        return null;
      }
      if (r.b(paramContext, "android.permission.ACCESS_WIFI_STATE"))
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
          if (i > 0) {
            return paramContext;
          }
          return null;
        }
      }
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static String v(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (!r.b) {
          return null;
        }
        if (!r.b(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
          continue;
        }
        Object localObject = (WifiManager)paramContext.getSystemService("wifi");
        if ((!((WifiManager)localObject).isWifiEnabled()) || (!g(paramContext))) {
          continue;
        }
        paramContext = ((WifiManager)localObject).getConnectionInfo();
        if (paramContext == null) {
          continue;
        }
        localObject = paramContext.getBSSID();
        if (localObject == null) {
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext = null;
        continue;
      }
      try
      {
        paramContext = paramContext.getSSID();
        return paramContext;
      }
      catch (Throwable paramContext) {}
      paramContext = null;
    }
  }
  
  /* Error */
  public static JSONArray w(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 566	com/unionpay/sdk/r:b	Z
    //   3: ifne +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: aload_0
    //   9: ldc_w 797
    //   12: invokestatic 416	com/unionpay/sdk/r:b	(Landroid/content/Context;Ljava/lang/String;)Z
    //   15: ifeq +272 -> 287
    //   18: aload_0
    //   19: ldc_w 469
    //   22: invokevirtual 84	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   25: checkcast 471	android/net/wifi/WifiManager
    //   28: astore_2
    //   29: aload_2
    //   30: invokevirtual 474	android/net/wifi/WifiManager:isWifiEnabled	()Z
    //   33: ifeq +254 -> 287
    //   36: aload_2
    //   37: invokevirtual 843	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   40: astore_3
    //   41: aload_3
    //   42: ifnull +245 -> 287
    //   45: aload_3
    //   46: invokevirtual 848	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   49: ifnull +238 -> 287
    //   52: aload_3
    //   53: invokevirtual 848	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   56: astore 4
    //   58: new 75	org/json/JSONArray
    //   61: dup
    //   62: invokespecial 76	org/json/JSONArray:<init>	()V
    //   65: astore_0
    //   66: new 211	org/json/JSONObject
    //   69: dup
    //   70: invokespecial 212	org/json/JSONObject:<init>	()V
    //   73: astore_1
    //   74: aload_1
    //   75: ldc_w 810
    //   78: aload_3
    //   79: invokevirtual 851	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   82: invokevirtual 226	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   85: pop
    //   86: aload_1
    //   87: ldc_w 816
    //   90: aload 4
    //   92: invokevirtual 226	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   95: pop
    //   96: aload_1
    //   97: ldc_w 853
    //   100: aload_3
    //   101: invokevirtual 854	android/net/wifi/WifiInfo:getRssi	()I
    //   104: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   107: pop
    //   108: aload_1
    //   109: ldc_w 856
    //   112: aload_3
    //   113: invokevirtual 859	android/net/wifi/WifiInfo:getHiddenSSID	()Z
    //   116: invokevirtual 535	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   119: pop
    //   120: aload_1
    //   121: ldc_w 861
    //   124: aload_3
    //   125: invokevirtual 864	android/net/wifi/WifiInfo:getIpAddress	()I
    //   128: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   131: pop
    //   132: aload_1
    //   133: ldc_w 866
    //   136: aload_3
    //   137: invokevirtual 869	android/net/wifi/WifiInfo:getLinkSpeed	()I
    //   140: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   143: pop
    //   144: aload_1
    //   145: ldc_w 587
    //   148: aload_3
    //   149: invokevirtual 870	android/net/wifi/WifiInfo:getNetworkId	()I
    //   152: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   155: pop
    //   156: aload_1
    //   157: ldc_w 872
    //   160: aload_3
    //   161: invokevirtual 875	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
    //   164: invokevirtual 226	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   167: pop
    //   168: aload_2
    //   169: invokevirtual 879	android/net/wifi/WifiManager:getDhcpInfo	()Landroid/net/DhcpInfo;
    //   172: astore_2
    //   173: aload_2
    //   174: ifnull +104 -> 278
    //   177: new 211	org/json/JSONObject
    //   180: dup
    //   181: invokespecial 212	org/json/JSONObject:<init>	()V
    //   184: astore_3
    //   185: aload_3
    //   186: ldc_w 881
    //   189: aload_2
    //   190: getfield 885	android/net/DhcpInfo:dns1	I
    //   193: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   196: pop
    //   197: aload_3
    //   198: ldc_w 887
    //   201: aload_2
    //   202: getfield 889	android/net/DhcpInfo:dns2	I
    //   205: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   208: pop
    //   209: aload_3
    //   210: ldc_w 891
    //   213: aload_2
    //   214: getfield 894	android/net/DhcpInfo:gateway	I
    //   217: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   220: pop
    //   221: aload_3
    //   222: ldc_w 861
    //   225: aload_2
    //   226: getfield 897	android/net/DhcpInfo:ipAddress	I
    //   229: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   232: pop
    //   233: aload_3
    //   234: ldc_w 899
    //   237: aload_2
    //   238: getfield 902	android/net/DhcpInfo:netmask	I
    //   241: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   244: pop
    //   245: aload_3
    //   246: ldc_w 904
    //   249: aload_2
    //   250: getfield 907	android/net/DhcpInfo:serverAddress	I
    //   253: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   256: pop
    //   257: aload_3
    //   258: ldc_w 909
    //   261: aload_2
    //   262: getfield 911	android/net/DhcpInfo:leaseDuration	I
    //   265: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload_1
    //   270: ldc_w 913
    //   273: aload_3
    //   274: invokevirtual 226	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   277: pop
    //   278: aload_0
    //   279: aload_1
    //   280: invokevirtual 156	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
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
  public static JSONArray x(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 566	com/unionpay/sdk/r:b	Z
    //   3: ifeq +15 -> 18
    //   6: getstatic 572	com/unionpay/sdk/r:d	Z
    //   9: ifne +11 -> 20
    //   12: getstatic 574	com/unionpay/sdk/r:e	Z
    //   15: ifne +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: aload_0
    //   21: ldc_w 797
    //   24: invokestatic 416	com/unionpay/sdk/r:b	(Landroid/content/Context;Ljava/lang/String;)Z
    //   27: ifeq +260 -> 287
    //   30: aload_0
    //   31: ldc_w 469
    //   34: invokevirtual 84	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   37: checkcast 471	android/net/wifi/WifiManager
    //   40: astore_2
    //   41: aload_2
    //   42: invokevirtual 474	android/net/wifi/WifiManager:isWifiEnabled	()Z
    //   45: ifne +18 -> 63
    //   48: getstatic 517	android/os/Build$VERSION:SDK_INT	I
    //   51: bipush 18
    //   53: if_icmplt +234 -> 287
    //   56: aload_2
    //   57: invokevirtual 916	android/net/wifi/WifiManager:isScanAlwaysAvailable	()Z
    //   60: ifeq +227 -> 287
    //   63: aload_0
    //   64: ldc_w 918
    //   67: invokestatic 416	com/unionpay/sdk/r:b	(Landroid/content/Context;Ljava/lang/String;)Z
    //   70: istore_1
    //   71: iload_1
    //   72: ifeq +55 -> 127
    //   75: new 4	java/lang/Object
    //   78: dup
    //   79: invokespecial 69	java/lang/Object:<init>	()V
    //   82: astore_3
    //   83: new 920	android/content/IntentFilter
    //   86: dup
    //   87: ldc_w 922
    //   90: invokespecial 923	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   93: astore 4
    //   95: aload_0
    //   96: new 925	com/unionpay/sdk/ba
    //   99: dup
    //   100: aload_3
    //   101: aload_0
    //   102: invokespecial 928	com/unionpay/sdk/ba:<init>	(Ljava/lang/Object;Landroid/content/Context;)V
    //   105: aload 4
    //   107: invokevirtual 932	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   110: pop
    //   111: aload_2
    //   112: invokevirtual 935	android/net/wifi/WifiManager:startScan	()Z
    //   115: pop
    //   116: aload_3
    //   117: monitorenter
    //   118: aload_3
    //   119: ldc2_w 936
    //   122: invokevirtual 941	java/lang/Object:wait	(J)V
    //   125: aload_3
    //   126: monitorexit
    //   127: aload_2
    //   128: invokevirtual 944	android/net/wifi/WifiManager:getScanResults	()Ljava/util/List;
    //   131: astore_2
    //   132: aload_2
    //   133: ifnull +154 -> 287
    //   136: new 75	org/json/JSONArray
    //   139: dup
    //   140: invokespecial 76	org/json/JSONArray:<init>	()V
    //   143: astore_0
    //   144: aload_2
    //   145: invokeinterface 638 1 0
    //   150: astore_2
    //   151: aload_2
    //   152: invokeinterface 643 1 0
    //   157: ifeq +127 -> 284
    //   160: aload_2
    //   161: invokeinterface 646 1 0
    //   166: checkcast 946	android/net/wifi/ScanResult
    //   169: astore_3
    //   170: aload_3
    //   171: getfield 948	android/net/wifi/ScanResult:level	I
    //   174: bipush -85
    //   176: if_icmplt -25 -> 151
    //   179: new 211	org/json/JSONObject
    //   182: dup
    //   183: invokespecial 212	org/json/JSONObject:<init>	()V
    //   186: astore 4
    //   188: aload 4
    //   190: ldc_w 816
    //   193: aload_3
    //   194: getfield 949	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
    //   197: invokevirtual 226	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   200: pop
    //   201: aload 4
    //   203: ldc_w 810
    //   206: aload_3
    //   207: getfield 950	android/net/wifi/ScanResult:SSID	Ljava/lang/String;
    //   210: invokevirtual 226	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   213: pop
    //   214: aload 4
    //   216: ldc_w 853
    //   219: aload_3
    //   220: getfield 948	android/net/wifi/ScanResult:level	I
    //   223: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   226: pop
    //   227: aload 4
    //   229: ldc_w 952
    //   232: aload_3
    //   233: getfield 955	android/net/wifi/ScanResult:frequency	I
    //   236: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   239: pop
    //   240: bipush 17
    //   242: invokestatic 308	com/unionpay/sdk/r:a	(I)Z
    //   245: ifeq +16 -> 261
    //   248: aload 4
    //   250: ldc_w 655
    //   253: aload_3
    //   254: getfield 958	android/net/wifi/ScanResult:timestamp	J
    //   257: invokevirtual 661	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   260: pop
    //   261: aload_0
    //   262: aload 4
    //   264: invokevirtual 156	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   267: pop
    //   268: goto -117 -> 151
    //   271: astore_3
    //   272: goto -121 -> 151
    //   275: astore_0
    //   276: aload_3
    //   277: monitorexit
    //   278: aload_0
    //   279: athrow
    //   280: astore_0
    //   281: goto -154 -> 127
    //   284: aload_0
    //   285: areturn
    //   286: astore_0
    //   287: aconst_null
    //   288: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	paramContext	Context
    //   70	2	1	bool	boolean
    //   40	121	2	localObject1	Object
    //   82	172	3	localObject2	Object
    //   271	6	3	localThrowable	Throwable
    //   93	170	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   188	261	271	java/lang/Throwable
    //   261	268	271	java/lang/Throwable
    //   118	127	275	finally
    //   75	118	280	java/lang/Throwable
    //   276	280	280	java/lang/Throwable
    //   20	63	286	java/lang/Throwable
    //   63	71	286	java/lang/Throwable
    //   127	132	286	java/lang/Throwable
    //   136	151	286	java/lang/Throwable
    //   151	188	286	java/lang/Throwable
  }
  
  public static JSONArray y(Context paramContext)
  {
    JSONArray localJSONArray = new JSONArray();
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      ArrayList localArrayList;
      label209:
      int i;
      try
      {
        localObject1 = (TelephonyManager)paramContext.getSystemService("phone");
        localObject2 = ((TelephonyManager)localObject1).getDeviceId();
        localArrayList = new ArrayList();
        if (b(((String)localObject2).trim()).booleanValue())
        {
          localArrayList.add(((String)localObject2).trim());
          localObject1 = a((TelephonyManager)localObject1, (String)localObject2);
          if (localObject1 != null) {
            localJSONArray.put(localObject1);
          }
        }
      }
      catch (Throwable paramContext) {}
      for (;;)
      {
        try
        {
          localObject1 = (TelephonyManager)paramContext.getSystemService("phone1");
          localObject2 = ((TelephonyManager)localObject1).getDeviceId();
          if ((localObject2 != null) && (b((String)localObject2).booleanValue()) && (!localArrayList.contains(localObject2)))
          {
            localArrayList.add(localObject2);
            localObject1 = a((TelephonyManager)localObject1, (String)localObject2);
            if (localObject1 != null) {
              localJSONArray.put(localObject1);
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          break;
          break label236;
          break label225;
        }
        try
        {
          localObject1 = (TelephonyManager)paramContext.getSystemService("phone2");
          localObject2 = ((TelephonyManager)localObject1).getDeviceId();
          if ((localObject2 != null) && (b((String)localObject2).booleanValue()) && (!localArrayList.contains(localObject2)))
          {
            localArrayList.add(localObject2);
            localObject1 = a((TelephonyManager)localObject1, (String)localObject2);
            if (localObject1 != null) {
              localJSONArray.put(localObject1);
            }
          }
        }
        catch (Throwable localThrowable1)
        {
          break label209;
        }
      }
    }
    localObject1 = D(paramContext);
    localObject2 = C(paramContext);
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      label225:
      localObject2 = B(paramContext);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        label236:
        paramContext = A(paramContext);
        if (paramContext != null) {
          localObject1 = paramContext;
        }
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            paramContext = ((JSONArray)localObject1).getJSONObject(i);
            localObject2 = paramContext.getString("imei");
            if (!localArrayList.contains(localObject2))
            {
              localArrayList.add(localObject2);
              localJSONArray.put(paramContext);
            }
            i += 1;
          }
        }
        return localJSONArray;
      }
    }
  }
  
  public static Map z(Context paramContext)
  {
    int i = 1;
    if (e(paramContext)) {}
    for (;;)
    {
      int j;
      try
      {
        Object localObject = b(paramContext);
        if (localObject != null)
        {
          paramContext = ((String)localObject).substring(0, ((String)localObject).lastIndexOf('.') + 1);
          j = Integer.parseInt(((String)localObject).substring(((String)localObject).lastIndexOf('.') + 1));
          if (j - 5 > 0) {
            break label155;
          }
          if (i < j + 7)
          {
            if (i > 254) {
              break label148;
            }
            localObject = InetAddress.getByName(paramContext + i);
            DatagramSocket localDatagramSocket = new DatagramSocket();
            byte[] arrayOfByte = new byte[1];
            arrayOfByte[0] = 1;
            localDatagramSocket.send(new DatagramPacket(arrayOfByte, arrayOfByte.length, (InetAddress)localObject, 80));
            Thread.sleep(200L);
            break label148;
          }
        }
        paramContext = b();
        return paramContext;
      }
      catch (Throwable paramContext) {}
      return null;
      label148:
      i += 1;
      continue;
      label155:
      i = j - 5;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */