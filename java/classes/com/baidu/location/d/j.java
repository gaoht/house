package com.baidu.location.d;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import com.baidu.location.BDLocation;
import com.baidu.location.b.a;
import com.baidu.location.b.d;
import com.baidu.location.b.g;
import com.baidu.location.f;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;

public class j
{
  public static int A = 3;
  public static int B = 10;
  public static int C = 2;
  public static int D = 7;
  public static int E = 20;
  public static int F = 70;
  public static int G = 120;
  public static float H = 2.0F;
  public static float I = 10.0F;
  public static float J = 50.0F;
  public static float K = 200.0F;
  public static int L = 16;
  public static float M = 0.9F;
  public static int N = 10000;
  public static float O = 0.5F;
  public static float P = 0.0F;
  public static float Q = 0.1F;
  public static int R = 30;
  public static int S = 100;
  public static int T = 0;
  public static int U = 0;
  public static int V = 0;
  public static int W = 420000;
  public static boolean X = true;
  public static boolean Y = true;
  public static int Z = 20;
  public static boolean a = false;
  public static int aa = 300;
  public static int ab = 1000;
  public static long ac = 900000L;
  public static long ad = 420000L;
  public static long ae = 180000L;
  public static long af = 0L;
  public static long ag = 15L;
  public static long ah = 300000L;
  public static int ai = 1000;
  public static int aj = 0;
  public static int ak = 30000;
  public static int al = 30000;
  public static float am = 10.0F;
  public static float an = 6.0F;
  public static float ao = 10.0F;
  public static int ap = 60;
  public static int aq = 70;
  public static int ar = 6;
  private static String as;
  private static String at;
  private static String au;
  private static String av;
  private static String aw;
  private static String ax;
  private static String ay;
  public static boolean b = false;
  public static boolean c = false;
  public static int d = 0;
  public static String e;
  public static String f;
  public static boolean g;
  public static boolean h;
  public static boolean i;
  public static boolean j;
  public static boolean k;
  public static String l;
  public static boolean m;
  public static int n;
  public static double o;
  public static double p;
  public static double q;
  public static double r;
  public static int s;
  public static byte[] t;
  public static boolean u;
  public static int v;
  public static float w;
  public static float x;
  public static float y;
  public static float z;
  
  static
  {
    as = "http://loc.map.baidu.com/sdk.php";
    e = "http://loc.map.baidu.com/sdk_ep.php";
    at = "http://loc.map.baidu.com/user_err.php";
    au = "http://loc.map.baidu.com/oqur.php";
    av = "http://loc.map.baidu.com/tcu.php";
    aw = "http://loc.map.baidu.com/rtbu.php";
    ax = "http://loc.map.baidu.com/iofd.php";
    ay = "http://loc.map.baidu.com/wloc";
    f = "no";
    g = false;
    h = false;
    i = false;
    j = false;
    k = false;
    l = "gcj02";
    m = true;
    n = 3;
    o = 0.0D;
    p = 0.0D;
    q = 0.0D;
    r = 0.0D;
    s = 0;
    t = null;
    u = false;
    v = 0;
    w = 1.1F;
    x = 2.2F;
    y = 2.3F;
    z = 3.8F;
  }
  
  public static int a(Context paramContext)
  {
    try
    {
      int i1 = Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on", 0);
      return i1;
    }
    catch (Exception paramContext) {}
    return 2;
  }
  
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.equals(""))) {}
    int i1;
    do
    {
      int i2;
      do
      {
        do
        {
          return Integer.MIN_VALUE;
          i1 = paramString1.indexOf(paramString2);
        } while (i1 == -1);
        i1 += paramString2.length();
        i2 = paramString1.indexOf(paramString3, i1);
      } while (i2 == -1);
      paramString1 = paramString1.substring(i1, i2);
    } while ((paramString1 == null) || (paramString1.equals("")));
    try
    {
      i1 = Integer.parseInt(paramString1);
      return i1;
    }
    catch (NumberFormatException paramString1) {}
    return Integer.MIN_VALUE;
  }
  
  public static Object a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = paramContext.getApplicationContext().getSystemService(paramString);
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static Object a(Object paramObject, String paramString, Object... paramVarArgs)
    throws Exception
  {
    Class localClass = paramObject.getClass();
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i1 = 0;
    int i2 = paramVarArgs.length;
    while (i1 < i2)
    {
      arrayOfClass[i1] = paramVarArgs[i1].getClass();
      if (arrayOfClass[i1] == Integer.class) {
        arrayOfClass[i1] = Integer.TYPE;
      }
      i1 += 1;
    }
    paramString = localClass.getDeclaredMethod(paramString, arrayOfClass);
    if (!paramString.isAccessible()) {
      paramString.setAccessible(true);
    }
    return paramString.invoke(paramObject, paramVarArgs);
  }
  
  public static String a()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i1 = localCalendar.get(5);
    int i2 = localCalendar.get(1);
    int i3 = localCalendar.get(2);
    int i4 = localCalendar.get(11);
    int i5 = localCalendar.get(12);
    int i6 = localCalendar.get(13);
    return String.format(Locale.CHINA, "%d-%02d-%02d %02d:%02d:%02d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3 + 1), Integer.valueOf(i1), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6) });
  }
  
  public static String a(a parama, g paramg, Location paramLocation, String paramString, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(1024);
    String str;
    if (parama != null)
    {
      str = com.baidu.location.b.b.a().b(parama);
      if (str != null) {
        localStringBuffer.append(str);
      }
    }
    if (paramg != null)
    {
      if (paramInt != 0) {
        break label272;
      }
      str = paramg.b();
    }
    for (;;)
    {
      if (str != null) {
        localStringBuffer.append(str);
      }
      if (paramLocation != null)
      {
        if ((d == 0) || (paramInt == 0)) {
          break label281;
        }
        str = d.c(paramLocation);
        label87:
        if (str != null) {
          localStringBuffer.append(str);
        }
      }
      boolean bool = false;
      if (paramInt == 0) {
        bool = true;
      }
      str = b.a().a(bool);
      if (str != null) {
        localStringBuffer.append(str);
      }
      if (paramString != null) {
        localStringBuffer.append(paramString);
      }
      if ((paramInt != 0) || (parama != null))
      {
        parama = com.baidu.location.b.b.a().a(parama);
        if ((parama != null) && (parama.length() + localStringBuffer.length() < 750)) {
          localStringBuffer.append(parama);
        }
      }
      parama = localStringBuffer.toString();
      if ((paramLocation == null) || (paramg == null)) {
        break label351;
      }
      try
      {
        float f1 = paramLocation.getSpeed();
        paramInt = d;
        int i1 = paramg.d();
        int i2 = paramg.a();
        bool = paramg.e();
        if ((f1 < an) && ((paramInt == 1) || (paramInt == 0)) && ((i1 < ap) || (bool == true)))
        {
          n = 1;
          return parama;
          label272:
          str = paramg.c();
          continue;
          label281:
          str = d.b(paramLocation);
          break label87;
        }
        else if ((f1 < ao) && ((paramInt == 1) || (paramInt == 0) || (paramInt == 3)) && ((i1 < aq) || (i2 > ar)))
        {
          n = 2;
          return parama;
        }
      }
      catch (Exception paramg)
      {
        n = 3;
        return parama;
      }
    }
    n = 3;
    return parama;
    label351:
    n = 3;
    return parama;
  }
  
  public static String a(File paramFile, String paramString)
  {
    if (!paramFile.isFile()) {
      return null;
    }
    byte[] arrayOfByte = new byte['Ѐ'];
    try
    {
      paramString = MessageDigest.getInstance(paramString);
      paramFile = new FileInputStream(paramFile);
      for (;;)
      {
        int i1 = paramFile.read(arrayOfByte, 0, 1024);
        if (i1 == -1) {
          break;
        }
        paramString.update(arrayOfByte, 0, i1);
      }
      paramFile.close();
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
      return null;
    }
    return new BigInteger(1, paramString.digest()).toString(16);
  }
  
  public static boolean a(BDLocation paramBDLocation)
  {
    int i1 = paramBDLocation.getLocType();
    return (i1 > 100) && (i1 < 200);
  }
  
  public static int b(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 23) {}
    try
    {
      int i1 = Settings.Secure.getInt(paramContext.getContentResolver(), "location_mode", -1);
      return i1;
    }
    catch (Exception paramContext) {}
    return -2;
    return -1;
  }
  
  private static int b(Context paramContext, String paramString)
  {
    if (paramContext.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0) {}
    for (int i1 = 1; i1 == 0; i1 = 0) {
      return 0;
    }
    return 1;
  }
  
  public static int b(Object paramObject, String paramString, Object... paramVarArgs)
    throws Exception
  {
    Class localClass = paramObject.getClass();
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i1 = 0;
    int i2 = paramVarArgs.length;
    while (i1 < i2)
    {
      arrayOfClass[i1] = paramVarArgs[i1].getClass();
      if (arrayOfClass[i1] == Integer.class) {
        arrayOfClass[i1] = Integer.TYPE;
      }
      i1 += 1;
    }
    paramString = localClass.getDeclaredMethod(paramString, arrayOfClass);
    if (!paramString.isAccessible()) {
      paramString.setAccessible(true);
    }
    return ((Integer)paramString.invoke(paramObject, paramVarArgs)).intValue();
  }
  
  public static String b()
  {
    try
    {
      Object localObject2;
      Object localObject3;
      do
      {
        localObject1 = NetworkInterface.getNetworkInterfaces();
        while (!((Enumeration)localObject2).hasMoreElements())
        {
          if (!((Enumeration)localObject1).hasMoreElements()) {
            break;
          }
          localObject2 = ((NetworkInterface)((Enumeration)localObject1).nextElement()).getInetAddresses();
        }
        localObject3 = (InetAddress)((Enumeration)localObject2).nextElement();
      } while ((((InetAddress)localObject3).isLoopbackAddress()) || (!(localObject3 instanceof Inet4Address)));
      byte[] arrayOfByte = ((InetAddress)localObject3).getAddress();
      int i1 = 0;
      Object localObject1 = "";
      for (;;)
      {
        localObject2 = localObject1;
        if (i1 >= arrayOfByte.length) {
          break;
        }
        localObject3 = Integer.toHexString(arrayOfByte[i1] & 0xFF);
        localObject2 = localObject3;
        if (((String)localObject3).length() == 1) {
          localObject2 = '0' + (String)localObject3;
        }
        localObject1 = (String)localObject1 + (String)localObject2;
        i1 += 1;
      }
      return (String)localObject2;
    }
    catch (Exception localException)
    {
      localObject2 = null;
    }
  }
  
  public static boolean b(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString3 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(com.baidu.android.bbalbs.common.a.b.a(paramString3.getBytes())));
      Signature localSignature = Signature.getInstance("SHA1WithRSA");
      localSignature.initVerify(paramString3);
      localSignature.update(paramString1.getBytes());
      boolean bool = localSignature.verify(com.baidu.android.bbalbs.common.a.b.a(paramString2.getBytes()));
      return bool;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return false;
  }
  
  public static String c()
  {
    return as;
  }
  
  public static String c(Context paramContext)
  {
    int i1 = b(paramContext, "android.permission.ACCESS_COARSE_LOCATION");
    int i2 = b(paramContext, "android.permission.ACCESS_FINE_LOCATION");
    int i3 = b(paramContext, "android.permission.READ_PHONE_STATE");
    return "&per=" + i1 + "|" + i2 + "|" + i3;
  }
  
  public static String d()
  {
    return av;
  }
  
  public static String d(Context paramContext)
  {
    int i1 = -1;
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((paramContext == null) || (!paramContext.isAvailable())) {
          break label63;
        }
        int i2 = paramContext.getType();
        i1 = i2;
      }
      catch (Exception paramContext)
      {
        continue;
      }
      return "&netc=" + i1;
      label63:
      i1 = -1;
    }
  }
  
  public static String e()
  {
    try
    {
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        String str = Environment.getExternalStorageDirectory().getPath();
        File localFile = new File(str + "/baidu/tempdata");
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        return str;
      }
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String f()
  {
    String str = e();
    if (str == null) {
      return null;
    }
    return str + "/baidu/tempdata";
  }
  
  public static String g()
  {
    try
    {
      Object localObject = new File(f.getServiceContext().getFilesDir() + File.separator + "lldt");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = ((File)localObject).getAbsolutePath();
      return (String)localObject;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/d/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */