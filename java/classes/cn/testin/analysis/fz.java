package cn.testin.analysis;

public abstract class fz
  extends Exception
{
  protected static final boolean a;
  protected static final StackTraceElement[] b;
  
  static
  {
    if (System.getProperty("surefire.test.class.path") != null) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      b = new StackTraceElement[0];
      return;
    }
  }
  
  public final Throwable fillInStackTrace()
  {
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/fz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */