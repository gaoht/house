package com.f.a.c;

import android.content.Context;
import android.provider.Settings.System;
import com.f.a.a.a.b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class d
{
  private static final Object b = new Object();
  private static d c = null;
  private static final String j = ".UTSystemConfig" + File.separator + "Global";
  private Context a = null;
  private String d = null;
  private e e = null;
  private String f = "xx_utdid_key";
  private String g = "xx_utdid_domain";
  private com.f.a.b.a.c h = null;
  private com.f.a.b.a.c i = null;
  private Pattern k = Pattern.compile("[^0-9a-zA-Z=/+]+");
  
  private d(Context paramContext)
  {
    this.a = paramContext;
    this.i = new com.f.a.b.a.c(paramContext, j, "Alvin2");
    this.h = new com.f.a.b.a.c(paramContext, ".DataStorage", "ContextData");
    this.e = new e();
    this.f = String.format("K_%d", new Object[] { Integer.valueOf(com.f.a.a.a.e.b(this.f)) });
    this.g = String.format("D_%d", new Object[] { Integer.valueOf(com.f.a.a.a.e.b(this.g)) });
  }
  
  public static d a(Context paramContext)
  {
    int n = 1;
    if ((paramContext != null) && (c == null)) {}
    label187:
    for (;;)
    {
      synchronized (b)
      {
        if (c == null)
        {
          paramContext = new d(paramContext);
          c = paramContext;
          if (paramContext.i != null)
          {
            if (com.f.a.a.a.e.a(paramContext.i.b("UTDID2")))
            {
              String str = paramContext.i.b("UTDID");
              if (!com.f.a.a.a.e.a(str)) {
                paramContext.a(str);
              }
            }
            int m = 0;
            if (!com.f.a.a.a.e.a(paramContext.i.b("DID")))
            {
              paramContext.i.a("DID");
              m = 1;
            }
            if (!com.f.a.a.a.e.a(paramContext.i.b("EI")))
            {
              paramContext.i.a("EI");
              m = 1;
            }
            if (com.f.a.a.a.e.a(paramContext.i.b("SI"))) {
              break label187;
            }
            paramContext.i.a("SI");
            m = n;
            if (m != 0) {
              paramContext.i.a();
            }
          }
        }
        return c;
      }
    }
  }
  
  private void a(String paramString)
  {
    if (e(paramString))
    {
      String str = paramString;
      if (paramString.endsWith("\n")) {
        str = paramString.substring(0, paramString.length() - 1);
      }
      if ((str.length() == 24) && (this.i != null))
      {
        this.i.a("UTDID2", str);
        this.i.a();
      }
    }
  }
  
  private void b(String paramString)
  {
    if ((paramString != null) && (this.h != null) && (!paramString.equals(this.h.b(this.f))))
    {
      this.h.a(this.f, paramString);
      this.h.a();
    }
  }
  
  private final byte[] b()
    throws Exception
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int m = (int)(System.currentTimeMillis() / 1000L);
    int n = new Random().nextInt();
    Object localObject1 = com.f.a.a.a.c.a(m);
    Object localObject2 = com.f.a.a.a.c.a(n);
    localByteArrayOutputStream.write((byte[])localObject1, 0, 4);
    localByteArrayOutputStream.write((byte[])localObject2, 0, 4);
    localByteArrayOutputStream.write(3);
    localByteArrayOutputStream.write(0);
    try
    {
      localObject1 = com.f.a.a.a.d.a(this.a);
      localByteArrayOutputStream.write(com.f.a.a.a.c.a(com.f.a.a.a.e.b((String)localObject1)), 0, 4);
      localObject1 = localByteArrayOutputStream.toByteArray();
      localObject2 = Mac.getInstance("HmacSHA1");
      ((Mac)localObject2).init(new SecretKeySpec("d6fc3a4a06adbde89223bvefedc24fecde188aaa9161".getBytes(), ((Mac)localObject2).getAlgorithm()));
      localByteArrayOutputStream.write(com.f.a.a.a.c.a(com.f.a.a.a.e.b(b.a(((Mac)localObject2).doFinal((byte[])localObject1), 2))));
      return localByteArrayOutputStream.toByteArray();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = new Random().nextInt();
      }
    }
  }
  
  private void c(String paramString)
  {
    String str1;
    if ((this.a.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0) && (e(paramString)))
    {
      str1 = paramString;
      if (paramString.endsWith("\n")) {
        str1 = paramString.substring(0, paramString.length() - 1);
      }
      if (24 == str1.length()) {
        paramString = null;
      }
    }
    try
    {
      String str2 = Settings.System.getString(this.a.getContentResolver(), "mqBRboGZkQPcAkyk");
      paramString = str2;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (!e(paramString)) {}
    try
    {
      Settings.System.putString(this.a.getContentResolver(), "mqBRboGZkQPcAkyk", str1);
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void d(String paramString)
  {
    Object localObject;
    if ((this.a.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0) && (paramString != null)) {
      localObject = null;
    }
    try
    {
      String str = Settings.System.getString(this.a.getContentResolver(), "dxCRMxhQkdGePGnp");
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (!paramString.equals(localObject)) {}
    try
    {
      Settings.System.putString(this.a.getContentResolver(), "dxCRMxhQkdGePGnp", paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  private boolean e(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      String str = paramString;
      if (paramString.endsWith("\n")) {
        str = paramString.substring(0, paramString.length() - 1);
      }
      bool1 = bool2;
      if (24 == str.length())
      {
        bool1 = bool2;
        if (!this.k.matcher(str).find()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  /* Error */
  public final String a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 61	com/f/a/c/d:d	Ljava/lang/String;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 61	com/f/a/c/d:d	Ljava/lang/String;
    //   13: astore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_2
    //   17: areturn
    //   18: ldc_w 285
    //   21: astore_3
    //   22: aload_0
    //   23: getfield 59	com/f/a/c/d:a	Landroid/content/Context;
    //   26: invokevirtual 260	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   29: ldc_w 262
    //   32: invokestatic 268	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   35: astore_2
    //   36: aload_2
    //   37: astore_3
    //   38: aload_3
    //   39: astore_2
    //   40: aload_0
    //   41: aload_3
    //   42: invokespecial 147	com/f/a/c/d:e	(Ljava/lang/String;)Z
    //   45: ifne -31 -> 14
    //   48: new 287	com/f/a/c/f
    //   51: dup
    //   52: invokespecial 288	com/f/a/c/f:<init>	()V
    //   55: astore 4
    //   57: iconst_0
    //   58: istore_1
    //   59: aload_0
    //   60: getfield 59	com/f/a/c/d:a	Landroid/content/Context;
    //   63: invokevirtual 260	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   66: ldc_w 274
    //   69: invokestatic 268	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_2
    //   73: aload_2
    //   74: invokestatic 131	com/f/a/a/a/e:a	(Ljava/lang/String;)Z
    //   77: ifne +411 -> 488
    //   80: aload 4
    //   82: aload_2
    //   83: invokevirtual 289	com/f/a/c/f:b	(Ljava/lang/String;)Ljava/lang/String;
    //   86: astore_3
    //   87: aload_0
    //   88: aload_3
    //   89: invokespecial 147	com/f/a/c/d:e	(Ljava/lang/String;)Z
    //   92: ifeq +24 -> 116
    //   95: aload_0
    //   96: aload_3
    //   97: invokespecial 291	com/f/a/c/d:c	(Ljava/lang/String;)V
    //   100: aload_3
    //   101: astore_2
    //   102: goto -88 -> 14
    //   105: astore_2
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_2
    //   109: athrow
    //   110: astore_2
    //   111: aconst_null
    //   112: astore_2
    //   113: goto -40 -> 73
    //   116: aload 4
    //   118: aload_2
    //   119: invokevirtual 293	com/f/a/c/f:a	(Ljava/lang/String;)Ljava/lang/String;
    //   122: astore_3
    //   123: aload_0
    //   124: aload_3
    //   125: invokespecial 147	com/f/a/c/d:e	(Ljava/lang/String;)Z
    //   128: ifeq +357 -> 485
    //   131: aload_0
    //   132: getfield 63	com/f/a/c/d:e	Lcom/f/a/c/e;
    //   135: aload_3
    //   136: invokevirtual 294	com/f/a/c/e:a	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore_3
    //   140: aload_3
    //   141: invokestatic 131	com/f/a/a/a/e:a	(Ljava/lang/String;)Z
    //   144: ifne +341 -> 485
    //   147: aload_0
    //   148: aload_3
    //   149: invokespecial 296	com/f/a/c/d:d	(Ljava/lang/String;)V
    //   152: aload_0
    //   153: getfield 59	com/f/a/c/d:a	Landroid/content/Context;
    //   156: invokevirtual 260	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   159: ldc_w 274
    //   162: invokestatic 268	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   165: astore_3
    //   166: aload_3
    //   167: astore_2
    //   168: aload_0
    //   169: getfield 63	com/f/a/c/d:e	Lcom/f/a/c/e;
    //   172: aload_2
    //   173: invokevirtual 297	com/f/a/c/e:b	(Ljava/lang/String;)Ljava/lang/String;
    //   176: astore_3
    //   177: aload_0
    //   178: aload_3
    //   179: invokespecial 147	com/f/a/c/d:e	(Ljava/lang/String;)Z
    //   182: ifeq +34 -> 216
    //   185: aload_0
    //   186: aload_3
    //   187: putfield 61	com/f/a/c/d:d	Ljava/lang/String;
    //   190: aload_0
    //   191: aload_3
    //   192: invokespecial 135	com/f/a/c/d:a	(Ljava/lang/String;)V
    //   195: aload_0
    //   196: aload_2
    //   197: invokespecial 299	com/f/a/c/d:b	(Ljava/lang/String;)V
    //   200: aload_0
    //   201: aload_0
    //   202: getfield 61	com/f/a/c/d:d	Ljava/lang/String;
    //   205: invokespecial 291	com/f/a/c/d:c	(Ljava/lang/String;)V
    //   208: aload_0
    //   209: getfield 61	com/f/a/c/d:d	Ljava/lang/String;
    //   212: astore_2
    //   213: goto -199 -> 14
    //   216: aload_0
    //   217: getfield 75	com/f/a/c/d:i	Lcom/f/a/b/a/c;
    //   220: ifnull +273 -> 493
    //   223: aload_0
    //   224: getfield 75	com/f/a/c/d:i	Lcom/f/a/b/a/c;
    //   227: ldc 125
    //   229: invokevirtual 128	com/f/a/b/a/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   232: astore_2
    //   233: aload_2
    //   234: invokestatic 131	com/f/a/a/a/e:a	(Ljava/lang/String;)Z
    //   237: ifne +256 -> 493
    //   240: aload_0
    //   241: getfield 63	com/f/a/c/d:e	Lcom/f/a/c/e;
    //   244: aload_2
    //   245: invokevirtual 294	com/f/a/c/e:a	(Ljava/lang/String;)Ljava/lang/String;
    //   248: ifnull +245 -> 493
    //   251: aload_0
    //   252: aload_2
    //   253: invokespecial 147	com/f/a/c/d:e	(Ljava/lang/String;)Z
    //   256: ifeq +39 -> 295
    //   259: aload_0
    //   260: getfield 63	com/f/a/c/d:e	Lcom/f/a/c/e;
    //   263: aload_2
    //   264: invokevirtual 294	com/f/a/c/e:a	(Ljava/lang/String;)Ljava/lang/String;
    //   267: astore_3
    //   268: iload_1
    //   269: ifeq +8 -> 277
    //   272: aload_0
    //   273: aload_3
    //   274: invokespecial 296	com/f/a/c/d:d	(Ljava/lang/String;)V
    //   277: aload_0
    //   278: aload_2
    //   279: invokespecial 291	com/f/a/c/d:c	(Ljava/lang/String;)V
    //   282: aload_0
    //   283: aload_3
    //   284: invokespecial 299	com/f/a/c/d:b	(Ljava/lang/String;)V
    //   287: aload_0
    //   288: aload_2
    //   289: putfield 61	com/f/a/c/d:d	Ljava/lang/String;
    //   292: goto -278 -> 14
    //   295: aload_0
    //   296: getfield 73	com/f/a/c/d:h	Lcom/f/a/b/a/c;
    //   299: aload_0
    //   300: getfield 67	com/f/a/c/d:f	Ljava/lang/String;
    //   303: invokevirtual 128	com/f/a/b/a/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   306: astore 5
    //   308: aload 5
    //   310: invokestatic 131	com/f/a/a/a/e:a	(Ljava/lang/String;)Z
    //   313: ifne +85 -> 398
    //   316: aload 4
    //   318: aload 5
    //   320: invokevirtual 293	com/f/a/c/f:a	(Ljava/lang/String;)Ljava/lang/String;
    //   323: astore_3
    //   324: aload_3
    //   325: astore_2
    //   326: aload_0
    //   327: aload_3
    //   328: invokespecial 147	com/f/a/c/d:e	(Ljava/lang/String;)Z
    //   331: ifne +13 -> 344
    //   334: aload_0
    //   335: getfield 63	com/f/a/c/d:e	Lcom/f/a/c/e;
    //   338: aload 5
    //   340: invokevirtual 297	com/f/a/c/e:b	(Ljava/lang/String;)Ljava/lang/String;
    //   343: astore_2
    //   344: aload_0
    //   345: aload_2
    //   346: invokespecial 147	com/f/a/c/d:e	(Ljava/lang/String;)Z
    //   349: ifeq +49 -> 398
    //   352: aload_0
    //   353: getfield 63	com/f/a/c/d:e	Lcom/f/a/c/e;
    //   356: aload_2
    //   357: invokevirtual 294	com/f/a/c/e:a	(Ljava/lang/String;)Ljava/lang/String;
    //   360: astore_3
    //   361: aload_2
    //   362: invokestatic 131	com/f/a/a/a/e:a	(Ljava/lang/String;)Z
    //   365: ifne +33 -> 398
    //   368: aload_0
    //   369: aload_2
    //   370: putfield 61	com/f/a/c/d:d	Ljava/lang/String;
    //   373: iload_1
    //   374: ifeq +8 -> 382
    //   377: aload_0
    //   378: aload_3
    //   379: invokespecial 296	com/f/a/c/d:d	(Ljava/lang/String;)V
    //   382: aload_0
    //   383: aload_0
    //   384: getfield 61	com/f/a/c/d:d	Ljava/lang/String;
    //   387: invokespecial 135	com/f/a/c/d:a	(Ljava/lang/String;)V
    //   390: aload_0
    //   391: getfield 61	com/f/a/c/d:d	Ljava/lang/String;
    //   394: astore_2
    //   395: goto -381 -> 14
    //   398: aload_0
    //   399: invokespecial 301	com/f/a/c/d:b	()[B
    //   402: astore_3
    //   403: aload_3
    //   404: ifnull +71 -> 475
    //   407: aload_0
    //   408: aload_3
    //   409: iconst_2
    //   410: invokestatic 241	com/f/a/a/a/b:a	([BI)Ljava/lang/String;
    //   413: putfield 61	com/f/a/c/d:d	Ljava/lang/String;
    //   416: aload_0
    //   417: aload_0
    //   418: getfield 61	com/f/a/c/d:d	Ljava/lang/String;
    //   421: invokespecial 135	com/f/a/c/d:a	(Ljava/lang/String;)V
    //   424: aload_0
    //   425: getfield 63	com/f/a/c/d:e	Lcom/f/a/c/e;
    //   428: astore_2
    //   429: aload_3
    //   430: iconst_2
    //   431: invokestatic 241	com/f/a/a/a/b:a	([BI)Ljava/lang/String;
    //   434: astore_3
    //   435: aload_2
    //   436: getfield 303	com/f/a/c/e:a	Ljava/lang/String;
    //   439: aload_3
    //   440: invokestatic 308	com/f/a/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   443: astore_2
    //   444: aload_2
    //   445: ifnull +17 -> 462
    //   448: iload_1
    //   449: ifeq +8 -> 457
    //   452: aload_0
    //   453: aload_2
    //   454: invokespecial 296	com/f/a/c/d:d	(Ljava/lang/String;)V
    //   457: aload_0
    //   458: aload_2
    //   459: invokespecial 299	com/f/a/c/d:b	(Ljava/lang/String;)V
    //   462: aload_0
    //   463: getfield 61	com/f/a/c/d:d	Ljava/lang/String;
    //   466: astore_2
    //   467: goto -453 -> 14
    //   470: astore_2
    //   471: aload_2
    //   472: invokevirtual 311	java/lang/Exception:printStackTrace	()V
    //   475: aconst_null
    //   476: astore_2
    //   477: goto -463 -> 14
    //   480: astore_2
    //   481: goto -443 -> 38
    //   484: astore_3
    //   485: goto -317 -> 168
    //   488: iconst_1
    //   489: istore_1
    //   490: goto -274 -> 216
    //   493: aconst_null
    //   494: astore_2
    //   495: goto -244 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	498	0	this	d
    //   58	432	1	m	int
    //   13	89	2	localObject1	Object
    //   105	4	2	localObject2	Object
    //   110	1	2	localException1	Exception
    //   112	355	2	localObject3	Object
    //   470	2	2	localException2	Exception
    //   476	1	2	localObject4	Object
    //   480	1	2	localException3	Exception
    //   494	1	2	localObject5	Object
    //   21	419	3	localObject6	Object
    //   484	1	3	localException4	Exception
    //   55	262	4	localf	f
    //   306	33	5	str	String
    // Exception table:
    //   from	to	target	type
    //   2	14	105	finally
    //   22	36	105	finally
    //   40	57	105	finally
    //   59	73	105	finally
    //   73	100	105	finally
    //   116	152	105	finally
    //   152	166	105	finally
    //   168	177	105	finally
    //   177	213	105	finally
    //   216	251	105	finally
    //   251	268	105	finally
    //   272	277	105	finally
    //   277	292	105	finally
    //   295	324	105	finally
    //   326	344	105	finally
    //   344	373	105	finally
    //   377	382	105	finally
    //   382	395	105	finally
    //   398	403	105	finally
    //   407	444	105	finally
    //   452	457	105	finally
    //   457	462	105	finally
    //   462	467	105	finally
    //   471	475	105	finally
    //   59	73	110	java/lang/Exception
    //   398	403	470	java/lang/Exception
    //   407	444	470	java/lang/Exception
    //   452	457	470	java/lang/Exception
    //   457	462	470	java/lang/Exception
    //   462	467	470	java/lang/Exception
    //   22	36	480	java/lang/Exception
    //   152	166	484	java/lang/Exception
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/f/a/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */