package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.j;
import com.tencent.smtt.utils.z;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ai
{
  public static ThreadLocal<Integer> a;
  static boolean b = false;
  private static ai c = null;
  private static final Lock h = new ReentrantLock();
  private static final Lock i = new ReentrantLock();
  private static Handler k;
  private static final Long[][] l;
  private static boolean m = false;
  private int d = 0;
  private FileLock e;
  private FileOutputStream f;
  private boolean g = false;
  private boolean j = false;
  
  static
  {
    a = new aj();
    k = null;
    Long[] arrayOfLong1 = { Long.valueOf(25438L), Long.valueOf(11489180L) };
    Long[] arrayOfLong2 = { Long.valueOf(25439L), Long.valueOf(12013472L) };
    l = new Long[][] { { Long.valueOf(25413L), Long.valueOf(11460320L) }, { Long.valueOf(25436L), Long.valueOf(12009376L) }, { Long.valueOf(25437L), Long.valueOf(11489180L) }, arrayOfLong1, arrayOfLong2, { Long.valueOf(25440L), Long.valueOf(11489180L) }, { Long.valueOf(25442L), Long.valueOf(11489180L) } };
  }
  
  private ai()
  {
    if (k == null) {
      k = new ak(this, ag.a().getLooper());
    }
  }
  
  /* Error */
  static ai a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 31	com/tencent/smtt/sdk/ai:c	Lcom/tencent/smtt/sdk/ai;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 31	com/tencent/smtt/sdk/ai:c	Lcom/tencent/smtt/sdk/ai;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/tencent/smtt/sdk/ai
    //   21: dup
    //   22: invokespecial 107	com/tencent/smtt/sdk/ai:<init>	()V
    //   25: putstatic 31	com/tencent/smtt/sdk/ai:c	Lcom/tencent/smtt/sdk/ai;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 31	com/tencent/smtt/sdk/ai:c	Lcom/tencent/smtt/sdk/ai;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localai	ai
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  /* Error */
  private void a(int paramInt, String paramString, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 114	java/io/File
    //   9: dup
    //   10: aload_2
    //   11: invokespecial 117	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 121	java/io/File:delete	()Z
    //   17: pop
    //   18: ldc 123
    //   20: new 125	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   27: ldc -128
    //   29: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc -122
    //   38: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: iconst_1
    //   45: invokestatic 143	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   48: new 114	java/io/File
    //   51: dup
    //   52: aload_3
    //   53: ldc -111
    //   55: iconst_0
    //   56: invokevirtual 151	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   59: ldc -103
    //   61: invokespecial 156	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   64: astore_2
    //   65: aload_2
    //   66: ifnull +109 -> 175
    //   69: aload_2
    //   70: invokevirtual 159	java/io/File:canRead	()Z
    //   73: ifeq +102 -> 175
    //   76: new 114	java/io/File
    //   79: dup
    //   80: aload_2
    //   81: ldc -95
    //   83: invokespecial 156	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   86: astore_2
    //   87: new 163	java/util/Properties
    //   90: dup
    //   91: invokespecial 164	java/util/Properties:<init>	()V
    //   94: astore 6
    //   96: new 166	java/io/BufferedInputStream
    //   99: dup
    //   100: new 168	java/io/FileInputStream
    //   103: dup
    //   104: aload_2
    //   105: invokespecial 171	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   108: invokespecial 174	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   111: astore_3
    //   112: aload 6
    //   114: aload_3
    //   115: invokevirtual 177	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   118: new 179	java/io/BufferedOutputStream
    //   121: dup
    //   122: new 181	java/io/FileOutputStream
    //   125: dup
    //   126: aload_2
    //   127: invokespecial 182	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   130: invokespecial 185	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   133: astore_2
    //   134: aload 6
    //   136: ldc -69
    //   138: ldc -67
    //   140: invokevirtual 193	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   143: pop
    //   144: aload 6
    //   146: aload_2
    //   147: aconst_null
    //   148: invokevirtual 197	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   151: ldc 123
    //   153: ldc -57
    //   155: iconst_1
    //   156: invokestatic 143	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   159: aload_2
    //   160: ifnull +7 -> 167
    //   163: aload_2
    //   164: invokevirtual 202	java/io/BufferedOutputStream:close	()V
    //   167: aload_3
    //   168: ifnull +7 -> 175
    //   171: aload_3
    //   172: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   175: return
    //   176: astore_2
    //   177: aload_2
    //   178: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   181: goto -14 -> 167
    //   184: astore_2
    //   185: aload_2
    //   186: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   189: return
    //   190: astore 4
    //   192: aconst_null
    //   193: astore_2
    //   194: aload 5
    //   196: astore_3
    //   197: aload 4
    //   199: invokevirtual 207	java/lang/Throwable:printStackTrace	()V
    //   202: aload_2
    //   203: ifnull +7 -> 210
    //   206: aload_2
    //   207: invokevirtual 202	java/io/BufferedOutputStream:close	()V
    //   210: aload_3
    //   211: ifnull -36 -> 175
    //   214: aload_3
    //   215: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   218: return
    //   219: astore_2
    //   220: aload_2
    //   221: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   224: return
    //   225: astore_2
    //   226: aload_2
    //   227: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   230: goto -20 -> 210
    //   233: astore_2
    //   234: aconst_null
    //   235: astore_3
    //   236: aload 4
    //   238: ifnull +8 -> 246
    //   241: aload 4
    //   243: invokevirtual 202	java/io/BufferedOutputStream:close	()V
    //   246: aload_3
    //   247: ifnull +7 -> 254
    //   250: aload_3
    //   251: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   254: aload_2
    //   255: athrow
    //   256: astore 4
    //   258: aload 4
    //   260: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   263: goto -17 -> 246
    //   266: astore_3
    //   267: aload_3
    //   268: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   271: goto -17 -> 254
    //   274: astore_2
    //   275: goto -39 -> 236
    //   278: astore 5
    //   280: aload_2
    //   281: astore 4
    //   283: aload 5
    //   285: astore_2
    //   286: goto -50 -> 236
    //   289: astore 5
    //   291: aload_2
    //   292: astore 4
    //   294: aload 5
    //   296: astore_2
    //   297: goto -61 -> 236
    //   300: astore 4
    //   302: aconst_null
    //   303: astore_2
    //   304: goto -107 -> 197
    //   307: astore 4
    //   309: goto -112 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	ai
    //   0	312	1	paramInt	int
    //   0	312	2	paramString	String
    //   0	312	3	paramContext	Context
    //   1	1	4	localObject1	Object
    //   190	52	4	localThrowable1	Throwable
    //   256	3	4	localIOException	java.io.IOException
    //   281	12	4	str	String
    //   300	1	4	localThrowable2	Throwable
    //   307	1	4	localThrowable3	Throwable
    //   4	191	5	localObject2	Object
    //   278	6	5	localObject3	Object
    //   289	6	5	localObject4	Object
    //   94	51	6	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   163	167	176	java/io/IOException
    //   171	175	184	java/io/IOException
    //   96	112	190	java/lang/Throwable
    //   214	218	219	java/io/IOException
    //   206	210	225	java/io/IOException
    //   96	112	233	finally
    //   241	246	256	java/io/IOException
    //   250	254	266	java/io/IOException
    //   112	134	274	finally
    //   134	159	278	finally
    //   197	202	289	finally
    //   112	134	300	java/lang/Throwable
    //   134	159	307	java/lang/Throwable
  }
  
  /* Error */
  @TargetApi(11)
  private void a(Context paramContext1, Context paramContext2, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 9
    //   3: aload_1
    //   4: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   7: sipush 65012
    //   10: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   13: aload_0
    //   14: aload_2
    //   15: invokevirtual 226	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Z
    //   18: ifeq +4 -> 22
    //   21: return
    //   22: ldc 123
    //   24: ldc -28
    //   26: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: getstatic 236	android/os/Build$VERSION:SDK_INT	I
    //   32: bipush 11
    //   34: if_icmplt +67 -> 101
    //   37: aload_2
    //   38: ldc -18
    //   40: iconst_4
    //   41: invokevirtual 242	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   44: astore 14
    //   46: aload 14
    //   48: ldc -12
    //   50: iconst_m1
    //   51: invokeinterface 250 3 0
    //   56: iload_3
    //   57: if_icmpne +56 -> 113
    //   60: ldc 123
    //   62: new 125	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   69: ldc -4
    //   71: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: iload_3
    //   75: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   78: ldc_w 257
    //   81: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 259	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_1
    //   91: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   94: sipush 65011
    //   97: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   100: return
    //   101: aload_2
    //   102: ldc -18
    //   104: iconst_0
    //   105: invokevirtual 242	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   108: astore 14
    //   110: goto -64 -> 46
    //   113: aload_0
    //   114: aload_2
    //   115: invokevirtual 261	com/tencent/smtt/sdk/ai:l	(Landroid/content/Context;)Z
    //   118: ifne +14 -> 132
    //   121: aload_1
    //   122: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   125: sipush 65010
    //   128: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   131: return
    //   132: getstatic 40	com/tencent/smtt/sdk/ai:i	Ljava/util/concurrent/locks/Lock;
    //   135: invokeinterface 266 1 0
    //   140: ifeq +1504 -> 1644
    //   143: getstatic 38	com/tencent/smtt/sdk/ai:h	Ljava/util/concurrent/locks/Lock;
    //   146: invokeinterface 269 1 0
    //   151: aload_2
    //   152: invokestatic 274	com/tencent/smtt/sdk/ad:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ad;
    //   155: ldc_w 276
    //   158: invokevirtual 279	com/tencent/smtt/sdk/ad:c	(Ljava/lang/String;)I
    //   161: istore 4
    //   163: aload_2
    //   164: invokestatic 274	com/tencent/smtt/sdk/ad:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ad;
    //   167: ldc_w 281
    //   170: invokevirtual 283	com/tencent/smtt/sdk/ad:b	(Ljava/lang/String;)I
    //   173: istore 5
    //   175: iload 4
    //   177: iload_3
    //   178: if_icmpne +45 -> 223
    //   181: getstatic 288	com/tencent/smtt/sdk/QbSdk:j	Lcom/tencent/smtt/sdk/TbsListener;
    //   184: sipush 220
    //   187: invokeinterface 293 2 0
    //   192: aload_1
    //   193: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   196: sipush 65008
    //   199: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   202: getstatic 38	com/tencent/smtt/sdk/ai:h	Ljava/util/concurrent/locks/Lock;
    //   205: invokeinterface 296 1 0
    //   210: getstatic 40	com/tencent/smtt/sdk/ai:i	Ljava/util/concurrent/locks/Lock;
    //   213: invokeinterface 296 1 0
    //   218: aload_0
    //   219: invokevirtual 298	com/tencent/smtt/sdk/ai:b	()V
    //   222: return
    //   223: aload_0
    //   224: aload_2
    //   225: invokevirtual 301	com/tencent/smtt/sdk/ai:c	(Landroid/content/Context;)I
    //   228: istore 6
    //   230: ldc 123
    //   232: new 125	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   239: ldc_w 303
    //   242: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: iload 6
    //   247: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   250: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: iload 6
    //   258: iload_3
    //   259: if_icmpne +43 -> 302
    //   262: getstatic 288	com/tencent/smtt/sdk/QbSdk:j	Lcom/tencent/smtt/sdk/TbsListener;
    //   265: sipush 220
    //   268: invokeinterface 293 2 0
    //   273: aload_1
    //   274: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   277: sipush 65008
    //   280: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   283: getstatic 38	com/tencent/smtt/sdk/ai:h	Ljava/util/concurrent/locks/Lock;
    //   286: invokeinterface 296 1 0
    //   291: getstatic 40	com/tencent/smtt/sdk/ai:i	Ljava/util/concurrent/locks/Lock;
    //   294: invokeinterface 296 1 0
    //   299: goto -81 -> 218
    //   302: aload_2
    //   303: invokestatic 274	com/tencent/smtt/sdk/ad:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ad;
    //   306: invokevirtual 306	com/tencent/smtt/sdk/ad:b	()I
    //   309: istore 7
    //   311: iload 7
    //   313: ifle +1398 -> 1711
    //   316: iload_3
    //   317: iload 7
    //   319: if_icmpgt +6 -> 325
    //   322: goto +1389 -> 1711
    //   325: aload_0
    //   326: aload_2
    //   327: invokevirtual 309	com/tencent/smtt/sdk/ai:f	(Landroid/content/Context;)V
    //   330: goto +1395 -> 1725
    //   333: iconst_m1
    //   334: istore 4
    //   336: aload_0
    //   337: aload_2
    //   338: invokevirtual 309	com/tencent/smtt/sdk/ai:f	(Landroid/content/Context;)V
    //   341: ldc 123
    //   343: ldc_w 311
    //   346: iconst_1
    //   347: invokestatic 143	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   350: aload_2
    //   351: invokestatic 315	com/tencent/smtt/utils/j:b	(Landroid/content/Context;)Z
    //   354: ifne +88 -> 442
    //   357: invokestatic 320	com/tencent/smtt/utils/z:a	()J
    //   360: lstore 10
    //   362: aload_2
    //   363: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   366: invokevirtual 323	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   369: lstore 12
    //   371: aload_1
    //   372: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   375: sipush 65007
    //   378: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   381: aload_2
    //   382: invokestatic 328	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   385: sipush 210
    //   388: new 125	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   395: ldc_w 330
    //   398: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: lload 10
    //   403: invokevirtual 333	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   406: ldc_w 335
    //   409: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: lload 12
    //   414: invokevirtual 333	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   417: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokevirtual 338	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   423: getstatic 38	com/tencent/smtt/sdk/ai:h	Ljava/util/concurrent/locks/Lock;
    //   426: invokeinterface 296 1 0
    //   431: getstatic 40	com/tencent/smtt/sdk/ai:i	Ljava/util/concurrent/locks/Lock;
    //   434: invokeinterface 296 1 0
    //   439: goto -221 -> 218
    //   442: iload 4
    //   444: ifle +22 -> 466
    //   447: getstatic 38	com/tencent/smtt/sdk/ai:h	Ljava/util/concurrent/locks/Lock;
    //   450: invokeinterface 296 1 0
    //   455: getstatic 40	com/tencent/smtt/sdk/ai:i	Ljava/util/concurrent/locks/Lock;
    //   458: invokeinterface 296 1 0
    //   463: goto -245 -> 218
    //   466: iload 4
    //   468: ifne +78 -> 546
    //   471: aload_2
    //   472: invokestatic 274	com/tencent/smtt/sdk/ad:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ad;
    //   475: ldc_w 340
    //   478: invokevirtual 279	com/tencent/smtt/sdk/ad:c	(Ljava/lang/String;)I
    //   481: istore 4
    //   483: iload 4
    //   485: bipush 10
    //   487: if_icmple +45 -> 532
    //   490: aload_2
    //   491: invokestatic 328	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   494: sipush 211
    //   497: ldc_w 342
    //   500: invokevirtual 338	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   503: aload_1
    //   504: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   507: sipush 65006
    //   510: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   513: getstatic 38	com/tencent/smtt/sdk/ai:h	Ljava/util/concurrent/locks/Lock;
    //   516: invokeinterface 296 1 0
    //   521: getstatic 40	com/tencent/smtt/sdk/ai:i	Ljava/util/concurrent/locks/Lock;
    //   524: invokeinterface 296 1 0
    //   529: goto -311 -> 218
    //   532: aload_2
    //   533: invokestatic 274	com/tencent/smtt/sdk/ad:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ad;
    //   536: ldc_w 340
    //   539: iload 4
    //   541: iconst_1
    //   542: iadd
    //   543: invokevirtual 345	com/tencent/smtt/sdk/ad:a	(Ljava/lang/String;I)V
    //   546: aload_0
    //   547: aload_1
    //   548: invokevirtual 348	com/tencent/smtt/sdk/ai:g	(Landroid/content/Context;)Ljava/io/File;
    //   551: astore 14
    //   553: aload_0
    //   554: aload_2
    //   555: invokevirtual 350	com/tencent/smtt/sdk/ai:k	(Landroid/content/Context;)Ljava/io/File;
    //   558: astore 18
    //   560: aload 14
    //   562: ifnull +1023 -> 1585
    //   565: aload 18
    //   567: ifnull +1018 -> 1585
    //   570: aload_2
    //   571: invokestatic 274	com/tencent/smtt/sdk/ad:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ad;
    //   574: iload_3
    //   575: iconst_0
    //   576: invokevirtual 353	com/tencent/smtt/sdk/ad:a	(II)V
    //   579: new 355	com/tencent/smtt/utils/y
    //   582: dup
    //   583: invokespecial 356	com/tencent/smtt/utils/y:<init>	()V
    //   586: astore 15
    //   588: aload 15
    //   590: aload 14
    //   592: invokevirtual 358	com/tencent/smtt/utils/y:a	(Ljava/io/File;)V
    //   595: invokestatic 363	java/lang/System:currentTimeMillis	()J
    //   598: lstore 10
    //   600: aload_1
    //   601: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   604: sipush 64985
    //   607: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   610: aload 14
    //   612: aload 18
    //   614: invokestatic 366	com/tencent/smtt/utils/j:b	(Ljava/io/File;Ljava/io/File;)Z
    //   617: istore 8
    //   619: ldc 123
    //   621: new 125	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   628: ldc_w 368
    //   631: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: invokestatic 363	java/lang/System:currentTimeMillis	()J
    //   637: lload 10
    //   639: lsub
    //   640: invokevirtual 333	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   643: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   646: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   649: iload 8
    //   651: ifeq +885 -> 1536
    //   654: aload 15
    //   656: aload 14
    //   658: invokevirtual 370	com/tencent/smtt/utils/y:b	(Ljava/io/File;)V
    //   661: aload 15
    //   663: invokevirtual 372	com/tencent/smtt/utils/y:a	()Z
    //   666: ifne +59 -> 725
    //   669: ldc 123
    //   671: ldc_w 374
    //   674: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   677: aload 18
    //   679: iconst_1
    //   680: invokestatic 377	com/tencent/smtt/utils/j:a	(Ljava/io/File;Z)V
    //   683: aload_2
    //   684: invokestatic 328	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   687: sipush 213
    //   690: ldc_w 379
    //   693: invokevirtual 338	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   696: aload_1
    //   697: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   700: sipush 65005
    //   703: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   706: getstatic 38	com/tencent/smtt/sdk/ai:h	Ljava/util/concurrent/locks/Lock;
    //   709: invokeinterface 296 1 0
    //   714: getstatic 40	com/tencent/smtt/sdk/ai:i	Ljava/util/concurrent/locks/Lock;
    //   717: invokeinterface 296 1 0
    //   722: goto -504 -> 218
    //   725: aconst_null
    //   726: astore 16
    //   728: new 114	java/io/File
    //   731: dup
    //   732: aload 18
    //   734: ldc_w 381
    //   737: invokespecial 156	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   740: astore 14
    //   742: new 163	java/util/Properties
    //   745: dup
    //   746: invokespecial 164	java/util/Properties:<init>	()V
    //   749: astore 15
    //   751: aload 14
    //   753: ifnull +160 -> 913
    //   756: aload 14
    //   758: invokevirtual 384	java/io/File:exists	()Z
    //   761: ifeq +152 -> 913
    //   764: aload 15
    //   766: ifnull +147 -> 913
    //   769: new 166	java/io/BufferedInputStream
    //   772: dup
    //   773: new 168	java/io/FileInputStream
    //   776: dup
    //   777: aload 14
    //   779: invokespecial 171	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   782: invokespecial 174	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   785: astore 14
    //   787: aload 14
    //   789: astore 17
    //   791: aload 15
    //   793: aload 14
    //   795: invokevirtual 177	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   798: iconst_1
    //   799: istore 4
    //   801: aload 14
    //   803: ifnull +8 -> 811
    //   806: aload 14
    //   808: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   811: iload 9
    //   813: istore 8
    //   815: iload 4
    //   817: ifeq +345 -> 1162
    //   820: aload 18
    //   822: invokevirtual 388	java/io/File:listFiles	()[Ljava/io/File;
    //   825: astore 14
    //   827: aload_1
    //   828: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   831: sipush 64984
    //   834: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   837: iconst_0
    //   838: istore 5
    //   840: iload 9
    //   842: istore 8
    //   844: iload 5
    //   846: aload 14
    //   848: arraylength
    //   849: if_icmpge +313 -> 1162
    //   852: aload 14
    //   854: iload 5
    //   856: aaload
    //   857: astore 16
    //   859: ldc_w 381
    //   862: aload 16
    //   864: invokevirtual 391	java/io/File:getName	()Ljava/lang/String;
    //   867: invokevirtual 397	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   870: ifne +34 -> 904
    //   873: aload 16
    //   875: invokevirtual 391	java/io/File:getName	()Ljava/lang/String;
    //   878: ldc_w 399
    //   881: invokevirtual 403	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   884: ifne +20 -> 904
    //   887: ldc -95
    //   889: aload 16
    //   891: invokevirtual 391	java/io/File:getName	()Ljava/lang/String;
    //   894: invokevirtual 397	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   897: istore 8
    //   899: iload 8
    //   901: ifeq +119 -> 1020
    //   904: iload 5
    //   906: iconst_1
    //   907: iadd
    //   908: istore 5
    //   910: goto -70 -> 840
    //   913: aconst_null
    //   914: astore 14
    //   916: iconst_0
    //   917: istore 4
    //   919: goto -118 -> 801
    //   922: astore 16
    //   924: aconst_null
    //   925: astore 15
    //   927: aconst_null
    //   928: astore 14
    //   930: aload 14
    //   932: astore 17
    //   934: aload 16
    //   936: invokevirtual 404	java/lang/Exception:printStackTrace	()V
    //   939: aload 14
    //   941: ifnull +8 -> 949
    //   944: aload 14
    //   946: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   949: iconst_1
    //   950: istore 4
    //   952: goto -141 -> 811
    //   955: astore 14
    //   957: aload 16
    //   959: astore 15
    //   961: aload 15
    //   963: ifnull +8 -> 971
    //   966: aload 15
    //   968: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   971: aload 14
    //   973: athrow
    //   974: astore 14
    //   976: aload_2
    //   977: invokestatic 328	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   980: sipush 215
    //   983: aload 14
    //   985: invokevirtual 405	java/lang/Exception:toString	()Ljava/lang/String;
    //   988: invokevirtual 338	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   991: aload_1
    //   992: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   995: sipush 64999
    //   998: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1001: getstatic 38	com/tencent/smtt/sdk/ai:h	Ljava/util/concurrent/locks/Lock;
    //   1004: invokeinterface 296 1 0
    //   1009: getstatic 40	com/tencent/smtt/sdk/ai:i	Ljava/util/concurrent/locks/Lock;
    //   1012: invokeinterface 296 1 0
    //   1017: goto -799 -> 218
    //   1020: aload 16
    //   1022: invokestatic 410	com/tencent/smtt/utils/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   1025: astore 17
    //   1027: aload 15
    //   1029: aload 16
    //   1031: invokevirtual 391	java/io/File:getName	()Ljava/lang/String;
    //   1034: ldc_w 412
    //   1037: invokevirtual 416	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1040: astore 19
    //   1042: aload 19
    //   1044: ldc_w 412
    //   1047: invokevirtual 397	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1050: ifne +74 -> 1124
    //   1053: aload 17
    //   1055: aload 19
    //   1057: invokevirtual 397	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1060: ifeq +64 -> 1124
    //   1063: ldc 123
    //   1065: new 125	java/lang/StringBuilder
    //   1068: dup
    //   1069: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1072: ldc_w 418
    //   1075: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1078: aload 16
    //   1080: invokevirtual 391	java/io/File:getName	()Ljava/lang/String;
    //   1083: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: ldc_w 420
    //   1089: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1092: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1095: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1098: goto -194 -> 904
    //   1101: astore_1
    //   1102: getstatic 38	com/tencent/smtt/sdk/ai:h	Ljava/util/concurrent/locks/Lock;
    //   1105: invokeinterface 296 1 0
    //   1110: getstatic 40	com/tencent/smtt/sdk/ai:i	Ljava/util/concurrent/locks/Lock;
    //   1113: invokeinterface 296 1 0
    //   1118: aload_0
    //   1119: invokevirtual 298	com/tencent/smtt/sdk/ai:b	()V
    //   1122: aload_1
    //   1123: athrow
    //   1124: ldc 123
    //   1126: new 125	java/lang/StringBuilder
    //   1129: dup
    //   1130: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1133: ldc_w 422
    //   1136: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1139: aload 16
    //   1141: invokevirtual 391	java/io/File:getName	()Ljava/lang/String;
    //   1144: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: ldc_w 420
    //   1150: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1153: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1156: invokestatic 259	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1159: iconst_0
    //   1160: istore 8
    //   1162: ldc 123
    //   1164: new 125	java/lang/StringBuilder
    //   1167: dup
    //   1168: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1171: ldc_w 424
    //   1174: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: iload 8
    //   1179: invokevirtual 427	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1182: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1185: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1188: iload 4
    //   1190: ifeq +64 -> 1254
    //   1193: iload 8
    //   1195: ifne +59 -> 1254
    //   1198: ldc 123
    //   1200: ldc_w 429
    //   1203: invokestatic 259	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1206: aload 18
    //   1208: iconst_1
    //   1209: invokestatic 377	com/tencent/smtt/utils/j:a	(Ljava/io/File;Z)V
    //   1212: aload_2
    //   1213: invokestatic 328	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1216: sipush 213
    //   1219: ldc_w 431
    //   1222: invokevirtual 338	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   1225: aload_1
    //   1226: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1229: sipush 65004
    //   1232: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1235: getstatic 38	com/tencent/smtt/sdk/ai:h	Ljava/util/concurrent/locks/Lock;
    //   1238: invokeinterface 296 1 0
    //   1243: getstatic 40	com/tencent/smtt/sdk/ai:i	Ljava/util/concurrent/locks/Lock;
    //   1246: invokeinterface 296 1 0
    //   1251: goto -1033 -> 218
    //   1254: ldc 123
    //   1256: ldc_w 433
    //   1259: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1262: aload_1
    //   1263: invokestatic 437	com/tencent/smtt/sdk/ab:b	(Landroid/content/Context;)Ljava/io/File;
    //   1266: astore 15
    //   1268: aload 15
    //   1270: ifnull +38 -> 1308
    //   1273: aload 15
    //   1275: invokevirtual 384	java/io/File:exists	()Z
    //   1278: ifeq +30 -> 1308
    //   1281: aload_2
    //   1282: invokestatic 442	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1285: ifeq +181 -> 1466
    //   1288: ldc_w 444
    //   1291: astore 14
    //   1293: new 114	java/io/File
    //   1296: dup
    //   1297: aload 15
    //   1299: aload 14
    //   1301: invokespecial 156	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1304: aload_2
    //   1305: invokestatic 447	com/tencent/smtt/sdk/ab:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1308: aload_2
    //   1309: invokestatic 274	com/tencent/smtt/sdk/ad:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ad;
    //   1312: iload_3
    //   1313: iconst_1
    //   1314: invokevirtual 353	com/tencent/smtt/sdk/ad:a	(II)V
    //   1317: aload_0
    //   1318: getfield 91	com/tencent/smtt/sdk/ai:j	Z
    //   1321: ifeq +153 -> 1474
    //   1324: aload_2
    //   1325: invokestatic 328	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1328: sipush 220
    //   1331: ldc_w 449
    //   1334: invokevirtual 338	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   1337: aload_1
    //   1338: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1341: sipush 65003
    //   1344: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1347: ldc 123
    //   1349: new 125	java/lang/StringBuilder
    //   1352: dup
    //   1353: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1356: ldc_w 451
    //   1359: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1362: iload_3
    //   1363: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1366: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1369: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1372: getstatic 236	android/os/Build$VERSION:SDK_INT	I
    //   1375: bipush 11
    //   1377: if_icmplt +113 -> 1490
    //   1380: aload_2
    //   1381: ldc -18
    //   1383: iconst_4
    //   1384: invokevirtual 242	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1387: astore 14
    //   1389: aload 14
    //   1391: invokeinterface 455 1 0
    //   1396: astore 14
    //   1398: aload 14
    //   1400: ldc_w 457
    //   1403: iconst_0
    //   1404: invokeinterface 463 3 0
    //   1409: pop
    //   1410: aload 14
    //   1412: ldc_w 465
    //   1415: iconst_0
    //   1416: invokeinterface 463 3 0
    //   1421: pop
    //   1422: aload 14
    //   1424: ldc_w 467
    //   1427: iload_3
    //   1428: invokeinterface 463 3 0
    //   1433: pop
    //   1434: aload 14
    //   1436: invokeinterface 470 1 0
    //   1441: pop
    //   1442: aload_2
    //   1443: invokestatic 471	com/tencent/smtt/utils/z:a	(Landroid/content/Context;)Z
    //   1446: pop
    //   1447: getstatic 38	com/tencent/smtt/sdk/ai:h	Ljava/util/concurrent/locks/Lock;
    //   1450: invokeinterface 296 1 0
    //   1455: getstatic 40	com/tencent/smtt/sdk/ai:i	Ljava/util/concurrent/locks/Lock;
    //   1458: invokeinterface 296 1 0
    //   1463: goto -1245 -> 218
    //   1466: ldc_w 473
    //   1469: astore 14
    //   1471: goto -178 -> 1293
    //   1474: aload_2
    //   1475: invokestatic 328	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1478: sipush 220
    //   1481: ldc_w 475
    //   1484: invokevirtual 338	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   1487: goto -150 -> 1337
    //   1490: aload_2
    //   1491: ldc -18
    //   1493: iconst_0
    //   1494: invokevirtual 242	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1497: astore 14
    //   1499: goto -110 -> 1389
    //   1502: astore 14
    //   1504: ldc 123
    //   1506: new 125	java/lang/StringBuilder
    //   1509: dup
    //   1510: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1513: ldc_w 477
    //   1516: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1519: aload 14
    //   1521: invokestatic 483	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1524: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1527: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1530: invokestatic 259	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1533: goto -91 -> 1442
    //   1536: ldc 123
    //   1538: ldc_w 485
    //   1541: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1544: aload_2
    //   1545: invokestatic 274	com/tencent/smtt/sdk/ad:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ad;
    //   1548: iload_3
    //   1549: iconst_2
    //   1550: invokevirtual 353	com/tencent/smtt/sdk/ad:a	(II)V
    //   1553: aload 18
    //   1555: iconst_0
    //   1556: invokestatic 377	com/tencent/smtt/utils/j:a	(Ljava/io/File;Z)V
    //   1559: aload_1
    //   1560: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1563: sipush 65002
    //   1566: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1569: aload_2
    //   1570: invokestatic 328	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1573: sipush 212
    //   1576: ldc_w 487
    //   1579: invokevirtual 338	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   1582: goto -135 -> 1447
    //   1585: aload 14
    //   1587: ifnonnull +26 -> 1613
    //   1590: aload_2
    //   1591: invokestatic 328	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1594: sipush 213
    //   1597: ldc_w 489
    //   1600: invokevirtual 338	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   1603: aload_1
    //   1604: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1607: sipush 65001
    //   1610: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1613: aload 18
    //   1615: ifnonnull -168 -> 1447
    //   1618: aload_2
    //   1619: invokestatic 328	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1622: sipush 214
    //   1625: ldc_w 491
    //   1628: invokevirtual 338	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   1631: aload_1
    //   1632: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1635: sipush 65000
    //   1638: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1641: goto -194 -> 1447
    //   1644: aload_0
    //   1645: invokevirtual 298	com/tencent/smtt/sdk/ai:b	()V
    //   1648: aload_1
    //   1649: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1652: sipush 64998
    //   1655: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1658: return
    //   1659: astore 15
    //   1661: aload 15
    //   1663: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   1666: goto -695 -> 971
    //   1669: astore 14
    //   1671: aload 14
    //   1673: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   1676: goto -727 -> 949
    //   1679: astore 14
    //   1681: aload 14
    //   1683: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   1686: goto -875 -> 811
    //   1689: astore 14
    //   1691: aload 17
    //   1693: astore 15
    //   1695: goto -734 -> 961
    //   1698: astore 16
    //   1700: aconst_null
    //   1701: astore 14
    //   1703: goto -773 -> 930
    //   1706: astore 16
    //   1708: goto -778 -> 930
    //   1711: iload 4
    //   1713: ifle +12 -> 1725
    //   1716: iload_3
    //   1717: iload 4
    //   1719: if_icmple +6 -> 1725
    //   1722: goto -1397 -> 325
    //   1725: iload 5
    //   1727: istore 4
    //   1729: iload 5
    //   1731: iconst_3
    //   1732: if_icmpne -1382 -> 350
    //   1735: iload 5
    //   1737: istore 4
    //   1739: iload 6
    //   1741: ifle -1391 -> 350
    //   1744: iload_3
    //   1745: iload 6
    //   1747: if_icmpgt -1414 -> 333
    //   1750: iload 5
    //   1752: istore 4
    //   1754: iload_3
    //   1755: ldc_w 492
    //   1758: if_icmpne -1408 -> 350
    //   1761: goto -1428 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1764	0	this	ai
    //   0	1764	1	paramContext1	Context
    //   0	1764	2	paramContext2	Context
    //   0	1764	3	paramInt	int
    //   161	1592	4	n	int
    //   173	1578	5	i1	int
    //   228	1520	6	i2	int
    //   309	11	7	i3	int
    //   617	577	8	bool1	boolean
    //   1	840	9	bool2	boolean
    //   360	278	10	l1	long
    //   369	44	12	l2	long
    //   44	901	14	localObject1	Object
    //   955	17	14	localObject2	Object
    //   974	10	14	localException1	Exception
    //   1291	207	14	localObject3	Object
    //   1502	84	14	localThrowable	Throwable
    //   1669	3	14	localIOException1	java.io.IOException
    //   1679	3	14	localIOException2	java.io.IOException
    //   1689	1	14	localObject4	Object
    //   1701	1	14	localObject5	Object
    //   586	712	15	localObject6	Object
    //   1659	3	15	localIOException3	java.io.IOException
    //   1693	1	15	localObject7	Object
    //   726	164	16	localObject8	Object
    //   922	218	16	localException2	Exception
    //   1698	1	16	localException3	Exception
    //   1706	1	16	localException4	Exception
    //   789	903	17	localObject9	Object
    //   558	1056	18	localFile	File
    //   1040	16	19	str	String
    // Exception table:
    //   from	to	target	type
    //   728	751	922	java/lang/Exception
    //   728	751	955	finally
    //   756	764	955	finally
    //   769	787	955	finally
    //   151	175	974	java/lang/Exception
    //   181	202	974	java/lang/Exception
    //   223	256	974	java/lang/Exception
    //   262	283	974	java/lang/Exception
    //   302	311	974	java/lang/Exception
    //   325	330	974	java/lang/Exception
    //   336	350	974	java/lang/Exception
    //   350	423	974	java/lang/Exception
    //   471	483	974	java/lang/Exception
    //   490	513	974	java/lang/Exception
    //   532	546	974	java/lang/Exception
    //   546	560	974	java/lang/Exception
    //   570	649	974	java/lang/Exception
    //   654	706	974	java/lang/Exception
    //   806	811	974	java/lang/Exception
    //   820	837	974	java/lang/Exception
    //   844	852	974	java/lang/Exception
    //   859	899	974	java/lang/Exception
    //   944	949	974	java/lang/Exception
    //   966	971	974	java/lang/Exception
    //   971	974	974	java/lang/Exception
    //   1020	1098	974	java/lang/Exception
    //   1124	1159	974	java/lang/Exception
    //   1162	1188	974	java/lang/Exception
    //   1198	1235	974	java/lang/Exception
    //   1254	1268	974	java/lang/Exception
    //   1273	1288	974	java/lang/Exception
    //   1293	1308	974	java/lang/Exception
    //   1308	1337	974	java/lang/Exception
    //   1337	1389	974	java/lang/Exception
    //   1389	1442	974	java/lang/Exception
    //   1442	1447	974	java/lang/Exception
    //   1474	1487	974	java/lang/Exception
    //   1490	1499	974	java/lang/Exception
    //   1504	1533	974	java/lang/Exception
    //   1536	1582	974	java/lang/Exception
    //   1590	1613	974	java/lang/Exception
    //   1618	1641	974	java/lang/Exception
    //   1661	1666	974	java/lang/Exception
    //   1671	1676	974	java/lang/Exception
    //   1681	1686	974	java/lang/Exception
    //   151	175	1101	finally
    //   181	202	1101	finally
    //   223	256	1101	finally
    //   262	283	1101	finally
    //   302	311	1101	finally
    //   325	330	1101	finally
    //   336	350	1101	finally
    //   350	423	1101	finally
    //   471	483	1101	finally
    //   490	513	1101	finally
    //   532	546	1101	finally
    //   546	560	1101	finally
    //   570	649	1101	finally
    //   654	706	1101	finally
    //   806	811	1101	finally
    //   820	837	1101	finally
    //   844	852	1101	finally
    //   859	899	1101	finally
    //   944	949	1101	finally
    //   966	971	1101	finally
    //   971	974	1101	finally
    //   976	1001	1101	finally
    //   1020	1098	1101	finally
    //   1124	1159	1101	finally
    //   1162	1188	1101	finally
    //   1198	1235	1101	finally
    //   1254	1268	1101	finally
    //   1273	1288	1101	finally
    //   1293	1308	1101	finally
    //   1308	1337	1101	finally
    //   1337	1389	1101	finally
    //   1389	1442	1101	finally
    //   1442	1447	1101	finally
    //   1474	1487	1101	finally
    //   1490	1499	1101	finally
    //   1504	1533	1101	finally
    //   1536	1582	1101	finally
    //   1590	1613	1101	finally
    //   1618	1641	1101	finally
    //   1661	1666	1101	finally
    //   1671	1676	1101	finally
    //   1681	1686	1101	finally
    //   1389	1442	1502	java/lang/Throwable
    //   966	971	1659	java/io/IOException
    //   944	949	1669	java/io/IOException
    //   806	811	1679	java/io/IOException
    //   791	798	1689	finally
    //   934	939	1689	finally
    //   756	764	1698	java/lang/Exception
    //   769	787	1698	java/lang/Exception
    //   791	798	1706	java/lang/Exception
  }
  
  /* Error */
  private boolean a(Context paramContext, File paramFile)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_1
    //   4: istore_3
    //   5: ldc 123
    //   7: ldc_w 503
    //   10: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_2
    //   14: invokestatic 506	com/tencent/smtt/utils/j:c	(Ljava/io/File;)Z
    //   17: ifne +28 -> 45
    //   20: aload_1
    //   21: invokestatic 328	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   24: sipush 204
    //   27: ldc_w 508
    //   30: invokevirtual 338	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   33: aload_1
    //   34: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   37: sipush 65016
    //   40: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   43: iconst_0
    //   44: ireturn
    //   45: new 114	java/io/File
    //   48: dup
    //   49: aload_1
    //   50: ldc -111
    //   52: iconst_0
    //   53: invokevirtual 151	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   56: ldc -103
    //   58: invokespecial 156	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   61: astore 6
    //   63: aload 6
    //   65: ifnull +16 -> 81
    //   68: aload 6
    //   70: invokevirtual 384	java/io/File:exists	()Z
    //   73: ifeq +8 -> 81
    //   76: aload 6
    //   78: invokestatic 509	com/tencent/smtt/utils/j:b	(Ljava/io/File;)V
    //   81: aload_0
    //   82: aload_1
    //   83: invokevirtual 511	com/tencent/smtt/sdk/ai:j	(Landroid/content/Context;)Ljava/io/File;
    //   86: astore 6
    //   88: aload 6
    //   90: ifnonnull +62 -> 152
    //   93: aload_1
    //   94: invokestatic 328	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   97: sipush 205
    //   100: ldc_w 513
    //   103: invokevirtual 338	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   106: aload_1
    //   107: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   110: sipush 65015
    //   113: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   116: iconst_0
    //   117: ireturn
    //   118: astore 6
    //   120: ldc 123
    //   122: new 125	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   129: ldc_w 515
    //   132: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload 6
    //   137: invokestatic 483	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   140: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 259	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: goto -68 -> 81
    //   152: aload 6
    //   154: invokestatic 517	com/tencent/smtt/utils/j:a	(Ljava/io/File;)Z
    //   157: pop
    //   158: aload_2
    //   159: aload 6
    //   161: invokestatic 519	com/tencent/smtt/utils/j:a	(Ljava/io/File;Ljava/io/File;)Z
    //   164: istore 5
    //   166: iload 5
    //   168: ifne +47 -> 215
    //   171: aload 6
    //   173: invokestatic 509	com/tencent/smtt/utils/j:b	(Ljava/io/File;)V
    //   176: aload_1
    //   177: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   180: sipush 65014
    //   183: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   186: ldc 123
    //   188: new 125	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   195: ldc_w 521
    //   198: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload 6
    //   203: invokevirtual 384	java/io/File:exists	()Z
    //   206: invokevirtual 427	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   209: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 259	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: ldc 123
    //   217: ldc_w 523
    //   220: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: iload 5
    //   225: ireturn
    //   226: astore_2
    //   227: aload_1
    //   228: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   231: sipush 65013
    //   234: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   237: aload_1
    //   238: invokestatic 328	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   241: sipush 206
    //   244: aload_2
    //   245: invokevirtual 526	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/Throwable;)V
    //   248: aload 6
    //   250: ifnull +236 -> 486
    //   253: aload 6
    //   255: invokevirtual 384	java/io/File:exists	()Z
    //   258: istore 5
    //   260: iload 5
    //   262: ifeq +224 -> 486
    //   265: iload_3
    //   266: ifeq +42 -> 308
    //   269: aload 6
    //   271: ifnull +37 -> 308
    //   274: aload 6
    //   276: invokestatic 509	com/tencent/smtt/utils/j:b	(Ljava/io/File;)V
    //   279: ldc 123
    //   281: new 125	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   288: ldc_w 528
    //   291: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload 6
    //   296: invokevirtual 384	java/io/File:exists	()Z
    //   299: invokevirtual 427	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   302: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 259	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: ldc 123
    //   310: ldc_w 523
    //   313: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: iconst_0
    //   317: ireturn
    //   318: astore_2
    //   319: aload_1
    //   320: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   323: sipush 65013
    //   326: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   329: aload_1
    //   330: invokestatic 328	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   333: sipush 207
    //   336: aload_2
    //   337: invokevirtual 526	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/Throwable;)V
    //   340: aload 6
    //   342: ifnull +139 -> 481
    //   345: aload 6
    //   347: invokevirtual 384	java/io/File:exists	()Z
    //   350: istore 5
    //   352: iload 5
    //   354: ifeq +127 -> 481
    //   357: iload 4
    //   359: istore_3
    //   360: iload_3
    //   361: ifeq +42 -> 403
    //   364: aload 6
    //   366: ifnull +37 -> 403
    //   369: aload 6
    //   371: invokestatic 509	com/tencent/smtt/utils/j:b	(Ljava/io/File;)V
    //   374: ldc 123
    //   376: new 125	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   383: ldc_w 528
    //   386: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload 6
    //   391: invokevirtual 384	java/io/File:exists	()Z
    //   394: invokevirtual 427	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   397: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 259	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   403: goto -95 -> 308
    //   406: astore_1
    //   407: ldc 123
    //   409: ldc_w 523
    //   412: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   415: aload_1
    //   416: athrow
    //   417: astore_1
    //   418: ldc 123
    //   420: new 125	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   427: ldc_w 530
    //   430: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload_1
    //   434: invokestatic 483	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   437: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokestatic 259	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: goto -138 -> 308
    //   449: astore_1
    //   450: ldc 123
    //   452: new 125	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   459: ldc_w 530
    //   462: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload_1
    //   466: invokestatic 483	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   469: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 259	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   478: goto -75 -> 403
    //   481: iconst_0
    //   482: istore_3
    //   483: goto -123 -> 360
    //   486: iconst_0
    //   487: istore_3
    //   488: goto -223 -> 265
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	491	0	this	ai
    //   0	491	1	paramContext	Context
    //   0	491	2	paramFile	File
    //   4	484	3	n	int
    //   1	357	4	i1	int
    //   164	189	5	bool	boolean
    //   61	28	6	localFile	File
    //   118	272	6	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   45	63	118	java/lang/Throwable
    //   68	81	118	java/lang/Throwable
    //   152	166	226	java/io/IOException
    //   171	215	226	java/io/IOException
    //   152	166	318	java/lang/Exception
    //   171	215	318	java/lang/Exception
    //   152	166	406	finally
    //   171	215	406	finally
    //   227	248	406	finally
    //   253	260	406	finally
    //   319	340	406	finally
    //   345	352	406	finally
    //   274	308	417	java/lang/Throwable
    //   369	403	449	java/lang/Throwable
  }
  
  @TargetApi(11)
  private void b(Context paramContext, String paramString, int paramInt)
  {
    int i3 = 200;
    int i5 = 0;
    int i4 = 0;
    TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65035);
    if (a(paramContext))
    {
      TbsLog.i("TbsInstaller", "isTbsLocalInstalled --> no installation!", true);
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65034);
      return;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsApkPath=" + paramString);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer=" + paramInt);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentProcessId=" + Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentThreadName=" + Thread.currentThread().getName());
    if (Build.VERSION.SDK_INT >= 11) {}
    for (Object localObject = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4); ((SharedPreferences)localObject).getInt("tbs_precheck_disable_version", -1) == paramInt; localObject = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0))
    {
      TbsLog.e("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- version:" + paramInt + " is disabled by preload_x5_check!");
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65033);
      return;
    }
    if (!j.b(paramContext))
    {
      long l1 = z.a();
      long l2 = TbsDownloadConfig.getInstance(paramContext).getDownloadMinFreeSpace();
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65032);
      TbsLogReport.a(paramContext).a(210, "rom is not enough when installing tbs core! curAvailROM=" + l1 + ",minReqRom=" + l2);
      return;
    }
    if (!l(paramContext))
    {
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65031);
      return;
    }
    boolean bool = i.tryLock();
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread locked =" + bool);
    int n;
    int i1;
    label541:
    int i2;
    if (bool)
    {
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65029);
      h.lock();
      try
      {
        n = ad.a(paramContext).c("copy_core_ver");
        i1 = ad.a(paramContext).b();
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreCopyVer =" + n);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstallVer =" + i1);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer =" + paramInt);
        if ((i1 <= 0) || (paramInt <= i1)) {
          break label2043;
        }
        f(paramContext);
        i1 = ad.a(paramContext).c();
        i2 = c(paramContext);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus1=" + i1);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstalledVer=" + i2);
        if ((i1 >= 0) && (i1 < 2))
        {
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- retry.....", true);
          i2 = 1;
          label632:
          TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65028);
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus2=" + i1);
          n = i5;
          if (i1 >= 1) {
            break label1568;
          }
          TbsLog.i("TbsInstaller", "STEP 2/2 begin installation.....", true);
          TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65027);
          if (i2 == 0) {
            break label837;
          }
          n = ad.a(paramContext).c("unzip_retry_num");
          if (n > 10)
          {
            TbsLogReport.a(paramContext).a(201, "exceed unzip retry num!");
            r(paramContext);
            TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65026);
          }
        }
        else
        {
          n = i1;
          if (i1 != 3) {
            break label2057;
          }
          n = i1;
          if (i2 <= 0) {
            break label2057;
          }
          if (paramInt <= i2)
          {
            n = i1;
            if (paramInt != 88888888) {
              break label2057;
            }
          }
          n = -1;
          f(paramContext);
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- update TBS.....", true);
          break label2057;
        }
        ad.a(paramContext).b(n + 1);
        label837:
        if (paramString == null)
        {
          String str = ad.a(paramContext).d("install_apk_path");
          localObject = str;
          if (str == null)
          {
            TbsLogReport.a(paramContext).a(202, "apk path is null!");
            TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65025);
          }
        }
        else
        {
          localObject = paramString;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread apkPath =" + (String)localObject);
        i5 = b(paramContext, (String)localObject);
        if (i5 == 0)
        {
          TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65024);
          TbsLogReport.a(paramContext).a(203, "apk version is 0!");
          return;
        }
        ad.a(paramContext).a("install_apk_path", (String)localObject);
        ad.a(paramContext).b(i5, 0);
        TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(64988);
        if (!a(paramContext, new File((String)localObject)))
        {
          TbsLogReport.a(paramContext).a(207, "unzipTbsApk failed");
          return;
        }
        if (i2 != 0)
        {
          n = ad.a(paramContext).b("unlzma_status");
          if (n > 5)
          {
            TbsLogReport.a(paramContext).a(223, "exceed unlzma retry num!");
            TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(64983);
            r(paramContext);
            ab.c(paramContext);
            TbsDownloadConfig.getInstance(paramContext).a.put("tbs_needdownload", Boolean.valueOf(true));
            TbsDownloadConfig.getInstance(paramContext).a.put("request_full_package", Boolean.valueOf(true));
            TbsDownloadConfig.getInstance(paramContext).commit();
            return;
          }
          ad.a(paramContext).d(n + 1);
        }
        TbsLog.i("TbsInstaller", "unlzma begin");
        n = TbsDownloadConfig.getInstance().mPreferences.getInt("tbs_responsecode", 0);
        if (c(paramContext) != 0)
        {
          localObject = QbSdk.a(paramContext, "can_unlzma", null);
          if ((localObject == null) || (!(localObject instanceof Boolean))) {
            break label2037;
          }
          bool = ((Boolean)localObject).booleanValue();
          label1276:
          if (bool)
          {
            localObject = new Bundle();
            ((Bundle)localObject).putInt("responseCode", n);
            ((Bundle)localObject).putString("unzip_temp_path", j(paramContext).getAbsolutePath());
            localObject = QbSdk.a(paramContext, "unlzma", (Bundle)localObject);
            if (localObject == null)
            {
              TbsLog.i("TbsInstaller", "unlzma return null");
              TbsLogReport.a(paramContext).a(222, "unlzma is null");
              n = i4;
            }
            label1357:
            while (n == 0)
            {
              return;
              if ((localObject instanceof Boolean))
              {
                if (((Boolean)localObject).booleanValue())
                {
                  TbsLog.i("TbsInstaller", "unlzma success");
                  n = 1;
                  break label2067;
                }
                TbsLog.i("TbsInstaller", "unlzma return false");
                TbsLogReport.a(paramContext).a(222, "unlzma return false");
                n = 0;
                break label2067;
              }
              if ((localObject instanceof Bundle))
              {
                n = 1;
              }
              else
              {
                n = i4;
                if ((localObject instanceof Throwable))
                {
                  TbsLog.i("TbsInstaller", "unlzma failure because Throwable" + Log.getStackTraceString((Throwable)localObject));
                  TbsLogReport.a(paramContext).a(222, (Throwable)localObject);
                  n = i4;
                }
              }
            }
          }
        }
        TbsLog.i("TbsInstaller", "unlzma finished");
      }
      finally
      {
        h.unlock();
        i.unlock();
        b();
      }
      ad.a(paramContext).b(i5, 1);
      n = i5;
      label1568:
      if (i1 < 2)
      {
        if (i2 != 0)
        {
          i1 = ad.a(paramContext).c("dexopt_retry_num");
          if (i1 > 10)
          {
            TbsLogReport.a(paramContext).a(208, "exceed dexopt retry num!");
            TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65022);
            r(paramContext);
            h.unlock();
            i.unlock();
            b();
            return;
          }
          ad.a(paramContext).a(i1 + 1);
        }
        TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(64987);
        if (!c(paramContext, 0))
        {
          TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65021);
          h.unlock();
          i.unlock();
          b();
          return;
        }
        ad.a(paramContext).b(n, 2);
        TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart!", true);
        TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart! version:" + paramInt);
        TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65020);
        if (Build.VERSION.SDK_INT >= 11) {
          localObject = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
        }
        try
        {
          for (;;)
          {
            localObject = ((SharedPreferences)localObject).edit();
            ((SharedPreferences.Editor)localObject).putInt("tbs_preload_x5_counter", 0);
            ((SharedPreferences.Editor)localObject).putInt("tbs_preload_x5_recorder", 0);
            ((SharedPreferences.Editor)localObject).putInt("tbs_preload_x5_version", paramInt);
            ((SharedPreferences.Editor)localObject).commit();
            TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65019);
            if (paramInt == 88888888) {
              a(paramInt, paramString, paramContext);
            }
            if (!this.j) {
              break;
            }
            paramString = TbsLogReport.a(paramContext);
            paramInt = i3;
            if (ad.a(paramContext).d() == 1) {
              paramInt = 221;
            }
            paramString.a(paramInt, "continueInstallWithout core success");
            label1894:
            h.unlock();
            i.unlock();
            b();
            return;
            localObject = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            TbsLog.e("TbsInstaller", "Init tbs_preload_x5_counter#1 exception:" + Log.getStackTraceString(localThrowable));
            TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65018);
          }
          paramString = TbsLogReport.a(paramContext);
          if (ad.a(paramContext).d() != 1) {}
        }
      }
    }
    for (paramInt = 221;; paramInt = 200)
    {
      paramString.a(paramInt, "success");
      break label1894;
      if (i1 != 2) {
        break label1894;
      }
      QbSdk.j.onInstallFinish(200);
      break label1894;
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(65017);
      b();
      return;
      label2037:
      bool = false;
      break label1276;
      label2043:
      if ((n <= 0) || (paramInt <= n)) {
        break label541;
      }
      break;
      label2057:
      i2 = 0;
      i1 = n;
      break label632;
      label2067:
      break label1357;
    }
  }
  
  /* Error */
  private boolean c(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 123
    //   4: new 125	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 718
    //   14: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: iload_2
    //   18: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   21: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: iload_2
    //   28: tableswitch	default:+28->56, 0:+55->83, 1:+195->223, 2:+205->233
    //   56: ldc 123
    //   58: new 125	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   65: ldc_w 720
    //   68: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: iload_2
    //   72: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 259	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: iconst_0
    //   82: ireturn
    //   83: aload_0
    //   84: aload_1
    //   85: invokevirtual 511	com/tencent/smtt/sdk/ai:j	(Landroid/content/Context;)Ljava/io/File;
    //   88: astore 6
    //   90: aload 6
    //   92: new 722	com/tencent/smtt/sdk/al
    //   95: dup
    //   96: aload_0
    //   97: invokespecial 725	com/tencent/smtt/sdk/al:<init>	(Lcom/tencent/smtt/sdk/ai;)V
    //   100: invokevirtual 728	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   103: astore 7
    //   105: aload 7
    //   107: arraylength
    //   108: istore 4
    //   110: getstatic 236	android/os/Build$VERSION:SDK_INT	I
    //   113: bipush 16
    //   115: if_icmpge +33 -> 148
    //   118: aload_1
    //   119: invokevirtual 731	android/content/Context:getPackageName	()Ljava/lang/String;
    //   122: ifnull +26 -> 148
    //   125: aload_1
    //   126: invokevirtual 731	android/content/Context:getPackageName	()Ljava/lang/String;
    //   129: ldc_w 733
    //   132: invokevirtual 736	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   135: istore 5
    //   137: iload 5
    //   139: ifeq +9 -> 148
    //   142: ldc2_w 737
    //   145: invokestatic 742	java/lang/Thread:sleep	(J)V
    //   148: aload_1
    //   149: invokevirtual 746	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   152: astore 8
    //   154: iload_3
    //   155: istore_2
    //   156: iload_2
    //   157: iload 4
    //   159: if_icmpge +106 -> 265
    //   162: ldc 123
    //   164: new 125	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   171: ldc_w 748
    //   174: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload 7
    //   179: iload_2
    //   180: aaload
    //   181: invokevirtual 680	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   184: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: new 750	dalvik/system/DexClassLoader
    //   196: dup
    //   197: aload 7
    //   199: iload_2
    //   200: aaload
    //   201: invokevirtual 680	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   204: aload 6
    //   206: invokevirtual 680	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   209: aconst_null
    //   210: aload 8
    //   212: invokespecial 753	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   215: pop
    //   216: iload_2
    //   217: iconst_1
    //   218: iadd
    //   219: istore_2
    //   220: goto -64 -> 156
    //   223: aload_0
    //   224: aload_1
    //   225: invokevirtual 350	com/tencent/smtt/sdk/ai:k	(Landroid/content/Context;)Ljava/io/File;
    //   228: astore 6
    //   230: goto -140 -> 90
    //   233: aload_0
    //   234: aload_1
    //   235: invokevirtual 348	com/tencent/smtt/sdk/ai:g	(Landroid/content/Context;)Ljava/io/File;
    //   238: astore 6
    //   240: goto -150 -> 90
    //   243: astore 6
    //   245: aload 6
    //   247: invokevirtual 404	java/lang/Exception:printStackTrace	()V
    //   250: aload_1
    //   251: invokestatic 328	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   254: sipush 209
    //   257: aload 6
    //   259: invokevirtual 405	java/lang/Exception:toString	()Ljava/lang/String;
    //   262: invokevirtual 338	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   265: ldc 123
    //   267: ldc_w 755
    //   270: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: iconst_1
    //   274: ireturn
    //   275: astore 8
    //   277: goto -129 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	ai
    //   0	280	1	paramContext	Context
    //   0	280	2	paramInt	int
    //   1	154	3	n	int
    //   108	52	4	i1	int
    //   135	3	5	bool	boolean
    //   88	151	6	localFile	File
    //   243	15	6	localException1	Exception
    //   103	95	7	arrayOfFile	File[]
    //   152	59	8	localClassLoader	ClassLoader
    //   275	1	8	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   56	81	243	java/lang/Exception
    //   83	90	243	java/lang/Exception
    //   90	137	243	java/lang/Exception
    //   148	154	243	java/lang/Exception
    //   162	216	243	java/lang/Exception
    //   223	230	243	java/lang/Exception
    //   233	240	243	java/lang/Exception
    //   142	148	275	java/lang/Exception
  }
  
  private boolean c(Context paramContext, String paramString)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), paramString);
    if ((paramContext == null) || (!paramContext.exists())) {}
    do
    {
      return false;
      paramContext = new File(paramContext, "tbs.conf");
    } while ((paramContext == null) || (!paramContext.exists()));
    return true;
  }
  
  /* Error */
  private boolean c(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 8
    //   6: iconst_0
    //   7: istore 9
    //   9: iconst_1
    //   10: istore 7
    //   12: aload_0
    //   13: monitorenter
    //   14: ldc 123
    //   16: ldc_w 759
    //   19: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: iload 8
    //   24: istore 6
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 261	com/tencent/smtt/sdk/ai:l	(Landroid/content/Context;)Z
    //   31: istore 10
    //   33: iload 10
    //   35: ifne +12 -> 47
    //   38: iload 9
    //   40: istore 5
    //   42: aload_0
    //   43: monitorexit
    //   44: iload 5
    //   46: ireturn
    //   47: iload 8
    //   49: istore 6
    //   51: getstatic 38	com/tencent/smtt/sdk/ai:h	Ljava/util/concurrent/locks/Lock;
    //   54: invokeinterface 266 1 0
    //   59: istore 9
    //   61: iload 8
    //   63: istore 6
    //   65: ldc 123
    //   67: new 125	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   74: ldc_w 761
    //   77: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: iload 9
    //   82: invokevirtual 427	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   85: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: iload 9
    //   93: ifeq +111 -> 204
    //   96: aload_1
    //   97: invokestatic 274	com/tencent/smtt/sdk/ad:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ad;
    //   100: ldc_w 281
    //   103: invokevirtual 283	com/tencent/smtt/sdk/ad:b	(Ljava/lang/String;)I
    //   106: istore_3
    //   107: aload_0
    //   108: iconst_0
    //   109: aload_1
    //   110: invokevirtual 764	com/tencent/smtt/sdk/ai:a	(ZLandroid/content/Context;)I
    //   113: istore 4
    //   115: ldc 123
    //   117: new 125	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 766
    //   127: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: iload_3
    //   131: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   134: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: ldc 123
    //   142: new 125	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   149: ldc_w 768
    //   152: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: iload 4
    //   157: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: iload_3
    //   167: iconst_1
    //   168: if_icmpne +160 -> 328
    //   171: iload 4
    //   173: ifne +102 -> 275
    //   176: ldc 123
    //   178: ldc_w 770
    //   181: iconst_1
    //   182: invokestatic 143	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   185: aload_0
    //   186: aload_1
    //   187: invokespecial 773	com/tencent/smtt/sdk/ai:n	(Landroid/content/Context;)V
    //   190: iload 7
    //   192: istore_2
    //   193: getstatic 38	com/tencent/smtt/sdk/ai:h	Ljava/util/concurrent/locks/Lock;
    //   196: invokeinterface 296 1 0
    //   201: iload_2
    //   202: istore 5
    //   204: iload 5
    //   206: istore 6
    //   208: aload_0
    //   209: invokevirtual 298	com/tencent/smtt/sdk/ai:b	()V
    //   212: goto -170 -> 42
    //   215: astore 11
    //   217: iload 6
    //   219: istore 5
    //   221: aload_1
    //   222: invokestatic 328	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   225: sipush 215
    //   228: aload 11
    //   230: invokevirtual 774	java/lang/Throwable:toString	()Ljava/lang/String;
    //   233: invokevirtual 338	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   236: aload_1
    //   237: new 125	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   244: ldc_w 776
    //   247: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 11
    //   252: invokestatic 483	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   255: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 779	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   264: goto -222 -> 42
    //   267: astore_1
    //   268: aload_1
    //   269: athrow
    //   270: astore_1
    //   271: aload_0
    //   272: monitorexit
    //   273: aload_1
    //   274: athrow
    //   275: iload_2
    //   276: ifeq +52 -> 328
    //   279: ldc 123
    //   281: ldc_w 781
    //   284: iconst_1
    //   285: invokestatic 143	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   288: aload_0
    //   289: aload_1
    //   290: invokespecial 773	com/tencent/smtt/sdk/ai:n	(Landroid/content/Context;)V
    //   293: iload 7
    //   295: istore_2
    //   296: goto -103 -> 193
    //   299: astore 11
    //   301: iload 8
    //   303: istore 6
    //   305: getstatic 38	com/tencent/smtt/sdk/ai:h	Ljava/util/concurrent/locks/Lock;
    //   308: invokeinterface 296 1 0
    //   313: iload 8
    //   315: istore 6
    //   317: aload 11
    //   319: athrow
    //   320: astore 11
    //   322: iload_2
    //   323: istore 5
    //   325: goto -104 -> 221
    //   328: iconst_0
    //   329: istore_2
    //   330: goto -137 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	this	ai
    //   0	333	1	paramContext	Context
    //   0	333	2	paramBoolean	boolean
    //   106	63	3	n	int
    //   113	59	4	i1	int
    //   1	323	5	bool1	boolean
    //   24	292	6	bool2	boolean
    //   10	284	7	bool3	boolean
    //   4	310	8	bool4	boolean
    //   7	85	9	bool5	boolean
    //   31	3	10	bool6	boolean
    //   215	36	11	localThrowable1	Throwable
    //   299	19	11	localObject	Object
    //   320	1	11	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   26	33	215	java/lang/Throwable
    //   51	61	215	java/lang/Throwable
    //   65	91	215	java/lang/Throwable
    //   208	212	215	java/lang/Throwable
    //   305	313	215	java/lang/Throwable
    //   317	320	215	java/lang/Throwable
    //   26	33	267	finally
    //   51	61	267	finally
    //   65	91	267	finally
    //   193	201	267	finally
    //   208	212	267	finally
    //   221	264	267	finally
    //   305	313	267	finally
    //   317	320	267	finally
    //   14	22	270	finally
    //   268	270	270	finally
    //   96	166	299	finally
    //   176	190	299	finally
    //   279	293	299	finally
    //   193	201	320	java/lang/Throwable
  }
  
  private Context d(Context paramContext, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=" + paramInt);
    if (paramInt <= 0) {
      return null;
    }
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    int n = 0;
    if (n < arrayOfString.length)
    {
      if (paramContext.getPackageName().equalsIgnoreCase(arrayOfString[n])) {}
      Context localContext;
      label140:
      int i1;
      do
      {
        for (;;)
        {
          n += 1;
          break;
          if (d(paramContext, arrayOfString[n]))
          {
            localContext = a(paramContext, arrayOfString[n]);
            if (localContext != null)
            {
              if (b(localContext)) {
                break label140;
              }
              TbsLog.e("TbsInstaller", "TbsInstaller--getTbsCoreHostContext " + arrayOfString[n] + " illegal signature go on next");
            }
          }
        }
        i1 = c(localContext);
        TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=" + i1);
      } while ((i1 == 0) || (i1 != paramInt));
      TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext targetApp=" + arrayOfString[n]);
      return localContext;
    }
    return null;
  }
  
  private boolean d(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext != null) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
  
  private boolean d(Context paramContext, boolean paramBoolean)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    label64:
    try
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip canRenameTmpDir =" + paramBoolean);
      bool2 = bool4;
      try
      {
        boolean bool6 = l(paramContext);
        if (bool6) {
          break label64;
        }
        bool1 = bool5;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            n = ad.a(paramContext).c();
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip installStatus=" + n);
            i1 = a(false, paramContext);
            if (n != 2) {
              break label300;
            }
            if (i1 == 0)
            {
              TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
              m(paramContext);
              paramBoolean = bool3;
            }
          }
          finally
          {
            bool2 = bool4;
            h.unlock();
            bool2 = bool4;
          }
          try
          {
            h.unlock();
            bool1 = paramBoolean;
            bool2 = bool1;
            b();
          }
          catch (Exception localException2)
          {
            bool1 = paramBoolean;
            continue;
          }
          localException1 = localException1;
          bool1 = bool2;
          QbSdk.a(paramContext, "TbsInstaller::enableTbsCoreFromUnzip Exception: " + localException1);
          localException1.printStackTrace();
        }
      }
      return bool1;
    }
    finally {}
    boolean bool2 = bool4;
    bool5 = h.tryLock();
    bool2 = bool4;
    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip locked=" + bool5);
    if (bool5) {}
    for (;;)
    {
      int n;
      int i1;
      if (paramBoolean)
      {
        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
        m(paramContext);
        paramBoolean = bool3;
      }
      else
      {
        label300:
        paramBoolean = false;
      }
    }
  }
  
  private boolean e(Context paramContext, boolean paramBoolean)
  {
    return false;
  }
  
  static File i(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_private");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  private void m(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
    if ((bg.b().a() == null) && (bg.b().a(paramContext) == null))
    {
      TbsLog.e("TbsInstaller", "generateNewTbsCoreFromUnzip -- failed to get rename fileLock#2!");
      return;
    }
    try
    {
      o(paramContext);
      p(paramContext);
      if (!TbsShareManager.isThirdPartyApp(paramContext)) {
        TbsShareManager.a(paramContext);
      }
      ad.a(paramContext).a(0);
      ad.a(paramContext).b(0);
      ad.a(paramContext).d(0);
      ad.a(paramContext).a("incrupdate_retry_num", 0);
      ad.a(paramContext).b(0, 3);
      ad.a(paramContext).a("");
      ad.a(paramContext).c(-1);
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        TbsShareManager.writeCoreInfoForThirdPartyApp(paramContext, e(paramContext), true);
      }
      a.set(Integer.valueOf(0));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      TbsLogReport.a(paramContext).a(219, "exception when renameing from unzip:" + localThrowable.toString());
      TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
    }
  }
  
  private void n(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
    if ((bg.b().a() == null) && (bg.b().a(paramContext) == null))
    {
      TbsLog.e("TbsInstaller", "generateNewTbsCoreFromCopy -- failed to get rename fileLock#2!");
      return;
    }
    try
    {
      o(paramContext);
      q(paramContext);
      TbsShareManager.a(paramContext);
      ad.a(paramContext).a(0, 3);
      a.set(Integer.valueOf(0));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      TbsLogReport.a(paramContext).a(219, "exception when renameing from copy:" + localException.toString());
    }
  }
  
  private void o(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
    j.a(g(paramContext), false);
  }
  
  private void p(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
    File localFile = j(paramContext);
    paramContext = g(paramContext);
    if ((localFile == null) || (paramContext == null)) {
      return;
    }
    localFile.renameTo(paramContext);
  }
  
  private void q(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
    File localFile = k(paramContext);
    paramContext = g(paramContext);
    if ((localFile == null) || (paramContext == null)) {
      return;
    }
    localFile.renameTo(paramContext);
  }
  
  private void r(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
    File localFile = j(paramContext);
    if (localFile != null) {
      j.a(localFile, false);
    }
    ad.a(paramContext).b(0, 5);
    ad.a(paramContext).c(-1);
    QbSdk.a(paramContext, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
  }
  
  public int a(boolean paramBoolean, Context paramContext)
  {
    if ((paramBoolean) || (((Integer)a.get()).intValue() <= 0)) {
      a.set(Integer.valueOf(c(paramContext)));
    }
    return ((Integer)a.get()).intValue();
  }
  
  Context a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.createPackageContext(paramString, 2);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  void a(Context paramContext, Bundle paramBundle)
  {
    if ((paramBundle == null) || (paramContext == null)) {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 3;
    localMessage.obj = new Object[] { paramContext, paramBundle };
    k.sendMessage(localMessage);
  }
  
  void a(Context paramContext, String paramString, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=" + paramString);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=" + paramInt);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = new Object[] { paramContext, paramString, Integer.valueOf(paramInt) };
    k.sendMessage(localMessage);
  }
  
  void a(Context paramContext, boolean paramBoolean)
  {
    int i4 = 0;
    if (paramBoolean) {
      this.j = true;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentThreadName=" + Thread.currentThread().getName());
    if (!l(paramContext)) {
      return;
    }
    if (h.tryLock()) {}
    for (;;)
    {
      try
      {
        i3 = ad.a(paramContext).c();
        i2 = ad.a(paramContext).b();
        str = ad.a(paramContext).d("install_apk_path");
        n = ad.a(paramContext).c("copy_core_ver");
        i1 = ad.a(paramContext).b("copy_status");
        h.unlock();
        b();
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=" + i3);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=" + i2);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=" + str);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=" + n);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=" + i1);
        if (TbsShareManager.isThirdPartyApp(paramContext))
        {
          b(paramContext, TbsShareManager.a(paramContext, false));
          return;
        }
      }
      finally
      {
        h.unlock();
      }
      int i5 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_responsecode", 0);
      if ((i5 == 1) || (i5 == 2) || (i5 == 4)) {
        i4 = 1;
      }
      if (i4 == 0)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("operation", 10001);
        a(paramContext, localBundle);
      }
      if ((i3 > -1) && (i3 < 2)) {
        a(paramContext, str, i2);
      }
      if (i1 != 0) {
        break;
      }
      a(paramContext, n);
      return;
      int i1 = -1;
      String str = null;
      int i2 = 0;
      int i3 = -1;
      int n = 0;
    }
  }
  
  /* Error */
  boolean a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 348	com/tencent/smtt/sdk/ai:g	(Landroid/content/Context;)Ljava/io/File;
    //   7: astore 5
    //   9: new 114	java/io/File
    //   12: dup
    //   13: aload 5
    //   15: ldc -95
    //   17: invokespecial 156	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   20: astore_1
    //   21: aload_1
    //   22: ifnull +10 -> 32
    //   25: aload_1
    //   26: invokevirtual 384	java/io/File:exists	()Z
    //   29: ifne +9 -> 38
    //   32: iconst_0
    //   33: istore 4
    //   35: iload 4
    //   37: ireturn
    //   38: new 163	java/util/Properties
    //   41: dup
    //   42: invokespecial 164	java/util/Properties:<init>	()V
    //   45: astore 6
    //   47: new 166	java/io/BufferedInputStream
    //   50: dup
    //   51: new 168	java/io/FileInputStream
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 171	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   59: invokespecial 174	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   62: astore_1
    //   63: aload 6
    //   65: aload_1
    //   66: invokevirtual 177	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   69: aload 6
    //   71: ldc -69
    //   73: ldc_w 985
    //   76: invokevirtual 416	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   79: invokestatic 988	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   82: invokevirtual 668	java/lang/Boolean:booleanValue	()Z
    //   85: istore 4
    //   87: iload 4
    //   89: ifeq +175 -> 264
    //   92: invokestatic 363	java/lang/System:currentTimeMillis	()J
    //   95: aload 5
    //   97: invokevirtual 991	java/io/File:lastModified	()J
    //   100: lsub
    //   101: ldc2_w 992
    //   104: lcmp
    //   105: ifle +70 -> 175
    //   108: iconst_1
    //   109: istore_3
    //   110: ldc 123
    //   112: new 125	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 995
    //   122: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: iload 4
    //   127: invokevirtual 427	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   130: ldc_w 997
    //   133: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: iload_3
    //   137: invokevirtual 427	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   140: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: iload_3
    //   147: ifne +33 -> 180
    //   150: iload 4
    //   152: iload_2
    //   153: iand
    //   154: istore_3
    //   155: iload_3
    //   156: istore 4
    //   158: aload_1
    //   159: ifnull -124 -> 35
    //   162: aload_1
    //   163: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   166: iload_3
    //   167: ireturn
    //   168: astore_1
    //   169: aload_1
    //   170: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   173: iload_3
    //   174: ireturn
    //   175: iconst_0
    //   176: istore_3
    //   177: goto -67 -> 110
    //   180: iconst_0
    //   181: istore_2
    //   182: goto -32 -> 150
    //   185: astore 5
    //   187: iconst_0
    //   188: istore_3
    //   189: aconst_null
    //   190: astore_1
    //   191: aload 5
    //   193: invokevirtual 207	java/lang/Throwable:printStackTrace	()V
    //   196: iload_3
    //   197: istore 4
    //   199: aload_1
    //   200: ifnull -165 -> 35
    //   203: aload_1
    //   204: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   207: iload_3
    //   208: ireturn
    //   209: astore_1
    //   210: aload_1
    //   211: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   214: iload_3
    //   215: ireturn
    //   216: astore 5
    //   218: aconst_null
    //   219: astore_1
    //   220: aload_1
    //   221: ifnull +7 -> 228
    //   224: aload_1
    //   225: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   228: aload 5
    //   230: athrow
    //   231: astore_1
    //   232: aload_1
    //   233: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   236: goto -8 -> 228
    //   239: astore 5
    //   241: goto -21 -> 220
    //   244: astore 5
    //   246: goto -26 -> 220
    //   249: astore 5
    //   251: iconst_0
    //   252: istore_3
    //   253: goto -62 -> 191
    //   256: astore 5
    //   258: iload 4
    //   260: istore_3
    //   261: goto -70 -> 191
    //   264: iconst_0
    //   265: istore_3
    //   266: goto -156 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	ai
    //   0	269	1	paramContext	Context
    //   1	181	2	bool1	boolean
    //   109	157	3	bool2	boolean
    //   33	226	4	bool3	boolean
    //   7	89	5	localFile	File
    //   185	7	5	localThrowable1	Throwable
    //   216	13	5	localObject1	Object
    //   239	1	5	localObject2	Object
    //   244	1	5	localObject3	Object
    //   249	1	5	localThrowable2	Throwable
    //   256	1	5	localThrowable3	Throwable
    //   45	25	6	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   162	166	168	java/io/IOException
    //   47	63	185	java/lang/Throwable
    //   203	207	209	java/io/IOException
    //   47	63	216	finally
    //   224	228	231	java/io/IOException
    //   63	87	239	finally
    //   92	108	239	finally
    //   110	146	239	finally
    //   191	196	244	finally
    //   63	87	249	java/lang/Throwable
    //   92	108	256	java/lang/Throwable
    //   110	146	256	java/lang/Throwable
  }
  
  boolean a(Context paramContext, int paramInt)
  {
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=" + paramInt);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + Thread.currentThread().getName());
    Context localContext = d(paramContext, paramInt);
    if (localContext != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = new Object[] { localContext, paramContext, Integer.valueOf(paramInt) };
      k.sendMessage(localMessage);
      return true;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
    return false;
  }
  
  /* Error */
  public boolean a(Context paramContext1, Context paramContext2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 123
    //   4: ldc_w 1010
    //   7: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: getstatic 83	com/tencent/smtt/sdk/ai:m	Z
    //   13: istore_3
    //   14: iload_3
    //   15: iconst_1
    //   16: if_icmpne +7 -> 23
    //   19: aload_0
    //   20: monitorexit
    //   21: iconst_1
    //   22: ireturn
    //   23: iconst_1
    //   24: putstatic 83	com/tencent/smtt/sdk/ai:m	Z
    //   27: new 1012	com/tencent/smtt/sdk/am
    //   30: dup
    //   31: aload_0
    //   32: aload_2
    //   33: aload_1
    //   34: invokespecial 1015	com/tencent/smtt/sdk/am:<init>	(Lcom/tencent/smtt/sdk/ai;Landroid/content/Context;Landroid/content/Context;)V
    //   37: invokevirtual 1018	com/tencent/smtt/sdk/am:start	()V
    //   40: goto -21 -> 19
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	ai
    //   0	48	1	paramContext1	Context
    //   0	48	2	paramContext2	Context
    //   13	4	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	43	finally
    //   23	40	43	finally
  }
  
  public boolean a(Context paramContext, File[] paramArrayOfFile)
  {
    return false;
  }
  
  int b(Context paramContext, String paramString)
  {
    int n = 0;
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
    if (paramContext != null) {
      n = paramContext.versionCode;
    }
    return n;
  }
  
  File b(Context paramContext1, Context paramContext2)
  {
    paramContext2 = new File(paramContext2.getDir("tbs", 0), "core_share");
    if ((paramContext2 == null) || ((!paramContext2.isDirectory()) && ((paramContext1 == null) || (!TbsShareManager.isThirdPartyApp(paramContext1))) && (!paramContext2.mkdir()))) {
      return null;
    }
    return paramContext2;
  }
  
  /* Error */
  void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 87	com/tencent/smtt/sdk/ai:d	I
    //   6: istore_1
    //   7: aload_0
    //   8: iload_1
    //   9: iconst_1
    //   10: isub
    //   11: putfield 87	com/tencent/smtt/sdk/ai:d	I
    //   14: iload_1
    //   15: iconst_1
    //   16: if_icmpgt +10 -> 26
    //   19: aload_0
    //   20: getfield 89	com/tencent/smtt/sdk/ai:g	Z
    //   23: ifne +14 -> 37
    //   26: ldc 123
    //   28: ldc_w 1032
    //   31: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: ldc 123
    //   39: ldc_w 1034
    //   42: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: getfield 1036	com/tencent/smtt/sdk/ai:e	Ljava/nio/channels/FileLock;
    //   49: aload_0
    //   50: getfield 1038	com/tencent/smtt/sdk/ai:f	Ljava/io/FileOutputStream;
    //   53: invokestatic 1041	com/tencent/smtt/utils/j:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   56: aload_0
    //   57: iconst_0
    //   58: putfield 89	com/tencent/smtt/sdk/ai:g	Z
    //   61: goto -27 -> 34
    //   64: astore_2
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_2
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	ai
    //   6	11	1	n	int
    //   64	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	64	finally
    //   19	26	64	finally
    //   26	34	64	finally
    //   37	61	64	finally
  }
  
  void b(Context paramContext, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
    if (paramInt <= 0) {}
    int n;
    do
    {
      do
      {
        return;
        n = c(paramContext);
      } while (n == paramInt);
      Context localContext = TbsShareManager.d(paramContext);
      if (localContext != null)
      {
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
        a(paramContext, localContext);
        return;
      }
    } while (n > 0);
    TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
    QbSdk.a(paramContext, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
  }
  
  /* Error */
  void b(Context paramContext, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 226	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;)Z
    //   5: ifeq +14 -> 19
    //   8: aload_1
    //   9: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   12: sipush 64997
    //   15: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   18: return
    //   19: ldc 123
    //   21: ldc_w 1056
    //   24: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_2
    //   28: ifnull -10 -> 18
    //   31: aload_1
    //   32: ifnull -14 -> 18
    //   35: aload_1
    //   36: invokestatic 315	com/tencent/smtt/utils/j:b	(Landroid/content/Context;)Z
    //   39: ifne +70 -> 109
    //   42: invokestatic 320	com/tencent/smtt/utils/z:a	()J
    //   45: lstore 6
    //   47: aload_1
    //   48: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   51: invokevirtual 323	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   54: lstore 4
    //   56: aload_1
    //   57: invokestatic 328	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   60: sipush 210
    //   63: new 125	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   70: ldc_w 1058
    //   73: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: lload 6
    //   78: invokevirtual 333	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   81: ldc_w 335
    //   84: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: lload 4
    //   89: invokevirtual 333	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   92: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokevirtual 338	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   98: aload_1
    //   99: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   102: sipush 64996
    //   105: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   108: return
    //   109: aload_0
    //   110: aload_1
    //   111: invokevirtual 261	com/tencent/smtt/sdk/ai:l	(Landroid/content/Context;)Z
    //   114: ifne +14 -> 128
    //   117: aload_1
    //   118: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   121: sipush 64995
    //   124: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   127: return
    //   128: getstatic 40	com/tencent/smtt/sdk/ai:i	Ljava/util/concurrent/locks/Lock;
    //   131: invokeinterface 266 1 0
    //   136: istore 8
    //   138: ldc 123
    //   140: new 125	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 1060
    //   150: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: iload 8
    //   155: invokevirtual 427	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   158: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: iload 8
    //   166: ifeq +619 -> 785
    //   169: aconst_null
    //   170: astore 11
    //   172: aconst_null
    //   173: astore 10
    //   175: aload 11
    //   177: astore 9
    //   179: iconst_1
    //   180: invokestatic 1064	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   183: aload 11
    //   185: astore 9
    //   187: aload_0
    //   188: aload_1
    //   189: invokevirtual 301	com/tencent/smtt/sdk/ai:c	(Landroid/content/Context;)I
    //   192: ifle +18 -> 210
    //   195: aload 11
    //   197: astore 9
    //   199: aload_1
    //   200: invokestatic 274	com/tencent/smtt/sdk/ad:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ad;
    //   203: invokevirtual 714	com/tencent/smtt/sdk/ad:d	()I
    //   206: iconst_1
    //   207: if_icmpne +36 -> 243
    //   210: aload 11
    //   212: astore 9
    //   214: iconst_0
    //   215: invokestatic 1064	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   218: getstatic 40	com/tencent/smtt/sdk/ai:i	Ljava/util/concurrent/locks/Lock;
    //   221: invokeinterface 296 1 0
    //   226: aload_0
    //   227: invokevirtual 298	com/tencent/smtt/sdk/ai:b	()V
    //   230: ldc 123
    //   232: ldc_w 1066
    //   235: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: iconst_0
    //   239: invokestatic 1064	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   242: return
    //   243: aload 11
    //   245: astore 9
    //   247: aload_1
    //   248: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   251: getfield 658	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   254: ldc_w 660
    //   257: iconst_0
    //   258: invokeinterface 250 3 0
    //   263: istore_3
    //   264: iload_3
    //   265: iconst_1
    //   266: if_icmpeq +746 -> 1012
    //   269: iload_3
    //   270: iconst_2
    //   271: if_icmpeq +741 -> 1012
    //   274: iload_3
    //   275: iconst_4
    //   276: if_icmpne +54 -> 330
    //   279: goto +733 -> 1012
    //   282: iload_3
    //   283: ifne +721 -> 1004
    //   286: aload 11
    //   288: astore 9
    //   290: aload_1
    //   291: invokestatic 274	com/tencent/smtt/sdk/ad:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ad;
    //   294: ldc_w 869
    //   297: invokevirtual 279	com/tencent/smtt/sdk/ad:c	(Ljava/lang/String;)I
    //   300: istore_3
    //   301: iload_3
    //   302: iconst_5
    //   303: if_icmple +32 -> 335
    //   306: aload 11
    //   308: astore 9
    //   310: ldc 123
    //   312: ldc_w 1068
    //   315: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   318: aload 11
    //   320: astore 9
    //   322: new 1070	java/lang/NullPointerException
    //   325: dup
    //   326: invokespecial 1071	java/lang/NullPointerException:<init>	()V
    //   329: athrow
    //   330: iconst_0
    //   331: istore_3
    //   332: goto -50 -> 282
    //   335: aload 11
    //   337: astore 9
    //   339: aload_1
    //   340: invokestatic 274	com/tencent/smtt/sdk/ad:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ad;
    //   343: ldc_w 869
    //   346: iload_3
    //   347: iconst_1
    //   348: iadd
    //   349: invokevirtual 345	com/tencent/smtt/sdk/ad:a	(Ljava/lang/String;I)V
    //   352: aload 11
    //   354: astore 9
    //   356: aload_1
    //   357: invokestatic 1073	com/tencent/smtt/sdk/ai:i	(Landroid/content/Context;)Ljava/io/File;
    //   360: astore 12
    //   362: aload 12
    //   364: ifnull +640 -> 1004
    //   367: aload 11
    //   369: astore 9
    //   371: new 114	java/io/File
    //   374: dup
    //   375: aload 12
    //   377: ldc_w 1075
    //   380: invokespecial 156	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   383: astore 12
    //   385: aload 12
    //   387: ifnull +617 -> 1004
    //   390: aload 11
    //   392: astore 9
    //   394: aload 12
    //   396: invokevirtual 384	java/io/File:exists	()Z
    //   399: ifeq +605 -> 1004
    //   402: aload 11
    //   404: astore 9
    //   406: aload_1
    //   407: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   410: sipush 64986
    //   413: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   416: aload 11
    //   418: astore 9
    //   420: aload_1
    //   421: aload_2
    //   422: invokestatic 1078	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   425: astore_2
    //   426: aload_2
    //   427: ifnonnull +106 -> 533
    //   430: iconst_1
    //   431: istore_3
    //   432: getstatic 40	com/tencent/smtt/sdk/ai:i	Ljava/util/concurrent/locks/Lock;
    //   435: invokeinterface 296 1 0
    //   440: aload_0
    //   441: invokevirtual 298	com/tencent/smtt/sdk/ai:b	()V
    //   444: iload_3
    //   445: ifne +449 -> 894
    //   448: ldc 123
    //   450: ldc_w 1080
    //   453: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   456: aload_1
    //   457: invokestatic 274	com/tencent/smtt/sdk/ad:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ad;
    //   460: ldc_w 869
    //   463: iconst_0
    //   464: invokevirtual 345	com/tencent/smtt/sdk/ad:a	(Ljava/lang/String;I)V
    //   467: aload_1
    //   468: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   471: sipush 64992
    //   474: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   477: aload_1
    //   478: invokestatic 274	com/tencent/smtt/sdk/ad:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ad;
    //   481: iconst_0
    //   482: iconst_m1
    //   483: invokevirtual 617	com/tencent/smtt/sdk/ad:b	(II)V
    //   486: aload_1
    //   487: invokestatic 274	com/tencent/smtt/sdk/ad:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ad;
    //   490: iconst_1
    //   491: invokevirtual 873	com/tencent/smtt/sdk/ad:c	(I)V
    //   494: aload_2
    //   495: ldc_w 1082
    //   498: invokevirtual 1085	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   501: astore 9
    //   503: new 114	java/io/File
    //   506: dup
    //   507: aload 9
    //   509: invokespecial 117	java/io/File:<init>	(Ljava/lang/String;)V
    //   512: aload_1
    //   513: invokestatic 447	com/tencent/smtt/sdk/ab:a	(Ljava/io/File;Landroid/content/Context;)V
    //   516: aload_0
    //   517: aload_1
    //   518: aload 9
    //   520: aload_2
    //   521: ldc_w 1087
    //   524: invokevirtual 1089	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   527: invokevirtual 981	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   530: goto -292 -> 238
    //   533: aload_2
    //   534: astore 9
    //   536: aload_2
    //   537: astore 10
    //   539: aload_2
    //   540: ldc_w 1091
    //   543: invokevirtual 1089	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   546: istore_3
    //   547: goto -115 -> 432
    //   550: astore_2
    //   551: aload 9
    //   553: astore 10
    //   555: aload_2
    //   556: invokevirtual 404	java/lang/Exception:printStackTrace	()V
    //   559: aload_1
    //   560: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   563: sipush 64993
    //   566: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   569: aload_1
    //   570: invokestatic 328	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   573: sipush 218
    //   576: aload_2
    //   577: invokevirtual 405	java/lang/Exception:toString	()Ljava/lang/String;
    //   580: invokevirtual 338	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   583: getstatic 40	com/tencent/smtt/sdk/ai:i	Ljava/util/concurrent/locks/Lock;
    //   586: invokeinterface 296 1 0
    //   591: aload_0
    //   592: invokevirtual 298	com/tencent/smtt/sdk/ai:b	()V
    //   595: aload_1
    //   596: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   599: sipush 64990
    //   602: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   605: ldc 123
    //   607: ldc_w 1093
    //   610: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   613: aload_1
    //   614: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   617: getfield 630	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   620: ldc_w 632
    //   623: iconst_1
    //   624: invokestatic 637	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   627: invokeinterface 643 3 0
    //   632: pop
    //   633: aload_1
    //   634: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   637: invokevirtual 647	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   640: aload_1
    //   641: invokestatic 328	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   644: sipush 217
    //   647: new 125	java/lang/StringBuilder
    //   650: dup
    //   651: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   654: ldc_w 1095
    //   657: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: iconst_1
    //   661: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   664: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: invokevirtual 338	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   670: goto -432 -> 238
    //   673: astore_2
    //   674: aconst_null
    //   675: astore 9
    //   677: iconst_2
    //   678: istore_3
    //   679: getstatic 40	com/tencent/smtt/sdk/ai:i	Ljava/util/concurrent/locks/Lock;
    //   682: invokeinterface 296 1 0
    //   687: aload_0
    //   688: invokevirtual 298	com/tencent/smtt/sdk/ai:b	()V
    //   691: iload_3
    //   692: ifne +108 -> 800
    //   695: ldc 123
    //   697: ldc_w 1080
    //   700: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   703: aload_1
    //   704: invokestatic 274	com/tencent/smtt/sdk/ad:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ad;
    //   707: ldc_w 869
    //   710: iconst_0
    //   711: invokevirtual 345	com/tencent/smtt/sdk/ad:a	(Ljava/lang/String;I)V
    //   714: aload_1
    //   715: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   718: sipush 64992
    //   721: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   724: aload_1
    //   725: invokestatic 274	com/tencent/smtt/sdk/ad:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ad;
    //   728: iconst_0
    //   729: iconst_m1
    //   730: invokevirtual 617	com/tencent/smtt/sdk/ad:b	(II)V
    //   733: aload_1
    //   734: invokestatic 274	com/tencent/smtt/sdk/ad:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/ad;
    //   737: iconst_1
    //   738: invokevirtual 873	com/tencent/smtt/sdk/ad:c	(I)V
    //   741: aload 9
    //   743: ldc_w 1082
    //   746: invokevirtual 1085	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   749: astore 10
    //   751: new 114	java/io/File
    //   754: dup
    //   755: aload 10
    //   757: invokespecial 117	java/io/File:<init>	(Ljava/lang/String;)V
    //   760: aload_1
    //   761: invokestatic 447	com/tencent/smtt/sdk/ab:a	(Ljava/io/File;Landroid/content/Context;)V
    //   764: aload_0
    //   765: aload_1
    //   766: aload 10
    //   768: aload 9
    //   770: ldc_w 1087
    //   773: invokevirtual 1089	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   776: invokevirtual 981	com/tencent/smtt/sdk/ai:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   779: iconst_0
    //   780: invokestatic 1064	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   783: aload_2
    //   784: athrow
    //   785: aload_1
    //   786: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   789: sipush 64989
    //   792: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   795: aload_0
    //   796: invokevirtual 298	com/tencent/smtt/sdk/ai:b	()V
    //   799: return
    //   800: iload_3
    //   801: iconst_2
    //   802: if_icmpne +14 -> 816
    //   805: ldc 123
    //   807: ldc_w 1066
    //   810: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   813: goto -34 -> 779
    //   816: aload_1
    //   817: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   820: sipush 64990
    //   823: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   826: ldc 123
    //   828: ldc_w 1093
    //   831: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   834: aload_1
    //   835: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   838: getfield 630	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   841: ldc_w 632
    //   844: iconst_1
    //   845: invokestatic 637	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   848: invokeinterface 643 3 0
    //   853: pop
    //   854: aload_1
    //   855: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   858: invokevirtual 647	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   861: aload_1
    //   862: invokestatic 328	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   865: sipush 217
    //   868: new 125	java/lang/StringBuilder
    //   871: dup
    //   872: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   875: ldc_w 1095
    //   878: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: iload_3
    //   882: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   885: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   888: invokevirtual 338	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   891: goto -112 -> 779
    //   894: iload_3
    //   895: iconst_2
    //   896: if_icmpne +14 -> 910
    //   899: ldc 123
    //   901: ldc_w 1066
    //   904: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   907: goto -669 -> 238
    //   910: aload_1
    //   911: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   914: sipush 64990
    //   917: invokevirtual 223	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   920: ldc 123
    //   922: ldc_w 1093
    //   925: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   928: aload_1
    //   929: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   932: getfield 630	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   935: ldc_w 632
    //   938: iconst_1
    //   939: invokestatic 637	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   942: invokeinterface 643 3 0
    //   947: pop
    //   948: aload_1
    //   949: invokestatic 219	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   952: invokevirtual 647	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   955: aload_1
    //   956: invokestatic 328	com/tencent/smtt/sdk/TbsLogReport:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   959: sipush 217
    //   962: new 125	java/lang/StringBuilder
    //   965: dup
    //   966: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   969: ldc_w 1095
    //   972: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   975: iload_3
    //   976: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   979: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: invokevirtual 338	com/tencent/smtt/sdk/TbsLogReport:a	(ILjava/lang/String;)V
    //   985: goto -747 -> 238
    //   988: astore_2
    //   989: aload 10
    //   991: astore 9
    //   993: iconst_2
    //   994: istore_3
    //   995: goto -316 -> 679
    //   998: astore_2
    //   999: iconst_1
    //   1000: istore_3
    //   1001: goto -322 -> 679
    //   1004: iconst_2
    //   1005: istore_3
    //   1006: aload 10
    //   1008: astore_2
    //   1009: goto -577 -> 432
    //   1012: iconst_1
    //   1013: istore_3
    //   1014: goto -732 -> 282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1017	0	this	ai
    //   0	1017	1	paramContext	Context
    //   0	1017	2	paramBundle	Bundle
    //   263	751	3	n	int
    //   54	34	4	l1	long
    //   45	32	6	l2	long
    //   136	29	8	bool	boolean
    //   177	815	9	localObject1	Object
    //   173	834	10	localObject2	Object
    //   170	247	11	localObject3	Object
    //   360	35	12	localFile	File
    // Exception table:
    //   from	to	target	type
    //   179	183	550	java/lang/Exception
    //   187	195	550	java/lang/Exception
    //   199	210	550	java/lang/Exception
    //   214	218	550	java/lang/Exception
    //   247	264	550	java/lang/Exception
    //   290	301	550	java/lang/Exception
    //   310	318	550	java/lang/Exception
    //   322	330	550	java/lang/Exception
    //   339	352	550	java/lang/Exception
    //   356	362	550	java/lang/Exception
    //   371	385	550	java/lang/Exception
    //   394	402	550	java/lang/Exception
    //   406	416	550	java/lang/Exception
    //   420	426	550	java/lang/Exception
    //   539	547	550	java/lang/Exception
    //   179	183	673	finally
    //   187	195	673	finally
    //   199	210	673	finally
    //   214	218	673	finally
    //   247	264	673	finally
    //   290	301	673	finally
    //   310	318	673	finally
    //   322	330	673	finally
    //   339	352	673	finally
    //   356	362	673	finally
    //   371	385	673	finally
    //   394	402	673	finally
    //   406	416	673	finally
    //   420	426	673	finally
    //   539	547	988	finally
    //   555	559	988	finally
    //   559	583	998	finally
  }
  
  void b(Context paramContext, boolean paramBoolean)
  {
    int i2 = 0;
    if (QbSdk.b) {}
    label54:
    label121:
    label127:
    label131:
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT < 8)
      {
        TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
        return;
      }
      int n;
      int i1;
      if (!c(paramContext, "core_copy_tmp"))
      {
        n = 0;
        if (c(paramContext, "core_unzip_tmp")) {
          break label121;
        }
        i1 = 0;
        if (c(paramContext, "core_share_backup_tmp")) {
          break label127;
        }
      }
      for (;;)
      {
        if (((i2 == 0) || (!e(paramContext, paramBoolean))) && ((n == 0) || (!c(paramContext, paramBoolean))) && ((i1 == 0) || (!d(paramContext, paramBoolean)))) {
          break label131;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, SUCCESS!!", true);
        return;
        n = 1;
        break;
        i1 = 1;
        break label54;
        i2 = 1;
      }
    }
  }
  
  boolean b(Context paramContext)
  {
    try
    {
      Signature localSignature = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0];
      if (paramContext.getPackageName().equals("com.tencent.mtt"))
      {
        if (localSignature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
          break label201;
        }
        return false;
      }
      if (paramContext.getPackageName().equals("com.tencent.mm"))
      {
        if (localSignature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499")) {
          break label201;
        }
      }
      else
      {
        if (paramContext.getPackageName().equals("com.tencent.mobileqq"))
        {
          if (localSignature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049")) {
            break label201;
          }
          return false;
        }
        if (paramContext.getPackageName().equals("com.tencent.x5sdk.demo"))
        {
          if (localSignature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
            break label201;
          }
          return false;
        }
        if (paramContext.getPackageName().equals("com.qzone"))
        {
          if (localSignature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677")) {
            break label201;
          }
          return false;
        }
        if (!paramContext.getPackageName().equals("com.tencent.qqpimsecure")) {
          break label201;
        }
        boolean bool = localSignature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8");
        if (bool) {
          break label201;
        }
        return false;
      }
    }
    catch (Exception paramContext)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
    }
    return false;
    label201:
    return true;
  }
  
  /* Error */
  int c(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore 4
    //   5: new 114	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: aload_1
    //   11: invokevirtual 348	com/tencent/smtt/sdk/ai:g	(Landroid/content/Context;)Ljava/io/File;
    //   14: ldc -95
    //   16: invokespecial 156	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   19: astore_1
    //   20: aload_1
    //   21: ifnull +14 -> 35
    //   24: aload_1
    //   25: invokevirtual 384	java/io/File:exists	()Z
    //   28: istore 5
    //   30: iload 5
    //   32: ifne +20 -> 52
    //   35: iload 4
    //   37: istore_3
    //   38: iconst_0
    //   39: ifeq +11 -> 50
    //   42: new 1070	java/lang/NullPointerException
    //   45: dup
    //   46: invokespecial 1071	java/lang/NullPointerException:<init>	()V
    //   49: athrow
    //   50: iload_3
    //   51: ireturn
    //   52: new 163	java/util/Properties
    //   55: dup
    //   56: invokespecial 164	java/util/Properties:<init>	()V
    //   59: astore 7
    //   61: new 166	java/io/BufferedInputStream
    //   64: dup
    //   65: new 168	java/io/FileInputStream
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 171	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   73: invokespecial 174	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   76: astore 6
    //   78: aload 6
    //   80: astore_1
    //   81: aload 7
    //   83: aload 6
    //   85: invokevirtual 177	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   88: aload 6
    //   90: astore_1
    //   91: aload 6
    //   93: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   96: aload 6
    //   98: astore_1
    //   99: aload 7
    //   101: ldc_w 1145
    //   104: invokevirtual 1147	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   107: astore 7
    //   109: aload 7
    //   111: ifnonnull +51 -> 162
    //   114: iload 4
    //   116: istore_3
    //   117: aload 6
    //   119: ifnull -69 -> 50
    //   122: aload 6
    //   124: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   127: iconst_0
    //   128: ireturn
    //   129: astore_1
    //   130: new 125	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   137: ldc_w 1149
    //   140: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: invokevirtual 1150	java/io/IOException:toString	()Ljava/lang/String;
    //   147: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: astore_1
    //   154: ldc 123
    //   156: aload_1
    //   157: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: iload_2
    //   161: ireturn
    //   162: aload 6
    //   164: astore_1
    //   165: aload 7
    //   167: invokestatic 1153	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   170: istore_3
    //   171: iload_3
    //   172: istore_2
    //   173: iload_2
    //   174: istore_3
    //   175: aload 6
    //   177: ifnull -127 -> 50
    //   180: aload 6
    //   182: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   185: iload_2
    //   186: ireturn
    //   187: astore_1
    //   188: new 125	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   195: ldc_w 1149
    //   198: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_1
    //   202: invokevirtual 1150	java/io/IOException:toString	()Ljava/lang/String;
    //   205: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: astore_1
    //   212: goto -58 -> 154
    //   215: astore 7
    //   217: aconst_null
    //   218: astore 6
    //   220: aload 6
    //   222: astore_1
    //   223: ldc 123
    //   225: new 125	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   232: ldc_w 1155
    //   235: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload 7
    //   240: invokevirtual 405	java/lang/Exception:toString	()Ljava/lang/String;
    //   243: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: iload 4
    //   254: istore_3
    //   255: aload 6
    //   257: ifnull -207 -> 50
    //   260: aload 6
    //   262: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   265: iconst_0
    //   266: ireturn
    //   267: astore_1
    //   268: new 125	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   275: ldc_w 1149
    //   278: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_1
    //   282: invokevirtual 1150	java/io/IOException:toString	()Ljava/lang/String;
    //   285: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: astore_1
    //   292: goto -138 -> 154
    //   295: astore 6
    //   297: aconst_null
    //   298: astore_1
    //   299: aload_1
    //   300: ifnull +7 -> 307
    //   303: aload_1
    //   304: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   307: aload 6
    //   309: athrow
    //   310: astore_1
    //   311: ldc 123
    //   313: new 125	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   320: ldc_w 1149
    //   323: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_1
    //   327: invokevirtual 1150	java/io/IOException:toString	()Ljava/lang/String;
    //   330: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: goto -32 -> 307
    //   342: astore_1
    //   343: new 125	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   350: ldc_w 1149
    //   353: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_1
    //   357: invokevirtual 1150	java/io/IOException:toString	()Ljava/lang/String;
    //   360: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: astore_1
    //   367: goto -213 -> 154
    //   370: astore 6
    //   372: goto -73 -> 299
    //   375: astore 7
    //   377: goto -157 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	this	ai
    //   0	380	1	paramContext	Context
    //   1	185	2	n	int
    //   37	218	3	i1	int
    //   3	250	4	i2	int
    //   28	3	5	bool	boolean
    //   76	185	6	localBufferedInputStream	java.io.BufferedInputStream
    //   295	13	6	localObject1	Object
    //   370	1	6	localObject2	Object
    //   59	107	7	localObject3	Object
    //   215	24	7	localException1	Exception
    //   375	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   122	127	129	java/io/IOException
    //   180	185	187	java/io/IOException
    //   5	20	215	java/lang/Exception
    //   24	30	215	java/lang/Exception
    //   52	78	215	java/lang/Exception
    //   260	265	267	java/io/IOException
    //   5	20	295	finally
    //   24	30	295	finally
    //   52	78	295	finally
    //   303	307	310	java/io/IOException
    //   42	50	342	java/io/IOException
    //   81	88	370	finally
    //   91	96	370	finally
    //   99	109	370	finally
    //   165	171	370	finally
    //   223	252	370	finally
    //   81	88	375	java/lang/Exception
    //   91	96	375	java/lang/Exception
    //   99	109	375	java/lang/Exception
    //   165	171	375	java/lang/Exception
  }
  
  boolean d(Context paramContext)
  {
    paramContext = new File(g(paramContext), "tbs.conf");
    return (paramContext != null) && (paramContext.exists());
  }
  
  /* Error */
  int e(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 261	com/tencent/smtt/sdk/ai:l	(Landroid/content/Context;)Z
    //   5: ifne +5 -> 10
    //   8: iconst_m1
    //   9: ireturn
    //   10: getstatic 38	com/tencent/smtt/sdk/ai:h	Ljava/util/concurrent/locks/Lock;
    //   13: invokeinterface 266 1 0
    //   18: istore_3
    //   19: ldc 123
    //   21: new 125	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 1157
    //   31: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_3
    //   35: invokevirtual 427	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   38: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: iload_3
    //   45: ifeq +288 -> 333
    //   48: new 114	java/io/File
    //   51: dup
    //   52: aload_0
    //   53: aload_1
    //   54: invokevirtual 348	com/tencent/smtt/sdk/ai:g	(Landroid/content/Context;)Ljava/io/File;
    //   57: ldc -95
    //   59: invokespecial 156	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   62: astore_1
    //   63: aload_1
    //   64: ifnull +12 -> 76
    //   67: aload_1
    //   68: invokevirtual 384	java/io/File:exists	()Z
    //   71: istore_3
    //   72: iload_3
    //   73: ifne +29 -> 102
    //   76: iconst_0
    //   77: ifeq +11 -> 88
    //   80: new 1070	java/lang/NullPointerException
    //   83: dup
    //   84: invokespecial 1071	java/lang/NullPointerException:<init>	()V
    //   87: athrow
    //   88: getstatic 38	com/tencent/smtt/sdk/ai:h	Ljava/util/concurrent/locks/Lock;
    //   91: invokeinterface 296 1 0
    //   96: aload_0
    //   97: invokevirtual 298	com/tencent/smtt/sdk/ai:b	()V
    //   100: iconst_0
    //   101: ireturn
    //   102: new 163	java/util/Properties
    //   105: dup
    //   106: invokespecial 164	java/util/Properties:<init>	()V
    //   109: astore 5
    //   111: new 166	java/io/BufferedInputStream
    //   114: dup
    //   115: new 168	java/io/FileInputStream
    //   118: dup
    //   119: aload_1
    //   120: invokespecial 171	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   123: invokespecial 174	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   126: astore 4
    //   128: aload 4
    //   130: astore_1
    //   131: aload 5
    //   133: aload 4
    //   135: invokevirtual 177	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   138: aload 4
    //   140: astore_1
    //   141: aload 4
    //   143: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   146: aload 4
    //   148: astore_1
    //   149: aload 5
    //   151: ldc_w 1145
    //   154: invokevirtual 1147	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   157: astore 5
    //   159: aload 5
    //   161: ifnonnull +27 -> 188
    //   164: aload 4
    //   166: ifnull +8 -> 174
    //   169: aload 4
    //   171: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   174: getstatic 38	com/tencent/smtt/sdk/ai:h	Ljava/util/concurrent/locks/Lock;
    //   177: invokeinterface 296 1 0
    //   182: aload_0
    //   183: invokevirtual 298	com/tencent/smtt/sdk/ai:b	()V
    //   186: iconst_0
    //   187: ireturn
    //   188: aload 4
    //   190: astore_1
    //   191: getstatic 45	com/tencent/smtt/sdk/ai:a	Ljava/lang/ThreadLocal;
    //   194: aload 5
    //   196: invokestatic 1153	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   199: invokestatic 884	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   202: invokevirtual 890	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   205: aload 4
    //   207: astore_1
    //   208: getstatic 45	com/tencent/smtt/sdk/ai:a	Ljava/lang/ThreadLocal;
    //   211: invokevirtual 922	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   214: checkcast 881	java/lang/Integer
    //   217: invokevirtual 925	java/lang/Integer:intValue	()I
    //   220: istore_2
    //   221: aload 4
    //   223: ifnull +8 -> 231
    //   226: aload 4
    //   228: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   231: getstatic 38	com/tencent/smtt/sdk/ai:h	Ljava/util/concurrent/locks/Lock;
    //   234: invokeinterface 296 1 0
    //   239: aload_0
    //   240: invokevirtual 298	com/tencent/smtt/sdk/ai:b	()V
    //   243: iload_2
    //   244: ireturn
    //   245: astore 5
    //   247: aconst_null
    //   248: astore 4
    //   250: aload 4
    //   252: astore_1
    //   253: ldc 123
    //   255: new 125	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   262: ldc_w 1159
    //   265: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload 5
    //   270: invokevirtual 405	java/lang/Exception:toString	()Ljava/lang/String;
    //   273: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: aload 4
    //   284: ifnull +8 -> 292
    //   287: aload 4
    //   289: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   292: getstatic 38	com/tencent/smtt/sdk/ai:h	Ljava/util/concurrent/locks/Lock;
    //   295: invokeinterface 296 1 0
    //   300: aload_0
    //   301: invokevirtual 298	com/tencent/smtt/sdk/ai:b	()V
    //   304: iconst_0
    //   305: ireturn
    //   306: astore 4
    //   308: aconst_null
    //   309: astore_1
    //   310: aload_1
    //   311: ifnull +7 -> 318
    //   314: aload_1
    //   315: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   318: getstatic 38	com/tencent/smtt/sdk/ai:h	Ljava/util/concurrent/locks/Lock;
    //   321: invokeinterface 296 1 0
    //   326: aload_0
    //   327: invokevirtual 298	com/tencent/smtt/sdk/ai:b	()V
    //   330: aload 4
    //   332: athrow
    //   333: aload_0
    //   334: invokevirtual 298	com/tencent/smtt/sdk/ai:b	()V
    //   337: iconst_0
    //   338: ireturn
    //   339: astore_1
    //   340: ldc 123
    //   342: new 125	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   349: ldc_w 1161
    //   352: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_1
    //   356: invokevirtual 1150	java/io/IOException:toString	()Ljava/lang/String;
    //   359: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: goto -50 -> 318
    //   371: astore_1
    //   372: ldc 123
    //   374: new 125	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   381: ldc_w 1161
    //   384: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: aload_1
    //   388: invokevirtual 1150	java/io/IOException:toString	()Ljava/lang/String;
    //   391: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: goto -108 -> 292
    //   403: astore_1
    //   404: ldc 123
    //   406: new 125	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   413: ldc_w 1161
    //   416: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: aload_1
    //   420: invokevirtual 1150	java/io/IOException:toString	()Ljava/lang/String;
    //   423: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   432: goto -344 -> 88
    //   435: astore_1
    //   436: ldc 123
    //   438: new 125	java/lang/StringBuilder
    //   441: dup
    //   442: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   445: ldc_w 1161
    //   448: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload_1
    //   452: invokevirtual 1150	java/io/IOException:toString	()Ljava/lang/String;
    //   455: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   464: goto -290 -> 174
    //   467: astore_1
    //   468: ldc 123
    //   470: new 125	java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   477: ldc_w 1161
    //   480: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: aload_1
    //   484: invokevirtual 1150	java/io/IOException:toString	()Ljava/lang/String;
    //   487: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 231	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   496: goto -265 -> 231
    //   499: astore 4
    //   501: goto -191 -> 310
    //   504: astore 5
    //   506: goto -256 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	509	0	this	ai
    //   0	509	1	paramContext	Context
    //   220	24	2	n	int
    //   18	55	3	bool	boolean
    //   126	162	4	localBufferedInputStream	java.io.BufferedInputStream
    //   306	25	4	localObject1	Object
    //   499	1	4	localObject2	Object
    //   109	86	5	localObject3	Object
    //   245	24	5	localException1	Exception
    //   504	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   48	63	245	java/lang/Exception
    //   67	72	245	java/lang/Exception
    //   102	128	245	java/lang/Exception
    //   48	63	306	finally
    //   67	72	306	finally
    //   102	128	306	finally
    //   314	318	339	java/io/IOException
    //   287	292	371	java/io/IOException
    //   80	88	403	java/io/IOException
    //   169	174	435	java/io/IOException
    //   226	231	467	java/io/IOException
    //   131	138	499	finally
    //   141	146	499	finally
    //   149	159	499	finally
    //   191	205	499	finally
    //   208	221	499	finally
    //   253	282	499	finally
    //   131	138	504	java/lang/Exception
    //   141	146	504	java/lang/Exception
    //   149	159	504	java/lang/Exception
    //   191	205	504	java/lang/Exception
    //   208	221	504	java/lang/Exception
  }
  
  void f(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
    ad.a(paramContext).a(0);
    ad.a(paramContext).b(0);
    ad.a(paramContext).d(0);
    ad.a(paramContext).a("incrupdate_retry_num", 0);
    ad.a(paramContext).b(0, -1);
    ad.a(paramContext).a("");
    ad.a(paramContext).a("copy_retry_num", 0);
    ad.a(paramContext).a(0, -1);
    ad.a(paramContext).c(-1);
    j.a(j(paramContext), true);
    j.a(k(paramContext), true);
  }
  
  File g(Context paramContext)
  {
    return b(null, paramContext);
  }
  
  File h(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "share");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  File j(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_unzip_tmp");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  File k(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_copy_tmp");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  boolean l(Context paramContext)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        this.d += 1;
        if (this.g)
        {
          TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= true");
          return bool;
        }
        this.f = j.b(paramContext, true, "tbslock.txt");
        if (this.f != null)
        {
          this.e = j.a(paramContext, this.f);
          if (this.e == null)
          {
            bool = false;
          }
          else
          {
            TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= false");
            this.g = true;
          }
        }
        else
        {
          bool = false;
        }
      }
      finally {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */