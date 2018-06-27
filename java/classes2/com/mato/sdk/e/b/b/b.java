package com.mato.sdk.e.b.b;

import com.mato.sdk.b.g;

public final class b
{
  private static final String a = g.b("");
  
  /* Error */
  public static c a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: new 31	com/mato/sdk/e/b/b/c
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 34	com/mato/sdk/e/b/b/c:<init>	(Ljava/lang/String;)V
    //   12: astore 4
    //   14: new 36	java/lang/StringBuilder
    //   17: dup
    //   18: ldc 38
    //   20: invokespecial 39	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: aload_0
    //   24: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: astore_0
    //   31: invokestatic 53	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   34: aload_0
    //   35: invokevirtual 57	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   38: astore_0
    //   39: new 59	java/io/BufferedReader
    //   42: dup
    //   43: new 61	java/io/InputStreamReader
    //   46: dup
    //   47: aload_0
    //   48: invokevirtual 67	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   51: invokespecial 70	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   54: invokespecial 73	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   57: astore_2
    //   58: aload_2
    //   59: invokevirtual 76	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   62: astore_1
    //   63: aload_1
    //   64: ifnull +166 -> 230
    //   67: aload_1
    //   68: ldc 78
    //   70: invokevirtual 84	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   73: ifeq +9 -> 82
    //   76: aload 4
    //   78: aload_1
    //   79: invokestatic 87	com/mato/sdk/e/b/b/b:a	(Lcom/mato/sdk/e/b/b/c;Ljava/lang/String;)V
    //   82: aload_1
    //   83: ldc 89
    //   85: invokevirtual 84	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   88: ifeq -30 -> 58
    //   91: aload_1
    //   92: ldc 91
    //   94: invokevirtual 95	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   97: astore_1
    //   98: aload 4
    //   100: aload_1
    //   101: iconst_4
    //   102: aaload
    //   103: ldc 97
    //   105: invokevirtual 95	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   108: iconst_0
    //   109: aaload
    //   110: invokestatic 103	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   113: putfield 107	com/mato/sdk/e/b/b/c:d	I
    //   116: aload 4
    //   118: aload_1
    //   119: iconst_5
    //   120: aaload
    //   121: ldc 97
    //   123: invokevirtual 95	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   126: iconst_0
    //   127: aaload
    //   128: invokestatic 103	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   131: putfield 110	com/mato/sdk/e/b/b/c:e	I
    //   134: aload 4
    //   136: aload_1
    //   137: iconst_3
    //   138: aaload
    //   139: ldc 112
    //   141: invokevirtual 95	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   144: iconst_1
    //   145: aaload
    //   146: ldc 97
    //   148: invokevirtual 95	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   151: iconst_0
    //   152: aaload
    //   153: invokestatic 103	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   156: putfield 115	com/mato/sdk/e/b/b/c:c	I
    //   159: new 36	java/lang/StringBuilder
    //   162: dup
    //   163: ldc 117
    //   165: invokespecial 39	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   168: aload 4
    //   170: getfield 107	com/mato/sdk/e/b/b/c:d	I
    //   173: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: ldc 122
    //   178: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 4
    //   183: getfield 110	com/mato/sdk/e/b/b/c:e	I
    //   186: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: ldc 124
    //   191: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload 4
    //   196: getfield 115	com/mato/sdk/e/b/b/c:c	I
    //   199: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: goto -145 -> 58
    //   206: astore_1
    //   207: aload_0
    //   208: astore_1
    //   209: aload_2
    //   210: astore_0
    //   211: aload_1
    //   212: ifnull +7 -> 219
    //   215: aload_1
    //   216: invokevirtual 127	java/lang/Process:destroy	()V
    //   219: aload_0
    //   220: ifnull +7 -> 227
    //   223: aload_0
    //   224: invokevirtual 130	java/io/BufferedReader:close	()V
    //   227: aload 4
    //   229: areturn
    //   230: aload_0
    //   231: invokevirtual 134	java/lang/Process:waitFor	()I
    //   234: pop
    //   235: aload_0
    //   236: ifnull +7 -> 243
    //   239: aload_0
    //   240: invokevirtual 127	java/lang/Process:destroy	()V
    //   243: aload_2
    //   244: invokevirtual 130	java/io/BufferedReader:close	()V
    //   247: aload 4
    //   249: areturn
    //   250: astore_0
    //   251: aload 4
    //   253: areturn
    //   254: astore_1
    //   255: aconst_null
    //   256: astore_0
    //   257: aload_3
    //   258: astore_2
    //   259: aload_0
    //   260: ifnull +7 -> 267
    //   263: aload_0
    //   264: invokevirtual 127	java/lang/Process:destroy	()V
    //   267: aload_2
    //   268: ifnull +7 -> 275
    //   271: aload_2
    //   272: invokevirtual 130	java/io/BufferedReader:close	()V
    //   275: aload_1
    //   276: athrow
    //   277: astore_1
    //   278: goto -43 -> 235
    //   281: astore_0
    //   282: aload 4
    //   284: areturn
    //   285: astore_0
    //   286: goto -11 -> 275
    //   289: astore_1
    //   290: aload_3
    //   291: astore_2
    //   292: goto -33 -> 259
    //   295: astore_1
    //   296: goto -37 -> 259
    //   299: astore_0
    //   300: aconst_null
    //   301: astore_0
    //   302: goto -91 -> 211
    //   305: astore_1
    //   306: aconst_null
    //   307: astore_2
    //   308: aload_0
    //   309: astore_1
    //   310: aload_2
    //   311: astore_0
    //   312: goto -101 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	paramString	String
    //   3	134	1	localObject1	Object
    //   206	1	1	localException1	Exception
    //   208	8	1	str1	String
    //   254	22	1	localObject2	Object
    //   277	1	1	localInterruptedException	InterruptedException
    //   289	1	1	localObject3	Object
    //   295	1	1	localObject4	Object
    //   305	1	1	localException2	Exception
    //   309	1	1	str2	String
    //   57	254	2	localObject5	Object
    //   1	290	3	localObject6	Object
    //   12	271	4	localc	c
    // Exception table:
    //   from	to	target	type
    //   58	63	206	java/lang/Exception
    //   67	82	206	java/lang/Exception
    //   82	203	206	java/lang/Exception
    //   230	235	206	java/lang/Exception
    //   243	247	250	java/io/IOException
    //   14	39	254	finally
    //   230	235	277	java/lang/InterruptedException
    //   223	227	281	java/io/IOException
    //   271	275	285	java/io/IOException
    //   39	58	289	finally
    //   58	63	295	finally
    //   67	82	295	finally
    //   82	203	295	finally
    //   230	235	295	finally
    //   14	39	299	java/lang/Exception
    //   39	58	305	java/lang/Exception
  }
  
  private static void a(c paramc, String paramString)
  {
    paramString.contains("errors");
    paramString = paramString.split(",");
    int i = 0;
    for (;;)
    {
      if (i < paramString.length)
      {
        if (paramString[i].contains("packet loss")) {
          paramc.b = Integer.valueOf(paramString[i].split("%")[0].trim()).intValue();
        }
      }
      else
      {
        i = paramc.b;
        return;
      }
      i += 1;
    }
  }
  
  private static void b(c paramc, String paramString)
  {
    paramString = paramString.split("/");
    paramc.d = Integer.parseInt(paramString[4].split("\\.")[0]);
    paramc.e = Integer.parseInt(paramString[5].split("\\.")[0]);
    paramc.c = Integer.parseInt(paramString[3].split(" = ")[1].split("\\.")[0]);
    new StringBuilder("avgRTT:").append(paramc.d).append(" maxRTT:").append(paramc.e).append(" minRTT:").append(paramc.c);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/b/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */