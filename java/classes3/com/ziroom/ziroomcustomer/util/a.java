package com.ziroom.ziroomcustomer.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.maa.android.agent.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.a.b;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.Advertisement;
import java.util.List;

@Instrumented
public class a
{
  private Context a = ApplicationEx.c;
  
  private void a(final Advertisement paramAdvertisement)
  {
    String str = ad.getAdvertisement(this.a).getPic();
    ad.saveAdvertisement(this.a, paramAdvertisement);
    if ((this.a.getSharedPreferences("welcome_advertisement", 0).getBoolean("isPicPrepared", false)) && (str != null) && (str.equals(paramAdvertisement.getPic()))) {
      return;
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        a.a(a.this, paramAdvertisement.getPic());
      }
    }).start();
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: getfield 23	com/ziroom/ziroomcustomer/util/a:a	Landroid/content/Context;
    //   10: ldc 44
    //   12: iconst_0
    //   13: invokevirtual 50	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   16: astore 6
    //   18: aload 6
    //   20: invokeinterface 87 1 0
    //   25: astore 7
    //   27: aload 7
    //   29: ldc 52
    //   31: iconst_0
    //   32: invokeinterface 93 3 0
    //   37: pop
    //   38: aload 7
    //   40: invokeinterface 96 1 0
    //   45: new 98	java/net/URL
    //   48: dup
    //   49: aload_1
    //   50: invokespecial 100	java/net/URL:<init>	(Ljava/lang/String;)V
    //   53: astore_1
    //   54: ldc 102
    //   56: ldc 104
    //   58: invokestatic 110	com/ziroom/ziroomcustomer/util/u:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_1
    //   62: instanceof 98
    //   65: ifne +384 -> 449
    //   68: aload_1
    //   69: invokevirtual 114	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   72: astore_1
    //   73: aload_1
    //   74: checkcast 116	java/net/HttpURLConnection
    //   77: astore_1
    //   78: aload_1
    //   79: sipush 10000
    //   82: invokevirtual 120	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   85: aload_1
    //   86: ldc 122
    //   88: invokevirtual 125	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   91: ldc 102
    //   93: new 127	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   100: ldc -126
    //   102: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_1
    //   106: invokevirtual 138	java/net/HttpURLConnection:getResponseCode	()I
    //   109: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 110	com/ziroom/ziroomcustomer/util/u:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_1
    //   119: invokevirtual 138	java/net/HttpURLConnection:getResponseCode	()I
    //   122: sipush 200
    //   125: if_icmpne +553 -> 678
    //   128: ldc 102
    //   130: ldc -110
    //   132: invokestatic 110	com/ziroom/ziroomcustomer/util/u:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_1
    //   136: invokevirtual 150	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   139: astore_1
    //   140: ldc 102
    //   142: new 127	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   149: ldc -104
    //   151: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_0
    //   155: getfield 23	com/ziroom/ziroomcustomer/util/a:a	Landroid/content/Context;
    //   158: invokevirtual 156	android/content/Context:getFilesDir	()Ljava/io/File;
    //   161: invokevirtual 161	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   164: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 110	com/ziroom/ziroomcustomer/util/u:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: new 158	java/io/File
    //   176: dup
    //   177: aload_0
    //   178: getfield 23	com/ziroom/ziroomcustomer/util/a:a	Landroid/content/Context;
    //   181: invokevirtual 156	android/content/Context:getFilesDir	()Ljava/io/File;
    //   184: invokevirtual 161	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   187: ldc -93
    //   189: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: astore_3
    //   193: ldc 102
    //   195: new 127	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   202: ldc -89
    //   204: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_3
    //   208: invokevirtual 161	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   211: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 110	com/ziroom/ziroomcustomer/util/u:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: new 169	java/io/FileOutputStream
    //   223: dup
    //   224: aload_3
    //   225: invokespecial 172	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   228: astore_3
    //   229: sipush 1024
    //   232: newarray <illegal type>
    //   234: astore 4
    //   236: aload_1
    //   237: aload 4
    //   239: invokevirtual 178	java/io/InputStream:read	([B)I
    //   242: istore_2
    //   243: iload_2
    //   244: iconst_m1
    //   245: if_icmpeq +215 -> 460
    //   248: aload_3
    //   249: aload 4
    //   251: iconst_0
    //   252: iload_2
    //   253: invokevirtual 182	java/io/FileOutputStream:write	([BII)V
    //   256: goto -20 -> 236
    //   259: astore 5
    //   261: aload_3
    //   262: astore 4
    //   264: aload 5
    //   266: astore_3
    //   267: ldc 102
    //   269: ldc -72
    //   271: invokestatic 110	com/ziroom/ziroomcustomer/util/u:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: ldc 102
    //   276: aload_3
    //   277: invokevirtual 187	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   280: invokestatic 110	com/ziroom/ziroomcustomer/util/u:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: ldc 102
    //   285: aload_3
    //   286: invokevirtual 191	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   289: invokevirtual 192	java/lang/Object:toString	()Ljava/lang/String;
    //   292: invokestatic 110	com/ziroom/ziroomcustomer/util/u:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: new 194	java/lang/Throwable
    //   298: dup
    //   299: invokespecial 195	java/lang/Throwable:<init>	()V
    //   302: invokevirtual 196	java/lang/Throwable:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   305: astore 5
    //   307: new 198	java/lang/StringBuffer
    //   310: dup
    //   311: invokespecial 199	java/lang/StringBuffer:<init>	()V
    //   314: astore 6
    //   316: aload 6
    //   318: new 127	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   325: ldc -55
    //   327: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_3
    //   331: invokevirtual 205	java/lang/Object:getClass	()Ljava/lang/Class;
    //   334: invokevirtual 210	java/lang/Class:getName	()Ljava/lang/String;
    //   337: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: ldc -44
    //   342: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokevirtual 215	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   351: pop
    //   352: iconst_0
    //   353: istore_2
    //   354: iload_2
    //   355: aload 5
    //   357: arraylength
    //   358: if_icmpge +169 -> 527
    //   361: aload 6
    //   363: new 127	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   370: ldc -39
    //   372: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload 5
    //   377: iload_2
    //   378: aaload
    //   379: invokevirtual 222	java/lang/StackTraceElement:getClassName	()Ljava/lang/String;
    //   382: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: ldc -32
    //   387: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload 5
    //   392: iload_2
    //   393: aaload
    //   394: invokevirtual 227	java/lang/StackTraceElement:getMethodName	()Ljava/lang/String;
    //   397: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: ldc -27
    //   402: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload 5
    //   407: iload_2
    //   408: aaload
    //   409: invokevirtual 232	java/lang/StackTraceElement:getFileName	()Ljava/lang/String;
    //   412: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: ldc -44
    //   417: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload 5
    //   422: iload_2
    //   423: aaload
    //   424: invokevirtual 235	java/lang/StackTraceElement:getLineNumber	()I
    //   427: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   430: ldc -19
    //   432: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokevirtual 215	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   441: pop
    //   442: iload_2
    //   443: iconst_1
    //   444: iadd
    //   445: istore_2
    //   446: goto -92 -> 354
    //   449: aload_1
    //   450: checkcast 98	java/net/URL
    //   453: invokestatic 242	com/mato/sdk/instrumentation/HttpInstrumentation:openConnection	(Ljava/net/URL;)Ljava/net/URLConnection;
    //   456: astore_1
    //   457: goto -384 -> 73
    //   460: aload_3
    //   461: invokevirtual 245	java/io/FileOutputStream:flush	()V
    //   464: ldc 102
    //   466: ldc -9
    //   468: invokestatic 110	com/ziroom/ziroomcustomer/util/u:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: aload 6
    //   473: invokeinterface 87 1 0
    //   478: pop
    //   479: aload 7
    //   481: ldc 52
    //   483: iconst_1
    //   484: invokeinterface 93 3 0
    //   489: pop
    //   490: aload 7
    //   492: invokeinterface 96 1 0
    //   497: aload_1
    //   498: ifnull +7 -> 505
    //   501: aload_1
    //   502: invokevirtual 250	java/io/InputStream:close	()V
    //   505: aload_3
    //   506: ifnull +7 -> 513
    //   509: aload_3
    //   510: invokevirtual 251	java/io/FileOutputStream:close	()V
    //   513: return
    //   514: astore_1
    //   515: ldc 102
    //   517: ldc -3
    //   519: invokestatic 110	com/ziroom/ziroomcustomer/util/u:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   522: aload_1
    //   523: invokevirtual 256	java/lang/Exception:printStackTrace	()V
    //   526: return
    //   527: getstatic 262	java/lang/System:out	Ljava/io/PrintStream;
    //   530: aload 6
    //   532: invokevirtual 263	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   535: invokevirtual 268	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   538: ldc 102
    //   540: new 127	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   547: ldc_w 270
    //   550: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: aload 6
    //   555: invokevirtual 263	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   558: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 110	com/ziroom/ziroomcustomer/util/u:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   567: aload_3
    //   568: invokevirtual 256	java/lang/Exception:printStackTrace	()V
    //   571: aload_1
    //   572: ifnull +7 -> 579
    //   575: aload_1
    //   576: invokevirtual 250	java/io/InputStream:close	()V
    //   579: aload 4
    //   581: ifnull -68 -> 513
    //   584: aload 4
    //   586: invokevirtual 251	java/io/FileOutputStream:close	()V
    //   589: return
    //   590: astore_1
    //   591: ldc 102
    //   593: ldc -3
    //   595: invokestatic 110	com/ziroom/ziroomcustomer/util/u:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   598: aload_1
    //   599: invokevirtual 256	java/lang/Exception:printStackTrace	()V
    //   602: return
    //   603: astore_3
    //   604: aconst_null
    //   605: astore_1
    //   606: aload_1
    //   607: ifnull +7 -> 614
    //   610: aload_1
    //   611: invokevirtual 250	java/io/InputStream:close	()V
    //   614: aload 4
    //   616: ifnull +8 -> 624
    //   619: aload 4
    //   621: invokevirtual 251	java/io/FileOutputStream:close	()V
    //   624: aload_3
    //   625: athrow
    //   626: astore_1
    //   627: ldc 102
    //   629: ldc -3
    //   631: invokestatic 110	com/ziroom/ziroomcustomer/util/u:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   634: aload_1
    //   635: invokevirtual 256	java/lang/Exception:printStackTrace	()V
    //   638: goto -14 -> 624
    //   641: astore_3
    //   642: goto -36 -> 606
    //   645: astore 5
    //   647: aload_3
    //   648: astore 4
    //   650: aload 5
    //   652: astore_3
    //   653: goto -47 -> 606
    //   656: astore_3
    //   657: goto -51 -> 606
    //   660: astore_3
    //   661: aconst_null
    //   662: astore_1
    //   663: aload 5
    //   665: astore 4
    //   667: goto -400 -> 267
    //   670: astore_3
    //   671: aload 5
    //   673: astore 4
    //   675: goto -408 -> 267
    //   678: aconst_null
    //   679: astore_3
    //   680: aconst_null
    //   681: astore_1
    //   682: goto -185 -> 497
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	685	0	this	a
    //   0	685	1	paramString	String
    //   242	204	2	i	int
    //   192	376	3	localObject1	Object
    //   603	22	3	localObject2	Object
    //   641	7	3	localObject3	Object
    //   652	1	3	localObject4	Object
    //   656	1	3	localObject5	Object
    //   660	1	3	localException1	Exception
    //   670	1	3	localException2	Exception
    //   679	1	3	localObject6	Object
    //   1	673	4	localObject7	Object
    //   4	1	5	localObject8	Object
    //   259	6	5	localException3	Exception
    //   305	116	5	arrayOfStackTraceElement	StackTraceElement[]
    //   645	27	5	localObject9	Object
    //   16	538	6	localObject10	Object
    //   25	466	7	localEditor	android.content.SharedPreferences.Editor
    // Exception table:
    //   from	to	target	type
    //   229	236	259	java/lang/Exception
    //   236	243	259	java/lang/Exception
    //   248	256	259	java/lang/Exception
    //   460	497	259	java/lang/Exception
    //   501	505	514	java/lang/Exception
    //   509	513	514	java/lang/Exception
    //   575	579	590	java/lang/Exception
    //   584	589	590	java/lang/Exception
    //   6	73	603	finally
    //   73	140	603	finally
    //   449	457	603	finally
    //   610	614	626	java/lang/Exception
    //   619	624	626	java/lang/Exception
    //   140	229	641	finally
    //   229	236	645	finally
    //   236	243	645	finally
    //   248	256	645	finally
    //   460	497	645	finally
    //   267	352	656	finally
    //   354	442	656	finally
    //   527	571	656	finally
    //   6	73	660	java/lang/Exception
    //   73	140	660	java/lang/Exception
    //   449	457	660	java/lang/Exception
    //   140	229	670	java/lang/Exception
  }
  
  public void getAdvertisement()
  {
    j.getAd(this.a, "app_start_ads", new b(this.a, new e(Advertisement.class))
    {
      public void onSuccess(int paramAnonymousInt, List<Advertisement> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if ((paramAnonymousList == null) || (paramAnonymousList.size() < 4)) {
          return;
        }
        if (ac.getScreenHeight(a.a(a.this)) < 1500) {}
        for (paramAnonymousList = (Advertisement)paramAnonymousList.get(2);; paramAnonymousList = (Advertisement)paramAnonymousList.get(3))
        {
          a.a(a.this, paramAnonymousList);
          return;
        }
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */