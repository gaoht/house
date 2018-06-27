package com.xiaomi.channel.commonutils.android;

public class c
{
  /* Error */
  public static boolean a(android.content.Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: invokevirtual 14	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   10: aload_1
    //   11: invokevirtual 20	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: astore_0
    //   15: aload_0
    //   16: invokestatic 26	com/xiaomi/channel/commonutils/file/a:b	(Ljava/io/InputStream;)[B
    //   19: astore 7
    //   21: new 28	java/io/File
    //   24: dup
    //   25: aload_2
    //   26: invokespecial 32	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 36	java/io/File:exists	()Z
    //   34: ifeq +264 -> 298
    //   37: new 38	java/io/FileInputStream
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 41	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: astore 5
    //   47: aload 5
    //   49: invokestatic 26	com/xiaomi/channel/commonutils/file/a:b	(Ljava/io/InputStream;)[B
    //   52: invokestatic 46	com/xiaomi/channel/commonutils/string/d:a	([B)Ljava/lang/String;
    //   55: astore_1
    //   56: aload 7
    //   58: invokestatic 46	com/xiaomi/channel/commonutils/string/d:a	([B)Ljava/lang/String;
    //   61: astore 8
    //   63: aload_1
    //   64: invokestatic 52	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifne +29 -> 96
    //   70: aload_1
    //   71: aload 8
    //   73: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   76: istore_3
    //   77: iload_3
    //   78: ifeq +18 -> 96
    //   81: aload_0
    //   82: invokestatic 61	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   85: aload 5
    //   87: invokestatic 61	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   90: aconst_null
    //   91: invokestatic 64	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/OutputStream;)V
    //   94: iconst_0
    //   95: ireturn
    //   96: aload 5
    //   98: astore_1
    //   99: new 66	java/io/FileOutputStream
    //   102: dup
    //   103: aload_2
    //   104: invokespecial 67	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   107: astore_2
    //   108: aload_2
    //   109: aload 7
    //   111: invokevirtual 71	java/io/FileOutputStream:write	([B)V
    //   114: aload_2
    //   115: invokevirtual 75	java/io/FileOutputStream:flush	()V
    //   118: aload_0
    //   119: invokestatic 61	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   122: aload_1
    //   123: invokestatic 61	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   126: aload_2
    //   127: invokestatic 64	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/OutputStream;)V
    //   130: iconst_1
    //   131: ireturn
    //   132: astore_2
    //   133: aconst_null
    //   134: astore_0
    //   135: aconst_null
    //   136: astore_1
    //   137: aload_2
    //   138: invokevirtual 78	java/lang/Exception:printStackTrace	()V
    //   141: aload_1
    //   142: invokestatic 61	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   145: aload_0
    //   146: invokestatic 61	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   149: aload 4
    //   151: invokestatic 64	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/OutputStream;)V
    //   154: iconst_0
    //   155: ireturn
    //   156: astore_1
    //   157: aconst_null
    //   158: astore_2
    //   159: aconst_null
    //   160: astore_0
    //   161: aload 6
    //   163: astore 4
    //   165: aload_0
    //   166: invokestatic 61	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   169: aload_2
    //   170: invokestatic 61	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   173: aload 4
    //   175: invokestatic 64	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/OutputStream;)V
    //   178: aload_1
    //   179: athrow
    //   180: astore_1
    //   181: aconst_null
    //   182: astore_2
    //   183: aload 6
    //   185: astore 4
    //   187: goto -22 -> 165
    //   190: astore_1
    //   191: aload 6
    //   193: astore 4
    //   195: aload 5
    //   197: astore_2
    //   198: goto -33 -> 165
    //   201: astore 4
    //   203: aload_1
    //   204: astore_2
    //   205: aload 4
    //   207: astore_1
    //   208: aload 6
    //   210: astore 4
    //   212: goto -47 -> 165
    //   215: astore 4
    //   217: aload_1
    //   218: astore 5
    //   220: aload 4
    //   222: astore_1
    //   223: aload_2
    //   224: astore 4
    //   226: aload 5
    //   228: astore_2
    //   229: goto -64 -> 165
    //   232: astore_2
    //   233: aload_1
    //   234: astore 5
    //   236: aload_2
    //   237: astore_1
    //   238: aload_0
    //   239: astore_2
    //   240: aload 5
    //   242: astore_0
    //   243: goto -78 -> 165
    //   246: astore_2
    //   247: aconst_null
    //   248: astore 5
    //   250: aload_0
    //   251: astore_1
    //   252: aload 5
    //   254: astore_0
    //   255: goto -118 -> 137
    //   258: astore_2
    //   259: aload_0
    //   260: astore_1
    //   261: aload 5
    //   263: astore_0
    //   264: goto -127 -> 137
    //   267: astore_2
    //   268: aload_0
    //   269: astore 5
    //   271: aload_1
    //   272: astore_0
    //   273: aload 5
    //   275: astore_1
    //   276: goto -139 -> 137
    //   279: astore 6
    //   281: aload_2
    //   282: astore 4
    //   284: aload_0
    //   285: astore 5
    //   287: aload 6
    //   289: astore_2
    //   290: aload_1
    //   291: astore_0
    //   292: aload 5
    //   294: astore_1
    //   295: goto -158 -> 137
    //   298: aconst_null
    //   299: astore_1
    //   300: goto -201 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	paramContext	android.content.Context
    //   0	303	1	paramString1	String
    //   0	303	2	paramString2	String
    //   76	2	3	bool	boolean
    //   4	190	4	localObject1	Object
    //   201	5	4	localObject2	Object
    //   210	1	4	localObject3	Object
    //   215	6	4	localObject4	Object
    //   224	59	4	str1	String
    //   45	248	5	localObject5	Object
    //   1	208	6	localObject6	Object
    //   279	9	6	localException	Exception
    //   19	91	7	arrayOfByte	byte[]
    //   61	11	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   6	15	132	java/lang/Exception
    //   6	15	156	finally
    //   15	47	180	finally
    //   47	77	190	finally
    //   99	108	201	finally
    //   108	118	215	finally
    //   137	141	232	finally
    //   15	47	246	java/lang/Exception
    //   47	77	258	java/lang/Exception
    //   99	108	267	java/lang/Exception
    //   108	118	279	java/lang/Exception
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/android/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */