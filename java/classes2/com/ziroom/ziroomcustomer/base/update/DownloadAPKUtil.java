package com.ziroom.ziroomcustomer.base.update;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import com.maa.android.agent.instrumentation.Instrumented;
import java.io.File;
import java.lang.ref.WeakReference;

public class DownloadAPKUtil
{
  private static ArrayMap<String, WeakReference<a>> taskMap = new ArrayMap();
  
  @TargetApi(11)
  public static void download(Context paramContext, File paramFile, String paramString, Callback<Boolean> paramCallback)
  {
    if (taskMap.containsKey(paramFile.getAbsolutePath()))
    {
      a locala = (a)((WeakReference)taskMap.remove(paramFile.getAbsolutePath())).get();
      if (locala != null) {
        locala.cancel(true);
      }
    }
    paramContext = new a(paramContext, paramFile, paramString, paramCallback, null);
    if (Build.VERSION.SDK_INT >= 11) {
      paramContext.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }
    for (;;)
    {
      taskMap.put(paramFile.getAbsolutePath(), new WeakReference(paramContext));
      return;
      paramContext.execute(new String[0]);
    }
  }
  
  @Instrumented
  private static class a
    extends AsyncTask<String, Integer, Boolean>
  {
    private String a;
    private int b;
    private File c;
    private Callback<Boolean> d;
    private ProgressDialog e;
    
    private a(Context paramContext, File paramFile, String paramString, Callback<Boolean> paramCallback)
    {
      this.c = paramFile;
      this.a = paramString;
      this.d = paramCallback;
      this.e = ProgressDialog.showHorizontal(paramContext, "正在下载", true, false, null);
      this.e.setMax(100);
    }
    
    /* Error */
    protected Boolean a(String... paramVarArgs)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 8
      //   3: aconst_null
      //   4: astore 10
      //   6: aconst_null
      //   7: astore 9
      //   9: new 55	java/net/URL
      //   12: dup
      //   13: aload_0
      //   14: getfield 28	com/ziroom/ziroomcustomer/base/update/DownloadAPKUtil$a:a	Ljava/lang/String;
      //   17: invokespecial 58	java/net/URL:<init>	(Ljava/lang/String;)V
      //   20: astore_1
      //   21: aload_1
      //   22: instanceof 55
      //   25: ifne +209 -> 234
      //   28: aload_1
      //   29: invokevirtual 62	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   32: astore_1
      //   33: aload_1
      //   34: checkcast 64	java/net/HttpURLConnection
      //   37: astore 11
      //   39: aload 11
      //   41: sipush 30000
      //   44: invokevirtual 67	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   47: aload 11
      //   49: sipush 30000
      //   52: invokevirtual 70	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   55: aload 11
      //   57: iconst_0
      //   58: invokevirtual 74	java/net/HttpURLConnection:setUseCaches	(Z)V
      //   61: aload 11
      //   63: iconst_1
      //   64: invokevirtual 77	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
      //   67: getstatic 82	android/os/Build$VERSION:SDK_INT	I
      //   70: bipush 13
      //   72: if_icmple +12 -> 84
      //   75: aload 11
      //   77: ldc 84
      //   79: ldc 86
      //   81: invokevirtual 90	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   84: aload 11
      //   86: ldc 92
      //   88: ldc 94
      //   90: invokevirtual 90	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   93: aload 11
      //   95: invokevirtual 98	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   98: astore_1
      //   99: aload_0
      //   100: getfield 26	com/ziroom/ziroomcustomer/base/update/DownloadAPKUtil$a:c	Ljava/io/File;
      //   103: invokevirtual 104	java/io/File:exists	()Z
      //   106: ifne +11 -> 117
      //   109: aload_0
      //   110: getfield 26	com/ziroom/ziroomcustomer/base/update/DownloadAPKUtil$a:c	Ljava/io/File;
      //   113: invokevirtual 107	java/io/File:createNewFile	()Z
      //   116: pop
      //   117: new 109	java/io/FileOutputStream
      //   120: dup
      //   121: aload_0
      //   122: getfield 26	com/ziroom/ziroomcustomer/base/update/DownloadAPKUtil$a:c	Ljava/io/File;
      //   125: invokespecial 112	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   128: astore 8
      //   130: iconst_0
      //   131: istore_2
      //   132: aload_0
      //   133: aload 11
      //   135: invokevirtual 116	java/net/HttpURLConnection:getContentLength	()I
      //   138: putfield 118	com/ziroom/ziroomcustomer/base/update/DownloadAPKUtil$a:b	I
      //   141: sipush 1024
      //   144: newarray <illegal type>
      //   146: astore 9
      //   148: invokestatic 124	android/os/SystemClock:elapsedRealtime	()J
      //   151: lstore 4
      //   153: aload_0
      //   154: invokevirtual 127	com/ziroom/ziroomcustomer/base/update/DownloadAPKUtil$a:isCancelled	()Z
      //   157: ifne +88 -> 245
      //   160: aload_1
      //   161: aload 9
      //   163: invokevirtual 133	java/io/InputStream:read	([B)I
      //   166: istore_3
      //   167: iload_3
      //   168: iconst_m1
      //   169: if_icmpeq +76 -> 245
      //   172: aload 8
      //   174: aload 9
      //   176: iconst_0
      //   177: iload_3
      //   178: invokevirtual 139	java/io/OutputStream:write	([BII)V
      //   181: iload_2
      //   182: iload_3
      //   183: iadd
      //   184: istore_2
      //   185: invokestatic 124	android/os/SystemClock:elapsedRealtime	()J
      //   188: lstore 6
      //   190: lload 6
      //   192: lload 4
      //   194: lsub
      //   195: ldc2_w 140
      //   198: lcmp
      //   199: ifle +218 -> 417
      //   202: aload_0
      //   203: iconst_2
      //   204: anewarray 143	java/lang/Integer
      //   207: dup
      //   208: iconst_0
      //   209: aload_0
      //   210: getfield 118	com/ziroom/ziroomcustomer/base/update/DownloadAPKUtil$a:b	I
      //   213: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   216: aastore
      //   217: dup
      //   218: iconst_1
      //   219: iload_2
      //   220: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   223: aastore
      //   224: invokevirtual 151	com/ziroom/ziroomcustomer/base/update/DownloadAPKUtil$a:publishProgress	([Ljava/lang/Object;)V
      //   227: lload 6
      //   229: lstore 4
      //   231: goto -78 -> 153
      //   234: aload_1
      //   235: checkcast 55	java/net/URL
      //   238: invokestatic 156	com/mato/sdk/instrumentation/HttpInstrumentation:openConnection	(Ljava/net/URL;)Ljava/net/URLConnection;
      //   241: astore_1
      //   242: goto -209 -> 33
      //   245: aload 11
      //   247: invokevirtual 159	java/net/HttpURLConnection:disconnect	()V
      //   250: aload_1
      //   251: ifnull +7 -> 258
      //   254: aload_1
      //   255: invokevirtual 161	java/io/InputStream:close	()V
      //   258: aload 8
      //   260: ifnull +8 -> 268
      //   263: aload 8
      //   265: invokevirtual 162	java/io/OutputStream:close	()V
      //   268: iconst_1
      //   269: invokestatic 167	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   272: astore_1
      //   273: aload_1
      //   274: areturn
      //   275: astore_1
      //   276: aload_1
      //   277: invokevirtual 170	java/lang/Exception:printStackTrace	()V
      //   280: goto -12 -> 268
      //   283: astore 10
      //   285: aload 8
      //   287: astore_1
      //   288: aload 10
      //   290: astore 8
      //   292: aload 8
      //   294: invokevirtual 170	java/lang/Exception:printStackTrace	()V
      //   297: iconst_0
      //   298: invokestatic 167	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   301: astore 8
      //   303: aload_1
      //   304: ifnull +7 -> 311
      //   307: aload_1
      //   308: invokevirtual 161	java/io/InputStream:close	()V
      //   311: aload 8
      //   313: astore_1
      //   314: aload 9
      //   316: ifnull -43 -> 273
      //   319: aload 9
      //   321: invokevirtual 162	java/io/OutputStream:close	()V
      //   324: aload 8
      //   326: areturn
      //   327: astore_1
      //   328: aload_1
      //   329: invokevirtual 170	java/lang/Exception:printStackTrace	()V
      //   332: aload 8
      //   334: areturn
      //   335: astore 8
      //   337: aconst_null
      //   338: astore_1
      //   339: aload 10
      //   341: astore 9
      //   343: aload_1
      //   344: ifnull +7 -> 351
      //   347: aload_1
      //   348: invokevirtual 161	java/io/InputStream:close	()V
      //   351: aload 9
      //   353: ifnull +8 -> 361
      //   356: aload 9
      //   358: invokevirtual 162	java/io/OutputStream:close	()V
      //   361: aload 8
      //   363: athrow
      //   364: astore_1
      //   365: aload_1
      //   366: invokevirtual 170	java/lang/Exception:printStackTrace	()V
      //   369: goto -8 -> 361
      //   372: astore 8
      //   374: aload 10
      //   376: astore 9
      //   378: goto -35 -> 343
      //   381: astore 10
      //   383: aload 8
      //   385: astore 9
      //   387: aload 10
      //   389: astore 8
      //   391: goto -48 -> 343
      //   394: astore 8
      //   396: goto -53 -> 343
      //   399: astore 8
      //   401: goto -109 -> 292
      //   404: astore 10
      //   406: aload 8
      //   408: astore 9
      //   410: aload 10
      //   412: astore 8
      //   414: goto -122 -> 292
      //   417: goto -186 -> 231
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	420	0	this	a
      //   0	420	1	paramVarArgs	String[]
      //   131	89	2	i	int
      //   166	18	3	j	int
      //   151	79	4	l1	long
      //   188	40	6	l2	long
      //   1	332	8	localObject1	Object
      //   335	27	8	localObject2	Object
      //   372	12	8	localObject3	Object
      //   389	1	8	localObject4	Object
      //   394	1	8	localObject5	Object
      //   399	8	8	localException1	Exception
      //   412	1	8	localObject6	Object
      //   7	402	9	localObject7	Object
      //   4	1	10	localObject8	Object
      //   283	92	10	localException2	Exception
      //   381	7	10	localObject9	Object
      //   404	7	10	localException3	Exception
      //   37	209	11	localHttpURLConnection	java.net.HttpURLConnection
      // Exception table:
      //   from	to	target	type
      //   254	258	275	java/lang/Exception
      //   263	268	275	java/lang/Exception
      //   9	33	283	java/lang/Exception
      //   33	84	283	java/lang/Exception
      //   84	99	283	java/lang/Exception
      //   234	242	283	java/lang/Exception
      //   307	311	327	java/lang/Exception
      //   319	324	327	java/lang/Exception
      //   9	33	335	finally
      //   33	84	335	finally
      //   84	99	335	finally
      //   234	242	335	finally
      //   347	351	364	java/lang/Exception
      //   356	361	364	java/lang/Exception
      //   99	117	372	finally
      //   117	130	372	finally
      //   132	153	381	finally
      //   153	167	381	finally
      //   172	181	381	finally
      //   185	190	381	finally
      //   202	227	381	finally
      //   245	250	381	finally
      //   292	297	394	finally
      //   99	117	399	java/lang/Exception
      //   117	130	399	java/lang/Exception
      //   132	153	404	java/lang/Exception
      //   153	167	404	java/lang/Exception
      //   172	181	404	java/lang/Exception
      //   185	190	404	java/lang/Exception
      //   202	227	404	java/lang/Exception
      //   245	250	404	java/lang/Exception
    }
    
    protected void a(Boolean paramBoolean)
    {
      DownloadAPKUtil.taskMap.remove(this.c.getAbsolutePath());
      this.e.dismiss();
      if ((!isCancelled()) && (this.d != null)) {
        this.d.callback(paramBoolean);
      }
    }
    
    protected void a(Integer... paramVarArgs)
    {
      boolean bool = true;
      int i = paramVarArgs[0].intValue();
      int j = paramVarArgs[1].intValue();
      paramVarArgs = this.e;
      if (i < 0) {}
      for (;;)
      {
        paramVarArgs.setIndeterminate(bool);
        if (i > 0) {
          this.e.setProgress((int)(j / i * 100.0F));
        }
        return;
        bool = false;
      }
    }
    
    protected void onCancelled()
    {
      super.onCancelled();
      DownloadAPKUtil.taskMap.remove(this.c.getAbsolutePath());
      this.e.dismiss();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/base/update/DownloadAPKUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */