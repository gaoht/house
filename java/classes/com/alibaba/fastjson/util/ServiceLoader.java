package com.alibaba.fastjson.util;

import com.maa.android.agent.instrumentation.Instrumented;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Instrumented
public class ServiceLoader
{
  private static final String PREFIX = "META-INF/services/";
  private static final Set<String> loadedUrls = new HashSet();
  
  public static <T> Set<T> load(Class<T> paramClass, ClassLoader paramClassLoader)
  {
    if (paramClassLoader == null) {
      return Collections.emptySet();
    }
    localHashSet = new HashSet();
    paramClass = paramClass.getName();
    Object localObject = "META-INF/services/" + paramClass;
    paramClass = new HashSet();
    try
    {
      localObject = paramClassLoader.getResources((String)localObject);
      while (((Enumeration)localObject).hasMoreElements())
      {
        URL localURL = (URL)((Enumeration)localObject).nextElement();
        if (!loadedUrls.contains(localURL.toString()))
        {
          load(localURL, paramClass);
          loadedUrls.add(localURL.toString());
        }
      }
      String str;
      return localHashSet;
    }
    catch (IOException localIOException)
    {
      paramClass = paramClass.iterator();
      while (paramClass.hasNext())
      {
        str = (String)paramClass.next();
        try
        {
          localHashSet.add(paramClassLoader.loadClass(str).newInstance());
        }
        catch (Exception localException) {}
      }
    }
  }
  
  /* Error */
  public static void load(URL paramURL, Set<String> paramSet)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: instanceof 69
    //   6: ifne +47 -> 53
    //   9: aload_0
    //   10: invokevirtual 109	java/net/URL:openStream	()Ljava/io/InputStream;
    //   13: astore_0
    //   14: new 111	java/io/BufferedReader
    //   17: dup
    //   18: new 113	java/io/InputStreamReader
    //   21: dup
    //   22: aload_0
    //   23: ldc 115
    //   25: invokespecial 118	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   28: invokespecial 121	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore 5
    //   33: aload 5
    //   35: invokevirtual 124	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_3
    //   39: aload_3
    //   40: ifnonnull +24 -> 64
    //   43: aload 5
    //   45: invokestatic 130	com/alibaba/fastjson/util/IOUtils:close	(Ljava/io/Closeable;)V
    //   48: aload_0
    //   49: invokestatic 130	com/alibaba/fastjson/util/IOUtils:close	(Ljava/io/Closeable;)V
    //   52: return
    //   53: aload_0
    //   54: checkcast 69	java/net/URL
    //   57: invokestatic 135	com/mato/sdk/instrumentation/HttpInstrumentation:openStream	(Ljava/net/URL;)Ljava/io/InputStream;
    //   60: astore_0
    //   61: goto -47 -> 14
    //   64: aload_3
    //   65: bipush 35
    //   67: invokevirtual 139	java/lang/String:indexOf	(I)I
    //   70: istore_2
    //   71: aload_3
    //   72: astore 4
    //   74: iload_2
    //   75: iflt +11 -> 86
    //   78: aload_3
    //   79: iconst_0
    //   80: iload_2
    //   81: invokevirtual 143	java/lang/String:substring	(II)Ljava/lang/String;
    //   84: astore 4
    //   86: aload 4
    //   88: invokevirtual 146	java/lang/String:trim	()Ljava/lang/String;
    //   91: astore_3
    //   92: aload_3
    //   93: invokevirtual 150	java/lang/String:length	()I
    //   96: ifeq -63 -> 33
    //   99: aload_1
    //   100: aload_3
    //   101: invokeinterface 82 2 0
    //   106: pop
    //   107: goto -74 -> 33
    //   110: astore 4
    //   112: aload 5
    //   114: astore_3
    //   115: aload_0
    //   116: astore_1
    //   117: aload 4
    //   119: astore_0
    //   120: aload_3
    //   121: invokestatic 130	com/alibaba/fastjson/util/IOUtils:close	(Ljava/io/Closeable;)V
    //   124: aload_1
    //   125: invokestatic 130	com/alibaba/fastjson/util/IOUtils:close	(Ljava/io/Closeable;)V
    //   128: aload_0
    //   129: athrow
    //   130: astore_0
    //   131: aconst_null
    //   132: astore_1
    //   133: goto -13 -> 120
    //   136: astore 4
    //   138: aload_0
    //   139: astore_1
    //   140: aload 4
    //   142: astore_0
    //   143: goto -23 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramURL	URL
    //   0	146	1	paramSet	Set<String>
    //   70	11	2	i	int
    //   1	120	3	localObject1	Object
    //   72	15	4	localObject2	Object
    //   110	8	4	localObject3	Object
    //   136	5	4	localObject4	Object
    //   31	82	5	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   33	39	110	finally
    //   64	71	110	finally
    //   78	86	110	finally
    //   86	107	110	finally
    //   2	14	130	finally
    //   53	61	130	finally
    //   14	33	136	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/util/ServiceLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */