package com.megvii.zhimasdk.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.megvii.zhimasdk.b.a.af;
import com.megvii.zhimasdk.b.a.e;
import com.megvii.zhimasdk.b.a.s;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URI;

public abstract class c
  implements r
{
  private String a = "UTF-8";
  private Handler b;
  private boolean c;
  private boolean d;
  private URI e = null;
  private e[] f = null;
  private Looper g = null;
  private WeakReference<Object> h = new WeakReference(null);
  
  public c()
  {
    this(null);
  }
  
  public c(Looper paramLooper)
  {
    this(localLooper, false);
  }
  
  private c(Looper paramLooper, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (paramLooper != null) {}
      for (;;)
      {
        v.a(bool1, "use looper thread, must call Looper.prepare() first!");
        this.g = paramLooper;
        this.b = new a(this, paramLooper);
        this.d = paramBoolean;
        return;
        bool1 = false;
      }
    }
    if (paramLooper == null) {}
    for (bool1 = bool2;; bool1 = false)
    {
      v.a(bool1, "use pool thread, looper should be null!");
      this.g = null;
      this.b = null;
      break;
    }
  }
  
  protected Message a(int paramInt, Object paramObject)
  {
    return Message.obtain(this.b, paramInt, paramObject);
  }
  
  public void a(int paramInt)
  {
    a.a.b("AsyncHttpRH", String.format("Request retry no. %d", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public abstract void a(int paramInt, e[] paramArrayOfe, byte[] paramArrayOfByte);
  
  public abstract void a(int paramInt, e[] paramArrayOfe, byte[] paramArrayOfByte, Throwable paramThrowable);
  
  public void a(long paramLong1, long paramLong2)
  {
    m localm = a.a;
    if (paramLong2 > 0L) {}
    for (double d1 = paramLong1 * 1.0D / paramLong2 * 100.0D;; d1 = -1.0D)
    {
      localm.a("AsyncHttpRH", String.format("Progress %d from %d (%2.0f%%)", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Double.valueOf(d1) }));
      return;
    }
  }
  
  protected void a(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 0: 
        paramMessage = (Object[])paramMessage.obj;
        if ((paramMessage != null) && (paramMessage.length >= 3))
        {
          a(((Integer)paramMessage[0]).intValue(), (e[])paramMessage[1], (byte[])paramMessage[2]);
          return;
        }
        break;
      }
    }
    catch (Throwable paramMessage)
    {
      a(paramMessage);
      return;
    }
    a.a.e("AsyncHttpRH", "SUCCESS_MESSAGE didn't got enough params");
    return;
    paramMessage = (Object[])paramMessage.obj;
    if ((paramMessage != null) && (paramMessage.length >= 4))
    {
      a(((Integer)paramMessage[0]).intValue(), (e[])paramMessage[1], (byte[])paramMessage[2], (Throwable)paramMessage[3]);
      return;
    }
    a.a.e("AsyncHttpRH", "FAILURE_MESSAGE didn't got enough params");
    return;
    c();
    return;
    d();
    return;
    paramMessage = (Object[])paramMessage.obj;
    if (paramMessage != null)
    {
      int i = paramMessage.length;
      if (i >= 2) {
        try
        {
          a(((Long)paramMessage[0]).longValue(), ((Long)paramMessage[1]).longValue());
          return;
        }
        catch (Throwable paramMessage)
        {
          a.a.b("AsyncHttpRH", "custom onProgress contains an error", paramMessage);
          return;
        }
      }
    }
    a.a.e("AsyncHttpRH", "PROGRESS_MESSAGE didn't got enough params");
    return;
    paramMessage = (Object[])paramMessage.obj;
    if ((paramMessage != null) && (paramMessage.length == 1))
    {
      a(((Integer)paramMessage[0]).intValue());
      return;
    }
    a.a.e("AsyncHttpRH", "RETRY_MESSAGE didn't get enough params");
    return;
    e();
    return;
  }
  
  public void a(s params)
  {
    af localaf;
    byte[] arrayOfByte;
    if (!Thread.currentThread().isInterrupted())
    {
      localaf = params.a();
      arrayOfByte = a(params.b());
      if (!Thread.currentThread().isInterrupted())
      {
        if (localaf.b() < 300) {
          break label85;
        }
        b(localaf.b(), params.e(), arrayOfByte, new com.megvii.zhimasdk.b.a.b.k(localaf.b(), localaf.c()));
      }
    }
    return;
    label85:
    b(localaf.b(), params.e(), arrayOfByte);
  }
  
  public void a(r paramr, s params) {}
  
  public void a(Throwable paramThrowable)
  {
    a.a.b("AsyncHttpRH", "User-space exception detected!", paramThrowable);
    throw new RuntimeException(paramThrowable);
  }
  
  public void a(URI paramURI)
  {
    this.e = paramURI;
  }
  
  public void a(e[] paramArrayOfe)
  {
    this.f = paramArrayOfe;
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  byte[] a(com.megvii.zhimasdk.b.a.k paramk)
  {
    int i = 4096;
    if (paramk != null)
    {
      InputStream localInputStream = paramk.a();
      if (localInputStream != null)
      {
        long l2 = paramk.b();
        if (l2 > 2147483647L) {
          throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
        if (l2 <= 0L) {}
        try
        {
          for (;;)
          {
            com.megvii.zhimasdk.b.a.o.c localc = new com.megvii.zhimasdk.b.a.o.c(i);
            try
            {
              byte[] arrayOfByte = new byte['က'];
              long l1 = 0L;
              label74:
              i = localInputStream.read(arrayOfByte);
              if ((i != -1) && (!Thread.currentThread().isInterrupted()))
              {
                long l3 = i + l1;
                localc.a(arrayOfByte, 0, i);
                if (l2 <= 0L) {}
                for (l1 = 1L;; l1 = l2)
                {
                  b(l3, l1);
                  l1 = l3;
                  break label74;
                  i = (int)l2;
                  break;
                }
              }
              return localc.b();
            }
            finally
            {
              a.a(localInputStream);
              a.a(paramk);
            }
          }
          return null;
        }
        catch (OutOfMemoryError paramk)
        {
          System.gc();
          throw new IOException("File too large to fit into available memory");
        }
      }
    }
  }
  
  public final void b(int paramInt)
  {
    b(a(5, new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public final void b(int paramInt, e[] paramArrayOfe, byte[] paramArrayOfByte)
  {
    b(a(0, new Object[] { Integer.valueOf(paramInt), paramArrayOfe, paramArrayOfByte }));
  }
  
  public final void b(int paramInt, e[] paramArrayOfe, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    b(a(1, new Object[] { Integer.valueOf(paramInt), paramArrayOfe, paramArrayOfByte, paramThrowable }));
  }
  
  public final void b(long paramLong1, long paramLong2)
  {
    b(a(4, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
  }
  
  protected void b(Message paramMessage)
  {
    if ((a()) || (this.b == null)) {
      a(paramMessage);
    }
    while (Thread.currentThread().isInterrupted()) {
      return;
    }
    if (this.b != null) {}
    for (boolean bool = true;; bool = false)
    {
      v.a(bool, "handler should not be null!");
      this.b.sendMessage(paramMessage);
      return;
    }
  }
  
  public void b(r paramr, s params) {}
  
  public boolean b()
  {
    return this.d;
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e()
  {
    a.a.b("AsyncHttpRH", "Request got cancelled");
  }
  
  public final void f()
  {
    b(a(2, null));
  }
  
  public final void g()
  {
    b(a(3, null));
  }
  
  public final void h()
  {
    b(a(6, null));
  }
  
  private static class a
    extends Handler
  {
    private final c a;
    
    a(c paramc, Looper paramLooper)
    {
      super();
      this.a = paramc;
    }
    
    public void handleMessage(Message paramMessage)
    {
      this.a.a(paramMessage);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */