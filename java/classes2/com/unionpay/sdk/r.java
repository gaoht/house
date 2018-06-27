package com.unionpay.sdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.InflaterInputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.json.JSONObject;

public class r
{
  public static boolean b;
  public static String c;
  public static boolean d;
  public static boolean e;
  private static String f;
  private static String g;
  private static String h;
  private static final ExecutorService i;
  private static final byte[] j;
  private static byte[] k;
  
  static
  {
    if (!r.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      b = true;
      c = "TDLog";
      d = false;
      e = false;
      f = "ge";
      g = "tp";
      h = "rop";
      i = Executors.newSingleThreadExecutor();
      j = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
      k = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 };
      return;
    }
  }
  
  public static String a()
  {
    try
    {
      Object localObject = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(f + g + h).getInputStream(), "UTF-8"));
      StringBuilder localStringBuilder = new StringBuilder();
      for (;;)
      {
        String str = ((BufferedReader)localObject).readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str).append("\n");
      }
      ((BufferedReader)localObject).close();
      localObject = localStringBuilder.toString();
      return (String)localObject;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getAssets().open(paramString);
      paramString = new byte[paramContext.available()];
      paramContext.read(paramString);
      paramContext.close();
      paramContext = new JSONObject(new String(paramString)).getString("td_channel_id");
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static final String a(String paramString)
  {
    String str = paramString;
    if (paramString.length() > 256) {
      str = paramString.substring(0, 256);
    }
    return str;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int n = paramArrayOfByte.length;
    int m = 0;
    while (m < n)
    {
      int i1 = paramArrayOfByte[m] & 0xFF;
      if (i1 < 16) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(Integer.toHexString(i1));
      m += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = b(paramArrayOfByte, paramInt1, paramInt2);
    try
    {
      String str = new String(paramArrayOfByte, "US-ASCII");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return new String(paramArrayOfByte);
  }
  
  public static void a(Class paramClass, m paramm, String paramString1, String paramString2)
  {
    paramString1 = paramClass.getDeclaredField(paramString1);
    paramString1.setAccessible(true);
    Object localObject = paramString1.get(null);
    paramString2 = Class.forName(paramString2);
    paramm = new be(paramm, localObject);
    paramString1.set(null, Proxy.newProxyInstance(paramClass.getClass().getClassLoader(), new Class[] { paramString2 }, paramm));
  }
  
  public static void a(Object paramObject, m paramm, String paramString1, String paramString2)
  {
    paramString1 = paramObject.getClass().getDeclaredField(paramString1);
    paramString1.setAccessible(true);
    Object localObject = paramString1.get(paramObject);
    paramString2 = Class.forName(paramString2);
    paramm = new bd(paramm, localObject);
    paramString1.set(paramObject, Proxy.newProxyInstance(paramObject.getClass().getClassLoader(), new Class[] { paramString2 }, paramm));
  }
  
  public static boolean a(int paramInt)
  {
    return Build.VERSION.SDK_INT >= paramInt;
  }
  
  public static boolean a(Context paramContext)
  {
    if (b(paramContext, "android.permission.GET_TASKS"))
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      ArrayList localArrayList = new ArrayList();
      paramContext = paramContext.getPackageManager();
      Object localObject = new Intent("android.intent.action.MAIN");
      ((Intent)localObject).addCategory("android.intent.category.HOME");
      paramContext = paramContext.queryIntentActivities((Intent)localObject, 65536).iterator();
      while (paramContext.hasNext())
      {
        localObject = (ResolveInfo)paramContext.next();
        if (((ResolveInfo)localObject).activityInfo != null) {
          localArrayList.add(((ResolveInfo)localObject).activityInfo.packageName);
        }
      }
      if (localArrayList.contains(((ActivityManager.RunningTaskInfo)localActivityManager.getRunningTasks(1).get(0)).baseActivity.getPackageName())) {
        return true;
      }
    }
    return false;
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    int i1 = 0;
    byte[] arrayOfByte = j;
    int m;
    if (paramInt2 > 0)
    {
      m = paramArrayOfByte1[paramInt1] << 24 >>> 8;
      label23:
      if (paramInt2 <= 1) {
        break label104;
      }
    }
    label104:
    for (int n = paramArrayOfByte1[(paramInt1 + 1)] << 24 >>> 16;; n = 0)
    {
      if (paramInt2 > 2) {
        i1 = paramArrayOfByte1[(paramInt1 + 2)] << 24 >>> 24;
      }
      paramInt1 = i1 | n | m;
      switch (paramInt2)
      {
      default: 
        return paramArrayOfByte2;
        m = 0;
        break label23;
      }
    }
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = arrayOfByte[(paramInt1 & 0x3F)];
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = 61;
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    SecureRandom localSecureRandom = new SecureRandom();
    paramArrayOfByte1 = new DESKeySpec(paramArrayOfByte1);
    paramArrayOfByte1 = SecretKeyFactory.getInstance("DES").generateSecret(paramArrayOfByte1);
    Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    localCipher.init(2, paramArrayOfByte1, new IvParameterSpec(new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 }), localSecureRandom);
    paramArrayOfByte1 = new InflaterInputStream(new ByteArrayInputStream(localCipher.doFinal(paramArrayOfByte2)));
    paramArrayOfByte2 = new ByteArrayOutputStream();
    for (;;)
    {
      int m = paramArrayOfByte1.read();
      if (m == -1) {
        break;
      }
      paramArrayOfByte2.write(m);
    }
    return paramArrayOfByte2.toByteArray();
  }
  
  public static byte[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int m = 0;
    while (m < paramArrayOfInt1.length)
    {
      paramArrayOfInt1[m] = (paramArrayOfInt1[m] * paramArrayOfInt2[(paramArrayOfInt2.length - 1 - m)] - paramArrayOfInt1[(paramArrayOfInt1.length - 1 - m)] * paramArrayOfInt2[m] + "kiG9w0BAQUFADCBqjELMAkGA0JFSUpJTkcxEDAOBgNVBAcMB0JFSUpJTkcxFjAUBgNVB".charAt(m));
      paramArrayOfInt2[m] = (paramArrayOfInt2[m] * paramArrayOfInt1[(paramArrayOfInt1.length - 1 - m)] + paramArrayOfInt2[(paramArrayOfInt2.length - 1 - m)] * paramArrayOfInt1[m] - "kiG9w0BAQUFADCBqjELMAkGA0JFSUpJTkcxEDAOBgNVBAcMB0JFSUpJTkcxFjAUBgNVB".charAt("kiG9w0BAQUFADCBqjELMAkGA0JFSUpJTkcxEDAOBgNVBAcMB0JFSUpJTkcxFjAUBgNVB".length() - 1 - m));
      m += 1;
    }
    return (Arrays.toString(paramArrayOfInt1) + Arrays.hashCode(paramArrayOfInt2)).getBytes();
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      paramArrayOfByte = a(paramArrayOfByte, 0, paramArrayOfByte.length);
      if ((!a) && (paramArrayOfByte == null)) {
        throw new AssertionError();
      }
    }
    catch (IOException localIOException)
    {
      do
      {
        paramArrayOfByte = (byte[])localObject;
      } while (a);
      throw new AssertionError(localIOException.getMessage());
    }
    return paramArrayOfByte;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      int m = paramContext.checkCallingOrSelfPermission(paramString);
      if (m == 0) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static final boolean b(String paramString)
  {
    return (paramString == null) || ("".equals(paramString.trim()));
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("Cannot serialize a null array.");
    }
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Cannot have negative offset: " + paramInt1);
    }
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("Cannot have length offset: " + paramInt2);
    }
    if (paramInt1 + paramInt2 > paramArrayOfByte.length) {
      throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length) }));
    }
    int n = paramInt2 / 3;
    if (paramInt2 % 3 > 0) {}
    byte[] arrayOfByte;
    for (int m = 4;; m = 0)
    {
      arrayOfByte = new byte[m + n * 4];
      m = 0;
      n = 0;
      while (n < paramInt2 - 2)
      {
        a(paramArrayOfByte, n + paramInt1, 3, arrayOfByte, m);
        n += 3;
        m += 4;
      }
    }
    int i1 = m;
    if (n < paramInt2)
    {
      a(paramArrayOfByte, n + paramInt1, paramInt2 - n, arrayOfByte, m);
      i1 = m + 4;
    }
    if (i1 <= arrayOfByte.length - 1)
    {
      paramArrayOfByte = new byte[i1];
      System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, i1);
      return paramArrayOfByte;
    }
    return arrayOfByte;
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte2 = new DESKeySpec(paramArrayOfByte2);
      paramArrayOfByte2 = SecretKeyFactory.getInstance("DES").generateSecret(paramArrayOfByte2);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(1, paramArrayOfByte2, new IvParameterSpec(k));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1) {}
    return null;
  }
  
  public static String c(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      if (paramContext != null)
      {
        Iterator localIterator = paramContext.keySet().iterator();
        while (localIterator.hasNext()) {
          if (((String)localIterator.next()).equalsIgnoreCase(paramString))
          {
            paramContext = String.valueOf(paramContext.get(paramString));
            return paramContext;
          }
        }
      }
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static String c(String paramString)
  {
    try
    {
      paramString = a(MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8")));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static byte[] c(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte2 = new DESKeySpec(paramArrayOfByte2);
      paramArrayOfByte2 = SecretKeyFactory.getInstance("DES").generateSecret(paramArrayOfByte2);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(2, paramArrayOfByte2, new IvParameterSpec(k));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1) {}
    return null;
  }
  
  public static String d(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = a(MessageDigest.getInstance("SHA-256").digest(paramString.getBytes("UTF-8")));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static FileChannel d(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new File(paramContext.getFilesDir(), paramString + "td.lock");
      if (!paramContext.exists()) {
        paramContext.createNewFile();
      }
      paramContext = new RandomAccessFile(paramContext, "rw");
      try
      {
        paramContext.close();
        return null;
      }
      catch (Exception paramContext)
      {
        return null;
      }
    }
    catch (Throwable paramContext)
    {
      try
      {
        paramString = paramContext.getChannel();
        return paramString;
      }
      catch (Throwable paramString)
      {
        for (;;) {}
      }
      paramContext = paramContext;
      paramContext = null;
    }
  }
  
  public static void execute(Runnable paramRunnable)
  {
    i.execute(paramRunnable);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */