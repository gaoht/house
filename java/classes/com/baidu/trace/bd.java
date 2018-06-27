package com.baidu.trace;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.trace.b.a;
import com.baidu.trace.b.d;
import com.baidu.trace.c.e;
import java.lang.ref.WeakReference;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public final class bd
  extends Thread
{
  protected static int b = ar.b;
  protected static Deque<ar.a> c = null;
  protected static boolean d = false;
  protected static int f = 0;
  protected static boolean g = false;
  protected static boolean h = false;
  protected static int i = 30000;
  private static Map<Integer, Integer> q = null;
  private static Map<Integer, Queue<ar.a>> r = null;
  protected ar a = null;
  protected boolean e = false;
  private Context j = null;
  private WeakReference<LBSTraceService> k = null;
  private a l = null;
  private b m = null;
  private Handler n = null;
  private int o = 0;
  private long p = 0L;
  private boolean s = false;
  private boolean t = false;
  private long u = 0L;
  private long v = System.currentTimeMillis();
  private long w = System.currentTimeMillis();
  
  public bd(LBSTraceService paramLBSTraceService)
  {
    this.k = new WeakReference(paramLBSTraceService);
    this.n = ((LBSTraceService)this.k.get()).getTraceHandler();
    this.j = ((LBSTraceService)this.k.get()).getServiceContext();
    this.a = new ar(this.k, this.n);
    this.m = new b((byte)0);
    q = new LinkedHashMap();
    r = new LinkedHashMap();
    c = new LinkedList();
  }
  
  protected static void a(int paramInt)
  {
    r.remove(Integer.valueOf(paramInt));
    q.remove(Integer.valueOf(paramInt));
  }
  
  protected static void a(int paramInt, Queue<ar.a> paramQueue)
  {
    r.put(Integer.valueOf(paramInt), paramQueue);
    q.put(Integer.valueOf(paramInt), Integer.valueOf(e.a()));
  }
  
  protected static void a(Handler paramHandler)
  {
    if ((e.d > 0) && (z.s == 1) && (e.a() - e.d > 60) && (paramHandler != null)) {
      paramHandler.obtainMessage(4).sendToTarget();
    }
  }
  
  protected static void a(boolean paramBoolean)
  {
    if ((r == null) || (r.size() == 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = r.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (Map.Entry)localIterator.next();
        if (localObject1 != null)
        {
          Queue localQueue = (Queue)((Map.Entry)localObject1).getValue();
          localObject1 = (Integer)((Map.Entry)localObject1).getKey();
          if ((localQueue != null) && (localObject1 != null))
          {
            Object localObject2 = (Integer)q.get(localObject1);
            if (localObject2 != null)
            {
              int i1 = e.a();
              if ((paramBoolean) && (i1 - ((Integer)localObject2).intValue() < aw.b))
              {
                localQueue.clear();
                return;
              }
              while (localQueue.size() > 0)
              {
                localObject2 = (ar.a)localQueue.poll();
                aw.a.offerLast(localObject2);
              }
              try
              {
                q.remove(localObject1);
                localIterator.remove();
              }
              catch (Exception localException) {}
            }
          }
        }
      }
    }
  }
  
  protected static void b()
  {
    if (q != null)
    {
      q.clear();
      q = null;
    }
    if (r != null)
    {
      r.clear();
      r = null;
    }
    if (c != null)
    {
      c.clear();
      c = null;
    }
  }
  
  protected static void d()
  {
    int i1 = i / ar.b;
    if (ar.b <= z.p * 1000) {
      b = ar.b;
    }
    for (;;)
    {
      i = i1 * ar.b;
      return;
      int i2 = ar.b / 5000 * 5000;
      ar.b = i2;
      if (i2 % (z.p * 1000) == 0) {
        b = z.p * 1000;
      } else {
        b = 5000;
      }
    }
  }
  
  protected static int e()
  {
    int i1 = 0;
    if (c != null) {
      i1 = c.size() + 0;
    }
    int i2 = i1;
    if (aw.a != null) {
      i2 = i1 + aw.a.size();
    }
    return i2;
  }
  
  protected final void a()
  {
    f = 0;
    g = false;
    h = false;
    d = false;
    this.t = false;
    this.s = false;
    this.e = false;
  }
  
  protected final void a(long paramLong)
  {
    this.p = 0L;
  }
  
  protected final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.t = paramBoolean1;
    this.s = paramBoolean2;
    if (!paramBoolean2) {
      this.o = 0;
    }
  }
  
  protected final void c()
  {
    if ((this.l != null) && (this.m != null))
    {
      this.l.removeCallbacks(this.m);
      if (Build.VERSION.SDK_INT < 18) {
        break label54;
      }
      this.l.getLooper().quitSafely();
    }
    for (;;)
    {
      this.m = null;
      this.l = null;
      return;
      label54:
      this.l.getLooper().quit();
    }
  }
  
  public final void run()
  {
    Looper.prepare();
    this.l = new a();
    this.l.post(this.m);
    Looper.loop();
  }
  
  static final class a
    extends Handler
  {
    public final void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
    }
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      if (bd.d)
      {
        if (bd.b(bd.this)) {
          bd.a(bd.c(bd.this));
        }
        if ((bd.this.a != null) && (System.currentTimeMillis() - bd.d(bd.this) >= ar.b))
        {
          bd.a(bd.this, System.currentTimeMillis());
          bd.this.a.a();
        }
      }
      int i;
      if (bd.a(bd.this))
      {
        bd.e(bd.this);
        i = bd.c.size();
        if (i > 0)
        {
          if ((60000 == bd.f(bd.this) * ar.b) || (i >= 60000 / ar.b))
          {
            bd.a(bd.this, 0);
            bd.a(false);
            am.a(false);
            bd.g = true;
            bd.h = true;
          }
          if (0L == bd.g(bd.this)) {
            bd.b(bd.this, e.a());
          }
          if ((e.a() - bd.g(bd.this) >= 900L) && (bd.h(bd.this) != null))
          {
            bd.b(bd.this, e.a());
            localObject = new Intent("com.baidu.trace.action.SOCKET_RECONNECT");
            bd.h(bd.this).sendBroadcast((Intent)localObject);
          }
          bd.i(bd.this).postDelayed(this, bd.b);
        }
      }
      label729:
      do
      {
        do
        {
          do
          {
            return;
            bd.a(bd.this, 0);
            break;
            if (bd.b(bd.this))
            {
              bd.a(bd.this, 0);
              bd.a(true);
              int k = bd.e();
              int j = bd.b;
              if (!bd.g)
              {
                i = j;
                if (!bd.d)
                {
                  i = j;
                  if (!bd.h) {}
                }
              }
              else
              {
                i = 2000;
              }
              if ((k >= bd.i / ar.b) || ((!bd.d) && (bd.h)))
              {
                if ((!bd.j(bd.this)) && (System.currentTimeMillis() - bd.k(bd.this) >= z.p * 1000))
                {
                  bd.c(bd.this, System.currentTimeMillis());
                  bd.l(bd.this);
                }
                bd.d(bd.this, System.currentTimeMillis());
              }
              for (;;)
              {
                bd.i(bd.this).postDelayed(this, i);
                return;
                if (System.currentTimeMillis() - bd.m(bd.this) >= bd.i)
                {
                  bd.d(bd.this, System.currentTimeMillis());
                  if (k > 0)
                  {
                    if (!bd.j(bd.this))
                    {
                      bd.c(bd.this, System.currentTimeMillis());
                      bd.l(bd.this);
                    }
                  }
                  else if (System.currentTimeMillis() - bd.k(bd.this) >= z.p * 1000)
                  {
                    bd.c(bd.this, System.currentTimeMillis());
                    bd.l(bd.this);
                  }
                }
                else if (System.currentTimeMillis() - bd.k(bd.this) >= z.p * 1000)
                {
                  bd.c(bd.this, System.currentTimeMillis());
                  bd.l(bd.this);
                }
              }
            }
          } while (!bd.this.e);
          bd.a(true);
          i = bd.e();
          if ((i <= 0) && (!bd.h)) {
            break label729;
          }
          if ((d.a(bd.h(bd.this))) && (a.d()))
          {
            if (!bd.j(bd.this)) {
              bd.l(bd.this);
            }
            bd.i(bd.this).postDelayed(this, 2000L);
            return;
          }
          am.a(false);
        } while (bd.c(bd.this) == null);
        localObject = bd.c(bd.this).obtainMessage(141);
        if ((i > 0) || (bd.h)) {}
        for (((Message)localObject).arg1 = 143;; ((Message)localObject).arg1 = 141)
        {
          ((Message)localObject).sendToTarget();
          return;
        }
        localObject = ax.a((short)12, e.a());
        if ((localObject != null) && (d.a(bd.h(bd.this))) && (a.d()))
        {
          bd.f = e.a();
          az.a(bd.c(bd.this));
          a.a((byte[])localObject, bd.c(bd.this));
          return;
        }
      } while (bd.c(bd.this) == null);
      Object localObject = bd.c(bd.this).obtainMessage(141);
      ((Message)localObject).arg1 = 141;
      ((Message)localObject).sendToTarget();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */