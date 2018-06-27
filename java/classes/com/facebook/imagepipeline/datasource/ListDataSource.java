package com.facebook.imagepipeline.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.annotation.concurrent.GuardedBy;

public class ListDataSource<T>
  extends AbstractDataSource<List<CloseableReference<T>>>
{
  private final DataSource<CloseableReference<T>>[] mDataSources;
  @GuardedBy("this")
  private int mFinishedDataSources;
  
  protected ListDataSource(DataSource<CloseableReference<T>>[] paramArrayOfDataSource)
  {
    this.mDataSources = paramArrayOfDataSource;
    this.mFinishedDataSources = 0;
  }
  
  public static <T> ListDataSource<T> create(DataSource<CloseableReference<T>>... paramVarArgs)
  {
    int i = 0;
    Preconditions.checkNotNull(paramVarArgs);
    if (paramVarArgs.length > 0) {}
    ListDataSource localListDataSource;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      localListDataSource = new ListDataSource(paramVarArgs);
      int j = paramVarArgs.length;
      while (i < j)
      {
        DataSource<CloseableReference<T>> localDataSource = paramVarArgs[i];
        if (localDataSource != null)
        {
          localListDataSource.getClass();
          localDataSource.subscribe(new InternalDataSubscriber(localListDataSource, null), CallerThreadExecutor.getInstance());
        }
        i += 1;
      }
    }
    return localListDataSource;
  }
  
  /* Error */
  private boolean increaseAndCheckIfLast()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/facebook/imagepipeline/datasource/ListDataSource:mFinishedDataSources	I
    //   6: iconst_1
    //   7: iadd
    //   8: istore_1
    //   9: aload_0
    //   10: iload_1
    //   11: putfield 27	com/facebook/imagepipeline/datasource/ListDataSource:mFinishedDataSources	I
    //   14: aload_0
    //   15: getfield 25	com/facebook/imagepipeline/datasource/ListDataSource:mDataSources	[Lcom/facebook/datasource/DataSource;
    //   18: arraylength
    //   19: istore_2
    //   20: iload_1
    //   21: iload_2
    //   22: if_icmpne +9 -> 31
    //   25: iconst_1
    //   26: istore_3
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_3
    //   30: ireturn
    //   31: iconst_0
    //   32: istore_3
    //   33: goto -6 -> 27
    //   36: astore 4
    //   38: aload_0
    //   39: monitorexit
    //   40: aload 4
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	ListDataSource
    //   8	15	1	i	int
    //   19	4	2	j	int
    //   26	7	3	bool	boolean
    //   36	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	36	finally
  }
  
  private void onDataSourceCancelled()
  {
    setFailure(new CancellationException());
  }
  
  private void onDataSourceFailed(DataSource<CloseableReference<T>> paramDataSource)
  {
    setFailure(paramDataSource.getFailureCause());
  }
  
  private void onDataSourceFinished()
  {
    if (increaseAndCheckIfLast()) {
      setResult(null, true);
    }
  }
  
  private void onDataSourceProgress()
  {
    float f = 0.0F;
    DataSource[] arrayOfDataSource = this.mDataSources;
    int j = arrayOfDataSource.length;
    int i = 0;
    while (i < j)
    {
      f += arrayOfDataSource[i].getProgress();
      i += 1;
    }
    setProgress(f / this.mDataSources.length);
  }
  
  public boolean close()
  {
    int i = 0;
    if (!super.close()) {
      return false;
    }
    DataSource[] arrayOfDataSource = this.mDataSources;
    int j = arrayOfDataSource.length;
    while (i < j)
    {
      arrayOfDataSource[i].close();
      i += 1;
    }
    return true;
  }
  
  /* Error */
  @javax.annotation.Nullable
  public List<CloseableReference<T>> getResult()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 127	com/facebook/imagepipeline/datasource/ListDataSource:hasResult	()Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifne +11 -> 19
    //   11: aconst_null
    //   12: astore 4
    //   14: aload_0
    //   15: monitorexit
    //   16: aload 4
    //   18: areturn
    //   19: new 129	java/util/ArrayList
    //   22: dup
    //   23: aload_0
    //   24: getfield 25	com/facebook/imagepipeline/datasource/ListDataSource:mDataSources	[Lcom/facebook/datasource/DataSource;
    //   27: arraylength
    //   28: invokespecial 132	java/util/ArrayList:<init>	(I)V
    //   31: astore 5
    //   33: aload_0
    //   34: getfield 25	com/facebook/imagepipeline/datasource/ListDataSource:mDataSources	[Lcom/facebook/datasource/DataSource;
    //   37: astore 6
    //   39: aload 6
    //   41: arraylength
    //   42: istore_2
    //   43: iconst_0
    //   44: istore_1
    //   45: aload 5
    //   47: astore 4
    //   49: iload_1
    //   50: iload_2
    //   51: if_icmpge -37 -> 14
    //   54: aload 5
    //   56: aload 6
    //   58: iload_1
    //   59: aaload
    //   60: invokeinterface 134 1 0
    //   65: invokeinterface 140 2 0
    //   70: pop
    //   71: iload_1
    //   72: iconst_1
    //   73: iadd
    //   74: istore_1
    //   75: goto -30 -> 45
    //   78: astore 4
    //   80: aload_0
    //   81: monitorexit
    //   82: aload 4
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	ListDataSource
    //   44	31	1	i	int
    //   42	10	2	j	int
    //   6	2	3	bool	boolean
    //   12	36	4	localObject1	Object
    //   78	5	4	localObject2	Object
    //   31	24	5	localArrayList	java.util.ArrayList
    //   37	20	6	arrayOfDataSource	DataSource[]
    // Exception table:
    //   from	to	target	type
    //   2	7	78	finally
    //   19	43	78	finally
    //   54	71	78	finally
  }
  
  /* Error */
  public boolean hasResult()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 144	com/facebook/imagepipeline/datasource/ListDataSource:isClosed	()Z
    //   6: ifne +25 -> 31
    //   9: aload_0
    //   10: getfield 27	com/facebook/imagepipeline/datasource/ListDataSource:mFinishedDataSources	I
    //   13: istore_1
    //   14: aload_0
    //   15: getfield 25	com/facebook/imagepipeline/datasource/ListDataSource:mDataSources	[Lcom/facebook/datasource/DataSource;
    //   18: arraylength
    //   19: istore_2
    //   20: iload_1
    //   21: iload_2
    //   22: if_icmpne +9 -> 31
    //   25: iconst_1
    //   26: istore_3
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_3
    //   30: ireturn
    //   31: iconst_0
    //   32: istore_3
    //   33: goto -6 -> 27
    //   36: astore 4
    //   38: aload_0
    //   39: monitorexit
    //   40: aload 4
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	ListDataSource
    //   13	10	1	i	int
    //   19	4	2	j	int
    //   26	7	3	bool	boolean
    //   36	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	36	finally
  }
  
  private class InternalDataSubscriber
    implements DataSubscriber<CloseableReference<T>>
  {
    @GuardedBy("InternalDataSubscriber.this")
    boolean mFinished = false;
    
    private InternalDataSubscriber() {}
    
    /* Error */
    private boolean tryFinish()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_1
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_0
      //   5: getfield 26	com/facebook/imagepipeline/datasource/ListDataSource$InternalDataSubscriber:mFinished	Z
      //   8: istore_2
      //   9: iload_2
      //   10: ifeq +9 -> 19
      //   13: iconst_0
      //   14: istore_1
      //   15: aload_0
      //   16: monitorexit
      //   17: iload_1
      //   18: ireturn
      //   19: aload_0
      //   20: iconst_1
      //   21: putfield 26	com/facebook/imagepipeline/datasource/ListDataSource$InternalDataSubscriber:mFinished	Z
      //   24: goto -9 -> 15
      //   27: astore_3
      //   28: aload_0
      //   29: monitorexit
      //   30: aload_3
      //   31: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	32	0	this	InternalDataSubscriber
      //   1	17	1	bool1	boolean
      //   8	2	2	bool2	boolean
      //   27	4	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   4	9	27	finally
      //   19	24	27	finally
    }
    
    public void onCancellation(DataSource<CloseableReference<T>> paramDataSource)
    {
      ListDataSource.this.onDataSourceCancelled();
    }
    
    public void onFailure(DataSource<CloseableReference<T>> paramDataSource)
    {
      ListDataSource.this.onDataSourceFailed(paramDataSource);
    }
    
    public void onNewResult(DataSource<CloseableReference<T>> paramDataSource)
    {
      if ((paramDataSource.isFinished()) && (tryFinish())) {
        ListDataSource.this.onDataSourceFinished();
      }
    }
    
    public void onProgressUpdate(DataSource<CloseableReference<T>> paramDataSource)
    {
      ListDataSource.this.onDataSourceProgress();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/datasource/ListDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */