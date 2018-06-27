package android.support.v4.os;

import android.os.AsyncTask;

@Deprecated
public final class AsyncTaskCompat
{
  @Deprecated
  public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> executeParallel(AsyncTask<Params, Progress, Result> paramAsyncTask, Params... paramVarArgs)
  {
    if (paramAsyncTask == null) {
      throw new IllegalArgumentException("task can not be null");
    }
    paramAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramVarArgs);
    return paramAsyncTask;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v4/os/AsyncTaskCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */