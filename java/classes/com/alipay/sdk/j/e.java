package com.alipay.sdk.j;

import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.a.a;

public class e
{
  public Activity a;
  private IAlixPay b;
  private final Object c = IAlixPay.class;
  private boolean d;
  private a e;
  private ServiceConnection f = new f(this);
  private IRemoteServiceCallback g = new g(this);
  
  public e(Activity paramActivity, a parama)
  {
    this.a = paramActivity;
    this.e = parama;
  }
  
  /* Error */
  private String b(String paramString)
  {
    // Byte code:
    //   0: new 58	android/content/Intent
    //   3: dup
    //   4: invokespecial 59	android/content/Intent:<init>	()V
    //   7: astore_3
    //   8: invokestatic 64	com/alipay/sdk/j/k:a	()Ljava/lang/String;
    //   11: astore_2
    //   12: aload_3
    //   13: aload_2
    //   14: invokevirtual 68	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   17: pop
    //   18: aload_3
    //   19: new 70	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   26: aload_2
    //   27: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 77
    //   32: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokevirtual 83	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   41: pop
    //   42: aload_0
    //   43: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   46: invokestatic 87	com/alipay/sdk/j/k:h	(Landroid/content/Context;)Ljava/lang/String;
    //   49: astore_2
    //   50: aload_0
    //   51: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   54: invokevirtual 93	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   57: aload_3
    //   58: aload_0
    //   59: getfield 36	com/alipay/sdk/j/e:f	Landroid/content/ServiceConnection;
    //   62: iconst_1
    //   63: invokevirtual 99	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   66: ifne +27 -> 93
    //   69: new 54	java/lang/Throwable
    //   72: dup
    //   73: ldc 101
    //   75: invokespecial 104	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   78: athrow
    //   79: astore_1
    //   80: ldc 106
    //   82: ldc 108
    //   84: aload_1
    //   85: invokestatic 113	com/alipay/sdk/app/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   88: ldc 115
    //   90: astore_1
    //   91: aload_1
    //   92: areturn
    //   93: aload_0
    //   94: getfield 29	com/alipay/sdk/j/e:c	Ljava/lang/Object;
    //   97: astore_3
    //   98: aload_3
    //   99: monitorenter
    //   100: aload_0
    //   101: getfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   104: astore 4
    //   106: aload 4
    //   108: ifnonnull +17 -> 125
    //   111: aload_0
    //   112: getfield 29	com/alipay/sdk/j/e:c	Ljava/lang/Object;
    //   115: invokestatic 120	com/alipay/sdk/c/a:b	()Lcom/alipay/sdk/c/a;
    //   118: invokevirtual 123	com/alipay/sdk/c/a:a	()I
    //   121: i2l
    //   122: invokevirtual 127	java/lang/Object:wait	(J)V
    //   125: aload_3
    //   126: monitorexit
    //   127: aload_0
    //   128: getfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   131: ifnonnull +161 -> 292
    //   134: aload_0
    //   135: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   138: invokestatic 87	com/alipay/sdk/j/k:h	(Landroid/content/Context;)Ljava/lang/String;
    //   141: astore_1
    //   142: aload_0
    //   143: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   146: invokestatic 130	com/alipay/sdk/j/k:i	(Landroid/content/Context;)Ljava/lang/String;
    //   149: astore_3
    //   150: ldc 106
    //   152: ldc -124
    //   154: new 70	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   161: aload_2
    //   162: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc -122
    //   167: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_1
    //   171: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc -122
    //   176: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_3
    //   180: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 137	com/alipay/sdk/app/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   189: ldc 115
    //   191: astore_2
    //   192: aload_0
    //   193: getfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   196: aload_0
    //   197: getfield 41	com/alipay/sdk/j/e:g	Lcom/alipay/android/app/IRemoteServiceCallback;
    //   200: invokeinterface 141 2 0
    //   205: aload_0
    //   206: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   209: invokevirtual 93	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   212: aload_0
    //   213: getfield 36	com/alipay/sdk/j/e:f	Landroid/content/ServiceConnection;
    //   216: invokevirtual 145	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   219: aload_0
    //   220: aconst_null
    //   221: putfield 45	com/alipay/sdk/j/e:e	Lcom/alipay/sdk/j/e$a;
    //   224: aload_0
    //   225: aconst_null
    //   226: putfield 41	com/alipay/sdk/j/e:g	Lcom/alipay/android/app/IRemoteServiceCallback;
    //   229: aload_0
    //   230: aconst_null
    //   231: putfield 36	com/alipay/sdk/j/e:f	Landroid/content/ServiceConnection;
    //   234: aload_0
    //   235: aconst_null
    //   236: putfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   239: aload_2
    //   240: astore_1
    //   241: aload_0
    //   242: getfield 147	com/alipay/sdk/j/e:d	Z
    //   245: ifeq -154 -> 91
    //   248: aload_2
    //   249: astore_1
    //   250: aload_0
    //   251: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   254: ifnull -163 -> 91
    //   257: aload_0
    //   258: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   261: iconst_0
    //   262: invokevirtual 151	android/app/Activity:setRequestedOrientation	(I)V
    //   265: aload_0
    //   266: iconst_0
    //   267: putfield 147	com/alipay/sdk/j/e:d	Z
    //   270: ldc 115
    //   272: areturn
    //   273: astore 4
    //   275: ldc 106
    //   277: ldc -103
    //   279: aload 4
    //   281: invokestatic 113	com/alipay/sdk/app/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   284: goto -159 -> 125
    //   287: astore_1
    //   288: aload_3
    //   289: monitorexit
    //   290: aload_1
    //   291: athrow
    //   292: aload_0
    //   293: getfield 45	com/alipay/sdk/j/e:e	Lcom/alipay/sdk/j/e$a;
    //   296: ifnull +12 -> 308
    //   299: aload_0
    //   300: getfield 45	com/alipay/sdk/j/e:e	Lcom/alipay/sdk/j/e$a;
    //   303: invokeinterface 155 1 0
    //   308: aload_0
    //   309: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   312: invokevirtual 158	android/app/Activity:getRequestedOrientation	()I
    //   315: ifne +16 -> 331
    //   318: aload_0
    //   319: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   322: iconst_1
    //   323: invokevirtual 151	android/app/Activity:setRequestedOrientation	(I)V
    //   326: aload_0
    //   327: iconst_1
    //   328: putfield 147	com/alipay/sdk/j/e:d	Z
    //   331: aload_0
    //   332: getfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   335: aload_0
    //   336: getfield 41	com/alipay/sdk/j/e:g	Lcom/alipay/android/app/IRemoteServiceCallback;
    //   339: invokeinterface 161 2 0
    //   344: aload_0
    //   345: getfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   348: aload_1
    //   349: invokeinterface 164 2 0
    //   354: astore_2
    //   355: aload_0
    //   356: getfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   359: aload_0
    //   360: getfield 41	com/alipay/sdk/j/e:g	Lcom/alipay/android/app/IRemoteServiceCallback;
    //   363: invokeinterface 141 2 0
    //   368: aload_0
    //   369: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   372: invokevirtual 93	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   375: aload_0
    //   376: getfield 36	com/alipay/sdk/j/e:f	Landroid/content/ServiceConnection;
    //   379: invokevirtual 145	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   382: aload_0
    //   383: aconst_null
    //   384: putfield 45	com/alipay/sdk/j/e:e	Lcom/alipay/sdk/j/e$a;
    //   387: aload_0
    //   388: aconst_null
    //   389: putfield 41	com/alipay/sdk/j/e:g	Lcom/alipay/android/app/IRemoteServiceCallback;
    //   392: aload_0
    //   393: aconst_null
    //   394: putfield 36	com/alipay/sdk/j/e:f	Landroid/content/ServiceConnection;
    //   397: aload_0
    //   398: aconst_null
    //   399: putfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   402: aload_2
    //   403: astore_1
    //   404: aload_0
    //   405: getfield 147	com/alipay/sdk/j/e:d	Z
    //   408: ifeq -317 -> 91
    //   411: aload_2
    //   412: astore_1
    //   413: aload_0
    //   414: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   417: ifnull -326 -> 91
    //   420: aload_0
    //   421: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   424: iconst_0
    //   425: invokevirtual 151	android/app/Activity:setRequestedOrientation	(I)V
    //   428: aload_0
    //   429: iconst_0
    //   430: putfield 147	com/alipay/sdk/j/e:d	Z
    //   433: aload_2
    //   434: areturn
    //   435: astore_1
    //   436: ldc 106
    //   438: ldc -90
    //   440: aload_1
    //   441: invokestatic 113	com/alipay/sdk/app/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   444: invokestatic 169	com/alipay/sdk/app/i:a	()Ljava/lang/String;
    //   447: astore_2
    //   448: aload_0
    //   449: getfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   452: aload_0
    //   453: getfield 41	com/alipay/sdk/j/e:g	Lcom/alipay/android/app/IRemoteServiceCallback;
    //   456: invokeinterface 141 2 0
    //   461: aload_0
    //   462: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   465: invokevirtual 93	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   468: aload_0
    //   469: getfield 36	com/alipay/sdk/j/e:f	Landroid/content/ServiceConnection;
    //   472: invokevirtual 145	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   475: aload_0
    //   476: aconst_null
    //   477: putfield 45	com/alipay/sdk/j/e:e	Lcom/alipay/sdk/j/e$a;
    //   480: aload_0
    //   481: aconst_null
    //   482: putfield 41	com/alipay/sdk/j/e:g	Lcom/alipay/android/app/IRemoteServiceCallback;
    //   485: aload_0
    //   486: aconst_null
    //   487: putfield 36	com/alipay/sdk/j/e:f	Landroid/content/ServiceConnection;
    //   490: aload_0
    //   491: aconst_null
    //   492: putfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   495: aload_2
    //   496: astore_1
    //   497: aload_0
    //   498: getfield 147	com/alipay/sdk/j/e:d	Z
    //   501: ifeq -410 -> 91
    //   504: aload_2
    //   505: astore_1
    //   506: aload_0
    //   507: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   510: ifnull -419 -> 91
    //   513: aload_0
    //   514: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   517: iconst_0
    //   518: invokevirtual 151	android/app/Activity:setRequestedOrientation	(I)V
    //   521: aload_0
    //   522: iconst_0
    //   523: putfield 147	com/alipay/sdk/j/e:d	Z
    //   526: aload_2
    //   527: areturn
    //   528: astore_1
    //   529: aload_0
    //   530: getfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   533: aload_0
    //   534: getfield 41	com/alipay/sdk/j/e:g	Lcom/alipay/android/app/IRemoteServiceCallback;
    //   537: invokeinterface 141 2 0
    //   542: aload_0
    //   543: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   546: invokevirtual 93	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   549: aload_0
    //   550: getfield 36	com/alipay/sdk/j/e:f	Landroid/content/ServiceConnection;
    //   553: invokevirtual 145	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   556: aload_0
    //   557: aconst_null
    //   558: putfield 45	com/alipay/sdk/j/e:e	Lcom/alipay/sdk/j/e$a;
    //   561: aload_0
    //   562: aconst_null
    //   563: putfield 41	com/alipay/sdk/j/e:g	Lcom/alipay/android/app/IRemoteServiceCallback;
    //   566: aload_0
    //   567: aconst_null
    //   568: putfield 36	com/alipay/sdk/j/e:f	Landroid/content/ServiceConnection;
    //   571: aload_0
    //   572: aconst_null
    //   573: putfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   576: aload_0
    //   577: getfield 147	com/alipay/sdk/j/e:d	Z
    //   580: ifeq +23 -> 603
    //   583: aload_0
    //   584: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   587: ifnull +16 -> 603
    //   590: aload_0
    //   591: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   594: iconst_0
    //   595: invokevirtual 151	android/app/Activity:setRequestedOrientation	(I)V
    //   598: aload_0
    //   599: iconst_0
    //   600: putfield 147	com/alipay/sdk/j/e:d	Z
    //   603: aload_1
    //   604: athrow
    //   605: astore_2
    //   606: goto -50 -> 556
    //   609: astore_2
    //   610: goto -68 -> 542
    //   613: astore_1
    //   614: goto -139 -> 475
    //   617: astore_1
    //   618: goto -157 -> 461
    //   621: astore_1
    //   622: goto -240 -> 382
    //   625: astore_1
    //   626: goto -258 -> 368
    //   629: astore_1
    //   630: goto -411 -> 219
    //   633: astore_1
    //   634: goto -429 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	637	0	this	e
    //   0	637	1	paramString	String
    //   11	516	2	str	String
    //   605	1	2	localThrowable1	Throwable
    //   609	1	2	localThrowable2	Throwable
    //   7	282	3	localObject	Object
    //   104	3	4	localIAlixPay	IAlixPay
    //   273	7	4	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   50	79	79	java/lang/Throwable
    //   111	125	273	java/lang/InterruptedException
    //   100	106	287	finally
    //   111	125	287	finally
    //   125	127	287	finally
    //   275	284	287	finally
    //   288	290	287	finally
    //   127	189	435	java/lang/Throwable
    //   292	308	435	java/lang/Throwable
    //   308	331	435	java/lang/Throwable
    //   331	355	435	java/lang/Throwable
    //   127	189	528	finally
    //   292	308	528	finally
    //   308	331	528	finally
    //   331	355	528	finally
    //   436	448	528	finally
    //   542	556	605	java/lang/Throwable
    //   529	542	609	java/lang/Throwable
    //   461	475	613	java/lang/Throwable
    //   448	461	617	java/lang/Throwable
    //   368	382	621	java/lang/Throwable
    //   355	368	625	java/lang/Throwable
    //   205	219	629	java/lang/Throwable
    //   192	205	633	java/lang/Throwable
  }
  
  public final String a(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = k.a(this.a);
        if (((k.a)localObject).a()) {
          return "failed";
        }
        if (localObject != null)
        {
          int i = ((k.a)localObject).b;
          if (i > 78) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        Intent localIntent;
        a.a("biz", "CheckClientSignEx", localThrowable);
        continue;
      }
      return b(paramString);
      localObject = k.a();
      localIntent = new Intent();
      localIntent.setClassName((String)localObject, "com.alipay.android.app.TransProcessPayActivity");
      this.a.startActivity(localIntent);
      Thread.sleep(200L);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/sdk/j/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */