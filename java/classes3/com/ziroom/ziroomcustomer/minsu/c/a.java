package com.ziroom.ziroomcustomer.minsu.c;

import com.ziroom.ziroomcustomer.util.u;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

public class a
{
  private static a a;
  private static final Object b = new Object();
  private List<a> c;
  private Timer d;
  private TimerTask e;
  private int f = 1000;
  private int g = 1000;
  private final int h = 1;
  private final int i = 2;
  private int j = 1;
  
  private a(a parama)
  {
    if (this.c == null) {
      this.c = new Vector();
    }
    this.c.add(parama);
    u.i("wz", "  +++ --- +++ ==============" + this.c.size());
  }
  
  public static a getInstance(a parama)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("wz error", " getInstance ");
    if (a == null) {}
    for (;;)
    {
      synchronized (b)
      {
        if (a == null) {
          a = new a(parama);
        }
        return a;
      }
      a.stop();
      a = new a(parama);
    }
  }
  
  public void start()
  {
    u.i("wz error", " start cbs.size = " + this.c.size());
    this.d = new Timer();
    this.e = new b();
    this.d.schedule(this.e, this.f, this.g);
    this.j = 2;
  }
  
  public void stop()
  {
    try
    {
      if (a != null)
      {
        if (this.c != null) {
          this.c.clear();
        }
        if (this.e != null)
        {
          this.e.cancel();
          this.e = null;
        }
        if (this.d != null)
        {
          this.d.cancel();
          this.d = null;
        }
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("wz error", "++++ ---- cbs.size = " + this.c.size());
        a = null;
      }
      return;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void onCountDown(long paramLong);
  }
  
  public class b
    extends TimerTask
  {
    public b() {}
    
    public void run()
    {
      u.i("wz", " onTick  +++++ cdh 1");
      if (a.a(a.this) != null)
      {
        u.i("wz", " onTick  +++++ = " + a.a(a.this).size());
        Iterator localIterator = a.a(a.this).iterator();
        while (localIterator.hasNext()) {
          ((a.a)localIterator.next()).onCountDown(a.b(a.this));
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */