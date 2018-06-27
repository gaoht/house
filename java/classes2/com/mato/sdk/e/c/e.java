package com.mato.sdk.e.c;

import android.text.TextUtils;
import com.mato.sdk.b.g;
import com.mato.sdk.b.h;
import com.mato.sdk.d.m;
import com.mato.sdk.proxy.a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class e
{
  private static final String a = g.b("");
  
  private static int a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte['ࠀ'];
    int i = 0;
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte);
      if (j <= 0) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, j);
      i += j;
    }
    return i;
  }
  
  private static String a(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      URL localURL = new URL(paramString);
      String str = "";
      if (!TextUtils.isEmpty(localURL.getHost())) {
        if (TextUtils.isEmpty(localURL.getFile())) {
          break label80;
        }
      }
      label80:
      for (str = m.a(paramString);; str = m.a(paramString + "/"))
      {
        paramString = new StringBuilder();
        paramString.append(str).append(".").append(paramLong1).append(".").append(paramLong2);
        return paramString.toString();
      }
      return null;
    }
    catch (Exception paramString) {}
  }
  
  private static String a(Map<String, List<String>> paramMap)
  {
    if (paramMap == null) {
      return "\r\n\r\n";
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (List)((Map.Entry)localObject).getValue();
      StringBuilder localStringBuilder2 = new StringBuilder();
      int i = 0;
      while (i < ((List)localObject).size())
      {
        localStringBuilder2.append((String)((List)localObject).get(i));
        i += 1;
      }
      localObject = localStringBuilder2.toString();
      if (str == null)
      {
        localStringBuilder1.append((String)localObject);
        localStringBuilder1.append("\r\n");
      }
      else if (!str.equalsIgnoreCase("transfer-encoding"))
      {
        localStringBuilder1.append(str);
        localStringBuilder1.append(":");
        localStringBuilder1.append((String)localObject);
        localStringBuilder1.append("\r\n");
      }
    }
    localStringBuilder1.append("WSPX-Precache:true");
    localStringBuilder1.append("\r\n");
    return localStringBuilder1.toString();
  }
  
  public static List<String> a(int paramInt, c paramc, long paramLong1, long paramLong2, String paramString)
  {
    paramString = new File(paramString);
    ArrayList localArrayList1 = new ArrayList(paramc.e());
    ArrayList localArrayList2 = new ArrayList();
    int j = 0;
    if (j < localArrayList1.size())
    {
      String str1 = (String)localArrayList1.get(j);
      int i;
      label119:
      label137:
      File localFile;
      if (!TextUtils.isEmpty(str1)) {
        switch (a.b().h().c())
        {
        default: 
          i = -1;
          if ((i == -1) || ((i & paramInt) != i))
          {
            i = 0;
            if (i != 0)
            {
              String str2 = a(str1, paramLong1, paramLong2);
              if (str2 != null)
              {
                localFile = new File(paramString, str2);
                if (!a(str1, localFile)) {
                  break label248;
                }
                localArrayList2.add(str2);
                paramc.a(str1);
              }
            }
          }
          break;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        i = 1;
        break label119;
        i = 2;
        break label119;
        i = 4;
        break label119;
        i = 8;
        break label119;
        i = -1;
        break label119;
        i = -1;
        break label119;
        i = 1;
        break label137;
        label248:
        if (localFile.exists()) {
          localFile.delete();
        }
      }
    }
    return localArrayList2;
  }
  
  private static boolean a(int paramInt)
  {
    boolean bool = true;
    int i;
    switch (a.b().h().c())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      if ((i == -1) || ((i & paramInt) != i)) {
        bool = false;
      }
      return bool;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 4;
      continue;
      i = 8;
      continue;
      i = -1;
      continue;
      i = -1;
    }
  }
  
  /* Error */
  private static boolean a(String paramString, File paramFile)
  {
    // Byte code:
    //   0: invokestatic 197	com/mato/sdk/instrumentation/InstrumentationUtils:getHttpProxy	()Ljava/net/Proxy;
    //   3: astore 4
    //   5: aload 4
    //   7: ifnonnull +5 -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: aconst_null
    //   13: astore_3
    //   14: new 43	java/net/URL
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 46	java/net/URL:<init>	(Ljava/lang/String;)V
    //   22: aload 4
    //   24: invokevirtual 201	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   27: checkcast 203	java/net/HttpURLConnection
    //   30: astore_0
    //   31: aload_0
    //   32: sipush 3000
    //   35: invokevirtual 207	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   38: aload_0
    //   39: sipush 3000
    //   42: invokevirtual 210	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   45: aload_0
    //   46: ldc -44
    //   48: invokevirtual 215	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   51: aload_0
    //   52: invokevirtual 218	java/net/HttpURLConnection:getResponseCode	()I
    //   55: pop
    //   56: aload_0
    //   57: invokevirtual 218	java/net/HttpURLConnection:getResponseCode	()I
    //   60: sipush 200
    //   63: if_icmpne +19 -> 82
    //   66: aload_0
    //   67: aload_1
    //   68: invokestatic 221	com/mato/sdk/e/c/e:a	(Ljava/net/HttpURLConnection;Ljava/io/File;)Z
    //   71: istore_2
    //   72: aload_0
    //   73: ifnull +7 -> 80
    //   76: aload_0
    //   77: invokevirtual 224	java/net/HttpURLConnection:disconnect	()V
    //   80: iload_2
    //   81: ireturn
    //   82: aload_0
    //   83: ifnull +7 -> 90
    //   86: aload_0
    //   87: invokevirtual 224	java/net/HttpURLConnection:disconnect	()V
    //   90: iconst_0
    //   91: ireturn
    //   92: astore_0
    //   93: aconst_null
    //   94: astore_0
    //   95: aload_0
    //   96: ifnull -6 -> 90
    //   99: aload_0
    //   100: invokevirtual 224	java/net/HttpURLConnection:disconnect	()V
    //   103: goto -13 -> 90
    //   106: astore_1
    //   107: aload_3
    //   108: astore_0
    //   109: aload_0
    //   110: ifnull +7 -> 117
    //   113: aload_0
    //   114: invokevirtual 224	java/net/HttpURLConnection:disconnect	()V
    //   117: aload_1
    //   118: athrow
    //   119: astore_1
    //   120: goto -11 -> 109
    //   123: astore_1
    //   124: goto -29 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramString	String
    //   0	127	1	paramFile	File
    //   71	10	2	bool	boolean
    //   13	95	3	localObject	Object
    //   3	20	4	localProxy	java.net.Proxy
    // Exception table:
    //   from	to	target	type
    //   14	31	92	java/lang/Exception
    //   14	31	106	finally
    //   31	72	119	finally
    //   31	72	123	java/lang/Exception
  }
  
  private static boolean a(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderFields().keySet().iterator();
    while (paramHttpURLConnection.hasNext())
    {
      String str = (String)paramHttpURLConnection.next();
      if ((str != null) && (str.equalsIgnoreCase("content-length"))) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  private static boolean a(HttpURLConnection paramHttpURLConnection, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 5
    //   9: new 238	java/io/FileOutputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 241	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   17: astore_3
    //   18: aload_3
    //   19: aload_0
    //   20: invokevirtual 229	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   23: invokestatic 243	com/mato/sdk/e/c/e:a	(Ljava/util/Map;)Ljava/lang/String;
    //   26: invokevirtual 247	java/lang/String:getBytes	()[B
    //   29: invokevirtual 250	java/io/OutputStream:write	([B)V
    //   32: new 252	java/io/BufferedInputStream
    //   35: dup
    //   36: aload_0
    //   37: invokevirtual 256	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   40: invokespecial 259	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore 4
    //   45: aload_0
    //   46: invokestatic 261	com/mato/sdk/e/c/e:a	(Ljava/net/HttpURLConnection;)Z
    //   49: ifeq +69 -> 118
    //   52: aload_3
    //   53: ldc 127
    //   55: invokevirtual 247	java/lang/String:getBytes	()[B
    //   58: invokevirtual 250	java/io/OutputStream:write	([B)V
    //   61: aload 4
    //   63: aload_3
    //   64: invokestatic 263	com/mato/sdk/e/c/e:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   67: pop
    //   68: aconst_null
    //   69: astore_0
    //   70: aconst_null
    //   71: astore_1
    //   72: aload 5
    //   74: astore 6
    //   76: aload_3
    //   77: invokevirtual 266	java/io/OutputStream:flush	()V
    //   80: aload_3
    //   81: invokevirtual 269	java/io/OutputStream:close	()V
    //   84: aload_1
    //   85: ifnull +7 -> 92
    //   88: aload_1
    //   89: invokevirtual 269	java/io/OutputStream:close	()V
    //   92: aload_0
    //   93: ifnull +7 -> 100
    //   96: aload_0
    //   97: invokevirtual 270	java/io/InputStream:close	()V
    //   100: aload 4
    //   102: invokevirtual 270	java/io/InputStream:close	()V
    //   105: aload 6
    //   107: ifnull +9 -> 116
    //   110: aload 6
    //   112: invokevirtual 189	java/io/File:delete	()Z
    //   115: pop
    //   116: iconst_1
    //   117: ireturn
    //   118: new 142	java/io/File
    //   121: dup
    //   122: new 65	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   129: aload_1
    //   130: invokevirtual 273	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   133: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc_w 275
    //   139: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokespecial 143	java/io/File:<init>	(Ljava/lang/String;)V
    //   148: astore_0
    //   149: new 238	java/io/FileOutputStream
    //   152: dup
    //   153: aload_0
    //   154: invokespecial 241	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   157: astore 5
    //   159: aload 4
    //   161: aload 5
    //   163: invokestatic 263	com/mato/sdk/e/c/e:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   166: istore_2
    //   167: aload_3
    //   168: getstatic 281	java/util/Locale:US	Ljava/util/Locale;
    //   171: ldc_w 283
    //   174: iconst_1
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: iload_2
    //   181: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: aastore
    //   185: invokestatic 293	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   188: invokevirtual 247	java/lang/String:getBytes	()[B
    //   191: invokevirtual 250	java/io/OutputStream:write	([B)V
    //   194: aload_3
    //   195: ldc 127
    //   197: invokevirtual 247	java/lang/String:getBytes	()[B
    //   200: invokevirtual 250	java/io/OutputStream:write	([B)V
    //   203: new 295	java/io/FileInputStream
    //   206: dup
    //   207: aload_0
    //   208: invokespecial 296	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   211: astore_1
    //   212: aload_1
    //   213: aload_3
    //   214: invokestatic 263	com/mato/sdk/e/c/e:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   217: pop
    //   218: aload_0
    //   219: astore 6
    //   221: aload_1
    //   222: astore_0
    //   223: aload 5
    //   225: astore_1
    //   226: goto -150 -> 76
    //   229: astore_0
    //   230: aconst_null
    //   231: astore_0
    //   232: aconst_null
    //   233: astore_1
    //   234: aconst_null
    //   235: astore_3
    //   236: aconst_null
    //   237: astore 4
    //   239: aload 6
    //   241: astore 5
    //   243: aload_3
    //   244: ifnull +7 -> 251
    //   247: aload_3
    //   248: invokevirtual 269	java/io/OutputStream:close	()V
    //   251: aload_1
    //   252: ifnull +7 -> 259
    //   255: aload_1
    //   256: invokevirtual 269	java/io/OutputStream:close	()V
    //   259: aload 5
    //   261: ifnull +8 -> 269
    //   264: aload 5
    //   266: invokevirtual 270	java/io/InputStream:close	()V
    //   269: aload 4
    //   271: ifnull +8 -> 279
    //   274: aload 4
    //   276: invokevirtual 270	java/io/InputStream:close	()V
    //   279: aload_0
    //   280: ifnull +8 -> 288
    //   283: aload_0
    //   284: invokevirtual 189	java/io/File:delete	()Z
    //   287: pop
    //   288: iconst_0
    //   289: ireturn
    //   290: astore_0
    //   291: aconst_null
    //   292: astore_1
    //   293: aconst_null
    //   294: astore 5
    //   296: aconst_null
    //   297: astore_3
    //   298: aconst_null
    //   299: astore 4
    //   301: aload 7
    //   303: astore 6
    //   305: aload_3
    //   306: ifnull +7 -> 313
    //   309: aload_3
    //   310: invokevirtual 269	java/io/OutputStream:close	()V
    //   313: aload 5
    //   315: ifnull +8 -> 323
    //   318: aload 5
    //   320: invokevirtual 269	java/io/OutputStream:close	()V
    //   323: aload_1
    //   324: ifnull +7 -> 331
    //   327: aload_1
    //   328: invokevirtual 270	java/io/InputStream:close	()V
    //   331: aload 4
    //   333: ifnull +8 -> 341
    //   336: aload 4
    //   338: invokevirtual 270	java/io/InputStream:close	()V
    //   341: aload 6
    //   343: ifnull +9 -> 352
    //   346: aload 6
    //   348: invokevirtual 189	java/io/File:delete	()Z
    //   351: pop
    //   352: aload_0
    //   353: athrow
    //   354: astore_3
    //   355: goto -271 -> 84
    //   358: astore_1
    //   359: goto -267 -> 92
    //   362: astore_0
    //   363: goto -263 -> 100
    //   366: astore_0
    //   367: goto -262 -> 105
    //   370: astore_3
    //   371: goto -120 -> 251
    //   374: astore_1
    //   375: goto -116 -> 259
    //   378: astore_1
    //   379: goto -110 -> 269
    //   382: astore_1
    //   383: goto -104 -> 279
    //   386: astore_3
    //   387: goto -74 -> 313
    //   390: astore_3
    //   391: goto -68 -> 323
    //   394: astore_1
    //   395: goto -64 -> 331
    //   398: astore_1
    //   399: goto -58 -> 341
    //   402: astore_0
    //   403: aconst_null
    //   404: astore_1
    //   405: aconst_null
    //   406: astore 5
    //   408: aconst_null
    //   409: astore 4
    //   411: aload 7
    //   413: astore 6
    //   415: goto -110 -> 305
    //   418: astore_0
    //   419: aconst_null
    //   420: astore_1
    //   421: aconst_null
    //   422: astore 5
    //   424: aload 7
    //   426: astore 6
    //   428: goto -123 -> 305
    //   431: astore 7
    //   433: aconst_null
    //   434: astore_1
    //   435: aconst_null
    //   436: astore 5
    //   438: aload_0
    //   439: astore 6
    //   441: aload 7
    //   443: astore_0
    //   444: goto -139 -> 305
    //   447: astore 7
    //   449: aconst_null
    //   450: astore_1
    //   451: aload_0
    //   452: astore 6
    //   454: aload 7
    //   456: astore_0
    //   457: goto -152 -> 305
    //   460: astore 7
    //   462: aload_0
    //   463: astore 6
    //   465: aload 7
    //   467: astore_0
    //   468: goto -163 -> 305
    //   471: astore 7
    //   473: aload_1
    //   474: astore 5
    //   476: aload_0
    //   477: astore_1
    //   478: aload 7
    //   480: astore_0
    //   481: goto -176 -> 305
    //   484: astore_0
    //   485: aconst_null
    //   486: astore_0
    //   487: aconst_null
    //   488: astore_1
    //   489: aconst_null
    //   490: astore 4
    //   492: aload 6
    //   494: astore 5
    //   496: goto -253 -> 243
    //   499: astore_0
    //   500: aconst_null
    //   501: astore_0
    //   502: aconst_null
    //   503: astore_1
    //   504: aload 6
    //   506: astore 5
    //   508: goto -265 -> 243
    //   511: astore_1
    //   512: aconst_null
    //   513: astore_1
    //   514: aload 6
    //   516: astore 5
    //   518: goto -275 -> 243
    //   521: astore_1
    //   522: aload 5
    //   524: astore_1
    //   525: aload 6
    //   527: astore 5
    //   529: goto -286 -> 243
    //   532: astore 6
    //   534: aload 5
    //   536: astore 6
    //   538: aload_1
    //   539: astore 5
    //   541: aload 6
    //   543: astore_1
    //   544: goto -301 -> 243
    //   547: astore 5
    //   549: aload_0
    //   550: astore 5
    //   552: aload 6
    //   554: astore_0
    //   555: goto -312 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	558	0	paramHttpURLConnection	HttpURLConnection
    //   0	558	1	paramFile	File
    //   166	15	2	i	int
    //   17	293	3	localFileOutputStream	java.io.FileOutputStream
    //   354	1	3	localIOException1	IOException
    //   370	1	3	localIOException2	IOException
    //   386	1	3	localIOException3	IOException
    //   390	1	3	localIOException4	IOException
    //   43	448	4	localBufferedInputStream	java.io.BufferedInputStream
    //   7	533	5	localObject1	Object
    //   547	1	5	localThrowable1	Throwable
    //   550	1	5	localHttpURLConnection	HttpURLConnection
    //   1	525	6	localObject2	Object
    //   532	1	6	localThrowable2	Throwable
    //   536	17	6	localObject3	Object
    //   4	421	7	localObject4	Object
    //   431	11	7	localObject5	Object
    //   447	8	7	localObject6	Object
    //   460	6	7	localObject7	Object
    //   471	8	7	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   9	18	229	java/lang/Throwable
    //   9	18	290	finally
    //   80	84	354	java/io/IOException
    //   88	92	358	java/io/IOException
    //   96	100	362	java/io/IOException
    //   100	105	366	java/io/IOException
    //   247	251	370	java/io/IOException
    //   255	259	374	java/io/IOException
    //   264	269	378	java/io/IOException
    //   274	279	382	java/io/IOException
    //   309	313	386	java/io/IOException
    //   318	323	390	java/io/IOException
    //   327	331	394	java/io/IOException
    //   336	341	398	java/io/IOException
    //   18	45	402	finally
    //   45	68	418	finally
    //   118	149	418	finally
    //   149	159	431	finally
    //   159	212	447	finally
    //   212	218	460	finally
    //   76	80	471	finally
    //   18	45	484	java/lang/Throwable
    //   45	68	499	java/lang/Throwable
    //   118	149	499	java/lang/Throwable
    //   149	159	511	java/lang/Throwable
    //   159	212	521	java/lang/Throwable
    //   212	218	532	java/lang/Throwable
    //   76	80	547	java/lang/Throwable
  }
  
  private static int b(int paramInt)
  {
    switch (paramInt)
    {
    case -1: 
    case 0: 
    default: 
      return -1;
    case 1: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 4;
    }
    return 8;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */