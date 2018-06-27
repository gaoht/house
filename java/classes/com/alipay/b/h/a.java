package com.alipay.b.h;

import android.content.Context;
import com.alipay.c.a.a.a.a.c;
import com.alipay.c.a.a.d.d;
import java.util.HashMap;
import java.util.Map;

public class a
{
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (com.alipay.c.a.a.a.a.a(paramString1)) || (com.alipay.c.a.a.a.a.a(paramString2))) {}
    for (;;)
    {
      return null;
      try
      {
        paramContext = d.a(paramContext, paramString1, paramString2, "");
        if (!com.alipay.c.a.a.a.a.a(paramContext))
        {
          paramContext = c.b(c.a(), paramContext);
          return paramContext;
        }
      }
      catch (Throwable paramContext) {}
    }
    return null;
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 18	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   7: ifne +10 -> 17
    //   10: aload_1
    //   11: invokestatic 18	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   14: ifeq +8 -> 22
    //   17: ldc 2
    //   19: monitorexit
    //   20: aconst_null
    //   21: areturn
    //   22: aload_0
    //   23: invokestatic 39	com/alipay/c/a/a/d/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore_0
    //   27: aload_0
    //   28: invokestatic 18	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   31: istore_2
    //   32: iload_2
    //   33: ifeq +14 -> 47
    //   36: ldc 2
    //   38: monitorexit
    //   39: aconst_null
    //   40: areturn
    //   41: astore_0
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload_0
    //   46: athrow
    //   47: new 41	org/json/JSONObject
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 44	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   55: aload_1
    //   56: invokevirtual 47	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore_0
    //   60: aload_0
    //   61: invokestatic 18	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   64: istore_2
    //   65: iload_2
    //   66: ifeq +8 -> 74
    //   69: ldc 2
    //   71: monitorexit
    //   72: aconst_null
    //   73: areturn
    //   74: invokestatic 30	com/alipay/c/a/a/a/a/c:a	()Ljava/lang/String;
    //   77: aload_0
    //   78: invokestatic 34	com/alipay/c/a/a/a/a/c:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   81: astore_0
    //   82: ldc 2
    //   84: monitorexit
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: ldc 2
    //   90: monitorexit
    //   91: aconst_null
    //   92: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramString1	String
    //   0	93	1	paramString2	String
    //   31	35	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	17	41	finally
    //   17	20	41	finally
    //   22	32	41	finally
    //   36	39	41	finally
    //   47	65	41	finally
    //   69	72	41	finally
    //   74	82	41	finally
    //   82	85	41	finally
    //   22	32	87	java/lang/Throwable
    //   47	65	87	java/lang/Throwable
    //   74	82	87	java/lang/Throwable
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((com.alipay.c.a.a.a.a.a(paramString1)) || (com.alipay.c.a.a.a.a.a(paramString2)) || (paramContext == null)) {
      return;
    }
    try
    {
      paramString3 = c.a(c.a(), paramString3);
      HashMap localHashMap = new HashMap();
      localHashMap.put(paramString2, paramString3);
      d.a(paramContext, paramString1, localHashMap);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 18	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   7: ifne +10 -> 17
    //   10: aload_1
    //   11: invokestatic 18	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   14: ifeq +7 -> 21
    //   17: ldc 2
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: invokestatic 39	com/alipay/c/a/a/d/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore 5
    //   27: new 41	org/json/JSONObject
    //   30: dup
    //   31: invokespecial 68	org/json/JSONObject:<init>	()V
    //   34: astore 4
    //   36: aload 5
    //   38: invokestatic 70	com/alipay/c/a/a/a/a:b	(Ljava/lang/String;)Z
    //   41: istore_3
    //   42: iload_3
    //   43: ifeq +14 -> 57
    //   46: new 41	org/json/JSONObject
    //   49: dup
    //   50: aload 5
    //   52: invokespecial 44	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   55: astore 4
    //   57: aload 4
    //   59: aload_1
    //   60: invokestatic 30	com/alipay/c/a/a/a/a/c:a	()Ljava/lang/String;
    //   63: aload_2
    //   64: invokestatic 50	com/alipay/c/a/a/a/a/c:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   67: invokevirtual 73	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   70: pop
    //   71: aload 4
    //   73: invokevirtual 76	org/json/JSONObject:toString	()Ljava/lang/String;
    //   76: astore_2
    //   77: aload_2
    //   78: invokestatic 18	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   81: ifne +9 -> 90
    //   84: aload_0
    //   85: aload_2
    //   86: invokestatic 81	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   89: pop
    //   90: invokestatic 86	com/alipay/c/a/a/d/c:a	()Z
    //   93: ifeq +92 -> 185
    //   96: new 88	java/lang/StringBuilder
    //   99: dup
    //   100: ldc 90
    //   102: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: getstatic 97	java/io/File:separator	Ljava/lang/String;
    //   108: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_0
    //   112: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore_0
    //   119: invokestatic 86	com/alipay/c/a/a/d/c:a	()Z
    //   122: ifeq +63 -> 185
    //   125: new 93	java/io/File
    //   128: dup
    //   129: invokestatic 108	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   132: aload_0
    //   133: invokespecial 111	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 114	java/io/File:exists	()Z
    //   141: ifne +11 -> 152
    //   144: aload_0
    //   145: invokevirtual 117	java/io/File:getParentFile	()Ljava/io/File;
    //   148: invokevirtual 120	java/io/File:mkdirs	()Z
    //   151: pop
    //   152: new 93	java/io/File
    //   155: dup
    //   156: aload_0
    //   157: invokevirtual 123	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   160: invokespecial 124	java/io/File:<init>	(Ljava/lang/String;)V
    //   163: astore_0
    //   164: aconst_null
    //   165: astore_1
    //   166: new 126	java/io/FileWriter
    //   169: dup
    //   170: aload_0
    //   171: iconst_0
    //   172: invokespecial 129	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   175: astore_0
    //   176: aload_0
    //   177: aload_2
    //   178: invokevirtual 132	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   181: aload_0
    //   182: invokevirtual 135	java/io/FileWriter:close	()V
    //   185: ldc 2
    //   187: monitorexit
    //   188: return
    //   189: astore_0
    //   190: ldc 2
    //   192: monitorexit
    //   193: aload_0
    //   194: athrow
    //   195: astore 4
    //   197: new 41	org/json/JSONObject
    //   200: dup
    //   201: invokespecial 68	org/json/JSONObject:<init>	()V
    //   204: astore 4
    //   206: goto -149 -> 57
    //   209: astore_0
    //   210: goto -25 -> 185
    //   213: astore_0
    //   214: aconst_null
    //   215: astore_0
    //   216: aload_0
    //   217: ifnull -32 -> 185
    //   220: aload_0
    //   221: invokevirtual 135	java/io/FileWriter:close	()V
    //   224: goto -39 -> 185
    //   227: astore_0
    //   228: goto -43 -> 185
    //   231: astore_0
    //   232: aload_1
    //   233: ifnull +7 -> 240
    //   236: aload_1
    //   237: invokevirtual 135	java/io/FileWriter:close	()V
    //   240: aload_0
    //   241: athrow
    //   242: astore_0
    //   243: goto -58 -> 185
    //   246: astore_0
    //   247: goto -62 -> 185
    //   250: astore_1
    //   251: goto -11 -> 240
    //   254: astore_2
    //   255: aload_0
    //   256: astore_1
    //   257: aload_2
    //   258: astore_0
    //   259: goto -27 -> 232
    //   262: astore_1
    //   263: goto -47 -> 216
    //   266: astore_1
    //   267: goto -177 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	paramString1	String
    //   0	270	1	paramString2	String
    //   0	270	2	paramString3	String
    //   41	2	3	bool	boolean
    //   34	38	4	localJSONObject1	org.json.JSONObject
    //   195	1	4	localException	Exception
    //   204	1	4	localJSONObject2	org.json.JSONObject
    //   25	26	5	str	String
    // Exception table:
    //   from	to	target	type
    //   3	17	189	finally
    //   17	20	189	finally
    //   21	42	189	finally
    //   46	57	189	finally
    //   57	77	189	finally
    //   77	90	189	finally
    //   90	119	189	finally
    //   119	152	189	finally
    //   152	164	189	finally
    //   181	185	189	finally
    //   185	188	189	finally
    //   197	206	189	finally
    //   220	224	189	finally
    //   236	240	189	finally
    //   240	242	189	finally
    //   46	57	195	java/lang/Exception
    //   21	42	209	java/lang/Throwable
    //   46	57	209	java/lang/Throwable
    //   57	77	209	java/lang/Throwable
    //   90	119	209	java/lang/Throwable
    //   119	152	209	java/lang/Throwable
    //   152	164	209	java/lang/Throwable
    //   181	185	209	java/lang/Throwable
    //   197	206	209	java/lang/Throwable
    //   220	224	209	java/lang/Throwable
    //   236	240	209	java/lang/Throwable
    //   240	242	209	java/lang/Throwable
    //   166	176	213	java/lang/Exception
    //   220	224	227	java/io/IOException
    //   166	176	231	finally
    //   119	152	242	java/lang/Exception
    //   152	164	242	java/lang/Exception
    //   181	185	242	java/lang/Exception
    //   220	224	242	java/lang/Exception
    //   236	240	242	java/lang/Exception
    //   240	242	242	java/lang/Exception
    //   181	185	246	java/io/IOException
    //   236	240	250	java/io/IOException
    //   176	181	254	finally
    //   176	181	262	java/lang/Exception
    //   77	90	266	java/lang/Throwable
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/b/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */