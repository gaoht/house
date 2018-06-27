package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.m;
import com.tencent.smtt.utils.v;
import com.tencent.smtt.utils.w;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;

class TbsLogReport
{
  private static TbsLogReport b;
  int a;
  private Context c;
  private long d;
  private String e;
  private String f;
  private int g;
  private int h;
  private int i;
  private int j;
  private String k;
  private int l;
  private int m;
  private long n;
  private long o;
  private int p;
  private String q;
  private String r;
  private long s;
  
  private TbsLogReport(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    e();
  }
  
  public static TbsLogReport a(Context paramContext)
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new TbsLogReport(paramContext);
      }
      return b;
    }
    finally {}
  }
  
  private String e(long paramLong)
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(paramLong));
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private void e()
  {
    this.d = 0L;
    this.e = null;
    this.f = null;
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = 2;
    this.k = "unknown";
    this.l = 0;
    this.m = 2;
    this.n = 0L;
    this.o = 0L;
    this.p = 1;
    this.a = 0;
    this.q = null;
    this.r = null;
    this.s = 0L;
  }
  
  private String f(long paramLong)
  {
    return paramLong + "|";
  }
  
  private String f(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str + "|";
  }
  
  private JSONArray f()
  {
    Object localObject = h().getString("tbs_download_upload", null);
    if (localObject == null) {
      return new JSONArray();
    }
    try
    {
      localObject = new JSONArray((String)localObject);
      return (JSONArray)localObject;
    }
    catch (Exception localException) {}
    return new JSONArray();
  }
  
  private void g()
  {
    SharedPreferences.Editor localEditor = h().edit();
    localEditor.remove("tbs_download_upload");
    localEditor.commit();
  }
  
  private SharedPreferences h()
  {
    return this.c.getSharedPreferences("tbs_download_stat", 4);
  }
  
  private String i(int paramInt)
  {
    return paramInt + "|";
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: getfield 47	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   7: invokestatic 186	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   10: iconst_3
    //   11: if_icmpeq +4 -> 15
    //   14: return
    //   15: invokestatic 191	com/tencent/smtt/utils/TbsLog:getTbsLogFilePath	()Ljava/lang/String;
    //   18: astore 6
    //   20: aload 6
    //   22: ifnull -8 -> 14
    //   25: invokestatic 196	com/tencent/smtt/utils/o:a	()Lcom/tencent/smtt/utils/o;
    //   28: invokevirtual 198	com/tencent/smtt/utils/o:b	()Ljava/lang/String;
    //   31: astore 9
    //   33: aload_0
    //   34: getfield 47	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   37: invokestatic 203	com/tencent/smtt/utils/b:c	(Landroid/content/Context;)Ljava/lang/String;
    //   40: astore_3
    //   41: aload_0
    //   42: getfield 47	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   45: invokestatic 205	com/tencent/smtt/utils/b:f	(Landroid/content/Context;)Ljava/lang/String;
    //   48: astore_2
    //   49: aload_3
    //   50: invokevirtual 211	java/lang/String:getBytes	()[B
    //   53: astore_3
    //   54: aload_2
    //   55: invokevirtual 211	java/lang/String:getBytes	()[B
    //   58: astore 4
    //   60: aload_3
    //   61: astore_2
    //   62: invokestatic 196	com/tencent/smtt/utils/o:a	()Lcom/tencent/smtt/utils/o;
    //   65: aload_3
    //   66: invokevirtual 214	com/tencent/smtt/utils/o:a	([B)[B
    //   69: astore_3
    //   70: aload_3
    //   71: astore_2
    //   72: invokestatic 196	com/tencent/smtt/utils/o:a	()Lcom/tencent/smtt/utils/o;
    //   75: aload 4
    //   77: invokevirtual 214	com/tencent/smtt/utils/o:a	([B)[B
    //   80: astore 5
    //   82: aload 5
    //   84: astore_2
    //   85: aload_3
    //   86: astore 4
    //   88: aload_2
    //   89: astore_3
    //   90: aload 4
    //   92: invokestatic 217	com/tencent/smtt/utils/o:b	([B)Ljava/lang/String;
    //   95: astore_2
    //   96: aload_3
    //   97: invokestatic 217	com/tencent/smtt/utils/o:b	([B)Ljava/lang/String;
    //   100: astore_3
    //   101: new 121	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   108: aload_0
    //   109: getfield 47	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   112: invokestatic 222	com/tencent/smtt/utils/w:a	(Landroid/content/Context;)Lcom/tencent/smtt/utils/w;
    //   115: invokevirtual 224	com/tencent/smtt/utils/w:e	()Ljava/lang/String;
    //   118: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_2
    //   122: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc -30
    //   127: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_3
    //   131: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: astore 10
    //   139: new 228	java/util/HashMap
    //   142: dup
    //   143: invokespecial 229	java/util/HashMap:<init>	()V
    //   146: astore 11
    //   148: aload 11
    //   150: ldc -25
    //   152: ldc -23
    //   154: invokeinterface 239 3 0
    //   159: pop
    //   160: aload 11
    //   162: ldc -15
    //   164: ldc -13
    //   166: invokeinterface 239 3 0
    //   171: pop
    //   172: aload 11
    //   174: ldc -11
    //   176: aload_0
    //   177: getfield 47	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   180: invokestatic 249	com/tencent/smtt/utils/v:a	(Landroid/content/Context;)Ljava/lang/String;
    //   183: invokeinterface 239 3 0
    //   188: pop
    //   189: new 251	java/io/File
    //   192: dup
    //   193: getstatic 255	com/tencent/smtt/utils/j:a	Ljava/lang/String;
    //   196: invokespecial 256	java/io/File:<init>	(Ljava/lang/String;)V
    //   199: pop
    //   200: new 9	com/tencent/smtt/sdk/TbsLogReport$ZipHelper
    //   203: dup
    //   204: aload 6
    //   206: new 121	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   213: getstatic 255	com/tencent/smtt/utils/j:a	Ljava/lang/String;
    //   216: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: ldc_w 258
    //   222: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokespecial 261	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: invokevirtual 264	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:Zip	()V
    //   234: new 251	java/io/File
    //   237: dup
    //   238: getstatic 255	com/tencent/smtt/utils/j:a	Ljava/lang/String;
    //   241: ldc_w 266
    //   244: invokespecial 267	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: astore 5
    //   249: new 269	java/io/FileInputStream
    //   252: dup
    //   253: aload 5
    //   255: invokespecial 272	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   258: astore 4
    //   260: sipush 8192
    //   263: newarray <illegal type>
    //   265: astore_3
    //   266: new 274	java/io/ByteArrayOutputStream
    //   269: dup
    //   270: invokespecial 275	java/io/ByteArrayOutputStream:<init>	()V
    //   273: astore_2
    //   274: aload_2
    //   275: astore 8
    //   277: aload 5
    //   279: astore 7
    //   281: aload 4
    //   283: astore 6
    //   285: aload 4
    //   287: aload_3
    //   288: invokevirtual 279	java/io/FileInputStream:read	([B)I
    //   291: istore_1
    //   292: iload_1
    //   293: iconst_m1
    //   294: if_icmpeq +114 -> 408
    //   297: aload_2
    //   298: astore 8
    //   300: aload 5
    //   302: astore 7
    //   304: aload 4
    //   306: astore 6
    //   308: aload_2
    //   309: aload_3
    //   310: iconst_0
    //   311: iload_1
    //   312: invokevirtual 283	java/io/ByteArrayOutputStream:write	([BII)V
    //   315: goto -41 -> 274
    //   318: astore_3
    //   319: aload_2
    //   320: astore 8
    //   322: aload 5
    //   324: astore 7
    //   326: aload 4
    //   328: astore 6
    //   330: aload_3
    //   331: invokevirtual 286	java/lang/Exception:printStackTrace	()V
    //   334: aload 4
    //   336: ifnull +8 -> 344
    //   339: aload 4
    //   341: invokevirtual 289	java/io/FileInputStream:close	()V
    //   344: aload_2
    //   345: ifnull +7 -> 352
    //   348: aload_2
    //   349: invokevirtual 290	java/io/ByteArrayOutputStream:close	()V
    //   352: aload 5
    //   354: ifnull +250 -> 604
    //   357: aload 5
    //   359: invokevirtual 293	java/io/File:delete	()Z
    //   362: pop
    //   363: aconst_null
    //   364: astore_2
    //   365: new 121	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   372: aload 10
    //   374: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: ldc_w 295
    //   380: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: aload 9
    //   385: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: aload 11
    //   393: aload_2
    //   394: new 297	com/tencent/smtt/sdk/aq
    //   397: dup
    //   398: aload_0
    //   399: invokespecial 299	com/tencent/smtt/sdk/aq:<init>	(Lcom/tencent/smtt/sdk/TbsLogReport;)V
    //   402: iconst_0
    //   403: invokestatic 304	com/tencent/smtt/utils/m:a	(Ljava/lang/String;Ljava/util/Map;[BLcom/tencent/smtt/utils/m$a;Z)Ljava/lang/String;
    //   406: pop
    //   407: return
    //   408: aload_2
    //   409: astore 8
    //   411: aload 5
    //   413: astore 7
    //   415: aload 4
    //   417: astore 6
    //   419: aload_2
    //   420: invokevirtual 307	java/io/ByteArrayOutputStream:flush	()V
    //   423: aload_2
    //   424: astore 8
    //   426: aload 5
    //   428: astore 7
    //   430: aload 4
    //   432: astore 6
    //   434: invokestatic 196	com/tencent/smtt/utils/o:a	()Lcom/tencent/smtt/utils/o;
    //   437: aload_2
    //   438: invokevirtual 310	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   441: invokevirtual 214	com/tencent/smtt/utils/o:a	([B)[B
    //   444: astore_3
    //   445: aload 4
    //   447: ifnull +8 -> 455
    //   450: aload 4
    //   452: invokevirtual 289	java/io/FileInputStream:close	()V
    //   455: aload_2
    //   456: ifnull +7 -> 463
    //   459: aload_2
    //   460: invokevirtual 290	java/io/ByteArrayOutputStream:close	()V
    //   463: aload_3
    //   464: astore_2
    //   465: aload 5
    //   467: ifnull -102 -> 365
    //   470: aload 5
    //   472: invokevirtual 293	java/io/File:delete	()Z
    //   475: pop
    //   476: aload_3
    //   477: astore_2
    //   478: goto -113 -> 365
    //   481: astore_2
    //   482: aconst_null
    //   483: astore 5
    //   485: aconst_null
    //   486: astore_3
    //   487: aload_3
    //   488: ifnull +7 -> 495
    //   491: aload_3
    //   492: invokevirtual 289	java/io/FileInputStream:close	()V
    //   495: aload 8
    //   497: ifnull +8 -> 505
    //   500: aload 8
    //   502: invokevirtual 290	java/io/ByteArrayOutputStream:close	()V
    //   505: aload 5
    //   507: ifnull +9 -> 516
    //   510: aload 5
    //   512: invokevirtual 293	java/io/File:delete	()Z
    //   515: pop
    //   516: aload_2
    //   517: athrow
    //   518: astore 4
    //   520: goto -65 -> 455
    //   523: astore_2
    //   524: goto -61 -> 463
    //   527: astore_3
    //   528: goto -184 -> 344
    //   531: astore_2
    //   532: goto -180 -> 352
    //   535: astore_3
    //   536: goto -41 -> 495
    //   539: astore_3
    //   540: goto -35 -> 505
    //   543: astore_2
    //   544: aconst_null
    //   545: astore_3
    //   546: goto -59 -> 487
    //   549: astore_2
    //   550: aload 4
    //   552: astore_3
    //   553: goto -66 -> 487
    //   556: astore_2
    //   557: aload 7
    //   559: astore 5
    //   561: aload 6
    //   563: astore_3
    //   564: goto -77 -> 487
    //   567: astore_3
    //   568: aconst_null
    //   569: astore_2
    //   570: aconst_null
    //   571: astore 5
    //   573: aconst_null
    //   574: astore 4
    //   576: goto -257 -> 319
    //   579: astore_3
    //   580: aconst_null
    //   581: astore_2
    //   582: aconst_null
    //   583: astore 4
    //   585: goto -266 -> 319
    //   588: astore_3
    //   589: aconst_null
    //   590: astore_2
    //   591: goto -272 -> 319
    //   594: astore_3
    //   595: aload 4
    //   597: astore_3
    //   598: aload_2
    //   599: astore 4
    //   601: goto -511 -> 90
    //   604: aconst_null
    //   605: astore_2
    //   606: goto -241 -> 365
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	609	0	this	TbsLogReport
    //   291	21	1	i1	int
    //   48	430	2	localObject1	Object
    //   481	36	2	localObject2	Object
    //   523	1	2	localException1	Exception
    //   531	1	2	localException2	Exception
    //   543	1	2	localObject3	Object
    //   549	1	2	localObject4	Object
    //   556	1	2	localObject5	Object
    //   569	37	2	localObject6	Object
    //   40	270	3	localObject7	Object
    //   318	13	3	localException3	Exception
    //   444	48	3	arrayOfByte	byte[]
    //   527	1	3	localException4	Exception
    //   535	1	3	localException5	Exception
    //   539	1	3	localException6	Exception
    //   545	19	3	localObject8	Object
    //   567	1	3	localException7	Exception
    //   579	1	3	localException8	Exception
    //   588	1	3	localException9	Exception
    //   594	1	3	localException10	Exception
    //   597	1	3	localObject9	Object
    //   58	393	4	localObject10	Object
    //   518	33	4	localException11	Exception
    //   574	26	4	localObject11	Object
    //   80	492	5	localObject12	Object
    //   18	544	6	localObject13	Object
    //   279	279	7	localObject14	Object
    //   1	500	8	localObject15	Object
    //   31	353	9	str1	String
    //   137	236	10	str2	String
    //   146	246	11	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   285	292	318	java/lang/Exception
    //   308	315	318	java/lang/Exception
    //   419	423	318	java/lang/Exception
    //   434	445	318	java/lang/Exception
    //   189	249	481	finally
    //   450	455	518	java/lang/Exception
    //   459	463	523	java/lang/Exception
    //   339	344	527	java/lang/Exception
    //   348	352	531	java/lang/Exception
    //   491	495	535	java/lang/Exception
    //   500	505	539	java/lang/Exception
    //   249	260	543	finally
    //   260	274	549	finally
    //   285	292	556	finally
    //   308	315	556	finally
    //   330	334	556	finally
    //   419	423	556	finally
    //   434	445	556	finally
    //   189	249	567	java/lang/Exception
    //   249	260	579	java/lang/Exception
    //   260	274	588	java/lang/Exception
    //   62	70	594	java/lang/Exception
    //   72	82	594	java/lang/Exception
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt != 200) && (paramInt != 220) && (paramInt != 221)) {
      TbsLog.i("TbsDownload", "error occured in installation, errorCode:" + paramInt, true);
    }
    h(paramInt);
    a(System.currentTimeMillis());
    e(paramString);
    QbSdk.j.onInstallFinish(paramInt);
    a(EventType.TYPE_INSTALL);
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    a(paramThrowable);
    a(paramInt, this.r);
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void a(EventType paramEventType)
  {
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(i(paramEventType.a));
    localStringBuilder.append(f(b.c(this.c)));
    localStringBuilder.append(f(v.a(this.c)));
    localStringBuilder.append(i(ai.a().e(this.c)));
    paramEventType = Build.MODEL;
    try
    {
      localObject = new String(paramEventType.getBytes("UTF-8"), "ISO8859-1");
      paramEventType = (EventType)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        continue;
        localStringBuilder.append(i(b.b(this.c)));
      }
    }
    localStringBuilder.append(f(paramEventType));
    paramEventType = this.c.getPackageName();
    localStringBuilder.append(f(paramEventType));
    if ("com.tencent.mm".equals(paramEventType))
    {
      localStringBuilder.append(f(b.a(this.c, "com.tencent.mm.BuildInfo.CLIENT_VERSION")));
      localStringBuilder.append(f(e(this.d)));
      localStringBuilder.append(f(this.e));
      localStringBuilder.append(f(this.f));
      localStringBuilder.append(i(this.g));
      localStringBuilder.append(i(this.h));
      localStringBuilder.append(i(this.i));
      localStringBuilder.append(i(this.j));
      localStringBuilder.append(f(this.k));
      localStringBuilder.append(i(this.l));
      localStringBuilder.append(i(this.m));
      localStringBuilder.append(f(this.s));
      localStringBuilder.append(f(this.n));
      localStringBuilder.append(f(this.o));
      localStringBuilder.append(i(this.p));
      localStringBuilder.append(i(this.a));
      localStringBuilder.append(f(this.q));
      localStringBuilder.append(f(this.r));
      localStringBuilder.append(i(TbsDownloadConfig.getInstance(this.c).mPreferences.getInt("tbs_download_version", 0)));
      localStringBuilder.append(f(b.f(this.c)));
      localStringBuilder.append(f("3.0.0.1038_43000"));
      localStringBuilder.append(false);
      localObject = h();
      paramEventType = f();
      paramEventType.put(localStringBuilder.toString());
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("tbs_download_upload", paramEventType.toString());
      ((SharedPreferences.Editor)localObject).commit();
      e();
      new Thread(new ap(this)).start();
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (this.e == null)
    {
      this.e = paramString;
      return;
    }
    this.e = (this.e + ";" + paramString);
  }
  
  public void a(Throwable paramThrowable)
  {
    if (paramThrowable == null)
    {
      this.r = "";
      return;
    }
    String str = Log.getStackTraceString(paramThrowable);
    paramThrowable = str;
    if (str.length() > 1024) {
      paramThrowable = str.substring(0, 1024);
    }
    this.r = paramThrowable;
  }
  
  public void b()
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] Run in UIThread, Report delay");
      return;
    }
    try
    {
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat]");
      JSONArray localJSONArray = f();
      if ((localJSONArray == null) || (localJSONArray.length() == 0))
      {
        TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] no data");
        return;
      }
    }
    finally {}
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + localObject);
    try
    {
      String str = m.a(w.a(this.c).c(), ((JSONArray)localObject).toString().getBytes("utf-8"), new ar(this), true);
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] response:" + str + " testcase: " + -1);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void b(int paramInt, String paramString)
  {
    h(paramInt);
    a(System.currentTimeMillis());
    e(paramString);
    a(EventType.TYPE_LOAD);
  }
  
  public void b(int paramInt, Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      String str = "msg: " + paramThrowable.getMessage() + "; err: " + paramThrowable + "; cause: " + Log.getStackTraceString(paramThrowable.getCause());
      paramThrowable = str;
      if (str.length() > 1024) {
        paramThrowable = str.substring(0, 1024);
      }
    }
    for (this.r = paramThrowable;; this.r = "NULL")
    {
      b(paramInt, this.r);
      return;
    }
  }
  
  public void b(long paramLong)
  {
    this.n = paramLong;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public int c()
  {
    return this.m;
  }
  
  public void c(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.o += paramLong;
  }
  
  public void c(String paramString)
  {
    this.k = paramString;
  }
  
  public void d()
  {
    try
    {
      e();
      SharedPreferences.Editor localEditor = h().edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void d(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void d(long paramLong)
  {
    this.s += paramLong;
  }
  
  public void d(String paramString)
  {
    h(108);
    this.q = paramString;
  }
  
  public void e(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void e(String paramString)
  {
    if (paramString == null) {
      return;
    }
    String str = paramString;
    if (paramString.length() > 1024) {
      str = paramString.substring(0, 1024);
    }
    this.r = str;
  }
  
  public void f(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void g(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void h(int paramInt)
  {
    if ((paramInt != 100) && (paramInt != 110) && (paramInt != 120) && (paramInt != 111) && (paramInt < 400)) {
      TbsLog.i("TbsDownload", "error occured, errorCode:" + paramInt, true);
    }
    if (paramInt == 111) {
      TbsLog.i("TbsDownload", "you are not in wifi, downloading stoped", true);
    }
    this.a = paramInt;
  }
  
  public static enum EventType
  {
    int a;
    
    private EventType(int paramInt)
    {
      this.a = paramInt;
    }
  }
  
  public static class ZipHelper
  {
    private final String a;
    private final String b;
    
    public ZipHelper(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
    
    /* Error */
    private static void a(java.io.File paramFile)
    {
      // Byte code:
      //   0: new 27	java/io/RandomAccessFile
      //   3: dup
      //   4: aload_0
      //   5: ldc 29
      //   7: invokespecial 32	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   10: astore_3
      //   11: aload_3
      //   12: ifnull +58 -> 70
      //   15: aload_3
      //   16: astore_0
      //   17: ldc 34
      //   19: iconst_2
      //   20: invokestatic 40	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
      //   23: istore_1
      //   24: aload_3
      //   25: astore_0
      //   26: aload_3
      //   27: ldc2_w 41
      //   30: invokevirtual 46	java/io/RandomAccessFile:seek	(J)V
      //   33: aload_3
      //   34: astore_0
      //   35: aload_3
      //   36: invokevirtual 50	java/io/RandomAccessFile:read	()I
      //   39: istore_2
      //   40: iload_2
      //   41: iload_1
      //   42: iand
      //   43: ifle +27 -> 70
      //   46: aload_3
      //   47: astore_0
      //   48: aload_3
      //   49: ldc2_w 41
      //   52: invokevirtual 46	java/io/RandomAccessFile:seek	(J)V
      //   55: aload_3
      //   56: astore_0
      //   57: aload_3
      //   58: iload_1
      //   59: iconst_m1
      //   60: ixor
      //   61: sipush 255
      //   64: iand
      //   65: iload_2
      //   66: iand
      //   67: invokevirtual 54	java/io/RandomAccessFile:write	(I)V
      //   70: aload_3
      //   71: ifnull +7 -> 78
      //   74: aload_3
      //   75: invokevirtual 57	java/io/RandomAccessFile:close	()V
      //   78: return
      //   79: astore_0
      //   80: aload_0
      //   81: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   84: return
      //   85: astore 4
      //   87: aconst_null
      //   88: astore_3
      //   89: aload_3
      //   90: astore_0
      //   91: aload 4
      //   93: invokevirtual 61	java/lang/Exception:printStackTrace	()V
      //   96: aload_3
      //   97: ifnull -19 -> 78
      //   100: aload_3
      //   101: invokevirtual 57	java/io/RandomAccessFile:close	()V
      //   104: return
      //   105: astore_0
      //   106: aload_0
      //   107: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   110: return
      //   111: astore_3
      //   112: aconst_null
      //   113: astore_0
      //   114: aload_0
      //   115: ifnull +7 -> 122
      //   118: aload_0
      //   119: invokevirtual 57	java/io/RandomAccessFile:close	()V
      //   122: aload_3
      //   123: athrow
      //   124: astore_0
      //   125: aload_0
      //   126: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   129: goto -7 -> 122
      //   132: astore_3
      //   133: goto -19 -> 114
      //   136: astore 4
      //   138: goto -49 -> 89
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	141	0	paramFile	java.io.File
      //   23	38	1	i	int
      //   39	28	2	j	int
      //   10	91	3	localRandomAccessFile	java.io.RandomAccessFile
      //   111	12	3	localObject1	Object
      //   132	1	3	localObject2	Object
      //   85	7	4	localException1	Exception
      //   136	1	4	localException2	Exception
      // Exception table:
      //   from	to	target	type
      //   74	78	79	java/io/IOException
      //   0	11	85	java/lang/Exception
      //   100	104	105	java/io/IOException
      //   0	11	111	finally
      //   118	122	124	java/io/IOException
      //   17	24	132	finally
      //   26	33	132	finally
      //   35	40	132	finally
      //   48	55	132	finally
      //   57	70	132	finally
      //   91	96	132	finally
      //   17	24	136	java/lang/Exception
      //   26	33	136	java/lang/Exception
      //   35	40	136	java/lang/Exception
      //   48	55	136	java/lang/Exception
      //   57	70	136	java/lang/Exception
    }
    
    /* Error */
    public void Zip()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aconst_null
      //   4: astore_2
      //   5: new 64	java/io/FileOutputStream
      //   8: dup
      //   9: aload_0
      //   10: getfield 19	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:b	Ljava/lang/String;
      //   13: invokespecial 67	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   16: astore 4
      //   18: new 69	java/util/zip/ZipOutputStream
      //   21: dup
      //   22: new 71	java/io/BufferedOutputStream
      //   25: dup
      //   26: aload 4
      //   28: invokespecial 74	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   31: invokespecial 75	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   34: astore 6
      //   36: sipush 2048
      //   39: newarray <illegal type>
      //   41: astore 7
      //   43: aload_0
      //   44: getfield 17	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:a	Ljava/lang/String;
      //   47: astore 8
      //   49: new 77	java/io/FileInputStream
      //   52: dup
      //   53: aload 8
      //   55: invokespecial 78	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
      //   58: astore 5
      //   60: new 80	java/io/BufferedInputStream
      //   63: dup
      //   64: aload 5
      //   66: sipush 2048
      //   69: invokespecial 83	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
      //   72: astore_3
      //   73: aload 6
      //   75: new 85	java/util/zip/ZipEntry
      //   78: dup
      //   79: aload 8
      //   81: aload 8
      //   83: ldc 87
      //   85: invokevirtual 93	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
      //   88: iconst_1
      //   89: iadd
      //   90: invokevirtual 97	java/lang/String:substring	(I)Ljava/lang/String;
      //   93: invokespecial 98	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
      //   96: invokevirtual 102	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
      //   99: aload_3
      //   100: aload 7
      //   102: iconst_0
      //   103: sipush 2048
      //   106: invokevirtual 105	java/io/BufferedInputStream:read	([BII)I
      //   109: istore_1
      //   110: iload_1
      //   111: iconst_m1
      //   112: if_icmpeq +80 -> 192
      //   115: aload 6
      //   117: aload 7
      //   119: iconst_0
      //   120: iload_1
      //   121: invokevirtual 108	java/util/zip/ZipOutputStream:write	([BII)V
      //   124: goto -25 -> 99
      //   127: astore 7
      //   129: aload 5
      //   131: astore_2
      //   132: aload 7
      //   134: astore 5
      //   136: aload 5
      //   138: invokevirtual 61	java/lang/Exception:printStackTrace	()V
      //   141: aload_3
      //   142: ifnull +7 -> 149
      //   145: aload_3
      //   146: invokevirtual 109	java/io/BufferedInputStream:close	()V
      //   149: aload_2
      //   150: ifnull +7 -> 157
      //   153: aload_2
      //   154: invokevirtual 110	java/io/FileInputStream:close	()V
      //   157: new 112	java/io/File
      //   160: dup
      //   161: aload_0
      //   162: getfield 19	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:b	Ljava/lang/String;
      //   165: invokespecial 113	java/io/File:<init>	(Ljava/lang/String;)V
      //   168: invokestatic 115	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:a	(Ljava/io/File;)V
      //   171: aload 6
      //   173: ifnull +8 -> 181
      //   176: aload 6
      //   178: invokevirtual 116	java/util/zip/ZipOutputStream:close	()V
      //   181: aload 4
      //   183: ifnull +8 -> 191
      //   186: aload 4
      //   188: invokevirtual 117	java/io/FileOutputStream:close	()V
      //   191: return
      //   192: aload 6
      //   194: invokevirtual 120	java/util/zip/ZipOutputStream:flush	()V
      //   197: aload 6
      //   199: invokevirtual 123	java/util/zip/ZipOutputStream:closeEntry	()V
      //   202: aload_3
      //   203: ifnull +7 -> 210
      //   206: aload_3
      //   207: invokevirtual 109	java/io/BufferedInputStream:close	()V
      //   210: aload 5
      //   212: ifnull -55 -> 157
      //   215: aload 5
      //   217: invokevirtual 110	java/io/FileInputStream:close	()V
      //   220: goto -63 -> 157
      //   223: astore_2
      //   224: aload_2
      //   225: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   228: goto -71 -> 157
      //   231: astore_3
      //   232: aload 4
      //   234: astore_2
      //   235: aload 6
      //   237: astore 4
      //   239: aload_3
      //   240: invokevirtual 61	java/lang/Exception:printStackTrace	()V
      //   243: aload 4
      //   245: ifnull +8 -> 253
      //   248: aload 4
      //   250: invokevirtual 116	java/util/zip/ZipOutputStream:close	()V
      //   253: aload_2
      //   254: ifnull -63 -> 191
      //   257: aload_2
      //   258: invokevirtual 117	java/io/FileOutputStream:close	()V
      //   261: return
      //   262: astore_2
      //   263: aload_2
      //   264: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   267: return
      //   268: astore_2
      //   269: aload_2
      //   270: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   273: goto -63 -> 210
      //   276: astore_2
      //   277: aload 6
      //   279: astore_3
      //   280: aload_3
      //   281: ifnull +7 -> 288
      //   284: aload_3
      //   285: invokevirtual 116	java/util/zip/ZipOutputStream:close	()V
      //   288: aload 4
      //   290: ifnull +8 -> 298
      //   293: aload 4
      //   295: invokevirtual 117	java/io/FileOutputStream:close	()V
      //   298: aload_2
      //   299: athrow
      //   300: astore_3
      //   301: aload_3
      //   302: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   305: goto -156 -> 149
      //   308: astore_2
      //   309: aload_2
      //   310: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   313: goto -156 -> 157
      //   316: astore_2
      //   317: aconst_null
      //   318: astore_3
      //   319: aconst_null
      //   320: astore 5
      //   322: aload_3
      //   323: ifnull +7 -> 330
      //   326: aload_3
      //   327: invokevirtual 109	java/io/BufferedInputStream:close	()V
      //   330: aload 5
      //   332: ifnull +8 -> 340
      //   335: aload 5
      //   337: invokevirtual 110	java/io/FileInputStream:close	()V
      //   340: aload_2
      //   341: athrow
      //   342: astore_3
      //   343: aload_3
      //   344: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   347: goto -17 -> 330
      //   350: astore_3
      //   351: aload_3
      //   352: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   355: goto -15 -> 340
      //   358: astore_2
      //   359: aload_2
      //   360: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   363: goto -182 -> 181
      //   366: astore_2
      //   367: aload_2
      //   368: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   371: return
      //   372: astore_3
      //   373: aload_3
      //   374: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   377: goto -124 -> 253
      //   380: astore_3
      //   381: aload_3
      //   382: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   385: goto -97 -> 288
      //   388: astore_3
      //   389: aload_3
      //   390: invokevirtual 60	java/io/IOException:printStackTrace	()V
      //   393: goto -95 -> 298
      //   396: astore_2
      //   397: aconst_null
      //   398: astore_3
      //   399: aconst_null
      //   400: astore 4
      //   402: goto -122 -> 280
      //   405: astore_2
      //   406: aconst_null
      //   407: astore_3
      //   408: goto -128 -> 280
      //   411: astore 5
      //   413: aload 4
      //   415: astore_3
      //   416: aload_2
      //   417: astore 4
      //   419: aload 5
      //   421: astore_2
      //   422: goto -142 -> 280
      //   425: astore_3
      //   426: aconst_null
      //   427: astore_2
      //   428: aload 5
      //   430: astore 4
      //   432: goto -193 -> 239
      //   435: astore_3
      //   436: aload 4
      //   438: astore_2
      //   439: aload 5
      //   441: astore 4
      //   443: goto -204 -> 239
      //   446: astore_2
      //   447: aconst_null
      //   448: astore_3
      //   449: goto -127 -> 322
      //   452: astore_2
      //   453: goto -131 -> 322
      //   456: astore 7
      //   458: aload_2
      //   459: astore 5
      //   461: aload 7
      //   463: astore_2
      //   464: goto -142 -> 322
      //   467: astore 5
      //   469: aconst_null
      //   470: astore_3
      //   471: goto -335 -> 136
      //   474: astore 7
      //   476: aconst_null
      //   477: astore_3
      //   478: aload 5
      //   480: astore_2
      //   481: aload 7
      //   483: astore 5
      //   485: goto -349 -> 136
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	488	0	this	ZipHelper
      //   109	12	1	i	int
      //   4	150	2	localObject1	Object
      //   223	2	2	localIOException1	java.io.IOException
      //   234	24	2	localObject2	Object
      //   262	2	2	localIOException2	java.io.IOException
      //   268	2	2	localIOException3	java.io.IOException
      //   276	23	2	localObject3	Object
      //   308	2	2	localIOException4	java.io.IOException
      //   316	25	2	localObject4	Object
      //   358	2	2	localIOException5	java.io.IOException
      //   366	2	2	localIOException6	java.io.IOException
      //   396	1	2	localObject5	Object
      //   405	12	2	localObject6	Object
      //   421	18	2	localObject7	Object
      //   446	1	2	localObject8	Object
      //   452	7	2	localObject9	Object
      //   463	18	2	localObject10	Object
      //   72	135	3	localBufferedInputStream	java.io.BufferedInputStream
      //   231	9	3	localException1	Exception
      //   279	6	3	localZipOutputStream1	java.util.zip.ZipOutputStream
      //   300	2	3	localIOException7	java.io.IOException
      //   318	9	3	localObject11	Object
      //   342	2	3	localIOException8	java.io.IOException
      //   350	2	3	localIOException9	java.io.IOException
      //   372	2	3	localIOException10	java.io.IOException
      //   380	2	3	localIOException11	java.io.IOException
      //   388	2	3	localIOException12	java.io.IOException
      //   398	18	3	localObject12	Object
      //   425	1	3	localException2	Exception
      //   435	1	3	localException3	Exception
      //   448	30	3	localObject13	Object
      //   16	426	4	localObject14	Object
      //   1	335	5	localObject15	Object
      //   411	29	5	localObject16	Object
      //   459	1	5	localObject17	Object
      //   467	12	5	localException4	Exception
      //   483	1	5	localObject18	Object
      //   34	244	6	localZipOutputStream2	java.util.zip.ZipOutputStream
      //   41	77	7	arrayOfByte	byte[]
      //   127	6	7	localException5	Exception
      //   456	6	7	localObject19	Object
      //   474	8	7	localException6	Exception
      //   47	35	8	str	String
      // Exception table:
      //   from	to	target	type
      //   73	99	127	java/lang/Exception
      //   99	110	127	java/lang/Exception
      //   115	124	127	java/lang/Exception
      //   192	202	127	java/lang/Exception
      //   215	220	223	java/io/IOException
      //   36	49	231	java/lang/Exception
      //   145	149	231	java/lang/Exception
      //   153	157	231	java/lang/Exception
      //   157	171	231	java/lang/Exception
      //   206	210	231	java/lang/Exception
      //   215	220	231	java/lang/Exception
      //   224	228	231	java/lang/Exception
      //   269	273	231	java/lang/Exception
      //   301	305	231	java/lang/Exception
      //   309	313	231	java/lang/Exception
      //   326	330	231	java/lang/Exception
      //   335	340	231	java/lang/Exception
      //   340	342	231	java/lang/Exception
      //   343	347	231	java/lang/Exception
      //   351	355	231	java/lang/Exception
      //   257	261	262	java/io/IOException
      //   206	210	268	java/io/IOException
      //   36	49	276	finally
      //   145	149	276	finally
      //   153	157	276	finally
      //   157	171	276	finally
      //   206	210	276	finally
      //   215	220	276	finally
      //   224	228	276	finally
      //   269	273	276	finally
      //   301	305	276	finally
      //   309	313	276	finally
      //   326	330	276	finally
      //   335	340	276	finally
      //   340	342	276	finally
      //   343	347	276	finally
      //   351	355	276	finally
      //   145	149	300	java/io/IOException
      //   153	157	308	java/io/IOException
      //   49	60	316	finally
      //   326	330	342	java/io/IOException
      //   335	340	350	java/io/IOException
      //   176	181	358	java/io/IOException
      //   186	191	366	java/io/IOException
      //   248	253	372	java/io/IOException
      //   284	288	380	java/io/IOException
      //   293	298	388	java/io/IOException
      //   5	18	396	finally
      //   18	36	405	finally
      //   239	243	411	finally
      //   5	18	425	java/lang/Exception
      //   18	36	435	java/lang/Exception
      //   60	73	446	finally
      //   73	99	452	finally
      //   99	110	452	finally
      //   115	124	452	finally
      //   192	202	452	finally
      //   136	141	456	finally
      //   49	60	467	java/lang/Exception
      //   60	73	474	java/lang/Exception
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/TbsLogReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */