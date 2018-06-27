package com.facebook.datasource;

import com.facebook.common.internal.Supplier;

public class DataSources
{
  public static <T> Supplier<DataSource<T>> getFailedDataSourceSupplier(Throwable paramThrowable)
  {
    new Supplier()
    {
      public DataSource<T> get()
      {
        return DataSources.immediateFailedDataSource(this.val$failure);
      }
    };
  }
  
  public static <T> DataSource<T> immediateDataSource(T paramT)
  {
    SimpleDataSource localSimpleDataSource = SimpleDataSource.create();
    localSimpleDataSource.setResult(paramT);
    return localSimpleDataSource;
  }
  
  public static <T> DataSource<T> immediateFailedDataSource(Throwable paramThrowable)
  {
    SimpleDataSource localSimpleDataSource = SimpleDataSource.create();
    localSimpleDataSource.setFailure(paramThrowable);
    return localSimpleDataSource;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/datasource/DataSources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */