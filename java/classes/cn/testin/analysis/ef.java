package cn.testin.analysis;

public class ef
  extends Exception
{
  private int a;
  
  public ef(int paramInt)
  {
    this.a = paramInt;
  }
  
  public ef(int paramInt, String paramString)
  {
    super(paramString);
    this.a = paramInt;
  }
  
  public ef(int paramInt, Throwable paramThrowable)
  {
    super(paramThrowable);
    this.a = paramInt;
  }
  
  public int a()
  {
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */