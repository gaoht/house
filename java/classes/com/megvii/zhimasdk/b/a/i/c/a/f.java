package com.megvii.zhimasdk.b.a.i.c.a;

import com.megvii.zhimasdk.b.a.e.q;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.o.g;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

@Deprecated
public class f
{
  public com.megvii.zhimasdk.b.a.h.b a = new com.megvii.zhimasdk.b.a.h.b(getClass());
  protected final com.megvii.zhimasdk.b.a.e.b.b b;
  protected final int c;
  protected final com.megvii.zhimasdk.b.a.e.a.b d;
  protected final LinkedList<b> e;
  protected final Queue<h> f;
  protected int g;
  
  public f(com.megvii.zhimasdk.b.a.e.b.b paramb, com.megvii.zhimasdk.b.a.e.a.b paramb1)
  {
    this.b = paramb;
    this.d = paramb1;
    this.c = paramb1.a(paramb);
    this.e = new LinkedList();
    this.f = new LinkedList();
    this.g = 0;
  }
  
  public final com.megvii.zhimasdk.b.a.e.b.b a()
  {
    return this.b;
  }
  
  public b a(Object paramObject)
  {
    Object localObject;
    if (!this.e.isEmpty())
    {
      localObject = this.e.listIterator(this.e.size());
      while (((ListIterator)localObject).hasPrevious())
      {
        b localb = (b)((ListIterator)localObject).previous();
        if ((localb.a() == null) || (g.a(paramObject, localb.a())))
        {
          ((ListIterator)localObject).remove();
          return localb;
        }
      }
    }
    if ((d() == 0) && (!this.e.isEmpty()))
    {
      paramObject = (b)this.e.remove();
      ((b)paramObject).b();
      localObject = ((b)paramObject).c();
      try
      {
        ((q)localObject).close();
        return (b)paramObject;
      }
      catch (IOException localIOException)
      {
        this.a.a("I/O error closing connection", localIOException);
        return (b)paramObject;
      }
    }
    return null;
  }
  
  public void a(b paramb)
  {
    if (this.g < 1) {
      throw new IllegalStateException("No entry created for this pool. " + this.b);
    }
    if (this.g <= this.e.size()) {
      throw new IllegalStateException("No entry allocated from this pool. " + this.b);
    }
    this.e.add(paramb);
  }
  
  public void a(h paramh)
  {
    a.a(paramh, "Waiting thread");
    this.f.add(paramh);
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public void b(b paramb)
  {
    a.a(this.b.equals(paramb.d()), "Entry not planned for this pool");
    this.g += 1;
  }
  
  public void b(h paramh)
  {
    if (paramh == null) {
      return;
    }
    this.f.remove(paramh);
  }
  
  public boolean c()
  {
    return (this.g < 1) && (this.f.isEmpty());
  }
  
  public boolean c(b paramb)
  {
    boolean bool = this.e.remove(paramb);
    if (bool) {
      this.g -= 1;
    }
    return bool;
  }
  
  public int d()
  {
    return this.d.a(this.b) - this.g;
  }
  
  public void e()
  {
    if (this.g > 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.megvii.zhimasdk.b.a.o.b.a(bool, "There is no entry that could be dropped");
      this.g -= 1;
      return;
    }
  }
  
  public boolean f()
  {
    return !this.f.isEmpty();
  }
  
  public h g()
  {
    return (h)this.f.peek();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/c/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */