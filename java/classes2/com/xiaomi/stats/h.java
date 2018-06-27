package com.xiaomi.stats;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ak.b;
import com.xiaomi.push.thrift.c;
import com.xiaomi.xmpush.thrift.aq;
import java.util.Hashtable;

public class h
{
  private static final int a = com.xiaomi.push.thrift.a.c.a();
  
  public static void a()
  {
    a(0, a);
  }
  
  public static void a(int paramInt)
  {
    com.xiaomi.push.thrift.b localb = f.a().f();
    localb.a(com.xiaomi.push.thrift.a.ac.a());
    localb.c(paramInt);
    f.a().a(localb);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 16777215) {}
    for (;;)
    {
      try
      {
        a.a.put(Integer.valueOf(paramInt1 << 24 | paramInt2), Long.valueOf(System.currentTimeMillis()));
        return;
      }
      finally {}
      com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4)
  {
    com.xiaomi.push.thrift.b localb = f.a().f();
    localb.a((byte)paramInt1);
    localb.a(paramInt2);
    localb.b(paramInt3);
    localb.b(paramString);
    localb.c(paramInt4);
    f.a().a(localb);
  }
  
  /* Error */
  public static void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   6: lstore 4
    //   8: iload_0
    //   9: bipush 24
    //   11: ishl
    //   12: iload_1
    //   13: ior
    //   14: istore_0
    //   15: getstatic 52	com/xiaomi/stats/h$a:a	Ljava/util/Hashtable;
    //   18: iload_0
    //   19: invokestatic 58	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   22: invokevirtual 98	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
    //   25: ifeq +86 -> 111
    //   28: invokestatic 31	com/xiaomi/stats/f:a	()Lcom/xiaomi/stats/f;
    //   31: invokevirtual 35	com/xiaomi/stats/f:f	()Lcom/xiaomi/push/thrift/b;
    //   34: astore 6
    //   36: aload 6
    //   38: iload_1
    //   39: invokevirtual 43	com/xiaomi/push/thrift/b:a	(I)Lcom/xiaomi/push/thrift/b;
    //   42: pop
    //   43: aload 6
    //   45: lload 4
    //   47: getstatic 52	com/xiaomi/stats/h$a:a	Ljava/util/Hashtable;
    //   50: iload_0
    //   51: invokestatic 58	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: invokevirtual 102	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 66	java/lang/Long
    //   60: invokevirtual 105	java/lang/Long:longValue	()J
    //   63: lsub
    //   64: l2i
    //   65: invokevirtual 90	com/xiaomi/push/thrift/b:b	(I)Lcom/xiaomi/push/thrift/b;
    //   68: pop
    //   69: aload 6
    //   71: aload_2
    //   72: invokevirtual 93	com/xiaomi/push/thrift/b:b	(Ljava/lang/String;)Lcom/xiaomi/push/thrift/b;
    //   75: pop
    //   76: iload_3
    //   77: iconst_m1
    //   78: if_icmple +10 -> 88
    //   81: aload 6
    //   83: iload_3
    //   84: invokevirtual 45	com/xiaomi/push/thrift/b:c	(I)Lcom/xiaomi/push/thrift/b;
    //   87: pop
    //   88: invokestatic 31	com/xiaomi/stats/f:a	()Lcom/xiaomi/stats/f;
    //   91: aload 6
    //   93: invokevirtual 48	com/xiaomi/stats/f:a	(Lcom/xiaomi/push/thrift/b;)V
    //   96: getstatic 52	com/xiaomi/stats/h$a:a	Ljava/util/Hashtable;
    //   99: iload_1
    //   100: invokestatic 58	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: invokevirtual 108	java/util/Hashtable:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   106: pop
    //   107: ldc 2
    //   109: monitorexit
    //   110: return
    //   111: ldc 110
    //   113: invokestatic 83	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   116: goto -9 -> 107
    //   119: astore_2
    //   120: ldc 2
    //   122: monitorexit
    //   123: aload_2
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramInt1	int
    //   0	125	1	paramInt2	int
    //   0	125	2	paramString	String
    //   0	125	3	paramInt3	int
    //   6	40	4	l	long
    //   34	58	6	localb	com.xiaomi.push.thrift.b
    // Exception table:
    //   from	to	target	type
    //   3	8	119	finally
    //   15	76	119	finally
    //   81	88	119	finally
    //   88	107	119	finally
    //   111	116	119	finally
  }
  
  public static void a(XMPushService paramXMPushService, ak.b paramb)
  {
    new a(paramXMPushService, paramb).a();
  }
  
  public static void a(String paramString, int paramInt, Exception paramException)
  {
    com.xiaomi.push.thrift.b localb = f.a().f();
    if (paramInt > 0)
    {
      localb.a(com.xiaomi.push.thrift.a.i.a());
      localb.b(paramString);
      localb.b(paramInt);
      f.a().a(localb);
      return;
    }
    try
    {
      paramException = d.a(paramException);
      localb.a(paramException.a.a());
      localb.c(paramException.b);
      localb.b(paramString);
      f.a().a(localb);
      return;
    }
    catch (NullPointerException paramString) {}
  }
  
  public static void a(String paramString, Exception paramException)
  {
    try
    {
      paramException = d.b(paramException);
      com.xiaomi.push.thrift.b localb = f.a().f();
      localb.a(paramException.a.a());
      localb.c(paramException.b);
      localb.b(paramString);
      f.a().a(localb);
      return;
    }
    catch (NullPointerException paramString) {}
  }
  
  public static void b()
  {
    a(0, a, null, -1);
  }
  
  public static void b(String paramString, Exception paramException)
  {
    try
    {
      paramException = d.d(paramException);
      com.xiaomi.push.thrift.b localb = f.a().f();
      localb.a(paramException.a.a());
      localb.c(paramException.b);
      localb.b(paramString);
      f.a().a(localb);
      return;
    }
    catch (NullPointerException paramString) {}
  }
  
  public static byte[] c()
  {
    byte[] arrayOfByte = null;
    c localc = f.a().e();
    if (localc != null) {
      arrayOfByte = aq.a(localc);
    }
    return arrayOfByte;
  }
  
  static class a
  {
    static Hashtable<Integer, Long> a = new Hashtable();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/stats/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */