package c.a.b;

import c.a.b.a.f;
import c.a.b.d.g;
import c.a.b.e.h;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class d
  implements a
{
  public static int a;
  public static boolean b;
  private static final Object v;
  public final BlockingQueue<ByteBuffer> c;
  public final BlockingQueue<ByteBuffer> d;
  public SelectionKey e;
  public ByteChannel f;
  private final e h;
  private volatile boolean i = false;
  private a.a j = a.a.a;
  private List<c.a.b.c.a> k;
  private c.a.b.c.a l = null;
  private a.b m;
  private c.a.b.e.a n = null;
  private ByteBuffer o = ByteBuffer.allocate(0);
  private c.a.b.a.a p = null;
  private String q = null;
  private Integer r = null;
  private Boolean s = null;
  private String t = null;
  private long u = System.currentTimeMillis();
  
  static
  {
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      g = bool;
      a = 16384;
      b = false;
      v = new Object();
      return;
    }
  }
  
  public d(e parame, c.a.b.c.a parama)
  {
    if ((parame == null) || ((parama == null) && (this.m == a.b.b))) {
      throw new IllegalArgumentException("parameters must not be null");
    }
    this.c = new LinkedBlockingQueue();
    this.d = new LinkedBlockingQueue();
    this.h = parame;
    this.m = a.b.a;
    if (parama != null) {
      this.l = parama.c();
    }
  }
  
  @Deprecated
  public d(e parame, c.a.b.c.a parama, Socket paramSocket)
  {
    this(parame, parama);
  }
  
  public d(e parame, List<c.a.b.c.a> paramList)
  {
    this(parame, (c.a.b.c.a)null);
    this.m = a.b.b;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.k = new ArrayList();
      this.k.add(new c.a.b.c.d());
      return;
    }
    this.k = paramList;
  }
  
  @Deprecated
  public d(e parame, List<c.a.b.c.a> paramList, Socket paramSocket)
  {
    this(parame, paramList);
  }
  
  private void a(f paramf)
  {
    if (b) {
      System.out.println("open using draft: " + this.l.getClass().getSimpleName());
    }
    this.j = a.a.c;
    try
    {
      this.h.onWebsocketOpen(this, paramf);
      return;
    }
    catch (RuntimeException paramf)
    {
      this.h.onWebsocketError(this, paramf);
    }
  }
  
  private void a(Collection<c.a.b.e.a> paramCollection)
  {
    if (!isOpen()) {
      throw new g();
    }
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      c.a.b.e.a locala = (c.a.b.e.a)paramCollection.next();
      if (b) {
        System.out.println("send frame: " + locala);
      }
      localArrayList.add(this.l.a(locala));
    }
    a(localArrayList);
  }
  
  private void a(List<ByteBuffer> paramList)
  {
    synchronized (v)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext()) {
        e((ByteBuffer)paramList.next());
      }
    }
  }
  
  /* Error */
  private boolean b(ByteBuffer paramByteBuffer)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 89	c/a/b/d:o	Ljava/nio/ByteBuffer;
    //   4: invokevirtual 262	java/nio/ByteBuffer:capacity	()I
    //   7: ifne +73 -> 80
    //   10: aload_1
    //   11: astore 4
    //   13: aload 4
    //   15: invokevirtual 266	java/nio/ByteBuffer:mark	()Ljava/nio/Buffer;
    //   18: pop
    //   19: aload_0
    //   20: getfield 79	c/a/b/d:l	Lc/a/b/c/a;
    //   23: ifnonnull +210 -> 233
    //   26: aload_0
    //   27: aload 4
    //   29: invokespecial 269	c/a/b/d:d	(Ljava/nio/ByteBuffer;)Lc/a/b/c/a$b;
    //   32: astore 5
    //   34: getstatic 274	c/a/b/c/a$b:a	Lc/a/b/c/a$b;
    //   37: astore 6
    //   39: aload 5
    //   41: aload 6
    //   43: if_acmpne +190 -> 233
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 129	c/a/b/d:h	Lc/a/b/e;
    //   51: aload_0
    //   52: invokeinterface 278 2 0
    //   57: invokestatic 283	c/a/b/b/c:a	(Ljava/lang/String;)[B
    //   60: invokestatic 287	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   63: invokestatic 293	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   66: invokespecial 245	c/a/b/d:a	(Ljava/util/List;)V
    //   69: aload_0
    //   70: bipush -3
    //   72: ldc_w 295
    //   75: invokevirtual 299	c/a/b/d:close	(ILjava/lang/String;)V
    //   78: iconst_0
    //   79: ireturn
    //   80: aload_0
    //   81: getfield 89	c/a/b/d:o	Ljava/nio/ByteBuffer;
    //   84: invokevirtual 302	java/nio/ByteBuffer:remaining	()I
    //   87: aload_1
    //   88: invokevirtual 302	java/nio/ByteBuffer:remaining	()I
    //   91: if_icmpge +44 -> 135
    //   94: aload_0
    //   95: getfield 89	c/a/b/d:o	Ljava/nio/ByteBuffer;
    //   98: invokevirtual 262	java/nio/ByteBuffer:capacity	()I
    //   101: aload_1
    //   102: invokevirtual 302	java/nio/ByteBuffer:remaining	()I
    //   105: iadd
    //   106: invokestatic 87	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   109: astore 4
    //   111: aload_0
    //   112: getfield 89	c/a/b/d:o	Ljava/nio/ByteBuffer;
    //   115: invokevirtual 305	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   118: pop
    //   119: aload 4
    //   121: aload_0
    //   122: getfield 89	c/a/b/d:o	Ljava/nio/ByteBuffer;
    //   125: invokevirtual 309	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   128: pop
    //   129: aload_0
    //   130: aload 4
    //   132: putfield 89	c/a/b/d:o	Ljava/nio/ByteBuffer;
    //   135: aload_0
    //   136: getfield 89	c/a/b/d:o	Ljava/nio/ByteBuffer;
    //   139: aload_1
    //   140: invokevirtual 309	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   143: pop
    //   144: aload_0
    //   145: getfield 89	c/a/b/d:o	Ljava/nio/ByteBuffer;
    //   148: invokevirtual 305	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   151: pop
    //   152: aload_0
    //   153: getfield 89	c/a/b/d:o	Ljava/nio/ByteBuffer;
    //   156: astore 4
    //   158: goto -145 -> 13
    //   161: astore 5
    //   163: aload_0
    //   164: sipush 1006
    //   167: ldc_w 311
    //   170: iconst_1
    //   171: invokespecial 314	c/a/b/d:c	(ILjava/lang/String;Z)V
    //   174: goto -96 -> 78
    //   177: astore 5
    //   179: aload_0
    //   180: getfield 89	c/a/b/d:o	Ljava/nio/ByteBuffer;
    //   183: invokevirtual 262	java/nio/ByteBuffer:capacity	()I
    //   186: ifne +606 -> 792
    //   189: aload 4
    //   191: invokevirtual 317	java/nio/ByteBuffer:reset	()Ljava/nio/Buffer;
    //   194: pop
    //   195: aload 5
    //   197: invokevirtual 320	c/a/b/d/a:getPreferedSize	()I
    //   200: istore_3
    //   201: iload_3
    //   202: ifne +559 -> 761
    //   205: aload 4
    //   207: invokevirtual 262	java/nio/ByteBuffer:capacity	()I
    //   210: bipush 16
    //   212: iadd
    //   213: istore_2
    //   214: aload_0
    //   215: iload_2
    //   216: invokestatic 87	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   219: putfield 89	c/a/b/d:o	Ljava/nio/ByteBuffer;
    //   222: aload_0
    //   223: getfield 89	c/a/b/d:o	Ljava/nio/ByteBuffer;
    //   226: aload_1
    //   227: invokevirtual 309	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   230: pop
    //   231: iconst_0
    //   232: ireturn
    //   233: aload_0
    //   234: getfield 109	c/a/b/d:m	Lc/a/b/a$b;
    //   237: getstatic 113	c/a/b/a$b:b	Lc/a/b/a$b;
    //   240: if_acmpne +314 -> 554
    //   243: aload_0
    //   244: getfield 79	c/a/b/d:l	Lc/a/b/c/a;
    //   247: ifnonnull +233 -> 480
    //   250: aload_0
    //   251: getfield 152	c/a/b/d:k	Ljava/util/List;
    //   254: invokeinterface 247 1 0
    //   259: astore 5
    //   261: aload 5
    //   263: invokeinterface 227 1 0
    //   268: ifeq +192 -> 460
    //   271: aload 5
    //   273: invokeinterface 231 1 0
    //   278: checkcast 133	c/a/b/c/a
    //   281: invokevirtual 136	c/a/b/c/a:c	()Lc/a/b/c/a;
    //   284: astore 6
    //   286: aload 6
    //   288: aload_0
    //   289: getfield 109	c/a/b/d:m	Lc/a/b/a$b;
    //   292: invokevirtual 323	c/a/b/c/a:a	(Lc/a/b/a$b;)V
    //   295: aload 4
    //   297: invokevirtual 317	java/nio/ByteBuffer:reset	()Ljava/nio/Buffer;
    //   300: pop
    //   301: aload 6
    //   303: aload 4
    //   305: invokevirtual 326	c/a/b/c/a:d	(Ljava/nio/ByteBuffer;)Lc/a/b/a/f;
    //   308: astore 7
    //   310: aload 7
    //   312: instanceof 328
    //   315: ifne +16 -> 331
    //   318: aload_0
    //   319: sipush 1002
    //   322: ldc_w 330
    //   325: iconst_0
    //   326: invokevirtual 332	c/a/b/d:b	(ILjava/lang/String;Z)V
    //   329: iconst_0
    //   330: ireturn
    //   331: aload 7
    //   333: checkcast 328	c/a/b/a/a
    //   336: astore 7
    //   338: aload 6
    //   340: aload 7
    //   342: invokevirtual 335	c/a/b/c/a:a	(Lc/a/b/a/a;)Lc/a/b/c/a$b;
    //   345: getstatic 274	c/a/b/c/a$b:a	Lc/a/b/c/a$b;
    //   348: if_acmpne -87 -> 261
    //   351: aload_0
    //   352: aload 7
    //   354: invokeinterface 337 1 0
    //   359: putfield 99	c/a/b/d:t	Ljava/lang/String;
    //   362: aload_0
    //   363: getfield 129	c/a/b/d:h	Lc/a/b/e;
    //   366: aload_0
    //   367: aload 6
    //   369: aload 7
    //   371: invokeinterface 341 4 0
    //   376: astore 8
    //   378: aload_0
    //   379: aload 6
    //   381: aload 6
    //   383: aload 7
    //   385: aload 8
    //   387: invokevirtual 344	c/a/b/c/a:a	(Lc/a/b/a/a;Lc/a/b/a/i;)Lc/a/b/a/c;
    //   390: aload_0
    //   391: getfield 109	c/a/b/d:m	Lc/a/b/a$b;
    //   394: invokevirtual 347	c/a/b/c/a:a	(Lc/a/b/a/f;Lc/a/b/a$b;)Ljava/util/List;
    //   397: invokespecial 245	c/a/b/d:a	(Ljava/util/List;)V
    //   400: aload_0
    //   401: aload 6
    //   403: putfield 79	c/a/b/d:l	Lc/a/b/c/a;
    //   406: aload_0
    //   407: aload 7
    //   409: invokespecial 349	c/a/b/d:a	(Lc/a/b/a/f;)V
    //   412: iconst_1
    //   413: ireturn
    //   414: astore 6
    //   416: aload_0
    //   417: aload 6
    //   419: invokevirtual 352	c/a/b/d/b:getCloseCode	()I
    //   422: aload 6
    //   424: invokevirtual 355	c/a/b/d/b:getMessage	()Ljava/lang/String;
    //   427: iconst_0
    //   428: invokevirtual 332	c/a/b/d:b	(ILjava/lang/String;Z)V
    //   431: iconst_0
    //   432: ireturn
    //   433: astore 6
    //   435: aload_0
    //   436: getfield 129	c/a/b/d:h	Lc/a/b/e;
    //   439: aload_0
    //   440: aload 6
    //   442: invokeinterface 209 3 0
    //   447: aload_0
    //   448: iconst_m1
    //   449: aload 6
    //   451: invokevirtual 356	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   454: iconst_0
    //   455: invokevirtual 332	c/a/b/d:b	(ILjava/lang/String;Z)V
    //   458: iconst_0
    //   459: ireturn
    //   460: aload_0
    //   461: getfield 79	c/a/b/d:l	Lc/a/b/c/a;
    //   464: ifnonnull +366 -> 830
    //   467: aload_0
    //   468: sipush 1002
    //   471: ldc_w 358
    //   474: invokevirtual 299	c/a/b/d:close	(ILjava/lang/String;)V
    //   477: goto +353 -> 830
    //   480: aload_0
    //   481: getfield 79	c/a/b/d:l	Lc/a/b/c/a;
    //   484: aload 4
    //   486: invokevirtual 326	c/a/b/c/a:d	(Ljava/nio/ByteBuffer;)Lc/a/b/a/f;
    //   489: astore 5
    //   491: aload 5
    //   493: instanceof 328
    //   496: ifne +16 -> 512
    //   499: aload_0
    //   500: sipush 1002
    //   503: ldc_w 330
    //   506: iconst_0
    //   507: invokevirtual 332	c/a/b/d:b	(ILjava/lang/String;Z)V
    //   510: iconst_0
    //   511: ireturn
    //   512: aload 5
    //   514: checkcast 328	c/a/b/a/a
    //   517: astore 5
    //   519: aload_0
    //   520: getfield 79	c/a/b/d:l	Lc/a/b/c/a;
    //   523: aload 5
    //   525: invokevirtual 335	c/a/b/c/a:a	(Lc/a/b/a/a;)Lc/a/b/c/a$b;
    //   528: getstatic 274	c/a/b/c/a$b:a	Lc/a/b/c/a$b;
    //   531: if_acmpne +11 -> 542
    //   534: aload_0
    //   535: aload 5
    //   537: invokespecial 349	c/a/b/d:a	(Lc/a/b/a/f;)V
    //   540: iconst_1
    //   541: ireturn
    //   542: aload_0
    //   543: sipush 1002
    //   546: ldc_w 360
    //   549: invokevirtual 299	c/a/b/d:close	(ILjava/lang/String;)V
    //   552: iconst_0
    //   553: ireturn
    //   554: aload_0
    //   555: getfield 109	c/a/b/d:m	Lc/a/b/a$b;
    //   558: getstatic 131	c/a/b/a$b:a	Lc/a/b/a$b;
    //   561: if_acmpne -330 -> 231
    //   564: aload_0
    //   565: getfield 79	c/a/b/d:l	Lc/a/b/c/a;
    //   568: aload_0
    //   569: getfield 109	c/a/b/d:m	Lc/a/b/a$b;
    //   572: invokevirtual 323	c/a/b/c/a:a	(Lc/a/b/a$b;)V
    //   575: aload_0
    //   576: getfield 79	c/a/b/d:l	Lc/a/b/c/a;
    //   579: aload 4
    //   581: invokevirtual 326	c/a/b/c/a:d	(Ljava/nio/ByteBuffer;)Lc/a/b/a/f;
    //   584: astore 5
    //   586: aload 5
    //   588: instanceof 362
    //   591: ifne +16 -> 607
    //   594: aload_0
    //   595: sipush 1002
    //   598: ldc_w 330
    //   601: iconst_0
    //   602: invokevirtual 332	c/a/b/d:b	(ILjava/lang/String;Z)V
    //   605: iconst_0
    //   606: ireturn
    //   607: aload 5
    //   609: checkcast 362	c/a/b/a/h
    //   612: astore 5
    //   614: aload_0
    //   615: getfield 79	c/a/b/d:l	Lc/a/b/c/a;
    //   618: aload_0
    //   619: getfield 91	c/a/b/d:p	Lc/a/b/a/a;
    //   622: aload 5
    //   624: invokevirtual 365	c/a/b/c/a:a	(Lc/a/b/a/a;Lc/a/b/a/h;)Lc/a/b/c/a$b;
    //   627: astore 6
    //   629: getstatic 274	c/a/b/c/a$b:a	Lc/a/b/c/a$b;
    //   632: astore 7
    //   634: aload 6
    //   636: aload 7
    //   638: if_acmpne +73 -> 711
    //   641: aload_0
    //   642: getfield 129	c/a/b/d:h	Lc/a/b/e;
    //   645: aload_0
    //   646: aload_0
    //   647: getfield 91	c/a/b/d:p	Lc/a/b/a/a;
    //   650: aload 5
    //   652: invokeinterface 369 4 0
    //   657: aload_0
    //   658: aload 5
    //   660: invokespecial 349	c/a/b/d:a	(Lc/a/b/a/f;)V
    //   663: iconst_1
    //   664: ireturn
    //   665: astore 5
    //   667: aload_0
    //   668: aload 5
    //   670: invokevirtual 352	c/a/b/d/b:getCloseCode	()I
    //   673: aload 5
    //   675: invokevirtual 355	c/a/b/d/b:getMessage	()Ljava/lang/String;
    //   678: iconst_0
    //   679: invokevirtual 332	c/a/b/d:b	(ILjava/lang/String;Z)V
    //   682: iconst_0
    //   683: ireturn
    //   684: astore 5
    //   686: aload_0
    //   687: getfield 129	c/a/b/d:h	Lc/a/b/e;
    //   690: aload_0
    //   691: aload 5
    //   693: invokeinterface 209 3 0
    //   698: aload_0
    //   699: iconst_m1
    //   700: aload 5
    //   702: invokevirtual 356	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   705: iconst_0
    //   706: invokevirtual 332	c/a/b/d:b	(ILjava/lang/String;Z)V
    //   709: iconst_0
    //   710: ireturn
    //   711: aload_0
    //   712: sipush 1002
    //   715: new 174	java/lang/StringBuilder
    //   718: dup
    //   719: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   722: ldc_w 371
    //   725: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: aload_0
    //   729: getfield 79	c/a/b/d:l	Lc/a/b/c/a;
    //   732: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   735: ldc_w 373
    //   738: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   744: invokevirtual 299	c/a/b/d:close	(ILjava/lang/String;)V
    //   747: goto -516 -> 231
    //   750: astore 5
    //   752: aload_0
    //   753: aload 5
    //   755: invokevirtual 376	c/a/b/d:a	(Lc/a/b/d/b;)V
    //   758: goto -527 -> 231
    //   761: iload_3
    //   762: istore_2
    //   763: getstatic 58	c/a/b/d:g	Z
    //   766: ifne -552 -> 214
    //   769: iload_3
    //   770: istore_2
    //   771: aload 5
    //   773: invokevirtual 320	c/a/b/d/a:getPreferedSize	()I
    //   776: aload 4
    //   778: invokevirtual 302	java/nio/ByteBuffer:remaining	()I
    //   781: if_icmpge -567 -> 214
    //   784: new 378	java/lang/AssertionError
    //   787: dup
    //   788: invokespecial 379	java/lang/AssertionError:<init>	()V
    //   791: athrow
    //   792: aload_0
    //   793: getfield 89	c/a/b/d:o	Ljava/nio/ByteBuffer;
    //   796: aload_0
    //   797: getfield 89	c/a/b/d:o	Ljava/nio/ByteBuffer;
    //   800: invokevirtual 382	java/nio/ByteBuffer:limit	()I
    //   803: invokevirtual 386	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   806: pop
    //   807: aload_0
    //   808: getfield 89	c/a/b/d:o	Ljava/nio/ByteBuffer;
    //   811: aload_0
    //   812: getfield 89	c/a/b/d:o	Ljava/nio/ByteBuffer;
    //   815: invokevirtual 262	java/nio/ByteBuffer:capacity	()I
    //   818: invokevirtual 388	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   821: pop
    //   822: goto -591 -> 231
    //   825: astore 6
    //   827: goto -566 -> 261
    //   830: iconst_0
    //   831: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	832	0	this	d
    //   0	832	1	paramByteBuffer	ByteBuffer
    //   213	558	2	i1	int
    //   200	570	3	i2	int
    //   11	766	4	localByteBuffer	ByteBuffer
    //   32	8	5	localb1	c.a.b.c.a.b
    //   161	1	5	localb2	c.a.b.d.b
    //   177	19	5	locala	c.a.b.d.a
    //   259	400	5	localObject1	Object
    //   665	9	5	localb3	c.a.b.d.b
    //   684	17	5	localRuntimeException1	RuntimeException
    //   750	22	5	locald1	c.a.b.d.d
    //   37	365	6	localObject2	Object
    //   414	9	6	localb4	c.a.b.d.b
    //   433	17	6	localRuntimeException2	RuntimeException
    //   627	8	6	localb5	c.a.b.c.a.b
    //   825	1	6	locald2	c.a.b.d.d
    //   308	329	7	localObject3	Object
    //   376	10	8	locali	c.a.b.a.i
    // Exception table:
    //   from	to	target	type
    //   46	78	161	c/a/b/d/b
    //   19	39	177	c/a/b/d/a
    //   46	78	177	c/a/b/d/a
    //   163	174	177	c/a/b/d/a
    //   233	261	177	c/a/b/d/a
    //   261	286	177	c/a/b/d/a
    //   286	329	177	c/a/b/d/a
    //   331	362	177	c/a/b/d/a
    //   362	378	177	c/a/b/d/a
    //   378	412	177	c/a/b/d/a
    //   416	431	177	c/a/b/d/a
    //   435	458	177	c/a/b/d/a
    //   460	477	177	c/a/b/d/a
    //   480	510	177	c/a/b/d/a
    //   512	540	177	c/a/b/d/a
    //   542	552	177	c/a/b/d/a
    //   554	605	177	c/a/b/d/a
    //   607	634	177	c/a/b/d/a
    //   641	657	177	c/a/b/d/a
    //   657	663	177	c/a/b/d/a
    //   667	682	177	c/a/b/d/a
    //   686	709	177	c/a/b/d/a
    //   711	747	177	c/a/b/d/a
    //   752	758	177	c/a/b/d/a
    //   362	378	414	c/a/b/d/b
    //   362	378	433	java/lang/RuntimeException
    //   641	657	665	c/a/b/d/b
    //   641	657	684	java/lang/RuntimeException
    //   233	261	750	c/a/b/d/d
    //   261	286	750	c/a/b/d/d
    //   460	477	750	c/a/b/d/d
    //   480	510	750	c/a/b/d/d
    //   512	540	750	c/a/b/d/d
    //   542	552	750	c/a/b/d/d
    //   554	605	750	c/a/b/d/d
    //   607	634	750	c/a/b/d/d
    //   641	657	750	c/a/b/d/d
    //   657	663	750	c/a/b/d/d
    //   667	682	750	c/a/b/d/d
    //   686	709	750	c/a/b/d/d
    //   711	747	750	c/a/b/d/d
    //   286	329	825	c/a/b/d/d
    //   331	362	825	c/a/b/d/d
    //   362	378	825	c/a/b/d/d
    //   378	412	825	c/a/b/d/d
    //   416	431	825	c/a/b/d/d
    //   435	458	825	c/a/b/d/d
  }
  
  private void c(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.j != a.a.d) && (this.j != a.a.e))
    {
      if (this.j != a.a.c) {
        break label215;
      }
      if (paramInt == 1006)
      {
        if ((!g) && (paramBoolean)) {
          throw new AssertionError();
        }
        this.j = a.a.d;
        b(paramInt, paramString, false);
      }
    }
    else
    {
      return;
    }
    if ((this.l.b() == c.a.b.c.a.a.a) || (!paramBoolean)) {}
    for (;;)
    {
      try
      {
        this.h.onWebsocketCloseInitiated(this, paramInt, paramString);
        localc = new c.a.b.e.c();
        localc.a(paramString);
        localc.a(paramInt);
      }
      catch (RuntimeException localRuntimeException)
      {
        try
        {
          c.a.b.e.c localc;
          localc.c();
          sendFrame(localc);
          b(paramInt, paramString, paramBoolean);
          if (paramInt == 1002) {
            b(paramInt, paramString, paramBoolean);
          }
          this.j = a.a.d;
          this.o = null;
          return;
        }
        catch (c.a.b.d.b localb2)
        {
          throw localb2;
        }
        localRuntimeException = localRuntimeException;
        this.h.onWebsocketError(this, localRuntimeException);
        continue;
      }
      catch (c.a.b.d.b localb1)
      {
        this.h.onWebsocketError(this, localb1);
        b(1006, "generated frame is invalid", false);
        continue;
      }
      label215:
      if (paramInt == -3)
      {
        if ((!g) && (!paramBoolean)) {
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
      c.a.b.e.a.a locala1;
      boolean bool;
      int i1;
      try
      {
        Iterator localIterator = this.l.c(paramByteBuffer).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        paramByteBuffer = (c.a.b.e.a)localIterator.next();
        if (b) {
          System.out.println("matched frame: " + paramByteBuffer);
        }
        locala1 = paramByteBuffer.j();
        bool = paramByteBuffer.e();
        if (this.j == a.a.d) {
          return;
        }
        if (locala1 != c.a.b.e.a.a.f) {
          break label195;
        }
        if (!(paramByteBuffer instanceof c.a.b.e.c)) {
          break label695;
        }
        paramByteBuffer = (c.a.b.e.c)paramByteBuffer;
        i1 = paramByteBuffer.a();
        paramByteBuffer = paramByteBuffer.b();
        if (this.j == a.a.d)
        {
          a(i1, paramByteBuffer, true);
          continue;
        }
        if (this.l.b() != c.a.b.c.a.a.c) {
          break label185;
        }
      }
      catch (c.a.b.d.b paramByteBuffer)
      {
        this.h.onWebsocketError(this, paramByteBuffer);
        a(paramByteBuffer);
        return;
      }
      c(i1, paramByteBuffer, true);
      continue;
      label185:
      b(i1, paramByteBuffer, false);
      continue;
      label195:
      if (locala1 == c.a.b.e.a.a.d)
      {
        this.h.onWebsocketPing(this, paramByteBuffer);
      }
      else if (locala1 == c.a.b.e.a.a.e)
      {
        this.u = System.currentTimeMillis();
        this.h.onWebsocketPong(this, paramByteBuffer);
      }
      else if ((!bool) || (locala1 == c.a.b.e.a.a.a))
      {
        if (locala1 != c.a.b.e.a.a.a)
        {
          if (this.n != null) {
            throw new c.a.b.d.b(1002, "Previous continuous frame sequence not completed.");
          }
          this.n = paramByteBuffer;
        }
        while ((locala1 == c.a.b.e.a.a.b) && (!c.a.b.b.c.b(paramByteBuffer.d())))
        {
          throw new c.a.b.d.b(1007);
          if (bool)
          {
            if (this.n == null) {
              throw new c.a.b.d.b(1002, "Continuous frame sequence was not started.");
            }
            if (this.n.j() == c.a.b.e.a.a.b)
            {
              i1 = Math.max(this.n.d().limit() - 64, 0);
              this.n.a(paramByteBuffer);
              if (!c.a.b.b.c.a(this.n.d(), i1)) {
                throw new c.a.b.d.b(1007);
              }
            }
            this.n = null;
          }
          else if (this.n == null)
          {
            throw new c.a.b.d.b(1002, "Continuous frame sequence was not started.");
          }
        }
        if ((locala1 == c.a.b.e.a.a.a) && (this.n != null) && (this.n.j() == c.a.b.e.a.a.b))
        {
          i1 = Math.max(this.n.d().limit() - 64, 0);
          this.n.a(paramByteBuffer);
          if (!c.a.b.b.c.a(this.n.d(), i1)) {
            throw new c.a.b.d.b(1007);
          }
        }
        try
        {
          this.h.onWebsocketMessageFragment(this, paramByteBuffer);
        }
        catch (RuntimeException paramByteBuffer)
        {
          this.h.onWebsocketError(this, paramByteBuffer);
        }
      }
      else
      {
        if (this.n != null) {
          throw new c.a.b.d.b(1002, "Continuous frame sequence not completed.");
        }
        c.a.b.e.a.a locala2 = c.a.b.e.a.a.b;
        if (locala1 == locala2)
        {
          try
          {
            this.h.onWebsocketMessage(this, c.a.b.b.c.a(paramByteBuffer.d()));
          }
          catch (RuntimeException paramByteBuffer)
          {
            this.h.onWebsocketError(this, paramByteBuffer);
          }
        }
        else
        {
          locala2 = c.a.b.e.a.a.c;
          if (locala1 == locala2)
          {
            try
            {
              this.h.onWebsocketMessage(this, paramByteBuffer.d());
            }
            catch (RuntimeException paramByteBuffer)
            {
              this.h.onWebsocketError(this, paramByteBuffer);
            }
          }
          else
          {
            throw new c.a.b.d.b(1002, "non control or continious frame expected");
            label695:
            paramByteBuffer = "";
            i1 = 1005;
          }
        }
      }
    }
  }
  
  private c.a.b.c.a.b d(ByteBuffer paramByteBuffer)
    throws c.a.b.d.a
  {
    paramByteBuffer.mark();
    if (paramByteBuffer.limit() > c.a.b.c.a.c.length) {
      return c.a.b.c.a.b.b;
    }
    if (paramByteBuffer.limit() < c.a.b.c.a.c.length) {
      throw new c.a.b.d.a(c.a.b.c.a.c.length);
    }
    int i1 = 0;
    while (paramByteBuffer.hasRemaining())
    {
      if (c.a.b.c.a.c[i1] != paramByteBuffer.get())
      {
        paramByteBuffer.reset();
        return c.a.b.c.a.b.b;
      }
      i1 += 1;
    }
    return c.a.b.c.a.b.a;
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
      this.c.add(paramByteBuffer);
      this.h.onWriteDemand(this);
      return;
    }
  }
  
  public void a()
  {
    if (this.s == null) {
      throw new IllegalStateException("this method must be used in conjuction with flushAndClose");
    }
    a(this.r.intValue(), this.q, this.s.booleanValue());
  }
  
  /* Error */
  protected void a(int paramInt, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 77	c/a/b/d:j	Lc/a/b/a$a;
    //   6: astore 4
    //   8: getstatic 392	c/a/b/a$a:e	Lc/a/b/a$a;
    //   11: astore 5
    //   13: aload 4
    //   15: aload 5
    //   17: if_acmpne +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 561	c/a/b/d:e	Ljava/nio/channels/SelectionKey;
    //   27: ifnull +10 -> 37
    //   30: aload_0
    //   31: getfield 561	c/a/b/d:e	Ljava/nio/channels/SelectionKey;
    //   34: invokevirtual 566	java/nio/channels/SelectionKey:cancel	()V
    //   37: aload_0
    //   38: getfield 568	c/a/b/d:f	Ljava/nio/channels/ByteChannel;
    //   41: astore 4
    //   43: aload 4
    //   45: ifnull +12 -> 57
    //   48: aload_0
    //   49: getfield 568	c/a/b/d:f	Ljava/nio/channels/ByteChannel;
    //   52: invokeinterface 572 1 0
    //   57: aload_0
    //   58: getfield 129	c/a/b/d:h	Lc/a/b/e;
    //   61: aload_0
    //   62: iload_1
    //   63: aload_2
    //   64: iload_3
    //   65: invokeinterface 576 5 0
    //   70: aload_0
    //   71: getfield 79	c/a/b/d:l	Lc/a/b/c/a;
    //   74: ifnull +10 -> 84
    //   77: aload_0
    //   78: getfield 79	c/a/b/d:l	Lc/a/b/c/a;
    //   81: invokevirtual 578	c/a/b/c/a:a	()V
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 91	c/a/b/d:p	Lc/a/b/a/a;
    //   89: aload_0
    //   90: getstatic 392	c/a/b/a$a:e	Lc/a/b/a$a;
    //   93: putfield 77	c/a/b/d:j	Lc/a/b/a$a;
    //   96: aload_0
    //   97: getfield 125	c/a/b/d:c	Ljava/util/concurrent/BlockingQueue;
    //   100: invokeinterface 581 1 0
    //   105: goto -85 -> 20
    //   108: astore_2
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_2
    //   112: athrow
    //   113: astore 4
    //   115: aload_0
    //   116: getfield 129	c/a/b/d:h	Lc/a/b/e;
    //   119: aload_0
    //   120: aload 4
    //   122: invokeinterface 209 3 0
    //   127: goto -70 -> 57
    //   130: astore_2
    //   131: aload_0
    //   132: getfield 129	c/a/b/d:h	Lc/a/b/e;
    //   135: aload_0
    //   136: aload_2
    //   137: invokeinterface 209 3 0
    //   142: goto -72 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	d
    //   0	145	1	paramInt	int
    //   0	145	2	paramString	String
    //   0	145	3	paramBoolean	boolean
    //   6	38	4	localObject	Object
    //   113	8	4	localIOException	java.io.IOException
    //   11	5	5	locala	a.a
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
  
  public void a(c.a.b.a.b paramb)
    throws c.a.b.d.d
  {
    if ((!g) && (this.j == a.a.b)) {
      throw new AssertionError("shall only be called once");
    }
    this.p = this.l.a(paramb);
    this.t = paramb.a();
    if ((!g) && (this.t == null)) {
      throw new AssertionError();
    }
    try
    {
      this.h.onWebsocketHandshakeSentAsClient(this, this.p);
      a(this.l.a(this.p, this.m));
      return;
    }
    catch (c.a.b.d.b paramb)
    {
      throw new c.a.b.d.d("Handshake data rejected by client.");
    }
    catch (RuntimeException paramb)
    {
      this.h.onWebsocketError(this, paramb);
      throw new c.a.b.d.d("rejected because of" + paramb);
    }
  }
  
  public void a(c.a.b.d.b paramb)
  {
    c(paramb.getCloseCode(), paramb.getMessage(), false);
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    if ((!g) && (!paramByteBuffer.hasRemaining())) {
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
      if (this.j == a.a.a) {
        break label175;
      }
      if (this.j == a.a.c) {
        c(paramByteBuffer);
      }
    }
    for (;;)
    {
      if ((g) || (isClosing()) || (isFlushAndClose()) || (!paramByteBuffer.hasRemaining())) {
        return;
      }
      throw new AssertionError();
      str = new String(paramByteBuffer.array(), paramByteBuffer.position(), paramByteBuffer.remaining());
      break;
      label175:
      if (b(paramByteBuffer))
      {
        if ((!g) && (this.o.hasRemaining() == paramByteBuffer.hasRemaining()) && (paramByteBuffer.hasRemaining())) {
          throw new AssertionError();
        }
        if (paramByteBuffer.hasRemaining()) {
          c(paramByteBuffer);
        } else if (this.o.hasRemaining()) {
          c(this.o);
        }
      }
    }
  }
  
  public void b()
  {
    if (getReadyState() == a.a.a)
    {
      a(-1, true);
      return;
    }
    if (this.i)
    {
      a(this.r.intValue(), this.q, this.s.booleanValue());
      return;
    }
    if (this.l.b() == c.a.b.c.a.a.a)
    {
      a(1000, true);
      return;
    }
    if (this.l.b() == c.a.b.c.a.a.b)
    {
      if (this.m == a.b.b)
      {
        a(1006, true);
        return;
      }
      a(1000, true);
      return;
    }
    a(1006, true);
  }
  
  /* Error */
  protected void b(int paramInt, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 71	c/a/b/d:i	Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: iload_1
    //   18: invokestatic 633	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: putfield 95	c/a/b/d:r	Ljava/lang/Integer;
    //   24: aload_0
    //   25: aload_2
    //   26: putfield 93	c/a/b/d:q	Ljava/lang/String;
    //   29: aload_0
    //   30: iload_3
    //   31: invokestatic 636	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   34: putfield 97	c/a/b/d:s	Ljava/lang/Boolean;
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 71	c/a/b/d:i	Z
    //   42: aload_0
    //   43: getfield 129	c/a/b/d:h	Lc/a/b/e;
    //   46: aload_0
    //   47: invokeinterface 533 2 0
    //   52: aload_0
    //   53: getfield 129	c/a/b/d:h	Lc/a/b/e;
    //   56: aload_0
    //   57: iload_1
    //   58: aload_2
    //   59: iload_3
    //   60: invokeinterface 639 5 0
    //   65: aload_0
    //   66: getfield 79	c/a/b/d:l	Lc/a/b/c/a;
    //   69: ifnull +10 -> 79
    //   72: aload_0
    //   73: getfield 79	c/a/b/d:l	Lc/a/b/c/a;
    //   76: invokevirtual 578	c/a/b/c/a:a	()V
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 91	c/a/b/d:p	Lc/a/b/a/a;
    //   84: goto -71 -> 13
    //   87: astore_2
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_2
    //   91: athrow
    //   92: astore_2
    //   93: aload_0
    //   94: getfield 129	c/a/b/d:h	Lc/a/b/e;
    //   97: aload_0
    //   98: aload_2
    //   99: invokeinterface 209 3 0
    //   104: goto -39 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	d
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
  
  long c()
  {
    return this.u;
  }
  
  public void close()
  {
    close(1000);
  }
  
  public void close(int paramInt)
  {
    c(paramInt, "", false);
  }
  
  public void close(int paramInt, String paramString)
  {
    c(paramInt, paramString, false);
  }
  
  public void closeConnection(int paramInt, String paramString)
  {
    a(paramInt, paramString, false);
  }
  
  public c.a.b.c.a getDraft()
  {
    return this.l;
  }
  
  public InetSocketAddress getLocalSocketAddress()
  {
    return this.h.getLocalSocketAddress(this);
  }
  
  public a.a getReadyState()
  {
    return this.j;
  }
  
  public InetSocketAddress getRemoteSocketAddress()
  {
    return this.h.getRemoteSocketAddress(this);
  }
  
  public String getResourceDescriptor()
  {
    return this.t;
  }
  
  public boolean hasBufferedData()
  {
    return !this.c.isEmpty();
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public boolean isClosed()
  {
    return this.j == a.a.e;
  }
  
  public boolean isClosing()
  {
    return this.j == a.a.d;
  }
  
  public boolean isConnecting()
  {
    if ((!g) && (this.i) && (this.j != a.a.b)) {
      throw new AssertionError();
    }
    return this.j == a.a.b;
  }
  
  public boolean isFlushAndClose()
  {
    return this.i;
  }
  
  public boolean isOpen()
  {
    if ((!g) && (this.j == a.a.c) && (this.i)) {
      throw new AssertionError();
    }
    return this.j == a.a.c;
  }
  
  public void send(String paramString)
    throws g
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
    }
    c.a.b.c.a locala = this.l;
    if (this.m == a.b.a) {}
    for (boolean bool = true;; bool = false)
    {
      a(locala.a(paramString, bool));
      return;
    }
  }
  
  public void send(ByteBuffer paramByteBuffer)
    throws IllegalArgumentException, g
  {
    if (paramByteBuffer == null) {
      throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
    }
    c.a.b.c.a locala = this.l;
    if (this.m == a.b.a) {}
    for (boolean bool = true;; bool = false)
    {
      a(locala.a(paramByteBuffer, bool));
      return;
    }
  }
  
  public void send(byte[] paramArrayOfByte)
    throws IllegalArgumentException, g
  {
    send(ByteBuffer.wrap(paramArrayOfByte));
  }
  
  public void sendFragmentedFrame(c.a.b.e.a.a parama, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    a(this.l.a(parama, paramByteBuffer, paramBoolean));
  }
  
  public void sendFrame(c.a.b.e.a parama)
  {
    a(Collections.singletonList(parama));
  }
  
  public void sendPing()
    throws NotYetConnectedException
  {
    sendFrame(new h());
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/c/a/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */