package b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class j<TResult>
{
  public static final ExecutorService a = ;
  public static final Executor b = b.uiThread();
  private static final Executor c = c.b();
  private static volatile b d;
  private static j<?> m = new j(null);
  private static j<Boolean> n = new j(Boolean.valueOf(true));
  private static j<Boolean> o = new j(Boolean.valueOf(false));
  private static j<?> p = new j(true);
  private final Object e = new Object();
  private boolean f;
  private boolean g;
  private TResult h;
  private Exception i;
  private boolean j;
  private l k;
  private List<h<TResult, Void>> l = new ArrayList();
  
  j() {}
  
  private j(TResult paramTResult)
  {
    a(paramTResult);
  }
  
  private j(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a();
      return;
    }
    a(null);
  }
  
  static j<Void> a(long paramLong, ScheduledExecutorService paramScheduledExecutorService, d paramd)
  {
    if ((paramd != null) && (paramd.isCancellationRequested())) {
      return cancelled();
    }
    if (paramLong <= 0L) {
      return forResult(null);
    }
    final k localk = new k();
    paramScheduledExecutorService = paramScheduledExecutorService.schedule(new Runnable()
    {
      public void run()
      {
        this.a.trySetResult(null);
      }
    }, paramLong, TimeUnit.MILLISECONDS);
    if (paramd != null) {
      paramd.register(new Runnable()
      {
        public void run()
        {
          this.a.cancel(true);
          localk.trySetCancelled();
        }
      });
    }
    return localk.getTask();
  }
  
  private void b()
  {
    for (;;)
    {
      h localh;
      synchronized (this.e)
      {
        Iterator localIterator = this.l.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localh = (h)localIterator.next();
      }
      try
      {
        localh.then(this);
      }
      catch (RuntimeException localRuntimeException)
      {
        throw localRuntimeException;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    }
    this.l = null;
  }
  
  private static <TContinuationResult, TResult> void c(final k<TContinuationResult> paramk, final h<TResult, TContinuationResult> paramh, final j<TResult> paramj, Executor paramExecutor, d paramd)
  {
    try
    {
      paramExecutor.execute(new Runnable()
      {
        public void run()
        {
          if ((this.a != null) && (this.a.isCancellationRequested()))
          {
            paramk.setCancelled();
            return;
          }
          try
          {
            Object localObject = paramh.then(paramj);
            paramk.setResult(localObject);
            return;
          }
          catch (CancellationException localCancellationException)
          {
            paramk.setCancelled();
            return;
          }
          catch (Exception localException)
          {
            paramk.setError(localException);
          }
        }
      });
      return;
    }
    catch (Exception paramh)
    {
      paramk.setError(new i(paramh));
    }
  }
  
  public static <TResult> j<TResult> call(Callable<TResult> paramCallable)
  {
    return call(paramCallable, c, null);
  }
  
  public static <TResult> j<TResult> call(Callable<TResult> paramCallable, d paramd)
  {
    return call(paramCallable, c, paramd);
  }
  
  public static <TResult> j<TResult> call(Callable<TResult> paramCallable, Executor paramExecutor)
  {
    return call(paramCallable, paramExecutor, null);
  }
  
  public static <TResult> j<TResult> call(final Callable<TResult> paramCallable, Executor paramExecutor, d paramd)
  {
    final k localk = new k();
    try
    {
      paramExecutor.execute(new Runnable()
      {
        public void run()
        {
          if ((this.a != null) && (this.a.isCancellationRequested()))
          {
            localk.setCancelled();
            return;
          }
          try
          {
            localk.setResult(paramCallable.call());
            return;
          }
          catch (CancellationException localCancellationException)
          {
            localk.setCancelled();
            return;
          }
          catch (Exception localException)
          {
            localk.setError(localException);
          }
        }
      });
      return localk.getTask();
    }
    catch (Exception paramCallable)
    {
      for (;;)
      {
        localk.setError(new i(paramCallable));
      }
    }
  }
  
  public static <TResult> j<TResult> callInBackground(Callable<TResult> paramCallable)
  {
    return call(paramCallable, a, null);
  }
  
  public static <TResult> j<TResult> callInBackground(Callable<TResult> paramCallable, d paramd)
  {
    return call(paramCallable, a, paramd);
  }
  
  public static <TResult> j<TResult> cancelled()
  {
    return p;
  }
  
  public static <TResult> j<TResult>.a create()
  {
    j localj = new j();
    localj.getClass();
    return new a();
  }
  
  private static <TContinuationResult, TResult> void d(final k<TContinuationResult> paramk, final h<TResult, j<TContinuationResult>> paramh, final j<TResult> paramj, Executor paramExecutor, d paramd)
  {
    try
    {
      paramExecutor.execute(new Runnable()
      {
        public void run()
        {
          if ((this.a != null) && (this.a.isCancellationRequested()))
          {
            paramk.setCancelled();
            return;
          }
          try
          {
            j localj = (j)paramh.then(paramj);
            if (localj == null)
            {
              paramk.setResult(null);
              return;
            }
          }
          catch (CancellationException localCancellationException)
          {
            paramk.setCancelled();
            return;
            localCancellationException.continueWith(new h()
            {
              public Void then(j<TContinuationResult> paramAnonymous2j)
              {
                if ((j.7.this.a != null) && (j.7.this.a.isCancellationRequested()))
                {
                  j.7.this.b.setCancelled();
                  return null;
                }
                if (paramAnonymous2j.isCancelled())
                {
                  j.7.this.b.setCancelled();
                  return null;
                }
                if (paramAnonymous2j.isFaulted())
                {
                  j.7.this.b.setError(paramAnonymous2j.getError());
                  return null;
                }
                j.7.this.b.setResult(paramAnonymous2j.getResult());
                return null;
              }
            });
            return;
          }
          catch (Exception localException)
          {
            paramk.setError(localException);
          }
        }
      });
      return;
    }
    catch (Exception paramh)
    {
      paramk.setError(new i(paramh));
    }
  }
  
  public static j<Void> delay(long paramLong)
  {
    return a(paramLong, c.a(), null);
  }
  
  public static j<Void> delay(long paramLong, d paramd)
  {
    return a(paramLong, c.a(), paramd);
  }
  
  public static <TResult> j<TResult> forError(Exception paramException)
  {
    k localk = new k();
    localk.setError(paramException);
    return localk.getTask();
  }
  
  public static <TResult> j<TResult> forResult(TResult paramTResult)
  {
    if (paramTResult == null) {
      return m;
    }
    if ((paramTResult instanceof Boolean))
    {
      if (((Boolean)paramTResult).booleanValue()) {
        return n;
      }
      return o;
    }
    k localk = new k();
    localk.setResult(paramTResult);
    return localk.getTask();
  }
  
  public static b getUnobservedExceptionHandler()
  {
    return d;
  }
  
  public static void setUnobservedExceptionHandler(b paramb)
  {
    d = paramb;
  }
  
  public static j<Void> whenAll(Collection<? extends j<?>> paramCollection)
  {
    if (paramCollection.size() == 0) {
      return forResult(null);
    }
    final k localk = new k();
    final ArrayList localArrayList = new ArrayList();
    Object localObject = new Object();
    final AtomicInteger localAtomicInteger = new AtomicInteger(paramCollection.size());
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      ((j)paramCollection.next()).continueWith(new h()
      {
        public Void then(j<Object> paramAnonymousj)
        {
          if (paramAnonymousj.isFaulted()) {}
          synchronized (this.a)
          {
            localArrayList.add(paramAnonymousj.getError());
            if (paramAnonymousj.isCancelled()) {
              localAtomicBoolean.set(true);
            }
            if (localAtomicInteger.decrementAndGet() == 0)
            {
              if (localArrayList.size() == 0) {
                break label143;
              }
              if (localArrayList.size() == 1) {
                localk.setError((Exception)localArrayList.get(0));
              }
            }
            else
            {
              return null;
            }
          }
          paramAnonymousj = new a(String.format("There were %d exceptions.", new Object[] { Integer.valueOf(localArrayList.size()) }), localArrayList);
          localk.setError(paramAnonymousj);
          return null;
          label143:
          if (localAtomicBoolean.get())
          {
            localk.setCancelled();
            return null;
          }
          localk.setResult(null);
          return null;
        }
      });
    }
    return localk.getTask();
  }
  
  public static <TResult> j<List<TResult>> whenAllResult(Collection<? extends j<TResult>> paramCollection)
  {
    whenAll(paramCollection).onSuccess(new h()
    {
      public List<TResult> then(j<Void> paramAnonymousj)
        throws Exception
      {
        if (this.a.size() == 0) {
          return Collections.emptyList();
        }
        paramAnonymousj = new ArrayList();
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
          paramAnonymousj.add(((j)localIterator.next()).getResult());
        }
        return paramAnonymousj;
      }
    });
  }
  
  public static j<j<?>> whenAny(Collection<? extends j<?>> paramCollection)
  {
    if (paramCollection.size() == 0) {
      return forResult(null);
    }
    final k localk = new k();
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      ((j)paramCollection.next()).continueWith(new h()
      {
        public Void then(j<Object> paramAnonymousj)
        {
          if (this.a.compareAndSet(false, true)) {
            localk.setResult(paramAnonymousj);
          }
          for (;;)
          {
            return null;
            paramAnonymousj.getError();
          }
        }
      });
    }
    return localk.getTask();
  }
  
  public static <TResult> j<j<TResult>> whenAnyResult(Collection<? extends j<TResult>> paramCollection)
  {
    if (paramCollection.size() == 0) {
      return forResult(null);
    }
    final k localk = new k();
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      ((j)paramCollection.next()).continueWith(new h()
      {
        public Void then(j<TResult> paramAnonymousj)
        {
          if (this.a.compareAndSet(false, true)) {
            localk.setResult(paramAnonymousj);
          }
          for (;;)
          {
            return null;
            paramAnonymousj.getError();
          }
        }
      });
    }
    return localk.getTask();
  }
  
  boolean a()
  {
    synchronized (this.e)
    {
      if (this.f) {
        return false;
      }
      this.f = true;
      this.g = true;
      this.e.notifyAll();
      b();
      return true;
    }
  }
  
  boolean a(Exception paramException)
  {
    synchronized (this.e)
    {
      if (this.f) {
        return false;
      }
      this.f = true;
      this.i = paramException;
      this.j = false;
      this.e.notifyAll();
      b();
      if ((!this.j) && (getUnobservedExceptionHandler() != null)) {
        this.k = new l(this);
      }
      return true;
    }
  }
  
  boolean a(TResult paramTResult)
  {
    synchronized (this.e)
    {
      if (this.f) {
        return false;
      }
      this.f = true;
      this.h = paramTResult;
      this.e.notifyAll();
      b();
      return true;
    }
  }
  
  public <TOut> j<TOut> cast()
  {
    return this;
  }
  
  public j<Void> continueWhile(Callable<Boolean> paramCallable, h<Void, j<Void>> paramh)
  {
    return continueWhile(paramCallable, paramh, c, null);
  }
  
  public j<Void> continueWhile(Callable<Boolean> paramCallable, h<Void, j<Void>> paramh, d paramd)
  {
    return continueWhile(paramCallable, paramh, c, paramd);
  }
  
  public j<Void> continueWhile(Callable<Boolean> paramCallable, h<Void, j<Void>> paramh, Executor paramExecutor)
  {
    return continueWhile(paramCallable, paramh, paramExecutor, null);
  }
  
  public j<Void> continueWhile(final Callable<Boolean> paramCallable, final h<Void, j<Void>> paramh, final Executor paramExecutor, final d paramd)
  {
    final g localg = new g();
    localg.set(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
        throws Exception
      {
        if ((paramd != null) && (paramd.isCancellationRequested())) {
          return j.cancelled();
        }
        if (((Boolean)paramCallable.call()).booleanValue()) {
          return j.forResult(null).onSuccessTask(paramh, paramExecutor).onSuccessTask((h)localg.get(), paramExecutor);
        }
        return j.forResult(null);
      }
    });
    return makeVoid().continueWithTask((h)localg.get(), paramExecutor);
  }
  
  public <TContinuationResult> j<TContinuationResult> continueWith(h<TResult, TContinuationResult> paramh)
  {
    return continueWith(paramh, c, null);
  }
  
  public <TContinuationResult> j<TContinuationResult> continueWith(h<TResult, TContinuationResult> paramh, d paramd)
  {
    return continueWith(paramh, c, paramd);
  }
  
  public <TContinuationResult> j<TContinuationResult> continueWith(h<TResult, TContinuationResult> paramh, Executor paramExecutor)
  {
    return continueWith(paramh, paramExecutor, null);
  }
  
  public <TContinuationResult> j<TContinuationResult> continueWith(final h<TResult, TContinuationResult> paramh, final Executor paramExecutor, final d paramd)
  {
    final k localk = new k();
    synchronized (this.e)
    {
      boolean bool = isCompleted();
      if (!bool) {
        this.l.add(new h()
        {
          public Void then(j<TResult> paramAnonymousj)
          {
            j.a(localk, paramh, paramAnonymousj, paramExecutor, paramd);
            return null;
          }
        });
      }
      if (bool) {
        c(localk, paramh, this, paramExecutor, paramd);
      }
      return localk.getTask();
    }
  }
  
  public <TContinuationResult> j<TContinuationResult> continueWithTask(h<TResult, j<TContinuationResult>> paramh)
  {
    return continueWithTask(paramh, c, null);
  }
  
  public <TContinuationResult> j<TContinuationResult> continueWithTask(h<TResult, j<TContinuationResult>> paramh, d paramd)
  {
    return continueWithTask(paramh, c, paramd);
  }
  
  public <TContinuationResult> j<TContinuationResult> continueWithTask(h<TResult, j<TContinuationResult>> paramh, Executor paramExecutor)
  {
    return continueWithTask(paramh, paramExecutor, null);
  }
  
  public <TContinuationResult> j<TContinuationResult> continueWithTask(final h<TResult, j<TContinuationResult>> paramh, final Executor paramExecutor, final d paramd)
  {
    final k localk = new k();
    synchronized (this.e)
    {
      boolean bool = isCompleted();
      if (!bool) {
        this.l.add(new h()
        {
          public Void then(j<TResult> paramAnonymousj)
          {
            j.b(localk, paramh, paramAnonymousj, paramExecutor, paramd);
            return null;
          }
        });
      }
      if (bool) {
        d(localk, paramh, this, paramExecutor, paramd);
      }
      return localk.getTask();
    }
  }
  
  public Exception getError()
  {
    synchronized (this.e)
    {
      if (this.i != null)
      {
        this.j = true;
        if (this.k != null)
        {
          this.k.setObserved();
          this.k = null;
        }
      }
      Exception localException = this.i;
      return localException;
    }
  }
  
  public TResult getResult()
  {
    synchronized (this.e)
    {
      Object localObject2 = this.h;
      return (TResult)localObject2;
    }
  }
  
  public boolean isCancelled()
  {
    synchronized (this.e)
    {
      boolean bool = this.g;
      return bool;
    }
  }
  
  public boolean isCompleted()
  {
    synchronized (this.e)
    {
      boolean bool = this.f;
      return bool;
    }
  }
  
  public boolean isFaulted()
  {
    for (;;)
    {
      synchronized (this.e)
      {
        if (getError() != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public j<Void> makeVoid()
  {
    continueWithTask(new h()
    {
      public j<Void> then(j<TResult> paramAnonymousj)
        throws Exception
      {
        if (paramAnonymousj.isCancelled()) {
          return j.cancelled();
        }
        if (paramAnonymousj.isFaulted()) {
          return j.forError(paramAnonymousj.getError());
        }
        return j.forResult(null);
      }
    });
  }
  
  public <TContinuationResult> j<TContinuationResult> onSuccess(h<TResult, TContinuationResult> paramh)
  {
    return onSuccess(paramh, c, null);
  }
  
  public <TContinuationResult> j<TContinuationResult> onSuccess(h<TResult, TContinuationResult> paramh, d paramd)
  {
    return onSuccess(paramh, c, paramd);
  }
  
  public <TContinuationResult> j<TContinuationResult> onSuccess(h<TResult, TContinuationResult> paramh, Executor paramExecutor)
  {
    return onSuccess(paramh, paramExecutor, null);
  }
  
  public <TContinuationResult> j<TContinuationResult> onSuccess(final h<TResult, TContinuationResult> paramh, Executor paramExecutor, final d paramd)
  {
    continueWithTask(new h()
    {
      public j<TContinuationResult> then(j<TResult> paramAnonymousj)
      {
        if ((paramd != null) && (paramd.isCancellationRequested())) {
          return j.cancelled();
        }
        if (paramAnonymousj.isFaulted()) {
          return j.forError(paramAnonymousj.getError());
        }
        if (paramAnonymousj.isCancelled()) {
          return j.cancelled();
        }
        return paramAnonymousj.continueWith(paramh);
      }
    }, paramExecutor);
  }
  
  public <TContinuationResult> j<TContinuationResult> onSuccessTask(h<TResult, j<TContinuationResult>> paramh)
  {
    return onSuccessTask(paramh, c);
  }
  
  public <TContinuationResult> j<TContinuationResult> onSuccessTask(h<TResult, j<TContinuationResult>> paramh, d paramd)
  {
    return onSuccessTask(paramh, c, paramd);
  }
  
  public <TContinuationResult> j<TContinuationResult> onSuccessTask(h<TResult, j<TContinuationResult>> paramh, Executor paramExecutor)
  {
    return onSuccessTask(paramh, paramExecutor, null);
  }
  
  public <TContinuationResult> j<TContinuationResult> onSuccessTask(final h<TResult, j<TContinuationResult>> paramh, Executor paramExecutor, final d paramd)
  {
    continueWithTask(new h()
    {
      public j<TContinuationResult> then(j<TResult> paramAnonymousj)
      {
        if ((paramd != null) && (paramd.isCancellationRequested())) {
          return j.cancelled();
        }
        if (paramAnonymousj.isFaulted()) {
          return j.forError(paramAnonymousj.getError());
        }
        if (paramAnonymousj.isCancelled()) {
          return j.cancelled();
        }
        return paramAnonymousj.continueWithTask(paramh);
      }
    }, paramExecutor);
  }
  
  public void waitForCompletion()
    throws InterruptedException
  {
    synchronized (this.e)
    {
      if (!isCompleted()) {
        this.e.wait();
      }
      return;
    }
  }
  
  public boolean waitForCompletion(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    synchronized (this.e)
    {
      if (!isCompleted()) {
        this.e.wait(paramTimeUnit.toMillis(paramLong));
      }
      boolean bool = isCompleted();
      return bool;
    }
  }
  
  public class a
    extends k<TResult>
  {
    a() {}
  }
  
  public static abstract interface b
  {
    public abstract void unobservedException(j<?> paramj, m paramm);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */