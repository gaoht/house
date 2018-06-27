package com.g.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class l
{
  static TelephonyManager a;
  static String b;
  private static final Pattern c = Pattern.compile("^([0-9A-F]{2}:){5}([0-9A-F]{2})$");
  private static final Pattern d = Pattern.compile("[0-3][0-9a-f]{24,32}");
  private static final Pattern e = Pattern.compile("[0-3][0-9a-f]{32}");
  private static String f = null;
  private static boolean g = false;
  private static String h = null;
  
  public static final String a()
  {
    try
    {
      if (z.a(9))
      {
        String str = Build.SERIAL;
        return str;
      }
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = j(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  static String a(Context paramContext, boolean paramBoolean)
  {
    Object localObject1;
    if ((z.a(23)) && (paramContext.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0))
    {
      localObject1 = null;
      return (String)localObject1;
    }
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      Object localObject2 = Environment.getExternalStorageDirectory();
      if (paramBoolean) {}
      for (localObject1 = ".tcookieid";; localObject1 = ".tcookieid" + i(paramContext))
      {
        localObject2 = a(new File((File)localObject2, (String)localObject1));
        localObject1 = localObject2;
        if (!z.b((String)localObject2)) {
          break;
        }
        return a(new File(Environment.getExternalStorageDirectory(), ".tid" + i(paramContext)));
      }
    }
    return "";
  }
  
  private static String a(File paramFile)
  {
    try
    {
      if ((paramFile.exists()) && (paramFile.canRead()))
      {
        paramFile = new FileInputStream(paramFile);
        byte[] arrayOfByte = new byte[''];
        int i = paramFile.read(arrayOfByte);
        paramFile.close();
        paramFile = new String(arrayOfByte, 0, i);
        return paramFile;
      }
    }
    catch (Throwable paramFile) {}
    return null;
  }
  
  private static void a(Context paramContext, String paramString)
  {
    try
    {
      File[] arrayOfFile = new File("/").listFiles();
      if (arrayOfFile != null)
      {
        if (arrayOfFile.length == 0) {
          return;
        }
        int k = arrayOfFile.length;
        int i = 0;
        while (i < k)
        {
          Object localObject = arrayOfFile[i];
          if ((((File)localObject).isDirectory()) && (!"/sdcard".equals(((File)localObject).getAbsolutePath())))
          {
            if ((((File)localObject).canWrite()) && (!new File((File)localObject, ".tcookieid" + i(paramContext)).exists())) {
              a(new File((File)localObject, ".tcookieid"), paramString);
            }
            if (((File)localObject).listFiles() != null)
            {
              localObject = ((File)localObject).listFiles();
              int m = localObject.length;
              int j = 0;
              while (j < m)
              {
                File localFile = localObject[j];
                if ((localFile.isDirectory()) && (localFile.canWrite()) && (!new File(localFile, ".tcookieid" + i(paramContext)).exists())) {
                  a(new File(localFile, ".tcookieid"), paramString);
                }
                j += 1;
              }
            }
          }
          i += 1;
        }
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      File localFile = Environment.getExternalStorageDirectory();
      if (paramBoolean) {}
      for (paramContext = ".tcookieid";; paramContext = ".tcookieid" + i(paramContext))
      {
        a(new File(localFile, paramContext), paramString);
        return;
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private static void a(File paramFile, String paramString)
  {
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.close();
      if (z.a(9))
      {
        paramFile.getClass().getMethod("setReadable", new Class[] { Boolean.TYPE, Boolean.TYPE }).invoke(paramFile, new Object[] { Boolean.valueOf(true), Boolean.valueOf(false) });
        return;
      }
      Runtime.getRuntime().exec("chmod 444 " + paramFile.getAbsolutePath());
      return;
    }
    catch (Throwable paramFile) {}
  }
  
  /* Error */
  static String b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aload 8
    //   11: astore 5
    //   13: new 95	java/io/File
    //   16: dup
    //   17: ldc -109
    //   19: invokespecial 150	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: invokevirtual 154	java/io/File:listFiles	()[Ljava/io/File;
    //   25: astore 9
    //   27: aload 9
    //   29: ifnull +269 -> 298
    //   32: aload 8
    //   34: astore 5
    //   36: aload 9
    //   38: arraylength
    //   39: ifne +5 -> 44
    //   42: aconst_null
    //   43: areturn
    //   44: aload 8
    //   46: astore 5
    //   48: aload 9
    //   50: arraylength
    //   51: istore_2
    //   52: iconst_0
    //   53: istore_0
    //   54: aload 7
    //   56: astore 6
    //   58: iload_0
    //   59: iload_2
    //   60: if_icmpge +238 -> 298
    //   63: aload 9
    //   65: iload_0
    //   66: aaload
    //   67: astore 10
    //   69: aload 7
    //   71: astore 8
    //   73: aload 7
    //   75: astore 5
    //   77: aload 10
    //   79: invokevirtual 157	java/io/File:isDirectory	()Z
    //   82: ifeq +199 -> 281
    //   85: aload 7
    //   87: astore 8
    //   89: aload 7
    //   91: astore 5
    //   93: ldc -97
    //   95: aload 10
    //   97: invokevirtual 162	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   100: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   103: ifne +178 -> 281
    //   106: aload 7
    //   108: astore 6
    //   110: aload 7
    //   112: astore 5
    //   114: aload 10
    //   116: invokevirtual 165	java/io/File:canWrite	()Z
    //   119: ifeq +43 -> 162
    //   122: aload 7
    //   124: astore 5
    //   126: new 95	java/io/File
    //   129: dup
    //   130: aload 10
    //   132: ldc 93
    //   134: invokespecial 98	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   137: invokestatic 101	com/g/a/l:a	(Ljava/io/File;)Ljava/lang/String;
    //   140: astore 7
    //   142: aload 7
    //   144: astore 5
    //   146: aload 7
    //   148: astore 6
    //   150: aload 7
    //   152: invokestatic 104	com/g/a/z:b	(Ljava/lang/String;)Z
    //   155: ifeq +143 -> 298
    //   158: aload 7
    //   160: astore 6
    //   162: aload 6
    //   164: astore 8
    //   166: aload 6
    //   168: astore 5
    //   170: aload 10
    //   172: invokevirtual 154	java/io/File:listFiles	()[Ljava/io/File;
    //   175: ifnull +106 -> 281
    //   178: aload 6
    //   180: astore 5
    //   182: aload 10
    //   184: invokevirtual 154	java/io/File:listFiles	()[Ljava/io/File;
    //   187: astore 10
    //   189: aload 6
    //   191: astore 5
    //   193: aload 10
    //   195: arraylength
    //   196: istore_3
    //   197: iconst_0
    //   198: istore_1
    //   199: aload 6
    //   201: astore 8
    //   203: iload_1
    //   204: iload_3
    //   205: if_icmpge +76 -> 281
    //   208: aload 10
    //   210: iload_1
    //   211: aaload
    //   212: astore 8
    //   214: aload 6
    //   216: astore 7
    //   218: aload 6
    //   220: astore 5
    //   222: aload 8
    //   224: invokevirtual 157	java/io/File:isDirectory	()Z
    //   227: ifeq +43 -> 270
    //   230: aload 6
    //   232: astore 5
    //   234: new 95	java/io/File
    //   237: dup
    //   238: aload 8
    //   240: ldc 93
    //   242: invokespecial 98	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   245: invokestatic 101	com/g/a/l:a	(Ljava/io/File;)Ljava/lang/String;
    //   248: astore 7
    //   250: aload 7
    //   252: astore 5
    //   254: aload 7
    //   256: invokestatic 104	com/g/a/z:b	(Ljava/lang/String;)Z
    //   259: istore 4
    //   261: aload 7
    //   263: astore 6
    //   265: iload 4
    //   267: ifeq +31 -> 298
    //   270: iload_1
    //   271: iconst_1
    //   272: iadd
    //   273: istore_1
    //   274: aload 7
    //   276: astore 6
    //   278: goto -79 -> 199
    //   281: iload_0
    //   282: iconst_1
    //   283: iadd
    //   284: istore_0
    //   285: aload 8
    //   287: astore 7
    //   289: goto -235 -> 54
    //   292: astore 6
    //   294: aload 5
    //   296: astore 6
    //   298: aload 6
    //   300: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   53	232	0	i	int
    //   198	76	1	j	int
    //   51	10	2	k	int
    //   196	10	3	m	int
    //   259	7	4	bool	boolean
    //   11	284	5	localObject1	Object
    //   4	273	6	localObject2	Object
    //   292	1	6	localThrowable	Throwable
    //   296	3	6	localObject3	Object
    //   7	281	7	localObject4	Object
    //   1	285	8	localObject5	Object
    //   25	39	9	arrayOfFile	File[]
    //   67	142	10	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   13	27	292	java/lang/Throwable
    //   36	42	292	java/lang/Throwable
    //   48	52	292	java/lang/Throwable
    //   77	85	292	java/lang/Throwable
    //   93	106	292	java/lang/Throwable
    //   114	122	292	java/lang/Throwable
    //   126	142	292	java/lang/Throwable
    //   150	158	292	java/lang/Throwable
    //   170	178	292	java/lang/Throwable
    //   182	189	292	java/lang/Throwable
    //   193	197	292	java/lang/Throwable
    //   222	230	292	java/lang/Throwable
    //   234	250	292	java/lang/Throwable
    //   254	261	292	java/lang/Throwable
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  private static void b(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("tdid", 0);
      if (paramContext != null)
      {
        paramContext = paramContext.edit();
        paramContext.putString("pref.deviceid.key", paramString);
        paramContext.commit();
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static String c(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if ((z.a(23)) && (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0)) {
          return null;
        }
        if (z.b(paramContext, "android.permission.READ_PHONE_STATE"))
        {
          if (a == null) {
            init(paramContext);
          }
          paramContext = r.x(paramContext);
          if (paramContext != null)
          {
            int i = paramContext.length();
            if (i == 2) {
              try
              {
                paramContext = paramContext.getJSONObject(1).getString("imei");
                if (paramContext != null) {
                  break;
                }
                paramContext = a.getDeviceId();
                return paramContext;
              }
              catch (Exception paramContext)
              {
                paramContext = null;
                continue;
              }
            }
          }
        }
        else
        {
          return null;
        }
      }
      catch (Throwable paramContext) {}
      paramContext = null;
    }
    return paramContext;
  }
  
  static boolean c()
  {
    for (;;)
    {
      try
      {
        if (!z.a(9)) {
          break label49;
        }
        bool = ((Boolean)Environment.class.getMethod("isExternalStorageRemovable", new Class[0]).invoke(null, new Object[0])).booleanValue();
        if (!bool) {
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        bool = true;
        continue;
      }
      return false;
      label49:
      boolean bool = true;
    }
  }
  
  public static String d(Context paramContext)
  {
    try
    {
      if ((z.a(23)) && (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0)) {
        return null;
      }
      if (z.b(paramContext, "android.permission.READ_PHONE_STATE"))
      {
        if (a == null) {
          init(paramContext);
        }
        paramContext = a.getSimSerialNumber();
        return paramContext;
      }
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static String e(Context paramContext)
  {
    try
    {
      if ((z.a(23)) && (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0)) {
        return null;
      }
      if (z.b(paramContext, "android.permission.READ_PHONE_STATE"))
      {
        if (a == null) {
          init(paramContext);
        }
        paramContext = a.getSubscriberId();
        return paramContext;
      }
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static String f(Context paramContext)
  {
    Iterator localIterator = null;
    Object localObject2 = null;
    if (!z.a) {
      paramContext = null;
    }
    for (;;)
    {
      return paramContext;
      try
      {
        boolean bool = z.a(23);
        Object localObject1;
        if (bool)
        {
          localObject1 = localIterator;
          try
          {
            paramContext = Collections.list(NetworkInterface.getNetworkInterfaces());
            if (paramContext == null) {
              break label389;
            }
            localObject1 = localIterator;
            if (paramContext.size() <= 0) {
              break label389;
            }
            localObject1 = localIterator;
            localIterator = paramContext.iterator();
            paramContext = (Context)localObject2;
            for (;;)
            {
              localObject1 = paramContext;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject1 = paramContext;
              localObject2 = (NetworkInterface)localIterator.next();
              localObject1 = paramContext;
              if (((NetworkInterface)localObject2).getName().equalsIgnoreCase("wlan0"))
              {
                localObject1 = paramContext;
                localObject2 = ((NetworkInterface)localObject2).getHardwareAddress();
                if (localObject2 == null) {
                  return "";
                }
                localObject1 = paramContext;
                StringBuilder localStringBuilder = new StringBuilder();
                localObject1 = paramContext;
                int j = localObject2.length;
                int i = 0;
                while (i < j)
                {
                  localObject1 = paramContext;
                  localStringBuilder.append(String.format("%02X:", new Object[] { Byte.valueOf(localObject2[i]) }));
                  i += 1;
                }
                localObject1 = paramContext;
                if (localStringBuilder.length() > 0)
                {
                  localObject1 = paramContext;
                  localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
                }
                localObject1 = paramContext;
                paramContext = localStringBuilder.toString().toUpperCase().trim();
              }
            }
            localObject1 = paramContext;
            paramContext = (Context)localObject1;
          }
          catch (Throwable paramContext)
          {
            for (;;)
            {
              try
              {
                bool = z.b((String)localObject1);
                paramContext = (Context)localObject1;
                if (!bool) {
                  break;
                }
                return "02:00:00:00:00:00";
              }
              catch (Throwable localThrowable2)
              {
                continue;
              }
              paramContext = paramContext;
            }
          }
        }
        else if (z.b(paramContext, "android.permission.ACCESS_WIFI_STATE"))
        {
          paramContext = (WifiManager)paramContext.getSystemService("wifi");
          if (paramContext.isWifiEnabled())
          {
            paramContext = paramContext.getConnectionInfo();
            if (paramContext != null)
            {
              localObject1 = paramContext.getMacAddress();
              paramContext = (Context)localObject1;
              if (localObject1 == null) {
                continue;
              }
              paramContext = (Context)localObject1;
              localObject1 = ((String)localObject1).toUpperCase().trim();
              paramContext = (Context)localObject1;
              if (!"00:00:00:00:00:00".equals(localObject1))
              {
                paramContext = (Context)localObject1;
                bool = c.matcher((CharSequence)localObject1).matches();
                paramContext = (Context)localObject1;
                if (bool) {
                  continue;
                }
              }
              return null;
            }
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        paramContext = null;
        av.postSDKError(localThrowable1);
        return paramContext;
      }
    }
    return null;
    label389:
    return "02:00:00:00:00:00";
  }
  
  public static final String g(Context paramContext)
  {
    try
    {
      if (!g)
      {
        paramContext = new m(paramContext);
        paramContext.setName("TD_ADID");
        paramContext.start();
      }
      paramContext = f;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      av.postSDKError(paramContext);
    }
    return null;
  }
  
  static String h(Context paramContext)
  {
    try
    {
      String str2 = v.b(paramContext, "tdid", "pref.deviceid.key", null);
      String str1 = str2;
      if (z.b(str2)) {
        str1 = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("pref.deviceid.key", null);
      }
      return str1;
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  static String i(Context paramContext)
  {
    if (h == null) {
      try
      {
        localObject = ((SensorManager)paramContext.getSystemService("sensor")).getSensorList(-1);
        paramContext = new Sensor[64];
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Sensor localSensor = (Sensor)((Iterator)localObject).next();
          if ((localSensor.getType() < paramContext.length) && (localSensor.getType() >= 0))
          {
            paramContext[localSensor.getType()] = localSensor;
            continue;
            return h;
          }
        }
      }
      catch (Throwable paramContext) {}
    }
    Object localObject = new StringBuffer();
    int i = 0;
    for (;;)
    {
      if (i < paramContext.length)
      {
        if (paramContext[i] != null) {
          ((StringBuffer)localObject).append(i).append('.').append(paramContext[i].getVendor()).append('-').append(paramContext[i].getName()).append('-').append(paramContext[i].getVersion()).append('\n');
        }
      }
      else
      {
        h = String.valueOf(((StringBuffer)localObject).toString().hashCode());
        break;
      }
      i += 1;
    }
  }
  
  public static void init(Context paramContext)
  {
    try
    {
      a = (TelephonyManager)paramContext.getSystemService("phone");
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private static String j(Context paramContext)
  {
    int j = 0;
    String str1 = h(paramContext);
    String str2 = b();
    boolean bool = c();
    String str3 = a(paramContext, bool);
    String[] arrayOfString = new String[3];
    arrayOfString[0] = str1;
    arrayOfString[1] = str2;
    arrayOfString[2] = str3;
    int k = arrayOfString.length;
    int i = 0;
    Object localObject1;
    if (i < k)
    {
      localObject1 = arrayOfString[i];
      if ((z.b((String)localObject1)) || (!e.matcher((CharSequence)localObject1).matches())) {}
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (z.b((String)localObject1))
      {
        localObject2 = localObject1;
        if (!z.b(str1))
        {
          localObject2 = localObject1;
          if (Math.random() < 0.99D)
          {
            k = arrayOfString.length;
            i = j;
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (i < k)
        {
          localObject2 = arrayOfString[i];
          if ((z.b((String)localObject2)) || (!d.matcher((CharSequence)localObject2).matches())) {}
        }
        else
        {
          localObject1 = localObject2;
          if (z.b((String)localObject2)) {
            localObject1 = k(paramContext);
          }
          if (!((String)localObject1).equals(str1)) {
            b(paramContext, (String)localObject1);
          }
          if (!((String)localObject1).equals(str3)) {
            a(paramContext, (String)localObject1, bool);
          }
          if (!((String)localObject1).equals(str2)) {
            a(paramContext, (String)localObject1);
          }
          return (String)localObject1;
          i += 1;
          break;
        }
        i += 1;
      }
      localObject1 = null;
    }
  }
  
  private static String k(Context paramContext)
  {
    paramContext = l(paramContext);
    return "3" + z.c(paramContext);
  }
  
  private static String l(Context paramContext)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(c(paramContext)).append('-').append(f(paramContext)).append('-').append(b(paramContext));
      paramContext = localStringBuilder.toString();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */