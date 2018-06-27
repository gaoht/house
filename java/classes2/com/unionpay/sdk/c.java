package com.unionpay.sdk;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Random;
import java.util.zip.GZIPOutputStream;

class c
  extends bh
{
  private static volatile c e = null;
  private static m f = null;
  private static Handler m = null;
  private static HandlerThread n;
  private final String a = "140.207.168.45";
  private final String b = "140.207.168.45";
  private final String c = "http://140.207.168.45/g/d";
  private volatile boolean d = false;
  private bf g = new a("140.207.168.45", "140.207.168.45", "http://140.207.168.45/g/d");
  private final int h = 30000;
  private int i = 30000;
  private boolean j = false;
  private long k = SystemClock.elapsedRealtime() - this.i;
  private Random l = new Random();
  private FileLock o = null;
  private final String p = null;
  
  static
  {
    HandlerThread localHandlerThread = new HandlerThread("prepareSubmitHandlerThread");
    n = localHandlerThread;
    localHandlerThread.start();
    m = new aa(n.getLooper());
    f = new ab();
    try
    {
      ar.a().register(a());
      return;
    }
    catch (Throwable localThrowable)
    {
      k.a(localThrowable);
    }
  }
  
  static c a()
  {
    if (e == null) {}
    try
    {
      if (e == null) {
        e = new c();
      }
      return e;
    }
    finally {}
  }
  
  private void b()
  {
    for (;;)
    {
      Object localObject2;
      try
      {
        boolean bool = this.d;
        if (bool) {
          return;
        }
        try
        {
          if (d.e != null) {
            this.o = d.e.tryLock();
          }
          if (this.o == null) {
            break label225;
          }
          if (!j.c(d.c)) {
            continue;
          }
          localObject2 = ac.a(t.a());
          p localp = new p();
          localp.c = this.g.b;
          localp.b = this.g.c;
          localp.a = this.g.d;
          localp.d = "Analytics";
          localp.e = this.p;
          localp.g = localObject2;
          if (localObject2 != null) {
            break label181;
          }
          k.a("No new data found!");
          localp.f = null;
          localObject2 = Message.obtain();
          ((Message)localObject2).obj = localp;
          ((Message)localObject2).what = 8;
          ag.b.a().sendMessage((Message)localObject2);
          this.d = true;
        }
        catch (Throwable localThrowable)
        {
          c();
        }
        if (!ag.a) {
          continue;
        }
        localThrowable.printStackTrace();
        continue;
        k.a("New data found, Submitting...");
      }
      finally {}
      label181:
      HashMap localHashMap = new HashMap();
      localHashMap.put("entity", localObject2);
      ((p)localObject1).f = this.g.a(localHashMap);
      ((p)localObject1).h = true;
      continue;
      label225:
      if (UPAgent.LOG_ON) {
        Log.d("UPLog", "Aborted submitting, file cannot be accessed due to lock.");
      }
    }
  }
  
  private void c()
  {
    if (this.o != null) {}
    try
    {
      this.o.release();
      return;
    }
    catch (Throwable localThrowable)
    {
      k.a(localThrowable);
    }
  }
  
  /* Error */
  final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 5
    //   3: iconst_1
    //   4: istore_2
    //   5: aload_0
    //   6: monitorenter
    //   7: invokestatic 194	android/os/Message:obtain	()Landroid/os/Message;
    //   10: astore 9
    //   12: iload_1
    //   13: ifeq +190 -> 203
    //   16: aload 9
    //   18: iload_2
    //   19: putfield 200	android/os/Message:what	I
    //   22: getstatic 217	com/unionpay/sdk/ag:a	Z
    //   25: ifeq +60 -> 85
    //   28: new 258	java/lang/StringBuilder
    //   31: dup
    //   32: ldc_w 260
    //   35: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: invokestatic 117	android/os/SystemClock:elapsedRealtime	()J
    //   41: aload_0
    //   42: getfield 119	com/unionpay/sdk/c:k	J
    //   45: lsub
    //   46: ldc2_w 262
    //   49: ldiv
    //   50: invokestatic 269	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   53: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 185	com/unionpay/sdk/k:a	(Ljava/lang/String;)V
    //   62: new 258	java/lang/StringBuilder
    //   65: dup
    //   66: ldc_w 279
    //   69: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: iload_1
    //   73: invokestatic 282	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   76: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 185	com/unionpay/sdk/k:a	(Ljava/lang/String;)V
    //   85: iload_1
    //   86: ifne +122 -> 208
    //   89: invokestatic 117	android/os/SystemClock:elapsedRealtime	()J
    //   92: aload_0
    //   93: getfield 119	com/unionpay/sdk/c:k	J
    //   96: lsub
    //   97: lstore 7
    //   99: lload 7
    //   101: lconst_0
    //   102: lcmp
    //   103: iflt +97 -> 200
    //   106: lload 5
    //   108: lstore_3
    //   109: aload_0
    //   110: getfield 119	com/unionpay/sdk/c:k	J
    //   113: lconst_0
    //   114: lcmp
    //   115: ifle +22 -> 137
    //   118: lload 5
    //   120: lstore_3
    //   121: lload 7
    //   123: ldc2_w 283
    //   126: lcmp
    //   127: ifge +10 -> 137
    //   130: ldc2_w 283
    //   133: lload 7
    //   135: lsub
    //   136: lstore_3
    //   137: getstatic 217	com/unionpay/sdk/ag:a	Z
    //   140: ifeq +36 -> 176
    //   143: new 258	java/lang/StringBuilder
    //   146: dup
    //   147: ldc_w 286
    //   150: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   153: lload_3
    //   154: ldc2_w 262
    //   157: ldiv
    //   158: invokestatic 269	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   161: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc_w 288
    //   167: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 185	com/unionpay/sdk/k:a	(Ljava/lang/String;)V
    //   176: getstatic 43	com/unionpay/sdk/c:m	Landroid/os/Handler;
    //   179: iconst_0
    //   180: invokevirtual 292	android/os/Handler:removeMessages	(I)V
    //   183: getstatic 43	com/unionpay/sdk/c:m	Landroid/os/Handler;
    //   186: iconst_1
    //   187: invokevirtual 292	android/os/Handler:removeMessages	(I)V
    //   190: getstatic 43	com/unionpay/sdk/c:m	Landroid/os/Handler;
    //   193: aload 9
    //   195: lload_3
    //   196: invokevirtual 296	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   199: pop
    //   200: aload_0
    //   201: monitorexit
    //   202: return
    //   203: iconst_0
    //   204: istore_2
    //   205: goto -189 -> 16
    //   208: aload_0
    //   209: getfield 111	com/unionpay/sdk/c:j	Z
    //   212: ifeq +10 -> 222
    //   215: aload_0
    //   216: sipush 30000
    //   219: putfield 109	com/unionpay/sdk/c:i	I
    //   222: invokestatic 117	android/os/SystemClock:elapsedRealtime	()J
    //   225: aload_0
    //   226: getfield 119	com/unionpay/sdk/c:k	J
    //   229: lsub
    //   230: aload_0
    //   231: getfield 109	com/unionpay/sdk/c:i	I
    //   234: i2l
    //   235: lcmp
    //   236: ifle -36 -> 200
    //   239: getstatic 43	com/unionpay/sdk/c:m	Landroid/os/Handler;
    //   242: iconst_0
    //   243: invokevirtual 292	android/os/Handler:removeMessages	(I)V
    //   246: getstatic 43	com/unionpay/sdk/c:m	Landroid/os/Handler;
    //   249: iconst_1
    //   250: invokevirtual 292	android/os/Handler:removeMessages	(I)V
    //   253: getstatic 43	com/unionpay/sdk/c:m	Landroid/os/Handler;
    //   256: aload 9
    //   258: invokevirtual 211	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   261: pop
    //   262: goto -62 -> 200
    //   265: astore 9
    //   267: aload_0
    //   268: monitorexit
    //   269: aload 9
    //   271: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	c
    //   0	272	1	paramBoolean	boolean
    //   4	201	2	i1	int
    //   108	88	3	l1	long
    //   1	118	5	l2	long
    //   97	37	7	l3	long
    //   10	247	9	localMessage	Message
    //   265	5	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	12	265	finally
    //   16	85	265	finally
    //   89	99	265	finally
    //   109	118	265	finally
    //   137	176	265	finally
    //   176	200	265	finally
    //   208	222	265	finally
    //   222	262	265	finally
  }
  
  public final void onTDEBEventResponse(s params)
  {
    try
    {
      this.k = SystemClock.elapsedRealtime();
      if (params != null) {
        if ((params.a != null) && (String.valueOf(params.a.get("action")).equals("Analytics")))
        {
          if (Integer.valueOf(String.valueOf(params.a.get("statusCode"))).intValue() != 200) {
            break label160;
          }
          k.a("Data submitting Succeed!");
          Object localObject2 = null;
          Object localObject1 = localObject2;
          if (params.b != null)
          {
            localObject1 = localObject2;
            if ((params.b instanceof w.f)) {
              localObject1 = (w.f)params.b;
            }
          }
          ac.a((w.f)localObject1, t.a());
          this.i = 120000;
        }
      }
      for (this.j = true;; this.j = false)
      {
        j.c(d.c);
        if ((o.f() != null) && (!o.f().equals("2"))) {
          a(false);
        }
        c();
        this.d = false;
        return;
        label160:
        this.i = (this.l.nextInt(60000) - 30000 + 120000);
        k.a("Data submitting Failed!");
        k.b(new String[] { "statusCode: ", String.valueOf(params.a.get("statusCode")), "responseMsg", String.valueOf(params.a.get("responseMsg")) });
      }
      return;
    }
    catch (Throwable params)
    {
      k.a(params);
    }
  }
  
  final class a
    extends bf
  {
    a(String paramString1, String paramString2, String paramString3)
    {
      this.b = paramString1;
      this.c = paramString2;
      this.d = paramString3;
      this.e = 1;
    }
    
    final byte[] a(HashMap paramHashMap)
    {
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1024);
        GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
        z localz = new z(localGZIPOutputStream);
        if ((paramHashMap.containsKey("entity")) && (paramHashMap.get("entity") != null) && ((paramHashMap.get("entity") instanceof w.f)))
        {
          localz.a((w.f)paramHashMap.get("entity"));
          localGZIPOutputStream.finish();
          localGZIPOutputStream.close();
          paramHashMap = localByteArrayOutputStream.toByteArray();
          return paramHashMap;
        }
        return null;
      }
      catch (Throwable paramHashMap)
      {
        paramHashMap.printStackTrace();
      }
      return null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */