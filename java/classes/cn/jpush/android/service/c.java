package cn.jpush.android.service;

final class c
  implements Runnable
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[5];
    Object localObject1 = "\006\026?$\026\027\001>!R\026\022\"4";
    int i = -1;
    int j = 0;
    Object localObject3 = arrayOfString;
    localObject1 = ((String)localObject1).toCharArray();
    int k = localObject1.length;
    int m;
    int n;
    int i1;
    label42:
    Object localObject2;
    int i2;
    label91:
    label113:
    Object localObject4;
    int i3;
    if (k <= 1)
    {
      m = 0;
      n = j;
      i1 = i;
      j = m;
      for (;;)
      {
        localObject2 = localObject1;
        i2 = localObject2[m];
        switch (j % 5)
        {
        default: 
          i = 54;
          localObject2[m] = ((char)(i ^ i2));
          j += 1;
          if (k != 0) {
            break label113;
          }
          m = k;
        }
      }
      i = k;
      localObject4 = localObject3;
      i3 = n;
      localObject2 = localObject1;
      i2 = i1;
    }
    for (;;)
    {
      i1 = i2;
      localObject1 = localObject2;
      n = i3;
      localObject3 = localObject4;
      k = i;
      m = j;
      if (i > j) {
        break label42;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject1 = "\024\037#%W\021\nq4D\034\0246%D\020\027";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = "?#$3^9\0342!Z;\034%)P\034\02004_\032\035\022%X\001\026#";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        localObject1 = "\007\026</@\020S";
        j = 3;
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        j = 4;
        localObject1 = "\007\026!%W\001S0$R";
        i = 3;
        break;
      case 3: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 117;
        break label91;
        i = 115;
        break label91;
        i = 81;
        break label91;
        i = 64;
        break label91;
        m = 0;
        i2 = i;
        localObject2 = localObject1;
        i3 = j;
        localObject4 = localObject3;
        i = k;
        j = m;
      }
    }
  }
  
  c(a parama, long paramLong) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: invokestatic 56	cn/jpush/android/service/a:a	()Lcn/jpush/android/data/e;
    //   3: ifnonnull +31 -> 34
    //   6: aload_0
    //   7: getfield 44	cn/jpush/android/service/c:b	Lcn/jpush/android/service/a;
    //   10: invokestatic 59	cn/jpush/android/service/a:a	(Lcn/jpush/android/service/a;)Landroid/content/Context;
    //   13: ifnull +21 -> 34
    //   16: new 61	cn/jpush/android/data/e
    //   19: dup
    //   20: aload_0
    //   21: getfield 44	cn/jpush/android/service/c:b	Lcn/jpush/android/service/a;
    //   24: invokestatic 59	cn/jpush/android/service/a:a	(Lcn/jpush/android/service/a;)Landroid/content/Context;
    //   27: invokespecial 64	cn/jpush/android/data/e:<init>	(Landroid/content/Context;)V
    //   30: invokestatic 67	cn/jpush/android/service/a:a	(Lcn/jpush/android/data/e;)Lcn/jpush/android/data/e;
    //   33: pop
    //   34: aconst_null
    //   35: astore_3
    //   36: aload_3
    //   37: astore 4
    //   39: invokestatic 56	cn/jpush/android/service/a:a	()Lcn/jpush/android/data/e;
    //   42: iconst_1
    //   43: invokevirtual 70	cn/jpush/android/data/e:a	(Z)Z
    //   46: pop
    //   47: aload_3
    //   48: astore 4
    //   50: invokestatic 56	cn/jpush/android/service/a:a	()Lcn/jpush/android/data/e;
    //   53: aload_0
    //   54: getfield 46	cn/jpush/android/service/c:a	J
    //   57: iconst_0
    //   58: invokevirtual 73	cn/jpush/android/data/e:a	(JI)Landroid/database/Cursor;
    //   61: astore_3
    //   62: aload_3
    //   63: astore 4
    //   65: invokestatic 56	cn/jpush/android/service/a:a	()Lcn/jpush/android/data/e;
    //   68: aload_3
    //   69: invokestatic 76	cn/jpush/android/service/a:b	()Lcn/jpush/android/data/g;
    //   72: invokevirtual 79	cn/jpush/android/data/e:a	(Landroid/database/Cursor;Lcn/jpush/android/data/g;)V
    //   75: aload_3
    //   76: astore 4
    //   78: iconst_1
    //   79: invokestatic 76	cn/jpush/android/service/a:b	()Lcn/jpush/android/data/g;
    //   82: invokevirtual 85	cn/jpush/android/data/g:c	()I
    //   85: if_icmpne +76 -> 161
    //   88: aload_3
    //   89: astore 4
    //   91: getstatic 40	cn/jpush/android/service/c:z	[Ljava/lang/String;
    //   94: iconst_2
    //   95: aaload
    //   96: getstatic 40	cn/jpush/android/service/c:z	[Ljava/lang/String;
    //   99: iconst_3
    //   100: aaload
    //   101: invokestatic 90	cn/jpush/android/c/f:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_3
    //   105: astore 4
    //   107: invokestatic 56	cn/jpush/android/service/a:a	()Lcn/jpush/android/data/e;
    //   110: invokestatic 76	cn/jpush/android/service/a:b	()Lcn/jpush/android/data/g;
    //   113: invokevirtual 93	cn/jpush/android/data/g:a	()J
    //   116: iconst_0
    //   117: iconst_1
    //   118: iconst_0
    //   119: invokestatic 76	cn/jpush/android/service/a:b	()Lcn/jpush/android/data/g;
    //   122: invokevirtual 96	cn/jpush/android/data/g:d	()Ljava/lang/String;
    //   125: invokestatic 76	cn/jpush/android/service/a:b	()Lcn/jpush/android/data/g;
    //   128: invokevirtual 99	cn/jpush/android/data/g:f	()J
    //   131: invokestatic 76	cn/jpush/android/service/a:b	()Lcn/jpush/android/data/g;
    //   134: invokevirtual 102	cn/jpush/android/data/g:e	()J
    //   137: invokevirtual 105	cn/jpush/android/data/e:b	(JIIILjava/lang/String;JJ)Z
    //   140: pop
    //   141: aload_3
    //   142: astore 4
    //   144: invokestatic 56	cn/jpush/android/service/a:a	()Lcn/jpush/android/data/e;
    //   147: invokevirtual 107	cn/jpush/android/data/e:a	()V
    //   150: aload_3
    //   151: ifnull +9 -> 160
    //   154: aload_3
    //   155: invokeinterface 112 1 0
    //   160: return
    //   161: aload_3
    //   162: astore 4
    //   164: invokestatic 76	cn/jpush/android/service/a:b	()Lcn/jpush/android/data/g;
    //   167: invokevirtual 114	cn/jpush/android/data/g:b	()I
    //   170: iconst_1
    //   171: if_icmple +80 -> 251
    //   174: aload_3
    //   175: astore 4
    //   177: getstatic 40	cn/jpush/android/service/c:z	[Ljava/lang/String;
    //   180: iconst_2
    //   181: aaload
    //   182: getstatic 40	cn/jpush/android/service/c:z	[Ljava/lang/String;
    //   185: iconst_4
    //   186: aaload
    //   187: invokestatic 90	cn/jpush/android/c/f:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload_3
    //   191: astore 4
    //   193: invokestatic 56	cn/jpush/android/service/a:a	()Lcn/jpush/android/data/e;
    //   196: invokestatic 76	cn/jpush/android/service/a:b	()Lcn/jpush/android/data/g;
    //   199: invokevirtual 93	cn/jpush/android/data/g:a	()J
    //   202: invokestatic 76	cn/jpush/android/service/a:b	()Lcn/jpush/android/data/g;
    //   205: invokevirtual 114	cn/jpush/android/data/g:b	()I
    //   208: iconst_1
    //   209: isub
    //   210: iconst_0
    //   211: iconst_0
    //   212: invokestatic 76	cn/jpush/android/service/a:b	()Lcn/jpush/android/data/g;
    //   215: invokevirtual 96	cn/jpush/android/data/g:d	()Ljava/lang/String;
    //   218: invokestatic 76	cn/jpush/android/service/a:b	()Lcn/jpush/android/data/g;
    //   221: invokevirtual 99	cn/jpush/android/data/g:f	()J
    //   224: invokestatic 76	cn/jpush/android/service/a:b	()Lcn/jpush/android/data/g;
    //   227: invokevirtual 102	cn/jpush/android/data/g:e	()J
    //   230: invokevirtual 105	cn/jpush/android/data/e:b	(JIIILjava/lang/String;JJ)Z
    //   233: pop
    //   234: goto -93 -> 141
    //   237: astore_3
    //   238: aload 4
    //   240: ifnull -80 -> 160
    //   243: aload 4
    //   245: invokeinterface 112 1 0
    //   250: return
    //   251: aload_3
    //   252: astore 4
    //   254: invokestatic 76	cn/jpush/android/service/a:b	()Lcn/jpush/android/data/g;
    //   257: invokevirtual 114	cn/jpush/android/data/g:b	()I
    //   260: iconst_1
    //   261: if_icmpne +146 -> 407
    //   264: aload_3
    //   265: astore 4
    //   267: getstatic 40	cn/jpush/android/service/c:z	[Ljava/lang/String;
    //   270: iconst_2
    //   271: aaload
    //   272: getstatic 40	cn/jpush/android/service/c:z	[Ljava/lang/String;
    //   275: iconst_0
    //   276: aaload
    //   277: invokestatic 90	cn/jpush/android/c/f:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: aload_3
    //   281: astore 4
    //   283: invokestatic 119	java/lang/System:currentTimeMillis	()J
    //   286: lstore_1
    //   287: aload_3
    //   288: astore 4
    //   290: invokestatic 76	cn/jpush/android/service/a:b	()Lcn/jpush/android/data/g;
    //   293: invokevirtual 99	cn/jpush/android/data/g:f	()J
    //   296: lload_1
    //   297: lcmp
    //   298: ifle +37 -> 335
    //   301: aload_3
    //   302: astore 4
    //   304: getstatic 40	cn/jpush/android/service/c:z	[Ljava/lang/String;
    //   307: iconst_2
    //   308: aaload
    //   309: getstatic 40	cn/jpush/android/service/c:z	[Ljava/lang/String;
    //   312: iconst_4
    //   313: aaload
    //   314: invokestatic 90	cn/jpush/android/c/f:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: goto -176 -> 141
    //   320: astore 4
    //   322: aload_3
    //   323: ifnull +9 -> 332
    //   326: aload_3
    //   327: invokeinterface 112 1 0
    //   332: aload 4
    //   334: athrow
    //   335: aload_3
    //   336: astore 4
    //   338: aload_0
    //   339: getfield 44	cn/jpush/android/service/c:b	Lcn/jpush/android/service/a;
    //   342: aload_0
    //   343: getfield 44	cn/jpush/android/service/c:b	Lcn/jpush/android/service/a;
    //   346: invokestatic 59	cn/jpush/android/service/a:a	(Lcn/jpush/android/service/a;)Landroid/content/Context;
    //   349: invokestatic 76	cn/jpush/android/service/a:b	()Lcn/jpush/android/data/g;
    //   352: invokevirtual 96	cn/jpush/android/data/g:d	()Ljava/lang/String;
    //   355: aload_0
    //   356: getfield 44	cn/jpush/android/service/c:b	Lcn/jpush/android/service/a;
    //   359: invokestatic 122	cn/jpush/android/service/a:b	(Lcn/jpush/android/service/a;)Ljava/lang/String;
    //   362: ldc 124
    //   364: invokestatic 127	cn/jpush/android/service/a:a	(Lcn/jpush/android/service/a;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   367: aload_3
    //   368: astore 4
    //   370: invokestatic 56	cn/jpush/android/service/a:a	()Lcn/jpush/android/data/e;
    //   373: invokestatic 76	cn/jpush/android/service/a:b	()Lcn/jpush/android/data/g;
    //   376: invokevirtual 93	cn/jpush/android/data/g:a	()J
    //   379: iconst_0
    //   380: iconst_0
    //   381: iconst_0
    //   382: invokestatic 76	cn/jpush/android/service/a:b	()Lcn/jpush/android/data/g;
    //   385: invokevirtual 96	cn/jpush/android/data/g:d	()Ljava/lang/String;
    //   388: invokestatic 76	cn/jpush/android/service/a:b	()Lcn/jpush/android/data/g;
    //   391: invokevirtual 99	cn/jpush/android/data/g:f	()J
    //   394: invokestatic 76	cn/jpush/android/service/a:b	()Lcn/jpush/android/data/g;
    //   397: invokevirtual 102	cn/jpush/android/data/g:e	()J
    //   400: invokevirtual 105	cn/jpush/android/data/e:b	(JIIILjava/lang/String;JJ)Z
    //   403: pop
    //   404: goto -263 -> 141
    //   407: aload_3
    //   408: astore 4
    //   410: getstatic 40	cn/jpush/android/service/c:z	[Ljava/lang/String;
    //   413: iconst_2
    //   414: aaload
    //   415: getstatic 40	cn/jpush/android/service/c:z	[Ljava/lang/String;
    //   418: iconst_1
    //   419: aaload
    //   420: invokestatic 90	cn/jpush/android/c/f:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   423: goto -282 -> 141
    //   426: astore 4
    //   428: aconst_null
    //   429: astore_3
    //   430: goto -108 -> 322
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	433	0	this	c
    //   286	11	1	l	long
    //   35	156	3	localCursor	android.database.Cursor
    //   237	171	3	localException1	Exception
    //   429	1	3	localObject1	Object
    //   37	266	4	localObject2	Object
    //   320	13	4	localObject3	Object
    //   336	73	4	localException2	Exception
    //   426	1	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   39	47	237	java/lang/Exception
    //   50	62	237	java/lang/Exception
    //   65	75	237	java/lang/Exception
    //   78	88	237	java/lang/Exception
    //   91	104	237	java/lang/Exception
    //   107	141	237	java/lang/Exception
    //   144	150	237	java/lang/Exception
    //   164	174	237	java/lang/Exception
    //   177	190	237	java/lang/Exception
    //   193	234	237	java/lang/Exception
    //   254	264	237	java/lang/Exception
    //   267	280	237	java/lang/Exception
    //   283	287	237	java/lang/Exception
    //   290	301	237	java/lang/Exception
    //   304	317	237	java/lang/Exception
    //   338	367	237	java/lang/Exception
    //   370	404	237	java/lang/Exception
    //   410	423	237	java/lang/Exception
    //   65	75	320	finally
    //   78	88	320	finally
    //   91	104	320	finally
    //   107	141	320	finally
    //   144	150	320	finally
    //   164	174	320	finally
    //   177	190	320	finally
    //   193	234	320	finally
    //   254	264	320	finally
    //   267	280	320	finally
    //   283	287	320	finally
    //   290	301	320	finally
    //   304	317	320	finally
    //   338	367	320	finally
    //   370	404	320	finally
    //   410	423	320	finally
    //   39	47	426	finally
    //   50	62	426	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/service/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */