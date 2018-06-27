package com.hyphenate.exceptions;

import com.hyphenate.chat.adapter.EMAError;

public class HyphenateException
  extends Exception
{
  private static final long serialVersionUID = 1L;
  protected String desc = "";
  protected int errorCode = -1;
  
  public HyphenateException() {}
  
  public HyphenateException(int paramInt, String paramString)
  {
    super(paramString);
    this.errorCode = paramInt;
    this.desc = paramString;
  }
  
  public HyphenateException(EMAError paramEMAError)
  {
    super(paramEMAError.errMsg());
    this.errorCode = paramEMAError.errCode();
    this.desc = paramEMAError.errMsg();
  }
  
  public HyphenateException(String paramString)
  {
    super(paramString);
  }
  
  public HyphenateException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    super.initCause(paramThrowable);
  }
  
  public String getDescription()
  {
    return this.desc;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/exceptions/HyphenateException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */