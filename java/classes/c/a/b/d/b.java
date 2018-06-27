package c.a.b.d;

public class b
  extends Exception
{
  private int a;
  
  public b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public b(int paramInt, String paramString)
  {
    super(paramString);
    this.a = paramInt;
  }
  
  public b(int paramInt, String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.a = paramInt;
  }
  
  public b(int paramInt, Throwable paramThrowable)
  {
    super(paramThrowable);
    this.a = paramInt;
  }
  
  public int getCloseCode()
  {
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/c/a/b/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */