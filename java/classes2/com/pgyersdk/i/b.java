package com.pgyersdk.i;

import android.os.AsyncTask;
import android.os.Build.VERSION;

public class b
{
  public static void a(AsyncTask paramAsyncTask)
  {
    if (Build.VERSION.SDK_INT <= 12)
    {
      paramAsyncTask.execute(new Void[0]);
      return;
    }
    paramAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/i/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */