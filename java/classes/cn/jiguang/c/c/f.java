package cn.jiguang.c.c;

public final class f
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[7];
    int j = 0;
    Object localObject2 = "tyQ}YVzD(QG<U2OGo\0058OAsW}JZhM}h]wK2J]TJ.IvdF8MGuJ3\007";
    int i = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int k = arrayOfChar.length;
    int i1 = 0;
    int m = 0;
    int i3 = i;
    localObject2 = arrayOfChar;
    int i4 = j;
    Object localObject3 = localObject1;
    int n = k;
    Object localObject4;
    int i2;
    if (k <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i2 = i;
      label68:
      n = m;
      label71:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 61;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label71;
      }
      i1 = n;
      n = k;
      localObject3 = localObject4;
      i4 = j;
      localObject2 = localObject1;
      i3 = i2;
      i2 = i3;
      localObject1 = localObject2;
      j = i4;
      localObject4 = localObject3;
      k = n;
      m = i1;
      if (n > i1) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i3)
      {
      default: 
        localObject3[i4] = localObject1;
        j = 1;
        localObject2 = "tyQ}YVzD(QG<U2OGo\0058OAsW}JZhM}sRq@\tR\\PJ3ZvdF8MGuJ3";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "tyQ}YVzD(QG<U2OGo\0058OAsW}JZhM}iVdQ\r\\Ao@\030EPyU)T\\r";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "tyQ}YVzD(QG<U2OGo\0058OAsW}JZhM}xK@-IZsK";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "@nSg";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "wRv\016OEIQ4Q@";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "tyQ}YVzD(QG<U2OGo\0058OAsW}JZhM}t|Y]>XChL2S\t";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 51;
        continue;
        i = 28;
        continue;
        i = 37;
        continue;
        i = 93;
      }
    }
  }
  
  /* Error */
  public static java.util.List<p> a(String paramString)
  {
    // Byte code:
    //   0: new 53	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 55	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: invokestatic 61	cn/jiguang/c/c/o:b	()Lcn/jiguang/c/c/o;
    //   12: invokevirtual 64	cn/jiguang/c/c/o:a	()[Ljava/lang/String;
    //   15: astore 6
    //   17: aload_0
    //   18: invokestatic 69	cn/jiguang/c/c/j:a	(Ljava/lang/String;)Lcn/jiguang/c/c/j;
    //   21: getstatic 72	cn/jiguang/c/c/j:a	Lcn/jiguang/c/c/j;
    //   24: invokestatic 75	cn/jiguang/c/c/j:a	(Lcn/jiguang/c/c/j;Lcn/jiguang/c/c/j;)Lcn/jiguang/c/c/j;
    //   27: bipush 33
    //   29: iconst_1
    //   30: invokestatic 80	cn/jiguang/c/c/m:a	(Lcn/jiguang/c/c/j;II)Lcn/jiguang/c/c/m;
    //   33: invokestatic 85	cn/jiguang/c/c/h:a	(Lcn/jiguang/c/c/m;)Lcn/jiguang/c/c/h;
    //   36: ldc 86
    //   38: invokevirtual 89	cn/jiguang/c/c/h:b	(I)[B
    //   41: astore_0
    //   42: aload 6
    //   44: arraylength
    //   45: istore_3
    //   46: iconst_0
    //   47: istore_1
    //   48: iload_1
    //   49: iload_3
    //   50: if_icmpge +345 -> 395
    //   53: aload 6
    //   55: iload_1
    //   56: aaload
    //   57: astore 7
    //   59: new 82	cn/jiguang/c/c/h
    //   62: dup
    //   63: aconst_null
    //   64: new 91	java/net/InetSocketAddress
    //   67: dup
    //   68: aload 7
    //   70: invokestatic 97	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   73: bipush 53
    //   75: invokespecial 100	java/net/InetSocketAddress:<init>	(Ljava/net/InetAddress;I)V
    //   78: aload_0
    //   79: invokestatic 106	java/lang/System:currentTimeMillis	()J
    //   82: ldc2_w 107
    //   85: ladd
    //   86: invokestatic 113	cn/jiguang/c/c/r:a	(Ljava/net/SocketAddress;Ljava/net/SocketAddress;[BJ)[B
    //   89: invokespecial 116	cn/jiguang/c/c/h:<init>	([B)V
    //   92: astore 8
    //   94: aload 8
    //   96: invokevirtual 119	cn/jiguang/c/c/h:a	()Lcn/jiguang/c/c/m;
    //   99: astore 7
    //   101: aload 7
    //   103: ifnonnull +6 -> 109
    //   106: aload 5
    //   108: areturn
    //   109: aload 8
    //   111: iconst_1
    //   112: invokevirtual 122	cn/jiguang/c/c/h:a	(I)[Lcn/jiguang/c/c/l;
    //   115: astore 8
    //   117: iconst_0
    //   118: istore_2
    //   119: iload_2
    //   120: aload 8
    //   122: arraylength
    //   123: if_icmpge +275 -> 398
    //   126: aload 8
    //   128: iload_2
    //   129: aaload
    //   130: invokevirtual 126	cn/jiguang/c/c/l:b	()Lcn/jiguang/c/c/m;
    //   133: invokevirtual 130	cn/jiguang/c/c/m:e	()I
    //   136: aload 7
    //   138: invokevirtual 130	cn/jiguang/c/c/m:e	()I
    //   141: if_icmpne +264 -> 405
    //   144: aload 8
    //   146: iload_2
    //   147: aaload
    //   148: invokevirtual 126	cn/jiguang/c/c/l:b	()Lcn/jiguang/c/c/m;
    //   151: invokevirtual 133	cn/jiguang/c/c/m:d	()I
    //   154: istore 4
    //   156: aload 8
    //   158: iload_2
    //   159: aaload
    //   160: invokevirtual 126	cn/jiguang/c/c/l:b	()Lcn/jiguang/c/c/m;
    //   163: invokevirtual 136	cn/jiguang/c/c/m:b	()Lcn/jiguang/c/c/j;
    //   166: astore 9
    //   168: iload 4
    //   170: aload 7
    //   172: invokevirtual 139	cn/jiguang/c/c/m:c	()I
    //   175: if_icmpne +230 -> 405
    //   178: aload 9
    //   180: aload 7
    //   182: invokevirtual 136	cn/jiguang/c/c/m:b	()Lcn/jiguang/c/c/j;
    //   185: invokevirtual 143	cn/jiguang/c/c/j:equals	(Ljava/lang/Object;)Z
    //   188: ifeq +217 -> 405
    //   191: aload 8
    //   193: iload_2
    //   194: aaload
    //   195: invokevirtual 146	cn/jiguang/c/c/l:a	()Ljava/util/Iterator;
    //   198: astore 9
    //   200: aload 9
    //   202: invokeinterface 152 1 0
    //   207: ifeq +198 -> 405
    //   210: aload 9
    //   212: invokeinterface 156 1 0
    //   217: checkcast 158	cn/jiguang/c/c/p
    //   220: astore 10
    //   222: aload 10
    //   224: invokevirtual 161	cn/jiguang/c/c/p:h	()I
    //   227: ifle +13 -> 240
    //   230: aload 5
    //   232: aload 10
    //   234: invokeinterface 166 2 0
    //   239: pop
    //   240: getstatic 38	cn/jiguang/c/c/f:z	[Ljava/lang/String;
    //   243: iconst_5
    //   244: aaload
    //   245: new 168	java/lang/StringBuilder
    //   248: dup
    //   249: getstatic 38	cn/jiguang/c/c/f:z	[Ljava/lang/String;
    //   252: iconst_4
    //   253: aaload
    //   254: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   257: aload 10
    //   259: invokevirtual 174	cn/jiguang/c/c/p:toString	()Ljava/lang/String;
    //   262: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 184	cn/jiguang/d/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: goto -71 -> 200
    //   274: astore 7
    //   276: getstatic 38	cn/jiguang/c/c/f:z	[Ljava/lang/String;
    //   279: iconst_5
    //   280: aaload
    //   281: new 168	java/lang/StringBuilder
    //   284: dup
    //   285: getstatic 38	cn/jiguang/c/c/f:z	[Ljava/lang/String;
    //   288: iconst_0
    //   289: aaload
    //   290: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   293: aload 7
    //   295: invokevirtual 187	java/net/UnknownHostException:getMessage	()Ljava/lang/String;
    //   298: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 189	cn/jiguang/d/d:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: goto +91 -> 398
    //   310: astore 7
    //   312: getstatic 38	cn/jiguang/c/c/f:z	[Ljava/lang/String;
    //   315: iconst_5
    //   316: aaload
    //   317: new 168	java/lang/StringBuilder
    //   320: dup
    //   321: getstatic 38	cn/jiguang/c/c/f:z	[Ljava/lang/String;
    //   324: bipush 6
    //   326: aaload
    //   327: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   330: aload 7
    //   332: invokevirtual 190	java/io/IOException:getMessage	()Ljava/lang/String;
    //   335: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 189	cn/jiguang/d/d:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: goto +54 -> 398
    //   347: astore_0
    //   348: getstatic 38	cn/jiguang/c/c/f:z	[Ljava/lang/String;
    //   351: iconst_5
    //   352: aaload
    //   353: getstatic 38	cn/jiguang/c/c/f:z	[Ljava/lang/String;
    //   356: iconst_2
    //   357: aaload
    //   358: invokestatic 189	cn/jiguang/d/d:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: aload 5
    //   363: areturn
    //   364: astore_0
    //   365: getstatic 38	cn/jiguang/c/c/f:z	[Ljava/lang/String;
    //   368: iconst_5
    //   369: aaload
    //   370: getstatic 38	cn/jiguang/c/c/f:z	[Ljava/lang/String;
    //   373: iconst_1
    //   374: aaload
    //   375: invokestatic 189	cn/jiguang/d/d:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   378: aload 5
    //   380: areturn
    //   381: astore_0
    //   382: getstatic 38	cn/jiguang/c/c/f:z	[Ljava/lang/String;
    //   385: iconst_5
    //   386: aaload
    //   387: getstatic 38	cn/jiguang/c/c/f:z	[Ljava/lang/String;
    //   390: iconst_3
    //   391: aaload
    //   392: invokestatic 189	cn/jiguang/d/d:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload 5
    //   397: areturn
    //   398: iload_1
    //   399: iconst_1
    //   400: iadd
    //   401: istore_1
    //   402: goto -354 -> 48
    //   405: iload_2
    //   406: iconst_1
    //   407: iadd
    //   408: istore_2
    //   409: goto -290 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	412	0	paramString	String
    //   47	355	1	i	int
    //   118	291	2	j	int
    //   45	6	3	k	int
    //   154	22	4	m	int
    //   7	389	5	localArrayList	java.util.ArrayList
    //   15	39	6	arrayOfString	String[]
    //   57	124	7	localObject1	Object
    //   274	20	7	localUnknownHostException	java.net.UnknownHostException
    //   310	21	7	localIOException	java.io.IOException
    //   92	100	8	localObject2	Object
    //   166	45	9	localObject3	Object
    //   220	38	10	localp	p
    // Exception table:
    //   from	to	target	type
    //   59	101	274	java/net/UnknownHostException
    //   109	117	274	java/net/UnknownHostException
    //   119	200	274	java/net/UnknownHostException
    //   200	240	274	java/net/UnknownHostException
    //   240	271	274	java/net/UnknownHostException
    //   59	101	310	java/io/IOException
    //   109	117	310	java/io/IOException
    //   119	200	310	java/io/IOException
    //   200	240	310	java/io/IOException
    //   240	271	310	java/io/IOException
    //   9	46	347	cn/jiguang/c/c/s
    //   59	101	347	cn/jiguang/c/c/s
    //   109	117	347	cn/jiguang/c/c/s
    //   119	200	347	cn/jiguang/c/c/s
    //   200	240	347	cn/jiguang/c/c/s
    //   240	271	347	cn/jiguang/c/c/s
    //   276	307	347	cn/jiguang/c/c/s
    //   312	344	347	cn/jiguang/c/c/s
    //   9	46	364	cn/jiguang/c/c/k
    //   59	101	364	cn/jiguang/c/c/k
    //   109	117	364	cn/jiguang/c/c/k
    //   119	200	364	cn/jiguang/c/c/k
    //   200	240	364	cn/jiguang/c/c/k
    //   240	271	364	cn/jiguang/c/c/k
    //   276	307	364	cn/jiguang/c/c/k
    //   312	344	364	cn/jiguang/c/c/k
    //   9	46	381	java/lang/Exception
    //   59	101	381	java/lang/Exception
    //   109	117	381	java/lang/Exception
    //   119	200	381	java/lang/Exception
    //   200	240	381	java/lang/Exception
    //   240	271	381	java/lang/Exception
    //   276	307	381	java/lang/Exception
    //   312	344	381	java/lang/Exception
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */