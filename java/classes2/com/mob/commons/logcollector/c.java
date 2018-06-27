package com.mob.commons.logcollector;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.MobSDK;
import com.mob.commons.LockAction;
import com.mob.commons.a;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper.NetworkTimeOut;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.Hashon;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;

public class c
{
  private static c b;
  private static String c = "http://api.exc.mob.com:80";
  protected final Handler a = MobHandlerThread.newHandler("l", new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      c.this.a(paramAnonymousMessage);
      return false;
    }
  });
  private HashMap<String, Integer> d = new HashMap();
  private NetworkHelper e = new NetworkHelper();
  private d f;
  private File g;
  
  public static c a()
  {
    try
    {
      if (b == null) {
        b = new c();
      }
      c localc = b;
      return localc;
    }
    finally {}
  }
  
  private String a(String paramString)
    throws Throwable
  {
    paramString = new ByteArrayInputStream(paramString.getBytes());
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Object localObject = new GZIPOutputStream(localByteArrayOutputStream);
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramString.read(arrayOfByte, 0, 1024);
      if (i == -1) {
        break;
      }
      ((GZIPOutputStream)localObject).write(arrayOfByte, 0, i);
    }
    try
    {
      ((GZIPOutputStream)localObject).flush();
      ((GZIPOutputStream)localObject).close();
      localObject = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.flush();
      localByteArrayOutputStream.close();
      paramString.close();
      return Base64.encodeToString((byte[])localObject, 2);
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  private void a(final int paramInt, final String paramString, final String[] paramArrayOfString)
  {
    try
    {
      b();
      if (!this.f.c()) {
        return;
      }
      if ("none".equals(DeviceHelper.getInstance(MobSDK.getContext()).getDetailNetworkTypeForStatic())) {
        throw new IllegalStateException("network is disconnected!");
      }
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().i(paramString);
      return;
    }
    c();
    com.mob.commons.c.a(this.g, new LockAction()
    {
      public boolean run(FileLocker paramAnonymousFileLocker)
      {
        try
        {
          paramAnonymousFileLocker = f.a(paramArrayOfString);
          int i = 0;
          while (i < paramAnonymousFileLocker.size())
          {
            e locale = (e)paramAnonymousFileLocker.get(i);
            HashMap localHashMap = c.a(c.this, paramInt, paramString);
            localHashMap.put("errmsg", locale.a);
            if (c.a(c.this, c.a(c.this, new Hashon().fromHashMap(localHashMap)), true)) {
              f.a(locale.b);
            }
            i += 1;
          }
          return false;
        }
        catch (Throwable paramAnonymousFileLocker)
        {
          MobLog.getInstance().i(paramAnonymousFileLocker);
        }
      }
    });
  }
  
  private boolean a(String paramString, boolean paramBoolean)
    throws Throwable
  {
    if (a.D()) {
      return false;
    }
    try
    {
      if ("none".equals(DeviceHelper.getInstance(MobSDK.getContext()).getDetailNetworkTypeForStatic())) {
        throw new IllegalStateException("network is disconnected!");
      }
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().i(paramString);
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("m", paramString));
    paramString = new NetworkHelper.NetworkTimeOut();
    paramString.readTimout = 10000;
    paramString.connectionTimeout = 10000;
    this.e.httpPost(e(), localArrayList, null, null, paramString);
    return true;
  }
  
  private void b()
  {
    try
    {
      if (this.f == null) {
        this.f = d.a();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  private void b(int paramInt, String paramString)
    throws Throwable
  {
    // Byte code:
    //   0: new 196	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 197	java/util/ArrayList:<init>	()V
    //   7: astore 8
    //   9: invokestatic 137	com/mob/MobSDK:getContext	()Landroid/content/Context;
    //   12: invokestatic 143	com/mob/tools/utils/DeviceHelper:getInstance	(Landroid/content/Context;)Lcom/mob/tools/utils/DeviceHelper;
    //   15: astore 9
    //   17: aload 8
    //   19: new 199	com/mob/tools/network/KVPair
    //   22: dup
    //   23: ldc -26
    //   25: invokestatic 233	com/mob/MobSDK:getAppkey	()Ljava/lang/String;
    //   28: invokespecial 204	com/mob/tools/network/KVPair:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   31: invokevirtual 207	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   34: pop
    //   35: aload 8
    //   37: new 199	com/mob/tools/network/KVPair
    //   40: dup
    //   41: ldc -21
    //   43: aload_2
    //   44: invokespecial 204	com/mob/tools/network/KVPair:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   47: invokevirtual 207	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   50: pop
    //   51: aload 8
    //   53: new 199	com/mob/tools/network/KVPair
    //   56: dup
    //   57: ldc -19
    //   59: aload 9
    //   61: invokevirtual 240	com/mob/tools/utils/DeviceHelper:getPackageName	()Ljava/lang/String;
    //   64: invokestatic 244	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   67: invokespecial 204	com/mob/tools/network/KVPair:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   70: invokevirtual 207	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   73: pop
    //   74: aload 8
    //   76: new 199	com/mob/tools/network/KVPair
    //   79: dup
    //   80: ldc -10
    //   82: aload 9
    //   84: invokevirtual 250	com/mob/tools/utils/DeviceHelper:getAppVersion	()I
    //   87: invokestatic 253	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   90: invokespecial 204	com/mob/tools/network/KVPair:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   93: invokevirtual 207	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   96: pop
    //   97: aload 8
    //   99: new 199	com/mob/tools/network/KVPair
    //   102: dup
    //   103: ldc -1
    //   105: iload_1
    //   106: invokestatic 253	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   109: invokespecial 204	com/mob/tools/network/KVPair:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   112: invokevirtual 207	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   115: pop
    //   116: aload 8
    //   118: new 199	com/mob/tools/network/KVPair
    //   121: dup
    //   122: ldc_w 257
    //   125: aload 9
    //   127: invokevirtual 260	com/mob/tools/utils/DeviceHelper:getPlatformCode	()I
    //   130: invokestatic 253	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   133: invokespecial 204	com/mob/tools/network/KVPair:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   136: invokevirtual 207	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   139: pop
    //   140: new 209	com/mob/tools/network/NetworkHelper$NetworkTimeOut
    //   143: dup
    //   144: invokespecial 210	com/mob/tools/network/NetworkHelper$NetworkTimeOut:<init>	()V
    //   147: astore_2
    //   148: aload_2
    //   149: sipush 10000
    //   152: putfield 214	com/mob/tools/network/NetworkHelper$NetworkTimeOut:readTimout	I
    //   155: aload_2
    //   156: sipush 10000
    //   159: putfield 217	com/mob/tools/network/NetworkHelper$NetworkTimeOut:connectionTimeout	I
    //   162: aload_0
    //   163: getfield 40	com/mob/commons/logcollector/c:e	Lcom/mob/tools/network/NetworkHelper;
    //   166: aload_0
    //   167: invokespecial 262	com/mob/commons/logcollector/c:d	()Ljava/lang/String;
    //   170: aload 8
    //   172: aconst_null
    //   173: aconst_null
    //   174: aload_2
    //   175: invokevirtual 223	com/mob/tools/network/NetworkHelper:httpPost	(Ljava/lang/String;Ljava/util/ArrayList;Lcom/mob/tools/network/KVPair;Ljava/util/ArrayList;Lcom/mob/tools/network/NetworkHelper$NetworkTimeOut;)Ljava/lang/String;
    //   178: astore_2
    //   179: invokestatic 163	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   182: ldc_w 264
    //   185: iconst_1
    //   186: anewarray 4	java/lang/Object
    //   189: dup
    //   190: iconst_0
    //   191: aload_2
    //   192: aastore
    //   193: invokevirtual 267	com/mob/tools/log/NLog:i	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   196: pop
    //   197: new 269	com/mob/tools/utils/Hashon
    //   200: dup
    //   201: invokespecial 270	com/mob/tools/utils/Hashon:<init>	()V
    //   204: aload_2
    //   205: invokevirtual 274	com/mob/tools/utils/Hashon:fromJson	(Ljava/lang/String;)Ljava/util/HashMap;
    //   208: astore_2
    //   209: ldc_w 276
    //   212: aload_2
    //   213: ldc_w 278
    //   216: invokevirtual 282	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   219: invokestatic 244	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   222: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   225: ifeq +18 -> 243
    //   228: invokestatic 163	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   231: ldc_w 284
    //   234: iconst_0
    //   235: anewarray 4	java/lang/Object
    //   238: invokevirtual 267	com/mob/tools/log/NLog:i	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   241: pop
    //   242: return
    //   243: aload_2
    //   244: ldc_w 286
    //   247: invokevirtual 282	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   250: astore_2
    //   251: aload_2
    //   252: ifnull +394 -> 646
    //   255: aload_2
    //   256: instanceof 42
    //   259: ifeq +387 -> 646
    //   262: aload_0
    //   263: invokespecial 124	com/mob/commons/logcollector/c:b	()V
    //   266: aload_2
    //   267: checkcast 42	java/util/HashMap
    //   270: astore_2
    //   271: aload_2
    //   272: ldc_w 288
    //   275: invokevirtual 291	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   278: istore_3
    //   279: iload_3
    //   280: ifeq +35 -> 315
    //   283: aload_2
    //   284: ldc_w 288
    //   287: invokevirtual 282	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   290: invokestatic 244	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   293: invokestatic 297	com/mob/tools/utils/ResHelper:parseLong	(Ljava/lang/String;)J
    //   296: lstore 4
    //   298: invokestatic 303	java/lang/System:currentTimeMillis	()J
    //   301: lstore 6
    //   303: aload_0
    //   304: getfield 65	com/mob/commons/logcollector/c:f	Lcom/mob/commons/logcollector/d;
    //   307: lload 6
    //   309: lload 4
    //   311: lsub
    //   312: invokevirtual 306	com/mob/commons/logcollector/d:a	(J)V
    //   315: ldc_w 308
    //   318: aload_2
    //   319: ldc_w 310
    //   322: invokevirtual 282	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   325: invokestatic 244	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   328: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   331: ifeq +304 -> 635
    //   334: aload_0
    //   335: getfield 65	com/mob/commons/logcollector/c:f	Lcom/mob/commons/logcollector/d;
    //   338: iconst_1
    //   339: invokevirtual 313	com/mob/commons/logcollector/d:a	(Z)V
    //   342: aload_2
    //   343: ldc_w 315
    //   346: invokevirtual 282	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   349: astore 8
    //   351: aload 8
    //   353: ifnull +93 -> 446
    //   356: aload 8
    //   358: instanceof 42
    //   361: ifeq +85 -> 446
    //   364: aload 8
    //   366: checkcast 42	java/util/HashMap
    //   369: astore 10
    //   371: aload 10
    //   373: ldc_w 317
    //   376: invokevirtual 282	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   379: invokestatic 244	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   382: astore 8
    //   384: aload 10
    //   386: ldc_w 319
    //   389: invokevirtual 282	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   392: invokestatic 244	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   395: astore 9
    //   397: aload 10
    //   399: ldc_w 321
    //   402: invokevirtual 282	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   405: invokestatic 244	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   408: astore 10
    //   410: aload_0
    //   411: getfield 65	com/mob/commons/logcollector/c:f	Lcom/mob/commons/logcollector/d;
    //   414: aload 8
    //   416: invokestatic 327	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   419: invokevirtual 330	com/mob/commons/logcollector/d:a	(I)V
    //   422: aload_0
    //   423: getfield 65	com/mob/commons/logcollector/c:f	Lcom/mob/commons/logcollector/d;
    //   426: aload 9
    //   428: invokestatic 327	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   431: invokevirtual 332	com/mob/commons/logcollector/d:b	(I)V
    //   434: aload_0
    //   435: getfield 65	com/mob/commons/logcollector/c:f	Lcom/mob/commons/logcollector/d;
    //   438: aload 10
    //   440: invokestatic 327	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   443: invokevirtual 334	com/mob/commons/logcollector/d:c	(I)V
    //   446: aload_2
    //   447: ldc_w 336
    //   450: invokevirtual 291	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   453: ifeq +88 -> 541
    //   456: aload_2
    //   457: ldc_w 338
    //   460: invokevirtual 291	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   463: ifeq +78 -> 541
    //   466: aload_2
    //   467: ldc_w 336
    //   470: invokevirtual 282	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   473: invokestatic 244	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   476: astore 8
    //   478: aload_2
    //   479: ldc_w 338
    //   482: invokevirtual 282	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   485: invokestatic 244	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   488: astore 9
    //   490: aload 8
    //   492: invokestatic 344	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   495: ifne +46 -> 541
    //   498: aload 9
    //   500: invokestatic 344	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   503: ifne +38 -> 541
    //   506: new 346	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   513: ldc_w 349
    //   516: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: aload 8
    //   521: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: ldc_w 355
    //   527: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload 9
    //   532: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: putstatic 31	com/mob/commons/logcollector/c:c	Ljava/lang/String;
    //   541: aload_2
    //   542: ldc_w 360
    //   545: invokevirtual 282	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   548: astore_2
    //   549: aload_2
    //   550: ifnull +96 -> 646
    //   553: aload_2
    //   554: instanceof 196
    //   557: ifeq +89 -> 646
    //   560: aload_2
    //   561: checkcast 196	java/util/ArrayList
    //   564: astore_2
    //   565: aload_2
    //   566: invokevirtual 363	java/util/ArrayList:size	()I
    //   569: ifle +77 -> 646
    //   572: new 42	java/util/HashMap
    //   575: dup
    //   576: invokespecial 43	java/util/HashMap:<init>	()V
    //   579: astore 8
    //   581: aload 8
    //   583: ldc_w 365
    //   586: aload_2
    //   587: invokevirtual 369	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   590: pop
    //   591: aload_0
    //   592: getfield 65	com/mob/commons/logcollector/c:f	Lcom/mob/commons/logcollector/d;
    //   595: new 269	com/mob/tools/utils/Hashon
    //   598: dup
    //   599: invokespecial 270	com/mob/tools/utils/Hashon:<init>	()V
    //   602: aload 8
    //   604: invokevirtual 373	com/mob/tools/utils/Hashon:fromHashMap	(Ljava/util/HashMap;)Ljava/lang/String;
    //   607: invokevirtual 375	com/mob/commons/logcollector/d:a	(Ljava/lang/String;)V
    //   610: return
    //   611: astore_2
    //   612: invokestatic 163	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   615: aload_2
    //   616: invokevirtual 377	com/mob/tools/log/NLog:d	(Ljava/lang/Throwable;)I
    //   619: pop
    //   620: return
    //   621: astore 8
    //   623: invokestatic 163	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   626: aload 8
    //   628: invokevirtual 169	com/mob/tools/log/NLog:i	(Ljava/lang/Throwable;)I
    //   631: pop
    //   632: goto -317 -> 315
    //   635: aload_0
    //   636: getfield 65	com/mob/commons/logcollector/c:f	Lcom/mob/commons/logcollector/d;
    //   639: iconst_0
    //   640: invokevirtual 313	com/mob/commons/logcollector/d:a	(Z)V
    //   643: goto -301 -> 342
    //   646: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	647	0	this	c
    //   0	647	1	paramInt	int
    //   0	647	2	paramString	String
    //   278	2	3	bool	boolean
    //   296	14	4	l1	long
    //   301	7	6	l2	long
    //   7	596	8	localObject1	Object
    //   621	6	8	localThrowable	Throwable
    //   15	516	9	localObject2	Object
    //   369	70	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   140	242	611	java/lang/Throwable
    //   243	251	611	java/lang/Throwable
    //   255	279	611	java/lang/Throwable
    //   315	342	611	java/lang/Throwable
    //   342	351	611	java/lang/Throwable
    //   356	446	611	java/lang/Throwable
    //   446	541	611	java/lang/Throwable
    //   541	549	611	java/lang/Throwable
    //   553	610	611	java/lang/Throwable
    //   623	632	611	java/lang/Throwable
    //   635	643	611	java/lang/Throwable
    //   283	315	621	java/lang/Throwable
  }
  
  private void b(Message paramMessage)
  {
    this.a.sendMessageDelayed(paramMessage, 1000L);
  }
  
  private HashMap<String, Object> c(int paramInt, String paramString)
    throws Throwable
  {
    HashMap localHashMap = new HashMap();
    DeviceHelper localDeviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
    localHashMap.put("key", MobSDK.getAppkey());
    localHashMap.put("plat", Integer.valueOf(localDeviceHelper.getPlatformCode()));
    localHashMap.put("sdk", paramString);
    localHashMap.put("sdkver", Integer.valueOf(paramInt));
    localHashMap.put("appname", localDeviceHelper.getAppName());
    localHashMap.put("apppkg", localDeviceHelper.getPackageName());
    localHashMap.put("appver", String.valueOf(localDeviceHelper.getAppVersion()));
    localHashMap.put("deviceid", localDeviceHelper.getDeviceKey());
    localHashMap.put("model", localDeviceHelper.getModel());
    localHashMap.put("mac", localDeviceHelper.getMacAddress());
    localHashMap.put("udid", localDeviceHelper.getDeviceId());
    localHashMap.put("sysver", String.valueOf(localDeviceHelper.getOSVersionInt()));
    localHashMap.put("networktype", localDeviceHelper.getDetailNetworkTypeForStatic());
    return localHashMap;
  }
  
  private void c()
  {
    if (this.g == null) {
      this.g = new File(MobSDK.getContext().getFilesDir(), ".lock");
    }
    if (!this.g.exists()) {}
    try
    {
      this.g.createNewFile();
      return;
    }
    catch (Exception localException)
    {
      MobLog.getInstance().w(localException);
    }
  }
  
  private void c(Message paramMessage)
  {
    try
    {
      int i = paramMessage.arg1;
      paramMessage = (String)paramMessage.obj;
      b(i, paramMessage);
      a(i, paramMessage, null);
      return;
    }
    catch (Throwable paramMessage)
    {
      MobLog.getInstance().w(paramMessage);
    }
  }
  
  private String d()
  {
    return c + "/errconf";
  }
  
  private void d(final Message paramMessage)
  {
    for (;;)
    {
      int j;
      String str1;
      final int i;
      int k;
      int m;
      try
      {
        j = paramMessage.arg1;
        localObject1 = (Object[])paramMessage.obj;
        str1 = (String)localObject1[0];
        localObject1 = (String)localObject1[1];
        i = 1;
        if (paramMessage.arg2 == 0)
        {
          i = 2;
          b();
          localObject2 = this.f.g();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = (ArrayList)new Hashon().fromJson((String)localObject2).get("fakelist");
            if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
            {
              localObject2 = ((ArrayList)localObject2).iterator();
              if (((Iterator)localObject2).hasNext())
              {
                String str2 = (String)((Iterator)localObject2).next();
                if ((TextUtils.isEmpty(str2)) || (!((String)localObject1).contains(str2))) {
                  continue;
                }
              }
            }
          }
        }
        else
        {
          if (paramMessage.arg2 != 2) {
            continue;
          }
          i = 1;
          continue;
        }
        k = this.f.d();
        m = this.f.e();
        n = this.f.f();
        if (3 != i) {
          break label350;
        }
        if (-1 == n) {
          break label349;
        }
      }
      catch (Throwable paramMessage)
      {
        final Object localObject1;
        final Object localObject2;
        int n;
        MobLog.getInstance().w(paramMessage);
        return;
      }
      localObject2 = Data.MD5((String)localObject1);
      c();
      if (com.mob.commons.c.a(this.g, new LockAction()
      {
        public boolean run(FileLocker paramAnonymousFileLocker)
        {
          try
          {
            f.a(System.currentTimeMillis() - c.a(c.this).b(), localObject1, i, localObject2);
            return false;
          }
          catch (Throwable paramAnonymousFileLocker)
          {
            if (c.b(c.this).containsKey(localObject2)) {}
            for (int i = ((Integer)c.b(c.this).get(localObject2)).intValue();; i = 0)
            {
              i += 1;
              c.b(c.this).put(localObject2, Integer.valueOf(i));
              if (i >= 3) {
                break;
              }
              c.a(c.this, paramMessage);
              return false;
            }
            c.b(c.this).remove(localObject2);
            MobLog.getInstance().w(paramAnonymousFileLocker);
          }
          return false;
        }
      }))
      {
        this.d.remove(localObject2);
        if ((3 == i) && (1 == n))
        {
          a(j, str1, new String[] { String.valueOf(3) });
          return;
        }
        if ((1 == i) && (1 == k))
        {
          a(j, str1, new String[] { String.valueOf(1) });
          return;
        }
        if ((2 == i) && (1 == m)) {
          a(j, str1, new String[] { String.valueOf(2) });
        }
      }
      label349:
      label350:
      do
      {
        do
        {
          return;
        } while ((1 == i) && (-1 == k));
        if (2 != i) {
          break;
        }
      } while (-1 == m);
    }
  }
  
  private String e()
  {
    return c + "/errlog";
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    Message localMessage = new Message();
    localMessage.what = 101;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = new Object[] { paramString1, paramString2 };
    this.a.sendMessage(localMessage);
  }
  
  public void a(int paramInt, String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 100;
    localMessage.arg1 = paramInt;
    localMessage.obj = paramString;
    this.a.sendMessage(localMessage);
  }
  
  protected void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      c(paramMessage);
      return;
    }
    d(paramMessage);
  }
  
  public void b(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(paramInt1, paramInt2, paramString1, paramString2);
    try
    {
      this.a.wait();
      return;
    }
    catch (Throwable paramString1) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/logcollector/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */