package cn.testin.analysis;

import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class dr
  implements dn
{
  public static int a;
  public static boolean b;
  public static final List<dw> c;
  public SelectionKey d;
  public ByteChannel e;
  public final BlockingQueue<ByteBuffer> f;
  public final BlockingQueue<ByteBuffer> g;
  private volatile boolean i = false;
  private do j = do.a;
  private final ds k;
  private List<dw> l;
  private dw m = null;
  private dp n;
  private ep o = null;
  private ByteBuffer p = ByteBuffer.allocate(0);
  private er q = null;
  private String r = null;
  private Integer s = null;
  private Boolean t = null;
  private String u = null;
  
  static
  {
    if (!dr.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      h = bool;
      a = 16384;
      b = false;
      c = new ArrayList(4);
      c.add(new eb());
      c.add(new dz());
      c.add(new ed());
      c.add(new ec());
      return;
    }
  }
  
  public dr(ds paramds, dw paramdw)
  {
    if ((paramds == null) || ((paramdw == null) && (this.n == dp.b))) {
      throw new IllegalArgumentException("parameters must not be null");
    }
    this.f = new LinkedBlockingQueue();
    this.g = new LinkedBlockingQueue();
    this.k = paramds;
    this.n = dp.a;
    if (paramdw != null) {
      this.m = paramdw.c();
    }
  }
  
  private void a(ew paramew)
  {
    if (b) {
      System.out.println("open using draft: " + this.m.getClass().getSimpleName());
    }
    this.j = do.c;
    try
    {
      this.k.a(this, paramew);
      return;
    }
    catch (RuntimeException paramew)
    {
      this.k.a(this, paramew);
    }
  }
  
  private void a(Collection<eo> paramCollection)
  {
    if (!c()) {
      throw new ek();
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      a((eo)paramCollection.next());
    }
  }
  
  private void a(List<ByteBuffer> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      e((ByteBuffer)paramList.next());
    }
  }
  
  /* Error */
  private boolean b(ByteBuffer paramByteBuffer)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 109	cn/testin/analysis/dr:p	Ljava/nio/ByteBuffer;
    //   4: invokevirtual 237	java/nio/ByteBuffer:capacity	()I
    //   7: ifne +70 -> 77
    //   10: aload_1
    //   11: astore 4
    //   13: aload 4
    //   15: invokevirtual 241	java/nio/ByteBuffer:mark	()Ljava/nio/Buffer;
    //   18: pop
    //   19: aload_0
    //   20: getfield 99	cn/testin/analysis/dr:m	Lcn/testin/analysis/dw;
    //   23: ifnonnull +207 -> 230
    //   26: aload_0
    //   27: aload 4
    //   29: invokespecial 244	cn/testin/analysis/dr:d	(Ljava/nio/ByteBuffer;)Lcn/testin/analysis/dy;
    //   32: astore 5
    //   34: getstatic 249	cn/testin/analysis/dy:a	Lcn/testin/analysis/dy;
    //   37: astore 6
    //   39: aload 5
    //   41: aload 6
    //   43: if_acmpne +187 -> 230
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 141	cn/testin/analysis/dr:k	Lcn/testin/analysis/ds;
    //   51: aload_0
    //   52: invokeinterface 252 2 0
    //   57: invokestatic 257	cn/testin/analysis/fc:a	(Ljava/lang/String;)[B
    //   60: invokestatic 261	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   63: invokespecial 225	cn/testin/analysis/dr:e	(Ljava/nio/ByteBuffer;)V
    //   66: aload_0
    //   67: bipush -3
    //   69: ldc_w 263
    //   72: invokevirtual 266	cn/testin/analysis/dr:a	(ILjava/lang/String;)V
    //   75: iconst_0
    //   76: ireturn
    //   77: aload_0
    //   78: getfield 109	cn/testin/analysis/dr:p	Ljava/nio/ByteBuffer;
    //   81: invokevirtual 269	java/nio/ByteBuffer:remaining	()I
    //   84: aload_1
    //   85: invokevirtual 269	java/nio/ByteBuffer:remaining	()I
    //   88: if_icmpge +44 -> 132
    //   91: aload_0
    //   92: getfield 109	cn/testin/analysis/dr:p	Ljava/nio/ByteBuffer;
    //   95: invokevirtual 237	java/nio/ByteBuffer:capacity	()I
    //   98: aload_1
    //   99: invokevirtual 269	java/nio/ByteBuffer:remaining	()I
    //   102: iadd
    //   103: invokestatic 107	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   106: astore 4
    //   108: aload_0
    //   109: getfield 109	cn/testin/analysis/dr:p	Ljava/nio/ByteBuffer;
    //   112: invokevirtual 272	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   115: pop
    //   116: aload 4
    //   118: aload_0
    //   119: getfield 109	cn/testin/analysis/dr:p	Ljava/nio/ByteBuffer;
    //   122: invokevirtual 276	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   125: pop
    //   126: aload_0
    //   127: aload 4
    //   129: putfield 109	cn/testin/analysis/dr:p	Ljava/nio/ByteBuffer;
    //   132: aload_0
    //   133: getfield 109	cn/testin/analysis/dr:p	Ljava/nio/ByteBuffer;
    //   136: aload_1
    //   137: invokevirtual 276	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   140: pop
    //   141: aload_0
    //   142: getfield 109	cn/testin/analysis/dr:p	Ljava/nio/ByteBuffer;
    //   145: invokevirtual 272	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   148: pop
    //   149: aload_0
    //   150: getfield 109	cn/testin/analysis/dr:p	Ljava/nio/ByteBuffer;
    //   153: astore 4
    //   155: goto -142 -> 13
    //   158: astore 5
    //   160: aload_0
    //   161: sipush 1006
    //   164: ldc_w 278
    //   167: iconst_1
    //   168: invokespecial 281	cn/testin/analysis/dr:c	(ILjava/lang/String;Z)V
    //   171: goto -96 -> 75
    //   174: astore 5
    //   176: aload_0
    //   177: getfield 109	cn/testin/analysis/dr:p	Ljava/nio/ByteBuffer;
    //   180: invokevirtual 237	java/nio/ByteBuffer:capacity	()I
    //   183: ifne +606 -> 789
    //   186: aload 4
    //   188: invokevirtual 284	java/nio/ByteBuffer:reset	()Ljava/nio/Buffer;
    //   191: pop
    //   192: aload 5
    //   194: invokevirtual 286	cn/testin/analysis/ee:a	()I
    //   197: istore_3
    //   198: iload_3
    //   199: ifne +559 -> 758
    //   202: aload 4
    //   204: invokevirtual 237	java/nio/ByteBuffer:capacity	()I
    //   207: bipush 16
    //   209: iadd
    //   210: istore_2
    //   211: aload_0
    //   212: iload_2
    //   213: invokestatic 107	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   216: putfield 109	cn/testin/analysis/dr:p	Ljava/nio/ByteBuffer;
    //   219: aload_0
    //   220: getfield 109	cn/testin/analysis/dr:p	Ljava/nio/ByteBuffer;
    //   223: aload_1
    //   224: invokevirtual 276	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   227: pop
    //   228: iconst_0
    //   229: ireturn
    //   230: aload_0
    //   231: getfield 121	cn/testin/analysis/dr:n	Lcn/testin/analysis/dp;
    //   234: getstatic 125	cn/testin/analysis/dp:b	Lcn/testin/analysis/dp;
    //   237: if_acmpne +314 -> 551
    //   240: aload_0
    //   241: getfield 99	cn/testin/analysis/dr:m	Lcn/testin/analysis/dw;
    //   244: ifnonnull +233 -> 477
    //   247: aload_0
    //   248: getfield 288	cn/testin/analysis/dr:l	Ljava/util/List;
    //   251: invokeinterface 222 1 0
    //   256: astore 5
    //   258: aload 5
    //   260: invokeinterface 209 1 0
    //   265: ifeq +192 -> 457
    //   268: aload 5
    //   270: invokeinterface 213 1 0
    //   275: checkcast 145	cn/testin/analysis/dw
    //   278: invokevirtual 148	cn/testin/analysis/dw:c	()Lcn/testin/analysis/dw;
    //   281: astore 6
    //   283: aload 6
    //   285: aload_0
    //   286: getfield 121	cn/testin/analysis/dr:n	Lcn/testin/analysis/dp;
    //   289: invokevirtual 291	cn/testin/analysis/dw:a	(Lcn/testin/analysis/dp;)V
    //   292: aload 4
    //   294: invokevirtual 284	java/nio/ByteBuffer:reset	()Ljava/nio/Buffer;
    //   297: pop
    //   298: aload 6
    //   300: aload 4
    //   302: invokevirtual 294	cn/testin/analysis/dw:d	(Ljava/nio/ByteBuffer;)Lcn/testin/analysis/ew;
    //   305: astore 7
    //   307: aload 7
    //   309: instanceof 296
    //   312: ifne +16 -> 328
    //   315: aload_0
    //   316: sipush 1002
    //   319: ldc_w 298
    //   322: iconst_0
    //   323: invokevirtual 300	cn/testin/analysis/dr:b	(ILjava/lang/String;Z)V
    //   326: iconst_0
    //   327: ireturn
    //   328: aload 7
    //   330: checkcast 296	cn/testin/analysis/er
    //   333: astore 7
    //   335: aload 6
    //   337: aload 7
    //   339: invokevirtual 303	cn/testin/analysis/dw:a	(Lcn/testin/analysis/er;)Lcn/testin/analysis/dy;
    //   342: getstatic 249	cn/testin/analysis/dy:a	Lcn/testin/analysis/dy;
    //   345: if_acmpne -87 -> 258
    //   348: aload_0
    //   349: aload 7
    //   351: invokeinterface 305 1 0
    //   356: putfield 119	cn/testin/analysis/dr:u	Ljava/lang/String;
    //   359: aload_0
    //   360: getfield 141	cn/testin/analysis/dr:k	Lcn/testin/analysis/ds;
    //   363: aload_0
    //   364: aload 6
    //   366: aload 7
    //   368: invokeinterface 308 4 0
    //   373: astore 8
    //   375: aload_0
    //   376: aload 6
    //   378: aload 6
    //   380: aload 7
    //   382: aload 8
    //   384: invokevirtual 311	cn/testin/analysis/dw:a	(Lcn/testin/analysis/er;Lcn/testin/analysis/ez;)Lcn/testin/analysis/et;
    //   387: aload_0
    //   388: getfield 121	cn/testin/analysis/dr:n	Lcn/testin/analysis/dp;
    //   391: invokevirtual 314	cn/testin/analysis/dw:a	(Lcn/testin/analysis/ew;Lcn/testin/analysis/dp;)Ljava/util/List;
    //   394: invokespecial 316	cn/testin/analysis/dr:a	(Ljava/util/List;)V
    //   397: aload_0
    //   398: aload 6
    //   400: putfield 99	cn/testin/analysis/dr:m	Lcn/testin/analysis/dw;
    //   403: aload_0
    //   404: aload 7
    //   406: invokespecial 318	cn/testin/analysis/dr:a	(Lcn/testin/analysis/ew;)V
    //   409: iconst_1
    //   410: ireturn
    //   411: astore 6
    //   413: aload_0
    //   414: aload 6
    //   416: invokevirtual 319	cn/testin/analysis/ef:a	()I
    //   419: aload 6
    //   421: invokevirtual 322	cn/testin/analysis/ef:getMessage	()Ljava/lang/String;
    //   424: iconst_0
    //   425: invokevirtual 300	cn/testin/analysis/dr:b	(ILjava/lang/String;Z)V
    //   428: iconst_0
    //   429: ireturn
    //   430: astore 6
    //   432: aload_0
    //   433: getfield 141	cn/testin/analysis/dr:k	Lcn/testin/analysis/ds;
    //   436: aload_0
    //   437: aload 6
    //   439: invokeinterface 192 3 0
    //   444: aload_0
    //   445: iconst_m1
    //   446: aload 6
    //   448: invokevirtual 323	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   451: iconst_0
    //   452: invokevirtual 300	cn/testin/analysis/dr:b	(ILjava/lang/String;Z)V
    //   455: iconst_0
    //   456: ireturn
    //   457: aload_0
    //   458: getfield 99	cn/testin/analysis/dr:m	Lcn/testin/analysis/dw;
    //   461: ifnonnull +366 -> 827
    //   464: aload_0
    //   465: sipush 1002
    //   468: ldc_w 325
    //   471: invokevirtual 266	cn/testin/analysis/dr:a	(ILjava/lang/String;)V
    //   474: goto +353 -> 827
    //   477: aload_0
    //   478: getfield 99	cn/testin/analysis/dr:m	Lcn/testin/analysis/dw;
    //   481: aload 4
    //   483: invokevirtual 294	cn/testin/analysis/dw:d	(Ljava/nio/ByteBuffer;)Lcn/testin/analysis/ew;
    //   486: astore 5
    //   488: aload 5
    //   490: instanceof 296
    //   493: ifne +16 -> 509
    //   496: aload_0
    //   497: sipush 1002
    //   500: ldc_w 298
    //   503: iconst_0
    //   504: invokevirtual 300	cn/testin/analysis/dr:b	(ILjava/lang/String;Z)V
    //   507: iconst_0
    //   508: ireturn
    //   509: aload 5
    //   511: checkcast 296	cn/testin/analysis/er
    //   514: astore 5
    //   516: aload_0
    //   517: getfield 99	cn/testin/analysis/dr:m	Lcn/testin/analysis/dw;
    //   520: aload 5
    //   522: invokevirtual 303	cn/testin/analysis/dw:a	(Lcn/testin/analysis/er;)Lcn/testin/analysis/dy;
    //   525: getstatic 249	cn/testin/analysis/dy:a	Lcn/testin/analysis/dy;
    //   528: if_acmpne +11 -> 539
    //   531: aload_0
    //   532: aload 5
    //   534: invokespecial 318	cn/testin/analysis/dr:a	(Lcn/testin/analysis/ew;)V
    //   537: iconst_1
    //   538: ireturn
    //   539: aload_0
    //   540: sipush 1002
    //   543: ldc_w 327
    //   546: invokevirtual 266	cn/testin/analysis/dr:a	(ILjava/lang/String;)V
    //   549: iconst_0
    //   550: ireturn
    //   551: aload_0
    //   552: getfield 121	cn/testin/analysis/dr:n	Lcn/testin/analysis/dp;
    //   555: getstatic 143	cn/testin/analysis/dp:a	Lcn/testin/analysis/dp;
    //   558: if_acmpne -330 -> 228
    //   561: aload_0
    //   562: getfield 99	cn/testin/analysis/dr:m	Lcn/testin/analysis/dw;
    //   565: aload_0
    //   566: getfield 121	cn/testin/analysis/dr:n	Lcn/testin/analysis/dp;
    //   569: invokevirtual 291	cn/testin/analysis/dw:a	(Lcn/testin/analysis/dp;)V
    //   572: aload_0
    //   573: getfield 99	cn/testin/analysis/dr:m	Lcn/testin/analysis/dw;
    //   576: aload 4
    //   578: invokevirtual 294	cn/testin/analysis/dw:d	(Ljava/nio/ByteBuffer;)Lcn/testin/analysis/ew;
    //   581: astore 5
    //   583: aload 5
    //   585: instanceof 329
    //   588: ifne +16 -> 604
    //   591: aload_0
    //   592: sipush 1002
    //   595: ldc_w 298
    //   598: iconst_0
    //   599: invokevirtual 300	cn/testin/analysis/dr:b	(ILjava/lang/String;Z)V
    //   602: iconst_0
    //   603: ireturn
    //   604: aload 5
    //   606: checkcast 329	cn/testin/analysis/ey
    //   609: astore 5
    //   611: aload_0
    //   612: getfield 99	cn/testin/analysis/dr:m	Lcn/testin/analysis/dw;
    //   615: aload_0
    //   616: getfield 111	cn/testin/analysis/dr:q	Lcn/testin/analysis/er;
    //   619: aload 5
    //   621: invokevirtual 332	cn/testin/analysis/dw:a	(Lcn/testin/analysis/er;Lcn/testin/analysis/ey;)Lcn/testin/analysis/dy;
    //   624: astore 6
    //   626: getstatic 249	cn/testin/analysis/dy:a	Lcn/testin/analysis/dy;
    //   629: astore 7
    //   631: aload 6
    //   633: aload 7
    //   635: if_acmpne +73 -> 708
    //   638: aload_0
    //   639: getfield 141	cn/testin/analysis/dr:k	Lcn/testin/analysis/ds;
    //   642: aload_0
    //   643: aload_0
    //   644: getfield 111	cn/testin/analysis/dr:q	Lcn/testin/analysis/er;
    //   647: aload 5
    //   649: invokeinterface 335 4 0
    //   654: aload_0
    //   655: aload 5
    //   657: invokespecial 318	cn/testin/analysis/dr:a	(Lcn/testin/analysis/ew;)V
    //   660: iconst_1
    //   661: ireturn
    //   662: astore 5
    //   664: aload_0
    //   665: aload 5
    //   667: invokevirtual 319	cn/testin/analysis/ef:a	()I
    //   670: aload 5
    //   672: invokevirtual 322	cn/testin/analysis/ef:getMessage	()Ljava/lang/String;
    //   675: iconst_0
    //   676: invokevirtual 300	cn/testin/analysis/dr:b	(ILjava/lang/String;Z)V
    //   679: iconst_0
    //   680: ireturn
    //   681: astore 5
    //   683: aload_0
    //   684: getfield 141	cn/testin/analysis/dr:k	Lcn/testin/analysis/ds;
    //   687: aload_0
    //   688: aload 5
    //   690: invokeinterface 192 3 0
    //   695: aload_0
    //   696: iconst_m1
    //   697: aload 5
    //   699: invokevirtual 323	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   702: iconst_0
    //   703: invokevirtual 300	cn/testin/analysis/dr:b	(ILjava/lang/String;Z)V
    //   706: iconst_0
    //   707: ireturn
    //   708: aload_0
    //   709: sipush 1002
    //   712: new 159	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   719: ldc_w 337
    //   722: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: aload_0
    //   726: getfield 99	cn/testin/analysis/dr:m	Lcn/testin/analysis/dw;
    //   729: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   732: ldc_w 342
    //   735: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokevirtual 266	cn/testin/analysis/dr:a	(ILjava/lang/String;)V
    //   744: goto -516 -> 228
    //   747: astore 5
    //   749: aload_0
    //   750: aload 5
    //   752: invokevirtual 345	cn/testin/analysis/dr:a	(Lcn/testin/analysis/ef;)V
    //   755: goto -527 -> 228
    //   758: iload_3
    //   759: istore_2
    //   760: getstatic 55	cn/testin/analysis/dr:h	Z
    //   763: ifne -552 -> 211
    //   766: iload_3
    //   767: istore_2
    //   768: aload 5
    //   770: invokevirtual 286	cn/testin/analysis/ee:a	()I
    //   773: aload 4
    //   775: invokevirtual 269	java/nio/ByteBuffer:remaining	()I
    //   778: if_icmpge -567 -> 211
    //   781: new 347	java/lang/AssertionError
    //   784: dup
    //   785: invokespecial 348	java/lang/AssertionError:<init>	()V
    //   788: athrow
    //   789: aload_0
    //   790: getfield 109	cn/testin/analysis/dr:p	Ljava/nio/ByteBuffer;
    //   793: aload_0
    //   794: getfield 109	cn/testin/analysis/dr:p	Ljava/nio/ByteBuffer;
    //   797: invokevirtual 351	java/nio/ByteBuffer:limit	()I
    //   800: invokevirtual 355	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   803: pop
    //   804: aload_0
    //   805: getfield 109	cn/testin/analysis/dr:p	Ljava/nio/ByteBuffer;
    //   808: aload_0
    //   809: getfield 109	cn/testin/analysis/dr:p	Ljava/nio/ByteBuffer;
    //   812: invokevirtual 237	java/nio/ByteBuffer:capacity	()I
    //   815: invokevirtual 357	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   818: pop
    //   819: goto -591 -> 228
    //   822: astore 6
    //   824: goto -566 -> 258
    //   827: iconst_0
    //   828: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	829	0	this	dr
    //   0	829	1	paramByteBuffer	ByteBuffer
    //   210	558	2	i1	int
    //   197	570	3	i2	int
    //   11	763	4	localByteBuffer	ByteBuffer
    //   32	8	5	localdy1	dy
    //   158	1	5	localef1	ef
    //   174	19	5	localee	ee
    //   256	400	5	localObject1	Object
    //   662	9	5	localef2	ef
    //   681	17	5	localRuntimeException1	RuntimeException
    //   747	22	5	localeh1	eh
    //   37	362	6	localObject2	Object
    //   411	9	6	localef3	ef
    //   430	17	6	localRuntimeException2	RuntimeException
    //   624	8	6	localdy2	dy
    //   822	1	6	localeh2	eh
    //   305	329	7	localObject3	Object
    //   373	10	8	localez	ez
    // Exception table:
    //   from	to	target	type
    //   46	75	158	cn/testin/analysis/ef
    //   19	39	174	cn/testin/analysis/ee
    //   46	75	174	cn/testin/analysis/ee
    //   160	171	174	cn/testin/analysis/ee
    //   230	258	174	cn/testin/analysis/ee
    //   258	283	174	cn/testin/analysis/ee
    //   283	326	174	cn/testin/analysis/ee
    //   328	359	174	cn/testin/analysis/ee
    //   359	375	174	cn/testin/analysis/ee
    //   375	409	174	cn/testin/analysis/ee
    //   413	428	174	cn/testin/analysis/ee
    //   432	455	174	cn/testin/analysis/ee
    //   457	474	174	cn/testin/analysis/ee
    //   477	507	174	cn/testin/analysis/ee
    //   509	537	174	cn/testin/analysis/ee
    //   539	549	174	cn/testin/analysis/ee
    //   551	602	174	cn/testin/analysis/ee
    //   604	631	174	cn/testin/analysis/ee
    //   638	654	174	cn/testin/analysis/ee
    //   654	660	174	cn/testin/analysis/ee
    //   664	679	174	cn/testin/analysis/ee
    //   683	706	174	cn/testin/analysis/ee
    //   708	744	174	cn/testin/analysis/ee
    //   749	755	174	cn/testin/analysis/ee
    //   359	375	411	cn/testin/analysis/ef
    //   359	375	430	java/lang/RuntimeException
    //   638	654	662	cn/testin/analysis/ef
    //   638	654	681	java/lang/RuntimeException
    //   230	258	747	cn/testin/analysis/eh
    //   258	283	747	cn/testin/analysis/eh
    //   457	474	747	cn/testin/analysis/eh
    //   477	507	747	cn/testin/analysis/eh
    //   509	537	747	cn/testin/analysis/eh
    //   539	549	747	cn/testin/analysis/eh
    //   551	602	747	cn/testin/analysis/eh
    //   604	631	747	cn/testin/analysis/eh
    //   638	654	747	cn/testin/analysis/eh
    //   654	660	747	cn/testin/analysis/eh
    //   664	679	747	cn/testin/analysis/eh
    //   683	706	747	cn/testin/analysis/eh
    //   708	744	747	cn/testin/analysis/eh
    //   283	326	822	cn/testin/analysis/eh
    //   328	359	822	cn/testin/analysis/eh
    //   359	375	822	cn/testin/analysis/eh
    //   375	409	822	cn/testin/analysis/eh
    //   413	428	822	cn/testin/analysis/eh
    //   432	455	822	cn/testin/analysis/eh
  }
  
  private void c(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.j != do.d) && (this.j != do.e))
    {
      if (this.j != do.c) {
        break label191;
      }
      if (paramInt == 1006)
      {
        if ((!h) && (paramBoolean)) {
          throw new AssertionError();
        }
        this.j = do.d;
        b(paramInt, paramString, false);
      }
    }
    else
    {
      return;
    }
    if ((this.m.b() == dx.a) || (!paramBoolean)) {}
    for (;;)
    {
      try
      {
        this.k.a(this, paramInt, paramString);
        a(new em(paramInt, paramString));
        b(paramInt, paramString, paramBoolean);
        if (paramInt == 1002) {
          b(paramInt, paramString, paramBoolean);
        }
        this.j = do.d;
        this.p = null;
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.k.a(this, localRuntimeException);
        continue;
      }
      catch (ef localef)
      {
        this.k.a(this, localef);
        b(1006, "generated frame is invalid", false);
        continue;
      }
      label191:
      if (paramInt == -3)
      {
        if ((!h) && (!paramBoolean)) {
          throw new AssertionError();
        }
        b(-3, paramString, true);
      }
      else
      {
        b(-1, paramString, false);
      }
    }
  }
  
  private void c(ByteBuffer paramByteBuffer)
  {
    for (;;)
    {
      ep localep1;
      boolean bool;
      int i1;
      try
      {
        Iterator localIterator = this.m.c(paramByteBuffer).iterator();
        if (localIterator.hasNext())
        {
          paramByteBuffer = (eo)localIterator.next();
          if (b) {
            System.out.println("matched frame: " + paramByteBuffer);
          }
          localep1 = paramByteBuffer.f();
          bool = paramByteBuffer.d();
          if (localep1 != ep.f) {
            break label188;
          }
          if (!(paramByteBuffer instanceof el)) {
            break label492;
          }
          paramByteBuffer = (el)paramByteBuffer;
          i1 = paramByteBuffer.a();
          paramByteBuffer = paramByteBuffer.b();
          if (this.j == do.d) {
            a(i1, paramByteBuffer, true);
          }
        }
        else
        {
          return;
        }
      }
      catch (ef paramByteBuffer)
      {
        this.k.a(this, paramByteBuffer);
        a(paramByteBuffer);
      }
      if (this.m.b() == dx.c)
      {
        c(i1, paramByteBuffer, true);
      }
      else
      {
        b(i1, paramByteBuffer, false);
        continue;
        label188:
        if (localep1 == ep.d)
        {
          this.k.b(this, paramByteBuffer);
        }
        else if (localep1 == ep.e)
        {
          this.k.c(this, paramByteBuffer);
        }
        else
        {
          if ((!bool) || (localep1 == ep.a))
          {
            if (localep1 != ep.a)
            {
              if (this.o != null) {
                throw new ef(1002, "Previous continuous frame sequence not completed.");
              }
              this.o = localep1;
            }
            label341:
            do
            {
              for (;;)
              {
                try
                {
                  this.k.a(this, paramByteBuffer);
                }
                catch (RuntimeException paramByteBuffer)
                {
                  this.k.a(this, paramByteBuffer);
                }
                break;
                if (!bool) {
                  break label341;
                }
                if (this.o == null) {
                  throw new ef(1002, "Continuous frame sequence was not started.");
                }
                this.o = null;
              }
            } while (this.o != null);
            throw new ef(1002, "Continuous frame sequence was not started.");
          }
          if (this.o != null) {
            throw new ef(1002, "Continuous frame sequence not completed.");
          }
          ep localep2 = ep.b;
          if (localep1 == localep2)
          {
            try
            {
              this.k.a(this, fc.a(paramByteBuffer.c()));
            }
            catch (RuntimeException paramByteBuffer)
            {
              this.k.a(this, paramByteBuffer);
            }
          }
          else
          {
            localep2 = ep.c;
            if (localep1 == localep2)
            {
              try
              {
                this.k.a(this, paramByteBuffer.c());
              }
              catch (RuntimeException paramByteBuffer)
              {
                this.k.a(this, paramByteBuffer);
              }
            }
            else
            {
              throw new ef(1002, "non control or continious frame expected");
              label492:
              paramByteBuffer = "";
              i1 = 1005;
            }
          }
        }
      }
    }
  }
  
  private dy d(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.mark();
    if (paramByteBuffer.limit() > dw.c.length) {
      return dy.b;
    }
    if (paramByteBuffer.limit() < dw.c.length) {
      throw new ee(dw.c.length);
    }
    int i1 = 0;
    while (paramByteBuffer.hasRemaining())
    {
      if (dw.c[i1] != paramByteBuffer.get())
      {
        paramByteBuffer.reset();
        return dy.b;
      }
      i1 += 1;
    }
    return dy.a;
  }
  
  private void e(ByteBuffer paramByteBuffer)
  {
    PrintStream localPrintStream;
    StringBuilder localStringBuilder;
    if (b)
    {
      localPrintStream = System.out;
      localStringBuilder = new StringBuilder().append("write(").append(paramByteBuffer.remaining()).append("): {");
      if (paramByteBuffer.remaining() <= 1000) {
        break label93;
      }
    }
    label93:
    for (String str = "too big to display";; str = new String(paramByteBuffer.array()))
    {
      localPrintStream.println(str + "}");
      this.f.add(paramByteBuffer);
      this.k.b(this);
      return;
    }
  }
  
  public InetSocketAddress a()
  {
    return this.k.c(this);
  }
  
  public void a(int paramInt)
  {
    c(paramInt, "", false);
  }
  
  public void a(int paramInt, String paramString)
  {
    c(paramInt, paramString, false);
  }
  
  /* Error */
  protected void a(int paramInt, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 97	cn/testin/analysis/dr:j	Lcn/testin/analysis/do;
    //   6: astore 4
    //   8: getstatic 361	cn/testin/analysis/do:e	Lcn/testin/analysis/do;
    //   11: astore 5
    //   13: aload 4
    //   15: aload 5
    //   17: if_acmpne +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 486	cn/testin/analysis/dr:d	Ljava/nio/channels/SelectionKey;
    //   27: ifnull +10 -> 37
    //   30: aload_0
    //   31: getfield 486	cn/testin/analysis/dr:d	Ljava/nio/channels/SelectionKey;
    //   34: invokevirtual 491	java/nio/channels/SelectionKey:cancel	()V
    //   37: aload_0
    //   38: getfield 493	cn/testin/analysis/dr:e	Ljava/nio/channels/ByteChannel;
    //   41: astore 4
    //   43: aload 4
    //   45: ifnull +12 -> 57
    //   48: aload_0
    //   49: getfield 493	cn/testin/analysis/dr:e	Ljava/nio/channels/ByteChannel;
    //   52: invokeinterface 498 1 0
    //   57: aload_0
    //   58: getfield 141	cn/testin/analysis/dr:k	Lcn/testin/analysis/ds;
    //   61: aload_0
    //   62: iload_1
    //   63: aload_2
    //   64: iload_3
    //   65: invokeinterface 501 5 0
    //   70: aload_0
    //   71: getfield 99	cn/testin/analysis/dr:m	Lcn/testin/analysis/dw;
    //   74: ifnull +10 -> 84
    //   77: aload_0
    //   78: getfield 99	cn/testin/analysis/dr:m	Lcn/testin/analysis/dw;
    //   81: invokevirtual 503	cn/testin/analysis/dw:a	()V
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 111	cn/testin/analysis/dr:q	Lcn/testin/analysis/er;
    //   89: aload_0
    //   90: getstatic 361	cn/testin/analysis/do:e	Lcn/testin/analysis/do;
    //   93: putfield 97	cn/testin/analysis/dr:j	Lcn/testin/analysis/do;
    //   96: aload_0
    //   97: getfield 137	cn/testin/analysis/dr:f	Ljava/util/concurrent/BlockingQueue;
    //   100: invokeinterface 506 1 0
    //   105: goto -85 -> 20
    //   108: astore_2
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_2
    //   112: athrow
    //   113: astore 4
    //   115: aload_0
    //   116: getfield 141	cn/testin/analysis/dr:k	Lcn/testin/analysis/ds;
    //   119: aload_0
    //   120: aload 4
    //   122: invokeinterface 192 3 0
    //   127: goto -70 -> 57
    //   130: astore_2
    //   131: aload_0
    //   132: getfield 141	cn/testin/analysis/dr:k	Lcn/testin/analysis/ds;
    //   135: aload_0
    //   136: aload_2
    //   137: invokeinterface 192 3 0
    //   142: goto -72 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	dr
    //   0	145	1	paramInt	int
    //   0	145	2	paramString	String
    //   0	145	3	paramBoolean	boolean
    //   6	38	4	localObject	Object
    //   113	8	4	localIOException	java.io.IOException
    //   11	5	5	localdo	do
    // Exception table:
    //   from	to	target	type
    //   2	13	108	finally
    //   23	37	108	finally
    //   37	43	108	finally
    //   48	57	108	finally
    //   57	70	108	finally
    //   70	84	108	finally
    //   84	105	108	finally
    //   115	127	108	finally
    //   131	142	108	finally
    //   48	57	113	java/io/IOException
    //   57	70	130	java/lang/RuntimeException
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, "", paramBoolean);
  }
  
  public void a(ef paramef)
  {
    c(paramef.a(), paramef.getMessage(), false);
  }
  
  public void a(eo parameo)
  {
    if (b) {
      System.out.println("send frame: " + parameo);
    }
    e(this.m.a(parameo));
  }
  
  public void a(ep paramep, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    a(this.m.a(paramep, paramByteBuffer, paramBoolean));
  }
  
  public void a(es parames)
  {
    if ((!h) && (this.j == do.b)) {
      throw new AssertionError("shall only be called once");
    }
    this.q = this.m.a(parames);
    this.u = parames.a();
    if ((!h) && (this.u == null)) {
      throw new AssertionError();
    }
    try
    {
      this.k.a(this, this.q);
      a(this.m.a(this.q, this.n));
      return;
    }
    catch (ef parames)
    {
      throw new eh("Handshake data rejected by client.");
    }
    catch (RuntimeException parames)
    {
      this.k.a(this, parames);
      throw new eh("rejected because of" + parames);
    }
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    if ((!h) && (!paramByteBuffer.hasRemaining())) {
      throw new AssertionError();
    }
    String str;
    if (b)
    {
      PrintStream localPrintStream = System.out;
      StringBuilder localStringBuilder = new StringBuilder().append("process(").append(paramByteBuffer.remaining()).append("): {");
      if (paramByteBuffer.remaining() > 1000)
      {
        str = "too big to display";
        localPrintStream.println(str + "}");
      }
    }
    else
    {
      if (this.j == do.a) {
        break label165;
      }
      c(paramByteBuffer);
    }
    for (;;)
    {
      if ((h) || (d()) || (e()) || (!paramByteBuffer.hasRemaining())) {
        return;
      }
      throw new AssertionError();
      str = new String(paramByteBuffer.array(), paramByteBuffer.position(), paramByteBuffer.remaining());
      break;
      label165:
      if (b(paramByteBuffer))
      {
        if ((!h) && (this.p.hasRemaining() == paramByteBuffer.hasRemaining()) && (paramByteBuffer.hasRemaining())) {
          throw new AssertionError();
        }
        if (paramByteBuffer.hasRemaining()) {
          c(paramByteBuffer);
        } else if (this.p.hasRemaining()) {
          c(this.p);
        }
      }
    }
  }
  
  public void b()
  {
    if (g() == do.a)
    {
      a(-1, true);
      return;
    }
    if (this.i)
    {
      a(this.s.intValue(), this.r, this.t.booleanValue());
      return;
    }
    if (this.m.b() == dx.a)
    {
      a(1000, true);
      return;
    }
    if (this.m.b() == dx.b)
    {
      if (this.n == dp.b)
      {
        a(1006, true);
        return;
      }
      a(1000, true);
      return;
    }
    a(1006, true);
  }
  
  public void b(int paramInt, String paramString)
  {
    a(paramInt, paramString, false);
  }
  
  /* Error */
  protected void b(int paramInt, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 91	cn/testin/analysis/dr:i	Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: iload_1
    //   18: invokestatic 575	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: putfield 115	cn/testin/analysis/dr:s	Ljava/lang/Integer;
    //   24: aload_0
    //   25: aload_2
    //   26: putfield 113	cn/testin/analysis/dr:r	Ljava/lang/String;
    //   29: aload_0
    //   30: iload_3
    //   31: invokestatic 578	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   34: putfield 117	cn/testin/analysis/dr:t	Ljava/lang/Boolean;
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 91	cn/testin/analysis/dr:i	Z
    //   42: aload_0
    //   43: getfield 141	cn/testin/analysis/dr:k	Lcn/testin/analysis/ds;
    //   46: aload_0
    //   47: invokeinterface 469 2 0
    //   52: aload_0
    //   53: getfield 141	cn/testin/analysis/dr:k	Lcn/testin/analysis/ds;
    //   56: aload_0
    //   57: iload_1
    //   58: aload_2
    //   59: iload_3
    //   60: invokeinterface 580 5 0
    //   65: aload_0
    //   66: getfield 99	cn/testin/analysis/dr:m	Lcn/testin/analysis/dw;
    //   69: ifnull +10 -> 79
    //   72: aload_0
    //   73: getfield 99	cn/testin/analysis/dr:m	Lcn/testin/analysis/dw;
    //   76: invokevirtual 503	cn/testin/analysis/dw:a	()V
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 111	cn/testin/analysis/dr:q	Lcn/testin/analysis/er;
    //   84: goto -71 -> 13
    //   87: astore_2
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_2
    //   91: athrow
    //   92: astore_2
    //   93: aload_0
    //   94: getfield 141	cn/testin/analysis/dr:k	Lcn/testin/analysis/ds;
    //   97: aload_0
    //   98: aload_2
    //   99: invokeinterface 192 3 0
    //   104: goto -39 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	dr
    //   0	107	1	paramInt	int
    //   0	107	2	paramString	String
    //   0	107	3	paramBoolean	boolean
    //   6	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	87	finally
    //   16	52	87	finally
    //   52	65	87	finally
    //   65	79	87	finally
    //   79	84	87	finally
    //   93	104	87	finally
    //   52	65	92	java/lang/RuntimeException
  }
  
  public boolean c()
  {
    if ((h) || (this.j != do.c) || (!this.i))
    {
      if (this.j == do.c) {
        return true;
      }
    }
    else {
      throw new AssertionError();
    }
    return false;
  }
  
  public boolean d()
  {
    return this.j == do.d;
  }
  
  public boolean e()
  {
    return this.i;
  }
  
  public boolean f()
  {
    return this.j == do.e;
  }
  
  public do g()
  {
    return this.j;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/dr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */