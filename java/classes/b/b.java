package b;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class b
{
  static final int a = e + 1;
  static final int b = e * 2 + 1;
  private static final b c = new b();
  private static final int e = Runtime.getRuntime().availableProcessors();
  private final Executor d = new a(null);
  
  @SuppressLint({"NewApi"})
  public static void allowCoreThreadTimeout(ThreadPoolExecutor paramThreadPoolExecutor, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      paramThreadPoolExecutor.allowCoreThreadTimeOut(paramBoolean);
    }
  }
  
  public static ExecutorService newCachedThreadPool()
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(a, b, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    allowCoreThreadTimeout(localThreadPoolExecutor, true);
    return localThreadPoolExecutor;
  }
  
  public static ExecutorService newCachedThreadPool(ThreadFactory paramThreadFactory)
  {
    paramThreadFactory = new ThreadPoolExecutor(a, b, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(), paramThreadFactory);
    allowCoreThreadTimeout(paramThreadFactory, true);
    return paramThreadFactory;
  }
  
  public static Executor uiThread()
  {
    return c.d;
  }
  
  private static class a
    implements Executor
  {
    public void execute(Runnable paramRunnable)
    {
      new Handler(Looper.getMainLooper()).post(paramRunnable);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */