package com.alipay.sdk.d;

public final class c
{
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 17	java/io/ByteArrayInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 20	java/io/ByteArrayInputStream:<init>	([B)V
    //   11: astore_0
    //   12: new 22	java/io/ByteArrayOutputStream
    //   15: dup
    //   16: invokespecial 23	java/io/ByteArrayOutputStream:<init>	()V
    //   19: astore_2
    //   20: new 25	java/util/zip/GZIPOutputStream
    //   23: dup
    //   24: aload_2
    //   25: invokespecial 28	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   28: astore 5
    //   30: sipush 4096
    //   33: newarray <illegal type>
    //   35: astore_3
    //   36: aload_0
    //   37: aload_3
    //   38: invokevirtual 32	java/io/ByteArrayInputStream:read	([B)I
    //   41: istore_1
    //   42: iload_1
    //   43: iconst_m1
    //   44: if_icmpeq +55 -> 99
    //   47: aload 5
    //   49: aload_3
    //   50: iconst_0
    //   51: iload_1
    //   52: invokevirtual 36	java/util/zip/GZIPOutputStream:write	([BII)V
    //   55: goto -19 -> 36
    //   58: astore 6
    //   60: aload_0
    //   61: astore_3
    //   62: aload_2
    //   63: astore 4
    //   65: aload 5
    //   67: astore_2
    //   68: aload 6
    //   70: astore_0
    //   71: aload_3
    //   72: ifnull +7 -> 79
    //   75: aload_3
    //   76: invokevirtual 39	java/io/ByteArrayInputStream:close	()V
    //   79: aload 4
    //   81: ifnull +8 -> 89
    //   84: aload 4
    //   86: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   89: aload_2
    //   90: ifnull +7 -> 97
    //   93: aload_2
    //   94: invokevirtual 41	java/util/zip/GZIPOutputStream:close	()V
    //   97: aload_0
    //   98: athrow
    //   99: aload 5
    //   101: invokevirtual 44	java/util/zip/GZIPOutputStream:flush	()V
    //   104: aload 5
    //   106: invokevirtual 47	java/util/zip/GZIPOutputStream:finish	()V
    //   109: aload_2
    //   110: invokevirtual 51	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   113: astore_3
    //   114: aload_0
    //   115: invokevirtual 39	java/io/ByteArrayInputStream:close	()V
    //   118: aload_2
    //   119: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   122: aload 5
    //   124: invokevirtual 41	java/util/zip/GZIPOutputStream:close	()V
    //   127: aload_3
    //   128: areturn
    //   129: astore_0
    //   130: goto -12 -> 118
    //   133: astore_0
    //   134: goto -12 -> 122
    //   137: astore_0
    //   138: aload_3
    //   139: areturn
    //   140: astore_3
    //   141: goto -62 -> 79
    //   144: astore_3
    //   145: goto -56 -> 89
    //   148: astore_2
    //   149: goto -52 -> 97
    //   152: astore_0
    //   153: aconst_null
    //   154: astore_2
    //   155: aconst_null
    //   156: astore_3
    //   157: goto -86 -> 71
    //   160: astore 5
    //   162: aconst_null
    //   163: astore_2
    //   164: aload_0
    //   165: astore_3
    //   166: aload 5
    //   168: astore_0
    //   169: goto -98 -> 71
    //   172: astore 6
    //   174: aconst_null
    //   175: astore 5
    //   177: aload_2
    //   178: astore 4
    //   180: aload_0
    //   181: astore_3
    //   182: aload 6
    //   184: astore_0
    //   185: aload 5
    //   187: astore_2
    //   188: goto -117 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramArrayOfByte	byte[]
    //   41	11	1	i	int
    //   19	100	2	localObject1	Object
    //   148	1	2	localException1	Exception
    //   154	34	2	localObject2	Object
    //   35	104	3	arrayOfByte1	byte[]
    //   140	1	3	localException2	Exception
    //   144	1	3	localException3	Exception
    //   156	26	3	arrayOfByte2	byte[]
    //   1	178	4	localObject3	Object
    //   28	95	5	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   160	7	5	localObject4	Object
    //   175	11	5	localObject5	Object
    //   58	11	6	localObject6	Object
    //   172	11	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   30	36	58	finally
    //   36	42	58	finally
    //   47	55	58	finally
    //   99	114	58	finally
    //   114	118	129	java/lang/Exception
    //   118	122	133	java/lang/Exception
    //   122	127	137	java/lang/Exception
    //   75	79	140	java/lang/Exception
    //   84	89	144	java/lang/Exception
    //   93	97	148	java/lang/Exception
    //   3	12	152	finally
    //   12	20	160	finally
    //   20	30	172	finally
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 17	java/io/ByteArrayInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 20	java/io/ByteArrayInputStream:<init>	([B)V
    //   11: astore_0
    //   12: new 55	java/util/zip/GZIPInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 58	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: astore_3
    //   21: sipush 4096
    //   24: newarray <illegal type>
    //   26: astore 5
    //   28: new 22	java/io/ByteArrayOutputStream
    //   31: dup
    //   32: invokespecial 23	java/io/ByteArrayOutputStream:<init>	()V
    //   35: astore_2
    //   36: aload_3
    //   37: aload 5
    //   39: iconst_0
    //   40: sipush 4096
    //   43: invokevirtual 61	java/util/zip/GZIPInputStream:read	([BII)I
    //   46: istore_1
    //   47: iload_1
    //   48: iconst_m1
    //   49: if_icmpeq +39 -> 88
    //   52: aload_2
    //   53: aload 5
    //   55: iconst_0
    //   56: iload_1
    //   57: invokevirtual 62	java/io/ByteArrayOutputStream:write	([BII)V
    //   60: goto -24 -> 36
    //   63: astore 5
    //   65: aload_2
    //   66: astore 4
    //   68: aload_0
    //   69: astore_2
    //   70: aload 5
    //   72: astore_0
    //   73: aload 4
    //   75: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   78: aload_3
    //   79: invokevirtual 63	java/util/zip/GZIPInputStream:close	()V
    //   82: aload_2
    //   83: invokevirtual 39	java/io/ByteArrayInputStream:close	()V
    //   86: aload_0
    //   87: athrow
    //   88: aload_2
    //   89: invokevirtual 64	java/io/ByteArrayOutputStream:flush	()V
    //   92: aload_2
    //   93: invokevirtual 51	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   96: astore 4
    //   98: aload_2
    //   99: invokevirtual 40	java/io/ByteArrayOutputStream:close	()V
    //   102: aload_3
    //   103: invokevirtual 63	java/util/zip/GZIPInputStream:close	()V
    //   106: aload_0
    //   107: invokevirtual 39	java/io/ByteArrayInputStream:close	()V
    //   110: aload 4
    //   112: areturn
    //   113: astore_2
    //   114: goto -12 -> 102
    //   117: astore_2
    //   118: goto -12 -> 106
    //   121: astore_0
    //   122: aload 4
    //   124: areturn
    //   125: astore 4
    //   127: goto -49 -> 78
    //   130: astore_3
    //   131: goto -49 -> 82
    //   134: astore_2
    //   135: goto -49 -> 86
    //   138: astore_0
    //   139: aconst_null
    //   140: astore_3
    //   141: aconst_null
    //   142: astore_2
    //   143: goto -70 -> 73
    //   146: astore 5
    //   148: aconst_null
    //   149: astore_3
    //   150: aload_0
    //   151: astore_2
    //   152: aload 5
    //   154: astore_0
    //   155: goto -82 -> 73
    //   158: astore 5
    //   160: aload_0
    //   161: astore_2
    //   162: aload 5
    //   164: astore_0
    //   165: goto -92 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramArrayOfByte	byte[]
    //   46	11	1	i	int
    //   35	64	2	localObject1	Object
    //   113	1	2	localException1	Exception
    //   117	1	2	localException2	Exception
    //   134	1	2	localException3	Exception
    //   142	20	2	arrayOfByte1	byte[]
    //   20	83	3	localGZIPInputStream	java.util.zip.GZIPInputStream
    //   130	1	3	localException4	Exception
    //   140	10	3	localObject2	Object
    //   1	122	4	localObject3	Object
    //   125	1	4	localException5	Exception
    //   26	28	5	arrayOfByte2	byte[]
    //   63	8	5	localObject4	Object
    //   146	7	5	localObject5	Object
    //   158	5	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   36	47	63	finally
    //   52	60	63	finally
    //   88	98	63	finally
    //   98	102	113	java/lang/Exception
    //   102	106	117	java/lang/Exception
    //   106	110	121	java/lang/Exception
    //   73	78	125	java/lang/Exception
    //   78	82	130	java/lang/Exception
    //   82	86	134	java/lang/Exception
    //   3	12	138	finally
    //   12	21	146	finally
    //   21	36	158	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/sdk/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */