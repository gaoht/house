package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.network.Host;
import com.xiaomi.push.protobuf.a.a;
import com.xiaomi.stats.f;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class ae
{
  private static final Pattern a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
  private static long b = 0L;
  private static ThreadPoolExecutor c = new ThreadPoolExecutor(1, 1, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  
  public static void a()
  {
    long l = System.currentTimeMillis();
    if ((c.getActiveCount() > 0) && (l - b < 1800000L)) {}
    a.a locala;
    do
    {
      do
      {
        return;
      } while (!f.a().c());
      locala = at.a().d();
    } while ((locala == null) || (locala.m() <= 0));
    b = l;
    a(locala.l(), true);
  }
  
  public static void a(List<String> paramList, boolean paramBoolean)
  {
    c.execute(new af(paramList, paramBoolean));
  }
  
  public static void b()
  {
    String str = c("/proc/self/net/tcp");
    if (!TextUtils.isEmpty(str))
    {
      b.a("dump tcp for uid = " + Process.myUid());
      b.a(str);
    }
    str = c("/proc/self/net/tcp6");
    if (!TextUtils.isEmpty(str))
    {
      b.a("dump tcp6 for uid = " + Process.myUid());
      b.a(str);
    }
  }
  
  private static boolean b(String paramString)
  {
    long l1 = System.currentTimeMillis();
    try
    {
      b.a("ConnectivityTest: begin to connect to " + paramString);
      Socket localSocket = new Socket();
      localSocket.connect(Host.b(paramString, 5222), 5000);
      localSocket.setTcpNoDelay(true);
      long l2 = System.currentTimeMillis();
      b.a("ConnectivityTest: connect to " + paramString + " in " + (l2 - l1));
      localSocket.close();
      return true;
    }
    catch (Throwable localThrowable)
    {
      b.d("ConnectivityTest: could not connect to:" + paramString + " exception: " + localThrowable.getClass().getSimpleName() + " description: " + localThrowable.getMessage());
    }
    return false;
  }
  
  /* Error */
  private static String c(String paramString)
  {
    // Byte code:
    //   0: new 194	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 198	java/io/BufferedReader
    //   12: dup
    //   13: new 200	java/io/FileReader
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 203	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   21: invokespecial 206	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_0
    //   25: new 112	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   32: astore_1
    //   33: aload_0
    //   34: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   37: astore_2
    //   38: aload_2
    //   39: ifnull +26 -> 65
    //   42: aload_1
    //   43: ldc -45
    //   45: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_1
    //   50: aload_2
    //   51: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: goto -22 -> 33
    //   58: astore_1
    //   59: aload_0
    //   60: invokestatic 215	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/Reader;)V
    //   63: aconst_null
    //   64: areturn
    //   65: aload_1
    //   66: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: astore_1
    //   70: aload_0
    //   71: invokestatic 215	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/Reader;)V
    //   74: aload_1
    //   75: areturn
    //   76: astore_0
    //   77: aconst_null
    //   78: astore_2
    //   79: aload_0
    //   80: astore_1
    //   81: aload_2
    //   82: invokestatic 215	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/Reader;)V
    //   85: aload_1
    //   86: athrow
    //   87: astore_1
    //   88: aload_0
    //   89: astore_2
    //   90: goto -9 -> 81
    //   93: astore_0
    //   94: aconst_null
    //   95: astore_0
    //   96: goto -37 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramString	String
    //   32	18	1	localStringBuilder	StringBuilder
    //   58	8	1	localException	Exception
    //   69	17	1	str1	String
    //   87	1	1	localObject	Object
    //   37	53	2	str2	String
    // Exception table:
    //   from	to	target	type
    //   25	33	58	java/lang/Exception
    //   33	38	58	java/lang/Exception
    //   42	55	58	java/lang/Exception
    //   65	70	58	java/lang/Exception
    //   9	25	76	finally
    //   25	33	87	finally
    //   33	38	87	finally
    //   42	55	87	finally
    //   65	70	87	finally
    //   9	25	93	java/lang/Exception
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */