package com.xiaomi.smack;

import android.os.SystemClock;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.util.e;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public abstract class h
  extends a
{
  protected Exception o = null;
  protected Socket p;
  String q = null;
  protected XMPushService r;
  protected volatile long s = 0L;
  protected volatile long t = 0L;
  protected volatile long u = 0L;
  private String v;
  private int w;
  
  public h(XMPushService paramXMPushService, b paramb)
  {
    super(paramXMPushService, paramb);
    this.r = paramXMPushService;
  }
  
  private void a(b paramb)
  {
    a(paramb.e(), paramb.d());
  }
  
  /* Error */
  private void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: aconst_null
    //   4: putfield 25	com/xiaomi/smack/h:o	Ljava/lang/Exception;
    //   7: new 59	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 62	java/util/ArrayList:<init>	()V
    //   14: astore 10
    //   16: new 64	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   23: ldc 67
    //   25: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_1
    //   29: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 79	com/xiaomi/channel/commonutils/logger/b:e	(Ljava/lang/String;)Ljava/lang/Integer;
    //   38: invokevirtual 84	java/lang/Integer:intValue	()I
    //   41: istore 4
    //   43: aload_0
    //   44: aload_1
    //   45: invokevirtual 88	com/xiaomi/smack/h:b	(Ljava/lang/String;)Lcom/xiaomi/network/Fallback;
    //   48: astore 11
    //   50: iload 4
    //   52: invokestatic 92	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: invokestatic 95	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Integer;)V
    //   58: aload 11
    //   60: ifnull +11 -> 71
    //   63: aload 11
    //   65: iconst_1
    //   66: invokevirtual 100	com/xiaomi/network/Fallback:a	(Z)Ljava/util/ArrayList;
    //   69: astore 10
    //   71: aload 10
    //   73: invokevirtual 104	java/util/ArrayList:isEmpty	()Z
    //   76: ifeq +10 -> 86
    //   79: aload 10
    //   81: aload_1
    //   82: invokevirtual 108	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   85: pop
    //   86: aload_0
    //   87: lconst_0
    //   88: putfield 33	com/xiaomi/smack/h:u	J
    //   91: aload_0
    //   92: getfield 35	com/xiaomi/smack/h:r	Lcom/xiaomi/push/service/XMPushService;
    //   95: invokestatic 114	com/xiaomi/channel/commonutils/network/d:k	(Landroid/content/Context;)Ljava/lang/String;
    //   98: astore 12
    //   100: new 64	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   107: astore 13
    //   109: aload 10
    //   111: invokevirtual 118	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   114: astore 14
    //   116: aload 14
    //   118: invokeinterface 123 1 0
    //   123: ifeq +663 -> 786
    //   126: aload 14
    //   128: invokeinterface 127 1 0
    //   133: checkcast 129	java/lang/String
    //   136: astore 10
    //   138: invokestatic 135	java/lang/System:currentTimeMillis	()J
    //   141: lstore 8
    //   143: aload_0
    //   144: aload_0
    //   145: getfield 137	com/xiaomi/smack/h:b	I
    //   148: iconst_1
    //   149: iadd
    //   150: putfield 137	com/xiaomi/smack/h:b	I
    //   153: iload_3
    //   154: istore 4
    //   156: new 64	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   163: ldc -117
    //   165: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 10
    //   170: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 142	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   179: iload_3
    //   180: istore 4
    //   182: aload_0
    //   183: aload_0
    //   184: invokevirtual 145	com/xiaomi/smack/h:s	()Ljava/net/Socket;
    //   187: putfield 147	com/xiaomi/smack/h:p	Ljava/net/Socket;
    //   190: iload_3
    //   191: istore 4
    //   193: aload 10
    //   195: iload_2
    //   196: invokestatic 152	com/xiaomi/network/Host:b	(Ljava/lang/String;I)Ljava/net/InetSocketAddress;
    //   199: astore_1
    //   200: iload_3
    //   201: istore 4
    //   203: aload_0
    //   204: getfield 147	com/xiaomi/smack/h:p	Ljava/net/Socket;
    //   207: aload_1
    //   208: sipush 8000
    //   211: invokevirtual 158	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   214: iload_3
    //   215: istore 4
    //   217: ldc -96
    //   219: invokestatic 142	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   222: iload_3
    //   223: istore 4
    //   225: aload_0
    //   226: getfield 147	com/xiaomi/smack/h:p	Ljava/net/Socket;
    //   229: iconst_1
    //   230: invokevirtual 164	java/net/Socket:setTcpNoDelay	(Z)V
    //   233: iload_3
    //   234: istore 4
    //   236: aload_0
    //   237: aload 10
    //   239: putfield 166	com/xiaomi/smack/h:v	Ljava/lang/String;
    //   242: iload_3
    //   243: istore 4
    //   245: aload_0
    //   246: invokevirtual 168	com/xiaomi/smack/h:b	()V
    //   249: iconst_1
    //   250: istore 4
    //   252: iconst_1
    //   253: istore 6
    //   255: iconst_1
    //   256: istore 7
    //   258: iconst_1
    //   259: istore_3
    //   260: iload 7
    //   262: istore 5
    //   264: aload_0
    //   265: invokestatic 135	java/lang/System:currentTimeMillis	()J
    //   268: lload 8
    //   270: lsub
    //   271: putfield 171	com/xiaomi/smack/h:c	J
    //   274: iload 7
    //   276: istore 5
    //   278: aload_0
    //   279: aload 12
    //   281: putfield 173	com/xiaomi/smack/h:k	Ljava/lang/String;
    //   284: aload 11
    //   286: ifnull +19 -> 305
    //   289: iload 7
    //   291: istore 5
    //   293: aload 11
    //   295: aload 10
    //   297: aload_0
    //   298: getfield 171	com/xiaomi/smack/h:c	J
    //   301: lconst_0
    //   302: invokevirtual 176	com/xiaomi/network/Fallback:b	(Ljava/lang/String;JJ)V
    //   305: iload 7
    //   307: istore 5
    //   309: aload_0
    //   310: invokestatic 181	android/os/SystemClock:elapsedRealtime	()J
    //   313: putfield 33	com/xiaomi/smack/h:u	J
    //   316: iload 7
    //   318: istore 5
    //   320: new 64	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   327: ldc -73
    //   329: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload 10
    //   334: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: ldc -71
    //   339: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload_0
    //   343: getfield 171	com/xiaomi/smack/h:c	J
    //   346: invokevirtual 188	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   349: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 142	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   355: invokestatic 194	com/xiaomi/network/HostManager:getInstance	()Lcom/xiaomi/network/HostManager;
    //   358: invokevirtual 197	com/xiaomi/network/HostManager:persist	()V
    //   361: iload_3
    //   362: ifne +396 -> 758
    //   365: new 55	com/xiaomi/smack/l
    //   368: dup
    //   369: aload 13
    //   371: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokespecial 199	com/xiaomi/smack/l:<init>	(Ljava/lang/String;)V
    //   377: athrow
    //   378: astore_1
    //   379: iload_3
    //   380: istore 4
    //   382: aload 11
    //   384: ifnull +22 -> 406
    //   387: iload 4
    //   389: istore 5
    //   391: aload 11
    //   393: aload 10
    //   395: invokestatic 135	java/lang/System:currentTimeMillis	()J
    //   398: lload 8
    //   400: lsub
    //   401: lconst_0
    //   402: aload_1
    //   403: invokevirtual 202	com/xiaomi/network/Fallback:b	(Ljava/lang/String;JJLjava/lang/Exception;)V
    //   406: iload 4
    //   408: istore 5
    //   410: aload_0
    //   411: aload_1
    //   412: putfield 25	com/xiaomi/smack/h:o	Ljava/lang/Exception;
    //   415: iload 4
    //   417: istore 5
    //   419: new 64	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   426: ldc -52
    //   428: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: aload 10
    //   433: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 206	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   442: iload 4
    //   444: istore 5
    //   446: aload 13
    //   448: ldc -48
    //   450: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload 10
    //   455: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: ldc -46
    //   460: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: iload_2
    //   464: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   467: ldc -41
    //   469: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload_1
    //   473: invokevirtual 218	java/io/IOException:getMessage	()Ljava/lang/String;
    //   476: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: ldc -36
    //   481: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: iload 4
    //   487: istore 5
    //   489: iload 4
    //   491: ifne +34 -> 525
    //   494: aload 10
    //   496: aload_0
    //   497: getfield 25	com/xiaomi/smack/h:o	Ljava/lang/Exception;
    //   500: invokestatic 225	com/xiaomi/stats/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   503: iload 4
    //   505: istore_3
    //   506: aload 12
    //   508: aload_0
    //   509: getfield 35	com/xiaomi/smack/h:r	Lcom/xiaomi/push/service/XMPushService;
    //   512: invokestatic 114	com/xiaomi/channel/commonutils/network/d:k	(Landroid/content/Context;)Ljava/lang/String;
    //   515: invokestatic 231	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   518: ifeq -163 -> 355
    //   521: iload 4
    //   523: istore 5
    //   525: iload 5
    //   527: istore_3
    //   528: goto -412 -> 116
    //   531: astore_1
    //   532: aload 11
    //   534: ifnull +21 -> 555
    //   537: iload_3
    //   538: istore 5
    //   540: aload 11
    //   542: aload 10
    //   544: invokestatic 135	java/lang/System:currentTimeMillis	()J
    //   547: lload 8
    //   549: lsub
    //   550: lconst_0
    //   551: aload_1
    //   552: invokevirtual 202	com/xiaomi/network/Fallback:b	(Ljava/lang/String;JJLjava/lang/Exception;)V
    //   555: iload_3
    //   556: istore 5
    //   558: aload_0
    //   559: aload_1
    //   560: putfield 25	com/xiaomi/smack/h:o	Ljava/lang/Exception;
    //   563: iload_3
    //   564: istore 5
    //   566: new 64	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   573: ldc -52
    //   575: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload 10
    //   580: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: invokestatic 206	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   589: iload_3
    //   590: istore 5
    //   592: aload 13
    //   594: ldc -48
    //   596: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: aload 10
    //   601: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: ldc -46
    //   606: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: iload_2
    //   610: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   613: ldc -41
    //   615: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: aload_1
    //   619: invokevirtual 232	com/xiaomi/smack/l:getMessage	()Ljava/lang/String;
    //   622: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: ldc -36
    //   627: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: pop
    //   631: iload_3
    //   632: istore 5
    //   634: iload_3
    //   635: ifne -110 -> 525
    //   638: aload 10
    //   640: aload_0
    //   641: getfield 25	com/xiaomi/smack/h:o	Ljava/lang/Exception;
    //   644: invokestatic 225	com/xiaomi/stats/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   647: iload_3
    //   648: istore 5
    //   650: aload 12
    //   652: aload_0
    //   653: getfield 35	com/xiaomi/smack/h:r	Lcom/xiaomi/push/service/XMPushService;
    //   656: invokestatic 114	com/xiaomi/channel/commonutils/network/d:k	(Landroid/content/Context;)Ljava/lang/String;
    //   659: invokestatic 231	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   662: ifne -137 -> 525
    //   665: goto -310 -> 355
    //   668: astore_1
    //   669: iload_3
    //   670: istore 4
    //   672: aload_0
    //   673: new 234	java/lang/Exception
    //   676: dup
    //   677: ldc -20
    //   679: aload_1
    //   680: invokespecial 239	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   683: putfield 25	com/xiaomi/smack/h:o	Ljava/lang/Exception;
    //   686: iload_3
    //   687: istore 4
    //   689: aload_1
    //   690: invokestatic 242	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   693: iload_3
    //   694: ifne +89 -> 783
    //   697: aload 10
    //   699: aload_0
    //   700: getfield 25	com/xiaomi/smack/h:o	Ljava/lang/Exception;
    //   703: invokestatic 225	com/xiaomi/stats/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   706: aload 12
    //   708: aload_0
    //   709: getfield 35	com/xiaomi/smack/h:r	Lcom/xiaomi/push/service/XMPushService;
    //   712: invokestatic 114	com/xiaomi/channel/commonutils/network/d:k	(Landroid/content/Context;)Ljava/lang/String;
    //   715: invokestatic 231	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   718: ifne +65 -> 783
    //   721: goto -366 -> 355
    //   724: astore_1
    //   725: iload 4
    //   727: istore_3
    //   728: iload_3
    //   729: ifne +27 -> 756
    //   732: aload 10
    //   734: aload_0
    //   735: getfield 25	com/xiaomi/smack/h:o	Ljava/lang/Exception;
    //   738: invokestatic 225	com/xiaomi/stats/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   741: aload 12
    //   743: aload_0
    //   744: getfield 35	com/xiaomi/smack/h:r	Lcom/xiaomi/push/service/XMPushService;
    //   747: invokestatic 114	com/xiaomi/channel/commonutils/network/d:k	(Landroid/content/Context;)Ljava/lang/String;
    //   750: invokestatic 231	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   753: ifeq -398 -> 355
    //   756: aload_1
    //   757: athrow
    //   758: return
    //   759: astore_1
    //   760: iload 5
    //   762: istore_3
    //   763: goto -35 -> 728
    //   766: astore_1
    //   767: iconst_1
    //   768: istore_3
    //   769: goto -100 -> 669
    //   772: astore_1
    //   773: iload 6
    //   775: istore_3
    //   776: goto -244 -> 532
    //   779: astore_1
    //   780: goto -398 -> 382
    //   783: goto -255 -> 528
    //   786: goto -431 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	789	0	this	h
    //   0	789	1	paramString	String
    //   0	789	2	paramInt	int
    //   1	775	3	i	int
    //   41	685	4	j	int
    //   262	499	5	k	int
    //   253	521	6	m	int
    //   256	61	7	n	int
    //   141	407	8	l	long
    //   14	719	10	localObject	Object
    //   48	493	11	localFallback	Fallback
    //   98	644	12	str	String
    //   107	486	13	localStringBuilder	StringBuilder
    //   114	13	14	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   156	179	378	java/io/IOException
    //   182	190	378	java/io/IOException
    //   193	200	378	java/io/IOException
    //   203	214	378	java/io/IOException
    //   217	222	378	java/io/IOException
    //   225	233	378	java/io/IOException
    //   236	242	378	java/io/IOException
    //   245	249	378	java/io/IOException
    //   156	179	531	com/xiaomi/smack/l
    //   182	190	531	com/xiaomi/smack/l
    //   193	200	531	com/xiaomi/smack/l
    //   203	214	531	com/xiaomi/smack/l
    //   217	222	531	com/xiaomi/smack/l
    //   225	233	531	com/xiaomi/smack/l
    //   236	242	531	com/xiaomi/smack/l
    //   245	249	531	com/xiaomi/smack/l
    //   156	179	668	java/lang/Throwable
    //   182	190	668	java/lang/Throwable
    //   193	200	668	java/lang/Throwable
    //   203	214	668	java/lang/Throwable
    //   217	222	668	java/lang/Throwable
    //   225	233	668	java/lang/Throwable
    //   236	242	668	java/lang/Throwable
    //   245	249	668	java/lang/Throwable
    //   156	179	724	finally
    //   182	190	724	finally
    //   193	200	724	finally
    //   203	214	724	finally
    //   217	222	724	finally
    //   225	233	724	finally
    //   236	242	724	finally
    //   245	249	724	finally
    //   672	686	724	finally
    //   689	693	724	finally
    //   264	274	759	finally
    //   278	284	759	finally
    //   293	305	759	finally
    //   309	316	759	finally
    //   320	355	759	finally
    //   391	406	759	finally
    //   410	415	759	finally
    //   419	442	759	finally
    //   446	485	759	finally
    //   540	555	759	finally
    //   558	563	759	finally
    //   566	589	759	finally
    //   592	631	759	finally
    //   264	274	766	java/lang/Throwable
    //   278	284	766	java/lang/Throwable
    //   293	305	766	java/lang/Throwable
    //   309	316	766	java/lang/Throwable
    //   320	355	766	java/lang/Throwable
    //   264	274	772	com/xiaomi/smack/l
    //   278	284	772	com/xiaomi/smack/l
    //   293	305	772	com/xiaomi/smack/l
    //   309	316	772	com/xiaomi/smack/l
    //   320	355	772	com/xiaomi/smack/l
    //   264	274	779	java/io/IOException
    //   278	284	779	java/io/IOException
    //   293	305	779	java/io/IOException
    //   309	316	779	java/io/IOException
    //   320	355	779	java/io/IOException
  }
  
  /* Error */
  protected void a(int paramInt, Exception paramException)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 246	com/xiaomi/smack/h:m	()I
    //   6: istore_3
    //   7: iload_3
    //   8: iconst_2
    //   9: if_icmpne +6 -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: iconst_2
    //   17: iload_1
    //   18: aload_2
    //   19: invokevirtual 249	com/xiaomi/smack/h:a	(IILjava/lang/Exception;)V
    //   22: aload_0
    //   23: ldc -5
    //   25: putfield 254	com/xiaomi/smack/h:j	Ljava/lang/String;
    //   28: aload_0
    //   29: getfield 147	com/xiaomi/smack/h:p	Ljava/net/Socket;
    //   32: invokevirtual 257	java/net/Socket:close	()V
    //   35: aload_0
    //   36: lconst_0
    //   37: putfield 29	com/xiaomi/smack/h:s	J
    //   40: aload_0
    //   41: lconst_0
    //   42: putfield 31	com/xiaomi/smack/h:t	J
    //   45: goto -33 -> 12
    //   48: astore_2
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_2
    //   52: athrow
    //   53: astore_2
    //   54: goto -19 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	h
    //   0	57	1	paramInt	int
    //   0	57	2	paramException	Exception
    //   6	4	3	i	int
    // Exception table:
    //   from	to	target	type
    //   2	7	48	finally
    //   15	28	48	finally
    //   28	35	48	finally
    //   35	45	48	finally
    //   28	35	53	java/lang/Throwable
  }
  
  protected void a(Exception paramException)
  {
    if (SystemClock.elapsedRealtime() - this.u < 300000L)
    {
      if (com.xiaomi.channel.commonutils.network.d.d(this.r))
      {
        this.w += 1;
        if (this.w >= 2)
        {
          String str = d();
          com.xiaomi.channel.commonutils.logger.b.a("max short conn time reached, sink down current host:" + str);
          a(str, 0L, paramException);
          this.w = 0;
        }
      }
      return;
    }
    this.w = 0;
  }
  
  protected void a(String paramString, long paramLong, Exception paramException)
  {
    Object localObject = b.b();
    localObject = HostManager.getInstance().getFallbacksByHost((String)localObject, false);
    if (localObject != null)
    {
      ((Fallback)localObject).b(paramString, paramLong, 0L, paramException);
      HostManager.getInstance().persist();
    }
  }
  
  protected abstract void a(boolean paramBoolean);
  
  public void a(com.xiaomi.slim.b[] paramArrayOfb)
  {
    throw new l("Don't support send Blob");
  }
  
  public void a(com.xiaomi.smack.packet.d[] paramArrayOfd)
  {
    int j = paramArrayOfd.length;
    int i = 0;
    while (i < j)
    {
      a(paramArrayOfd[i]);
      i += 1;
    }
  }
  
  Fallback b(String paramString)
  {
    Fallback localFallback = HostManager.getInstance().getFallbacksByHost(paramString, false);
    if (!localFallback.b()) {
      e.a(new k(this, paramString));
    }
    this.f = 0;
    try
    {
      paramString = InetAddress.getByName(localFallback.f).getAddress();
      this.f = (paramString[0] & 0xFF);
      this.f |= paramString[1] << 8 & 0xFF00;
      this.f |= paramString[2] << 16 & 0xFF0000;
      int i = this.f;
      this.f = (paramString[3] << 24 & 0xFF000000 | i);
      return localFallback;
    }
    catch (UnknownHostException paramString) {}
    return localFallback;
  }
  
  protected void b() {}
  
  public void b(int paramInt, Exception paramException)
  {
    a(paramInt, paramException);
    if (((paramException != null) || (paramInt == 18)) && (this.u != 0L)) {
      a(paramException);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    a(paramBoolean);
    if (!paramBoolean) {
      this.r.a(new i(this, 13, l), 10000L);
    }
  }
  
  public void c(int paramInt, Exception paramException)
  {
    this.r.a(new j(this, 2, paramInt, paramException));
  }
  
  public String d()
  {
    return this.v;
  }
  
  public String q()
  {
    return this.j;
  }
  
  /* Error */
  public void r()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 345	com/xiaomi/smack/h:k	()Z
    //   6: ifne +10 -> 16
    //   9: aload_0
    //   10: invokevirtual 347	com/xiaomi/smack/h:j	()Z
    //   13: ifeq +12 -> 25
    //   16: ldc_w 349
    //   19: invokestatic 142	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: iconst_0
    //   27: iconst_0
    //   28: aconst_null
    //   29: invokevirtual 249	com/xiaomi/smack/h:a	(IILjava/lang/Exception;)V
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 352	com/xiaomi/smack/h:m	Lcom/xiaomi/smack/b;
    //   37: invokespecial 354	com/xiaomi/smack/h:a	(Lcom/xiaomi/smack/b;)V
    //   40: goto -18 -> 22
    //   43: astore_1
    //   44: new 55	com/xiaomi/smack/l
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 356	com/xiaomi/smack/l:<init>	(Ljava/lang/Throwable;)V
    //   52: athrow
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	h
    //   43	6	1	localIOException	java.io.IOException
    //   53	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	43	java/io/IOException
    //   16	22	43	java/io/IOException
    //   25	40	43	java/io/IOException
    //   2	16	53	finally
    //   16	22	53	finally
    //   25	40	53	finally
    //   44	53	53	finally
  }
  
  public Socket s()
  {
    return new Socket();
  }
  
  public void t()
  {
    this.s = SystemClock.elapsedRealtime();
  }
  
  public void u()
  {
    this.t = SystemClock.elapsedRealtime();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/smack/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */