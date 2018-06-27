package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public class JobScheduler
{
  static final String QUEUE_TIME_KEY = "queueTime";
  private final Runnable mDoJobRunnable;
  @VisibleForTesting
  @GuardedBy("this")
  EncodedImage mEncodedImage;
  private final Executor mExecutor;
  @VisibleForTesting
  @GuardedBy("this")
  boolean mIsLast;
  private final JobRunnable mJobRunnable;
  @VisibleForTesting
  @GuardedBy("this")
  long mJobStartTime;
  @VisibleForTesting
  @GuardedBy("this")
  JobState mJobState;
  @VisibleForTesting
  @GuardedBy("this")
  long mJobSubmitTime;
  private final int mMinimumJobIntervalMs;
  private final Runnable mSubmitJobRunnable;
  
  public JobScheduler(Executor paramExecutor, JobRunnable paramJobRunnable, int paramInt)
  {
    this.mExecutor = paramExecutor;
    this.mJobRunnable = paramJobRunnable;
    this.mMinimumJobIntervalMs = paramInt;
    this.mDoJobRunnable = new Runnable()
    {
      public void run()
      {
        JobScheduler.this.doJob();
      }
    };
    this.mSubmitJobRunnable = new Runnable()
    {
      public void run()
      {
        JobScheduler.this.submitJob();
      }
    };
    this.mEncodedImage = null;
    this.mIsLast = false;
    this.mJobState = JobState.IDLE;
    this.mJobSubmitTime = 0L;
    this.mJobStartTime = 0L;
  }
  
  /* Error */
  private void doJob()
  {
    // Byte code:
    //   0: invokestatic 92	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore_1
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 66	com/facebook/imagepipeline/producers/JobScheduler:mEncodedImage	Lcom/facebook/imagepipeline/image/EncodedImage;
    //   10: astore 4
    //   12: aload_0
    //   13: getfield 68	com/facebook/imagepipeline/producers/JobScheduler:mIsLast	Z
    //   16: istore_3
    //   17: aload_0
    //   18: aconst_null
    //   19: putfield 66	com/facebook/imagepipeline/producers/JobScheduler:mEncodedImage	Lcom/facebook/imagepipeline/image/EncodedImage;
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 68	com/facebook/imagepipeline/producers/JobScheduler:mIsLast	Z
    //   27: aload_0
    //   28: getstatic 95	com/facebook/imagepipeline/producers/JobScheduler$JobState:RUNNING	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   31: putfield 73	com/facebook/imagepipeline/producers/JobScheduler:mJobState	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   34: aload_0
    //   35: lload_1
    //   36: putfield 77	com/facebook/imagepipeline/producers/JobScheduler:mJobStartTime	J
    //   39: aload_0
    //   40: monitorexit
    //   41: aload 4
    //   43: iload_3
    //   44: invokestatic 99	com/facebook/imagepipeline/producers/JobScheduler:shouldProcess	(Lcom/facebook/imagepipeline/image/EncodedImage;Z)Z
    //   47: ifeq +15 -> 62
    //   50: aload_0
    //   51: getfield 54	com/facebook/imagepipeline/producers/JobScheduler:mJobRunnable	Lcom/facebook/imagepipeline/producers/JobScheduler$JobRunnable;
    //   54: aload 4
    //   56: iload_3
    //   57: invokeinterface 103 3 0
    //   62: aload 4
    //   64: invokestatic 109	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   67: aload_0
    //   68: invokespecial 112	com/facebook/imagepipeline/producers/JobScheduler:onJobFinished	()V
    //   71: return
    //   72: astore 4
    //   74: aload_0
    //   75: monitorexit
    //   76: aload 4
    //   78: athrow
    //   79: astore 5
    //   81: aload 4
    //   83: invokestatic 109	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   86: aload_0
    //   87: invokespecial 112	com/facebook/imagepipeline/producers/JobScheduler:onJobFinished	()V
    //   90: aload 5
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	JobScheduler
    //   3	33	1	l	long
    //   16	41	3	bool	boolean
    //   10	53	4	localEncodedImage1	EncodedImage
    //   72	10	4	localEncodedImage2	EncodedImage
    //   79	12	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	41	72	finally
    //   74	76	72	finally
    //   41	62	79	finally
  }
  
  private void enqueueJob(long paramLong)
  {
    if (paramLong > 0L)
    {
      JobStartExecutorSupplier.get().schedule(this.mSubmitJobRunnable, paramLong, TimeUnit.MILLISECONDS);
      return;
    }
    this.mSubmitJobRunnable.run();
  }
  
  /* Error */
  private void onJobFinished()
  {
    // Byte code:
    //   0: invokestatic 92	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 4
    //   5: lconst_0
    //   6: lstore_2
    //   7: iconst_0
    //   8: istore_1
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 73	com/facebook/imagepipeline/producers/JobScheduler:mJobState	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   15: getstatic 137	com/facebook/imagepipeline/producers/JobScheduler$JobState:RUNNING_AND_PENDING	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   18: if_acmpne +49 -> 67
    //   21: aload_0
    //   22: getfield 77	com/facebook/imagepipeline/producers/JobScheduler:mJobStartTime	J
    //   25: aload_0
    //   26: getfield 56	com/facebook/imagepipeline/producers/JobScheduler:mMinimumJobIntervalMs	I
    //   29: i2l
    //   30: ladd
    //   31: lload 4
    //   33: invokestatic 143	java/lang/Math:max	(JJ)J
    //   36: lstore_2
    //   37: iconst_1
    //   38: istore_1
    //   39: aload_0
    //   40: lload 4
    //   42: putfield 75	com/facebook/imagepipeline/producers/JobScheduler:mJobSubmitTime	J
    //   45: aload_0
    //   46: getstatic 146	com/facebook/imagepipeline/producers/JobScheduler$JobState:QUEUED	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   49: putfield 73	com/facebook/imagepipeline/producers/JobScheduler:mJobState	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   52: aload_0
    //   53: monitorexit
    //   54: iload_1
    //   55: ifeq +11 -> 66
    //   58: aload_0
    //   59: lload_2
    //   60: lload 4
    //   62: lsub
    //   63: invokespecial 148	com/facebook/imagepipeline/producers/JobScheduler:enqueueJob	(J)V
    //   66: return
    //   67: aload_0
    //   68: getstatic 71	com/facebook/imagepipeline/producers/JobScheduler$JobState:IDLE	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   71: putfield 73	com/facebook/imagepipeline/producers/JobScheduler:mJobState	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   74: goto -22 -> 52
    //   77: astore 6
    //   79: aload_0
    //   80: monitorexit
    //   81: aload 6
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	JobScheduler
    //   8	47	1	i	int
    //   6	54	2	l1	long
    //   3	58	4	l2	long
    //   77	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	37	77	finally
    //   39	52	77	finally
    //   52	54	77	finally
    //   67	74	77	finally
    //   79	81	77	finally
  }
  
  private static boolean shouldProcess(EncodedImage paramEncodedImage, boolean paramBoolean)
  {
    return (paramBoolean) || (EncodedImage.isValid(paramEncodedImage));
  }
  
  private void submitJob()
  {
    this.mExecutor.execute(this.mDoJobRunnable);
  }
  
  public void clearJob()
  {
    try
    {
      EncodedImage localEncodedImage = this.mEncodedImage;
      this.mEncodedImage = null;
      this.mIsLast = false;
      EncodedImage.closeSafely(localEncodedImage);
      return;
    }
    finally {}
  }
  
  public long getQueuedTime()
  {
    try
    {
      long l1 = this.mJobStartTime;
      long l2 = this.mJobSubmitTime;
      return l1 - l2;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean scheduleJob()
  {
    int j = 0;
    long l3 = SystemClock.uptimeMillis();
    long l2 = 0L;
    for (;;)
    {
      try
      {
        if (!shouldProcess(this.mEncodedImage, this.mIsLast)) {
          return false;
        }
        i = j;
        l1 = l2;
        switch (this.mJobState)
        {
        case ???: 
          if (i != 0) {
            enqueueJob(l1 - l3);
          }
          return true;
        }
      }
      finally {}
      long l1 = Math.max(this.mJobStartTime + this.mMinimumJobIntervalMs, l3);
      this.mJobSubmitTime = l3;
      this.mJobState = JobState.QUEUED;
      int i = 1;
      continue;
      this.mJobState = JobState.RUNNING_AND_PENDING;
      i = j;
      l1 = l2;
      continue;
      i = j;
      l1 = l2;
    }
  }
  
  public boolean updateJob(EncodedImage paramEncodedImage, boolean paramBoolean)
  {
    if (!shouldProcess(paramEncodedImage, paramBoolean)) {
      return false;
    }
    try
    {
      EncodedImage localEncodedImage = this.mEncodedImage;
      this.mEncodedImage = EncodedImage.cloneOrNull(paramEncodedImage);
      this.mIsLast = paramBoolean;
      EncodedImage.closeSafely(localEncodedImage);
      return true;
    }
    finally {}
  }
  
  public static abstract interface JobRunnable
  {
    public abstract void run(EncodedImage paramEncodedImage, boolean paramBoolean);
  }
  
  @VisibleForTesting
  static class JobStartExecutorSupplier
  {
    private static ScheduledExecutorService sJobStarterExecutor;
    
    static ScheduledExecutorService get()
    {
      if (sJobStarterExecutor == null) {
        sJobStarterExecutor = Executors.newSingleThreadScheduledExecutor();
      }
      return sJobStarterExecutor;
    }
  }
  
  @VisibleForTesting
  static enum JobState
  {
    IDLE,  QUEUED,  RUNNING,  RUNNING_AND_PENDING;
    
    private JobState() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/JobScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */