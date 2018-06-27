package com.xiaomi.slim;

import android.text.TextUtils;
import com.xiaomi.push.protobuf.b.b;
import com.xiaomi.push.protobuf.b.j;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ak.b;
import com.xiaomi.smack.a.a;
import com.xiaomi.smack.l;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class f
  extends com.xiaomi.smack.h
{
  private Thread v;
  private c w;
  private d x;
  
  public f(XMPushService paramXMPushService, com.xiaomi.smack.b paramb)
  {
    super(paramXMPushService, paramb);
  }
  
  private b c(boolean paramBoolean)
  {
    b localb = new b();
    localb.a("PING", null);
    if (paramBoolean) {
      localb.a("1");
    }
    for (;;)
    {
      b.j localj = new b.j();
      byte[] arrayOfByte = c().a();
      if (arrayOfByte != null) {}
      try
      {
        localj.a(b.b.b(arrayOfByte));
        arrayOfByte = com.xiaomi.stats.h.c();
        if (arrayOfByte != null) {
          localj.a(com.google.b.a.a.a(arrayOfByte));
        }
        localb.a(localj.c(), null);
        return localb;
        localb.a("0");
      }
      catch (com.google.b.a.d locald)
      {
        for (;;) {}
      }
    }
  }
  
  private void v()
  {
    try
    {
      this.w = new c(this.p.getInputStream(), this);
      this.x = new d(this.p.getOutputStream(), this);
      this.v = new g(this, "Blob Reader (" + this.l + ")");
      this.v.start();
      return;
    }
    catch (Exception localException)
    {
      throw new l("Error to init reader and writer", localException);
    }
  }
  
  /* Error */
  protected void a(int paramInt, Exception paramException)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/xiaomi/slim/f:w	Lcom/xiaomi/slim/c;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 19	com/xiaomi/slim/f:w	Lcom/xiaomi/slim/c;
    //   13: invokevirtual 148	com/xiaomi/slim/c:b	()V
    //   16: aload_0
    //   17: aconst_null
    //   18: putfield 19	com/xiaomi/slim/f:w	Lcom/xiaomi/slim/c;
    //   21: aload_0
    //   22: getfield 104	com/xiaomi/slim/f:x	Lcom/xiaomi/slim/d;
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull +15 -> 42
    //   30: aload_0
    //   31: getfield 104	com/xiaomi/slim/f:x	Lcom/xiaomi/slim/d;
    //   34: invokevirtual 149	com/xiaomi/slim/d:b	()V
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield 104	com/xiaomi/slim/f:x	Lcom/xiaomi/slim/d;
    //   42: aload_0
    //   43: iload_1
    //   44: aload_2
    //   45: invokespecial 151	com/xiaomi/smack/h:a	(ILjava/lang/Exception;)V
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: astore_3
    //   52: aload_3
    //   53: invokestatic 156	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   56: goto -19 -> 37
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	f
    //   0	64	1	paramInt	int
    //   0	64	2	paramException	Exception
    //   25	2	3	locald	d
    //   51	2	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   30	37	51	java/lang/Exception
    //   2	21	59	finally
    //   21	26	59	finally
    //   30	37	59	finally
    //   37	42	59	finally
    //   42	48	59	finally
    //   52	56	59	finally
  }
  
  public void a(ak.b paramb)
  {
    try
    {
      a.a(paramb, q(), this);
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  void a(b paramb)
  {
    if (paramb == null) {
      return;
    }
    if (paramb.d()) {
      com.xiaomi.channel.commonutils.logger.b.a("[Slim] RCV blob chid=" + paramb.c() + "; id=" + paramb.h() + "; errCode=" + paramb.e() + "; err=" + paramb.f());
    }
    if (paramb.c() == 0)
    {
      if (!"PING".equals(paramb.a())) {
        break label161;
      }
      com.xiaomi.channel.commonutils.logger.b.a("[Slim] RCV ping id=" + paramb.h());
      u();
    }
    for (;;)
    {
      Iterator localIterator = this.g.values().iterator();
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).a(paramb);
      }
      break;
      label161:
      if ("CLOSE".equals(paramb.a())) {
        c(13, null);
      }
    }
  }
  
  @Deprecated
  public void a(com.xiaomi.smack.packet.d paramd)
  {
    b(b.a(paramd, null));
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      a.a(paramString1, paramString2, this);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.x != null)
    {
      b localb = c(paramBoolean);
      com.xiaomi.channel.commonutils.logger.b.a("[Slim] SND ping id=" + localb.h());
      b(localb);
      t();
      return;
    }
    throw new l("The BlobWriter is null.");
  }
  
  public void a(b[] paramArrayOfb)
  {
    int j = paramArrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b(paramArrayOfb[i]);
      i += 1;
    }
  }
  
  public void a(com.xiaomi.smack.packet.d[] paramArrayOfd)
  {
    int j = paramArrayOfd.length;
    int i = 0;
    while (i < j)
    {
      a(paramArrayOfd[i]);
      i += 1;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected void b()
  {
    try
    {
      v();
      this.x.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void b(b paramb)
  {
    if (this.x != null) {
      try
      {
        int i = this.x.a(paramb);
        Object localObject = paramb.i();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          com.xiaomi.smack.util.g.a(this.n, (String)localObject, i, false, System.currentTimeMillis());
        }
        localObject = this.h.values().iterator();
        while (((Iterator)localObject).hasNext())
        {
          ((a.a)((Iterator)localObject).next()).a(paramb);
          continue;
          throw new l("the writer is null.");
        }
      }
      catch (Exception paramb)
      {
        throw new l(paramb);
      }
    }
  }
  
  void b(com.xiaomi.smack.packet.d paramd)
  {
    if (paramd == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.g.values().iterator();
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).a(paramd);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/xiaomi/slim/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */