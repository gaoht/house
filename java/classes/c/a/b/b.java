package c.a.b;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public abstract class b
  extends c
{
  private boolean a;
  private Timer b;
  private TimerTask c;
  private int d = 60;
  
  private void d()
  {
    if (this.b != null)
    {
      this.b.cancel();
      this.b = null;
    }
    if (this.c != null)
    {
      this.c.cancel();
      this.c = null;
    }
  }
  
  protected abstract Collection<a> a();
  
  protected void b()
  {
    if ((this.b != null) || (this.c != null))
    {
      if (d.b) {
        System.out.println("Connection lost timer stoped");
      }
      d();
    }
  }
  
  protected void c()
  {
    if (this.d <= 0)
    {
      if (d.b) {
        System.out.println("Connection lost timer deactivated");
      }
      return;
    }
    if (d.b) {
      System.out.println("Connection lost timer started");
    }
    d();
    this.b = new Timer();
    this.c = new TimerTask()
    {
      private ArrayList<a> b = new ArrayList();
      
      public void run()
      {
        this.b.clear();
        this.b.addAll(b.this.a());
        long l1 = System.currentTimeMillis();
        long l2 = b.a(b.this) * 1500;
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if ((locala instanceof d))
          {
            d locald = (d)locala;
            if (locald.c() < l1 - l2)
            {
              if (d.b) {
                System.out.println("Closing connection due to no pong received: " + locala.toString());
              }
              locald.a(1006, false);
            }
            else
            {
              locald.sendPing();
            }
          }
        }
        this.b.clear();
      }
    };
    this.b.scheduleAtFixedRate(this.c, this.d * 1000, this.d * 1000);
  }
  
  public int getConnectionLostTimeout()
  {
    return this.d;
  }
  
  public boolean isTcpNoDelay()
  {
    return this.a;
  }
  
  public void setConnectionLostTimeout(int paramInt)
  {
    this.d = paramInt;
    if (this.d <= 0)
    {
      b();
      return;
    }
    c();
  }
  
  public void setTcpNoDelay(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/c/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */