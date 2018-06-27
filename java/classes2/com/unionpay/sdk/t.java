package com.unionpay.sdk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

final class t
  extends bg
{
  private static volatile t a = null;
  private static SQLiteDatabase b;
  private static int c;
  private final int d = 1;
  private final int e = 2;
  private final int f = 3;
  
  /* Error */
  private long a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, int paramInt)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_1
    //   6: invokestatic 43	com/unionpay/sdk/r:b	(Ljava/lang/String;)Z
    //   9: istore 8
    //   11: iload 8
    //   13: ifeq +8 -> 21
    //   16: aload_0
    //   17: monitorexit
    //   18: lload 6
    //   20: lreturn
    //   21: getstatic 45	com/unionpay/sdk/t:b	Landroid/database/sqlite/SQLiteDatabase;
    //   24: invokevirtual 50	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   27: iload 5
    //   29: tableswitch	default:+27->56, 1:+85->114, 2:+99->128, 3:+116->145
    //   56: lconst_0
    //   57: lstore 6
    //   59: getstatic 45	com/unionpay/sdk/t:b	Landroid/database/sqlite/SQLiteDatabase;
    //   62: invokevirtual 53	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   65: getstatic 45	com/unionpay/sdk/t:b	Landroid/database/sqlite/SQLiteDatabase;
    //   68: invokevirtual 56	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   71: iconst_2
    //   72: anewarray 58	java/lang/String
    //   75: dup
    //   76: iconst_0
    //   77: ldc 60
    //   79: aastore
    //   80: dup
    //   81: iconst_1
    //   82: new 62	java/lang/StringBuilder
    //   85: dup
    //   86: ldc 64
    //   88: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: lload 6
    //   93: invokestatic 71	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   96: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: aastore
    //   103: invokestatic 84	com/unionpay/sdk/k:b	([Ljava/lang/String;)V
    //   106: goto -90 -> 16
    //   109: astore_1
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic 45	com/unionpay/sdk/t:b	Landroid/database/sqlite/SQLiteDatabase;
    //   117: aload_1
    //   118: aconst_null
    //   119: aload_2
    //   120: invokevirtual 88	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   123: lstore 6
    //   125: goto -66 -> 59
    //   128: getstatic 45	com/unionpay/sdk/t:b	Landroid/database/sqlite/SQLiteDatabase;
    //   131: aload_1
    //   132: aload_2
    //   133: aload_3
    //   134: aload 4
    //   136: invokevirtual 92	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   139: i2l
    //   140: lstore 6
    //   142: goto -83 -> 59
    //   145: getstatic 45	com/unionpay/sdk/t:b	Landroid/database/sqlite/SQLiteDatabase;
    //   148: aload_1
    //   149: aload_3
    //   150: aload 4
    //   152: invokevirtual 96	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   155: istore 5
    //   157: iload 5
    //   159: i2l
    //   160: lstore 6
    //   162: goto -103 -> 59
    //   165: astore_1
    //   166: lconst_0
    //   167: lstore 6
    //   169: aload_1
    //   170: invokestatic 99	com/unionpay/sdk/k:a	(Ljava/lang/Throwable;)V
    //   173: getstatic 45	com/unionpay/sdk/t:b	Landroid/database/sqlite/SQLiteDatabase;
    //   176: invokevirtual 56	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   179: goto -108 -> 71
    //   182: astore_1
    //   183: getstatic 45	com/unionpay/sdk/t:b	Landroid/database/sqlite/SQLiteDatabase;
    //   186: invokevirtual 56	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   189: aload_1
    //   190: athrow
    //   191: astore_1
    //   192: goto -23 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	t
    //   0	195	1	paramString1	String
    //   0	195	2	paramContentValues	ContentValues
    //   0	195	3	paramString2	String
    //   0	195	4	paramArrayOfString	String[]
    //   0	195	5	paramInt	int
    //   1	167	6	l	long
    //   9	3	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	11	109	finally
    //   21	27	109	finally
    //   65	71	109	finally
    //   71	106	109	finally
    //   173	179	109	finally
    //   183	191	109	finally
    //   114	125	165	java/lang/Throwable
    //   128	142	165	java/lang/Throwable
    //   145	157	165	java/lang/Throwable
    //   59	65	182	finally
    //   114	125	182	finally
    //   128	142	182	finally
    //   145	157	182	finally
    //   169	173	182	finally
    //   59	65	191	java/lang/Throwable
  }
  
  /* Error */
  private long a(String paramString, w.c paramc, StringBuffer paramStringBuffer)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 45	com/unionpay/sdk/t:b	Landroid/database/sqlite/SQLiteDatabase;
    //   5: ldc 102
    //   7: getstatic 105	com/unionpay/sdk/t$c:a	[Ljava/lang/String;
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: ldc 107
    //   16: invokevirtual 111	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore 10
    //   21: aload_1
    //   22: ldc 113
    //   24: invokevirtual 117	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   27: astore_1
    //   28: aload_1
    //   29: arraylength
    //   30: istore 4
    //   32: iload 4
    //   34: iconst_3
    //   35: if_icmpge +23 -> 58
    //   38: aload 10
    //   40: ifnull +10 -> 50
    //   43: aload 10
    //   45: invokeinterface 122 1 0
    //   50: lconst_0
    //   51: lstore 5
    //   53: aload_0
    //   54: monitorexit
    //   55: lload 5
    //   57: lreturn
    //   58: new 62	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   65: aload_1
    //   66: iconst_0
    //   67: aaload
    //   68: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 113
    //   73: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: iconst_1
    //   78: aaload
    //   79: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 113
    //   84: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_1
    //   88: iconst_2
    //   89: aaload
    //   90: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: astore_1
    //   97: aload_3
    //   98: aload_1
    //   99: invokestatic 126	com/unionpay/sdk/r:c	(Ljava/lang/String;)Ljava/lang/String;
    //   102: invokevirtual 131	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   105: pop
    //   106: aload 10
    //   108: invokeinterface 135 1 0
    //   113: ifeq +252 -> 365
    //   116: aload 10
    //   118: invokeinterface 138 1 0
    //   123: istore 9
    //   125: iload 9
    //   127: ifne +238 -> 365
    //   130: aload_2
    //   131: aload 10
    //   133: iconst_1
    //   134: invokeinterface 142 2 0
    //   139: invokestatic 146	com/unionpay/sdk/bj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   142: invokestatic 152	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   145: putfield 157	com/unionpay/sdk/w$c:a	J
    //   148: aload_2
    //   149: aload 10
    //   151: iconst_2
    //   152: invokeinterface 161 2 0
    //   157: putfield 164	com/unionpay/sdk/w$c:d	[B
    //   160: aload_2
    //   161: aload 10
    //   163: iconst_3
    //   164: invokeinterface 142 2 0
    //   169: invokestatic 146	com/unionpay/sdk/bj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   172: invokestatic 170	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   175: putfield 172	com/unionpay/sdk/w$c:b	I
    //   178: new 58	java/lang/String
    //   181: dup
    //   182: aload_2
    //   183: getfield 164	com/unionpay/sdk/w$c:d	[B
    //   186: ldc -82
    //   188: invokespecial 177	java/lang/String:<init>	([BLjava/lang/String;)V
    //   191: astore_3
    //   192: aload_3
    //   193: invokevirtual 181	java/lang/String:length	()I
    //   196: aload_1
    //   197: invokevirtual 181	java/lang/String:length	()I
    //   200: if_icmplt -84 -> 116
    //   203: aload_3
    //   204: ldc 113
    //   206: invokevirtual 117	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   209: astore_3
    //   210: aload_3
    //   211: arraylength
    //   212: iconst_3
    //   213: if_icmplt -97 -> 116
    //   216: new 62	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   223: aload_3
    //   224: iconst_0
    //   225: aaload
    //   226: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: ldc 113
    //   231: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_3
    //   235: iconst_1
    //   236: aaload
    //   237: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc 113
    //   242: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload_3
    //   246: iconst_2
    //   247: aaload
    //   248: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: aload_1
    //   255: invokevirtual 185	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   258: ifeq +81 -> 339
    //   261: aload 10
    //   263: iconst_0
    //   264: invokeinterface 189 2 0
    //   269: lstore 7
    //   271: lload 7
    //   273: lstore 5
    //   275: aload 10
    //   277: ifnull -224 -> 53
    //   280: aload 10
    //   282: invokeinterface 122 1 0
    //   287: lload 7
    //   289: lstore 5
    //   291: goto -238 -> 53
    //   294: astore_1
    //   295: aload_0
    //   296: monitorexit
    //   297: aload_1
    //   298: athrow
    //   299: astore_3
    //   300: aload_3
    //   301: invokestatic 99	com/unionpay/sdk/k:a	(Ljava/lang/Throwable;)V
    //   304: aload 10
    //   306: invokeinterface 192 1 0
    //   311: pop
    //   312: goto -196 -> 116
    //   315: astore_2
    //   316: aload 10
    //   318: astore_1
    //   319: aload_2
    //   320: invokestatic 99	com/unionpay/sdk/k:a	(Ljava/lang/Throwable;)V
    //   323: aload_1
    //   324: ifnull +9 -> 333
    //   327: aload_1
    //   328: invokeinterface 122 1 0
    //   333: lconst_0
    //   334: lstore 5
    //   336: goto -283 -> 53
    //   339: aload 10
    //   341: invokeinterface 192 1 0
    //   346: pop
    //   347: goto -231 -> 116
    //   350: astore_1
    //   351: aload 10
    //   353: ifnull +10 -> 363
    //   356: aload 10
    //   358: invokeinterface 122 1 0
    //   363: aload_1
    //   364: athrow
    //   365: aload 10
    //   367: ifnull -34 -> 333
    //   370: aload 10
    //   372: invokeinterface 122 1 0
    //   377: goto -44 -> 333
    //   380: astore_1
    //   381: aconst_null
    //   382: astore 10
    //   384: goto -33 -> 351
    //   387: astore_2
    //   388: aload_1
    //   389: astore 10
    //   391: aload_2
    //   392: astore_1
    //   393: goto -42 -> 351
    //   396: astore_2
    //   397: aconst_null
    //   398: astore_1
    //   399: goto -80 -> 319
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	this	t
    //   0	402	1	paramString	String
    //   0	402	2	paramc	w.c
    //   0	402	3	paramStringBuffer	StringBuffer
    //   30	6	4	i	int
    //   51	284	5	l1	long
    //   269	19	7	l2	long
    //   123	3	9	bool	boolean
    //   19	371	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   43	50	294	finally
    //   280	287	294	finally
    //   327	333	294	finally
    //   356	363	294	finally
    //   363	365	294	finally
    //   370	377	294	finally
    //   130	178	299	java/lang/Throwable
    //   21	32	315	java/lang/Throwable
    //   58	116	315	java/lang/Throwable
    //   116	125	315	java/lang/Throwable
    //   178	271	315	java/lang/Throwable
    //   300	312	315	java/lang/Throwable
    //   339	347	315	java/lang/Throwable
    //   21	32	350	finally
    //   58	116	350	finally
    //   116	125	350	finally
    //   130	178	350	finally
    //   178	271	350	finally
    //   300	312	350	finally
    //   339	347	350	finally
    //   2	21	380	finally
    //   319	323	387	finally
    //   2	21	396	java/lang/Throwable
  }
  
  static t a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new t();
      }
      return a;
    }
    finally {}
  }
  
  /* Error */
  private static java.util.Map a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +8 -> 9
    //   4: aload_0
    //   5: arraylength
    //   6: ifne +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 197	java/util/HashMap
    //   14: dup
    //   15: invokespecial 198	java/util/HashMap:<init>	()V
    //   18: astore 6
    //   20: new 200	java/io/ByteArrayInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 203	java/io/ByteArrayInputStream:<init>	([B)V
    //   28: astore_0
    //   29: new 205	java/io/DataInputStream
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 208	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   37: astore 5
    //   39: aload 5
    //   41: invokevirtual 211	java/io/DataInputStream:readInt	()I
    //   44: istore_2
    //   45: iconst_0
    //   46: istore_1
    //   47: iload_1
    //   48: iload_2
    //   49: if_icmpge +78 -> 127
    //   52: aload 5
    //   54: invokevirtual 214	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   57: astore 7
    //   59: aload 5
    //   61: invokevirtual 211	java/io/DataInputStream:readInt	()I
    //   64: istore_3
    //   65: iload_3
    //   66: bipush 66
    //   68: if_icmpne +32 -> 100
    //   71: aload 5
    //   73: invokevirtual 218	java/io/DataInputStream:readDouble	()D
    //   76: invokestatic 223	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   79: astore 4
    //   81: aload 6
    //   83: aload 7
    //   85: aload 4
    //   87: invokeinterface 229 3 0
    //   92: pop
    //   93: iload_1
    //   94: iconst_1
    //   95: iadd
    //   96: istore_1
    //   97: goto -50 -> 47
    //   100: iload_3
    //   101: bipush 88
    //   103: if_icmpne +13 -> 116
    //   106: aload 5
    //   108: invokevirtual 214	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   111: astore 4
    //   113: goto -32 -> 81
    //   116: aload_0
    //   117: invokestatic 232	com/unionpay/sdk/t:a	(Ljava/io/Closeable;)V
    //   120: aload 5
    //   122: invokestatic 232	com/unionpay/sdk/t:a	(Ljava/io/Closeable;)V
    //   125: aconst_null
    //   126: areturn
    //   127: aload_0
    //   128: invokestatic 232	com/unionpay/sdk/t:a	(Ljava/io/Closeable;)V
    //   131: aload 5
    //   133: invokestatic 232	com/unionpay/sdk/t:a	(Ljava/io/Closeable;)V
    //   136: aload 6
    //   138: areturn
    //   139: astore_0
    //   140: aconst_null
    //   141: astore_0
    //   142: aconst_null
    //   143: astore 4
    //   145: aload 4
    //   147: invokestatic 232	com/unionpay/sdk/t:a	(Ljava/io/Closeable;)V
    //   150: aload_0
    //   151: invokestatic 232	com/unionpay/sdk/t:a	(Ljava/io/Closeable;)V
    //   154: aconst_null
    //   155: areturn
    //   156: astore 4
    //   158: aconst_null
    //   159: astore 5
    //   161: aconst_null
    //   162: astore_0
    //   163: aload_0
    //   164: invokestatic 232	com/unionpay/sdk/t:a	(Ljava/io/Closeable;)V
    //   167: aload 5
    //   169: invokestatic 232	com/unionpay/sdk/t:a	(Ljava/io/Closeable;)V
    //   172: aload 4
    //   174: athrow
    //   175: astore 4
    //   177: aconst_null
    //   178: astore 5
    //   180: goto -17 -> 163
    //   183: astore 4
    //   185: goto -22 -> 163
    //   188: astore 4
    //   190: aconst_null
    //   191: astore 5
    //   193: aload_0
    //   194: astore 4
    //   196: aload 5
    //   198: astore_0
    //   199: goto -54 -> 145
    //   202: astore 4
    //   204: aload_0
    //   205: astore 4
    //   207: aload 5
    //   209: astore_0
    //   210: goto -65 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramArrayOfByte	byte[]
    //   46	51	1	i	int
    //   44	6	2	j	int
    //   64	40	3	k	int
    //   79	67	4	localObject1	Object
    //   156	17	4	localObject2	Object
    //   175	1	4	localObject3	Object
    //   183	1	4	localObject4	Object
    //   188	1	4	localThrowable1	Throwable
    //   194	1	4	arrayOfByte1	byte[]
    //   202	1	4	localThrowable2	Throwable
    //   205	1	4	arrayOfByte2	byte[]
    //   37	171	5	localDataInputStream	java.io.DataInputStream
    //   18	119	6	localHashMap	java.util.HashMap
    //   57	27	7	str	String
    // Exception table:
    //   from	to	target	type
    //   11	29	139	java/lang/Throwable
    //   11	29	156	finally
    //   29	39	175	finally
    //   39	45	183	finally
    //   52	65	183	finally
    //   71	81	183	finally
    //   81	93	183	finally
    //   106	113	183	finally
    //   29	39	188	java/lang/Throwable
    //   39	45	202	java/lang/Throwable
    //   52	65	202	java/lang/Throwable
    //   71	81	202	java/lang/Throwable
    //   81	93	202	java/lang/Throwable
    //   106	113	202	java/lang/Throwable
  }
  
  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable)
    {
      k.a(paramCloseable);
    }
  }
  
  /* Error */
  private static byte[] a(java.util.Map paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +12 -> 13
    //   4: aload_0
    //   5: invokeinterface 239 1 0
    //   10: ifne +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: invokeinterface 239 1 0
    //   21: bipush 10
    //   23: if_icmple +129 -> 152
    //   26: bipush 10
    //   28: istore_1
    //   29: new 241	java/io/ByteArrayOutputStream
    //   32: dup
    //   33: invokespecial 242	java/io/ByteArrayOutputStream:<init>	()V
    //   36: astore_2
    //   37: new 244	java/io/DataOutputStream
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 247	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   45: astore_3
    //   46: aload_3
    //   47: iload_1
    //   48: invokevirtual 251	java/io/DataOutputStream:writeInt	(I)V
    //   51: aload_0
    //   52: invokeinterface 255 1 0
    //   57: invokeinterface 261 1 0
    //   62: astore_0
    //   63: iconst_0
    //   64: istore_1
    //   65: aload_0
    //   66: invokeinterface 266 1 0
    //   71: ifeq +66 -> 137
    //   74: aload_0
    //   75: invokeinterface 270 1 0
    //   80: checkcast 272	java/util/Map$Entry
    //   83: astore 4
    //   85: aload_3
    //   86: aload 4
    //   88: invokeinterface 275 1 0
    //   93: checkcast 58	java/lang/String
    //   96: invokevirtual 278	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   99: aload 4
    //   101: invokeinterface 281 1 0
    //   106: astore 4
    //   108: aload 4
    //   110: instanceof 283
    //   113: ifeq +49 -> 162
    //   116: aload_3
    //   117: bipush 66
    //   119: invokevirtual 251	java/io/DataOutputStream:writeInt	(I)V
    //   122: aload_3
    //   123: aload 4
    //   125: checkcast 283	java/lang/Number
    //   128: invokevirtual 286	java/lang/Number:doubleValue	()D
    //   131: invokevirtual 290	java/io/DataOutputStream:writeDouble	(D)V
    //   134: goto +104 -> 238
    //   137: aload_2
    //   138: invokevirtual 294	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   141: astore_0
    //   142: aload_2
    //   143: invokestatic 232	com/unionpay/sdk/t:a	(Ljava/io/Closeable;)V
    //   146: aload_3
    //   147: invokestatic 232	com/unionpay/sdk/t:a	(Ljava/io/Closeable;)V
    //   150: aload_0
    //   151: areturn
    //   152: aload_0
    //   153: invokeinterface 239 1 0
    //   158: istore_1
    //   159: goto -130 -> 29
    //   162: aload_3
    //   163: bipush 88
    //   165: invokevirtual 251	java/io/DataOutputStream:writeInt	(I)V
    //   168: aload_3
    //   169: aload 4
    //   171: invokevirtual 297	java/lang/Object:toString	()Ljava/lang/String;
    //   174: invokestatic 299	com/unionpay/sdk/r:a	(Ljava/lang/String;)Ljava/lang/String;
    //   177: invokevirtual 278	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   180: goto +58 -> 238
    //   183: astore_0
    //   184: aload_3
    //   185: astore_0
    //   186: aload_2
    //   187: invokestatic 232	com/unionpay/sdk/t:a	(Ljava/io/Closeable;)V
    //   190: aload_0
    //   191: invokestatic 232	com/unionpay/sdk/t:a	(Ljava/io/Closeable;)V
    //   194: aconst_null
    //   195: areturn
    //   196: astore_0
    //   197: aconst_null
    //   198: astore_3
    //   199: aconst_null
    //   200: astore_2
    //   201: aload_2
    //   202: invokestatic 232	com/unionpay/sdk/t:a	(Ljava/io/Closeable;)V
    //   205: aload_3
    //   206: invokestatic 232	com/unionpay/sdk/t:a	(Ljava/io/Closeable;)V
    //   209: aload_0
    //   210: athrow
    //   211: astore_0
    //   212: aconst_null
    //   213: astore_3
    //   214: goto -13 -> 201
    //   217: astore_0
    //   218: goto -17 -> 201
    //   221: astore_0
    //   222: aconst_null
    //   223: astore_0
    //   224: aconst_null
    //   225: astore_2
    //   226: goto -40 -> 186
    //   229: astore_0
    //   230: aconst_null
    //   231: astore_0
    //   232: goto -46 -> 186
    //   235: goto -170 -> 65
    //   238: iload_1
    //   239: iconst_1
    //   240: iadd
    //   241: istore_1
    //   242: iload_1
    //   243: bipush 10
    //   245: if_icmpne -10 -> 235
    //   248: goto -111 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	paramMap	java.util.Map
    //   28	218	1	i	int
    //   36	190	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   45	169	3	localDataOutputStream	java.io.DataOutputStream
    //   83	87	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   46	63	183	java/lang/Throwable
    //   65	134	183	java/lang/Throwable
    //   137	142	183	java/lang/Throwable
    //   162	180	183	java/lang/Throwable
    //   29	37	196	finally
    //   37	46	211	finally
    //   46	63	217	finally
    //   65	134	217	finally
    //   137	142	217	finally
    //   162	180	217	finally
    //   29	37	221	java/lang/Throwable
    //   37	46	229	java/lang/Throwable
  }
  
  /* Error */
  private long e(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: getstatic 45	com/unionpay/sdk/t:b	Landroid/database/sqlite/SQLiteDatabase;
    //   8: ldc_w 302
    //   11: getstatic 303	com/unionpay/sdk/t$a:a	[Ljava/lang/String;
    //   14: ldc_w 305
    //   17: iconst_1
    //   18: anewarray 58	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: lload_1
    //   24: invokestatic 71	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   27: aastore
    //   28: aconst_null
    //   29: aconst_null
    //   30: ldc 107
    //   32: invokevirtual 111	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   35: astore 5
    //   37: aload 5
    //   39: invokeinterface 135 1 0
    //   44: ifeq +49 -> 93
    //   47: aload 5
    //   49: invokeinterface 138 1 0
    //   54: ifne +39 -> 93
    //   57: aload 5
    //   59: bipush 6
    //   61: invokeinterface 142 2 0
    //   66: invokestatic 146	com/unionpay/sdk/bj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   69: invokestatic 152	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   72: lstore_1
    //   73: lload_1
    //   74: lstore_3
    //   75: aload 5
    //   77: ifnull +12 -> 89
    //   80: aload 5
    //   82: invokeinterface 122 1 0
    //   87: lload_1
    //   88: lstore_3
    //   89: aload_0
    //   90: monitorexit
    //   91: lload_3
    //   92: lreturn
    //   93: aload 5
    //   95: ifnull +10 -> 105
    //   98: aload 5
    //   100: invokeinterface 122 1 0
    //   105: lconst_0
    //   106: lstore_3
    //   107: goto -18 -> 89
    //   110: astore 6
    //   112: aconst_null
    //   113: astore 5
    //   115: aload 6
    //   117: invokestatic 99	com/unionpay/sdk/k:a	(Ljava/lang/Throwable;)V
    //   120: aload 5
    //   122: ifnull -17 -> 105
    //   125: aload 5
    //   127: invokeinterface 122 1 0
    //   132: goto -27 -> 105
    //   135: astore 5
    //   137: aload_0
    //   138: monitorexit
    //   139: aload 5
    //   141: athrow
    //   142: astore 5
    //   144: aload 6
    //   146: ifnull +10 -> 156
    //   149: aload 6
    //   151: invokeinterface 122 1 0
    //   156: aload 5
    //   158: athrow
    //   159: astore 7
    //   161: aload 5
    //   163: astore 6
    //   165: aload 7
    //   167: astore 5
    //   169: goto -25 -> 144
    //   172: astore 7
    //   174: aload 5
    //   176: astore 6
    //   178: aload 7
    //   180: astore 5
    //   182: goto -38 -> 144
    //   185: astore 6
    //   187: goto -72 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	t
    //   0	190	1	paramLong	long
    //   74	33	3	l	long
    //   35	91	5	localCursor	Cursor
    //   135	5	5	localObject1	Object
    //   142	20	5	localObject2	Object
    //   167	14	5	localObject3	Object
    //   1	1	6	localObject4	Object
    //   110	40	6	localThrowable1	Throwable
    //   163	14	6	localObject5	Object
    //   185	1	6	localThrowable2	Throwable
    //   159	7	7	localObject6	Object
    //   172	7	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   5	37	110	java/lang/Throwable
    //   80	87	135	finally
    //   98	105	135	finally
    //   125	132	135	finally
    //   149	156	135	finally
    //   156	159	135	finally
    //   5	37	142	finally
    //   37	73	159	finally
    //   115	120	172	finally
    //   37	73	185	java/lang/Throwable
  }
  
  private void e()
  {
    for (;;)
    {
      try
      {
        if (d.c != null)
        {
          if (b != null) {
            break label160;
          }
          File localFile = new File(d.c.getFilesDir(), "UPtcagent.db");
          boolean bool = localFile.exists();
          if (!localFile.getParentFile().exists()) {
            localFile.getParentFile().mkdirs();
          }
          SQLiteDatabase localSQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(localFile, null);
          b = localSQLiteDatabase;
          localSQLiteDatabase.setLockingEnabled(true);
          if ((localFile.length() > 6144000L) && (localFile.length() > 8089600L))
          {
            f();
            g();
          }
          b.setMaximumSize(8192000L);
          c = 1;
          if (bool) {
            continue;
          }
          g();
        }
      }
      catch (Throwable localThrowable)
      {
        if (!ag.a) {
          continue;
        }
        localThrowable.printStackTrace();
        continue;
      }
      finally {}
      return;
      if (6 > b.getVersion())
      {
        f();
        g();
        continue;
        label160:
        c += 1;
      }
    }
  }
  
  private static void f()
  {
    b.setVersion(6);
    d.b(b);
    a.b(b);
    b.b(b);
    c.b(b);
  }
  
  private static void g()
  {
    b.setVersion(6);
    d.a(b);
    a.a(b);
    b.a(b);
    c.a(b);
  }
  
  private void h()
  {
    try
    {
      c -= 1;
      int i = Math.max(0, c);
      c = i;
      if ((i == 0) && (b != null))
      {
        b.close();
        b = null;
      }
      return;
    }
    finally {}
  }
  
  final long a(long paramLong)
  {
    try
    {
      k.b(new String[] { "[Delete Activity LT Id] ", "activityId:" + paramLong });
      paramLong = a("activity", null, "_id<=? AND duration !=? ", new String[] { String.valueOf(paramLong), bj.a("0") }, 3);
      return paramLong;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final long a(long paramLong1, long paramLong2)
  {
    try
    {
      k.b(new String[] { "[Update Activity] ", "activityId:" + String.valueOf(paramLong1), ", endRealTime:" + String.valueOf(paramLong2) });
      long l1 = e(paramLong1);
      long l2 = (paramLong2 - l1) / 1000L;
      k.b(new String[] { String.format("%d - %d / 1000 = %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(l1), Long.valueOf(l2) }) });
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("duration", bj.a(String.valueOf(l2)));
      paramLong1 = a("activity", localContentValues, "_id=?", new String[] { String.valueOf(paramLong1) }, 2);
      return paramLong1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final long a(long paramLong, String paramString)
  {
    for (;;)
    {
      ContentValues localContentValues;
      w.c localc;
      try
      {
        k.b(new String[] { "[Save Error] ", "errorTime:" + paramLong, ", data:" + paramString });
        localContentValues = new ContentValues();
        localContentValues.put("error_time", bj.a(String.valueOf(paramLong)));
        localc = new w.c();
        StringBuffer localStringBuffer = new StringBuffer("");
        try
        {
          paramLong = a(paramString, localc, localStringBuffer);
          if (0L != paramLong) {
            continue;
          }
          localContentValues.put("message", paramString.getBytes("UTF-8"));
          localContentValues.put("repeat", bj.a(String.valueOf(1)));
          localContentValues.put("shorthashcode", bj.a(localStringBuffer.toString()));
          paramLong = a("error_report", localContentValues, null, null, 1);
        }
        catch (Throwable paramString)
        {
          k.a(paramString);
          paramLong = 0L;
          continue;
        }
        return paramLong;
      }
      finally {}
      localContentValues.put("repeat", bj.a(String.valueOf(localc.b + 1)));
      paramLong = a("error_report", localContentValues, "_id=?", new String[] { String.valueOf(paramLong) }, 2);
    }
  }
  
  final long a(String paramString)
  {
    try
    {
      k.b(new String[] { "[Update Session Launch Status] ", "sessionId:" + paramString, ", status:" + String.valueOf(2) });
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("is_launch", bj.a(String.valueOf(2)));
      long l = a("session", localContentValues, "session_id=?", new String[] { bj.a(paramString) }, 2);
      return l;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  final long a(String paramString, int paramInt)
  {
    try
    {
      k.b(new String[] { "[Update Session Duration] ", "sessionId:" + paramString, ", duration:" + paramInt });
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("duration", bj.a(String.valueOf(paramInt)));
      long l = a("session", localContentValues, "session_id=?", new String[] { bj.a(paramString) }, 2);
      return l;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  final long a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    try
    {
      k.b(new String[] { "[Save Session] ", "sessionId: " + paramString, ", startTime: " + paramLong1 });
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("session_id", bj.a(paramString));
      localContentValues.put("start_time", bj.a(String.valueOf(paramLong1)));
      localContentValues.put("duration", bj.a(String.valueOf(0)));
      localContentValues.put("is_launch", bj.a(String.valueOf(0)));
      localContentValues.put("interval", bj.a(String.valueOf(paramLong2)));
      localContentValues.put("is_connected", bj.a(String.valueOf(paramInt)));
      paramLong1 = a("session", localContentValues, null, null, 1);
      return paramLong1;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  final long a(String paramString1, String paramString2, long paramLong1, String paramString3, long paramLong2)
  {
    try
    {
      k.b(new String[] { "[Save Activity] ", "sessionId:" + paramString1, ", name:" + paramString2, ", start:" + paramLong1, ", duration:0", ", refer:" + paramString3 });
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("session_id", bj.a(paramString1));
      localContentValues.put("name", bj.a(paramString2));
      localContentValues.put("start_time", bj.a(String.valueOf(paramLong1)));
      localContentValues.put("duration", bj.a(String.valueOf(0)));
      localContentValues.put("refer", bj.a(paramString3));
      localContentValues.put("realtime", bj.a(String.valueOf(paramLong2)));
      paramLong1 = a("activity", localContentValues, null, null, 1);
      return paramLong1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  final long a(String paramString1, String paramString2, String paramString3, long paramLong, java.util.Map paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 62	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 467
    //   9: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: aload_1
    //   13: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: astore 9
    //   21: new 62	java/lang/StringBuilder
    //   24: dup
    //   25: ldc_w 518
    //   28: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   31: aload_2
    //   32: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: astore 10
    //   40: new 62	java/lang/StringBuilder
    //   43: dup
    //   44: ldc_w 520
    //   47: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: aload_3
    //   51: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore 11
    //   59: new 62	java/lang/StringBuilder
    //   62: dup
    //   63: ldc_w 522
    //   66: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   69: lload 4
    //   71: invokestatic 71	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   74: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore 12
    //   82: new 62	java/lang/StringBuilder
    //   85: dup
    //   86: ldc_w 524
    //   89: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: astore 13
    //   94: aload 6
    //   96: ifnonnull +151 -> 247
    //   99: ldc_w 403
    //   102: astore 8
    //   104: bipush 6
    //   106: anewarray 58	java/lang/String
    //   109: dup
    //   110: iconst_0
    //   111: ldc_w 526
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: aload 9
    //   119: aastore
    //   120: dup
    //   121: iconst_2
    //   122: aload 10
    //   124: aastore
    //   125: dup
    //   126: iconst_3
    //   127: aload 11
    //   129: aastore
    //   130: dup
    //   131: iconst_4
    //   132: aload 12
    //   134: aastore
    //   135: dup
    //   136: iconst_5
    //   137: aload 13
    //   139: aload 8
    //   141: invokestatic 529	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   144: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: aastore
    //   151: invokestatic 84	com/unionpay/sdk/k:b	([Ljava/lang/String;)V
    //   154: new 426	android/content/ContentValues
    //   157: dup
    //   158: invokespecial 427	android/content/ContentValues:<init>	()V
    //   161: astore 8
    //   163: aload 8
    //   165: ldc_w 531
    //   168: aload_2
    //   169: invokestatic 404	com/unionpay/sdk/bj:a	(Ljava/lang/String;)Ljava/lang/String;
    //   172: invokevirtual 432	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: aload 8
    //   177: ldc_w 533
    //   180: aload_3
    //   181: invokestatic 404	com/unionpay/sdk/bj:a	(Ljava/lang/String;)Ljava/lang/String;
    //   184: invokevirtual 432	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload 8
    //   189: ldc_w 492
    //   192: aload_1
    //   193: invokestatic 404	com/unionpay/sdk/bj:a	(Ljava/lang/String;)Ljava/lang/String;
    //   196: invokevirtual 432	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload 8
    //   201: ldc_w 535
    //   204: lload 4
    //   206: invokestatic 71	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   209: invokestatic 404	com/unionpay/sdk/bj:a	(Ljava/lang/String;)Ljava/lang/String;
    //   212: invokevirtual 432	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: aload 8
    //   217: ldc_w 537
    //   220: aload 6
    //   222: invokestatic 539	com/unionpay/sdk/t:a	(Ljava/util/Map;)[B
    //   225: invokevirtual 456	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   228: aload_0
    //   229: ldc_w 541
    //   232: aload 8
    //   234: aconst_null
    //   235: aconst_null
    //   236: iconst_1
    //   237: invokespecial 406	com/unionpay/sdk/t:a	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;I)J
    //   240: lstore 4
    //   242: aload_0
    //   243: monitorexit
    //   244: lload 4
    //   246: lreturn
    //   247: aload 6
    //   249: invokeinterface 239 1 0
    //   254: istore 7
    //   256: iload 7
    //   258: invokestatic 544	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   261: astore 8
    //   263: goto -159 -> 104
    //   266: astore_1
    //   267: aload_0
    //   268: monitorexit
    //   269: aload_1
    //   270: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	t
    //   0	271	1	paramString1	String
    //   0	271	2	paramString2	String
    //   0	271	3	paramString3	String
    //   0	271	4	paramLong	long
    //   0	271	6	paramMap	java.util.Map
    //   254	3	7	i	int
    //   102	160	8	localObject	Object
    //   19	99	9	str1	String
    //   38	85	10	str2	String
    //   57	71	11	str3	String
    //   80	53	12	str4	String
    //   92	46	13	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	94	266	finally
    //   104	242	266	finally
    //   247	256	266	finally
  }
  
  /* Error */
  final long a(List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokeinterface 548 1 0
    //   8: istore_2
    //   9: iload_2
    //   10: ifne +9 -> 19
    //   13: lconst_0
    //   14: lstore_3
    //   15: aload_0
    //   16: monitorexit
    //   17: lload_3
    //   18: lreturn
    //   19: iload_2
    //   20: iconst_1
    //   21: isub
    //   22: istore_2
    //   23: lconst_0
    //   24: lstore_3
    //   25: iload_2
    //   26: iflt +187 -> 213
    //   29: lload_3
    //   30: lstore 7
    //   32: new 62	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   39: astore 10
    //   41: lload_3
    //   42: lstore 7
    //   44: aload 10
    //   46: ldc_w 550
    //   49: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aconst_null
    //   54: astore 9
    //   56: getstatic 45	com/unionpay/sdk/t:b	Landroid/database/sqlite/SQLiteDatabase;
    //   59: aload 10
    //   61: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: iconst_1
    //   65: anewarray 58	java/lang/String
    //   68: dup
    //   69: iconst_0
    //   70: aload_1
    //   71: iload_2
    //   72: invokeinterface 554 2 0
    //   77: checkcast 556	com/unionpay/sdk/w$j
    //   80: getfield 559	com/unionpay/sdk/w$j:a	Ljava/lang/String;
    //   83: invokestatic 404	com/unionpay/sdk/bj:a	(Ljava/lang/String;)Ljava/lang/String;
    //   86: aastore
    //   87: invokevirtual 563	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   90: astore 10
    //   92: lload_3
    //   93: lstore 5
    //   95: aload 10
    //   97: invokeinterface 135 1 0
    //   102: ifeq +57 -> 159
    //   105: aload 10
    //   107: iconst_0
    //   108: invokeinterface 189 2 0
    //   113: lstore 5
    //   115: lload 5
    //   117: lconst_0
    //   118: lcmp
    //   119: ifeq +40 -> 159
    //   122: lload 5
    //   124: lstore_3
    //   125: aload 10
    //   127: ifnull -112 -> 15
    //   130: aload 10
    //   132: invokeinterface 122 1 0
    //   137: lload 5
    //   139: lstore_3
    //   140: goto -125 -> 15
    //   143: astore_1
    //   144: lload 5
    //   146: lstore_3
    //   147: aload_1
    //   148: invokestatic 99	com/unionpay/sdk/k:a	(Ljava/lang/Throwable;)V
    //   151: goto -136 -> 15
    //   154: astore_1
    //   155: aload_0
    //   156: monitorexit
    //   157: aload_1
    //   158: athrow
    //   159: aload 10
    //   161: ifnull +55 -> 216
    //   164: lload 5
    //   166: lstore 7
    //   168: aload 10
    //   170: invokeinterface 122 1 0
    //   175: goto +41 -> 216
    //   178: aload 9
    //   180: ifnull +13 -> 193
    //   183: lload_3
    //   184: lstore 7
    //   186: aload 9
    //   188: invokeinterface 122 1 0
    //   193: lload_3
    //   194: lstore 7
    //   196: aload_1
    //   197: athrow
    //   198: astore_1
    //   199: lload 7
    //   201: lstore_3
    //   202: goto -55 -> 147
    //   205: astore_1
    //   206: aload 10
    //   208: astore 9
    //   210: goto -32 -> 178
    //   213: goto -198 -> 15
    //   216: iload_2
    //   217: iconst_1
    //   218: isub
    //   219: istore_2
    //   220: lload 5
    //   222: lstore_3
    //   223: goto -198 -> 25
    //   226: astore_1
    //   227: goto -49 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	t
    //   0	230	1	paramList	List
    //   8	212	2	i	int
    //   14	209	3	l1	long
    //   93	128	5	l2	long
    //   30	170	7	l3	long
    //   54	155	9	localObject1	Object
    //   39	168	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   130	137	143	java/lang/Throwable
    //   2	9	154	finally
    //   32	41	154	finally
    //   44	53	154	finally
    //   130	137	154	finally
    //   147	151	154	finally
    //   168	175	154	finally
    //   186	193	154	finally
    //   196	198	154	finally
    //   32	41	198	java/lang/Throwable
    //   44	53	198	java/lang/Throwable
    //   168	175	198	java/lang/Throwable
    //   186	193	198	java/lang/Throwable
    //   196	198	198	java/lang/Throwable
    //   95	115	205	finally
    //   56	92	226	finally
  }
  
  final long b(long paramLong)
  {
    try
    {
      k.b(new String[] { "[Delete AppEvent LT Id] ", "appEventId:" + paramLong });
      paramLong = a("app_event", null, "_id<=? ", new String[] { String.valueOf(paramLong) }, 3);
      return paramLong;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final long b(String paramString)
  {
    try
    {
      k.b(new String[] { "[Delete Session By Id] ", "sessionId:" + paramString });
      long l = a("session", null, "session_id=?", new String[] { bj.a(paramString) }, 3);
      return l;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  final long b(List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokeinterface 548 1 0
    //   8: istore_2
    //   9: iload_2
    //   10: ifne +9 -> 19
    //   13: lconst_0
    //   14: lstore_3
    //   15: aload_0
    //   16: monitorexit
    //   17: lload_3
    //   18: lreturn
    //   19: iload_2
    //   20: iconst_1
    //   21: isub
    //   22: istore_2
    //   23: iload_2
    //   24: iflt +113 -> 137
    //   27: new 62	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   34: astore 8
    //   36: aload 8
    //   38: ldc_w 573
    //   41: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aconst_null
    //   46: astore 7
    //   48: getstatic 45	com/unionpay/sdk/t:b	Landroid/database/sqlite/SQLiteDatabase;
    //   51: aload 8
    //   53: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: iconst_1
    //   57: anewarray 58	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: iload_2
    //   64: invokeinterface 554 2 0
    //   69: checkcast 556	com/unionpay/sdk/w$j
    //   72: getfield 559	com/unionpay/sdk/w$j:a	Ljava/lang/String;
    //   75: invokestatic 404	com/unionpay/sdk/bj:a	(Ljava/lang/String;)Ljava/lang/String;
    //   78: aastore
    //   79: invokevirtual 563	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   82: astore 8
    //   84: aload 8
    //   86: invokeinterface 135 1 0
    //   91: ifeq +51 -> 142
    //   94: aload 8
    //   96: iconst_0
    //   97: invokeinterface 189 2 0
    //   102: lstore 5
    //   104: lload 5
    //   106: lconst_0
    //   107: lcmp
    //   108: ifeq +34 -> 142
    //   111: lload 5
    //   113: lstore_3
    //   114: aload 8
    //   116: ifnull -101 -> 15
    //   119: aload 8
    //   121: invokeinterface 122 1 0
    //   126: lload 5
    //   128: lstore_3
    //   129: goto -114 -> 15
    //   132: astore_1
    //   133: aload_1
    //   134: invokestatic 99	com/unionpay/sdk/k:a	(Ljava/lang/Throwable;)V
    //   137: lconst_0
    //   138: lstore_3
    //   139: goto -124 -> 15
    //   142: aload 8
    //   144: ifnull +40 -> 184
    //   147: aload 8
    //   149: invokeinterface 122 1 0
    //   154: goto +30 -> 184
    //   157: aload 7
    //   159: ifnull +10 -> 169
    //   162: aload 7
    //   164: invokeinterface 122 1 0
    //   169: aload_1
    //   170: athrow
    //   171: astore_1
    //   172: aload_0
    //   173: monitorexit
    //   174: aload_1
    //   175: athrow
    //   176: astore_1
    //   177: aload 8
    //   179: astore 7
    //   181: goto -24 -> 157
    //   184: iload_2
    //   185: iconst_1
    //   186: isub
    //   187: istore_2
    //   188: goto -165 -> 23
    //   191: astore_1
    //   192: goto -35 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	t
    //   0	195	1	paramList	List
    //   8	180	2	i	int
    //   14	125	3	l1	long
    //   102	25	5	l2	long
    //   46	134	7	localObject1	Object
    //   34	144	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   27	45	132	java/lang/Throwable
    //   119	126	132	java/lang/Throwable
    //   147	154	132	java/lang/Throwable
    //   162	169	132	java/lang/Throwable
    //   169	171	132	java/lang/Throwable
    //   2	9	171	finally
    //   27	45	171	finally
    //   119	126	171	finally
    //   133	137	171	finally
    //   147	154	171	finally
    //   162	169	171	finally
    //   169	171	171	finally
    //   84	104	176	finally
    //   48	84	191	finally
  }
  
  final void b()
  {
    e();
  }
  
  final long c(long paramLong)
  {
    try
    {
      k.b(new String[] { "[Delete Error LT Id] ", "errorId:" + paramLong });
      paramLong = a("error_report", null, "_id<=?", new String[] { String.valueOf(paramLong) }, 3);
      return paramLong;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final long c(String paramString)
  {
    try
    {
      k.b(new String[] { "[Delete Activity By Session Id] ", "sessionId:" + paramString });
      long l = a("activity", null, "session_id=? ", new String[] { bj.a(paramString) }, 3);
      return l;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  final void c()
  {
    h();
  }
  
  /* Error */
  final List d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 590	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 591	java/util/ArrayList:<init>	()V
    //   9: astore 5
    //   11: getstatic 45	com/unionpay/sdk/t:b	Landroid/database/sqlite/SQLiteDatabase;
    //   14: ldc_w 473
    //   17: getstatic 592	com/unionpay/sdk/t$d:a	[Ljava/lang/String;
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: ldc 107
    //   26: ldc_w 594
    //   29: invokevirtual 597	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore_3
    //   33: aload_3
    //   34: astore_2
    //   35: aload_3
    //   36: invokeinterface 135 1 0
    //   41: ifeq +450 -> 491
    //   44: aload_3
    //   45: astore_2
    //   46: aload_3
    //   47: invokeinterface 138 1 0
    //   52: ifne +439 -> 491
    //   55: aload_3
    //   56: astore_2
    //   57: new 556	com/unionpay/sdk/w$j
    //   60: dup
    //   61: invokespecial 598	com/unionpay/sdk/w$j:<init>	()V
    //   64: astore 4
    //   66: aload_3
    //   67: astore_2
    //   68: aload 4
    //   70: aload_3
    //   71: iconst_1
    //   72: invokeinterface 142 2 0
    //   77: invokestatic 146	com/unionpay/sdk/bj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   80: putfield 559	com/unionpay/sdk/w$j:a	Ljava/lang/String;
    //   83: aload_3
    //   84: astore_2
    //   85: aload 4
    //   87: aload_3
    //   88: iconst_2
    //   89: invokeinterface 142 2 0
    //   94: invokestatic 146	com/unionpay/sdk/bj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   97: invokestatic 152	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   100: putfield 600	com/unionpay/sdk/w$j:b	J
    //   103: aload_3
    //   104: astore_2
    //   105: iconst_1
    //   106: anewarray 58	java/lang/String
    //   109: dup
    //   110: iconst_0
    //   111: new 62	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   118: aload 4
    //   120: getfield 559	com/unionpay/sdk/w$j:a	Ljava/lang/String;
    //   123: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc_w 602
    //   129: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload 4
    //   134: getfield 600	com/unionpay/sdk/w$j:b	J
    //   137: invokevirtual 399	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   140: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: aastore
    //   144: invokestatic 84	com/unionpay/sdk/k:b	([Ljava/lang/String;)V
    //   147: aload_3
    //   148: astore_2
    //   149: aload 4
    //   151: aload_3
    //   152: iconst_3
    //   153: invokeinterface 142 2 0
    //   158: invokestatic 146	com/unionpay/sdk/bj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   161: invokestatic 170	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   164: putfield 603	com/unionpay/sdk/w$j:d	I
    //   167: aload_3
    //   168: astore_2
    //   169: aload_3
    //   170: iconst_4
    //   171: invokeinterface 142 2 0
    //   176: invokestatic 146	com/unionpay/sdk/bj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   179: astore 6
    //   181: aload 6
    //   183: ifnull +235 -> 418
    //   186: aload_3
    //   187: astore_2
    //   188: aload 6
    //   190: ldc_w 605
    //   193: invokevirtual 185	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   196: ifne +222 -> 418
    //   199: aload_3
    //   200: astore_2
    //   201: aload 6
    //   203: invokestatic 170	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   206: ifne +212 -> 418
    //   209: aload_3
    //   210: astore_2
    //   211: aload 4
    //   213: iconst_1
    //   214: putfield 606	com/unionpay/sdk/w$j:c	I
    //   217: aload_3
    //   218: astore_2
    //   219: iconst_1
    //   220: anewarray 58	java/lang/String
    //   223: dup
    //   224: iconst_0
    //   225: new 62	java/lang/StringBuilder
    //   228: dup
    //   229: ldc_w 608
    //   232: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   235: aload 4
    //   237: getfield 559	com/unionpay/sdk/w$j:a	Ljava/lang/String;
    //   240: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc_w 610
    //   246: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload 4
    //   251: getfield 603	com/unionpay/sdk/w$j:d	I
    //   254: invokestatic 460	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   257: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc_w 612
    //   263: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload 4
    //   268: getfield 606	com/unionpay/sdk/w$j:c	I
    //   271: invokestatic 460	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   274: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: aastore
    //   281: invokestatic 84	com/unionpay/sdk/k:b	([Ljava/lang/String;)V
    //   284: aload_3
    //   285: astore_2
    //   286: iconst_1
    //   287: aload 4
    //   289: getfield 606	com/unionpay/sdk/w$j:c	I
    //   292: if_icmpne +57 -> 349
    //   295: aload_3
    //   296: astore_2
    //   297: aload 4
    //   299: aload_3
    //   300: iconst_5
    //   301: invokeinterface 142 2 0
    //   306: invokestatic 146	com/unionpay/sdk/bj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   309: invokestatic 170	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   312: putfield 614	com/unionpay/sdk/w$j:g	I
    //   315: aload_3
    //   316: astore_2
    //   317: aload 4
    //   319: getfield 614	com/unionpay/sdk/w$j:g	I
    //   322: ifge +11 -> 333
    //   325: aload_3
    //   326: astore_2
    //   327: aload 4
    //   329: iconst_0
    //   330: putfield 614	com/unionpay/sdk/w$j:g	I
    //   333: aload_3
    //   334: astore_2
    //   335: aload 4
    //   337: aload 4
    //   339: getfield 614	com/unionpay/sdk/w$j:g	I
    //   342: sipush 1000
    //   345: idiv
    //   346: putfield 603	com/unionpay/sdk/w$j:d	I
    //   349: aload_3
    //   350: astore_2
    //   351: aload 4
    //   353: aload_3
    //   354: bipush 6
    //   356: invokeinterface 142 2 0
    //   361: invokestatic 146	com/unionpay/sdk/bj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   364: invokestatic 170	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   367: putfield 616	com/unionpay/sdk/w$j:h	I
    //   370: aload_3
    //   371: astore_2
    //   372: aload 5
    //   374: aload 4
    //   376: invokeinterface 619 2 0
    //   381: pop
    //   382: aload_3
    //   383: astore_2
    //   384: aload_3
    //   385: invokeinterface 192 1 0
    //   390: pop
    //   391: goto -347 -> 44
    //   394: astore 4
    //   396: aload_3
    //   397: astore_2
    //   398: aload 4
    //   400: invokestatic 99	com/unionpay/sdk/k:a	(Ljava/lang/Throwable;)V
    //   403: aload_3
    //   404: ifnull +9 -> 413
    //   407: aload_3
    //   408: invokeinterface 122 1 0
    //   413: aload_0
    //   414: monitorexit
    //   415: aload 5
    //   417: areturn
    //   418: aload_3
    //   419: astore_2
    //   420: aload 4
    //   422: getfield 603	com/unionpay/sdk/w$j:d	I
    //   425: ifeq +61 -> 486
    //   428: iconst_3
    //   429: istore_1
    //   430: aload_3
    //   431: astore_2
    //   432: aload 4
    //   434: iload_1
    //   435: putfield 606	com/unionpay/sdk/w$j:c	I
    //   438: goto -221 -> 217
    //   441: astore 4
    //   443: aload_3
    //   444: astore_2
    //   445: aload 4
    //   447: invokestatic 99	com/unionpay/sdk/k:a	(Ljava/lang/Throwable;)V
    //   450: aload_3
    //   451: astore_2
    //   452: aload_3
    //   453: invokeinterface 192 1 0
    //   458: pop
    //   459: goto -415 -> 44
    //   462: astore 4
    //   464: aload_2
    //   465: astore_3
    //   466: aload 4
    //   468: astore_2
    //   469: aload_3
    //   470: ifnull +9 -> 479
    //   473: aload_3
    //   474: invokeinterface 122 1 0
    //   479: aload_2
    //   480: athrow
    //   481: astore_2
    //   482: aload_0
    //   483: monitorexit
    //   484: aload_2
    //   485: athrow
    //   486: iconst_2
    //   487: istore_1
    //   488: goto -58 -> 430
    //   491: aload_3
    //   492: ifnull -79 -> 413
    //   495: aload_3
    //   496: invokeinterface 122 1 0
    //   501: goto -88 -> 413
    //   504: astore_2
    //   505: aconst_null
    //   506: astore_3
    //   507: goto -38 -> 469
    //   510: astore 4
    //   512: aconst_null
    //   513: astore_3
    //   514: goto -118 -> 396
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	517	0	this	t
    //   429	59	1	i	int
    //   34	446	2	localObject1	Object
    //   481	4	2	localObject2	Object
    //   504	1	2	localObject3	Object
    //   32	482	3	localObject4	Object
    //   64	311	4	localj	w.j
    //   394	39	4	localThrowable1	Throwable
    //   441	5	4	localThrowable2	Throwable
    //   462	5	4	localObject5	Object
    //   510	1	4	localThrowable3	Throwable
    //   9	407	5	localArrayList	ArrayList
    //   179	23	6	str	String
    // Exception table:
    //   from	to	target	type
    //   35	44	394	java/lang/Throwable
    //   46	55	394	java/lang/Throwable
    //   57	66	394	java/lang/Throwable
    //   219	284	394	java/lang/Throwable
    //   286	295	394	java/lang/Throwable
    //   297	315	394	java/lang/Throwable
    //   317	325	394	java/lang/Throwable
    //   327	333	394	java/lang/Throwable
    //   335	349	394	java/lang/Throwable
    //   351	370	394	java/lang/Throwable
    //   372	382	394	java/lang/Throwable
    //   384	391	394	java/lang/Throwable
    //   445	450	394	java/lang/Throwable
    //   452	459	394	java/lang/Throwable
    //   68	83	441	java/lang/Throwable
    //   85	103	441	java/lang/Throwable
    //   105	147	441	java/lang/Throwable
    //   149	167	441	java/lang/Throwable
    //   169	181	441	java/lang/Throwable
    //   188	199	441	java/lang/Throwable
    //   201	209	441	java/lang/Throwable
    //   211	217	441	java/lang/Throwable
    //   420	428	441	java/lang/Throwable
    //   432	438	441	java/lang/Throwable
    //   35	44	462	finally
    //   46	55	462	finally
    //   57	66	462	finally
    //   68	83	462	finally
    //   85	103	462	finally
    //   105	147	462	finally
    //   149	167	462	finally
    //   169	181	462	finally
    //   188	199	462	finally
    //   201	209	462	finally
    //   211	217	462	finally
    //   219	284	462	finally
    //   286	295	462	finally
    //   297	315	462	finally
    //   317	325	462	finally
    //   327	333	462	finally
    //   335	349	462	finally
    //   351	370	462	finally
    //   372	382	462	finally
    //   384	391	462	finally
    //   398	403	462	finally
    //   420	428	462	finally
    //   432	438	462	finally
    //   445	450	462	finally
    //   452	459	462	finally
    //   2	11	481	finally
    //   407	413	481	finally
    //   473	479	481	finally
    //   479	481	481	finally
    //   495	501	481	finally
    //   11	33	504	finally
    //   11	33	510	java/lang/Throwable
  }
  
  /* Error */
  final List d(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 590	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 591	java/util/ArrayList:<init>	()V
    //   9: astore 5
    //   11: aconst_null
    //   12: astore_3
    //   13: new 62	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   20: astore 4
    //   22: aload 4
    //   24: ldc_w 622
    //   27: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: getstatic 45	com/unionpay/sdk/t:b	Landroid/database/sqlite/SQLiteDatabase;
    //   34: aload 4
    //   36: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: iconst_1
    //   40: anewarray 58	java/lang/String
    //   43: dup
    //   44: iconst_0
    //   45: lload_1
    //   46: invokestatic 71	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   49: aastore
    //   50: invokevirtual 563	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   53: astore 4
    //   55: aload 4
    //   57: astore_3
    //   58: aload_3
    //   59: invokeinterface 135 1 0
    //   64: ifeq +227 -> 291
    //   67: getstatic 310	com/unionpay/sdk/d:c	Landroid/content/Context;
    //   70: ifnull +169 -> 239
    //   73: invokestatic 626	com/unionpay/sdk/o:g	()I
    //   76: invokestatic 460	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   79: astore 4
    //   81: aload_3
    //   82: invokeinterface 138 1 0
    //   87: ifne +204 -> 291
    //   90: new 628	com/unionpay/sdk/w$i
    //   93: dup
    //   94: invokespecial 629	com/unionpay/sdk/w$i:<init>	()V
    //   97: astore 6
    //   99: aload 6
    //   101: iconst_3
    //   102: putfield 631	com/unionpay/sdk/w$i:a	I
    //   105: new 154	com/unionpay/sdk/w$c
    //   108: dup
    //   109: invokespecial 442	com/unionpay/sdk/w$c:<init>	()V
    //   112: astore 7
    //   114: aload 7
    //   116: aload_3
    //   117: iconst_0
    //   118: invokeinterface 142 2 0
    //   123: invokestatic 146	com/unionpay/sdk/bj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   126: invokestatic 152	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   129: putfield 157	com/unionpay/sdk/w$c:a	J
    //   132: aload 7
    //   134: aload_3
    //   135: iconst_1
    //   136: invokeinterface 161 2 0
    //   141: putfield 164	com/unionpay/sdk/w$c:d	[B
    //   144: aload 7
    //   146: aload_3
    //   147: iconst_2
    //   148: invokeinterface 142 2 0
    //   153: invokestatic 146	com/unionpay/sdk/bj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   156: invokestatic 170	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   159: putfield 172	com/unionpay/sdk/w$c:b	I
    //   162: aload 7
    //   164: aload_3
    //   165: iconst_3
    //   166: invokeinterface 142 2 0
    //   171: invokestatic 146	com/unionpay/sdk/bj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   174: putfield 633	com/unionpay/sdk/w$c:e	Ljava/lang/String;
    //   177: aload 7
    //   179: aload 4
    //   181: putfield 635	com/unionpay/sdk/w$c:c	Ljava/lang/String;
    //   184: aload 6
    //   186: aload 7
    //   188: putfield 638	com/unionpay/sdk/w$i:d	Lcom/unionpay/sdk/w$c;
    //   191: aload 5
    //   193: aload 6
    //   195: invokeinterface 619 2 0
    //   200: pop
    //   201: aload_3
    //   202: invokeinterface 192 1 0
    //   207: pop
    //   208: goto -127 -> 81
    //   211: astore 4
    //   213: getstatic 367	com/unionpay/sdk/ag:a	Z
    //   216: ifeq +8 -> 224
    //   219: aload 4
    //   221: invokevirtual 370	java/lang/Throwable:printStackTrace	()V
    //   224: aload_3
    //   225: ifnull +9 -> 234
    //   228: aload_3
    //   229: invokeinterface 122 1 0
    //   234: aload_0
    //   235: monitorexit
    //   236: aload 5
    //   238: areturn
    //   239: ldc_w 444
    //   242: astore 4
    //   244: goto -163 -> 81
    //   247: astore 6
    //   249: aload 6
    //   251: invokestatic 99	com/unionpay/sdk/k:a	(Ljava/lang/Throwable;)V
    //   254: aload_3
    //   255: invokeinterface 192 1 0
    //   260: pop
    //   261: goto -180 -> 81
    //   264: astore 5
    //   266: aload_3
    //   267: astore 4
    //   269: aload 5
    //   271: astore_3
    //   272: aload 4
    //   274: ifnull +10 -> 284
    //   277: aload 4
    //   279: invokeinterface 122 1 0
    //   284: aload_3
    //   285: athrow
    //   286: astore_3
    //   287: aload_0
    //   288: monitorexit
    //   289: aload_3
    //   290: athrow
    //   291: aload_3
    //   292: ifnull -58 -> 234
    //   295: aload_3
    //   296: invokeinterface 122 1 0
    //   301: goto -67 -> 234
    //   304: astore_3
    //   305: aconst_null
    //   306: astore 4
    //   308: goto -36 -> 272
    //   311: astore 5
    //   313: aload_3
    //   314: astore 4
    //   316: aload 5
    //   318: astore_3
    //   319: goto -47 -> 272
    //   322: astore 4
    //   324: goto -111 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	t
    //   0	327	1	paramLong	long
    //   12	273	3	localObject1	Object
    //   286	10	3	localObject2	Object
    //   304	10	3	localObject3	Object
    //   318	1	3	localObject4	Object
    //   20	160	4	localObject5	Object
    //   211	9	4	localThrowable1	Throwable
    //   242	73	4	localObject6	Object
    //   322	1	4	localThrowable2	Throwable
    //   9	228	5	localArrayList	ArrayList
    //   264	6	5	localObject7	Object
    //   311	6	5	localObject8	Object
    //   97	97	6	locali	w.i
    //   247	3	6	localThrowable3	Throwable
    //   112	75	7	localc	w.c
    // Exception table:
    //   from	to	target	type
    //   58	81	211	java/lang/Throwable
    //   81	99	211	java/lang/Throwable
    //   191	208	211	java/lang/Throwable
    //   249	261	211	java/lang/Throwable
    //   99	191	247	java/lang/Throwable
    //   58	81	264	finally
    //   81	99	264	finally
    //   99	191	264	finally
    //   191	208	264	finally
    //   249	261	264	finally
    //   2	11	286	finally
    //   228	234	286	finally
    //   277	284	286	finally
    //   284	286	286	finally
    //   295	301	286	finally
    //   13	55	304	finally
    //   213	224	311	finally
    //   13	55	322	java/lang/Throwable
  }
  
  /* Error */
  final List d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 590	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 591	java/util/ArrayList:<init>	()V
    //   9: astore 4
    //   11: getstatic 45	com/unionpay/sdk/t:b	Landroid/database/sqlite/SQLiteDatabase;
    //   14: ldc_w 302
    //   17: getstatic 303	com/unionpay/sdk/t$a:a	[Ljava/lang/String;
    //   20: ldc_w 641
    //   23: iconst_2
    //   24: anewarray 58	java/lang/String
    //   27: dup
    //   28: iconst_0
    //   29: aload_1
    //   30: invokestatic 404	com/unionpay/sdk/bj:a	(Ljava/lang/String;)Ljava/lang/String;
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: ldc_w 403
    //   39: invokestatic 404	com/unionpay/sdk/bj:a	(Ljava/lang/String;)Ljava/lang/String;
    //   42: aastore
    //   43: aconst_null
    //   44: aconst_null
    //   45: ldc 107
    //   47: invokevirtual 111	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore_3
    //   51: aload_3
    //   52: astore_2
    //   53: aload_3
    //   54: invokeinterface 135 1 0
    //   59: ifeq +342 -> 401
    //   62: aload_3
    //   63: astore_2
    //   64: aload_3
    //   65: invokeinterface 138 1 0
    //   70: ifne +331 -> 401
    //   73: aload_3
    //   74: astore_2
    //   75: new 643	com/unionpay/sdk/w$a
    //   78: dup
    //   79: invokespecial 644	com/unionpay/sdk/w$a:<init>	()V
    //   82: astore 5
    //   84: aload_3
    //   85: astore_2
    //   86: aload 5
    //   88: aload_3
    //   89: iconst_1
    //   90: invokeinterface 142 2 0
    //   95: invokestatic 146	com/unionpay/sdk/bj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   98: putfield 645	com/unionpay/sdk/w$a:a	Ljava/lang/String;
    //   101: aload_3
    //   102: astore_2
    //   103: aload 5
    //   105: aload_3
    //   106: iconst_2
    //   107: invokeinterface 142 2 0
    //   112: invokestatic 146	com/unionpay/sdk/bj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   115: invokestatic 152	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   118: putfield 646	com/unionpay/sdk/w$a:b	J
    //   121: aload_3
    //   122: astore_2
    //   123: aload 5
    //   125: aload_3
    //   126: iconst_3
    //   127: invokeinterface 142 2 0
    //   132: invokestatic 146	com/unionpay/sdk/bj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   135: invokestatic 170	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   138: putfield 647	com/unionpay/sdk/w$a:c	I
    //   141: aload_3
    //   142: astore_2
    //   143: aload 5
    //   145: aload_3
    //   146: iconst_5
    //   147: invokeinterface 142 2 0
    //   152: invokestatic 146	com/unionpay/sdk/bj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   155: putfield 649	com/unionpay/sdk/w$a:d	Ljava/lang/String;
    //   158: aload_3
    //   159: astore_2
    //   160: iconst_1
    //   161: anewarray 58	java/lang/String
    //   164: dup
    //   165: iconst_0
    //   166: new 62	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   173: aload_3
    //   174: iconst_0
    //   175: invokeinterface 189 2 0
    //   180: invokestatic 71	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   183: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: ldc_w 651
    //   189: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_1
    //   193: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: aastore
    //   200: invokestatic 84	com/unionpay/sdk/k:b	([Ljava/lang/String;)V
    //   203: aload_3
    //   204: astore_2
    //   205: iconst_1
    //   206: anewarray 58	java/lang/String
    //   209: dup
    //   210: iconst_0
    //   211: new 62	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   218: aload_3
    //   219: iconst_0
    //   220: invokeinterface 189 2 0
    //   225: invokestatic 71	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   228: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc_w 653
    //   234: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_3
    //   238: iconst_3
    //   239: invokeinterface 142 2 0
    //   244: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: aastore
    //   251: invokestatic 84	com/unionpay/sdk/k:b	([Ljava/lang/String;)V
    //   254: aload_3
    //   255: astore_2
    //   256: iconst_1
    //   257: anewarray 58	java/lang/String
    //   260: dup
    //   261: iconst_0
    //   262: new 62	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   269: aload_3
    //   270: iconst_0
    //   271: invokeinterface 189 2 0
    //   276: invokestatic 71	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   279: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: ldc_w 655
    //   285: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_3
    //   289: iconst_3
    //   290: invokeinterface 142 2 0
    //   295: invokestatic 146	com/unionpay/sdk/bj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   298: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: aastore
    //   305: invokestatic 84	com/unionpay/sdk/k:b	([Ljava/lang/String;)V
    //   308: aload_3
    //   309: astore_2
    //   310: aload 4
    //   312: aload 5
    //   314: invokeinterface 619 2 0
    //   319: pop
    //   320: aload_3
    //   321: astore_2
    //   322: aload_3
    //   323: invokeinterface 192 1 0
    //   328: pop
    //   329: goto -267 -> 62
    //   332: astore_1
    //   333: aload_3
    //   334: astore_2
    //   335: getstatic 367	com/unionpay/sdk/ag:a	Z
    //   338: ifeq +9 -> 347
    //   341: aload_3
    //   342: astore_2
    //   343: aload_1
    //   344: invokevirtual 370	java/lang/Throwable:printStackTrace	()V
    //   347: aload_3
    //   348: ifnull +9 -> 357
    //   351: aload_3
    //   352: invokeinterface 122 1 0
    //   357: aload_0
    //   358: monitorexit
    //   359: aload 4
    //   361: areturn
    //   362: astore 5
    //   364: aload_3
    //   365: astore_2
    //   366: aload 5
    //   368: invokestatic 99	com/unionpay/sdk/k:a	(Ljava/lang/Throwable;)V
    //   371: aload_3
    //   372: astore_2
    //   373: aload_3
    //   374: invokeinterface 192 1 0
    //   379: pop
    //   380: goto -318 -> 62
    //   383: astore_1
    //   384: aload_2
    //   385: ifnull +9 -> 394
    //   388: aload_2
    //   389: invokeinterface 122 1 0
    //   394: aload_1
    //   395: athrow
    //   396: astore_1
    //   397: aload_0
    //   398: monitorexit
    //   399: aload_1
    //   400: athrow
    //   401: aload_3
    //   402: ifnull -45 -> 357
    //   405: aload_3
    //   406: invokeinterface 122 1 0
    //   411: goto -54 -> 357
    //   414: astore_1
    //   415: aconst_null
    //   416: astore_2
    //   417: goto -33 -> 384
    //   420: astore_1
    //   421: aconst_null
    //   422: astore_3
    //   423: goto -90 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	this	t
    //   0	426	1	paramString	String
    //   52	365	2	localCursor1	Cursor
    //   50	373	3	localCursor2	Cursor
    //   9	351	4	localArrayList	ArrayList
    //   82	231	5	locala	w.a
    //   362	5	5	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   53	62	332	java/lang/Throwable
    //   64	73	332	java/lang/Throwable
    //   75	84	332	java/lang/Throwable
    //   160	203	332	java/lang/Throwable
    //   205	254	332	java/lang/Throwable
    //   256	308	332	java/lang/Throwable
    //   310	320	332	java/lang/Throwable
    //   322	329	332	java/lang/Throwable
    //   366	371	332	java/lang/Throwable
    //   373	380	332	java/lang/Throwable
    //   86	101	362	java/lang/Throwable
    //   103	121	362	java/lang/Throwable
    //   123	141	362	java/lang/Throwable
    //   143	158	362	java/lang/Throwable
    //   53	62	383	finally
    //   64	73	383	finally
    //   75	84	383	finally
    //   86	101	383	finally
    //   103	121	383	finally
    //   123	141	383	finally
    //   143	158	383	finally
    //   160	203	383	finally
    //   205	254	383	finally
    //   256	308	383	finally
    //   310	320	383	finally
    //   322	329	383	finally
    //   335	341	383	finally
    //   343	347	383	finally
    //   366	371	383	finally
    //   373	380	383	finally
    //   2	11	396	finally
    //   351	357	396	finally
    //   388	394	396	finally
    //   394	396	396	finally
    //   405	411	396	finally
    //   11	51	414	finally
    //   11	51	420	java/lang/Throwable
  }
  
  final long e(String paramString)
  {
    try
    {
      k.b(new String[] { "[Delete AppEvent LT Session Id] ", "sessionId:" + paramString });
      long l = a("app_event", null, "session_id=? ", new String[] { bj.a(paramString) }, 3);
      return l;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  final List f(String paramString)
  {
    Object localObject3 = null;
    w.b localb = null;
    for (;;)
    {
      try
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject2 = localb;
        Object localObject1 = localObject3;
        try
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localObject2 = localb;
          localObject1 = localObject3;
          localStringBuilder.append("SELECT COUNT(_id), MAX(occurtime), event_id, event_label, paramap from app_event where session_id = ? group by event_id, event_label, paramap");
          localObject2 = localb;
          localObject1 = localObject3;
          paramString = b.rawQuery(localStringBuilder.toString(), new String[] { bj.a(paramString) });
          localObject2 = paramString;
          localObject1 = paramString;
          if (!paramString.moveToFirst()) {
            break label301;
          }
        }
        catch (Throwable paramString)
        {
          paramString = paramString;
          localObject1 = localObject2;
          k.a(paramString);
          if (localObject2 == null) {
            continue;
          }
          ((Cursor)localObject2).close();
          return localArrayList;
          continue;
        }
        finally
        {
          if (localObject1 == null) {
            continue;
          }
          ((Cursor)localObject1).close();
        }
        localObject2 = paramString;
        localObject1 = paramString;
        if (!paramString.isAfterLast())
        {
          localObject2 = paramString;
          localObject1 = paramString;
          localb = new w.b();
          localObject1 = paramString;
        }
        if (paramString == null) {
          continue;
        }
      }
      finally {}
      label301:
      paramString.close();
    }
  }
  
  /* Error */
  final long g(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: monitorenter
    //   8: aload 8
    //   10: astore 6
    //   12: new 62	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   19: astore 9
    //   21: aload 8
    //   23: astore 6
    //   25: aload 9
    //   27: ldc_w 679
    //   30: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 8
    //   36: astore 6
    //   38: aload 9
    //   40: aload_1
    //   41: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 8
    //   47: astore 6
    //   49: getstatic 45	com/unionpay/sdk/t:b	Landroid/database/sqlite/SQLiteDatabase;
    //   52: aload 9
    //   54: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: aconst_null
    //   58: invokevirtual 563	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   61: astore_1
    //   62: aload_1
    //   63: invokeinterface 135 1 0
    //   68: ifeq +41 -> 109
    //   71: aload_1
    //   72: invokeinterface 138 1 0
    //   77: ifne +32 -> 109
    //   80: aload_1
    //   81: iconst_0
    //   82: invokeinterface 189 2 0
    //   87: lstore_2
    //   88: lload_2
    //   89: lstore 4
    //   91: aload_1
    //   92: ifnull +12 -> 104
    //   95: aload_1
    //   96: invokeinterface 122 1 0
    //   101: lload_2
    //   102: lstore 4
    //   104: aload_0
    //   105: monitorexit
    //   106: lload 4
    //   108: lreturn
    //   109: aload_1
    //   110: ifnull +9 -> 119
    //   113: aload_1
    //   114: invokeinterface 122 1 0
    //   119: lconst_0
    //   120: lstore 4
    //   122: goto -18 -> 104
    //   125: astore 6
    //   127: aload 7
    //   129: astore_1
    //   130: aload 6
    //   132: astore 7
    //   134: aload_1
    //   135: astore 6
    //   137: aload 7
    //   139: invokestatic 99	com/unionpay/sdk/k:a	(Ljava/lang/Throwable;)V
    //   142: aload_1
    //   143: ifnull -24 -> 119
    //   146: aload_1
    //   147: invokeinterface 122 1 0
    //   152: goto -33 -> 119
    //   155: astore_1
    //   156: aload_0
    //   157: monitorexit
    //   158: aload_1
    //   159: athrow
    //   160: astore_1
    //   161: aload 6
    //   163: ifnull +10 -> 173
    //   166: aload 6
    //   168: invokeinterface 122 1 0
    //   173: aload_1
    //   174: athrow
    //   175: astore 7
    //   177: aload_1
    //   178: astore 6
    //   180: aload 7
    //   182: astore_1
    //   183: goto -22 -> 161
    //   186: astore 7
    //   188: goto -54 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	t
    //   0	191	1	paramString	String
    //   87	15	2	l1	long
    //   89	32	4	l2	long
    //   10	38	6	localObject1	Object
    //   125	6	6	localThrowable1	Throwable
    //   135	44	6	str	String
    //   4	134	7	localObject2	Object
    //   175	6	7	localObject3	Object
    //   186	1	7	localThrowable2	Throwable
    //   1	45	8	localObject4	Object
    //   19	34	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   12	21	125	java/lang/Throwable
    //   25	34	125	java/lang/Throwable
    //   38	45	125	java/lang/Throwable
    //   49	62	125	java/lang/Throwable
    //   95	101	155	finally
    //   113	119	155	finally
    //   146	152	155	finally
    //   166	173	155	finally
    //   173	175	155	finally
    //   12	21	160	finally
    //   25	34	160	finally
    //   38	45	160	finally
    //   49	62	160	finally
    //   137	142	160	finally
    //   62	88	175	finally
    //   62	88	186	java/lang/Throwable
  }
  
  static final class a
    implements BaseColumns
  {
    static final String[] a = { "_id", "name", "start_time", "duration", "session_id", "refer", "realtime" };
    
    static final void a(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE activity (_id INTEGER PRIMARY KEY autoincrement,name TEXT,start_time LONG,duration INTEGER,session_id TEXT,refer TEXT,realtime LONG)");
    }
    
    static final void b(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS activity");
    }
  }
  
  static final class b
    implements BaseColumns
  {
    static final String[] a = { "_id", "event_id", "event_label", "session_id", "occurtime", "paramap" };
    
    static final void a(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE app_event (_id INTEGER PRIMARY KEY autoincrement,event_id TEXT,event_label TEXT,session_id TEXT,occurtime LONG,paramap BLOB)");
    }
    
    static final void b(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS app_event");
    }
  }
  
  static final class c
    implements BaseColumns
  {
    static final String[] a = { "_id", "error_time", "message", "repeat", "shorthashcode" };
    
    static final void a(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE error_report (_id INTEGER PRIMARY KEY autoincrement,error_time LONG,message BLOB,repeat INTERGER,shorthashcode TEXT)");
    }
    
    static final void b(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS error_report");
    }
  }
  
  static final class d
    implements BaseColumns
  {
    static final String[] a = { "_id", "session_id", "start_time", "duration", "is_launch", "interval", "is_connected" };
    
    static final void a(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE session (_id INTEGER PRIMARY KEY autoincrement,session_id TEXT,start_time LONG,duration INTEGER,is_launch INTEGER,interval LONG, is_connected INTEGER)");
    }
    
    static final void b(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS session");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */