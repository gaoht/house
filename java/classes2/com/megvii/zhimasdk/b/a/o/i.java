package com.megvii.zhimasdk.b.a.o;

import java.util.Map;
import java.util.Map<**>;

public class i
{
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  
  protected i(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a.a(paramString1, "Package identifier");
    this.a = paramString1;
    if (paramString2 != null)
    {
      this.b = paramString2;
      if (paramString3 == null) {
        break label63;
      }
      label29:
      this.c = paramString3;
      if (paramString4 == null) {
        break label69;
      }
      label39:
      this.d = paramString4;
      if (paramString5 == null) {
        break label76;
      }
    }
    for (;;)
    {
      this.e = paramString5;
      return;
      paramString2 = "UNAVAILABLE";
      break;
      label63:
      paramString3 = "UNAVAILABLE";
      break label29;
      label69:
      paramString4 = "UNAVAILABLE";
      break label39;
      label76:
      paramString5 = "UNAVAILABLE";
    }
  }
  
  /* Error */
  public static i a(String paramString, ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ldc 17
    //   5: invokestatic 22	com/megvii/zhimasdk/b/a/o/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   8: pop
    //   9: aload_1
    //   10: ifnull +79 -> 89
    //   13: aload_1
    //   14: astore_2
    //   15: aload_2
    //   16: new 40	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   23: aload_0
    //   24: bipush 46
    //   26: bipush 47
    //   28: invokevirtual 47	java/lang/String:replace	(CC)Ljava/lang/String;
    //   31: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 53
    //   36: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc 55
    //   41: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokevirtual 65	java/lang/ClassLoader:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   50: astore 4
    //   52: aload 4
    //   54: ifnull +64 -> 118
    //   57: new 67	java/util/Properties
    //   60: dup
    //   61: invokespecial 68	java/util/Properties:<init>	()V
    //   64: astore_1
    //   65: aload_1
    //   66: aload 4
    //   68: invokevirtual 72	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   71: aload 4
    //   73: invokevirtual 77	java/io/InputStream:close	()V
    //   76: aload_1
    //   77: ifnull +10 -> 87
    //   80: aload_0
    //   81: aload_1
    //   82: aload_2
    //   83: invokestatic 80	com/megvii/zhimasdk/b/a/o/i:a	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/ClassLoader;)Lcom/megvii/zhimasdk/b/a/o/i;
    //   86: astore_3
    //   87: aload_3
    //   88: areturn
    //   89: invokestatic 86	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   92: invokevirtual 90	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   95: astore_2
    //   96: goto -81 -> 15
    //   99: astore_1
    //   100: aload 4
    //   102: invokevirtual 77	java/io/InputStream:close	()V
    //   105: aload_1
    //   106: athrow
    //   107: astore_1
    //   108: aconst_null
    //   109: astore_1
    //   110: goto -34 -> 76
    //   113: astore 4
    //   115: goto -39 -> 76
    //   118: aconst_null
    //   119: astore_1
    //   120: goto -44 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramString	String
    //   0	123	1	paramClassLoader	ClassLoader
    //   14	82	2	localClassLoader	ClassLoader
    //   1	87	3	locali	i
    //   50	51	4	localInputStream	java.io.InputStream
    //   113	1	4	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   57	71	99	finally
    //   15	52	107	java/io/IOException
    //   100	107	107	java/io/IOException
    //   71	76	113	java/io/IOException
  }
  
  protected static i a(String paramString, Map<?, ?> paramMap, ClassLoader paramClassLoader)
  {
    Object localObject4 = null;
    a.a(paramString, "Package identifier");
    Object localObject1;
    Object localObject2;
    label80:
    Object localObject3;
    if (paramMap != null)
    {
      localObject1 = (String)paramMap.get("info.module");
      if ((localObject1 != null) && (((String)localObject1).length() < 1))
      {
        localObject1 = null;
        localObject2 = (String)paramMap.get("info.release");
        if ((localObject2 != null) && ((((String)localObject2).length() < 1) || (((String)localObject2).equals("${pom.version}"))))
        {
          localObject2 = null;
          localObject3 = (String)paramMap.get("info.timestamp");
          if ((localObject3 != null) && ((((String)localObject3).length() < 1) || (((String)localObject3).equals("${mvn.timestamp}"))))
          {
            Object localObject5 = null;
            paramMap = (Map<?, ?>)localObject2;
            localObject3 = localObject1;
            localObject2 = localObject5;
            localObject1 = paramMap;
            paramMap = (Map<?, ?>)localObject3;
          }
        }
      }
    }
    for (;;)
    {
      localObject3 = localObject4;
      if (paramClassLoader != null) {
        localObject3 = paramClassLoader.toString();
      }
      return new i(paramString, paramMap, (String)localObject1, (String)localObject2, (String)localObject3);
      paramMap = (Map<?, ?>)localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      continue;
      break label80;
      break;
      localObject2 = null;
      localObject1 = null;
      paramMap = null;
    }
  }
  
  public final String a()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.a.length() + 20 + this.b.length() + this.c.length() + this.d.length() + this.e.length());
    localStringBuilder.append("VersionInfo(").append(this.a).append(':').append(this.b);
    if (!"UNAVAILABLE".equals(this.c)) {
      localStringBuilder.append(':').append(this.c);
    }
    if (!"UNAVAILABLE".equals(this.d)) {
      localStringBuilder.append(':').append(this.d);
    }
    localStringBuilder.append(')');
    if (!"UNAVAILABLE".equals(this.e)) {
      localStringBuilder.append('@').append(this.e);
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/o/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */