package com.megvii.zhimasdk.b.a.i.c.a;

import com.megvii.zhimasdk.b.a.e.q;
import com.megvii.zhimasdk.b.a.i.c.l;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
public abstract class a
{
  public com.megvii.zhimasdk.b.a.h.b a = new com.megvii.zhimasdk.b.a.h.b(getClass());
  protected final Lock b = new ReentrantLock();
  protected Set<b> c = new HashSet();
  protected volatile boolean d;
  protected l e = new l();
  
  public void a()
  {
    this.b.lock();
    try
    {
      boolean bool = this.d;
      if (bool) {
        return;
      }
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        localIterator.remove();
        a(localb.c());
      }
      this.e.a();
    }
    finally
    {
      this.b.unlock();
    }
    this.d = true;
    this.b.unlock();
  }
  
  protected void a(q paramq)
  {
    if (paramq != null) {}
    try
    {
      paramq.close();
      return;
    }
    catch (IOException paramq)
    {
      this.a.a("I/O error closing connection", paramq);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/c/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */