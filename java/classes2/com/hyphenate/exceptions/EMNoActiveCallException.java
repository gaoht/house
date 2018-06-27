package com.hyphenate.exceptions;

public class EMNoActiveCallException
  extends HyphenateException
{
  private static final long serialVersionUID = 1L;
  
  public EMNoActiveCallException() {}
  
  public EMNoActiveCallException(String paramString)
  {
    super(paramString);
  }
  
  public EMNoActiveCallException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    super.initCause(paramThrowable);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/exceptions/EMNoActiveCallException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */