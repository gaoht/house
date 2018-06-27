package com.g.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class n
{
  private static BroadcastReceiver a = new o();
  
  private static int a(String paramString)
  {
    String str = "";
    try
    {
      Matcher localMatcher = Pattern.compile("([0-9]+)").matcher(paramString);
      paramString = str;
      if (localMatcher.find()) {
        paramString = localMatcher.toMatchResult().group(0);
      }
      int i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception paramString)
    {
      av.postSDKError(paramString);
    }
    return 0;
  }
  
  public static String a()
  {
    return "Android+" + Build.VERSION.RELEASE;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      if (paramContext != null)
      {
        int i = paramContext.widthPixels;
        int j = paramContext.heightPixels;
        paramContext = Math.min(i, j) + "*" + Math.max(i, j) + "*" + paramContext.densityDpi;
        return paramContext;
      }
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  private static String a(String paramString1, String paramString2)
  {
    try
    {
      String str = paramString1.toLowerCase();
      if ((!str.startsWith("unknown")) && (!str.startsWith("alps")) && (!str.startsWith("android")) && (!str.startsWith("sprd")) && (!str.startsWith("spreadtrum")) && (!str.startsWith("rockchip")) && (!str.startsWith("wondermedia")) && (!str.startsWith("mtk")) && (!str.startsWith("mt65")) && (!str.startsWith("nvidia")) && (!str.startsWith("brcm")) && (!str.startsWith("marvell")))
      {
        boolean bool = paramString2.toLowerCase().contains(str);
        if (!bool) {}
      }
      else
      {
        paramString1 = null;
      }
      return paramString1;
    }
    catch (Throwable paramString1) {}
    return null;
  }
  
  public static JSONObject a(Context paramContext, JSONObject paramJSONObject)
  {
    try
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      if (paramContext != null)
      {
        int i = paramContext.widthPixels;
        int j = paramContext.heightPixels;
        paramJSONObject.put("pixel", Math.min(i, j) + "*" + Math.max(i, j) + "*" + paramContext.densityDpi);
        paramJSONObject.put("densityDpi", paramContext.densityDpi);
      }
      return paramJSONObject;
    }
    catch (Throwable paramContext) {}
    return paramJSONObject;
  }
  
  public static String b()
  {
    return Build.MANUFACTURER.trim();
  }
  
  private static String b(String paramString)
  {
    BufferedReader localBufferedReader = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1 = localBufferedReader;
    try
    {
      FileReader localFileReader = new FileReader(paramString);
      localObject1 = localBufferedReader;
      Object localObject2 = localObject4;
      char[] arrayOfChar;
      int i;
      return (String)localObject2;
    }
    catch (Throwable paramString)
    {
      try
      {
        arrayOfChar = new char['Ѐ'];
        localObject1 = localBufferedReader;
        localObject2 = localObject4;
        localBufferedReader = new BufferedReader(localFileReader, 1024);
        for (paramString = (String)localObject3;; paramString = paramString + new String(arrayOfChar, 0, i))
        {
          localObject1 = paramString;
          localObject2 = paramString;
          i = localBufferedReader.read(arrayOfChar, 0, 1024);
          if (-1 == i) {
            break;
          }
          localObject1 = paramString;
          localObject2 = paramString;
        }
        localObject1 = paramString;
        localObject2 = paramString;
        localBufferedReader.close();
        localObject1 = paramString;
        localObject2 = paramString;
        localFileReader.close();
        return paramString;
      }
      catch (IOException paramString) {}
      paramString = paramString;
      return (String)localObject1;
    }
  }
  
  public static String c()
  {
    return Build.BRAND.trim();
  }
  
  public static String d()
  {
    return Build.MODEL.trim();
  }
  
  public static int e()
  {
    return TimeZone.getDefault().getRawOffset() / 3600000;
  }
  
  public static String f()
  {
    try
    {
      String str = Build.MODEL.trim();
      Object localObject2 = a(Build.MANUFACTURER.trim(), str);
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = a(Build.BRAND.trim(), str);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = (String)localObject2 + ":" + str;
      return (String)localObject1;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public static int g()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static String h()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static String i()
  {
    return Locale.getDefault().getLanguage();
  }
  
  public static String j()
  {
    return Locale.getDefault().getCountry();
  }
  
  /* Error */
  public static String[] k()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: iconst_4
    //   3: anewarray 129	java/lang/String
    //   6: astore_3
    //   7: iconst_0
    //   8: istore_0
    //   9: iload_0
    //   10: iconst_4
    //   11: if_icmpge +15 -> 26
    //   14: aload_3
    //   15: iload_0
    //   16: ldc 22
    //   18: aastore
    //   19: iload_0
    //   20: iconst_1
    //   21: iadd
    //   22: istore_0
    //   23: goto -14 -> 9
    //   26: new 262	java/util/ArrayList
    //   29: dup
    //   30: invokespecial 263	java/util/ArrayList:<init>	()V
    //   33: astore 4
    //   35: new 191	java/io/FileReader
    //   38: dup
    //   39: ldc_w 265
    //   42: invokespecial 194	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   45: astore 5
    //   47: new 196	java/io/BufferedReader
    //   50: dup
    //   51: aload 5
    //   53: sipush 1024
    //   56: invokespecial 199	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   59: astore 6
    //   61: aload 6
    //   63: invokevirtual 268	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   66: astore 7
    //   68: aload 7
    //   70: ifnull +132 -> 202
    //   73: aload 4
    //   75: aload 7
    //   77: invokeinterface 274 2 0
    //   82: pop
    //   83: goto -22 -> 61
    //   86: astore 7
    //   88: aload 6
    //   90: invokevirtual 209	java/io/BufferedReader:close	()V
    //   93: aload 5
    //   95: invokevirtual 210	java/io/FileReader:close	()V
    //   98: iconst_0
    //   99: istore_0
    //   100: iload_0
    //   101: ifeq +161 -> 262
    //   104: aload 4
    //   106: invokeinterface 277 1 0
    //   111: istore_2
    //   112: iconst_0
    //   113: istore_0
    //   114: iload_0
    //   115: iconst_3
    //   116: if_icmpge +146 -> 262
    //   119: iconst_3
    //   120: anewarray 129	java/lang/String
    //   123: dup
    //   124: iconst_0
    //   125: ldc_w 279
    //   128: aastore
    //   129: dup
    //   130: iconst_1
    //   131: ldc_w 281
    //   134: aastore
    //   135: dup
    //   136: iconst_2
    //   137: ldc_w 283
    //   140: aastore
    //   141: iload_0
    //   142: aaload
    //   143: invokestatic 30	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   146: astore 5
    //   148: iconst_0
    //   149: istore_1
    //   150: iload_1
    //   151: iload_2
    //   152: if_icmpge +103 -> 255
    //   155: aload 5
    //   157: aload 4
    //   159: iload_1
    //   160: invokeinterface 287 2 0
    //   165: checkcast 129	java/lang/String
    //   168: invokevirtual 34	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   171: astore 6
    //   173: aload 6
    //   175: invokevirtual 40	java/util/regex/Matcher:find	()Z
    //   178: ifeq +17 -> 195
    //   181: aload_3
    //   182: iload_0
    //   183: aload 6
    //   185: invokevirtual 44	java/util/regex/Matcher:toMatchResult	()Ljava/util/regex/MatchResult;
    //   188: iconst_1
    //   189: invokeinterface 50 2 0
    //   194: aastore
    //   195: iload_1
    //   196: iconst_1
    //   197: iadd
    //   198: istore_1
    //   199: goto -49 -> 150
    //   202: aload 6
    //   204: invokevirtual 209	java/io/BufferedReader:close	()V
    //   207: aload 5
    //   209: invokevirtual 210	java/io/FileReader:close	()V
    //   212: iload_1
    //   213: istore_0
    //   214: goto -114 -> 100
    //   217: astore 5
    //   219: iload_1
    //   220: istore_0
    //   221: goto -121 -> 100
    //   224: astore 5
    //   226: iconst_0
    //   227: istore_0
    //   228: goto -128 -> 100
    //   231: astore 4
    //   233: aload 6
    //   235: invokevirtual 209	java/io/BufferedReader:close	()V
    //   238: aload 5
    //   240: invokevirtual 210	java/io/FileReader:close	()V
    //   243: aload 4
    //   245: athrow
    //   246: astore 4
    //   248: aload 4
    //   250: invokestatic 66	com/g/a/av:postSDKError	(Ljava/lang/Throwable;)V
    //   253: aload_3
    //   254: areturn
    //   255: iload_0
    //   256: iconst_1
    //   257: iadd
    //   258: istore_0
    //   259: goto -145 -> 114
    //   262: aload_3
    //   263: iconst_3
    //   264: ldc_w 289
    //   267: invokestatic 291	com/g/a/n:b	(Ljava/lang/String;)Ljava/lang/String;
    //   270: aastore
    //   271: aload_3
    //   272: areturn
    //   273: astore 5
    //   275: goto -32 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   8	251	0	i	int
    //   1	219	1	j	int
    //   111	42	2	k	int
    //   6	266	3	arrayOfString	String[]
    //   33	125	4	localArrayList	java.util.ArrayList
    //   231	13	4	localObject1	Object
    //   246	3	4	localThrowable1	Throwable
    //   45	163	5	localObject2	Object
    //   217	1	5	localIOException1	IOException
    //   224	15	5	localIOException2	IOException
    //   273	1	5	localIOException3	IOException
    //   59	175	6	localObject3	Object
    //   66	10	7	str	String
    //   86	1	7	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   61	68	86	java/lang/Throwable
    //   73	83	86	java/lang/Throwable
    //   202	212	217	java/io/IOException
    //   88	98	224	java/io/IOException
    //   61	68	231	finally
    //   73	83	231	finally
    //   35	61	246	java/lang/Throwable
    //   88	98	246	java/lang/Throwable
    //   104	112	246	java/lang/Throwable
    //   119	148	246	java/lang/Throwable
    //   155	195	246	java/lang/Throwable
    //   202	212	246	java/lang/Throwable
    //   233	243	246	java/lang/Throwable
    //   243	246	246	java/lang/Throwable
    //   262	271	246	java/lang/Throwable
    //   233	243	273	java/io/IOException
  }
  
  public static String[] l()
  {
    return null;
  }
  
  /* Error */
  public static int[] m()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_2
    //   3: newarray <illegal type>
    //   5: astore_2
    //   6: aload_2
    //   7: iconst_0
    //   8: iconst_0
    //   9: iastore
    //   10: aload_2
    //   11: iconst_1
    //   12: iconst_0
    //   13: iastore
    //   14: iconst_4
    //   15: newarray <illegal type>
    //   17: astore 5
    //   19: iconst_0
    //   20: istore_0
    //   21: iload_0
    //   22: iconst_4
    //   23: if_icmpge +15 -> 38
    //   26: aload 5
    //   28: iload_0
    //   29: iconst_0
    //   30: iastore
    //   31: iload_0
    //   32: iconst_1
    //   33: iadd
    //   34: istore_0
    //   35: goto -14 -> 21
    //   38: new 191	java/io/FileReader
    //   41: dup
    //   42: ldc_w 296
    //   45: invokespecial 194	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   48: astore_3
    //   49: new 196	java/io/BufferedReader
    //   52: dup
    //   53: aload_3
    //   54: sipush 1024
    //   57: invokespecial 199	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   60: astore 4
    //   62: iload_1
    //   63: istore_0
    //   64: iload_0
    //   65: iconst_4
    //   66: if_icmpge +22 -> 88
    //   69: aload 5
    //   71: iload_0
    //   72: aload 4
    //   74: invokevirtual 268	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   77: invokestatic 298	com/g/a/n:a	(Ljava/lang/String;)I
    //   80: iastore
    //   81: iload_0
    //   82: iconst_1
    //   83: iadd
    //   84: istore_0
    //   85: goto -21 -> 64
    //   88: aload_2
    //   89: iconst_0
    //   90: aload 5
    //   92: iconst_0
    //   93: iaload
    //   94: iastore
    //   95: aload 5
    //   97: iconst_1
    //   98: iaload
    //   99: istore_0
    //   100: aload 5
    //   102: iconst_2
    //   103: iaload
    //   104: istore_1
    //   105: aload_2
    //   106: iconst_1
    //   107: aload 5
    //   109: iconst_3
    //   110: iaload
    //   111: iload_0
    //   112: iload_1
    //   113: iadd
    //   114: iadd
    //   115: iastore
    //   116: aload 4
    //   118: invokevirtual 209	java/io/BufferedReader:close	()V
    //   121: aload_3
    //   122: invokevirtual 210	java/io/FileReader:close	()V
    //   125: aload_2
    //   126: areturn
    //   127: astore 5
    //   129: aload 4
    //   131: invokevirtual 209	java/io/BufferedReader:close	()V
    //   134: aload_3
    //   135: invokevirtual 210	java/io/FileReader:close	()V
    //   138: aload_2
    //   139: areturn
    //   140: astore_3
    //   141: aload_2
    //   142: areturn
    //   143: astore 5
    //   145: aload 4
    //   147: invokevirtual 209	java/io/BufferedReader:close	()V
    //   150: aload_3
    //   151: invokevirtual 210	java/io/FileReader:close	()V
    //   154: aload 5
    //   156: athrow
    //   157: astore_3
    //   158: aload_3
    //   159: invokestatic 66	com/g/a/av:postSDKError	(Ljava/lang/Throwable;)V
    //   162: aload_2
    //   163: areturn
    //   164: astore_3
    //   165: goto -11 -> 154
    //   168: astore_3
    //   169: aload_2
    //   170: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	94	0	i	int
    //   1	113	1	j	int
    //   5	165	2	arrayOfInt1	int[]
    //   48	87	3	localFileReader	FileReader
    //   140	11	3	localIOException1	IOException
    //   157	2	3	localThrowable	Throwable
    //   164	1	3	localIOException2	IOException
    //   168	1	3	localIOException3	IOException
    //   60	86	4	localBufferedReader	BufferedReader
    //   17	91	5	arrayOfInt2	int[]
    //   127	1	5	localIOException4	IOException
    //   143	12	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   69	81	127	java/io/IOException
    //   129	138	140	java/io/IOException
    //   69	81	143	finally
    //   38	62	157	java/lang/Throwable
    //   116	125	157	java/lang/Throwable
    //   129	138	157	java/lang/Throwable
    //   145	154	157	java/lang/Throwable
    //   154	157	157	java/lang/Throwable
    //   145	154	164	java/io/IOException
    //   116	125	168	java/io/IOException
  }
  
  public static int[] n()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
      int i = localStatFs.getBlockCount() * (localStatFs.getBlockSize() / 512) / 2;
      int j = localStatFs.getAvailableBlocks();
      j = localStatFs.getBlockSize() / 512 * j / 2;
      localStatFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
      int k = localStatFs.getBlockCount() * (localStatFs.getBlockSize() / 512) / 2;
      int m = localStatFs.getAvailableBlocks();
      m = localStatFs.getBlockSize() / 512 * m / 2;
      return new int[] { i, j, k, m };
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */