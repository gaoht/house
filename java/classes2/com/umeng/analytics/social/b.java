package com.umeng.analytics.social;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class b
{
  private static String a(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 8192);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str + "\n");
      }
      return null;
    }
    catch (IOException localIOException) {}finally
    {
      try
      {
        paramInputStream.close();
        return null;
      }
      catch (IOException paramInputStream)
      {
        return null;
      }
      try
      {
        paramInputStream.close();
        return localStringBuilder.toString();
      }
      catch (IOException paramInputStream)
      {
        try
        {
          paramInputStream.close();
          throw ((Throwable)localObject);
        }
        catch (IOException paramInputStream) {}
        paramInputStream = paramInputStream;
        return null;
      }
      localObject = finally;
    }
  }
  
  /* Error */
  protected static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 49	java/util/Random
    //   5: dup
    //   6: invokespecial 50	java/util/Random:<init>	()V
    //   9: sipush 1000
    //   12: invokevirtual 54	java/util/Random:nextInt	(I)I
    //   15: istore_1
    //   16: ldc 56
    //   18: invokestatic 61	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   21: astore 4
    //   23: aload_0
    //   24: invokevirtual 67	java/lang/String:length	()I
    //   27: iconst_1
    //   28: if_icmpgt +39 -> 67
    //   31: new 25	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   38: iload_1
    //   39: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: ldc 72
    //   44: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 78	com/umeng/analytics/pro/by:e	(Ljava/lang/String;)V
    //   53: iconst_0
    //   54: ifeq +11 -> 65
    //   57: new 80	java/lang/NullPointerException
    //   60: dup
    //   61: invokespecial 81	java/lang/NullPointerException:<init>	()V
    //   64: athrow
    //   65: aconst_null
    //   66: areturn
    //   67: new 83	java/net/URL
    //   70: dup
    //   71: aload_0
    //   72: invokespecial 85	java/net/URL:<init>	(Ljava/lang/String;)V
    //   75: invokevirtual 89	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   78: checkcast 91	java/net/HttpURLConnection
    //   81: astore_2
    //   82: aload_2
    //   83: sipush 10000
    //   86: invokevirtual 95	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   89: aload_2
    //   90: sipush 20000
    //   93: invokevirtual 98	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   96: aload_2
    //   97: ldc 100
    //   99: invokevirtual 103	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   102: getstatic 109	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   105: invokestatic 115	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   108: bipush 8
    //   110: if_icmpge +11 -> 121
    //   113: ldc 117
    //   115: ldc 119
    //   117: invokestatic 123	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   120: pop
    //   121: new 25	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   128: iload_1
    //   129: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: ldc 125
    //   134: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_0
    //   138: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 128	com/umeng/analytics/pro/by:c	(Ljava/lang/String;)V
    //   147: aload_2
    //   148: invokevirtual 131	java/net/HttpURLConnection:getResponseCode	()I
    //   151: sipush 200
    //   154: if_icmpne +183 -> 337
    //   157: aload_2
    //   158: invokevirtual 135	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   161: astore_0
    //   162: aload_2
    //   163: ldc -119
    //   165: invokevirtual 140	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   168: astore_3
    //   169: aload_3
    //   170: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   173: ifne +93 -> 266
    //   176: aload_3
    //   177: ldc -108
    //   179: invokevirtual 152	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   182: ifeq +84 -> 266
    //   185: new 25	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   192: iload_1
    //   193: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: ldc -102
    //   198: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 128	com/umeng/analytics/pro/by:c	(Ljava/lang/String;)V
    //   207: new 156	java/util/zip/GZIPInputStream
    //   210: dup
    //   211: aload_0
    //   212: invokespecial 157	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   215: astore_0
    //   216: aload_0
    //   217: invokestatic 159	com/umeng/analytics/social/b:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   220: astore_0
    //   221: new 25	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   228: iload_1
    //   229: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: ldc -95
    //   234: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload 4
    //   239: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_0
    //   243: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 128	com/umeng/analytics/pro/by:c	(Ljava/lang/String;)V
    //   252: aload_0
    //   253: ifnonnull +74 -> 327
    //   256: aload_2
    //   257: ifnull +7 -> 264
    //   260: aload_2
    //   261: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   264: aconst_null
    //   265: areturn
    //   266: aload_3
    //   267: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   270: ifne +126 -> 396
    //   273: aload_3
    //   274: ldc -90
    //   276: invokevirtual 152	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   279: ifeq +117 -> 396
    //   282: new 25	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   289: iload_1
    //   290: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: ldc -88
    //   295: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 128	com/umeng/analytics/pro/by:c	(Ljava/lang/String;)V
    //   304: new 170	java/util/zip/InflaterInputStream
    //   307: dup
    //   308: aload_0
    //   309: invokespecial 171	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   312: astore_0
    //   313: goto -97 -> 216
    //   316: astore_0
    //   317: aload_2
    //   318: ifnull +7 -> 325
    //   321: aload_2
    //   322: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   325: aconst_null
    //   326: areturn
    //   327: aload_2
    //   328: ifnull +7 -> 335
    //   331: aload_2
    //   332: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   335: aload_0
    //   336: areturn
    //   337: new 25	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   344: iload_1
    //   345: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   348: ldc -83
    //   350: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload_0
    //   354: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 128	com/umeng/analytics/pro/by:c	(Ljava/lang/String;)V
    //   363: aload_2
    //   364: ifnull +7 -> 371
    //   367: aload_2
    //   368: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   371: aconst_null
    //   372: areturn
    //   373: astore_0
    //   374: aload_3
    //   375: astore_2
    //   376: aload_2
    //   377: ifnull +7 -> 384
    //   380: aload_2
    //   381: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   384: aload_0
    //   385: athrow
    //   386: astore_0
    //   387: goto -11 -> 376
    //   390: astore_0
    //   391: aconst_null
    //   392: astore_2
    //   393: goto -76 -> 317
    //   396: goto -180 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	paramString	String
    //   15	330	1	i	int
    //   81	312	2	localObject	Object
    //   1	374	3	str1	String
    //   21	217	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   82	121	316	java/lang/Exception
    //   121	216	316	java/lang/Exception
    //   216	252	316	java/lang/Exception
    //   266	313	316	java/lang/Exception
    //   337	363	316	java/lang/Exception
    //   16	53	373	finally
    //   67	82	373	finally
    //   82	121	386	finally
    //   121	216	386	finally
    //   216	252	386	finally
    //   266	313	386	finally
    //   337	363	386	finally
    //   16	53	390	java/lang/Exception
    //   67	82	390	java/lang/Exception
  }
  
  /* Error */
  protected static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 49	java/util/Random
    //   6: dup
    //   7: invokespecial 50	java/util/Random:<init>	()V
    //   10: sipush 1000
    //   13: invokevirtual 54	java/util/Random:nextInt	(I)I
    //   16: istore_2
    //   17: ldc 56
    //   19: invokestatic 61	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 5
    //   24: new 83	java/net/URL
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 85	java/net/URL:<init>	(Ljava/lang/String;)V
    //   32: invokevirtual 89	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   35: checkcast 91	java/net/HttpURLConnection
    //   38: astore_3
    //   39: aload_3
    //   40: sipush 10000
    //   43: invokevirtual 95	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   46: aload_3
    //   47: sipush 20000
    //   50: invokevirtual 98	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   53: aload_3
    //   54: iconst_1
    //   55: invokevirtual 177	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   58: aload_3
    //   59: iconst_1
    //   60: invokevirtual 180	java/net/HttpURLConnection:setDoInput	(Z)V
    //   63: aload_3
    //   64: iconst_0
    //   65: invokevirtual 183	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   68: aload_3
    //   69: ldc -71
    //   71: invokevirtual 103	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   74: new 25	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   81: iload_2
    //   82: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: ldc -69
    //   87: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 128	com/umeng/analytics/pro/by:c	(Ljava/lang/String;)V
    //   100: getstatic 109	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   103: invokestatic 115	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   106: bipush 8
    //   108: if_icmpge +11 -> 119
    //   111: ldc 117
    //   113: ldc 119
    //   115: invokestatic 123	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   118: pop
    //   119: aload_1
    //   120: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifne +93 -> 216
    //   126: new 25	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   133: iload_2
    //   134: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: ldc -67
    //   139: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_1
    //   143: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 128	com/umeng/analytics/pro/by:c	(Ljava/lang/String;)V
    //   152: new 191	java/util/ArrayList
    //   155: dup
    //   156: invokespecial 192	java/util/ArrayList:<init>	()V
    //   159: astore 4
    //   161: aload 4
    //   163: new 25	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   170: ldc -62
    //   172: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_1
    //   176: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokeinterface 200 2 0
    //   187: pop
    //   188: aload_3
    //   189: invokevirtual 204	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   192: astore_1
    //   193: aload_1
    //   194: aload 4
    //   196: invokevirtual 205	java/lang/Object:toString	()Ljava/lang/String;
    //   199: invokestatic 210	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   202: invokevirtual 214	java/lang/String:getBytes	()[B
    //   205: invokevirtual 220	java/io/OutputStream:write	([B)V
    //   208: aload_1
    //   209: invokevirtual 223	java/io/OutputStream:flush	()V
    //   212: aload_1
    //   213: invokevirtual 224	java/io/OutputStream:close	()V
    //   216: aload_3
    //   217: invokevirtual 131	java/net/HttpURLConnection:getResponseCode	()I
    //   220: sipush 200
    //   223: if_icmpne +100 -> 323
    //   226: aload_3
    //   227: invokevirtual 135	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   230: astore_0
    //   231: aload_3
    //   232: ldc -119
    //   234: invokevirtual 140	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   237: astore_1
    //   238: aload_1
    //   239: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   242: ifne +152 -> 394
    //   245: aload_1
    //   246: ldc -108
    //   248: invokevirtual 152	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   251: ifeq +143 -> 394
    //   254: new 170	java/util/zip/InflaterInputStream
    //   257: dup
    //   258: aload_0
    //   259: invokespecial 171	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   262: astore_0
    //   263: aload_0
    //   264: invokestatic 159	com/umeng/analytics/social/b:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   267: astore_0
    //   268: new 25	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   275: iload_2
    //   276: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   279: ldc -95
    //   281: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload 5
    //   286: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload_0
    //   290: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 128	com/umeng/analytics/pro/by:c	(Ljava/lang/String;)V
    //   299: aload_0
    //   300: ifnonnull +13 -> 313
    //   303: aload_3
    //   304: ifnull +7 -> 311
    //   307: aload_3
    //   308: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   311: aconst_null
    //   312: areturn
    //   313: aload_3
    //   314: ifnull +7 -> 321
    //   317: aload_3
    //   318: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   321: aload_0
    //   322: areturn
    //   323: new 25	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   330: iload_2
    //   331: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   334: ldc -30
    //   336: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: aload_0
    //   340: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 78	com/umeng/analytics/pro/by:e	(Ljava/lang/String;)V
    //   349: aload_3
    //   350: ifnull +7 -> 357
    //   353: aload_3
    //   354: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   357: aconst_null
    //   358: areturn
    //   359: astore_0
    //   360: aconst_null
    //   361: astore_3
    //   362: aload_3
    //   363: ifnull +7 -> 370
    //   366: aload_3
    //   367: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   370: aconst_null
    //   371: areturn
    //   372: astore_0
    //   373: aload 4
    //   375: astore_3
    //   376: aload_3
    //   377: ifnull +7 -> 384
    //   380: aload_3
    //   381: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   384: aload_0
    //   385: athrow
    //   386: astore_0
    //   387: goto -11 -> 376
    //   390: astore_0
    //   391: goto -29 -> 362
    //   394: goto -131 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	paramString1	String
    //   0	397	1	paramString2	String
    //   16	315	2	i	int
    //   38	343	3	localObject	Object
    //   1	373	4	localArrayList	java.util.ArrayList
    //   22	263	5	str	String
    // Exception table:
    //   from	to	target	type
    //   17	39	359	java/lang/Exception
    //   17	39	372	finally
    //   39	119	386	finally
    //   119	216	386	finally
    //   216	263	386	finally
    //   263	299	386	finally
    //   323	349	386	finally
    //   39	119	390	java/lang/Exception
    //   119	216	390	java/lang/Exception
    //   216	263	390	java/lang/Exception
    //   263	299	390	java/lang/Exception
    //   323	349	390	java/lang/Exception
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/social/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */