package com.alipay.sdk.f;

import com.alipay.sdk.b.a;
import com.alipay.sdk.d.d;
import com.alipay.sdk.j.k;

public final class e
{
  private boolean a;
  private String b;
  
  public e(boolean paramBoolean)
  {
    this.a = paramBoolean;
    this.b = k.d();
  }
  
  /* Error */
  private static byte[] a(byte[]... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: arraylength
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 29	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 30	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore 4
    //   18: new 32	java/io/DataOutputStream
    //   21: dup
    //   22: aload 4
    //   24: invokespecial 35	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore_3
    //   28: iload_1
    //   29: aload_0
    //   30: arraylength
    //   31: if_icmpge +48 -> 79
    //   34: aload_0
    //   35: iload_1
    //   36: aaload
    //   37: arraylength
    //   38: istore_2
    //   39: aload_3
    //   40: invokestatic 41	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   43: ldc 43
    //   45: iconst_1
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: iload_2
    //   52: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: invokestatic 55	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   59: invokevirtual 59	java/lang/String:getBytes	()[B
    //   62: invokevirtual 63	java/io/DataOutputStream:write	([B)V
    //   65: aload_3
    //   66: aload_0
    //   67: iload_1
    //   68: aaload
    //   69: invokevirtual 63	java/io/DataOutputStream:write	([B)V
    //   72: iload_1
    //   73: iconst_1
    //   74: iadd
    //   75: istore_1
    //   76: goto -48 -> 28
    //   79: aload_3
    //   80: invokevirtual 66	java/io/DataOutputStream:flush	()V
    //   83: aload 4
    //   85: invokevirtual 69	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   88: astore_0
    //   89: aload 4
    //   91: invokevirtual 72	java/io/ByteArrayOutputStream:close	()V
    //   94: aload_3
    //   95: invokevirtual 73	java/io/DataOutputStream:close	()V
    //   98: aload_0
    //   99: areturn
    //   100: astore_3
    //   101: aload_0
    //   102: areturn
    //   103: astore_0
    //   104: aconst_null
    //   105: astore_0
    //   106: aconst_null
    //   107: astore 4
    //   109: aload 4
    //   111: ifnull +8 -> 119
    //   114: aload 4
    //   116: invokevirtual 72	java/io/ByteArrayOutputStream:close	()V
    //   119: aload_0
    //   120: ifnull -113 -> 7
    //   123: aload_0
    //   124: invokevirtual 73	java/io/DataOutputStream:close	()V
    //   127: aconst_null
    //   128: areturn
    //   129: astore_0
    //   130: aconst_null
    //   131: areturn
    //   132: astore_0
    //   133: aconst_null
    //   134: astore 4
    //   136: aconst_null
    //   137: astore_3
    //   138: aload 4
    //   140: ifnull +8 -> 148
    //   143: aload 4
    //   145: invokevirtual 72	java/io/ByteArrayOutputStream:close	()V
    //   148: aload_3
    //   149: ifnull +7 -> 156
    //   152: aload_3
    //   153: invokevirtual 73	java/io/DataOutputStream:close	()V
    //   156: aload_0
    //   157: athrow
    //   158: astore 4
    //   160: goto -66 -> 94
    //   163: astore_3
    //   164: goto -45 -> 119
    //   167: astore 4
    //   169: goto -21 -> 148
    //   172: astore_3
    //   173: goto -17 -> 156
    //   176: astore_0
    //   177: aconst_null
    //   178: astore_3
    //   179: goto -41 -> 138
    //   182: astore_0
    //   183: goto -45 -> 138
    //   186: astore_0
    //   187: aconst_null
    //   188: astore_0
    //   189: goto -80 -> 109
    //   192: astore_0
    //   193: aload_3
    //   194: astore_0
    //   195: goto -86 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramVarArgs	byte[][]
    //   1	75	1	i	int
    //   38	14	2	j	int
    //   27	68	3	localDataOutputStream	java.io.DataOutputStream
    //   100	1	3	localException1	Exception
    //   137	16	3	localObject1	Object
    //   163	1	3	localException2	Exception
    //   172	1	3	localException3	Exception
    //   178	16	3	localObject2	Object
    //   16	128	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   158	1	4	localException4	Exception
    //   167	1	4	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   94	98	100	java/lang/Exception
    //   9	18	103	java/lang/Exception
    //   123	127	129	java/lang/Exception
    //   9	18	132	finally
    //   89	94	158	java/lang/Exception
    //   114	119	163	java/lang/Exception
    //   143	148	167	java/lang/Exception
    //   152	156	172	java/lang/Exception
    //   18	28	176	finally
    //   28	72	182	finally
    //   79	89	182	finally
    //   18	28	186	java/lang/Exception
    //   28	72	192	java/lang/Exception
    //   79	89	192	java/lang/Exception
  }
  
  /* Error */
  public final b a(c paramc)
  {
    // Byte code:
    //   0: new 76	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_1
    //   5: getfield 81	com/alipay/sdk/f/c:b	[B
    //   8: invokespecial 83	java/io/ByteArrayInputStream:<init>	([B)V
    //   11: astore 4
    //   13: iconst_5
    //   14: newarray <illegal type>
    //   16: astore_3
    //   17: aload 4
    //   19: aload_3
    //   20: invokevirtual 87	java/io/ByteArrayInputStream:read	([B)I
    //   23: pop
    //   24: new 51	java/lang/String
    //   27: dup
    //   28: aload_3
    //   29: invokespecial 88	java/lang/String:<init>	([B)V
    //   32: invokestatic 92	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   35: newarray <illegal type>
    //   37: astore_3
    //   38: aload 4
    //   40: aload_3
    //   41: invokevirtual 87	java/io/ByteArrayInputStream:read	([B)I
    //   44: pop
    //   45: new 51	java/lang/String
    //   48: dup
    //   49: aload_3
    //   50: invokespecial 88	java/lang/String:<init>	([B)V
    //   53: astore 5
    //   55: iconst_5
    //   56: newarray <illegal type>
    //   58: astore_3
    //   59: aload 4
    //   61: aload_3
    //   62: invokevirtual 87	java/io/ByteArrayInputStream:read	([B)I
    //   65: pop
    //   66: new 51	java/lang/String
    //   69: dup
    //   70: aload_3
    //   71: invokespecial 88	java/lang/String:<init>	([B)V
    //   74: invokestatic 92	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   77: istore_2
    //   78: iload_2
    //   79: ifle +166 -> 245
    //   82: iload_2
    //   83: newarray <illegal type>
    //   85: astore 6
    //   87: aload 4
    //   89: aload 6
    //   91: invokevirtual 87	java/io/ByteArrayInputStream:read	([B)I
    //   94: pop
    //   95: aload 6
    //   97: astore_3
    //   98: aload_0
    //   99: getfield 15	com/alipay/sdk/f/e:a	Z
    //   102: ifeq +13 -> 115
    //   105: aload_0
    //   106: getfield 23	com/alipay/sdk/f/e:b	Ljava/lang/String;
    //   109: aload 6
    //   111: invokestatic 97	com/alipay/sdk/d/e:b	(Ljava/lang/String;[B)[B
    //   114: astore_3
    //   115: aload_1
    //   116: getfield 98	com/alipay/sdk/f/c:a	Z
    //   119: ifeq +121 -> 240
    //   122: aload_3
    //   123: invokestatic 103	com/alipay/sdk/d/c:b	([B)[B
    //   126: astore_1
    //   127: new 51	java/lang/String
    //   130: dup
    //   131: aload_1
    //   132: invokespecial 88	java/lang/String:<init>	([B)V
    //   135: astore_1
    //   136: aload 4
    //   138: invokevirtual 104	java/io/ByteArrayInputStream:close	()V
    //   141: aload 5
    //   143: astore_3
    //   144: aload_3
    //   145: ifnonnull +59 -> 204
    //   148: aload_1
    //   149: ifnonnull +55 -> 204
    //   152: aconst_null
    //   153: areturn
    //   154: astore_3
    //   155: aload 5
    //   157: astore_3
    //   158: goto -14 -> 144
    //   161: astore_1
    //   162: aconst_null
    //   163: astore 4
    //   165: aconst_null
    //   166: astore_3
    //   167: aload 4
    //   169: ifnull +66 -> 235
    //   172: aload 4
    //   174: invokevirtual 104	java/io/ByteArrayInputStream:close	()V
    //   177: aconst_null
    //   178: astore_1
    //   179: goto -35 -> 144
    //   182: astore_1
    //   183: aconst_null
    //   184: astore_1
    //   185: goto -41 -> 144
    //   188: astore_1
    //   189: aconst_null
    //   190: astore 4
    //   192: aload 4
    //   194: ifnull +8 -> 202
    //   197: aload 4
    //   199: invokevirtual 104	java/io/ByteArrayInputStream:close	()V
    //   202: aload_1
    //   203: athrow
    //   204: new 106	com/alipay/sdk/f/b
    //   207: dup
    //   208: aload_3
    //   209: aload_1
    //   210: invokespecial 109	com/alipay/sdk/f/b:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: areturn
    //   214: astore_3
    //   215: goto -13 -> 202
    //   218: astore_1
    //   219: goto -27 -> 192
    //   222: astore_1
    //   223: aconst_null
    //   224: astore_3
    //   225: goto -58 -> 167
    //   228: astore_1
    //   229: aload 5
    //   231: astore_3
    //   232: goto -65 -> 167
    //   235: aconst_null
    //   236: astore_1
    //   237: goto -93 -> 144
    //   240: aload_3
    //   241: astore_1
    //   242: goto -115 -> 127
    //   245: aconst_null
    //   246: astore_1
    //   247: goto -111 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	e
    //   0	250	1	paramc	c
    //   77	6	2	i	int
    //   16	129	3	localObject1	Object
    //   154	1	3	localException1	Exception
    //   157	52	3	localObject2	Object
    //   214	1	3	localException2	Exception
    //   224	17	3	localObject3	Object
    //   11	187	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   53	177	5	str	String
    //   85	25	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   136	141	154	java/lang/Exception
    //   0	13	161	java/lang/Exception
    //   172	177	182	java/lang/Exception
    //   0	13	188	finally
    //   197	202	214	java/lang/Exception
    //   13	55	218	finally
    //   55	78	218	finally
    //   82	95	218	finally
    //   98	115	218	finally
    //   115	127	218	finally
    //   127	136	218	finally
    //   13	55	222	java/lang/Exception
    //   55	78	228	java/lang/Exception
    //   82	95	228	java/lang/Exception
    //   98	115	228	java/lang/Exception
    //   115	127	228	java/lang/Exception
    //   127	136	228	java/lang/Exception
  }
  
  public final c a(b paramb, boolean paramBoolean)
  {
    arrayOfByte2 = paramb.a.getBytes();
    arrayOfByte1 = paramb.b.getBytes();
    paramb = arrayOfByte1;
    bool = paramBoolean;
    if (paramBoolean) {}
    try
    {
      paramb = com.alipay.sdk.d.c.a(arrayOfByte1);
      bool = paramBoolean;
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        bool = false;
        paramb = arrayOfByte1;
        continue;
        paramb = a(new byte[][] { arrayOfByte2, paramb });
      }
    }
    if (this.a)
    {
      paramb = a(new byte[][] { arrayOfByte2, d.a(this.b, a.b), com.alipay.sdk.d.e.a(this.b, paramb) });
      return new c(bool, paramb);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/sdk/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */