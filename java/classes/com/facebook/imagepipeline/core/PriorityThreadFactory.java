package com.facebook.imagepipeline.core;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

public class PriorityThreadFactory
  implements ThreadFactory
{
  private final int mThreadPriority;
  
  public PriorityThreadFactory(int paramInt)
  {
    this.mThreadPriority = paramInt;
  }
  
  public Thread newThread(final Runnable paramRunnable)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          Process.setThreadPriority(PriorityThreadFactory.this.mThreadPriority);
          paramRunnable.run();
          return;
        }
        catch (Throwable localThrowable)
        {
          for (;;) {}
        }
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/core/PriorityThreadFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */