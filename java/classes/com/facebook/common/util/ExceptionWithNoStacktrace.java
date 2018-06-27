package com.facebook.common.util;

public class ExceptionWithNoStacktrace
  extends Exception
{
  public ExceptionWithNoStacktrace(String paramString)
  {
    super(paramString);
  }
  
  public Throwable fillInStackTrace()
  {
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/common/util/ExceptionWithNoStacktrace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */