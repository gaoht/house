package com.mob.tools.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.UiModeManager;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class DeviceHelper
{
  private static DeviceHelper deviceHelper;
  private String advertiseID;
  private Context context;
  private String fixedString = null;
  private String imei;
  private String[] invalidMacList;
  private String serialno;
  private String wifimac;
  
  private DeviceHelper(Context paramContext)
  {
    this.context = paramContext.getApplicationContext();
  }
  
  private boolean checkMacIsValid(String paramString)
  {
    if (paramString != null) {
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty(paramString.trim())) {
            return false;
          }
          if (this.invalidMacList == null) {
            this.invalidMacList = getInvalidMacList();
          }
          String[] arrayOfString = this.invalidMacList;
          if (arrayOfString == null)
          {
            arrayOfString = new String[] { Strings.getString(70), Strings.getString(71) };
            int j = arrayOfString.length;
            int i = 0;
            if (i < j)
            {
              String str = arrayOfString[i];
              if (str != null)
              {
                boolean bool = paramString.trim().startsWith(str.trim());
                if (bool) {
                  break;
                }
              }
              i += 1;
            }
            else
            {
              return true;
            }
          }
        }
        catch (Throwable paramString)
        {
          MobLog.getInstance().d(paramString);
        }
      }
    }
    return false;
  }
  
  /* Error */
  public static Object currentActivityThread()
  {
    // Byte code:
    //   0: new 6	com/mob/tools/utils/DeviceHelper$1
    //   3: dup
    //   4: invokespecial 87	com/mob/tools/utils/DeviceHelper$1:<init>	()V
    //   7: astore_2
    //   8: invokestatic 93	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   11: invokevirtual 97	java/lang/Thread:getId	()J
    //   14: invokestatic 103	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   17: invokevirtual 106	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   20: invokevirtual 97	java/lang/Thread:getId	()J
    //   23: lcmp
    //   24: ifne +11 -> 35
    //   27: aload_2
    //   28: aconst_null
    //   29: invokeinterface 112 2 0
    //   34: areturn
    //   35: new 4	java/lang/Object
    //   38: dup
    //   39: invokespecial 30	java/lang/Object:<init>	()V
    //   42: astore_0
    //   43: iconst_1
    //   44: anewarray 4	java/lang/Object
    //   47: astore_1
    //   48: aload_0
    //   49: monitorenter
    //   50: iconst_0
    //   51: new 8	com/mob/tools/utils/DeviceHelper$2
    //   54: dup
    //   55: aload_0
    //   56: aload_1
    //   57: aload_2
    //   58: invokespecial 115	com/mob/tools/utils/DeviceHelper$2:<init>	(Ljava/lang/Object;[Ljava/lang/Object;Lcom/mob/tools/utils/ReflectHelper$ReflectRunnable;)V
    //   61: invokestatic 121	com/mob/tools/utils/UIHandler:sendEmptyMessage	(ILandroid/os/Handler$Callback;)Z
    //   64: pop
    //   65: aload_0
    //   66: invokevirtual 124	java/lang/Object:wait	()V
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: iconst_0
    //   73: aaload
    //   74: areturn
    //   75: astore_2
    //   76: invokestatic 78	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   79: aload_2
    //   80: invokevirtual 127	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   83: pop
    //   84: goto -15 -> 69
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   42	47	0	localObject1	Object
    //   47	25	1	arrayOfObject	Object[]
    //   87	4	1	localObject2	Object
    //   7	51	2	local1	1
    //   75	5	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   65	69	75	java/lang/Throwable
    //   50	65	87	finally
    //   65	69	87	finally
    //   69	71	87	finally
    //   76	84	87	finally
    //   88	90	87	finally
  }
  
  private String genDeviceKey()
  {
    try
    {
      String str1 = getMacAddress();
      String str2 = getDeviceId();
      String str3 = getModel();
      str1 = Data.byteToHex(Data.SHA1(str1 + ":" + str2 + ":" + str3));
      return str1;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
    return null;
  }
  
  public static Context getApplication()
  {
    try
    {
      Object localObject = currentActivityThread();
      if (localObject != null)
      {
        localObject = (Context)ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(33), new Object[0]);
        return (Context)localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
    return null;
  }
  
  private String getCurrentNetworkHardwareAddress()
    throws Throwable
  {
    Object localObject1 = NetworkInterface.getNetworkInterfaces();
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = Collections.list((Enumeration)localObject1).iterator();
    break label64;
    label21:
    NetworkInterface localNetworkInterface;
    Iterator localIterator;
    while (((Iterator)localObject2).hasNext())
    {
      localNetworkInterface = (NetworkInterface)((Iterator)localObject2).next();
      localObject1 = localNetworkInterface.getInetAddresses();
      if (localObject1 != null) {
        localIterator = Collections.list((Enumeration)localObject1).iterator();
      }
    }
    for (;;)
    {
      label64:
      if (!localIterator.hasNext()) {
        break label21;
      }
      localObject1 = (InetAddress)localIterator.next();
      if ((((InetAddress)localObject1).isLoopbackAddress()) || (!(localObject1 instanceof Inet4Address))) {
        break;
      }
      if (Build.VERSION.SDK_INT >= 9) {}
      for (localObject1 = localNetworkInterface.getHardwareAddress(); localObject1 != null; localObject1 = null)
      {
        localObject2 = new StringBuilder();
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          ((StringBuilder)localObject2).append(String.format("%02x:", new Object[] { Byte.valueOf(localObject1[i]) }));
          i += 1;
        }
        if (((StringBuilder)localObject2).length() > 0) {
          ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
        }
        return ((StringBuilder)localObject2).toString();
        return null;
      }
    }
  }
  
  /* Error */
  private String getDeviceKeyWithDuid(String paramString)
    throws Throwable
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/mob/tools/utils/DeviceHelper:context	Landroid/content/Context;
    //   4: aload_1
    //   5: invokestatic 245	com/mob/tools/utils/ResHelper:getCacheRootFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull +122 -> 132
    //   13: aload_1
    //   14: invokevirtual 250	java/io/File:exists	()Z
    //   17: ifeq +115 -> 132
    //   20: aload_1
    //   21: invokevirtual 253	java/io/File:isFile	()Z
    //   24: istore_2
    //   25: iload_2
    //   26: ifeq +106 -> 132
    //   29: new 255	java/io/ObjectInputStream
    //   32: dup
    //   33: new 257	java/io/FileInputStream
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 260	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   41: invokespecial 263	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: astore_3
    //   45: aload_3
    //   46: astore_1
    //   47: aload_3
    //   48: invokevirtual 266	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   51: checkcast 268	java/util/HashMap
    //   54: astore 4
    //   56: aload 4
    //   58: astore_1
    //   59: aload_3
    //   60: ifnull +10 -> 70
    //   63: aload_3
    //   64: invokevirtual 271	java/io/ObjectInputStream:close	()V
    //   67: aload 4
    //   69: astore_1
    //   70: aload_1
    //   71: ifnonnull +66 -> 137
    //   74: aconst_null
    //   75: areturn
    //   76: astore 4
    //   78: aconst_null
    //   79: astore_3
    //   80: aload_3
    //   81: astore_1
    //   82: invokestatic 78	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   85: aload 4
    //   87: invokevirtual 127	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   90: pop
    //   91: aload_3
    //   92: ifnull +40 -> 132
    //   95: aload_3
    //   96: invokevirtual 271	java/io/ObjectInputStream:close	()V
    //   99: aconst_null
    //   100: astore_1
    //   101: goto -31 -> 70
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_1
    //   107: goto -37 -> 70
    //   110: astore_3
    //   111: aconst_null
    //   112: astore_1
    //   113: aload_1
    //   114: ifnull +7 -> 121
    //   117: aload_1
    //   118: invokevirtual 271	java/io/ObjectInputStream:close	()V
    //   121: aload_3
    //   122: athrow
    //   123: astore_1
    //   124: invokestatic 78	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   127: aload_1
    //   128: invokevirtual 127	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   131: pop
    //   132: aconst_null
    //   133: astore_1
    //   134: goto -64 -> 70
    //   137: aload_1
    //   138: ldc_w 273
    //   141: invokevirtual 276	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   144: checkcast 268	java/util/HashMap
    //   147: astore 5
    //   149: aload 5
    //   151: ifnull -77 -> 74
    //   154: aload 5
    //   156: ldc_w 278
    //   159: invokevirtual 276	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   162: checkcast 47	java/lang/String
    //   165: astore 4
    //   167: aload 5
    //   169: ldc_w 279
    //   172: invokevirtual 276	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   175: checkcast 47	java/lang/String
    //   178: astore_3
    //   179: aload_3
    //   180: astore_1
    //   181: aload_3
    //   182: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   185: ifeq +25 -> 210
    //   188: aload_3
    //   189: astore_1
    //   190: getstatic 212	android/os/Build$VERSION:SDK_INT	I
    //   193: bipush 9
    //   195: if_icmplt +15 -> 210
    //   198: aload 5
    //   200: ldc_w 280
    //   203: invokevirtual 276	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   206: checkcast 47	java/lang/String
    //   209: astore_1
    //   210: aload 5
    //   212: ldc_w 282
    //   215: invokevirtual 276	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   218: checkcast 47	java/lang/String
    //   221: astore_3
    //   222: new 139	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   229: aload 4
    //   231: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: ldc -110
    //   236: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_1
    //   240: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc -110
    //   245: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_3
    //   249: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 155	com/mob/tools/utils/Data:SHA1	(Ljava/lang/String;)[B
    //   258: invokestatic 159	com/mob/tools/utils/Data:byteToHex	([B)Ljava/lang/String;
    //   261: astore_1
    //   262: aload_1
    //   263: areturn
    //   264: astore_1
    //   265: invokestatic 78	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   268: aload_1
    //   269: invokevirtual 84	com/mob/tools/log/NLog:d	(Ljava/lang/Throwable;)I
    //   272: pop
    //   273: aconst_null
    //   274: areturn
    //   275: astore_1
    //   276: aload 4
    //   278: astore_1
    //   279: goto -209 -> 70
    //   282: astore_1
    //   283: goto -162 -> 121
    //   286: astore_3
    //   287: goto -174 -> 113
    //   290: astore 4
    //   292: goto -212 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	DeviceHelper
    //   0	295	1	paramString	String
    //   24	2	2	bool	boolean
    //   44	52	3	localObjectInputStream	ObjectInputStream
    //   110	12	3	localObject1	Object
    //   178	71	3	str1	String
    //   286	1	3	localObject2	Object
    //   54	14	4	localHashMap1	HashMap
    //   76	10	4	localThrowable1	Throwable
    //   165	112	4	str2	String
    //   290	1	4	localThrowable2	Throwable
    //   147	64	5	localHashMap2	HashMap
    // Exception table:
    //   from	to	target	type
    //   29	45	76	java/lang/Throwable
    //   95	99	104	java/lang/Throwable
    //   29	45	110	finally
    //   0	9	123	java/lang/Throwable
    //   13	25	123	java/lang/Throwable
    //   121	123	123	java/lang/Throwable
    //   154	179	264	java/lang/Throwable
    //   181	188	264	java/lang/Throwable
    //   190	210	264	java/lang/Throwable
    //   210	262	264	java/lang/Throwable
    //   63	67	275	java/lang/Throwable
    //   117	121	282	java/lang/Throwable
    //   47	56	286	finally
    //   82	91	286	finally
    //   47	56	290	java/lang/Throwable
  }
  
  /* Error */
  private String getHardwareAddressFromShell(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: bipush 42
    //   4: invokestatic 69	com/mob/tools/utils/Strings:getString	(I)Ljava/lang/String;
    //   7: invokestatic 286	com/mob/tools/utils/ReflectHelper:importClass	(Ljava/lang/String;)Ljava/lang/String;
    //   10: bipush 43
    //   12: invokestatic 69	com/mob/tools/utils/Strings:getString	(I)Ljava/lang/String;
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 290	com/mob/tools/utils/ReflectHelper:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   22: astore_2
    //   23: new 139	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   30: bipush 6
    //   32: invokestatic 69	com/mob/tools/utils/Strings:getString	(I)Ljava/lang/String;
    //   35: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: bipush 7
    //   44: invokestatic 69	com/mob/tools/utils/Strings:getString	(I)Ljava/lang/String;
    //   47: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: astore_1
    //   54: new 292	java/io/BufferedReader
    //   57: dup
    //   58: new 294	java/io/InputStreamReader
    //   61: dup
    //   62: aload_2
    //   63: bipush 44
    //   65: invokestatic 69	com/mob/tools/utils/Strings:getString	(I)Ljava/lang/String;
    //   68: iconst_1
    //   69: anewarray 4	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload_1
    //   75: aastore
    //   76: invokestatic 168	com/mob/tools/utils/ReflectHelper:invokeInstanceMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   79: bipush 45
    //   81: invokestatic 69	com/mob/tools/utils/Strings:getString	(I)Ljava/lang/String;
    //   84: iconst_0
    //   85: anewarray 4	java/lang/Object
    //   88: invokestatic 168	com/mob/tools/utils/ReflectHelper:invokeInstanceMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   91: checkcast 296	java/io/InputStream
    //   94: invokespecial 297	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   97: invokespecial 300	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   100: astore_2
    //   101: aload_2
    //   102: astore_1
    //   103: aload_2
    //   104: invokevirtual 303	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   107: astore_3
    //   108: aload_3
    //   109: astore_1
    //   110: aload_2
    //   111: ifnull +9 -> 120
    //   114: aload_2
    //   115: invokevirtual 304	java/io/BufferedReader:close	()V
    //   118: aload_3
    //   119: astore_1
    //   120: aload_1
    //   121: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   124: ifeq +50 -> 174
    //   127: aconst_null
    //   128: areturn
    //   129: astore_3
    //   130: aconst_null
    //   131: astore_2
    //   132: aload_2
    //   133: astore_1
    //   134: invokestatic 78	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   137: aload_3
    //   138: invokevirtual 84	com/mob/tools/log/NLog:d	(Ljava/lang/Throwable;)I
    //   141: pop
    //   142: aload_2
    //   143: ifnull +55 -> 198
    //   146: aload_2
    //   147: invokevirtual 304	java/io/BufferedReader:close	()V
    //   150: aconst_null
    //   151: astore_1
    //   152: goto -32 -> 120
    //   155: astore_1
    //   156: aconst_null
    //   157: astore_1
    //   158: goto -38 -> 120
    //   161: astore_1
    //   162: aload_3
    //   163: astore_2
    //   164: aload_2
    //   165: ifnull +7 -> 172
    //   168: aload_2
    //   169: invokevirtual 304	java/io/BufferedReader:close	()V
    //   172: aload_1
    //   173: athrow
    //   174: aload_1
    //   175: areturn
    //   176: astore_1
    //   177: aload_3
    //   178: astore_1
    //   179: goto -59 -> 120
    //   182: astore_2
    //   183: goto -11 -> 172
    //   186: astore_3
    //   187: aload_1
    //   188: astore_2
    //   189: aload_3
    //   190: astore_1
    //   191: goto -27 -> 164
    //   194: astore_3
    //   195: goto -63 -> 132
    //   198: aconst_null
    //   199: astore_1
    //   200: goto -80 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	DeviceHelper
    //   0	203	1	paramString	String
    //   22	147	2	localObject1	Object
    //   182	1	2	localThrowable1	Throwable
    //   188	1	2	str1	String
    //   1	118	3	str2	String
    //   129	49	3	localThrowable2	Throwable
    //   186	4	3	localObject2	Object
    //   194	1	3	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	101	129	java/lang/Throwable
    //   146	150	155	java/lang/Throwable
    //   2	101	161	finally
    //   114	118	176	java/lang/Throwable
    //   168	172	182	java/lang/Throwable
    //   103	108	186	finally
    //   134	142	186	finally
    //   103	108	194	java/lang/Throwable
  }
  
  public static DeviceHelper getInstance(Context paramContext)
  {
    try
    {
      if ((deviceHelper == null) && (paramContext != null)) {
        deviceHelper = new DeviceHelper(paramContext);
      }
      paramContext = deviceHelper;
      return paramContext;
    }
    finally {}
  }
  
  private String[] getInvalidMacList()
  {
    try
    {
      Object localObject = ResHelper.getCacheRootFile(this.context, ".mcli");
      localObject = Data.AES128Decode(Strings.getString(76), (byte[])ResHelper.readObjectFromFile(((File)localObject).getPath()));
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = (ArrayList)new Hashon().fromJson((String)localObject).get("list");
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = (String[])((ArrayList)localObject).toArray(new String[0]);
          return (String[])localObject;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
    return null;
  }
  
  private String getLocalDeviceKey()
    throws Throwable
  {
    if (!getSdcardState()) {}
    do
    {
      return null;
      localObject1 = new File(getSdcardPath(), "ShareSDK");
      if (((File)localObject1).exists())
      {
        localObject1 = new File((File)localObject1, ".dk");
        if (((File)localObject1).exists())
        {
          localObject2 = ResHelper.getCacheRootFile(this.context, ".dk");
          if ((localObject2 != null) && (((File)localObject1).renameTo((File)localObject2))) {
            ((File)localObject1).delete();
          }
        }
      }
      localObject1 = ResHelper.getCacheRootFile(this.context, ".dk");
    } while ((localObject1 != null) && (!((File)localObject1).exists()));
    Object localObject2 = new ObjectInputStream(new FileInputStream((File)localObject1));
    Object localObject1 = ((ObjectInputStream)localObject2).readObject();
    if ((localObject1 != null) && ((localObject1 instanceof char[]))) {}
    for (localObject1 = String.valueOf((char[])localObject1);; localObject1 = null)
    {
      ((ObjectInputStream)localObject2).close();
      return (String)localObject1;
    }
  }
  
  private String getLocalSerial()
  {
    try
    {
      Object localObject = ResHelper.getCacheRootFile(this.context, ".slw");
      localObject = Data.AES128Decode(Strings.getString(76), (byte[])ResHelper.readObjectFromFile(((File)localObject).getPath()));
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return ((String)localObject).trim();
      }
      localObject = getWAbcd(3);
      return (String)localObject;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
    return null;
  }
  
  private String getLocalWifiMac()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = ResHelper.getCacheRootFile(this.context, ".mcw");
        if (!((File)localObject1).exists()) {
          break label91;
        }
        localObject1 = Data.AES128Decode("1234567890abcdfg", (byte[])ResHelper.readObjectFromFile(((File)localObject1).getPath()));
        Object localObject3 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject3 = getWAbcd(2);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).trim().matches("^[a-fA-F0-9]{2}(:[a-fA-F0-9]{2}){5}$")))
        {
          localObject1 = ((String)localObject3).trim();
          return (String)localObject1;
        }
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().d(localThrowable);
      }
      return null;
      label91:
      Object localObject2 = null;
    }
  }
  
  private HashMap<String, Object> getMapFromOtherPlace(String paramString)
  {
    try
    {
      paramString = Data.AES128Decode(Strings.getString(76), (byte[])ResHelper.readObjectFromFile(paramString));
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new Hashon().fromJson(paramString);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().d(paramString);
    }
    return null;
  }
  
  private ArrayList<String> getPackageList()
  {
    localArrayList = new ArrayList();
    try
    {
      localObject2 = ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(Strings.getString(42)), Strings.getString(43), new Object[0]), Strings.getString(44), new Object[] { Strings.getString(20) });
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader((InputStream)ReflectHelper.invokeInstanceMethod(localObject2, Strings.getString(45), new Object[0]), "utf-8"));
      for (localObject1 = localBufferedReader.readLine(); localObject1 != null; localObject1 = localBufferedReader.readLine())
      {
        localObject1 = ((String)localObject1).trim();
        if ((((String)localObject1).length() > 8) && (((String)localObject1).substring(0, 8).equalsIgnoreCase("package:")))
        {
          localObject1 = ((String)localObject1).substring(8).trim();
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localArrayList.add(localObject1);
          }
        }
      }
      localBufferedReader.close();
      ReflectHelper.invokeInstanceMethod(localObject2, Strings.getString(51), new Object[0]);
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject1;
        MobLog.getInstance().w(localThrowable2);
      }
    }
    if (localArrayList.isEmpty()) {
      try
      {
        localObject1 = new Intent("android.intent.action.MAIN");
        ((Intent)localObject1).addCategory(Strings.getString(74));
        localObject1 = this.context.getPackageManager().queryIntentActivities((Intent)localObject1, 0).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ResolveInfo)((Iterator)localObject1).next();
          if ((localObject2 != null) && (((ResolveInfo)localObject2).activityInfo != null) && (!TextUtils.isEmpty(((ResolveInfo)localObject2).activityInfo.packageName))) {
            localArrayList.add(((ResolveInfo)localObject2).activityInfo.packageName);
          }
        }
        return localArrayList;
      }
      catch (Throwable localThrowable1)
      {
        MobLog.getInstance().w(localThrowable1);
      }
    }
  }
  
  private String getSystemProperties(String paramString)
  {
    try
    {
      paramString = ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(Strings.getString(9)), Strings.getString(10), new Object[] { paramString });
      if (paramString != null)
      {
        paramString = String.valueOf(paramString);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().w(paramString);
    }
    return "";
  }
  
  private Object getSystemServiceSave(String paramString)
  {
    try
    {
      paramString = this.context.getSystemService(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().w(paramString);
    }
    return null;
  }
  
  private String getValidNetworkHardwareAddress()
    throws Throwable
  {
    HashMap localHashMap = listNetworkHardware();
    if ((localHashMap == null) || (localHashMap.isEmpty())) {}
    for (;;)
    {
      return null;
      Object localObject2 = new ArrayList(localHashMap.keySet());
      Object localObject3 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      ArrayList localArrayList5 = new ArrayList();
      ArrayList localArrayList6 = new ArrayList();
      Object localObject1 = null;
      if (((ArrayList)localObject2).size() > 0)
      {
        String str = ((String)((ArrayList)localObject2).remove(0)).trim();
        if (str.equals("wlan0")) {
          localObject1 = "wlan0";
        }
        for (;;)
        {
          break;
          if (str.startsWith("wlan")) {
            ((ArrayList)localObject3).add(str);
          } else if (str.startsWith("eth")) {
            localArrayList1.add(str);
          } else if (str.startsWith("rev_rmnet")) {
            localArrayList2.add(str);
          } else if (str.startsWith("dummy")) {
            localArrayList3.add(str);
          } else if (str.startsWith("usbnet")) {
            localArrayList4.add(str);
          } else if (str.startsWith("rmnet_usb")) {
            localArrayList5.add(str);
          } else {
            localArrayList6.add(str);
          }
        }
      }
      Collections.sort((List)localObject3);
      Collections.sort(localArrayList1);
      Collections.sort(localArrayList2);
      Collections.sort(localArrayList3);
      Collections.sort(localArrayList4);
      Collections.sort(localArrayList5);
      Collections.sort(localArrayList6);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((ArrayList)localObject2).add(localObject1);
      }
      ((ArrayList)localObject2).addAll((Collection)localObject3);
      if ("wifi".equals(getNetworkType())) {}
      try
      {
        localObject1 = getCurrentNetworkHardwareAddress();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((ArrayList)localObject2).add(localObject1);
        }
        if (((ArrayList)localObject2).size() > 0)
        {
          localObject1 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (String)localHashMap.get((String)((Iterator)localObject1).next());
            if ((localObject3 != null) && (checkMacIsValid((String)localObject3)))
            {
              this.wifimac = ((String)localObject3).trim();
              saveLocalWifiMac(this.wifimac);
              return this.wifimac;
            }
          }
        }
        ((ArrayList)localObject2).addAll(localArrayList1);
        ((ArrayList)localObject2).addAll(localArrayList2);
        ((ArrayList)localObject2).addAll(localArrayList3);
        ((ArrayList)localObject2).addAll(localArrayList4);
        ((ArrayList)localObject2).addAll(localArrayList5);
        ((ArrayList)localObject2).addAll(localArrayList6);
        localObject1 = ((ArrayList)localObject2).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (String)localHashMap.get((String)((Iterator)localObject1).next());
        } while ((localObject2 == null) || (!checkMacIsValid((String)localObject2)));
        return ((String)localObject2).trim();
      }
      catch (Throwable localThrowable)
      {
        for (;;) {}
      }
    }
  }
  
  private String getWifiMac()
  {
    try
    {
      Object localObject = getSystemServiceSave("wifi");
      if (localObject == null) {
        return null;
      }
      localObject = ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(2), new Object[0]);
      if (localObject != null)
      {
        localObject = (String)ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(5), new Object[0]);
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = ((String)localObject).trim();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
    return null;
    return localThrowable;
  }
  
  private int getWifiSecurity(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.contains("WEP")) {
        return 1;
      }
      if (paramString.contains("PSK")) {
        return 2;
      }
      if (paramString.contains("EAP")) {
        return 3;
      }
    }
    return 0;
  }
  
  private String getWlanMac()
  {
    try
    {
      String str1 = getHardwareAddressFromShell("wlan0");
      if ((str1 != null) && (checkMacIsValid(str1)))
      {
        this.wifimac = str1.trim();
        saveLocalWifiMac(this.wifimac);
        str1 = this.wifimac;
        return str1;
      }
    }
    catch (Throwable localThrowable1)
    {
      MobLog.getInstance().d(localThrowable1);
      try
      {
        String str2 = getValidNetworkHardwareAddress();
        return str2;
      }
      catch (Throwable localThrowable2)
      {
        MobLog.getInstance().d(localThrowable2);
      }
    }
    return null;
  }
  
  private boolean is4GMobileNetwork()
  {
    Object localObject = getSystemServiceSave("phone");
    if (localObject == null) {
      return false;
    }
    try
    {
      int i = ((Integer)ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(19), new Object[0])).intValue();
      if (i == 13) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
  }
  
  private static boolean isBackground(Context paramContext)
  {
    try
    {
      Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        paramContext = paramContext.getPackageName();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (localRunningAppProcessInfo.processName.equals(paramContext))
          {
            int i = localRunningAppProcessInfo.importance;
            return i == 400;
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      MobLog.getInstance().w(paramContext);
    }
    return false;
  }
  
  private boolean isFastMobileNetwork()
  {
    Object localObject = getSystemServiceSave("phone");
    if (localObject == null) {
      return false;
    }
    try
    {
      int i = ((Integer)ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(19), new Object[0])).intValue();
      switch (i)
      {
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        MobLog.getInstance().w(localThrowable);
      }
    }
    return false;
    return false;
    return false;
    return false;
    return true;
    return true;
    return false;
    return true;
    return true;
    return true;
    return true;
    return true;
    return true;
    return true;
    return false;
    return true;
    return false;
  }
  
  private boolean isSystemApp(PackageInfo paramPackageInfo)
  {
    boolean bool = false;
    int i;
    if ((paramPackageInfo.applicationInfo.flags & 0x1) == 1)
    {
      i = 1;
      if ((paramPackageInfo.applicationInfo.flags & 0x80) != 1) {
        break label54;
      }
    }
    label54:
    for (int j = 1;; j = 0)
    {
      if ((i != 0) || (j != 0)) {
        bool = true;
      }
      return bool;
      i = 0;
      break;
    }
  }
  
  private void saveLocalDeviceKey(String paramString)
    throws Throwable
  {
    if (!getSdcardState()) {
      return;
    }
    Object localObject = ResHelper.getCacheRootFile(this.context, ".dk");
    if ((localObject != null) && (((File)localObject).exists())) {
      ((File)localObject).delete();
    }
    localObject = new ObjectOutputStream(new FileOutputStream((File)localObject));
    ((ObjectOutputStream)localObject).writeObject(paramString.toCharArray());
    ((ObjectOutputStream)localObject).flush();
    ((ObjectOutputStream)localObject).close();
  }
  
  private void saveLocalSerial(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.trim().equals("")))
      {
        File localFile = ResHelper.getCacheRootFile(this.context, ".slw");
        byte[] arrayOfByte = Data.AES128Encode(Strings.getString(76), paramString.trim());
        ResHelper.saveObjectToFile(localFile.getPath(), arrayOfByte);
        saveWabcd(paramString.trim(), 3);
      }
      return;
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().d(paramString);
    }
  }
  
  private void saveLocalWifiMac(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramString.trim().matches("^[a-fA-F0-9]{2}(:[a-fA-F0-9]{2}){5}$")))
      {
        File localFile = ResHelper.getCacheRootFile(this.context, ".mcw");
        byte[] arrayOfByte = Data.AES128Encode("1234567890abcdfg", paramString.trim());
        ResHelper.saveObjectToFile(localFile.getPath(), arrayOfByte);
        saveWabcd(paramString.trim(), 2);
      }
      return;
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().d(paramString);
    }
  }
  
  public String Base64AES(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = Base64.encodeToString(Data.AES128Encode(paramString2, paramString1), 0);
      paramString2 = paramString1;
      MobLog.getInstance().w(paramString2);
    }
    catch (Throwable paramString2)
    {
      try
      {
        if (paramString1.contains("\n")) {
          paramString2 = paramString1.replace("\n", "");
        }
        return paramString2;
      }
      catch (Throwable paramString2)
      {
        for (;;) {}
      }
      paramString2 = paramString2;
      paramString1 = null;
    }
    return paramString1;
  }
  
  public boolean amIOnForeground()
  {
    try
    {
      if (Build.VERSION.SDK_INT > 27)
      {
        if (isBackground(this.context)) {
          break label92;
        }
        return true;
      }
      Iterator localIterator = ((Map)ReflectHelper.getInstanceField(currentActivityThread(), Strings.getString(23))).values().iterator();
      while (localIterator.hasNext())
      {
        boolean bool = ((Boolean)ReflectHelper.getInstanceField(localIterator.next(), Strings.getString(24))).booleanValue();
        if (!bool) {
          return true;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
    return false;
    label92:
    return false;
  }
  
  public boolean checkPermission(String paramString)
    throws Throwable
  {
    if (Build.VERSION.SDK_INT >= 23) {
      try
      {
        ReflectHelper.importClass("android.content.Context");
        paramString = (Integer)ReflectHelper.invokeInstanceMethod(this.context, Strings.getString(22), new Object[] { paramString });
        if (paramString == null) {
          i = -1;
        } else {
          i = paramString.intValue();
        }
      }
      catch (Throwable paramString)
      {
        MobLog.getInstance().d(paramString);
        i = -1;
      }
    }
    int i = this.context.getPackageManager().checkPermission(paramString, getPackageName());
    while (i != 0) {
      return false;
    }
    return true;
  }
  
  public String getAdvertisingID()
    throws Throwable
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw new Throwable("Do not call this function from the main thread !");
    }
    if (!TextUtils.isEmpty(this.advertiseID)) {
      return this.advertiseID;
    }
    Object localObject1 = new Intent("com.google.android.gms.ads.identifier.service.START");
    ((Intent)localObject1).setPackage("com.google.android.gms");
    GSConnection localGSConnection = new GSConnection(null);
    try
    {
      this.context.bindService((Intent)localObject1, localGSConnection, 1);
      localObject1 = localGSConnection.takeBinder();
      if (localObject1 == null)
      {
        localObject1 = this.advertiseID;
        return (String)localObject1;
      }
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
      ((IBinder)localObject1).transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      this.advertiseID = localParcel2.readString();
      localParcel2.recycle();
      localParcel1.recycle();
      localObject1 = this.advertiseID;
      return (String)localObject1;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
      String str = this.advertiseID;
      return str;
    }
    finally
    {
      this.context.unbindService(localGSConnection);
    }
  }
  
  /* Error */
  public ArrayList<HashMap<String, Object>> getAllApp()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 715	com/mob/tools/utils/DeviceHelper:getPackageList	()Ljava/util/ArrayList;
    //   4: astore_2
    //   5: new 334	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 393	java/util/ArrayList:<init>	()V
    //   12: astore 4
    //   14: aload_0
    //   15: getfield 40	com/mob/tools/utils/DeviceHelper:context	Landroid/content/Context;
    //   18: invokevirtual 431	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   21: astore 5
    //   23: aload_2
    //   24: invokevirtual 509	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   27: astore 6
    //   29: aload 6
    //   31: invokeinterface 193 1 0
    //   36: ifeq +186 -> 222
    //   39: aload 6
    //   41: invokeinterface 196 1 0
    //   46: checkcast 47	java/lang/String
    //   49: astore_2
    //   50: aload 5
    //   52: aload_2
    //   53: iconst_0
    //   54: invokevirtual 719	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   57: astore_2
    //   58: aload_2
    //   59: ifnull -30 -> 29
    //   62: new 268	java/util/HashMap
    //   65: dup
    //   66: invokespecial 720	java/util/HashMap:<init>	()V
    //   69: astore 7
    //   71: aload 7
    //   73: ldc_w 722
    //   76: aload_2
    //   77: getfield 723	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   80: invokevirtual 727	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: aload_2
    //   85: getfield 574	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   88: aload 5
    //   90: invokevirtual 731	android/content/pm/ApplicationInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   93: astore_3
    //   94: aload 7
    //   96: ldc_w 733
    //   99: aload_0
    //   100: aload_2
    //   101: invokespecial 735	com/mob/tools/utils/DeviceHelper:isSystemApp	(Landroid/content/pm/PackageInfo;)Z
    //   104: invokestatic 738	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   107: invokevirtual 727	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   110: pop
    //   111: aload 5
    //   113: aload_2
    //   114: getfield 723	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   117: invokevirtual 741	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   120: ifnull +111 -> 231
    //   123: iconst_1
    //   124: istore_1
    //   125: aload 7
    //   127: ldc_w 743
    //   130: iload_1
    //   131: invokestatic 738	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   134: invokevirtual 727	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   137: pop
    //   138: aload_3
    //   139: ifnonnull +73 -> 212
    //   142: aload_2
    //   143: getfield 723	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   146: astore_3
    //   147: aload 7
    //   149: ldc_w 745
    //   152: aload_3
    //   153: invokevirtual 727	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   156: pop
    //   157: aload 7
    //   159: ldc_w 747
    //   162: aload_2
    //   163: getfield 750	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   166: invokevirtual 727	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   169: pop
    //   170: aload 4
    //   172: aload 7
    //   174: invokevirtual 414	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   177: pop
    //   178: goto -149 -> 29
    //   181: astore_2
    //   182: invokestatic 78	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   185: aload_2
    //   186: invokevirtual 127	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   189: pop
    //   190: new 334	java/util/ArrayList
    //   193: dup
    //   194: invokespecial 393	java/util/ArrayList:<init>	()V
    //   197: areturn
    //   198: astore_2
    //   199: invokestatic 78	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   202: aload_2
    //   203: invokevirtual 127	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   206: pop
    //   207: aconst_null
    //   208: astore_2
    //   209: goto -151 -> 58
    //   212: aload_3
    //   213: invokeinterface 753 1 0
    //   218: astore_3
    //   219: goto -72 -> 147
    //   222: aload 4
    //   224: areturn
    //   225: astore_3
    //   226: aconst_null
    //   227: astore_3
    //   228: goto -134 -> 94
    //   231: iconst_0
    //   232: istore_1
    //   233: goto -108 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	DeviceHelper
    //   124	109	1	bool	boolean
    //   4	159	2	localObject1	Object
    //   181	5	2	localThrowable1	Throwable
    //   198	5	2	localThrowable2	Throwable
    //   208	1	2	localObject2	Object
    //   93	126	3	localObject3	Object
    //   225	1	3	localThrowable3	Throwable
    //   227	1	3	localObject4	Object
    //   12	211	4	localArrayList	ArrayList
    //   21	91	5	localPackageManager	PackageManager
    //   27	13	6	localIterator	Iterator
    //   69	104	7	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   0	29	181	java/lang/Throwable
    //   29	50	181	java/lang/Throwable
    //   62	84	181	java/lang/Throwable
    //   94	123	181	java/lang/Throwable
    //   125	138	181	java/lang/Throwable
    //   142	147	181	java/lang/Throwable
    //   147	178	181	java/lang/Throwable
    //   199	207	181	java/lang/Throwable
    //   212	219	181	java/lang/Throwable
    //   50	58	198	java/lang/Throwable
    //   84	94	225	java/lang/Throwable
  }
  
  public String getAndroidID()
  {
    try
    {
      String str = Settings.Secure.getString(this.context.getContentResolver(), "android_id");
      MobLog.getInstance().i("getAndroidID === " + str, new Object[0]);
      return str;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
    return "";
  }
  
  public String getAppLanguage()
  {
    return this.context.getResources().getConfiguration().locale.getLanguage();
  }
  
  public String getAppName()
  {
    ApplicationInfo localApplicationInfo;
    try
    {
      localApplicationInfo = this.context.getApplicationInfo();
      str1 = localApplicationInfo.name;
      str3 = str1;
      if (str1 != null)
      {
        str3 = str1;
        if (Build.VERSION.SDK_INT < 25) {
          break label78;
        }
        boolean bool = str1.endsWith(".*");
        str3 = str1;
        if (bool) {
          break label78;
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      String str1;
      String str3;
      label56:
      int i;
      MobLog.getInstance().w(localThrowable2);
      return "";
    }
    try
    {
      ReflectHelper.importClass(str1);
      str3 = null;
    }
    catch (Throwable localThrowable3)
    {
      String str2;
      String str4 = str2;
      break label56;
    }
    i = localApplicationInfo.labelRes;
    if (i > 0) {
      try
      {
        str1 = this.context.getString(i);
        str3 = str1;
        label78:
        return str3;
      }
      catch (Throwable localThrowable1)
      {
        MobLog.getInstance().w(localThrowable1);
        return str3;
      }
    }
    str2 = String.valueOf(localApplicationInfo.nonLocalizedLabel);
    return str2;
  }
  
  public int getAppVersion()
  {
    try
    {
      int i = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionCode;
      return i;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
    return 0;
  }
  
  public String getAppVersionName()
  {
    try
    {
      String str = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName;
      return str;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
    return "1.0";
  }
  
  public ArrayList<HashMap<String, Object>> getArpList()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/net/arp"));
      for (;;)
      {
        String str1 = localBufferedReader.readLine();
        if (str1 == null) {
          break;
        }
        try
        {
          String str3 = str1.trim();
          if (!str3.toUpperCase(Locale.US).contains("IP"))
          {
            str1 = str3.substring(0, 17).trim();
            String str2 = str3.substring(29, 32).trim();
            str3 = str3.substring(41, 63).trim();
            HashMap localHashMap = new HashMap();
            localHashMap.put("ip", str1);
            localHashMap.put("flag", str2);
            localHashMap.put("mac", str3);
            localArrayList.add(localHashMap);
          }
        }
        catch (Throwable localThrowable2)
        {
          MobLog.getInstance().d(localThrowable2);
        }
      }
      localThrowable1.close();
    }
    catch (Throwable localThrowable1)
    {
      MobLog.getInstance().d(localThrowable1);
      return localArrayList;
    }
    return localArrayList;
  }
  
  public ArrayList<HashMap<String, Object>> getAvailableWifiList()
  {
    for (;;)
    {
      ArrayList localArrayList2;
      Object localObject4;
      HashMap localHashMap;
      Object localObject3;
      try
      {
        if (checkPermission("android.permission.ACCESS_WIFI_STATE"))
        {
          localObject1 = getSystemServiceSave("wifi");
          if (localObject1 == null) {
            return null;
          }
          localObject1 = (List)ReflectHelper.invokeInstanceMethod(localObject1, Strings.getString(34), new Object[0]);
          if (localObject1 == null) {
            return null;
          }
          if (Build.VERSION.SDK_INT > 27)
          {
            arrayOfString2 = TextUtils.split(Strings.getString(72), ",");
            arrayOfString1 = TextUtils.split(Strings.getString(73), ",");
            localArrayList2 = new ArrayList();
            Iterator localIterator = ((List)localObject1).iterator();
            if (!localIterator.hasNext()) {
              break label555;
            }
            localObject4 = localIterator.next();
            localHashMap = new HashMap();
            j = arrayOfString2.length;
            i = 0;
            localObject1 = null;
            if (i >= j) {
              break label563;
            }
            str2 = arrayOfString2[i];
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject1;
        String[] arrayOfString2;
        String[] arrayOfString1;
        int j;
        int i;
        String str2;
        label237:
        MobLog.getInstance().w(localThrowable1);
      }
      for (;;)
      {
        try
        {
          if ("SSID".equals(str2)) {
            localObject3 = (String)ReflectHelper.getInstanceField(localObject4, str2);
          }
          try
          {
            boolean bool = TextUtils.isEmpty((CharSequence)localObject3);
            if (bool)
            {
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                break;
              }
              j = arrayOfString1.length;
              i = 0;
              if (i >= j) {
                continue;
              }
              localObject3 = arrayOfString1[i];
            }
          }
          catch (Throwable localThrowable5)
          {
            localObject1 = localObject3;
          }
        }
        catch (Throwable localThrowable6)
        {
          String str1;
          Object localObject2;
          ArrayList localArrayList1;
          break label376;
        }
        try
        {
          localObject1 = ReflectHelper.getInstanceField(localObject4, (String)localObject3);
          if (localObject1 != null) {
            continue;
          }
          localObject1 = null;
          localHashMap.put(localObject3, localObject1);
        }
        catch (Throwable localThrowable2)
        {
          MobLog.getInstance().w(localThrowable2);
          break label237;
        }
      }
      i += 1;
      continue;
      arrayOfString2 = TextUtils.split(Strings.getString(35), ",");
      arrayOfString1 = TextUtils.split(Strings.getString(36), ",");
      continue;
      localHashMap.put(str2, localObject3);
      localObject1 = localObject3;
      i += 1;
      continue;
      if ("capabilities".equals(str2))
      {
        localObject3 = (String)ReflectHelper.getInstanceField(localObject4, str2);
        if ((localObject3 != null) && (((String)localObject3).contains("[IBSS]"))) {
          localObject3 = null;
        } else {
          localHashMap.put(str2, localObject3);
        }
      }
      else
      {
        localHashMap.put(str2, ReflectHelper.getInstanceField(localObject4, str2));
        continue;
        label376:
        MobLog.getInstance().w(localThrowable5);
        continue;
        return null;
        str1 = localThrowable1.toString();
        continue;
        try
        {
          localObject2 = ReflectHelper.invokeInstanceMethod(localObject4, Strings.getString(37), new Object[0]);
          localHashMap.put(Strings.getString(39), localObject2);
          try
          {
            if (Build.VERSION.SDK_INT < 28)
            {
              localObject2 = (List)ReflectHelper.getInstanceField(localObject4, Strings.getString(38));
              localObject3 = Strings.getString(38);
              if (localObject2 != null) {
                break label527;
              }
              localObject2 = null;
              localHashMap.put(localObject3, localObject2);
            }
          }
          catch (Throwable localThrowable4)
          {
            for (;;)
            {
              MobLog.getInstance().w(localThrowable4);
            }
          }
          localArrayList2.add(localHashMap);
        }
        catch (Throwable localThrowable3)
        {
          for (;;)
          {
            MobLog.getInstance().w(localThrowable3);
            continue;
            label527:
            localArrayList1 = new ArrayList(localThrowable3);
          }
        }
        label555:
        return localArrayList2;
        label563:
        localObject3 = localThrowable4;
      }
    }
  }
  
  public void getBatteryState(final ReflectHelper.ReflectRunnable<HashMap<String, Object>, Void> paramReflectRunnable)
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.BATTERY_CHANGED");
      this.context.registerReceiver(new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          HashMap localHashMap = new HashMap();
          Iterator localIterator = paramAnonymousIntent.getExtras().keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localHashMap.put(str, paramAnonymousIntent.getExtras().get(str));
          }
          if (paramReflectRunnable != null) {
            paramReflectRunnable.run(localHashMap);
          }
          try
          {
            paramAnonymousContext.unregisterReceiver(this);
            return;
          }
          catch (Throwable paramAnonymousContext) {}
        }
      }, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        MobLog.getInstance().w(localThrowable);
      } while (paramReflectRunnable == null);
      paramReflectRunnable.run(null);
    }
  }
  
  public String getBluetoothName()
  {
    try
    {
      if (checkPermission("android.permission.BLUETOOTH"))
      {
        Object localObject = ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(Strings.getString(16)), Strings.getString(17), new Object[0]);
        if (localObject != null)
        {
          localObject = (String)ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(18), new Object[0]);
          return (String)localObject;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
    return null;
  }
  
  public String getBssid()
  {
    try
    {
      if (checkPermission("android.permission.ACCESS_WIFI_STATE"))
      {
        Object localObject = getSystemServiceSave("wifi");
        if (localObject == null) {
          return null;
        }
        localObject = ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(2), new Object[0]);
        if (localObject != null)
        {
          String str = (String)ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(4), new Object[0]);
          localObject = str;
          if (str == null) {
            localObject = null;
          }
          return (String)localObject;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
    return null;
  }
  
  public HashMap<String, Object> getCPUInfo()
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      FileReader localFileReader;
      BufferedReader localBufferedReader;
      Object localObject3;
      try
      {
        localFileReader = new FileReader(Strings.getString(41));
        localBufferedReader = new BufferedReader(localFileReader);
        ArrayList localArrayList = new ArrayList();
        localHashMap.put("processors", localArrayList);
        Object localObject1 = null;
        localObject3 = localBufferedReader.readLine();
        if (localObject3 == null) {
          break label211;
        }
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          if (localObject1 == null) {
            break label223;
          }
          localArrayList.add(localObject1);
          break label223;
        }
        Object localObject4 = ((String)localObject3).trim();
        localObject3 = localObject1;
        if (((String)localObject4).startsWith("processor"))
        {
          if (localObject1 != null) {
            localArrayList.add(localObject1);
          }
          localObject3 = new HashMap();
        }
        localObject4 = ((String)localObject4).split(":");
        localObject1 = localObject3;
        if (localObject4 == null) {
          continue;
        }
        localObject1 = localObject3;
        if (localObject4.length <= 1) {
          continue;
        }
        if (localObject3 == null)
        {
          localHashMap.put(localObject4[0].trim(), localObject4[1].trim());
          localObject1 = localObject3;
          continue;
        }
        ((HashMap)localObject3).put(localObject4[0].trim(), localObject4[1].trim());
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().d(localThrowable);
        return localHashMap;
      }
      Object localObject2 = localObject3;
      continue;
      label211:
      localBufferedReader.close();
      localFileReader.close();
      return localHashMap;
      label223:
      localObject2 = null;
    }
  }
  
  public String getCarrier()
  {
    try
    {
      Object localObject = getSystemServiceSave("phone");
      if (localObject == null) {
        return "-1";
      }
      String str2 = (String)ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(12), new Object[0]);
      localObject = str2;
      if (TextUtils.isEmpty(str2)) {
        return "-1";
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
      String str1 = "-1";
      return str1;
    }
  }
  
  public String getCarrierName()
  {
    Object localObject = getSystemServiceSave("phone");
    if (localObject == null) {}
    for (;;)
    {
      return null;
      try
      {
        if (checkPermission("android.permission.READ_PHONE_STATE"))
        {
          localObject = (String)ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(13), new Object[0]);
          boolean bool = TextUtils.isEmpty((CharSequence)localObject);
          if (bool) {
            localObject = null;
          }
          return (String)localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().w(localThrowable);
      }
    }
    return null;
  }
  
  public int getCdmaBid()
  {
    try
    {
      if (checkPermission("android.permission.ACCESS_COARSE_LOCATION"))
      {
        Object localObject = getSystemServiceSave("phone");
        if (localObject != null)
        {
          localObject = ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(26), new Object[0]);
          if ((localObject != null) && ("CdmaCellLocation".equals(localObject.getClass().getSimpleName())))
          {
            int i = ((Integer)ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(56), new Object[0]), Integer.valueOf(-1))).intValue();
            return i;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
    return -1;
  }
  
  public int getCdmaLat()
  {
    int i;
    try
    {
      if (!checkPermission("android.permission.ACCESS_COARSE_LOCATION")) {
        break label101;
      }
      Object localObject = getSystemServiceSave("phone");
      if (localObject == null) {
        break label101;
      }
      localObject = ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(26), new Object[0]);
      if ((localObject == null) || (!"CdmaCellLocation".equals(localObject.getClass().getSimpleName()))) {
        break label101;
      }
      i = ((Integer)ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(56), new Object[0]), Integer.valueOf(-1))).intValue();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        MobLog.getInstance().d(localThrowable);
        label101:
        i = -1;
      }
    }
    if (i == Integer.MAX_VALUE) {
      return -1;
    }
    return i;
  }
  
  public int getCdmaLon()
  {
    int i;
    try
    {
      if (!checkPermission("android.permission.ACCESS_COARSE_LOCATION")) {
        break label101;
      }
      Object localObject = getSystemServiceSave("phone");
      if (localObject == null) {
        break label101;
      }
      localObject = ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(26), new Object[0]);
      if ((localObject == null) || (!"CdmaCellLocation".equals(localObject.getClass().getSimpleName()))) {
        break label101;
      }
      i = ((Integer)ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(57), new Object[0]), Integer.valueOf(-1))).intValue();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        MobLog.getInstance().d(localThrowable);
        label101:
        i = -1;
      }
    }
    if (i == Integer.MAX_VALUE) {
      return -1;
    }
    return i;
  }
  
  public int getCdmaNid()
  {
    try
    {
      if (checkPermission("android.permission.ACCESS_COARSE_LOCATION"))
      {
        Object localObject = getSystemServiceSave("phone");
        if (localObject != null)
        {
          localObject = ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(26), new Object[0]);
          if ((localObject != null) && ("CdmaCellLocation".equals(localObject.getClass().getSimpleName())))
          {
            int i = ((Integer)ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(60), new Object[0]), Integer.valueOf(-1))).intValue();
            return i;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
    return -1;
  }
  
  public int getCdmaSid()
  {
    try
    {
      if (checkPermission("android.permission.ACCESS_COARSE_LOCATION"))
      {
        Object localObject = getSystemServiceSave("phone");
        if (localObject != null)
        {
          localObject = ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(26), new Object[0]);
          if ((localObject != null) && ("CdmaCellLocation".equals(localObject.getClass().getSimpleName())))
          {
            int i = ((Integer)ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(59), new Object[0]), Integer.valueOf(-1))).intValue();
            return i;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
    return -1;
  }
  
  public int getCellId()
  {
    try
    {
      if (checkPermission("android.permission.ACCESS_COARSE_LOCATION"))
      {
        Object localObject = getSystemServiceSave("phone");
        if (localObject != null)
        {
          localObject = ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(26), new Object[0]);
          if ((localObject != null) && (!"CdmaCellLocation".equals(localObject.getClass().getSimpleName())))
          {
            int i = ((Integer)ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(27), new Object[0]), Integer.valueOf(-1))).intValue();
            return i;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
    return -1;
  }
  
  public int getCellLac()
  {
    try
    {
      if (checkPermission("android.permission.ACCESS_COARSE_LOCATION"))
      {
        Object localObject = getSystemServiceSave("phone");
        if (localObject != null)
        {
          localObject = ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(26), new Object[0]);
          if ((localObject != null) && (!"CdmaCellLocation".equals(localObject.getClass().getSimpleName())))
          {
            int i = ((Integer)ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(28), new Object[0]), Integer.valueOf(-1))).intValue();
            return i;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
    return -1;
  }
  
  public String getCharAndNumr(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    long l2 = SystemClock.elapsedRealtime();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(l1 ^ l2);
    Random localRandom = new Random();
    int i = 0;
    if (i < paramInt)
    {
      String str;
      if (localRandom.nextInt(2) % 2 == 0)
      {
        str = "char";
        label60:
        if (!"char".equalsIgnoreCase(str)) {
          break label106;
        }
        localStringBuffer.insert(i + 1, (char)(localRandom.nextInt(26) + 97));
      }
      for (;;)
      {
        i += 1;
        break;
        str = "num";
        break label60;
        label106:
        localStringBuffer.insert(localStringBuffer.length(), localRandom.nextInt(10));
      }
    }
    return localStringBuffer.toString().substring(0, 40);
  }
  
  public String getDetailNetworkTypeForStatic()
  {
    try
    {
      String str3 = getNetworkType().toLowerCase();
      if ((!TextUtils.isEmpty(str3)) && (!"none".equals(str3)))
      {
        if (str3.startsWith("wifi")) {
          return "wifi";
        }
        if (str3.startsWith("4g")) {
          return "4g";
        }
        if (str3.startsWith("3g")) {
          return "3g";
        }
        if (str3.startsWith("2g")) {
          return "2g";
        }
        String str1 = str3;
        if (!str3.startsWith("bluetooth")) {
          return ???;
        }
        return "bluetooth";
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
      return "none";
    }
    String str2 = "none";
    return str2;
  }
  
  public String getDeviceData()
  {
    try
    {
      String str3 = getModel() + "|" + getOSVersionInt() + "|" + getManufacturer() + "|" + getCarrier() + "|" + getScreenSize();
      String str2 = getDeviceKey();
      String str1;
      if (str2 == null) {
        str1 = "";
      }
      for (;;)
      {
        return Base64AES(str3, str1);
        str1 = str2;
        if (str2.length() > 16) {
          str1 = str2.substring(0, 16);
        }
      }
      return "";
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
  }
  
  public String getDeviceDataNotAES()
  {
    return getModel() + "|" + getOSVersionInt() + "|" + getManufacturer() + "|" + getCarrier() + "|" + getScreenSize();
  }
  
  public String getDeviceId()
  {
    String str2 = getIMEI();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (Build.VERSION.SDK_INT >= 9) {
        str1 = getSerialno();
      }
    }
    return str1;
  }
  
  public String getDeviceKey()
  {
    Object localObject3 = null;
    Object localObject2;
    try
    {
      String str1 = getDeviceKeyWithDuid("comm/dbs/.duid");
      if (!TextUtils.isEmpty(str1))
      {
        localObject2 = str1;
        if (str1.length() >= 40) {}
      }
      else
      {
        localObject2 = genDeviceKey();
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).length() >= 40))
      {
        localObject2 = ((String)localObject2).trim();
        return (String)localObject2;
      }
    }
    catch (Throwable localThrowable1)
    {
      String str2;
      for (;;)
      {
        MobLog.getInstance().w(localThrowable1);
        str2 = null;
      }
      try
      {
        str2 = getLocalDeviceKey();
        if ((!TextUtils.isEmpty(str2)) && (str2.length() >= 40)) {
          return str2.trim();
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          MobLog.getInstance().w(localThrowable2);
          localObject1 = localObject3;
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label126;
        }
      }
      if (((String)localObject1).length() >= 40) {
        break label166;
      }
    }
    label126:
    Object localObject1 = getCharAndNumr(40);
    label166:
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        break;
      }
      localObject2 = localObject1;
      try
      {
        localObject1 = ((String)localObject1).trim();
        localObject2 = localObject1;
        saveLocalDeviceKey((String)localObject1);
        return (String)localObject1;
      }
      catch (Throwable localThrowable3)
      {
        MobLog.getInstance().w(localThrowable3);
        return (String)localObject2;
      }
    }
  }
  
  public String getDeviceType()
  {
    try
    {
      UiModeManager localUiModeManager = (UiModeManager)getSystemServiceSave("uimode");
      if (localUiModeManager != null)
      {
        int i = localUiModeManager.getCurrentModeType();
        switch (i)
        {
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        MobLog.getInstance().d(localThrowable);
      }
      return "DESK";
    }
    return "UNDEFINED";
    return "NO_UI";
    return "VRHEADSET";
    return "CAR";
    return "TELEVISION";
    return "APPLIANCE";
    return "WATCH";
  }
  
  public String getFixedString()
  {
    if (this.fixedString == null) {
      try
      {
        Object localObject = ((SensorManager)this.context.getSystemService("sensor")).getSensorList(-1);
        StringBuilder localStringBuilder = new StringBuilder();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Sensor localSensor = (Sensor)((Iterator)localObject).next();
          if (localSensor.getType() >= 0)
          {
            localStringBuilder.append(localSensor.getType()).append('.').append(localSensor.getName()).append('-').append(localSensor.getVersion()).append("-").append(localSensor.getVendor()).append('\n');
            continue;
            return this.fixedString;
          }
        }
      }
      catch (Throwable localThrowable) {}
    }
    for (;;)
    {
      this.fixedString = String.valueOf(localThrowable.toString().hashCode());
    }
  }
  
  public String getIMEI()
  {
    if (!TextUtils.isEmpty(this.imei)) {
      return this.imei;
    }
    Object localObject1 = getSystemServiceSave("phone");
    if (localObject1 == null) {
      return null;
    }
    try
    {
      if (checkPermission("android.permission.READ_PHONE_STATE"))
      {
        localObject1 = (String)ReflectHelper.invokeInstanceMethod(localObject1, Strings.getString(8), new Object[0]);
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            Object localObject2 = ResHelper.getCacheRootFile(this.context, "comm/.di");
            if ((localObject2 == null) || (!((File)localObject2).exists())) {
              return getWAbcd(1);
            }
            ObjectInputStream localObjectInputStream = new ObjectInputStream(new FileInputStream((File)localObject2));
            localObject2 = localObjectInputStream.readObject();
            if ((localObject2 == null) || (!(localObject2 instanceof char[]))) {
              break label229;
            }
            localObject2 = String.valueOf((char[])localObject2);
            localObjectInputStream.close();
            return (String)localObject2;
          }
        }
        catch (Throwable localThrowable1)
        {
          MobLog.getInstance().w(localThrowable1);
          return (String)localObject1;
        }
        this.imei = ((String)localObject1);
        Object localObject3 = ResHelper.getCacheRootFile(this.context, "comm/.di");
        if ((localObject3 != null) && (((File)localObject3).exists())) {
          ((File)localObject3).delete();
        }
        localObject3 = new ObjectOutputStream(new FileOutputStream((File)localObject3));
        ((ObjectOutputStream)localObject3).writeObject(((String)localObject1).toCharArray());
        ((ObjectOutputStream)localObject3).flush();
        ((ObjectOutputStream)localObject3).close();
        saveWabcd((String)localObject1, 1);
        return (String)localObject1;
      }
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        localObject1 = null;
        continue;
        label229:
        Object localObject4 = null;
        continue;
        localObject1 = null;
      }
    }
  }
  
  public String getIMSI()
  {
    Object localObject1 = getSystemServiceSave("phone");
    if (localObject1 == null) {}
    for (;;)
    {
      return null;
      try
      {
        if (checkPermission("android.permission.READ_PHONE_STATE"))
        {
          localObject1 = (String)ReflectHelper.invokeInstanceMethod(localObject1, Strings.getString(25), new Object[0]);
          Object localObject3;
          if (localObject1 != null)
          {
            localObject3 = localObject1;
            if (((String)localObject1).length() >= 15) {}
          }
          else
          {
            String[] arrayOfString = queryIMSI();
            localObject3 = localObject1;
            if (arrayOfString != null)
            {
              localObject3 = localObject1;
              if (arrayOfString.length > 0)
              {
                localObject3 = localObject1;
                if (arrayOfString[0].length() >= 15) {
                  localObject3 = arrayOfString[0];
                }
              }
            }
          }
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            continue;
          }
          return (String)localObject3;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          MobLog.getInstance().w(localThrowable);
          Object localObject2 = null;
        }
      }
    }
  }
  
  public String getIPAddress()
  {
    try
    {
      if (checkPermission("android.permission.INTERNET"))
      {
        InetAddress localInetAddress;
        do
        {
          localObject = NetworkInterface.getNetworkInterfaces();
          Enumeration localEnumeration;
          while (!localEnumeration.hasMoreElements())
          {
            if (!((Enumeration)localObject).hasMoreElements()) {
              break;
            }
            localEnumeration = ((NetworkInterface)((Enumeration)localObject).nextElement()).getInetAddresses();
          }
          localInetAddress = (InetAddress)localEnumeration.nextElement();
        } while ((localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address)));
        Object localObject = localInetAddress.getHostAddress();
        return (String)localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
    return "0.0.0.0";
  }
  
  /* Error */
  public ArrayList<HashMap<String, String>> getInstalledApp(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 715	com/mob/tools/utils/DeviceHelper:getPackageList	()Ljava/util/ArrayList;
    //   4: astore_2
    //   5: new 334	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 393	java/util/ArrayList:<init>	()V
    //   12: astore 4
    //   14: aload_0
    //   15: getfield 40	com/mob/tools/utils/DeviceHelper:context	Landroid/content/Context;
    //   18: invokevirtual 431	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   21: astore 5
    //   23: aload_2
    //   24: invokevirtual 509	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   27: astore 6
    //   29: aload 6
    //   31: invokeinterface 193 1 0
    //   36: ifeq +154 -> 190
    //   39: aload 6
    //   41: invokeinterface 196 1 0
    //   46: checkcast 47	java/lang/String
    //   49: astore_2
    //   50: aload 5
    //   52: aload_2
    //   53: iconst_0
    //   54: invokevirtual 719	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   57: astore_2
    //   58: aload_2
    //   59: ifnull -30 -> 29
    //   62: iload_1
    //   63: ifne +11 -> 74
    //   66: aload_0
    //   67: aload_2
    //   68: invokespecial 735	com/mob/tools/utils/DeviceHelper:isSystemApp	(Landroid/content/pm/PackageInfo;)Z
    //   71: ifne -42 -> 29
    //   74: new 268	java/util/HashMap
    //   77: dup
    //   78: invokespecial 720	java/util/HashMap:<init>	()V
    //   81: astore 7
    //   83: aload 7
    //   85: ldc_w 722
    //   88: aload_2
    //   89: getfield 723	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   92: invokevirtual 727	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   95: pop
    //   96: aload_2
    //   97: getfield 574	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   100: aload 5
    //   102: invokevirtual 731	android/content/pm/ApplicationInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   105: astore_3
    //   106: aload_3
    //   107: ifnonnull +73 -> 180
    //   110: aload_2
    //   111: getfield 723	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   114: astore_3
    //   115: aload 7
    //   117: ldc_w 745
    //   120: aload_3
    //   121: invokevirtual 727	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   124: pop
    //   125: aload 7
    //   127: ldc_w 747
    //   130: aload_2
    //   131: getfield 750	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   134: invokevirtual 727	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   137: pop
    //   138: aload 4
    //   140: aload 7
    //   142: invokevirtual 414	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   145: pop
    //   146: goto -117 -> 29
    //   149: astore_2
    //   150: invokestatic 78	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   153: aload_2
    //   154: invokevirtual 127	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   157: pop
    //   158: new 334	java/util/ArrayList
    //   161: dup
    //   162: invokespecial 393	java/util/ArrayList:<init>	()V
    //   165: areturn
    //   166: astore_2
    //   167: invokestatic 78	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   170: aload_2
    //   171: invokevirtual 127	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   174: pop
    //   175: aconst_null
    //   176: astore_2
    //   177: goto -119 -> 58
    //   180: aload_3
    //   181: invokeinterface 753 1 0
    //   186: astore_3
    //   187: goto -72 -> 115
    //   190: aload 4
    //   192: areturn
    //   193: astore_3
    //   194: aconst_null
    //   195: astore_3
    //   196: goto -90 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	DeviceHelper
    //   0	199	1	paramBoolean	boolean
    //   4	127	2	localObject1	Object
    //   149	5	2	localThrowable1	Throwable
    //   166	5	2	localThrowable2	Throwable
    //   176	1	2	localObject2	Object
    //   105	82	3	localObject3	Object
    //   193	1	3	localThrowable3	Throwable
    //   195	1	3	localObject4	Object
    //   12	179	4	localArrayList	ArrayList
    //   21	80	5	localPackageManager	PackageManager
    //   27	13	6	localIterator	Iterator
    //   81	60	7	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   0	29	149	java/lang/Throwable
    //   29	50	149	java/lang/Throwable
    //   66	74	149	java/lang/Throwable
    //   74	96	149	java/lang/Throwable
    //   110	115	149	java/lang/Throwable
    //   115	146	149	java/lang/Throwable
    //   167	175	149	java/lang/Throwable
    //   180	187	149	java/lang/Throwable
    //   50	58	166	java/lang/Throwable
    //   96	106	193	java/lang/Throwable
  }
  
  public String getLine1Number()
  {
    try
    {
      if (checkPermission("android.permission.READ_PHONE_STATE"))
      {
        Object localObject = getSystemServiceSave("phone");
        if (localObject == null) {
          return "-1";
        }
        localObject = (String)ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(15), new Object[0]);
        return (String)localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
    return "-1";
  }
  
  public Location getLocation(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      if (checkPermission("android.permission.ACCESS_FINE_LOCATION"))
      {
        Location localLocation = new LocationHelper().getLocation(this.context, paramInt1, paramInt2, paramBoolean);
        return localLocation;
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
    return null;
  }
  
  public String getMCC()
  {
    String str = getIMSI();
    if ((str != null) && (str.length() >= 3)) {
      return str.substring(0, 3);
    }
    return null;
  }
  
  public String getMIUIVersion()
  {
    Object localObject2 = getSystemProperties(Strings.getString(65));
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = getSystemProperties(Strings.getString(66));
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = getSystemProperties(Strings.getString(67));
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = getSystemProperties(Strings.getString(69));
    }
    return (String)localObject1;
  }
  
  public String getMNC()
  {
    String str = getIMSI();
    if ((str != null) && (str.length() >= 5)) {
      return str.substring(3, 5);
    }
    return null;
  }
  
  public String getMacAddress()
  {
    if (!TextUtils.isEmpty(this.wifimac)) {
      return this.wifimac;
    }
    String str = getLocalWifiMac();
    if ((!TextUtils.isEmpty(str)) && (checkMacIsValid(str)))
    {
      this.wifimac = str;
      return str;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      str = getWlanMac();
      if ((str != null) && (!TextUtils.isEmpty(str.trim()))) {
        return str.trim();
      }
      return getWifiMac();
    }
    str = getWifiMac();
    if ((str != null) && (checkMacIsValid(str)))
    {
      this.wifimac = str.trim();
      saveLocalWifiMac(this.wifimac);
      return this.wifimac;
    }
    return getWlanMac();
  }
  
  public String getManufacturer()
  {
    return Build.MANUFACTURER;
  }
  
  public HashMap<String, Long> getMemoryInfo()
  {
    localHashMap = new HashMap();
    localHashMap.put("available", Long.valueOf(-1L));
    localHashMap.put("total", Long.valueOf(-1L));
    localHashMap.put("isLow", Long.valueOf(-1L));
    localHashMap.put("threshold", Long.valueOf(-1L));
    try
    {
      Object localObject = getSystemServiceSave(Strings.getString(30));
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(64), new Object[] { localMemoryInfo });
      localHashMap.put("available", Long.valueOf(localMemoryInfo.availMem));
      localHashMap.put("total", Long.valueOf(localMemoryInfo.totalMem));
      if (localMemoryInfo.lowMemory) {}
      for (long l = 1L;; l = 0L)
      {
        localHashMap.put("isLow", Long.valueOf(l));
        localHashMap.put("threshold", Long.valueOf(localMemoryInfo.threshold));
        return localHashMap;
      }
      return localHashMap;
    }
    catch (Throwable localThrowable) {}
  }
  
  public String getModel()
  {
    String str2 = Build.MODEL;
    String str1 = str2;
    if (!TextUtils.isEmpty(str2)) {
      str1 = str2.trim();
    }
    return str1;
  }
  
  public ArrayList<HashMap<String, Object>> getNeighboringCellInfo()
  {
    int i;
    try
    {
      if (checkPermission("android.permission.ACCESS_COARSE_LOCATION"))
      {
        Object localObject1 = getSystemServiceSave("phone");
        if (localObject1 != null)
        {
          Object localObject2 = (List)ReflectHelper.invokeInstanceMethod(localObject1, Strings.getString(61), new Object[0]);
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject1 = new ArrayList();
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Object localObject3 = ((Iterator)localObject2).next();
              i = ((Integer)ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(localObject3, Strings.getString(27), new Object[0]), Integer.valueOf(-1))).intValue();
              int j = ((Integer)ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(localObject3, Strings.getString(28), new Object[0]), Integer.valueOf(-1))).intValue();
              int k = ((Integer)ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(localObject3, Strings.getString(62), new Object[0]), Integer.valueOf(-1))).intValue();
              int m = ((Integer)ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(localObject3, Strings.getString(63), new Object[0]), Integer.valueOf(-1))).intValue();
              int n = ((Integer)ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(localObject3, Strings.getString(19), new Object[0]), Integer.valueOf(-1))).intValue();
              if ((i != -1) && (j != -1))
              {
                localObject3 = new HashMap();
                ((HashMap)localObject3).put("cell", Integer.valueOf(i));
                ((HashMap)localObject3).put("lac", Integer.valueOf(j));
                ((HashMap)localObject3).put("rssi", Integer.valueOf(k));
                ((HashMap)localObject3).put("psc", Integer.valueOf(m));
                ((HashMap)localObject3).put("networkType", Integer.valueOf(n));
                ((ArrayList)localObject1).add(localObject3);
              }
            }
          }
        }
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
    do
    {
      i = localThrowable.size();
    } while (i <= 0);
    return localThrowable;
  }
  
  public String getNetworkOperator()
  {
    Object localObject = getSystemServiceSave("phone");
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = (String)ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(21), new Object[0]);
      return (String)localObject;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
    return null;
  }
  
  public String getNetworkType()
  {
    for (;;)
    {
      try
      {
        if (!checkPermission("android.permission.ACCESS_NETWORK_STATE")) {
          break label140;
        }
        Object localObject = getSystemServiceSave("connectivity");
        if (localObject == null) {
          break label140;
        }
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
        if ((localObject == null) || (!((NetworkInfo)localObject).isAvailable())) {
          break label140;
        }
        int i = ((NetworkInfo)localObject).getType();
        switch (i)
        {
        case 2: 
        case 3: 
        case 4: 
        case 5: 
          return String.valueOf(i);
        }
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().w(localThrowable);
      }
      if (is4GMobileNetwork()) {
        return "4G";
      }
      if (!isFastMobileNetwork()) {
        break;
      }
      return "3G";
      return "wimax";
      label140:
      return "none";
    }
    return "wifi";
    return "2G";
    return "bluetooth";
    return "dummy";
    return "ethernet";
  }
  
  public String getNetworkTypeForStatic()
  {
    String str = getNetworkType().toLowerCase();
    if ((TextUtils.isEmpty(str)) || ("none".equals(str))) {
      return "none";
    }
    if ((str.startsWith("4g")) || (str.startsWith("3g")) || (str.startsWith("2g"))) {
      return "cell";
    }
    if (str.startsWith("wifi")) {
      return "wifi";
    }
    return "other";
  }
  
  public String getOSCountry()
  {
    return Locale.getDefault().getCountry();
  }
  
  public String getOSLanguage()
  {
    return Locale.getDefault().getLanguage();
  }
  
  public int getOSVersionInt()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public String getOSVersionName()
  {
    return Build.VERSION.RELEASE;
  }
  
  public String getPackageName()
  {
    return this.context.getPackageName();
  }
  
  public int getPlatformCode()
  {
    return 1;
  }
  
  public int getPsc()
  {
    try
    {
      if (checkPermission("android.permission.ACCESS_COARSE_LOCATION"))
      {
        Object localObject = getSystemServiceSave("phone");
        if (localObject != null)
        {
          localObject = ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(26), new Object[0]);
          if ((localObject != null) && (!"CdmaCellLocation".equals(localObject.getClass().getSimpleName())))
          {
            int i = ((Integer)ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(63), new Object[0]), Integer.valueOf(-1))).intValue();
            return i;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
    return -1;
  }
  
  public String getQemuKernel()
  {
    try
    {
      String str = (String)ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(Strings.getString(9)), Strings.getString(10), new Object[] { Strings.getString(53), "0" });
      return str;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
    return "0";
  }
  
  public String getSSID()
  {
    try
    {
      if (checkPermission("android.permission.ACCESS_WIFI_STATE"))
      {
        Object localObject = getSystemServiceSave("wifi");
        if (localObject == null) {
          return null;
        }
        localObject = ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(2), new Object[0]);
        if (localObject != null)
        {
          localObject = (String)ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(3), new Object[0]);
          if (localObject == null) {
            localObject = null;
          } else {
            localObject = ((String)localObject).replace("\"", "");
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
    return null;
    return localThrowable;
  }
  
  public int getScreenBrightness()
  {
    try
    {
      int i = Settings.System.getInt(this.context.getContentResolver(), "screen_brightness");
      return i;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
    return -1;
  }
  
  public int getScreenBrightnessMode()
  {
    try
    {
      int i = Settings.System.getInt(this.context.getContentResolver(), "screen_brightness_mode");
      return i;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
    return -1;
  }
  
  public String getScreenSize()
  {
    int[] arrayOfInt = ResHelper.getScreenSize(this.context);
    if (this.context.getResources().getConfiguration().orientation == 1) {
      return arrayOfInt[0] + "x" + arrayOfInt[1];
    }
    return arrayOfInt[1] + "x" + arrayOfInt[0];
  }
  
  public String getSdcardPath()
  {
    try
    {
      String str = Environment.getExternalStorageDirectory().getAbsolutePath();
      return str;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public boolean getSdcardState()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (checkPermission("android.permission.WRITE_EXTERNAL_STORAGE"))
      {
        boolean bool3 = "mounted".equals(Environment.getExternalStorageState());
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
    return false;
  }
  
  public String getSerialno()
  {
    Object localObject4 = null;
    Object localObject1;
    if (!TextUtils.isEmpty(this.serialno))
    {
      localObject1 = this.serialno;
      return (String)localObject1;
    }
    if ((Build.VERSION.SDK_INT >= 9) && (Build.VERSION.SDK_INT < 26)) {}
    for (;;)
    {
      try
      {
        localObject1 = (String)ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(Strings.getString(9)), Strings.getString(10), new Object[] { Strings.getString(11), "unknown" });
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject3 = localObject1;
          if (!"unknown".equalsIgnoreCase((String)localObject1)) {}
        }
        else
        {
          localObject3 = Build.SERIAL;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject1 = localObject3;
          if (!"unknown".equalsIgnoreCase((String)localObject3)) {}
        }
        else
        {
          localObject1 = localObject3;
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          Object localObject3;
          if (checkPermission("android.permission.READ_PHONE_STATE")) {
            localObject1 = (String)ReflectHelper.invokeStaticMethod(ReflectHelper.importClass("android.os.Build"), "getSerial", new Object[0]);
          }
          if ("unknown".equalsIgnoreCase((String)localObject1))
          {
            localObject1 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject3 = getLocalSerial();
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                break;
              }
              return (String)localObject3;
              localThrowable1 = localThrowable1;
              MobLog.getInstance().d(localThrowable1);
              Object localObject2 = null;
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          MobLog.getInstance().w(localThrowable2);
          str = null;
          continue;
          this.serialno = str;
          str = str.trim();
          saveLocalSerial(str);
          return str;
        }
      }
      continue;
      String str = null;
    }
  }
  
  public String getSignMD5()
  {
    try
    {
      String str = Data.MD5(this.context.getPackageManager().getPackageInfo(getPackageName(), 64).signatures[0].toByteArray());
      return str;
    }
    catch (Exception localException)
    {
      MobLog.getInstance().w(localException);
    }
    return null;
  }
  
  public String getSimSerialNumber()
  {
    try
    {
      if (checkPermission("android.permission.READ_PHONE_STATE"))
      {
        Object localObject = getSystemServiceSave("phone");
        if (localObject == null) {
          return "-1";
        }
        localObject = (String)ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(14), new Object[0]);
        return (String)localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
    return "-1";
  }
  
  public HashMap<String, HashMap<String, Long>> getSizeInfo()
  {
    int i = 0;
    HashMap localHashMap = new HashMap();
    Object localObject1 = new String[2];
    localObject1[0] = "sdcard";
    localObject1[1] = "data";
    int j = localObject1.length;
    Object localObject2;
    Object localObject3;
    while (i < j)
    {
      localObject2 = localObject1[i];
      localObject3 = new HashMap();
      ((HashMap)localObject3).put("available", Long.valueOf(-1L));
      ((HashMap)localObject3).put("free", Long.valueOf(-1L));
      ((HashMap)localObject3).put("total", Long.valueOf(-1L));
      localHashMap.put(localObject2, localObject3);
      i += 1;
    }
    localObject1 = new HashMap();
    for (;;)
    {
      try
      {
        localObject2 = getSdcardPath();
        if (localObject2 != null) {
          ((HashMap)localObject1).put("sdcard", new StatFs((String)localObject2));
        }
      }
      catch (Throwable localThrowable2)
      {
        long l3;
        long l1;
        long l2;
        continue;
      }
      try
      {
        localObject2 = Environment.getDataDirectory();
        if (localObject2 != null) {
          ((HashMap)localObject1).put("data", new StatFs(((File)localObject2).getPath()));
        }
      }
      catch (Throwable localThrowable1) {}
    }
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (StatFs)((Map.Entry)localObject2).getValue();
      if (Build.VERSION.SDK_INT <= 18)
      {
        l3 = ((StatFs)localObject3).getAvailableBlocks() * ((StatFs)localObject3).getBlockSize();
        l1 = ((StatFs)localObject3).getFreeBlocks();
        l2 = ((StatFs)localObject3).getBlockSize() * l1;
      }
      for (l1 = ((StatFs)localObject3).getBlockCount() * ((StatFs)localObject3).getBlockSize();; l1 = ((StatFs)localObject3).getBlockCountLong() * ((StatFs)localObject3).getBlockSizeLong())
      {
        localObject2 = (HashMap)localHashMap.get(((Map.Entry)localObject2).getKey());
        ((HashMap)localObject2).put("available", Long.valueOf(l3));
        ((HashMap)localObject2).put("free", Long.valueOf(l2));
        ((HashMap)localObject2).put("total", Long.valueOf(l1));
        break;
        l3 = ((StatFs)localObject3).getAvailableBlocksLong() * ((StatFs)localObject3).getBlockSizeLong();
        l1 = ((StatFs)localObject3).getFreeBlocksLong();
        l2 = ((StatFs)localObject3).getBlockSizeLong() * l1;
      }
    }
    return localHashMap;
  }
  
  public int getStatusBarHeight()
  {
    if (Build.VERSION.SDK_INT < 28) {
      try
      {
        int i = ((Integer)ReflectHelper.getStaticField(ReflectHelper.importClass("com.android.internal.R$dimen"), "status_bar_height")).intValue();
        i = this.context.getResources().getDimensionPixelSize(i);
        return i;
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().d(localThrowable);
      }
    }
    return -1;
  }
  
  public ArrayList<ArrayList<String>> getTTYDriversInfo()
  {
    ArrayList localArrayList1 = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        FileReader localFileReader = new FileReader(Strings.getString(52));
        BufferedReader localBufferedReader = new BufferedReader(localFileReader);
        Object localObject = localBufferedReader.readLine();
        if (localObject != null)
        {
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            continue;
          }
          localObject = ((String)localObject).trim().split(" ");
          if (localObject.length <= 1) {
            continue;
          }
          ArrayList localArrayList2 = new ArrayList();
          int j = localObject.length;
          i = 0;
          if (i < j)
          {
            CharSequence localCharSequence = localObject[i];
            if (TextUtils.isEmpty(localCharSequence)) {
              break label156;
            }
            localArrayList2.add(localCharSequence.trim());
            break label156;
          }
          localArrayList1.add(localArrayList2);
          continue;
        }
        localBufferedReader.close();
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().d(localThrowable);
        return localArrayList1;
      }
      localThrowable.close();
      return localArrayList1;
      label156:
      i += 1;
    }
  }
  
  public Activity getTopActivity()
  {
    try
    {
      if (Build.VERSION.SDK_INT > 27) {
        return null;
      }
      Object localObject1 = (Map)ReflectHelper.getInstanceField(currentActivityThread(), Strings.getString(23));
      Object localObject2 = ((Map)localObject1).values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (!((Boolean)ReflectHelper.getInstanceField(localObject3, Strings.getString(29))).booleanValue()) {
          return (Activity)ReflectHelper.getInstanceField(localObject3, Strings.getString(30));
        }
      }
      localObject1 = ((Map)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (!((Boolean)ReflectHelper.getInstanceField(localObject2, Strings.getString(24))).booleanValue())
        {
          localObject1 = (Activity)ReflectHelper.getInstanceField(localObject2, Strings.getString(30));
          return (Activity)localObject1;
        }
      }
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public String getWAbcd(int paramInt)
  {
    try
    {
      if (!getSdcardState()) {
        return null;
      }
      String str = getSdcardPath();
      if (TextUtils.isEmpty(str)) {
        return null;
      }
      String[] arrayOfString = Strings.getString(75).split(",");
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = arrayOfString[i];
          if (localObject != null)
          {
            localObject = ((String)localObject).trim();
            boolean bool = TextUtils.isEmpty((CharSequence)localObject);
            if (!bool) {
              try
              {
                localObject = new File(str + (String)localObject, ".mn_" + getFixedString());
                if ((((File)localObject).exists()) && (((File)localObject).isFile()))
                {
                  localObject = getMapFromOtherPlace(((File)localObject).getPath());
                  if (localObject != null)
                  {
                    localObject = (String)((HashMap)localObject).get(String.valueOf(paramInt));
                    if (!TextUtils.isEmpty((CharSequence)localObject))
                    {
                      localObject = ((String)localObject).trim();
                      return (String)localObject;
                    }
                  }
                }
              }
              catch (Throwable localThrowable2)
              {
                MobLog.getInstance().d(localThrowable2);
              }
            }
          }
          i += 1;
        }
      }
      return null;
    }
    catch (Throwable localThrowable1)
    {
      MobLog.getInstance().d(localThrowable1);
    }
  }
  
  public Bitmap getWallPaper()
  {
    int i = 1;
    for (;;)
    {
      try
      {
        Object localObject3 = WallpaperManager.getInstance(this.context);
        Object localObject2 = ((WallpaperManager)localObject3).peekDrawable();
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = ((WallpaperManager)localObject3).getWallpaperInfo().loadThumbnail(this.context.getPackageManager());
          localObject1 = localObject2;
          if (localObject2 == null) {
            return null;
          }
        }
        if ((localObject1 instanceof BitmapDrawable)) {
          return ((BitmapDrawable)localObject1).getBitmap();
        }
        if ((((Drawable)localObject1).getIntrinsicWidth() > 0) && (((Drawable)localObject1).getIntrinsicHeight() > 0))
        {
          j = ((Drawable)localObject1).getIntrinsicWidth();
          i = ((Drawable)localObject1).getIntrinsicHeight();
          localObject2 = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
          localObject3 = new Canvas((Bitmap)localObject2);
          ((Drawable)localObject1).setBounds(0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
          ((Drawable)localObject1).draw((Canvas)localObject3);
          return (Bitmap)localObject2;
        }
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().d(localThrowable);
        return null;
      }
      int j = 1;
    }
  }
  
  public void hideSoftInput(View paramView)
  {
    Object localObject = getSystemServiceSave("input_method");
    if (localObject == null) {
      return;
    }
    ((InputMethodManager)localObject).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  public boolean isPackageInstalled(String paramString)
  {
    boolean bool = false;
    try
    {
      paramString = this.context.getPackageManager().getPackageInfo(paramString, 0);
      if (paramString != null) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public boolean isRooted()
  {
    boolean bool1 = true;
    try
    {
      File localFile = new File(Strings.getString(0));
      if ((localFile.exists()) && (localFile.canExecute())) {
        return true;
      }
      localFile = new File(Strings.getString(1));
      if (localFile.exists())
      {
        boolean bool2 = localFile.canExecute();
        if (bool2) {}
      }
      else
      {
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
      bool1 = false;
    }
    return bool1;
  }
  
  public HashMap<String, String> listNetworkHardware()
    throws Throwable
  {
    Object localObject = NetworkInterface.getNetworkInterfaces();
    if (localObject == null) {
      return null;
    }
    localObject = Collections.list((Enumeration)localObject);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = ((List)localObject).iterator();
    label165:
    label168:
    for (;;)
    {
      NetworkInterface localNetworkInterface;
      if (localIterator.hasNext())
      {
        localNetworkInterface = (NetworkInterface)localIterator.next();
        if (Build.VERSION.SDK_INT < 9) {
          break label165;
        }
      }
      for (localObject = localNetworkInterface.getHardwareAddress();; localObject = null)
      {
        if (localObject == null) {
          break label168;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localStringBuilder.append(String.format("%02x:", new Object[] { Byte.valueOf(localObject[i]) }));
          i += 1;
        }
        if (localStringBuilder.length() > 0) {
          localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        }
        localHashMap.put(localNetworkInterface.getName(), localStringBuilder.toString());
        break;
        return localHashMap;
      }
    }
  }
  
  public HashMap<String, String> ping(String paramString, int paramInt1, int paramInt2)
  {
    float f1 = 0.0F;
    ArrayList localArrayList = new ArrayList();
    Process localProcess;
    label157:
    int i;
    try
    {
      String str1 = "ping -c " + paramInt1 + " -s " + paramInt2 + " " + paramString;
      localProcess = Runtime.getRuntime().exec(str1);
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
      str1 = localBufferedReader.readLine();
      for (;;)
      {
        if (str1 == null) {
          break label388;
        }
        String str2;
        if (str1.startsWith(paramInt2 + 8 + " bytes from"))
        {
          if (!str1.endsWith("ms")) {
            break label210;
          }
          str2 = str1.substring(0, str1.length() - 2).trim();
          i = str2.indexOf("time=");
          if (i > 0) {
            str1 = str2.substring(i + 5).trim();
          }
        }
        try
        {
          localArrayList.add(Float.valueOf(Float.parseFloat(str1)));
          str1 = localBufferedReader.readLine();
          continue;
          label210:
          str2 = str1;
          if (!str1.endsWith("s")) {
            break label157;
          }
          str2 = str1.substring(0, str1.length() - 1).trim() + "000";
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            MobLog.getInstance().w(localThrowable1);
          }
        }
      }
      i = localArrayList.size();
    }
    catch (Throwable localThrowable2)
    {
      MobLog.getInstance().d(localThrowable2);
    }
    int j;
    float f2;
    for (;;)
    {
      j = localArrayList.size();
      if (i <= 0) {
        break label523;
      }
      f2 = Float.MAX_VALUE;
      paramInt2 = 0;
      f3 = 0.0F;
      f1 = 0.0F;
      while (paramInt2 < i)
      {
        float f5 = ((Float)localArrayList.get(paramInt2)).floatValue();
        f4 = f2;
        if (f5 < f2) {
          f4 = f5;
        }
        if (f5 <= f1) {
          break label520;
        }
        f1 = f5;
        paramInt2 += 1;
        f3 += f5;
        f2 = f4;
      }
      label388:
      localProcess.waitFor();
    }
    float f4 = f3 / i;
    float f3 = f1;
    f1 = f4;
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("address", paramString);
      localHashMap.put("transmitted", String.valueOf(paramInt1));
      localHashMap.put("received", String.valueOf(i));
      localHashMap.put("loss", String.valueOf(paramInt1 - j));
      localHashMap.put("min", String.valueOf(f2));
      localHashMap.put("max", String.valueOf(f3));
      localHashMap.put("avg", String.valueOf(f1));
      return localHashMap;
      label520:
      break;
      label523:
      f3 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public String[] queryIMEI()
  {
    for (;;)
    {
      int i;
      int j;
      int k;
      try
      {
        localArrayList = new ArrayList();
        try
        {
          if (checkPermission("android.permission.READ_PHONE_STATE"))
          {
            localObject5 = getSystemServiceSave("phone");
            if (localObject5 == null) {
              return null;
            }
            localObject4 = (String)ReflectHelper.invokeInstanceMethod(localObject5, "getDeviceId", new Object[0]);
            Object localObject1 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject1 = "-1";
            }
            localArrayList.add(localObject1);
            i = 0;
            if (i <= 5) {
              try
              {
                localObject1 = (String)ReflectHelper.invokeInstanceMethod(localObject5, Strings.getString(8), new Object[] { Integer.valueOf(i) });
                localObject4 = localObject1;
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  localObject4 = "-1";
                }
                localArrayList.add(localObject4);
                i += 1;
              }
              catch (Throwable localThrowable1)
              {
                Object localObject2 = null;
                continue;
              }
            }
          }
          int m;
          if (i >= m) {
            continue;
          }
        }
        catch (Throwable localThrowable2)
        {
          MobLog.getInstance().w(localThrowable2);
          localObject4 = Strings.getString(54).split(";");
          localObject3 = new String[localObject4.length][];
          i = 0;
          if (i < localObject4.length)
          {
            localObject3[i] = localObject4[i].split(",");
            i += 1;
            continue;
          }
          m = localObject3.length;
          i = 0;
        }
        Object localObject4 = localObject3[i];
        int n = localObject4.length;
        j = 0;
        if (j >= n) {
          break label364;
        }
        Object localObject5 = getSystemProperties(localObject4[j]).split(",");
        int i1 = localObject5.length;
        k = 0;
        if (k >= i1) {
          break label357;
        }
        CharSequence localCharSequence = localObject5[k];
        if ((TextUtils.isEmpty(localCharSequence)) || (localArrayList.contains(localCharSequence))) {
          break label350;
        }
        localArrayList.add(localCharSequence);
      }
      catch (Throwable localThrowable3)
      {
        ArrayList localArrayList;
        Object localObject3;
        MobLog.getInstance().w(localThrowable3);
      }
      if (localArrayList.size() > 0)
      {
        localObject3 = (String[])localArrayList.toArray(new String[localArrayList.size()]);
        return (String[])localObject3;
      }
      return null;
      label350:
      k += 1;
      continue;
      label357:
      j += 1;
      continue;
      label364:
      i += 1;
    }
  }
  
  public String[] queryIMSI()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject2 = getSystemProperties(Strings.getString(55));
        Object localObject1 = new ArrayList();
        localObject2 = ((String)localObject2).split(",");
        int j = localObject2.length;
        i = 0;
        if (i < j)
        {
          CharSequence localCharSequence = localObject2[i];
          if ((TextUtils.isEmpty(localCharSequence)) || (((ArrayList)localObject1).contains(localCharSequence))) {
            break label108;
          }
          ((ArrayList)localObject1).add(localCharSequence);
          break label108;
        }
        if (((ArrayList)localObject1).size() > 0)
        {
          localObject1 = (String[])((ArrayList)localObject1).toArray(new String[((ArrayList)localObject1).size()]);
          return (String[])localObject1;
        }
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().w(localThrowable);
      }
      return null;
      label108:
      i += 1;
    }
  }
  
  public void saveWabcd(String paramString, int paramInt)
  {
    try
    {
      if (!getSdcardState()) {
        return;
      }
      String str = getSdcardPath();
      if (!TextUtils.isEmpty(str))
      {
        String[] arrayOfString = Strings.getString(75).split(",");
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            Object localObject1 = arrayOfString[i];
            if (localObject1 != null)
            {
              localObject1 = ((String)localObject1).trim();
              boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
              if (bool) {}
            }
            try
            {
              File localFile = new File(str + (String)localObject1, ".mn_" + getFixedString());
              Object localObject2 = null;
              localObject1 = localObject2;
              if (localFile.exists())
              {
                localObject1 = localObject2;
                if (localFile.isFile()) {
                  localObject1 = getMapFromOtherPlace(localFile.getPath());
                }
              }
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new HashMap();
              }
              ((HashMap)localObject2).put(String.valueOf(paramInt), paramString);
              localObject1 = Data.AES128Encode(Strings.getString(76), new Hashon().fromHashMap((HashMap)localObject2));
              ResHelper.saveObjectToFile(localFile.getPath(), localObject1);
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                MobLog.getInstance().d(localThrowable);
              }
            }
            i += 1;
          }
        }
      }
      return;
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().d(paramString);
    }
  }
  
  public boolean scanWifiList()
  {
    try
    {
      if (checkPermission("android.permission.CHANGE_WIFI_STATE"))
      {
        Object localObject = getSystemServiceSave("wifi");
        if (localObject == null) {
          return false;
        }
        boolean bool = ((Boolean)ReflectHelper.invokeInstanceMethod(localObject, Strings.getString(40), new Object[0])).booleanValue();
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
    return false;
  }
  
  public void showSoftInput(View paramView)
  {
    Object localObject = getSystemServiceSave("input_method");
    if (localObject == null) {
      return;
    }
    ((InputMethodManager)localObject).toggleSoftInputFromWindow(paramView.getWindowToken(), 2, 0);
  }
  
  private class GSConnection
    implements ServiceConnection
  {
    boolean got = false;
    private final BlockingQueue<IBinder> iBinders = new LinkedBlockingQueue();
    
    private GSConnection() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      try
      {
        this.iBinders.put(paramIBinder);
        return;
      }
      catch (Throwable paramComponentName)
      {
        MobLog.getInstance().w(paramComponentName);
      }
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName) {}
    
    public IBinder takeBinder()
      throws InterruptedException
    {
      if (this.got) {
        throw new IllegalStateException();
      }
      this.got = true;
      return (IBinder)this.iBinders.poll(1500L, TimeUnit.MILLISECONDS);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/utils/DeviceHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */