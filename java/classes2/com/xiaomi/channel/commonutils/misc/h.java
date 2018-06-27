package com.xiaomi.channel.commonutils.misc;

import android.os.Handler;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class h
{
  private a a;
  private Handler b = null;
  private volatile boolean c = false;
  private final boolean d;
  private int e = 0;
  private volatile b f;
  
  public h()
  {
    this(false);
  }
  
  public h(boolean paramBoolean)
  {
    this(paramBoolean, 0);
  }
  
  public h(boolean paramBoolean, int paramInt)
  {
    this.d = paramBoolean;
    this.e = paramInt;
  }
  
  private void a()
  {
    try
    {
      this.a = null;
      this.c = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(b paramb)
  {
    try
    {
      if (this.a == null)
      {
        this.a = new a();
        this.a.setDaemon(this.d);
        this.c = false;
        this.a.start();
      }
      this.a.a(paramb);
      return;
    }
    finally {}
  }
  
  public void a(b paramb, long paramLong)
  {
    this.b.postDelayed(new j(this, paramb), paramLong);
  }
  
  private class a
    extends Thread
  {
    private final LinkedBlockingQueue<h.b> b = new LinkedBlockingQueue();
    
    public a()
    {
      super();
    }
    
    public void a(h.b paramb)
    {
      this.b.add(paramb);
    }
    
    public void run()
    {
      long l;
      if (h.a(h.this) > 0) {
        l = h.a(h.this);
      }
      while (!h.b(h.this))
      {
        try
        {
          h.a(h.this, (h.b)this.b.poll(l, TimeUnit.SECONDS));
          if (h.c(h.this) == null) {
            break label151;
          }
          Message localMessage = h.d(h.this).obtainMessage(0, h.c(h.this));
          h.d(h.this).sendMessage(localMessage);
          h.c(h.this).b();
          localMessage = h.d(h.this).obtainMessage(1, h.c(h.this));
          h.d(h.this).sendMessage(localMessage);
        }
        catch (InterruptedException localInterruptedException)
        {
          b.a(localInterruptedException);
        }
        continue;
        l = Long.MAX_VALUE;
        continue;
        label151:
        if (h.a(h.this) > 0) {
          h.e(h.this);
        }
      }
    }
  }
  
  public static abstract class b
  {
    public void a() {}
    
    public abstract void b();
    
    public void c() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/misc/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */