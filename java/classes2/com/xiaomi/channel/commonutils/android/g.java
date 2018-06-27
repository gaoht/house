package com.xiaomi.channel.commonutils.android;

public class g
{
  private static int a = 0;
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 16	com/xiaomi/channel/commonutils/android/g:c	()I
    //   8: istore_0
    //   9: iload_0
    //   10: iconst_1
    //   11: if_icmpne +8 -> 19
    //   14: ldc 2
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: iconst_0
    //   20: istore_1
    //   21: goto -7 -> 14
    //   24: astore_2
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   8	4	0	i	int
    //   1	20	1	bool	boolean
    //   24	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	9	24	finally
  }
  
  /* Error */
  public static boolean b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 16	com/xiaomi/channel/commonutils/android/g:c	()I
    //   6: istore_0
    //   7: iload_0
    //   8: iconst_2
    //   9: if_icmpne +10 -> 19
    //   12: iconst_1
    //   13: istore_1
    //   14: ldc 2
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: iconst_0
    //   20: istore_1
    //   21: goto -7 -> 14
    //   24: astore_2
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	4	0	i	int
    //   13	8	1	bool	boolean
    //   24	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	24	finally
  }
  
  /* Error */
  public static int c()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 10	com/xiaomi/channel/commonutils/android/g:a	I
    //   8: istore_0
    //   9: iload_0
    //   10: ifne +103 -> 113
    //   13: new 21	java/util/Properties
    //   16: dup
    //   17: invokespecial 24	java/util/Properties:<init>	()V
    //   20: astore 4
    //   22: new 26	java/io/FileInputStream
    //   25: dup
    //   26: new 28	java/io/File
    //   29: dup
    //   30: invokestatic 34	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   33: ldc 36
    //   35: invokespecial 39	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   38: invokespecial 42	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   41: astore_3
    //   42: aload_3
    //   43: astore_2
    //   44: aload 4
    //   46: aload_3
    //   47: invokevirtual 46	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   50: aload_3
    //   51: astore_2
    //   52: aload 4
    //   54: ldc 48
    //   56: aconst_null
    //   57: invokevirtual 52	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   60: ifnonnull +122 -> 182
    //   63: aload_3
    //   64: astore_2
    //   65: aload 4
    //   67: ldc 54
    //   69: aconst_null
    //   70: invokevirtual 52	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   73: ifnull +49 -> 122
    //   76: goto +106 -> 182
    //   79: aload_3
    //   80: astore_2
    //   81: iload_0
    //   82: putstatic 10	com/xiaomi/channel/commonutils/android/g:a	I
    //   85: aload_3
    //   86: invokestatic 58	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   89: new 60	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   96: ldc 63
    //   98: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: getstatic 10	com/xiaomi/channel/commonutils/android/g:a	I
    //   104: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 79	com/xiaomi/channel/commonutils/logger/b:b	(Ljava/lang/String;)V
    //   113: getstatic 10	com/xiaomi/channel/commonutils/android/g:a	I
    //   116: istore_0
    //   117: ldc 2
    //   119: monitorexit
    //   120: iload_0
    //   121: ireturn
    //   122: iconst_0
    //   123: istore_0
    //   124: goto +60 -> 184
    //   127: iconst_2
    //   128: istore_0
    //   129: goto -50 -> 79
    //   132: astore 4
    //   134: aconst_null
    //   135: astore_3
    //   136: aload_3
    //   137: astore_2
    //   138: ldc 81
    //   140: aload 4
    //   142: invokestatic 84	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   145: aload_3
    //   146: astore_2
    //   147: iconst_0
    //   148: putstatic 10	com/xiaomi/channel/commonutils/android/g:a	I
    //   151: aload_3
    //   152: invokestatic 58	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   155: goto -66 -> 89
    //   158: astore_2
    //   159: ldc 2
    //   161: monitorexit
    //   162: aload_2
    //   163: athrow
    //   164: astore_3
    //   165: aconst_null
    //   166: astore_2
    //   167: aload_2
    //   168: invokestatic 58	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   171: aload_3
    //   172: athrow
    //   173: astore_3
    //   174: goto -7 -> 167
    //   177: astore 4
    //   179: goto -43 -> 136
    //   182: iconst_1
    //   183: istore_0
    //   184: iload_0
    //   185: ifeq -58 -> 127
    //   188: iload_1
    //   189: istore_0
    //   190: goto -111 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   8	182	0	i	int
    //   1	188	1	j	int
    //   43	104	2	localFileInputStream1	java.io.FileInputStream
    //   158	5	2	localObject1	Object
    //   166	2	2	localInputStream	java.io.InputStream
    //   41	111	3	localFileInputStream2	java.io.FileInputStream
    //   164	8	3	localObject2	Object
    //   173	1	3	localObject3	Object
    //   20	46	4	localProperties	java.util.Properties
    //   132	9	4	localThrowable1	Throwable
    //   177	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   13	42	132	java/lang/Throwable
    //   5	9	158	finally
    //   85	89	158	finally
    //   89	113	158	finally
    //   113	117	158	finally
    //   151	155	158	finally
    //   167	173	158	finally
    //   13	42	164	finally
    //   44	50	173	finally
    //   52	63	173	finally
    //   65	76	173	finally
    //   81	85	173	finally
    //   138	145	173	finally
    //   147	151	173	finally
    //   44	50	177	java/lang/Throwable
    //   52	63	177	java/lang/Throwable
    //   65	76	177	java/lang/Throwable
    //   81	85	177	java/lang/Throwable
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/android/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */