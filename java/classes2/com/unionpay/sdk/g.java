package com.unionpay.sdk;

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
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class g
{
  static TelephonyManager a;
  static String b;
  private static final Pattern c = Pattern.compile("^([0-9A-F]{2}:){5}([0-9A-F]{2})$");
  private static final Pattern d = Pattern.compile("[0-3][0-9a-f]{24,32}");
  private static final Pattern e = Pattern.compile("[0-3][0-9a-f]{32}");
  private static String f = null;
  
  public static final String a()
  {
    try
    {
      if (r.a(9))
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
    int k = 0;
    for (;;)
    {
      Object localObject3;
      boolean bool1;
      int j;
      int i;
      Object localObject5;
      try
      {
        if (b == null)
        {
          localObject3 = l.b(paramContext, "tdid", "pref.deviceid.key", null);
          if (!r.b((String)localObject3)) {
            break label769;
          }
          localObject3 = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("pref.deviceid.key", null);
          localObject4 = new File("/").listFiles();
          if (localObject4 == null) {
            break label772;
          }
          if (localObject4.length != 0) {
            continue;
          }
          break label772;
          bool1 = b();
          if ((!r.a(23)) || (paramContext.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0)) {
            continue;
          }
          localObject1 = null;
          String[] arrayOfString = new String[3];
          arrayOfString[0] = localObject3;
          arrayOfString[1] = localObject4;
          arrayOfString[2] = localObject1;
          j = arrayOfString.length;
          i = 0;
          if (i >= j) {
            break label763;
          }
          localObject2 = arrayOfString[i];
          if ((r.b((String)localObject2)) || (!e.matcher((CharSequence)localObject2).matches())) {
            break label813;
          }
          if ((!r.b((String)localObject2)) || (r.b((String)localObject3)) || (Math.random() >= 0.99D)) {
            break label760;
          }
          j = arrayOfString.length;
          i = k;
          if (i >= j) {
            break label760;
          }
          localObject5 = arrayOfString[i];
          if ((r.b((String)localObject5)) || (!d.matcher((CharSequence)localObject5).matches())) {
            break label820;
          }
          localObject2 = localObject5;
          if (!r.b((String)localObject2)) {
            break label757;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(c(paramContext)).append('-').append(f(paramContext)).append('-').append(b(paramContext));
          localObject2 = ((StringBuilder)localObject2).toString();
          localObject2 = "3" + r.c((String)localObject2);
          boolean bool2 = ((String)localObject2).equals(localObject3);
          if (bool2) {}
        }
      }
      finally {}
      try
      {
        localObject3 = paramContext.getSharedPreferences("tdid", 0);
        if (localObject3 != null)
        {
          localObject3 = ((SharedPreferences)localObject3).edit();
          ((SharedPreferences.Editor)localObject3).putString("pref.deviceid.key", (String)localObject2);
          ((SharedPreferences.Editor)localObject3).commit();
        }
      }
      catch (Throwable localThrowable)
      {
        continue;
      }
      if (!((String)localObject2).equals(localObject1))
      {
        localObject3 = Environment.getExternalStorageDirectory();
        if (bool1)
        {
          localObject1 = ".tcookieid";
          a(new File((File)localObject3, (String)localObject1), (String)localObject2);
        }
      }
      else
      {
        if (!((String)localObject2).equals(localObject4)) {
          a(paramContext, (String)localObject2);
        }
        b = (String)localObject2;
        paramContext = b;
        return paramContext;
        int m = localObject4.length;
        localObject2 = null;
        i = 0;
        localObject1 = localObject2;
        if (i >= m) {
          break label796;
        }
        localObject5 = localObject4[i];
        localObject1 = localObject2;
        if (!((File)localObject5).isDirectory()) {
          break label785;
        }
        localObject1 = localObject2;
        if ("/sdcard".equals(((File)localObject5).getAbsolutePath())) {
          break label785;
        }
        if (((File)localObject5).canWrite())
        {
          localObject2 = a(new File((File)localObject5, ".tcookieid"));
          localObject1 = localObject2;
          if (!r.b((String)localObject2)) {
            break label796;
          }
        }
        localObject1 = localObject2;
        if (((File)localObject5).listFiles() == null) {
          break label785;
        }
        localObject5 = ((File)localObject5).listFiles();
        int n = localObject5.length;
        j = 0;
        localObject1 = localObject2;
        if (j >= n) {
          break label785;
        }
        localObject1 = localObject5[j];
        if (!((File)localObject1).isDirectory()) {
          break label778;
        }
        localObject2 = a(new File((File)localObject1, ".tcookieid"));
        localObject1 = localObject2;
        if (!r.b((String)localObject2)) {
          break label796;
        }
        break label778;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
          break label806;
        }
        localObject2 = Environment.getExternalStorageDirectory();
        if (bool1)
        {
          localObject1 = ".tcookieid";
          localObject2 = a(new File((File)localObject2, (String)localObject1));
          localObject1 = localObject2;
          if (!r.b((String)localObject2)) {
            break label803;
          }
          localObject1 = a(new File(Environment.getExternalStorageDirectory(), ".tid" + i(paramContext)));
          break label803;
        }
        localObject1 = ".tcookieid" + i(paramContext);
        continue;
      }
      Object localObject1 = ".tcookieid" + i(paramContext);
      continue;
      label757:
      continue;
      label760:
      continue;
      label763:
      Object localObject2 = null;
      continue;
      label769:
      continue;
      label772:
      Object localObject4 = null;
      continue;
      label778:
      j += 1;
      continue;
      label785:
      i += 1;
      localObject2 = localObject1;
      continue;
      label796:
      localObject4 = localObject1;
      continue;
      label803:
      continue;
      label806:
      localObject1 = "";
      continue;
      label813:
      i += 1;
      continue;
      label820:
      i += 1;
    }
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
    File[] arrayOfFile = new File("/").listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0)) {}
    for (;;)
    {
      return;
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
  }
  
  private static void a(File paramFile, String paramString)
  {
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.close();
      if (r.a(9))
      {
        paramFile.getClass().getMethod("setReadable", new Class[] { Boolean.TYPE, Boolean.TYPE }).invoke(paramFile, new Object[] { Boolean.valueOf(true), Boolean.valueOf(false) });
        return;
      }
      Runtime.getRuntime().exec("chmod 444 " + paramFile.getAbsolutePath());
      return;
    }
    catch (Throwable paramFile) {}
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
  
  private static boolean b()
  {
    try
    {
      if (r.a(9))
      {
        bool = ((Boolean)Environment.class.getMethod("isExternalStorageRemovable", new Class[0]).invoke(null, new Object[0])).booleanValue();
        if (bool) {
          break label47;
        }
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        boolean bool = true;
      }
    }
    label47:
    return false;
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      if ((r.a(23)) && (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0)) {
        return null;
      }
      Context localContext;
      if (r.b(paramContext, "android.permission.READ_PHONE_STATE"))
      {
        if (a == null) {
          init(paramContext);
        }
        paramContext = j.y(paramContext);
        if (paramContext != null)
        {
          int i = paramContext.length();
          if (i != 2) {}
        }
        for (;;)
        {
          try
          {
            paramContext = paramContext.getJSONObject(1).getString("imei");
            localContext = paramContext;
            if (paramContext != null) {
              break;
            }
            paramContext = a.getDeviceId();
            return paramContext;
          }
          catch (Exception paramContext) {}
          paramContext = null;
        }
      }
      return localContext;
    }
    catch (Throwable paramContext)
    {
      localContext = null;
    }
  }
  
  public static String d(Context paramContext)
  {
    try
    {
      if ((r.a(23)) && (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0)) {
        return null;
      }
      if (r.b(paramContext, "android.permission.READ_PHONE_STATE"))
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
      if ((r.a(23)) && (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0)) {
        return null;
      }
      if (r.b(paramContext, "android.permission.READ_PHONE_STATE"))
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
    if (!r.b) {
      return null;
    }
    for (;;)
    {
      try
      {
        if (!r.b(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
          continue;
        }
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (!paramContext.isWifiEnabled()) {
          continue;
        }
        paramContext = paramContext.getConnectionInfo();
        if (paramContext == null) {
          continue;
        }
        str = paramContext.getMacAddress();
        paramContext = str;
        if (str != null) {
          paramContext = str;
        }
      }
      catch (Throwable paramContext)
      {
        String str;
        paramContext = null;
        continue;
        paramContext = null;
        continue;
      }
      try
      {
        str = str.toUpperCase().trim();
        paramContext = str;
        if (!"00:00:00:00:00:00".equals(str))
        {
          paramContext = str;
          boolean bool = c.matcher(str).matches();
          paramContext = str;
          if (bool) {}
        }
        else
        {
          paramContext = null;
        }
      }
      catch (Throwable localThrowable) {}
    }
    return paramContext;
  }
  
  public static final String g(Context paramContext)
  {
    try
    {
      paramContext = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[] { Context.class }).invoke(null, new Object[] { paramContext });
      paramContext = (String)Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(paramContext, new Object[0]);
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static final String h(Context paramContext)
  {
    String str2 = f(paramContext);
    String str1 = str2;
    if (!TextUtils.isEmpty(str2)) {
      str1 = String.valueOf(Long.parseLong(str2.replaceAll(":", ""), 16));
    }
    str2 = b(paramContext);
    String str3 = c(paramContext);
    String str4 = e(paramContext);
    String str5 = d(paramContext);
    String str6 = a(paramContext);
    paramContext = g(paramContext);
    String str7 = a();
    return "2|" + str1 + "|" + str2 + "|" + str3 + "|" + str4 + "|" + str5 + "|" + str6 + "|" + paramContext + "|" + str7;
  }
  
  private static String i(Context paramContext)
  {
    if (f == null) {
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
            return f;
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
        f = String.valueOf(((StringBuffer)localObject).toString().hashCode());
        break;
      }
      i += 1;
    }
  }
  
  public static void init(Context paramContext)
  {
    a = (TelephonyManager)paramContext.getSystemService("phone");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */