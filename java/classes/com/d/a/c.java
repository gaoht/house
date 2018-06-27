package com.d.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class c
  extends a
{
  boolean b = false;
  private ArrayList<a> c = new ArrayList();
  private HashMap<a, e> d = new HashMap();
  private ArrayList<e> e = new ArrayList();
  private ArrayList<e> f = new ArrayList();
  private boolean g = true;
  private a h = null;
  private boolean i = false;
  private long j = 0L;
  private n k = null;
  private long l = -1L;
  
  private void a()
  {
    Object localObject1;
    int n;
    int m;
    Object localObject2;
    int i1;
    int i2;
    if (this.g)
    {
      this.f.clear();
      localObject1 = new ArrayList();
      n = this.e.size();
      m = 0;
      while (m < n)
      {
        localObject2 = (e)this.e.get(m);
        if ((((e)localObject2).b == null) || (((e)localObject2).b.size() == 0)) {
          ((ArrayList)localObject1).add(localObject2);
        }
        m += 1;
      }
      localObject2 = new ArrayList();
      while (((ArrayList)localObject1).size() > 0)
      {
        i1 = ((ArrayList)localObject1).size();
        m = 0;
        while (m < i1)
        {
          e locale1 = (e)((ArrayList)localObject1).get(m);
          this.f.add(locale1);
          if (locale1.e != null)
          {
            i2 = locale1.e.size();
            n = 0;
            while (n < i2)
            {
              e locale2 = (e)locale1.e.get(n);
              locale2.d.remove(locale1);
              if (locale2.d.size() == 0) {
                ((ArrayList)localObject2).add(locale2);
              }
              n += 1;
            }
          }
          m += 1;
        }
        ((ArrayList)localObject1).clear();
        ((ArrayList)localObject1).addAll((Collection)localObject2);
        ((ArrayList)localObject2).clear();
      }
      this.g = false;
      if (this.f.size() != this.e.size()) {
        throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
      }
    }
    else
    {
      i1 = this.e.size();
      m = 0;
      while (m < i1)
      {
        localObject1 = (e)this.e.get(m);
        if ((((e)localObject1).b != null) && (((e)localObject1).b.size() > 0))
        {
          i2 = ((e)localObject1).b.size();
          n = 0;
          while (n < i2)
          {
            localObject2 = (c)((e)localObject1).b.get(n);
            if (((e)localObject1).d == null) {
              ((e)localObject1).d = new ArrayList();
            }
            if (!((e)localObject1).d.contains(((c)localObject2).a)) {
              ((e)localObject1).d.add(((c)localObject2).a);
            }
            n += 1;
          }
        }
        ((e)localObject1).f = false;
        m += 1;
      }
    }
  }
  
  public void cancel()
  {
    this.b = true;
    Object localObject;
    Iterator localIterator;
    if (isStarted())
    {
      if (this.a == null) {
        break label173;
      }
      localObject = (ArrayList)this.a.clone();
      localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).onAnimationCancel(this);
      }
    }
    for (;;)
    {
      if ((this.k != null) && (this.k.isRunning())) {
        this.k.cancel();
      }
      while (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((a.a)((Iterator)localObject).next()).onAnimationEnd(this);
        }
        if (this.f.size() > 0)
        {
          localIterator = this.f.iterator();
          while (localIterator.hasNext()) {
            ((e)localIterator.next()).a.cancel();
          }
        }
      }
      this.i = false;
      return;
      label173:
      localObject = null;
    }
  }
  
  public c clone()
  {
    c localc = (c)super.clone();
    localc.g = true;
    localc.b = false;
    localc.i = false;
    localc.c = new ArrayList();
    localc.d = new HashMap();
    localc.e = new ArrayList();
    localc.f = new ArrayList();
    HashMap localHashMap = new HashMap();
    Object localObject3 = this.e.iterator();
    Object localObject2;
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (e)((Iterator)localObject3).next();
      localObject2 = ((e)localObject1).clone();
      localHashMap.put(localObject1, localObject2);
      localc.e.add(localObject2);
      localc.d.put(((e)localObject2).a, localObject2);
      ((e)localObject2).b = null;
      ((e)localObject2).c = null;
      ((e)localObject2).e = null;
      ((e)localObject2).d = null;
      localObject4 = ((e)localObject2).a.getListeners();
      if (localObject4 != null)
      {
        Iterator localIterator = ((ArrayList)localObject4).iterator();
        localObject1 = null;
        while (localIterator.hasNext())
        {
          a.a locala = (a.a)localIterator.next();
          if ((locala instanceof a))
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(locala);
            localObject1 = localObject2;
          }
        }
        if (localObject1 != null)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((ArrayList)localObject4).remove((a.a)((Iterator)localObject1).next());
          }
        }
      }
    }
    Object localObject1 = this.e.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (e)((Iterator)localObject1).next();
      localObject2 = (e)localHashMap.get(localObject3);
      if (((e)localObject3).b != null)
      {
        localObject3 = ((e)localObject3).b.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (c)((Iterator)localObject3).next();
          ((e)localObject2).addDependency(new c((e)localHashMap.get(((c)localObject4).a), ((c)localObject4).b));
        }
      }
    }
    return localc;
  }
  
  public void end()
  {
    this.b = true;
    if (isStarted())
    {
      Iterator localIterator;
      if (this.f.size() != this.e.size())
      {
        a();
        localIterator = this.f.iterator();
        while (localIterator.hasNext())
        {
          e locale = (e)localIterator.next();
          if (this.h == null) {
            this.h = new a(this);
          }
          locale.a.addListener(this.h);
        }
      }
      if (this.k != null) {
        this.k.cancel();
      }
      if (this.f.size() > 0)
      {
        localIterator = this.f.iterator();
        while (localIterator.hasNext()) {
          ((e)localIterator.next()).a.end();
        }
      }
      if (this.a != null)
      {
        localIterator = ((ArrayList)this.a.clone()).iterator();
        while (localIterator.hasNext()) {
          ((a.a)localIterator.next()).onAnimationEnd(this);
        }
      }
      this.i = false;
    }
  }
  
  public ArrayList<a> getChildAnimations()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((e)localIterator.next()).a);
    }
    return localArrayList;
  }
  
  public long getDuration()
  {
    return this.l;
  }
  
  public long getStartDelay()
  {
    return this.j;
  }
  
  public boolean isRunning()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      if (((e)localIterator.next()).a.isRunning()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isStarted()
  {
    return this.i;
  }
  
  public b play(a parama)
  {
    if (parama != null)
    {
      this.g = true;
      return new b(parama);
    }
    return null;
  }
  
  public void playSequentially(List<a> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.g = true;
      if (paramList.size() != 1) {
        break label44;
      }
      play((a)paramList.get(0));
    }
    for (;;)
    {
      return;
      label44:
      int m = 0;
      while (m < paramList.size() - 1)
      {
        play((a)paramList.get(m)).before((a)paramList.get(m + 1));
        m += 1;
      }
    }
  }
  
  public void playSequentially(a... paramVarArgs)
  {
    int m = 0;
    if (paramVarArgs != null)
    {
      this.g = true;
      if (paramVarArgs.length != 1) {
        break label26;
      }
      play(paramVarArgs[0]);
    }
    for (;;)
    {
      return;
      label26:
      while (m < paramVarArgs.length - 1)
      {
        play(paramVarArgs[m]).before(paramVarArgs[(m + 1)]);
        m += 1;
      }
    }
  }
  
  public void playTogether(Collection<a> paramCollection)
  {
    if ((paramCollection != null) && (paramCollection.size() > 0))
    {
      this.g = true;
      a locala = null;
      Iterator localIterator = paramCollection.iterator();
      paramCollection = locala;
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if (paramCollection == null) {
          paramCollection = play(locala);
        }
        for (;;)
        {
          break;
          paramCollection.with(locala);
        }
      }
    }
  }
  
  public void playTogether(a... paramVarArgs)
  {
    int m = 1;
    if (paramVarArgs != null)
    {
      this.g = true;
      b localb = play(paramVarArgs[0]);
      while (m < paramVarArgs.length)
      {
        localb.with(paramVarArgs[m]);
        m += 1;
      }
    }
  }
  
  public c setDuration(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("duration must be a value of zero or greater");
    }
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).a.setDuration(paramLong);
    }
    this.l = paramLong;
    return this;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).a.setInterpolator(paramInterpolator);
    }
  }
  
  public void setStartDelay(long paramLong)
  {
    this.j = paramLong;
  }
  
  public void setTarget(Object paramObject)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      a locala = ((e)localIterator.next()).a;
      if ((locala instanceof c)) {
        ((c)locala).setTarget(paramObject);
      } else if ((locala instanceof j)) {
        ((j)locala).setTarget(paramObject);
      }
    }
  }
  
  public void setupEndValues()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).a.setupEndValues();
    }
  }
  
  public void setupStartValues()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).a.setupStartValues();
    }
  }
  
  public void start()
  {
    int i1 = 0;
    this.b = false;
    this.i = true;
    a();
    int i2 = this.f.size();
    int m = 0;
    Object localObject2;
    Object localObject3;
    while (m < i2)
    {
      localObject1 = (e)this.f.get(m);
      localObject2 = ((e)localObject1).a.getListeners();
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject2 = new ArrayList((Collection)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (a.a)((Iterator)localObject2).next();
          if (((localObject3 instanceof d)) || ((localObject3 instanceof a))) {
            ((e)localObject1).a.removeListener((a.a)localObject3);
          }
        }
      }
      m += 1;
    }
    final Object localObject1 = new ArrayList();
    m = 0;
    int n;
    if (m < i2)
    {
      localObject2 = (e)this.f.get(m);
      if (this.h == null) {
        this.h = new a(this);
      }
      if ((((e)localObject2).b == null) || (((e)localObject2).b.size() == 0)) {
        ((ArrayList)localObject1).add(localObject2);
      }
      for (;;)
      {
        ((e)localObject2).a.addListener(this.h);
        m += 1;
        break;
        int i3 = ((e)localObject2).b.size();
        n = 0;
        while (n < i3)
        {
          localObject3 = (c)((e)localObject2).b.get(n);
          ((c)localObject3).a.a.addListener(new d(this, (e)localObject2, ((c)localObject3).b));
          n += 1;
        }
        ((e)localObject2).c = ((ArrayList)((e)localObject2).b.clone());
      }
    }
    if (this.j <= 0L)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (e)((Iterator)localObject1).next();
        ((e)localObject2).a.start();
        this.c.add(((e)localObject2).a);
      }
    }
    this.k = n.ofFloat(new float[] { 0.0F, 1.0F });
    this.k.setDuration(this.j);
    this.k.addListener(new b()
    {
      boolean a = false;
      
      public void onAnimationCancel(a paramAnonymousa)
      {
        this.a = true;
      }
      
      public void onAnimationEnd(a paramAnonymousa)
      {
        if (!this.a)
        {
          int j = localObject1.size();
          int i = 0;
          while (i < j)
          {
            paramAnonymousa = (c.e)localObject1.get(i);
            paramAnonymousa.a.start();
            c.a(c.this).add(paramAnonymousa.a);
            i += 1;
          }
        }
      }
    });
    this.k.start();
    if (this.a != null)
    {
      localObject1 = (ArrayList)this.a.clone();
      n = ((ArrayList)localObject1).size();
      m = 0;
      while (m < n)
      {
        ((a.a)((ArrayList)localObject1).get(m)).onAnimationStart(this);
        m += 1;
      }
    }
    if ((this.e.size() == 0) && (this.j == 0L))
    {
      this.i = false;
      if (this.a != null)
      {
        localObject1 = (ArrayList)this.a.clone();
        n = ((ArrayList)localObject1).size();
        m = i1;
        while (m < n)
        {
          ((a.a)((ArrayList)localObject1).get(m)).onAnimationEnd(this);
          m += 1;
        }
      }
    }
  }
  
  private class a
    implements a.a
  {
    private c b;
    
    a(c paramc)
    {
      this.b = paramc;
    }
    
    public void onAnimationCancel(a parama)
    {
      if ((!c.this.b) && (c.a(c.this).size() == 0) && (c.this.a != null))
      {
        int j = c.this.a.size();
        int i = 0;
        while (i < j)
        {
          ((a.a)c.this.a.get(i)).onAnimationCancel(this.b);
          i += 1;
        }
      }
    }
    
    public void onAnimationEnd(a parama)
    {
      parama.removeListener(this);
      c.a(c.this).remove(parama);
      ((c.e)c.b(this.b).get(parama)).f = true;
      int j;
      if (!c.this.b)
      {
        parama = c.c(this.b);
        j = parama.size();
        i = 0;
        if (i >= j) {
          break label162;
        }
        if (((c.e)parama.get(i)).f) {}
      }
      label162:
      for (int i = 0;; i = 1)
      {
        if (i != 0)
        {
          if (c.this.a != null)
          {
            parama = (ArrayList)c.this.a.clone();
            j = parama.size();
            i = 0;
            for (;;)
            {
              if (i < j)
              {
                ((a.a)parama.get(i)).onAnimationEnd(this.b);
                i += 1;
                continue;
                i += 1;
                break;
              }
            }
          }
          c.a(this.b, false);
        }
        return;
      }
    }
    
    public void onAnimationRepeat(a parama) {}
    
    public void onAnimationStart(a parama) {}
  }
  
  public class b
  {
    private c.e b;
    
    b(a parama)
    {
      this.b = ((c.e)c.b(c.this).get(parama));
      if (this.b == null)
      {
        this.b = new c.e(parama);
        c.b(c.this).put(parama, this.b);
        c.d(c.this).add(this.b);
      }
    }
    
    public b after(long paramLong)
    {
      n localn = n.ofFloat(new float[] { 0.0F, 1.0F });
      localn.setDuration(paramLong);
      after(localn);
      return this;
    }
    
    public b after(a parama)
    {
      c.e locale2 = (c.e)c.b(c.this).get(parama);
      c.e locale1 = locale2;
      if (locale2 == null)
      {
        locale1 = new c.e(parama);
        c.b(c.this).put(parama, locale1);
        c.d(c.this).add(locale1);
      }
      parama = new c.c(locale1, 1);
      this.b.addDependency(parama);
      return this;
    }
    
    public b before(a parama)
    {
      c.e locale2 = (c.e)c.b(c.this).get(parama);
      c.e locale1 = locale2;
      if (locale2 == null)
      {
        locale1 = new c.e(parama);
        c.b(c.this).put(parama, locale1);
        c.d(c.this).add(locale1);
      }
      locale1.addDependency(new c.c(this.b, 1));
      return this;
    }
    
    public b with(a parama)
    {
      c.e locale2 = (c.e)c.b(c.this).get(parama);
      c.e locale1 = locale2;
      if (locale2 == null)
      {
        locale1 = new c.e(parama);
        c.b(c.this).put(parama, locale1);
        c.d(c.this).add(locale1);
      }
      locale1.addDependency(new c.c(this.b, 0));
      return this;
    }
  }
  
  private static class c
  {
    public c.e a;
    public int b;
    
    public c(c.e parame, int paramInt)
    {
      this.a = parame;
      this.b = paramInt;
    }
  }
  
  private static class d
    implements a.a
  {
    private c a;
    private c.e b;
    private int c;
    
    public d(c paramc, c.e parame, int paramInt)
    {
      this.a = paramc;
      this.b = parame;
      this.c = paramInt;
    }
    
    private void a(a parama)
    {
      if (this.a.b) {
        return;
      }
      int j = this.b.c.size();
      int i = 0;
      label24:
      c.c localc;
      if (i < j)
      {
        localc = (c.c)this.b.c.get(i);
        if ((localc.b == this.c) && (localc.a.a == parama)) {
          parama.removeListener(this);
        }
      }
      for (parama = localc;; parama = null)
      {
        this.b.c.remove(parama);
        if (this.b.c.size() != 0) {
          break;
        }
        this.b.a.start();
        c.a(this.a).add(this.b.a);
        return;
        i += 1;
        break label24;
      }
    }
    
    public void onAnimationCancel(a parama) {}
    
    public void onAnimationEnd(a parama)
    {
      if (this.c == 1) {
        a(parama);
      }
    }
    
    public void onAnimationRepeat(a parama) {}
    
    public void onAnimationStart(a parama)
    {
      if (this.c == 0) {
        a(parama);
      }
    }
  }
  
  private static class e
    implements Cloneable
  {
    public a a;
    public ArrayList<c.c> b = null;
    public ArrayList<c.c> c = null;
    public ArrayList<e> d = null;
    public ArrayList<e> e = null;
    public boolean f = false;
    
    public e(a parama)
    {
      this.a = parama;
    }
    
    public void addDependency(c.c paramc)
    {
      if (this.b == null)
      {
        this.b = new ArrayList();
        this.d = new ArrayList();
      }
      this.b.add(paramc);
      if (!this.d.contains(paramc.a)) {
        this.d.add(paramc.a);
      }
      paramc = paramc.a;
      if (paramc.e == null) {
        paramc.e = new ArrayList();
      }
      paramc.e.add(this);
    }
    
    public e clone()
    {
      try
      {
        e locale = (e)super.clone();
        locale.a = this.a.clone();
        return locale;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        throw new AssertionError();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/d/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */