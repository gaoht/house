package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class a
{
  private static int a(List<String> paramList, String paramString)
  {
    int i = 0;
    while ((paramList != null) && (i < paramList.size()))
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase((String)paramList.get(i)))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      String[] arrayOfString = paramString.split("/");
      str = paramString;
      if (arrayOfString != null)
      {
        str = paramString;
        if (arrayOfString.length > 0) {
          str = arrayOfString[(arrayOfString.length - 1)];
        }
      }
    }
    return str;
  }
  
  public static List<String> a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = b(paramContext);
    if (!TextUtils.isEmpty(paramContext)) {
      localArrayList.add(paramContext);
    }
    paramContext = i.a("ro.product.cpu.abi", "");
    if (!TextUtils.isEmpty(paramContext)) {
      localArrayList.add(paramContext);
    }
    paramContext = i.a("ro.product.cpu.abi2", "");
    if (!TextUtils.isEmpty(paramContext)) {
      localArrayList.add(paramContext);
    }
    paramContext = i.a("ro.product.cpu.abilist", "");
    if (!TextUtils.isEmpty(paramContext))
    {
      paramContext = paramContext.split(",");
      int i = 0;
      while ((paramContext != null) && (i < paramContext.length))
      {
        if (!TextUtils.isEmpty(paramContext[i])) {
          localArrayList.add(paramContext[i]);
        }
        i += 1;
      }
    }
    localArrayList.add("armeabi");
    return localArrayList;
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: astore 4
    //   6: aload_1
    //   7: ifnull +38 -> 45
    //   10: aload_1
    //   11: astore 4
    //   13: aload_1
    //   14: getstatic 80	java/io/File:separator	Ljava/lang/String;
    //   17: invokevirtual 83	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   20: ifne +25 -> 45
    //   23: new 85	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   30: aload_1
    //   31: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: getstatic 80	java/io/File:separator	Ljava/lang/String;
    //   37: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: astore 4
    //   45: aload_2
    //   46: astore_1
    //   47: aload_2
    //   48: ifnull +36 -> 84
    //   51: aload_2
    //   52: astore_1
    //   53: aload_2
    //   54: getstatic 80	java/io/File:separator	Ljava/lang/String;
    //   57: invokevirtual 83	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   60: ifne +24 -> 84
    //   63: new 85	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   70: aload_2
    //   71: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: getstatic 80	java/io/File:separator	Ljava/lang/String;
    //   77: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore_1
    //   84: new 96	java/util/HashMap
    //   87: dup
    //   88: invokespecial 97	java/util/HashMap:<init>	()V
    //   91: astore_2
    //   92: aload_0
    //   93: invokestatic 99	com/xiaomi/channel/commonutils/android/a:a	(Landroid/content/Context;)Ljava/util/List;
    //   96: astore 6
    //   98: new 101	java/util/zip/ZipFile
    //   101: dup
    //   102: aload 4
    //   104: invokespecial 104	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual 108	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   112: astore 4
    //   114: sipush 1024
    //   117: newarray <illegal type>
    //   119: astore 5
    //   121: aload 4
    //   123: invokeinterface 114 1 0
    //   128: ifeq +295 -> 423
    //   131: aload 4
    //   133: invokeinterface 118 1 0
    //   138: checkcast 120	java/util/zip/ZipEntry
    //   141: astore 7
    //   143: new 85	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   150: ldc 122
    //   152: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 7
    //   157: invokevirtual 125	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   160: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 129	com/xiaomi/channel/commonutils/logger/b:b	(Ljava/lang/String;)V
    //   169: aload 7
    //   171: invokevirtual 125	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   174: ldc -125
    //   176: invokevirtual 134	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   179: ifeq -58 -> 121
    //   182: aload 7
    //   184: invokevirtual 137	java/util/zip/ZipEntry:isDirectory	()Z
    //   187: ifne -66 -> 121
    //   190: aload 7
    //   192: invokevirtual 125	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   195: invokestatic 139	com/xiaomi/channel/commonutils/android/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   198: astore 8
    //   200: aload 7
    //   202: invokevirtual 125	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   205: invokestatic 141	com/xiaomi/channel/commonutils/android/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   208: astore 9
    //   210: aload_2
    //   211: aload 8
    //   213: invokevirtual 144	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   216: checkcast 24	java/lang/String
    //   219: astore 10
    //   221: aload 10
    //   223: invokestatic 18	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   226: ifne +26 -> 252
    //   229: aload 6
    //   231: aload 9
    //   233: invokestatic 146	com/xiaomi/channel/commonutils/android/a:a	(Ljava/util/List;Ljava/lang/String;)I
    //   236: istore_3
    //   237: iload_3
    //   238: iflt -117 -> 121
    //   241: iload_3
    //   242: aload 6
    //   244: aload 10
    //   246: invokestatic 146	com/xiaomi/channel/commonutils/android/a:a	(Ljava/util/List;Ljava/lang/String;)I
    //   249: if_icmpge -128 -> 121
    //   252: new 85	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   259: ldc -108
    //   261: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload 9
    //   266: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 129	com/xiaomi/channel/commonutils/logger/b:b	(Ljava/lang/String;)V
    //   275: aload_2
    //   276: aload 8
    //   278: aload 9
    //   280: invokevirtual 152	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   283: pop
    //   284: new 76	java/io/File
    //   287: dup
    //   288: new 85	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   295: aload_1
    //   296: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 8
    //   301: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokespecial 153	java/io/File:<init>	(Ljava/lang/String;)V
    //   310: astore 8
    //   312: aload 8
    //   314: invokevirtual 156	java/io/File:exists	()Z
    //   317: ifeq +9 -> 326
    //   320: aload 8
    //   322: invokevirtual 159	java/io/File:delete	()Z
    //   325: pop
    //   326: new 161	java/io/FileOutputStream
    //   329: dup
    //   330: aload 8
    //   332: invokespecial 164	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   335: astore 8
    //   337: new 166	java/io/BufferedInputStream
    //   340: dup
    //   341: aload_0
    //   342: aload 7
    //   344: invokevirtual 170	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   347: invokespecial 173	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   350: astore 7
    //   352: aload 7
    //   354: aload 5
    //   356: iconst_0
    //   357: sipush 1024
    //   360: invokevirtual 179	java/io/InputStream:read	([BII)I
    //   363: istore_3
    //   364: iload_3
    //   365: iconst_m1
    //   366: if_icmpeq +29 -> 395
    //   369: aload 8
    //   371: aload 5
    //   373: iconst_0
    //   374: iload_3
    //   375: invokevirtual 183	java/io/FileOutputStream:write	([BII)V
    //   378: goto -26 -> 352
    //   381: astore_1
    //   382: aload_1
    //   383: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   386: aload_0
    //   387: ifnull +7 -> 394
    //   390: aload_0
    //   391: invokevirtual 189	java/util/zip/ZipFile:close	()V
    //   394: return
    //   395: aload 7
    //   397: invokestatic 193	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   400: aload 8
    //   402: invokestatic 196	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/OutputStream;)V
    //   405: goto -284 -> 121
    //   408: astore_2
    //   409: aload_0
    //   410: astore_1
    //   411: aload_2
    //   412: astore_0
    //   413: aload_1
    //   414: ifnull +7 -> 421
    //   417: aload_1
    //   418: invokevirtual 189	java/util/zip/ZipFile:close	()V
    //   421: aload_0
    //   422: athrow
    //   423: aload_0
    //   424: ifnull -30 -> 394
    //   427: aload_0
    //   428: invokevirtual 189	java/util/zip/ZipFile:close	()V
    //   431: return
    //   432: astore_0
    //   433: aload_0
    //   434: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   437: return
    //   438: astore_0
    //   439: aload_0
    //   440: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   443: return
    //   444: astore_1
    //   445: aload_1
    //   446: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   449: goto -28 -> 421
    //   452: astore_0
    //   453: aconst_null
    //   454: astore_1
    //   455: goto -42 -> 413
    //   458: astore_2
    //   459: aload_0
    //   460: astore_1
    //   461: aload_2
    //   462: astore_0
    //   463: goto -50 -> 413
    //   466: astore_1
    //   467: aload 5
    //   469: astore_0
    //   470: goto -88 -> 382
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	473	0	paramContext	Context
    //   0	473	1	paramString1	String
    //   0	473	2	paramString2	String
    //   236	139	3	i	int
    //   4	128	4	localObject1	Object
    //   1	467	5	arrayOfByte	byte[]
    //   96	147	6	localList	List
    //   141	255	7	localObject2	Object
    //   198	203	8	localObject3	Object
    //   208	71	9	str1	String
    //   219	26	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   108	121	381	java/lang/Exception
    //   121	237	381	java/lang/Exception
    //   241	252	381	java/lang/Exception
    //   252	326	381	java/lang/Exception
    //   326	352	381	java/lang/Exception
    //   352	364	381	java/lang/Exception
    //   369	378	381	java/lang/Exception
    //   395	405	381	java/lang/Exception
    //   108	121	408	finally
    //   121	237	408	finally
    //   241	252	408	finally
    //   252	326	408	finally
    //   326	352	408	finally
    //   352	364	408	finally
    //   369	378	408	finally
    //   395	405	408	finally
    //   427	431	432	java/lang/Exception
    //   390	394	438	java/lang/Exception
    //   417	421	444	java/lang/Exception
    //   13	45	452	finally
    //   53	84	452	finally
    //   84	108	452	finally
    //   382	386	458	finally
    //   13	45	466	java/lang/Exception
    //   53	84	466	java/lang/Exception
    //   84	108	466	java/lang/Exception
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getApplicationInfo();
      Field localField = Class.forName("android.content.pm.ApplicationInfo").getDeclaredField("primaryCpuAbi");
      localField.setAccessible(true);
      paramContext = (String)localField.get(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  private static String b(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.split("/");
      if ((paramString != null) && (paramString.length > 1)) {
        return paramString[(paramString.length - 2)];
      }
    }
    return "armeabi";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/android/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */