package com.baidu.mapapi.map;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class l<T extends a>
{
  private final f a;
  private final int b;
  private List<T> c;
  private List<l<T>> d = null;
  
  private l(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, int paramInt)
  {
    this(new f(paramDouble1, paramDouble2, paramDouble3, paramDouble4), paramInt);
  }
  
  public l(f paramf)
  {
    this(paramf, 0);
  }
  
  private l(f paramf, int paramInt)
  {
    this.a = paramf;
    this.b = paramInt;
  }
  
  private void a()
  {
    this.d = new ArrayList(4);
    this.d.add(new l(this.a.a, this.a.e, this.a.b, this.a.f, this.b + 1));
    this.d.add(new l(this.a.e, this.a.c, this.a.b, this.a.f, this.b + 1));
    this.d.add(new l(this.a.a, this.a.e, this.a.f, this.a.d, this.b + 1));
    this.d.add(new l(this.a.e, this.a.c, this.a.f, this.a.d, this.b + 1));
    Object localObject = this.c;
    this.c = null;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      a(locala.a().x, locala.a().y, locala);
    }
  }
  
  private void a(double paramDouble1, double paramDouble2, T paramT)
  {
    if (this.d != null) {
      if (paramDouble2 < this.a.f) {
        if (paramDouble1 < this.a.e) {
          ((l)this.d.get(0)).a(paramDouble1, paramDouble2, paramT);
        }
      }
    }
    do
    {
      return;
      ((l)this.d.get(1)).a(paramDouble1, paramDouble2, paramT);
      return;
      if (paramDouble1 < this.a.e)
      {
        ((l)this.d.get(2)).a(paramDouble1, paramDouble2, paramT);
        return;
      }
      ((l)this.d.get(3)).a(paramDouble1, paramDouble2, paramT);
      return;
      if (this.c == null) {
        this.c = new ArrayList();
      }
      this.c.add(paramT);
    } while ((this.c.size() <= 40) || (this.b >= 40));
    a();
  }
  
  private void a(f paramf, Collection<T> paramCollection)
  {
    if (!this.a.a(paramf)) {}
    for (;;)
    {
      return;
      Iterator localIterator;
      if (this.d != null)
      {
        localIterator = this.d.iterator();
        while (localIterator.hasNext()) {
          ((l)localIterator.next()).a(paramf, paramCollection);
        }
      }
      else if (this.c != null)
      {
        if (paramf.b(this.a))
        {
          paramCollection.addAll(this.c);
          return;
        }
        localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (paramf.a(locala.a())) {
            paramCollection.add(locala);
          }
        }
      }
    }
  }
  
  public Collection<T> a(f paramf)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramf, localArrayList);
    return localArrayList;
  }
  
  public void a(T paramT)
  {
    Point localPoint = paramT.a();
    if (this.a.a(localPoint.x, localPoint.y)) {
      a(localPoint.x, localPoint.y, paramT);
    }
  }
  
  static abstract class a
  {
    abstract Point a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */