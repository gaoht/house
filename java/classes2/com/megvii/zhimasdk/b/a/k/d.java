package com.megvii.zhimasdk.b.a.k;

import com.megvii.zhimasdk.b.a.e;
import com.megvii.zhimasdk.b.a.g;
import com.megvii.zhimasdk.b.a.h;
import com.megvii.zhimasdk.b.a.o.a;
import java.util.NoSuchElementException;

public class d
  implements g
{
  private final h a;
  private final r b;
  private com.megvii.zhimasdk.b.a.f c = null;
  private com.megvii.zhimasdk.b.a.o.d d = null;
  private u e = null;
  
  public d(h paramh)
  {
    this(paramh, f.b);
  }
  
  public d(h paramh, r paramr)
  {
    this.a = ((h)a.a(paramh, "Header iterator"));
    this.b = ((r)a.a(paramr, "Parser"));
  }
  
  private void b()
  {
    this.e = null;
    this.d = null;
    Object localObject;
    do
    {
      if (this.a.hasNext())
      {
        localObject = this.a.a();
        if ((localObject instanceof com.megvii.zhimasdk.b.a.d))
        {
          this.d = ((com.megvii.zhimasdk.b.a.d)localObject).a();
          this.e = new u(0, this.d.c());
          this.e.a(((com.megvii.zhimasdk.b.a.d)localObject).b());
        }
      }
      else
      {
        return;
      }
      localObject = ((e)localObject).d();
    } while (localObject == null);
    this.d = new com.megvii.zhimasdk.b.a.o.d(((String)localObject).length());
    this.d.a((String)localObject);
    this.e = new u(0, this.d.c());
  }
  
  private void c()
  {
    for (;;)
    {
      if ((this.a.hasNext()) || (this.e != null))
      {
        if ((this.e == null) || (this.e.c())) {
          b();
        }
        if (this.e == null) {}
      }
      else
      {
        while (!this.e.c())
        {
          com.megvii.zhimasdk.b.a.f localf = this.b.b(this.d, this.e);
          if ((localf.a().length() != 0) || (localf.b() != null))
          {
            this.c = localf;
            return;
          }
        }
        if (this.e.c())
        {
          this.e = null;
          this.d = null;
        }
      }
    }
  }
  
  public com.megvii.zhimasdk.b.a.f a()
  {
    if (this.c == null) {
      c();
    }
    if (this.c == null) {
      throw new NoSuchElementException("No more header elements available");
    }
    com.megvii.zhimasdk.b.a.f localf = this.c;
    this.c = null;
    return localf;
  }
  
  public boolean hasNext()
  {
    if (this.c == null) {
      c();
    }
    return this.c != null;
  }
  
  public final Object next()
  {
    return a();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Remove not supported");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/k/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */