package com.mob.commons;

import com.mob.MobSDK;
import com.mob.a;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.DeviceHelper;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class MobProductCollector
  implements PublicMemberKeeper
{
  public static final String[] MOB_PRODUCTS = { "SHARESDK", "SMSSDK", "SHAREREC", "MOBAPI", "MOBLINK", "UMSSDK", "CMSSDK", "BBSSDK", "SHOPSDK", "PAYSDK", "MOBIM", "MOBPUSH", "ANALYSDK" };
  private static boolean a = false;
  private static final HashMap<String, MobProduct> b = new HashMap();
  
  public static void collect()
  {
    try
    {
      getProducts();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static ArrayList<MobProduct> getProducts()
  {
    try
    {
      if (!a)
      {
        b.putAll(MobProductParser.parse());
        a = true;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(b.values());
      return localArrayList;
    }
    finally {}
  }
  
  public static String getUserIdentity()
  {
    try
    {
      String str = getUserIdentity(getProducts());
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String getUserIdentity(ArrayList<MobProduct> paramArrayList)
  {
    for (;;)
    {
      try
      {
        localObject1 = DeviceHelper.getInstance(MobSDK.getContext());
        str1 = URLEncoder.encode(((DeviceHelper)localObject1).getPackageName(), "utf-8");
        str2 = URLEncoder.encode(((DeviceHelper)localObject1).getAppVersionName(), "utf-8");
        localObject3 = URLEncoder.encode(((DeviceHelper)localObject1).getManufacturer(), "utf-8");
        localObject4 = URLEncoder.encode(((DeviceHelper)localObject1).getModel(), "utf-8");
        str1 = "APP/" + str1 + ";" + str2;
        str2 = "SYS/Android;" + ((DeviceHelper)localObject1).getOSVersionInt();
        str3 = "SDI/" + ((DeviceHelper)localObject1).getDeviceKey();
        str4 = "FM/" + (String)localObject3 + ";" + (String)localObject4;
        str5 = "NE/" + ((DeviceHelper)localObject1).getNetworkTypeForStatic() + ";" + ((DeviceHelper)localObject1).getCarrier();
        str6 = "Lang/" + Locale.getDefault().toString().replace("-r", "-");
        str7 = "CLV/" + a.a;
        localObject1 = "SDK/";
        localObject3 = localObject1;
        if (!paramArrayList.isEmpty())
        {
          int j = paramArrayList.size();
          i = 0;
          localObject3 = localObject1;
          if (i < j) {
            localObject3 = localObject1;
          }
        }
      }
      catch (Throwable paramArrayList)
      {
        Object localObject1;
        String str1;
        String str2;
        Object localObject4;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int i;
        MobProduct localMobProduct;
        MobLog.getInstance().w(paramArrayList);
        paramArrayList = "";
        continue;
      }
      finally {}
      try
      {
        localMobProduct = (MobProduct)paramArrayList.get(i);
        localObject4 = localObject1;
        if (i != 0)
        {
          localObject3 = localObject1;
          localObject4 = (String)localObject1 + ",";
        }
        localObject3 = localObject4;
        localObject1 = (String)localObject4 + localMobProduct.getProductTag() + ";" + localMobProduct.getSdkver();
      }
      catch (Throwable localThrowable)
      {
        Object localObject2 = localObject3;
        continue;
      }
      i += 1;
    }
    paramArrayList = str1 + " " + str2 + " " + str3 + " " + str4 + " " + str5 + " " + str6 + " " + str7 + " " + (String)localObject3;
    return paramArrayList;
  }
  
  /* Error */
  public static boolean registerProduct(MobProduct paramMobProduct)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +39 -> 43
    //   7: getstatic 54	com/mob/commons/MobProductCollector:b	Ljava/util/HashMap;
    //   10: aload_0
    //   11: invokeinterface 205 1 0
    //   16: invokevirtual 230	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   19: ifne +24 -> 43
    //   22: getstatic 54	com/mob/commons/MobProductCollector:b	Ljava/util/HashMap;
    //   25: aload_0
    //   26: invokeinterface 205 1 0
    //   31: aload_0
    //   32: invokevirtual 234	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: pop
    //   36: iconst_1
    //   37: istore_1
    //   38: ldc 2
    //   40: monitorexit
    //   41: iload_1
    //   42: ireturn
    //   43: iconst_0
    //   44: istore_1
    //   45: goto -7 -> 38
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	paramMobProduct	MobProduct
    //   37	8	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   7	36	48	finally
  }
  
  public static void syncInit()
  {
    try
    {
      MOBLINK localMOBLINK = new MOBLINK();
      if ((localMOBLINK instanceof MobProduct)) {
        localMOBLINK.getProductTag();
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/MobProductCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */