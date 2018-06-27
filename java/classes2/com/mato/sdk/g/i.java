package com.mato.sdk.g;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.mato.sdk.b.g;
import com.mato.sdk.d.m;
import java.io.File;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;

public final class i
{
  private static final String a = g.b("");
  private static final Random b = new Random();
  
  public static TelephonyManager a(Context paramContext)
  {
    return (TelephonyManager)paramContext.getSystemService("phone");
  }
  
  public static String a()
  {
    return new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new Date());
  }
  
  public static String a(Context paramContext, String paramString)
  {
    String str = paramString;
    if (e(paramContext, "android.permission.READ_PHONE_STATE")) {
      str = c(paramContext, paramString);
    }
    return str;
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = InetAddress.getByName(paramString).getHostAddress();
      return paramString;
    }
    catch (Throwable paramString)
    {
      return null;
    }
    catch (UnknownHostException paramString) {}
    return null;
  }
  
  public static List<Class<?>> a(Class<?> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    a(paramClass, localLinkedHashSet);
    return new ArrayList(localLinkedHashSet);
  }
  
  private static void a(Class<?> paramClass, HashSet<Class<?>> paramHashSet)
  {
    while (paramClass != null)
    {
      Class[] arrayOfClass = paramClass.getInterfaces();
      int j = arrayOfClass.length;
      int i = 0;
      while (i < j)
      {
        Class localClass = arrayOfClass[i];
        if (paramHashSet.add(localClass)) {
          a(localClass, paramHashSet);
        }
        i += 1;
      }
      paramClass = paramClass.getSuperclass();
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  public static ConnectivityManager b(Context paramContext)
  {
    return (ConnectivityManager)paramContext.getSystemService("connectivity");
  }
  
  public static String b(Context paramContext, String paramString)
  {
    String str = paramString;
    if (e(paramContext, "android.permission.READ_PHONE_STATE")) {
      str = d(paramContext, paramString);
    }
    return str;
  }
  
  public static List<String> b()
  {
    localArrayList = new ArrayList();
    try
    {
      Method localMethod = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
      int i = 0;
      while (i < 4)
      {
        String str = (String)localMethod.invoke(null, new Object[] { new String[] { "net.dns1", "net.dns2", "net.dns3", "net.dns4" }[i] });
        if ((str != null) && ((str.matches("^\\d+(\\.\\d+){3}$")) || (str.matches("^[0-9a-f]+(:[0-9a-f]*)+:[0-9a-f]+$"))) && (!localArrayList.contains(str))) {
          localArrayList.add(str);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  public static String[] b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 167	java/net/InetAddress:getAllByName	(Ljava/lang/String;)[Ljava/net/InetAddress;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +36 -> 42
    //   9: aload_3
    //   10: arraylength
    //   11: anewarray 131	java/lang/String
    //   14: astore_2
    //   15: iconst_0
    //   16: istore_1
    //   17: aload_2
    //   18: astore_0
    //   19: iload_1
    //   20: aload_3
    //   21: arraylength
    //   22: if_icmpge +22 -> 44
    //   25: aload_2
    //   26: iload_1
    //   27: aload_3
    //   28: iload_1
    //   29: aaload
    //   30: invokevirtual 77	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   33: aastore
    //   34: iload_1
    //   35: iconst_1
    //   36: iadd
    //   37: istore_1
    //   38: goto -21 -> 17
    //   41: astore_0
    //   42: aconst_null
    //   43: astore_0
    //   44: aload_0
    //   45: areturn
    //   46: astore_0
    //   47: goto -5 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	paramString	String
    //   16	22	1	i	int
    //   14	12	2	arrayOfString	String[]
    //   4	24	3	arrayOfInetAddress	InetAddress[]
    // Exception table:
    //   from	to	target	type
    //   0	5	41	java/lang/Throwable
    //   9	15	41	java/lang/Throwable
    //   19	34	41	java/lang/Throwable
    //   0	5	46	java/net/UnknownHostException
    //   9	15	46	java/net/UnknownHostException
    //   19	34	46	java/net/UnknownHostException
  }
  
  public static String c(Context paramContext)
  {
    return paramContext.getFilesDir().getAbsolutePath();
  }
  
  private static String c(Context paramContext, String paramString)
  {
    try
    {
      paramContext = a(paramContext).getDeviceId();
      boolean bool = TextUtils.isEmpty(paramContext);
      if (bool) {
        return paramString;
      }
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return paramString;
  }
  
  public static boolean c()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  public static String d(Context paramContext)
  {
    Object localObject = paramContext.getPackageManager();
    paramContext = g(paramContext);
    String str = "";
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(paramContext, 64);
      paramContext = str;
      if (localObject != null)
      {
        localObject = ((PackageInfo)localObject).signatures;
        paramContext = str;
        if (localObject.length > 0) {
          paramContext = m.a(localObject[0].toByteArray());
        }
      }
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return "";
  }
  
  private static String d(Context paramContext, String paramString)
  {
    try
    {
      TelephonyManager localTelephonyManager = a(paramContext);
      String str = localTelephonyManager.getSubscriberId();
      paramContext = str;
      if (TextUtils.isEmpty(str)) {
        paramContext = localTelephonyManager.getSimOperator();
      }
      boolean bool = TextUtils.isEmpty(paramContext);
      if (bool) {
        return paramString;
      }
    }
    catch (Throwable paramContext)
    {
      return paramString;
    }
    return paramContext;
  }
  
  public static Random d()
  {
    return b;
  }
  
  private static String e()
  {
    try
    {
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        String str = Environment.getExternalStorageDirectory().getAbsolutePath();
        return str;
      }
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static String e(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    String str = g(paramContext);
    try
    {
      ApplicationInfo localApplicationInfo = localPackageManager.getApplicationInfo(str, 0);
      paramContext = str;
      if (localApplicationInfo != null) {
        paramContext = localPackageManager.getApplicationLabel(localApplicationInfo).toString();
      }
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.toString();
      return str;
    }
    catch (SecurityException paramContext)
    {
      paramContext.toString();
    }
    return str;
  }
  
  private static boolean e(Context paramContext, String paramString)
  {
    return (Build.VERSION.SDK_INT < 23) || (paramContext.checkSelfPermission(paramString) == 0);
  }
  
  public static String f(Context paramContext)
  {
    Object localObject2 = paramContext.getPackageManager();
    Object localObject1 = null;
    try
    {
      localObject2 = ((PackageManager)localObject2).getPackageInfo(g(paramContext), 0);
      paramContext = (Context)localObject1;
      if (localObject2 != null) {
        paramContext = ((PackageInfo)localObject2).versionName;
      }
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static String g(Context paramContext)
  {
    ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
    if ((localApplicationInfo != null) && (!TextUtils.isEmpty(localApplicationInfo.packageName))) {
      return localApplicationInfo.packageName;
    }
    return paramContext.getPackageName();
  }
  
  public static String h(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        paramContext = paramContext.getExtraInfo();
        return paramContext;
      }
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  public static DisplayMetrics i(Context paramContext)
  {
    try
    {
      paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext.getMetrics(localDisplayMetrics);
      return localDisplayMetrics;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static boolean j(Context paramContext)
  {
    try
    {
      paramContext = b(paramContext).getActiveNetworkInfo();
      if (paramContext != null)
      {
        paramContext = paramContext.getExtraInfo();
        if (paramContext != null)
        {
          boolean bool = paramContext.equalsIgnoreCase("3gwap");
          if (bool) {
            return true;
          }
        }
        return false;
      }
      return false;
    }
    catch (Throwable paramContext) {}
    return true;
  }
  
  public static String k(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    int i = Process.myPid();
    for (paramContext = (ActivityManager)paramContext.getSystemService("activity");; paramContext = null)
    {
      try
      {
        paramContext = paramContext.getRunningAppProcesses();
        if (paramContext == null) {
          continue;
        }
        paramContext = paramContext.iterator();
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
        do
        {
          if (!paramContext.hasNext()) {
            break;
          }
          localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        } while (localRunningAppProcessInfo.pid != i);
        paramContext = localRunningAppProcessInfo.processName;
      }
      catch (SecurityException paramContext)
      {
        for (;;)
        {
          paramContext = null;
        }
      }
      return paramContext;
    }
  }
  
  public static String l(Context paramContext)
  {
    paramContext = k(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.split(":");
      if (paramContext.length == 2) {
        return paramContext[1];
      }
      return "";
    }
    return null;
  }
  
  public static Context m(Context paramContext)
  {
    Context localContext = paramContext;
    if (!(paramContext instanceof Application)) {
      localContext = paramContext.getApplicationContext();
    }
    return localContext;
  }
  
  public static String n(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (e(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE"))
    {
      localObject1 = localObject2;
      if (e(paramContext, "android.permission.READ_EXTERNAL_STORAGE")) {
        localObject1 = e();
      }
    }
    return (String)localObject1;
  }
  
  private static WifiManager o(Context paramContext)
  {
    return (WifiManager)paramContext.getSystemService("wifi");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/g/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */