package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import java.io.Closeable;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Instrumented
public class m
{
  public static String a(String paramString, Map<String, String> paramMap, byte[] paramArrayOfByte, a parama, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      paramString = a(paramString, paramMap);
    } while (paramString == null);
    if (paramBoolean) {
      a(paramString, paramArrayOfByte);
    }
    for (;;)
    {
      return a(paramString, parama, false);
      b(paramString, paramArrayOfByte);
    }
  }
  
  /* Error */
  public static String a(String paramString, byte[] paramArrayOfByte, a parama, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_3
    //   1: ifeq +50 -> 51
    //   4: invokestatic 32	com/tencent/smtt/utils/p:a	()Lcom/tencent/smtt/utils/p;
    //   7: invokevirtual 36	com/tencent/smtt/utils/p:c	()Ljava/lang/String;
    //   10: astore 4
    //   12: new 38	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   19: aload_0
    //   20: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload 4
    //   25: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: astore 4
    //   33: iload_3
    //   34: ifeq +35 -> 69
    //   37: invokestatic 32	com/tencent/smtt/utils/p:a	()Lcom/tencent/smtt/utils/p;
    //   40: aload_1
    //   41: invokevirtual 52	com/tencent/smtt/utils/p:a	([B)[B
    //   44: astore_0
    //   45: aload_0
    //   46: ifnonnull +44 -> 90
    //   49: aconst_null
    //   50: areturn
    //   51: invokestatic 57	com/tencent/smtt/utils/o:a	()Lcom/tencent/smtt/utils/o;
    //   54: invokevirtual 59	com/tencent/smtt/utils/o:b	()Ljava/lang/String;
    //   57: astore 4
    //   59: goto -47 -> 12
    //   62: astore_0
    //   63: aload_0
    //   64: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   67: aconst_null
    //   68: areturn
    //   69: invokestatic 57	com/tencent/smtt/utils/o:a	()Lcom/tencent/smtt/utils/o;
    //   72: aload_1
    //   73: invokevirtual 63	com/tencent/smtt/utils/o:a	([B)[B
    //   76: astore_0
    //   77: goto -32 -> 45
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   85: aload_1
    //   86: astore_0
    //   87: goto -42 -> 45
    //   90: new 65	java/util/HashMap
    //   93: dup
    //   94: invokespecial 66	java/util/HashMap:<init>	()V
    //   97: astore_1
    //   98: aload_1
    //   99: ldc 68
    //   101: ldc 70
    //   103: invokeinterface 76 3 0
    //   108: pop
    //   109: aload_1
    //   110: ldc 78
    //   112: aload_0
    //   113: arraylength
    //   114: invokestatic 84	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   117: invokeinterface 76 3 0
    //   122: pop
    //   123: aload 4
    //   125: aload_1
    //   126: invokestatic 12	com/tencent/smtt/utils/m:a	(Ljava/lang/String;Ljava/util/Map;)Ljava/net/HttpURLConnection;
    //   129: astore_1
    //   130: aload_1
    //   131: ifnull +17 -> 148
    //   134: aload_1
    //   135: aload_0
    //   136: invokestatic 21	com/tencent/smtt/utils/m:b	(Ljava/net/HttpURLConnection;[B)V
    //   139: aload_1
    //   140: aload_2
    //   141: iload_3
    //   142: invokestatic 18	com/tencent/smtt/utils/m:a	(Ljava/net/HttpURLConnection;Lcom/tencent/smtt/utils/m$a;Z)Ljava/lang/String;
    //   145: astore_0
    //   146: aload_0
    //   147: areturn
    //   148: aconst_null
    //   149: astore_0
    //   150: goto -4 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramString	String
    //   0	153	1	paramArrayOfByte	byte[]
    //   0	153	2	parama	a
    //   0	153	3	paramBoolean	boolean
    //   10	114	4	str	String
    // Exception table:
    //   from	to	target	type
    //   4	12	62	java/lang/Exception
    //   12	33	62	java/lang/Exception
    //   51	59	62	java/lang/Exception
    //   37	45	80	java/lang/Exception
    //   69	77	80	java/lang/Exception
  }
  
  /* Error */
  private static String a(HttpURLConnection paramHttpURLConnection, a parama, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: invokevirtual 92	java/net/HttpURLConnection:getResponseCode	()I
    //   10: istore_3
    //   11: aload_1
    //   12: ifnull +10 -> 22
    //   15: aload_1
    //   16: iload_3
    //   17: invokeinterface 95 2 0
    //   22: iload_3
    //   23: sipush 200
    //   26: if_icmpne +256 -> 282
    //   29: aload_0
    //   30: invokevirtual 99	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   33: astore_1
    //   34: aload_0
    //   35: invokevirtual 102	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   38: astore_0
    //   39: aload_0
    //   40: ifnull +88 -> 128
    //   43: aload_0
    //   44: ldc 104
    //   46: invokevirtual 108	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   49: ifeq +79 -> 128
    //   52: new 110	java/util/zip/GZIPInputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 113	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   60: astore_0
    //   61: new 115	java/io/ByteArrayOutputStream
    //   64: dup
    //   65: invokespecial 116	java/io/ByteArrayOutputStream:<init>	()V
    //   68: astore_1
    //   69: sipush 128
    //   72: newarray <illegal type>
    //   74: astore 4
    //   76: aload_0
    //   77: aload 4
    //   79: invokevirtual 122	java/io/InputStream:read	([B)I
    //   82: istore_3
    //   83: iload_3
    //   84: iconst_m1
    //   85: if_icmpeq +90 -> 175
    //   88: aload_1
    //   89: aload 4
    //   91: iconst_0
    //   92: iload_3
    //   93: invokevirtual 126	java/io/ByteArrayOutputStream:write	([BII)V
    //   96: goto -20 -> 76
    //   99: astore 5
    //   101: aload_1
    //   102: astore 4
    //   104: aload_0
    //   105: astore_1
    //   106: aload 4
    //   108: astore_0
    //   109: aload 5
    //   111: astore 4
    //   113: aload 4
    //   115: invokevirtual 127	java/lang/Throwable:printStackTrace	()V
    //   118: aload_1
    //   119: invokestatic 130	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   122: aload_0
    //   123: invokestatic 130	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   126: aconst_null
    //   127: areturn
    //   128: aload_0
    //   129: ifnull +41 -> 170
    //   132: aload_0
    //   133: ldc -124
    //   135: invokevirtual 108	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   138: ifeq +32 -> 170
    //   141: new 134	java/util/zip/InflaterInputStream
    //   144: dup
    //   145: aload_1
    //   146: new 136	java/util/zip/Inflater
    //   149: dup
    //   150: iconst_1
    //   151: invokespecial 139	java/util/zip/Inflater:<init>	(Z)V
    //   154: invokespecial 142	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   157: astore_0
    //   158: goto -97 -> 61
    //   161: astore 4
    //   163: aconst_null
    //   164: astore_0
    //   165: aconst_null
    //   166: astore_1
    //   167: goto -54 -> 113
    //   170: aload_1
    //   171: astore_0
    //   172: goto -111 -> 61
    //   175: iload_2
    //   176: ifeq +29 -> 205
    //   179: new 80	java/lang/String
    //   182: dup
    //   183: aload_1
    //   184: invokevirtual 146	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   187: ldc -108
    //   189: invokespecial 151	java/lang/String:<init>	([BLjava/lang/String;)V
    //   192: astore 4
    //   194: aload_0
    //   195: invokestatic 130	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   198: aload_1
    //   199: invokestatic 130	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   202: aload 4
    //   204: areturn
    //   205: new 80	java/lang/String
    //   208: dup
    //   209: invokestatic 57	com/tencent/smtt/utils/o:a	()Lcom/tencent/smtt/utils/o;
    //   212: aload_1
    //   213: invokevirtual 146	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   216: invokevirtual 153	com/tencent/smtt/utils/o:c	([B)[B
    //   219: invokespecial 156	java/lang/String:<init>	([B)V
    //   222: astore 4
    //   224: goto -30 -> 194
    //   227: astore_1
    //   228: aconst_null
    //   229: astore_0
    //   230: aload_0
    //   231: invokestatic 130	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   234: aload 4
    //   236: invokestatic 130	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   239: aload_1
    //   240: athrow
    //   241: astore_1
    //   242: goto -12 -> 230
    //   245: astore 5
    //   247: aload_1
    //   248: astore 4
    //   250: aload 5
    //   252: astore_1
    //   253: goto -23 -> 230
    //   256: astore 4
    //   258: aload_1
    //   259: astore 5
    //   261: aload 4
    //   263: astore_1
    //   264: aload_0
    //   265: astore 4
    //   267: aload 5
    //   269: astore_0
    //   270: goto -40 -> 230
    //   273: astore 4
    //   275: aload_0
    //   276: astore_1
    //   277: aconst_null
    //   278: astore_0
    //   279: goto -166 -> 113
    //   282: aconst_null
    //   283: astore_1
    //   284: aconst_null
    //   285: astore 4
    //   287: aload 5
    //   289: astore_0
    //   290: goto -96 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramHttpURLConnection	HttpURLConnection
    //   0	293	1	parama	a
    //   0	293	2	paramBoolean	boolean
    //   10	83	3	i	int
    //   1	113	4	localObject1	Object
    //   161	1	4	localThrowable1	Throwable
    //   192	57	4	localObject2	Object
    //   256	6	4	localObject3	Object
    //   265	1	4	localHttpURLConnection	HttpURLConnection
    //   273	1	4	localThrowable2	Throwable
    //   285	1	4	localObject4	Object
    //   4	1	5	localObject5	Object
    //   99	11	5	localThrowable3	Throwable
    //   245	6	5	localObject6	Object
    //   259	29	5	locala	a
    // Exception table:
    //   from	to	target	type
    //   69	76	99	java/lang/Throwable
    //   76	83	99	java/lang/Throwable
    //   88	96	99	java/lang/Throwable
    //   179	194	99	java/lang/Throwable
    //   205	224	99	java/lang/Throwable
    //   6	11	161	java/lang/Throwable
    //   15	22	161	java/lang/Throwable
    //   29	39	161	java/lang/Throwable
    //   43	61	161	java/lang/Throwable
    //   132	158	161	java/lang/Throwable
    //   6	11	227	finally
    //   15	22	227	finally
    //   29	39	227	finally
    //   43	61	227	finally
    //   132	158	227	finally
    //   61	69	241	finally
    //   69	76	245	finally
    //   76	83	245	finally
    //   88	96	245	finally
    //   179	194	245	finally
    //   205	224	245	finally
    //   113	118	256	finally
    //   61	69	273	java/lang/Throwable
  }
  
  private static HttpURLConnection a(String paramString, Map<String, String> paramMap)
  {
    for (;;)
    {
      try
      {
        paramString = new URL(paramString);
        if (!(paramString instanceof URL))
        {
          paramString = paramString.openConnection();
          paramString = (HttpURLConnection)paramString;
        }
      }
      catch (Exception paramMap)
      {
        try
        {
          paramString.setRequestMethod("POST");
          paramString.setDoOutput(true);
          paramString.setDoInput(true);
          paramString.setUseCaches(false);
          paramString.setConnectTimeout(20000);
          if (Build.VERSION.SDK_INT <= 13) {
            break label150;
          }
          paramString.setRequestProperty("Connection", "close");
          Iterator localIterator = paramMap.entrySet().iterator();
          paramMap = paramString;
          if (!localIterator.hasNext()) {
            break label148;
          }
          paramMap = (Map.Entry)localIterator.next();
          paramString.setRequestProperty((String)paramMap.getKey(), (String)paramMap.getValue());
          continue;
          paramString = HttpInstrumentation.openConnection((URL)paramString);
        }
        catch (Exception paramMap)
        {
          for (;;) {}
        }
        paramMap = paramMap;
        paramString = null;
      }
      paramMap.printStackTrace();
      paramMap = paramString;
      label148:
      return paramMap;
      label150:
      paramString.setRequestProperty("http.keepAlive", "false");
    }
  }
  
  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  /* Error */
  private static void a(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 240	java/util/zip/GZIPOutputStream
    //   3: dup
    //   4: new 242	java/io/BufferedOutputStream
    //   7: dup
    //   8: aload_0
    //   9: invokevirtual 246	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   12: ldc -9
    //   14: invokespecial 250	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   17: invokespecial 253	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore_0
    //   23: aload_2
    //   24: aload_1
    //   25: invokevirtual 257	java/io/OutputStream:write	([B)V
    //   28: aload_2
    //   29: astore_0
    //   30: aload_2
    //   31: invokevirtual 260	java/io/OutputStream:flush	()V
    //   34: aconst_null
    //   35: invokestatic 130	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   38: aload_2
    //   39: invokestatic 130	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   42: return
    //   43: astore_3
    //   44: aconst_null
    //   45: astore_1
    //   46: aload_1
    //   47: astore_0
    //   48: aload_3
    //   49: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   52: aconst_null
    //   53: invokestatic 130	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   56: aload_1
    //   57: invokestatic 130	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   60: return
    //   61: astore_1
    //   62: aconst_null
    //   63: astore_0
    //   64: aconst_null
    //   65: invokestatic 130	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   68: aload_0
    //   69: invokestatic 130	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   72: aload_1
    //   73: athrow
    //   74: astore_1
    //   75: goto -11 -> 64
    //   78: astore_3
    //   79: aload_2
    //   80: astore_1
    //   81: goto -35 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramHttpURLConnection	HttpURLConnection
    //   0	84	1	paramArrayOfByte	byte[]
    //   20	60	2	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   43	6	3	localException1	Exception
    //   78	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	21	43	java/lang/Exception
    //   0	21	61	finally
    //   23	28	74	finally
    //   30	34	74	finally
    //   48	52	74	finally
    //   23	28	78	java/lang/Exception
    //   30	34	78	java/lang/Exception
  }
  
  private static void b(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte)
  {
    try
    {
      paramHttpURLConnection = paramHttpURLConnection.getOutputStream();
      paramHttpURLConnection.write(paramArrayOfByte);
      paramHttpURLConnection.flush();
      return;
    }
    catch (Exception paramHttpURLConnection)
    {
      paramHttpURLConnection.printStackTrace();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/utils/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */