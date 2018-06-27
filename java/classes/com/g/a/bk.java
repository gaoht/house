package com.g.a;

import android.content.Context;
import java.io.File;
import java.io.FileDescriptor;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.CRC32;

public class bk
{
  private static bk b;
  Lock a = new ReentrantLock();
  private ExecutorService c;
  private bj d;
  private HashMap e;
  private CRC32 f;
  private Map g;
  private Map h;
  
  private bk()
  {
    b();
    this.d = null;
    this.e = new HashMap();
    a[] arrayOfa = a.c;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      this.e.put(Integer.valueOf(locala.c()), new TreeSet());
      i += 1;
    }
    this.c = Executors.newSingleThreadExecutor();
    this.f = new CRC32();
  }
  
  public static bk a()
  {
    try
    {
      if (b == null) {
        b = new bk();
      }
      return b;
    }
    finally {}
  }
  
  private void a(File paramFile)
  {
    try
    {
      if (c(paramFile) > 6) {
        b(paramFile);
      }
      return;
    }
    catch (Throwable paramFile)
    {
      av.postSDKError(paramFile);
    }
  }
  
  private void b()
  {
    File localFile1 = c.e.getFilesDir();
    this.g = new HashMap();
    this.h = new HashMap();
    try
    {
      a[] arrayOfa = a.c;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        a locala = arrayOfa[i];
        File localFile2 = new File(localFile1, "td_database" + locala.c() + "SaaS");
        if (!localFile2.exists()) {
          localFile2.mkdir();
        }
        localFile2 = new File(localFile1, "Lock" + locala.c());
        this.g.put(new Integer(locala.c()), new RandomAccessFile(localFile2, "rw"));
        i += 1;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
  }
  
  private void b(File paramFile)
  {
    try
    {
      if (paramFile.isDirectory())
      {
        b((File)d(paramFile).get(0));
        return;
      }
      paramFile.delete();
      return;
    }
    catch (Throwable paramFile)
    {
      av.postSDKError(paramFile);
    }
  }
  
  private int c(File paramFile)
  {
    long l1 = 0L;
    if (paramFile == null) {
      return 0;
    }
    for (;;)
    {
      int i;
      long l2;
      try
      {
        if (!paramFile.isDirectory()) {
          return 0;
        }
        paramFile = paramFile.listFiles();
        int j = paramFile.length;
        i = 0;
        if (i < j)
        {
          Object localObject = paramFile[i];
          l2 = l1;
          if (((File)localObject).isFile()) {
            l2 = l1 + ((File)localObject).length();
          }
        }
        else
        {
          l1 /= 1048576L;
          return (int)l1;
        }
      }
      catch (Throwable paramFile)
      {
        av.postSDKError(paramFile);
        return 0;
      }
      i += 1;
      l1 = l2;
    }
  }
  
  private List d(File paramFile)
  {
    paramFile = Arrays.asList(paramFile.listFiles());
    try
    {
      Collections.sort(paramFile, new bl(this));
      return paramFile;
    }
    catch (Throwable localThrowable) {}
    return paramFile;
  }
  
  /* Error */
  public List a(a parama, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 206	java/util/LinkedList
    //   5: dup
    //   6: invokespecial 207	java/util/LinkedList:<init>	()V
    //   9: astore 11
    //   11: new 117	java/io/File
    //   14: dup
    //   15: getstatic 105	com/g/a/c:e	Landroid/content/Context;
    //   18: invokevirtual 111	android/content/Context:getFilesDir	()Ljava/io/File;
    //   21: new 119	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   28: ldc 122
    //   30: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 51	com/g/a/a:c	()I
    //   37: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: ldc -125
    //   42: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 138	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   51: astore 12
    //   53: aload 12
    //   55: invokevirtual 142	java/io/File:exists	()Z
    //   58: ifne +31 -> 89
    //   61: new 119	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   68: ldc -47
    //   70: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload 12
    //   75: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 218	com/g/a/h:iForDeveloper	(Ljava/lang/String;)V
    //   84: aload_0
    //   85: monitorexit
    //   86: aload 11
    //   88: areturn
    //   89: aload 12
    //   91: invokevirtual 222	java/io/File:list	()[Ljava/lang/String;
    //   94: astore 13
    //   96: aload 13
    //   98: ifnull -14 -> 84
    //   101: aload 13
    //   103: arraylength
    //   104: ifle -20 -> 84
    //   107: iload_2
    //   108: istore_3
    //   109: aload 13
    //   111: arraylength
    //   112: iload_2
    //   113: if_icmpge +7 -> 120
    //   116: aload 13
    //   118: arraylength
    //   119: istore_3
    //   120: iconst_0
    //   121: istore_2
    //   122: aconst_null
    //   123: astore 6
    //   125: aconst_null
    //   126: astore 8
    //   128: aconst_null
    //   129: astore 5
    //   131: iload_2
    //   132: iload_3
    //   133: if_icmpge -49 -> 84
    //   136: new 117	java/io/File
    //   139: dup
    //   140: aload 12
    //   142: aload 13
    //   144: iload_2
    //   145: aaload
    //   146: invokespecial 138	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   149: astore 9
    //   151: new 224	com/g/a/bj
    //   154: dup
    //   155: aload 13
    //   157: iload_2
    //   158: aaload
    //   159: invokespecial 226	com/g/a/bj:<init>	(Ljava/lang/String;)V
    //   162: astore 7
    //   164: new 152	java/io/RandomAccessFile
    //   167: dup
    //   168: aload 9
    //   170: ldc -102
    //   172: invokespecial 155	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   175: astore 5
    //   177: aload 6
    //   179: astore 10
    //   181: aload 5
    //   183: astore 9
    //   185: aload 6
    //   187: astore 8
    //   189: aload 5
    //   191: invokevirtual 230	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   194: invokevirtual 236	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   197: astore 6
    //   199: aload 6
    //   201: ifnonnull +106 -> 307
    //   204: aload 6
    //   206: astore 10
    //   208: aload 5
    //   210: astore 9
    //   212: aload 6
    //   214: astore 8
    //   216: aload 5
    //   218: invokevirtual 239	java/io/RandomAccessFile:close	()V
    //   221: aload 6
    //   223: astore 8
    //   225: aload 6
    //   227: ifnull +15 -> 242
    //   230: aload 6
    //   232: astore 9
    //   234: aload 6
    //   236: invokevirtual 244	java/nio/channels/FileLock:release	()V
    //   239: aconst_null
    //   240: astore 8
    //   242: aload 5
    //   244: astore 6
    //   246: aload 5
    //   248: ifnull +15 -> 263
    //   251: aload 8
    //   253: astore 9
    //   255: aload 5
    //   257: invokevirtual 239	java/io/RandomAccessFile:close	()V
    //   260: aconst_null
    //   261: astore 6
    //   263: aload 7
    //   265: astore 5
    //   267: aload 6
    //   269: astore 7
    //   271: aload 8
    //   273: astore 6
    //   275: iload_2
    //   276: iconst_1
    //   277: iadd
    //   278: istore_2
    //   279: aload 7
    //   281: astore 8
    //   283: goto -152 -> 131
    //   286: astore 6
    //   288: aload 9
    //   290: astore 6
    //   292: aload 5
    //   294: astore 8
    //   296: aload 7
    //   298: astore 5
    //   300: aload 8
    //   302: astore 7
    //   304: goto -29 -> 275
    //   307: aload 6
    //   309: astore 10
    //   311: aload 5
    //   313: astore 9
    //   315: aload 6
    //   317: astore 8
    //   319: aload 5
    //   321: lconst_1
    //   322: invokevirtual 248	java/io/RandomAccessFile:seek	(J)V
    //   325: aload 6
    //   327: astore 10
    //   329: aload 5
    //   331: astore 9
    //   333: aload 6
    //   335: astore 8
    //   337: aload 5
    //   339: invokevirtual 251	java/io/RandomAccessFile:readInt	()I
    //   342: istore 4
    //   344: aload 6
    //   346: astore 10
    //   348: aload 5
    //   350: astore 9
    //   352: aload 6
    //   354: astore 8
    //   356: aload 5
    //   358: invokevirtual 251	java/io/RandomAccessFile:readInt	()I
    //   361: newarray <illegal type>
    //   363: astore 14
    //   365: aload 6
    //   367: astore 10
    //   369: aload 5
    //   371: astore 9
    //   373: aload 6
    //   375: astore 8
    //   377: aload 5
    //   379: aload 14
    //   381: invokevirtual 255	java/io/RandomAccessFile:readFully	([B)V
    //   384: aload 6
    //   386: astore 10
    //   388: aload 5
    //   390: astore 9
    //   392: aload 6
    //   394: astore 8
    //   396: aload_0
    //   397: getfield 77	com/g/a/bk:f	Ljava/util/zip/CRC32;
    //   400: invokevirtual 258	java/util/zip/CRC32:reset	()V
    //   403: aload 6
    //   405: astore 10
    //   407: aload 5
    //   409: astore 9
    //   411: aload 6
    //   413: astore 8
    //   415: aload_0
    //   416: getfield 77	com/g/a/bk:f	Ljava/util/zip/CRC32;
    //   419: aload 14
    //   421: invokevirtual 261	java/util/zip/CRC32:update	([B)V
    //   424: aload 6
    //   426: astore 10
    //   428: aload 5
    //   430: astore 9
    //   432: aload 6
    //   434: astore 8
    //   436: iload 4
    //   438: aload_0
    //   439: getfield 77	com/g/a/bk:f	Ljava/util/zip/CRC32;
    //   442: invokevirtual 264	java/util/zip/CRC32:getValue	()J
    //   445: l2i
    //   446: if_icmpne +240 -> 686
    //   449: aload 14
    //   451: ifnull +105 -> 556
    //   454: aload 6
    //   456: astore 10
    //   458: aload 5
    //   460: astore 9
    //   462: aload 6
    //   464: astore 8
    //   466: aload 11
    //   468: aload 14
    //   470: invokeinterface 268 2 0
    //   475: pop
    //   476: aload 6
    //   478: astore 10
    //   480: aload 5
    //   482: astore 9
    //   484: aload 6
    //   486: astore 8
    //   488: aload_0
    //   489: aload 7
    //   491: aload_1
    //   492: invokevirtual 271	com/g/a/bk:a	(Lcom/g/a/bj;Lcom/g/a/a;)V
    //   495: aload 6
    //   497: astore 8
    //   499: aload 6
    //   501: ifnull +15 -> 516
    //   504: aload 6
    //   506: astore 9
    //   508: aload 6
    //   510: invokevirtual 244	java/nio/channels/FileLock:release	()V
    //   513: aconst_null
    //   514: astore 8
    //   516: aload 5
    //   518: astore 6
    //   520: aload 5
    //   522: ifnull +15 -> 537
    //   525: aload 8
    //   527: astore 9
    //   529: aload 5
    //   531: invokevirtual 239	java/io/RandomAccessFile:close	()V
    //   534: aconst_null
    //   535: astore 6
    //   537: aload 6
    //   539: astore 9
    //   541: aload 7
    //   543: astore 5
    //   545: aload 8
    //   547: astore 6
    //   549: aload 9
    //   551: astore 7
    //   553: goto -278 -> 275
    //   556: aload 6
    //   558: astore 10
    //   560: aload 5
    //   562: astore 9
    //   564: aload 6
    //   566: astore 8
    //   568: aload_0
    //   569: getfield 72	com/g/a/bk:c	Ljava/util/concurrent/ExecutorService;
    //   572: new 9	com/g/a/bk$b
    //   575: dup
    //   576: aload_0
    //   577: aload 7
    //   579: aload_1
    //   580: invokespecial 274	com/g/a/bk$b:<init>	(Lcom/g/a/bk;Lcom/g/a/bj;Lcom/g/a/a;)V
    //   583: invokeinterface 280 2 0
    //   588: goto -93 -> 495
    //   591: astore 6
    //   593: aload 10
    //   595: astore 6
    //   597: aload 5
    //   599: astore 9
    //   601: aload 6
    //   603: astore 8
    //   605: aload_0
    //   606: getfield 72	com/g/a/bk:c	Ljava/util/concurrent/ExecutorService;
    //   609: new 9	com/g/a/bk$b
    //   612: dup
    //   613: aload_0
    //   614: aload 7
    //   616: aload_1
    //   617: invokespecial 274	com/g/a/bk$b:<init>	(Lcom/g/a/bk;Lcom/g/a/bj;Lcom/g/a/a;)V
    //   620: invokeinterface 280 2 0
    //   625: aload 6
    //   627: astore 8
    //   629: aload 6
    //   631: ifnull +15 -> 646
    //   634: aload 6
    //   636: astore 9
    //   638: aload 6
    //   640: invokevirtual 244	java/nio/channels/FileLock:release	()V
    //   643: aconst_null
    //   644: astore 8
    //   646: aload 5
    //   648: astore 6
    //   650: aload 5
    //   652: ifnull +15 -> 667
    //   655: aload 8
    //   657: astore 9
    //   659: aload 5
    //   661: invokevirtual 239	java/io/RandomAccessFile:close	()V
    //   664: aconst_null
    //   665: astore 6
    //   667: aload 6
    //   669: astore 9
    //   671: aload 7
    //   673: astore 5
    //   675: aload 8
    //   677: astore 6
    //   679: aload 9
    //   681: astore 7
    //   683: goto -408 -> 275
    //   686: aload 6
    //   688: astore 10
    //   690: aload 5
    //   692: astore 9
    //   694: aload 6
    //   696: astore 8
    //   698: aload_0
    //   699: getfield 72	com/g/a/bk:c	Ljava/util/concurrent/ExecutorService;
    //   702: new 9	com/g/a/bk$b
    //   705: dup
    //   706: aload_0
    //   707: aload 7
    //   709: aload_1
    //   710: invokespecial 274	com/g/a/bk$b:<init>	(Lcom/g/a/bk;Lcom/g/a/bj;Lcom/g/a/a;)V
    //   713: invokeinterface 280 2 0
    //   718: goto -223 -> 495
    //   721: astore_1
    //   722: aload 9
    //   724: astore 5
    //   726: aload 8
    //   728: astore 6
    //   730: aload 6
    //   732: ifnull +8 -> 740
    //   735: aload 6
    //   737: invokevirtual 244	java/nio/channels/FileLock:release	()V
    //   740: aload 5
    //   742: ifnull +8 -> 750
    //   745: aload 5
    //   747: invokevirtual 239	java/io/RandomAccessFile:close	()V
    //   750: aload_1
    //   751: athrow
    //   752: astore_1
    //   753: aload_0
    //   754: monitorexit
    //   755: aload_1
    //   756: athrow
    //   757: astore 6
    //   759: aload 9
    //   761: astore 6
    //   763: aload 5
    //   765: astore 8
    //   767: aload 7
    //   769: astore 5
    //   771: aload 8
    //   773: astore 7
    //   775: goto -500 -> 275
    //   778: astore 6
    //   780: aload 9
    //   782: astore 6
    //   784: aload 5
    //   786: astore 8
    //   788: aload 7
    //   790: astore 5
    //   792: aload 8
    //   794: astore 7
    //   796: goto -521 -> 275
    //   799: astore 5
    //   801: goto -51 -> 750
    //   804: astore_1
    //   805: aload 8
    //   807: astore 5
    //   809: goto -79 -> 730
    //   812: astore 7
    //   814: aload 5
    //   816: astore 7
    //   818: aload 8
    //   820: astore 5
    //   822: goto -225 -> 597
    //   825: astore 5
    //   827: aload 8
    //   829: astore 5
    //   831: goto -234 -> 597
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	834	0	this	bk
    //   0	834	1	parama	a
    //   0	834	2	paramInt	int
    //   108	26	3	i	int
    //   342	105	4	j	int
    //   129	662	5	localObject1	Object
    //   799	1	5	localThrowable1	Throwable
    //   807	14	5	localObject2	Object
    //   825	1	5	localThrowable2	Throwable
    //   829	1	5	localObject3	Object
    //   123	151	6	localObject4	Object
    //   286	1	6	localThrowable3	Throwable
    //   290	275	6	localObject5	Object
    //   591	1	6	localThrowable4	Throwable
    //   595	141	6	localObject6	Object
    //   757	1	6	localThrowable5	Throwable
    //   761	1	6	localObject7	Object
    //   778	1	6	localThrowable6	Throwable
    //   782	1	6	localObject8	Object
    //   162	633	7	localObject9	Object
    //   812	1	7	localThrowable7	Throwable
    //   816	1	7	localObject10	Object
    //   126	702	8	localObject11	Object
    //   149	632	9	localObject12	Object
    //   179	510	10	localObject13	Object
    //   9	458	11	localLinkedList	java.util.LinkedList
    //   51	90	12	localFile	File
    //   94	62	13	arrayOfString	String[]
    //   363	106	14	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   234	239	286	java/lang/Throwable
    //   255	260	286	java/lang/Throwable
    //   189	199	591	java/lang/Throwable
    //   216	221	591	java/lang/Throwable
    //   319	325	591	java/lang/Throwable
    //   337	344	591	java/lang/Throwable
    //   356	365	591	java/lang/Throwable
    //   377	384	591	java/lang/Throwable
    //   396	403	591	java/lang/Throwable
    //   415	424	591	java/lang/Throwable
    //   436	449	591	java/lang/Throwable
    //   466	476	591	java/lang/Throwable
    //   488	495	591	java/lang/Throwable
    //   568	588	591	java/lang/Throwable
    //   698	718	591	java/lang/Throwable
    //   189	199	721	finally
    //   216	221	721	finally
    //   319	325	721	finally
    //   337	344	721	finally
    //   356	365	721	finally
    //   377	384	721	finally
    //   396	403	721	finally
    //   415	424	721	finally
    //   436	449	721	finally
    //   466	476	721	finally
    //   488	495	721	finally
    //   568	588	721	finally
    //   605	625	721	finally
    //   698	718	721	finally
    //   2	84	752	finally
    //   89	96	752	finally
    //   101	107	752	finally
    //   109	120	752	finally
    //   234	239	752	finally
    //   255	260	752	finally
    //   508	513	752	finally
    //   529	534	752	finally
    //   638	643	752	finally
    //   659	664	752	finally
    //   735	740	752	finally
    //   745	750	752	finally
    //   750	752	752	finally
    //   508	513	757	java/lang/Throwable
    //   529	534	757	java/lang/Throwable
    //   638	643	778	java/lang/Throwable
    //   659	664	778	java/lang/Throwable
    //   735	740	799	java/lang/Throwable
    //   745	750	799	java/lang/Throwable
    //   136	164	804	finally
    //   164	177	804	finally
    //   136	164	812	java/lang/Throwable
    //   164	177	825	java/lang/Throwable
  }
  
  public void a(bj parambj, a parama)
  {
    if ((parama != null) && (parambj != null)) {}
    try
    {
      ((TreeSet)this.e.get(Integer.valueOf(parama.c()))).add(parambj);
      return;
    }
    catch (Throwable parambj)
    {
      for (;;)
      {
        av.postSDKError(parambj);
      }
    }
    finally {}
  }
  
  public void a(bj parambj, be parambe)
  {
    try
    {
      this.c.execute(new c(parambj, parambe));
      return;
    }
    finally
    {
      parambj = finally;
      throw parambj;
    }
  }
  
  public void confirmRead(a parama)
  {
    this.c.execute(new a(parama));
  }
  
  public void getFileLock(a parama)
  {
    try
    {
      this.a.lock();
      this.h.put(new Integer(parama.c()), ((RandomAccessFile)this.g.get(new Integer(parama.c()))).getChannel().lock());
      return;
    }
    catch (Throwable parama) {}
  }
  
  /* Error */
  public void releaseFileLock(a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 115	com/g/a/bk:h	Ljava/util/Map;
    //   4: new 53	java/lang/Integer
    //   7: dup
    //   8: aload_1
    //   9: invokevirtual 51	com/g/a/a:c	()I
    //   12: invokespecial 150	java/lang/Integer:<init>	(I)V
    //   15: invokeinterface 300 2 0
    //   20: astore_2
    //   21: aload_2
    //   22: ifnull +38 -> 60
    //   25: aload_0
    //   26: getfield 115	com/g/a/bk:h	Ljava/util/Map;
    //   29: new 53	java/lang/Integer
    //   32: dup
    //   33: aload_1
    //   34: invokevirtual 51	com/g/a/a:c	()I
    //   37: invokespecial 150	java/lang/Integer:<init>	(I)V
    //   40: invokeinterface 300 2 0
    //   45: checkcast 241	java/nio/channels/FileLock
    //   48: invokevirtual 244	java/nio/channels/FileLock:release	()V
    //   51: aload_0
    //   52: getfield 34	com/g/a/bk:a	Ljava/util/concurrent/locks/Lock;
    //   55: invokeinterface 306 1 0
    //   60: return
    //   61: astore_1
    //   62: return
    //   63: astore_1
    //   64: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	bk
    //   0	65	1	parama	a
    //   20	2	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	21	61	java/lang/Throwable
    //   25	60	63	java/lang/Throwable
  }
  
  class a
    implements Runnable
  {
    private final String b;
    private final TreeSet c;
    private final a d;
    
    public a(a parama)
    {
      this.b = (c.e.getFilesDir() + File.separator + "td_database" + parama.c() + "SaaS");
      this.c = ((TreeSet)bk.a(bk.this).get(Integer.valueOf(parama.c())));
      this.d = parama;
    }
    
    public void run()
    {
      try
      {
        if (this.c != null)
        {
          if (this.c.isEmpty()) {}
          while (!this.c.isEmpty())
          {
            Object localObject = (bj)this.c.pollFirst();
            if (localObject != null)
            {
              localObject = new File(this.b + File.separator + ((bj)localObject).b());
              if ((!((File)localObject).exists()) || (((File)localObject).delete())) {}
            }
          }
          this.c.clear();
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        av.postSDKError(localThrowable);
      }
    }
  }
  
  class b
    implements Runnable
  {
    private final String b;
    private final bj c;
    
    public b(bj parambj, a parama)
    {
      this.b = (c.e.getFilesDir().getAbsolutePath() + File.separator + "td_database" + parama.c() + "SaaS");
      this.c = parambj;
    }
    
    public void run()
    {
      try
      {
        File localFile = new File(this.b + File.separator + this.c.b());
        if (localFile.exists())
        {
          boolean bool = localFile.delete();
          if (bool) {}
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        av.postSDKError(localThrowable);
      }
    }
  }
  
  class c
    implements Runnable
  {
    private final String b;
    private final bj c;
    
    public c(bj parambj, be parambe)
    {
      this.b = (c.e.getFilesDir() + File.separator + "td_database" + parambe.a.c() + "SaaS");
      this.c = parambj;
    }
    
    public void run()
    {
      try
      {
        Object localObject = new File(this.b);
        if ((!((File)localObject).exists()) && (!((File)localObject).isDirectory())) {
          ((File)localObject).mkdir();
        }
        bk.a(bk.this, (File)localObject);
        localObject = new File(this.b + File.separator + this.c.b());
        if (!((File)localObject).exists()) {
          ((File)localObject).createNewFile();
        }
        localObject = new RandomAccessFile((File)localObject, "rw");
        ((RandomAccessFile)localObject).seek(1L);
        ((RandomAccessFile)localObject).writeInt(this.c.d());
        ((RandomAccessFile)localObject).writeInt(this.c.e());
        ((RandomAccessFile)localObject).write(this.c.c());
        ((RandomAccessFile)localObject).getFD().sync();
        ((RandomAccessFile)localObject).close();
        return;
      }
      catch (Throwable localThrowable)
      {
        av.postSDKError(localThrowable);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */