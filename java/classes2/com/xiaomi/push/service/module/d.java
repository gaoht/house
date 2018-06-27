package com.xiaomi.push.service.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.maa.android.agent.instrumentation.Instrumented;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.misc.k;
import com.xiaomi.push.service.ah;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class d
{
  private static d a = null;
  private Map<String, c> b = new HashMap();
  private List<b> c = new ArrayList();
  private Context d;
  private SharedPreferences e;
  private boolean f;
  
  private d(Context paramContext)
  {
    this.d = paramContext.getApplicationContext();
    this.e = this.d.getSharedPreferences("mipush_extra", 0);
  }
  
  private c a(a parama, DexClassLoader paramDexClassLoader)
  {
    if (paramDexClassLoader != null) {
      return new c(parama.e(), parama.f(), paramDexClassLoader, parama.b(), parama.a());
    }
    return null;
  }
  
  public static d a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new d(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a(e parame, int paramInt)
  {
    this.e.edit().putInt("plugin_version_" + parame.b, paramInt).commit();
  }
  
  private void a(f paramf)
  {
    try
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((b)localIterator.next()).a(paramf);
      }
    }
    finally {}
  }
  
  private int b(e parame)
  {
    return this.e.getInt("plugin_version_" + parame.b, 0);
  }
  
  private List<f> b()
  {
    ArrayList localArrayList = new ArrayList();
    ah localah = ah.a(this.d);
    f localf = new f();
    localf.a = e.a;
    localf.b = localah.a(com.xiaomi.xmpush.thrift.e.Q.a(), 0);
    localf.c = localah.a(com.xiaomi.xmpush.thrift.e.R.a(), "");
    localf.d = localah.a(com.xiaomi.xmpush.thrift.e.S.a(), "");
    localf.e = localah.a(com.xiaomi.xmpush.thrift.e.T.a(), false);
    localArrayList.add(localf);
    return localArrayList;
  }
  
  public c a(e parame)
  {
    
    if (parame == null) {}
    DexClassLoader localDexClassLoader;
    do
    {
      return null;
      a();
      b.b("loadModule " + parame.b);
      parame = parame.b;
      if (this.b.containsKey(parame)) {
        return (c)this.b.get(parame);
      }
      localObject = new a(this.d, parame);
      localDexClassLoader = ((a)localObject).c();
    } while (localDexClassLoader == null);
    Object localObject = a((a)localObject, localDexClassLoader);
    ((c)localObject).a(this.d);
    this.b.put(parame, localObject);
    b.b("module load success.");
    return (c)localObject;
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.f;
        if (bool) {
          return;
        }
        this.f = true;
        Iterator localIterator = b().iterator();
        if (localIterator.hasNext())
        {
          f localf = (f)localIterator.next();
          if ((b(localf.a) < localf.b) && (!TextUtils.isEmpty(localf.c)))
          {
            Object localObject2 = a.a(this.d, localf.a.b);
            localObject2 = new a(this.d, localf.c, localf.d, (String)localObject2, localf.e);
            ((a)localObject2).run();
            if (a.a((a)localObject2))
            {
              a(localf.a, localf.b);
              a(localf);
            }
          }
        }
        else
        {
          this.f = false;
        }
      }
      finally {}
    }
  }
  
  @Instrumented
  private static class a
    implements Runnable
  {
    private String a = null;
    private String b = null;
    private String c;
    private boolean d;
    private Context e;
    private boolean f = false;
    
    public a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = paramBoolean;
      this.e = paramContext.getApplicationContext();
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aconst_null
      //   4: astore 4
      //   6: aload_0
      //   7: getfield 41	com/xiaomi/push/service/module/d$a:e	Landroid/content/Context;
      //   10: invokestatic 51	com/xiaomi/channel/commonutils/network/d:f	(Landroid/content/Context;)Z
      //   13: ifne +4 -> 17
      //   16: return
      //   17: new 53	java/net/URL
      //   20: dup
      //   21: aload_0
      //   22: getfield 25	com/xiaomi/push/service/module/d$a:a	Ljava/lang/String;
      //   25: invokespecial 56	java/net/URL:<init>	(Ljava/lang/String;)V
      //   28: astore_1
      //   29: aload_1
      //   30: instanceof 53
      //   33: ifne +258 -> 291
      //   36: aload_1
      //   37: invokevirtual 60	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   40: astore_1
      //   41: aload_1
      //   42: checkcast 62	java/net/HttpURLConnection
      //   45: astore_1
      //   46: aload_1
      //   47: ldc 64
      //   49: invokevirtual 67	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   52: aload_1
      //   53: sipush 5000
      //   56: invokevirtual 71	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   59: aload_1
      //   60: invokevirtual 74	java/net/HttpURLConnection:connect	()V
      //   63: aload_1
      //   64: invokevirtual 78	java/net/HttpURLConnection:getResponseCode	()I
      //   67: sipush 200
      //   70: if_icmpne -54 -> 16
      //   73: aload_1
      //   74: invokevirtual 82	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   77: invokestatic 87	com/xiaomi/channel/commonutils/file/a:b	(Ljava/io/InputStream;)[B
      //   80: astore_1
      //   81: aload_1
      //   82: astore_2
      //   83: aload_0
      //   84: getfield 27	com/xiaomi/push/service/module/d$a:b	Ljava/lang/String;
      //   87: invokestatic 93	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   90: ifne +23 -> 113
      //   93: aload_1
      //   94: invokestatic 98	com/xiaomi/channel/commonutils/string/d:a	([B)Ljava/lang/String;
      //   97: astore_3
      //   98: aload_1
      //   99: astore_2
      //   100: aload_0
      //   101: getfield 27	com/xiaomi/push/service/module/d$a:b	Ljava/lang/String;
      //   104: aload_3
      //   105: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   108: ifne +5 -> 113
      //   111: aconst_null
      //   112: astore_2
      //   113: aload_2
      //   114: ifnull -98 -> 16
      //   117: ldc 106
      //   119: invokestatic 110	com/xiaomi/channel/commonutils/logger/b:b	(Ljava/lang/String;)V
      //   122: aload 5
      //   124: astore_1
      //   125: new 112	java/io/File
      //   128: dup
      //   129: new 114	java/lang/StringBuilder
      //   132: dup
      //   133: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   136: aload_0
      //   137: getfield 31	com/xiaomi/push/service/module/d$a:c	Ljava/lang/String;
      //   140: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   143: ldc 121
      //   145: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   148: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   151: invokespecial 126	java/io/File:<init>	(Ljava/lang/String;)V
      //   154: astore 6
      //   156: aload 5
      //   158: astore_1
      //   159: aload 6
      //   161: invokevirtual 130	java/io/File:delete	()Z
      //   164: pop
      //   165: aload 5
      //   167: astore_1
      //   168: new 132	java/io/FileOutputStream
      //   171: dup
      //   172: aload 6
      //   174: invokespecial 135	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   177: astore_3
      //   178: aload_3
      //   179: aload_2
      //   180: invokevirtual 139	java/io/FileOutputStream:write	([B)V
      //   183: aload_3
      //   184: invokevirtual 142	java/io/FileOutputStream:flush	()V
      //   187: aload_3
      //   188: invokevirtual 145	java/io/FileOutputStream:close	()V
      //   191: aload 5
      //   193: astore_1
      //   194: aload_0
      //   195: getfield 41	com/xiaomi/push/service/module/d$a:e	Landroid/content/Context;
      //   198: aload 6
      //   200: invokevirtual 148	java/io/File:getPath	()Ljava/lang/String;
      //   203: invokestatic 153	com/xiaomi/channel/commonutils/android/b:e	(Landroid/content/Context;Ljava/lang/String;)[Landroid/content/pm/Signature;
      //   206: invokestatic 158	com/xiaomi/channel/commonutils/android/d:a	([Landroid/content/pm/Signature;)Z
      //   209: ifeq +93 -> 302
      //   212: aload 5
      //   214: astore_1
      //   215: ldc -96
      //   217: invokestatic 110	com/xiaomi/channel/commonutils/logger/b:b	(Ljava/lang/String;)V
      //   220: aload 5
      //   222: astore_1
      //   223: aload 6
      //   225: new 112	java/io/File
      //   228: dup
      //   229: aload_0
      //   230: getfield 31	com/xiaomi/push/service/module/d$a:c	Ljava/lang/String;
      //   233: invokespecial 126	java/io/File:<init>	(Ljava/lang/String;)V
      //   236: invokevirtual 164	java/io/File:renameTo	(Ljava/io/File;)Z
      //   239: pop
      //   240: aload 5
      //   242: astore_1
      //   243: aload_0
      //   244: iconst_1
      //   245: putfield 29	com/xiaomi/push/service/module/d$a:f	Z
      //   248: aload 5
      //   250: astore_1
      //   251: aload_0
      //   252: getfield 33	com/xiaomi/push/service/module/d$a:d	Z
      //   255: ifeq +25 -> 280
      //   258: aload 5
      //   260: astore_1
      //   261: aload_0
      //   262: getfield 41	com/xiaomi/push/service/module/d$a:e	Landroid/content/Context;
      //   265: invokestatic 166	com/xiaomi/channel/commonutils/android/b:b	(Landroid/content/Context;)Z
      //   268: ifne +12 -> 280
      //   271: aload 5
      //   273: astore_1
      //   274: invokestatic 171	android/os/Process:myPid	()I
      //   277: invokestatic 174	android/os/Process:killProcess	(I)V
      //   280: aconst_null
      //   281: invokestatic 177	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/OutputStream;)V
      //   284: return
      //   285: astore_1
      //   286: aload_1
      //   287: invokevirtual 180	java/lang/Exception:printStackTrace	()V
      //   290: return
      //   291: aload_1
      //   292: checkcast 53	java/net/URL
      //   295: invokestatic 185	com/mato/sdk/instrumentation/HttpInstrumentation:openConnection	(Ljava/net/URL;)Ljava/net/URLConnection;
      //   298: astore_1
      //   299: goto -258 -> 41
      //   302: aload 5
      //   304: astore_1
      //   305: ldc -69
      //   307: invokestatic 189	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
      //   310: aload 5
      //   312: astore_1
      //   313: aload 6
      //   315: invokevirtual 130	java/io/File:delete	()Z
      //   318: pop
      //   319: goto -39 -> 280
      //   322: astore_3
      //   323: aload 4
      //   325: astore_2
      //   326: aload_2
      //   327: astore_1
      //   328: aload_3
      //   329: invokevirtual 180	java/lang/Exception:printStackTrace	()V
      //   332: aload_2
      //   333: invokestatic 177	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/OutputStream;)V
      //   336: return
      //   337: aload_1
      //   338: invokestatic 177	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/OutputStream;)V
      //   341: aload_2
      //   342: athrow
      //   343: astore_2
      //   344: aload_3
      //   345: astore_1
      //   346: goto -9 -> 337
      //   349: astore_1
      //   350: aload_3
      //   351: astore_2
      //   352: aload_1
      //   353: astore_3
      //   354: goto -28 -> 326
      //   357: astore_2
      //   358: goto -21 -> 337
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	361	0	this	a
      //   28	246	1	localObject1	Object
      //   285	7	1	localException1	Exception
      //   298	48	1	localObject2	Object
      //   349	4	1	localException2	Exception
      //   82	260	2	localObject3	Object
      //   343	1	2	localObject4	Object
      //   351	1	2	localObject5	Object
      //   357	1	2	localObject6	Object
      //   97	91	3	localObject7	Object
      //   322	29	3	localException3	Exception
      //   353	1	3	localException4	Exception
      //   4	320	4	localObject8	Object
      //   1	310	5	localObject9	Object
      //   154	160	6	localFile	java.io.File
      // Exception table:
      //   from	to	target	type
      //   17	41	285	java/lang/Exception
      //   41	81	285	java/lang/Exception
      //   83	98	285	java/lang/Exception
      //   100	111	285	java/lang/Exception
      //   117	122	285	java/lang/Exception
      //   280	284	285	java/lang/Exception
      //   291	299	285	java/lang/Exception
      //   332	336	285	java/lang/Exception
      //   337	343	285	java/lang/Exception
      //   125	156	322	java/lang/Exception
      //   159	165	322	java/lang/Exception
      //   168	178	322	java/lang/Exception
      //   194	212	322	java/lang/Exception
      //   215	220	322	java/lang/Exception
      //   223	240	322	java/lang/Exception
      //   243	248	322	java/lang/Exception
      //   251	258	322	java/lang/Exception
      //   261	271	322	java/lang/Exception
      //   274	280	322	java/lang/Exception
      //   305	310	322	java/lang/Exception
      //   313	319	322	java/lang/Exception
      //   178	191	343	finally
      //   178	191	349	java/lang/Exception
      //   125	156	357	finally
      //   159	165	357	finally
      //   168	178	357	finally
      //   194	212	357	finally
      //   215	220	357	finally
      //   223	240	357	finally
      //   243	248	357	finally
      //   251	258	357	finally
      //   261	271	357	finally
      //   274	280	357	finally
      //   305	310	357	finally
      //   313	319	357	finally
      //   328	332	357	finally
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(f paramf);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/module/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */