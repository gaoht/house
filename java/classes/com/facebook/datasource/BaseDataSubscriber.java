package com.facebook.datasource;

public abstract class BaseDataSubscriber<T>
  implements DataSubscriber<T>
{
  public void onCancellation(DataSource<T> paramDataSource) {}
  
  public void onFailure(DataSource<T> paramDataSource)
  {
    try
    {
      onFailureImpl(paramDataSource);
      return;
    }
    finally
    {
      paramDataSource.close();
    }
  }
  
  protected abstract void onFailureImpl(DataSource<T> paramDataSource);
  
  public void onNewResult(DataSource<T> paramDataSource)
  {
    boolean bool = paramDataSource.isFinished();
    try
    {
      onNewResultImpl(paramDataSource);
      return;
    }
    finally
    {
      if (bool) {
        paramDataSource.close();
      }
    }
  }
  
  protected abstract void onNewResultImpl(DataSource<T> paramDataSource);
  
  public void onProgressUpdate(DataSource<T> paramDataSource) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/datasource/BaseDataSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */