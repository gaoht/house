package com.baidu.trace;

import android.database.sqlite.SQLiteDatabase;

final class w
  implements Runnable
{
  w(u paramu, int paramInt1, int paramInt2, SQLiteDatabase paramSQLiteDatabase) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: new 28	java/lang/StringBuffer
    //   3: dup
    //   4: ldc 30
    //   6: invokespecial 33	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   9: astore 10
    //   11: aload 10
    //   13: ldc 35
    //   15: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   18: ldc 41
    //   20: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   23: ldc 43
    //   25: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   28: ldc 45
    //   30: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   33: pop
    //   34: new 28	java/lang/StringBuffer
    //   37: dup
    //   38: ldc 30
    //   40: invokespecial 33	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   43: astore 11
    //   45: aload 11
    //   47: ldc 47
    //   49: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   52: ldc 49
    //   54: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   57: ldc 51
    //   59: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   62: ldc 53
    //   64: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   67: ldc 55
    //   69: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   72: ldc 57
    //   74: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   77: ldc 59
    //   79: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   82: ldc 61
    //   84: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   87: ldc 63
    //   89: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   92: ldc 65
    //   94: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   97: ldc 67
    //   99: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   102: pop
    //   103: new 28	java/lang/StringBuffer
    //   106: dup
    //   107: ldc 30
    //   109: invokespecial 33	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   112: astore 12
    //   114: aload 12
    //   116: ldc 69
    //   118: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   121: ldc 71
    //   123: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   126: ldc 51
    //   128: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   131: ldc 53
    //   133: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   136: ldc 73
    //   138: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   141: ldc 75
    //   143: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   146: ldc 77
    //   148: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   151: ldc 79
    //   153: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   156: pop
    //   157: aconst_null
    //   158: astore 6
    //   160: aconst_null
    //   161: astore 8
    //   163: aload_0
    //   164: getfield 15	com/baidu/trace/w:a	I
    //   167: istore_1
    //   168: aload 8
    //   170: astore 6
    //   172: aload 8
    //   174: astore 7
    //   176: iload_1
    //   177: aload_0
    //   178: getfield 17	com/baidu/trace/w:b	I
    //   181: if_icmpge +1215 -> 1396
    //   184: aload 8
    //   186: astore 6
    //   188: aload 8
    //   190: astore 7
    //   192: aload_0
    //   193: getfield 15	com/baidu/trace/w:a	I
    //   196: tableswitch	default:+1233->1429, 2:+20->216
    //   216: aload 8
    //   218: astore 6
    //   220: aload 8
    //   222: astore 7
    //   224: aload_0
    //   225: getfield 19	com/baidu/trace/w:c	Landroid/database/sqlite/SQLiteDatabase;
    //   228: aload 12
    //   230: invokevirtual 83	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   233: invokevirtual 88	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   236: aload 8
    //   238: astore 6
    //   240: aload 8
    //   242: astore 7
    //   244: new 28	java/lang/StringBuffer
    //   247: dup
    //   248: ldc 90
    //   250: invokespecial 33	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   253: astore 9
    //   255: aload 8
    //   257: astore 6
    //   259: aload 8
    //   261: astore 7
    //   263: aload 9
    //   265: ldc 92
    //   267: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   270: ldc 94
    //   272: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   275: pop
    //   276: aload 8
    //   278: astore 6
    //   280: aload 8
    //   282: astore 7
    //   284: aload_0
    //   285: getfield 19	com/baidu/trace/w:c	Landroid/database/sqlite/SQLiteDatabase;
    //   288: aload 9
    //   290: invokevirtual 83	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   293: invokevirtual 88	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   296: aload 8
    //   298: astore 6
    //   300: aload 8
    //   302: astore 7
    //   304: aload_0
    //   305: getfield 19	com/baidu/trace/w:c	Landroid/database/sqlite/SQLiteDatabase;
    //   308: aload 10
    //   310: invokevirtual 83	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   313: invokevirtual 88	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   316: aload 8
    //   318: astore 6
    //   320: aload 8
    //   322: astore 7
    //   324: new 28	java/lang/StringBuffer
    //   327: dup
    //   328: ldc 96
    //   330: invokespecial 33	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   333: astore 9
    //   335: aload 8
    //   337: astore 6
    //   339: aload 8
    //   341: astore 7
    //   343: aload 9
    //   345: ldc 94
    //   347: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   350: pop
    //   351: aload 8
    //   353: astore 6
    //   355: aload 8
    //   357: astore 7
    //   359: aload_0
    //   360: getfield 19	com/baidu/trace/w:c	Landroid/database/sqlite/SQLiteDatabase;
    //   363: aload 9
    //   365: invokevirtual 83	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   368: aconst_null
    //   369: invokevirtual 100	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   372: astore 9
    //   374: aload 9
    //   376: astore 8
    //   378: aload 9
    //   380: ifnull +270 -> 650
    //   383: aload 9
    //   385: astore 6
    //   387: aload 9
    //   389: astore 7
    //   391: aload 9
    //   393: invokeinterface 106 1 0
    //   398: ifeq +234 -> 632
    //   401: aload 9
    //   403: astore 6
    //   405: aload 9
    //   407: astore 7
    //   409: aload 9
    //   411: aload 9
    //   413: ldc 108
    //   415: invokeinterface 112 2 0
    //   420: invokeinterface 116 2 0
    //   425: astore 13
    //   427: aload 9
    //   429: astore 6
    //   431: aload 9
    //   433: astore 7
    //   435: aload 13
    //   437: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   440: ifne -57 -> 383
    //   443: aload 9
    //   445: astore 6
    //   447: aload 9
    //   449: astore 7
    //   451: aload 13
    //   453: invokevirtual 128	java/lang/String:length	()I
    //   456: bipush 8
    //   458: if_icmplt -75 -> 383
    //   461: aload 9
    //   463: astore 6
    //   465: aload 9
    //   467: astore 7
    //   469: aload 13
    //   471: invokestatic 133	com/baidu/trace/c/d:a	(Ljava/lang/String;)[B
    //   474: astore 8
    //   476: aload 9
    //   478: astore 6
    //   480: aload 9
    //   482: astore 7
    //   484: aload 13
    //   486: aload 13
    //   488: invokevirtual 128	java/lang/String:length	()I
    //   491: bipush 8
    //   493: isub
    //   494: aload 13
    //   496: invokevirtual 128	java/lang/String:length	()I
    //   499: invokevirtual 137	java/lang/String:substring	(II)Ljava/lang/String;
    //   502: bipush 16
    //   504: invokestatic 143	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   507: lstore 4
    //   509: aload 9
    //   511: astore 6
    //   513: aload 9
    //   515: astore 7
    //   517: new 28	java/lang/StringBuffer
    //   520: dup
    //   521: ldc -111
    //   523: invokespecial 33	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   526: astore 13
    //   528: aload 9
    //   530: astore 6
    //   532: aload 9
    //   534: astore 7
    //   536: aload 13
    //   538: ldc -109
    //   540: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   543: ldc -107
    //   545: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   548: ldc -105
    //   550: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   553: ldc -103
    //   555: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   558: pop
    //   559: aload 9
    //   561: astore 6
    //   563: aload 9
    //   565: astore 7
    //   567: getstatic 159	com/baidu/trace/Trace:e	Ljava/lang/String;
    //   570: astore 14
    //   572: aload 9
    //   574: astore 6
    //   576: aload 9
    //   578: astore 7
    //   580: aload_0
    //   581: getfield 19	com/baidu/trace/w:c	Landroid/database/sqlite/SQLiteDatabase;
    //   584: aload 13
    //   586: invokevirtual 83	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   589: iconst_3
    //   590: anewarray 4	java/lang/Object
    //   593: dup
    //   594: iconst_0
    //   595: lload 4
    //   597: invokestatic 163	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   600: aastore
    //   601: dup
    //   602: iconst_1
    //   603: aload 14
    //   605: aastore
    //   606: dup
    //   607: iconst_2
    //   608: aload 8
    //   610: aastore
    //   611: invokevirtual 166	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   614: goto -231 -> 383
    //   617: astore 7
    //   619: aload 6
    //   621: ifnull +10 -> 631
    //   624: aload 6
    //   626: invokeinterface 169 1 0
    //   631: return
    //   632: aload 9
    //   634: astore 6
    //   636: aload 9
    //   638: astore 7
    //   640: aload 9
    //   642: invokeinterface 169 1 0
    //   647: aconst_null
    //   648: astore 8
    //   650: aload 8
    //   652: astore 6
    //   654: aload 8
    //   656: astore 7
    //   658: new 28	java/lang/StringBuffer
    //   661: dup
    //   662: ldc -85
    //   664: invokespecial 33	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   667: astore 9
    //   669: aload 8
    //   671: astore 6
    //   673: aload 8
    //   675: astore 7
    //   677: aload 9
    //   679: ldc 94
    //   681: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   684: pop
    //   685: aload 8
    //   687: astore 6
    //   689: aload 8
    //   691: astore 7
    //   693: aload_0
    //   694: getfield 19	com/baidu/trace/w:c	Landroid/database/sqlite/SQLiteDatabase;
    //   697: aload 9
    //   699: invokevirtual 83	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   702: invokevirtual 88	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   705: aload 8
    //   707: astore 6
    //   709: aload 8
    //   711: astore 7
    //   713: new 28	java/lang/StringBuffer
    //   716: dup
    //   717: ldc 90
    //   719: invokespecial 33	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   722: astore 9
    //   724: aload 8
    //   726: astore 6
    //   728: aload 8
    //   730: astore 7
    //   732: aload 9
    //   734: ldc -83
    //   736: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   739: ldc -81
    //   741: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   744: pop
    //   745: aload 8
    //   747: astore 6
    //   749: aload 8
    //   751: astore 7
    //   753: aload_0
    //   754: getfield 19	com/baidu/trace/w:c	Landroid/database/sqlite/SQLiteDatabase;
    //   757: aload 9
    //   759: invokevirtual 83	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   762: invokevirtual 88	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   765: aload 8
    //   767: astore 6
    //   769: aload 8
    //   771: astore 7
    //   773: aload_0
    //   774: getfield 19	com/baidu/trace/w:c	Landroid/database/sqlite/SQLiteDatabase;
    //   777: aload 11
    //   779: invokevirtual 83	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   782: invokevirtual 88	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   785: aload 8
    //   787: astore 6
    //   789: aload 8
    //   791: astore 7
    //   793: new 28	java/lang/StringBuffer
    //   796: dup
    //   797: ldc 96
    //   799: invokespecial 33	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   802: astore 9
    //   804: aload 8
    //   806: astore 6
    //   808: aload 8
    //   810: astore 7
    //   812: aload 9
    //   814: ldc -81
    //   816: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   819: pop
    //   820: aload 8
    //   822: astore 6
    //   824: aload 8
    //   826: astore 7
    //   828: aload_0
    //   829: getfield 19	com/baidu/trace/w:c	Landroid/database/sqlite/SQLiteDatabase;
    //   832: aload 9
    //   834: invokevirtual 83	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   837: aconst_null
    //   838: invokevirtual 100	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   841: astore 8
    //   843: aload 8
    //   845: astore 6
    //   847: aload 6
    //   849: ifnull +573 -> 1422
    //   852: aload 6
    //   854: invokeinterface 106 1 0
    //   859: ifeq +464 -> 1323
    //   862: aload 6
    //   864: iconst_0
    //   865: invokeinterface 179 2 0
    //   870: lstore 4
    //   872: aload 6
    //   874: iconst_1
    //   875: invokeinterface 116 2 0
    //   880: astore 7
    //   882: aload 7
    //   884: ldc -75
    //   886: invokevirtual 184	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   889: istore_2
    //   890: aload 7
    //   892: ldc -70
    //   894: invokevirtual 184	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   897: istore_3
    //   898: iload_2
    //   899: ifle -47 -> 852
    //   902: iload_3
    //   903: ifle -51 -> 852
    //   906: aload 7
    //   908: iload_2
    //   909: iconst_1
    //   910: iadd
    //   911: iload_3
    //   912: invokevirtual 137	java/lang/String:substring	(II)Ljava/lang/String;
    //   915: ldc -68
    //   917: invokevirtual 192	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   920: astore 9
    //   922: new 194	android/content/ContentValues
    //   925: dup
    //   926: invokespecial 195	android/content/ContentValues:<init>	()V
    //   929: astore 7
    //   931: aload 7
    //   933: ldc -59
    //   935: getstatic 159	com/baidu/trace/Trace:e	Ljava/lang/String;
    //   938: invokevirtual 201	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   941: aload 7
    //   943: ldc -53
    //   945: getstatic 209	com/baidu/trace/api/fence/FenceShape:circle	Lcom/baidu/trace/api/fence/FenceShape;
    //   948: invokevirtual 212	com/baidu/trace/api/fence/FenceShape:name	()Ljava/lang/String;
    //   951: invokevirtual 201	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   954: aload 7
    //   956: ldc -42
    //   958: getstatic 220	com/baidu/trace/model/CoordType:bd09ll	Lcom/baidu/trace/model/CoordType;
    //   961: invokevirtual 221	com/baidu/trace/model/CoordType:name	()Ljava/lang/String;
    //   964: invokevirtual 201	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   967: aload 7
    //   969: ldc -33
    //   971: invokestatic 227	com/baidu/trace/c/e:c	()Ljava/lang/String;
    //   974: invokevirtual 201	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   977: aload 7
    //   979: ldc -27
    //   981: invokestatic 227	com/baidu/trace/c/e:c	()Ljava/lang/String;
    //   984: invokevirtual 201	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   987: lload 4
    //   989: aconst_null
    //   990: aconst_null
    //   991: aconst_null
    //   992: dconst_0
    //   993: iconst_0
    //   994: aconst_null
    //   995: invokestatic 235	com/baidu/trace/api/fence/CircleFence:buildLocalFence	(JLjava/lang/String;Ljava/lang/String;Lcom/baidu/trace/model/LatLng;DILcom/baidu/trace/model/CoordType;)Lcom/baidu/trace/api/fence/CircleFence;
    //   998: astore 8
    //   1000: aload 9
    //   1002: arraylength
    //   1003: istore_3
    //   1004: iconst_0
    //   1005: istore_2
    //   1006: iload_2
    //   1007: iload_3
    //   1008: if_icmpge +189 -> 1197
    //   1011: aload 9
    //   1013: iload_2
    //   1014: aaload
    //   1015: ldc -19
    //   1017: invokevirtual 192	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1020: astore 14
    //   1022: aload 14
    //   1024: arraylength
    //   1025: iconst_2
    //   1026: if_icmpne +410 -> 1436
    //   1029: aload 14
    //   1031: iconst_0
    //   1032: aaload
    //   1033: invokevirtual 240	java/lang/String:trim	()Ljava/lang/String;
    //   1036: astore 13
    //   1038: aload 14
    //   1040: iconst_1
    //   1041: aaload
    //   1042: invokevirtual 240	java/lang/String:trim	()Ljava/lang/String;
    //   1045: astore 14
    //   1047: ldc -15
    //   1049: aload 13
    //   1051: invokevirtual 245	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1054: ifeq +15 -> 1069
    //   1057: aload 7
    //   1059: ldc -9
    //   1061: aload 14
    //   1063: invokevirtual 201	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1066: goto +370 -> 1436
    //   1069: ldc -7
    //   1071: aload 13
    //   1073: invokevirtual 245	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1076: ifeq +48 -> 1124
    //   1079: aload 14
    //   1081: ldc -5
    //   1083: invokevirtual 192	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1086: astore 13
    //   1088: aload 13
    //   1090: arraylength
    //   1091: iconst_2
    //   1092: if_icmpne +344 -> 1436
    //   1095: aload 8
    //   1097: new 253	com/baidu/trace/model/LatLng
    //   1100: dup
    //   1101: aload 13
    //   1103: iconst_0
    //   1104: aaload
    //   1105: invokestatic 259	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   1108: aload 13
    //   1110: iconst_1
    //   1111: aaload
    //   1112: invokestatic 259	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   1115: invokespecial 262	com/baidu/trace/model/LatLng:<init>	(DD)V
    //   1118: invokevirtual 266	com/baidu/trace/api/fence/CircleFence:setCenter	(Lcom/baidu/trace/model/LatLng;)V
    //   1121: goto +315 -> 1436
    //   1124: ldc_w 268
    //   1127: aload 13
    //   1129: invokevirtual 245	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1132: ifeq +41 -> 1173
    //   1135: aload 8
    //   1137: aload 14
    //   1139: invokestatic 259	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   1142: invokevirtual 272	com/baidu/trace/api/fence/CircleFence:setRadius	(D)V
    //   1145: goto +291 -> 1436
    //   1148: astore 8
    //   1150: aload 6
    //   1152: astore 7
    //   1154: aload 8
    //   1156: astore 6
    //   1158: aload 7
    //   1160: ifnull +10 -> 1170
    //   1163: aload 7
    //   1165: invokeinterface 169 1 0
    //   1170: aload 6
    //   1172: athrow
    //   1173: ldc_w 274
    //   1176: aload 13
    //   1178: invokevirtual 245	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1181: ifeq +255 -> 1436
    //   1184: aload 7
    //   1186: ldc_w 276
    //   1189: aload 14
    //   1191: invokevirtual 201	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1194: goto +242 -> 1436
    //   1197: new 28	java/lang/StringBuffer
    //   1200: dup
    //   1201: invokespecial 277	java/lang/StringBuffer:<init>	()V
    //   1204: astore 9
    //   1206: aload 8
    //   1208: aconst_null
    //   1209: aload 9
    //   1211: invokestatic 282	com/baidu/trace/a:a	(Lcom/baidu/trace/api/fence/CircleFence;Ljava/lang/StringBuffer;Ljava/lang/StringBuffer;)V
    //   1214: aload 7
    //   1216: ldc_w 284
    //   1219: aload 9
    //   1221: invokevirtual 83	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1224: invokevirtual 201	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1227: lload 4
    //   1229: lconst_0
    //   1230: lcmp
    //   1231: ifle +75 -> 1306
    //   1234: new 194	android/content/ContentValues
    //   1237: dup
    //   1238: invokespecial 195	android/content/ContentValues:<init>	()V
    //   1241: astore 8
    //   1243: aload 8
    //   1245: ldc_w 286
    //   1248: lload 4
    //   1250: lconst_1
    //   1251: lsub
    //   1252: invokestatic 163	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1255: invokevirtual 289	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1258: new 28	java/lang/StringBuffer
    //   1261: dup
    //   1262: ldc -15
    //   1264: invokespecial 33	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   1267: astore 9
    //   1269: aload 9
    //   1271: ldc_w 291
    //   1274: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1277: pop
    //   1278: aload_0
    //   1279: getfield 19	com/baidu/trace/w:c	Landroid/database/sqlite/SQLiteDatabase;
    //   1282: ldc_w 293
    //   1285: aload 8
    //   1287: aload 9
    //   1289: invokevirtual 83	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1292: iconst_1
    //   1293: anewarray 124	java/lang/String
    //   1296: dup
    //   1297: iconst_0
    //   1298: ldc_w 295
    //   1301: aastore
    //   1302: invokevirtual 299	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1305: pop
    //   1306: aload_0
    //   1307: getfield 19	com/baidu/trace/w:c	Landroid/database/sqlite/SQLiteDatabase;
    //   1310: ldc_w 295
    //   1313: aconst_null
    //   1314: aload 7
    //   1316: invokevirtual 303	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   1319: pop2
    //   1320: goto -468 -> 852
    //   1323: aload 6
    //   1325: invokeinterface 169 1 0
    //   1330: aconst_null
    //   1331: astore 8
    //   1333: aload 8
    //   1335: astore 6
    //   1337: aload 8
    //   1339: astore 7
    //   1341: new 28	java/lang/StringBuffer
    //   1344: dup
    //   1345: ldc -85
    //   1347: invokespecial 33	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   1350: astore 9
    //   1352: aload 8
    //   1354: astore 6
    //   1356: aload 8
    //   1358: astore 7
    //   1360: aload 9
    //   1362: ldc -81
    //   1364: invokevirtual 39	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1367: pop
    //   1368: aload 8
    //   1370: astore 6
    //   1372: aload 8
    //   1374: astore 7
    //   1376: aload_0
    //   1377: getfield 19	com/baidu/trace/w:c	Landroid/database/sqlite/SQLiteDatabase;
    //   1380: aload 9
    //   1382: invokevirtual 83	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1385: invokevirtual 88	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   1388: goto +41 -> 1429
    //   1391: astore 6
    //   1393: goto -235 -> 1158
    //   1396: aload 8
    //   1398: ifnull -767 -> 631
    //   1401: aload 8
    //   1403: invokeinterface 169 1 0
    //   1408: return
    //   1409: astore 6
    //   1411: aconst_null
    //   1412: astore 7
    //   1414: goto -256 -> 1158
    //   1417: astore 8
    //   1419: goto -113 -> 1306
    //   1422: aload 6
    //   1424: astore 8
    //   1426: goto -93 -> 1333
    //   1429: iload_1
    //   1430: iconst_1
    //   1431: iadd
    //   1432: istore_1
    //   1433: goto -1265 -> 168
    //   1436: iload_2
    //   1437: iconst_1
    //   1438: iadd
    //   1439: istore_2
    //   1440: goto -434 -> 1006
    //   1443: astore 7
    //   1445: goto -826 -> 619
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1448	0	this	w
    //   167	1266	1	i	int
    //   889	551	2	j	int
    //   897	112	3	k	int
    //   507	742	4	l	long
    //   158	1213	6	localObject1	Object
    //   1391	1	6	localObject2	Object
    //   1409	14	6	localObject3	Object
    //   174	405	7	localObject4	Object
    //   617	1	7	localException1	Exception
    //   638	775	7	localObject5	Object
    //   1443	1	7	localException2	Exception
    //   161	975	8	localObject6	Object
    //   1148	59	8	localCircleFence	com.baidu.trace.api.fence.CircleFence
    //   1241	161	8	localContentValues	android.content.ContentValues
    //   1417	1	8	localException3	Exception
    //   1424	1	8	localObject7	Object
    //   253	1128	9	localObject8	Object
    //   9	300	10	localStringBuffer1	StringBuffer
    //   43	735	11	localStringBuffer2	StringBuffer
    //   112	117	12	localStringBuffer3	StringBuffer
    //   425	752	13	localObject9	Object
    //   570	620	14	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   163	168	617	java/lang/Exception
    //   176	184	617	java/lang/Exception
    //   192	216	617	java/lang/Exception
    //   224	236	617	java/lang/Exception
    //   244	255	617	java/lang/Exception
    //   263	276	617	java/lang/Exception
    //   284	296	617	java/lang/Exception
    //   304	316	617	java/lang/Exception
    //   324	335	617	java/lang/Exception
    //   343	351	617	java/lang/Exception
    //   359	374	617	java/lang/Exception
    //   391	401	617	java/lang/Exception
    //   409	427	617	java/lang/Exception
    //   435	443	617	java/lang/Exception
    //   451	461	617	java/lang/Exception
    //   469	476	617	java/lang/Exception
    //   484	509	617	java/lang/Exception
    //   517	528	617	java/lang/Exception
    //   536	559	617	java/lang/Exception
    //   567	572	617	java/lang/Exception
    //   580	614	617	java/lang/Exception
    //   640	647	617	java/lang/Exception
    //   658	669	617	java/lang/Exception
    //   677	685	617	java/lang/Exception
    //   693	705	617	java/lang/Exception
    //   713	724	617	java/lang/Exception
    //   732	745	617	java/lang/Exception
    //   753	765	617	java/lang/Exception
    //   773	785	617	java/lang/Exception
    //   793	804	617	java/lang/Exception
    //   812	820	617	java/lang/Exception
    //   828	843	617	java/lang/Exception
    //   1341	1352	617	java/lang/Exception
    //   1360	1368	617	java/lang/Exception
    //   1376	1388	617	java/lang/Exception
    //   852	898	1148	finally
    //   906	1004	1148	finally
    //   1011	1066	1148	finally
    //   1069	1121	1148	finally
    //   1124	1145	1148	finally
    //   1173	1194	1148	finally
    //   1197	1227	1148	finally
    //   1234	1306	1148	finally
    //   1306	1320	1148	finally
    //   1323	1330	1148	finally
    //   176	184	1391	finally
    //   192	216	1391	finally
    //   224	236	1391	finally
    //   244	255	1391	finally
    //   263	276	1391	finally
    //   284	296	1391	finally
    //   304	316	1391	finally
    //   324	335	1391	finally
    //   343	351	1391	finally
    //   359	374	1391	finally
    //   391	401	1391	finally
    //   409	427	1391	finally
    //   435	443	1391	finally
    //   451	461	1391	finally
    //   469	476	1391	finally
    //   484	509	1391	finally
    //   517	528	1391	finally
    //   536	559	1391	finally
    //   567	572	1391	finally
    //   580	614	1391	finally
    //   640	647	1391	finally
    //   658	669	1391	finally
    //   677	685	1391	finally
    //   693	705	1391	finally
    //   713	724	1391	finally
    //   732	745	1391	finally
    //   753	765	1391	finally
    //   773	785	1391	finally
    //   793	804	1391	finally
    //   812	820	1391	finally
    //   828	843	1391	finally
    //   1341	1352	1391	finally
    //   1360	1368	1391	finally
    //   1376	1388	1391	finally
    //   163	168	1409	finally
    //   1234	1306	1417	java/lang/Exception
    //   852	898	1443	java/lang/Exception
    //   906	1004	1443	java/lang/Exception
    //   1011	1066	1443	java/lang/Exception
    //   1069	1121	1443	java/lang/Exception
    //   1124	1145	1443	java/lang/Exception
    //   1173	1194	1443	java/lang/Exception
    //   1197	1227	1443	java/lang/Exception
    //   1306	1320	1443	java/lang/Exception
    //   1323	1330	1443	java/lang/Exception
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */