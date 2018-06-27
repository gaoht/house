package android.support.v7.widget;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;

class ba
{
  final ArrayMap<RecyclerView.u, a> a = new ArrayMap();
  final LongSparseArray<RecyclerView.u> b = new LongSparseArray();
  
  private RecyclerView.e.c a(RecyclerView.u paramu, int paramInt)
  {
    Object localObject2 = null;
    int i = this.a.indexOfKey(paramu);
    Object localObject1;
    if (i < 0) {
      localObject1 = localObject2;
    }
    a locala;
    do
    {
      do
      {
        return (RecyclerView.e.c)localObject1;
        locala = (a)this.a.valueAt(i);
        localObject1 = localObject2;
      } while (locala == null);
      localObject1 = localObject2;
    } while ((locala.a & paramInt) == 0);
    locala.a &= (paramInt ^ 0xFFFFFFFF);
    if (paramInt == 4) {}
    for (paramu = locala.b;; paramu = locala.c)
    {
      localObject1 = paramu;
      if ((locala.a & 0xC) != 0) {
        break;
      }
      this.a.removeAt(i);
      a.a(locala);
      return paramu;
      if (paramInt != 8) {
        break label129;
      }
    }
    label129:
    throw new IllegalArgumentException("Must provide flag PRE or POST");
  }
  
  RecyclerView.u a(long paramLong)
  {
    return (RecyclerView.u)this.b.get(paramLong);
  }
  
  void a()
  {
    this.a.clear();
    this.b.clear();
  }
  
  void a(long paramLong, RecyclerView.u paramu)
  {
    this.b.put(paramLong, paramu);
  }
  
  void a(RecyclerView.u paramu, RecyclerView.e.c paramc)
  {
    a locala2 = (a)this.a.get(paramu);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.a();
      this.a.put(paramu, locala1);
    }
    locala1.b = paramc;
    locala1.a |= 0x4;
  }
  
  void a(b paramb)
  {
    int i = this.a.size() - 1;
    if (i >= 0)
    {
      RecyclerView.u localu = (RecyclerView.u)this.a.keyAt(i);
      a locala = (a)this.a.removeAt(i);
      if ((locala.a & 0x3) == 3) {
        paramb.unused(localu);
      }
      for (;;)
      {
        a.a(locala);
        i -= 1;
        break;
        if ((locala.a & 0x1) != 0)
        {
          if (locala.b == null) {
            paramb.unused(localu);
          } else {
            paramb.processDisappeared(localu, locala.b, locala.c);
          }
        }
        else if ((locala.a & 0xE) == 14) {
          paramb.processAppeared(localu, locala.b, locala.c);
        } else if ((locala.a & 0xC) == 12) {
          paramb.processPersistent(localu, locala.b, locala.c);
        } else if ((locala.a & 0x4) != 0) {
          paramb.processDisappeared(localu, locala.b, null);
        } else if ((locala.a & 0x8) != 0) {
          paramb.processAppeared(localu, locala.b, locala.c);
        } else if ((locala.a & 0x2) == 0) {}
      }
    }
  }
  
  boolean a(RecyclerView.u paramu)
  {
    paramu = (a)this.a.get(paramu);
    return (paramu != null) && ((paramu.a & 0x1) != 0);
  }
  
  RecyclerView.e.c b(RecyclerView.u paramu)
  {
    return a(paramu, 4);
  }
  
  void b() {}
  
  void b(RecyclerView.u paramu, RecyclerView.e.c paramc)
  {
    a locala2 = (a)this.a.get(paramu);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.a();
      this.a.put(paramu, locala1);
    }
    locala1.a |= 0x2;
    locala1.b = paramc;
  }
  
  RecyclerView.e.c c(RecyclerView.u paramu)
  {
    return a(paramu, 8);
  }
  
  void c(RecyclerView.u paramu, RecyclerView.e.c paramc)
  {
    a locala2 = (a)this.a.get(paramu);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.a();
      this.a.put(paramu, locala1);
    }
    locala1.c = paramc;
    locala1.a |= 0x8;
  }
  
  boolean d(RecyclerView.u paramu)
  {
    paramu = (a)this.a.get(paramu);
    return (paramu != null) && ((paramu.a & 0x4) != 0);
  }
  
  void e(RecyclerView.u paramu)
  {
    a locala2 = (a)this.a.get(paramu);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.a();
      this.a.put(paramu, locala1);
    }
    locala1.a |= 0x1;
  }
  
  void f(RecyclerView.u paramu)
  {
    paramu = (a)this.a.get(paramu);
    if (paramu == null) {
      return;
    }
    paramu.a &= 0xFFFFFFFE;
  }
  
  void g(RecyclerView.u paramu)
  {
    int i = this.b.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (paramu == this.b.valueAt(i)) {
          this.b.removeAt(i);
        }
      }
      else
      {
        paramu = (a)this.a.remove(paramu);
        if (paramu != null) {
          a.a(paramu);
        }
        return;
      }
      i -= 1;
    }
  }
  
  public void onViewDetached(RecyclerView.u paramu)
  {
    f(paramu);
  }
  
  static class a
  {
    static Pools.Pool<a> d = new Pools.SimplePool(20);
    int a;
    RecyclerView.e.c b;
    RecyclerView.e.c c;
    
    static a a()
    {
      a locala2 = (a)d.acquire();
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a();
      }
      return locala1;
    }
    
    static void a(a parama)
    {
      parama.a = 0;
      parama.b = null;
      parama.c = null;
      d.release(parama);
    }
    
    static void b()
    {
      while (d.acquire() != null) {}
    }
  }
  
  static abstract interface b
  {
    public abstract void processAppeared(RecyclerView.u paramu, RecyclerView.e.c paramc1, RecyclerView.e.c paramc2);
    
    public abstract void processDisappeared(RecyclerView.u paramu, RecyclerView.e.c paramc1, RecyclerView.e.c paramc2);
    
    public abstract void processPersistent(RecyclerView.u paramu, RecyclerView.e.c paramc1, RecyclerView.e.c paramc2);
    
    public abstract void unused(RecyclerView.u paramu);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */