package org.json.a;

public class a
  extends Exception
{
  private Throwable a;
  
  public a(String paramString)
  {
    super(paramString);
  }
  
  public a(Throwable paramThrowable)
  {
    super(paramThrowable.getMessage());
    this.a = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/json/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */