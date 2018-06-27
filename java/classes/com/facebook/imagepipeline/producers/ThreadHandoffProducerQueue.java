package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;

public class ThreadHandoffProducerQueue
{
  private final Executor mExecutor;
  private boolean mQueueing = false;
  private final Deque<Runnable> mRunnableList;
  
  public ThreadHandoffProducerQueue(Executor paramExecutor)
  {
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    this.mRunnableList = new ArrayDeque();
  }
  
  private void execInQueue()
  {
    while (!this.mRunnableList.isEmpty()) {
      this.mExecutor.execute((Runnable)this.mRunnableList.pop());
    }
    this.mRunnableList.clear();
  }
  
  /* Error */
  public void addToQueueOrExecute(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/facebook/imagepipeline/producers/ThreadHandoffProducerQueue:mQueueing	Z
    //   6: ifeq +17 -> 23
    //   9: aload_0
    //   10: getfield 33	com/facebook/imagepipeline/producers/ThreadHandoffProducerQueue:mRunnableList	Ljava/util/Deque;
    //   13: aload_1
    //   14: invokeinterface 59 2 0
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 28	com/facebook/imagepipeline/producers/ThreadHandoffProducerQueue:mExecutor	Ljava/util/concurrent/Executor;
    //   27: aload_1
    //   28: invokeinterface 51 2 0
    //   33: goto -13 -> 20
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	ThreadHandoffProducerQueue
    //   0	41	1	paramRunnable	Runnable
    // Exception table:
    //   from	to	target	type
    //   2	20	36	finally
    //   23	33	36	finally
  }
  
  public boolean isQueueing()
  {
    try
    {
      boolean bool = this.mQueueing;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void remove(Runnable paramRunnable)
  {
    try
    {
      this.mRunnableList.remove(paramRunnable);
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  public void startQueueing()
  {
    try
    {
      this.mQueueing = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void stopQueuing()
  {
    try
    {
      this.mQueueing = false;
      execInQueue();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/ThreadHandoffProducerQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */