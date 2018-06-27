package cn.jiguang.service;

public class Protocol
{
  private static final String z;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 12
    //   2: astore 6
    //   4: iconst_m1
    //   5: istore_2
    //   6: aload 6
    //   8: invokevirtual 18	java/lang/String:toCharArray	()[C
    //   11: astore 6
    //   13: aload 6
    //   15: arraylength
    //   16: istore_1
    //   17: iload_1
    //   18: iconst_1
    //   19: if_icmpgt +376 -> 395
    //   22: iconst_0
    //   23: istore_0
    //   24: iload_2
    //   25: istore 4
    //   27: iload_0
    //   28: istore_3
    //   29: iload_0
    //   30: istore_2
    //   31: aload 6
    //   33: astore 7
    //   35: aload 7
    //   37: iload_2
    //   38: caload
    //   39: istore 5
    //   41: iload_3
    //   42: iconst_5
    //   43: irem
    //   44: tableswitch	default:+32->76, 0:+134->178, 1:+140->184, 2:+146->190, 3:+152->196
    //   76: bipush 28
    //   78: istore_0
    //   79: aload 7
    //   81: iload_2
    //   82: iload_0
    //   83: iload 5
    //   85: ixor
    //   86: i2c
    //   87: castore
    //   88: iload_3
    //   89: iconst_1
    //   90: iadd
    //   91: istore_3
    //   92: iload_1
    //   93: ifne +8 -> 101
    //   96: iload_1
    //   97: istore_2
    //   98: goto -67 -> 31
    //   101: iload_1
    //   102: istore_2
    //   103: aload 6
    //   105: astore 7
    //   107: iload 4
    //   109: istore 5
    //   111: iload 5
    //   113: istore 4
    //   115: aload 7
    //   117: astore 6
    //   119: iload_2
    //   120: istore_1
    //   121: iload_3
    //   122: istore_0
    //   123: iload_2
    //   124: iload_3
    //   125: if_icmpgt -98 -> 27
    //   128: new 14	java/lang/String
    //   131: dup
    //   132: aload 7
    //   134: invokespecial 22	java/lang/String:<init>	([C)V
    //   137: invokevirtual 26	java/lang/String:intern	()Ljava/lang/String;
    //   140: astore 6
    //   142: iload 5
    //   144: tableswitch	default:+20->164, 0:+234->378
    //   164: aload 6
    //   166: putstatic 28	cn/jiguang/service/Protocol:z	Ljava/lang/String;
    //   169: ldc 30
    //   171: astore 6
    //   173: iconst_0
    //   174: istore_2
    //   175: goto -169 -> 6
    //   178: bipush 21
    //   180: istore_0
    //   181: goto -102 -> 79
    //   184: bipush 11
    //   186: istore_0
    //   187: goto -108 -> 79
    //   190: bipush 18
    //   192: istore_0
    //   193: goto -114 -> 79
    //   196: iconst_2
    //   197: istore_0
    //   198: goto -119 -> 79
    //   201: astore 8
    //   203: ldc 32
    //   205: invokevirtual 18	java/lang/String:toCharArray	()[C
    //   208: astore 6
    //   210: aload 6
    //   212: arraylength
    //   213: istore_0
    //   214: iload_0
    //   215: iconst_1
    //   216: if_icmpgt +168 -> 384
    //   219: iconst_0
    //   220: istore_2
    //   221: iload_0
    //   222: istore_1
    //   223: iload_2
    //   224: istore_0
    //   225: iload_0
    //   226: istore_3
    //   227: iload_0
    //   228: istore_2
    //   229: aload 6
    //   231: astore 7
    //   233: aload 7
    //   235: iload_2
    //   236: caload
    //   237: istore 4
    //   239: iload_3
    //   240: iconst_5
    //   241: irem
    //   242: tableswitch	default:+30->272, 0:+55->297, 1:+61->303, 2:+67->309, 3:+73->315
    //   272: bipush 28
    //   274: istore_0
    //   275: aload 7
    //   277: iload_2
    //   278: iload_0
    //   279: iload 4
    //   281: ixor
    //   282: i2c
    //   283: castore
    //   284: iload_3
    //   285: iconst_1
    //   286: iadd
    //   287: istore_3
    //   288: iload_1
    //   289: ifne +31 -> 320
    //   292: iload_1
    //   293: istore_2
    //   294: goto -65 -> 229
    //   297: bipush 21
    //   299: istore_0
    //   300: goto -25 -> 275
    //   303: bipush 11
    //   305: istore_0
    //   306: goto -31 -> 275
    //   309: bipush 18
    //   311: istore_0
    //   312: goto -37 -> 275
    //   315: iconst_2
    //   316: istore_0
    //   317: goto -42 -> 275
    //   320: iload_1
    //   321: istore_2
    //   322: aload 6
    //   324: astore 7
    //   326: aload 7
    //   328: astore 6
    //   330: iload_2
    //   331: istore_1
    //   332: iload_3
    //   333: istore_0
    //   334: iload_2
    //   335: iload_3
    //   336: if_icmpgt -111 -> 225
    //   339: new 14	java/lang/String
    //   342: dup
    //   343: aload 7
    //   345: invokespecial 22	java/lang/String:<init>	([C)V
    //   348: invokevirtual 26	java/lang/String:intern	()Ljava/lang/String;
    //   351: new 34	java/lang/StringBuilder
    //   354: dup
    //   355: getstatic 28	cn/jiguang/service/Protocol:z	Ljava/lang/String;
    //   358: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   361: aload 8
    //   363: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 50	cn/jiguang/d/d:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: aload 8
    //   374: invokevirtual 53	java/lang/Throwable:printStackTrace	()V
    //   377: return
    //   378: aload 6
    //   380: invokestatic 58	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   383: return
    //   384: iconst_0
    //   385: istore_3
    //   386: aload 6
    //   388: astore 7
    //   390: iload_0
    //   391: istore_2
    //   392: goto -66 -> 326
    //   395: iconst_0
    //   396: istore_3
    //   397: iload_2
    //   398: istore 5
    //   400: aload 6
    //   402: astore 7
    //   404: iload_1
    //   405: istore_2
    //   406: goto -295 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   23	368	0	i	int
    //   16	389	1	j	int
    //   5	401	2	k	int
    //   28	369	3	m	int
    //   25	257	4	n	int
    //   39	360	5	i1	int
    //   2	399	6	localObject1	Object
    //   33	370	7	localObject2	Object
    //   201	172	8	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   378	383	201	java/lang/Throwable
  }
  
  public static synchronized native int Close(long paramLong);
  
  public static native int GetSdkVersion();
  
  public static synchronized native long InitConn();
  
  public static native int InitPush(long paramLong, String paramString, int paramInt);
  
  public static native int LogPush(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt);
  
  public static native int RecvPush(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  public static native int SendData(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  public static native int Stop(long paramLong);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/service/Protocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */