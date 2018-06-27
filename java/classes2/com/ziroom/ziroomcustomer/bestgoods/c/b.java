package com.ziroom.ziroomcustomer.bestgoods.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.freelxl.baselibrary.f.g;
import com.maa.android.agent.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.bestgoods.b.a;
import com.ziroom.ziroomcustomer.widget.LodingProgressDialog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class b
{
  private static ArrayMap<String, WeakReference<a>> a = new ArrayMap();
  
  @TargetApi(11)
  public static void download(Activity paramActivity, File paramFile, String paramString, a<Boolean> parama)
  {
    if (a.containsKey(paramFile.getAbsolutePath()))
    {
      a locala = (a)((WeakReference)a.remove(paramFile.getAbsolutePath())).get();
      if (locala != null) {
        locala.cancel(true);
      }
    }
    if (TextUtils.isEmpty(paramString))
    {
      g.textToast(paramActivity, "暂无发票信息，请稍后重试");
      return;
    }
    paramActivity = new a(paramActivity, paramFile, paramString, parama);
    if (Build.VERSION.SDK_INT >= 11) {
      paramActivity.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }
    for (;;)
    {
      a.put(paramFile.getAbsolutePath(), new WeakReference(paramActivity));
      return;
      paramActivity.execute(new String[0]);
    }
  }
  
  @Instrumented
  private static class a
    extends AsyncTask<String, Integer, Boolean>
  {
    private Activity a;
    private String b;
    private int c;
    private File d;
    private a<Boolean> e;
    private Timer f;
    
    public a(Activity paramActivity, File paramFile, String paramString, a<Boolean> parama)
    {
      this.a = paramActivity;
      this.d = paramFile;
      this.b = paramString;
      this.e = parama;
      LodingProgressDialog.show(paramActivity, "", false, true);
      this.f = new Timer();
      this.f.schedule(new a(), 30000L);
    }
    
    /* Error */
    protected Boolean a(String... paramVarArgs)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 14
      //   3: aconst_null
      //   4: astore 13
      //   6: aconst_null
      //   7: astore 15
      //   9: aconst_null
      //   10: astore 11
      //   12: aconst_null
      //   13: astore 12
      //   15: aload 15
      //   17: astore 8
      //   19: aload 14
      //   21: astore 9
      //   23: aload_0
      //   24: iconst_2
      //   25: anewarray 69	java/lang/Integer
      //   28: dup
      //   29: iconst_0
      //   30: iconst_m1
      //   31: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   34: aastore
      //   35: dup
      //   36: iconst_1
      //   37: iconst_m1
      //   38: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   41: aastore
      //   42: invokevirtual 77	com/ziroom/ziroomcustomer/bestgoods/c/b$a:publishProgress	([Ljava/lang/Object;)V
      //   45: aload 15
      //   47: astore 8
      //   49: aload 14
      //   51: astore 9
      //   53: new 79	java/net/URL
      //   56: dup
      //   57: aload_0
      //   58: getfield 34	com/ziroom/ziroomcustomer/bestgoods/c/b$a:b	Ljava/lang/String;
      //   61: invokespecial 82	java/net/URL:<init>	(Ljava/lang/String;)V
      //   64: astore_1
      //   65: aload 15
      //   67: astore 8
      //   69: aload 14
      //   71: astore 9
      //   73: aload_0
      //   74: getfield 30	com/ziroom/ziroomcustomer/bestgoods/c/b$a:a	Landroid/app/Activity;
      //   77: invokestatic 88	com/ziroom/ziroomcustomer/bestgoods/c/c:getProxy	(Landroid/content/Context;)Ljava/net/Proxy;
      //   80: astore 10
      //   82: aload 10
      //   84: ifnull +281 -> 365
      //   87: aload 15
      //   89: astore 8
      //   91: aload 14
      //   93: astore 9
      //   95: aload_1
      //   96: aload 10
      //   98: invokevirtual 92	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
      //   101: checkcast 94	java/net/HttpURLConnection
      //   104: astore 10
      //   106: aload 15
      //   108: astore 8
      //   110: aload 14
      //   112: astore 9
      //   114: aload 10
      //   116: sipush 30000
      //   119: invokevirtual 98	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   122: aload 15
      //   124: astore 8
      //   126: aload 14
      //   128: astore 9
      //   130: aload 10
      //   132: sipush 30000
      //   135: invokevirtual 101	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   138: aload 15
      //   140: astore 8
      //   142: aload 14
      //   144: astore 9
      //   146: aload 10
      //   148: iconst_0
      //   149: invokevirtual 105	java/net/HttpURLConnection:setUseCaches	(Z)V
      //   152: aload 15
      //   154: astore 8
      //   156: aload 14
      //   158: astore 9
      //   160: aload 10
      //   162: iconst_1
      //   163: invokevirtual 108	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
      //   166: aload 15
      //   168: astore 8
      //   170: aload 14
      //   172: astore 9
      //   174: getstatic 113	android/os/Build$VERSION:SDK_INT	I
      //   177: bipush 13
      //   179: if_icmple +20 -> 199
      //   182: aload 15
      //   184: astore 8
      //   186: aload 14
      //   188: astore 9
      //   190: aload 10
      //   192: ldc 115
      //   194: ldc 117
      //   196: invokevirtual 121	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   199: aload 15
      //   201: astore 8
      //   203: aload 14
      //   205: astore 9
      //   207: aload 10
      //   209: ldc 123
      //   211: ldc 38
      //   213: invokevirtual 121	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   216: aload 15
      //   218: astore 8
      //   220: aload 14
      //   222: astore 9
      //   224: aload 10
      //   226: invokevirtual 127	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   229: astore_1
      //   230: aload_0
      //   231: getfield 32	com/ziroom/ziroomcustomer/bestgoods/c/b$a:d	Ljava/io/File;
      //   234: invokevirtual 133	java/io/File:exists	()Z
      //   237: ifne +11 -> 248
      //   240: aload_0
      //   241: getfield 32	com/ziroom/ziroomcustomer/bestgoods/c/b$a:d	Ljava/io/File;
      //   244: invokevirtual 136	java/io/File:createNewFile	()Z
      //   247: pop
      //   248: new 138	java/io/FileOutputStream
      //   251: dup
      //   252: aload_0
      //   253: getfield 32	com/ziroom/ziroomcustomer/bestgoods/c/b$a:d	Ljava/io/File;
      //   256: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   259: astore 8
      //   261: iconst_0
      //   262: istore_2
      //   263: aload_0
      //   264: aload 10
      //   266: invokevirtual 145	java/net/HttpURLConnection:getContentLength	()I
      //   269: putfield 147	com/ziroom/ziroomcustomer/bestgoods/c/b$a:c	I
      //   272: sipush 1024
      //   275: newarray <illegal type>
      //   277: astore 9
      //   279: invokestatic 153	android/os/SystemClock:elapsedRealtime	()J
      //   282: lstore 4
      //   284: aload_0
      //   285: invokevirtual 156	com/ziroom/ziroomcustomer/bestgoods/c/b$a:isCancelled	()Z
      //   288: ifne +141 -> 429
      //   291: aload_1
      //   292: aload 9
      //   294: invokevirtual 162	java/io/InputStream:read	([B)I
      //   297: istore_3
      //   298: iload_3
      //   299: iconst_m1
      //   300: if_icmpeq +129 -> 429
      //   303: aload 8
      //   305: aload 9
      //   307: iconst_0
      //   308: iload_3
      //   309: invokevirtual 168	java/io/OutputStream:write	([BII)V
      //   312: iload_2
      //   313: iload_3
      //   314: iadd
      //   315: istore_2
      //   316: invokestatic 153	android/os/SystemClock:elapsedRealtime	()J
      //   319: lstore 6
      //   321: lload 6
      //   323: lload 4
      //   325: lsub
      //   326: ldc2_w 169
      //   329: lcmp
      //   330: ifle +273 -> 603
      //   333: aload_0
      //   334: iconst_2
      //   335: anewarray 69	java/lang/Integer
      //   338: dup
      //   339: iconst_0
      //   340: aload_0
      //   341: getfield 147	com/ziroom/ziroomcustomer/bestgoods/c/b$a:c	I
      //   344: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   347: aastore
      //   348: dup
      //   349: iconst_1
      //   350: iload_2
      //   351: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   354: aastore
      //   355: invokevirtual 77	com/ziroom/ziroomcustomer/bestgoods/c/b$a:publishProgress	([Ljava/lang/Object;)V
      //   358: lload 6
      //   360: lstore 4
      //   362: goto -78 -> 284
      //   365: aload 15
      //   367: astore 8
      //   369: aload 14
      //   371: astore 9
      //   373: aload_1
      //   374: instanceof 79
      //   377: ifne +33 -> 410
      //   380: aload 15
      //   382: astore 8
      //   384: aload 14
      //   386: astore 9
      //   388: aload_1
      //   389: invokevirtual 173	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   392: astore_1
      //   393: aload 15
      //   395: astore 8
      //   397: aload 14
      //   399: astore 9
      //   401: aload_1
      //   402: checkcast 94	java/net/HttpURLConnection
      //   405: astore 10
      //   407: goto -301 -> 106
      //   410: aload 15
      //   412: astore 8
      //   414: aload 14
      //   416: astore 9
      //   418: aload_1
      //   419: checkcast 79	java/net/URL
      //   422: invokestatic 178	com/mato/sdk/instrumentation/HttpInstrumentation:openConnection	(Ljava/net/URL;)Ljava/net/URLConnection;
      //   425: astore_1
      //   426: goto -33 -> 393
      //   429: aload 10
      //   431: invokevirtual 181	java/net/HttpURLConnection:disconnect	()V
      //   434: aload_1
      //   435: ifnull +7 -> 442
      //   438: aload_1
      //   439: invokevirtual 183	java/io/InputStream:close	()V
      //   442: aload 8
      //   444: ifnull +8 -> 452
      //   447: aload 8
      //   449: invokevirtual 184	java/io/OutputStream:close	()V
      //   452: iconst_1
      //   453: invokestatic 189	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   456: astore_1
      //   457: aload_1
      //   458: areturn
      //   459: astore_1
      //   460: aload_1
      //   461: invokevirtual 192	java/lang/Exception:printStackTrace	()V
      //   464: goto -12 -> 452
      //   467: astore 11
      //   469: aload 13
      //   471: astore_1
      //   472: aload 12
      //   474: astore 10
      //   476: aload 10
      //   478: astore 8
      //   480: aload_1
      //   481: astore 9
      //   483: aload 11
      //   485: invokevirtual 192	java/lang/Exception:printStackTrace	()V
      //   488: iconst_0
      //   489: invokestatic 189	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   492: astore 8
      //   494: aload_1
      //   495: ifnull +7 -> 502
      //   498: aload_1
      //   499: invokevirtual 183	java/io/InputStream:close	()V
      //   502: aload 8
      //   504: astore_1
      //   505: aload 10
      //   507: ifnull -50 -> 457
      //   510: aload 10
      //   512: invokevirtual 184	java/io/OutputStream:close	()V
      //   515: aload 8
      //   517: areturn
      //   518: astore_1
      //   519: aload_1
      //   520: invokevirtual 192	java/lang/Exception:printStackTrace	()V
      //   523: aload 8
      //   525: areturn
      //   526: astore_1
      //   527: aload 9
      //   529: ifnull +8 -> 537
      //   532: aload 9
      //   534: invokevirtual 183	java/io/InputStream:close	()V
      //   537: aload 8
      //   539: ifnull +8 -> 547
      //   542: aload 8
      //   544: invokevirtual 184	java/io/OutputStream:close	()V
      //   547: aload_1
      //   548: athrow
      //   549: astore 8
      //   551: aload 8
      //   553: invokevirtual 192	java/lang/Exception:printStackTrace	()V
      //   556: goto -9 -> 547
      //   559: astore 8
      //   561: aload_1
      //   562: astore 9
      //   564: aload 8
      //   566: astore_1
      //   567: aload 11
      //   569: astore 8
      //   571: goto -44 -> 527
      //   574: astore 10
      //   576: aload_1
      //   577: astore 9
      //   579: aload 10
      //   581: astore_1
      //   582: goto -55 -> 527
      //   585: astore 11
      //   587: aload 12
      //   589: astore 10
      //   591: goto -115 -> 476
      //   594: astore 11
      //   596: aload 8
      //   598: astore 10
      //   600: goto -124 -> 476
      //   603: goto -241 -> 362
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	606	0	this	a
      //   0	606	1	paramVarArgs	String[]
      //   262	89	2	i	int
      //   297	18	3	j	int
      //   282	79	4	l1	long
      //   319	40	6	l2	long
      //   17	526	8	localObject1	Object
      //   549	3	8	localException1	Exception
      //   559	6	8	localObject2	Object
      //   569	28	8	localException2	Exception
      //   21	557	9	localObject3	Object
      //   80	431	10	localObject4	Object
      //   574	6	10	localObject5	Object
      //   589	10	10	localObject6	Object
      //   10	1	11	localObject7	Object
      //   467	101	11	localException3	Exception
      //   585	1	11	localException4	Exception
      //   594	1	11	localException5	Exception
      //   13	575	12	localObject8	Object
      //   4	466	13	localObject9	Object
      //   1	414	14	localObject10	Object
      //   7	404	15	localObject11	Object
      // Exception table:
      //   from	to	target	type
      //   438	442	459	java/lang/Exception
      //   447	452	459	java/lang/Exception
      //   23	45	467	java/lang/Exception
      //   53	65	467	java/lang/Exception
      //   73	82	467	java/lang/Exception
      //   95	106	467	java/lang/Exception
      //   114	122	467	java/lang/Exception
      //   130	138	467	java/lang/Exception
      //   146	152	467	java/lang/Exception
      //   160	166	467	java/lang/Exception
      //   174	182	467	java/lang/Exception
      //   190	199	467	java/lang/Exception
      //   207	216	467	java/lang/Exception
      //   224	230	467	java/lang/Exception
      //   373	380	467	java/lang/Exception
      //   388	393	467	java/lang/Exception
      //   401	407	467	java/lang/Exception
      //   418	426	467	java/lang/Exception
      //   498	502	518	java/lang/Exception
      //   510	515	518	java/lang/Exception
      //   23	45	526	finally
      //   53	65	526	finally
      //   73	82	526	finally
      //   95	106	526	finally
      //   114	122	526	finally
      //   130	138	526	finally
      //   146	152	526	finally
      //   160	166	526	finally
      //   174	182	526	finally
      //   190	199	526	finally
      //   207	216	526	finally
      //   224	230	526	finally
      //   373	380	526	finally
      //   388	393	526	finally
      //   401	407	526	finally
      //   418	426	526	finally
      //   483	488	526	finally
      //   532	537	549	java/lang/Exception
      //   542	547	549	java/lang/Exception
      //   230	248	559	finally
      //   248	261	559	finally
      //   263	284	574	finally
      //   284	298	574	finally
      //   303	312	574	finally
      //   316	321	574	finally
      //   333	358	574	finally
      //   429	434	574	finally
      //   230	248	585	java/lang/Exception
      //   248	261	585	java/lang/Exception
      //   263	284	594	java/lang/Exception
      //   284	298	594	java/lang/Exception
      //   303	312	594	java/lang/Exception
      //   316	321	594	java/lang/Exception
      //   333	358	594	java/lang/Exception
      //   429	434	594	java/lang/Exception
    }
    
    protected void a(Boolean paramBoolean)
    {
      b.a().remove(this.d.getAbsolutePath());
      LodingProgressDialog.dismiss();
      if (!isCancelled()) {}
      try
      {
        if (this.e != null) {
          this.e.callback(paramBoolean);
        }
        return;
      }
      catch (Exception paramBoolean) {}
    }
    
    protected void a(Integer... paramVarArgs) {}
    
    protected void onCancelled()
    {
      super.onCancelled();
      b.a().remove(this.d.getAbsolutePath());
      LodingProgressDialog.dismiss();
    }
    
    public class a
      extends TimerTask
    {
      public a() {}
      
      public void run()
      {
        if (LodingProgressDialog.getDialog() != null) {
          LodingProgressDialog.dismiss();
        }
        if (b.a.a(b.a.this) != null) {
          g.textToast(b.a.b(b.a.this), "网络超时");
        }
        b.a.a(b.a.this, null);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */