package com.freelxl.baselibrary.e;

public abstract interface l
{
  public abstract int getCurrentRetryCount();
  
  public abstract int getCurrentTimeout();
  
  public abstract void retry(Exception paramException)
    throws Exception;
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/e/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */