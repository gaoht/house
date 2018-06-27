package com.xiaomi.smack.provider;

import com.maa.android.agent.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Instrumented
public class c
{
  private static c a;
  private Map<String, Object> b = new ConcurrentHashMap();
  private Map<String, Object> c = new ConcurrentHashMap();
  
  private c()
  {
    b();
  }
  
  public static c a()
  {
    try
    {
      if (a == null) {
        a = new c();
      }
      c localc = a;
      return localc;
    }
    finally {}
  }
  
  private String b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<").append(paramString1).append("/>");
    if (paramString1 != null) {
      localStringBuilder.append("<").append(paramString2).append("/>");
    }
    return localStringBuilder.toString();
  }
  
  private ClassLoader[] c()
  {
    int i = 0;
    ClassLoader[] arrayOfClassLoader = new ClassLoader[2];
    arrayOfClassLoader[0] = c.class.getClassLoader();
    arrayOfClassLoader[1] = Thread.currentThread().getContextClassLoader();
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfClassLoader.length;
    while (i < j)
    {
      ClassLoader localClassLoader = arrayOfClassLoader[i];
      if (localClassLoader != null) {
        localArrayList.add(localClassLoader);
      }
      i += 1;
    }
    return (ClassLoader[])localArrayList.toArray(new ClassLoader[localArrayList.size()]);
  }
  
  public Object a(String paramString1, String paramString2)
  {
    paramString1 = b(paramString1, paramString2);
    return this.b.get(paramString1);
  }
  
  public void a(String paramString1, String paramString2, Object paramObject)
  {
    if ((!(paramObject instanceof b)) && (!(paramObject instanceof Class))) {
      throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
    }
    paramString1 = b(paramString1, paramString2);
    this.b.put(paramString1, paramObject);
  }
  
  /* Error */
  protected void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 111	com/xiaomi/smack/provider/c:c	()[Ljava/lang/ClassLoader;
    //   4: astore 8
    //   6: aload 8
    //   8: arraylength
    //   9: istore 4
    //   11: iconst_0
    //   12: istore_1
    //   13: iload_1
    //   14: iload 4
    //   16: if_icmpge +447 -> 463
    //   19: aload 8
    //   21: iload_1
    //   22: aaload
    //   23: ldc 113
    //   25: invokevirtual 117	java/lang/ClassLoader:getResources	(Ljava/lang/String;)Ljava/util/Enumeration;
    //   28: astore 9
    //   30: aload 9
    //   32: invokeinterface 123 1 0
    //   37: ifeq +691 -> 728
    //   40: aload 9
    //   42: invokeinterface 127 1 0
    //   47: checkcast 129	java/net/URL
    //   50: astore 10
    //   52: aconst_null
    //   53: astore 6
    //   55: aload 6
    //   57: astore 7
    //   59: aload 10
    //   61: instanceof 129
    //   64: ifne +316 -> 380
    //   67: aload 6
    //   69: astore 7
    //   71: aload 10
    //   73: invokevirtual 133	java/net/URL:openStream	()Ljava/io/InputStream;
    //   76: astore 6
    //   78: aload 6
    //   80: astore 7
    //   82: invokestatic 139	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   85: invokevirtual 143	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   88: astore 10
    //   90: aload 6
    //   92: astore 7
    //   94: aload 10
    //   96: ldc -111
    //   98: iconst_1
    //   99: invokeinterface 151 3 0
    //   104: aload 6
    //   106: astore 7
    //   108: aload 10
    //   110: aload 6
    //   112: ldc -103
    //   114: invokeinterface 157 3 0
    //   119: aload 6
    //   121: astore 7
    //   123: aload 10
    //   125: invokeinterface 160 1 0
    //   130: istore_2
    //   131: iload_2
    //   132: iconst_2
    //   133: if_icmpne +215 -> 348
    //   136: aload 6
    //   138: astore 7
    //   140: aload 10
    //   142: invokeinterface 163 1 0
    //   147: ldc -91
    //   149: invokevirtual 170	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   152: ifeq +312 -> 464
    //   155: aload 6
    //   157: astore 7
    //   159: aload 10
    //   161: invokeinterface 173 1 0
    //   166: pop
    //   167: aload 6
    //   169: astore 7
    //   171: aload 10
    //   173: invokeinterface 173 1 0
    //   178: pop
    //   179: aload 6
    //   181: astore 7
    //   183: aload 10
    //   185: invokeinterface 176 1 0
    //   190: astore 12
    //   192: aload 6
    //   194: astore 7
    //   196: aload 10
    //   198: invokeinterface 173 1 0
    //   203: pop
    //   204: aload 6
    //   206: astore 7
    //   208: aload 10
    //   210: invokeinterface 173 1 0
    //   215: pop
    //   216: aload 6
    //   218: astore 7
    //   220: aload 10
    //   222: invokeinterface 176 1 0
    //   227: astore 13
    //   229: aload 6
    //   231: astore 7
    //   233: aload 10
    //   235: invokeinterface 173 1 0
    //   240: pop
    //   241: aload 6
    //   243: astore 7
    //   245: aload 10
    //   247: invokeinterface 173 1 0
    //   252: pop
    //   253: aload 6
    //   255: astore 7
    //   257: aload 10
    //   259: invokeinterface 176 1 0
    //   264: astore 11
    //   266: aload 6
    //   268: astore 7
    //   270: aload_0
    //   271: aload 12
    //   273: aload 13
    //   275: invokespecial 85	com/xiaomi/smack/provider/c:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   278: astore 12
    //   280: aload 6
    //   282: astore 7
    //   284: aload_0
    //   285: getfield 22	com/xiaomi/smack/provider/c:c	Ljava/util/Map;
    //   288: aload 12
    //   290: invokeinterface 179 2 0
    //   295: istore 5
    //   297: iload 5
    //   299: ifne +49 -> 348
    //   302: aload 6
    //   304: astore 7
    //   306: aload 11
    //   308: invokestatic 183	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   311: astore 11
    //   313: aload 6
    //   315: astore 7
    //   317: ldc -71
    //   319: aload 11
    //   321: invokevirtual 189	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   324: ifeq +73 -> 397
    //   327: aload 6
    //   329: astore 7
    //   331: aload_0
    //   332: getfield 22	com/xiaomi/smack/provider/c:c	Ljava/util/Map;
    //   335: aload 12
    //   337: aload 11
    //   339: invokevirtual 191	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   342: invokeinterface 105 3 0
    //   347: pop
    //   348: aload 6
    //   350: astore 7
    //   352: aload 10
    //   354: invokeinterface 173 1 0
    //   359: istore_3
    //   360: iload_3
    //   361: istore_2
    //   362: iload_3
    //   363: iconst_1
    //   364: if_icmpne -233 -> 131
    //   367: aload 6
    //   369: invokevirtual 196	java/io/InputStream:close	()V
    //   372: goto -342 -> 30
    //   375: astore 6
    //   377: goto -347 -> 30
    //   380: aload 6
    //   382: astore 7
    //   384: aload 10
    //   386: checkcast 129	java/net/URL
    //   389: invokestatic 201	com/mato/sdk/instrumentation/HttpInstrumentation:openStream	(Ljava/net/URL;)Ljava/io/InputStream;
    //   392: astore 6
    //   394: goto -316 -> 78
    //   397: aload 6
    //   399: astore 7
    //   401: ldc -53
    //   403: aload 11
    //   405: invokevirtual 189	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   408: ifeq -60 -> 348
    //   411: aload 6
    //   413: astore 7
    //   415: aload_0
    //   416: getfield 22	com/xiaomi/smack/provider/c:c	Ljava/util/Map;
    //   419: aload 12
    //   421: aload 11
    //   423: invokeinterface 105 3 0
    //   428: pop
    //   429: goto -81 -> 348
    //   432: astore 11
    //   434: aload 6
    //   436: astore 7
    //   438: aload 11
    //   440: invokevirtual 206	java/lang/ClassNotFoundException:printStackTrace	()V
    //   443: goto -95 -> 348
    //   446: astore 6
    //   448: aload 7
    //   450: invokevirtual 196	java/io/InputStream:close	()V
    //   453: aload 6
    //   455: athrow
    //   456: astore 6
    //   458: aload 6
    //   460: invokevirtual 207	java/lang/Exception:printStackTrace	()V
    //   463: return
    //   464: aload 6
    //   466: astore 7
    //   468: aload 10
    //   470: invokeinterface 163 1 0
    //   475: ldc -47
    //   477: invokevirtual 170	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   480: ifeq -132 -> 348
    //   483: aload 6
    //   485: astore 7
    //   487: aload 10
    //   489: invokeinterface 173 1 0
    //   494: pop
    //   495: aload 6
    //   497: astore 7
    //   499: aload 10
    //   501: invokeinterface 173 1 0
    //   506: pop
    //   507: aload 6
    //   509: astore 7
    //   511: aload 10
    //   513: invokeinterface 176 1 0
    //   518: astore 12
    //   520: aload 6
    //   522: astore 7
    //   524: aload 10
    //   526: invokeinterface 173 1 0
    //   531: pop
    //   532: aload 6
    //   534: astore 7
    //   536: aload 10
    //   538: invokeinterface 173 1 0
    //   543: pop
    //   544: aload 6
    //   546: astore 7
    //   548: aload 10
    //   550: invokeinterface 176 1 0
    //   555: astore 13
    //   557: aload 6
    //   559: astore 7
    //   561: aload 10
    //   563: invokeinterface 173 1 0
    //   568: pop
    //   569: aload 6
    //   571: astore 7
    //   573: aload 10
    //   575: invokeinterface 173 1 0
    //   580: pop
    //   581: aload 6
    //   583: astore 7
    //   585: aload 10
    //   587: invokeinterface 176 1 0
    //   592: astore 11
    //   594: aload 6
    //   596: astore 7
    //   598: aload_0
    //   599: aload 12
    //   601: aload 13
    //   603: invokespecial 85	com/xiaomi/smack/provider/c:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   606: astore 12
    //   608: aload 6
    //   610: astore 7
    //   612: aload_0
    //   613: getfield 20	com/xiaomi/smack/provider/c:b	Ljava/util/Map;
    //   616: aload 12
    //   618: invokeinterface 179 2 0
    //   623: istore 5
    //   625: iload 5
    //   627: ifne -279 -> 348
    //   630: aload 6
    //   632: astore 7
    //   634: aload 11
    //   636: invokestatic 183	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   639: astore 11
    //   641: aload 6
    //   643: astore 7
    //   645: ldc 94
    //   647: aload 11
    //   649: invokevirtual 189	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   652: ifeq +41 -> 693
    //   655: aload 6
    //   657: astore 7
    //   659: aload_0
    //   660: getfield 20	com/xiaomi/smack/provider/c:b	Ljava/util/Map;
    //   663: aload 12
    //   665: aload 11
    //   667: invokevirtual 191	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   670: invokeinterface 105 3 0
    //   675: pop
    //   676: goto -328 -> 348
    //   679: astore 11
    //   681: aload 6
    //   683: astore 7
    //   685: aload 11
    //   687: invokevirtual 206	java/lang/ClassNotFoundException:printStackTrace	()V
    //   690: goto -342 -> 348
    //   693: aload 6
    //   695: astore 7
    //   697: ldc -45
    //   699: aload 11
    //   701: invokevirtual 189	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   704: ifeq -356 -> 348
    //   707: aload 6
    //   709: astore 7
    //   711: aload_0
    //   712: getfield 20	com/xiaomi/smack/provider/c:b	Ljava/util/Map;
    //   715: aload 12
    //   717: aload 11
    //   719: invokeinterface 105 3 0
    //   724: pop
    //   725: goto -377 -> 348
    //   728: iload_1
    //   729: iconst_1
    //   730: iadd
    //   731: istore_1
    //   732: goto -719 -> 13
    //   735: astore 7
    //   737: goto -284 -> 453
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	740	0	this	c
    //   12	720	1	i	int
    //   130	232	2	j	int
    //   359	6	3	k	int
    //   9	8	4	m	int
    //   295	331	5	bool	boolean
    //   53	315	6	localInputStream1	java.io.InputStream
    //   375	6	6	localException1	Exception
    //   392	43	6	localInputStream2	java.io.InputStream
    //   446	8	6	localObject1	Object
    //   456	252	6	localException2	Exception
    //   57	653	7	localObject2	Object
    //   735	1	7	localException3	Exception
    //   4	16	8	arrayOfClassLoader	ClassLoader[]
    //   28	13	9	localEnumeration	java.util.Enumeration
    //   50	536	10	localObject3	Object
    //   264	158	11	localObject4	Object
    //   432	7	11	localClassNotFoundException1	ClassNotFoundException
    //   592	74	11	localObject5	Object
    //   679	39	11	localClassNotFoundException2	ClassNotFoundException
    //   190	526	12	str1	String
    //   227	375	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   367	372	375	java/lang/Exception
    //   306	313	432	java/lang/ClassNotFoundException
    //   317	327	432	java/lang/ClassNotFoundException
    //   331	348	432	java/lang/ClassNotFoundException
    //   401	411	432	java/lang/ClassNotFoundException
    //   415	429	432	java/lang/ClassNotFoundException
    //   59	67	446	finally
    //   71	78	446	finally
    //   82	90	446	finally
    //   94	104	446	finally
    //   108	119	446	finally
    //   123	131	446	finally
    //   140	155	446	finally
    //   159	167	446	finally
    //   171	179	446	finally
    //   183	192	446	finally
    //   196	204	446	finally
    //   208	216	446	finally
    //   220	229	446	finally
    //   233	241	446	finally
    //   245	253	446	finally
    //   257	266	446	finally
    //   270	280	446	finally
    //   284	297	446	finally
    //   306	313	446	finally
    //   317	327	446	finally
    //   331	348	446	finally
    //   352	360	446	finally
    //   384	394	446	finally
    //   401	411	446	finally
    //   415	429	446	finally
    //   438	443	446	finally
    //   468	483	446	finally
    //   487	495	446	finally
    //   499	507	446	finally
    //   511	520	446	finally
    //   524	532	446	finally
    //   536	544	446	finally
    //   548	557	446	finally
    //   561	569	446	finally
    //   573	581	446	finally
    //   585	594	446	finally
    //   598	608	446	finally
    //   612	625	446	finally
    //   634	641	446	finally
    //   645	655	446	finally
    //   659	676	446	finally
    //   685	690	446	finally
    //   697	707	446	finally
    //   711	725	446	finally
    //   0	11	456	java/lang/Exception
    //   19	30	456	java/lang/Exception
    //   30	52	456	java/lang/Exception
    //   453	456	456	java/lang/Exception
    //   634	641	679	java/lang/ClassNotFoundException
    //   645	655	679	java/lang/ClassNotFoundException
    //   659	676	679	java/lang/ClassNotFoundException
    //   697	707	679	java/lang/ClassNotFoundException
    //   711	725	679	java/lang/ClassNotFoundException
    //   448	453	735	java/lang/Exception
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/smack/provider/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */