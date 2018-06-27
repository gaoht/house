package com.xiaomi.push.log;

import android.annotation.SuppressLint;
import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class a
{
  private static String b = "/MiPushLog";
  @SuppressLint({"SimpleDateFormat"})
  private final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private String c;
  private String d;
  private boolean e;
  private int f;
  private int g = 2097152;
  private ArrayList<File> h = new ArrayList();
  
  private void a(BufferedReader paramBufferedReader, BufferedWriter paramBufferedWriter, Pattern paramPattern)
  {
    char[] arrayOfChar = new char['က'];
    int j = paramBufferedReader.read(arrayOfChar);
    int i = 0;
    int k;
    int m;
    int n;
    if ((j != -1) && (i != 1))
    {
      String str1 = new String(arrayOfChar, 0, j);
      Matcher localMatcher = paramPattern.matcher(str1);
      k = 0;
      m = 0;
      if ((k >= j) || (!localMatcher.find(k))) {
        break label275;
      }
      k = localMatcher.start();
      String str2 = str1.substring(k, this.c.length() + k);
      if (!this.e)
      {
        n = m;
        if (str2.compareTo(this.c) >= 0)
        {
          this.e = true;
          n = k;
        }
      }
      do
      {
        m = str1.indexOf('\n', k);
        if (m == -1) {
          break label224;
        }
        k += m;
        m = n;
        break;
        n = m;
      } while (str2.compareTo(this.d) <= 0);
      i = 1;
    }
    for (;;)
    {
      if (this.e)
      {
        j = k - m;
        this.f += j;
        if (i != 0) {
          paramBufferedWriter.write(arrayOfChar, m, j);
        }
        label224:
        do
        {
          return;
          k += this.c.length();
          m = n;
          break;
          paramBufferedWriter.write(arrayOfChar, m, j);
        } while (this.f > this.g);
      }
      j = paramBufferedReader.read(arrayOfChar);
      break;
      label275:
      k = j;
    }
  }
  
  /* Error */
  private void b(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 7
    //   12: aconst_null
    //   13: astore 8
    //   15: aconst_null
    //   16: astore_3
    //   17: ldc 111
    //   19: invokestatic 115	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   22: astore 9
    //   24: new 101	java/io/BufferedWriter
    //   27: dup
    //   28: new 117	java/io/OutputStreamWriter
    //   31: dup
    //   32: new 119	java/io/FileOutputStream
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 121	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   40: invokespecial 124	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   43: invokespecial 127	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   46: astore_2
    //   47: aload_2
    //   48: astore_3
    //   49: aload 4
    //   51: astore_1
    //   52: aload 7
    //   54: astore 5
    //   56: aload 8
    //   58: astore 6
    //   60: new 129	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   67: astore 10
    //   69: aload_2
    //   70: astore_3
    //   71: aload 4
    //   73: astore_1
    //   74: aload 7
    //   76: astore 5
    //   78: aload 8
    //   80: astore 6
    //   82: aload 10
    //   84: ldc -124
    //   86: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: getstatic 141	android/os/Build:MODEL	Ljava/lang/String;
    //   92: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_2
    //   97: astore_3
    //   98: aload 4
    //   100: astore_1
    //   101: aload 7
    //   103: astore 5
    //   105: aload 8
    //   107: astore 6
    //   109: aload 10
    //   111: ldc -113
    //   113: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: getstatic 148	android/os/Build$VERSION:INCREMENTAL	Ljava/lang/String;
    //   119: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_2
    //   124: astore_3
    //   125: aload 4
    //   127: astore_1
    //   128: aload 7
    //   130: astore 5
    //   132: aload 8
    //   134: astore 6
    //   136: aload 10
    //   138: ldc -106
    //   140: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokestatic 155	com/xiaomi/push/service/at:e	()Ljava/lang/String;
    //   146: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_2
    //   151: astore_3
    //   152: aload 4
    //   154: astore_1
    //   155: aload 7
    //   157: astore 5
    //   159: aload 8
    //   161: astore 6
    //   163: aload 10
    //   165: ldc -99
    //   167: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokestatic 163	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   173: invokevirtual 166	java/util/Locale:toString	()Ljava/lang/String;
    //   176: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_2
    //   181: astore_3
    //   182: aload 4
    //   184: astore_1
    //   185: aload 7
    //   187: astore 5
    //   189: aload 8
    //   191: astore 6
    //   193: aload 10
    //   195: ldc -88
    //   197: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: bipush 26
    //   202: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_2
    //   207: astore_3
    //   208: aload 4
    //   210: astore_1
    //   211: aload 7
    //   213: astore 5
    //   215: aload 8
    //   217: astore 6
    //   219: aload 10
    //   221: ldc -83
    //   223: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: getstatic 176	android/os/Build$VERSION:SDK_INT	I
    //   229: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_2
    //   234: astore_3
    //   235: aload 4
    //   237: astore_1
    //   238: aload 7
    //   240: astore 5
    //   242: aload 8
    //   244: astore 6
    //   246: aload 10
    //   248: ldc -78
    //   250: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_2
    //   255: astore_3
    //   256: aload 4
    //   258: astore_1
    //   259: aload 7
    //   261: astore 5
    //   263: aload 8
    //   265: astore 6
    //   267: aload_2
    //   268: aload 10
    //   270: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokevirtual 181	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   276: aload_2
    //   277: astore_3
    //   278: aload 4
    //   280: astore_1
    //   281: aload 7
    //   283: astore 5
    //   285: aload 8
    //   287: astore 6
    //   289: aload_0
    //   290: iconst_0
    //   291: putfield 99	com/xiaomi/push/log/a:f	I
    //   294: aload_2
    //   295: astore_3
    //   296: aload 4
    //   298: astore_1
    //   299: aload 7
    //   301: astore 5
    //   303: aload 8
    //   305: astore 6
    //   307: aload_0
    //   308: getfield 48	com/xiaomi/push/log/a:h	Ljava/util/ArrayList;
    //   311: invokevirtual 185	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   314: astore 7
    //   316: aconst_null
    //   317: astore_1
    //   318: aload 7
    //   320: invokeinterface 191 1 0
    //   325: ifeq +82 -> 407
    //   328: new 51	java/io/BufferedReader
    //   331: dup
    //   332: new 193	java/io/InputStreamReader
    //   335: dup
    //   336: new 195	java/io/FileInputStream
    //   339: dup
    //   340: aload 7
    //   342: invokeinterface 199 1 0
    //   347: checkcast 201	java/io/File
    //   350: invokespecial 202	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   353: invokespecial 205	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   356: invokespecial 208	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   359: astore 4
    //   361: aload_2
    //   362: astore_3
    //   363: aload 4
    //   365: astore_1
    //   366: aload 4
    //   368: astore 5
    //   370: aload 4
    //   372: astore 6
    //   374: aload_0
    //   375: aload 4
    //   377: aload_2
    //   378: aload 9
    //   380: invokespecial 210	com/xiaomi/push/log/a:a	(Ljava/io/BufferedReader;Ljava/io/BufferedWriter;Ljava/util/regex/Pattern;)V
    //   383: aload_2
    //   384: astore_3
    //   385: aload 4
    //   387: astore_1
    //   388: aload 4
    //   390: astore 5
    //   392: aload 4
    //   394: astore 6
    //   396: aload 4
    //   398: invokevirtual 213	java/io/BufferedReader:close	()V
    //   401: aload 4
    //   403: astore_1
    //   404: goto -86 -> 318
    //   407: aload_2
    //   408: invokestatic 217	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/Writer;)V
    //   411: aload_1
    //   412: invokestatic 219	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/Reader;)V
    //   415: return
    //   416: astore 4
    //   418: aconst_null
    //   419: astore 5
    //   421: aload_3
    //   422: astore_2
    //   423: aload 5
    //   425: astore_3
    //   426: aload_2
    //   427: astore_1
    //   428: new 129	java/lang/StringBuilder
    //   431: dup
    //   432: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   435: ldc -35
    //   437: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload 4
    //   442: invokevirtual 224	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   445: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 228	com/xiaomi/channel/commonutils/logger/b:c	(Ljava/lang/String;)V
    //   454: aload 5
    //   456: invokestatic 217	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/Writer;)V
    //   459: aload_2
    //   460: invokestatic 219	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/Reader;)V
    //   463: return
    //   464: astore 4
    //   466: aconst_null
    //   467: astore 6
    //   469: aload 5
    //   471: astore_2
    //   472: aload 6
    //   474: astore_3
    //   475: aload_2
    //   476: astore_1
    //   477: new 129	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   484: ldc -35
    //   486: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload 4
    //   491: invokevirtual 229	java/io/IOException:getMessage	()Ljava/lang/String;
    //   494: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokestatic 228	com/xiaomi/channel/commonutils/logger/b:c	(Ljava/lang/String;)V
    //   503: aload 6
    //   505: invokestatic 217	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/Writer;)V
    //   508: aload_2
    //   509: invokestatic 219	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/Reader;)V
    //   512: return
    //   513: astore 4
    //   515: aconst_null
    //   516: astore_2
    //   517: aload 6
    //   519: astore_1
    //   520: aload_2
    //   521: invokestatic 217	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/Writer;)V
    //   524: aload_1
    //   525: invokestatic 219	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/Reader;)V
    //   528: aload 4
    //   530: athrow
    //   531: astore 4
    //   533: aload_3
    //   534: astore_2
    //   535: goto -15 -> 520
    //   538: astore 4
    //   540: goto -20 -> 520
    //   543: astore 4
    //   545: aload_2
    //   546: astore 6
    //   548: aload 5
    //   550: astore_2
    //   551: goto -79 -> 472
    //   554: astore 4
    //   556: aload_2
    //   557: astore 6
    //   559: aload_1
    //   560: astore_2
    //   561: goto -89 -> 472
    //   564: astore 4
    //   566: aload_2
    //   567: astore 5
    //   569: aload 6
    //   571: astore_2
    //   572: goto -149 -> 423
    //   575: astore 4
    //   577: aload_2
    //   578: astore 5
    //   580: aload_1
    //   581: astore_2
    //   582: goto -159 -> 423
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	585	0	this	a
    //   0	585	1	paramFile	File
    //   46	536	2	localObject1	Object
    //   16	518	3	localObject2	Object
    //   7	395	4	localBufferedReader	BufferedReader
    //   416	25	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   464	26	4	localIOException1	java.io.IOException
    //   513	16	4	localObject3	Object
    //   531	1	4	localObject4	Object
    //   538	1	4	localObject5	Object
    //   543	1	4	localIOException2	java.io.IOException
    //   554	1	4	localIOException3	java.io.IOException
    //   564	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   575	1	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   1	578	5	localObject6	Object
    //   4	566	6	localObject7	Object
    //   10	331	7	localIterator	java.util.Iterator
    //   13	291	8	localObject8	Object
    //   22	357	9	localPattern	Pattern
    //   67	202	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   24	47	416	java/io/FileNotFoundException
    //   24	47	464	java/io/IOException
    //   24	47	513	finally
    //   60	69	531	finally
    //   82	96	531	finally
    //   109	123	531	finally
    //   136	150	531	finally
    //   163	180	531	finally
    //   193	206	531	finally
    //   219	233	531	finally
    //   246	254	531	finally
    //   267	276	531	finally
    //   289	294	531	finally
    //   307	316	531	finally
    //   374	383	531	finally
    //   396	401	531	finally
    //   428	454	531	finally
    //   477	503	531	finally
    //   318	361	538	finally
    //   60	69	543	java/io/IOException
    //   82	96	543	java/io/IOException
    //   109	123	543	java/io/IOException
    //   136	150	543	java/io/IOException
    //   163	180	543	java/io/IOException
    //   193	206	543	java/io/IOException
    //   219	233	543	java/io/IOException
    //   246	254	543	java/io/IOException
    //   267	276	543	java/io/IOException
    //   289	294	543	java/io/IOException
    //   307	316	543	java/io/IOException
    //   374	383	543	java/io/IOException
    //   396	401	543	java/io/IOException
    //   318	361	554	java/io/IOException
    //   60	69	564	java/io/FileNotFoundException
    //   82	96	564	java/io/FileNotFoundException
    //   109	123	564	java/io/FileNotFoundException
    //   136	150	564	java/io/FileNotFoundException
    //   163	180	564	java/io/FileNotFoundException
    //   193	206	564	java/io/FileNotFoundException
    //   219	233	564	java/io/FileNotFoundException
    //   246	254	564	java/io/FileNotFoundException
    //   267	276	564	java/io/FileNotFoundException
    //   289	294	564	java/io/FileNotFoundException
    //   307	316	564	java/io/FileNotFoundException
    //   374	383	564	java/io/FileNotFoundException
    //   396	401	564	java/io/FileNotFoundException
    //   318	361	575	java/io/FileNotFoundException
  }
  
  a a(File paramFile)
  {
    if (paramFile.exists()) {
      this.h.add(paramFile);
    }
    return this;
  }
  
  a a(Date paramDate1, Date paramDate2)
  {
    if (paramDate1.after(paramDate2))
    {
      this.c = this.a.format(paramDate2);
      this.d = this.a.format(paramDate1);
      return this;
    }
    this.c = this.a.format(paramDate1);
    this.d = this.a.format(paramDate2);
    return this;
  }
  
  File a(Context paramContext, Date paramDate1, Date paramDate2, File paramFile)
  {
    if ("com.xiaomi.xmsf".equalsIgnoreCase(paramContext.getPackageName()))
    {
      paramContext = paramContext.getFilesDir();
      a(new File(paramContext, "xmsf.log.1"));
      a(new File(paramContext, "xmsf.log"));
      if (paramContext.isDirectory()) {
        break label127;
      }
      paramContext = null;
    }
    label127:
    File localFile;
    do
    {
      return paramContext;
      paramContext = new File(paramContext.getExternalFilesDir(null) + b);
      a(new File(paramContext, "log0.txt"));
      a(new File(paramContext, "log1.txt"));
      break;
      localFile = new File(paramFile, paramDate1.getTime() + "-" + paramDate2.getTime() + ".zip");
      if (localFile.exists()) {
        return null;
      }
      a(paramDate1, paramDate2);
      long l = System.currentTimeMillis();
      paramContext = new File(paramFile, "log.txt");
      b(paramContext);
      b.c("LOG: filter cost = " + (System.currentTimeMillis() - l));
      if (!paramContext.exists()) {
        break label304;
      }
      l = System.currentTimeMillis();
      com.xiaomi.channel.commonutils.file.a.a(localFile, paramContext);
      b.c("LOG: zip cost = " + (System.currentTimeMillis() - l));
      paramContext.delete();
      paramContext = localFile;
    } while (localFile.exists());
    label304:
    return null;
  }
  
  void a(int paramInt)
  {
    if (paramInt != 0) {
      this.g = paramInt;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/log/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */