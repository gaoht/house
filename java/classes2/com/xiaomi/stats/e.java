package com.xiaomi.stats;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.g;

public class e
  implements com.xiaomi.smack.d
{
  XMPushService a;
  com.xiaomi.smack.a b;
  private int c;
  private Exception d;
  private String e;
  private long f = 0L;
  private long g = 0L;
  private long h = 0L;
  private long i = 0L;
  private long j = 0L;
  private long k = 0L;
  
  e(XMPushService paramXMPushService)
  {
    this.a = paramXMPushService;
    this.e = com.xiaomi.channel.commonutils.network.d.k(paramXMPushService);
    c();
    int m = Process.myUid();
    this.k = TrafficStats.getUidRxBytes(m);
    this.j = TrafficStats.getUidTxBytes(m);
  }
  
  private void c()
  {
    this.g = 0L;
    this.i = 0L;
    this.f = 0L;
    this.h = 0L;
    long l = SystemClock.elapsedRealtime();
    if (com.xiaomi.channel.commonutils.network.d.d(this.a)) {
      this.f = l;
    }
    if (this.a.f()) {
      this.h = l;
    }
  }
  
  private void d()
  {
    try
    {
      com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.e + " netDuration = " + this.g + " ChannelDuration = " + this.i + " channelConnectedTime = " + this.h);
      com.xiaomi.push.thrift.b localb = new com.xiaomi.push.thrift.b();
      localb.a = 0;
      localb.a(com.xiaomi.push.thrift.a.h.a());
      localb.a(this.e);
      localb.d((int)(System.currentTimeMillis() / 1000L));
      localb.b((int)(this.g / 1000L));
      localb.c((int)(this.i / 1000L));
      f.a().a(localb);
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  Exception a()
  {
    return this.d;
  }
  
  public void a(com.xiaomi.smack.a parama)
  {
    b();
    this.h = SystemClock.elapsedRealtime();
    h.a(0, com.xiaomi.push.thrift.a.s.a(), parama.d(), parama.l());
  }
  
  public void a(com.xiaomi.smack.a parama, int paramInt, Exception paramException)
  {
    if ((this.c == 0) && (this.d == null))
    {
      this.c = paramInt;
      this.d = paramException;
      h.b(parama.d(), paramException);
    }
    if ((paramInt == 22) && (this.h != 0L))
    {
      l2 = parama.g() - this.h;
      l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      this.i = (l1 + g.c() / 2 + this.i);
      this.h = 0L;
    }
    b();
    paramInt = Process.myUid();
    long l1 = TrafficStats.getUidRxBytes(paramInt);
    long l2 = TrafficStats.getUidTxBytes(paramInt);
    com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (l1 - this.k) + ", tx=" + (l2 - this.j));
    this.k = l1;
    this.j = l2;
  }
  
  public void a(com.xiaomi.smack.a parama, Exception paramException)
  {
    if (com.xiaomi.channel.commonutils.network.d.d(this.a)) {}
    for (int m = 1;; m = 0)
    {
      h.a(0, com.xiaomi.push.thrift.a.d.a(), 1, parama.d(), m);
      b();
      return;
    }
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	com/xiaomi/stats/e:a	Lcom/xiaomi/push/service/XMPushService;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 42	com/xiaomi/stats/e:a	Lcom/xiaomi/push/service/XMPushService;
    //   20: invokestatic 47	com/xiaomi/channel/commonutils/network/d:k	(Landroid/content/Context;)Ljava/lang/String;
    //   23: astore 4
    //   25: aload_0
    //   26: getfield 42	com/xiaomi/stats/e:a	Lcom/xiaomi/push/service/XMPushService;
    //   29: invokestatic 76	com/xiaomi/channel/commonutils/network/d:d	(Landroid/content/Context;)Z
    //   32: istore_1
    //   33: invokestatic 73	android/os/SystemClock:elapsedRealtime	()J
    //   36: lstore_2
    //   37: aload_0
    //   38: getfield 30	com/xiaomi/stats/e:f	J
    //   41: lconst_0
    //   42: lcmp
    //   43: ifle +23 -> 66
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 32	com/xiaomi/stats/e:g	J
    //   51: lload_2
    //   52: aload_0
    //   53: getfield 30	com/xiaomi/stats/e:f	J
    //   56: lsub
    //   57: ladd
    //   58: putfield 32	com/xiaomi/stats/e:g	J
    //   61: aload_0
    //   62: lconst_0
    //   63: putfield 30	com/xiaomi/stats/e:f	J
    //   66: aload_0
    //   67: getfield 34	com/xiaomi/stats/e:h	J
    //   70: lconst_0
    //   71: lcmp
    //   72: ifeq +23 -> 95
    //   75: aload_0
    //   76: aload_0
    //   77: getfield 36	com/xiaomi/stats/e:i	J
    //   80: lload_2
    //   81: aload_0
    //   82: getfield 34	com/xiaomi/stats/e:h	J
    //   85: lsub
    //   86: ladd
    //   87: putfield 36	com/xiaomi/stats/e:i	J
    //   90: aload_0
    //   91: lconst_0
    //   92: putfield 34	com/xiaomi/stats/e:h	J
    //   95: iload_1
    //   96: ifeq -83 -> 13
    //   99: aload_0
    //   100: getfield 49	com/xiaomi/stats/e:e	Ljava/lang/String;
    //   103: aload 4
    //   105: invokestatic 197	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   108: ifne +14 -> 122
    //   111: aload_0
    //   112: getfield 32	com/xiaomi/stats/e:g	J
    //   115: ldc2_w 198
    //   118: lcmp
    //   119: ifgt +14 -> 133
    //   122: aload_0
    //   123: getfield 32	com/xiaomi/stats/e:g	J
    //   126: ldc2_w 200
    //   129: lcmp
    //   130: ifle +7 -> 137
    //   133: aload_0
    //   134: invokespecial 203	com/xiaomi/stats/e:d	()V
    //   137: aload_0
    //   138: aload 4
    //   140: putfield 49	com/xiaomi/stats/e:e	Ljava/lang/String;
    //   143: aload_0
    //   144: getfield 30	com/xiaomi/stats/e:f	J
    //   147: lconst_0
    //   148: lcmp
    //   149: ifne +8 -> 157
    //   152: aload_0
    //   153: lload_2
    //   154: putfield 30	com/xiaomi/stats/e:f	J
    //   157: aload_0
    //   158: getfield 42	com/xiaomi/stats/e:a	Lcom/xiaomi/push/service/XMPushService;
    //   161: invokevirtual 81	com/xiaomi/push/service/XMPushService:f	()Z
    //   164: ifeq -151 -> 13
    //   167: aload_0
    //   168: lload_2
    //   169: putfield 34	com/xiaomi/stats/e:h	J
    //   172: goto -159 -> 13
    //   175: astore 4
    //   177: aload_0
    //   178: monitorexit
    //   179: aload 4
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	e
    //   32	64	1	bool	boolean
    //   36	133	2	l	long
    //   6	133	4	localObject1	Object
    //   175	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	175	finally
    //   16	66	175	finally
    //   66	95	175	finally
    //   99	122	175	finally
    //   122	133	175	finally
    //   133	137	175	finally
    //   137	157	175	finally
    //   157	172	175	finally
  }
  
  public void b(com.xiaomi.smack.a parama)
  {
    this.c = 0;
    this.d = null;
    this.b = parama;
    h.a(0, com.xiaomi.push.thrift.a.s.a());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/stats/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */