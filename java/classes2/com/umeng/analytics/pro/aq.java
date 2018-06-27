package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.AnalyticsConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class aq
  implements au, az
{
  private static Context j;
  private static final String q = "thtstart";
  private static final String r = "gkvc";
  private static final String s = "ekvc";
  String a = null;
  private cc b = null;
  private be c = null;
  private bh d = null;
  private bg e = null;
  private bi f = null;
  private a g = null;
  private af.a h = null;
  private long i = 0L;
  private int k = 10;
  private JSONArray l = new JSONArray();
  private final int m = 5000;
  private int n = 0;
  private int o = 0;
  private long p = 0L;
  private final long t = 28800000L;
  
  public aq(Context paramContext)
  {
    j = paramContext;
    this.c = new be(paramContext);
    this.b = cc.a(paramContext);
    this.h = af.a(paramContext).b();
    this.g = new a();
    this.e = bg.a(j);
    this.d = bh.a(j);
    this.f = bi.a(j, this.c);
    paramContext = ba.a(j);
    this.p = paramContext.getLong("thtstart", 0L);
    this.n = paramContext.getInt("gkvc", 0);
    this.o = paramContext.getInt("ekvc", 0);
    this.a = af.a(j).b().b(null);
  }
  
  private void a(int paramInt)
  {
    c(a(new int[] { paramInt, (int)(System.currentTimeMillis() - this.c.m()) }));
    bz.a(new cb()
    {
      public void a()
      {
        aq.this.a();
      }
    }, paramInt);
  }
  
  private void a(JSONObject paramJSONObject, String paramString1, String paramString2)
    throws JSONException
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "0";
    }
    paramJSONObject.put("$pr_ve", str);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
    }
    paramJSONObject.put("$ud_da", paramString1);
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!bv.l(j))
    {
      by.e("network is unavailable");
      return false;
    }
    if (this.c.f()) {
      return true;
    }
    return this.g.b(paramBoolean).a(paramBoolean);
  }
  
  private String[] a(SharedPreferences.Editor paramEditor, SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
  {
    paramString2 = paramSharedPreferences.getString("pre_version", "");
    paramString1 = paramSharedPreferences.getString("pre_date", "");
    paramSharedPreferences = paramSharedPreferences.getString("cur_version", "");
    String str = bv.b(j);
    if (!paramSharedPreferences.equals(str))
    {
      paramString1 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
      paramEditor.putString("pre_version", paramSharedPreferences);
      paramEditor.putString("pre_date", paramString1);
      paramEditor.putString("cur_version", str);
      paramEditor.commit();
    }
    for (paramEditor = paramString1;; paramEditor = paramString1)
    {
      return new String[] { paramSharedPreferences, paramEditor };
      paramSharedPreferences = paramString2;
    }
  }
  
  private void b(int paramInt)
  {
    a(paramInt);
  }
  
  private void b(JSONObject paramJSONObject)
  {
    try
    {
      if (2050 == paramJSONObject.getInt("__t"))
      {
        if (!c(this.n)) {
          return;
        }
        this.n += 1;
      }
      for (;;)
      {
        if (this.l.length() > this.k)
        {
          w.a(j).a(this.l);
          this.l = new JSONArray();
        }
        if (this.p == 0L) {
          this.p = System.currentTimeMillis();
        }
        this.l.put(paramJSONObject);
        return;
        if (2049 == paramJSONObject.getInt("__t"))
        {
          if (!c(this.o)) {
            break;
          }
          this.o += 1;
        }
      }
      return;
    }
    catch (Throwable paramJSONObject) {}
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      try
      {
        ad localad = ad.a(j);
        localad.a();
        try
        {
          Object localObject = localad.b();
          localObject = Base64.encodeToString(new cp().a((cg)localObject), 0);
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject("header");
            localJSONObject.put("id_tracking", localObject);
            paramJSONObject.put("header", localJSONObject);
          }
          paramJSONObject = String.valueOf(paramJSONObject).getBytes();
          if ((paramJSONObject == null) || (bt.a(j, paramJSONObject))) {
            continue;
          }
          if (e()) {}
          for (paramJSONObject = aa.b(j, AnalyticsConfig.getAppkey(j), paramJSONObject);; paramJSONObject = aa.a(j, AnalyticsConfig.getAppkey(j), paramJSONObject))
          {
            paramJSONObject = paramJSONObject.c();
            localObject = cc.a(j);
            ((cc)localObject).g();
            ((cc)localObject).a(paramJSONObject);
            localad.d();
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;) {}
        }
        return;
      }
      catch (Exception paramJSONObject) {}
    }
  }
  
  private boolean c(int paramInt)
  {
    if (this.p != 0L)
    {
      if (System.currentTimeMillis() - this.p <= 28800000L) {
        break label30;
      }
      f();
    }
    label30:
    while (paramInt <= 5000) {
      return true;
    }
    return false;
  }
  
  private void d()
  {
    try
    {
      if (this.b.h())
      {
        localObject = new bc(j, this.c);
        ((bc)localObject).a(this);
        if (this.d.d()) {
          ((bc)localObject).b(true);
        }
        ((bc)localObject).a();
        return;
      }
      Object localObject = a(new int[0]);
      if (((JSONObject)localObject).length() > 0)
      {
        bc localbc = new bc(j, this.c);
        localbc.a(this);
        if (this.d.d()) {
          localbc.b(true);
        }
        localbc.a((JSONObject)localObject);
        localbc.a(e());
        localbc.a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (localThrowable != null) {
        localThrowable.printStackTrace();
      }
    }
  }
  
  private void d(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put(bg.a(j).f(), bg.a(j).e());
    paramJSONObject.put("group_info", localJSONObject);
  }
  
  private boolean e()
  {
    switch (this.h.c(-1))
    {
    case 0: 
    default: 
      return false;
    case 1: 
      return true;
    }
    return AnalyticsConfig.sEncrypt;
  }
  
  private void f()
  {
    this.n = 0;
    this.o = 0;
    this.p = System.currentTimeMillis();
  }
  
  /* Error */
  protected JSONObject a(int... paramVarArgs)
  {
    // Byte code:
    //   0: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   3: invokestatic 355	com/umeng/analytics/AnalyticsConfig:getAppkey	(Landroid/content/Context;)Ljava/lang/String;
    //   6: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +11 -> 20
    //   12: ldc_w 416
    //   15: invokestatic 232	com/umeng/analytics/pro/by:e	(Ljava/lang/String;)V
    //   18: aconst_null
    //   19: areturn
    //   20: aload_0
    //   21: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   24: invokevirtual 418	com/umeng/analytics/pro/aq:a	(Landroid/content/Context;)V
    //   27: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   30: invokestatic 295	com/umeng/analytics/pro/w:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/w;
    //   33: invokevirtual 421	com/umeng/analytics/pro/w:a	()Lorg/json/JSONObject;
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: ifnonnull +11 -> 51
    //   43: new 190	org/json/JSONObject
    //   46: dup
    //   47: invokespecial 399	org/json/JSONObject:<init>	()V
    //   50: astore_2
    //   51: aload_2
    //   52: ldc_w 423
    //   55: invokevirtual 333	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   58: astore 4
    //   60: new 190	org/json/JSONObject
    //   63: dup
    //   64: aload 4
    //   66: invokevirtual 426	org/json/JSONObject:toString	()Ljava/lang/String;
    //   69: invokespecial 428	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   72: astore 5
    //   74: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   77: invokestatic 134	com/umeng/analytics/pro/ba:a	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   80: astore_3
    //   81: aload_3
    //   82: ifnull +35 -> 117
    //   85: aload_3
    //   86: ldc_w 430
    //   89: ldc -9
    //   91: invokeinterface 251 3 0
    //   96: astore 6
    //   98: aload 6
    //   100: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifne +14 -> 117
    //   106: aload 4
    //   108: ldc_w 430
    //   111: aload 6
    //   113: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   116: pop
    //   117: aload_0
    //   118: getfield 59	com/umeng/analytics/pro/aq:c	Lcom/umeng/analytics/pro/be;
    //   121: invokevirtual 235	com/umeng/analytics/pro/be:f	()Z
    //   124: ifeq +56 -> 180
    //   127: aload_0
    //   128: getfield 71	com/umeng/analytics/pro/aq:i	J
    //   131: lconst_0
    //   132: lcmp
    //   133: ifeq +47 -> 180
    //   136: new 190	org/json/JSONObject
    //   139: dup
    //   140: invokespecial 399	org/json/JSONObject:<init>	()V
    //   143: astore 6
    //   145: aload 6
    //   147: ldc_w 432
    //   150: aload_0
    //   151: getfield 71	com/umeng/analytics/pro/aq:i	J
    //   154: invokevirtual 435	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   157: pop
    //   158: aload 4
    //   160: ldc_w 437
    //   163: aload 6
    //   165: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   168: pop
    //   169: aload 5
    //   171: ldc_w 437
    //   174: aload 6
    //   176: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   179: pop
    //   180: new 190	org/json/JSONObject
    //   183: dup
    //   184: invokespecial 399	org/json/JSONObject:<init>	()V
    //   187: astore 6
    //   189: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   192: invokestatic 442	com/umeng/analytics/pro/m:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/m;
    //   195: invokevirtual 444	com/umeng/analytics/pro/m:b	()Lorg/json/JSONObject;
    //   198: astore 7
    //   200: aload 7
    //   202: ifnull +22 -> 224
    //   205: aload 7
    //   207: invokevirtual 391	org/json/JSONObject:length	()I
    //   210: ifle +14 -> 224
    //   213: aload 6
    //   215: ldc_w 446
    //   218: aload 7
    //   220: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   223: pop
    //   224: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   227: invokestatic 442	com/umeng/analytics/pro/m:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/m;
    //   230: invokevirtual 448	com/umeng/analytics/pro/m:c	()Lorg/json/JSONObject;
    //   233: astore 7
    //   235: aload 7
    //   237: ifnull +22 -> 259
    //   240: aload 7
    //   242: invokevirtual 391	org/json/JSONObject:length	()I
    //   245: ifle +14 -> 259
    //   248: aload 6
    //   250: ldc_w 450
    //   253: aload 7
    //   255: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   258: pop
    //   259: aload 6
    //   261: invokevirtual 391	org/json/JSONObject:length	()I
    //   264: ifle +25 -> 289
    //   267: aload 4
    //   269: ldc_w 452
    //   272: aload 6
    //   274: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   277: pop
    //   278: aload 5
    //   280: ldc_w 452
    //   283: aload 6
    //   285: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   288: pop
    //   289: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   292: invokestatic 457	com/umeng/analytics/c:a	(Landroid/content/Context;)[Ljava/lang/String;
    //   295: astore 6
    //   297: aload 6
    //   299: ifnull +88 -> 387
    //   302: aload 6
    //   304: iconst_0
    //   305: aaload
    //   306: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   309: ifne +78 -> 387
    //   312: aload 6
    //   314: iconst_1
    //   315: aaload
    //   316: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   319: ifne +68 -> 387
    //   322: new 190	org/json/JSONObject
    //   325: dup
    //   326: invokespecial 399	org/json/JSONObject:<init>	()V
    //   329: astore 7
    //   331: aload 7
    //   333: ldc_w 459
    //   336: aload 6
    //   338: iconst_0
    //   339: aaload
    //   340: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   343: pop
    //   344: aload 7
    //   346: ldc_w 461
    //   349: aload 6
    //   351: iconst_1
    //   352: aaload
    //   353: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   356: pop
    //   357: aload 7
    //   359: invokevirtual 391	org/json/JSONObject:length	()I
    //   362: ifle +25 -> 387
    //   365: aload 4
    //   367: ldc_w 463
    //   370: aload 7
    //   372: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   375: pop
    //   376: aload 5
    //   378: ldc_w 463
    //   381: aload 7
    //   383: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   386: pop
    //   387: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   390: invokestatic 119	com/umeng/analytics/pro/bg:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/bg;
    //   393: invokevirtual 465	com/umeng/analytics/pro/bg:a	()Z
    //   396: ifeq +9 -> 405
    //   399: aload_0
    //   400: aload 4
    //   402: invokespecial 467	com/umeng/analytics/pro/aq:d	(Lorg/json/JSONObject;)V
    //   405: aload_0
    //   406: getfield 61	com/umeng/analytics/pro/aq:d	Lcom/umeng/analytics/pro/bh;
    //   409: aload 4
    //   411: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   414: invokevirtual 470	com/umeng/analytics/pro/bh:a	(Lorg/json/JSONObject;Landroid/content/Context;)V
    //   417: aload_1
    //   418: ifnull +77 -> 495
    //   421: aload_1
    //   422: arraylength
    //   423: iconst_2
    //   424: if_icmpne +71 -> 495
    //   427: new 190	org/json/JSONObject
    //   430: dup
    //   431: invokespecial 399	org/json/JSONObject:<init>	()V
    //   434: astore 6
    //   436: new 190	org/json/JSONObject
    //   439: dup
    //   440: invokespecial 399	org/json/JSONObject:<init>	()V
    //   443: astore 7
    //   445: aload 7
    //   447: ldc_w 472
    //   450: aload_1
    //   451: iconst_0
    //   452: iaload
    //   453: sipush 1000
    //   456: idiv
    //   457: invokevirtual 475	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   460: pop
    //   461: aload 7
    //   463: ldc_w 477
    //   466: aload_1
    //   467: iconst_1
    //   468: iaload
    //   469: invokevirtual 475	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   472: pop
    //   473: aload 6
    //   475: ldc_w 479
    //   478: aload 7
    //   480: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   483: pop
    //   484: aload 4
    //   486: ldc_w 481
    //   489: aload 6
    //   491: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   494: pop
    //   495: aload 4
    //   497: invokevirtual 391	org/json/JSONObject:length	()I
    //   500: ifle +983 -> 1483
    //   503: aload_2
    //   504: ldc_w 423
    //   507: aload 4
    //   509: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   512: pop
    //   513: new 190	org/json/JSONObject
    //   516: dup
    //   517: invokespecial 399	org/json/JSONObject:<init>	()V
    //   520: astore 4
    //   522: aload 4
    //   524: ldc_w 483
    //   527: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   530: invokestatic 355	com/umeng/analytics/AnalyticsConfig:getAppkey	(Landroid/content/Context;)Ljava/lang/String;
    //   533: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   536: pop
    //   537: aload 4
    //   539: ldc_w 485
    //   542: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   545: invokestatic 488	com/umeng/analytics/AnalyticsConfig:getChannel	(Landroid/content/Context;)Ljava/lang/String;
    //   548: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   551: pop
    //   552: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   555: invokestatic 491	com/umeng/analytics/AnalyticsConfig:getSecretKey	(Landroid/content/Context;)Ljava/lang/String;
    //   558: invokestatic 495	com/umeng/analytics/pro/bw:a	(Ljava/lang/String;)Ljava/lang/String;
    //   561: astore_1
    //   562: aload_1
    //   563: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   566: ifne +13 -> 579
    //   569: aload 4
    //   571: ldc_w 497
    //   574: aload_1
    //   575: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   578: pop
    //   579: aload 4
    //   581: ldc_w 499
    //   584: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   587: invokestatic 502	com/umeng/analytics/pro/bv:w	(Landroid/content/Context;)Ljava/lang/String;
    //   590: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   593: pop
    //   594: aload 4
    //   596: ldc_w 504
    //   599: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   602: invokestatic 506	com/umeng/analytics/pro/bv:t	(Landroid/content/Context;)Ljava/lang/String;
    //   605: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   608: pop
    //   609: aload 4
    //   611: ldc_w 508
    //   614: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   617: invokestatic 511	com/umeng/analytics/pro/bv:u	(Landroid/content/Context;)Ljava/lang/String;
    //   620: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   623: pop
    //   624: aload_3
    //   625: astore_1
    //   626: aload_3
    //   627: ifnonnull +10 -> 637
    //   630: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   633: invokestatic 134	com/umeng/analytics/pro/ba:a	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   636: astore_1
    //   637: aload_1
    //   638: astore_3
    //   639: aload_1
    //   640: ifnull +64 -> 704
    //   643: aload_1
    //   644: astore_3
    //   645: aload_1
    //   646: ldc_w 513
    //   649: ldc -9
    //   651: invokeinterface 251 3 0
    //   656: astore 6
    //   658: aload_1
    //   659: astore_3
    //   660: aload 6
    //   662: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   665: ifne +833 -> 1498
    //   668: aload_1
    //   669: astore_3
    //   670: aload 4
    //   672: ldc_w 515
    //   675: aload 6
    //   677: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   680: pop
    //   681: aload_1
    //   682: astore_3
    //   683: aload 4
    //   685: ldc_w 517
    //   688: aload_1
    //   689: ldc_w 519
    //   692: iconst_0
    //   693: invokeinterface 144 3 0
    //   698: invokevirtual 475	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   701: pop
    //   702: aload_1
    //   703: astore_3
    //   704: getstatic 522	com/umeng/analytics/AnalyticsConfig:mWrapperType	Ljava/lang/String;
    //   707: ifnull +33 -> 740
    //   710: getstatic 525	com/umeng/analytics/AnalyticsConfig:mWrapperVersion	Ljava/lang/String;
    //   713: ifnull +27 -> 740
    //   716: aload 4
    //   718: ldc_w 527
    //   721: getstatic 522	com/umeng/analytics/AnalyticsConfig:mWrapperType	Ljava/lang/String;
    //   724: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   727: pop
    //   728: aload 4
    //   730: ldc_w 529
    //   733: getstatic 525	com/umeng/analytics/AnalyticsConfig:mWrapperVersion	Ljava/lang/String;
    //   736: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   739: pop
    //   740: aload 4
    //   742: ldc_w 531
    //   745: ldc_w 533
    //   748: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   751: pop
    //   752: aload 4
    //   754: ldc_w 535
    //   757: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   760: invokestatic 538	com/umeng/analytics/AnalyticsConfig:getSDKVersion	(Landroid/content/Context;)Ljava/lang/String;
    //   763: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   766: pop
    //   767: aload 4
    //   769: ldc_w 540
    //   772: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   775: invokestatic 544	com/umeng/analytics/AnalyticsConfig:getVerticalType	(Landroid/content/Context;)I
    //   778: invokevirtual 475	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   781: pop
    //   782: aload 4
    //   784: ldc_w 546
    //   787: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   790: invokestatic 548	com/umeng/analytics/pro/bv:d	(Landroid/content/Context;)Ljava/lang/String;
    //   793: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   796: pop
    //   797: aload 4
    //   799: ldc_w 550
    //   802: invokestatic 552	com/umeng/analytics/pro/bv:a	()Ljava/lang/String;
    //   805: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   808: pop
    //   809: aload 4
    //   811: ldc_w 554
    //   814: ldc_w 533
    //   817: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   820: pop
    //   821: aload 4
    //   823: ldc_w 556
    //   826: getstatic 561	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   829: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   832: pop
    //   833: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   836: invokestatic 564	com/umeng/analytics/pro/bv:r	(Landroid/content/Context;)[I
    //   839: astore_1
    //   840: aload_1
    //   841: ifnull +40 -> 881
    //   844: aload 4
    //   846: ldc_w 566
    //   849: new 568	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 569	java/lang/StringBuilder:<init>	()V
    //   856: aload_1
    //   857: iconst_1
    //   858: iaload
    //   859: invokevirtual 573	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   862: ldc_w 575
    //   865: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: aload_1
    //   869: iconst_0
    //   870: iaload
    //   871: invokevirtual 573	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   874: invokevirtual 579	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   877: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   880: pop
    //   881: aload 4
    //   883: ldc_w 581
    //   886: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   889: invokestatic 583	com/umeng/analytics/pro/bv:q	(Landroid/content/Context;)Ljava/lang/String;
    //   892: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   895: pop
    //   896: aload 4
    //   898: ldc_w 585
    //   901: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   904: invokestatic 587	com/umeng/analytics/pro/bv:c	(Landroid/content/Context;)Ljava/lang/String;
    //   907: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   910: pop
    //   911: aload 4
    //   913: ldc_w 589
    //   916: getstatic 594	android/os/Build:MODEL	Ljava/lang/String;
    //   919: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   922: pop
    //   923: aload 4
    //   925: ldc_w 596
    //   928: getstatic 599	android/os/Build:BOARD	Ljava/lang/String;
    //   931: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   934: pop
    //   935: aload 4
    //   937: ldc_w 601
    //   940: getstatic 604	android/os/Build:BRAND	Ljava/lang/String;
    //   943: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   946: pop
    //   947: aload 4
    //   949: ldc_w 606
    //   952: getstatic 609	android/os/Build:TIME	J
    //   955: invokevirtual 435	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   958: pop
    //   959: aload 4
    //   961: ldc_w 611
    //   964: getstatic 614	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   967: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   970: pop
    //   971: aload 4
    //   973: ldc_w 616
    //   976: getstatic 619	android/os/Build:ID	Ljava/lang/String;
    //   979: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   982: pop
    //   983: aload 4
    //   985: ldc_w 621
    //   988: getstatic 624	android/os/Build:DEVICE	Ljava/lang/String;
    //   991: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   994: pop
    //   995: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   998: invokestatic 627	com/umeng/analytics/pro/bv:x	(Landroid/content/Context;)Ljava/lang/String;
    //   1001: astore_1
    //   1002: aload_1
    //   1003: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1006: ifne +13 -> 1019
    //   1009: aload 4
    //   1011: ldc_w 629
    //   1014: aload_1
    //   1015: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1018: pop
    //   1019: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   1022: invokestatic 632	com/umeng/analytics/pro/bv:y	(Landroid/content/Context;)Ljava/lang/String;
    //   1025: astore_1
    //   1026: aload_1
    //   1027: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1030: ifne +13 -> 1043
    //   1033: aload 4
    //   1035: ldc_w 634
    //   1038: aload_1
    //   1039: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1042: pop
    //   1043: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   1046: invokestatic 636	com/umeng/analytics/pro/bv:j	(Landroid/content/Context;)[Ljava/lang/String;
    //   1049: astore_1
    //   1050: ldc_w 638
    //   1053: aload_1
    //   1054: iconst_0
    //   1055: aaload
    //   1056: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1059: ifeq +530 -> 1589
    //   1062: aload 4
    //   1064: ldc_w 640
    //   1067: ldc_w 642
    //   1070: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1073: pop
    //   1074: ldc -9
    //   1076: aload_1
    //   1077: iconst_1
    //   1078: aaload
    //   1079: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1082: ifne +15 -> 1097
    //   1085: aload 4
    //   1087: ldc_w 644
    //   1090: aload_1
    //   1091: iconst_1
    //   1092: aaload
    //   1093: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1096: pop
    //   1097: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   1100: invokestatic 646	com/umeng/analytics/pro/bv:e	(Landroid/content/Context;)Ljava/lang/String;
    //   1103: astore_1
    //   1104: aload_1
    //   1105: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1108: ifne +523 -> 1631
    //   1111: aload 4
    //   1113: ldc_w 648
    //   1116: aload_1
    //   1117: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1120: pop
    //   1121: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   1124: invokestatic 650	com/umeng/analytics/pro/bv:o	(Landroid/content/Context;)[Ljava/lang/String;
    //   1127: astore_1
    //   1128: aload 4
    //   1130: ldc_w 652
    //   1133: aload_1
    //   1134: iconst_0
    //   1135: aaload
    //   1136: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1139: pop
    //   1140: aload 4
    //   1142: ldc_w 654
    //   1145: aload_1
    //   1146: iconst_1
    //   1147: aaload
    //   1148: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1151: pop
    //   1152: aload 4
    //   1154: ldc_w 656
    //   1157: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   1160: invokestatic 658	com/umeng/analytics/pro/bv:m	(Landroid/content/Context;)I
    //   1163: invokevirtual 475	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1166: pop
    //   1167: aload 4
    //   1169: ldc_w 660
    //   1172: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   1175: invokestatic 662	com/umeng/analytics/pro/bv:h	(Landroid/content/Context;)Ljava/lang/String;
    //   1178: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1181: pop
    //   1182: aload 4
    //   1184: ldc_w 664
    //   1187: aload_3
    //   1188: ldc_w 666
    //   1191: iconst_0
    //   1192: invokeinterface 144 3 0
    //   1197: invokevirtual 475	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1200: pop
    //   1201: aload 4
    //   1203: ldc_w 668
    //   1206: aload_3
    //   1207: ldc_w 668
    //   1210: iconst_0
    //   1211: invokeinterface 144 3 0
    //   1216: invokevirtual 475	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1219: pop
    //   1220: aload 4
    //   1222: ldc_w 670
    //   1225: aload_3
    //   1226: ldc_w 672
    //   1229: iconst_0
    //   1230: invokeinterface 144 3 0
    //   1235: invokevirtual 475	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1238: pop
    //   1239: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   1242: invokestatic 108	com/umeng/analytics/pro/af:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/af;
    //   1245: invokevirtual 675	com/umeng/analytics/pro/af:a	()Lcom/umeng/analytics/pro/bn;
    //   1248: astore_1
    //   1249: aload_1
    //   1250: ifnull +27 -> 1277
    //   1253: aload 4
    //   1255: ldc_w 677
    //   1258: new 317	com/umeng/analytics/pro/cp
    //   1261: dup
    //   1262: invokespecial 318	com/umeng/analytics/pro/cp:<init>	()V
    //   1265: aload_1
    //   1266: invokevirtual 321	com/umeng/analytics/pro/cp:a	(Lcom/umeng/analytics/pro/cg;)[B
    //   1269: iconst_0
    //   1270: invokestatic 327	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   1273: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1276: pop
    //   1277: aload_2
    //   1278: ldc_w 329
    //   1281: aload 4
    //   1283: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1286: pop
    //   1287: aload 5
    //   1289: ldc_w 535
    //   1292: aload 4
    //   1294: ldc_w 535
    //   1297: invokevirtual 679	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1300: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1303: ldc_w 585
    //   1306: aload 4
    //   1308: ldc_w 585
    //   1311: invokevirtual 679	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1314: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1317: ldc_w 589
    //   1320: aload 4
    //   1322: ldc_w 589
    //   1325: invokevirtual 679	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1328: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1331: ldc_w 681
    //   1334: aload 4
    //   1336: ldc_w 517
    //   1339: invokevirtual 679	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1342: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1345: ldc_w 483
    //   1348: aload 4
    //   1350: ldc_w 483
    //   1353: invokevirtual 679	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1356: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1359: ldc_w 485
    //   1362: aload 4
    //   1364: ldc_w 485
    //   1367: invokevirtual 679	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1370: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1373: pop
    //   1374: aload_0
    //   1375: aload 4
    //   1377: invokevirtual 684	com/umeng/analytics/pro/aq:a	(Lorg/json/JSONObject;)Z
    //   1380: ifne +5 -> 1385
    //   1383: aconst_null
    //   1384: astore_2
    //   1385: getstatic 686	com/umeng/analytics/pro/by:a	Z
    //   1388: ifeq +19 -> 1407
    //   1391: aload 5
    //   1393: invokevirtual 391	org/json/JSONObject:length	()I
    //   1396: ifle +11 -> 1407
    //   1399: aload 5
    //   1401: invokestatic 339	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1404: invokestatic 688	com/umeng/analytics/pro/by:b	(Ljava/lang/String;)V
    //   1407: aload_3
    //   1408: ifnull +245 -> 1653
    //   1411: aload_3
    //   1412: invokeinterface 692 1 0
    //   1417: astore_1
    //   1418: aload_1
    //   1419: ldc_w 513
    //   1422: invokeinterface 696 2 0
    //   1427: pop
    //   1428: aload_1
    //   1429: ldc_w 519
    //   1432: invokeinterface 696 2 0
    //   1437: pop
    //   1438: aload_1
    //   1439: ldc_w 698
    //   1442: invokeinterface 696 2 0
    //   1447: pop
    //   1448: aload_1
    //   1449: ldc_w 700
    //   1452: invokeinterface 696 2 0
    //   1457: pop
    //   1458: aload_1
    //   1459: invokeinterface 273 1 0
    //   1464: pop
    //   1465: aload_2
    //   1466: areturn
    //   1467: astore_1
    //   1468: aload_2
    //   1469: areturn
    //   1470: astore_3
    //   1471: new 190	org/json/JSONObject
    //   1474: dup
    //   1475: invokespecial 399	org/json/JSONObject:<init>	()V
    //   1478: astore 4
    //   1480: goto -1420 -> 60
    //   1483: aload_2
    //   1484: ldc_w 423
    //   1487: invokevirtual 703	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   1490: pop
    //   1491: goto -978 -> 513
    //   1494: astore_1
    //   1495: goto -982 -> 513
    //   1498: aload_1
    //   1499: astore_3
    //   1500: aload 4
    //   1502: ldc_w 515
    //   1505: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   1508: invokestatic 258	com/umeng/analytics/pro/bv:b	(Landroid/content/Context;)Ljava/lang/String;
    //   1511: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1514: pop
    //   1515: aload_1
    //   1516: astore_3
    //   1517: aload 4
    //   1519: ldc_w 517
    //   1522: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   1525: invokestatic 705	com/umeng/analytics/pro/bv:a	(Landroid/content/Context;)Ljava/lang/String;
    //   1528: invokestatic 710	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1531: invokevirtual 475	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1534: pop
    //   1535: aload_1
    //   1536: astore_3
    //   1537: goto -833 -> 704
    //   1540: astore_1
    //   1541: aload 4
    //   1543: ldc_w 515
    //   1546: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   1549: invokestatic 258	com/umeng/analytics/pro/bv:b	(Landroid/content/Context;)Ljava/lang/String;
    //   1552: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1555: pop
    //   1556: aload 4
    //   1558: ldc_w 517
    //   1561: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   1564: invokestatic 705	com/umeng/analytics/pro/bv:a	(Landroid/content/Context;)Ljava/lang/String;
    //   1567: invokestatic 710	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1570: invokevirtual 475	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1573: pop
    //   1574: goto -870 -> 704
    //   1577: astore_1
    //   1578: getstatic 94	com/umeng/analytics/pro/aq:j	Landroid/content/Context;
    //   1581: invokestatic 103	com/umeng/analytics/pro/cc:a	(Landroid/content/Context;)Lcom/umeng/analytics/pro/cc;
    //   1584: invokevirtual 364	com/umeng/analytics/pro/cc:g	()V
    //   1587: aconst_null
    //   1588: areturn
    //   1589: ldc_w 712
    //   1592: aload_1
    //   1593: iconst_0
    //   1594: aaload
    //   1595: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1598: ifeq +18 -> 1616
    //   1601: aload 4
    //   1603: ldc_w 640
    //   1606: ldc_w 712
    //   1609: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1612: pop
    //   1613: goto -539 -> 1074
    //   1616: aload 4
    //   1618: ldc_w 640
    //   1621: ldc_w 714
    //   1624: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1627: pop
    //   1628: goto -554 -> 1074
    //   1631: aload 4
    //   1633: ldc_w 648
    //   1636: ldc -9
    //   1638: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1641: pop
    //   1642: goto -521 -> 1121
    //   1645: astore_1
    //   1646: goto -369 -> 1277
    //   1649: astore_1
    //   1650: goto -411 -> 1239
    //   1653: aload_2
    //   1654: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1655	0	this	aq
    //   0	1655	1	paramVarArgs	int[]
    //   38	1616	2	localObject1	Object
    //   36	1376	3	localObject2	Object
    //   1470	1	3	localThrowable	Throwable
    //   1499	38	3	arrayOfInt	int[]
    //   58	1574	4	localJSONObject1	JSONObject
    //   72	1328	5	localJSONObject2	JSONObject
    //   96	580	6	localObject3	Object
    //   198	281	7	localJSONObject3	JSONObject
    // Exception table:
    //   from	to	target	type
    //   1411	1465	1467	java/lang/Throwable
    //   51	60	1470	java/lang/Throwable
    //   1483	1491	1494	java/lang/Throwable
    //   630	637	1540	java/lang/Throwable
    //   645	658	1540	java/lang/Throwable
    //   660	668	1540	java/lang/Throwable
    //   670	681	1540	java/lang/Throwable
    //   683	702	1540	java/lang/Throwable
    //   1500	1515	1540	java/lang/Throwable
    //   1517	1535	1540	java/lang/Throwable
    //   0	18	1577	java/lang/Throwable
    //   20	37	1577	java/lang/Throwable
    //   43	51	1577	java/lang/Throwable
    //   60	81	1577	java/lang/Throwable
    //   85	117	1577	java/lang/Throwable
    //   117	180	1577	java/lang/Throwable
    //   180	200	1577	java/lang/Throwable
    //   205	224	1577	java/lang/Throwable
    //   224	235	1577	java/lang/Throwable
    //   240	259	1577	java/lang/Throwable
    //   259	289	1577	java/lang/Throwable
    //   289	297	1577	java/lang/Throwable
    //   302	387	1577	java/lang/Throwable
    //   387	405	1577	java/lang/Throwable
    //   405	417	1577	java/lang/Throwable
    //   421	495	1577	java/lang/Throwable
    //   495	513	1577	java/lang/Throwable
    //   513	579	1577	java/lang/Throwable
    //   579	624	1577	java/lang/Throwable
    //   704	740	1577	java/lang/Throwable
    //   740	840	1577	java/lang/Throwable
    //   844	881	1577	java/lang/Throwable
    //   881	1019	1577	java/lang/Throwable
    //   1019	1043	1577	java/lang/Throwable
    //   1043	1074	1577	java/lang/Throwable
    //   1074	1097	1577	java/lang/Throwable
    //   1097	1121	1577	java/lang/Throwable
    //   1121	1182	1577	java/lang/Throwable
    //   1182	1239	1577	java/lang/Throwable
    //   1239	1249	1577	java/lang/Throwable
    //   1253	1277	1577	java/lang/Throwable
    //   1277	1374	1577	java/lang/Throwable
    //   1374	1383	1577	java/lang/Throwable
    //   1385	1407	1577	java/lang/Throwable
    //   1471	1480	1577	java/lang/Throwable
    //   1541	1574	1577	java/lang/Throwable
    //   1589	1613	1577	java/lang/Throwable
    //   1616	1628	1577	java/lang/Throwable
    //   1631	1642	1577	java/lang/Throwable
    //   1239	1249	1645	java/lang/Exception
    //   1253	1277	1645	java/lang/Exception
    //   1182	1239	1649	java/lang/Exception
  }
  
  public void a()
  {
    if (bv.l(j))
    {
      d();
      return;
    }
    by.b("network is unavailable");
  }
  
  public void a(Context paramContext)
  {
    try
    {
      if (j == null) {
        j = paramContext;
      }
      if (this.l.length() > 0)
      {
        w.a(j).a(this.l);
        this.l = new JSONArray();
      }
      ba.a(j).edit().putLong("thtstart", this.p).putInt("gkvc", this.n).putInt("ekvc", this.o).commit();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public void a(af.a parama)
  {
    this.e.a(parama);
    this.d.a(parama);
    this.f.a(parama);
    this.g.a(parama);
    this.a = af.a(j).b().b(null);
  }
  
  public void a(Object paramObject)
  {
    if (this.c.f()) {
      this.i = this.c.l();
    }
    boolean bool = true;
    if ((paramObject instanceof JSONObject)) {
      bool = false;
    }
    try
    {
      b((JSONObject)paramObject);
      if (a(bool)) {
        d();
      }
      return;
    }
    catch (Throwable paramObject)
    {
      for (;;) {}
    }
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    return (!TextUtils.isEmpty("device_id")) && (!TextUtils.isEmpty("mc")) && (!TextUtils.isEmpty("resolution")) && (!TextUtils.isEmpty("appkey")) && (!TextUtils.isEmpty("channel")) && (!TextUtils.isEmpty("app_signature")) && (!TextUtils.isEmpty("package_name")) && (!TextUtils.isEmpty("app_version"));
  }
  
  public void b()
  {
    c(a(new int[0]));
  }
  
  public class a
  {
    private ca.h b;
    private int c = -1;
    private int d = -1;
    private int e = -1;
    private int f = -1;
    
    public a()
    {
      this$1 = aq.a(aq.this).a(-1, -1);
      this.c = aq.this[0];
      this.d = aq.this[1];
    }
    
    private ca.h b(int paramInt1, int paramInt2)
    {
      switch (paramInt1)
      {
      case 2: 
      case 3: 
      case 7: 
      default: 
        if ((this.b instanceof ca.d)) {
          return this.b;
        }
        break;
      case 1: 
        if ((this.b instanceof ca.d)) {
          return this.b;
        }
        return new ca.d();
      case 6: 
        if ((this.b instanceof ca.e))
        {
          ca.h localh = this.b;
          ((ca.e)localh).a(paramInt2);
          return localh;
        }
        return new ca.e(aq.c(aq.this), paramInt2);
      case 4: 
        if ((this.b instanceof ca.f)) {
          return this.b;
        }
        return new ca.f(aq.c(aq.this));
      case 0: 
        if ((this.b instanceof ca.g)) {
          return this.b;
        }
        return new ca.g();
      case 5: 
        if ((this.b instanceof ca.i)) {
          return this.b;
        }
        return new ca.i(aq.c());
      case 8: 
        if ((this.b instanceof ca.j)) {
          return this.b;
        }
        return new ca.j(aq.c(aq.this));
      }
      return new ca.d();
    }
    
    public void a(int paramInt1, int paramInt2)
    {
      this.e = paramInt1;
      this.f = paramInt2;
    }
    
    public void a(af.a parama)
    {
      parama = parama.a(-1, -1);
      this.c = parama[0];
      this.d = parama[1];
    }
    
    protected void a(boolean paramBoolean)
    {
      int k = 1;
      int i = 1;
      int j = 0;
      Object localObject;
      if (aq.b(aq.this).d()) {
        if (((this.b instanceof ca.b)) && (this.b.a()))
        {
          if (i == 0) {
            break label62;
          }
          localObject = this.b;
          label50:
          this.b = ((ca.h)localObject);
        }
      }
      for (;;)
      {
        return;
        i = 0;
        break;
        label62:
        localObject = new ca.b(aq.c(aq.this), aq.b(aq.this));
        break label50;
        if (((this.b instanceof ca.c)) && (this.b.a())) {}
        for (i = k; i == 0; i = 0)
        {
          if ((!paramBoolean) || (!aq.d(aq.this).a())) {
            break label178;
          }
          this.b = new ca.c((int)aq.d(aq.this).b());
          aq.a(aq.this, (int)aq.d(aq.this).b());
          return;
        }
      }
      label178:
      if ((by.a) && (aq.a(aq.this).b()))
      {
        this.b = new ca.a(aq.c(aq.this));
        return;
      }
      if ((aq.e(aq.this).a()) && ("RPT".equals(aq.e(aq.this).f())))
      {
        i = j;
        if (aq.e(aq.this).b() == 6)
        {
          if (!aq.a(aq.this).a()) {
            break label310;
          }
          i = aq.a(aq.this).d(90000);
        }
        for (;;)
        {
          this.b = b(aq.e(aq.this).b(), i);
          return;
          label310:
          if (this.d > 0) {
            i = this.d;
          } else {
            i = this.f;
          }
        }
      }
      j = this.e;
      i = this.f;
      if (this.c != -1)
      {
        j = this.c;
        i = this.d;
      }
      this.b = b(j, i);
    }
    
    public ca.h b(boolean paramBoolean)
    {
      a(paramBoolean);
      return this.b;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */