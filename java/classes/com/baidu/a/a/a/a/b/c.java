package com.baidu.a.a.a.a.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.system.ErrnoException;
import android.system.Os;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.a.a.a.a.a.a;
import com.baidu.a.a.a.a.a.b;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  private static final String a;
  private static b e;
  private final Context b;
  private int c = 0;
  private PublicKey d;
  
  static
  {
    String str1 = new String(b.a(new byte[] { 77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61 }));
    String str2 = new String(b.a(new byte[] { 90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61 }));
    a = str1 + str2;
  }
  
  private c(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    a();
  }
  
  public static String a(Context paramContext)
  {
    return e(paramContext).b();
  }
  
  /* Error */
  private static String a(File paramFile)
  {
    // Byte code:
    //   0: new 91	java/io/FileReader
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 94	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_0
    //   11: sipush 8192
    //   14: newarray <illegal type>
    //   16: astore_3
    //   17: aload_2
    //   18: astore_0
    //   19: new 96	java/io/CharArrayWriter
    //   22: dup
    //   23: invokespecial 97	java/io/CharArrayWriter:<init>	()V
    //   26: astore 4
    //   28: aload_2
    //   29: astore_0
    //   30: aload_2
    //   31: aload_3
    //   32: invokevirtual 101	java/io/FileReader:read	([C)I
    //   35: istore_1
    //   36: iload_1
    //   37: ifle +33 -> 70
    //   40: aload_2
    //   41: astore_0
    //   42: aload 4
    //   44: aload_3
    //   45: iconst_0
    //   46: iload_1
    //   47: invokevirtual 105	java/io/CharArrayWriter:write	([CII)V
    //   50: goto -22 -> 28
    //   53: astore_3
    //   54: aload_2
    //   55: astore_0
    //   56: aload_3
    //   57: invokestatic 108	com/baidu/a/a/a/a/b/c:b	(Ljava/lang/Throwable;)V
    //   60: aload_2
    //   61: ifnull +7 -> 68
    //   64: aload_2
    //   65: invokevirtual 111	java/io/FileReader:close	()V
    //   68: aconst_null
    //   69: areturn
    //   70: aload_2
    //   71: astore_0
    //   72: aload 4
    //   74: invokevirtual 112	java/io/CharArrayWriter:toString	()Ljava/lang/String;
    //   77: astore_3
    //   78: aload_2
    //   79: invokevirtual 111	java/io/FileReader:close	()V
    //   82: aload_3
    //   83: areturn
    //   84: astore_0
    //   85: aload_0
    //   86: invokestatic 108	com/baidu/a/a/a/a/b/c:b	(Ljava/lang/Throwable;)V
    //   89: aload_3
    //   90: areturn
    //   91: astore_0
    //   92: aload_0
    //   93: invokestatic 108	com/baidu/a/a/a/a/b/c:b	(Ljava/lang/Throwable;)V
    //   96: aconst_null
    //   97: areturn
    //   98: astore_2
    //   99: aconst_null
    //   100: astore_0
    //   101: aload_0
    //   102: ifnull +7 -> 109
    //   105: aload_0
    //   106: invokevirtual 111	java/io/FileReader:close	()V
    //   109: aload_2
    //   110: athrow
    //   111: astore_0
    //   112: aload_0
    //   113: invokestatic 108	com/baidu/a/a/a/a/b/c:b	(Ljava/lang/Throwable;)V
    //   116: goto -7 -> 109
    //   119: astore_2
    //   120: goto -19 -> 101
    //   123: astore_3
    //   124: aconst_null
    //   125: astore_2
    //   126: goto -72 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramFile	File
    //   35	12	1	i	int
    //   8	71	2	localFileReader	java.io.FileReader
    //   98	12	2	localObject1	Object
    //   119	1	2	localObject2	Object
    //   125	1	2	localObject3	Object
    //   16	29	3	arrayOfChar	char[]
    //   53	4	3	localException1	Exception
    //   77	13	3	str	String
    //   123	1	3	localException2	Exception
    //   26	47	4	localCharArrayWriter	java.io.CharArrayWriter
    // Exception table:
    //   from	to	target	type
    //   11	17	53	java/lang/Exception
    //   19	28	53	java/lang/Exception
    //   30	36	53	java/lang/Exception
    //   42	50	53	java/lang/Exception
    //   72	78	53	java/lang/Exception
    //   78	82	84	java/lang/Exception
    //   64	68	91	java/lang/Exception
    //   0	9	98	finally
    //   105	109	111	java/lang/Exception
    //   11	17	119	finally
    //   19	28	119	finally
    //   30	36	119	finally
    //   42	50	119	finally
    //   56	60	119	finally
    //   72	78	119	finally
    //   0	9	123	java/lang/Exception
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
    }
    String str1 = "";
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      String str2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str2.length() == 1) {}
      for (str1 = str1 + "0" + str2;; str1 = str1 + str2)
      {
        i += 1;
        break;
      }
    }
    return str1.toLowerCase();
  }
  
  private List a(Intent paramIntent, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    PackageManager localPackageManager = this.b.getPackageManager();
    paramIntent = localPackageManager.queryBroadcastReceivers(paramIntent, 0);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        Object localObject3 = (ResolveInfo)paramIntent.next();
        if ((((ResolveInfo)localObject3).activityInfo != null) && (((ResolveInfo)localObject3).activityInfo.applicationInfo != null)) {
          for (;;)
          {
            try
            {
              Object localObject2 = localPackageManager.getReceiverInfo(new ComponentName(((ResolveInfo)localObject3).activityInfo.packageName, ((ResolveInfo)localObject3).activityInfo.name), 128).metaData;
              if (localObject2 == null) {
                break;
              }
              Object localObject1 = ((Bundle)localObject2).getString("galaxy_data");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break;
              }
              byte[] arrayOfByte = b.a(((String)localObject1).getBytes("utf-8"));
              Object localObject4 = new JSONObject(new String(arrayOfByte));
              localObject1 = new a(null);
              ((a)localObject1).b = ((JSONObject)localObject4).getInt("priority");
              ((a)localObject1).a = ((ResolveInfo)localObject3).activityInfo.applicationInfo;
              if (this.b.getPackageName().equals(((ResolveInfo)localObject3).activityInfo.applicationInfo.packageName)) {
                ((a)localObject1).d = true;
              }
              if (paramBoolean)
              {
                localObject2 = ((Bundle)localObject2).getString("galaxy_sf");
                if (!TextUtils.isEmpty((CharSequence)localObject2))
                {
                  localObject3 = localPackageManager.getPackageInfo(((ResolveInfo)localObject3).activityInfo.applicationInfo.packageName, 64);
                  localObject4 = ((JSONObject)localObject4).getJSONArray("sigs");
                  String[] arrayOfString = new String[((JSONArray)localObject4).length()];
                  i = 0;
                  if (i < arrayOfString.length)
                  {
                    arrayOfString[i] = ((JSONArray)localObject4).getString(i);
                    i += 1;
                    continue;
                  }
                  if (a(arrayOfString, a(((PackageInfo)localObject3).signatures)))
                  {
                    localObject2 = a(b.a(((String)localObject2).getBytes()), this.d);
                    arrayOfByte = com.baidu.a.a.a.a.a.d.a(arrayOfByte);
                    if ((localObject2 == null) || (!Arrays.equals((byte[])localObject2, arrayOfByte))) {
                      break label402;
                    }
                    i = 1;
                    if (i != 0) {
                      ((a)localObject1).c = true;
                    }
                  }
                }
              }
              localArrayList.add(localObject1);
            }
            catch (Exception localException) {}
            break;
            label402:
            int i = 0;
          }
        }
      }
    }
    Collections.sort(localArrayList, new d(this));
    return localArrayList;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 310	java/io/ByteArrayInputStream
    //   5: dup
    //   6: invokestatic 314	com/baidu/a/a/a/a/b/b:a	()[B
    //   9: invokespecial 315	java/io/ByteArrayInputStream:<init>	([B)V
    //   12: astore_1
    //   13: aload_0
    //   14: ldc_w 317
    //   17: invokestatic 323	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   20: aload_1
    //   21: invokevirtual 327	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   24: invokevirtual 333	java/security/cert/Certificate:getPublicKey	()Ljava/security/PublicKey;
    //   27: putfield 281	com/baidu/a/a/a/a/b/c:d	Ljava/security/PublicKey;
    //   30: aload_1
    //   31: invokevirtual 334	java/io/ByteArrayInputStream:close	()V
    //   34: return
    //   35: astore_1
    //   36: aload_1
    //   37: invokestatic 108	com/baidu/a/a/a/a/b/c:b	(Ljava/lang/Throwable;)V
    //   40: return
    //   41: astore_1
    //   42: aconst_null
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull -11 -> 34
    //   48: aload_1
    //   49: invokevirtual 334	java/io/ByteArrayInputStream:close	()V
    //   52: return
    //   53: astore_1
    //   54: aload_1
    //   55: invokestatic 108	com/baidu/a/a/a/a/b/c:b	(Ljava/lang/Throwable;)V
    //   58: return
    //   59: astore_1
    //   60: aload_2
    //   61: ifnull +7 -> 68
    //   64: aload_2
    //   65: invokevirtual 334	java/io/ByteArrayInputStream:close	()V
    //   68: aload_1
    //   69: athrow
    //   70: astore_2
    //   71: aload_2
    //   72: invokestatic 108	com/baidu/a/a/a/a/b/c:b	(Ljava/lang/Throwable;)V
    //   75: goto -7 -> 68
    //   78: astore_3
    //   79: aload_1
    //   80: astore_2
    //   81: aload_3
    //   82: astore_1
    //   83: goto -23 -> 60
    //   86: astore_2
    //   87: goto -43 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	c
    //   12	19	1	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   35	2	1	localException1	Exception
    //   41	1	1	localException2	Exception
    //   43	6	1	localObject1	Object
    //   53	2	1	localException3	Exception
    //   59	21	1	localObject2	Object
    //   82	1	1	localObject3	Object
    //   1	64	2	localObject4	Object
    //   70	2	2	localException4	Exception
    //   80	1	2	localObject5	Object
    //   86	1	2	localException5	Exception
    //   78	4	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   30	34	35	java/lang/Exception
    //   2	13	41	java/lang/Exception
    //   48	52	53	java/lang/Exception
    //   2	13	59	finally
    //   64	68	70	java/lang/Exception
    //   13	30	78	finally
    //   13	30	86	java/lang/Exception
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: getstatic 340	android/os/Build$VERSION:SDK_INT	I
    //   8: bipush 24
    //   10: if_icmplt +83 -> 93
    //   13: iconst_0
    //   14: istore_2
    //   15: aload_0
    //   16: getfield 78	com/baidu/a/a/a/a/b/c:b	Landroid/content/Context;
    //   19: ldc_w 342
    //   22: iload_2
    //   23: invokevirtual 346	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   26: astore 4
    //   28: aload 4
    //   30: astore 5
    //   32: aload 4
    //   34: aload_1
    //   35: invokevirtual 279	java/lang/String:getBytes	()[B
    //   38: invokevirtual 350	java/io/FileOutputStream:write	([B)V
    //   41: aload 4
    //   43: astore 5
    //   45: aload 4
    //   47: invokevirtual 353	java/io/FileOutputStream:flush	()V
    //   50: aload 4
    //   52: ifnull +8 -> 60
    //   55: aload 4
    //   57: invokevirtual 354	java/io/FileOutputStream:close	()V
    //   60: iload_2
    //   61: ifne +30 -> 91
    //   64: new 356	java/io/File
    //   67: dup
    //   68: aload_0
    //   69: getfield 78	com/baidu/a/a/a/a/b/c:b	Landroid/content/Context;
    //   72: invokevirtual 360	android/content/Context:getFilesDir	()Ljava/io/File;
    //   75: ldc_w 342
    //   78: invokespecial 363	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   81: invokevirtual 366	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   84: sipush 436
    //   87: invokestatic 369	com/baidu/a/a/a/a/b/c$c:a	(Ljava/lang/String;I)Z
    //   90: istore_3
    //   91: iload_3
    //   92: ireturn
    //   93: iconst_1
    //   94: istore_2
    //   95: goto -80 -> 15
    //   98: astore_1
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 354	java/io/FileOutputStream:close	()V
    //   109: iconst_0
    //   110: ireturn
    //   111: astore_1
    //   112: aload 5
    //   114: ifnull +8 -> 122
    //   117: aload 5
    //   119: invokevirtual 354	java/io/FileOutputStream:close	()V
    //   122: aload_1
    //   123: athrow
    //   124: astore_1
    //   125: goto -65 -> 60
    //   128: astore_1
    //   129: goto -20 -> 109
    //   132: astore 4
    //   134: goto -12 -> 122
    //   137: astore_1
    //   138: aload 4
    //   140: astore_1
    //   141: goto -40 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	c
    //   0	144	1	paramString	String
    //   14	81	2	i	int
    //   1	91	3	bool	boolean
    //   26	30	4	localFileOutputStream	java.io.FileOutputStream
    //   132	7	4	localException	Exception
    //   3	115	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	28	98	java/lang/Exception
    //   15	28	111	finally
    //   32	41	111	finally
    //   45	50	111	finally
    //   55	60	124	java/lang/Exception
    //   105	109	128	java/lang/Exception
    //   117	122	132	java/lang/Exception
    //   32	41	137	java/lang/Exception
    //   45	50	137	java/lang/Exception
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = Settings.System.putString(this.b.getContentResolver(), paramString1, paramString2);
      return bool;
    }
    catch (Exception paramString1) {}
    return false;
  }
  
  private boolean a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    int j = 0;
    if ((paramArrayOfString1 == null) || (paramArrayOfString2 == null) || (paramArrayOfString1.length != paramArrayOfString2.length)) {
      return false;
    }
    HashSet localHashSet = new HashSet();
    int k = paramArrayOfString1.length;
    int i = 0;
    while (i < k)
    {
      localHashSet.add(paramArrayOfString1[i]);
      i += 1;
    }
    paramArrayOfString1 = new HashSet();
    k = paramArrayOfString2.length;
    i = j;
    while (i < k)
    {
      paramArrayOfString1.add(paramArrayOfString2[i]);
      i += 1;
    }
    return localHashSet.equals(paramArrayOfString1);
  }
  
  private static byte[] a(byte[] paramArrayOfByte, PublicKey paramPublicKey)
    throws Exception
  {
    Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    localCipher.init(2, paramPublicKey);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  private String[] a(Signature[] paramArrayOfSignature)
  {
    String[] arrayOfString = new String[paramArrayOfSignature.length];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = a(com.baidu.a.a.a.a.a.d.a(paramArrayOfSignature[i].toByteArray()));
      i += 1;
    }
    return arrayOfString;
  }
  
  private b b()
  {
    Object localObject4 = null;
    int j = 0;
    Object localObject1 = a(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.b.getPackageName()), true);
    int i;
    boolean bool;
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      i = 0;
      while (i < 3)
      {
        Log.w("DeviceId", "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
        i += 1;
      }
      bool = false;
    }
    label955:
    label982:
    label996:
    for (;;)
    {
      localObject1 = new File(this.b.getFilesDir(), "libcuid.so");
      if (((File)localObject1).exists()) {}
      for (localObject1 = b.a(f(a((File)localObject1)));; localObject1 = null)
      {
        Object localObject2 = localObject1;
        Object localObject5;
        if (localObject1 == null)
        {
          this.c |= 0x10;
          localObject5 = a(new Intent("com.baidu.intent.action.GALAXY"), bool);
          localObject2 = localObject1;
          if (localObject5 != null)
          {
            localObject2 = this.b.getFilesDir();
            if ("files".equals(((File)localObject2).getName())) {
              break label982;
            }
            Log.e("DeviceId", "fetal error:: app files dir name is unexpectedly :: " + ((File)localObject2).getAbsolutePath());
          }
        }
        for (Object localObject3 = ((File)localObject2).getName();; localObject3 = "files")
        {
          localObject5 = ((List)localObject5).iterator();
          do
          {
            localObject2 = localObject1;
            if (!((Iterator)localObject5).hasNext()) {
              break;
            }
            localObject2 = (a)((Iterator)localObject5).next();
          } while (((a)localObject2).d);
          localObject2 = new File(new File(((a)localObject2).a.dataDir, (String)localObject3), "libcuid.so");
          if (((File)localObject2).exists())
          {
            localObject2 = b.a(f(a((File)localObject2)));
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = localObject2;
            }
          }
          for (;;)
          {
            break;
            localObject1 = (a)((List)localObject1).get(0);
            bool = ((a)localObject1).c;
            if (((a)localObject1).c) {
              break label996;
            }
            i = 0;
            while (i < 3)
            {
              Log.w("DeviceId", "galaxy config err, In the release version of the signature should be matched");
              i += 1;
            }
            localObject1 = localObject2;
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = b.a(f(b("com.baidu.deviceid.v2")));
            }
            bool = c("android.permission.READ_EXTERNAL_STORAGE");
            if ((localObject2 == null) && (bool))
            {
              this.c |= 0x2;
              localObject2 = e();
            }
            for (;;)
            {
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                this.c |= 0x8;
                localObject1 = d();
              }
              if ((localObject1 == null) && (bool))
              {
                this.c |= 0x1;
                localObject2 = h("");
                localObject1 = d((String)localObject2);
              }
              for (i = 1;; i = j)
              {
                if (localObject1 == null)
                {
                  this.c |= 0x4;
                  if (i == 0) {
                    localObject2 = h("");
                  }
                  localObject3 = new b(null);
                  localObject1 = d(this.b);
                  if (Build.VERSION.SDK_INT < 23)
                  {
                    localObject5 = UUID.randomUUID().toString();
                    localObject1 = (String)localObject2 + (String)localObject1 + (String)localObject5;
                    ((b)localObject3).a = com.baidu.a.a.a.a.a.c.a(((String)localObject1).getBytes(), true);
                    ((b)localObject3).b = ((String)localObject2);
                  }
                }
                for (;;)
                {
                  localObject2 = new File(this.b.getFilesDir(), "libcuid.so");
                  if ((this.c & 0x10) == 0)
                  {
                    localObject1 = localObject4;
                    if (((File)localObject2).exists()) {}
                  }
                  else
                  {
                    if (!TextUtils.isEmpty(null)) {
                      break label955;
                    }
                  }
                  for (localObject1 = e(((b)localObject3).a());; localObject1 = null)
                  {
                    a((String)localObject1);
                    bool = c();
                    localObject2 = localObject1;
                    if (bool) {
                      if ((this.c & 0x2) == 0)
                      {
                        localObject2 = localObject1;
                        if (!TextUtils.isEmpty(b("com.baidu.deviceid.v2"))) {}
                      }
                      else
                      {
                        localObject2 = localObject1;
                        if (TextUtils.isEmpty((CharSequence)localObject1)) {
                          localObject2 = e(((b)localObject3).a());
                        }
                        a("com.baidu.deviceid.v2", (String)localObject2);
                      }
                    }
                    if (c("android.permission.WRITE_EXTERNAL_STORAGE"))
                    {
                      localObject1 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
                      if (((this.c & 0x8) != 0) || (!((File)localObject1).exists()))
                      {
                        localObject1 = localObject2;
                        if (TextUtils.isEmpty((CharSequence)localObject2)) {
                          localObject1 = e(((b)localObject3).a());
                        }
                        g((String)localObject1);
                      }
                    }
                    if ((bool) && (((this.c & 0x1) != 0) || (TextUtils.isEmpty(b("com.baidu.deviceid")))))
                    {
                      a("com.baidu.deviceid", ((b)localObject3).a);
                      a("bd_setting_i", ((b)localObject3).b);
                    }
                    if ((bool) && (!TextUtils.isEmpty(((b)localObject3).b)))
                    {
                      localObject1 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
                      if (((this.c & 0x2) != 0) || (!((File)localObject1).exists())) {
                        b(((b)localObject3).b, ((b)localObject3).a);
                      }
                    }
                    return (b)localObject3;
                    localObject1 = "com.baidu" + (String)localObject1;
                    break;
                  }
                  localObject3 = localObject1;
                }
                localObject2 = null;
              }
            }
          }
        }
      }
    }
  }
  
  public static String b(Context paramContext)
  {
    return e(paramContext).a;
  }
  
  private String b(String paramString)
  {
    try
    {
      paramString = Settings.System.getString(this.b.getContentResolver(), paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private static void b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("=");
    localStringBuilder.append(paramString2);
    paramString1 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
    paramString2 = new File(paramString1, ".cuid");
    try
    {
      if ((paramString1.exists()) && (!paramString1.isDirectory()))
      {
        Random localRandom = new Random();
        File localFile1 = paramString1.getParentFile();
        String str = paramString1.getName();
        File localFile2;
        do
        {
          localFile2 = new File(localFile1, str + localRandom.nextInt() + ".tmp");
        } while (localFile2.exists());
        paramString1.renameTo(localFile2);
        localFile2.delete();
      }
      paramString1.mkdirs();
      paramString1 = new FileWriter(paramString2, false);
      paramString1.write(b.a(a.a(a, a, localStringBuilder.toString().getBytes()), "utf-8"));
      paramString1.flush();
      paramString1.close();
      return;
    }
    catch (IOException paramString1) {}catch (Exception paramString1) {}
  }
  
  private static void b(Throwable paramThrowable) {}
  
  public static String c(Context paramContext)
  {
    return e(paramContext).b;
  }
  
  private boolean c()
  {
    return c("android.permission.WRITE_SETTINGS");
  }
  
  private boolean c(String paramString)
  {
    return this.b.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0;
  }
  
  private b d()
  {
    Object localObject3 = b("com.baidu.deviceid");
    Object localObject2 = b("bd_setting_i");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = h("");
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        a("bd_setting_i", (String)localObject2);
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject2 = d(this.b);
      localObject2 = b(com.baidu.a.a.a.a.a.c.a(("com.baidu" + (String)localObject1 + (String)localObject2).getBytes(), true));
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = new b(null);
      ((b)localObject3).a = ((String)localObject2);
      ((b)localObject3).b = ((String)localObject1);
      return (b)localObject3;
    }
    return null;
  }
  
  /* Error */
  private b d(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: getstatic 340	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 23
    //   7: if_icmpge +18 -> 25
    //   10: iconst_1
    //   11: istore_2
    //   12: iload_2
    //   13: ifeq +17 -> 30
    //   16: aload_1
    //   17: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +10 -> 30
    //   23: aconst_null
    //   24: areturn
    //   25: iconst_0
    //   26: istore_2
    //   27: goto -15 -> 12
    //   30: ldc 122
    //   32: astore 5
    //   34: new 356	java/io/File
    //   37: dup
    //   38: invokestatic 515	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   41: ldc_w 603
    //   44: invokespecial 363	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   47: astore 4
    //   49: aload 4
    //   51: invokevirtual 435	java/io/File:exists	()Z
    //   54: ifne +310 -> 364
    //   57: new 356	java/io/File
    //   60: dup
    //   61: invokestatic 515	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   64: ldc_w 526
    //   67: invokespecial 363	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   70: astore 4
    //   72: new 605	java/io/BufferedReader
    //   75: dup
    //   76: new 91	java/io/FileReader
    //   79: dup
    //   80: aload 4
    //   82: invokespecial 94	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   85: invokespecial 608	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   88: astore 4
    //   90: new 53	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   97: astore 6
    //   99: aload 4
    //   101: invokevirtual 611	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   104: astore 7
    //   106: aload 7
    //   108: ifnull +63 -> 171
    //   111: aload 6
    //   113: aload 7
    //   115: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 6
    //   121: ldc_w 613
    //   124: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: goto -29 -> 99
    //   131: astore 4
    //   133: aload 5
    //   135: astore 6
    //   137: aload 6
    //   139: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   142: ifne +170 -> 312
    //   145: new 9	com/baidu/a/a/a/a/b/c$b
    //   148: dup
    //   149: aconst_null
    //   150: invokespecial 481	com/baidu/a/a/a/a/b/c$b:<init>	(Lcom/baidu/a/a/a/a/b/d;)V
    //   153: astore 4
    //   155: aload 4
    //   157: aload 6
    //   159: putfield 496	com/baidu/a/a/a/a/b/c$b:a	Ljava/lang/String;
    //   162: aload 4
    //   164: aload_1
    //   165: putfield 498	com/baidu/a/a/a/a/b/c$b:b	Ljava/lang/String;
    //   168: aload 4
    //   170: areturn
    //   171: aload 4
    //   173: invokevirtual 614	java/io/BufferedReader:close	()V
    //   176: new 24	java/lang/String
    //   179: dup
    //   180: getstatic 65	com/baidu/a/a/a/a/b/c:a	Ljava/lang/String;
    //   183: getstatic 65	com/baidu/a/a/a/a/b/c:a	Ljava/lang/String;
    //   186: aload 6
    //   188: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokevirtual 279	java/lang/String:getBytes	()[B
    //   194: invokestatic 38	com/baidu/a/a/a/a/a/b:a	([B)[B
    //   197: invokestatic 616	com/baidu/a/a/a/a/a/a:b	(Ljava/lang/String;Ljava/lang/String;[B)[B
    //   200: invokespecial 42	java/lang/String:<init>	([B)V
    //   203: ldc_w 537
    //   206: invokevirtual 620	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   209: astore 6
    //   211: aload 6
    //   213: ifnull +141 -> 354
    //   216: aload 6
    //   218: arraylength
    //   219: iconst_2
    //   220: if_icmpne +134 -> 354
    //   223: iload_2
    //   224: ifeq +17 -> 241
    //   227: aload_1
    //   228: astore 4
    //   230: aload_1
    //   231: aload 6
    //   233: iconst_0
    //   234: aaload
    //   235: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   238: ifne +23 -> 261
    //   241: iload_2
    //   242: ifne +112 -> 354
    //   245: aload_1
    //   246: astore 4
    //   248: aload_1
    //   249: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   252: ifeq +9 -> 261
    //   255: aload 6
    //   257: iconst_1
    //   258: aaload
    //   259: astore 4
    //   261: aload 6
    //   263: iconst_1
    //   264: aaload
    //   265: astore_1
    //   266: aload 4
    //   268: astore 5
    //   270: aload_1
    //   271: astore 4
    //   273: aload 4
    //   275: astore 6
    //   277: aload 5
    //   279: astore_1
    //   280: iload_3
    //   281: ifne -144 -> 137
    //   284: aload 5
    //   286: aload 4
    //   288: invokestatic 528	com/baidu/a/a/a/a/b/c:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: aload 4
    //   293: astore 6
    //   295: aload 5
    //   297: astore_1
    //   298: goto -161 -> 137
    //   301: astore_1
    //   302: aload 4
    //   304: astore 6
    //   306: aload 5
    //   308: astore_1
    //   309: goto -172 -> 137
    //   312: aconst_null
    //   313: areturn
    //   314: astore 4
    //   316: aload 5
    //   318: astore 6
    //   320: goto -183 -> 137
    //   323: astore_1
    //   324: aload 4
    //   326: astore 6
    //   328: aload 5
    //   330: astore_1
    //   331: goto -194 -> 137
    //   334: astore 4
    //   336: aload 5
    //   338: astore 6
    //   340: goto -203 -> 137
    //   343: astore_1
    //   344: aload 4
    //   346: astore 6
    //   348: aload 5
    //   350: astore_1
    //   351: goto -214 -> 137
    //   354: aload 5
    //   356: astore 4
    //   358: aload_1
    //   359: astore 5
    //   361: goto -88 -> 273
    //   364: iconst_0
    //   365: istore_3
    //   366: goto -294 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	c
    //   0	369	1	paramString	String
    //   11	231	2	i	int
    //   1	365	3	j	int
    //   47	53	4	localObject1	Object
    //   131	1	4	localFileNotFoundException	java.io.FileNotFoundException
    //   153	150	4	localObject2	Object
    //   314	11	4	localException	Exception
    //   334	11	4	localIOException	IOException
    //   356	1	4	localObject3	Object
    //   32	328	5	localObject4	Object
    //   97	250	6	localObject5	Object
    //   104	10	7	str	String
    // Exception table:
    //   from	to	target	type
    //   72	99	131	java/io/FileNotFoundException
    //   99	106	131	java/io/FileNotFoundException
    //   111	128	131	java/io/FileNotFoundException
    //   171	211	131	java/io/FileNotFoundException
    //   216	223	131	java/io/FileNotFoundException
    //   230	241	131	java/io/FileNotFoundException
    //   248	255	131	java/io/FileNotFoundException
    //   284	291	301	java/io/FileNotFoundException
    //   72	99	314	java/lang/Exception
    //   99	106	314	java/lang/Exception
    //   111	128	314	java/lang/Exception
    //   171	211	314	java/lang/Exception
    //   216	223	314	java/lang/Exception
    //   230	241	314	java/lang/Exception
    //   248	255	314	java/lang/Exception
    //   284	291	323	java/lang/Exception
    //   72	99	334	java/io/IOException
    //   99	106	334	java/io/IOException
    //   111	128	334	java/io/IOException
    //   171	211	334	java/io/IOException
    //   216	223	334	java/io/IOException
    //   230	241	334	java/io/IOException
    //   248	255	334	java/io/IOException
    //   284	291	343	java/io/IOException
  }
  
  public static String d(Context paramContext)
  {
    String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    paramContext = str;
    if (TextUtils.isEmpty(str)) {
      paramContext = "";
    }
    return paramContext;
  }
  
  private b e()
  {
    Object localObject = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
    if (((File)localObject).exists())
    {
      localObject = a((File)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = b.a(new String(a.b(a, a, b.a(((String)localObject).getBytes()))));
          return (b)localObject;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    return null;
  }
  
  private static b e(Context paramContext)
  {
    if (e == null) {}
    try
    {
      if (e == null)
      {
        SystemClock.uptimeMillis();
        e = new c(paramContext).b();
        SystemClock.uptimeMillis();
      }
      return e;
    }
    finally {}
  }
  
  private static String e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = b.a(a.a(a, a, paramString.getBytes()), "utf-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      return "";
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;) {}
    }
  }
  
  private static String f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new String(a.b(a, a, b.a(paramString.getBytes())));
      return paramString;
    }
    catch (Exception paramString)
    {
      b(paramString);
    }
    return "";
  }
  
  private static void g(String paramString)
  {
    Object localObject = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
    File localFile1 = new File((File)localObject, ".cuid2");
    try
    {
      if ((((File)localObject).exists()) && (!((File)localObject).isDirectory()))
      {
        Random localRandom = new Random();
        File localFile2 = ((File)localObject).getParentFile();
        String str = ((File)localObject).getName();
        File localFile3;
        do
        {
          localFile3 = new File(localFile2, str + localRandom.nextInt() + ".tmp");
        } while (localFile3.exists());
        ((File)localObject).renameTo(localFile3);
        localFile3.delete();
      }
      ((File)localObject).mkdirs();
      localObject = new FileWriter(localFile1, false);
      ((FileWriter)localObject).write(paramString);
      ((FileWriter)localObject).flush();
      ((FileWriter)localObject).close();
      return;
    }
    catch (Exception paramString) {}catch (IOException paramString) {}
  }
  
  private String h(String paramString)
  {
    try
    {
      localObject = (TelephonyManager)this.b.getSystemService("phone");
      if (localObject == null) {
        break label49;
      }
      localObject = ((TelephonyManager)localObject).getDeviceId();
    }
    catch (Exception localException)
    {
      label49:
      String str;
      for (;;)
      {
        Object localObject;
        Log.e("DeviceId", "Read IMEI failed", localException);
        str = null;
      }
      return str;
    }
    localObject = i((String)localObject);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return paramString;
    }
  }
  
  private static String i(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.contains(":")) {
        str = "";
      }
    }
    return str;
  }
  
  static class a
  {
    public ApplicationInfo a;
    public int b = 0;
    public boolean c = false;
    public boolean d = false;
  }
  
  static class b
  {
    public String a;
    public String b;
    public int c = 2;
    
    public static b a(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {}
      for (;;)
      {
        return null;
        try
        {
          Object localObject = new JSONObject(paramString);
          paramString = ((JSONObject)localObject).getString("deviceid");
          String str = ((JSONObject)localObject).getString("imei");
          int i = ((JSONObject)localObject).getInt("ver");
          if ((!TextUtils.isEmpty(paramString)) && (str != null))
          {
            localObject = new b();
            ((b)localObject).a = paramString;
            ((b)localObject).b = str;
            ((b)localObject).c = i;
            return (b)localObject;
          }
        }
        catch (JSONException paramString)
        {
          c.a(paramString);
        }
      }
      return null;
    }
    
    public String a()
    {
      try
      {
        String str = new JSONObject().put("deviceid", this.a).put("imei", this.b).put("ver", this.c).toString();
        return str;
      }
      catch (JSONException localJSONException)
      {
        c.a(localJSONException);
      }
      return null;
    }
    
    public String b()
    {
      String str2 = this.b;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "0";
      }
      str1 = new StringBuffer(str1).reverse().toString();
      return this.a + "|" + str1;
    }
  }
  
  static class c
  {
    static boolean a(String paramString, int paramInt)
    {
      try
      {
        Os.chmod(paramString, paramInt);
        return true;
      }
      catch (ErrnoException paramString)
      {
        c.a(paramString);
      }
      return false;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/a/a/a/a/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */