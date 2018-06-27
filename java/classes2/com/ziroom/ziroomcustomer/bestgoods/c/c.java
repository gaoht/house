package com.ziroom.ziroomcustomer.bestgoods.c;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.alibaba.fastjson.e;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.freelxl.baselibrary.f.h;
import com.ziroom.commonlibrary.login.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.util.ae;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c
{
  public static Proxy createProxy(String paramString, int paramInt)
    throws UnknownHostException
  {
    Matcher localMatcher = Pattern.compile("(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})").matcher(paramString);
    if ((localMatcher != null) && (localMatcher.find())) {}
    for (paramString = InetAddress.getByAddress(paramString, new byte[] { (byte)Integer.parseInt(localMatcher.group(1)), (byte)Integer.parseInt(localMatcher.group(2)), (byte)Integer.parseInt(localMatcher.group(3)), (byte)Integer.parseInt(localMatcher.group(4)) });; paramString = InetAddress.getByName(paramString)) {
      return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(paramString, paramInt));
    }
  }
  
  public static Map<String, String> getHeaderMap(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    String str1 = a.getUid(ApplicationEx.c);
    String str2 = a.getToken(ApplicationEx.c);
    localHashMap.put("Client-Version", h.getAppVersion(ApplicationEx.c));
    localHashMap.put("Client-Type", "1");
    localHashMap.put("User-Agent", ad.getUserAgent(paramContext));
    if (ae.notNull(str1)) {
      localHashMap.put("uid", str1);
    }
    if (ae.notNull(str2)) {
      localHashMap.put("token", str2);
    }
    localHashMap.put("source", "1");
    if (ae.notNull(com.ziroom.ziroomcustomer.minsu.b.c.a)) {
      localHashMap.put("cityCode", com.ziroom.ziroomcustomer.minsu.b.c.a);
    }
    localHashMap.put("traceInfo", e.toJSONString(new e(ad.getPhoneInfo()), new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static int getNetType(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        break label30;
      }
      paramContext = paramContext.getActiveNetworkInfo();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        label30:
        paramContext = null;
      }
    }
    if (paramContext == null) {
      return 0;
    }
    int i;
    if (paramContext.isConnectedOrConnecting())
    {
      i = paramContext.getType();
      if (i == 0) {
        i = 16;
      }
    }
    for (;;)
    {
      return i;
      if (i == 1) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  /* Error */
  public static Proxy getProxy(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 191	com/ziroom/ziroomcustomer/bestgoods/c/c:isWifiConnected	(Landroid/content/Context;)Z
    //   4: ifne +12 -> 16
    //   7: aload_0
    //   8: invokestatic 194	com/ziroom/ziroomcustomer/bestgoods/c/c:isNetworkConnected	(Landroid/content/Context;)Z
    //   11: istore_3
    //   12: iload_3
    //   13: ifne +21 -> 34
    //   16: iconst_0
    //   17: ifeq +11 -> 28
    //   20: new 196	java/lang/NullPointerException
    //   23: dup
    //   24: invokespecial 197	java/lang/NullPointerException:<init>	()V
    //   27: athrow
    //   28: aconst_null
    //   29: astore 5
    //   31: aload 5
    //   33: areturn
    //   34: ldc -57
    //   36: invokestatic 205	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   39: astore 4
    //   41: aload_0
    //   42: invokevirtual 209	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   45: aload 4
    //   47: aconst_null
    //   48: aconst_null
    //   49: aconst_null
    //   50: aconst_null
    //   51: invokevirtual 215	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   54: astore_0
    //   55: aload_0
    //   56: ifnull +98 -> 154
    //   59: aload_0
    //   60: invokeinterface 220 1 0
    //   65: ifeq +89 -> 154
    //   68: aload_0
    //   69: aload_0
    //   70: ldc -34
    //   72: invokeinterface 225 2 0
    //   77: invokeinterface 228 2 0
    //   82: astore 4
    //   84: aload_0
    //   85: aload_0
    //   86: ldc -26
    //   88: invokeinterface 225 2 0
    //   93: invokeinterface 234 2 0
    //   98: istore_2
    //   99: aload 4
    //   101: ifnull +53 -> 154
    //   104: aload 4
    //   106: invokevirtual 240	java/lang/String:trim	()Ljava/lang/String;
    //   109: invokevirtual 243	java/lang/String:length	()I
    //   112: ifle +42 -> 154
    //   115: iload_2
    //   116: istore_1
    //   117: iload_2
    //   118: iconst_m1
    //   119: if_icmpne +6 -> 125
    //   122: bipush 80
    //   124: istore_1
    //   125: aload 4
    //   127: iload_1
    //   128: invokestatic 245	com/ziroom/ziroomcustomer/bestgoods/c/c:createProxy	(Ljava/lang/String;I)Ljava/net/Proxy;
    //   131: astore 4
    //   133: aload 4
    //   135: astore 5
    //   137: aload_0
    //   138: ifnull -107 -> 31
    //   141: aload_0
    //   142: invokeinterface 248 1 0
    //   147: aload 4
    //   149: areturn
    //   150: astore_0
    //   151: aload 4
    //   153: areturn
    //   154: aload_0
    //   155: ifnull +9 -> 164
    //   158: aload_0
    //   159: invokeinterface 248 1 0
    //   164: aconst_null
    //   165: areturn
    //   166: astore_0
    //   167: aconst_null
    //   168: astore_0
    //   169: aload_0
    //   170: ifnull +9 -> 179
    //   173: aload_0
    //   174: invokeinterface 248 1 0
    //   179: aconst_null
    //   180: areturn
    //   181: astore 4
    //   183: aconst_null
    //   184: astore_0
    //   185: aload_0
    //   186: ifnull +9 -> 195
    //   189: aload_0
    //   190: invokeinterface 248 1 0
    //   195: aload 4
    //   197: athrow
    //   198: astore_0
    //   199: goto -171 -> 28
    //   202: astore_0
    //   203: goto -39 -> 164
    //   206: astore_0
    //   207: goto -28 -> 179
    //   210: astore_0
    //   211: goto -16 -> 195
    //   214: astore 4
    //   216: goto -31 -> 185
    //   219: astore 4
    //   221: goto -52 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	paramContext	Context
    //   116	12	1	i	int
    //   98	22	2	j	int
    //   11	2	3	bool	boolean
    //   39	113	4	localObject1	Object
    //   181	15	4	localObject2	Object
    //   214	1	4	localObject3	Object
    //   219	1	4	localException	Exception
    //   29	107	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   141	147	150	java/lang/Exception
    //   0	12	166	java/lang/Exception
    //   34	55	166	java/lang/Exception
    //   0	12	181	finally
    //   34	55	181	finally
    //   20	28	198	java/lang/Exception
    //   158	164	202	java/lang/Exception
    //   173	179	206	java/lang/Exception
    //   189	195	210	java/lang/Exception
    //   59	99	214	finally
    //   104	115	214	finally
    //   125	133	214	finally
    //   59	99	219	java/lang/Exception
    //   104	115	219	java/lang/Exception
    //   125	133	219	java/lang/Exception
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext == null) {
          continue;
        }
        paramContext = paramContext.getActiveNetworkInfo();
        if (paramContext == null) {
          continue;
        }
        bool = paramContext.isConnected();
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        boolean bool = false;
        continue;
      }
      finally {}
      return bool;
      bool = false;
    }
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext == null) {
          continue;
        }
        paramContext = paramContext.getActiveNetworkInfo();
        if (paramContext == null) {
          continue;
        }
        int i = paramContext.getType();
        if ((i != 1) && (i != 9)) {
          continue;
        }
        bool = paramContext.isConnected();
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        boolean bool = false;
        continue;
      }
      finally {}
      return bool;
      bool = false;
    }
  }
  
  public static void printLog(Activity paramActivity, Map<String, String> paramMap, String paramString) {}
  
  public static void setCommonParameter(Map paramMap)
  {
    String str2 = a.getUid(ApplicationEx.c);
    if (!paramMap.containsKey("uid"))
    {
      String str1 = str2;
      if (ae.isNull(str2)) {
        str1 = "";
      }
      paramMap.put("uid", str1);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */