package com.a.a;

public class c
  extends Exception
{
  private int a;
  
  public c(String paramString, int paramInt)
  {
    super(paramString);
    this.a = paramInt;
  }
  
  public c(String paramString, int paramInt, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.a = paramInt;
  }
  
  public int getErrorCode()
  {
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */