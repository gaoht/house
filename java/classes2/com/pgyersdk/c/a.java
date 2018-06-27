package com.pgyersdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.pgyersdk.e.c;
import com.pgyersdk.i.h;
import com.pgyersdk.i.i;
import com.pgyersdk.i.k;
import com.pgyersdk.i.l;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a
{
  private static String a = null;
  private static String b = null;
  private static boolean c = false;
  private static Context d;
  
  private static int a(WeakReference paramWeakReference)
  {
    int i = 0;
    String[] arrayOfString = b();
    Object localObject = null;
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      if (paramWeakReference != null) {}
      for (;;)
      {
        try
        {
          paramWeakReference = (Context)paramWeakReference.get();
          if (paramWeakReference == null) {
            break label114;
          }
          paramWeakReference = Arrays.asList(paramWeakReference.getSharedPreferences("PgyerSDK", 0).getString("ConfirmedFilenames", "").split("\\|"));
        }
        catch (Exception paramWeakReference)
        {
          int k;
          int m;
          int j;
          paramWeakReference = (WeakReference)localObject;
          continue;
        }
        if (paramWeakReference != null)
        {
          k = 2;
          m = arrayOfString.length;
          j = k;
          if (i < m)
          {
            if (!paramWeakReference.contains(arrayOfString[i])) {
              j = 1;
            }
          }
          else {
            return j;
          }
          i += 1;
          continue;
        }
        return 1;
        label114:
        paramWeakReference = null;
      }
    }
    return 0;
  }
  
  private static String a(String[] paramArrayOfString, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localStringBuffer.append(paramArrayOfString[i]);
      if (i < paramArrayOfString.length - 1) {
        localStringBuffer.append(paramString);
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static void a(Context paramContext)
  {
    d = paramContext;
  }
  
  private static void a(Context paramContext, g paramg, boolean paramBoolean)
  {
    if ((com.pgyersdk.b.a.b != null) && (com.pgyersdk.b.a.c != null))
    {
      Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
      if (localUncaughtExceptionHandler != null) {
        com.pgyersdk.i.g.a("PgyerSDK", "Current handler class = " + localUncaughtExceptionHandler.getClass().getName());
      }
      if ((localUncaughtExceptionHandler instanceof b))
      {
        ((b)localUncaughtExceptionHandler).a(paramg);
        ((b)localUncaughtExceptionHandler).a(a);
        return;
      }
      Thread.setDefaultUncaughtExceptionHandler(new b(paramContext, localUncaughtExceptionHandler, paramg, paramBoolean, a));
      return;
    }
    com.pgyersdk.i.g.a("PgyerSDK", "Exception handler not set because version or package is null.");
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, g paramg)
  {
    a(paramContext, paramString1, paramString2, paramg, false);
    com.pgyersdk.a.a.c(paramContext);
    b(paramContext, paramg);
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, g paramg, boolean paramBoolean)
  {
    if (paramContext != null) {
      b = paramString1;
    }
    try
    {
      a = l.a(paramString2);
      com.pgyersdk.b.a.l = a;
      if (k.a(i.a(paramContext, "appId"))) {
        i.a(paramContext, "appId", com.pgyersdk.b.a.l);
      }
      com.pgyersdk.b.a.a(paramContext);
      if (a == null) {
        a = com.pgyersdk.b.a.c;
      }
      if (paramBoolean) {
        if ((paramg == null) || (!paramg.a())) {
          break label91;
        }
      }
      label91:
      for (paramBoolean = true;; paramBoolean = false)
      {
        a(paramContext, paramg, Boolean.valueOf(paramBoolean).booleanValue());
        return;
      }
      return;
    }
    catch (IllegalArgumentException paramContext) {}
  }
  
  private static boolean a(String paramString, Boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (!k.a(paramString))
        {
          com.pgyersdk.i.g.a("PgyerSDK", "Transmitting exception data: \n" + paramString);
          HashMap localHashMap = new HashMap();
          localHashMap.put("crashLog", paramString);
          if (!paramBoolean.booleanValue()) {
            break label526;
          }
          paramString = "2";
          localHashMap.put("isException", paramString);
          localHashMap.put("versionCode", com.pgyersdk.b.a.b);
          localHashMap.put("version", com.pgyersdk.b.a.d);
          localHashMap.put("agKey", a);
          localHashMap.put("deviceId", com.pgyersdk.b.a.i);
          localHashMap.put("deviceName", com.pgyersdk.b.a.g);
          localHashMap.put("deviceModel", com.pgyersdk.b.a.f);
          localHashMap.put("osVersion", com.pgyersdk.b.a.e);
          localHashMap.put("resolution", com.pgyersdk.b.a.j);
          localHashMap.put("osType", "2");
          if (com.pgyersdk.b.a.a())
          {
            paramString = "1";
            localHashMap.put("jailBroken", paramString);
            paramString = com.pgyersdk.e.a.a();
            localHashMap.put("freeSpace", paramString[1] + " / " + paramString[0]);
            if (com.pgyersdk.e.a.c())
            {
              paramString = com.pgyersdk.e.a.b();
              localHashMap.put("freeSdc", paramString[1] + " / " + paramString[0]);
            }
            paramBoolean = com.pgyersdk.e.a.b(d);
            paramString = "";
            if (paramBoolean.length == 2) {
              paramString = paramBoolean[1] + " / " + paramBoolean[0];
            }
            localHashMap.put("freeRam", paramString);
            localHashMap.put("protrait", d.getResources().getConfiguration().orientation + "");
            paramString = "";
            paramBoolean = com.pgyersdk.e.a.a(d);
            if (paramBoolean.containsKey("network_type")) {
              paramString = (String)paramBoolean.get("network_type");
            }
            localHashMap.put("network", paramString);
            localHashMap.put("sdkVersion", com.pgyersdk.b.a.k);
            localHashMap.put("_api_key", "305092bc73c180b55c26012a94809131");
            int i = new com.pgyersdk.i.e("http://www.pgyer.com/apiv1/crash/add").a("POST").a(localHashMap, d, null, null).a().getResponseCode();
            if (i == 202) {
              break label524;
            }
            if (i == 201) {
              break label524;
            }
          }
          else
          {
            paramString = "2";
            continue;
          }
          return false;
        }
      }
      catch (Exception paramString)
      {
        paramString = paramString;
        paramString.printStackTrace();
        return false;
      }
      finally {}
      return false;
      label524:
      return true;
      label526:
      paramString = "1";
    }
  }
  
  private static void b(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      String[] arrayOfString = b();
      paramContext = paramContext.getSharedPreferences("PgyerSDK", 0).edit();
      paramContext.putString("ConfirmedFilenames", a(arrayOfString, "|"));
      h.a(paramContext);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private static void b(Context paramContext, g paramg)
  {
    if ((paramg != null) && (paramg.a())) {}
    Boolean localBoolean;
    int i;
    for (boolean bool = true;; bool = false)
    {
      localBoolean = Boolean.valueOf(bool);
      i = a(new WeakReference(paramContext));
      if (i != 1) {
        break;
      }
      if (paramg != null)
      {
        Boolean.valueOf(Boolean.valueOf(false).booleanValue() | paramg.g()).booleanValue();
        paramg.h();
        paramg.i();
      }
      b(paramContext, paramg, localBoolean.booleanValue());
      return;
    }
    if (i == 2)
    {
      if (paramg != null) {
        paramg.j();
      }
      b(paramContext, paramg, localBoolean.booleanValue());
      return;
    }
    a(paramContext, paramg, localBoolean.booleanValue());
  }
  
  private static void b(Context paramContext, g paramg, boolean paramBoolean)
  {
    b(paramContext);
    a(paramContext, paramg, paramBoolean);
    if (!c)
    {
      c = true;
      new e(paramContext, paramg).start();
    }
  }
  
  private static void b(Context paramContext, String paramString)
  {
    try
    {
      boolean bool = a(paramString, Boolean.valueOf(true));
      if (bool)
      {
        com.pgyersdk.i.g.a("PgyerSDK", "Transmission succeeded");
        return;
      }
      com.pgyersdk.i.g.a("PgyerSDK", "Transmission failed");
      return;
    }
    catch (Exception paramContext)
    {
      paramContext = paramContext;
      com.pgyersdk.i.g.a("PgyerSDK", "Transmission failed");
      return;
    }
    finally
    {
      paramContext = finally;
      com.pgyersdk.i.g.a("PgyerSDK", "Transmission failed");
      throw paramContext;
    }
  }
  
  private static String[] b()
  {
    if (com.pgyersdk.b.a.a != null)
    {
      com.pgyersdk.i.g.a("PgyerSDK", "Looking for exceptions in: " + com.pgyersdk.b.a.a);
      File localFile = new File(com.pgyersdk.b.a.a + "/");
      if ((!localFile.mkdir()) && (!localFile.exists())) {
        return new String[0];
      }
      return localFile.list(new f());
    }
    com.pgyersdk.i.g.a("PgyerSDK", "Can't search for exception as file path is null.");
    return null;
  }
  
  private static void c(Context paramContext, g paramg)
  {
    int i = 0;
    String[] arrayOfString = b();
    Object localObject1 = Boolean.valueOf(false);
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      com.pgyersdk.i.g.a("PgyerSDK", "Found " + arrayOfString.length + " stacktrace(s).");
      if (i < arrayOfString.length) {
        for (;;)
        {
          try
          {
            localObject4 = d(paramContext, arrayOfString[i]);
            localObject2 = localObject1;
            if (((String)localObject4).length() > 0)
            {
              boolean bool = a((String)localObject4, Boolean.valueOf(false));
              localObject2 = Boolean.valueOf(bool);
            }
            if (!((Boolean)localObject2).booleanValue()) {
              continue;
            }
            com.pgyersdk.i.g.a("PgyerSDK", "Transmission succeeded");
            c(paramContext, arrayOfString[i]);
            localObject4 = localObject2;
            if (paramg != null)
            {
              paramg.k();
              localObject4 = localObject2;
            }
          }
          catch (Exception localException)
          {
            Object localObject2;
            localException.printStackTrace();
            if (!((Boolean)localObject1).booleanValue()) {
              continue;
            }
            com.pgyersdk.i.g.a("PgyerSDK", "Transmission succeeded");
            c(paramContext, arrayOfString[i]);
            Object localObject4 = localObject1;
            if (paramg == null) {
              continue;
            }
            paramg.k();
            localObject4 = localObject1;
            continue;
            com.pgyersdk.i.g.a("PgyerSDK", "Transmission failed, will retry on next register() call");
            localObject4 = localObject1;
            if (paramg == null) {
              continue;
            }
            paramg.l();
            localObject4 = localObject1;
            continue;
          }
          finally
          {
            if (!((Boolean)localObject1).booleanValue()) {
              continue;
            }
            com.pgyersdk.i.g.a("PgyerSDK", "Transmission succeeded");
            c(paramContext, arrayOfString[i]);
            if (paramg == null) {
              continue;
            }
            paramg.k();
            throw ((Throwable)localObject3);
            com.pgyersdk.i.g.a("PgyerSDK", "Transmission failed, will retry on next register() call");
            if (paramg == null) {
              continue;
            }
            paramg.l();
            continue;
          }
          i += 1;
          localObject1 = localObject4;
          break;
          com.pgyersdk.i.g.a("PgyerSDK", "Transmission failed, will retry on next register() call");
          localObject4 = localObject2;
          if (paramg != null)
          {
            paramg.l();
            localObject4 = localObject2;
          }
        }
      }
    }
  }
  
  private static void c(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      paramContext.deleteFile(paramString);
      paramContext.deleteFile(paramString.replace(".stacktrace", ".user"));
      paramContext.deleteFile(paramString.replace(".stacktrace", ".contact"));
      paramContext.deleteFile(paramString.replace(".stacktrace", ".description"));
    }
  }
  
  /* Error */
  private static String d(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: ifnull +84 -> 89
    //   8: new 106	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   15: astore 4
    //   17: new 457	java/io/BufferedReader
    //   20: dup
    //   21: new 459	java/io/InputStreamReader
    //   24: dup
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 463	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   30: invokespecial 466	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   33: invokespecial 469	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   36: astore_0
    //   37: aload_0
    //   38: astore_1
    //   39: aload_0
    //   40: invokevirtual 472	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull +46 -> 91
    //   48: aload_0
    //   49: astore_1
    //   50: aload 4
    //   52: aload_2
    //   53: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_0
    //   58: astore_1
    //   59: aload 4
    //   61: ldc_w 474
    //   64: invokestatic 479	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   67: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: goto -34 -> 37
    //   74: astore_1
    //   75: aload_0
    //   76: ifnull +7 -> 83
    //   79: aload_0
    //   80: invokevirtual 482	java/io/BufferedReader:close	()V
    //   83: aload 4
    //   85: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore_2
    //   89: aload_2
    //   90: areturn
    //   91: aload_0
    //   92: ifnull -9 -> 83
    //   95: aload_0
    //   96: invokevirtual 482	java/io/BufferedReader:close	()V
    //   99: goto -16 -> 83
    //   102: astore_0
    //   103: goto -20 -> 83
    //   106: astore_2
    //   107: aconst_null
    //   108: astore_0
    //   109: aload_0
    //   110: astore_1
    //   111: aload_2
    //   112: invokevirtual 483	java/io/IOException:printStackTrace	()V
    //   115: aload_0
    //   116: ifnull -33 -> 83
    //   119: aload_0
    //   120: invokevirtual 482	java/io/BufferedReader:close	()V
    //   123: goto -40 -> 83
    //   126: astore_0
    //   127: goto -44 -> 83
    //   130: astore_0
    //   131: aconst_null
    //   132: astore_1
    //   133: aload_1
    //   134: ifnull +7 -> 141
    //   137: aload_1
    //   138: invokevirtual 482	java/io/BufferedReader:close	()V
    //   141: aload_0
    //   142: athrow
    //   143: astore_0
    //   144: goto -61 -> 83
    //   147: astore_1
    //   148: goto -7 -> 141
    //   151: astore_0
    //   152: goto -19 -> 133
    //   155: astore_2
    //   156: goto -47 -> 109
    //   159: astore_0
    //   160: aload_3
    //   161: astore_0
    //   162: goto -87 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	paramContext	Context
    //   0	165	1	paramString	String
    //   1	89	2	str	String
    //   106	6	2	localIOException1	java.io.IOException
    //   155	1	2	localIOException2	java.io.IOException
    //   3	158	3	localObject	Object
    //   15	69	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   39	44	74	java/io/FileNotFoundException
    //   50	57	74	java/io/FileNotFoundException
    //   59	71	74	java/io/FileNotFoundException
    //   95	99	102	java/io/IOException
    //   17	37	106	java/io/IOException
    //   119	123	126	java/io/IOException
    //   17	37	130	finally
    //   79	83	143	java/io/IOException
    //   137	141	147	java/io/IOException
    //   39	44	151	finally
    //   50	57	151	finally
    //   59	71	151	finally
    //   111	115	151	finally
    //   39	44	155	java/io/IOException
    //   50	57	155	java/io/IOException
    //   59	71	155	java/io/IOException
    //   17	37	159	java/io/FileNotFoundException
  }
  
  public static void register(Context paramContext)
  {
    try
    {
      c.a(paramContext);
      a(paramContext);
      a(paramContext, "http://www.pgyer.com/", com.pgyersdk.b.a.l, null);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void reportCaughtException(Context paramContext, Exception paramException)
  {
    int i = 0;
    c.a(paramContext);
    a(d, b, com.pgyersdk.b.a.l, null, false);
    paramContext = new StringBuilder();
    paramContext.append(paramException.toString());
    paramException = paramException.getStackTrace();
    int j = paramException.length;
    while (i < j)
    {
      Object localObject = paramException[i];
      paramContext.append("\r\n");
      paramContext.append(localObject);
      i += 1;
    }
    new d(paramContext).start();
  }
  
  public static void unregister()
  {
    try
    {
      com.pgyersdk.e.a.f(d);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */