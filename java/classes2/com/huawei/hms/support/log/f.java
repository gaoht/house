package com.huawei.hms.support.log;

import android.util.Log;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class f
{
  private static String c = System.getProperty("line.separator");
  protected LogLevel a = LogLevel.INFO;
  protected LogLevel b = LogLevel.ERROR;
  private int d = 0;
  private String e;
  private long f;
  private final Map<String, LogLevel> g = new HashMap();
  
  public f(String paramString, long paramLong)
  {
    this.e = paramString;
    this.f = paramLong;
  }
  
  /* Error */
  private void a(File paramFile, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 64	java/io/OutputStreamWriter
    //   6: dup
    //   7: new 66	java/io/FileOutputStream
    //   10: dup
    //   11: aload_1
    //   12: iconst_1
    //   13: invokespecial 69	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   16: ldc 71
    //   18: invokespecial 74	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   21: astore 7
    //   23: iload_3
    //   24: ifeq +118 -> 142
    //   27: iload 4
    //   29: ifeq +155 -> 184
    //   32: ldc 76
    //   34: astore 8
    //   36: aload 7
    //   38: astore 6
    //   40: invokestatic 81	com/huawei/hms/support/log/a/a:a	()Lcom/huawei/hms/support/log/a/a;
    //   43: astore 9
    //   45: aload 7
    //   47: astore 6
    //   49: aload 9
    //   51: ldc 83
    //   53: invokevirtual 86	com/huawei/hms/support/log/a/a:a	(Ljava/lang/Object;)Lcom/huawei/hms/support/log/a/a;
    //   56: aload 5
    //   58: invokevirtual 86	com/huawei/hms/support/log/a/a:a	(Ljava/lang/Object;)Lcom/huawei/hms/support/log/a/a;
    //   61: ldc 88
    //   63: invokevirtual 86	com/huawei/hms/support/log/a/a:a	(Ljava/lang/Object;)Lcom/huawei/hms/support/log/a/a;
    //   66: aload 8
    //   68: invokevirtual 86	com/huawei/hms/support/log/a/a:a	(Ljava/lang/Object;)Lcom/huawei/hms/support/log/a/a;
    //   71: pop
    //   72: aload 7
    //   74: astore 6
    //   76: aload_0
    //   77: getfield 36	com/huawei/hms/support/log/f:d	I
    //   80: ifle +19 -> 99
    //   83: aload 7
    //   85: astore 6
    //   87: aload 9
    //   89: invokevirtual 90	com/huawei/hms/support/log/a/a:b	()Lcom/huawei/hms/support/log/a/a;
    //   92: invokestatic 95	com/huawei/hms/support/log/b:a	()Ljava/lang/String;
    //   95: invokevirtual 86	com/huawei/hms/support/log/a/a:a	(Ljava/lang/Object;)Lcom/huawei/hms/support/log/a/a;
    //   98: pop
    //   99: aload 7
    //   101: astore 6
    //   103: aload 7
    //   105: new 97	com/huawei/hms/support/log/e$a
    //   108: dup
    //   109: aconst_null
    //   110: getstatic 100	com/huawei/hms/support/log/LogLevel:OUT	Lcom/huawei/hms/support/log/LogLevel;
    //   113: invokespecial 103	com/huawei/hms/support/log/e$a:<init>	(Ljava/lang/String;Lcom/huawei/hms/support/log/LogLevel;)V
    //   116: invokevirtual 106	com/huawei/hms/support/log/e$a:a	()Lcom/huawei/hms/support/log/e;
    //   119: aload 9
    //   121: invokevirtual 111	com/huawei/hms/support/log/e:a	(Ljava/lang/Object;)Lcom/huawei/hms/support/log/e;
    //   124: invokevirtual 114	com/huawei/hms/support/log/e:toString	()Ljava/lang/String;
    //   127: invokevirtual 118	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   130: aload 7
    //   132: astore 6
    //   134: aload 7
    //   136: getstatic 29	com/huawei/hms/support/log/f:c	Ljava/lang/String;
    //   139: invokevirtual 118	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   142: aload 7
    //   144: astore 6
    //   146: aload 7
    //   148: aload_2
    //   149: invokevirtual 118	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   152: aload 7
    //   154: astore 6
    //   156: aload 7
    //   158: getstatic 29	com/huawei/hms/support/log/f:c	Ljava/lang/String;
    //   161: invokevirtual 118	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   164: aload 7
    //   166: astore 6
    //   168: aload 7
    //   170: invokevirtual 121	java/io/OutputStreamWriter:flush	()V
    //   173: aload 7
    //   175: ifnull +8 -> 183
    //   178: aload 7
    //   180: invokevirtual 124	java/io/OutputStreamWriter:close	()V
    //   183: return
    //   184: ldc 126
    //   186: astore 8
    //   188: goto -152 -> 36
    //   191: astore_1
    //   192: ldc -128
    //   194: ldc -126
    //   196: invokestatic 135	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   199: pop
    //   200: return
    //   201: astore_2
    //   202: aconst_null
    //   203: astore 7
    //   205: aload 7
    //   207: astore 6
    //   209: ldc -128
    //   211: new 137	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   218: ldc -116
    //   220: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_1
    //   224: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 135	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   233: pop
    //   234: aload 7
    //   236: ifnull -53 -> 183
    //   239: aload 7
    //   241: invokevirtual 124	java/io/OutputStreamWriter:close	()V
    //   244: return
    //   245: astore_1
    //   246: ldc -128
    //   248: ldc -126
    //   250: invokestatic 135	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   253: pop
    //   254: return
    //   255: astore_2
    //   256: aconst_null
    //   257: astore 7
    //   259: aload 7
    //   261: astore 6
    //   263: ldc -128
    //   265: new 137	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   272: ldc -106
    //   274: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_1
    //   278: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 135	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   287: pop
    //   288: aload 7
    //   290: ifnull -107 -> 183
    //   293: aload 7
    //   295: invokevirtual 124	java/io/OutputStreamWriter:close	()V
    //   298: return
    //   299: astore_1
    //   300: ldc -128
    //   302: ldc -126
    //   304: invokestatic 135	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   307: pop
    //   308: return
    //   309: astore_1
    //   310: aload 6
    //   312: ifnull +8 -> 320
    //   315: aload 6
    //   317: invokevirtual 124	java/io/OutputStreamWriter:close	()V
    //   320: aload_1
    //   321: athrow
    //   322: astore_2
    //   323: ldc -128
    //   325: ldc -126
    //   327: invokestatic 135	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   330: pop
    //   331: goto -11 -> 320
    //   334: astore_1
    //   335: goto -25 -> 310
    //   338: astore_2
    //   339: goto -80 -> 259
    //   342: astore_2
    //   343: goto -138 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	this	f
    //   0	346	1	paramFile	File
    //   0	346	2	paramString1	String
    //   0	346	3	paramBoolean1	boolean
    //   0	346	4	paramBoolean2	boolean
    //   0	346	5	paramString2	String
    //   1	315	6	localObject	Object
    //   21	273	7	localOutputStreamWriter	java.io.OutputStreamWriter
    //   34	153	8	str	String
    //   43	77	9	locala	com.huawei.hms.support.log.a.a
    // Exception table:
    //   from	to	target	type
    //   178	183	191	java/io/IOException
    //   3	23	201	java/io/FileNotFoundException
    //   239	244	245	java/io/IOException
    //   3	23	255	java/io/IOException
    //   293	298	299	java/io/IOException
    //   3	23	309	finally
    //   315	320	322	java/io/IOException
    //   40	45	334	finally
    //   49	72	334	finally
    //   76	83	334	finally
    //   87	99	334	finally
    //   103	130	334	finally
    //   134	142	334	finally
    //   146	152	334	finally
    //   156	164	334	finally
    //   168	173	334	finally
    //   209	234	334	finally
    //   263	288	334	finally
    //   40	45	338	java/io/IOException
    //   49	72	338	java/io/IOException
    //   76	83	338	java/io/IOException
    //   87	99	338	java/io/IOException
    //   103	130	338	java/io/IOException
    //   134	142	338	java/io/IOException
    //   146	152	338	java/io/IOException
    //   156	164	338	java/io/IOException
    //   168	173	338	java/io/IOException
    //   40	45	342	java/io/FileNotFoundException
    //   49	72	342	java/io/FileNotFoundException
    //   76	83	342	java/io/FileNotFoundException
    //   87	99	342	java/io/FileNotFoundException
    //   103	130	342	java/io/FileNotFoundException
    //   134	142	342	java/io/FileNotFoundException
    //   146	152	342	java/io/FileNotFoundException
    //   156	164	342	java/io/FileNotFoundException
    //   168	173	342	java/io/FileNotFoundException
  }
  
  private boolean a(File paramFile1, File paramFile2)
  {
    if ((paramFile2.exists()) && (!paramFile2.delete()) && (Log.isLoggable("LoggerBase", 6))) {
      Log.e("LoggerBase", "delete file failed:" + paramFile2);
    }
    return paramFile1.renameTo(paramFile2);
  }
  
  public LogLevel a(String paramString)
  {
    try
    {
      LogLevel localLogLevel = (LogLevel)this.g.get(paramString);
      paramString = localLogLevel;
      if (localLogLevel == null) {
        paramString = this.a;
      }
      return paramString;
    }
    finally {}
  }
  
  public abstract void a(e parame);
  
  protected void a(String paramString1, LogLevel paramLogLevel, String paramString2)
  {
    if (a(paramString1, paramLogLevel)) {
      b(paramString2);
    }
  }
  
  public boolean a(String paramString, LogLevel paramLogLevel)
  {
    return paramLogLevel.value() >= a(paramString).value();
  }
  
  public long b()
  {
    return this.f;
  }
  
  public void b(LogLevel paramLogLevel)
  {
    this.a = paramLogLevel;
    try
    {
      Iterator localIterator = this.g.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((Map.Entry)localIterator.next()).setValue(paramLogLevel);
      }
    }
    finally {}
  }
  
  public abstract void b(e parame);
  
  protected void b(String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    label193:
    for (;;)
    {
      try
      {
        String str;
        long l;
        File localFile1;
        if (this.e != null)
        {
          str = null;
          l = b();
          localFile1 = new File(this.e);
          if (!localFile1.exists())
          {
            localFile1.setReadable(true);
            localFile1.setWritable(true);
            localFile1.setExecutable(false, false);
          }
          if (l <= 0L) {
            break label193;
          }
          File localFile2 = localFile1.getParentFile();
          if ((localFile2 != null) && (!localFile2.exists()))
          {
            boolean bool3 = localFile2.mkdirs();
            if (bool3) {}
          }
        }
        else
        {
          return;
        }
        if (localFile1.length() + paramString.length() > l)
        {
          str = this.e + ".bak";
          bool2 = a(localFile1, new File(str));
          a(localFile1, paramString, bool1, bool2, str);
          this.d += 1;
        }
        else
        {
          bool1 = false;
        }
      }
      finally {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/huawei/hms/support/log/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */