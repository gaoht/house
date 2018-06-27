package com.tencent.smtt.sdk;

import java.nio.channels.FileLock;

class bg
{
  private static bg a;
  private static FileLock e = null;
  private bh b;
  private boolean c;
  private boolean d;
  
  public static bg b()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bg();
      }
      return a;
    }
    finally {}
  }
  
  public bh a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.b;
    }
    return d();
  }
  
  public FileLock a()
  {
    return e;
  }
  
  /* Error */
  public FileLock a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 17	com/tencent/smtt/sdk/bg:e	Ljava/nio/channels/FileLock;
    //   5: ifnull +11 -> 16
    //   8: getstatic 17	com/tencent/smtt/sdk/bg:e	Ljava/nio/channels/FileLock;
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: aload_1
    //   17: iconst_1
    //   18: ldc 35
    //   20: invokestatic 40	com/tencent/smtt/utils/j:b	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   23: astore_2
    //   24: aload_2
    //   25: ifnonnull +10 -> 35
    //   28: getstatic 17	com/tencent/smtt/sdk/bg:e	Ljava/nio/channels/FileLock;
    //   31: astore_1
    //   32: goto -20 -> 12
    //   35: aload_1
    //   36: aload_2
    //   37: invokestatic 43	com/tencent/smtt/utils/j:a	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   40: putstatic 17	com/tencent/smtt/sdk/bg:e	Ljava/nio/channels/FileLock;
    //   43: getstatic 17	com/tencent/smtt/sdk/bg:e	Ljava/nio/channels/FileLock;
    //   46: astore_1
    //   47: aload_1
    //   48: ifnonnull -20 -> 28
    //   51: goto -23 -> 28
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	bg
    //   0	59	1	paramContext	android.content.Context
    //   23	14	2	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   2	12	54	finally
    //   16	24	54	finally
    //   28	32	54	finally
    //   35	47	54	finally
  }
  
  /* Error */
  public void a(android.content.Context paramContext, ah paramah)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_2
    //   6: ifnull +10 -> 16
    //   9: aload_2
    //   10: ldc 50
    //   12: iconst_2
    //   13: invokevirtual 55	com/tencent/smtt/sdk/ah:a	(Ljava/lang/String;B)V
    //   16: iconst_1
    //   17: invokestatic 60	com/tencent/smtt/sdk/k:a	(Z)Lcom/tencent/smtt/sdk/k;
    //   20: astore 8
    //   22: aload 8
    //   24: aload_1
    //   25: iconst_0
    //   26: iconst_0
    //   27: aload_2
    //   28: invokevirtual 63	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;ZZLcom/tencent/smtt/sdk/ah;)V
    //   31: new 65	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   38: astore 7
    //   40: aload_2
    //   41: ifnull +10 -> 51
    //   44: aload_2
    //   45: ldc 68
    //   47: iconst_1
    //   48: invokevirtual 55	com/tencent/smtt/sdk/ah:a	(Ljava/lang/String;B)V
    //   51: aload 8
    //   53: invokevirtual 71	com/tencent/smtt/sdk/k:b	()Z
    //   56: ifeq +390 -> 446
    //   59: aload_0
    //   60: getfield 73	com/tencent/smtt/sdk/bg:d	Z
    //   63: ifne +555 -> 618
    //   66: aload_2
    //   67: ifnull +8 -> 75
    //   70: aload_2
    //   71: iconst_1
    //   72: putfield 75	com/tencent/smtt/sdk/ah:a	Z
    //   75: aload_0
    //   76: new 77	com/tencent/smtt/sdk/bh
    //   79: dup
    //   80: aload 8
    //   82: invokevirtual 80	com/tencent/smtt/sdk/k:a	()Lcom/tencent/smtt/sdk/aw;
    //   85: invokevirtual 85	com/tencent/smtt/sdk/aw:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   88: invokespecial 88	com/tencent/smtt/sdk/bh:<init>	(Lcom/tencent/smtt/export/external/DexLoader;)V
    //   91: putfield 28	com/tencent/smtt/sdk/bg:b	Lcom/tencent/smtt/sdk/bh;
    //   94: aload_0
    //   95: aload_0
    //   96: getfield 28	com/tencent/smtt/sdk/bg:b	Lcom/tencent/smtt/sdk/bh;
    //   99: invokevirtual 90	com/tencent/smtt/sdk/bh:a	()Z
    //   102: putfield 92	com/tencent/smtt/sdk/bg:c	Z
    //   105: aload_0
    //   106: getfield 92	com/tencent/smtt/sdk/bg:c	Z
    //   109: ifne +11 -> 120
    //   112: aload 7
    //   114: ldc 94
    //   116: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aconst_null
    //   121: astore 4
    //   123: aload 4
    //   125: astore 5
    //   127: aload_0
    //   128: getfield 92	com/tencent/smtt/sdk/bg:c	Z
    //   131: ifeq +13 -> 144
    //   134: invokestatic 104	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   137: invokevirtual 106	com/tencent/smtt/sdk/CookieManager:a	()V
    //   140: aload 4
    //   142: astore 5
    //   144: aload_0
    //   145: getfield 92	com/tencent/smtt/sdk/bg:c	Z
    //   148: ifne +455 -> 603
    //   151: ldc 108
    //   153: ldc 110
    //   155: invokestatic 115	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload 8
    //   160: invokevirtual 71	com/tencent/smtt/sdk/k:b	()Z
    //   163: istore_3
    //   164: iload_3
    //   165: ifeq +350 -> 515
    //   168: aload 5
    //   170: ifnonnull +345 -> 515
    //   173: aload 8
    //   175: invokevirtual 80	com/tencent/smtt/sdk/k:a	()Lcom/tencent/smtt/sdk/aw;
    //   178: invokevirtual 85	com/tencent/smtt/sdk/aw:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   181: astore 5
    //   183: aload 6
    //   185: astore 4
    //   187: aload 5
    //   189: ifnull +22 -> 211
    //   192: aload 5
    //   194: ldc 117
    //   196: ldc 119
    //   198: iconst_0
    //   199: anewarray 121	java/lang/Class
    //   202: iconst_0
    //   203: anewarray 4	java/lang/Object
    //   206: invokevirtual 127	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   209: astore 4
    //   211: aload 4
    //   213: instanceof 48
    //   216: ifeq +62 -> 278
    //   219: aload 4
    //   221: checkcast 48	java/lang/Throwable
    //   224: astore 5
    //   226: aload 7
    //   228: new 65	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   235: ldc -127
    //   237: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload 5
    //   242: invokevirtual 133	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   245: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc -121
    //   250: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload 5
    //   255: invokevirtual 139	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   258: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   261: ldc -112
    //   263: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload 5
    //   268: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload 4
    //   280: instanceof 149
    //   283: ifeq +29 -> 312
    //   286: aload 7
    //   288: new 65	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   295: ldc -105
    //   297: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 4
    //   302: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 7
    //   314: ifnull +158 -> 472
    //   317: aload 7
    //   319: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: ldc -103
    //   324: invokevirtual 157	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   327: ifeq +145 -> 472
    //   330: invokestatic 162	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   333: aload_1
    //   334: sipush 408
    //   337: new 48	java/lang/Throwable
    //   340: dup
    //   341: new 65	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   348: ldc -92
    //   350: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload 7
    //   355: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokespecial 167	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   367: invokevirtual 170	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   370: aload_0
    //   371: iconst_1
    //   372: putfield 73	com/tencent/smtt/sdk/bg:d	Z
    //   375: aload_2
    //   376: ifnull +10 -> 386
    //   379: aload_2
    //   380: ldc 68
    //   382: iconst_2
    //   383: invokevirtual 55	com/tencent/smtt/sdk/ah:a	(Ljava/lang/String;B)V
    //   386: aload_0
    //   387: monitorexit
    //   388: return
    //   389: astore 4
    //   391: aload_0
    //   392: iconst_1
    //   393: putfield 92	com/tencent/smtt/sdk/bg:c	Z
    //   396: aconst_null
    //   397: astore 4
    //   399: goto -276 -> 123
    //   402: astore 4
    //   404: aload_0
    //   405: iconst_0
    //   406: putfield 92	com/tencent/smtt/sdk/bg:c	Z
    //   409: aload 7
    //   411: new 65	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   418: ldc -84
    //   420: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload 4
    //   425: invokestatic 178	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   428: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: goto -315 -> 123
    //   441: astore_1
    //   442: aload_0
    //   443: monitorexit
    //   444: aload_1
    //   445: athrow
    //   446: aload_0
    //   447: iconst_0
    //   448: putfield 92	com/tencent/smtt/sdk/bg:c	Z
    //   451: aload 7
    //   453: ldc -76
    //   455: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: goto +159 -> 618
    //   462: astore 4
    //   464: aload 4
    //   466: invokevirtual 183	java/lang/Throwable:printStackTrace	()V
    //   469: goto -157 -> 312
    //   472: invokestatic 162	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   475: aload_1
    //   476: sipush 407
    //   479: new 48	java/lang/Throwable
    //   482: dup
    //   483: new 65	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   490: ldc -92
    //   492: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload 7
    //   497: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokespecial 167	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   509: invokevirtual 170	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   512: goto -142 -> 370
    //   515: aload 8
    //   517: invokevirtual 71	com/tencent/smtt/sdk/k:b	()Z
    //   520: ifeq +43 -> 563
    //   523: invokestatic 162	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   526: aload_1
    //   527: sipush 409
    //   530: new 48	java/lang/Throwable
    //   533: dup
    //   534: new 65	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   541: ldc -71
    //   543: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: aload 5
    //   548: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   551: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokespecial 167	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   557: invokevirtual 170	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   560: goto -190 -> 370
    //   563: invokestatic 162	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   566: aload_1
    //   567: sipush 410
    //   570: new 48	java/lang/Throwable
    //   573: dup
    //   574: new 65	java/lang/StringBuilder
    //   577: dup
    //   578: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   581: ldc -69
    //   583: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: aload 5
    //   588: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   591: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokespecial 167	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   597: invokevirtual 170	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   600: goto -230 -> 370
    //   603: getstatic 17	com/tencent/smtt/sdk/bg:e	Ljava/nio/channels/FileLock;
    //   606: ifnonnull -236 -> 370
    //   609: aload_0
    //   610: aload_1
    //   611: invokevirtual 189	com/tencent/smtt/sdk/bg:a	(Landroid/content/Context;)Ljava/nio/channels/FileLock;
    //   614: pop
    //   615: goto -245 -> 370
    //   618: aconst_null
    //   619: astore 5
    //   621: goto -477 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	624	0	this	bg
    //   0	624	1	paramContext	android.content.Context
    //   0	624	2	paramah	ah
    //   163	2	3	bool	boolean
    //   121	180	4	localObject1	Object
    //   389	1	4	localNoSuchMethodException	NoSuchMethodException
    //   397	1	4	localObject2	Object
    //   402	22	4	localThrowable1	Throwable
    //   462	3	4	localThrowable2	Throwable
    //   125	495	5	localObject3	Object
    //   1	183	6	localObject4	Object
    //   38	458	7	localStringBuilder	StringBuilder
    //   20	496	8	localk	k
    // Exception table:
    //   from	to	target	type
    //   94	120	389	java/lang/NoSuchMethodException
    //   94	120	402	java/lang/Throwable
    //   9	16	441	finally
    //   16	40	441	finally
    //   44	51	441	finally
    //   51	66	441	finally
    //   70	75	441	finally
    //   75	94	441	finally
    //   94	120	441	finally
    //   127	140	441	finally
    //   144	164	441	finally
    //   173	183	441	finally
    //   192	211	441	finally
    //   211	278	441	finally
    //   278	312	441	finally
    //   317	370	441	finally
    //   370	375	441	finally
    //   379	386	441	finally
    //   391	396	441	finally
    //   404	438	441	finally
    //   446	459	441	finally
    //   464	469	441	finally
    //   472	512	441	finally
    //   515	560	441	finally
    //   563	600	441	finally
    //   603	615	441	finally
    //   173	183	462	java/lang/Throwable
    //   192	211	462	java/lang/Throwable
    //   211	278	462	java/lang/Throwable
    //   278	312	462	java/lang/Throwable
  }
  
  public boolean c()
  {
    if (QbSdk.a) {
      return false;
    }
    return this.c;
  }
  
  public bh d()
  {
    if (QbSdk.a) {
      return null;
    }
    return this.b;
  }
  
  boolean e()
  {
    return this.d;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */