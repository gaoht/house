package com.g.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.json.JSONObject;

public class z
{
  public static boolean a;
  public static String b;
  public static boolean c;
  public static boolean d;
  private static String f;
  private static String g;
  private static String h;
  private static final ExecutorService i;
  private static final byte[] j;
  private static byte[] k;
  
  static
  {
    if (!z.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      e = bool;
      a = true;
      b = "TDLog";
      c = false;
      d = false;
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
  
  private static String a(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null) {
      return null;
    }
    try
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).equalsIgnoreCase(paramString))
        {
          paramBundle = String.valueOf(paramBundle.get(paramString));
          return paramBundle;
        }
      }
    }
    catch (Throwable paramBundle) {}
    return null;
  }
  
  public static final String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= 256);
    return paramString.substring(0, 256);
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    try
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
      paramArrayOfByte = localStringBuilder.toString();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte) {}
    return null;
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = b(paramArrayOfByte, paramInt1, paramInt2);
    try
    {
      String str = new String(paramArrayOfByte, "US-ASCII");
      return str;
    }
    catch (Throwable localThrowable) {}
    return new String(paramArrayOfByte);
  }
  
  public static void a(Class paramClass, x paramx, String paramString1, String paramString2)
  {
    paramString1 = paramClass.getDeclaredField(paramString1);
    paramString1.setAccessible(true);
    Object localObject = paramString1.get(null);
    paramString2 = Class.forName(paramString2);
    paramx = new ac(paramx, localObject);
    paramString1.set(null, Proxy.newProxyInstance(paramClass.getClass().getClassLoader(), new Class[] { paramString2 }, paramx));
  }
  
  public static void a(Object paramObject, x paramx, String paramString1, String paramString2)
  {
    try
    {
      paramString1 = paramObject.getClass().getDeclaredField(paramString1);
      paramString1.setAccessible(true);
      Object localObject = paramString1.get(paramObject);
      paramString2 = Class.forName(paramString2);
      paramx = new ab(paramx, localObject);
      paramString1.set(paramObject, Proxy.newProxyInstance(paramObject.getClass().getClassLoader(), new Class[] { paramString2 }, paramx));
      return;
    }
    catch (Throwable paramObject) {}
  }
  
  public static boolean a(int paramInt)
  {
    return Build.VERSION.SDK_INT >= paramInt;
  }
  
  public static boolean a(Context paramContext)
  {
    return false;
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    int i1 = 0;
    byte[] arrayOfByte;
    int m;
    try
    {
      arrayOfByte = j;
      if (paramInt2 <= 0) {
        break label262;
      }
      m = paramArrayOfByte1[paramInt1] << 24 >>> 8;
    }
    catch (Throwable paramArrayOfByte1)
    {
      av.postSDKError(paramArrayOfByte1);
      return null;
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
    if (paramInt2 > 1) {}
    for (int n = paramArrayOfByte1[(paramInt1 + 1)] << 24 >>> 16;; n = 0)
    {
      if (paramInt2 > 2) {
        i1 = paramArrayOfByte1[(paramInt1 + 2)] << 24 >>> 24;
      }
      paramInt1 = i1 | n | m;
      switch (paramInt2)
      {
      }
      return paramArrayOfByte2;
      label262:
      m = 0;
      break;
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
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
    catch (Throwable paramArrayOfByte1) {}
    return null;
  }
  
  public static byte[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int m = 0;
    try
    {
      while (m < paramArrayOfInt1.length)
      {
        paramArrayOfInt1[m] = (paramArrayOfInt1[m] * paramArrayOfInt2[(paramArrayOfInt2.length - 1 - m)] - paramArrayOfInt1[(paramArrayOfInt1.length - 1 - m)] * paramArrayOfInt2[m] + "kiG9w0BAQUFADCBqjELMAkGA0JFSUpJTkcxEDAOBgNVBAcMB0JFSUpJTkcxFjAUBgNVB".charAt(m));
        paramArrayOfInt2[m] = (paramArrayOfInt2[m] * paramArrayOfInt1[(paramArrayOfInt1.length - 1 - m)] + paramArrayOfInt2[(paramArrayOfInt2.length - 1 - m)] * paramArrayOfInt1[m] - "kiG9w0BAQUFADCBqjELMAkGA0JFSUpJTkcxEDAOBgNVBAcMB0JFSUpJTkcxFjAUBgNVB".charAt("kiG9w0BAQUFADCBqjELMAkGA0JFSUpJTkcxEDAOBgNVBAcMB0JFSUpJTkcxFjAUBgNVB".length() - 1 - m));
        m += 1;
      }
      paramArrayOfInt1 = (Arrays.toString(paramArrayOfInt1) + Arrays.hashCode(paramArrayOfInt2)).getBytes();
      return paramArrayOfInt1;
    }
    catch (Throwable paramArrayOfInt1) {}
    return null;
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      paramArrayOfByte = a(paramArrayOfByte, 0, paramArrayOfByte.length);
      if ((!e) && (paramArrayOfByte == null)) {
        throw new AssertionError();
      }
    }
    catch (Throwable localThrowable)
    {
      do
      {
        paramArrayOfByte = (byte[])localObject;
      } while (e);
      throw new AssertionError(localThrowable.getMessage());
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
      localCipher.init(2, paramArrayOfByte2, new IvParameterSpec(k));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    catch (Throwable paramArrayOfByte1) {}
    return null;
  }
  
  public static String c(Context paramContext, String paramString)
  {
    try
    {
      paramContext = a(paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData, paramString);
      return paramContext;
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
    catch (Throwable paramString) {}
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
      catch (Throwable paramContext)
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
  
  /* Error */
  public static byte[] e(String paramString)
  {
    // Byte code:
    //   0: new 531	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 532	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_2
    //   10: new 534	java/util/zip/Deflater
    //   13: dup
    //   14: bipush 9
    //   16: iconst_1
    //   17: invokespecial 537	java/util/zip/Deflater:<init>	(IZ)V
    //   20: astore 4
    //   22: new 539	java/util/zip/DeflaterOutputStream
    //   25: dup
    //   26: aload_3
    //   27: aload 4
    //   29: invokespecial 542	java/util/zip/DeflaterOutputStream:<init>	(Ljava/io/OutputStream;Ljava/util/zip/Deflater;)V
    //   32: astore_1
    //   33: aload_1
    //   34: aload_0
    //   35: ldc -82
    //   37: invokevirtual 494	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   40: invokevirtual 545	java/util/zip/DeflaterOutputStream:write	([B)V
    //   43: aload_1
    //   44: ifnull +7 -> 51
    //   47: aload_1
    //   48: invokevirtual 546	java/util/zip/DeflaterOutputStream:close	()V
    //   51: aload 4
    //   53: invokevirtual 549	java/util/zip/Deflater:end	()V
    //   56: aload_3
    //   57: invokevirtual 552	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   60: areturn
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_1
    //   65: ifnull -14 -> 51
    //   68: aload_1
    //   69: invokevirtual 546	java/util/zip/DeflaterOutputStream:close	()V
    //   72: goto -21 -> 51
    //   75: astore_0
    //   76: goto -25 -> 51
    //   79: astore_0
    //   80: aload_2
    //   81: astore_1
    //   82: aload_1
    //   83: ifnull +7 -> 90
    //   86: aload_1
    //   87: invokevirtual 546	java/util/zip/DeflaterOutputStream:close	()V
    //   90: aload_0
    //   91: athrow
    //   92: astore_0
    //   93: goto -42 -> 51
    //   96: astore_1
    //   97: goto -7 -> 90
    //   100: astore_0
    //   101: goto -19 -> 82
    //   104: astore_0
    //   105: goto -41 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramString	String
    //   32	55	1	localObject1	Object
    //   96	1	1	localThrowable	Throwable
    //   9	72	2	localObject2	Object
    //   7	50	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   20	32	4	localDeflater	java.util.zip.Deflater
    // Exception table:
    //   from	to	target	type
    //   22	33	61	java/lang/Throwable
    //   68	72	75	java/lang/Throwable
    //   22	33	79	finally
    //   47	51	92	java/lang/Throwable
    //   86	90	96	java/lang/Throwable
    //   33	43	100	finally
    //   33	43	104	java/lang/Throwable
  }
  
  public static void execute(Runnable paramRunnable)
  {
    if (i != null) {
      i.execute(paramRunnable);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/g/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */