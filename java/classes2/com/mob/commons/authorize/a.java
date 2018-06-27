package com.mob.commons.authorize;

import android.text.TextUtils;
import android.util.Base64;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.commons.LockAction;
import com.mob.commons.MobProduct;
import com.mob.commons.MobProductCollector;
import com.mob.commons.c;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper.NetworkTimeOut;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private void a(long paramLong)
  {
    try
    {
      DataOutputStream localDataOutputStream = new DataOutputStream(new FileOutputStream(ResHelper.getCacheRootFile(MobSDK.getContext(), "comm/dbs/.digap")));
      localDataOutputStream.writeLong(paramLong);
      localDataOutputStream.flush();
      localDataOutputStream.close();
      return;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
  }
  
  private void a(final String paramString, final MobProduct paramMobProduct)
  {
    new Thread()
    {
      public void run()
      {
        try
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("duid", paramString);
          a.b(a.this, localHashMap);
          a.a(a.this, localHashMap, paramString);
          a.a(a.this, localHashMap, paramMobProduct);
          a.c(a.this, localHashMap);
          return;
        }
        finally {}
      }
    }.start();
  }
  
  private void a(HashMap<String, Object> paramHashMap, String paramString)
  {
    try
    {
      if (com.mob.commons.a.D()) {
        return;
      }
      Object localObject1 = (HashMap)paramHashMap.get("deviceInfo");
      paramHashMap = new HashMap();
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        paramHashMap.put(((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
      }
      try
      {
        paramHashMap.put("carrier", Integer.valueOf(ResHelper.parseInt(String.valueOf(paramHashMap.get("carrier")))));
        localObject1 = (ArrayList)paramHashMap.remove("androidids");
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())) {
          paramHashMap.put("androidid", ((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1));
        }
        localObject1 = DeviceHelper.getInstance(MobSDK.getContext());
        paramHashMap.put("duid", paramString);
        paramString = ((DeviceHelper)localObject1).queryIMEI();
        if ((paramString != null) && (paramString.length > 0)) {
          paramHashMap.put("imeiArray", paramString);
        }
        for (;;)
        {
          try
          {
            localObject2 = ((DeviceHelper)localObject1).listNetworkHardware();
            Object localObject3;
            if ((localObject2 != null) && (!((HashMap)localObject2).isEmpty()))
            {
              paramString = new ArrayList();
              localObject2 = ((HashMap)localObject2).entrySet().iterator();
              if (!((Iterator)localObject2).hasNext()) {
                break label553;
              }
              localObject3 = (Map.Entry)((Iterator)localObject2).next();
              HashMap localHashMap = new HashMap();
              localHashMap.put("ss", ((Map.Entry)localObject3).getKey());
              localHashMap.put("mac", ((Map.Entry)localObject3).getValue());
              paramString.add(localHashMap);
              continue;
            }
            a(com.mob.commons.a.a() + com.mob.commons.a.G());
          }
          catch (Throwable paramString)
          {
            localObject2 = ((DeviceHelper)localObject1).getMemoryInfo();
            paramString = ((DeviceHelper)localObject1).getSizeInfo();
            if (localObject2 != null) {
              paramHashMap.put("ram", ((HashMap)localObject2).get("total"));
            }
            if (paramString != null)
            {
              localObject2 = (HashMap)paramString.get("sdcard");
              if (localObject2 != null) {
                paramHashMap.put("sdcardStorage", ((HashMap)localObject2).get("total"));
              }
              paramString = (HashMap)paramString.get("data");
              if (paramString != null) {
                paramHashMap.put("dataStorage", paramString.get("total"));
              }
            }
            paramHashMap.put("romImg", ((DeviceHelper)localObject1).getMIUIVersion());
            paramString = new Hashon();
            paramHashMap = paramString.fromHashMap(paramHashMap);
            localObject1 = Base64.encodeToString(Data.AES128Encode(h(), paramHashMap), 2);
            paramHashMap = new ArrayList();
            paramHashMap.add(new KVPair("m", localObject1));
            localObject1 = new NetworkHelper.NetworkTimeOut();
            ((NetworkHelper.NetworkTimeOut)localObject1).readTimout = 30000;
            ((NetworkHelper.NetworkTimeOut)localObject1).connectionTimeout = 30000;
            localObject2 = new NetworkHelper();
            localObject3 = new ArrayList();
            ((ArrayList)localObject3).add(new KVPair("User-Identity", MobProductCollector.getUserIdentity()));
            if (!"200".equals(String.valueOf(paramString.fromJson(((NetworkHelper)localObject2).httpPost("http://devs.data.mob.com:80/dinfo", paramHashMap, null, (ArrayList)localObject3, (NetworkHelper.NetworkTimeOut)localObject1)).get("status")))) {
              break;
            }
          }
          return;
          paramHashMap.put("macArray", paramString);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;) {}
      }
    }
    catch (Throwable paramHashMap)
    {
      MobLog.getInstance().w(paramHashMap);
      return;
    }
    label553:
  }
  
  private void a(final HashMap<String, Object> paramHashMap, final boolean paramBoolean, final MobProduct paramMobProduct)
  {
    new Thread()
    {
      public void run()
      {
        try
        {
          boolean bool = paramBoolean;
          if ((a.a(a.this, paramHashMap)) || (a.b(a.this)))
          {
            a.b(a.this, paramHashMap);
            a.a(a.this, paramHashMap, (String)paramHashMap.get("duid"));
            bool = true;
          }
          if (a.a(a.this, paramHashMap, paramMobProduct)) {
            bool = true;
          }
          if (bool) {
            a.c(a.this, paramHashMap);
          }
          return;
        }
        finally {}
      }
    }.start();
  }
  
  private boolean a(MobProduct paramMobProduct, HashMap<String, Object> paramHashMap)
    throws Throwable
  {
    if (com.mob.commons.a.D()) {
      return false;
    }
    DeviceHelper localDeviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new KVPair("product", paramMobProduct.getProductTag()));
    String str = (String)paramHashMap.get("duid");
    ((ArrayList)localObject).add(new KVPair("appkey", MobSDK.getAppkey()));
    ((ArrayList)localObject).add(new KVPair("duid", str));
    ((ArrayList)localObject).add(new KVPair("apppkg", String.valueOf(localDeviceHelper.getPackageName())));
    ((ArrayList)localObject).add(new KVPair("appver", String.valueOf(localDeviceHelper.getAppVersion())));
    ((ArrayList)localObject).add(new KVPair("sdkver", String.valueOf(paramMobProduct.getSdkver())));
    ((ArrayList)localObject).add(new KVPair("network", String.valueOf(localDeviceHelper.getDetailNetworkTypeForStatic())));
    NetworkHelper.NetworkTimeOut localNetworkTimeOut = new NetworkHelper.NetworkTimeOut();
    localNetworkTimeOut.readTimout = 30000;
    localNetworkTimeOut.connectionTimeout = 30000;
    NetworkHelper localNetworkHelper = new NetworkHelper();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("User-Identity", MobProductCollector.getUserIdentity()));
    localObject = localNetworkHelper.httpPost("http://devs.data.mob.com:80/dsign", (ArrayList)localObject, null, localArrayList, localNetworkTimeOut);
    localObject = new Hashon().fromJson((String)localObject);
    if ("true".equals(String.valueOf(((HashMap)localObject).get("reup")))) {
      a(paramHashMap, str);
    }
    if ("200".equals(String.valueOf(((HashMap)localObject).get("status"))))
    {
      ((HashMap)((HashMap)paramHashMap.get("appInfo")).get(localDeviceHelper.getPackageName())).put(paramMobProduct.getProductTag(), MobSDK.getAppkey());
      return true;
    }
    return false;
  }
  
  private boolean a(HashMap<String, Object> paramHashMap)
  {
    HashMap localHashMap = (HashMap)paramHashMap.get("deviceInfo");
    if (localHashMap == null) {}
    do
    {
      DeviceHelper localDeviceHelper;
      do
      {
        do
        {
          Object localObject3;
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    return true;
                                    localDeviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
                                    localObject3 = localHashMap.get("adsid");
                                    paramHashMap = null;
                                    try
                                    {
                                      localObject1 = localDeviceHelper.getAdvertisingID();
                                      paramHashMap = (HashMap<String, Object>)localObject1;
                                    }
                                    catch (Throwable localThrowable)
                                    {
                                      for (;;)
                                      {
                                        Object localObject1;
                                        MobLog.getInstance().w(localThrowable);
                                      }
                                    }
                                  } while ((paramHashMap != null) && (!paramHashMap.equals(localObject3)));
                                  paramHashMap = localHashMap.get("phoneno");
                                  localObject1 = localDeviceHelper.getLine1Number();
                                } while ((localObject1 != null) && (!((String)localObject1).equals(paramHashMap)));
                                paramHashMap = localHashMap.get("simserialno");
                                localObject1 = localDeviceHelper.getSimSerialNumber();
                              } while ((localObject1 != null) && (!((String)localObject1).equals(paramHashMap)));
                              paramHashMap = localHashMap.get("imei");
                              localObject1 = localDeviceHelper.getIMEI();
                            } while ((localObject1 != null) && (!((String)localObject1).equals(paramHashMap)));
                            paramHashMap = localHashMap.get("serialno");
                            localObject1 = localDeviceHelper.getSerialno();
                          } while ((localObject1 != null) && (!((String)localObject1).equals(paramHashMap)));
                          paramHashMap = localHashMap.get("mac");
                          localObject1 = localDeviceHelper.getMacAddress();
                        } while ((localObject1 != null) && (!((String)localObject1).equals(paramHashMap)));
                        paramHashMap = localHashMap.get("model");
                        localObject1 = localDeviceHelper.getModel();
                      } while ((localObject1 != null) && (!((String)localObject1).equals(paramHashMap)));
                      paramHashMap = localHashMap.get("factory");
                      localObject1 = localDeviceHelper.getManufacturer();
                    } while ((localObject1 != null) && (!((String)localObject1).equals(paramHashMap)));
                    paramHashMap = localHashMap.get("carrier");
                    localObject1 = localDeviceHelper.getCarrier();
                  } while ((localObject1 != null) && (!((String)localObject1).equals(paramHashMap)));
                  paramHashMap = localHashMap.get("imsi");
                  localObject1 = localDeviceHelper.getIMSI();
                } while ((localObject1 != null) && (!((String)localObject1).equals(paramHashMap)));
                localObject1 = localHashMap.get("imsiArray");
                paramHashMap = localDeviceHelper.queryIMSI();
              } while ((paramHashMap != null) && (paramHashMap.length > 0) && (localObject1 == null));
              for (;;)
              {
                try
                {
                  localObject1 = (ArrayList)localObject1;
                  if (((ArrayList)localObject1).size() != paramHashMap.length) {
                    break;
                  }
                  int k = paramHashMap.length;
                  j = 0;
                  i = 0;
                  if (j >= k) {
                    continue;
                  }
                  localObject3 = paramHashMap[j];
                  Iterator localIterator = ((ArrayList)localObject1).iterator();
                  if (!localIterator.hasNext()) {
                    continue;
                  }
                  bool = ((String)localObject3).equals((String)localIterator.next());
                  if (!bool) {
                    continue;
                  }
                  i = 0;
                }
                catch (Throwable paramHashMap)
                {
                  int j;
                  boolean bool;
                  Object localObject2;
                  continue;
                  int i = 0;
                  continue;
                  continue;
                  i = 1;
                  continue;
                }
                j += 1;
              }
            } while (i != 0);
            localObject2 = localHashMap.get("androidids");
            paramHashMap = (HashMap<String, Object>)localObject2;
            if (localObject2 == null)
            {
              paramHashMap = localHashMap.get("androidid");
              if (paramHashMap == null) {
                break label658;
              }
              localObject2 = new ArrayList();
              ((ArrayList)localObject2).add(paramHashMap);
              paramHashMap = (HashMap<String, Object>)localObject2;
            }
          } while ((paramHashMap == null) || (!(paramHashMap instanceof ArrayList)));
          localObject2 = localDeviceHelper.getAndroidID();
          paramHashMap = ((ArrayList)paramHashMap).iterator();
          do
          {
            if (!paramHashMap.hasNext()) {
              break;
            }
            localObject3 = paramHashMap.next();
          } while ((localObject3 == null) || (!localObject3.equals(localObject2)));
          i = 1;
        } while (i == 0);
        paramHashMap = localHashMap.get("sysver");
        localObject2 = localDeviceHelper.getOSVersionName();
      } while ((localObject2 != null) && (!((String)localObject2).equals(paramHashMap)));
      paramHashMap = localHashMap.get("breaked");
      bool = localDeviceHelper.isRooted();
    } while (((paramHashMap == null) && (bool)) || ((paramHashMap != null) && (!String.valueOf(paramHashMap).equals(String.valueOf(bool)))));
    return false;
  }
  
  private boolean a(HashMap<String, Object> paramHashMap, MobProduct paramMobProduct)
  {
    Object localObject1 = paramMobProduct;
    if (paramMobProduct == null) {
      localObject1 = new MobProduct()
      {
        public String getProductTag()
        {
          return "COMMON";
        }
        
        public int getSdkver()
        {
          return com.mob.a.a;
        }
      };
    }
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    label214:
    for (;;)
    {
      try
      {
        paramMobProduct = (HashMap)paramHashMap.get("appInfo");
        if (paramMobProduct != null) {
          break label214;
        }
        bool2 = bool3;
        paramMobProduct = new HashMap();
        bool2 = bool3;
        paramHashMap.put("appInfo", paramMobProduct);
        bool1 = true;
        bool2 = bool1;
        String str = DeviceHelper.getInstance(MobSDK.getContext()).getPackageName();
        bool2 = bool1;
        HashMap localHashMap = (HashMap)paramMobProduct.get(str);
        Object localObject2 = localHashMap;
        bool3 = bool1;
        if (localHashMap == null)
        {
          bool2 = bool1;
          localObject2 = new HashMap();
          bool2 = bool1;
          paramMobProduct.put(str, localObject2);
          bool3 = true;
        }
        bool2 = bool3;
        paramMobProduct = (String)((HashMap)localObject2).get(((MobProduct)localObject1).getProductTag());
        bool2 = bool3;
        localObject2 = MobSDK.getAppkey();
        if (paramMobProduct != null)
        {
          bool2 = bool3;
          if (paramMobProduct.equals(localObject2)) {}
        }
        else
        {
          bool2 = bool3;
          bool1 = a((MobProduct)localObject1, paramHashMap);
          if (bool1) {
            return true;
          }
        }
      }
      catch (Throwable paramHashMap)
      {
        MobLog.getInstance().w(paramHashMap);
        return bool2;
      }
      return bool3;
    }
  }
  
  private File b()
  {
    return ResHelper.getCacheRootFile(MobSDK.getContext(), "comm/dbs/.duid");
  }
  
  private String b(MobProduct paramMobProduct)
  {
    HashMap localHashMap = d();
    String str;
    if ((localHashMap != null) && (localHashMap.size() > 0))
    {
      str = (String)localHashMap.get("duid");
      if (str != null) {
        break label73;
      }
      str = e();
      localHashMap.put("duid", str);
    }
    label73:
    for (boolean bool = true;; bool = false)
    {
      a(localHashMap, bool, paramMobProduct);
      return str;
      str = e();
      a(str, paramMobProduct);
      return str;
    }
  }
  
  /* Error */
  private void b(HashMap<String, Object> paramHashMap)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: invokestatic 40	com/mob/MobSDK:getContext	()Landroid/content/Context;
    //   6: invokestatic 180	com/mob/tools/utils/DeviceHelper:getInstance	(Landroid/content/Context;)Lcom/mob/tools/utils/DeviceHelper;
    //   9: astore 11
    //   11: aload_1
    //   12: ldc 98
    //   14: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: checkcast 100	java/util/HashMap
    //   20: astore 9
    //   22: aload 9
    //   24: ifnonnull +1009 -> 1033
    //   27: new 100	java/util/HashMap
    //   30: dup
    //   31: invokespecial 105	java/util/HashMap:<init>	()V
    //   34: astore 9
    //   36: aload_1
    //   37: ldc 98
    //   39: aload 9
    //   41: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: pop
    //   45: aload 9
    //   47: ldc_w 371
    //   50: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   53: astore 8
    //   55: aload 11
    //   57: invokevirtual 374	com/mob/tools/utils/DeviceHelper:getLine1Number	()Ljava/lang/String;
    //   60: astore 10
    //   62: aload 10
    //   64: ifnull +24 -> 88
    //   67: aload 10
    //   69: aload 8
    //   71: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   74: ifne +14 -> 88
    //   77: aload 9
    //   79: ldc_w 371
    //   82: aload 10
    //   84: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: aload 9
    //   90: ldc_w 376
    //   93: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   96: astore 8
    //   98: aload 11
    //   100: invokevirtual 379	com/mob/tools/utils/DeviceHelper:getSimSerialNumber	()Ljava/lang/String;
    //   103: astore 10
    //   105: aload 10
    //   107: ifnull +24 -> 131
    //   110: aload 10
    //   112: aload 8
    //   114: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   117: ifne +14 -> 131
    //   120: aload 9
    //   122: ldc_w 376
    //   125: aload 10
    //   127: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   130: pop
    //   131: aload 9
    //   133: ldc_w 366
    //   136: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   139: astore 12
    //   141: aconst_null
    //   142: astore 8
    //   144: aload 11
    //   146: invokevirtual 369	com/mob/tools/utils/DeviceHelper:getAdvertisingID	()Ljava/lang/String;
    //   149: astore 10
    //   151: aload 10
    //   153: astore 8
    //   155: aload 8
    //   157: ifnull +24 -> 181
    //   160: aload 8
    //   162: aload 12
    //   164: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   167: ifne +14 -> 181
    //   170: aload 9
    //   172: ldc_w 366
    //   175: aload 8
    //   177: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   180: pop
    //   181: aload 9
    //   183: ldc_w 381
    //   186: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   189: astore 8
    //   191: aload 11
    //   193: invokevirtual 384	com/mob/tools/utils/DeviceHelper:getIMEI	()Ljava/lang/String;
    //   196: astore 10
    //   198: aload 10
    //   200: ifnull +24 -> 224
    //   203: aload 10
    //   205: aload 8
    //   207: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   210: ifne +14 -> 224
    //   213: aload 9
    //   215: ldc_w 381
    //   218: aload 10
    //   220: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   223: pop
    //   224: aload 9
    //   226: ldc_w 386
    //   229: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   232: astore 8
    //   234: aload 11
    //   236: invokevirtual 389	com/mob/tools/utils/DeviceHelper:getSerialno	()Ljava/lang/String;
    //   239: astore 10
    //   241: aload 10
    //   243: ifnull +24 -> 267
    //   246: aload 10
    //   248: aload 8
    //   250: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   253: ifne +14 -> 267
    //   256: aload 9
    //   258: ldc_w 386
    //   261: aload 10
    //   263: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   266: pop
    //   267: aload 9
    //   269: ldc -58
    //   271: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   274: astore 8
    //   276: aload 11
    //   278: invokevirtual 392	com/mob/tools/utils/DeviceHelper:getMacAddress	()Ljava/lang/String;
    //   281: astore 10
    //   283: aload 10
    //   285: ifnull +23 -> 308
    //   288: aload 10
    //   290: aload 8
    //   292: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   295: ifne +13 -> 308
    //   298: aload 9
    //   300: ldc -58
    //   302: aload 10
    //   304: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   307: pop
    //   308: aload 9
    //   310: ldc_w 394
    //   313: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   316: astore 8
    //   318: aload 11
    //   320: invokevirtual 397	com/mob/tools/utils/DeviceHelper:getModel	()Ljava/lang/String;
    //   323: astore 10
    //   325: aload 10
    //   327: ifnull +24 -> 351
    //   330: aload 10
    //   332: aload 8
    //   334: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   337: ifne +14 -> 351
    //   340: aload 9
    //   342: ldc_w 394
    //   345: aload 10
    //   347: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   350: pop
    //   351: aload 9
    //   353: ldc_w 399
    //   356: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   359: astore 8
    //   361: aload 11
    //   363: invokevirtual 402	com/mob/tools/utils/DeviceHelper:getManufacturer	()Ljava/lang/String;
    //   366: astore 10
    //   368: aload 10
    //   370: ifnull +24 -> 394
    //   373: aload 10
    //   375: aload 8
    //   377: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   380: ifne +14 -> 394
    //   383: aload 9
    //   385: ldc_w 399
    //   388: aload 10
    //   390: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   393: pop
    //   394: aload 9
    //   396: ldc_w 407
    //   399: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   402: astore 8
    //   404: aload 11
    //   406: invokevirtual 410	com/mob/tools/utils/DeviceHelper:getIMSI	()Ljava/lang/String;
    //   409: astore 10
    //   411: aload 10
    //   413: ifnull +24 -> 437
    //   416: aload 10
    //   418: aload 8
    //   420: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   423: ifne +14 -> 437
    //   426: aload 9
    //   428: ldc_w 407
    //   431: aload 10
    //   433: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   436: pop
    //   437: aload 9
    //   439: ldc_w 412
    //   442: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   445: astore 8
    //   447: aload 11
    //   449: invokevirtual 415	com/mob/tools/utils/DeviceHelper:queryIMSI	()[Ljava/lang/String;
    //   452: astore 10
    //   454: aload 10
    //   456: ifnull +179 -> 635
    //   459: aload 10
    //   461: arraylength
    //   462: istore_2
    //   463: iload_2
    //   464: ifle +171 -> 635
    //   467: aload 8
    //   469: ifnonnull +141 -> 610
    //   472: iconst_1
    //   473: istore_2
    //   474: iload_2
    //   475: istore_3
    //   476: iload_2
    //   477: ifne +143 -> 620
    //   480: iload_2
    //   481: istore_3
    //   482: aload 8
    //   484: checkcast 163	java/util/ArrayList
    //   487: astore 8
    //   489: iload_2
    //   490: istore_3
    //   491: aload 8
    //   493: invokevirtual 172	java/util/ArrayList:size	()I
    //   496: aload 10
    //   498: arraylength
    //   499: if_icmpeq +116 -> 615
    //   502: iconst_1
    //   503: istore_2
    //   504: iload_2
    //   505: istore_3
    //   506: iload_2
    //   507: ifne +113 -> 620
    //   510: iload_2
    //   511: istore_3
    //   512: aload 10
    //   514: arraylength
    //   515: istore 6
    //   517: iconst_0
    //   518: istore 4
    //   520: iload_2
    //   521: istore_3
    //   522: iload 4
    //   524: iload 6
    //   526: if_icmpge +94 -> 620
    //   529: aload 10
    //   531: iload 4
    //   533: aaload
    //   534: astore 12
    //   536: aload 8
    //   538: invokevirtual 416	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   541: astore 13
    //   543: aload 13
    //   545: invokeinterface 120 1 0
    //   550: ifeq +478 -> 1028
    //   553: aload 12
    //   555: aload 13
    //   557: invokeinterface 124 1 0
    //   562: checkcast 143	java/lang/String
    //   565: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   568: istore 7
    //   570: iload 7
    //   572: ifeq -29 -> 543
    //   575: iconst_0
    //   576: istore_2
    //   577: iload 4
    //   579: iconst_1
    //   580: iadd
    //   581: istore 4
    //   583: goto -63 -> 520
    //   586: astore 10
    //   588: invokestatic 69	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   591: aload 10
    //   593: invokevirtual 139	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   596: pop
    //   597: goto -442 -> 155
    //   600: astore_1
    //   601: invokestatic 69	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   604: aload_1
    //   605: invokevirtual 139	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   608: pop
    //   609: return
    //   610: iconst_0
    //   611: istore_2
    //   612: goto -138 -> 474
    //   615: iconst_0
    //   616: istore_2
    //   617: goto -113 -> 504
    //   620: iload_3
    //   621: ifeq +14 -> 635
    //   624: aload 9
    //   626: ldc_w 412
    //   629: aload 10
    //   631: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   634: pop
    //   635: aload 9
    //   637: ldc_w 422
    //   640: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   643: astore 8
    //   645: aload 11
    //   647: invokevirtual 425	com/mob/tools/utils/DeviceHelper:getOSVersionName	()Ljava/lang/String;
    //   650: astore 10
    //   652: aload 10
    //   654: ifnull +24 -> 678
    //   657: aload 10
    //   659: aload 8
    //   661: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   664: ifne +14 -> 678
    //   667: aload 9
    //   669: ldc_w 422
    //   672: aload 10
    //   674: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   677: pop
    //   678: aload 9
    //   680: ldc -115
    //   682: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   685: astore 8
    //   687: aload 11
    //   689: invokevirtual 405	com/mob/tools/utils/DeviceHelper:getCarrier	()Ljava/lang/String;
    //   692: astore 10
    //   694: aload 10
    //   696: ifnull +23 -> 719
    //   699: aload 10
    //   701: aload 8
    //   703: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   706: ifne +13 -> 719
    //   709: aload 9
    //   711: ldc -115
    //   713: aload 10
    //   715: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   718: pop
    //   719: aload 9
    //   721: ldc -98
    //   723: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   726: astore 10
    //   728: aload 10
    //   730: astore 8
    //   732: aload 10
    //   734: ifnonnull +38 -> 772
    //   737: aload 9
    //   739: ldc -88
    //   741: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   744: astore 8
    //   746: aload 8
    //   748: ifnull +277 -> 1025
    //   751: new 163	java/util/ArrayList
    //   754: dup
    //   755: invokespecial 194	java/util/ArrayList:<init>	()V
    //   758: astore 10
    //   760: aload 10
    //   762: aload 8
    //   764: invokevirtual 202	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   767: pop
    //   768: aload 10
    //   770: astore 8
    //   772: aload 8
    //   774: ifnull +11 -> 785
    //   777: aload 8
    //   779: instanceof 163
    //   782: ifne +148 -> 930
    //   785: new 163	java/util/ArrayList
    //   788: dup
    //   789: invokespecial 194	java/util/ArrayList:<init>	()V
    //   792: astore 8
    //   794: aload 8
    //   796: aload 11
    //   798: invokevirtual 419	com/mob/tools/utils/DeviceHelper:getAndroidID	()Ljava/lang/String;
    //   801: invokevirtual 202	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   804: pop
    //   805: aload 9
    //   807: ldc -98
    //   809: aload 8
    //   811: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   814: pop
    //   815: aload 9
    //   817: ldc_w 427
    //   820: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   823: astore 8
    //   825: aload 11
    //   827: invokevirtual 430	com/mob/tools/utils/DeviceHelper:isRooted	()Z
    //   830: istore 7
    //   832: aload 8
    //   834: ifnull +19 -> 853
    //   837: aload 8
    //   839: invokestatic 147	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   842: iload 7
    //   844: invokestatic 433	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   847: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   850: ifne +17 -> 867
    //   853: aload 9
    //   855: ldc_w 427
    //   858: iload 7
    //   860: invokestatic 461	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   863: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   866: pop
    //   867: aload 9
    //   869: ldc_w 463
    //   872: iconst_1
    //   873: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   876: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   879: pop
    //   880: aload 9
    //   882: ldc_w 465
    //   885: aload 11
    //   887: invokevirtual 468	com/mob/tools/utils/DeviceHelper:getScreenSize	()Ljava/lang/String;
    //   890: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   893: pop
    //   894: aload 9
    //   896: ldc_w 470
    //   899: aload 11
    //   901: invokevirtual 473	com/mob/tools/utils/DeviceHelper:getDeviceType	()Ljava/lang/String;
    //   904: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   907: pop
    //   908: aload_1
    //   909: ldc 98
    //   911: aload 9
    //   913: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   916: pop
    //   917: return
    //   918: invokestatic 69	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   921: aload 8
    //   923: invokevirtual 75	com/mob/tools/log/NLog:d	(Ljava/lang/Throwable;)I
    //   926: pop
    //   927: goto -307 -> 620
    //   930: aload 11
    //   932: invokevirtual 419	com/mob/tools/utils/DeviceHelper:getAndroidID	()Ljava/lang/String;
    //   935: astore 10
    //   937: aload 8
    //   939: checkcast 163	java/util/ArrayList
    //   942: astore 8
    //   944: aload 8
    //   946: invokevirtual 416	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   949: astore 12
    //   951: aload 12
    //   953: invokeinterface 120 1 0
    //   958: ifeq +62 -> 1020
    //   961: aload 12
    //   963: invokeinterface 124 1 0
    //   968: astore 13
    //   970: aload 13
    //   972: ifnull -21 -> 951
    //   975: aload 13
    //   977: aload 10
    //   979: invokevirtual 420	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   982: ifeq -31 -> 951
    //   985: iload 5
    //   987: istore_2
    //   988: iload_2
    //   989: ifne -174 -> 815
    //   992: aload 8
    //   994: aload 10
    //   996: invokevirtual 202	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   999: pop
    //   1000: aload 9
    //   1002: ldc -98
    //   1004: aload 8
    //   1006: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1009: pop
    //   1010: goto -195 -> 815
    //   1013: astore 8
    //   1015: iconst_1
    //   1016: istore_3
    //   1017: goto -99 -> 918
    //   1020: iconst_0
    //   1021: istore_2
    //   1022: goto -34 -> 988
    //   1025: goto -253 -> 772
    //   1028: iconst_1
    //   1029: istore_2
    //   1030: goto -453 -> 577
    //   1033: goto -988 -> 45
    //   1036: astore 8
    //   1038: goto -120 -> 918
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1041	0	this	a
    //   0	1041	1	paramHashMap	HashMap<String, Object>
    //   462	568	2	i	int
    //   475	542	3	j	int
    //   518	64	4	k	int
    //   1	985	5	m	int
    //   515	12	6	n	int
    //   568	291	7	bool	boolean
    //   53	952	8	localObject1	Object
    //   1013	1	8	localThrowable1	Throwable
    //   1036	1	8	localThrowable2	Throwable
    //   20	981	9	localHashMap	HashMap
    //   60	470	10	localObject2	Object
    //   586	44	10	localThrowable3	Throwable
    //   650	345	10	localObject3	Object
    //   9	922	11	localDeviceHelper	DeviceHelper
    //   139	823	12	localObject4	Object
    //   541	435	13	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   144	151	586	java/lang/Throwable
    //   3	22	600	java/lang/Throwable
    //   27	45	600	java/lang/Throwable
    //   45	62	600	java/lang/Throwable
    //   67	88	600	java/lang/Throwable
    //   88	105	600	java/lang/Throwable
    //   110	131	600	java/lang/Throwable
    //   131	141	600	java/lang/Throwable
    //   160	181	600	java/lang/Throwable
    //   181	198	600	java/lang/Throwable
    //   203	224	600	java/lang/Throwable
    //   224	241	600	java/lang/Throwable
    //   246	267	600	java/lang/Throwable
    //   267	283	600	java/lang/Throwable
    //   288	308	600	java/lang/Throwable
    //   308	325	600	java/lang/Throwable
    //   330	351	600	java/lang/Throwable
    //   351	368	600	java/lang/Throwable
    //   373	394	600	java/lang/Throwable
    //   394	411	600	java/lang/Throwable
    //   416	437	600	java/lang/Throwable
    //   437	454	600	java/lang/Throwable
    //   459	463	600	java/lang/Throwable
    //   588	597	600	java/lang/Throwable
    //   624	635	600	java/lang/Throwable
    //   635	652	600	java/lang/Throwable
    //   657	678	600	java/lang/Throwable
    //   678	694	600	java/lang/Throwable
    //   699	719	600	java/lang/Throwable
    //   719	728	600	java/lang/Throwable
    //   737	746	600	java/lang/Throwable
    //   751	768	600	java/lang/Throwable
    //   777	785	600	java/lang/Throwable
    //   785	815	600	java/lang/Throwable
    //   815	832	600	java/lang/Throwable
    //   837	853	600	java/lang/Throwable
    //   853	867	600	java/lang/Throwable
    //   867	917	600	java/lang/Throwable
    //   918	927	600	java/lang/Throwable
    //   930	951	600	java/lang/Throwable
    //   951	970	600	java/lang/Throwable
    //   975	985	600	java/lang/Throwable
    //   992	1010	600	java/lang/Throwable
    //   536	543	1013	java/lang/Throwable
    //   543	570	1013	java/lang/Throwable
    //   482	489	1036	java/lang/Throwable
    //   491	502	1036	java/lang/Throwable
    //   512	517	1036	java/lang/Throwable
  }
  
  private File c()
  {
    File localFile = new File(ResHelper.getDataCache(MobSDK.getContext()), "comm/dbs/.duid");
    if (!localFile.getParentFile().exists()) {
      localFile.getParentFile().mkdirs();
    }
    return localFile;
  }
  
  private void c(final HashMap<String, Object> paramHashMap)
  {
    c.a(c.a("comm/locks/.globalLock"), new LockAction()
    {
      public boolean run(FileLocker paramAnonymousFileLocker)
      {
        a.d(a.this, paramHashMap);
        return false;
      }
    });
  }
  
  /* Error */
  private HashMap<String, Object> d()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 518	com/mob/commons/authorize/a:b	()Ljava/io/File;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 494	java/io/File:exists	()Z
    //   9: ifeq +100 -> 109
    //   12: aload_2
    //   13: invokevirtual 521	java/io/File:isFile	()Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifeq +91 -> 109
    //   21: new 523	java/io/ObjectInputStream
    //   24: dup
    //   25: new 525	java/io/FileInputStream
    //   28: dup
    //   29: aload_2
    //   30: invokespecial 526	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: invokespecial 529	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: invokevirtual 532	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   43: checkcast 100	java/util/HashMap
    //   46: astore 4
    //   48: aload_3
    //   49: ifnull +7 -> 56
    //   52: aload_3
    //   53: invokevirtual 533	java/io/ObjectInputStream:close	()V
    //   56: aload 4
    //   58: areturn
    //   59: astore 4
    //   61: aconst_null
    //   62: astore_3
    //   63: aload_3
    //   64: astore_2
    //   65: invokestatic 69	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   68: aload 4
    //   70: invokevirtual 139	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   73: pop
    //   74: aload_3
    //   75: ifnull +34 -> 109
    //   78: aload_3
    //   79: invokevirtual 533	java/io/ObjectInputStream:close	()V
    //   82: aconst_null
    //   83: areturn
    //   84: astore_2
    //   85: aconst_null
    //   86: areturn
    //   87: astore_3
    //   88: aconst_null
    //   89: astore_2
    //   90: aload_2
    //   91: ifnull +7 -> 98
    //   94: aload_2
    //   95: invokevirtual 533	java/io/ObjectInputStream:close	()V
    //   98: aload_3
    //   99: athrow
    //   100: astore_2
    //   101: invokestatic 69	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   104: aload_2
    //   105: invokevirtual 139	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   108: pop
    //   109: aconst_null
    //   110: areturn
    //   111: astore_2
    //   112: aload 4
    //   114: areturn
    //   115: astore_2
    //   116: goto -18 -> 98
    //   119: astore_3
    //   120: goto -30 -> 90
    //   123: astore 4
    //   125: goto -62 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	a
    //   16	2	1	bool	boolean
    //   4	61	2	localObject1	Object
    //   84	1	2	localThrowable1	Throwable
    //   89	6	2	localObject2	Object
    //   100	5	2	localThrowable2	Throwable
    //   111	1	2	localThrowable3	Throwable
    //   115	1	2	localThrowable4	Throwable
    //   36	43	3	localObjectInputStream	java.io.ObjectInputStream
    //   87	12	3	localObject3	Object
    //   119	1	3	localObject4	Object
    //   46	11	4	localHashMap	HashMap
    //   59	54	4	localThrowable5	Throwable
    //   123	1	4	localThrowable6	Throwable
    // Exception table:
    //   from	to	target	type
    //   21	37	59	java/lang/Throwable
    //   78	82	84	java/lang/Throwable
    //   21	37	87	finally
    //   0	17	100	java/lang/Throwable
    //   98	100	100	java/lang/Throwable
    //   52	56	111	java/lang/Throwable
    //   94	98	115	java/lang/Throwable
    //   39	48	119	finally
    //   65	74	119	finally
    //   39	48	123	java/lang/Throwable
  }
  
  /* Error */
  private void d(HashMap<String, Object> paramHashMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 518	com/mob/commons/authorize/a:b	()Ljava/io/File;
    //   4: astore 4
    //   6: new 538	java/io/ObjectOutputStream
    //   9: dup
    //   10: new 34	java/io/FileOutputStream
    //   13: dup
    //   14: aload 4
    //   16: invokespecial 51	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   19: invokespecial 539	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_3
    //   23: aload_3
    //   24: astore_2
    //   25: aload_3
    //   26: aload_1
    //   27: invokevirtual 543	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   30: aload_3
    //   31: astore_2
    //   32: aload_0
    //   33: invokespecial 545	com/mob/commons/authorize/a:c	()Ljava/io/File;
    //   36: astore_1
    //   37: aload_3
    //   38: astore_2
    //   39: aload 4
    //   41: invokevirtual 548	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   44: aload_1
    //   45: invokevirtual 548	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   48: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   51: ifne +25 -> 76
    //   54: aload_3
    //   55: astore_2
    //   56: aload_1
    //   57: invokevirtual 551	java/io/File:delete	()Z
    //   60: pop
    //   61: aload_3
    //   62: astore_2
    //   63: aload 4
    //   65: invokevirtual 548	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   68: aload_1
    //   69: invokevirtual 548	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   72: invokestatic 555	com/mob/tools/utils/ResHelper:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   75: pop
    //   76: aload_3
    //   77: ifnull +11 -> 88
    //   80: aload_3
    //   81: invokevirtual 556	java/io/ObjectOutputStream:flush	()V
    //   84: aload_3
    //   85: invokevirtual 557	java/io/ObjectOutputStream:close	()V
    //   88: return
    //   89: astore 4
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: astore_2
    //   95: invokestatic 69	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   98: aload 4
    //   100: invokevirtual 139	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   103: pop
    //   104: aload_1
    //   105: ifnull -17 -> 88
    //   108: aload_1
    //   109: invokevirtual 556	java/io/ObjectOutputStream:flush	()V
    //   112: aload_1
    //   113: invokevirtual 557	java/io/ObjectOutputStream:close	()V
    //   116: return
    //   117: astore_1
    //   118: return
    //   119: astore_1
    //   120: aconst_null
    //   121: astore_2
    //   122: aload_2
    //   123: ifnull +11 -> 134
    //   126: aload_2
    //   127: invokevirtual 556	java/io/ObjectOutputStream:flush	()V
    //   130: aload_2
    //   131: invokevirtual 557	java/io/ObjectOutputStream:close	()V
    //   134: aload_1
    //   135: athrow
    //   136: astore_2
    //   137: goto -3 -> 134
    //   140: astore_1
    //   141: goto -19 -> 122
    //   144: astore 4
    //   146: aload_3
    //   147: astore_1
    //   148: goto -55 -> 93
    //   151: astore_1
    //   152: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	a
    //   0	153	1	paramHashMap	HashMap<String, Object>
    //   24	107	2	localObject	Object
    //   136	1	2	localThrowable1	Throwable
    //   22	125	3	localObjectOutputStream	java.io.ObjectOutputStream
    //   4	60	4	localFile	File
    //   89	10	4	localThrowable2	Throwable
    //   144	1	4	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	23	89	java/lang/Throwable
    //   108	116	117	java/lang/Throwable
    //   0	23	119	finally
    //   126	134	136	java/lang/Throwable
    //   25	30	140	finally
    //   32	37	140	finally
    //   39	54	140	finally
    //   56	61	140	finally
    //   63	76	140	finally
    //   95	104	140	finally
    //   25	30	144	java/lang/Throwable
    //   32	37	144	java/lang/Throwable
    //   39	54	144	java/lang/Throwable
    //   56	61	144	java/lang/Throwable
    //   63	76	144	java/lang/Throwable
    //   80	88	151	java/lang/Throwable
  }
  
  private String e()
  {
    Object localObject;
    if (DeviceAuthorizer.a != null) {
      localObject = DeviceAuthorizer.a;
    }
    String str;
    do
    {
      return (String)localObject;
      str = f();
      localObject = str;
    } while (str != null);
    return g();
  }
  
  private String f()
  {
    try
    {
      if (com.mob.commons.a.D()) {
        return null;
      }
      DeviceHelper localDeviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
      String str2 = localDeviceHelper.getWAbcd(0);
      Object localObject = str2;
      if (TextUtils.isEmpty(str2))
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("plat", Integer.valueOf(1));
        ((HashMap)localObject).put("imei", localDeviceHelper.getIMEI());
        ((HashMap)localObject).put("serialno", localDeviceHelper.getSerialno());
        ((HashMap)localObject).put("mac", localDeviceHelper.getMacAddress());
        ((HashMap)localObject).put("model", localDeviceHelper.getModel());
        localObject = ((HashMap)new MobCommunicator(1024, "ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", "191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd").requestSynchronized((HashMap)localObject, "http://devs.data.mob.com:80/dgen", false)).get("duid");
        if (localObject != null)
        {
          localDeviceHelper.saveWabcd(String.valueOf(localObject), 0);
          localObject = String.valueOf(localObject);
          return (String)localObject;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
      String str1 = null;
      return str1;
    }
  }
  
  private String g()
  {
    DeviceHelper localDeviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
    try
    {
      String str1 = localDeviceHelper.getWAbcd(0);
      if (!TextUtils.isEmpty(str1)) {
        return str1;
      }
      str1 = localDeviceHelper.getModel();
      String str2 = localDeviceHelper.getIMEI();
      String str3 = localDeviceHelper.getMacAddress();
      String str4 = localDeviceHelper.getSerialno();
      str1 = Data.byteToHex(Data.SHA1(str1 + ":" + str2 + ":" + str3 + ":" + str4));
      localDeviceHelper.saveWabcd(str1, 0);
      return str1;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
    return null;
  }
  
  private String h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sd");
    localStringBuilder.append("k.");
    localStringBuilder.append("co");
    localStringBuilder.append("mm");
    localStringBuilder.append("on");
    localStringBuilder.append("ap");
    localStringBuilder.append(".s");
    localStringBuilder.append("dk");
    return localStringBuilder.toString();
  }
  
  private void i()
  {
    try
    {
      File localFile1 = b();
      File localFile2 = c();
      if ((localFile1.exists()) && (localFile1.isFile()))
      {
        if ((!localFile2.exists()) || (!localFile2.isFile())) {
          ResHelper.copyFile(localFile1.getAbsolutePath(), localFile2.getAbsolutePath());
        }
      }
      else if ((localFile2.exists()) && (localFile2.isFile()))
      {
        ResHelper.copyFile(localFile2.getAbsolutePath(), localFile1.getAbsolutePath());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
  }
  
  private boolean j()
  {
    boolean bool = false;
    Object localObject = ResHelper.getCacheRootFile(MobSDK.getContext(), "comm/dbs/.digap");
    if ((localObject != null) && (((File)localObject).exists())) {
      try
      {
        localObject = new DataInputStream(new FileInputStream((File)localObject));
        long l1 = ((DataInputStream)localObject).readLong();
        ((DataInputStream)localObject).close();
        long l2 = com.mob.commons.a.a();
        if (l1 < l2) {
          bool = true;
        }
        return bool;
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().d(localThrowable);
        return false;
      }
    }
    a(com.mob.commons.a.G() + com.mob.commons.a.a());
    return false;
  }
  
  final String a()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = d();
        if (localObject1 != null)
        {
          localObject1 = (String)((HashMap)localObject1).get("duid");
          Object localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = e();
          }
          return (String)localObject3;
        }
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().w(localThrowable);
        return null;
      }
      Object localObject2 = null;
    }
  }
  
  final String a(final MobProduct paramMobProduct)
  {
    final String[] arrayOfString = new String[1];
    c.a(c.a("comm/locks/.globalLock"), new LockAction()
    {
      public boolean run(FileLocker paramAnonymousFileLocker)
      {
        a.a(a.this);
        arrayOfString[0] = a.a(a.this, paramMobProduct);
        return false;
      }
    });
    return arrayOfString[0];
  }
  
  final String a(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    final String[] arrayOfString = new String[1];
    c.a(c.a("comm/locks/.globalLock"), new LockAction()
    {
      public boolean run(FileLocker paramAnonymousFileLocker)
      {
        for (;;)
        {
          try
          {
            paramAnonymousFileLocker = a.c(a.this);
            if (paramAnonymousFileLocker == null)
            {
              paramAnonymousFileLocker = new HashMap();
              String str2 = (String)paramAnonymousFileLocker.get("duid");
              String str1 = str2;
              if (str2 == null)
              {
                str1 = str2;
                if (paramBoolean2)
                {
                  str2 = a.d(a.this);
                  str1 = str2;
                  if (!paramBoolean1)
                  {
                    paramAnonymousFileLocker.put("duid", str2);
                    a.d(a.this, paramAnonymousFileLocker);
                    str1 = str2;
                  }
                }
              }
              arrayOfString[0] = str1;
              return false;
            }
          }
          catch (Throwable paramAnonymousFileLocker)
          {
            MobLog.getInstance().w(paramAnonymousFileLocker);
            return false;
          }
        }
      }
    });
    return arrayOfString[0];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/authorize/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */