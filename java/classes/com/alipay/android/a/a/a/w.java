package com.alipay.android.a.a.a;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

final class w
  extends FutureTask<af>
{
  w(v paramv, Callable paramCallable, ab paramab)
  {
    super(paramCallable);
  }
  
  protected final void done()
  {
    z localz = this.a.a();
    if (localz.a() == null) {
      super.done();
    }
    for (;;)
    {
      return;
      try
      {
        get();
        if ((!isCancelled()) && (!localz.f)) {
          continue;
        }
        localz.f = true;
        if ((isCancelled()) && (isDone())) {
          continue;
        }
        cancel(false);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        String.valueOf(localInterruptedException);
        return;
      }
      catch (ExecutionException localExecutionException)
      {
        if ((localExecutionException.getCause() != null) && ((localExecutionException.getCause() instanceof a)))
        {
          locala = (a)localExecutionException.getCause();
          locala.getCode();
          locala.getMsg();
          return;
        }
        String.valueOf(locala);
        return;
      }
      catch (CancellationException localCancellationException)
      {
        a locala;
        locala.f = true;
        return;
      }
      catch (Throwable localThrowable)
      {
        throw new RuntimeException("An error occured while executing http request", localThrowable);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/android/a/a/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */