package com.hyphenate.exceptions;

public class EMServiceNotReadyException
  extends HyphenateException
{
  private static final long serialVersionUID = 1L;
  
  public EMServiceNotReadyException() {}
  
  public EMServiceNotReadyException(int paramInt, String paramString)
  {
    super(paramInt, paramString);
  }
  
  public EMServiceNotReadyException(String paramString)
  {
    super(paramString);
  }
  
  public EMServiceNotReadyException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    super.initCause(paramThrowable);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/exceptions/EMServiceNotReadyException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */